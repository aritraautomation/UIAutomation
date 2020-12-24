package com.test.automation.selenium.testScripts.KMS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_DEKID_Tokenization {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strDEKID = null;
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
		
		kms.addKMS(22, browser, logresult);
		Thread.sleep(2000);
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "The Active DEK ID", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "=================", "");
		
		try{
			driver=browser.driver;
			
			List<WebElement> btnUpdate = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[6]/span[2]/span/button[text()='Update']"));
			
			if (btnUpdate.size() > 0){
				
				strDEKID = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[1]/span")).getText();
				strStatus = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "", "The Present Active DEK ID: "+strDEKID, "");
				logresult.logTest("Test Execution", "Status", "INFO", "The status of Present Active DEK ID: "+strDEKID, strStatus, "");
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
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "Updating The DEK ID From Active To Deactivated", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "==============================================", "");
		
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
		
		
		kms.addKMS(22, browser, logresult);
		Thread.sleep(2000);
		
		/*kms.addKMS(16, browser, logresult);
		Thread.sleep(2000);*/
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "The Newly Generated Deactivated DEK ID", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "======================================", "");
		
		try{
			driver=browser.driver;
			
			strStatus = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[1]/span[text()='"+strDEKID+"']/../../td[2]/span")).getText();
			logresult.logTest("Test Execution", "Status", "INFO", "", "The New Deactivated DEK ID: "+strDEKID, "");
			logresult.logTest("Test Execution", "Status", "INFO", "The status of New Deactivated DEK ID: "+strDEKID, strStatus, "");
			
			
			Thread.sleep(2000);
			}
		
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		//***************************************
		
		kms.token(4, browser, logresult);
		Thread.sleep(1000);
		
		kms.token(6, browser, logresult);
		Thread.sleep(1000);
		
		kms.token(8, browser, logresult);
		Thread.sleep(1000);
		
		kms.token(10, browser, logresult);
		Thread.sleep(1000);
		
		kms.token(12, browser, logresult);
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

