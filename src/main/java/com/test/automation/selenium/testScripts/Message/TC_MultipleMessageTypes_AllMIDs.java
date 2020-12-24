package com.test.automation.selenium.testScripts.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_MultipleMessageTypes_AllMIDs {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String strMessageSubjectInformation = null;
	String strMessageTextInformation = null;
	String strMessageTypeInformation = null;
	String strMessageSubjectWarning = null;
	String strMessageTextWarning = null;
	String strMessageTypeWarning = null;
	String strMessageSubjectReminder = null;
	String strMessageTextReminder = null;
	String strMessageTypeReminder = null;
					
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
			
			strMessageSubjectInformation = driver.findElement(By.id("messageSubject")).getAttribute("value");
			browser.excel.storeCellData("Message_Information", "text::"+strMessageSubjectInformation, 4, 1);
			browser.excel.storeCellData("Message_Information", "xpath:://div[@class='messageListText']/div[1]/a[text()='"+strMessageSubjectInformation+"']", 1, 4);
			browser.excel.storeCellData("Message_Information", "text::"+strMessageSubjectInformation, 6, 4);
			browser.excel.storeCellData("Message_Information", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectInformation+"']", 1, 1);
			browser.excel.storeCellData("Message_Information", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectInformation+"']/../../td[2]/span", 1, 2);
			browser.excel.storeCellData("Message_Information", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectInformation+"']/../../td[6]/span", 1, 3);
			browser.excel.storeCellData("Message_Information", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectInformation+"']/../../td[7]/span[2]/button", 1, 6);
			
			strMessageTypeInformation = driver.findElement(By.xpath("//div[@id='messageType']/button//div/span")).getText();
			browser.excel.storeCellData("Message_Information", "text::"+strMessageTypeInformation, 4, 2);
			
			strMessageTextInformation = driver.findElement(By.xpath("//div[@class='note-editable']")).getText();
			browser.excel.storeCellData("Message_Information", "xpath:://div[@class='messageListText']/div[2][text()='"+strMessageTextInformation+"']", 1, 5);
			browser.excel.storeCellData("Message_Information", "text::"+strMessageTextInformation, 6, 5);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		msg.addMessage(14, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(10, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			strMessageSubjectWarning = driver.findElement(By.id("messageSubject")).getAttribute("value");
			browser.excel.storeCellData("Message_Warning", "text::"+strMessageSubjectWarning, 4, 1);
			browser.excel.storeCellData("Message_Warning", "xpath:://div[@class='messageListText']/div[1]/a[text()='"+strMessageSubjectWarning+"']", 1, 4);
			browser.excel.storeCellData("Message_Warning", "text::"+strMessageSubjectWarning, 6, 4);
			browser.excel.storeCellData("Message_Warning", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectWarning+"']", 1, 1);
			browser.excel.storeCellData("Message_Warning", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectWarning+"']/../../td[2]/span", 1, 2);
			browser.excel.storeCellData("Message_Warning", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectWarning+"']/../../td[6]/span", 1, 3);
			browser.excel.storeCellData("Message_Warning", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectWarning+"']/../../td[7]/span[2]/button", 1, 6);
			
			strMessageTypeWarning = driver.findElement(By.xpath("//div[@id='messageType']/button//div/span")).getText();
			browser.excel.storeCellData("Message_Warning", "text::"+strMessageTypeWarning, 4, 2);
			
			strMessageTextWarning = driver.findElement(By.xpath("//div[@class='note-editable']")).getText();
			browser.excel.storeCellData("Message_Warning", "xpath:://div[@class='messageListText']/div[2][text()='"+strMessageTextWarning+"']", 1, 5);
			browser.excel.storeCellData("Message_Warning", "text::"+strMessageTextWarning, 6, 5);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		msg.addMessage(14, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(12, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			
			strMessageSubjectReminder = driver.findElement(By.id("messageSubject")).getAttribute("value");
			browser.excel.storeCellData("Message_Reminder", "text::"+strMessageSubjectReminder, 4, 1);
			browser.excel.storeCellData("Message_Reminder", "xpath:://div[@class='messageListText']/div[1]/a[text()='"+strMessageSubjectReminder+"']", 1, 4);
			browser.excel.storeCellData("Message_Reminder", "text::"+strMessageSubjectReminder, 6, 4);
			browser.excel.storeCellData("Message_Reminder", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectReminder+"']", 1, 1);
			browser.excel.storeCellData("Message_Reminder", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectReminder+"']/../../td[2]/span", 1, 2);
			browser.excel.storeCellData("Message_Reminder", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectReminder+"']/../../td[6]/span", 1, 3);
			browser.excel.storeCellData("Message_Reminder", "xpath:://table[@class='rtable']/tbody/tr[*]/td[1]/span[text()='"+strMessageSubjectReminder+"']/../../td[7]/span[2]/button", 1, 6);
			
			strMessageTypeReminder = driver.findElement(By.xpath("//div[@id='messageType']/button//div/span")).getText();
			browser.excel.storeCellData("Message_Reminder", "text::"+strMessageTypeReminder, 4, 2);
			
			strMessageTextReminder = driver.findElement(By.xpath("//div[@class='note-editable']")).getText();
			browser.excel.storeCellData("Message_Reminder", "xpath:://div[@class='messageListText']/div[2][text()='"+strMessageTextReminder+"']", 1, 5);
			browser.excel.storeCellData("Message_Reminder", "text::"+strMessageTextReminder, 6, 5);
			Thread.sleep(1000);
			}
		catch(Exception e){
			logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
		}
		
		msg.addMessage(14, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyInformation(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyWarning(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyReminder(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyDashboard(4, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyInformation(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyWarning(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyReminder(6, browser, logresult);
		Thread.sleep(1000);
		
		msg.addMessage(16, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyInformation(8, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyInformation(10, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyWarning(8, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyWarning(10, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyReminder(8, browser, logresult);
		Thread.sleep(1000);
		
		msg.verifyReminder(10, browser, logresult);
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

