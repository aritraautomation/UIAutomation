package com.test.automation.selenium.testScripts.KMS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_DEKID_ActiveToDeactivated {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strActiveDEKID_Old = null;
	String strActiveDEKID_New = null;
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
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "Before Update The DEK ID From Active To Deactivate", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "==================================================", "");
		
		try{
			driver=browser.driver;
			
			List<WebElement> btnUpdate = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[6]/span[2]/span/button[text()='Update']"));
			
			if (btnUpdate.size() > 0){
				
				int activeDEKCount = btnUpdate.size();
				strActiveDEKID_Old = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[1]/span")).getText();
				strStatus = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "", "The Number of Present Active DEK: "+activeDEKCount, "");
				logresult.logTest("Test Execution", "Status", "INFO", "", "The Present Active DEK ID: "+strActiveDEKID_Old, "");
				logresult.logTest("Test Execution", "Status", "INFO", "The status of Present Active DEK ID: "+strActiveDEKID_Old, strStatus, "");
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
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "After Update The DEK ID From Active To Deactivate", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "=================================================", "");

		logresult.logTest("Test Execution", "Status", "INFO", "", "The Newly Generated Deactivated DEK ID", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "======================================", "");
		
		try{
			driver=browser.driver;
			
			strStatus = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[1]/span[text()='"+strActiveDEKID_Old+"']/../../td[2]/span")).getText();
			logresult.logTest("Test Execution", "Status", "INFO", "", "The New Deactivated DEK ID: "+strActiveDEKID_Old, "");
			logresult.logTest("Test Execution", "Status", "INFO", "The status of New Deactivated DEK ID: "+strActiveDEKID_Old, strStatus, "");
			
			
			Thread.sleep(2000);
			}
		
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "The Newly Generated Active DEK ID", "");
		logresult.logTest("Test Execution", "Status", "INFO", "", "=================================", "");
		
		try{
			driver=browser.driver;
			
			List<WebElement> btnUpdate = driver.findElements(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[6]/span[2]/span/button[text()='Update']"));
			
			if (btnUpdate.size() > 0){
				
				int activeDEKCount = btnUpdate.size();
				strActiveDEKID_New = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']/../../td[1]/span")).getText();
				strStatus = driver.findElement(By.xpath("//div[@id='keyMangementResultTable']/table/tbody/tr[*]/td[2]/span[text()='ACTIVE']")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "", "The Number of Active DEK ID: "+activeDEKCount, "");
				logresult.logTest("Test Execution", "Status", "INFO", "", "The New Active DEK ID: "+strActiveDEKID_New, "");
				logresult.logTest("Test Execution", "Status", "INFO", "The status of New Active DEK ID: "+strActiveDEKID_New, strStatus, "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", "", "No Update Button is Present on the Page against an Active DEK!!!", "");
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

