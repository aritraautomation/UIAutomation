package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TxnDetailReportACH {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void vtRoutingAccountNumber(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_RoutingAcctNumber", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	
	public void vtRequestACHToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_RequestCheckToken", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	
	public void vtACHToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_Token", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/

	}
	
	public void vtDashboard(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_Dashboard", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/
		
	}
	
	public void vtACHReports(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_ACHReports", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/
		
	}
	
	public void txnDetailReport(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_Report", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/
		
	}
	
	public void txnDetailReportCheckButton(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlRprtACH_CheckButton", intRowNum);
			Thread.sleep(2000);
			
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
		       result.endTest();
		       result.closeReport();
		}*/
		
	}
	

}