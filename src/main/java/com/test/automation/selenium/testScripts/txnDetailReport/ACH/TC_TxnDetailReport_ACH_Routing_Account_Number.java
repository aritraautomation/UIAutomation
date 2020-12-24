package com.test.automation.selenium.testScripts.txnDetailReport.ACH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_TxnDetailReport_ACH_Routing_Account_Number {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	String txtExternalRefID = null;
	String txtAccountNumber = null;
	String txtAmount = null;
	String txtTxnMethod = null;
	String txtDate = null;
	String txtTime = null;
	String txtDateTime = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		TxnDetailReportACH txndtlrprt = new TxnDetailReportACH();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		txndtlrprt.vtRoutingAccountNumber(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRoutingAccountNumber(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRoutingAccountNumber(8, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDtlRprtACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[8]/button", 1, 2);
			browser.excel.storeCellData("TxnDtlRprtACH_ACHReports", txtTxnID, 5, 5);
			browser.excel.storeCellData("TxnDtlRprtACH_Report", "text::"+txtTxnID, 4, 21);
						
			txtAccountNumber = driver.findElement(By.xpath("//b[contains(text(),'Account Number')]/../../td[2]")).getText();
			browser.excel.storeCellData("TxnDtlRprtACH_Report", "text::"+txtAccountNumber, 4, 5);
			
			txtTxnMethod = driver.findElement(By.xpath("//b[contains(text(),'Transaction Method')]/../../td[2]")).getText();
			browser.excel.storeCellData("TxnDtlRprtACH_Report", "text::"+txtTxnMethod, 4, 7);
			
			txtExternalRefID = driver.findElement(By.xpath("//b[contains(text(),'External Ref ID')]/../../td[2]")).getText();
			browser.excel.storeCellData("TxnDtlRprtACH_Report", "text::"+txtExternalRefID, 4, 24);
			
			txtDate = driver.findElement(By.xpath("//b[contains(text(),'Date')]/../../td[2]")).getText();
			txtTime = driver.findElement(By.xpath("//b[contains(text(),'Time')]/../../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("TxnDtlRprtACH_Report", "text::"+txtDateTime, 4, 18);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtRoutingAccountNumber(12, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReport(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtACHReports(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtACHReports(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtACHReports(8, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReport(4, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}
