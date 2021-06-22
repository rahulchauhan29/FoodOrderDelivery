package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configReader.TestData;

public class FoodPageFactory {

	TestData test = new TestData();

	public FoodPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[@data-testid='sign-in']//a")
	private WebElement loginLink;

	public void setLoginLink() {
		loginLink.click();
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement userName;

	public void setUserName() {
		userName.sendKeys(test.getUserName());
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	public void setPassword() {
		password.sendKeys(test.getPassword());
	}

	@FindBy(xpath = "//button[@data-testid='sign-in-btn']")
	private WebElement googleLogin;

	public void setGoogleLogin() {
		googleLogin.click();
	}

	@FindBy(xpath = "//input[contains(@class,'addressInput')]")
	private WebElement location;

	public void setLocation() {
		location.sendKeys(test.getLocation());
	}

	@FindBy(xpath = "//button[text()='Find food']")
	private WebElement findFood;

	public void setfindFood() {
		findFood.click();
	}

	@FindBy(xpath = "//a[contains(@href,'wawa')]")
	private WebElement restaurant;

	public void setRestaurant() {
		restaurant.click();
	}

	@FindBy(xpath = "//div[@class='menuItemNew-name']//a[text()='Cold Hoagies and Sandwiches - Italian']")
	private WebElement menu;

	public void setMenu() {
		menu.click();
	}

	@FindBy(xpath = "//input[@aria-label='Input item quantity']")
	private WebElement quantity;

	public void setQuantity() {
		quantity.clear();
		quantity.sendKeys(test.getQuantity());
	}

	@FindBy(xpath = "//div[@id='expansion-panel-title']//div[@class='u-block ']//div[2]//div//div//h5[contains(text(),'Toast')]")
	private WebElement requiredField1;

	public void setRequiredField1() {
		requiredField1.click();
	}

	@FindBy(xpath = "//span[text()='Roll only toasted']")
	private WebElement select1;

	public void setSelect1() {
		select1.click();
	}

	@FindBy(xpath = "//div[@id='expansion-panel-title']//div[@class='u-block ']//div[2]//div//div//h5[contains(text(),'Bread')]")
	private WebElement requiredField2;

	public void setRequiredField2() {
		requiredField2.click();
	}

	@FindBy(xpath = "//span[text()='Wheat Classic Roll']")
	private WebElement select2;

	public void setSelect2() {
		select2.click();
	}

	@FindBy(xpath = "//div[@id='expansion-panel-title']//div[@class='u-block ']//div[2]//div//div//h5[contains(text(),'Cheeses')]")
	private WebElement requiredField3;

	public void setRequiredField3() {
		requiredField3.click();
	}

	@FindBy(xpath = "//span[text()='American']")
	private WebElement select3;

	public void setSelect3() {
		select3.click();
	}

	@FindBy(xpath = "//button//span//span[text()='Add to bag']")
	private WebElement addToBag;

	public void setAddToBag() {
		addToBag.click();
	}

	@FindBy(xpath = "//button//span//span[contains(text(),'86.28')]")
	private WebElement amountCheck;

	public WebElement getAmountCheck() {
		return amountCheck;
	}

	public void setAmountCheck() {
		amountCheck.click();
	}

	@FindBy(xpath = "//button[@aria-label='Delete this item from the bag']")
	private WebElement deleteItemFromCart;

	public void setDeleteItemFromCart() {
		deleteItemFromCart.click();
	}

	@FindBy(xpath = "//aside[contains(@class,'orderItem-removeOver')]//div//div//button[text()='Yes']")
	private WebElement deleteItemYes;

	public void setDeleteItemYes() {
		deleteItemYes.click();
	}

	@FindBy(xpath = "//h5[text()='Your bag is empty.']")
	private WebElement cartEmpty;

	public WebElement getCartEmpty() {
		return cartEmpty;
	}

}
