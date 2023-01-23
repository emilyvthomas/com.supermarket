package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	
	public void implicitWait(WebDriver driver,int d)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(d));
		
	}
	 public void eWPresenceOfElementLocated(WebDriver driver,int d,WebElement element)
	 {
		 WebDriverWait explicitWait=new WebDriverWait(driver,Duration.ofSeconds(d));
		  explicitWait.until(ExpectedConditions.visibilityOf(element));
		   
	 }
	 public void eWElementToBeClickable(WebDriver driver,int d,WebElement element)
	 {
	 WebDriverWait explicitWait1=(WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(d)).until(ExpectedConditions.elementToBeClickable((By) element));
		   
	 }
	 public void explicitWait(WebDriver driver) {
		 WebDriverWait explicitwait=new WebDriverWait(driver,Duration.ofSeconds(1000));
		 
	}
	 public void fluentWait(WebDriver driver,WebElement element ,int d) {
		 Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(d))
					.pollingEvery(Duration.ofSeconds(d))
					.ignoring(Exception.class);
         wait.until(ExpectedConditions.elementToBeSelected(element));
	 }
	public void generalSleep() throws Exception
	{
		Thread.sleep(5000);
	}

}
