package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends Menu {
	WebDriver driver;
	@FindBy(id="content")
	WebElement content;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/ul/a[1]")
	WebElement slideButton1;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/ul/a[2]")
	WebElement slideButton2;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/ul/a[3]")
	WebElement slideButton3;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public String getProductDescription(){
		return content.getText();
			
	}
	public void clickFirstSlideButton(){
		slideButton1.click();
	}
	public void clickSecondSlideButton(){
		slideButton2.click();
	}
	public void clickThirdSlideButton(){
		slideButton3.click();
	}
}
