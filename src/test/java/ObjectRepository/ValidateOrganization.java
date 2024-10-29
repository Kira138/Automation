package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateOrganization {

	public ValidateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ValidateOrgName(WebDriver driver,String OrgName)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement orgNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='dtlview_Organization Name']")));
		    String actData = orgNameElement.getText();

		if (actData.contains(OrgName)) {
			System.out.println("Organization Name is Created");
		} else {
			System.out.println("Organization name not created");
		}
	}
}