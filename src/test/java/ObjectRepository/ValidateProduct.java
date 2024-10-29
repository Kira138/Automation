package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateProduct {

	public ValidateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void validateProductName(WebDriver driver,String ProductName)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();

		if (actData.contains(ProductName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name not created");
		}
	}
}
