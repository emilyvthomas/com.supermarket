package com.supermarket.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;



public class ManageOrderPage {
	WebDriver driver;
	GeneralUtilities general=new GeneralUtilities();;
	ExcelUtility exobj=new ExcelUtility();
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-basket']")
	WebElement manageorder;
	@FindBy(xpath="//a[@class='btn btn-block btn-outline-info btn-sm']")
	WebElement view;
	@FindBy(xpath="//div[@class='col text-left']")
	WebElement orederId;
	@FindBy(xpath="//a[@class='btn btn-success btn-sm'][1]")
	WebElement changestatus;
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement back;
	@FindBy(xpath="//select[@id='status']")
	public
	WebElement updatedrop;
	@FindBy(xpath="//select[@id='delivery_boy_id']")
	public
	WebElement updatedrop1;		
	@FindBy(xpath="//button[@name='Update_st'][1]")
	public
	WebElement updatebtn;
	
	@FindBy(xpath="//button[@class='btn btn-info' and @name='assign_del']")
	WebElement updatebtn1;
	@FindBy(xpath="//div[@class='col text-left']")
	WebElement textmessage;
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm'][1]")
	public
	WebElement changedeliverydate;
	@FindBy(xpath="//input[@class='jquery-datepicker__input datepicker1']")
	public
	WebElement deliverydate;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	public
	WebElement editbtn;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement home;
	
	@FindBy(xpath="//input[@id='od']")
	WebElement order;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchOrder;
	@FindBy(xpath="//button[@class='btn btn-default btn-fix']")
	WebElement resetOrder;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement searchvalue;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[6]/span[1]")
	WebElement Value;
	
	@FindBy(xpath="//a[@class='btn btn-warning btn-sm']")
	WebElement assigndeliveryboy;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
   public void manageOrder() {
	   
	   general.clickCommand(manageorder);
	   general.clickCommand(view);
	   general.clickCommand(back);
//	   manageorder.click();
//	   view.click();
//	   back.click();	
	  
   }
   public String changeStatus() throws IOException {
	   
	   general.clickCommand(changestatus);
	   general.selectByVisibleText(updatedrop,  exobj.readStringData(37, 1));
	   general.clickCommand(updatebtn);
	   driver.navigate().back();
	   String updateValue=general.getText(Value);
		return updateValue;
		
	   //changestatus.click();
   }
   public String assignDeliveryBoy() throws IOException
   {
	   general.clickCommand(assigndeliveryboy);
	   general.selectByVisibleText(updatedrop1, exobj.readStringData(48, 1));
	   general.clickCommand(updatebtn1);
	   String alert=general.getText(alertmsg);
		
	return alert;
	   
   }
   public boolean isalertDisplayed()
	{
	Boolean val=alertmsg.isDisplayed();
	return val;
	}
  
   public String searchOrder() throws IOException
   {
	   general.clickCommand(search);
	   general.sendkeysCommand(order, exobj.readIntegerData(47, 1));
	   general.clickCommand(searchOrder);
	 //  general.clickCommand(resetOrder);
//	   search.click();
//	   order.sendKeys("335");
//	   searchOrder.click();
//	   resetOrder.click();
	   general.scrollUptoDown(driver);
	   String searchValue=general.getText(searchvalue);
	   return searchValue;
	   
   }
   public void scroll()
   {
   	general.scrollUptoDown(driver);
   	//general.scrollUp(driver);
   	
   }
   public void navigateBackHome()
   {
	   general.clickCommand(home);;
   }
      
   
   public ManageOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


}
