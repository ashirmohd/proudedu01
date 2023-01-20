package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;

public class timeTablepage {

	@FindBy(id = "grade")
	private WebElement gradedp;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right' and text()='Add ']")
	private WebElement addbtn;
	
	@FindBy(id = "day")
	private WebElement daydp;
	
	@FindBy(id="subject")
	private WebElement subjectdp;
	
	@FindBy(id = "teacher")
	private WebElement teacherdp;
	
	@FindBy(id ="classroom")
	private WebElement classroomdp;
	
	@FindBy(id = "start_time")
	private WebElement starttimebtn;
	
	@FindBy(id = "end_time")
	private WebElement endtimebtn;
	
	@FindBy(id ="btnSubmit")
	private WebElement lastsubmitbtn;
	
	public timeTablepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getGradedp() {
		return gradedp;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getDaydp() {
		return daydp;
	}

	public WebElement getSubjectdp() {
		return subjectdp;
	}

	public WebElement getTeacherdp() {
		return teacherdp;
	}

	public WebElement getStarttimebtn() {
		return starttimebtn;
	}

	public WebElement getEndtimebtn() {
		return endtimebtn;
	}
	

	public WebElement getClassroomdp() {
		return classroomdp;
	}

	public WebElement getLastsubmitbtn() {
		return lastsubmitbtn;
	}
	
	public void addgradedp(WebdriverUtility wblib,String visibletext) {
		wblib.select(visibletext, gradedp);
		submitbtn.click();
	}
	public void addtimetable(WebdriverUtility wblib,String visibletext,String visibletext1,String visibletext2,String visibletext3,ExcelUtility elib,JavaUtility jlib) throws Throwable {
		addbtn.click();
		wblib.select(visibletext, daydp);
		wblib.select(visibletext1, subjectdp);
		wblib.select(visibletext2, teacherdp);
		wblib.select(visibletext3, classroomdp);
		String starttime=elib.readExceldata("timetable", 0, 1);
		starttimebtn.sendKeys(jlib.javautil(10)+starttime);
		String endtime=elib.readExceldata("timetable", 1, 1);
		endtimebtn.sendKeys(jlib.javautil(10)+endtime);
		lastsubmitbtn.click();
	}
	public void camparingvalue(String gradeactaulvalue,WebDriver driver) {
		String actualtable="Timetable - "+gradeactaulvalue+"";
		String exe = driver.findElement(By.xpath("//h3[contains(text(),'Timetable - "+gradeactaulvalue+"')]")).getText();
		if(actualtable.contains(exe)) {
			System.out.println("timetable is found");
		}else {

			System.out.println("timetable is not found");
		}
	}
	
}
