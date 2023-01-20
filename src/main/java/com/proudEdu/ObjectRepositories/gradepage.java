
package com.proudEdu.ObjectRepositories;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;

public class gradepage {
@FindBy(id = "name")
private WebElement gradenameedt;

@FindBy(id = "admission_fee")
private WebElement gradefreeEdit;

@FindBy(id = "hall_charge")
private WebElement hallpriceedit;

@FindBy(id="btnSubmit")
private WebElement btnedit;

@FindBy(id="mark_range_text_1")
private WebElement markedit;

@FindBy(id="mark_grade_text_1")
private WebElement gradeedit;

@FindBy(id="btnSubmit1")
private WebElement lastbtnedit;

@FindBy(xpath = "//input[@type='search']")
private WebElement searchtextbox;


public gradepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getGradenameedt() {
	return gradenameedt;
}


public WebElement getGradefreeEdit() {
	return gradefreeEdit;
}


public WebElement getHallpriceedit() {
	return hallpriceedit;
}


public WebElement getBtnedit() {
	return btnedit;
}


public WebElement getMarkedit() {
	return markedit;
}


public WebElement getGradeedit() {
	return gradeedit;
}


public WebElement getLastbtnedit() {
	return lastbtnedit;
}


//business libraries

//public void classroomdata(WebDriver driver, ExcelUtility elib,ArrayList<String> value,JavaUtility jlib) throws Throwable {
//	int lastrownum=elib.readLastrownumb("Grade");
//	 System.out.println(lastrownum);
//	 for(int i=0;i<=lastrownum;i++) {
//		String value1=elib.readExceldata("Grade", i, 1);
//	    	driver.findElement(By.id(value.get(i))).sendKeys(value1);


//}

	 
public WebElement getSearchtextbox() {
	return searchtextbox;
}


//}
String gradeexcelvalue=null;
public void gradedata(ExcelUtility elib,JavaUtility jlib) throws Throwable {
	 gradeexcelvalue=elib.readExceldata("Grade", 0, 1)+jlib.javautil(500);
	gradenameedt.sendKeys(gradeexcelvalue);
	String admissionfeevalue=elib.readExceldata("Grade", 1, 1)+jlib.javautil(500);
	gradefreeEdit.sendKeys(admissionfeevalue);
	String hallchargevalue=elib.readExceldata("Grade", 2, 1)+jlib.javautil(500);
	hallpriceedit.sendKeys(hallchargevalue);
	btnedit.click();
	markedit.sendKeys("60-70");
	gradeedit.sendKeys("B+");
	lastbtnedit.click();
}
public void searchgrade(WebDriver driver,ExcelUtility elib) throws Throwable {
	searchtextbox.sendKeys(gradeexcelvalue);
	String expecteddata = driver.findElement(By.xpath("//td[.='"+gradeexcelvalue+"']")).getText();
	if(expecteddata.contains(gradeexcelvalue)) {
		System.out.println(expecteddata+"it is present");
	}else {
		System.out.println("it is not present");
	}
	 elib.writeExcelData("Grade", 3, 1, gradeexcelvalue);
}

}
