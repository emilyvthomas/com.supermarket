package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUserPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class HomeTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	WebDriver diver;
	GeneralUtilities general;
	ExcelUtility excel;
	LoginPage login;
	ManageUserPage muser;
	HomePage hmobj;
  @Test(description="navigate To Manage DeliverBoy Page",groups="sanity")
  public void navigateToManageDeliverBoy() throws IOException {
	 
	  hmobj=new HomePage(driver);
	  hmobj.login();
	  hmobj.navigateToManageDeliverBoyPage();
	  Assert.assertEquals(hmobj.getDeliveryBoyPageTitle(), Constants.title1);
	  hmobj.navigateToHomePage();
  }
  @Test(description="navigate To Manage User Page",groups="sanity",enabled=false)
  public void navigateToManageUser() {
	  
	  hmobj=new HomePage(driver);
	  
	  hmobj.navigateToManageUser();
	 // Assert.assertEquals(hmobj.navigateToManageUser(), Constants.title2);
	  Assert.assertEquals(hmobj.getUserTitle(), Constants.title2);
	 hmobj.navigateToHomePage();
  }
  @Test(description="navigate To Manage Order Page",groups="sanity",enabled=false)
  public void navigateToManageOrder() {
	  hmobj=new HomePage(driver);
	  hmobj.navigateToManageOrder();;
	 // Assert.assertEquals(hmobj.navigateToManageOrder(), Constants.title3);
	  Assert.assertEquals(hmobj.getOrderTitle(),Constants.title3);
	  hmobj.navigateToHomePage();
		 
  }
  @Test(description="navigate To Manage Location Page",groups="sanity")
  public void navigateToManageLocation() {
	  hmobj=new HomePage(driver);
	  hmobj.navigateToManageLocation();;
	 
	  Assert.assertEquals(hmobj.getLocationPageTitle(),Constants.title4);
	  hmobj.navigateToHomePage();
		 
  }
  
}
