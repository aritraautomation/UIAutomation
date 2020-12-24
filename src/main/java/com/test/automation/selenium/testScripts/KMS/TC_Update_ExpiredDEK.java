package com.test.automation.selenium.testScripts.KMS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Update_ExpiredDEK {
	
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
		
		kms.addKMS(8, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			List<WebElement> btnUpdate = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='EXPIRED']/../../td[6]/span[2]/span/button[text()='Update']"));
			
			if (btnUpdate.size() > 0){
				
				btnUpdate.get(0).click();
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "No Update Button is Present on the Page against an Expired DEK!!!", "");
			}
			
			Thread.sleep(2000);
			}
		
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		kms.addKMS(10, browser, logresult);
		Thread.sleep(2000);
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}

