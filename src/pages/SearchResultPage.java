package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultPage extends Menu {
	WebDriver driver;
	@FindBy(className="entry-title")
	WebElement title;
	@FindBy(className="productcol")
	List<WebElement> products;
	@FindBy(linkText="Register")
	WebElement registerButton;
	@FindBy(linkText="Log in")
	WebElement logInButton;
	@FindBy(className="go_to_checkout")
	WebElement goToCheckoutButton;
	@FindBy(className="continue_shopping")
	WebElement continueShoppingButton;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/p")
	WebElement content;
	@FindBy(className="prodtitle")
	WebElement searchResult;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public String getSearchResultPageTitle(){
		return title.getText();
	}
	public String getNoMatchMessage(){
		return content.getText();
	}
	public void goToProduct(String productName){
		 for (WebElement product : products){
			 if(product.findElement(By.className("wpsc_product_title")).getText().equals(productName)){
				 product.findElement(By.className("wpsc_product_title")).click();
				 break;
			 }
			 
		 }
	}
	public void goToRegisterPage(){
		registerButton.click();
	}
	public void goToLogInPage(){
		logInButton.click();
	}
	public void addToCart(String productName){
		for (WebElement product : products){
			 if(product.getText().contains(productName)){
				 product.findElement(By.className("wpsc_buy_button")).click();
				 break;
			 }
		}
		
	}
	public void goToCartOrContinueShopping(boolean continueShopping){
		if(continueShopping)
			continueShoppingButton.click();
		
		else
			goToCheckoutButton.click();
	}
	public String getSearchResult(){
		return searchResult.getText();
	}
}
