package com.test.automation.selenium.testScripts.tokenManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_RequestCheckToken_InvalidRouteNumber_InvalidAccountNumber {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	public String strBorderColourRN = null;
	public String strBorderColourAN = null;
			
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
			
			token.requestCheckToken(4, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(6, browser, logresult);
			Thread.sleep(1000);
			
			token.requestCheckToken(26, browser, logresult);
			Thread.sleep(1000);
			
			try{
				driver=browser.driver;
				strBorderColourRN = driver.findElement(By.id("checkt_route")).getCssValue("border-color");
				strBorderColourAN = driver.findElement(By.id("checkt_account")).getCssValue("border-color");
				logresult.logTest("Test Execution", "Status", "INFO", "Border Colour of the Route Number field: ", strBorderColourRN, "");
				logresult.logTest("Test Execution", "Status", "INFO", "Border Colour of the Card Number field: ", strBorderColourAN, "");
				Thread.sleep(1000);
				}
				catch(Exception e){
					logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
				}
			
			if(strBorderColourRN.equals("rgb(255, 0, 0)")){
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Border Colour of the Route Number field is RED when invalid Route Number is provided!!!", "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Border Colour of the Route Number field is NOT RED when invalid Route Number is provided!!!", "");
			}
			
			if(strBorderColourAN.equals("rgb(255, 0, 0)")){
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Border Colour of the Account Number field is RED when invalid Card Number is provided!!!", "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Border Colour of the Account Number field is NOT RED when invalid Card Number is provided!!!", "");
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
