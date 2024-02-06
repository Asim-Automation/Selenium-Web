package com.investor.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.MonkeyPageObject;
import com.investor.pages.NavigationPage;

public class VerifyTransactionHistory extends BaseClass {
	private String tempSrc = "";

	@Test
	public void VerifyTransactionHistoryPage_MarketBuy() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String email = "beta23@codeautomation.ai";
		String password = "Friend@0201";
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			email = "apurva.jain+production+9@vestedfinance.co";
			password = "iTestUser1!";
		}
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		printString("VerifyTransactionHistoryPage_MarketBuy:" + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-460?atlOrigin=eyJpIjoiZmJlZDAwZjc5NTM4NDAwZmIzNGVjNDhmYTM3MDNhMmUiLCJwIjoiaiJ9\">QAA-460.1 : [Web] Verify market buy in profile transaction page<a/>");
			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click On <b>'Profile Icon'</b>");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Transactions' Button</b>");
			navigationPage.clickOnTransactionsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);

			wait6s();

			testSteps.add("Step " + (++i) + " : Click On <b>'Completed Transactions Filter'</b>");
			navigationPage.clickOnCompletedTransactionsFilterBtn(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Completed Transactions Buy'</b>");
			navigationPage.clickOnCompletedTransactionsBuyBtn(driver);

			testSteps.addAll(instrumentPage.getTransactionMarketBuyTextAndColor(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyTransactionHistoryPage_MarketBuy", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: VerifyTransactionHistoryPage_MarketBuy " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyTransactionHistoryPage_MarketBuy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyTransactionHistoryPage_MarketBuy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyTransactionHistoryPage_MarketBuy " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyTransactionHistoryPage_MarketBuy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyTransactionHistoryPage_MarketBuy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyTransactionHistoryPage_MarketSell() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String email = "beta23@codeautomation.ai";
		String password = "Friend@0201";
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			email = "apurva.jain+production+9@vestedfinance.co";
			password = "iTestUser1!";
		}
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		printString("VerifyTransactionHistoryPage_MarketSell:" + driver.hashCode() + "", driver);
		int i = 0;

		printString(BaseClass.methodNamelist.toString());
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-460?atlOrigin=eyJpIjoiZmJlZDAwZjc5NTM4NDAwZmIzNGVjNDhmYTM3MDNhMmUiLCJwIjoiaiJ9\">QAA-460.2 : [Web] Verify market sell in profile transaction page<a/>");
			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click On <b>'Profile Icon'</b>");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Transactions' Button</b>");
			navigationPage.clickOnTransactionsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);

			wait6s();
			testSteps.add("Step " + (++i) + " : Click On <b>'Completed Transactions Filter'</b>");
			navigationPage.clickOnCompletedTransactionsFilterBtn(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Completed Transactions Sell'</b>");
			navigationPage.clickOnCompletedTransactionsSellBtn(driver);

			testSteps.addAll(instrumentPage.getTransactionMarketSellTextAndColor(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyTransactionHistoryPage_MarketSell", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: VerifyTransactionHistoryPage_MarketSell " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyTransactionHistoryPage_MarketSell") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyTransactionHistoryPage_MarketSell", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyTransactionHistoryPage_MarketSell " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyTransactionHistoryPage_MarketSell") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyTransactionHistoryPage_MarketSell", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyTransactionHistoryPage_Deposit() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String email = "beta23@codeautomation.ai";
		String password = "Friend@0201";
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			email = "apurva.jain+production+9@vestedfinance.co";
			password = "iTestUser1!";
		}
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		printString("VerifyTransactionHistoryPage_Deposit:" + driver.hashCode() + "", driver);
		int i = 0;

		printString(BaseClass.methodNamelist.toString());
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-460?atlOrigin=eyJpIjoiZmJlZDAwZjc5NTM4NDAwZmIzNGVjNDhmYTM3MDNhMmUiLCJwIjoiaiJ9\">QAA-460.3 : [Web] Verify 'deposit' in profile transaction page<a/>");
			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click On <b>'Profile Icon'</b>");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Transactions' Button</b>");
			navigationPage.clickOnTransactionsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);

			wait6s();
			testSteps.add("Step " + (++i) + " : Click On <b>'Completed Transactions Filter'</b>");
			navigationPage.clickOnCompletedTransactionsFilterBtn(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Completed Transactions Deposits'</b>");
			navigationPage.clickOnCompletedTransactionsDepositBtn(driver);

			testSteps.addAll(instrumentPage.getTransactionDepositTextAndColor(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyTransactionHistoryPage_Deposit", testSteps, driver);

		} catch (Exception e) {

			testSteps
					.add("Failed: VerifyTransactionHistoryPage_Deposit " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyTransactionHistoryPage_Deposit") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyTransactionHistoryPage_Deposit", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyTransactionHistoryPage_Deposit " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyTransactionHistoryPage_Deposit") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyTransactionHistoryPage_Deposit", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
