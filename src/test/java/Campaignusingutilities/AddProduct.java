package Campaignusingutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.LoginPage;



public class AddProduct {

	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		String BROWSER = flib.getkeyandvaluepair("browser");
		String URL = flib.getkeyandvaluepair("url");
		String USERNAME = flib.getkeyandvaluepair("username");
		String PASSWORD = flib.getkeyandvaluepair("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		//wlib.waitForElementsToLoad(driver);

		driver.findElement(By.linkText("Products")).click();


		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement moreLink = driver.findElement(By.linkText("More"));


		wlib.moveToElement(driver, moreLink);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();

		String CampName = elib.getExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(CampName);

		driver.findElement(By.name("campaignname")).sendKeys(CampName);


		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();

		wlib.swithToWindow(driver, "Products&action");

		driver.findElement(By.name("search_text")).sendKeys(PrdName);
		driver.findElement(By.cssSelector("[name=\"search\"]")).click();

		// Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='" + PrdName + "']")).click();


		wlib.swithToWindow(driver, "Campaigns&action");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(CampName)) {
			System.out.println("Campaigns Name is Created");
		} else {
			System.out.println("Campaigns name not created");
		}

		String actData1 = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
		if (actData1.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		wlib.mouseOverOnElement(driver, AmdLink);
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
