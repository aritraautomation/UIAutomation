package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ActiveInactive_Bulk {
	
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
		
		mb.merchantActiveInactive(20, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(22, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			int count = driver.findElements(By.xpath("//table[@class='rtable']/tbody/tr")).size();
			
			for (int i=0; i<count; i++){
				
				isChecked = driver.findElement(By.xpath("//table[@class='rtable']/tbody/tr["+(i+1)+"]/td[5]/span[2]/label/input[@class='custom-checkbox']")).isSelected();
				if (isChecked)	{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","MID"+(i+1)+" is Active!!!", "");
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","MID"+(i+1)+" is Inactive!!!", "");
				}
				
				for (int j=0; j<count; j++){
					
					driver.findElement(By.xpath("//table[@class='rtable']/tbody/tr["+(i+1)+"]/td[5]/span[2]/label/input[@class='custom-checkbox']")).click();
				}
			}
			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		mb.merchantActiveInactive(24, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(10, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(14, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(16, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(22, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			int count = driver.findElements(By.xpath("//table[@class='rtable']/tbody/tr")).size();
			
			for (int i=0; i<count; i++){
				
				isChecked = driver.findElement(By.xpath("//table[@class='rtable']/tbody/tr["+(i+1)+"]/td[5]/span[2]/label/input[@class='custom-checkbox']")).isSelected();
				if (isChecked)	{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","MID"+(i+1)+" is Active!!!", "");
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","MID"+(i+1)+" is Inactive!!!", "");
				}
				
				for (int j=0; j<count; j++){
					
					driver.findElement(By.xpath("//table[@class='rtable']/tbody/tr["+(i+1)+"]/td[5]/span[2]/label/input[@class='custom-checkbox']")).click();
				}
			}
			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		
		mb.merchantActiveInactive(24, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(10, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(14, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(16, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantActiveInactive(22, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			int count = driver.findElements(By.xpath("//table[@class='rtable']/tbody/tr")).size();
			
			for (int i=0; i<count; i++){
				
				isChecked = driver.findElement(By.xpath("//table[@class='rtable']/tbody/tr["+(i+1)+"]/td[5]/span[2]/label/input[@class='custom-checkbox']")).isSelected();
				if (isChecked)	{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","MID"+(i+1)+" is Active!!!", "");
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","MID"+(i+1)+" is Inactive!!!", "");
				}
				
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

