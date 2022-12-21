package FlightPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basesetup.BaseSetup;



public class BookingPage2 extends BaseSetup {

	@FindBy(linkText = "International Holidays")
	WebElement international;

	@FindBy(id = "holiday_category_d")
	WebElement destination;

	@FindBy(xpath = "//li[@class='ui-menu-item']//a[1]")
	WebElement firstoptn;

	@FindBy(id = "duration_d")
	WebElement duration;

	@FindBy(xpath = "//div[@class='searchBtncntr']//button[@type='submit']")
	WebElement search;
	
	@FindBy(xpath="//h1[text()='Canada  Tour Packages']")
	WebElement title;
	public BookingPage2() {
		PageFactory.initElements(driver, this);
	}

	public void booking_functionality() throws Exception {
		buttonclick(international,"international");
		inputvalue(destination, "canada","destination canada");
		buttonclick(firstoptn,"firstoption");
		Thread.sleep(2000);
		Select opt = new Select(duration);
		opt.selectByIndex(4);
		buttonclick(search,"search");
		 String actualtitle=title.getText();
		 String expectltitle="Canada Tour Packages";
		 validateresults("Booking page  ",expectltitle,actualtitle);
		 
		
	}
}
