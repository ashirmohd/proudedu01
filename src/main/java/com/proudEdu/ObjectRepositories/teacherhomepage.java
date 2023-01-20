package com.proudEdu.ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class teacherhomepage {
			
			@FindBy (xpath="//span[.='Dashboard']")
			private WebElement add_student;
			
			@FindBy (xpath="//span[.='My Profile']")
			private WebElement MyPrile;
			
			@FindBy (xpath="//span[.='My Student']")
			private WebElement Mystdt;
			
			@FindBy (xpath="//span[.='Subject']")
			private WebElement sbjt;
			
			@FindBy (xpath="//span[.='Timetable']")
			private WebElement tbt;
			
			@FindBy (xpath="//span[.='Attendance']")
			private WebElement attd;

			@FindBy (xpath="//span[.='My Salary']")
			private WebElement msly;
			
			@FindBy (xpath="//span[.='My Petty Cash']")
			private WebElement mpc ;
			
			@FindBy (xpath="//span[.='Exam']")
			private WebElement exam ;
			
			@FindBy (xpath="//span[.='Friends']")
			private WebElement fnds ;
			
			@FindBy (xpath="//span[.='Events']")
			private WebElement evnt ;
			
			@FindBy(linkText = "nawaz1")
			private WebElement adminbtn;
			
			@FindBy(linkText = "Sign out")
			private WebElement signout;
			
			
			
			//intilization
			
			public teacherhomepage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}


		     //utilization
			public WebElement getAdd_student() {
				return add_student;
			}



			public WebElement getMyPrile() {
				return MyPrile;
			}



			public WebElement getMystdt() {
				return Mystdt;
			}



			public WebElement getSbjt() {
				return sbjt;
			}



			public WebElement getTbt() {
				return tbt;
			}



			public WebElement getAttd() {
				return attd;
			}



			public WebElement getMsly() {
				return msly;
			}



			public WebElement getMpc() {
				return mpc;
			}



			public WebElement getExam() {
				return exam;
			}



			public WebElement getFnds() {
				return fnds;
			}



			public WebElement getEvnt() {
				return evnt;
			}
			
			
			
			public WebElement getAdminbtn() {
				return adminbtn;
			}


			public WebElement getSignout() {
				return signout;
			}


			//bussiness
			public void t_homepage()
			{
				add_student.click();
				MyPrile.click();
				
				sbjt.click();
				tbt.click();
				attd.click();
				msly.click();
				mpc.click();
				exam.click();
				fnds.click();
				evnt.click();
					
			}
			public void mystudebtn() {
				Mystdt.click();
			}
			
			public void clickonadminbtn() {
				adminbtn.click();
			}
			public void signoutbtn() {
				signout.click();
			}

}
