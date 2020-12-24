package com.test.automation.selenium.testScripts.vtACH;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACH_Negative_MIDNoAccessToACH {
	
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
		
		vt.updateMerchant(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(16, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(18, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(14, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
		
		logout.run(10, browser, logresult);
		Thread.sleep(1000);
		
		String credentials1 = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtRoutingAccountNumber(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(26, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtACHNegative(68, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(8, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(16, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(18, browser, logresult);
		Thread.sleep(1000);
		
		vt.updateMerchant(14, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials1);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}

