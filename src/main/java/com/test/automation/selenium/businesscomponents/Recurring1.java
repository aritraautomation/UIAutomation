package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class Recurring1 {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void addBillingPlan(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_BPAdd", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addCustomer(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_CustomerAdd", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void updateCustomer(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_CustomerUpdate", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void searchCustomer(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_CustomerSearch", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addNotice(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_NoticeAdd", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
 
	public void searchNotice(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_NoticeSearch", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateNotice(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring1_NoticeUpdate", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
