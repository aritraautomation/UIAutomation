package com.test.automation.selenium.testScripts.fms;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_AVSState_Decline_Matched {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	Boolean match = false;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		FMS fms = new FMS();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(6, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(6, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(8, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(10, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(12, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(12, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(16, browser, logresult);
		Thread.sleep(1000);
		
		fms.vtSale(18, browser, logresult);
		Thread.sleep(1000);
		
		fms.fmsHome(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(4, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(14, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(16, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(18, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(20, browser, logresult);
		Thread.sleep(1000);
		
		fms.avsState(10, browser, logresult);
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

