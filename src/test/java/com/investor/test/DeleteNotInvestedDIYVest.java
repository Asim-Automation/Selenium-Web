package com.investor.test;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.DIYVestPage;
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.NavigationPage;

public class DeleteNotInvestedDIYVest extends BaseClass {
	String tempSrc = "";

	@Test
	public void DeleteNonInvested_DIYVest() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String dashboardTitle = "Dashboard | Vested Finance";
		ArrayList<Double> percentageList = new ArrayList<Double>();
		ArrayList<Double> sortedPercentageList = new ArrayList<Double>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> alphabeticallySortednameList = new ArrayList<String>();
		String newVestTitle = generateRandomStringWithGivenNumberOfDigits(1, driver) + "testvest"
				+ generateRandomNumberWithGivenNumberOfDigits(3, driver);
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_Sort:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String password = dataArr[rowIndex][2].toString();
		String pinCode = dataArr[rowIndex][3].toString();
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-315?atlOrigin=eyJpIjoiNmM0MWNjOWNmZWM4NDE5OGFjNDMyMWE2ZDMwYzU5ZGUiLCJwIjoiaiJ9\">QAA-315 : [Web] - Delete Not Invested DIY Vest<a/>");

			testSteps.add("Step " + (++i) + "Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Dashboard page'</b> is displaying after clicking on <b>'Home'</b> button");

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.addAll(diyVestPage.deleteNotVestedThreeDotButton(driver));
			testSteps.addAll(diyVestPage.deleteNotVestedThreeDotButton(driver));
			testSteps.addAll(diyVestPage.deleteNotVestedThreeDotButton(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DeleteNonInvested_DIYVest", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: DeleteNonInvested_DIYVest " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DeleteNonInvested_DIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DeleteNonInvested_DIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DeleteNonInvested_DIYVest " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DeleteNonInvested_DIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DeleteNonInvested_DIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void CancelAllPendingOrders() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		String dashboardTitle = "Dashboard | Vested Finance";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Cancel_Pending_Orders:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-323?atlOrigin=eyJpIjoiYzI5Y2Y2MjZhMDBiNGRhZjg1OThjNGEyNjQwNDFkODYiLCJwIjoiaiJ9\">QAA-323 : [Web] - Cancel All Pending Orders<a/>");

			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");
			testSteps.addAll(instrumentPage.ClosePendingOrders(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("CancelAllPendingOrders", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: CancelAllPendingOrders " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("CancelAllPendingOrders") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("CancelAllPendingOrders", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: CancelAllPendingOrders " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("CancelAllPendingOrders") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("CancelAllPendingOrders", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}