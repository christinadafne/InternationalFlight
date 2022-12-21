package FlightPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basesetup.BaseSetup;

public class LoginPage extends BaseSetup{
	
	@FindBy(linkText="Customer Login")
	WebElement customer;
	
	@FindBy(linkText="User Login")
	WebElement userlogin;
	
	@FindBy(id="sign_user_email")
	WebElement email;
	
	@FindBy(id="sign_user_password")
	WebElement pass;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary modal-btn ajax-submit']")
	WebElement login;
	
	@FindBy(xpath="//h3[text()='Sign in to Mercury Travel Securely']")
	WebElement popup_title;
	
	@FindBy(partialLinkText="Welcome")
	WebElement welcometext;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void login_fuctionality() throws Exception
	{
		
		implicit_wait();
		//Thread.sleep(5000);
		Actions act=new Actions(driver);
		//Thread.sleep(8000);
		 act.moveToElement(customer).build().perform();
				 
		 act.moveToElement(userlogin).click().build().perform();
		
		 //email.sendKeys("admintest@test.com");
		 String title="Sign in to Mercury Travel Securely";
		 Thread.sleep(3000);
		 //implicit_wait();
		 String titledisp = popup_title.getText();
		 String emailid=uemail;
		 
		 validateresults("login page loaded",titledisp ,title);
		 
		 
		 inputvalue(email, emailid,"email id entered");//"admintest@test.com");
		 
		 inputvalue(pass,password,"password entered");
		 buttonclick(login,"login");
		 check_enabled(login, "submit button");
		 String login_title=welcometext.getText();
		 String hometitle="Welcome, Admin";
		 validateresults("signed in ",hometitle,login_title);
		 
	}

	public WebElement getCustomer() {
		return customer;
	}

	public WebElement getUserlogin() {
		return userlogin;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getPopup_title() {
		return popup_title;
	}

	public WebElement getWelcometext() {
		return welcometext;
	}
	
	
}



