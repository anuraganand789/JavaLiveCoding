import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Date;

public class SerialTest{
    public static void main(String... args) throws IOException, ClassNotFoundException{
        FileOutputStream fileOutStream = new FileOutputStream("tmp.ser");
	ObjectOutput     objectOutput  = new ObjectOutputStream(fileOutStream);
	objectOutput.writeObject("Today's date");
	objectOutput.writeObject(new Date());
	objectOutput.flush();
	objectOutput.close();

	FileInputStream fileInStream = new FileInputStream("tmp.ser");
	ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);

	//reading string object here
	System.out.print(objectInStream.readObject());
	//reading date object here 
	System.out.println(objectInStream.readObject());

	fileInStream.close();
	objectInStream.close();
    }
}
