package com.test.automation.selenium.testScripts.vtACH;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACH_Routing_Account_Number_GenerateTokenNo {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
					
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		VTACH vt = new VTACH();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		vt.vtRoutingAccountNumber(4, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(6, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(16, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(26, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			List<WebElement> lblTokenID = driver.findElements(By.xpath("//b[contains(text(),'Token ID')]"));
			if (lblTokenID.size() > 0){
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Token ID got generated if 'Generate Token' is selected 'No'!!!", "");
			}
			else{
				logresult.logTest("Test Execution", "Status", "INFO", "", "No Token ID got generated if 'Generate Token' is selected 'No'!!!", "");
			}
						
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		vt.vtRoutingAccountNumber(12, browser, logresult);
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

