package com.test.automation.selenium.testScripts.fms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_StreetAddress_Review_Matched {
	
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
		
		fms.streetAddress(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(22, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(8, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(24, browser, logresult);
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
			browser.excel.storeCellData("FMS_Dashboard", "text::"+txtTxnID, 8, 3);
			browser.excel.storeCellData("FMS_Home", "xpath:://span[text()='"+txtTxnID+"']/../../td[5]/span", 1, 10);
			browser.excel.storeCellData("FMS_Dashboard", "xpath:://td[text()='"+txtTxnID+"']/../td[7]/button", 1, 2);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		fms.vtSale(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(8, browser, logresult);
		Thread.sleep(1000);
		
		/*fms.fmsHome(16, browser, logresult);
		Thread.sleep(1000);*/
		
		fms.fmsHome(24, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(14, browser, logresult);
		Thread.sleep(1000);
		
		/*fms.fmsHome(16, browser, logresult);
		Thread.sleep(1000);*/
		
		fms.fmsHome(24, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(14, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(16, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(18, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(20, browser, logresult);
		Thread.sleep(1000);
		
		fms.streetAddress(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsDashboard(8, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsDashboard(12, browser, logresult);
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

