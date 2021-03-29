import java.util.Collections;
import java.util.List;



public class SortsContactByName {
	

	public void sortContactsByName(List<Contact> contactList) {
		Collections.sort(contactList, Contact.comparator1);
		for(Contact c: contactList)
		{
			System.out.println(c);
		}
		
	}
}