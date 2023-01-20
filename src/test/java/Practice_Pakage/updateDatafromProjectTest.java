package Practice_Pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class updateDatafromProjectTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		try {
		//step 1)register to database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//step 2)get connection from database
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		//step 3)update the issue statement
		Statement stat = con.createStatement();
		String data = "insert into project values('TY_Project_011','Ashir','21/12/2022','sdet45','created',4);";
		//step 4)excute the statement
	     result = stat.executeUpdate(data);
		//step 5)close the datanbase
		}
		catch(Exception e) {
			
		}
		finally {
			if(result==1) {
				System.out.println("it is successfully updated");
			}
			else {
				System.out.println("it is not updated");
			}
			con.close();
		}
	}

}
