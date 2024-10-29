package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {


	/**
	 * This method is used to read the data from properties_file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getkeyandvaluepair(String key) throws IOException
	{
		// step1:- get the file path connection
				FileInputStream fis = new FileInputStream("C:\\Users\\kiran\\Downloads\\Commondata.txt");
						// step2:- load all the keys
						Properties pro = new Properties();
						pro.load(fis);

						// step3:- read key value
						String Value = pro.getProperty(key);
						return Value;
	}


}
