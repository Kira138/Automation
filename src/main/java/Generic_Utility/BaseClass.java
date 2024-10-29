package Generic_Utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	public void bs()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("Parallel execution");
	}
	
	@BeforeClass
	public void bc() throws Throwable
	{
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getkeyandvaluepair("browser");
		
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
		sdriver=driver;
		
		
		System.out.println("launching Browser");
	}
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("login to application");
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("logout from application");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("close the browser");
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("Close database connection");
	}
}