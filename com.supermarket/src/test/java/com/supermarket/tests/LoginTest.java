package com.supermarket.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviderUtility;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.RetryAnalyzerUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPage lpobj;

  @Test(priority=2, retryAnalyzer=RetryAnalyzerUtility.class)
  public void loginwithvalidcredentials() throws IOException {
	ExcelUtility exobj=new ExcelUtility();
	lpobj=new LoginPage(driver);
	lpobj.clearDetails();
	lpobj.login(exobj.readStringData(1, 0), exobj.readStringData(1, 1));
	Assert.assertTrue(lpobj.isDisplayedDashboard());
	
	}
  
  @Test(dataProvider="loginData",dataProviderClass=DataProviderUtility.class,priority=1)
  public void loginWithInvalidCredentials(String username,String password) throws IOException {
	lpobj=new LoginPage(driver);
	lpobj.clearDetails();
	lpobj.login(username,password);
	
	
	Assert.assertEquals(lpobj.geterrorMessage(), Constants.expectedResult);
	  
  }
  
  


 
}
