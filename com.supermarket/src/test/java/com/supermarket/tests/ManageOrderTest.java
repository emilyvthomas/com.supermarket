package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;
import com.supermarket.pages.ManageOrderPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class ManageOrderTest extends BaseClass{
  		GeneralUtilities general;
		LoginPage loginp;
		HomePage hmObj;
		ExcelUtility excel;
		ManageOrderPage mpage;
			
		
	@Test(description="validation of view order",priority=0)	
	public void viewOrder() throws IOException {
		ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
		loginp=new LoginPage(driver);
		hmObj=new HomePage(driver);
		mpage=new ManageOrderPage(driver);	  
	    loginp.login(excel.readStringData(1, 0), excel.readStringData(1, 1));
		mpage=new ManageOrderPage(driver);
		mpage.manageOrder();
		  

	}

	@Test(description="validation of scroll bar",priority=4)
	public void ScrollUpAndDown() throws Exception 
	{
		loginp=new LoginPage(driver);
		hmObj=new HomePage(driver);
		mpage=new ManageOrderPage(driver);
		general=new GeneralUtilities();
		general.scrollUptoDown(driver);
		
	}
	
	@Test(description="validate the change status",priority=1)
	public void updateStatus() throws Exception 
	{
	Thread.sleep(3000);
	mpage=new ManageOrderPage(driver);
	//mpage.changeStatus();
	Assert.assertEquals(mpage.changeStatus(),Constants.changestatusdropdown);
	
	
	
	
	}
	
	@Test(description="validate the assign delivery boy",priority=2)
	public void assignDeliveryBoy() throws Exception 
	{
	Thread.sleep(3000);
	mpage=new ManageOrderPage(driver);
    mpage.assignDeliveryBoy();
	Assert.assertTrue(mpage.isalertDisplayed());
	
	
	
	
	}
	@Test(description="validate the Search Order",priority=3)
	public void searchOrder() throws IOException
	{
		mpage=new ManageOrderPage(driver);
		Assert.assertEquals(mpage.searchOrder(),Constants.searchorder);
		
	}
 

	@Test(description="Delete Order",priority=4,enabled=false)
	public void deleteOrder()
	{
		mpage=new ManageOrderPage(driver);
		
	
	}
	@Test(description="navigate to DashBoard",priority=5)
	public void navigateBackToHome()
	{
		mpage.navigateBackHome();
		Assert.assertTrue(loginp.isDisplayedDashboard());
	}

	
}