package mini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Signup {

	private WebDriver webdriver;

	@FindBy(id = "signin2")
	WebElement signupButton;

	@FindBy(id = "signInModal")
	WebElement signupWindow;

	// signin2 and Sign up
	public Signup(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void checkSignUpBtn() {

		System.out.println(signupButton.getText());

		Assert.assertEquals(signupButton.getText(), "Sign up");
	}

	public void checkSignUpBtnClickable() {

		Assert.assertEquals(signupButton.isEnabled(), true);
	}

	public void SignupWindow() throws InterruptedException {

		System.out.println(signupWindow.getAttribute("style"));
		signupButton.click();
		Thread.sleep(2000);

		System.out.println(signupWindow.getAttribute("style"));
		Assert.assertEquals(signupWindow.getAttribute("style"), "display: block;");
	}

}
