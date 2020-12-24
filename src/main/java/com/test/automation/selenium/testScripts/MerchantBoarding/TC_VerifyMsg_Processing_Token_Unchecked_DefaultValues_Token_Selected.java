package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_VerifyMsg_Processing_Token_Unchecked_DefaultValues_Token_Selected {
	
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
		
		mb.searchMerchant(4, browser, logresult);
		Thread.sleep(2000);
		
		mb.searchMerchant(6, browser, logresult);
		Thread.sleep(2000);
		
		mb.searchMerchant(8, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantProcessing(4, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			isChecked = driver.findElement(By.id("Token")).isSelected();
				if (isChecked)	{
					
					driver.findElement(By.id("Token")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//panel[@flabel='Processing']/following-sibling::div/button")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[text()='×']")).click();
				}
				
				else{
					
					logresult.logTest("Test Execution", "Status", "INFO", "","The Token Checkbox is alreaady unchecked!!!", "");
				}
			
			
			Thread.sleep(2000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		mb.merchantDefaultValues(4, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantDefaultValues(12, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantDefaultValues(14, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantProcessing(4, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			driver.findElement(By.id("Token")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//panel[@flabel='Processing']/following-sibling::div/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='×']")).click();
					
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

