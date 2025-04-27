package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import mini.pages.Login;
import mini.pages.Logout;

public class LogoutTest extends Base {

	@BeforeTest
	public void setup() {

		sheetname = "Logout";
	}

	@Test(dataProvider = "readData")
	public void testLogin(String userName, String pwd) throws IOException, InterruptedException {

		Login login = new Login(driver);

		login.checkLoginBtn();
		login.checkSLoginBtnClickable();
		login.LoginWindow(userName, pwd);
		Logout logout = new Logout(driver);
		logout.checkLogoutBtn();

	}
}
