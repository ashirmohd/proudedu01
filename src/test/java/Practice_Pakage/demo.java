package Practice_Pakage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class demo {
// public static void main(String[] args) {
	@Test
	public void comparetest() {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	String etitle="Google";
	String atitle=driver.getTitle();
//	Assert.assertEquals(etitle, atitle);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(etitle, atitle);
	sa.assertAll();
	driver.close();
	}
	@Test
	public void camparetest1() {
		System.out.println("---sample1---");
		System.out.println("---sample2---");
		assertEquals("A", "B");
		System.out.println("---sample3----");
		System.out.println("---sample4----");
		
	}
	@Test
	public void comparetest2() {
		System.out.println("---sample5---");
		System.out.println("---sample6---");
		assertNotEquals("A", "a");
		System.out.println("---sample7---");
		System.out.println("---sample8---");
	}
	@Test
	public void comparetest3() {
		String a=null;
		assertNotNull(a);
	}
	@Test
	public void camparetest4() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String exptitle = driver.getTitle();
		String atitle="oogle";
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(exptitle.equalsIgnoreCase(atitle));
		driver.close();
		sa.assertAll();
		
	}
	@Test
	public void camparetest5() {
		
	}
}
	
	

	

