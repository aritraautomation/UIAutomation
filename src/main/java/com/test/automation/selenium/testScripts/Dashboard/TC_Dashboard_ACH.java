package com.test.automation.selenium.testScripts.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Dashboard_ACH {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
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
		VTACH vt = new VTACH();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtRoutingAccountNumber(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(26, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']", 1, 4);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtTxnID, 6, 4);
						
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[3]", 1, 3);
			
			txtAccountNumber = driver.findElement(By.xpath("//b[contains(text(),'Account Number')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[1]", 1, 2);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtAccountNumber, 6, 2);
						
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[4]", 1, 5);
			
			txtDate = driver.findElement(By.xpath("//b[contains(text(),'Date')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[5]", 1, 6);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtDate, 6, 6);
			
			txtTime = driver.findElement(By.xpath("//b[contains(text(),'Time')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[6]", 1, 7);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtTime, 6, 7);
			
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[contains(@class,'rtable1')]/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[7]", 1, 8);
						
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtRoutingAccountNumber(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDashboard(6, browser, logresult);
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

