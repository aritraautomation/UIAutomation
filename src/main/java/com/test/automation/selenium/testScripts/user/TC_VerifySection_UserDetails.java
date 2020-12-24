package com.test.automation.selenium.testScripts.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_VerifySection_UserDetails {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtUsername = null;
	String txtUserLevel = null;	
	
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
				
		try{
			
			this.logresult = result;
			browser=new Browser(this.logresult);
			this.driver = browser.Open(browserType,BCEnvironment.appURL);
			
			Login login = Login.getInstance();
			User user = new User();
			Logout logout = new Logout();
			
			String credentials = login.run(6, browser, logresult);
			Thread.sleep(4000);
			
			user.userAdd(4, browser, logresult);
			Thread.sleep(1000);
			
			user.userAdd(24, browser, logresult);
			Thread.sleep(1000);
			
			try{
			driver=browser.driver;
			txtUsername = driver.findElement(By.id("userName")).getAttribute("value");
			browser.excel.storeCellData("User_Search", txtUsername, 5, 3);
			browser.excel.storeCellData("User_Detail", "valueattribute::"+txtUsername, 4, 2);
			
			txtUserLevel = driver.findElement(By.xpath("//div[@id='userCategoryId']/button/div/span")).getText();
			browser.excel.storeCellData("User_Detail", "text::"+txtUserLevel, 4, 4);
			
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
			
			user.userAdd(26, browser, logresult);
			Thread.sleep(1000);
			
			user.userAdd(10, browser, logresult);
			Thread.sleep(1000);
			
			user.userSearch(6, browser, logresult);
			Thread.sleep(1000);
			
			user.userSearch(10, browser, logresult);
			Thread.sleep(1000);
			
			user.verifyUserDetail(4, browser, logresult);
			Thread.sleep(1000);
			
			user.userSearch(6, browser, logresult);
			Thread.sleep(1000);
			
			user.userDelete(4, browser, logresult);
			Thread.sleep(1000);
			
			logout.run(4, browser, logresult);
			Thread.sleep(1000);

			logout.run(6, browser, logresult);
			Thread.sleep(1000);
			
			logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
			
			Thread.sleep(1000);
		
			browser.Close();
			
			}catch(Exception ex){
			
		}
		
	}

}
