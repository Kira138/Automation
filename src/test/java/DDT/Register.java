package DDT;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {

    public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        FileInputStream fis = new FileInputStream("C:\\Users\\kiran\\Downloads\\Register (1).xlsx");
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet("Sheet1");
        Row row = sheet.getRow(1);

        //------------------------------------------------------------------------------------------------------//
        String FirstName = row.getCell(0).getStringCellValue();
        String LastName = row.getCell(1).getStringCellValue();
        String Address = row.getCell(2).getStringCellValue();
        String Email = row.getCell(3).getStringCellValue();
        double PhoneDouble = row.getCell(4).getNumericCellValue();
        String Phone = String.valueOf((long) PhoneDouble);
        String Gender = row.getCell(5).getStringCellValue();
        String Hobbies = row.getCell(6).getStringCellValue();
        String Languages = row.getCell(7).getStringCellValue();
        String Skills = row.getCell(8).getStringCellValue();
        String SelectCountry = row.getCell(10).getStringCellValue();
        double Year1 = row.getCell(11).getNumericCellValue();
        String Year = String.valueOf((long) Year1);
        String Month = row.getCell(12).getStringCellValue();
        double Date1 = row.getCell(13).getNumericCellValue();
        String Date = String.valueOf((long) Date1);
        String Password = row.getCell(14).getStringCellValue();
        String ConfirmPassword = row.getCell(15).getStringCellValue();

        fis.close();  // Closing FileInputStream after reading

        //---------------------------------------------------------------------------------------------------------//
        driver.findElement(By.xpath("//input[@placeHolder='First Name']")).sendKeys(FirstName);
        driver.findElement(By.xpath("//input[@placeHolder='Last Name']")).sendKeys(LastName);
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(Address);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Email);
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(Phone);

        //--------------------------------------------------------------------------------------------------------//
        List<WebElement> Genders = driver.findElements(By.xpath("//input[@name='radiooptions']"));
        for (WebElement Gen : Genders) {
            if (Gen.getAttribute("value").equals(Gender)) {
                Gen.click();
                break;
            }
        }

        List<WebElement> Hobbie = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement Hob : Hobbie) {
            if (Hob.getAttribute("value").equals(Hobbies)) {
                Hob.click();
                break;
            }
        }

        //----------------------------------------------------------------------------------------------------------//
        driver.findElement(By.id("msdd")).click();
        Thread.sleep(3000);
        List<WebElement> allLanguage = driver.findElements(By.xpath("//li[@class='ng-scope']"));
        for (WebElement lang : allLanguage) {
            if (lang.getText().equals(Languages)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lang);
                lang.click();
                break;
            }
        }

        driver.findElement(By.tagName("body")).click();
        driver.findElement(By.xpath("//select[@id='Skills']")).click();
        Thread.sleep(3000);
        Select skillDropdown = new Select(driver.findElement(By.id("Skills")));
        skillDropdown.selectByVisibleText(Skills);
        driver.findElement(By.tagName("body")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(SelectCountry);
        List<WebElement>countries=driver.findElements(By.xpath("//li[@role='treeitem']"));
        for(WebElement country:countries)
        {
        	if(country.getText().equals(SelectCountry))
        	{
        		country.click();
        		break;
        	}
        }
        driver.findElement(By.id("countries")).click();
        driver.findElement(By.xpath("//option[text()='Select Country']")).click();
        WebElement year=driver.findElement(By.id("yearbox"));
        Select selectyear=new Select(year);
        selectyear.selectByValue(Year);

        WebElement month=driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select selectmonth=new Select(month);
        selectmonth.selectByValue(Month);

        WebElement date=driver.findElement(By.id("daybox"));
        Select selectdate=new Select(date);
        selectdate.selectByValue(Date);

        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys(ConfirmPassword);
        driver.findElement(By.id("submitbtn")).click();

    }


}
