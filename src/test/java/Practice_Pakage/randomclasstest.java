package Practice_Pakage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class randomclasstest {

	public static
	void main(String[] args) throws Throwable {
    Random ran=new Random();
    int random = ran.nextInt(200);
    
    FileInputStream fis=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\Commondata.properties");
	Properties p=new Properties();
	p.load(fis);
	String url = p.getProperty("URL2");
	String usn = p.getProperty("USERNAME2");
	String pwd = p.getProperty("PASSWORD2");
	
	FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testdata45.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	String sh=wb.getSheet("organization").getRow(0).getCell(1).getStringCellValue()+random;
	 
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.findElement(By.name("user_name")).sendKeys(usn);
	driver.findElement(By.name("user_password")).sendKeys(pwd);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(sh);
	String expectedvalue=sh;
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String finalvalue=driver.findElement(By.xpath("//span[contains(text(),' "+expectedvalue+" -  Organization Information')]")).getText();
	if(expectedvalue.contains(finalvalue)) {
		System.out.println("its is generated");
	}else {
		System.out.println("it is not generated");
	}
	
	}

}
