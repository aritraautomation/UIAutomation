package com.test.automation.selenium.testScripts.ACHReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_ACHReports_WithoutMID {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strBorderColour = null;
					
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		ACHReports ar = new ACHReports();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		ar.searchTransaction(4, browser, logresult);
		Thread.sleep(1000);
		
		ar.searchTransaction(32, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			strBorderColour = driver.findElement(By.id("mids-list")).getCssValue("border-color");
			logresult.logTest("Test Execution", "Status", "INFO", "Border Colour of the MID field: ", strBorderColour, "");
			//Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		if(strBorderColour.equals("rgb(68, 68, 68)")){
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "Border Colour of the MID field is RED when no MID is selected during search!!!", "");
		}
		
		else{
			
			logresult.logTest("Test Execution", "Status", "INFO", "", "Border Colour of the MID field is NOT RED when no MID is selected during search!!!", "");
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

