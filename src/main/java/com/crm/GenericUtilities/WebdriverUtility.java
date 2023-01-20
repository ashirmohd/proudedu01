

package com.crm.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	
	public void waitForLoadingPage(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
	}
	
	public void elementtoVisible(WebDriver driver,WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver, 10);	
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void select(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
				
	}
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void select(String visibletext,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	
	public void mousehover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element);
	}
	
	public void draganddrop(WebDriver driver,WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target);
	}
	
	public void rightclick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
		
	}
	
	public void doubleclick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick();
	}
	
	
	public void rightclick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void enterKeyPress(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();

	}
	public void enterKey(WebDriver driver) throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use getWindowHandes to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title 
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
		
	}
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;
		
	}
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	
}
	
}

