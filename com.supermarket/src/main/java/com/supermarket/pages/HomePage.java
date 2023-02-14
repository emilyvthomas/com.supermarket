package com.supermarket.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement home;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") 
	WebElement manageDeiverBoyLink;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user']")
	WebElement manageUserLink;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrderLink;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']")
	WebElement manageLocationLink;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNewsLink;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement userTitle;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement orderTitle;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement deliveryBoyPageTitle;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement LocationPageTitle;
	
	public void login() throws IOException
	{
		LoginPage login=new LoginPage(driver);
		  ExcelUtility excel=new ExcelUtility();
		  login=new LoginPage(driver);
		  login.clearDetails();
		  login.login(excel.readStringData(1, 0), excel.readStringData(1, 1));
	}
	public void navigateToHomePage()
	{
		gu.clickCommand(home);
		
	}
	
	public void navigateToManageDeliverBoyPage()
	{
		gu.clickCommand(manageDeiverBoyLink);
	}
	
	public void navigateToManageNewsPage()
	{
		gu.clickCommand(manageNewsLink);
	}
	
	
	public void navigateToManageUser()
	{
		gu.clickCommand(manageUserLink);
	}
	
	public void navigateToManageOrder()
	{
		gu.clickCommand(manageOrderLink);
		
	}
	
	public void navigateToManageLocation()
	{
		gu.clickCommand(manageLocationLink);
		
	}
	public String getUserTitle()
	{
	 String title=gu.getText(userTitle);
	 return title;
	}
	public String getOrderTitle()
	{
	 String title=gu.getText(orderTitle);
	 return title;
	}
	public String getDeliveryBoyPageTitle()
	{
	 String title=gu.getText(deliveryBoyPageTitle);
	 return title;
	}
	public String getLocationPageTitle()
	{
	 String title=gu.getText(LocationPageTitle);
	 return title;
	}
	
	
	public	HomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
	 }
	
}
