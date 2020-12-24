package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_RequestCheckToken_InactiveMerchant {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
			
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
				
		try{
			
			this.logresult = result;
			browser=new Browser(this.logresult);
			this.driver = browser.Open(browserType,BCEnvironment.appURL);
			
			Login login = Login.getInstance();
			TokenManager token = new TokenManager();
			Logout logout = new Logout();
			
			String credentials = login.run(6, browser, logresult);
			Thread.sleep(4000);
			
			token.updateMerchant(4, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(6, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(8, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(10, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(12, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(14, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(16, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(4, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(6, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(8, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(44, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(42, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(20, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(6, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(8, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(18, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(12, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(14, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(16, browser, logresult);
			Thread.sleep(1000);
			
			token.updateMerchant(10, browser, logresult);
			Thread.sleep(1000);
			
			logout.run(4, browser, logresult);
			Thread.sleep(1000);

			logout.run(6, browser, logresult);
			Thread.sleep(1000);
			
			logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
			Thread.sleep(1000);
		
			browser.Close();
			
			}catch(Exception ex){
			
		}
		
	}

}
