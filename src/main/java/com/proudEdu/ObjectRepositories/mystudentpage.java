package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class mystudentpage {

	@FindBy(id = "grade")
	private WebElement gradbtn;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement subtbtn;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement seachtxtbtn;
	
	public mystudentpage(WebDriver driver)
{
		PageFactory.initElements(driver, this);
		}

	public WebElement getGradbtn() {
		return gradbtn;
	}

	public WebElement getSubtbtn() {
		return subtbtn;
	}

	public WebElement getSeachtxtbtn() {
		return seachtxtbtn;
	}
	public void gradedp(WebdriverUtility weblib,String visibletext) {
		weblib.select(visibletext, gradbtn);
		subtbtn.click();
		seachtxtbtn.sendKeys("");
	}
}
