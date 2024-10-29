package TestNG;

import org.testng.annotations.Test;

public class DependsonMethod {

@Test
	public void createProduct()
	{
		System.out.println("Product Created");
		}

	@Test (dependsOnMethods="createProduct")
	public void ModifyProduct()
	{
		System.out.println("Product Modified");
		}

	@Test (dependsOnMethods="createProduct")
	public void DeleteProduct()
	{
		System.out.println("Product Deleted");
		}
	}


