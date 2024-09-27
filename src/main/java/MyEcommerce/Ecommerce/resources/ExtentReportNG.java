package MyEcommerce.Ecommerce.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\+index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Work");
		reporter.config().setDocumentTitle("Automation By Harry");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("SDET-1", "Harpreet Sindhia");
		return extent;
	}
}
