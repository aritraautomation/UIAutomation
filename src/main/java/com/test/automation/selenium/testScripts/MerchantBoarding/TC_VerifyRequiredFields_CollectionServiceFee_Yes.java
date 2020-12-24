package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_VerifyRequiredFields_CollectionServiceFee_Yes {
	
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
		
		mb.merchantAPIDefaults(8, browser, logresult);
		Thread.sleep(2000);
		
		mb.merchantAPIDefaults(24, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			/*if (driver.findElement(By.id("csfAmountFixed")).isEnabled()){
				
				driver.findElement(By.id("csfAmountFixed")).clear();
				Thread.sleep(1000);
			}
			
			else if (driver.findElement(By.id("csfAmountState")).isEnabled()){
				
				driver.findElement(By.id("csfAmountState")).clear();
				Thread.sleep(1000);
			}*/
			
			driver.findElement(By.id("csfAmountState")).clear();
			Thread.sleep(1000);
			
			driver.findElement(By.id("csfFeeSplit")).clear();
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		mb.merchantAPIDefaults(26, browser, logresult);
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

