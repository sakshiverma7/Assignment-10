import java.util.List;
import java.util.Set;

public class AddNewToExisting {
	public boolean addContacts(List<Contact> existingContact, Set<Contact> newContacts)
	{
		for(Contact c: newContacts)
		{
			existingContact.add(c);
		}
		for(Contact c: existingContact)
		{
			System.out.println(c);
		}
		return true;
	}

}