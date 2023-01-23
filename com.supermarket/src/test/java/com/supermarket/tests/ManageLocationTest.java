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
import com.supermarket.pages.ManageLocationPage;
import com.supermarket.pages.ManageOrderPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class ManageLocationTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
		WebDriver diver;
		GeneralUtilities general;
		ExcelUtility excel;
		LoginPage login;
		ManageLocationPage mloc;
		HomePage hmobj;
		
	@Test(description="create new location",enabled=true,priority=0)	
		public void createNewLocation() throws Exception  {
			excel=new ExcelUtility();
			login=new LoginPage(driver);
		    mloc=new ManageLocationPage(driver);
			 login.login(excel.readStringData(1, 0), excel.readStringData(1, 1));
			 mloc.createNew();
			 general=new GeneralUtilities();
			 general.selectByVisibleText(mloc.countrydrop, Constants.countrydrop);
			 general.selectByVisibleText(mloc.statedrop, Constants.statedrop);
			 Assert.assertEquals(mloc.locationAndDeliverdata(), Constants.locationalertsuccess);
	}
	@Test(description="search the location",priority=1)
	   public void searchLocation() throws Exception {
		  excel=new ExcelUtility();
		  general=new GeneralUtilities();
		  mloc=new ManageLocationPage(driver);
	    Assert.assertEquals(mloc.searchLocation(), Constants.searchlocation);
		
	}
	@Test(description="edit the location",enabled=true,priority=2)
	   public void editlocationdetails() throws Exception{
		excel=new ExcelUtility();
	    mloc=new ManageLocationPage(driver);
	    general=new GeneralUtilities();
	    mloc.edit();
	    Assert.assertTrue(mloc.isDisplayed());
		
	}

	@Test(description="the delete item",enabled=true,priority=3)   
	    public void delete() {
	       mloc=new ManageLocationPage(driver);
	       Assert.assertTrue(mloc.isdeletealertDisplayed());
			
	}

	}
