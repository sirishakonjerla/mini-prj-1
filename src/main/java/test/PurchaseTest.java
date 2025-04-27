package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

import mini.pages.Login;
import mini.pages.ProductStore;
import mini.pages.Purchase;

public class PurchaseTest extends Base {

	@BeforeTest
	public void setup() {

		sheetname = "purchase";

	}

	@Test(dataProvider = "readData")
	public void testPurchase(String userName, String pwd, String productname, String name, String country, String city,
			String creditcard, String month, String year) throws IOException, InterruptedException {

		Login login = new Login(driver);
		login.LoginWindow(userName, pwd);
		Thread.sleep(2000);

		ProductStore productstore = new ProductStore(driver);
		productstore.clickonProduct(productname);
		Thread.sleep(2000);
		productstore.addtocart();
		Purchase purchase = new Purchase(driver);
		purchase.initiatePurchase(name, country, city, creditcard, month, year);
		screenshot("purchaseTest");
	}

}
