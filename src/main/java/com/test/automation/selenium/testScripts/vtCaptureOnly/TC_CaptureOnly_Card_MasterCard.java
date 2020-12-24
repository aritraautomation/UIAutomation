package com.test.automation.selenium.testScripts.vtCaptureOnly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_CaptureOnly_Card_MasterCard {
	
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
		
		vt.vtAuth(14, browser, logresult);
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
		
		/*try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']", 1, 3);
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "text::"+txtTxnID, 6, 3);
			browser.excel.storeCellData("VTCaptureOnly_CardReports", txtTxnID, 5, 5);
			browser.excel.storeCellData("VTCaptureOnly_CardReports", "text::"+txtTxnID, 8, 8);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[1]", 1, 2);
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "text::"+txtCardNumber, 6, 2);
			browser.excel.storeCellData("VTCaptureOnly_CardReports", "text::"+txtCardNumber, 8, 10);
			
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[3]", 1, 4);
			
			txtPaymentType = driver.findElement(By.xpath("//td[contains(text(),'Payment Type')]/../td[2]")).getText();
			browser.excel.storeCellData("VTCaptureOnly_CardReports", "text::"+txtPaymentType, 8, 11);
			
			txtDate = driver.findElement(By.xpath("//td[contains(text(),'Date')]/../td[2]")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[4]", 1, 5);
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "text::"+txtDate, 6, 5);
			
			txtTime = driver.findElement(By.xpath("//td[contains(text(),'Time')]/../td[2]")).getText();
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[5]", 1, 6);
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "text::"+txtTime, 6, 6);
			
			browser.excel.storeCellData("VTCaptureOnly_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[6]", 1, 7);
			
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("VTCaptureOnly_CardReports", "text::"+txtDateTime, 8, 7);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}*/
		
		vt.vtCaptureOnly(12, browser, logresult);
		Thread.sleep(1000);
		
		/*vt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCardReports(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCardReports(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCardReports(8, browser, logresult);
		Thread.sleep(1000);*/
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}
