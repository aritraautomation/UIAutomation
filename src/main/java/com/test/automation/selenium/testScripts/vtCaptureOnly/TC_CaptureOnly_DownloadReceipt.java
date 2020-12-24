package com.test.automation.selenium.testScripts.vtCaptureOnly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_CaptureOnly_DownloadReceipt {
	
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
			browser.excel.storeCellData("VTCaptureOnly_Capture", txtTxnID, 5, 2);
			browser.excel.storeCellData("VTCaptureOnly_Capture", "valueattribute::"+txtTxnID, 8, 4);
			browser.excel.storeCellData("VTCaptureOnly_Capture", "text::"+txtTxnID, 10, 12);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtAuth(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDownload(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDownload(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCaptureOnly(12, browser, logresult);
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
