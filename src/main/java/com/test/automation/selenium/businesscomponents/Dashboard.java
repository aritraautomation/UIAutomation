package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class Dashboard {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void verifyChargeBackText(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("Dashboard_DB", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}