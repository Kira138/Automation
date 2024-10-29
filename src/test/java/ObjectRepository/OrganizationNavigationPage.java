package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationNavigationPage {

	public OrganizationNavigationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[alt=\"Create Organization...\"]")
	private WebElement plusSign;

	public WebElement getPlusSign() {
		return plusSign;
	}

	public void clickOrgPlus()
	{
		plusSign.click();
	}
}

