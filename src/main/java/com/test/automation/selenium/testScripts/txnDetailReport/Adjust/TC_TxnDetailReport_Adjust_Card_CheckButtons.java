package com.test.automation.selenium.testScripts.txnDetailReport.Adjust;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_TxnDetailReport_Adjust_Card_CheckButtons {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	String txtCardNumber = null;
	String txtAmount = null;
	String txtPaymentType = null;
	String txtDate = null;
	String txtTime = null;
	String txtDateTime = null;
	String txtExpDate = null;
	String txtDOP = null;
	String txtAuthCode = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		TxnDetailReportAdjust txndtlrprt = new TxnDetailReportAdjust();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		txndtlrprt.vtCard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCard(22, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCard(26, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDtlReportAdjust_Adjust", txtTxnID, 5, 2);
			browser.excel.storeCellData("TxnDtlReportAdjust_Adjust", "valueattribute::"+txtTxnID, 8, 4);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtCard(12, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtAdjust(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtAdjust(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtAdjust(8, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDtlReportAdjust_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[7]/button", 1, 2);
			browser.excel.storeCellData("TxnDtlReportAdjust_CheckButton", "text::"+txtTxnID, 4, 2);
			browser.excel.storeCellData("TxnDtlReportAdjust_CardReports", txtTxnID, 5, 5);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		
		txndtlrprt.vtAdjust(10, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReportCheckButton(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(8, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReportCheckButton(4, browser, logresult);
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

