package com.test.automation.selenium.testScripts.ACHReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACHReports_VerifyFromToDate {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtPageTitle = null;
	String txtFromDate = null;
	String txtToDate = null;
	String txtARFromDate = null;
	String txtARToDate = null;
	String txtSTRLFromDate = null;
	String txtSTRLToDate = null;
	String txtUTRLFromDate = null;
	String txtUTRLToDate = null;
	String txtARMRFromDate = null;
	String txtARMRToDate = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		ACHReports ar = new ACHReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		ar.searchTransaction(4, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtPageTitle = driver.findElement(By.xpath("//div[@class='title']/h1")).getText();
			txtFromDate = driver.findElement(By.id("startDate")).getAttribute("value");
			txtToDate = driver.findElement(By.id("endDate")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "Title of the page: ", txtPageTitle, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Report - From Date: ", txtFromDate, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Report - To Date: ", txtToDate, "");
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		ar.searchTransaction(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtPageTitle = driver.findElement(By.xpath("//div[@class='title']/h1")).getText();
			txtARFromDate = driver.findElement(By.id("startDate")).getAttribute("value");
			txtARToDate = driver.findElement(By.id("endDate")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "Title of the page: ", txtPageTitle, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Transaction Report List - From Date: ", txtARFromDate, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Transaction Report List - To Date: ", txtARToDate, "");
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		if(txtARFromDate.equals(txtFromDate) && txtARToDate.equals(txtToDate)){
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Report' and 'ACH Reports' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Report' and 'ACH Reports' pages!!!", "");
		}
		
		ar.verifyACHReports(10, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(40, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtPageTitle = driver.findElement(By.xpath("//div[@class='title']/h1")).getText();
			txtSTRLFromDate = driver.findElement(By.id("startDate")).getAttribute("value");
			txtSTRLToDate = driver.findElement(By.id("endDate")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "Title of the page: ", txtPageTitle, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Settled Transaction Report List - From Date: ", txtSTRLFromDate, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Settled Transaction Report List - To Date: ", txtSTRLToDate, "");
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		if(txtSTRLFromDate.equals(txtFromDate) && txtSTRLToDate.equals(txtToDate)){
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Reports' and 'Settled Transactions' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Reports' and 'Settled Transactions' pages!!!", "");
		}
		
		ar.verifyACHReports(10, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(42, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtPageTitle = driver.findElement(By.xpath("//div[@class='title']/h1")).getText();
			txtUTRLFromDate = driver.findElement(By.id("startDate")).getAttribute("value");
			txtUTRLToDate = driver.findElement(By.id("endDate")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "Title of the page: ", txtPageTitle, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Settled Transaction Report List - From Date: ", txtUTRLFromDate, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Settled Transaction Report List - To Date: ", txtUTRLToDate, "");
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		if(txtUTRLFromDate.equals(txtFromDate) && txtUTRLToDate.equals(txtToDate)){
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Reports' and 'Unauthorized Returns' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Reports' and 'Unauthorized Returns' pages!!!", "");
		}
		
		ar.verifyACHReports(10, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(44, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtPageTitle = driver.findElement(By.xpath("//div[@class='title']/h1")).getText();
			txtARMRFromDate = driver.findElement(By.id("startDate")).getAttribute("value");
			txtARMRToDate = driver.findElement(By.id("endDate")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "Title of the page: ", txtPageTitle, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Settled Transaction Report List - From Date: ", txtARMRFromDate, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Settled Transaction Report List - To Date: ", txtARMRToDate, "");
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		if(txtARMRFromDate.equals(txtFromDate) && txtARMRToDate.equals(txtToDate)){
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Reports' and 'Admin Returns Management' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Reports' and 'Admin Returns Management' pages!!!", "");
		}
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}

