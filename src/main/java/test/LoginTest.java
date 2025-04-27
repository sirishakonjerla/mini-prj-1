package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import mini.pages.Login;

public class LoginTest extends Base {

	@BeforeTest
	public void setup() {

		sheetname = "Login";
	}

	@Test(dataProvider = "readData")
	public void testLogin(String userName, String pwd) throws IOException, InterruptedException {

		Login login = new Login(driver);

		login.checkLoginBtn();
		login.checkSLoginBtnClickable();
		login.LoginWindow(userName, pwd);
		screenshot("login");

	}
}
