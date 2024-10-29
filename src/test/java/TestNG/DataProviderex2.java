package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Java_Utility;



public class DataProviderex2 {
	@Test(dataProvider = "getData")
	public void organizationModuleTest(String orgName,String phnNum,String mailId)throws Throwable
	{

	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phnNum);
	driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(mailId);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	}
	@DataProvider
	public Object[][] getData(){


		Java_Utility jilib=new Java_Utility();
		int ran=jilib.getRandomNum();

		Object[][] obj=new Object[2][3];

		obj[0][0]="AAA"+ran;
		obj[0][1]="654465165";
		obj[0][2]="mailto:svc@gmail.com";

		obj[1][0]="BBB"+ran;
		obj[1][1]="654465165";
		obj[1][2]="mailto:jhfb@gmail.com";


		return obj;


	}
}
