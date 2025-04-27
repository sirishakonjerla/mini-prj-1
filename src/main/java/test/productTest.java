package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

import mini.pages.Login;
import mini.pages.ProductStore;

public class productTest extends Base {

	@BeforeTest
	public void setup() {

		sheetname = "product";

	}

	@Test(dataProvider = "readData")
	public void testProduct(String userName, String pwd, String productname, String productprice,
			String productdescription) throws IOException, InterruptedException {

		Login login = new Login(driver);
		login.LoginWindow(userName, pwd);
		Thread.sleep(2000);
		ProductStore productstore = new ProductStore(driver);
		productstore.clickonProduct(productname);
		Thread.sleep(2000);
		productstore.productdetails(productname, productprice, productdescription);
		screenshot("prouctTest");
		productstore.addtocart();
		productstore.verifyCart();

	}
}