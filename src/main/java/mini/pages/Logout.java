package mini.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mini.utility.Utility;

public class Logout {
	@FindBy(xpath = ".//a[text()='Log out']")
	WebElement logoutButton;

	private WebDriver webdriver;

	public Logout(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void checkLogoutBtn() throws InterruptedException, IOException {
		Thread.sleep(2000);

		System.out.println(logoutButton.getText());

		Assert.assertEquals(logoutButton.getText(), "Log out");
		logoutButton.click();
		Thread.sleep(2000);
		Utility.screenshot("logout");
	}
}
