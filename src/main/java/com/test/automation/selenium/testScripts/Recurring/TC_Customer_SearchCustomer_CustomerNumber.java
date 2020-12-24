package com.test.automation.selenium.testScripts.Recurring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Customer_SearchCustomer_CustomerNumber {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtBillingPlan = null;
	String txtCustomerNo = null;
	String txtCustomerName = null;
	String txtPhoneNo = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		Recurring rd = new Recurring();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		rd.addBillingPlan(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addBillingPlan(6, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(6, browser, logresult);
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
			browser.excel.storeCellData("Recurring_CustomerSearch", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+txtCustomerNo+"']", 1, 9);
			browser.excel.storeCellData("Recurring_CustomerSearch", txtCustomerNo, 7, 3);
			browser.excel.storeCellData("Recurring_CustomerSearch", "text::"+txtCustomerNo, 20, 9);
			
			txtCustomerName = driver.findElement(By.id("customerName")).getAttribute("value");
			browser.excel.storeCellData("Recurring_CustomerSearch", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+txtCustomerNo+"']/../../td[2]/span", 1, 10);
			browser.excel.storeCellData("Recurring_CustomerSearch", "text::"+txtCustomerName, 20, 10);
			
			txtPhoneNo = driver.findElement(By.id("phoneNumber")).getAttribute("value");
			browser.excel.storeCellData("Recurring_CustomerSearch", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+txtCustomerNo+"']/../../td[3]/span", 1, 11);
			browser.excel.storeCellData("Recurring_CustomerSearch", "text::"+txtPhoneNo, 20, 11);
			
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addCustomer(10, browser, logresult);
		Thread.sleep(2000);
		
		rd.addCustomer(48, browser, logresult);
		Thread.sleep(2000);
		
		rd.searchCustomer(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			String txtSearchMsg = driver.findElement(By.xpath("//div[@class='table-control-top']/span")).getText();
			logresult.logTest("Test Execution", "Status", "INFO", "Search Message: "+txtSearchMsg, "", "");
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.searchCustomer(20, browser, logresult);
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

