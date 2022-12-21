package basesetup;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import FlightPages.LoginPage;
import reportUtils.UtilsClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class BaseSetup extends UtilsClass{
	
	
  
  @BeforeTest
  public void beforeTest() {
	  
	  browserlaunch(property("browser"));
  }
  

  @AfterTest
  public void afterTest() {
	  browserclose();
  }
  
  @AfterMethod
  public void testcloser(ITestResult result) {
	 
	  capture(result);
	
	
}
  

  @BeforeSuite
  public void beforeSuite() {
	  reportsetup();
	  
  }

  @AfterSuite
  public void afterSuite() {
	  reportclose();
  }

}
