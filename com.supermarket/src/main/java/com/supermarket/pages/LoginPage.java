package com.supermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
    ExcelUtility excel=new ExcelUtility();
	@FindBy(xpath="//input[@name='username']") 
	WebElement username;
	@FindBy(xpath="//input[@name='password']") 
	WebElement password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") 
	WebElement signin;
	@FindBy(xpath="//li[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") 
	WebElement errorMsg;
public  void login(String username1,String password1)
	{
	
	gu.sendkeysCommand(username, username1);
	gu.sendkeysCommand(password, password1);
	gu.clickCommand(signin);
	}

public boolean isDisplayedDashboard()
{ 
		Boolean returndashval=dashboard.isDisplayed();
	    return returndashval;
	    
}

public String geterrorMessage()
{
	String errormsg=gu.getText(errorMsg);
	return errormsg;
}

public void clearDetails()

{
	gu.clearCommand(username);
	gu.clearCommand(password);
}
public	LoginPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 
 }

}
