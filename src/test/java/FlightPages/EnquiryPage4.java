package FlightPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basesetup.BaseSetup;



public class EnquiryPage4 extends BaseSetup {

	@FindBy(xpath="//div[text()='View Itinerary'][1]")
	WebElement view;
	
	@FindBy(xpath="//button[text()='SEND ENQUIRY']")
	WebElement enquiry;
	
	public EnquiryPage4()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendequiry() {
		buttonclick(view,"view");
		String actual=enquiry.getText();
		String expect="SEND ENQUIRY all";
		validateresults("enquiry page " , actual, expect);
		
	}
}
