package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Menu{
	WebDriver driver;
	@FindBy(className="entry-title")
	WebElement title;
	@FindBy(linkText="Register")
	WebElement registerButton;
	@FindBy(linkText="Log in")
	WebElement logInButton;
	@FindBy(id="log")
	WebElement usernameField;
	@FindBy(id="pwd")
	WebElement passwordField;
	@FindBy(id="rememberme")
	WebElement rememberMe;
	@FindBy(id="login")
	WebElement confirmLogIn;
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public String getMyAccountPageTitle(){
		return title.getText();
	}
	public void goToRegisterPage(){
		registerButton.click();
	}
	public void goToLogInPage(){
		logInButton.click();
	}
	public void enterUsername(String username){
		usernameField.sendKeys(username);
	}
	public void enterPassword(String password){
		passwordField.sendKeys(password);
	}
	public void checkInRememberMe(){
		rememberMe.click();
	}
	public void logIn(String username, String password){
		this.enterUsername(username);
		this.enterPassword(password);
		confirmLogIn.click();
	}

	
	

}
