package com.supermarket.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities {

WebDriver driver;
public WebDriver browserLaunch(String url,String browser)
{
	if(browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
	}
	else
	{
		System.out.println("Invalid Browser!!!!!!!!Please check the browser you have entered");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	
	return driver;
	
}
public void clickCommand(WebElement element)
{
	element.click();
	
}
public void clearCommand(WebElement element)
{
	element.clear();
	
}
public void sendkeysCommand(WebElement element,String text)
{
	element.sendKeys(text);
	
}
public void moveToElemnet(WebElement element,WebDriver driver)
{
	Actions obj=new Actions(driver);
	obj.moveToElement(element).perform();
}
public String getText(WebElement element)
{
	return element.getText();
	
}
public String getPageTitle() 
{
	return driver.getTitle();
}
public void takeScreenshot(WebDriver driver,String methodname) throws IOException
{
	Date d=new Date();
    String date=d.toString().replace(":", "_").replace(" ", "_");
	TakesScreenshot ts=(TakesScreenshot) driver;
	File sourceFile=ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(sourceFile, new File("./Screenshot/"+methodname+"_"+date+".jpg"));
	 
}
public void alertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();

}
public void alertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();

}

public void navigateBack(WebDriver driver)
{
	driver.navigate().back();

}

public void navigateRefresh(WebDriver driver)
{
	driver.navigate().refresh();

}
public void navigateForward(WebDriver driver)
{
	driver.navigate().forward();

}
public void selectByVisibleText(WebElement element,String text)
{
	Select obj=new Select(element);
	obj.selectByVisibleText(text);
}

public void selectByValue(WebElement element,String text)
{
	Select obj=new Select(element);
	obj.selectByValue(text);
}

public void selectByIndex(WebElement element,int text)
{
	Select obj=new Select(element);
	obj.selectByIndex(0);
}

public void simpleAlerts(WebDriver driver) {
	  
	  Alert alert=driver.switchTo().alert();
	  alert.accept();

}
public boolean dynamicWebTableData(List<WebElement> colval,String value)
{
	boolean status=false;
	for(WebElement element:colval)
	{
		String value1=element.getText();
		if(value1.contains(value))
		{
			status=true;
			break;
		}
	}
		
	
	
	
	return status;
	
}
public void scrollUp(WebDriver driver) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1000)");
}
public void scrollUptoDown(WebDriver driver) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
}

}