package com.test.automation.selenium.testScripts.ACHReports;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACHReports_InvalidSearchCriteria {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strBorderColour = null;
					
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		ACHReports ar = new ACHReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		ar.searchTransaction(4, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(34, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(36, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(38, browser, logresult);
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

