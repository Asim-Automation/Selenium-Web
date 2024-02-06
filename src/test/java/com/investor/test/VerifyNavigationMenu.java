package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.LoginPage;
import com.investor.pages.NavigationPage;

public class VerifyNavigationMenu extends BaseClass {
	String tempSrc = "";

	@Test(groups = { "Grp_MonkeyTest" })
	public void MonkeyTest_ClickAllTabs() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		String dashboardTitle = "Dashboard | Vested Finance";
		String transferFundsTitle = "Transfer Funds | Vested Finance";
		String diyVestTitle = "Manage - DIY Vest | Vested Finance";
		String historyVestedFinanceTitle = "History | Vested Finance";

		String tradeStatementsTitle = "Trade Statements | Vested Finance";
		String statementsTitle = "Statements | Vested Finance";
		String taxDocumentsTitle = "Tax Documents | Vested Finance";
		String faqWindowTitle = "FAQs Related Vested & Vested Products & US Stock Investment";// "Frequently Asked
																								// Questions | Vested
																								// Finance";
		String referralInviteTitle = "Referral Rewards | Vested Finance";
		String manageSubscriptionTitle = "Manage Subscription | Vested Finance";
		String investmentProfileTitle = "Investment Profile | Vested Finance";
		String recurringInvestmentsTitle = "Recurring Investments | Vested Finance";
		String securityTitle = "Login and Security | Vested Finance";
		String instrumentsPageTitle = "Invest in US Stocks & ETFs | Vested Finance";
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		printString("MonkeyTest_ClickAllTabs:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String password = dataArr[rowIndex][2].toString();
		String pinCode = dataArr[rowIndex][3].toString();
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-52?atlOrigin=eyJpIjoiOTI4NzkzMTg5ZmU5NGEwOWFjMWIzOTg5NGNiNzdiOGMiLCJwIjoiaiJ9\">QAA-52 : Web - Verify user is able to access all tabs on navigation menu after logging in<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Home' button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Next verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Transfer Fund</b> page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Transfer' button");
			navigationPage.clickOnTransferBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify Transfer Fund page is displaying");
			assertEquals(loginPage.getPageTitle(driver), transferFundsTitle,
					"Failed : Transfer Fund page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Next verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Vested Direct</b> page is displaying after clicking on Vested Direct button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			
			testSteps.add("Step " + (++i) + " : click 'Referal' button");
			navigationPage.clickOnReferalBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify Referal page is displaying");
			assertEquals(loginPage.getPageTitle(driver), referralInviteTitle,
					"Failed : Referal page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Next verification
			testSteps.add(
					"Step " + (++i) + " : Verify <b>DIY Vest</b> page is displaying after clicking on DIY Vest button");

			testSteps.add("Step " + (++i) + " : click 'DIY Vest' button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify DIY Vest page is displaying");
			assertEquals(loginPage.getPageTitle(driver), diyVestTitle, "Failed : DIY Vest page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Profile Next verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Transactions</b> page is displaying after clicking on 'Transactions' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Transactions' button");
			navigationPage.clickOnTransactionsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Transactions' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), historyVestedFinanceTitle,
					"Failed : Transactions page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Profile Trade Confirmations verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Trade Confirmations</b> page is displaying after clicking on 'Trade Confirmations' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Trade Confirmations' button");
			navigationPage.clickOnTradeConfirmationsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Trade Confirmations' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), tradeStatementsTitle,
					"Failed : Trade Confirmations page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Profile Account Statements verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Account Statements</b> page is displaying after clicking on 'Account Statements' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Account Statements' button");
			navigationPage.clickOnAccountStatementsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Account Statements' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), statementsTitle,
					"Failed : Account Statements page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Profile Tax Documents verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Tax Documents</b> page is displaying after clicking on 'Tax Documents' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Tax Documents' button");
			navigationPage.clickOnTaxDocumentsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Tax Documents' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), taxDocumentsTitle,
					"Failed : Tax Documents page title not matched");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			// Profile FAQ

			testSteps.add("Step " + (++i) + " : Verify <b>FAQ</b> page is displaying after clicking on 'FAQ' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'FAQ' button");
			navigationPage.clickOnFaqBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'FAQ' page opened in new tab on clicking 'FAQ' button.");
			ArrayList<String> getWindowsTitle = getWindows(driver);
			assertEquals(getWindowsTitle.size(), 2);

			testSteps.add("Step " + (++i) + " : Switch to newly opened window to verify FAQ page Title");
			switchTab(1, driver);

			testSteps.add("Step " + (++i) + " : Verify 'FAQ' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), faqWindowTitle, "Failed : FAQ page title not matched");

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify FAQ page Title");
			closeTab(1, driver);

			// Profile Referral verification
			testSteps.add("Step " + (++i)
					+ " : Verify <b>Referral</b> page is displaying after clicking on 'Referral' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Referral' button");
			navigationPage.clickOnReferralBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Referral' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), referralInviteTitle,
					"Failed : Referral page title not matched");

			// Profile Manage Plan

			testSteps.add("Step " + (++i)
					+ " : Verify <b>Manage Plan</b> page is displaying after clicking on 'Manage Plan' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Manage Plan' button");
			navigationPage.clickOnManagePlanBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Manage Plan' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), manageSubscriptionTitle,
					"Failed : Manage Plan page title not matched");

			// Profile Investment Profile

			testSteps.add("Step " + (++i)
					+ " : Verify <b>Investment Profile</b> page is displaying after clicking on 'Investment Profile' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Investment Profile' button");
			navigationPage.clickOnInvestmentProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Investment Profile' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), investmentProfileTitle,
					"Failed : Investment Profile page title not matched");

			// Profile Recurring Investments

			testSteps.add("Step " + (++i)
					+ " : Verify <b>Recurring Investments</b> page is displaying after clicking on 'Recurring Investments' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Recurring Investments' button");
			navigationPage.clickOnRecurringInvestmentsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Recurring Investments' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), recurringInvestmentsTitle,
					"Failed : Recurring Investments page title not matched");

			// Profile Security

			testSteps.add("Step " + (++i)
					+ " : Verify <b>Security</b> page is displaying after clicking on 'Security' button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++i) + " : click 'Security' button");
			navigationPage.clickOnSecurityBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Security' page title is displaying");
			assertEquals(loginPage.getPageTitle(driver), securityTitle, "Failed : Security page title not matched");

			testSteps.add("Step " + (++i) + " : Verify 'Login and Security' page is displaying");
			assertEquals(navigationPage.getSecurityPageHeading(driver), "Login and Security",
					"Failed : Login and Security page heading not matched");

			testSteps.add("Step " + (++i) + " : Verify <b>Instruments</b> page is displaying");
			waitTime(2000, driver);
			testSteps.add("Step " + (++i) + " : Go to Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			assertEquals(loginPage.getPageTitle(driver), instrumentsPageTitle,
					"Failed : Instruments title not matched");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_ClickAllTabs", testSteps, driver);

		} catch (Exception e) {
			e.printStackTrace();
			testSteps.add("Failed: MonkeyTest_ClickAllTabs " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_ClickAllTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_ClickAllTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			e.printStackTrace();
			testSteps.add("Failed: MonkeyTest_ClickAllTabs " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_ClickAllTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_ClickAllTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}
}
