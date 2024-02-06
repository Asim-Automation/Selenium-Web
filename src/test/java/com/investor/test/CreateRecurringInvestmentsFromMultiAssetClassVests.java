package com.investor.test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.NavigationPage;

public class CreateRecurringInvestmentsFromMultiAssetClassVests extends BaseClass {
	String tempSrc = "";

	@Test
	public void RecurringInvestments_VerifySellButton() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		HomePage homePage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		instrumentPage = new InstrumentPage(driver);

		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		homePage = new HomePage(driver);
		printString("RecurringInvestments_VerifySellButton:" + driver.hashCode() + "", driver);

		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-391?atlOrigin=eyJpIjoiOGYwM2E1MmI2OWZhNGRmZGFiNjA2MzM4MDMyY2QzZTIiLCJwIjoiaiJ9\">QAA-391 : [Automation][Web] Verify the Sell button for the Theme Based Vest and Multi Asset Vest.<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("<b>**************For Recurring Investments Vests**************</b>");
			int count = testSteps.size();
			testSteps.addAll(homePage.verifySellButton_Vest(driver, count));
//			testSteps.add("<b>**************For Theme Based Vests**************</b>");
//			count = testSteps.size();
//			testSteps.addAll(homePage.verifySellButton_ThemeBasedVest(driver, count));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("RecurringInvestments_VerifySellButton", testSteps, driver);
		} catch (Exception e) {
			testSteps.add(
					"Failed: RecurringInvestments_VerifySellButton " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("RecurringInvestments_VerifySellButton") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("RecurringInvestments_VerifySellButton", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: RecurringInvestments_VerifySellButton " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("RecurringInvestments_VerifySellButton") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("RecurringInvestments_VerifySellButton", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 2 /* , groups = "CashRequired" */) 
	public void RecurringInvestments_Vest_MultiAssetClass() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		HomePage homePage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		instrumentPage = new InstrumentPage(driver);

		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		homePage = new HomePage(driver);
		printString("RecurringInvestments_Vest_MultiAssetClass:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, recurringInvestmentFromVests, driver);
		String emptyAmountError = dataArr[rowIndex][1].toString();
		String errorMessageForAmountLessThanTen = null;
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("staging")) {
			errorMessageForAmountLessThanTen = "Please enter a value greater than or equal to $10.00.";
		} else {
			errorMessageForAmountLessThanTen = "Please enter a value greater than or equal to $10.";
		}
		String amountToBeInvested = dataArr[rowIndex][3].toString();
		String frequencyToSelect = dataArr[rowIndex][4].toString();
		String successMessage = dataArr[rowIndex][5].toString();
		String defaultFormat = dataArr[rowIndex][6].toString();
		String confirmPageFormat = dataArr[rowIndex][7].toString();

		String aggressive = "Aggressive";
		String moderate = "Moderate";
		String conservative = "Conservative";
		ArrayList<String> dateList = new ArrayList<String>();
		String getCurrentDate;

		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-78?atlOrigin=eyJpIjoiNDMxN2JiY2VmNDg0NGY5NWExZjZlYWM4YmIwNTYyZGUiLCJwIjoiaiJ9\">QAA-78 : Web - Create a Recurring Investment from the \"Multi-Asset Class Vests\" menu in the Dashboard<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on 'Aggressive' button");
			homePage.clickOnAgressiveButton(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

//			testSteps.add("Step " + (++i) + " : Verify breadcrumb with name <b>" + aggressive + "</b>  is displaying");
//			assertTrue(homePage.isMultiVestBreadCrumbDisplaying(aggressive, driver),
//					"Verified breadcrumb with name '" + aggressive + "' is dipslaying.");

			testSteps.add("Step " + (++i) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount'</b> less than 10");
			homePage.enterInvestmentAmount("9", driver);

			testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
					+ "</b>  is displaying when investment amount is less than 10.");
			assertEquals(homePage.getInvestmentAmountError(driver), errorMessageForAmountLessThanTen,
					"Failed :error message <b>'" + errorMessageForAmountLessThanTen + "'</b> not matched");

			boolean isPremiumMember = homePage.isPremiumMemberDisplaying(driver);
			String getVestedFee = "";
			try {
				testSteps.add("Step " + (++i) + " : Verify <b>'Premium Member'</b> is displaying");
				assertTrue(isPremiumMember, "Verified 'Premium Member' is dipslaying.");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify error message <b>'" + errorMessageForAmountLessThanTen
						+ "'</b>  is displaying when investment amount is 'less than 10'");

			}

			if (isPremiumMember
					&& !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			Double getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			Double investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++i) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			String getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount' : <b>'" + amountToBeInvested + "'</b>");
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++i) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++i)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

			testSteps.add("Step " + (++i) + " : Verify frequency <b>'" + frequencyToSelect
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			String formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++i) + " : Verify Investment Amount <b>'" + amountToBeInvested
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

//			if (isPremiumMember && !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				testSteps.add("Step " + (++i) + " : Verify Vest Fee <b>'" + getVestedFee
//						+ "'</b>  is displaying on confirm recurring investment page.");
//				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
//						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
//			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add(
						"Step " + (++i) + " : Verify success message <b>'" + successMessage + "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");

			}

			testSteps.add("Step " + (++i) + " : click <b>'Home'</b> button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			// Moderate
			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on <b>'" + moderate + "'</b> button");
			homePage.clickOnModerateButton(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

//			testSteps.add("Step " + (++i) + " : Verify breadcrumb with name <b>'" + moderate + "'</b>  is displaying");
//			assertTrue(homePage.isMultiVestBreadCrumbDisplaying(moderate, driver),
//					"Verified breadcrumb with name <b>'" + moderate + "'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify error message <b>'" + emptyAmountError + "'</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>'" + emptyAmountError + "'</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount'</b> less than 10");
			homePage.enterInvestmentAmount("9", driver);

			testSteps.add("Step " + (++i) + " : Verify error message <b>'" + errorMessageForAmountLessThanTen
					+ "'</b>  is displaying when investment amount is less than 10.");
			assertEquals(homePage.getInvestmentAmountError(driver), errorMessageForAmountLessThanTen,
					"Failed :error message <b>'" + errorMessageForAmountLessThanTen + "'</b> not matched");

			isPremiumMember = homePage.isPremiumMemberDisplaying(driver);
			getVestedFee = "";
			try {
				testSteps.add("Step " + (++i) + " : Verify <b>'Premium Member'</b> is displaying");
				assertTrue(isPremiumMember, "Verified <b>'Premium Member'</b> is dipslaying.");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify error message <b>'" + errorMessageForAmountLessThanTen
						+ "'</b>  is displaying when investment amount is less than 10.");

			}

			if (isPremiumMember
					&& !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'<b>");
			getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++i) + " : Enter investment amount : <b>'" + investmentAmountGreateThanBuyingPower
					+ " '<b>");
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount' : <b>'" + amountToBeInvested + " '</b>");
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++i) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++i)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

//			testSteps.add("Step " + (++i) + " : Verify <b>'breadcrumb with name Confirm'</b> is displaying");
//			assertTrue(homePage.isConfirmPagebreadCrumbDisplaying(driver),
//					"Verified <b>'breadcrumb with name Confirm'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Verify frequency <b>" + frequencyToSelect
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);
			testSteps.add("Step " + (++i) + " : Verify Investment Amount <b>" + amountToBeInvested
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

//			if (isPremiumMember && !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				testSteps.add("Step " + (++i) + " : Verify Vest Fee <b>" + getVestedFee
//						+ "</b>  is displaying on confirm recurring investment page.");
//				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
//						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
//			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add(
						"Step " + (++i) + " : Verify success message <b>'" + successMessage + "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");
			}

			testSteps.add("Step " + (++i) + " : click <b>'Home'</b> button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			// conservative
//			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
//			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on '" + conservative + "' button");
			homePage.clickOnConservativeButton(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);
			} catch (Exception e) {
			}

//			testSteps
//					.add("Step " + (++i) + " : Verify breadcrumb with name <b>" + conservative + "</b>  is displaying");
//			assertTrue(homePage.isMultiVestBreadCrumbDisplaying(conservative, driver),
//					"Verified breadcrumb with name '" + conservative + "' is dipslaying.");

			testSteps.add("Step " + (++i) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount'</b> less than 10");
			homePage.enterInvestmentAmount("9", driver);

			testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
					+ "</b>  is displaying when investment amount is less than 10.");
			assertEquals(homePage.getInvestmentAmountError(driver), errorMessageForAmountLessThanTen,
					"Failed :error message <b>'" + errorMessageForAmountLessThanTen + "'</b> not matched");

			isPremiumMember = homePage.isPremiumMemberDisplaying(driver);
			getVestedFee = "";
			try {
				testSteps.add("Step " + (++i) + " : Verify <b>'Premium Member'</b> is displaying");
				assertTrue(isPremiumMember, "Verified 'Premium Member' is dipslaying.");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
						+ "</b>  is displaying when investment amount is less than 10.");

			}

			if (isPremiumMember
					&& !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++i) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount' : " + amountToBeInvested);
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++i) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++i)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

//			testSteps.add("Step " + (++i) + " : Verify <b>'breadcrumb with name Confirm'</b> is displaying");
//			assertTrue(homePage.isConfirmPagebreadCrumbDisplaying(driver),
//					"Verified <b>'breadcrumb with name Confirm'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Verify frequency <b>" + frequencyToSelect
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++i) + " : Verify Investment Amount <b>" + amountToBeInvested
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

//			if (isPremiumMember && !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				testSteps.add("Step " + (++i) + " : Verify Vest Fee <b>" + getVestedFee
//						+ "</b>  is displaying on confirm recurring investment page.");
//				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
//						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
//			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add(
						"Step " + (++i) + " : Verify success message <b>'" + successMessage + "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");
			}

			testSteps.add("Step " + (++i) + " : click <b>'Home'</b> button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("RecurringInvestments_Vest_MultiAssetClass", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: RecurringInvestments_Vest_MultiAssetClass " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("RecurringInvestments_Vest_MultiAssetClass") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("RecurringInvestments_Vest_MultiAssetClass", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: RecurringInvestments_Vest_MultiAssetClass " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("RecurringInvestments_Vest_MultiAssetClass") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("RecurringInvestments_Vest_MultiAssetClass", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 1/* , groups = "CashRequired" */)
	public void RecurringInvestments_Vest_ThemeBased() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		HomePage homePage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		instrumentPage = new InstrumentPage(driver);
		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		homePage = new HomePage(driver);
		printString("RecurringInvestments_Vest_ThemeBased: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, recurringInvestmentFromVests, driver);
		String emptyAmountError = dataArr[rowIndex][1].toString();
		String errorMessageForAmountLessThanTen = null;
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("staging")) {
			errorMessageForAmountLessThanTen = "Please enter a value greater than or equal to $10.00.";
		} else {
			errorMessageForAmountLessThanTen = "Please enter a value greater than or equal to $10.";
		}
		String amountToBeInvested = dataArr[rowIndex][3].toString();
		String frequencyToSelect = dataArr[rowIndex][4].toString();
		String successMessage = dataArr[rowIndex][5].toString();
		String defaultFormat = dataArr[rowIndex][6].toString();
		String confirmPageFormat = dataArr[rowIndex][7].toString();

		String getCurrentDate;
		String allWeather = "All Weather";
		String blackRockSmartBeta = "BlackRock Smart Beta";
		String swensenPortfolio = null;
		ArrayList<String> dateList = new ArrayList<String>();

		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-79?atlOrigin=eyJpIjoiOWYzNmNlYWI2NWMyNDU0MmI4NmY1ZmJjNWY5Yjk2N2IiLCJwIjoiaiJ9\">QAA-79 : Web - Create a Recurring Investment from \"Theme Based Vests\" <a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);
			allWeather = homePage.getCardNameallWeather_Button(driver);
			blackRockSmartBeta = homePage.getCardNameBlackRockSmartBetaBtn(driver);
			swensenPortfolio = homePage.getCardNameSwensenPortfolioButton(driver);

			testSteps.add("Step " + (++i) + " : Click on '" + allWeather + "' button");
			homePage.clickOnAllWeather_Button(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

//			testSteps.add("Step " + (++i) + " : Verify breadcrumb with name <b>" + saas_2 + "</b>  is displaying");
//			assertTrue(homePage.isMultiVestBreadCrumbDisplaying(saas_2, driver),
//					"Verified breadcrumb with name '" + saas_2 + "' is dipslaying.");

			testSteps.add("Step " + (++i) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount'</b> less than 10");
			homePage.enterInvestmentAmount("9", driver);

			testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
					+ "</b>  is displaying when investment amount is less than 0.");
			assertEquals(homePage.getInvestmentAmountError(driver), errorMessageForAmountLessThanTen,
					"Failed :error message <b>'" + errorMessageForAmountLessThanTen + "'</b> not matched");

			boolean isPremiumMember = homePage.isPremiumMemberDisplaying(driver);
			String getVestedFee = "";
			try {
				testSteps.add("Step " + (++i) + " : Verify <b>'Premium Member'</b> is displaying");
				assertTrue(isPremiumMember, "Verified 'Premium Member' is dipslaying.");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
						+ "</b>  is displaying when investment amount is less than 10.");

			}

			if (isPremiumMember
					&& !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			Double getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			Double investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++i) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			String getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount' : " + amountToBeInvested);
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++i) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++i)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

//			testSteps.add("Step " + (++i) + " : Verify <b>'breadcrumb with name Confirm'</b> is displaying");
//			assertTrue(homePage.isConfirmPagebreadCrumbDisplaying(driver),
//					"Verified <b>'breadcrumb with name Confirm'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Verify frequency <b>" + frequencyToSelect
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			String formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++i) + " : Verify Investment Amount <b>" + amountToBeInvested
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

//			if (isPremiumMember && !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				testSteps.add("Step " + (++i) + " : Verify Vest Fee <b>" + getVestedFee
//						+ "</b>  is displaying on confirm recurring investment page.");
//				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
//						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
//			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add(
						"Step " + (++i) + " : Verify success message <b>'" + successMessage + "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");
			}

			testSteps.add("Step " + (++i) + " : click <b>'Home'</b> button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			// Black Rock Smart beta
//			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
//			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on '" + blackRockSmartBeta + "' button");
			homePage.clickOnBlackRockSmartBetaBtn(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

//			testSteps.add("Step " + (++i) + " : Verify breadcrumb with name <b>" + blackRockSmartBeta
//					+ "</b>  is displaying");
//			assertTrue(homePage.isMultiVestBreadCrumbDisplaying(blackRockSmartBeta, driver),
//					"Verified breadcrumb with name '" + blackRockSmartBeta + "' is dipslaying.");

			testSteps.add("Step " + (++i) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount'</b> less than 10");
			homePage.enterInvestmentAmount("9", driver);

			testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
					+ "</b>  is displaying when investment amount is less than 10.");
			assertEquals(homePage.getInvestmentAmountError(driver), errorMessageForAmountLessThanTen,
					"Failed :error message <b>'" + errorMessageForAmountLessThanTen + "'</b> not matched");

			isPremiumMember = homePage.isPremiumMemberDisplaying(driver);
			getVestedFee = "";
			try {
				testSteps.add("Step " + (++i) + " : Verify <b>'Premium Member'</b> is displaying");
				assertTrue(isPremiumMember, "Verified 'Premium Member' is dipslaying.");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify error message <b>" + errorMessageForAmountLessThanTen
						+ "</b>  is displaying when investment amount is less than 10.");

			}

			if (isPremiumMember
					&& !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++i) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount' : " + amountToBeInvested);
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++i) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++i)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

//			testSteps.add("Step " + (++i) + " : Verify <b>'breadcrumb with name Confirm'</b> is displaying");
//			assertTrue(homePage.isConfirmPagebreadCrumbDisplaying(driver),
//					"Verified <b>'breadcrumb with name Confirm'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Verify frequency <b>" + frequencyToSelect
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++i) + " : Verify Investment Amount <b>" + amountToBeInvested
					+ "</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

//			if (isPremiumMember && !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				testSteps.add("Step " + (++i) + " : Verify Vest Fee <b>" + getVestedFee
//						+ "</b>  is displaying on confirm recurring investment page.");
//				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
//						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
//			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add(
						"Step " + (++i) + " : Verify success message <b>'" + successMessage + "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");
			}

			testSteps.add("Step " + (++i) + " : click <b>'Home'</b> button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			// SwensenPortfolio
//			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
//			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on <b>'" + swensenPortfolio + "'</b> button");
			homePage.clickOnSwensenPortfolioButton(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

//			testSteps.add(
//					"Step " + (++i) + " : Verify breadcrumb with name <b>'" + faangRebalance + " '</b>  is displaying");
//			assertTrue(homePage.isMultiVestBreadCrumbDisplaying(faangRebalance, driver),
//					"Verified breadcrumb with name <b>'" + faangRebalance + "'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify error message <b>'" + emptyAmountError + "'</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>'" + emptyAmountError + "'</b> not matched");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount'</b> less than 10");
			homePage.enterInvestmentAmount("9", driver);

			testSteps.add("Step " + (++i) + " : Verify error message <b>'" + errorMessageForAmountLessThanTen
					+ "'</b>  is displaying when investment amount is less than 10.");
			assertEquals(homePage.getInvestmentAmountError(driver), errorMessageForAmountLessThanTen,
					"Failed :error message <b>'" + errorMessageForAmountLessThanTen + "'</b> not matched");

			isPremiumMember = homePage.isPremiumMemberDisplaying(driver);
			getVestedFee = "";
			try {
				testSteps.add("Step " + (++i) + " : Verify <b>'Premium Member'</b> is displaying");
				assertTrue(isPremiumMember, "Verified <b>'Premium Member'</b> is dipslaying.");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify error message <b>'" + errorMessageForAmountLessThanTen
						+ "'</b>  is displaying when investment amount is less than 10.");

			}

			if (isPremiumMember
					&& !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++i) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++i) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
//		assertEquals(homePage.getStartDate(), getDateThreeDaysAheadOfCurrent, "Failed : date <b>"+ getDateThreeDaysAheadOfCurrent +"</b> not matched");		

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount' : " + amountToBeInvested);
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++i) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++i)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

//			testSteps.add("Step " + (++i) + " : Verify <b>'breadcrumb with name Confirm'</b> is displaying");
//			assertTrue(homePage.isConfirmPagebreadCrumbDisplaying(driver),
//					"Verified <b>'breadcrumb with name Confirm'</b> is dipslaying.");

			testSteps.add("Step " + (++i) + " : Verify frequency <b>'" + frequencyToSelect
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++i) + " : Verify Investment Amount <b>'" + amountToBeInvested
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

//			if (isPremiumMember && !PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				testSteps.add("Step " + (++i) + " : Verify Vest Fee <b>'" + getVestedFee
//						+ "'</b>  is displaying on confirm recurring investment page.");
//				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
//						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
//			}
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add(
						"Step " + (++i) + " : Verify success message <b>'" + successMessage + "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");
			}

			testSteps.add("Step " + (++i) + " : click <b>'Home'</b> button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("RecurringInvestments_Vest_ThemeBased", testSteps, driver);
		} catch (Exception e) {

			testSteps
					.add("Failed: RecurringInvestments_Vest_ThemeBased " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("RecurringInvestments_Vest_ThemeBased") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("RecurringInvestments_Vest_ThemeBased", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: RecurringInvestments_Vest_ThemeBased " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("RecurringInvestments_Vest_ThemeBased") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("RecurringInvestments_Vest_ThemeBased", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void KYC_ApprovedFundedAccount_Vest_MultiAssetClass() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		HomePage homePage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		instrumentPage = new InstrumentPage(driver);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		printString("RecurringInvestments_Vest_ThemeBased: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-126?atlOrigin=eyJpIjoiMThkMGU2YjFiMjM2NDZiOWI1MjBiNjRlMjY5YzIyMjIiLCJwIjoiaiJ9\">QAA--126 : [Web] Verify KYC-approved funded account user is able to view a Vests - Multi-Assets Class<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on <b>'Conservative'</b> button");
			homePage.clickOnConservativeButton(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Verifying <b>'Multi Asset Class Section'</b> is present");
			waitTime(3000, driver);
			assertTrue(homePage.isMultiAssetClassSectionPresent(driver),
					"Verified <b>'Multi Asset Class Section'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Your Position Section'</b> is present");
			assertTrue(homePage.isYourPositionSectionPresent(driver),
					"Verified <b>'Your Position Section'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Buy Button'</b> is present");
			assertTrue(homePage.isBuyButtonPresent(driver), "Verified <b>'Buy Button'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Create Recurring Investment Button'</b> is present");
			assertTrue(homePage.isCreateRecurringInvestmentButtonPresent(driver),
					"Verified <b>'Create Recurring Investment Button'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Allocations Section'</b> is present");
			assertTrue(homePage.isAllocationsSectionPresent(driver),
					"Verified <b>'Allocations Section'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Multi Asset Class - Conservative Section' is present");
			assertTrue(homePage.isMultiAssetClassConservativeSectionPresent(driver),
					"Verified 'Multi Asset Class - Conservative Section' is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Returns Section' is present");
			assertTrue(homePage.isReturnSectionPresent(driver), "Verified 'Returns Section' is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Volatility Section' is present");
			assertTrue(homePage.isVolatilitySectionPresent(driver), "Verified 'Volatility Section' is present");

			testSteps.add("Step " + (++i) + " : Click on 'Compare Vest' button");
			homePage.clickOnCompareVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Conservative vest' is present");
			assertTrue(homePage.isCompareVestConservativePresent(driver), "Verified 'Conservative vest' is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Moderate vest' is present");
			assertTrue(homePage.isCompareVestModeratePresent(driver), "Verified 'Moderate vest' is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Aggressive vest' is present");
			assertTrue(homePage.isCompareVestAggressivePresent(driver), "Verified 'Moderate vest' is present");

			testSteps.add("Step " + (++i) + " : Click on close button");
			homePage.clickOnCloseCompareVest(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'MAX'</b>");
			homePage.clickOnOverviewMax(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview Max Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview Max Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'5Y'</b>");
			homePage.clickOnOverview5Y(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 5Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 5Y Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'1Y'</b>");
			homePage.clickOnOverview1Y(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 1Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 1Y Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'3M'</b>");
			homePage.clickOnOverview3M(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 3M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'1M'</b>");
			homePage.clickOnOverview1M(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 1M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 1M Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'1W'</b>");
			homePage.clickOnOverview1W(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 1W Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 1W Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'i'</b> icon");
			homePage.clickOnIIcon(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Vest Performance Chart' is present");
			assertTrue(homePage.isVestPerformanceChartPresent(driver),
					"Verified <b>'Vest Performance Chart'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'x'</b> button");
			homePage.clickOnCloseVestPerformanceChart(driver);

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("KYC_ApprovedFundedAccount_Vest_MultiAssetClass", testSteps, driver);
		} catch (Exception e) {
			e.printStackTrace();
			testSteps.add("Failed: KYC_ApprovedFundedAccount_Vest_MultiAssetClass " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_Vest_MultiAssetClass") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_Vest_MultiAssetClass", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			e.printStackTrace();
			testSteps.add("Failed: KYC_ApprovedFundedAccount_Vest_MultiAssetClass " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_Vest_MultiAssetClass") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_Vest_MultiAssetClass", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void KYC_ApprovedFundedAccount_Vest_ThemeBased() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		HomePage homePage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		instrumentPage = new InstrumentPage(driver);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		String Vest = "";
		printString("RecurringInvestments_Vest_ThemeBased:" + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-127?atlOrigin=eyJpIjoiMzFjZjNkNDIyZTUxNGQyNjg0OWM3OWQ1NzcxZTMyNTUiLCJwIjoiaiJ9\">QAA--127 : [Web] Verify KYC-approved funded account user is able to view a Vests - Theme based<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);
			Vest = homePage.getCardNameSwensenPortfolioButton(driver).replace("Vested", "").trim();
			testSteps.add("Step " + (++i) + " : Click on '" + Vest + "' button");
			homePage.clickOnSwensenPortfolioButton(driver);
			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Verifying '" + Vest + " - Rebalance Section' is present");
			assertTrue(homePage.isFaangRebalanceSectionPresent(Vest, driver),
					"Verified '" + Vest + " Section' is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Your Position Section'</b> is present");
			waitTime(3000, driver);
			assertTrue(homePage.isYourPositionSectionPresent(driver),
					"Verified <b>'Your Position Section'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Buy Button'</b> is present");
			assertTrue(homePage.isBuyButtonPresent(driver), "Verified <b>'Buy Button'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Create Recurring Investment Button'</b> is present");
			assertTrue(homePage.isCreateRecurringInvestmentButtonPresent(driver),
					"Verified <b>'Create Recurring Investment Button'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Vest Performance Section'</b> is present");
			assertTrue(homePage.isVestPerformanceSectionPresent(driver),
					"Verified <b>'Vest Performance Section'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Allocations Section'</b> is present");
			assertTrue(homePage.isAllocationsSectionPresent(driver),
					"Verified <b>'Allocations Section'</b> is present");


			testSteps.add("Step " + (++i) + " : Click on <b>'MAX'</b>");
			homePage.clickOnOverviewMax(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview Max Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview Max Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'5Y'</b>");
			homePage.clickOnOverview5Y(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 5Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 5Y Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'1Y'</b>");
			homePage.clickOnOverview1Y(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 1Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 1Y Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'3M'</b>");
			homePage.clickOnOverview3M(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 3M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'1M'</b>");
			homePage.clickOnOverview1M(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 1M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 1M Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'1W'</b>");
			homePage.clickOnOverview1W(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Overview 1W Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Verified <b>'Overview 1W Graph'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'i'</b> icon");
			homePage.clickOnIIcon(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Vest Performance Chart' is present");
			assertTrue(homePage.isVestPerformanceChartPresent(driver),
					"Verified <b>'Vest Performance Chart'</b> is present");

			testSteps.add("Step " + (++i) + " : Click on <b>'x'</b> button");
			homePage.clickOnCloseVestPerformanceChart_2(driver);

			try {
				homePage.clickOnShareFaangRebalanceButton(driver);
				testSteps.add("Step " + (++i) + " : Click on <b>'Share'</b> button");

//				((JavascriptExecutor) driver).executeScript("window.open()");
//				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(1));
//
//				String localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
//						.getData(DataFlavor.stringFlavor);
//
//				driver.get(localClipboardData);

				testSteps.add("Step " + (++i) + " : Verifying <b>'" + Vest + " Rebalance Screen'</b> is present");
				assertTrue(homePage.isFaangRebalanceSectionPresent(Vest, driver),
						"Verified <b>'" + Vest + " Rebalance Screen'</b> is present");
			} catch (Exception e) {
				getRefreshWebPage(driver);
				testSteps.add("Step " + (++i) + " : Click on <b>'Share'</b> button");
				homePage.clickOnShareFaangRebalanceButton(driver);

				((JavascriptExecutor) driver).executeScript("window.open()");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));

				String localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
						.getData(DataFlavor.stringFlavor);

				driver.get(localClipboardData);

				testSteps.add("Step " + (++i) + " : Verifying <b>'" + Vest + " Rebalance Screen'</b> is present");
				assertTrue(homePage.isFaangRebalanceSectionPresent(Vest, driver),
						"Verified <b>'" + Vest + " Rebalance Screen'</b> is present");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("KYC_ApprovedFundedAccount_Vest_ThemeBased", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: KYC_ApprovedFundedAccount_Vest_ThemeBased " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_Vest_ThemeBased") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_Vest_ThemeBased", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(

					"Failed: KYC_ApprovedFundedAccount_Vest_ThemeBased " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_Vest_ThemeBased") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_Vest_ThemeBased", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(groups = "CashRequired")
	public void KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		HomePage homePage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		instrumentPage = new InstrumentPage(driver);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		String errorMessage = null;
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("staging")) {
			errorMessage = "Please enter a value greater than or equal to $10.00.";
		} else {
			errorMessage = "Please enter a value greater than or equal to $10.";
		}

		printString("KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-131?atlOrigin=eyJpIjoiZWFkZmRhYjI3NWIwNGE3Nzg5MzFmN2IzNmE2NTY3MzEiLCJwIjoiaiJ9\">QAA-131 : [Web] Verify KYC-approved funded account user is able to purchase a Vests - Multi-Assets Class<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);
			testSteps.add("Step " + (++i) + " : Click on <b>'Conservative'</b> button");
			homePage.clickOnConservativeButton(driver);

			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Buy'</b> button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++i) + " : Checking if 'Buy Temporary Unavailable'");
			boolean buyAvailable = homePage.isBuyTemporaryUnAvailable(driver);

			if (buyAvailable) {
				testSteps.add("Step " + (++i) + " : Click on 'x Buy Temporary Unavailable pop Up'");
				homePage.clickOnCloseVestPerformanceChart_2(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Home Tab'");
				homePage.clickOnHomeTabButton(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Show All Pending Vest Orders'");
				homePage.clickOnShowAllPendingVestOrdersButton(driver);

				testSteps.add("Step " + (++i)
						+ " : Click on 'Canceling all Pending Vest Order of Multi Asset Class Conservative'");
				homePage.clickOnCancelAllPendingMultiAssetClassConservative(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Conservative'</b> button");
				homePage.clickOnConservativeButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Buy'</b> button");
				homePage.clickOnBuyButton(driver);
			}

			testSteps.add("Step " + (++i) + " : Verifying <b>'Name'</b> is present");
			assertTrue(homePage.isNameInBuyPresent(driver), "Verified <b>'Name'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Price'</b> is present");
			assertTrue(homePage.isPriceInBuyPresent(driver), "Verified <b>'Price'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Weight' is present");
			assertTrue(homePage.isWeightInBuyPresent(driver), "Verified 'Weight' is present");

			testSteps.add("Step " + (++i) + " : Verifying 'No. of Shares' is present");
			assertTrue(homePage.isNoOfSharesInBuyPresent(driver), "Verified 'No. of Shares' is present");

			testSteps.add("Step " + (++i) + " : Verifying 'Investment Amount' is editable");
			assertTrue(homePage.isInvestmentAmountEnabled(driver), "Verified 'Investment Amount' is editable");

			testSteps.add("Step " + (++i) + " : Verifying 'Preview Order' is clickable");
			assertTrue(homePage.isPreviewOrderButtonClickable(driver), "Verified 'Preview Order' is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Order'</b> button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Empty Investment Amount' error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Required",
					"'Empty Investment Amount' error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount': aaa");
			homePage.enterInvestmentAmountOnBuy("aaa", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount: -111'</b>");
			homePage.enterInvestmentAmountOnBuy("-111", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount: ###'</b>");
			homePage.enterInvestmentAmountOnBuy("###", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount: 9'</b>");
			homePage.enterInvestmentAmountOnBuy("9", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Less then 10 Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), errorMessage,
					"<b>'Less then 10 Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount :  -110'</b>");
			homePage.enterInvestmentAmountOnBuy("-110", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount : 50'</b>");
			homePage.enterInvestmentAmountOnBuy("50", driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Order'</b> button");
			homePage.clickOnPreviewOrderButton(driver);

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Place Buy Order'</b> button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass "
					+ "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(groups = "CashRequired")
	public void KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		HomePage homePage;
		driver = initConfiguration();
		String Vest = "";

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		printString("KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased: " + driver.hashCode() + "", driver);
		String errorMessage = null;
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("staging")) {
			errorMessage = "Please enter a value greater than or equal to $10.00.";
		} else {
			errorMessage = "Please enter a value greater than or equal to $10.";
		}
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-132?atlOrigin=eyJpIjoiZGNlYjkyZjE3NzBjNDljNTkwNmIwZjU3Yjk3OGIzYTEiLCJwIjoiaiJ9\">QAA-132 : [Web] Verify KYC-approved funded account user is able to purchase a Vests - Theme based Vests<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Login To App");

			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);

			Vest = homePage.getCardNameSwensenPortfolioButton(driver);
			testSteps.add("Step " + (++i) + " : Click on '" + Vest + "' button");
			homePage.clickOnSwensenPortfolioButton(driver);

			waitfor10sec();
			testSteps.add("Step " + (++i) + " : Click on <b>'Buy'</b> button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Name'</b> is present");
			assertTrue(homePage.isNameInBuyPresent(driver), "Verified <b>'Name'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Price'</b> is present");
			assertTrue(homePage.isPriceInBuyPresent(driver), "Verified <b>'Price'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Weight'</b> is present");
			assertTrue(homePage.isWeightInBuyPresent(driver), "Verified <b>'Weight'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'No. of Shares'</b> is present");
			assertTrue(homePage.isNoOfSharesInBuyPresent(driver), "Verified <b>'No. of Shares'</b> is present");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Investment Amount'</b> is editable");
			assertTrue(homePage.isInvestmentAmountEnabled(driver), "Verified <b>'Investment Amount'</b> is editable");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Preview Order'</b> is clickable");
			assertTrue(homePage.isPreviewOrderButtonClickable(driver), "Verified <b>'Preview Order'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Order'</b> button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Empty Investment Amount' error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Required",
					"'Empty Investment Amount' error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter 'Investment Amount': aaa");
			homePage.enterInvestmentAmountOnBuy("aaa", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount: -111'</b>");
			homePage.enterInvestmentAmountOnBuy("-111", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount: ###'</b>");
			homePage.enterInvestmentAmountOnBuy("###", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount: 9'</b>");
			homePage.enterInvestmentAmountOnBuy("9", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Less then 10 Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), errorMessage,
					"<b>'Less then 10 Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount :  -110'</b>");
			homePage.enterInvestmentAmountOnBuy("-110", driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'Invalid Investment Amount'</b> error message");
			assertEquals(homePage.getInvestmentAmountErrorMessage(driver), "Must be number.",
					"<b>'Invalid Investment Amount'</b> error message is not equal");

			testSteps.add("Step " + (++i) + " : Enter <b>'Investment Amount : 50'</b>");
			homePage.enterInvestmentAmountOnBuy("50", driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Order'</b> button");
			homePage.clickOnPreviewOrderButton(driver);
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Place Buy Order'</b> button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

}
