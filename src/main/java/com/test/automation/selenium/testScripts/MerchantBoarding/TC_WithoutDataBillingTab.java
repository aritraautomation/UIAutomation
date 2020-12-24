package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_WithoutDataBillingTab {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
						
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		MerchantBoarding mb = new MerchantBoarding();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		mb.addMerchantGeneral(4, browser, logresult);
		Thread.sleep(1000);
		
		mb.addMerchantGeneral(14, browser, logresult);
		Thread.sleep(1000);
		
		mb.merchantProcessing(26, browser, logresult);
		Thread.sleep(1000);
		
		mb.merchantProcessing(16, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantBilling(4, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantBilling(6, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantBilling(8, browser, logresult);
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

