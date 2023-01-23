package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;
import com.supermarket.pages.ManageUserPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class ManageUserTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	WebDriver diver;
	GeneralUtilities general;
	ExcelUtility excel;
	LoginPage login;
	ManageUserPage muser;
	HomePage hmobj;
	@Test(description="navigate to manage user",priority=0)
	   public void manageUserClick() throws IOException, InterruptedException {

		login=new LoginPage(driver);
		hmobj=new HomePage(driver);	  
		login.login(excel.readStringData(1, 0), excel.readStringData(1, 1));
		muser=new ManageUserPage(driver);
		hmobj.navigateToManageUser();
		Assert.assertEquals(hmobj.getUserTitle(),Constants.title2);
	}
	
@Test(description="search manage user",enabled=true,priority=1)
	public void search() throws IOException, InterruptedException {

	login=new LoginPage(driver);
	hmobj=new HomePage(driver);	  
	muser=new ManageUserPage(driver);
	general=new GeneralUtilities();
	String val=muser.searchuser();
	Assert.assertEquals(val,Constants.searchmanageuser);
	
	
}
@Test(description="Change Active Status of User",enabled=true,priority=2)
	public void changeUserActive() throws IOException, InterruptedException {
	
	muser=new ManageUserPage(driver);
	Assert.assertEquals(muser.changeUserActive(),Constants.manageuserstatus);
	
	
}

@Test(description="Change InActive Status of User",enabled=true,priority=3)
public void changeUserInActive() throws IOException, InterruptedException {

muser=new ManageUserPage(driver);
Assert.assertEquals(muser.changeUserInActive(),Constants.manageuserstatus1);


}
@Test(description="View the password",enabled=true,priority=4)
  	public void passwordValidation() {
	muser=new ManageUserPage(driver);
	Assert.assertEquals(muser.passwordView(), Constants.passwordtext);
	
}
@Test(description="delete the manage user details",enabled=false)
public void deleteUser() throws IOException, Exception {
	  
	  muser=new ManageUserPage(driver);
	  muser.deleteUser();
	  Assert.assertTrue(muser.isDisplayed());
		
} 
@Test(description="navigate to DashBoard",priority=6)
public void navigateBackToHome()
	{
	 muser.backToHomePage();
	 Assert.assertTrue(login.isDisplayedDashboard());
	}	

}
