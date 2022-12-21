package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FlightPages.BookingPage2;
import FlightPages.DateSelect3;
import FlightPages.EnquiryPage4;
import FlightPages.LoginPage;
import basesetup.BaseSetup;

import reportUtils.UtilsClass;

public class Flight_testcases extends BaseSetup {
	
	@Test(priority = 0)
	public void loginvalid() {
		try {
			 test=extent.createTest("loginvalid");
			
		LoginPage lp=new LoginPage();
		lp.login_fuctionality();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	  @Test(enabled = false) 
	  public void submit_butt()
	  { 
		  try {
		  
	  test=extent.createTest("check enabled");
	  
	  LoginPage lp=new LoginPage();
	  lp.login_fuctionality();
	  Assert.assertTrue(check_enabled(lp.getLogin(),"submit button"));
	  
	  } catch(Exception e) { e.printStackTrace(); } }
	 
		
	@Test(priority = 1)
	public void bookingvalid() throws Exception
	{
		try
		{
			test=extent.createTest("booking valid");
			
		BookingPage2 bp=new BookingPage2();
		bp.booking_functionality();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void datevalid() {
		try {
			test=extent.createTest("Date valid");
			
		DateSelect3 ds=new DateSelect3();
		ds.dateselection();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	 @Test(priority = 3,enabled = false)
	 public void enquiry()
	 {
		 try
		 {
			 test=extent.createTest("enquiry valid");
				
		 
		 EnquiryPage4 ep=new EnquiryPage4();
		 ep.sendequiry();
		 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	 }
	 

	

}
