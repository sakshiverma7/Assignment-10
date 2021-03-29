import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class ReadContactFromDB{

	public static List<Contact> getContactInfor()
	{
	
	Connection cn=ConnectionUtil.getConnection();
	
		List<Contact> m=new ArrayList<Contact>();
		try {
			
			Statement st=cn.createStatement();
			
			String qry="select * from contact;";
			ResultSet rs=st.executeQuery(qry);
			
			while(rs.next())
			{
				Contact cont=new Contact();
				int contactId=rs.getInt(1);
				cont.setContactID(contactId);
				String name=rs.getString(2);
				cont.setContactName(name);
				String email=rs.getString(3);
				cont.setEmailAddress(email);
				String contactNums=rs.getString("contactList");
				List<String> conts=new ArrayList<String>();
				String n="";
				if(contactNums!=null)
				{
					String[] li=contactNums.split(",");
					for(String s: li)
					{
						conts.add(s);
						
						
					}
					cont.setContactNumber(conts);
				}
				else
				{
					n=null;
					conts.add(n);
					cont.setContactNumber(conts);
				}
				m.add(cont); 
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
}
	
	
	public static void updateDB(int id)
	{
		Connection cn=ConnectionUtil.getConnection();
		
		try
		{
			Statement st=cn.createStatement();
			String qry="delete from contact where contactId="+id+";";
			st.executeUpdate(qry);
			
		}catch(Exception e)
		{
			
		}
		
		
	}
	
	
	public static void removeContact(Contact contact, List<Contact> contacts) throws ContactNotFoundException
	{
		int cid=contact.getContactID();
	}
	
		public static void main(String[] args) throws ContactNotFoundException
		{
			
			List<Contact> list=new ArrayList<Contact>();
			list=getContactInfor();
			System.out.println("Enter the contact Id you want to remove");
			
			Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
			
			Iterator<Contact> itr=list.iterator();
			int flag=0;
			while(itr.hasNext())
			{
				flag=0;
				Contact c=itr.next();
			
				
				int cid=c.getContactID();
				if(cid==id)
				{
					updateDB(id);
					itr.remove();
					flag=0;
					break;
				}
				else
				{
					flag=1;
					
				}
			}
			if(flag==1)
			{
				throw new ContactNotFoundException("Contact Not Found!!");
			}
			else
			{
				System.out.println("Contact deleted");
				System.out.println("contacts :");
				for(Contact c: list)
				{
					System.out.println(c.getContactID()+","+c.getContactName()+","+c.getEmailAddress()+","+c.getContactNumber());
				}
			}
			
			
			
		}
		
}