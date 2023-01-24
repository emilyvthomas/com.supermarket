package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.MobileSliderPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.FileUploadUtility;
import com.supermarket.utilities.GeneralUtilities;

public class MobileSliderTest extends BaseClass{
	GeneralUtilities general;
	ExcelUtility excel;
	LoginPage loginp;
	FileUploadUtility filepload;
	MobileSliderPage mbsldr;
	HomePage hmObj;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	
@Test(description="Validate new Item created",priority=0,enabled=true)	
  public void createnewItem() throws Exception {
	 excel=new ExcelUtility();
     loginp=new LoginPage(driver);
     hmObj=new HomePage(driver);
     loginp.login(excel.readStringData(1, 0), excel.readStringData(1, 1));
     mbsldr=new MobileSliderPage(driver);
     mbsldr.create();
     general=new GeneralUtilities();
     general.selectByVisibleText(mbsldr.categorydrop, Constants.catchangedrop);
     filepload=new FileUploadUtility();
     filepload.uploadFile(mbsldr.choosefiledrop,Constants.path);
     general.clickCommand(mbsldr.savebtn);
         Assert.assertTrue(mbsldr.isalertmsgDisplayed());
	  
     }

@Test(description="Validate edit Item",priority=1) 
   public void editItem() throws Exception {
	   mbsldr=new MobileSliderPage(driver);
	   mbsldr.edit();
	   Assert.assertTrue(mbsldr.iseditalertmsgDisplayed());
		 }
@Test(description="validate delete Item",priority=2)   
   public void deleteItem() {
	mbsldr=new MobileSliderPage(driver);
	mbsldr.delete();

	Assert.assertTrue(mbsldr.isdeletealertmsgDisplayed());
	 
}


}


