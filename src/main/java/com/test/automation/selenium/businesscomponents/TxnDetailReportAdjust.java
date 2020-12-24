package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TxnDetailReportAdjust {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void vtCard(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlReportAdjust_Card", intRowNum);
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
	
	public void vtRequestCardToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlReportAdjust_ReqToken", intRowNum);
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
	
	public void vtToken(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlReportAdjust_Token", intRowNum);
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
	
	
	public void vtAdjust(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlReportAdjust_Adjust", intRowNum);
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
			
			browser.InputData("TxnDtlReportAdjust_Dashboard", intRowNum);
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
	
	public void vtCardReports(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDtlReportAdjust_CardReports", intRowNum);
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
			
			browser.InputData("TxnDtlReportAdjust_Report", intRowNum);
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
			
			browser.InputData("TxnDtlReportAdjust_CheckButton", intRowNum);
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