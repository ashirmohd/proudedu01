package Admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.proudEdu.ObjectRepositories.gradepage;
import com.proudEdu.ObjectRepositories.subjectpage;
import com.proudEdu.ObjectRepositories.subjectroutingpage;
//@Listeners(com.crm.GenericUtilities.Takescreenshotwhenitsfailed.class)
public class CreateSubjectRoutingPOMTest_3 extends baseClass{

	@Test(retryAnalyzer = com.crm.GenericUtilities.RetryAnalyserImpClass.class)
	public void ExcuteConfig() throws Throwable {

		Homepage hp=new Homepage(driver);
		hp.classroom();
		classroompage clp=new classroompage(driver);
		clp.classroomdata(elib, jlib);
		Thread.sleep(5000);
    	clp.enterSeachAndCompare(driver, elib);
    	hp.grade();
    	gradepage gp=new gradepage(driver);
    	gp.gradedata(elib, jlib);
    	 Thread.sleep(5000);
    	 gp.searchgrade(driver, elib);
         String gradefinaldata= elib.readExceldata("Grade", 3, 1);
         hp.subject();
         subjectpage sp=new subjectpage(driver);
         sp.subjectdata(elib, jlib);
         
        
        Thread.sleep(5000);
        
        sp.searchdata(elib, driver);
        
        String subjectfinalvalue=elib.readExceldata("Subject", 1, 1);
        hp.subjectrouting();
        subjectroutingpage srp=new subjectroutingpage(driver);
        srp.addsubjectbtn();
        srp.fillalldetailsinsubjectrouting(wblib, gradefinaldata, subjectfinalvalue, "nawaz1", "1000");
        Thread.sleep(5000);
        srp.searchtextsubject(subjectfinalvalue, driver);


	}

}
