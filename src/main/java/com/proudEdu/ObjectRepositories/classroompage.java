package com.proudEdu.ObjectRepositories;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;

public class classroompage {
	//declaration
@FindBy(id = "name")
private WebElement classroomname;

@FindBy(id = "student_count")
private WebElement studentcount1;

@FindBy(id = "btnSubmit")
private WebElement submitbtn;

@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
private WebElement searchbtn;



//initiliation
public classroompage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//utilzation
public WebElement getClassroomname() {
	return classroomname;
}
public WebElement getStudentcount() {
	return studentcount1;
}
public WebElement getSubmitbtn() {
	return submitbtn;
}
public WebElement getSearchbtn() {
	return searchbtn;
}


//String actualvalue =null;
//public void classroomdata(WebDriver driver, ExcelUtility elib,ArrayList<String> value,JavaUtility jlib) throws Throwable {
//	int lastrownum=elib.readLastrownumb("classroom");
//	 System.out.println(lastrownum);
//	 for(int i=0;i<=lastrownum;i++) {
//		String value1=elib.readExceldata("classroom", i, 1);
//	    	driver.findElement(By.id(value.get(i))).sendKeys(value1+jlib.javautil(200));
//	    	actualvalue=value1+jlib.javautil(200);
//	    	
//}
//}
String actualdata=null;
public void classroomdata(ExcelUtility elib,JavaUtility jlib) throws Throwable {
	actualdata = elib.readExceldata("classroom", 0, 1)+jlib.javautil(500);
	classroomname.sendKeys(actualdata);
	String studentcount = elib.readExceldata("classroom", 1, 1)+jlib.javautil(500);
	studentcount1.sendKeys(studentcount);
	
	submitbtn.click();
}
public void enterSeachAndCompare(WebDriver driver,ExcelUtility elib) throws Throwable {
	searchbtn.sendKeys(actualdata);
	String expecteddata = driver.findElement(By.xpath("//td[.='"+actualdata+"']")).getText();
	if(expecteddata.contains(actualdata)) {
		System.out.println(expecteddata+"it is present");
	}else {
		System.out.println("it is not present");
	}
	elib.writeExcelData("classroom", 2, 1, actualdata);
}


	
	 
//	 public void enterserchbtn(WebDriver driver,ExcelUtility elib,JavaUtility jlib) throws Throwable {
//		 searchbtn.sendKeys(actualvalue);
//		 String expecteddata = driver.findElement(By.xpath("//td[.='"+actualvalue+"']")).getText();
//		 
		// return expecteddata;
//		 if(expecteddata.contains(actualvalue)){
//				System.out.println("it is present");
//			}else {
//				System.out.println("it is not present");
//		       
//			}   
		 
	 }

	
	 





