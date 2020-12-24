package com.test.automation.selenium.testScripts.txnDetailReport.CaptureOnly;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_TxnDetailReport_CaptureOnly_Token_MasterCard {
	
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
	String txtDataSource = null;
	String txtTokenNumber = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		TxnDetailReportCaptureOnly txndtlrprt = new TxnDetailReportCaptureOnly();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		txndtlrprt.vtRequestCardToken(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRequestCardToken(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtRequestCardToken(12, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtExpDate = driver.findElement(By.id("cardt_exp_date")).getAttribute("value");
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtExpDate, 6, 5);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtRequestCardToken(24, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtTokenNumber = driver.findElement(By.id("requestTokenCopyInput")).getAttribute("value");
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtTokenNumber, 6, 16);
			
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
		
		txndtlrprt.vtToken(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtDataSource = driver.findElement(By.xpath("//div[@id='cardDataSource']/button/div/span")).getText();
			if (txtDataSource.equals("MANUAL")){
				
				txtDataSource = txtDataSource+"ENTRY";
				browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtDataSource, 6, 11);
			}
			else{
				browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtDataSource, 6, 11);				
			}
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtToken(20, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDtlReportCapture_Capture", txtTxnID, 5, 2);
			browser.excel.storeCellData("TxnDtlReportCapture_Capture", "valueattribute::"+txtTxnID, 8, 4);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		txndtlrprt.vtToken(12, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCaptureOnly(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCaptureOnly(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCaptureOnly(8, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("TxnDtlReportCapture_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[7]/button", 1, 2);
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtTxnID, 6, 14);
			browser.excel.storeCellData("TxnDtlReportCapture_CardReports", txtTxnID, 5, 5);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtCardNumber, 6, 4);
			
			txtPaymentType = driver.findElement(By.xpath("//td[contains(text(),'Payment Type')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtPaymentType, 6, 7);
			
			txtAuthCode = driver.findElement(By.xpath("//td[contains(text(),'Auth Code')]/../td[2]")).getText();
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtAuthCode, 6, 15);
			
			txtDate = driver.findElement(By.xpath("//td[contains(text(),'Date')]/../td[2]")).getText();
			txtTime = driver.findElement(By.xpath("//td[contains(text(),'Time')]/../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("TxnDtlReportCapture_Report", "text::"+txtDateTime, 6, 23);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		
		txndtlrprt.vtCaptureOnly(10, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReport(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(4, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(6, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.vtCardReports(8, browser, logresult);
		Thread.sleep(1000);
		
		txndtlrprt.txnDetailReport(6, browser, logresult);
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

