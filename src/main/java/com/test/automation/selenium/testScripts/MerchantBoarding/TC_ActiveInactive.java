package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ActiveInactive {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	Boolean isChecked = false;
					
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		MerchantBoarding mb = new MerchantBoarding();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		mb.merchantActiveInactive(4, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(6, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(12, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			isChecked = driver.findElement(By.xpath("//input[@class='custom-checkbox']")).isSelected();
				if (isChecked)	{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The MID is Active!!!", "");
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The MID is Inactive!!!", "");
				}
			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		mb.merchantActiveInactive(8, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(10, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(14, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(16, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(18, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			isChecked = driver.findElement(By.xpath("//input[@class='custom-checkbox']")).isSelected();
				if (isChecked)	{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The MID is Active!!!", "");
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The MID is Inactive!!!", "");
				}
			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		mb.merchantActiveInactive(8, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(10, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(14, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(16, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(12, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			isChecked = driver.findElement(By.xpath("//input[@class='custom-checkbox']")).isSelected();
				if (isChecked)	{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The MID is Active!!!", "");
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The MID is Inactive!!!", "");
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

