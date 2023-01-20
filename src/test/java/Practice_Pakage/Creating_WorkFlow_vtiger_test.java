package Practice_Pakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.fileUtility;

public class Creating_WorkFlow_vtiger_test {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wblib=new WebdriverUtility();
		
		int n = jlib.javautil(200);
		WebDriver driver=null;
		String browser=flib.getDataFromProperties("Browser");
		String url=flib.getDataFromProperties("URL2");
		String usn=flib.getDataFromProperties("USERNAME2");
		String pwd=flib.getDataFromProperties("PASSWORD2");
		 if(browser.equals("chrome")) {
			 driver=new ChromeDriver();
		 }else {
			 driver=new FirefoxDriver();
		 }
		 wblib.maximizeWindow(driver);
		 wblib.waitForLoadingPage(driver);
		 driver.get(url);
		 driver.findElement(By.name("user_name")).sendKeys(usn);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		
	}

}
