package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/div[1]/p[1]")
	WebElement registerPageTitle;
	@FindBy(id="user_login")
	WebElement usernameField;
	@FindBy(id="user_email")
	WebElement emailField;
	@FindBy(id="wp-submit")
	WebElement registerButton;
	@FindBy(linkText="Log in")
	WebElement goToLogInPageButton;
	@FindBy(linkText="Lost your password?")
	WebElement lostYourPasswordButton;
	@FindBy(id="backtoblog")
	WebElement backToHome;
	@FindBy(className="aiowps-captcha-equation")
	WebElement getDigits;
	@FindBy(id="login_error")
	WebElement error;
	
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public String getRegisterPageTitle(){
		return registerPageTitle.getText();
	}
	public void chooseUsername(String username){
		usernameField.sendKeys(username);
	}
	public void enterEmail(String email){
		emailField.sendKeys(email);
	}
	public void enterAnswer(String answer){
		getDigits.sendKeys(answer);
	}
	public void register(String username, String email, String answer){
		this.chooseUsername(username);
		this.enterEmail(email);
		this.enterAnswer(answer);
		registerButton.click();
	}
	public String getDigits(){
		return getDigits.getText();
	}
	public void goToHomePage(){
		backToHome.click();
	}
	public void goLostPasswordPage(){
		lostYourPasswordButton.click();
	}
	public void goLogInPage(){
		goToLogInPageButton.click();
	}
	public String getRegisterErrorMessage(){
		return error.getText();
	}
	
}
