package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateOrganizationPage {
	 // WebDriver instance
    WebDriver driver;

    // Constructor to initialize WebDriver
    public CreateOrganizationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for organization page elements (Update the locators based on your actual HTML elements)
    private By orgNameField = By.name("accountname"); // Example: Update with actual locator
    private By phoneField = By.name("phone"); // Example: Update with actual locator
    private By emailField = By.name("email1"); // Example: Update with actual locator
    private By saveButton = By.xpath("//input[@title='Save [Alt+S]']"); // Example: Update with actual locator

    // Method to enter the organization name
    public void enterOrgName(String orgName) {
        WebElement orgNameElement = driver.findElement(orgNameField);
        orgNameElement.sendKeys(orgName);
    }

    // Method to enter the phone number
    public void enterPhnNum(String phoneNum) {
        WebElement phoneElement = driver.findElement(phoneField);
        phoneElement.sendKeys(phoneNum);
    }

    // Method to enter the email address
    public void enterMailId(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    // Method to click the 'Save' button
    public void clickSaveButton() {
        WebElement saveBtn = driver.findElement(saveButton);
        saveBtn.click();
    }
}
