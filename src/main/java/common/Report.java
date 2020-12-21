package common;

import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	
	public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest testcase;
    private String OS = "";
    
    public Report(String OS) {
    	this.OS = OS;
    }
    
    
    public void startReport() {
    	Date date = new Date(System.currentTimeMillis());

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport-"+date+".html");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", OS);
    
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Upgrade Loan Offer Automation");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            testcase.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            testcase.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
        	testcase.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
        	testcase.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        	testcase.skip(result.getThrowable());
        }
    }
    
	@AfterClass
	public void tearDown() {
		extent.flush();
	}

}
