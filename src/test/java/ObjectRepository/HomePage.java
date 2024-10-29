package ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	//element initilaization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//element declaration
	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Products")
	private WebElement prdLink;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdmLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	//getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	//Bussiness Logics
	/**
	 * This method is used to click more link
	 */
	public void clickMoreLink()
	{
		moreLink.click();
	}
	/**
	 * This method is used to click on campaigns click
	 */
	public void clickCampLink()
	{
		campaignsLink.click();
	}

	public void clickOrgLink()
	{
		orgLink.click();
	}

	public void clickProductLink()
	{
		prdLink.click();
	}

	public void logOutFromApp()
	{
		AdmLink.click();
		signOutLink.click();
	}

	public void logOut(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(AdmLink).perform();
		signOutLink.click();
	}
}


