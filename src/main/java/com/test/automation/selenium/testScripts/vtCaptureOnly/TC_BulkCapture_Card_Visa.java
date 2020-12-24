package com.test.automation.selenium.testScripts.vtCaptureOnly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_BulkCapture_Card_Visa {
	
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
		VTCaptureOnly vt = new VTCaptureOnly();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtAuth(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAuth(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAuth(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAuth(10, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Capture", "text::"+txtTxnID, 14, 15);
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[1]", 1, 20);	//Checkbox
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[2]", 1, 14);	//Date & Time
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[4]", 1, 15);	//Txn ID
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[5]", 1, 16);	//Amount
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[7]", 1, 17);	//Card Number
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[8]", 1, 18);	//Type
			browser.excel.storeCellData("VTCaptureOnly_Capture", "xpath:://span[text()='"+txtTxnID+"']/../../td[12]", 1, 19);	//Status
			
			txtDate = driver.findElement(By.xpath("//td[contains(text(),'Date')]/../td[2]")).getText();
			txtTime = driver.findElement(By.xpath("//td[contains(text(),'Time')]/../td[2]")).getText();
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("VTCaptureOnly_Capture", "text::"+txtDateTime, 14, 14);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Capture", "text::"+txtCardNumber, 14, 17);
			
			txtPaymentType = driver.findElement(By.xpath("//td[contains(text(),'Payment Type')]/../td[2]")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Capture", "text::"+txtPaymentType, 14, 18);			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtAuth(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(16, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(18, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(20, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(22, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(24, browser, logresult);
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

