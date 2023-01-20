package Practice_Pakage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadTheDataFromAmazonTest {

	public static void main(String[] args) throws Throwable {
		int c=0;
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata45.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int data = sh.getLastRowNum();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> data1 = driver.findElements(By.xpath("//a"));
		int count = data1.size();
		for(int i=2;i<count;i++) {
			sh.createRow(i).createCell(0).setCellValue(data1.get(i).getAttribute("href"));
			c++;
		}
		FileOutputStream fous=new FileOutputStream("./src/test/resources/Testdata45.xlsx");
		wb.write(fous);
		System.out.println("mission passed");
	}

}
