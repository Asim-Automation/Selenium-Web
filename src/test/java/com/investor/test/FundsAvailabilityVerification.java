package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.FundTransferPage;
import com.investor.pages.LoginPage;
import com.investor.utilities.SlackUtils;
import com.slack.api.methods.SlackApiException;

public class FundsAvailabilityVerification extends BaseClass {

	@Test(groups = "IsCashAvailable")
	public void VerifyFundsAvailable_Premium() {
		String tempSrc = "";
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;
		String slackMessage = "";
		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);
		printString("VerifyFundsAvailable_Premium: " + driver.hashCode() + "", driver);
		Double VestedBalance = 0.0;
		Double BuyingPower = 0.0;
		Double UnsettledCash = 0.0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-375?atlOrigin=eyJpIjoiNmRlZjZkYWI5ZGViNDRjZDk0ZmU0MDQwYTkyMmVlYmMiLCJwIjoiaiJ9\">QAA-375 : Web - Write a testcase to check if cash is available<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			waitTime(1500);
			BuyingPower = fundTransferPage.getBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : Buying Power: " + BuyingPower);

			UnsettledCash = fundTransferPage.getUnSettledCash(driver);
			testSteps.add("Step " + (++i) + " : UnSettled Cash: " + UnsettledCash);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
//			fundTransferPage.clickOnBtnTransfer(driver);
//
//			VestedBalance = fundTransferPage.getvestedAvailableBalance(driver);
//			testSteps.add("Step " + (++i) + " : Available Vested Balance: <b>USD " + VestedBalance);
//			tempSrc = getScreenshotPath();
//			testSteps.add(tempSrc);
//			captureCapture(driver, tempSrc);
//			if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				if (!(VestedBalance > 51)) {
//					assertTrue(VestedBalance > 51,
//							"Available Amount is not enough to execute all Test cases in Pre-Prod");
//				}
//			} else {
//				if (!(VestedBalance > 2000)) {
//					assertTrue(VestedBalance > 2000, "Available Amount is not enough to execute all Test cases in "+PropertiesReader.getPropertyValue("env"));
//				}
//			}

			if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				if (!(BuyingPower > 10)) {
					testSteps.add("Step " + (++i) + " : Verifying Buying Power must be greater than 10");
					assertTrue(BuyingPower > 10, "Buying Power is not greater than 10 in Pre-Prod");
					testSteps.add("Step " + (++i) + " : Verified:  Buying Power must be greater than 10");
				}
			} else {
				if (!(BuyingPower > 500)) {
					assertTrue(BuyingPower > 500,
							"Buying Power is not greater than 500 in " + PropertiesReader.getPropertyValue("env"));
				}
			}

			testSteps.add("Step " + (++i) + " : Verifing BuyingPower must be greater than Unsettled Cash");
			assertTrue(BuyingPower >= UnsettledCash, "Buying Power is not greater than UnSettled Cash");
			testSteps.add("Step " + (++i) + " : Verified:  BuyingPower must be greater than Unsettled Cash");

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");

			AddTest_IntoReport("VerifyFundsAvailable_Premium", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: VerifyFundsAvailable_Premium " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyFundsAvailable_Premium") == RetryListener.maxRetryCnt) {
				if (e.toString().contains("Buying Power is not greater than")
						|| e.toString().contains("Buying Power is not greater than UnSettled Cash")) {
					slackMessage = fundTransferPage.getSlackMessage(driver,
							PropertiesReader.getPropertyValue(env + "_" + "EmailId"),
							PropertiesReader.getPropertyValue("env"), "BuyingPower");
				} else {
					slackMessage = fundTransferPage.getSlackMessage(driver,
							PropertiesReader.getPropertyValue(env + "_" + "EmailId"),
							PropertiesReader.getPropertyValue("env"), "Funds");
				}

				try {
					SlackUtils.SendSlackMessage(slackMessage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SlackApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				testSteps.add(premiumSkippedTestCases);
				AddTest_IntoReport("VerifyFundsAvailable_Premium", testSteps, driver);
			} else {
				quitBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyFundsAvailable_Premium " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyFundsAvailable_Premium") == RetryListener.maxRetryCnt) {
				if (e.toString().contains("Buying Power is not greater than")
						|| e.toString().contains("Buying Power is not greater than UnSettled Cash")) {
					slackMessage = fundTransferPage.getSlackMessage(driver,
							PropertiesReader.getPropertyValue(env + "_" + "EmailId"),
							PropertiesReader.getPropertyValue("env"), "BuyingPower");
				} else {
					slackMessage = fundTransferPage.getSlackMessage(driver,
							PropertiesReader.getPropertyValue(env + "_" + "EmailId"),
							PropertiesReader.getPropertyValue("env"), "Funds");
				}

				try {
					SlackUtils.SendSlackMessage(slackMessage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SlackApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				testSteps.add(premiumSkippedTestCases);
				AddTest_IntoReport("VerifyFundsAvailable_Premium", testSteps, driver);
			} else {
				quitBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "IsCashAvailableNonPremium")
	public void VerifyFundsAvailable_NonPremium() {
		String tempSrc = "";
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		String email = "";
		String password = "";
		String slackMessage = "";
		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);
		Object[][] dataArr = getData("testData", "UserProfile_BasicPlan", driver);
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			email = "apurva.jain+production+8@vestedfinance.co";
			password = "iTestUser1!";
		} else {
			email = dataArr[0][0].toString();
			password = dataArr[0][1].toString();
		}
		printString("VerifyFundsAvailable_NonPremium: " + driver.hashCode() + "", driver);
		Double VestedBalance = 0.0;
		Double BuyingPower = 0.0;
		Double UnsettledCash = 0.0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-375?atlOrigin=eyJpIjoiNmRlZjZkYWI5ZGViNDRjZDk0ZmU0MDQwYTkyMmVlYmMiLCJwIjoiaiJ9\">QAA-375 : Web - Write a testcase to check if cash is available<a/>");
			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			BuyingPower = fundTransferPage.getBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : Buying Power: " + BuyingPower);
			UnsettledCash = fundTransferPage.getUnSettledCash(driver);
			testSteps.add("Step " + (++i) + " : UnSettled Cash: " + UnsettledCash);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
//			fundTransferPage.clickOnBtnTransfer(driver);
//
//			VestedBalance = fundTransferPage.getvestedAvailableBalance(driver);
//			testSteps.add("Step " + (++i) + " : Available Vested Balance: <b>USD " + VestedBalance);
//			tempSrc = getScreenshotPath();
//			testSteps.add(tempSrc);
//			captureCapture(driver, tempSrc);
//			if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				if (!(VestedBalance > 51)) {
//					assertTrue(VestedBalance > 51, "Available Amount is not enough to execute all Test cases in Pre-prod");
//				}
//			} else {
//				
//				if (!(VestedBalance > 2000)) {
//					assertTrue(VestedBalance > 2000, "Available Amount is not enough to execute all Test cases in "+PropertiesReader.getPropertyValue("env"));
//				}
//			}

			if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				if (!(BuyingPower > 10)) {
					testSteps.add("Step " + (++i) + " : Verifying Buying Power must be greater than 10");
					assertTrue(BuyingPower > 10, "Buying Power is not greater than 10 in Pre-Prod");
					testSteps.add("Step " + (++i) + " : Verified:  Buying Power must be greater than 10");
				}
			} else {
				if (!(BuyingPower > 500)) {
					assertTrue(BuyingPower > 500,
							"Buying Power is not greater than 500 in " + PropertiesReader.getPropertyValue("env"));
				}
			}

			testSteps.add("Step " + (++i) + " : Verifing BuyingPower must be greater than Unsettled Cash");
			assertTrue(BuyingPower >= UnsettledCash, "Buying Power is not greater than UnSettled Cash");
			testSteps.add("Step " + (++i) + " : Verified:  BuyingPower must be greater than Unsettled Cash");
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("VerifyFundsAvailable_NonPremium", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: VerifyFundsAvailable_NonPremium " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyFundsAvailable_NonPremium") == RetryListener.maxRetryCnt) {

				if (e.toString().contains("Buying Power is not greater than")
						|| e.toString().contains("Buying Power is not greater than UnSettled Cash")) {
					slackMessage = fundTransferPage.getSlackMessage(driver, email,
							PropertiesReader.getPropertyValue("env"), "BuyingPower");
				} else {
					slackMessage = fundTransferPage.getSlackMessage(driver, email,
							PropertiesReader.getPropertyValue("env"), "Funds");
				}
				try {
					SlackUtils.SendSlackMessage(slackMessage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SlackApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				testSteps.add(nonPremiumSkippedTestCases);
				AddTest_IntoReport("VerifyFundsAvailable_NonPremium", testSteps, driver);
			} else {
				quitBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyFundsAvailable_NonPremium " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyFundsAvailable_NonPremium") == RetryListener.maxRetryCnt) {
				if (e.toString().contains("Buying Power is not greater than")
						|| e.toString().contains("Buying Power is not greater than UnSettled Cash")) {
					slackMessage = fundTransferPage.getSlackMessage(driver, email,
							PropertiesReader.getPropertyValue("env"), "BuyingPower");
				} else {
					slackMessage = fundTransferPage.getSlackMessage(driver, email,
							PropertiesReader.getPropertyValue("env"), "Funds");
				}
				try {
					SlackUtils.SendSlackMessage(slackMessage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SlackApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				testSteps.add(nonPremiumSkippedTestCases);
				AddTest_IntoReport("VerifyFundsAvailable_NonPremium", testSteps, driver);
			} else {
				quitBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
