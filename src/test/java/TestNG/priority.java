package TestNG;

import org.testng.annotations.Test;

public class priority {

@Test(priority=0)
public void createProduct()
{
	System.out.println("Product Created");
	}

@Test(priority=1)
public void ModifyProduct()
{
	System.out.println("Product Modified");
	}

@Test(priority=-1)
public void DeleteProduct()
{
	System.out.println("Product Deleted");
	}
}
