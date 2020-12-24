package com.test.automation.selenium.testScripts.vtAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Auth_Token_MasterCard_VerifyOptionalInformation {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		VTAuth vt = new VTAuth();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtRequestCardToken(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRequestCardToken(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRequestCardToken(12, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRequestCardToken(10, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtVerifyOptionalInformation(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtVerifyOptionalInformation(24, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			WebElement txtToken = driver.findElement(By.id("tokenId"));
			txtToken.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		vt.vtVerifyOptionalInformation(26, browser, logresult);
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

