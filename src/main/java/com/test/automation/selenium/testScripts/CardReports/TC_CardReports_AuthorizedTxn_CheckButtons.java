package com.test.automation.selenium.testScripts.CardReports;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_CardReports_AuthorizedTxn_CheckButtons {
	
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
		CardReports cr = new CardReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		cr.processAuthTxn(4, browser, logresult);
		Thread.sleep(1000);
		
		cr.processAuthTxn(6, browser, logresult);
		Thread.sleep(1000);
		
		cr.processAuthTxn(8, browser, logresult);
		Thread.sleep(1000);
		
		cr.processAuthTxn(10, browser, logresult);
		Thread.sleep(1000);
		
		cr.searchTransaction(4, browser, logresult);
		Thread.sleep(1000);
		
		cr.searchTransaction(28, browser, logresult);
		Thread.sleep(1000);
		
		cr.cardReportsCheckButton(8, browser, logresult);
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

