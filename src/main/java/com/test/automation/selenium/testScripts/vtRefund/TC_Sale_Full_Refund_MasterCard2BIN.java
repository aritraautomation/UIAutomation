package com.test.automation.selenium.testScripts.vtRefund;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Sale_Full_Refund_MasterCard2BIN {
	
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
		VTRefund vt = new VTRefund();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtSale(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtSale(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtSale(16, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtSale(10, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			
			browser.excel.storeCellData("VTRefund_Refund", txtTxnID, 5, 2);
			browser.excel.storeCellData("VTRefund_Refund", "text::"+txtTxnID, 8, 4);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtSale(12, browser, logresult);
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
		
		/*try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("VTRefund_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']", 1, 3);
			browser.excel.storeCellData("VTRefund_Dashboard", "text::"+txtTxnID, 6, 3);
			browser.excel.storeCellData("VTRefund_CardReports", txtTxnID, 5, 5);
			browser.excel.storeCellData("VTRefund_CardReports", "text::"+txtTxnID, 10, 8);
			
			txtCardNumber = driver.findElement(By.xpath("//td[contains(text(),'Card Number')]/../td[2]")).getText();
			browser.excel.storeCellData("VTRefund_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[1]", 1, 2);
			browser.excel.storeCellData("VTRefund_Dashboard", "text::"+txtCardNumber, 6, 2);
			browser.excel.storeCellData("VTRefund_CardReports", "text::"+txtCardNumber, 10, 10);
			
			browser.excel.storeCellData("VTRefund_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[3]", 1, 4);
			
			txtPaymentType = driver.findElement(By.xpath("//td[contains(text(),'Payment Type')]/../td[2]")).getText();
			browser.excel.storeCellData("VTRefund_CardReports", "text::"+txtPaymentType, 10, 11);
			
			txtDate = driver.findElement(By.xpath("//div[@id='customer_recipt']/table//tbody/tr[8]/td[2]")).getText();
			browser.excel.storeCellData("VTRefund_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[4]", 1, 5);
			browser.excel.storeCellData("VTRefund_Dashboard", "text::"+txtDate, 6, 5);
			
			txtTime = driver.findElement(By.xpath("//div[@id='customer_recipt']/table//tbody/tr[9]/td[2]")).getText();
			browser.excel.storeCellData("VTRefund_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[5]", 1, 6);
			browser.excel.storeCellData("VTRefund_Dashboard", "text::"+txtTime, 6, 6);
			
			browser.excel.storeCellData("VTRefund_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[6]", 1, 7);
			
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("VTRefund_CardReports", "text::"+txtDateTime, 10, 7);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}*/
		
		vt.vtRefund(14, browser, logresult);
		Thread.sleep(1000);
		
		/*vt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDashboard(6, browser, logresult);
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

