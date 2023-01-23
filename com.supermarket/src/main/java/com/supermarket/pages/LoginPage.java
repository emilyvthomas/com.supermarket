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
	//input[@name='username']
	//input[@name='password']
	GeneralUtilities gu=new GeneralUtilities();
    ExcelUtility excel=new ExcelUtility();
//	By username=By.xpath("//input[@name='username']");	
//	By password=By.xpath("//input[@name='password']");
//	By signin=By.xpath("//button[@class='btn btn-dark btn-block']");
//	By dashboard=By.xpath("//li[text()='Dashboard']");
//	By errorMsg=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
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
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") 
//	WebElement moreInfo;
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user']")
//	WebElement manageUserLink;
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
//	WebElement manageOrderLink;
//
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']")
//	WebElement manageLocationLink;
public  void login(String username1,String password1)
	{
	
	gu.sendkeysCommand(username, username1);
	gu.sendkeysCommand(password, password1);
	gu.clickCommand(signin);
//		username.sendKeys(username1);
//		password.sendKeys(password1);
//		signin.click();
	
	}
//public void moreInfo()
//{
//	manageLocationLink.click();
//	String title1=driver.getTitle();
//	System.out.println(title1);
//	
//}
public boolean isDisplayedDashboard()
{ 
		Boolean returndashval=dashboard.isDisplayed();
	    return returndashval;
	    
}

public String geterrorMessage()
{
	//div[@class='alert alert-danger alert-dismissible']
	String errormsg=gu.getText(errorMsg);
	return errormsg;
}

public void clearDetails()

{
	gu.clearCommand(username);
	gu.clearCommand(password);
//	username.clear();
//	password.clear();
}
public	LoginPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 
 }

}
