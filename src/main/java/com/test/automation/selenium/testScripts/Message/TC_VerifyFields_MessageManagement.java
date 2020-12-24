package com.test.automation.selenium.testScripts.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_VerifyFields_MessageManagement {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strMessageType = null;
					
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		Message msg = new Message();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		msg.addMessage(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(24, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(26, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "The List of Available Message Type", "");
			logresult.logTest("Test Execution", "Status", "INFO", "", "==================================", "");
			
			int count = driver.findElements(By.xpath("//div[@id='messageType']/ul/li")).size();
			
			for (int i=1; i<count; i++){
				
				strMessageType = driver.findElement(By.xpath("//div[@id='messageType']/ul/li["+(i+1)+"]/a")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "Service No.: "+i+"--->", strMessageType, "");	
			}
			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}

