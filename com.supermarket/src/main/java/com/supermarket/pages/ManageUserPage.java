package com.supermarket.pages;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;


public class ManageUserPage {
	WebDriver driver;
	GeneralUtilities general=new GeneralUtilities();
    ExcelUtility excel=new ExcelUtility();
	WaitUtility wait =new WaitUtility();
	@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
	WebElement manageuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath="//input[@name='un']")
	WebElement name;
	@FindBy(xpath="//input[@name='ut']")
	WebElement email;
	@FindBy(xpath="//input[@name='ph']")
	WebElement phno;
	@FindBy(xpath="//select[@name='st']")
	public
	WebElement status;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	public
	WebElement searchbtn;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	public
	WebElement resetbtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	List<WebElement> rElement;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td")
	List<WebElement> cElement;
	String tPath="//table[@class='table table-bordered table-hover table-sm']/tbody";
	@FindBy(xpath="//i[@class='fa fa-angle-double-down'][1]")
	WebElement passwordbtn;
	@FindBy(xpath="//div[@class='profile-info-name'][1]")
	WebElement passworddisplay;
	@FindBy(xpath="//span[@class='badge bg-success']")
	WebElement activebtn;
	@FindBy(xpath="//span[@class='badge bg-warning']")
	WebElement inactivebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-success btncss']")
	WebElement statuschangebtn;
	@FindBy(xpath="//button[@class='close']")
	WebElement alertclosebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg1;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deletebtn;
	//a[@class='btn btn-sm btn btn-danger btncss']
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteuseralert;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement home;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user']")
	WebElement moreinfo;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement searchuser;
	
	public void navigateToManageUser()
	{
		moreinfo.click();
	}
	public String searchuser() throws InterruptedException, IOException{
		
		general.clickCommand(search);
		general.sendkeysCommand(name, excel.readStringData(11, 1));
		wait.explicitWait(driver);
		String val=general.getText(searchuser);
		return val;
}

   public String passwordView() {
	   
	   general.clickCommand(passwordbtn);
	   return general.getText(passworddisplay);
   
   }
 public String changeUserActive()
 {
	 general.clickCommand(inactivebtn);
	 String status=general.getText(activebtn);
	 return status;

	 
	 
 }
 public String changeUserInActive()
 {
	 general.clickCommand(activebtn);
	 String status=general.getText(inactivebtn);
	 return status;
	 
 
 }
 
 public String deleteUser()
 {
	 general.clickCommand(deletebtn);
	 general.alertAccept(driver);
	 	String deleteValue=general.getText(deleteuseralert);
		return deleteValue;
 }
 public boolean isDisplayed()
	{
	Boolean val=deleteuseralert.isDisplayed();
	return val;
	}
 public void backToHomePage()
 {
		general.clickCommand(home);
	}

	public ManageUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
}
