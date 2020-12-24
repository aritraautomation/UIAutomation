package com.test.automation.selenium.businesscomponents;

import org.openqa.selenium.WebDriver;

import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;

public class TxnDetailReportSale {
	
	public int intRowNum;
	public WebDriver driver;
	public Browser browser;
	
	public void vtCard(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_Card", intRowNum);
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
			
			browser.InputData("TxnDetailReportSale_ReqToken", intRowNum);
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
			
			browser.InputData("TxnDetailReportSale_Token", intRowNum);
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
	
	public void vtHealthCare(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_HealthCare", intRowNum);
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
	
	public void vtLevel2(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_Level2", intRowNum);
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
	
	public void vtLevel3(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_Level3", intRowNum);
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
			
			browser.InputData("TxnDetailReportSale_Dashboard", intRowNum);
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
			
			browser.InputData("TxnDetailReportSale_CardReports", intRowNum);
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
	
	public void txnDetailReportNone(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_ReportNone", intRowNum);
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
	
	public void txnDetailReportHealthCare(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_ReportHC", intRowNum);
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
	
	public void txnDetailReportLevel2(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_ReportL2", intRowNum);
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
	
	public void txnDetailReportLevel3(int rownum, Browser bwr, logResult result){
		
		this.browser = bwr;
		intRowNum = rownum;
		driver=browser.driver;
				
		try {
			
			browser.InputData("TxnDetailReportSale_ReportL3", intRowNum);
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
			
			browser.InputData("TxnDetailReportSale_CheckButton", intRowNum);
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