package com.test.automation.selenium.testScripts.Recurring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Customer_AddCustomerSuspendContract {
	
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
		
		rd.addBillingPlan(8, browser, logresult);
		Thread.sleep(1000);
		
		rd.addBillingPlan(10, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			txtBillingPlan = driver.findElement(By.id("billingPlan")).getAttribute("value");
			browser.excel.storeCellData("Recurring_CustomerAdd", "xpath:://div[@id='billingPlan-0']/ul/li[*]/a[text()='"+txtBillingPlan+"']", 1, 45);
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addBillingPlan(14, browser, logresult);
		Thread.sleep(3000);
		
		rd.addCustomer(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(54, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(8, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(10, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(56, browser, logresult);
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

