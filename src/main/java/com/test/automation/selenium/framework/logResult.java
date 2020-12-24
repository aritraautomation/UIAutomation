package com.test.automation.selenium.framework;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class logResult {

	public String appURL = "";
	public int testPassCount = 0;
	public static int testFailCount = 0;
	static OutputStream htmlfile = null;
	static PrintStream printhtml = null;
	
	public ExtentHtmlReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTest paretntTest;
	public ExtentTest childTest;
	public static ExcelUtil excel = new ExcelUtil();
	
	public InetAddress localhost;
	
	//public Capabilities capability = null;
	//public WebDriver driver = null;
	
	public Browser browser = new Browser(this);
	//public WebDriver driver;
	//DesiredCapabilities capabilities;
	
	public  logResult() throws Exception {
				
		String Path = System.getProperty("user.dir") + "/" + Environment.resultDir + "/AutomationReport" + ".html";
		reporter = new ExtentHtmlReporter(Path);
		reporter.config().setDocumentTitle("Automation Report");//Title of the report
		reporter.config().setReportName("Regression Report");//Name of the report
		reporter.config().setTheme(Theme.DARK);
	
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		appURL = excel.getCellData("D:\\GETUIAutomationRegression\\Driver.xlsx", "Application Initialization", 3, 1);
		
		
		//capability = ((RemoteWebDriver) driver).getCapabilities();
	
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Hostname", localhost.getHostName());
		extent.setSystemInfo("IPAddress", localhost.getHostAddress().trim());
		extent.setSystemInfo("Application URL", appURL);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		//extent.setSystemInfo("Browser", capability.getBrowserName());
		//extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Tester", System.getProperty("user.name"));
	}
	
	public  void startTest(String testSuiteName,String testName) {
		childTest = paretntTest.createNode(testName);
		childTest.assignCategory(testSuiteName);
					
	}
	
	public  void init(String testSuiteName) {	
		
		paretntTest = extent.createTest(testSuiteName);
					
	}
	
	public  void logTest(String name1, String name2, String name3, String name4, String name5, String name6) {

		System.out.println(
				"output ->" + name1 + "<->" + name2 + "<->" + name3 + "<->" + name4 + "<->" + name5 + "<->" + name6);
		String dtls;
		if (name4.isEmpty())
			dtls = name5;
		else
			dtls = name4 + "::" + name5;

		switch (name3.toUpperCase()) {
		case "PASS":
			childTest.log(Status.PASS, name1 + "::" + name2);
			break;

		case "FAIL":
			childTest.log(Status.FAIL, name1 + "::" + name2);

			break;

		case "INFO":
			childTest.log(Status.INFO, name1 + "::" + name2);
			break;
		}
	}

	public  void endTest() {
		extent.flush();
	}

	public void closeReport() {
		extent.flush();
	}

	public static String CaptureScreen(WebDriver driver, String ImagesPath) {
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagesPath + ".jpg");
		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ImagesPath + ".jpg";
	}
}
