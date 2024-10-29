package TestNG;

import org.testng.annotations.Test;

public class enabled {

@Test
	public void createProduct()
	{
		System.out.println("Product Created");
		}

	@Test (enabled=false)
	public void ModifyProduct()
	{
		System.out.println("Product Modified");
		}

	@Test (invocationCount=2)
	public void DeleteProduct()
	{
		System.out.println("Product Deleted");
		}
	}


