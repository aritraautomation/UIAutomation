package com.test.automation.selenium.testScripts.KMS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_NumberOfDeactivatedDEKID_Multiple {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strDeactiveDEKID = null;
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
			
			List<WebElement> btnUpdate = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[6]/span[2]/span/button[text()='Update']"));
			
			if (btnUpdate.size() > 0){
				
				btnUpdate.get(0).click();
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "No Update Button is Present on the Page against an Active DEK!!!", "");
			}
			
			Thread.sleep(2000);
			}
		
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		kms.addKMS(12, browser, logresult);
		Thread.sleep(3000);
		
		try{
			driver=browser.driver;
			
			driver.navigate().refresh();
			Thread.sleep(3000);
			}
		
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		
		kms.addKMS(8, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			List<WebElement> eleDeactiveDEKID = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='DEACTIVATED']/../../td[1]/span"));
			int deActivatedDEKIDCount = eleDeactiveDEKID.size();
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "List of Deactivated DEK ID", "");
			logresult.logTest("Test Execution", "Status", "INFO", "", "==========================", "");
			
			
			if (deActivatedDEKIDCount > 0){
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "Number of Deactivated DEK: "+deActivatedDEKIDCount, "");
				
				for (int i=0; i<deActivatedDEKIDCount; i++){
					
					strDeactiveDEKID = eleDeactiveDEKID.get(i).getText();
					logresult.logTest("Test Execution", "Status", "INFO", "", "Deactivated DEK ID: "+strDeactiveDEKID, "");
									
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

