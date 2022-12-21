package FlightPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basesetup.BaseSetup;



public class DateSelect3 extends BaseSetup{
	@FindBy(xpath="//input[@class='form-control']")
	WebElement date;
	
	@FindBy(id="themes")
	WebElement holidaytype;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement searchpackage;
	
	@FindBy(xpath="//h1[text()='Canada  Tour Packages']")
	WebElement title;
	
	
	public DateSelect3()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dateselection() {
		inputvalue(date, "25/12/2022","date entered");
		
		Select opt1=new Select(holidaytype);
		opt1.selectByIndex(4);
		buttonclick(searchpackage,"search");
		String actualtitle=title.getText();
		 String expectltitle="Canada Tour Packages";
		 validateresults("Date selection page  ",expectltitle,actualtitle);
	}
	
}
