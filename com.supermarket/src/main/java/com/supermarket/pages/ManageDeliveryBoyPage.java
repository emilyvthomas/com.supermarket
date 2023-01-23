package com.supermarket.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExcelUtility exobj=new ExcelUtility();
	WaitUtility wait=new WaitUtility();
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBar;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchBar2;
	@FindBy(xpath="//button[@class='btn btn-default btn-fix']")
    WebElement resetButton;
	
	@FindBy(xpath="//div[@class='col-sm-12']/child::a[1]")
	WebElement newButton;

	@FindBy(xpath="//input[@id='name']")
    WebElement name;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement name1;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phonenumber;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement save;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	WebElement cancel;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement home;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement newDeliveryBoy;
	
	@FindBy(xpath="//span[@class='badge bg-success']")
	WebElement changeStatusActive;
	
	@FindBy(xpath="//span[@class='badge bg-warning']")
    WebElement changeStatusInactive;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement updateButton;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updatemsg;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletemsg;
	
	public void addDeliveryBoyDetails() throws Exception
{
		gu.clickCommand(newButton);
		gu.sendkeysCommand(name, ExcelUtility.readStringData(3, 1));
		gu.sendkeysCommand(email, ExcelUtility.readStringData(4, 1));
		//Thread.sleep(1000);
		wait.explicitWait(driver);
		gu.sendkeysCommand(phonenumber, ExcelUtility.readIntegerData(5, 1));
		gu.sendkeysCommand(address, ExcelUtility.readStringData(6, 1));
		gu.sendkeysCommand(username, ExcelUtility.readStringData(7, 1));
		gu.sendkeysCommand(password, ExcelUtility.readStringData(8, 1));
		
	}
	public void scroll()
	{
		gu.scrollUptoDown(driver);
	}
	public String editDeliveryBoyDetails() throws Exception
	{
		gu.clickCommand(editButton);
		gu.clearCommand(username);
		gu.sendkeysCommand(username, ExcelUtility.readStringData(9, 1));
		gu.clearCommand(password);
		gu.sendkeysCommand(password,ExcelUtility.readStringData(10, 1));
		gu.scrollUptoDown(driver);
		wait.generalSleep();
		gu.clickCommand(updateButton);
		String updatevalue=gu.getText(updatemsg);
		return updatevalue;
	}
	public String searchDeliveryBoy() throws IOException
	{
	
		gu.clickCommand(searchBar);
		gu.sendkeysCommand(name1,ExcelUtility.readStringData(3, 1));
		gu.clickCommand(searchBar2);;
		String searchValue=gu.getText(newDeliveryBoy);
		return searchValue;
	}
	public String deleteDeliveryBoy()
	{   
		
		wait.explicitWait(driver);
	    gu.clickCommand(deleteButton);
	    gu.alertAccept(driver);
		String deleteValue=gu.getText(deletemsg);
		return deleteValue;
	}
	
	
	public boolean isDisplayed()
	{
	Boolean val=deletemsg.isDisplayed();
	return val;
	}
	
	public String saveDetails()
	{
		gu.clickCommand(save);
		String savedValue=gu.getText(newDeliveryBoy);
		return savedValue;
	}
	
	

	public void backToHomePage()
   {
		gu.clickCommand(home);
   }

	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
