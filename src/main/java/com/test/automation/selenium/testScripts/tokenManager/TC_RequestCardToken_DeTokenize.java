package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_RequestCardToken_DeTokenize {
	
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
			
			token.requestCardToken(8, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(26, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(12, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(14, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(16, browser, logresult);
			Thread.sleep(1000);
			
			try{
			driver=browser.driver;
			WebElement txtTokenNumber = driver.findElement(By.id("cardt_update_card_number"));
			txtTokenNumber.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
			
			token.requestCardToken(18, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(20, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(28, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(44, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(24, browser, logresult);
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
