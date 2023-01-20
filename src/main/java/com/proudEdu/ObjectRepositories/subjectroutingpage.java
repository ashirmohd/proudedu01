package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class subjectroutingpage {
@FindBy(xpath = "//a[text()='Add ']")
private WebElement addbtn;

@FindBy(id = "grade")
private WebElement gradedp;

@FindBy(id="subject")
private WebElement subjectdp;

@FindBy(id="teacher")
private WebElement teacherdp;

@FindBy(id="fee")
private WebElement feebtn;

@FindBy(id="btnSubmit")
private WebElement submitbtn;

@FindBy(xpath = "//input[@class='form-control input-sm']")
private WebElement searchbtn;

public subjectroutingpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getAddbtn() {
	return addbtn;
}

public WebElement getGradedp() {
	return gradedp;
}

public WebElement getSubjectdp() {
	return subjectdp;
}

public WebElement getTeacherdp() {
	return teacherdp;
}

public WebElement getFeebtn() {
	return feebtn;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}

public WebElement getSearchbtn() {
	return searchbtn;
}

public void addsubjectbtn() {
	addbtn.click();
}
public void fillalldetailsinsubjectrouting(WebdriverUtility wblib,String visibletext,String visibletext1,String visibletext2,String feevalue) {
	wblib.select(visibletext, gradedp);
	wblib.select(visibletext1, subjectdp);
	wblib.select(visibletext2, teacherdp);
	feebtn.sendKeys(feevalue);
	submitbtn.click();
}
public void searchtextsubject(String actualvalue,WebDriver driver) {
	searchbtn.sendKeys(actualvalue);
	String finalvalue = driver.findElement(By.xpath("//td[.='"+actualvalue+"']")).getText();
    if(finalvalue.equals(actualvalue)) {
  	  	System.out.println("subject is created");
    }else {
  	  System.out.println("subject is not created");
    }
    
	}
}


