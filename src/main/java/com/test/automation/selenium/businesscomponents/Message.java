package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class Message {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void addMessage(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Add", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
 public void updateMessage(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Update", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	public void verifyMessage(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Verify", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	
	public void verifyDashboard(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Dashboard", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	public void verifyInformation(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Information", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	
	public void verifyWarning(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Warning", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	
	public void verifyReminder(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Message_Reminder", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
}