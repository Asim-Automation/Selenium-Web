package com.investor.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.investor.base.BaseClass;
import com.investor.utilities.MonitoringMail;
import com.investor.utilities.TestConfig;


public class CustomListeners extends BaseClass implements ITestListener,ISuiteListener {

	public 	String messageBody;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		printString("Start test",driver);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		UtilitycaptureScreenshot();
		
		
		
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+UtilityscreenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+UtilityscreenshotName+"><img src="+UtilityscreenshotName+" height=200 width=200></img></a>");
//		rep.endTest(test);
//		rep.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {


//		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
//		rep.endTest(test);
//		rep.flush();
		
	}


	public void onTestStart(ITestResult arg0) {

//		test = rep.startTest(arg0.getName().toUpperCase());
	
	}

	public void onTestSuccess(ITestResult arg0) {


//		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
//		rep.endTest(test);
//		rep.flush();
		
	}

	public void onFinish(ISuite arg0) {
		
		MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/LiveProject%20-%20PageObjectModel/Extent_Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void onStart(ISuite arg0) {
		printString("Start suite",driver);
	}

}
