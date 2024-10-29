package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class FetchingdatafromDB {

	public static void main(String[] args) throws Throwable {
		// Step1:- register/load mysql database
		    String url = "jdbc:mysql://localhost:3306/trainer_details";
	        String username = "KinuVanu";
	        String password = "KinuVanu";

		// step2:-get the connect of database                                       //database name
	        Connection conn = DriverManager.getConnection(url, username, password);

		// step3:- create SQL Statement
		Statement state = conn.createStatement();
		                              //tablename
		String query = "select * from trainerr";

		// step4:- execute statement
		                         //reading data from DB
		ResultSet result = state.executeQuery(query);
     while(result.next()) {
	System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
			+ result.getString(4));
}
  // step5:- close the database
conn.close();
	}

}
