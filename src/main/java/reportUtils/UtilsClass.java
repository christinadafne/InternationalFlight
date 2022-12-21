package reportUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilsClass {
	public static WebDriver driver;
	public static String brows,url,password,uemail;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static String loca;
	public static ITestResult result;
	
	public void reportsetup() {
	 spark=new ExtentSparkReporter("flight.html");
		 extent= new ExtentReports();
		  extent.attachReporter(spark);
		  

	}
	public void reportclose() {
		extent.flush();

	}
	
	public WebDriver browserlaunch(String browser ) {
		
		switch(brows)
		{
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			
			 driver=new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 driver.get(url);
			 //Thread.sleep(2000);
			 break;
		case "firefox":	
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 driver.get(url);
			 break;
			
		case "safari":
			driver=new SafariDriver();
			 driver.get(url);
			break;
			
		}
		
		return driver;
		

	}
	public boolean check_enabled(WebElement element,String id)
	{
		if(element.isEnabled())
		{
			
			test.log(Status.PASS,id + " is enabled");
			test.addScreenCaptureFromPath(screenshot(id));
			
			return true;
			
		}
		else 
		{
			test.log(Status.FAIL,id + " is not enabled");
			test.log(Status.INFO, result.getThrowable());
			test.addScreenCaptureFromPath(screenshot(id));
			return false;
		}
	}
	
	public void browserclose() {
		driver.close();

	}
		
	
		
			
	

	public String property(String input) {
		try {
		
		String loc=System.getProperty("user.dir")+"/config.properties";
		
		Properties prop =new Properties();
		FileInputStream file=new FileInputStream(loc);
		prop.load(file);
	 brows=prop.getProperty(input);
		 url=prop.getProperty("url");
	uemail=prop.getProperty("email");
	 password=prop.getProperty("password");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return brows;
	}
	
	
	public void validateresults(String page,String actual,String expect) {
		try {
			Assert.assertEquals(expect, actual);
			
			test.log(Status.PASS,page + " successful");
			test.addScreenCaptureFromPath(screenshot(page));
		
			System.out.println(page + " successful");
		}
		catch(Exception e)
		{
			System.out.println(page + " failed ");
			test.log(Status.FAIL,"validation failed");
			test.log(Status.INFO,result.getThrowable());
			test.addScreenCaptureFromPath(screenshot(page));
		}
		
	}
		
	public void inputvalue(WebElement ele,String value,String text) {
		try {
			
				ele.sendKeys(value);
				test.log(Status.PASS, text+" entered");
		
		 
		}
		catch(Exception e)
		{
		test.log(Status.FAIL,text+" not entered");
			System.out.println("Error occured"+e.getMessage());
		}
	
	}
	public void buttonclick(WebElement ele,String id) {
		
		try 
		{
			
			ele.click();
			
			test.log(Status.PASS, id+" button clicked");
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, id+" botton not clicked"+result.getThrowable());
		
		}
		

	}
	public String screenshot(String test_name) {
		
		try {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		loca="/Users/tina/Desktop/screenshot/"+test_name+".png";
	  File dest=new File(loca);
		FileUtils.copyFile(source, dest);
		return loca;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return loca;

	}
	public void capture(ITestResult result) {
	
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshot(result.getTestName()));
		
		}
		
	}
	public boolean wait_element(WebElement element,String id)
	{
		boolean flag=true;
		try
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		test.log(Status.PASS, id+ "is visible");
		flag=true;
	}
		catch(Exception e) {
			test.log(Status.FAIL, id+"is not visible");
			test.addScreenCaptureFromPath(screenshot(id),"element not present");
			flag=false;
		}
		
		return flag;
		
	}
	public Timeouts implicit_wait()
	{
		
			return driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		
	}
	
	  
	


}
