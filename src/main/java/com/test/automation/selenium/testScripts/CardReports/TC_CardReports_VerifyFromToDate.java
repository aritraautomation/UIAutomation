package com.test.automation.selenium.testScripts.CardReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_CardReports_VerifyFromToDate {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtPageTitle = null;
	String txtFromDate = null;
	String txtToDate = null;
	String txtTRLFromDate = null;
	String txtTRLToDate = null;
	String txtSTRLFromDate = null;
	String txtSTRLToDate = null;
	String txtUTRLFromDate = null;
	String txtUTRLToDate = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		CardReports cr = new CardReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		cr.searchTransaction(4, browser, logresult);
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
		
		cr.searchTransaction(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtPageTitle = driver.findElement(By.xpath("//div[@class='title']/h1")).getText();
			txtTRLFromDate = driver.findElement(By.id("startDate")).getAttribute("value");
			txtTRLToDate = driver.findElement(By.id("endDate")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "Title of the page: ", txtPageTitle, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Transaction Report List - From Date: ", txtTRLFromDate, "");
			logresult.logTest("Test Execution", "Status", "INFO", "Transaction Report List - To Date: ", txtTRLToDate, "");
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		if(txtTRLFromDate.equals(txtFromDate) && txtTRLToDate.equals(txtToDate)){
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Reports' and 'Transaction Report List' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Reports' and 'Transaction Report List' pages!!!", "");
		}
		
		cr.verifyCardReports(12, browser, logresult);
		Thread.sleep(1000);
		
		cr.searchTransaction(44, browser, logresult);
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
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Reports' and 'Settled Transaction Report List' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Reports' and 'Settled Transaction Report List' pages!!!", "");
		}
		
		cr.cardReportsCheckButton(22, browser, logresult);
		Thread.sleep(1000);
		
		cr.searchTransaction(46, browser, logresult);
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
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' matched in 'Reports' and 'Unsettled Transaction Report List' pages!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "'From Date' and 'To Date' not matched in 'Reports' and 'Unsettled Transaction Report List' pages!!!", "");
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

