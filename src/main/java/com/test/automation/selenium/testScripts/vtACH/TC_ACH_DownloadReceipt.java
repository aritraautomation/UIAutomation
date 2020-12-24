package com.test.automation.selenium.testScripts.vtACH;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACH_DownloadReceipt {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
				
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
		
		vt.vtRoutingAccountNumber(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(26, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDownload(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtDownload(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(12, browser, logresult);
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

