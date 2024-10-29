package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreateNavigationPage {
	public CampaignCreateNavigationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement plusSign;

	public WebElement getPlusSign() {
		return plusSign;
	}

	public void clickCampPlus()
	{
		plusSign.click();
	}
}

