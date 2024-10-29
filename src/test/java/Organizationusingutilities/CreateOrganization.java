package Organizationusingutilities;
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

public class CreateOrganization {

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		wlib.maximizeWindow(driver);
		//wlib.waitForElementsToLoad(driver);

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

		int ranNum = jlib.getRandomNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		System.out.println(OrgName);
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		// --------------------------------------------------------------------------------------------

		String PhoneNum = elib.getExcelDataUsingFormatter("Organization", 0, 1);
		System.out.println(PhoneNum);
		driver.findElement(By.id("phone")).sendKeys(PhoneNum);

		// ------------------------------------------------------------------------------------------

		String Email = elib.getExcelDataUsingFormatter("Organization", 0, 2);
		System.out.println(Email);
		driver.findElement(By.id("email1")).sendKeys(Email);

		// -------------------------------------------------------------------------------------------

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(OrgName)) {
			System.out.println("Organization Name is Created");
		} else {
			System.out.println("Organization name not created");
		}

		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		wlib.moveToElement(driver, AmdLink);
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
