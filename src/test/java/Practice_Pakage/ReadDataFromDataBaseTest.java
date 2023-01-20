package Practice_Pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBaseTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Driver driver=new Driver();
		try {
			//register the database
			DriverManager.registerDriver(driver);
			//get connection from the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root", "root");
			//issue create statement
			Statement stat = con.createStatement();
			String data = "select * from studentInfo;";
			//excute statement
			ResultSet result = stat.executeQuery(data);

			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		}
		catch(Exception e) {

		}
		finally {
			//close the database
			con.close();
		}


	}
}
