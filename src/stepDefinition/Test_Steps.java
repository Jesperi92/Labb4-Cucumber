package stepDefinition;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LogInPage;
import pages.Menu;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.RegisterPage;
import pages.SamplePage;
import pages.SearchResultPage;

public class Test_Steps {
	
	public static WebDriver driver;
	public static HomePage homePage;
	public static ProductPage productPage;
	public static CheckoutPage checkoutPage;
	public static LogInPage logInPage;
	public static MyAccountPage myAccountPage;
	public static RegisterPage registerPage;
	public static SamplePage samplePage;
	public static SearchResultPage searchResultPage;
	public static Menu menu;
	String firstProductName;
	String message;
	@Before
	public void beforeScenario(){
		driver = new FirefoxDriver();
		homePage = new HomePage(driver);
		productPage = new ProductPage(driver);
		checkoutPage = new CheckoutPage(driver);
		logInPage = new LogInPage(driver);
		myAccountPage = new MyAccountPage(driver);
		registerPage = new RegisterPage(driver);
		samplePage = new SamplePage(driver);
		searchResultPage = new SearchResultPage(driver);
		menu = new Menu(driver);
	}
	@After
	public void afterScenario(){
		driver.close();
	}
	@Given ("^User is on Home Page$")
	public void user_is_on_home_page() throws Throwable {
        driver.get("http://www.store.demoqa.com");
        driver.manage().window().maximize();
		
	}
	@When ("^User Navigate to A Random Product$")
	public void user_navigate_to_random_product() throws Throwable {
		homePage.goToRandomProduct();
		
	}
	@And ("^User Clicks on The MenuHomeButton$")
	public void user_clicks_on_menu_home_button() throws Throwable {
		productPage.goToHome1();
		
	}
	@And ("^User Clicks on The LogoHomeButton$")
	public void user_clicks_on_logo_home_button() throws Throwable {
		productPage.goToHome2();
		
	}
	@And ("^User Clicks on The BottomHomeButton$")
	public void user_clicks_on_bottom_home_button() throws Throwable {
		productPage.goToHome3();
		
	}
	@Then ("^The user is on the HomePage$")
	public void the_user_is_on_the_HomePage() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://store.demoqa.com/");
		
	}
	@When ("^User Clicks on the SampleButton$")
	public void user_Clicks_on_the_SampleButton() throws Throwable {
		homePage.goToSamplePage();
		
	}
	@Then ("^The user is on the SamplePage$")
	public void the_user_is_on_the_SamplePage() throws Throwable {
		Assert.assertEquals("Sample Page", samplePage.getSamplePageTitle());
		
	}
	@When("^User clicks on the AllProductsButton$")
	public void user_clicks_on_the_AllProductsButton() throws Throwable {
	    homePage.goToAllProduct();
	}

	@When("^User hower over Products button and then clicks on \"([^\"]*)\"$")
	public void user_hower_over_Products_button_and_then_clicks_on(String arg1) throws Throwable {
	    menu.chooseCatagory(arg1);
	}

	@When("^User clicks on the upper MyAccountButton$")
	public void user_clicks_on_the_upper_MyAccountButton() throws Throwable {
		homePage.goToAccount1();
	}

	@Then("^User is on the MyAccountPage$")
	public void user_is_on_the_MyAccountPage() throws Throwable {
		Assert.assertEquals(myAccountPage.getMyAccountPageTitle(), "Your Account");
	}
	
	@Then("^User is on a new page with the title \"([^\"]*)\"$")
	public void user_is_on_a_new_page_with_the_title(String arg1) throws Throwable {
	    Assert.assertEquals(searchResultPage.getSearchResultPageTitle(), arg1);
	}

	@When("^User clicks on the bottom MyAccountButton$")
	public void user_clicks_on_the_bottom_MyAccountButton() throws Throwable {
		homePage.goToAccount2();
	}

	@When("^User Search on \"([^\"]*)\"$")
	public void user_Search_on(String arg1) throws Throwable {
		homePage.searchText(arg1);
	}
	
	@Then("^There is no match on the search$")
	public void there_is_no_match() throws Throwable {
		Assert.assertEquals(searchResultPage.getNoMatchMessage(), "Sorry, but nothing matched your search criteria. Please try again with some different keywords.");
	}

	@Then("^There is a match on the search \"([^\"]*)\"$")
	public void there_is_a_match_on_the_search(String arg1) throws Throwable {
		Assert.assertEquals(searchResultPage.getSearchResult().toLowerCase(), arg1);
	}
	

	@When("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {
	    searchResultPage.goToProduct(arg1);
	}

	@Then("^User is on \"([^\"]*)\" product page$")
	public void user_is_on_product_page(String arg1) throws Throwable {
	    Assert.assertEquals(productPage.getProductPageTitle(), arg1);
	}

	
	@Then("^User is on that AlsoBought products page$")
	public void user_is_on_that_AlsoBought_products_page() throws Throwable {
		Assert.assertNotEquals(firstProductName, productPage.getProductPageTitle());
	}

	@When("^Clicks on a AlsoBought product$")
	public void clicks_on_a_AlsoBought_product() throws Throwable {
		firstProductName = productPage.getProductPageTitle();
		productPage.goToAlsoBoughtProduct();
	}

	@And("^rate that product with (\\d+)$")
	public void rate_that_product_with(int arg1) throws Throwable {
	    message = productPage.rateProduct(1);
	}

	@Then("^a message should pop up$")
	public void a_message_should_pop_up() throws Throwable {
		if(message.contains("Sorry")){
			Assert.assertEquals(message, "Sorry, you already rated!");
		}
		else{
			Assert.assertEquals(message, "Thanks for rating!");

		}
	}
	@When("^navigates to the register page$")
	public void navigates_to_the_register_page() throws Throwable {
		myAccountPage.goToRegisterPage();
	}

	@Then("^User is on the register page$")
	public void user_is_on_the_register_page() throws Throwable {
		Assert.assertEquals(registerPage.getRegisterPageTitle(), "Register For This Site");
	}

	@When("^navigates to the login page$")
	public void navigates_to_the_login_page() throws Throwable {
		myAccountPage.goToLogInPage();
	}

	@When("^enter username: \"([^\"]*)\" and password: \"([^\"]*)\"$")
	public void enter_username_and_password(String arg1, String arg2) throws Throwable {
		logInPage.logIn(arg1,arg2);
	}

	@Then("^a invalid login message appears$")
	public void a_invalid_login_message_appears() throws Throwable {
		Assert.assertTrue(logInPage.getLogInErrorMessage().contains("ERROR"));
	}
	@When("^adds \"([^\"]*)\" to the cart$")
	public void adds_to_the_cart(String arg1) throws Throwable {
		searchResultPage.addToCart(arg1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		searchResultPage.goToCartOrContinueShopping(false);
	}

	@When("^navigates to another product$")
	public void navigates_to_another_product() throws Throwable {
		checkoutPage.goToAllProduct();
		searchResultPage.goToProduct("Magic Mouse");
	}

	@When("^add it to the cart$")
	public void add_it_to_the_cart() throws Throwable {
		productPage.addToCart();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		productPage.goToCartOrContinueShopping(false);
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" are in the cart$")
	public void and_are_in_the_cart(String arg1, String arg2) throws Throwable {
		Assert.assertNotNull(checkoutPage.getProductRow(arg1));
		Assert.assertEquals(checkoutPage.getProductQuantity(arg1), "1");
		Assert.assertNotNull(checkoutPage.getProductRow(arg2));
		Assert.assertEquals(checkoutPage.getProductQuantity(arg2), "1");
	}

	@Then("^\"([^\"]*)\" are in the cart$")
	public void are_in_the_cart(String arg1) throws Throwable {
		Assert.assertNotNull(checkoutPage.getProductRow(arg1));
	}

	@When("^User removes \"([^\"]*)\" from the cart$")
	public void user_removes_from_the_cart(String arg1) throws Throwable {
		checkoutPage.removeProductFromCart(arg1);
	}

	@Then("^The cart is empty$")
	public void the_cart_is_empty() throws Throwable {
		Assert.assertEquals(checkoutPage.getCheckoutPageContent(), "Oops, there is nothing in your cart.");
	}
}
