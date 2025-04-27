package mini.utility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;

public class Utility {

	public static WebDriver driver;
	public String sheetname;

	public void browserandurl(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {

			driver = new ChromeDriver();

		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public static String[][] readExcel(String sheetname) throws IOException, URISyntaxException {

				URL url = ClassLoader.getSystemResource("mini-prj-1.xlsx");
				Path path = Paths.get(url.toURI());
		//XSSFWorkbook book = new XSSFWorkbook(
		//		"C:\\Users\\srinu\\automation\\mini-prj-1\\src\\test\\resources\\mini-prj-1.xlsx");
						XSSFWorkbook book = new XSSFWorkbook(path.toString());
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowcount][columncount];
		for (int i = 1; i <= rowcount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columncount; j++) {

				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i - 1][j] = cell.getStringCellValue();

			}
		}

		book.close();
		return data;
	}

	public static String screenshot(String name) throws IOException {

		String path = "screenshots\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

	public void closeBrowser() {

		// driver.close();
		driver.quit();
	}

}