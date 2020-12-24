package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TokenManager {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void requestCardToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TokenManager_RequestCardToken", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCardToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TokenManager_UpdateCardToken", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void requestCheckToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TokenManager_RequestCheckToken", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCheckToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TokenManager_UpdateCheckToken", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateMerchant(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TokenManager_UpdateMerchant", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
