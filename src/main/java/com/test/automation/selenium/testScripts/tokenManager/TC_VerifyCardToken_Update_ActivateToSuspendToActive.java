package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

import org.openqa.selenium.Keys;

public class TC_VerifyCardToken_Update_ActivateToSuspendToActive {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	public static WebElement txtTokenNumber = null;
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
			
			token.updateCardToken(18, browser, logresult);
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
			
			token.updateCardToken(20, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCardToken(34, browser, logresult);
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
				
				logresult.logTest("Test Execution", "Status", "INFO", "First Card Token: "+strTokenNumber1+" and Second Card Token: "+strTokenNumber2, "Same Card Token got generated for updating Token from Active to Suspend to Active!!!", "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "First Card Token: "+strTokenNumber1+" and Second Card Token: "+strTokenNumber2, "Different Card Tokens got generated for updating Token from Active to Suspend to Active!!!", "");
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
