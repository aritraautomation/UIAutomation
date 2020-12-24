package com.test.automation.selenium.testScripts.batchPay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_UploadFile_DropFile_CSV {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	//String strPath =  System.getProperty("user.dir") + "\\FilesToUpload\\";
	String strPath = "D:\\GETUIAutomationRegression\\FileToUpload";
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		BatchPay bp = new BatchPay();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		bp.uploadFile(4, browser, logresult);
		Thread.sleep(1000);
		
		bp.uploadFile(6, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			List<WebElement> txtDropFile = driver.findElements(By.id("dropfileInput"));
			if (txtDropFile.size() > 0){
				
				txtDropFile.get(0).click();
				}
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		Runtime.getRuntime().exec(strPath + "\\BatchPayCSV.exe");
		Thread.sleep(3000);
		
		bp.uploadFile(14, browser, logresult);
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

