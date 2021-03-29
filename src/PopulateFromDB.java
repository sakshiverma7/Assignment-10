import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class PopulateFromDB {
	Connection cn=ConnectionUtil.getConnection();
	
		
		public Set<Contact> populateContactFromDb()
		{
			Connection cn=ConnectionUtil.getConnection();
			
			Set<Contact> m=new HashSet<Contact>();
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
}