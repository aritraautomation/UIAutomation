package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_APIKey {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strTitle = null;
	String strAPIKey = null;
					
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
		
		mb.searchMerchant(34, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			strTitle = driver.findElement(By.xpath("//div[@id='apiKeyPopup']/div/div/div/h4[@class='modal-title']")).getText();
			logresult.logTest("Test Execution", "Status", "INFO", "", "Modal Window Title: "+strTitle, "");
			
			strAPIKey = driver.findElement(By.id("apikey-text-sec")).getAttribute("value");
			logresult.logTest("Test Execution", "Status", "INFO", "", "API Key: "+strAPIKey, "");
			
			driver.findElement(By.xpath("//div[@id='apiKeyPopup']/div/div/div/button[text()='×']")).click();
						
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

