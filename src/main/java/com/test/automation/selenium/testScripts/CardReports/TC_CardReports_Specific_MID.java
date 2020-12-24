package com.test.automation.selenium.testScripts.CardReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_CardReports_Specific_MID {
	
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
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		CardReports cr = new CardReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		cr.processSaleTxn(4, browser, logresult);
		Thread.sleep(1000);
		
		cr.processSaleTxn(6, browser, logresult);
		Thread.sleep(1000);
		
		cr.processSaleTxn(8, browser, logresult);
		Thread.sleep(10000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[2]/span", 1, 2); //Date:Time
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[3]/span", 1, 3); //MID
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']", 1, 4); //Txn ID
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[5]/span", 1, 5); //Amount
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[6]/span", 1, 6); //Customer Number
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[7]/span", 1, 7); //Card Number
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[8]/span", 1, 8); //Type
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[9]/span", 1, 9); //Customer Name
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[10]/span", 1, 10); //Recurring
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[11]/span", 1, 11); //Currency
			browser.excel.storeCellData("CardReports_Reports", "xpath:://table[@class='rtable']/tbody/tr[*]/td[4]/span[text()='"+txtTxnID+"']/../../td[12]/span", 1, 12); //Status
			
			txtDate = driver.findElement(By.xpath("//td[contains(text(),'Date')]/../td[2]")).getText();
			txtTime = driver.findElement(By.xpath("//td[contains(text(),'Time')]/../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("CardReports_Reports", "text::"+txtDateTime, 4, 2);
			
			browser.excel.storeCellData("CardReports_Reports", "text::"+txtTxnID, 4, 4);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("CardReports_Reports", "text::"+txtCardNumber, 4, 7);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		cr.processSaleTxn(10, browser, logresult);
		Thread.sleep(1000);
		
		cr.searchTransaction(4, browser, logresult);
		Thread.sleep(1000);
		
		cr.searchTransaction(8, browser, logresult);
		Thread.sleep(1000);
		
		cr.verifyCardReports(4, browser, logresult);
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

