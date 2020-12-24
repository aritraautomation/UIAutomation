package com.test.automation.selenium.testScripts.vtACH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACH_POP_WithoutReceivingCompanyNameButCustomerName {
	
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
	String txtTxnType = null;
				
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
		
		vt.vtRoutingAccountNumber(34, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			WebElement rdTxnTypeDebit = driver.findElement(By.id("checkTransactionType1"));
			WebElement rdTxnTypeCredit = driver.findElement(By.id("checkTransactionType2"));
			
			if(rdTxnTypeDebit.isSelected()){
				
				txtTxnType = "DR";
				browser.excel.storeCellData("VTACH_Reports", "text::"+txtTxnType, 8, 12);
			}
			
			else if(rdTxnTypeCredit.isSelected()){
				
				txtTxnType = "CR";
				browser.excel.storeCellData("VTACH_Reports", "text::"+txtTxnType, 8, 12);
			}
			
			Thread.sleep(1000);
		}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtRoutingAccountNumber(26, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(10, browser, logresult);
		Thread.sleep(1000);
		
		/*try{
			driver=browser.driver;
			
			txtTxnID = driver.findElement(By.id("transaction_id")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']", 1, 4);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtTxnID, 6, 4);
			browser.excel.storeCellData("VTACH_Reports", txtTxnID, 5, 5);
			browser.excel.storeCellData("VTACH_Reports", "text::"+txtTxnID, 8, 8);
			
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[3]", 1, 3);
			
			txtAccountNumber = driver.findElement(By.xpath("//b[contains(text(),'Account Number')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[1]", 1, 2);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtAccountNumber, 6, 2);
			browser.excel.storeCellData("VTACH_Reports", "text::"+txtAccountNumber, 8, 10);
			
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[4]", 1, 5);
			
			txtTxnMethod = driver.findElement(By.xpath("//b[contains(text(),'Transaction Method')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Reports", "text::"+txtTxnMethod, 8, 13);
			
			txtDate = driver.findElement(By.xpath("//b[contains(text(),'Date')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[5]", 1, 6);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtDate, 6, 6);
			
			txtTime = driver.findElement(By.xpath("//b[contains(text(),'Time')]/../../td[2]")).getText();
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[6]", 1, 7);
			browser.excel.storeCellData("VTACH_Dashboard", "text::"+txtTime, 6, 7);
			
			browser.excel.storeCellData("VTACH_Dashboard", "xpath:://table[@class='rtable1']/tbody/tr[*]/td[2][text()='"+txtTxnID+"']/../td[7]", 1, 8);
			
			txtDateTime = txtDate+" "+txtTime;
			browser.excel.storeCellData("VTACH_Reports", "text::"+txtDateTime, 8, 7);
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}*/
		
		vt.vtRoutingAccountNumber(12, browser, logresult);
		Thread.sleep(1000);
		
		/*vt.vtDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtACHReports(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtACHReports(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtACHReports(8, browser, logresult);
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

