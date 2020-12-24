package com.test.automation.selenium.testScripts.KMS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_NumberOfActiveDEKID_One {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strActiveDEKID = null;
	String strStatus = null;
					
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
			
			List<WebElement> eleActiveDEKID = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[1]/span"));
			int activeDEKIDCount = eleActiveDEKID.size();
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "List of Active DEK ID", "");
			logresult.logTest("Test Execution", "Status", "INFO", "", "=====================", "");
			
			
			if (activeDEKIDCount > 0){
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Number of Active DEK: "+activeDEKIDCount, "");
				
				for (int i=0; i<activeDEKIDCount; i++){
					
					strActiveDEKID = eleActiveDEKID.get(i).getText();
					logresult.logTest("Test Execution", "Status", "INFO", "", "Active DEK ID: "+strActiveDEKID, "");
									
				}
				
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "No Active DEK is Present on the Page!!!", "");
			}
			
			Thread.sleep(2000);
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

