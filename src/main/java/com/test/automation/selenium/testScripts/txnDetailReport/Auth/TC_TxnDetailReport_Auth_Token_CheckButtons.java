package com.test.automation.selenium.testScripts.txnDetailReport.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_TxnDetailReport_Auth_Token_CheckButtons {
	
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
	String txtTokenNumber = null;
				
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
		
		txndtlrprt.vtRequestCardToken(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRequestCardToken(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRequestCardToken(12, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRequestCardToken(24, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtTokenNumber = driver.findElement(By.id("requestTokenCopyInput")).getAttribute("value");
			browser.excel.storeCellData("TxnDetailReportAuth_CheckButton", "text::"+txtTokenNumber, 6, 3);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtRequestCardToken(10, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtToken(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtToken(6, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			WebElement txtToken = driver.findElement(By.id("tokenId"));
			txtToken.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		txndtlrprt.vtToken(14, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtToken(20, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDetailReportAuth_Dashboard", "xpath:://table[@class='rtable']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[7]/button", 1, 2);
			browser.excel.storeCellData("TxnDetailReportAuth_CheckButton", "text::"+txtTxnID, 6, 2);
			browser.excel.storeCellData("TxnDetailReportAuth_CardReports", txtTxnID, 5, 5);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtToken(12, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReportCheckButton(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(8, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReportCheckButton(6, browser, logresult);
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

