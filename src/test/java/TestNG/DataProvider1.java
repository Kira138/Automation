package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

	@Test(dataProvider="setOfData")
	public void bookTickets(String src,String dest,String passengers){
		System.out.println("Book tickets from:"+src+ " to " +dest+ "  with "  +passengers+  "  passengers  ");
	}
	@DataProvider
	public Object[][] setOfData(){

		Object[][] obj=new Object[3][3];

		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		obj[0][2]="5";


		obj[1][0]="Bangalore";
		obj[1][1]="Delhi";
		obj[1][2]="8";


		obj[2][0]="Bangalore";
		obj[2][1]="Hyderabad";
		obj[2][2]="12";

		return obj;
}
}
