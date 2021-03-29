import java.io.Serializable;
import java.util.Comparator;
import java.util.List;


public class Contact  implements Serializable{
	private int contactID;
	private String contactName;
	private String emailAddress;
	private List<String> contactNumber;
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public List<String> getContactNumber() {
		return contactNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", contactName=" + contactName + ", emailAddress=" + emailAddress
				+ ", contactNumber=" + contactNumber + "]";
	}
	public void setContactNumber(List<String> contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	public static Comparator<Contact> comparator1 = new Comparator<Contact>() {

		public int compare(Contact s1, Contact s2) {
			   String ContactName1 = s1.getContactName().toUpperCase();
			   String ContactName2 = s2.getContactName().toUpperCase();

			 
			   return ContactName1.compareTo(ContactName2);
		}
	};
}