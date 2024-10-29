package Organization;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationNavigationPage;
import ObjectRepository.ValidateOrganization;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws Throwable {
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

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrganizationNavigationPage orgPlus = new OrganizationNavigationPage(driver);
		orgPlus.clickOrgPlus();

		int ranNum = jlib.getRandomNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		System.out.println(OrgName);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.enterOrgName(OrgName);


		// --------------------------------------------------------------------------------------------

		String PhoneNum = elib.getExcelDataUsingFormatter("Organization", 0, 1);
		System.out.println(PhoneNum);
		orgPage.enterPhnNum(PhoneNum);

		// ------------------------------------------------------------------------------------------

		String Email = elib.getExcelDataUsingFormatter("Organization", 0, 2);
		System.out.println(Email);
		orgPage.enterMailId(Email);

		// -------------------------------------------------------------------------------------------

		orgPage.clickSaveButton();

		ValidateOrganization validate = new ValidateOrganization(driver);
		validate.ValidateOrgName(driver, OrgName);

	      home.logOut(driver);
	}

}
