package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampaigns {

	public ValidateCampaigns(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void validateCampName(WebDriver driver,String CampName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(CampName)) {
			System.out.println("Campaigns Name is Created");
		} else {
			System.out.println("Campaigns name not created");
		}
	}
}
