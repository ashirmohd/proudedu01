package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.WebdriverUtility;

public class searchStudentPage{

	@FindBy(id = "grade")
	private WebElement gradedp;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement sumbbtn;
	
	@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
	private WebElement searchbtn;
	
	public searchStudentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getGradedp() {
		return gradedp;
	}

	public WebElement getSumbbtn() {
		return sumbbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	//business scenario
	public void selgradevalue(WebdriverUtility wblib,ExcelUtility elib) throws Throwable {
		String visibletext=elib.readExceldata("Grade", 3, 1);
		wblib.select(visibletext, gradedp);
		sumbbtn.click();
	}
	public void seachandCompare(String actualdata,WebDriver driver) {
		
		searchbtn.sendKeys(actualdata);
		 String finalvalue = driver.findElement(By.xpath("//td/a[text()='"+actualdata+"']")).getText();
	    if(actualdata.equalsIgnoreCase(finalvalue)) {
	    	System.out.println("it is displayed");
	    }
	    else {
	    	System.out.println("it is not displayed");
	    }
	}
}
