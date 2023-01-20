
 package Practice_Pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class updateDataFromDataBaseTest {

	public static void main(String[] args) throws SQLException {

		Connection con=null;
		int result=0;
		try {
			Driver driver=new Driver();
			//step 1)register the datatbase
			DriverManager.registerDriver(driver);

			//step 2)get connection to the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root", "root");
			//step 3)issue statement
			Statement stat = con.createStatement();
			String queary = "insert into studentInfo values('Nawaz','OAT','API',2);";
			//step 4)excute the statement
			result = stat.executeUpdate(queary);
			//step 5)close the database
		}
		catch(Exception n) {

		}
		finally {
			if(result==1) {
				System.out.println("successfully updated");
			}
			else
			{
				System.out.println("not updated");
			}
			con.close();
		}


	}

}
