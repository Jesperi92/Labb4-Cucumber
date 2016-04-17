package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Menu{
	WebDriver driver;
	@FindBy(className="entry-title")
	WebElement title;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr")
	List<WebElement> products;
	@FindBy(className="wpsc_product_remove")
	WebElement removeButton;
	@FindBy(className="entry-content")
	WebElement checkoutPageContent;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public String getCheckoutPageTitle(){
		return title.getText();
	}
	public WebElement cartContains(String productName){
	
		for(WebElement product : products){
			if(product.getText().contains(productName)){
				return product;
			}
		}
		return null;
	}
	public String getProductRow(String productName){
		return this.cartContains(productName).getText();
	}
	public String getProductQuantity(String productName){
		return this.cartContains(productName).findElement(By.name("quantity")).getAttribute("value");
	}
	public void removeProductFromCart(String productName){
		this.cartContains(productName).findElement(By.className("wpsc_product_remove")).findElement(By.name("submit")).click();
	}
	public void changeProductQuantity(String productName, String quantity){
		WebElement productRow = this.cartContains(productName);
		productRow.findElement(By.name("quantity")).sendKeys(quantity);
		productRow.findElement(By.name("sudmit")).click();
	}
	public String getCheckoutPageContent(){
		return checkoutPageContent.getText();
	}
	
	
}
