package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_RequestCardToken_InvalidCard {
	
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
			
			token.requestCardToken(4, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(6, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(36, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(10, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(38, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(40, browser, logresult);
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
