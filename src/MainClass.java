import java.util.*;
public class MainClass {

	public static Contact getContactDetails(Contact contact)
	{
		return contact;
		
	}
	
	public static void showContactDetails(Contact c)
	{
		System.out.println(c.getContactID());
		System.out.println(c.getContactName());
		System.out.println(c.getEmailAddress());
		System.out.println(c.getContactNumber());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContactService cs=new ContactService();
		List<Contact> contactList=new ArrayList<Contact>();
		int val;
		String ans="";
		boolean value=true;
		while(value==true)
		{
			System.out.println("1. Add contacts in the list");
			System.out.println("2. Remove contact from the list");
			System.out.println("3. Search the name in Contact List");
			System.out.println("4. Search phone numbers");
			System.out.println("5. Update contact numbers in contact ID");
			System.out.println("6. Sort by contact names");
			System.out.println("7. Read contacts from file");
			System.out.println("8. Serialize");
			System.out.println("9. Deserialize");
			System.out.println("10. Populate From DB");
			System.out.println("11. Add new contacts to existing contacts(In a Set)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your option");
			Set<Contact> contactSet=new HashSet<Contact>();
			int opt=sc.nextInt();
			sc.nextLine();
			switch(opt)
			{
				case 1:
				{
					Contact c=new Contact();
					contactList=((ContactService) cs).addContact(c, contactList);
					for(Contact c1: contactList)
					{
						System.out.println(c1);
					}
					break;
				}
				
				case 2:
				{
					Contact c=new Contact();
					RemoveContactByID rc=new RemoveContactByID();
					try {
						rc.processContactRemoval(contactList);
					} catch (ContactNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 3:
				{
					Scanner sc1=new Scanner(System.in);
					System.out.println("Enter the name to be searched");
					String name1=sc1.nextLine();
					SearchByName sm=new SearchByName();
					sm.process(name1, contactList);
					try {
						sm.searchContactByName(name1, contactList);
					} catch (ContactNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 4:
				{
					System.out.println("Enter the phone number you want to search");
					String n=sc.nextLine();
					SearchPhoneNumbers snum=new SearchPhoneNumbers();
					List<Contact> searched=new ArrayList<Contact>();
					snum.process(n, contactList);
					break;
					
				}
				case 5:
				{
					System.out.println("You have opted for updation of contact number for a specific contact ID");
					System.out.println("Enter the contact ID for which you want to update the phone numbers");
					
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new phone number");
					String newNum=sc.nextLine();
					UpdateContact uc=new UpdateContact();
					uc.addContactNumber(id, newNum, contactList);
					break;
				}
				
				case 6:
				{
					SortsContactByName sort=new SortsContactByName();
					sort.sortContactsByName(contactList);
					break;
				}
				case 7:
				{
					System.out.println("You have chosen read contacts from a file");
					ReadFromFile rf=new ReadFromFile();
					rf.readContactsFromFile(contactList, "File1.txt");
					break;
				}
				case 8:
				{
					ReadSerialize rd=new ReadSerialize();
					List<Contact> list=new ArrayList<Contact>();
					List<Contact> lt=rd.readContactsFromFile(list, "Cnts1.txt");
					SerializeDeserialize s=new SerializeDeserialize();
					s.serializeContacts(lt, "Serialized1.txt");
				break;
				}
				case 9:
				{
					SerializeDeserialize s=new SerializeDeserialize();
					ArrayList<Contact> conts=s.deserializeContact("Serialized1.txt");
				for(Contact c: conts)
				{
					System.out.println(c);
				}
				break;
				}
				
				case 10:
				{
					System.out.println("Populate from DB");
					PopulateFromDB pdb=new PopulateFromDB();
					contactSet=pdb.populateContactFromDb();
					System.out.println(contactSet);
					break;
					
				}
				case 11:
				{
					System.out.println("Add new contacts to existing contacts(In a Set)");
					AddNewToExisting addToExisting=new AddNewToExisting();
					Set<Contact> conset=new HashSet<Contact>();
					addToExisting.addContacts(contactList, contactSet);
				}
			}
			
			System.out.println("Do you want to continue?(Y/N)");
			String c=sc.next();
			if(c=="Y")
			{
				value=false;
			}
		
		}
		
	}}

