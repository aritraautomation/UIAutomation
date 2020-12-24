package com.test.automation.selenium.testScripts.vtACH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACH_Routing_Account_Number_GenerateTokenYes {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtTokenID = null;
				
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
		
		vt.vtRoutingAccountNumber(14, browser, logresult);
		Thread.sleep(1000);
		
		vt.vtRoutingAccountNumber(26, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			txtTokenID = driver.findElement(By.xpath("//b[contains(text(),'Token ID')]/../../td[2]")).getText();
			if (txtTokenID != null){
				
				txtTokenID = txtTokenID.trim();
				logresult.logTest("Test Execution", "Status", "INFO", "", "Token ID got generated if 'Generate Token' is selected 'Yes'!!!", "");
				logresult.logTest("Test Execution", "Status", "INFO", "Generated Token ID: ", txtTokenID, "");
			}
			else{
				logresult.logTest("Test Execution", "Status", "INFO", "", "No Token ID got generated if 'Generate Token' is selected 'Yes'!!!", "");
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

