package com.test.automation.selenium.testScripts.Recurring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.test.automation.selenium.businesscomponents.*;
import com.test.automation.selenium.framework.Browser;
import com.test.automation.selenium.framework.logResult;


public class TC_Notice_AddNotice_EmailTypeSchedulePayment_Suspend {
	
	Browser browser;
	logResult logresult;
	
	public WebDriver driver;
	String txtBillingPlan = null;
	String txtCustomerNo = null;
	String txtContractNo = null;
				
	public void ExecuteTest(String browserType, String strProgramDetails, String strTestEnvDetails, logResult result) throws Exception 
	{
		this.logresult = result;
		browser=new Browser(this.logresult);
		this.driver = browser.Open(browserType,BCEnvironment.appURL);
		
		Login login = Login.getInstance();
		Recurring1 rd = new Recurring1();
		Logout logout = new Logout();
		
		String credentials = login.run(6, browser, logresult);
		Thread.sleep(4000);
		
		rd.addBillingPlan(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addBillingPlan(6, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(24, browser, logresult);
		Thread.sleep(1000);
		
		try{
			driver=browser.driver;
			driver.findElement(By.xpath("//div[@id='billingPlan-0']/ul/li[2]/a")).click();
			
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.addCustomer(8, browser, logresult);
		Thread.sleep(1000);
		
		rd.addCustomer(10, browser, logresult);
		Thread.sleep(2000);
		
		rd.addCustomer(12, browser, logresult);
		Thread.sleep(2000);
		
		try{
			driver=browser.driver;
			txtContractNo = driver.findElement(By.id("contractNumber-0")).getAttribute("value");
			browser.excel.storeCellData("Recurring1_NoticeAdd", txtContractNo, 21, 3);
			browser.excel.storeCellData("Recurring1_NoticeSearch", txtContractNo, 3, 1);
			browser.excel.storeCellData("Recurring1_NoticeSearch", "xpath:://tbody/tr[*]/td[1][text()='"+txtContractNo+"']", 1, 4);
			browser.excel.storeCellData("Recurring1_NoticeSearch", "xpath:://tbody/tr[*]/td[1][text()='"+txtContractNo+"']/following-sibling::td[1]", 1, 5);
			browser.excel.storeCellData("Recurring1_NoticeSearch", "xpath:://tbody/tr[*]/td[1][text()='"+txtContractNo+"']/following-sibling::td[2]", 1, 6);
			browser.excel.storeCellData("Recurring1_NoticeSearch", "text::"+txtContractNo, 8, 4);
			Thread.sleep(1000);
			}
			catch(Exception e){
				logresult.logTest("Test Execution", "Status", "INFO", "Exception occurred!!!", e.getMessage(), "");
			}
		
		rd.updateCustomer(34, browser, logresult);
		Thread.sleep(2000);
		
		rd.addNotice(4, browser, logresult);
		Thread.sleep(1000);
		
		rd.addNotice(6, browser, logresult);
		Thread.sleep(1000);
		
		rd.addNotice(22, browser, logresult);
		Thread.sleep(1000);
		
		/*rd.searchNotice(4, browser, logresult);
		Thread.sleep(1000);*/
		
		rd.searchNotice(8, browser, logresult);
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

