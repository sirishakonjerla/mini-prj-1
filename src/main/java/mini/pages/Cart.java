package mini.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mini.utility.Utility;

public class Cart {

	@FindBy(xpath = ".//a[text()='Delete']")
	List<WebElement> deleteItems;

	@FindBy(xpath = ".//a[text()='Home ']")
	WebElement home;

	@FindBy(xpath = ".//a[text()='Cart']")
	WebElement cartLink;

	private WebDriver webdriver;

	public Cart(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void deleteFromCart() throws InterruptedException, IOException {

		// WebElement element =
		// this.webdriver.findElement(By.xpath(".//a[text()='Cart']"));
		cartLink.click();

		Thread.sleep(2000);
		Utility.screenshot("cart");

		for (WebElement item : deleteItems) {
			item.click();

			Thread.sleep(2000);

		}

		home.click();

		Thread.sleep(2000);

	}

	public void verifyTotalPrice(String totalPrc) throws InterruptedException {
		cartLink.click();

		Thread.sleep(2000);

		WebElement totalPrice = this.webdriver.findElement(By.xpath(".//h3[@id='totalp']"));

		Assert.assertEquals(totalPrice.getText(), totalPrc);
	}

}
