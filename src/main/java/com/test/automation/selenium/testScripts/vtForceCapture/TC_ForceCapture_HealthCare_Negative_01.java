package com.test.automation.selenium.testScripts.vtForceCapture;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ForceCapture_HealthCare_Negative_01 {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTxnID = null;
	String txtCardNumber = null;
	String txtAmount = null;
	String txtPaymentType = null;
	String txtDate = null;
	String txtTime = null;
	String txtDateTime = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		VTForceCapture vt = new VTForceCapture();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtCard(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCard(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtCard(26, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtHealthCare(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtHealthCare(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtHealthCare(14, browser, logresult);
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

