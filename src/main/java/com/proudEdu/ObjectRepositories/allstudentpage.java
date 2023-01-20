package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class allstudentpage {

	@FindBy(xpath = "//a[text()=' All Student']")
	private WebElement clickonallstudent;
	
	@FindBy(id = "grade")
	private WebElement gradedp;
	
	public allstudentpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickonallstudent() {
		return clickonallstudent;
	}

	public WebElement getGradedp() {
		return gradedp;
	}
	public void clickonallstudent() {
		clickonallstudent.click();
	}
	public void clickongrade(WebdriverUtility wblib,String visibletext) {
		wblib.select(visibletext, gradedp);
	}
}
