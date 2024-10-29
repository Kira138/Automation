package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartEX1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\kiran\\Downloads\\FlipkartData.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER=pro.getProperty("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{

			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}

		String URL=pro.getProperty("url");
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement search=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		String Brand=pro.getProperty("brand");
		search.sendKeys(Brand);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> results=driver.findElements(By.xpath("//a[@class='WKTcLC']"));


		for(WebElement name:results)
		{
			String SHOENAME=pro.getProperty("shoename");
			if(name.getText().equals(SHOENAME))
			{
				name.click();
				break;
			}
		}
		String mainid=driver.getWindowHandle();
		Set<String>allids=driver.getWindowHandles();
		for(String id:allids)
		{
			if(!mainid.equals(id))
			{
				driver.switchTo().window(id);

			}
		}
		WebElement pincode=driver.findElement(By.xpath("//input[@placeholder='Enter delivery pincode']"));
		String Pincode=pro.getProperty("pincode");
		pincode.sendKeys(Pincode);
		driver.findElement(By.className("UFTn-O")).click();
		List<WebElement> colors=driver.findElements(By.xpath("//div[@class='_0QyAeO +ov7tq dpZEpc']"));
		for(WebElement color:colors)
		{
		String Colorr=pro.getProperty("colorr");
		if(color.getText().equals(Colorr));
		{
			color.click();
			break;
		}
		}
		Thread.sleep(8000);
		List<WebElement>sizes=driver.findElements(By.xpath("//li[@class='aJWdJI dpZEpc']"));
		for(WebElement size:sizes)
		{
			String SIZE=pro.getProperty("Size");
			if(size.getText().equals(SIZE))
			{
				size.click();
				break;
			}

		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")).click();


		{
}
	}
	}


