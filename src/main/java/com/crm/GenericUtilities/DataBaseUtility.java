


package com.crm.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	/**
	 * @author ashir
	 * generic class for getting connection to  database
	 */
     Connection con=null;
	//register the database and get connection
	public void connecttodb() throws Throwable {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUSERNAME, IPathConstant.DBPASSWORD);
	}
	/**
	 * @author ashir
	 * generic class for excuting data and closing the data in database
	 * @param queary
	 * @param columnIndex
	 * @param expdata
	 * @return
	 * @throws Throwable
	 */
	public String excutequearyandclosedb(String queary,String columnIndex,String expdata) throws Throwable {
         
		ResultSet result = con.createStatement().executeQuery(queary);
		boolean flag=false;
		while(result.next()) {
			
			String data = result.getString(columnIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expdata)) {
				flag=true;
				break;
			}
			
		}
		if(flag) {
			System.out.println(expdata+"project is created");
			return expdata;
		}
		else
		{
			System.out.println("project is not created");
			return "";
		}
	}
	public void closeDB() throws Throwable {
		con.close();
	}
}
