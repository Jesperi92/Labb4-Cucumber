package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamplePage extends Menu{
	WebDriver driver;
	@FindBy(linkText="Register")
	WebElement registerButton;
	@FindBy(linkText="Log in")
	WebElement logInButton;
	@FindBy(className="entry-title")
	WebElement title;
	public SamplePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void goToRegisterPage(){
		registerButton.click();
	}
	public void goToLogInPage(){
		logInButton.click();
	}
	public String getSamplePageTitle(){
		return title.getText();
	}
}
