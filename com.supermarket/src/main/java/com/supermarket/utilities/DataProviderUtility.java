package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

@DataProvider(name="loginData")
	  public Object[][] getData() {
	    return new Object[][] {
	      new Object[] { "user", "user" },
	      new Object[] { "user1", "user1" },
	    };
	  }
	  
	
}
