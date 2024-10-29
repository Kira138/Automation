package Generic_Utility;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener {

	ExtentTest test;
	ExtentReports report;

    @Override
	public void onStart(ITestContext context) {
		String time = new Date().toString().replace(" ","_" ).replace(":", "_");
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/Reports.html"+time);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Shobha");
		spark.config().setTheme(Theme.DARK);

		//System Configuration
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("PlatForm", "Windows10");
		report.setSystemInfo("ExecutedBy", "Kiran");
		report.setSystemInfo("ReviewedBy", "Shobha");
	 }

	@Override
	public void onTestStart(ITestResult result) {//@Test
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		System.out.println("--->>Test pass<<----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		System.out.println("--->>Test FAIL<<----");

	String screenShot = null;
	try {

		screenShot=WebDriver_utility.takeScreenShot1(BaseClass.sdriver, result.getMethod().getMethodName());
	} catch (Throwable e) {

		e.printStackTrace();
	}
		test.addScreenCaptureFromPath(screenShot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		System.out.println("--->>Test SKIP<<----");

	}


	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}


}
