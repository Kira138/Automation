package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Insertmultipledatstoexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\kiran\\Downloads\\Excel 2.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		//getting control on sheet
		Sheet sheet=book.getSheet("Sheet1");
		//getting control on row number
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		List<WebElement>allLinks=driver.findElements(By.xpath("//a"));
		for(int i=0;i<allLinks.size();i++)
		{
		Row row=sheet.createRow(i);      //row number starts from zero
		//getting control on cell number
		Cell cel=row.createCell(0);      //cell number also starts from zero
		cel.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\kiran\\Downloads\\Excel 2.xlsx");
		book.write(fos);
		book.close();
	}
	}

