package com.test.automation.selenium.testScripts.ACHReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACHReports_All_MIDs {
	
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
		ACHReports ar = new ACHReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		ar.processTxn(4, browser, logresult);
		Thread.sleep(1000);
		
		ar.processTxn(6, browser, logresult);
		Thread.sleep(1000);
		
		ar.processTxn(8, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("ACHReports_Reports", "text::"+txtTxnID, 4, 4);
			
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[1]/span", 1, 2); //Date:Time
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[2]/span", 1, 3); //MID
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']", 1, 4); //Txn ID
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[4]/span", 1, 5); //Amount
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[5]/span", 1, 6); //Account Number
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[6]/span", 1, 7); //Route Number
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[7]/span", 1, 8); //Type
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[8]/span", 1, 9); //Txn Method
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[9]/span", 1, 10); //Customer Name
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[10]/span", 1, 11); //Customer Number
			browser.excel.storeCellData("ACHReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[3]/span[text()='"+txtTxnID+"']/../../td[11]/span", 1, 12); //Status
			
			txtAccountNumber = driver.findElement(By.xpath("//b[contains(text(),'Account Number')]/../../td[2]")).getText();
			browser.excel.storeCellData("ACHReports_Reports", "text::"+txtAccountNumber, 4, 6);
			
			txtTxnMethod = driver.findElement(By.xpath("//b[contains(text(),'Transaction Method')]/../../td[2]")).getText();
			browser.excel.storeCellData("ACHReports_Reports", "text::"+txtTxnMethod, 4, 9);
			
			txtDate = driver.findElement(By.xpath("//b[contains(text(),'Date')]/../../td[2]")).getText();			
			txtTime = driver.findElement(By.xpath("//b[contains(text(),'Time')]/../../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("ACHReports_Reports", "text::"+txtDateTime, 4, 2);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		ar.processTxn(12, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(4, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(6, browser, logresult);
		Thread.sleep(1000);
		
		ar.verifyACHReports(4, browser, logresult);
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

