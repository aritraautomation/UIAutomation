package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

import org.openqa.selenium.Keys;

public class TC_UpdateSuspendCardToken_ExpiryDate {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	public static WebElement txtTokenNumber = null;
	
			
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
			
			token.requestCardToken(26, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(10, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(12, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(14, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(4, browser, logresult);
			Thread.sleep(1000);
			
			try{
			driver=browser.driver;
			txtTokenNumber = driver.findElement(By.id("update_token_number"));
			txtTokenNumber.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
			
			token.updateCardToken(6, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(8, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(10, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(12, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(14, browser, logresult);
			Thread.sleep(1000);
			
			try{
				driver=browser.driver;
				txtTokenNumber = driver.findElement(By.id("update_token_number"));
				txtTokenNumber.sendKeys(Keys.chord(Keys.CONTROL, "v"));
				Thread.sleep(1000);
				}
				catch(Exception e){
					logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
				}
				
			token.updateCardToken(6, browser, logresult);
			Thread.sleep(1000);
				
			token.updateCardToken(16, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(22, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(24, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(12, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(14, browser, logresult);
			Thread.sleep(1000);
			
			try{
				driver=browser.driver;
				txtTokenNumber = driver.findElement(By.id("update_token_number"));
				txtTokenNumber.sendKeys(Keys.chord(Keys.CONTROL, "v"));
				Thread.sleep(1000);
				}
				catch(Exception e){
					logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
				}
				
			token.updateCardToken(6, browser, logresult);
			Thread.sleep(1000);
			
			token.updateCardToken(26, browser, logresult);
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
