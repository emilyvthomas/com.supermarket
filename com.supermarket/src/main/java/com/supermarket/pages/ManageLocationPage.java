package com.supermarket.pages;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;


public class ManageLocationPage {

      WebDriver driver;
      GeneralUtilities gu=new GeneralUtilities();
      ExcelUtility excel=new ExcelUtility();
@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
WebElement manageloc;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
WebElement newbtn;
@FindBy(xpath="//select[@name='country_id']")     
public
WebElement countrydrop;
@FindBy(xpath="//select[@name='state_id']")
public
WebElement statedrop;
@FindBy(xpath="//input[@name='location']")
WebElement location;
@FindBy(xpath="//input[@name='delivery']")
WebElement delivery;
@FindBy(xpath="//button[@name='create']")
WebElement savebtn;
@FindBy(xpath="//button[@class='close']")
public
WebElement alertclose;
@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
public
WebElement cancelbtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement alerttext;

@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
public
WebElement editbtn;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss'][1]")
WebElement deletebtn;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
WebElement searchbtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement editalert;
@FindBy(xpath="//button[@class='btn btn-danger']")
WebElement updatebtn;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
public
WebElement search;
@FindBy(xpath="//input[@name='location']")
WebElement locationinput;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
WebElement newlocation;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td")
List<WebElement> cElement;
String tPath="//table[@class='table table-bordered table-hover table-sm']/tbody";
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
WebElement seacrhbtn;
@FindBy(xpath="//button[@name='Search']")
WebElement searchbtnclick;
//a[@class='btn btn-sm btn btn-danger btncss']
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
WebElement delete;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement deletealert;
@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
public
WebElement resetsearch;


    public void createNew() {
    	
    	gu.clickCommand(manageloc);
    	gu.clickCommand(newbtn);

          }
     public String locationAndDeliverdata() throws Exception {
    	 
    	 gu.sendkeysCommand(location, excel.readStringData(32, 1));
    	 gu.sendkeysCommand(delivery, excel.readIntegerData(33, 1));
    	 Thread.sleep(2000);
    	 gu.clickCommand(savebtn);
    	 String val=gu.getText(alerttext);
    	 driver.navigate().back();
    	 return val;

          }
     public String edit() throws InterruptedException, IOException {
    	 
    	 
    	 gu.clickCommand(editbtn);
    	 gu.clearCommand(location);
    	 gu.sendkeysCommand(location, excel.readStringData(34, 1));
    	 gu.clearCommand(delivery);
    	 gu.sendkeysCommand(delivery,excel.readIntegerData(35, 1));
    	 gu.scrollUptoDown(driver);
    	 Thread.sleep(2000);
    	 gu.clickCommand(updatebtn);
    	 return gu.getText(editalert);
	 
     }
     public boolean isDisplayed()
 	{
 	Boolean val=editalert.isDisplayed();
 	return val;
 	}
     
     public String searchLocation() throws Exception {
    	 
    	 driver.navigate().back();
    	 gu.clickCommand(searchbtn);
    	 gu.sendkeysCommand(locationinput, excel.readStringData(34, 1));
    	 gu.clickCommand(searchbtnclick);
    	 Thread.sleep(1000);
    	 return gu.getText(newlocation);
    	 

  	}
  	public String deleteItem() {
  		gu.alertAccept(driver);
  		return gu.getText(deletealert);
  	}
  	 public boolean isdeletealertDisplayed()
  	{
  	Boolean val=deletealert.isDisplayed();
  	driver.navigate().refresh();
  	return val;
  	}
 	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
 	
 		
 	}

