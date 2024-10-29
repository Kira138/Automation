package Annotations;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CampaignCreateNavigationPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ValidateCampaigns;

public class CreateCampaignsTest extends BaseClass {

	@Test
	public void createCampaignsTest() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		// Reading data from file_utility
		String URL = flib.getkeyandvaluepair("url");
		String USERNAME = flib.getkeyandvaluepair("username");
		String PASSWORD = flib.getkeyandvaluepair("password");


		driver.get(URL);
        LoginPage login = new LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		//wlib.waitForElementsToLoad(driver);

		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampaignCreateNavigationPage camp = new CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();

		int ranNum = jlib.getRandomNum();

		String CampName = elib.getExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(CampName);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CampName);

		ValidateCampaigns valid = new ValidateCampaigns(driver);
		valid.validateCampName(driver, CampName);
		home.logOut(driver);
	}

}
