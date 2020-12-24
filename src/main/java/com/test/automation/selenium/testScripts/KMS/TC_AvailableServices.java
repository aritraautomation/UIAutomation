package com.test.automation.selenium.testScripts.KMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_AvailableServices {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strService = null;
					
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		KMS kms = new KMS();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		kms.addKMS(4, browser, logresult);
		Thread.sleep(2000);
		
		kms.addKMS(6, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "The List of Available Services", "");
			logresult.logTest("Test Execution", "Status", "INFO", "", "==============================", "");
			
			int count = driver.findElements(By.xpath("//div[@id='serviceName']/ul/li")).size();
			
			for (int i=1; i<count; i++){
				
				strService = driver.findElement(By.xpath("//div[@id='serviceName']/ul/li["+(i+1)+"]/a")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "Service No.: "+i+"--->", strService, "");	
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

