import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSerialize {
	
	public static List<Contact> readContactsFromFile(List<Contact> populateC, String fileName)//List<Contact> contacts, String fileNAme
	{
	File file=new File("S:\\Sakshi\\"+fileName);
	
    String line;
    BufferedReader reader = null;
  
	try {
		if(file.isFile())
		{
			FileReader fr=new FileReader(file);
			reader = new BufferedReader(fr);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
    	
		while ((line = reader.readLine()) != null)
		{
			Contact m=new Contact();
		    String[] parts = line.split(",");
		
		   int val=Integer.parseInt(parts[0]);
		   String name=parts[1];
	
		
		   String email=parts[2];
		   List<String> list=new ArrayList<String>();
		   for(int i=3;i<parts.length;i++)
		   {
			   list.add(parts[i]);
		   }
		   m.setContactID(val);
		   m.setContactName(name);
		   m.setEmailAddress(email);
		   m.setContactNumber(list);
		   populateC.add(m);
		}
		
		
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try
    {
    	reader.close();
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    
 
    return populateC;
}
	
}