package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Menu {
	
	WebDriver driver;
	@FindBy(className="prodtitle")
	WebElement productPageTitle;
	@FindBy(className="wpsc_buy_button")
	WebElement addToCartButton;
	@FindBy(linkText="Go to Checkout")
	WebElement goToCheckoutButton;
	@FindBy(xpath="/html/body/div[4]/div[2]/a[2]")
	WebElement continueShoppingButton;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/div[2]/span/div[2]")
	WebElement rateOneStar;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/div[2]/span/div[3]")
	WebElement rateTwoStar;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/div[2]/span/div[4]")
	WebElement rateThreeStar;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/div[2]/span/div[5]")
	WebElement rateFourStar;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div/div[1]/div[2]/div[2]/span/div[6]")
	WebElement rateFiveStar;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div/div[2]/ul/li[1]")
	WebElement alsoBoughtProduct;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public String getProductPageTitle(){
		return productPageTitle.getText();
	}
	public void addToCart(){
		addToCartButton.click();
	}
	public void goToCartOrContinueShopping(boolean continueShopping){
		if(continueShopping)
			continueShoppingButton.click();
		
		else
			goToCheckoutButton.click();
	}
	public String rateProduct(int rating){
		switch(rating){
			case 1:
				rateOneStar.click();
				break;
			case 2:
				rateTwoStar.click();
				break;
			case 3:
				rateThreeStar.click();
				break;
			case 4:
				rateFourStar.click();
				break;
			case 5:
				rateFiveStar.click();
				break;
			
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(By.className("message")).getText();
	}
	public void goToAlsoBoughtProduct(){
		alsoBoughtProduct.click();
	}
}
