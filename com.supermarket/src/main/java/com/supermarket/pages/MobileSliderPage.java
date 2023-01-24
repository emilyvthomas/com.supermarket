package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.FileUploadUtility;
import com.supermarket.utilities.GeneralUtilities;

public class MobileSliderPage {

	WebDriver driver;
	GeneralUtilities general=new GeneralUtilities();
	FileUploadUtility filepload=new FileUploadUtility() ;
	
	
@FindBy(xpath="//i[@class='nav-icon fas fa-window-minimize']")	
WebElement mobileslider;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")	
WebElement newbtn;
@FindBy(xpath="//select[@class='form-control selectpicker']")
public	
WebElement categorydrop;	
@FindBy(xpath="//input[@name='main_img']")
public	
WebElement choosefiledrop;
@FindBy(xpath="//button[@name='create']")
public	
WebElement savebtn;
@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
public	
WebElement cancelbtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement alertmsg;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")	
WebElement editbtn;
@FindBy(xpath="//button[@name='update']")
public	
WebElement updatebtn;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss'][1]")	
WebElement deletebtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
public
WebElement editalertmsg;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
public
WebElement deletealertmsg;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
WebElement home;

  public void create() {
	  general.clickCommand(mobileslider);
	  general.clickCommand(newbtn);
  }

  public void edit() {
	    driver.navigate().back();
	  general.clickCommand(cancelbtn);
	  general.clickCommand(editbtn);
	    general.selectByVisibleText(categorydrop, Constants.catchangedrop);
       filepload.uploadFile(choosefiledrop,Constants.path);
	   general.clickCommand(updatebtn);
	  
  }
  
  public String delete() {
	  general.clickCommand(deletebtn);
	  general.alertAccept(driver);
		String deleteValue=general.getText(deletealertmsg);
		return deleteValue;
  }
  public boolean isalertmsgDisplayed()
	{
	Boolean val=alertmsg.isDisplayed();
	return val;
	}
  public boolean isdeletealertmsgDisplayed()
	{
	Boolean val=deletealertmsg.isDisplayed();
	return val;
	}
  
  public boolean iseditalertmsgDisplayed()
 	{
 	Boolean val=editalertmsg.isDisplayed();
 	return val;
 	}
   public MobileSliderPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }



	
}
