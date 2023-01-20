package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class Homepage {
	// declaration
	@FindBy(xpath = "//span[text()='Classroom']")
	private WebElement classroomlink;

	@FindBy(linkText = "Grade")
	private WebElement Gradelink;

	@FindBy(linkText = "Subject")
	private WebElement Subjectlink;

	@FindBy(linkText = "Teacher")
	private WebElement Teacherlink;

	@FindBy(linkText = "Subject Routing")
	private WebElement SubjectRoutinglink;

	@FindBy(linkText = "Timetable")
	private WebElement timetableLink;

	@FindBy(linkText = "Student")
	private WebElement studentlink;
	
	@FindBy(xpath = "//span[text()='Admin A']")
	private WebElement adminbutton;
	
	@FindBy(linkText = "Sign out")
	private WebElement signoutedt;
	


	

	// initilizatrion
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getClassroomlink() {
		return classroomlink;
	}

	public WebElement getGradelink() {
		return Gradelink;
	}

	public WebElement getSubjectlink() {
		return Subjectlink;
	}

	public WebElement getTeacherlink() {
		return Teacherlink;
	}

	public WebElement getSubjectRoutinglink() {
		return SubjectRoutinglink;
	}

	public WebElement getTimetableLink() {
		return timetableLink;
	}

	public WebElement getStudentlink() {
		return studentlink;
	}
	public WebElement getAdminbutton() {
		return adminbutton;
	}

	public WebElement getSignoutedt() {
		return signoutedt;
	}
	
	

	//business library
	
	

	public void classroom() {
		classroomlink.click();
	}
	public void subject() {
		Subjectlink.click();
	}
	public void grade() {
		Gradelink.click();
		}
	public void teacher() {
		Teacherlink.click();
	}
	public void subjectrouting() {
		SubjectRoutinglink.click();
	}
	public void timetable() {
		timetableLink.click();
	}
	public void student() {
		studentlink.click();
		
	}
	
	public void adminbtn() {
		adminbutton.click();
	}
	public void signout() {
		signoutedt.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
