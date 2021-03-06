package com.test.automation.selenium.testScripts.txnDetailReport.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_TxnDetailReport_Auth_Card_MasterCard_None {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	String txtExpDate = null;
	String txtCardNumber = null;
	String txtAmount = null;
	String txtDOP = null;
	String txtPaymentType = null;
	String txtDate = null;
	String txtTime = null;
	String txtDateTime = null;
	String txtAuthCode = null;
	String txtDataSource = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		TxnDetailReportAuth txndtlrprt = new TxnDetailReportAuth();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		txndtlrprt.vtCard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCard(14, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtExpDate = driver.findElement(By.id("expirationDate")).getAttribute("value");
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtExpDate, 4, 5);
			
			txtDataSource = driver.findElement(By.xpath("//div[@id='cardDataSource']/button/div/span")).getText();
			if (txtDataSource.equals("MANUAL")){
				
				txtDataSource = txtDataSource+"ENTRY";
				browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtDataSource, 4, 11);
			}
			else{
				browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtDataSource, 4, 11);				
			}
						
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtCard(26, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDetailReportAuth_Dashboard", "xpath:://table[@class='rtable']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[7]/button", 1, 2);
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtTxnID, 4, 14);
			browser.excel.storeCellData("TxnDetailReportAuth_CardReports", txtTxnID, 5, 5);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtCardNumber, 4, 4);
			
			txtDOP = driver.findElement(By.xpath("//td[contains(text(),'Description of purchase')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtDOP, 4, 6);
			
			txtPaymentType = driver.findElement(By.xpath("//td[contains(text(),'Payment Type')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtPaymentType, 4, 7);
			
			txtAuthCode = driver.findElement(By.xpath("//td[contains(text(),'Auth Code')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtAuthCode, 4, 15);
			
			txtDate = driver.findElement(By.xpath("//td[contains(text(),'Date')]/../td[2]")).getText();
			txtTime = driver.findElement(By.xpath("//td[contains(text(),'Time')]/../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("TxnDetailReportAuth_ReportNone", "text::"+txtDateTime, 4, 23);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtCard(12, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReportNone(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(8, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReportNone(4, browser, logresult);
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

