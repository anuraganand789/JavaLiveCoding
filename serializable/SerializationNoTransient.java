import java.io.Serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

public class SerializationNoTransient {

    public static void main(final String[] args) throws IOException{
        
        class Event implements Serializable{
	    long serializationId = 1L;

            String name;
            String trrigeredBy;
            long   timeToResolve;

            Event(final String name, final String trrigeredBy, final long timeToResolve) {
                this.name = name;
                this.trrigeredBy = trrigeredBy;
                this.timeToResolve = timeToResolve;
            }

        }

	File file = new File("event.ser");
	if(!file.exists()) file.createNewFile();

	//Write The Object
	try(ObjectOutputStream objWriteStream = new ObjectOutputStream(new FileOutputStream(file))){
	    final Event eventOne = new Event("Blackout", "DB Overload", 10L);
	    final Event eventTwo = new Event("App Server Crash", "OutOf Memory", 15L);

	    objWriteStream.writeObject(eventOne);
	    objWriteStream.writeObject(eventTwo);
	    objWriteStream.flush();
	}catch(FileNotFoundException ex){
	   ex.printStackTrace(); 
	}

       //Read The Object
       try(ObjectInputStream objReadStream = new ObjectInputStream(new FileInputStream(file))){
           final Event eventOne = (Event) objReadStream.readObject();
           final Event eventTwo = (Event) objReadStream.readObject();

	   System.out.printf("Name :- %s, Triggered By:- %s, Handled Int :- %d %n", eventOne.name, eventOne.trrigeredBy, eventOne.timeToResolve);
	   System.out.printf("Name :- %s, Triggered By:- %s, Handled Int :- %d %n", eventTwo.name, eventTwo.trrigeredBy, eventTwo.timeToResolve);
       }catch(FileNotFoundException | ClassNotFoundException ex){
           ex.printStackTrace();
       }
       
       System.out.println("Serialization And Desrialization Done");

    }
}
