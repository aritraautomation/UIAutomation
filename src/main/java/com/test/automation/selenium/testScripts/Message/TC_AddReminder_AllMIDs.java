package com.test.automation.selenium.testScripts.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_AddReminder_AllMIDs {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strMessageSubject = null;
	String strMessageText = null;
	String strMessageType = null;
					
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
		
		msg.addMessage(12, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			strMessageSubject = driver.findElement(By.id("messageSubject")).getAttribute("value");
			browser.excel.storeCellData("Message_Verify", "text::"+strMessageSubject, 4, 1);
			browser.excel.storeCellData("Message_Dashboard", "xpath:://div[@class='messageListText']/div[1]/a[text()='"+strMessageSubject+"']", 1, 2);
			browser.excel.storeCellData("Message_Dashboard", "text::"+strMessageSubject, 6, 2);
			browser.excel.storeCellData("Message_Verify", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubject+"']", 1, 1);
			browser.excel.storeCellData("Message_Verify", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubject+"']/../../td[2]/span", 1, 2);
			browser.excel.storeCellData("Message_Verify", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubject+"']/../../td[6]/span", 1, 3);
			browser.excel.storeCellData("Message_Add", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubject+"']/../../td[7]/span[2]/button", 1, 19);
			
			strMessageType = driver.findElement(By.xpath("//div[@id='messageType']/button//div/span")).getText();
			browser.excel.storeCellData("Message_Verify", "text::"+strMessageType, 4, 2);
			
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
		
		msg.verifyMessage(4, browser, logresult);
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
		
		logout.run(4, browser, logresult);
		Thread.sleep(1000);

		logout.run(6, browser, logresult);
		Thread.sleep(1000);
		
		logout.run(8, browser, logresult);CredentialManager.getInstance().releaseCredentials(credentials);
		Thread.sleep(1000);
	
		browser.Close();
		
		}


}

