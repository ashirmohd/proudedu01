
package com.crm.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.proudEdu.ObjectRepositories.Homepage;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.teacherhomepage;

public class baseClass {
    
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public WebdriverUtility wblib=new WebdriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public DataBaseUtility dblib=new DataBaseUtility();
	public fileUtility flib=new fileUtility();
	
	
	@BeforeSuite
	public void connectDB() throws Throwable {
//		dblib.connecttodb();
		System.out.println("----connect to database--");
	}
	
	
      @Parameters("BROWSER")
	@BeforeClass
	public void configBC(String Browser) throws Throwable {
//		public void configBC() throws Throwable {
//      String Browser=flib.getDataFromProperties("Browser");
		String url=flib.getDataFromProperties("URL");
		
		if(Browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else {
			System.out.println("invalid browser");
		}
		sdriver=driver;
		driver.get(url);
		wblib.maximizeWindow(driver);
		wblib.waitForLoadingPage(driver);
		System.out.println("browser is launched");
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		String usn=flib.getDataFromProperties("USERNAME");
		String pwd=flib.getDataFromProperties("PASSWORD");
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(usn, pwd);
	
		System.out.println("appication is logged in");
	}
	@AfterMethod
	public void configAM() {
		Homepage hp=new Homepage(driver);
		hp.adminbtn();
		 hp.signout();
		
		 System.out.println("Application is logged out");
	}
	@AfterClass
	public void configAC() {
		driver.quit();
		System.out.println("close the browser");
	}
	@AfterSuite
	public void configAS() throws Throwable {
		System.out.println("---disconnect database---");
//		dblib.closeDB();
	}
}
