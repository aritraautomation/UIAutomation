package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_RequestCardToken_Same_MID_Same_Card {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strTokenNumber1 = null;
	String strTokenNumber2 = null;
			
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
			
			token.requestCardToken(8, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(10, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(12, browser, logresult);
			Thread.sleep(1000);
			
			try{
				driver=browser.driver;
				strTokenNumber1 = driver.findElement(By.id("requestTokenCopyInput")).getAttribute("value");
				Thread.sleep(1000);
				}
				catch(Exception e){
					logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
				}
			
			token.requestCardToken(30, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(8, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(10, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(12, browser, logresult);
			Thread.sleep(1000);
			
			try{
				driver=browser.driver;
				strTokenNumber2 = driver.findElement(By.id("requestTokenCopyInput")).getAttribute("value");
				Thread.sleep(1000);
				}
				catch(Exception e){
					logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
				}
			
			token.requestCardToken(30, browser, logresult);
			Thread.sleep(1000);
			
			if(strTokenNumber1.equals(strTokenNumber2)){
				
				logresult.logTest("Test Execution", "Status", "INFO", "First Card Token: "+strTokenNumber1+" and Second Card Token: "+strTokenNumber2, "Card Token is matching for same MID and same Card Number!!!", "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "First Card Token: "+strTokenNumber1+" and Second Card Token: "+strTokenNumber2, "Card Token is not matching for same MID and same Card Number!!!", "");
			}
			
			
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
