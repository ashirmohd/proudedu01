package Practice_Pakage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DiffAnnotation {
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("database is connected");
	}
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("open the browser");
	}
	@BeforeMethod
	public void login() {
		System.out.println("login to the application");
	}
	@Test(priority = -1)
	public void excutedata() {
		System.out.println("data is excuted");
	}
	@Test(invocationCount = 2)
	public void createTeacher() {
		System.out.println("teacher is created");
	}
	@Test(dependsOnMethods = "createTeacher" )
	public void createStudent() {
		System.out.println("student is created");
	}
	@Test
	public void createTimetable() {
		System.out.println("timetable is created");
	}
	@AfterMethod
	public void logout() {
		System.out.println("logout from application");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("close the browser");
	}
	@AfterSuite
	public void disconnectDB() {
		System.out.println("disconnect the database");
	}

}
