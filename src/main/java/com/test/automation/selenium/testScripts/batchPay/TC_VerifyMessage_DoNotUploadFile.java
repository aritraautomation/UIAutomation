package com.test.automation.selenium.testScripts.batchPay;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_VerifyMessage_DoNotUploadFile {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	//String strPath =  System.getProperty("user.dir") + "\\FilesToUpload\\";
	String strPath = "D:\\GETUIAutomationRegression\\FileToUpload";
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		BatchPay bp = new BatchPay();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		bp.uploadFile(4, browser, logresult);
		Thread.sleep(1000);
		
		bp.uploadFile(6, browser, logresult);
		Thread.sleep(1000);
		
		bp.uploadFile(8, browser, logresult);
		Thread.sleep(1000);
		
		bp.uploadFile(12, browser, logresult);
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

