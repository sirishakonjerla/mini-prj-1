package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import mini.pages.Signup;

public class SignUpTest extends Base {

	@BeforeTest
	public void setup() {

	}

	@Test
	public void signupTest() throws IOException, InterruptedException {
		System.out.println("SignOut Test execution start");
		Signup signUp = new Signup(driver);
		signUp.checkSignUpBtn();
		signUp.checkSignUpBtnClickable();
		signUp.SignupWindow();
		screenshot("signup");
		driver.close();
		System.out.println("SignOut Test execution end");

	}

}
