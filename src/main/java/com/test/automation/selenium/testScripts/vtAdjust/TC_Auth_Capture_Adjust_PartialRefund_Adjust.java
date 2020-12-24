package com.test.automation.selenium.testScripts.vtAdjust;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Auth_Capture_Adjust_PartialRefund_Adjust {
	
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
		VTAdjust vt = new VTAdjust();
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
			
			browser.excel.storeCellData("VTAdjust_Capture", txtTxnID, 5, 2);
			browser.excel.storeCellData("VTAdjust_Capture", "valueattribute::"+txtTxnID, 8, 4);
			browser.excel.storeCellData("VTAdjust_Capture", "text::"+txtTxnID, 10, 12);
			
			browser.excel.storeCellData("VTAdjust_Adjust", txtTxnID, 5, 2);
			browser.excel.storeCellData("VTAdjust_Adjust", "valueattribute::"+txtTxnID, 8, 4);
			browser.excel.storeCellData("VTAdjust_Adjust", "valueattribute::"+txtTxnID, 14, 4);
			browser.excel.storeCellData("VTAdjust_Adjust", "text::"+txtTxnID, 10, 12);
			
			browser.excel.storeCellData("VTAdjust_Refund", txtTxnID, 5, 2);
			browser.excel.storeCellData("VTAdjust_Refund", "text::"+txtTxnID, 8, 4);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtAuth(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCapture(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCapture(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCapture(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCapture(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCapture(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRefund(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRefund(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRefund(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRefund(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRefund(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRefund(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtAdjust(10, browser, logresult);
		Thread.sleep(1000);
		
		
		/*try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("VTAdjust_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']", 1, 3);
			browser.excel.storeCellData("VTAdjust_Dashboard", "text::"+txtTxnID, 8, 3);
			browser.excel.storeCellData("VTAdjust_CardReports", txtTxnID, 5, 5);
			browser.excel.storeCellData("VTAdjust_CardReports", "text::"+txtTxnID, 10, 8);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("VTAdjust_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[1]", 1, 2);
			browser.excel.storeCellData("VTAdjust_Dashboard", "text::"+txtCardNumber, 8, 2);
			browser.excel.storeCellData("VTAdjust_CardReports", "text::"+txtCardNumber, 10, 10);
			
			browser.excel.storeCellData("VTAdjust_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[3]", 1, 4);
			
			txtPaymentType = driver.findElement(By.xpath("//td[contains(text(),'Payment Type')]/../td[2]")).getText();
			browser.excel.storeCellData("VTAdjust_CardReports", "text::"+txtPaymentType, 10, 11);
			
			txtDate = driver.findElement(By.xpath("//td[contains(text(),'Date')]/../td[2]")).getText();
			browser.excel.storeCellData("VTAdjust_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[4]", 1, 5);
			browser.excel.storeCellData("VTAdjust_Dashboard", "text::"+txtDate, 8, 5);
			
			txtTime = driver.findElement(By.xpath("//td[contains(text(),'Time')]/../td[2]")).getText();
			browser.excel.storeCellData("VTAdjust_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[5]", 1, 6);
			browser.excel.storeCellData("VTAdjust_Dashboard", "text::"+txtTime, 8, 6);
			
			browser.excel.storeCellData("VTAdjust_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[6]", 1, 7);
			
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("VTAdjust_CardReports", "text::"+txtDateTime, 10, 7);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}*/
		
		vt.vtAdjust(12, browser, logresult);
		Thread.sleep(1000);
		
		/*vt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDashboard(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCardReports(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCardReports(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCardReports(10, browser, logresult);
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

