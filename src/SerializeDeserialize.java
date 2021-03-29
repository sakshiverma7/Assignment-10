import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class SerializeDeserialize {
	
	public void serializeContacts(List<Contact> contact, String fileName)
	{
		try {
			FileOutputStream Out = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(Out);
			out.writeObject(contact);
			out.close();
			Out.close();
			System.out.println("Done");
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	public ArrayList<Contact> deserializeContact(String fileName)
	{
		ArrayList<Contact> contacts=new ArrayList<Contact>();
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				contacts=(ArrayList<Contact>)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contacts;
	}
}