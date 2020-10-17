import java.io.File;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class SerializationWithTransientVariable{
    public static void main(final String[] args) throws IOException{

        class Event implements Serializable{ 
	    String name, triggeredBy; 
	    long resolvedInMinutes; 
	    long serializedAt;
	    transient long objectCreationTime; 
	    Event(final String name, final String triggeredBy, final long resolvedInMinutes){
	        this.name = name;
	        this.triggeredBy = triggeredBy;
	        this.resolvedInMinutes = resolvedInMinutes;
		this.objectCreationTime = System.currentTimeMillis();
	    }

            private void writeObject(final ObjectOutputStream objWriter) throws IOException{
	        objWriter.defaultWriteObject();
	        //Time at which it was serialized => serializedAt
	        objWriter.writeLong(System.currentTimeMillis());
	    }

	    private void readObject(final ObjectInputStream objReader) throws ClassNotFoundException, IOException{
	        objReader.defaultReadObject();
	        serializedAt = objReader.readLong();
	        objectCreationTime = System.currentTimeMillis();
	    }
        }

       final File file = new File(String.format("event.%d.ser", System.currentTimeMillis()));

       if(!file.exists()) file.createNewFile();

       //Event(final String name, final String triggeredBy, final long resolvedInMinutes){
       try(ObjectOutputStream objWriter = new ObjectOutputStream(new FileOutputStream(file))){
           final Event eventOne = new Event("BlackOut", "Power Cut", 15L);
           final Event eventTwo = new Event("App server Down", "OutOfMemory Error", 10L);
           
	   objWriter.writeObject(eventOne);
	   Thread.currentThread().sleep(1000);
	   objWriter.writeObject(eventTwo);

	   objWriter.flush();
       }catch(InterruptedException | FileNotFoundException ex) { ex.printStackTrace(); }

       try(ObjectInputStream objReader = new ObjectInputStream(new FileInputStream(file))){
          final Event eventOne = (Event) objReader.readObject();
          final Event eventTwo = (Event) objReader.readObject();
          
	  System.out.printf("Name :- %s, Triggered By :- %s, Resolve In :- %d, De-Serialized At : %d %n", 
	                     eventOne.name, eventOne.triggeredBy, eventOne.resolvedInMinutes,
			     eventOne.serializedAt);
	  System.out.printf("Name :- %s, Triggered By :- %s, Resolve In :- %d, De-Serialized At : %d %n", 
	                     eventTwo.name, eventTwo.triggeredBy, eventTwo.resolvedInMinutes,
			     eventTwo.serializedAt);

       }catch(FileNotFoundException | ClassNotFoundException ex) { ex.printStackTrace(); }
    }
}
