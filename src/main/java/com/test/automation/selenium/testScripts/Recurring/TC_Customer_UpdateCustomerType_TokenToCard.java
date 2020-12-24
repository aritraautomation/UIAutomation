package com.test.automation.selenium.testScripts.Recurring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Customer_UpdateCustomerType_TokenToCard {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtBillingPlan = null;
	String txtCustomerNo = null;
	String txtCustomerName = null;
	String txtTokenNumber = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		TokenManager token = new TokenManager();
		Recurring1 rd = new Recurring1();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		token.requestCardToken(4, browser, logresult);
		Thread.sleep(1000);
		
		token.requestCardToken(6, browser, logresult);
		Thread.sleep(1000);
		
		token.requestCardToken(26, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtTokenNumber = driver.findElement(By.id("requestTokenCopyInput")).getAttribute("value");
			browser.excel.storeCellData("Recurring1_CustomerAdd", txtTokenNumber, 21, 27);
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		token.requestCardToken(30, browser, logresult);
		Thread.sleep(1000);
		
		rd.addBillingPlan(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(22, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			driver.findElement(By.xpath("//div[@id='billingPlan-0']/ul/li[2]/a")).click();
			
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addCustomer(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtCustomerNo = driver.findElement(By.id("customerNumber")).getAttribute("value");
			browser.excel.storeCellData("Recurring1_CustomerSearch", txtCustomerNo, 3, 1);			
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addCustomer(10, browser, logresult);
		Thread.sleep(2000);
		
		rd.addCustomer(12, browser, logresult);
		Thread.sleep(2000);
		
		rd.updateCustomer(32, browser, logresult);
		Thread.sleep(2000);
		
		rd.updateCustomer(22, browser, logresult);
		Thread.sleep(2000);
		
		rd.updateCustomer(8, browser, logresult);
		Thread.sleep(2000);
		
		rd.searchCustomer(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(12, browser, logresult);
		Thread.sleep(2000);
		
		rd.updateCustomer(24, browser, logresult);
		Thread.sleep(2000);
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}

