package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class MerchantBoarding {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void addMerchantGeneral(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_AddGeneral", intRowNum);
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
	
	
	public void searchMerchant(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_Search", intRowNum);
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
	
	
	public void merchantGeneral(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_General", intRowNum);
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
	
	
	public void merchantProcessing(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_Processing", intRowNum);
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
	
	public void merchantBilling(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_Billing", intRowNum);
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
	
	
	public void merchantAPIDefaults(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_APIDefaults", intRowNum);
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
	
	public void merchantDefaultValues(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_DefaultValues", intRowNum);
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
	
	public void merchantActiveInactive(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Merchant_ActiveInactive", intRowNum);
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