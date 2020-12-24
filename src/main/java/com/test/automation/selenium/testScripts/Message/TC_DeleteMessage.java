package com.test.automation.selenium.testScripts.Message;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_DeleteMessage {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strMessageSubject = null;
	String strMessageText = null;
						
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		Message msg = new Message();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		msg.addMessage(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(8, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			strMessageSubject = driver.findElement(By.id("messageSubject")).getAttribute("value");
			
			browser.excel.storeCellData("Message_Dashboard", "xpath:://div[@class='messageListText']/div[1]/a[text()='"+strMessageSubject+"']", 1, 2);
			browser.excel.storeCellData("Message_Dashboard", "text::"+strMessageSubject, 6, 2);
			
			browser.excel.storeCellData("Message_Add", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubject+"']/../../td[7]/span[2]/button", 1, 19);
			
			strMessageText = driver.findElement(By.xpath("//div[@class='note-editable']")).getText();
			browser.excel.storeCellData("Message_Dashboard", "xpath:://div[@class='messageListText']/div[2][text()='"+strMessageText+"']", 1, 3);
			browser.excel.storeCellData("Message_Dashboard", "text::"+strMessageText, 6, 3);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		msg.addMessage(14, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyDashboard(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(16, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(18, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(20, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			List<WebElement> lstMessageSubject = driver.findElements(By.xpath("//div[@class='messageListText']/div[1]/a[text()='"+strMessageSubject+"']"));
			
			if (lstMessageSubject.size() > 0){
				
				logresult.logTest("Test Execution", "Status", "INFO", strMessageSubject+" is displayed on the Dashboard after Deletion!!!", "", "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", strMessageSubject+" is not displayed on the Dashboard after Deletion!!!", "", "");
			}
			
			
			List<WebElement> lstMessageText = driver.findElements(By.xpath("//div[@class='messageListText']/div[2][text()='"+strMessageText+"']"));
			
			if (lstMessageText.size() > 0){
				
				logresult.logTest("Test Execution", "Status", "INFO", strMessageText+" is displayed on the Dashboard after Deletion!!!", "", "");
			}
			
			else{
				
				logresult.logTest("Test Execution", "Status", "INFO", strMessageText+" is not displayed on the Dashboard after Deletion!!!", "", "");
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

