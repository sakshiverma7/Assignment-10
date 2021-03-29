import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	static Connection cn=null;

	
	public static Connection getConnection() {
		if(cn==null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					cn=DriverManager.getConnection("jdbc:mysql://localhost/mydata?user=root&password=root");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cn;
	}

	public void closeConnection()
	{
		try {
			
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}