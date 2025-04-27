package mini.pages;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mini.utility.Utility;

public class Purchase {
	@FindBy(xpath = ".//button[text()='Place Order']")
	WebElement placeOrder;
	@FindBy(xpath = ".//a[text()='Cart']")
	WebElement cartLink;
	@FindBy(xpath = ".//input[@id='name']")
	WebElement name;
	@FindBy(xpath = ".//input[@id='country']")
	WebElement country;
	@FindBy(xpath = ".//input[@id='city']")
	WebElement city;
	@FindBy(xpath = ".//input[@id='card']")
	WebElement creditcard;
	@FindBy(xpath = ".//input[@id='month']")
	WebElement month;
	@FindBy(xpath = ".//input[@id='year']")
	WebElement year;
	@FindBy(xpath = ".//button[text()='Purchase']")
	WebElement purchase;

	private WebDriver webdriver;

	public Purchase(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void initiatePurchase(String cname, String ccountry, String ccity, String ccreditcard, String cmonth,
			String cyear) throws IOException, InterruptedException {
		cartLink.click();

		Thread.sleep(2000);

		placeOrder.click();
		Thread.sleep(2000);

		name.sendKeys(cname);
		country.sendKeys(ccountry);
		city.sendKeys(ccity);
		creditcard.sendKeys(ccreditcard);
		month.sendKeys(cmonth);
		year.sendKeys(cyear);

		Thread.sleep(2000);

		purchase.click();

		Thread.sleep(2000);

		Utility.screenshot("purchaseOrder");

	}
}
