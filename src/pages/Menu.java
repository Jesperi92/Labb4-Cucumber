package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {
	WebDriver driver;
	@FindBy(id="menu-item-15")
	WebElement homeButton;
	@FindBy(id="menu-item-33")
	WebElement catagoryButton;
	@FindBy(id="menu-item-72")
	WebElement allProductButton;
	@FindBy(id="menu-item-34")
	WebElement accessoriesButton;
	@FindBy(id="menu-item-35")
	WebElement imacsButton;
	@FindBy(id="menu-item-36")
	WebElement ipadsButton;
	@FindBy(id="menu-item-37")
	WebElement iphonesButton;
	@FindBy(id="menu-item-38")
	WebElement ipodsButton;
	@FindBy(id="menu-item-39")
	WebElement macbooksButton;
	@FindBy(xpath="/html/body/div[2]/div/div/header/nav/form/fieldset/input[1]")
	WebElement search;
	@FindBy(className="cart_icon")
	WebElement cartBotton;
	@FindBy(className="account_icon")
	WebElement accountBotton;
	@FindBy(id="logo")
	WebElement logoButton;
	@FindBy(id="menu-item-53")
	WebElement spHomeButton;
	@FindBy(id="menu-item-54")
	WebElement samplePageButton;
	@FindBy(id="menu-item-55")
	WebElement yourAccountButton;
	@FindBy(className="more")
	WebElement randomProductButton;
	
	
	public Menu(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void goToHome1(){
		homeButton.click();
	}
	public void goToHome2(){
		logoButton.click();
	}
	public void goToHome3(){
		spHomeButton.click();
	}
	public void chooseCatagory(String x){
		Actions action = new Actions(driver);
		action.moveToElement(catagoryButton);
		switch(x){
			case "Accessories":
				action.moveToElement(accessoriesButton);
				break;
			case "iMacs":
				action.moveToElement(imacsButton);
				break;
			case "iPads":
				action.moveToElement(ipadsButton);
				break;
			case "iPhones":
				action.moveToElement(iphonesButton);
				break;
			case "iPods":
				action.moveToElement(ipodsButton);
				break;
			case "MacBooks":
				action.moveToElement(macbooksButton);
				break;
		}
		action.click();
		action.perform();
	}
	public void goToAllProduct(){
		allProductButton.click();
	}
	public void searchText(String searchStr){
		search.sendKeys(searchStr);
		search.sendKeys(Keys.ENTER);
		
	}
	public void goToCart(){
		cartBotton.click();
	}
	public void goToAccount1(){
		accountBotton.click();
	}
	public void goToAccount2(){
		yourAccountButton.click();
	}
	public void goToSamplePage(){
		samplePageButton.click();
	}
	public void goToRandomProduct(){
		randomProductButton.click();
	}
	
}
