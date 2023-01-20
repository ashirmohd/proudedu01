
package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.fileUtility;

public class LoginPage {
    //declaration
	@FindBy(id="email")
	private WebElement usernameedt;
	
	@FindBy(id="password")
	private WebElement passwordedt;
	
	@FindBy(id="btnSubmit")
	private WebElement loginbtn;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//business library
	
	public void Login(String username,String password) {
		usernameedt.sendKeys(username);
		passwordedt.sendKeys(password);
		loginbtn.click();
	}
	
	
}
