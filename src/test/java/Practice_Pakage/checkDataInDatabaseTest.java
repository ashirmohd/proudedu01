package Practice_Pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class checkDataInDatabaseTest {
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		}
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("abcd23");
		
		driver.findElement(By.name("createdBy")).sendKeys("deepak");
		WebElement drop = driver.findElement(By.name("status"));
		Select s=new Select(drop);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success' ]")).click();
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement stat = con.createStatement();
                String Expectresult="select * from project where created_by"
                		+ "='deepak';";
		ResultSet res = stat.executeQuery(Expectresult);
       boolean flag=false;
       while(res.next()) {
    	   String actualvalue=res.getString(4);
    	   System.out.println(actualvalue);
    	   if(actualvalue.equalsIgnoreCase("abcd23")) {
    		   flag=true;
    		   break;
    	   }
       }    		   if(flag) {
    	   System.out.println("it is created");
    	   }
       else {
    	   System.out.println("it is not created");
       }
       con.close();
       }
	}


