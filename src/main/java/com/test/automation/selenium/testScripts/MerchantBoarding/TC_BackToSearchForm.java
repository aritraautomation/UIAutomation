package com.test.automation.selenium.testScripts.MerchantBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_BackToSearchForm {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strTitle1 = null;
	String strTitle2 = null;
					
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
		
		mb.searchMerchant(10, browser, logresult);
		Thread.sleep(2000);
		
		mb.searchMerchant(18, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			strTitle1 = driver.findElement(By.xpath("//h1[@class='page-title']")).getText();
			strTitle2 = driver.findElement(By.xpath("//span[@class='panel-heading-text']")).getText();
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "The Title of the Page: "+strTitle1+"::"+strTitle2, "");
						
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		
		logresult.logTest("Test Execution", "Status", "INFO", "", "Clicking on the 'Back To Search Form' button", "");
		
		mb.searchMerchant(32, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			
			strTitle1 = driver.findElement(By.xpath("//h1[@class='page-title']")).getText();
			strTitle2 = driver.findElement(By.xpath("//span[@class='panel-heading-text']")).getText();
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "The Title of the Page: "+strTitle1+"::"+strTitle2, "");
						
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

