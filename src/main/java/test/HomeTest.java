package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import mini.pages.Home;
import mini.pages.Login;

public class HomeTest extends Base {

	@BeforeTest
	public void setup() {

		sheetname = "Home";

	}

	@Test(dataProvider = "readData")
	public void testHome(String userName, String pwd, String welcomeUser, String menu, String categories)
			throws IOException, InterruptedException {
		Thread.sleep(2000);
		Login login = new Login(driver);
		login.LoginWindow(userName, pwd);
		Home home = new Home(driver);
		Thread.sleep(2000);
		home.homeusername(welcomeUser);
		String[] menuList = menu.split(",");
		home.checkallMenuitems(menuList);
		String[] categoryList = categories.split(",");
		home.checkCategories(categoryList);
		home.checkImage();
		screenshot("home");
		// driver.close();

	}
}
