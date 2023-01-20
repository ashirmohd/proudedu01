package Teacher_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.baseClass;
import com.crm.GenericUtilities.fileUtility;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.searchStudentPage;
import com.proudEdu.ObjectRepositories.teacherhomepage;

public class SearchStudentPom extends baseClass{
	
	@Test
	public void searchstudentconf() throws Throwable {

//	public static void main(String[] args) throws Throwable {
//		WebDriver driver=null;
//		ExcelUtility elib=new ExcelUtility();
//		fileUtility flib=new fileUtility();
//		JavaUtility jlib=new JavaUtility();
//		WebdriverUtility wblib=new WebdriverUtility();
		
//		int n = jlib.javautil(200);
//		String browser=flib.getDataFromProperties("Browser");
//		String url = flib.getDataFromProperties("URL");
		String usn1 = flib.getDataFromProperties("USERNAME1");
		String pwd = flib.getDataFromProperties("PASSWORD");
//		
//		String name="chrome";
//		if(browser.equals(name)) {
//			 driver=new ChromeDriver();
//		}else {
//			driver=new FirefoxDriver();
//		}
//		driver.get(url);
//		wblib.maximizeWindow(driver);
//		wblib.waitForLoadingPage(driver);
		LoginPage lp=new LoginPage(driver);
		lp.Login(usn1, pwd);
		teacherhomepage thp=new teacherhomepage(driver);
		thp.mystudebtn();
		searchStudentPage srp=new searchStudentPage(driver);
		srp.selgradevalue(wblib, elib);
		srp.seachandCompare("54nawaz khan", driver);
		 
		 thp.clickonadminbtn();
			thp.signoutbtn();
	}

}
