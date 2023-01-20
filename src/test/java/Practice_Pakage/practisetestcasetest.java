package Practice_Pakage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.fileUtility;

public class practisetestcasetest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wblib=new WebdriverUtility();
		int n = jlib.javautil(100);
		WebDriver driver=new ChromeDriver();
	    driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("12345");
	    driver.findElement(By.id("btnSubmit")).click();
	    driver.findElement(By.xpath("//span[text()='Student']")).click();
	    driver.findElement(By.xpath("//a[text()=' Add Student']")).click();
	    
	    ArrayList<String> al = elib.getlistUsingArraylist("student", 0);
        int readlastdata = elib.readLastrownumb("student");
        for(int i=0;i<=readlastdata;i++) {
        	String data = elib.readExceldata("student",i, 1);
        	driver.findElement(By.name(al.get(i))).sendKeys(n+data);
        }
        WebElement sel = driver.findElement(By.id("gender"));
		wblib.select("Male", sel);
        WebElement sel1 = driver.findElement(By.id("g_gender"));
        wblib.select("Male", sel1);
        driver.findElement(By.id("fileToUpload")).sendKeys("C:\\Users\\ashir\\Desktop\\image1.png");
        driver.findElement(By.id("g_fileToUpload")).sendKeys("C:\\Users\\ashir\\Desktop\\image1.png");
        driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
        WebElement grade = driver.findElement(By.id("grade"));
        wblib.select("grade127", grade);
        Thread.sleep(2000);
        driver.findElement(By.id("checkbox")).click();
		driver.findElement(By.xpath("//button[@id='btnSubmit1']/child::span")).click();
		driver.findElement(By.xpath("//div[@class='panel panel-info']/descendant::span[@class='glyphicon glyphicon-remove']")).click();
		 driver.findElement(By.xpath("//span[text()='Student']")).click();
	    driver.findElement(By.xpath("//a[text()=' All Student']")).click();
	   WebElement sel3 = driver.findElement(By.id("grade"));
	   wblib.select("grade127", sel3);

		}

}
