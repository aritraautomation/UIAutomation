package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_VerifyFields_DefaultValues_ExistingMerchant {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strValues = null;
					
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
		
		mb.searchMerchant(4, browser, logresult);
		Thread.sleep(2000);
		
		mb.searchMerchant(6, browser, logresult);
		Thread.sleep(2000);
		
		mb.searchMerchant(8, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantDefaultValues(4, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantDefaultValues(6, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantDefaultValues(8, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "The List of Dropdown Values of Currency", "");
			logresult.logTest("Test Execution", "Status", "INFO", "", "=======================================", "");
			
			int count = driver.findElements(By.xpath("//div[@id='currencyCode1']/ul/li")).size();
			
			for (int i=1; i<count; i++){
				
				strValues = driver.findElement(By.xpath("//div[@id='currencyCode1']/ul/li["+(i+1)+"]/a")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "Currency Value No.: "+i+"--->", strValues, "");	
			}
			
			
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		mb.merchantDefaultValues(10, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "The List of Dropdown Values of Data Source", "");
			logresult.logTest("Test Execution", "Status", "INFO", "", "==========================================", "");
			
			int count = driver.findElements(By.xpath("//div[@id='cardDataSource']/ul/li")).size();
			
			for (int i=1; i<count; i++){
				
				strValues = driver.findElement(By.xpath("//div[@id='cardDataSource']/ul/li["+(i+1)+"]/a")).getText();
				logresult.logTest("Test Execution", "Status", "INFO", "Data Source Value No.: "+i+"--->", strValues, "");	
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

