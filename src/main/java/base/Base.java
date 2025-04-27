package base;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import mini.utility.Utility;

public class Base  extends Utility{
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void launchBrowser(String browser,String url) {
		
		browserandurl(browser,url);
	}
	
	@DataProvider
	public String[][] readData() throws IOException, URISyntaxException {
		
		String[][] data = readExcel(sheetname);
		return data;
	}
	
	@AfterMethod
	public void browserClose() {
		
		closeBrowser();
	}

}
