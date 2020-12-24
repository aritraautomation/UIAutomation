package com.test.automation.selenium.testScripts.Recurring;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_BP_AddDuplicateBillingPlan {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtBillingPlan = null;
				
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
			browser.excel.storeCellData("Recurring_BPAdd", txtBillingPlan, 23, 6);
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addBillingPlan(12, browser, logresult);
		Thread.sleep(4000);
		
		try{
			driver=browser.driver;
			List<WebElement> btnAddBP = driver.findElements(By.xpath("//button[text()='Add Billing Plan']"));
			
			if (btnAddBP.size() > 0){
				
				driver.findElement(By.xpath("//button[text()='Add Billing Plan']")).click();
			}
			
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addBillingPlan(24, browser, logresult);
		Thread.sleep(1000);
		
		rd.addBillingPlan(26, browser, logresult);
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

