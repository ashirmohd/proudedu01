package Admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.baseClass;
import com.crm.GenericUtilities.fileUtility;
import com.proudEdu.ObjectRepositories.Homepage;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.classroompage;
//@Listeners(com.crm.GenericUtilities.Takescreenshotwhenitsfailed.class)
public class create_classroomPOMTest_1 extends baseClass {
	

	@Test(retryAnalyzer = com.crm.GenericUtilities.RetryAnalyserImpClass.class)
	    public void excuteConfig() throws Throwable {

	Homepage hp=new Homepage(driver);
    
    hp.classroom();
    Assert.fail();
    
    classroompage clp=new classroompage(driver);
    clp.classroomdata(elib, jlib);
	 Thread.sleep(5000);
	 clp.enterSeachAndCompare(driver, elib);
	 String finaldata=elib.readExceldata("classroom", 2, 1);
	 System.out.println(finaldata);
	}
	 @Test
	 public void sample1() {
		 System.out.println("---sample1---");
	 }

	
}