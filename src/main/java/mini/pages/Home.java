package mini.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home {

	@FindBy(id = "nameofuser")
	WebElement homeUserName;

	@FindBy(xpath = ".//a[@id='nava']")
	WebElement image;

	private WebDriver webdriver;

	public Home(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void homeusername(String welcomeUser) {
		System.out.println(homeUserName.getText());

		Assert.assertEquals(homeUserName.getText(), welcomeUser);

	}

	public void checkallMenuitems(String[] menuList) {

		// Assert.assertEquals(home.getText().trim(), "Home");
		for (String menu : menuList) {
			WebElement element = this.webdriver.findElement(By.xpath(".//a[text()='" + menu + "']"));
			Assert.assertEquals(element.getText(), menu);

		}

	}

	public void checkCategories(String[] categoryList) {
		for (String category : categoryList) {
			WebElement element = this.webdriver.findElement(By.xpath(".//a[text()='" + category + "']"));
			Assert.assertEquals(element.getText(), category);

		}
	}

	public void checkImage() {
		Assert.assertEquals(image.isDisplayed(), true);
		System.out.println(image.isDisplayed());
	}

}