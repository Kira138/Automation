package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult; //check mobile recording for the steps

public class ListenerImplementation implements ITestListener {


	@Override
	public void onTestFailure(ITestResult result) {
	TakesScreenshot takescreenshot=(TakesScreenshot)BaseClass.sdriver;
	File src=takescreenshot.getScreenshotAs(OutputType.FILE);
	File dest=new File("./FailedTestScript.png");
	try
	{
		FileUtils.copyFile(src, dest);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}




}
