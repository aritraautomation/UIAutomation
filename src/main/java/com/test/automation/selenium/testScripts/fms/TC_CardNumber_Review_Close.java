package com.test.automation.selenium.testScripts.fms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_CardNumber_Review_Close {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	Boolean match = false;
				
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
		
		fms.cardNumber(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(22, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(8, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(24, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(12, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("FMS_Home", "xpath:://span[text()='"+txtTxnID+"']/../../td[3]/span", 1, 9);
			browser.excel.storeCellData("FMS_Home", "text::"+txtTxnID, 24, 9);
			browser.excel.storeCellData("FMS_Home", "xpath:://span[text()='"+txtTxnID+"']/../../td[5]/span", 1, 10);
			browser.excel.storeCellData("FMS_Home", "xpath:://span[text()='"+txtTxnID+"']/../../td[7]/span[2]", 1, 11);
			Thread.sleep(1000);			
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		fms.vtSale(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(14, browser, logresult);
		Thread.sleep(1000);
		
		/*fms.fmsHome(16, browser, logresult);
		Thread.sleep(1000);*/
		
		fms.fmsHome(24, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(26, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsTransactionManager(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsTransactionManager(12, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsTransactionManager(14, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsTransactionManager(16, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(14, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(16, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(18, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(20, browser, logresult);
		Thread.sleep(1000);
		
		fms.cardNumber(10, browser, logresult);
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

