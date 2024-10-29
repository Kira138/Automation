package TestNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;

public class DataProvider3 {

    @Test(dataProvider = "getDataProviderData")
    public void organizationModuleTest(String orgName, String phnNum, String mailId) throws Throwable {
        // Utility classes
        File_Utility flib = new File_Utility();
        WebDriver_utility wlib = new WebDriver_utility();
        Java_Utility jlib = new Java_Utility();

        // Fetch data from properties file
        String BROWSER = flib.getkeyandvaluepair("browser");
        String URL = flib.getkeyandvaluepair("url");
        String USERNAME = flib.getkeyandvaluepair("username");
        String PASSWORD = flib.getkeyandvaluepair("password");

        // WebDriver initialization based on browser type
        WebDriver driver;
        if (BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        // Login to the application
        driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
        wlib.maximizeWindow(driver);

        // Navigate to Organizations and create a new organization
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

        // Use random number utility for unique organization name
        int ranNum = jlib.getRandomNum();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName + ranNum);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phnNum);
        driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(mailId);

        // Save the organization
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(3000);

        // Logout
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
        driver.findElement(By.linkText("Sign Out")).click();
    }

    // DataProvider to fetch Excel data dynamically
    @DataProvider(name = "getDataProviderData")
    public Object[][] getDataProviderData() throws Throwable {
        String sheetName = "Sheet2";  // Replace with dynamic sheet if needed
        FileInputStream fes = new FileInputStream("C:\\Users\\kiran\\Downloads\\organization (3).xlsx");

        // Open workbook and access sheet
        Workbook book = WorkbookFactory.create(fes);
        Sheet sheet = book.getSheet(sheetName);
        int lastRow = sheet.getLastRowNum();
        int lastCell = sheet.getRow(0).getLastCellNum();

        // Fetch data from Excel
        Object[][] objArr = new Object[lastRow + 1][lastCell];
        for (int i = 0; i <= lastRow; i++) {
            for (int j = 0; j < lastCell; j++) {
                objArr[i][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        return objArr;
    }
}
