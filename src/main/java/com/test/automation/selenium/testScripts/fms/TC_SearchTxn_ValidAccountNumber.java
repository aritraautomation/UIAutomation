package com.test.automation.selenium.testScripts.fms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_SearchTxn_ValidAccountNumber {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	String txtDate = null;
	String txtTime = null;
	String txtDateTime = null;
	String txtTxnType = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		FMS fms = new FMS();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(6, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(6, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(8, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(12, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtACH(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtACH(6, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtTxnID = driver.findElement(By.xpath("//td[@id='transaction_id']")).getText();
			browser.excel.storeCellData("FMS_Search", "xpath:://span[text()='"+txtTxnID+"']/../../td[1]/span", 1, 9);
			browser.excel.storeCellData("FMS_Search", "xpath:://span[text()='"+txtTxnID+"']/../../td[3]/span", 1, 11);
			browser.excel.storeCellData("FMS_Search", "xpath:://span[text()='"+txtTxnID+"']/../../td[4]/span", 1, 12);
			browser.excel.storeCellData("FMS_Search", "xpath:://span[text()='"+txtTxnID+"']/../../td[5]/span", 1, 13);
			browser.excel.storeCellData("FMS_Search", "xpath:://span[text()='"+txtTxnID+"']/../../td[6]/span", 1, 14);
			browser.excel.storeCellData("FMS_Search", "text::"+txtTxnID, 32, 11);
			
			txtDate = driver.findElement(By.xpath("//b[contains(text(),'Date')]/../../td[2]")).getText();
			txtTime = driver.findElement(By.xpath("//b[contains(text(),'Time')]/../../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("FMS_Search", "text::"+txtDateTime, 32, 9);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		fms.vtACH(8, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsSearch(22, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsSearch(14, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsSearch(32, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(14, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(16, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(18, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(20, browser, logresult);
		Thread.sleep(1000);
		
		fms.maxAmountLimit(10, browser, logresult);
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

