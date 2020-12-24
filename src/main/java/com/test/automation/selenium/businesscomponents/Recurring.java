package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class Recurring {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void verifyAddBillingPlanFields(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring_VerifyAddBP", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void verifyUpdateBillingPlanFields(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring_VerifyUpdateBP", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addBillingPlan(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring_BPAdd", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void searchBillingPlan(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring_BPSearch", intRowNum);
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
			
			browser.InputData("Recurring_CustomerAdd", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addCustomer1(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring_CustomerAdd1", intRowNum);
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
			
			browser.InputData("Recurring_CustomerUpdate", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void multipleContract(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Recurring_MultipleContract", intRowNum);
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
			
			browser.InputData("Recurring_CustomerSearch", intRowNum);
			Thread.sleep(1000);
			
			}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
