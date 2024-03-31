package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
	String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test execution started-------");
		
		//add @Test toextent reports
		test=report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test PASS-------");
		
		//Log the Pass status to extent report
		test.log(Status.PASS,methodName+"-------Test PASS-------");
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test FAIL-------");
		
		
		//Log the FAIL status to extent report
		test.log(Status.FAIL,methodName+"-------Test FAIL-------");
				
		
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		String screenShotName=methodName+"-"+j.getDate();
		
		try {
		String path=s.captureScreenshot(BaseClass.sDriver, screenShotName);
			
			//Attach screenshot to extent report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-------Test SKIP-------");
		
		//Log the SKIP status to extent report
		test.log(Status.SKIP,methodName+"-------Test SKIP-------");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("----Suite Execution started-----------");
		
		//extent Report configuration
		ExtentSparkReporter rep=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("vtiger execution report");
		rep.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Platform","windows");
		report.setSystemInfo("Base Browser","chrome");
		report.setSystemInfo("Base Url","http://localhost:8888");  //url of app
		report.setSystemInfo("Reporter Name", "Chaitra");
		
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("----Suite Execution Finished-----------");
		
		//Generate extent report
		report.flush();  //generates report
	}
	
	

}
