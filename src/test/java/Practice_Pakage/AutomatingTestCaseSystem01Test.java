
package Practice_Pakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomatingTestCaseSystem01Test {

	public static void main(String[] args) throws Throwable {
    WebDriver driver=new ChromeDriver();
    driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
    driver.findElement(By.id("password")).sendKeys("12345");
    driver.findElement(By.id("btnSubmit")).click();
    driver.findElement(By.xpath("//span[text()='Classroom']")).click();
    driver.findElement(By.id("name")).sendKeys("grade35");
    driver.findElement(By.id("student_count")).sendKeys("457");
    driver.findElement(By.id("btnSubmit")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[text()='Grade']")).click();
    driver.findElement(By.id("name")).sendKeys("selenium27");
    driver.findElement(By.id("admission_fee")).sendKeys("25895");
    driver.findElement(By.id("hall_charge")).sendKeys("500");
    driver.findElement(By.id("btnSubmit")).click();
    driver.findElement(By.id("mark_range_text_1")).sendKeys("35-55");
    driver.findElement(By.id("mark_grade_text_1")).sendKeys("B+");
    driver.findElement(By.id("btnSubmit1")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[text()='Subject']")).click();
    driver.findElement(By.id("name")).sendKeys("jdhsk");
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[text()='Teacher']")).click();
    driver.findElement(By.xpath("//a[text()=' Add Teacher']")).click();
    driver.findElement(By.id("index_number")).sendKeys("154",Keys.TAB,"manoj",Keys.TAB,"kumar",Keys.TAB,"bangalore");
    //driver.findElement(By.id("full_name")).sendKeys("manoj");
    //driver.findElement(By.id("i_name")).sendKeys("kumar");
    //driver.findElement(By.id("address")).sendKeys("bangalore");
    WebElement data = driver.findElement(By.id("gender"));
    Select s=new Select(data);
    s.selectByVisibleText("Male");
    driver.findElement(By.id("phone")).sendKeys("958-785-2589");
    driver.findElement(By.id("email")).sendKeys("manoj@gmail.com");
    driver.findElement(By.id("fileToUpload")).sendKeys("C:\\Users\\ashir\\Desktop\\image1.png");
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();
    driver.findElement(By.xpath("//a[text()='Add ']")).click();
    driver.findElement(By.id("grade")).click();
    
    
	}

}
