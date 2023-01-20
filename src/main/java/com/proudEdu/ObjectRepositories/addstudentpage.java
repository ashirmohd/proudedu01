package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;

public class addstudentpage {
@FindBy(id="index_number")
private WebElement studentidbtn;

@FindBy(id="full_name")
private WebElement studentnamebtn;

@FindBy(id = "i_name")
private WebElement surnamebtn;

@FindBy(id="address")
private WebElement addressbtn;

@FindBy(id="email")
private WebElement emailbtn;

@FindBy(id="phone")
private WebElement phonebtn;

@FindBy(id="b_date")
private WebElement birthdatebtn;

@FindBy(id="gender")
private WebElement genderdp;

@FindBy(id="fileToUpload")
private WebElement fileToUploadbtn;

@FindBy(id="g_full_name")
private WebElement g_full_namebtn;

@FindBy(id="g_i_name")
private WebElement g_i_namebtn;


@FindBy(id="g_address")
private WebElement g_addressbtn;


@FindBy(id="g_email")
private WebElement g_emailbtn;


@FindBy(id="g_phone")
private WebElement g_phonebtn;


@FindBy(id="g_b_date")
private WebElement g_b_datebtn;


@FindBy(id="g_gender")
private WebElement g_genderdp;

@FindBy(id="g_fileToUpload")
private WebElement g_fileToUploadbtn;

@FindBy(xpath = "//button[@id='btnSubmit']")
private WebElement nextbtn;

@FindBy(xpath = "//a[.=' Add Student']")
private WebElement addstudentbtn;

@FindBy(id = "grade")
private WebElement gradedpbtn;

@FindBy(id= "checkbox")
private WebElement checkbtn;

@FindBy(xpath = "//button[@id='btnSubmit1']/child::span")
private WebElement btnclick;

@FindBy(xpath = "//div[@class='panel panel-info']/descendant::span[@class='glyphicon glyphicon-remove']")
private WebElement finalclik;

public addstudentpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getStudentidbtn() {
	return studentidbtn;
}

public WebElement getStudentnamebtn() {
	return studentnamebtn;
}


public WebElement getSurnamebtn() {
	return surnamebtn;
}

public WebElement getAddressbtn() {
	return addressbtn;
}

public WebElement getEmailbtn() {
	return emailbtn;
}

public WebElement getPhonebtn() {
	return phonebtn;
}

public WebElement getBirthdatebtn() {
	return birthdatebtn;
}

public WebElement getGenderdp() {
	return genderdp;
}

public WebElement getFileToUploadbtn() {
	return fileToUploadbtn;
}

public WebElement getG_full_namebtn() {
	return g_full_namebtn;
}

public WebElement getG_i_namebtn() {
	return g_i_namebtn;
}

public WebElement getG_addressbtn() {
	return g_addressbtn;
}

public WebElement getG_emailbtn() {
	return g_emailbtn;
}

public WebElement getG_phonebtn() {
	return g_phonebtn;
}

public WebElement getG_b_datebtn() {
	return g_b_datebtn;
}

public WebElement getG_genderdp() {
	return g_genderdp;
}

public WebElement getG_fileToUploadbtn() {
	return g_fileToUploadbtn;
}

public WebElement getNextbtn() {
	return nextbtn;
}
public WebElement getAddstudentbtn() {
	return addstudentbtn;
}

public void clickonaddstudent() {
	addstudentbtn.click();
}

public WebElement getGradedpbtn() {
	return gradedpbtn;
}


public WebElement getCheckbtn() {
	return checkbtn;
}


public WebElement getBtnclick() {
	return btnclick;
}


public WebElement getFinalclik() {
	return finalclik;
}

public void getingdatainthetextbox(WebdriverUtility wblib,ExcelUtility elib,String visibletext,String visibletext1,JavaUtility jlib) throws Throwable {
	String indexvlaue= elib.readExceldata("student", 0, 1);
	studentidbtn.sendKeys(jlib.javautil(200)+indexvlaue);
	String fullnamevalue= elib.readExceldata("student", 1, 1);
	studentnamebtn.sendKeys(jlib.javautil(200)+fullnamevalue);
	String surnamevalue= elib.readExceldata("student", 2, 1);
	surnamebtn.sendKeys(jlib.javautil(200)+surnamevalue);
	String addressvalue= elib.readExceldata("student", 3, 1);
	addressbtn.sendKeys(jlib.javautil(200)+addressvalue);
	String emailvalue= elib.readExceldata("student", 4, 1);
	emailbtn.sendKeys(jlib.javautil(200)+emailvalue);
	String phonevalue= elib.readExceldata("student", 5, 1);
	phonebtn.sendKeys(jlib.javautil(200)+phonevalue);
	String birthdatebtnvalue= elib.readExceldata("student", 6, 1);
	birthdatebtn.sendKeys(jlib.javautil(200)+birthdatebtnvalue);
	String g_full_namevalue= elib.readExceldata("student", 7, 1);
	g_full_namebtn.sendKeys(jlib.javautil(200)+g_full_namevalue);
	String g_i_namebtnvalue= elib.readExceldata("student", 8, 1);
	g_i_namebtn.sendKeys(jlib.javautil(200)+g_i_namebtnvalue);
	String g_addressbtnvalue= elib.readExceldata("student", 9, 1);
	g_addressbtn.sendKeys(jlib.javautil(200)+g_addressbtnvalue);
	String g_emailbtnvalue= elib.readExceldata("student", 10, 1);
	g_emailbtn.sendKeys(jlib.javautil(200)+g_emailbtnvalue);
	String g_phonebtnvalue= elib.readExceldata("student", 11, 1);
	g_phonebtn.sendKeys(jlib.javautil(200)+g_phonebtnvalue);
	String g_b_datebtnvalue= elib.readExceldata("student", 12, 1);
	g_b_datebtn.sendKeys(jlib.javautil(200)+g_b_datebtnvalue);
	wblib.select(visibletext1, g_genderdp);
    wblib.select(visibletext, genderdp);
    String fileToUploadbtnvalue=elib.readExceldata("student", 13, 1);
    fileToUploadbtn.sendKeys(fileToUploadbtnvalue);
    String g_fileToUploadbtnvalue=elib.readExceldata("student", 14, 1);
    g_fileToUploadbtn.sendKeys(g_fileToUploadbtnvalue);
    nextbtn.click();
}
public void selectgrade(WebdriverUtility wblib,String visibletext ) {
	wblib.select(visibletext, gradedpbtn);
}
public void clickonchecker() {
	checkbtn.click();
}
public void clickbuttonandsubmit() {
	btnclick.click();
}
public void finalclik() {
	finalclik.click();
}

}
