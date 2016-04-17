package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;
	@FindBy(id="user_login")
	WebElement usernameField;
	@FindBy(id="user_pass")
	WebElement passwordField;
	@FindBy(id="rememberme")
	WebElement rememberMe;
	@FindBy(id="wp-submit")
	WebElement logInButton;
	@FindBy(linkText="Lost your password?")
	WebElement lostYourPasswordButton;
	@FindBy(id="backtoblog")
	WebElement backToHome;
	@FindBy(linkText="Register")
	WebElement goToRegisterPageButton;
	@FindBy(id="login_error")
	WebElement error;
	
	public LogInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
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
		logInButton.click();
	}
	public void goToHomePage(){
		backToHome.click();
	}
	public void goLostPasswordPage(){
		lostYourPasswordButton.click();
	}
	public void goToRegisterPage(){
		goToRegisterPageButton.click();
	}
	public String getLogInErrorMessage(){
		return error.getText();
	}

}
