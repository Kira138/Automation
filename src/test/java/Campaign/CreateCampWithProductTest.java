package Campaign;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CampaignCreateNavigationPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductNavigationpage;
import ObjectRepository.ValidateProduct;



public class CreateCampWithProductTest extends BaseClass {

	@Test
	    public void createCampWithProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		String URL = flib.getkeyandvaluepair("url");
		String USERNAME = flib.getkeyandvaluepair("username");
		String PASSWORD = flib.getkeyandvaluepair("password");

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		//wlib.waitForElementsToLoad(driver);

		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductNavigationpage prodPlus = new ProductNavigationpage(driver);
		prodPlus.clickProdPlus();

		int ranNum = jlib.getRandomNum();

		String ProdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(ProdName);

		CreateProductPage ProdPage = new CreateProductPage(driver);
		ProdPage.enterProductName(ProdName);
		ProdPage.clickSaveButton();

		home.clickMoreLink();
		home.clickCampLink();

		CampaignCreateNavigationPage camp = new CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();

		String CampName = elib.getExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(CampName);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CampName);

		ProdPage.clickSelect();
		wlib.swithToWindow(driver, "Products&action");
		ProdPage.enterSearch(ProdName);
		ProdPage.clickSearch();
		ProdPage.selectProduct(ProdName, driver);
		wlib.swithToWindow(driver, "Campaigns&action");
		ProdPage.clickSaveButton();

		ValidateProduct valid = new ValidateProduct(driver);
		valid.validateProductName(driver, ProdName);
		home.logOut(driver);
}
}