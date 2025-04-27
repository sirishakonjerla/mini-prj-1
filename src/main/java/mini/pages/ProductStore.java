package mini.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductStore {

	@FindBy(xpath = ".//div[@id='more-information']/p")
	WebElement productDescription;

	@FindBy(xpath = ".//h3[@class='price-container']")
	WebElement productPrice;

	@FindBy(xpath = ".//h2[@class='name']")
	WebElement productName;

	@FindBy(xpath = ".//a[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = ".//tbody[@id='tbodyid']/tr")
	List<WebElement> cartItems;

	@FindBy(xpath = ".//a[text()='Delete']")
	List<WebElement> deleteItems;

	private WebDriver webdriver;

	public ProductStore(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void clickonProduct(String productName) {
		WebElement element = this.webdriver
				.findElement(By.xpath(".//a[@class='hrefch'][text()='" + productName + "']"));

		Assert.assertEquals(element.getText(), productName);
		element.click();
	}

	public void productdetails(String productNm, String productprc, String productdesc) {

		Assert.assertEquals(productName.getText(), productNm);
		Assert.assertEquals(productPrice.getText(), "$" + productprc + " *includes tax");
		Assert.assertEquals(productDescription.getText().trim(), productdesc);

	}

	public void addtocart() throws InterruptedException {
		System.out.println(webdriver.getCurrentUrl());
		System.out.println(addToCart.getText());
		addToCart.click();

		Thread.sleep(2000);

		webdriver.switchTo().alert().accept();

	}

	public void verifyCart() throws InterruptedException {
		WebElement element = this.webdriver.findElement(By.xpath(".//a[text()='Cart']"));
		element.click();

		Assert.assertEquals(cartItems.size(), 1);

		Thread.sleep(2000);

	}

	public void deleteFromCart() throws InterruptedException {

		for (WebElement item : deleteItems) {
			item.click();
		}

		Thread.sleep(2000);

	}
}
