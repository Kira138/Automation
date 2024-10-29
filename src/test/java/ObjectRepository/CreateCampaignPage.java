package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	// Constructor to initialize the WebElements
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    // WebElement for the campaign name input field
	@FindBy(name = "campaignname")
	private WebElement campName;

	// WebElement for the save button
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;


    // Getter method for the campaign name input field
	public WebElement getCampName() {
		return campName;
	}


    // Getter method for the save button
	public WebElement getSaveButton() {
	return saveButton;
	}

	// Method to enter the campaign name only (no saving)
	public void enterCampName(String Name)
	{
		campName.sendKeys(Name);  // Enters the campaign name in the input field
		//saveButton.click();
	}

	  // Method to click the save button when needed
	public void clickSaveButton() {
        saveButton.click();  // Clicks the save button
    }
}
