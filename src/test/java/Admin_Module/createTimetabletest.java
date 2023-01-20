package Admin_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class createTimetabletest {

	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int random = ran.nextInt(200);

		FileInputStream fis=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("URL");
		String usn = p.getProperty("USERNAME");
		String pwd = p.getProperty("PASSWORD");

		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testdata45.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("classroom");
		Sheet sh1=wb.getSheet("Grade");
		Sheet sh2=wb.getSheet("Subject");
		String subdata = sh2.getRow(0).getCell(1).getStringCellValue()+random;
		Sheet sh3=wb.getSheet("teacher");
		//		Sheet sh4=wb.getSheet("subject routing");
		//		String subroutdata=sh4.getRow(0).getCell(1).getStringCellValue()+random;
		String startime = wb.getSheet("timetable").getRow(0).getCell(1).getStringCellValue();
		String endtime = wb.getSheet("timetable").getRow(1).getCell(1).getStringCellValue();


		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys(usn);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("btnSubmit")).click();

		driver.findElement(By.xpath("//span[text()='Classroom']")).click();

		ArrayList<String> data= new ArrayList<String>();
		data.add("name");
		data.add("student_count");
		String classroomname=null;;
		for(int i=0;i<=sh.getLastRowNum();i++) {
			String data1 = sh.getRow(i).getCell(1).getStringCellValue()+random;
			driver.findElement(By.id(data.get(i))).sendKeys(data1);
			classroomname=data1;
		}

		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
		WebElement tblval = driver.findElement(By.name("example1_length"));
		Select s=new Select(tblval);
		s.selectByValue("100");
		String finalclassvalue = driver.findElement(By.xpath("//tbody/descendant::tr[last()]/td[2]")).getText();
		System.out.println(finalclassvalue);

		driver.findElement(By.linkText("Grade")).click();

		ArrayList<String> grd=new ArrayList<String>();
		grd.add("name");
		grd.add("admission_fee");
		grd.add("hall_charge");

		for(int i=0;i<=sh1.getLastRowNum();i++) {
			String grddata = sh1.getRow(i).getCell(1).getStringCellValue()+random;
			driver.findElement(By.id(grd.get(i))).sendKeys(grddata);
		}
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.id("mark_range_text_1")).sendKeys("78-90");
		driver.findElement(By.id("mark_grade_text_1")).sendKeys("B+");
		driver.findElement(By.id("btnSubmit1")).click();

		Thread.sleep(5000);
		WebElement tblval1 = driver.findElement(By.name("example1_length"));
		Select s1=new Select(tblval1);
		s1.selectByValue("100");
		String finalgradevalue = driver.findElement(By.xpath("(//tbody/descendant::tr[last()]/td[2])[2]")).getText();
		System.out.println(finalgradevalue);


		driver.findElement(By.linkText("Subject")).click();
		driver.findElement(By.id("name")).sendKeys(subdata);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		Thread.sleep(5000);
		WebElement tblval2 = driver.findElement(By.name("example1_length"));
		Select s2=new Select(tblval2);
		s2.selectByValue("100");
		String finalsubjectvalue = driver.findElement(By.xpath("//tbody/descendant::tr[last()]/td[2]")).getText();
		System.out.println(finalsubjectvalue);
		//    Thread.sleep(3000);
		//   	driver.navigate().refresh();
		//    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();
		driver.findElement(By.xpath("//a[text()='Add ']")).click();

		WebElement grdedp = driver.findElement(By.id("grade"));
		Select s3=new Select(grdedp);
		s3.selectByVisibleText(finalgradevalue);
		WebElement subdp = driver.findElement(By.id("subject"));
		Select s5=new Select(subdp);
		s5.selectByVisibleText(finalsubjectvalue);
		WebElement techdp=driver.findElement(By.id("teacher"));
		Select s6=new Select(techdp);
		s6.selectByVisibleText("nawaz1");
		driver.findElement(By.id("fee")).sendKeys("5000");
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Timetable")).click();
		WebElement valuetime = driver.findElement(By.id("grade"));
		Select s7=new Select(valuetime);
		s7.selectByVisibleText(finalgradevalue);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm pull-right' and text()='Add ']")).click();

		WebElement dayval = driver.findElement(By.id("day"));
		Select s8=new Select(dayval);
		s8.selectByVisibleText("Wednesday");
		WebElement subval = driver.findElement(By.id("subject"));
		Select s9=new Select(subval);
		s9.selectByVisibleText(finalsubjectvalue);
		WebElement tecval = driver.findElement(By.id("teacher"));
		Select s10=new Select(tecval);
		s10.selectByVisibleText("nawaz1");
		WebElement classval = driver.findElement(By.name("classroom_id"));
		Select s11=new Select(classval);
		s11.selectByVisibleText(finalclassvalue);
		driver.findElement(By.id("start_time")).sendKeys(startime);
		driver.findElement(By.id("end_time")).sendKeys(endtime);
		driver.findElement(By.id("btnSubmit")).click();

		Thread.sleep(5000);
		String actualtable="Timetable - "+finalgradevalue+"";
		String exe = driver.findElement(By.xpath("//h3[.='Timetable - "+finalgradevalue+"']")).getText();
		if(actualtable.contains(exe)) {
			System.out.println("it is found");
		}else {

			System.out.println("it is not found");
		}
		driver.findElement(By.xpath("//span[text()='Admin A']")).click();
		driver.findElement(By.linkText("Sign out")).click();
	}


}
