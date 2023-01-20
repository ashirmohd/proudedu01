package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;

public class subjectpage {
@FindBy(id ="name")
private WebElement subjecttext;

@FindBy(xpath="//button[text()='Submit']")
private WebElement submitbtn;

@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
private WebElement searchbtn;

public subjectpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getSubjecttext() {
	return subjecttext;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}

public WebElement getSearchbtn() {
	return searchbtn;
}
String subjectvalue=null; 
public void subjectdata(ExcelUtility elib,JavaUtility jlib) throws Throwable {
	subjectvalue=elib.readExceldata("Subject", 0, 1)+jlib.javautil(500);
	subjecttext.sendKeys(subjectvalue);
	submitbtn.click();
}

public void searchdata(ExcelUtility elib,WebDriver driver) throws Throwable {
	searchbtn.sendKeys(subjectvalue);
	String expecteddata = driver.findElement(By.xpath("//td[.='"+subjectvalue+"']")).getText();
	if(expecteddata.contains(subjectvalue)) {
		System.out.println(expecteddata+"it is present");
	}else {
		System.out.println("it is not present");
	}
	 elib.writeExcelData("Subject", 1, 1, subjectvalue);
	
}
}
