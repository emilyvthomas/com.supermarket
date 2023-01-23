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
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class ManageDeliveryBoyTest extends BaseClass{
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	ManageDeliveryBoyPage mdobj;
	LoginPage lpObj;
	HomePage hmObj;
	ExcelUtility exobj=new ExcelUtility();
	GeneralUtilities general;
	
 @Test(description="navigate to delivery boyPage",priority=0)
 public void manageDeliveryLinkClick() throws IOException
  {
	  lpObj=new LoginPage(driver);
	  hmObj=new HomePage(driver);
	  mdobj=new ManageDeliveryBoyPage(driver);
	  
	  lpObj.login(exobj.readStringData(1, 0), exobj.readStringData(1, 1));
	  hmObj.navigateToManageDeliverBoyPage();
	  Assert.assertEquals(hmObj.getDeliveryBoyPageTitle(),Constants.title1);
	 
  }
 @Test(description="create new deliveryboy",priority=1)
 public void addDeliveryBoy() throws IOException, Exception {
	  lpObj=new LoginPage(driver);
	  hmObj=new HomePage(driver);
	  mdobj=new ManageDeliveryBoyPage(driver);
	  general=new GeneralUtilities();
	  mdobj.addDeliveryBoyDetails();
     
      general.scrollUptoDown(driver);
      Thread.sleep(2000);
	  Assert.assertEquals(mdobj.saveDetails(),Constants.newdeliverboy);
	 
	  
  }
 @Test(priority=2,enabled =false)
 public void cancelDetails() throws IOException, Exception {
	  lpObj=new LoginPage(driver);
	  hmObj=new HomePage(driver);
	  mdobj=new ManageDeliveryBoyPage(driver);

  }
	
 @Test(description="search deliveryboy",priority=2)
 public void searchDeliveryBoy() throws IOException, Exception {
	  
	  mdobj=new ManageDeliveryBoyPage(driver);
	  Assert.assertEquals(mdobj.searchDeliveryBoy(),Constants.newdeliverboy);
		 
  
}
 @Test(description="edit the deliveryboy",priority=3)
 public void editDeliveryBoy() throws IOException, Exception {
	  
	  mdobj=new ManageDeliveryBoyPage(driver);
	  Assert.assertEquals(mdobj.editDeliveryBoyDetails(),Constants.updatemsg);
		  
}
 @Test(description="delete the deliveryboy details",priority=4)
 public void deleteDeliveryBoy() throws IOException, Exception {
	  
	  mdobj=new ManageDeliveryBoyPage(driver);
	  mdobj.deleteDeliveryBoy();
	  Assert.assertTrue(mdobj.isDisplayed());
		
} 
 @Test(description="navigate to DashBoard",priority=5)
public void navigateBackToHome()
	{
	 mdobj.backToHomePage();
	 Assert.assertTrue(lpObj.isDisplayedDashboard());
	}
}
