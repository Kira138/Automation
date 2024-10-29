package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProductPage {

    // Constructor to initialize the WebElements
    public CreateProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "productname")
	private WebElement productName;

    // WebElement for the + sign to add product
    @FindBy(xpath = "//img[@alt='Select']")
    private WebElement select;

    @FindBy(name = "search_text")
    private WebElement prodName;

    @FindBy(name = "search")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;

    public WebElement getProductName() {
		return productName;
	}

// Getter for the select product (+ button)
    public WebElement getSelect() {
        return select;
    }

    // Getter for the search text field
    public WebElement getProdName() {
        return prodName;
    }

    // Getter for the search button
    public WebElement getSearchButton() {
        return searchButton;
    }

    // Getter for the save button
    public WebElement getSaveButton() {
        return saveButton;
    }

    public void enterProductName(String Name)
	{
    	productName.sendKeys(Name);  // Enters the campaign name in the input field

	}


    // Method to click the + sign to add product
    public void clickSelect() {
        select.click();
    }

    // Method to enter the product name in the search field
    public void enterSearch(String prdName) {
        prodName.sendKeys(prdName);
    }

    // Method to click the search button
    public void clickSearch() {
        searchButton.click();
    }

    // Method to select the product dynamically
    public void selectProduct(String prdName, WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	WebElement selectPro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + prdName + "']")));
        selectPro.click();
    }

    // Method to click the save button
    public void clickSaveButton() {
        saveButton.click();
    }
}
