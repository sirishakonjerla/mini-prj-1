package mini.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {

	private WebDriver webdriver;

	@FindBy(id = "login2")
	WebElement LoginButton;

	@FindBy(id = "loginusername")
	WebElement username;

	@FindBy(id = "loginpassword")
	WebElement password;

	@FindBy(xpath = ".//button[text()='Log in']")
	WebElement submit;

	public Login(WebDriver driver) {
		this.webdriver = driver;
		PageFactory.initElements(webdriver, this);
	}

	public void checkLoginBtn() {

		System.out.println(LoginButton.getText());

		Assert.assertEquals(LoginButton.getText(), "Log in");
	}

	public void checkSLoginBtnClickable() {

		Assert.assertEquals(LoginButton.isEnabled(), true);
	}

	public void LoginWindow(String user, String pwd) throws InterruptedException {

		System.out.println(webdriver.getCurrentUrl());
		LoginButton.click();
		Thread.sleep(2000);
		username.sendKeys(user);
		password.sendKeys(pwd);
		submit.click();

		System.out.println(webdriver.getCurrentUrl());

	}
}