package com.test.automation.selenium.testScripts.user;

import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TC_UpdateUserMyProfile {
	
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
			
			user.userUpdateMyProfile(4, browser, logresult);
			Thread.sleep(1000);
			
			user.userUpdateMyProfile(6, browser, logresult);
			Thread.sleep(1000);
			
			user.userUpdateMyProfile(8, browser, logresult);
			Thread.sleep(1000);
			
			user.userUpdateMyProfile(10, browser, logresult);
			Thread.sleep(1000);
			
			user.userSearch(22, browser, logresult);
			Thread.sleep(1000);
			
			user.userSearch(24, browser, logresult);
			Thread.sleep(1000);
			
			user.userSearch(10, browser, logresult);
			Thread.sleep(1000);
			
			user.verifyUserDetail(16, browser, logresult);
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
