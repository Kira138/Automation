package Productusingutilities;



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

public class DeleteProduct {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		// Reading data from file_utility

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		wlib.maximizeWindow(driver);
		//wlib.waitForElementsToLoad(driver);

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		driver.findElement(By.xpath("//a[text()='Products']")).click();

		// driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		wlib.alertAccept(driver);

		WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName + "']"));
		if (prd.equals(PrdName)) {
			System.out.println("Product Name is Present");
		} else {
			System.out.println("Product name is not Present");
		}

		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		wlib.moveToElement(driver, AmdLink);
		driver.findElement(By.linkText("Sign Out")).click();

	}
}
