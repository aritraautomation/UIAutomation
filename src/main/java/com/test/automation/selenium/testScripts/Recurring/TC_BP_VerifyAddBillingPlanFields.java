package com.test.automation.selenium.testScripts.Recurring;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_BP_VerifyAddBillingPlanFields {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
				
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
		
		rd.verifyAddBillingPlanFields(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.verifyAddBillingPlanFields(6, browser, logresult);
		Thread.sleep(1000);
		
		rd.verifyAddBillingPlanFields(8, browser, logresult);
		Thread.sleep(1000);
		
		rd.verifyAddBillingPlanFields(10, browser, logresult);
		Thread.sleep(1000);
		
		rd.verifyAddBillingPlanFields(12, browser, logresult);
		Thread.sleep(1000);
		
		rd.verifyAddBillingPlanFields(14, browser, logresult);
		Thread.sleep(1000);
		
		rd.verifyAddBillingPlanFields(16, browser, logresult);
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

