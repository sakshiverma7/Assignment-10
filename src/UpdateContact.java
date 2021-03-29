import java.util.List;



public class UpdateContact {
	public void addContactNumber(int contactId, String contactNo, List<Contact> contacts)
	{
		for(Contact c: contacts)
		{
			int i=c.getContactID();
			if(i==contactId)
			{
				List<String> cn=c.getContactNumber();
				cn.add(contactNo);
				c.setContactNumber(cn);
			}
		}
		for(Contact c: contacts)
		{
			System.out.println(c);
		}
		System.out.println();
	}
	
}