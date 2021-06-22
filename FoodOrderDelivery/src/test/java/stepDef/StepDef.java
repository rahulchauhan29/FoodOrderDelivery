package stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import configReader.ConfigFileReader;
import configReader.Validation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.CommonFunctions;
import pageFactory.FoodPageFactory;

public class StepDef {
	WebDriver driver;
	ConfigFileReader configFileReader;
	Validation validation = new Validation();
	FoodPageFactory foodPageFactory;
	CommonFunctions commonFunctions = new CommonFunctions();

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		configFileReader = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(configFileReader.getApplicationUrl());
		String expectedTitle = validation.getTitle();
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle);
		commonFunctions.takeSnapShot(driver);
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("//a[text()='Dismiss']")).click();
		} catch (Exception e) {
			System.out.println("Dismiss Window pop is not coming.");
		}
	}

	@When("^user login with valid credentials$")
	public void user_login_with_valid_credentials() throws Throwable {
		foodPageFactory = new FoodPageFactory(driver);

		foodPageFactory.setLoginLink();
		foodPageFactory.setUserName();
		foodPageFactory.setPassword();
		foodPageFactory.setGoogleLogin();
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-spinner']")).click();
		// driver.quit();
	}

	@When("^user enter the food delivery location$")
	public void user_enter_the_food_delivery_location() throws Throwable {
		foodPageFactory = new FoodPageFactory(driver);
		foodPageFactory.setLocation();
		commonFunctions.takeSnapShot(driver);
		foodPageFactory.setfindFood();
	}

	@When("^select the restaurant$")
	public void select_the_restaurant() throws Throwable {
		foodPageFactory = new FoodPageFactory(driver);
		foodPageFactory.setRestaurant();
		commonFunctions.takeSnapShot(driver);
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

	}

	@When("^select the food item and quantity$")
	public void select_the_food_item_and_quantity() throws Throwable {
		foodPageFactory = new FoodPageFactory(driver);
		commonFunctions.takeSnapShot(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Wawa']"))).isDisplayed()) {
			String expectedTitle = validation.getRestaurantTitle();
			String originalTitle = driver.getTitle();
			Assert.assertEquals(originalTitle, expectedTitle);
		} else {
			driver.findElement(By.xpath("//input[@id='search-autocomplete-input']")).sendKeys("Wawa");
			driver.findElement(By.xpath("//*[@id=\"ghs-restaurant-summary\"]/div/span[1]/div/div/div/div[2]")).click();
		}
		// Thread.sleep(2000);
		foodPageFactory.setMenu();
		foodPageFactory.setQuantity();
		commonFunctions.takeSnapShot(driver);
		foodPageFactory.setRequiredField1();
		foodPageFactory.setSelect1();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		foodPageFactory.setRequiredField2();
		foodPageFactory.setSelect2();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		foodPageFactory.setRequiredField3();
		foodPageFactory.setSelect3();

		commonFunctions.takeSnapShot(driver);
	}

	@When("^sent them into cart$")
	public void sent_them_into_cart() throws Throwable {
		foodPageFactory = new FoodPageFactory(driver);
		String amount = foodPageFactory.getAmountCheck().getText();
		String expectedAmount = validation.getAmount();
		Assert.assertEquals(amount, expectedAmount);
		commonFunctions.takeSnapShot(driver);
		foodPageFactory.setAddToBag();
	}

	@Then("^Food is added to cart successfully$")
	public void food_is_added_to_cart_successfully() throws Throwable {
		System.out.println("Item is successfully added to cart.");
		commonFunctions.takeSnapShot(driver);
		driver.quit();
	}

	@Then("^Click on delete cart values$")
	public void click_on_delete_cart_values() throws Throwable {
		foodPageFactory = new FoodPageFactory(driver);
		foodPageFactory.setDeleteItemFromCart();
		commonFunctions.takeSnapShot(driver);
		foodPageFactory.setDeleteItemYes();
		System.out.println("Item Deleted successfully.");
		commonFunctions.takeSnapShot(driver);
	}

	@Then("^verifies if cart is empty$")
	public void verifies_if_cart_is_empty() throws Throwable {
		String text = foodPageFactory.getCartEmpty().getText();
		String expectedText = validation.getBagEmpty();
		Assert.assertEquals(text, expectedText);
		commonFunctions.takeSnapShot(driver);
		driver.quit();
	}

}
