package com.investor.test;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.MonkeyPageObject;
import com.investor.pages.NavigationPage;

public class ETFsStocksAndOTCFlowVerification extends BaseClass {
	String tempSrc = "";

	@Test (groups = "CashRequired")
	public void ETFsFlowVerification() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("ETFsFlowVerification:" + driver.hashCode() + "", driver);
		int step = 0;
		double shareFractional = 1.001;
		int limitPriceValue = 100;
		DecimalFormat df = new DecimalFormat("#.##");
		double stopPriceValue;

		Object[][] dataArr = getData(testDataFile, recurringInvestmentFromVests, driver);
		String emptyAmountError = dataArr[rowIndex][1].toString();
		String amountToBeInvested = dataArr[rowIndex][3].toString();
		String frequencyToSelect = dataArr[rowIndex][4].toString();
		String successMessage = dataArr[rowIndex][5].toString();
		String defaultFormat = dataArr[rowIndex][6].toString();
		String confirmPageFormat = dataArr[rowIndex][7].toString();
		ArrayList<String> dateList = new ArrayList<String>();
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		String getVestedFee = "";
		String ETF = "Vanguard Short-Term Government Bond ETF";
		int share = 1;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-364?atlOrigin=eyJpIjoiMzIyYmFjYWI1NjJhNDg1MGE1OWZiZjQ5NjFjYWNhODEiLCJwIjoiaiJ9\">QAA-364.1 : [Web][Instrument][Buy]Verify and purchase the ETFs, Stocks, OTC<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Failed Dashboard is displayed");

			waitTime(2000, driver);

			testSteps.add("Step " + (++step) + " : Searching ETF : <b>" + ETF);
			instrumentPage.searchStock(driver, ETF);

			testSteps.add("Step " + (++step) + " : Verify '" + ETF + "' details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + ETF + "' details page load successfully");

			String stockName = instrumentPage.getInstrumentName(driver);

//			testSteps.add("Step " + (++step) + " : Click on <b>'MAX'</b>");
//			homePage.clickOnOverviewMax(driver);
//
//			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview Max Graph'</b> is present");
//			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview Max Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1Y'</b>");
			homePage.clickOnOverview1Y(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1Y Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'6M'</b>");
			homePage.clickOnOverview6M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 6M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'3M'</b>");
			homePage.clickOnOverview3M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 3M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1M'</b>");
			homePage.clickOnOverview1M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1W'</b>");
			homePage.clickOnOverview1W(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1W Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1W Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1D'</b>");
			homePage.clickOnOverview1D(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1D Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1D Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'Full Screen'</b>");
			homePage.clickOnFullScreen(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			printString("No of Tabs: " + tabs2.size());
			driver.switchTo().window(tabs2.get(1));
			getRefreshWebPage(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Full Screen Graph'</b> is present");
			assertTrue(homePage.isFullScreenGraphPresent(driver), "Failed <b>'Full Screen Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Full Screen Graph'</b> is present");

			tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			closeTab(1, driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview'</b> Tab is showing");
			assertTrue(instrumentPage.isOverviewTabIsDisplaying(driver), "Verified <b>'Overview'</b> Tab is showing");
			testSteps.add("Step " + (++step) + " : Verified: <b>'Overview'</b> Tab is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Overview'</b> Tab");
			instrumentPage.clickOnOverviewTab(driver);

//			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview'</b> Tab Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Overview'</b> Tab Details is showing");
//			testSteps.add("Step " + (++step) + " : Verified <b>'Overview'</b> Tab Details is showing");

			testSteps.add("Step " + (++step) + " : Verifying <b>'Returns Tab'</b> is showing");
			assertTrue(instrumentPage.isReturnTabIsDisplaying(driver), "Failed <b>'Returns Tab'</b> is showing");
			testSteps.add("Step " + (++step) + " : Verified <b>'Returns Tab'</b> is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Returns Tab'</b>");
			instrumentPage.clickOnReturnTab(driver);

//			testSteps.add("Step " + (++step) + " : Verifying <b>'Returns Tab'</b> Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Returns Tab Details'</b> is showing");
//			testSteps.add("Step " + (++step) + " : Verified <b>'Returns Tab'</b> Details is showing");

			testSteps.add("Step " + (++step) + " : Verifying <b>'Add to WatchList'</b> is showing");
			assertTrue(instrumentPage.isAddedToWatchListDisplaying(driver),
					"Failed <b>'Add to WatchList'</b> is showing");
			testSteps.add("Step " + (++step) + " : Verified <b>'Add to WatchList'</b> is showing");

			// Market Order Buy
			testSteps.add("<b>*************For Market Order*************</b>");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			double Share = 1.00;
			testSteps.add("Step " + (++step) + " : Enter Share Value: <b>" + Share);
			loginPage.enterBuyShareValue(Share, driver);

			instrumentPage.getBuyingPowerAmount(driver);

			testSteps.add("Step " + (++step) + " : Verifying the amount field is auto-populated");
			double ExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			double ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share;
			System.out.print(
					"Expected: " + String.valueOf(ExpectedVal) + "\n Actual: " + String.valueOf(ActualVal) + "\n");
			Assert.assertEquals(ActualVal, ExpectedVal);

			testSteps.add("Step " + (++step) + " : Verifying Estimate Amount field is auto pupolated");
			assertTrue(loginPage.isAmountFieldAutoPopulate(driver), "Verified Estimate Amount field is auto pupolated");
			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				instrumentPage.ClickOnPopUpGotItButton(driver);
				testSteps.add("Step " + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified Preview Order Page is displaying");

				testSteps.add("Step " + (++step) + " : Click on 'Place Buy Order' button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			} else {
				navigateToURL(DashboardUrl, driver);
			}

			// Limit Order Buy
			testSteps.add("<b>*************For Limit Order*************</b>");
			testSteps.add("Step " + (++step) + " : Searching ETF : <b>" + ETF);
			instrumentPage.searchStock(driver, ETF);

			testSteps.add("Step " + (++step) + " : Verify '" + ETF + "' details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + ETF + "' details page load successfully");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			testSteps.add("Step" + (++step) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++step) + " : Click on 'Limit Order Option' ");
			instrumentPage.clickOnLimitOrderOption(driver);

			testSteps.add("Step" + (++step) + " : Verify 'Limit Order Page' is displaying");
			assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

			testSteps.add("Step" + (++step) + " : Enter Share Fractional Value ' " + shareFractional + " '");
			loginPage.enterBuyShareValue(shareFractional, driver);

			testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
			loginPage.clickOnReviewOrderButton(driver);

			testSteps.add("Step" + (++step) + " : Verify fractional error message is displaying");
			assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
					"Verified fractional error message");

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + limitPriceValue + " '");
			instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++step) + " : Click on 'Place Buy Order' button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step" + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			}

			// Stop Order Buy
			testSteps.add("<b>*************For Stop Order*************</b>");
			testSteps.add("Step " + (++step) + " : Searching ETF : <b>" + ETF);
			instrumentPage.searchStock(driver, ETF);

			testSteps.add("Step " + (++step) + " : Verify '" + ETF + "' details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + ETF + "' details page load successfully");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			// Add
			testSteps.add("Step" + (++step) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++step) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step" + (++step) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
			stopPriceValue = stopPriceValue + 0.1;
			testSteps.add(
					"Step" + (++step) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++step) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}

				testSteps.add("Step" + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++step) + " : Click on Place Buy Order button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}
			}

			testSteps.add("Step" + (++step) + " : Verify User Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			// Create Recurring
			testSteps.add("<b>*************Create Recurring Investment*************</b>");
			testSteps.add("Step " + (++step) + " : Searching ETF : <b>" + ETF);
			instrumentPage.searchStock(driver, ETF);

			testSteps.add("Step " + (++step) + " : Verify '" + ETF + "' details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + ETF + "' details page load successfully");

			testSteps.add("Step " + (++step) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++step) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

			testSteps.add("Step " + (++step) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++step) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++step) + " : Enter <b>'Investment Amount'</b> less than 50");
			homePage.enterInvestmentAmount("49", driver);

			boolean isPremiumMember = homePage.isPremiumMemberDisplaying(driver);

			if (isPremiumMember) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++step) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add(
					"Step " + (++step) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++step) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++step)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			Double getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++step) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			Double investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++step) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			String getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++step) + " : Enter 'Investment Amount' : <b>'" + amountToBeInvested + "'</b>");
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++step) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++step)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

			testSteps.add("Step " + (++step) + " : Verify frequency <b>'" + frequencyToSelect
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			String formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++step) + " : Verify Investment Amount <b>'" + amountToBeInvested
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

			if (isPremiumMember) {
				testSteps.add("Step " + (++step) + " : Verify Vest Fee <b>'" + getVestedFee
						+ "'</b>  is displaying on confirm recurring investment page.");
				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++step) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add("Step " + (++step) + " : Verify success message <b>'" + successMessage
						+ "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++step) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");

			}
			AddTest_IntoReport("ETFsFlowVerification", testSteps, driver);
		} catch (Exception e) {
			
			testSteps.add("Failed: ETFsFlowVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ETFsFlowVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ETFsFlowVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: ETFsFlowVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ETFsFlowVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ETFsFlowVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void StocksFlowVerification() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("StocksFlowVerification:" + driver.hashCode() + "", driver);
		int step = 0;
		double shareFractional = 1.001;
		int limitPriceValue = 100;
		DecimalFormat df = new DecimalFormat("#.##");
		double stopPriceValue;
		int share = 1;

		Object[][] dataArr = getData(testDataFile, recurringInvestmentFromVests, driver);
		String emptyAmountError = dataArr[rowIndex][1].toString();
		String amountToBeInvested = dataArr[rowIndex][3].toString();
		String frequencyToSelect = dataArr[rowIndex][4].toString();
		String successMessage = dataArr[rowIndex][5].toString();
		String defaultFormat = dataArr[rowIndex][6].toString();
		String confirmPageFormat = dataArr[rowIndex][7].toString();
		ArrayList<String> dateList = new ArrayList<String>();
		String getVestedFee = "";
		String stock = "Yatra Online, Inc.";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-364?atlOrigin=eyJpIjoiMzIyYmFjYWI1NjJhNDg1MGE1OWZiZjQ5NjFjYWNhODEiLCJwIjoiaiJ9\">QAA-364.2 : [Web][Instrument][Buy]Verify and purchase the ETFs, Stocks, OTC<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Failed Dashboard is displayed");

			waitTime(2000, driver);

			testSteps.add("Step " + (++step) + " : Searching Stock : <b>" + stock);
			instrumentPage.searchStock(driver, stock);

			testSteps.add("Step " + (++step) + " : Verify '" + stock + "' stock details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + stock + "' stock details page load successfully");

			String stockName = instrumentPage.getInstrumentName(driver);

//			testSteps.add("Step " + (++step) + " : Click on <b>'MAX'</b>");
//			homePage.clickOnOverviewMax(driver);
//
//			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview Max Graph'</b> is present");
//			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview Max Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1Y'</b>");
			homePage.clickOnOverview1Y(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1Y Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'6M'</b>");
			homePage.clickOnOverview6M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 6M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'3M'</b>");
			homePage.clickOnOverview3M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 3M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1M'</b>");
			homePage.clickOnOverview1M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1W'</b>");
			homePage.clickOnOverview1W(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1W Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1W Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1D'</b>");
			homePage.clickOnOverview1D(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1D Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1D Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'Full Screen'</b>");
			homePage.clickOnFullScreen(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			printString("No of Tabs: " + tabs2.size());
			driver.switchTo().window(tabs2.get(1));
			getRefreshWebPage(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Full Screen Graph'</b> is present");
			assertTrue(homePage.isFullScreenGraphPresent(driver), "Failed <b>'Full Screen Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Full Screen Graph'</b> is present");

			tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			closeTab(1, driver);

			testSteps.add("Step " + (++step) + " : Verify <b>'Overview'</b> Tab is showing");
			assertTrue(instrumentPage.isOverviewTabIsDisplaying(driver), "Verified <b>'Overview'</b> Tab is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Overview'</b> Tab");
			instrumentPage.clickOnOverviewTab(driver);

//			testSteps.add("Step " + (++step) + " : Verify <b>'Overview'</b> Tab Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Overview'</b> Tab Details is showing");

			testSteps.add("Step " + (++step) + " : Verify <b>'Returns Tab'</b> is showing");
			assertTrue(instrumentPage.isReturnTabIsDisplaying(driver), "Failed <b>'Returns Tab'</b> is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Returns Tab'</b>");
			instrumentPage.clickOnReturnTab(driver);

//			testSteps.add("Step " + (++step) + " : Verify <b>'Returns Tab'</b> Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Overview Tab Details'</b> is showing");

			testSteps.add("Step " + (++step) + " : Verify <b>'Fundamental Data Tab</b> is showing");
			assertTrue(instrumentPage.isFundamentalDataTabIsDisplaying(driver),
					"Failed <b>'Fundamental Data Tab'</b> is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Fundamental Data Tab'</b>");
			instrumentPage.clickOnFundamentalDataTab(driver);

//			testSteps.add("Step " + (++step) + " : Verify <b>'Fundamental Data Tab Details'</b> is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Fundamental Data Tab Details'</b> is showing");

			testSteps.add("Step " + (++step) + " : Verify <b>'Key Ratio Tab'</b> is showing");
			assertTrue(instrumentPage.isKeyRatioTabIsDisplaying(driver), "Failed <b>'Key Ratio Tab'</b> is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Key Ratio Tab'</b>");
			instrumentPage.clickOnKeyRatioTab(driver);

//			testSteps.add("Step " + (++step) + " : Verify <b>'Key Ratio Tab Details'</b> is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Key Ratio Tab Details'</b> is showing");

			testSteps.add("Step " + (++step) + " : Verifying <b>'Add to WatchList'</b> is showing");
			assertTrue(instrumentPage.isAddedToWatchListDisplaying(driver),
					"Failed <b>'Add to WatchList'</b> is showing");
			testSteps.add("Step " + (++step) + " : Verified <b>'Add to WatchList'</b> is showing");

			testSteps.add("<b>*************For Market Order*************</b>");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			double Share = 1.00;
			testSteps.add("Step " + (++step) + " : Enter Share Value: <b>" + Share);
			loginPage.enterBuyShareValue(Share, driver);

			instrumentPage.getBuyingPowerAmount(driver);

			testSteps.add("Step " + (++step) + " : Verify the amount field is auto-populated");
			double ExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			double ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share;
			System.out.print(
					"Expected: " + String.valueOf(ExpectedVal) + "\n Actual: " + String.valueOf(ActualVal) + "\n");
			Assert.assertEquals(ActualVal, ExpectedVal);

			// ExtentListeners.attachScreenShot("Verify the amount field is
			// auto-populated");

			testSteps.add("Step " + (++step) + " : Verify Estimate Amount field is auto pupolated");
			assertTrue(loginPage.isAmountFieldAutoPopulate(driver), "Verified Estimate Amount field is auto pupolated");
			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				instrumentPage.ClickOnPopUpGotItButton(driver);
				testSteps.add("Step " + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified Preview Order Page is displaying");

				testSteps.add("Step " + (++step) + " : Click on 'Place Buy Order' button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			} else {
				navigateToURL(DashboardUrl, driver);
			}

			// Limit Order Buy
			testSteps.add("<b>*************For Limit Order*************</b>");
			testSteps.add("Step " + (++step) + " : Searching Stock : <b>" + stock);
			instrumentPage.searchStock(driver, stock);

			testSteps.add("Step " + (++step) + " : Verify '" + stock + "' stock details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + stock + "' stock details page load successfully");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			testSteps.add("Step" + (++step) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++step) + " : Click on 'Limit Order Option' ");
			instrumentPage.clickOnLimitOrderOption(driver);

			testSteps.add("Step" + (++step) + " : Verify 'Limit Order Page' is displaying");
			assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

			testSteps.add("Step" + (++step) + " : Enter Share Fractional Value ' " + shareFractional + " '");
			loginPage.enterBuyShareValue(shareFractional, driver);

			testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
			loginPage.clickOnReviewOrderButton(driver);

			testSteps.add("Step" + (++step) + " : Verify fractional error message is displaying");
			assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
					"Verified fractional error message");

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + limitPriceValue + " '");
			instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++step) + " : Click on 'Place Buy Order' button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step" + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			}

			// Stop Order Buy
			testSteps.add("<b>*************For Stop Order*************</b>");
			testSteps.add("Step " + (++step) + " : Searching Stock : <b>" + stock);
			instrumentPage.searchStock(driver, stock);

			testSteps.add("Step " + (++step) + " : Verify '" + stock + "' stock details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + stock + "' stock details page load successfully");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			// Add
			testSteps.add("Step" + (++step) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++step) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step" + (++step) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
			stopPriceValue = stopPriceValue + 0.1;
			testSteps.add(
					"Step" + (++step) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++step) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}

				testSteps.add("Step" + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++step) + " : Click on Place Buy Order button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}
			}

			testSteps.add("Step" + (++step) + " : Verify User Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			// Create Recurring
			testSteps.add("<b>*************Create Recurring Investment*************</b>");
			testSteps.add("Step " + (++step) + " : Searching Stock : <b>" + stock);
			instrumentPage.searchStock(driver, stock);

			testSteps.add("Step " + (++step) + " : Verify '" + stock + "' stock details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + stock + "' stock details page load successfully");

			testSteps.add("Step " + (++step) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++step) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

			testSteps.add("Step " + (++step) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++step) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++step) + " : Enter <b>'Investment Amount'</b> less than 50");
			homePage.enterInvestmentAmount("49", driver);

			boolean isPremiumMember = homePage.isPremiumMemberDisplaying(driver);

			if (isPremiumMember) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++step) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add(
					"Step " + (++step) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++step) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++step)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			Double getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++step) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			Double investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++step) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			String getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++step) + " : Enter 'Investment Amount' : <b>'" + amountToBeInvested + "'</b>");
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++step) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++step)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

			testSteps.add("Step " + (++step) + " : Verify frequency <b>'" + frequencyToSelect
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			String formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++step) + " : Verify Investment Amount <b>'" + amountToBeInvested
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

			if (isPremiumMember) {
				testSteps.add("Step " + (++step) + " : Verify Vest Fee <b>'" + getVestedFee
						+ "'</b>  is displaying on confirm recurring investment page.");
				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++step) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add("Step " + (++step) + " : Verify success message <b>'" + successMessage
						+ "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++step) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");

			}

			AddTest_IntoReport("StocksFlowVerification", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: StocksFlowVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("StocksFlowVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("StocksFlowVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: StocksFlowVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("StocksFlowVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("StocksFlowVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void OTCFlowVerification() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("OTCFlowVerification:" + driver.hashCode() + "", driver);
		int step = 0;
		double shareFractional = 1.001;
		int limitPriceValue = 100;
		DecimalFormat df = new DecimalFormat("#.##");
		double stopPriceValue;
		int share = 1;

		Object[][] dataArr = getData(testDataFile, recurringInvestmentFromVests, driver);
		String emptyAmountError = dataArr[rowIndex][1].toString();
		String amountToBeInvested = dataArr[rowIndex][3].toString();
		String frequencyToSelect = dataArr[rowIndex][4].toString();
		String successMessage = dataArr[rowIndex][5].toString();
		String defaultFormat = dataArr[rowIndex][6].toString();
		String confirmPageFormat = dataArr[rowIndex][7].toString();
		ArrayList<String> dateList = new ArrayList<String>();
		String getVestedFee = "";
		String OTC = "GBOOY";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-364?atlOrigin=eyJpIjoiMzIyYmFjYWI1NjJhNDg1MGE1OWZiZjQ5NjFjYWNhODEiLCJwIjoiaiJ9\">QAA-364.3 : [Web][Instrument][Buy]Verify and purchase the ETFs, Stocks, OTC<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++step) + " : Verifying Dashboard is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Failed Dashboard is displayed");
			testSteps.add("Step " + (++step) + " : Verified Dashboard is display");

			waitTime(2000, driver);

			testSteps.add("Step " + (++step) + " : Searching OTC : <b>" + OTC);
			instrumentPage.searchStock(driver, OTC);

			testSteps.add("Step " + (++step) + " : Verify '" + OTC + "' OTC details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + OTC + "' OTC details page load successfully");

			String stockName = instrumentPage.getInstrumentName(driver);

			testSteps.add("Step " + (++step) + " : Click on <b>'1D'</b>");
			homePage.clickOnOverview1D(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1D Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1D Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview 1D Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1Y'</b>");
			homePage.clickOnOverview1Y(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1Y Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1Y Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview 1Y Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'6M'</b>");
			homePage.clickOnOverview6M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 6M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 3M Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview 6M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'3M'</b>");
			homePage.clickOnOverview3M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 3M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 3M Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview 3M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1M'</b>");
			homePage.clickOnOverview1M(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1M Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1M Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview 1M Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'1W'</b>");
			homePage.clickOnOverview1W(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview 1W Graph'</b> is present");
			assertTrue(homePage.isOverviewGraphPresent(driver), "Failed <b>'Overview 1W Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview 1W Graph'</b> is present");

			testSteps.add("Step " + (++step) + " : Click on <b>'Full Screen'</b>");
			homePage.clickOnFullScreen(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			printString("No of Tabs: " + tabs2.size());
			driver.switchTo().window(tabs2.get(1));
			getRefreshWebPage(driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Full Screen Graph'</b> is present");
			assertTrue(homePage.isFullScreenGraphPresent(driver), "Failed <b>'Full Screen Graph'</b> is present");
			testSteps.add("Step " + (++step) + " : Verified <b>'Full Screen Graph'</b> is present");

			tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			closeTab(1, driver);

			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview'</b> Tab is showing");
			assertTrue(instrumentPage.isOverviewTabIsDisplaying(driver), "Verified <b>'Overview'</b> Tab is showing");
			testSteps.add("Step " + (++step) + " : Verified <b>'Overview'</b> Tab is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Overview'</b> Tab");
			instrumentPage.clickOnOverviewTab(driver);

//			testSteps.add("Step " + (++step) + " : Verifying <b>'Overview'</b> Tab Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Overview'</b> Tab Details is showing");
//			testSteps.add("Step " + (++step) + " : Verified <b>'Overview'</b> Tab Details is showing");

			testSteps.add("Step " + (++step) + " : Verifying <b>'Returns Tab'</b> is showing");
			assertTrue(instrumentPage.isReturnTabIsDisplaying(driver), "Failed <b>'Returns Tab'</b> is showing");
			testSteps.add("Step " + (++step) + " : Verified <b>'Returns Tab'</b> is showing");

			testSteps.add("Step " + (++step) + " : Click on <b>'Returns Tab'</b>");
			instrumentPage.clickOnReturnTab(driver);

//			testSteps.add("Step " + (++step) + " : Verifying <b>'Returns Tab'</b> Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Failed <b>'Overview Tab Details'</b> is showing");
//			testSteps.add("Step " + (++step) + " : Verified <b>'Returns Tab'</b> Details is showing");

			testSteps.add("Step " + (++step) + " : Verifying <b>'Add to WatchList'</b> is showing");
			assertTrue(instrumentPage.isAddedToWatchListDisplaying(driver),
					"Failed <b>'Add to WatchList'</b> is showing");
			testSteps.add("Step " + (++step) + " : Verified <b>'Add to WatchList'</b> is showing");

			testSteps.add("<b>*************For Market Order*************</b>");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			double Share = 1.00;
			testSteps.add("Step " + (++step) + " : Enter Share Value: <b>" + Share);
			loginPage.enterBuyShareValue(Share, driver);

			instrumentPage.getBuyingPowerAmount(driver);

			testSteps.add("Step " + (++step) + " : Verify the amount field is auto-populated");
			double ExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			double ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share;
			System.out.print(
					"Expected: " + String.valueOf(ExpectedVal) + "\n Actual: " + String.valueOf(ActualVal) + "\n");
			Assert.assertEquals(ActualVal, ExpectedVal);

			testSteps.add("Step " + (++step) + " : Verify Estimate Amount field is auto pupolated");
			assertTrue(loginPage.isAmountFieldAutoPopulate(driver), "Verified Estimate Amount field is auto pupolated");
			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				instrumentPage.ClickOnPopUpGotItButton(driver);
				testSteps.add("Step " + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified Preview Order Page is displaying");

				testSteps.add("Step " + (++step) + " : Click on 'Place Buy Order' button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			} else {
				navigateToURL(DashboardUrl, driver);
			}

			// Limit Order Buy
			testSteps.add("<b>*************For Limit Order*************</b>");
			testSteps.add("Step " + (++step) + " : Searching OTC : <b>" + OTC);
			instrumentPage.searchStock(driver, OTC);

			testSteps.add("Step " + (++step) + " : Verify '" + OTC + "' OTC details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + OTC + "' OTC details page load successfully");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			testSteps.add("Step" + (++step) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++step) + " : Click on 'Limit Order Option' ");
			instrumentPage.clickOnLimitOrderOption(driver);

			testSteps.add("Step" + (++step) + " : Verify 'Limit Order Page' is displaying");
			assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

			testSteps.add("Step" + (++step) + " : Enter Share Fractional Value ' " + shareFractional + " '");
			loginPage.enterBuyShareValue(shareFractional, driver);

			testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
			loginPage.clickOnReviewOrderButton(driver);

			testSteps.add("Step" + (++step) + " : Verify fractional error message is displaying");
			assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
					"Verified fractional error message");

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + limitPriceValue + " '");
			instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++step) + " : Click on 'Place Buy Order' button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step" + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			}

			// Stop Order Buy
			testSteps.add("<b>*************For Stop Order*************</b>");
			testSteps.add("Step " + (++step) + " : Searching OTC : <b>" + OTC);
			instrumentPage.searchStock(driver, OTC);

			testSteps.add("Step " + (++step) + " : Verify '" + OTC + "' OTC details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + OTC + "' OTC details page load successfully");
			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			// Add
			testSteps.add("Step" + (++step) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++step) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step" + (++step) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step" + (++step) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
			stopPriceValue = stopPriceValue + 0.1;
			testSteps.add(
					"Step" + (++step) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++step) + " : Click on 'Review Order' button");
				loginPage.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++step) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}

				testSteps.add("Step" + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(loginPage.isPreviewBUYOrderPageDisplaying(driver),
						"Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++step) + " : Click on Place Buy Order button");
				loginPage.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}
			}

			testSteps.add("Step" + (++step) + " : Verify User Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			// Create Recurring
			testSteps.add("<b>*************Create Recurring Investment*************</b>");
			testSteps.add("Step " + (++step) + " : Searching OTC : <b>" + OTC);
			instrumentPage.searchStock(driver, OTC);

			testSteps.add("Step " + (++step) + " : Verify '" + OTC + "' OTC details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Failed '" + OTC + "' OTC details page load successfully");

			testSteps.add("Step " + (++step) + " : Click on <b>'Create Recurring Investment'</b> button");
			homePage.clickOnCreateRecurringInvestmentButton(driver);

			try {
				testSteps.add("Step " + (++step) + " : Click on <b>'Start New Recurring Investment'</b> button");
				homePage.clickOnStartNewRecurrignInvestmentButton(driver);

			} catch (Exception e) {
			}

			testSteps.add("Step " + (++step) + " : Clear <b>'Investment Amount'</b> field");
			homePage.clearInvestmentAmount(driver);

//			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Recurring Investment'</b> button");
//			homePage.clickOnPreviewRecurringInvestmentButton(driver);
//
//			testSteps.add("Step " + (++step) + " : Verify error message <b>" + emptyAmountError + "</b>  is displaying");
//			assertEquals(homePage.getInvestmentAmountError(driver), emptyAmountError,
//					"Failed :error message <b>" + emptyAmountError + "</b> not matched");

			testSteps.add("Step " + (++step) + " : Enter <b>'Investment Amount'</b> less than 50");
			homePage.enterInvestmentAmount("49", driver);

			boolean isPremiumMember = homePage.isPremiumMemberDisplaying(driver);

			if (isPremiumMember) {
				getVestedFee = homePage.getVestFeePerPurchase(driver);
			}
			testSteps.add("Step " + (++step) + " : Click on <b>'FAQs'</b> button");
			homePage.clickOnFaqButton(driver);

			testSteps.add(
					"Step " + (++step) + " : Verify <b>'Frequently Asked Questions'</b> model popup is displaying");
			assertTrue(homePage.isFAQModelTitleDisplaying(driver),
					"Verified <b>'Frequently Asked Questions'</b> is dipslaying.");

			testSteps.add("Step " + (++step) + " : Click on <b>'FAQs'</b> Model close icon");
			homePage.clickOnFaqModelCloseIcon(driver);

			testSteps.add("Step " + (++step)
					+ " : Verify that <b>'date increases to three days upon entering investment amount greate than total buying power'</b>");
			Double getTotalBuyPower = homePage.getTotalBuyingPower(driver);
			testSteps.add("Step " + (++step) + " : 'Total Buying Power' : <b>'" + getTotalBuyPower + "'</b>");

			Double investmentAmountGreateThanBuyingPower = getTotalBuyPower + 10.0;
			testSteps.add("Step " + (++step) + " : Enter investment amount : " + investmentAmountGreateThanBuyingPower);
			homePage.enterInvestmentAmount(String.valueOf(investmentAmountGreateThanBuyingPower), driver);

			String getDateThreeDaysAheadOfCurrent = homePage.getDateThreeDaysAhead();
			dateList = getDateList(14, "d MMM, yyyy", "US/Eastern");
			assertTrue(dateList.contains(getDateThreeDaysAheadOfCurrent),
					"Failed : date <b>" + getDateThreeDaysAheadOfCurrent + "</b> not matched");

			testSteps.add("Step " + (++step) + " : Enter 'Investment Amount' : <b>'" + amountToBeInvested + "'</b>");
			homePage.enterInvestmentAmount(amountToBeInvested, driver);

			testSteps.add("Step " + (++step) + " : Selected Frequency : <b>'" + frequencyToSelect + "'</b>");
			homePage.selectFrequency(frequencyToSelect, driver);

			testSteps.add("Step " + (++step)
					+ " : Click on <b>'Investment Amount'</b> input to enable <b>'Preview Recurring Investment'</b> button");
			homePage.clickInvestmentAmount(driver);

			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Recurring Investment'</b> button");
			homePage.clickOnPreviewRecurringInvestmentButton(driver);

			testSteps.add("Step " + (++step) + " : Verify frequency <b>'" + frequencyToSelect
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageFrequency(driver), frequencyToSelect,
					"Failed : frequency <b>'" + frequencyToSelect + "'</b> not matched");

			String formattedDate = reformatDate(getDateThreeDaysAheadOfCurrent, defaultFormat, confirmPageFormat);

			testSteps.add("Step " + (++step) + " : Verify Investment Amount <b>'" + amountToBeInvested
					+ "'</b>  is displaying on confirm recurring investment page.");
			assertEquals(homePage.getConfirmPageInvestmentAmount(driver), amountToBeInvested,
					"Failed : Investment Amount <b>'" + amountToBeInvested + "'</b> not matched");

			if (isPremiumMember) {
				testSteps.add("Step " + (++step) + " : Verify Vest Fee <b>'" + getVestedFee
						+ "'</b>  is displaying on confirm recurring investment page.");
				assertEquals(homePage.getConfirmPageVestFee(driver), getVestedFee,
						"Failed : frequency <b>'" + getVestedFee + "'</b> not matched");
			}

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++step) + " : Click on <b>'Start Recurring Investment'</b> button");
				homePage.clickOnStartRecurringInvestmentButton(driver);

				testSteps.add("Step " + (++step) + " : Verify success message <b>'" + successMessage
						+ "'</b>  is displaying.");
				assertEquals(homePage.getSuccessMessage(driver), successMessage,
						"Failed : success message <b>'" + successMessage + "'</b> not matched");

				testSteps.add(
						"Step " + (++step) + " : Verify <b>'Recurring Investments Dashboard'</b> button is displaying");
				assertTrue(homePage.isRecurringInvestmentsDashboardButtonDisplaying(driver),
						"Verified <b>'Recurring Investments Dashboard'</b> button is dipslaying.");

			}

			AddTest_IntoReport("OTCFlowVerification", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: OTCFlowVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("OTCFlowVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("OTCFlowVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: OTCFlowVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("OTCFlowVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("OTCFlowVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DetailStocksPageVerification_Login_WithoutLogin() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		driver = initConfiguration();
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("DetailStocksPageVerification_Login_WithoutLogin:" + driver.hashCode() + "", driver);
		int step = 0;
		String URL = null;
		String stockMarketCap = null;
		String stockName = null;
		String stockRatio = null;
		String stockVolume = null;
		String stockAVGVolume = null;
		String stockBeta = null;
		String stockCurrentPrice = null;
		String stockChangeInPercentage = null;
		String stockMarketCap_incongnito = null;
		String stockName_incongnito = null;
		String stockRatio_incongnito = null;
		String stockVolume_incongnito = null;
		String stockAVGVolume_incongnito = null;
		String stockBeta_incongnito = null;
		String stockCurrentPrice_incongnito = null;
		String stockChangeInPercentage_incongnito = null;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-450?atlOrigin=eyJpIjoiY2U2YWJjMjY5ZDg1NGFmYTk3NjY5MGJmOTAxZWRmMDAiLCJwIjoiaiJ9\">QAA-450 : [Web] - Verify instrument detail page with and without logging in<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Failed Dashboard is displayed");

			testSteps.add("Step " + (++step) + " : Clicking On First Stock Of Top Movers");
			instrumentPage.clickingOnFirstStockOfTopMovers(driver);

			URL = getPageUrl(driver);
			testSteps.add("Step " + (++step) + " : Current Page Url: <b>" + URL);

			stockName = instrumentPage.getInstrumentName(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>Instrument Page Stock Name : <b>" + stockName
						+ "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Instrument Page Stock Name : <b>" + stockName);
			}

			stockChangeInPercentage = instrumentPage.getInstrumentCurrentValueChangeInPercentage(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " :<font color=red> Daily Change In Percentage Of '" + stockName
						+ "': <b>" + stockChangeInPercentage + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Daily Change In Percentage Of '" + stockName + "': <b>"
						+ stockChangeInPercentage);
			}

			stockMarketCap = instrumentPage.getInstrumentMarketCap(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> MarketCap Of '" + stockName + "': <b>"
						+ stockMarketCap + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " : MarketCap Of '" + stockName + "': <b>" + stockMarketCap);
			}

			stockRatio = instrumentPage.getInstrumentRatio(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> P/E Ratio Of '" + stockName + "': <b>"
						+ stockRatio + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " : P/E Ratio Of '" + stockName + "': <b>" + stockRatio);
			}

			stockVolume = instrumentPage.getInstrumentVolume(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> Volume Of '" + stockName + "': <b>"
						+ stockVolume + "</font");
			} else {
				testSteps.add("Step " + (++step) + " : Volume Of '" + stockName + "': <b>" + stockVolume);
			}

			stockAVGVolume = instrumentPage.getInstrumentAVGVolume(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> Average Volume Of '" + stockName + "': <b>"
						+ stockAVGVolume + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Average Volume Of '" + stockName + "': <b>" + stockAVGVolume);
			}

			stockBeta = instrumentPage.getInstrumentBeta(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>Beta Of '" + stockName + "': <b>" + stockBeta
						+ "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Beta Of '" + stockName + "': <b>" + stockBeta);
			}

			stockCurrentPrice = instrumentPage.getInstrumentCurrentPrice(driver);
			if (stockName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>CurrentPrice Of '" + stockName + "': <b>"
						+ stockCurrentPrice + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :CurrentPrice Of '" + stockName + "': <b>" + stockCurrentPrice);
			}

			testSteps.add("<b>***********Logging Out User***********</b>");
			waitTime(5000, driver);
			testSteps.add("Step " + (++step) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++step) + " : click 'LogOut' button");
			monkey.clickOnProfileLogOutButton(driver);

			testSteps.add("Step " + (++step) + " : Verify User is Logout Successfully");
			assertTrue(monkey.isProfileLogOutWelcomeBackPageDisplaying(driver), "User is not Logout Successfully");
			testSteps.add("Step " + (++step) + " : Verified:  User is Logout Successfully");

			testSteps.add("Step " + (++step) + " :Navigate to Instrument Url: <b>" + URL);
			navigateToURL(URL, driver);

			stockName_incongnito = instrumentPage.getInstrumentName(driver);
			testSteps.add(
					"Step " + (++step) + " :Instrument Page Stock Name As Non loggedIn : <b>" + stockName_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock Name");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockName, stockName_incongnito,
					"Instrument Stock Name"));

			stockChangeInPercentage_incongnito = instrumentPage.getInstrumentCurrentValueChangeInPercentage(driver);
			testSteps.add("Step " + (++step) + " :Daily Change In Percentage Of '" + stockName
					+ "' As Non loggedIn: <b>" + stockChangeInPercentage_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock Percentage Change");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockChangeInPercentage,
					stockChangeInPercentage_incongnito, "Instrument Stock Percentage Change"));

			stockMarketCap_incongnito = instrumentPage.getInstrumentMarketCap(driver);
			testSteps.add("Step " + (++step) + " : MarketCap Of '" + stockName + "' As Non loggedIn: <b>"
					+ stockMarketCap_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock MarketCap");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockMarketCap,
					stockMarketCap_incongnito, "Instrument Stock MarketCap"));

			stockRatio_incongnito = instrumentPage.getInstrumentRatio(driver);
			testSteps.add("Step " + (++step) + " : P/E Ratio Of '" + stockName + "'As Non loggedIn: <b>"
					+ stockRatio_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock P/E Ratio");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockRatio, stockRatio_incongnito,
					"Instrument Stock P/E Ratio"));

			stockVolume_incongnito = instrumentPage.getInstrumentVolume(driver);
			testSteps.add("Step " + (++step) + " : Volume Of '" + stockName + "' As Non loggedIn: <b>"
					+ stockVolume_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock Volume");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockVolume, stockVolume_incongnito,
					"Instrument Stock Volume"));

			stockAVGVolume_incongnito = instrumentPage.getInstrumentAVGVolume(driver);
			testSteps.add("Step " + (++step) + " :Average Volume Of '" + stockName + "' As Non loggedIn: <b>"
					+ stockAVGVolume_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock Average Volume");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockAVGVolume,
					stockAVGVolume_incongnito, "Instrument Stock Average Volume"));

			stockBeta_incongnito = instrumentPage.getInstrumentBeta(driver);
			testSteps.add(
					"Step " + (++step) + " :Beta Of '" + stockName + "' As Non loggedIn: <b>" + stockBeta_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock Beta");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockBeta, stockBeta_incongnito,
					"Instrument Stock Beta"));

			stockCurrentPrice_incongnito = instrumentPage.getInstrumentCurrentPrice(driver);
			testSteps.add("Step " + (++step) + " :CurrentPrice Of '" + stockName + "'As Non loggedIn: <b>"
					+ stockCurrentPrice_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Stock CurrentPrice");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, stockCurrentPrice,
					stockCurrentPrice_incongnito, "Instrument Stock CurrentPrice"));

			testSteps.add("Step " + (++step) + " : Close the Browser");
			AddTest_IntoReport("DetailStocksPageVerification_Login_WithoutLogin", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DetailStocksPageVerification_Login_WithoutLogin " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("DetailStocksPageVerification_Login_WithoutLogin") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DetailStocksPageVerification_Login_WithoutLogin", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DetailStocksPageVerification_Login_WithoutLogin " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("DetailStocksPageVerification_Login_WithoutLogin") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DetailStocksPageVerification_Login_WithoutLogin", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DetailETFPageVerification_Login_WithoutLogin() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		driver = initConfiguration();
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("DetailETFPageVerification_Login_WithoutLogin:" + driver.hashCode() + "", driver);
		int step = 0;
		String URL = null;
		String etfMarketCap = null;
		String etfName = null;
		String etfRatio = null;
		String etfVolume = null;
		String etfAVGVolume = null;
		String etfBeta = null;
		String etfCurrentPrice = null;
		String etfChangeInPercentage = null;
		String etfMarketCap_incongnito = null;
		String etfName_incongnito = null;
		String etfRatio_incongnito = null;
		String etfVolume_incongnito = null;
		String etfAVGVolume_incongnito = null;
		String etfBeta_incongnito = null;
		String etfCurrentPrice_incongnito = null;
		String etfChangeInPercentage_incongnito = null;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-455?atlOrigin=eyJpIjoiNjgwZTI2MDY2YzRiNDEyNDg2YzQ1Njg4NDM5NDk0MmIiLCJwIjoiaiJ9\">QAA-455.1 : [Web] - Verify ETF instrument detail page with and without logging in<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Failed Dashboard is displayed");

			testSteps.add("Step " + (++step) + " : Clicking On First Instrument Of ETF");
			instrumentPage.clickingOnFirstStockOfETF(driver);

			instrumentPage.clickOnFirstInstrument(driver);
			testSteps.add("Clicking On First Instrument from list");

			URL = getPageUrl(driver);
			testSteps.add("Step " + (++step) + " : Current Page Url: <b>" + URL);

			etfName = instrumentPage.getInstrumentName(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add(
						"Step " + (++step) + " : <font color=red>Instrument Page ETF Name : <b>" + etfName + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Instrument Page ETF Name : <b>" + etfName);
			}

			etfChangeInPercentage = instrumentPage.getInstrumentCurrentValueChangeInPercentage(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " :<font color=red> Daily Change In Percentage Of '" + etfName
						+ "': <b>" + etfChangeInPercentage + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Daily Change In Percentage Of '" + etfName + "': <b>"
						+ etfChangeInPercentage);
			}

			etfMarketCap = instrumentPage.getInstrumentMarketCap(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> MarketCap Of '" + etfName + "': <b>"
						+ etfMarketCap + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " : MarketCap Of '" + etfName + "': <b>" + etfMarketCap);
			}

			etfRatio = instrumentPage.getInstrumentRatio(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> P/E Ratio Of '" + etfName + "': <b>" + etfRatio
						+ "</font>");
			} else {
				testSteps.add("Step " + (++step) + " : P/E Ratio Of '" + etfName + "': <b>" + etfRatio);
			}

			etfVolume = instrumentPage.getInstrumentVolume(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> Volume Of '" + etfName + "': <b>" + etfVolume
						+ "</font");
			} else {
				testSteps.add("Step " + (++step) + " : Volume Of '" + etfName + "': <b>" + etfVolume);
			}

			etfAVGVolume = instrumentPage.getInstrumentAVGVolume(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> Average Volume Of '" + etfName + "': <b>"
						+ etfAVGVolume + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Average Volume Of '" + etfName + "': <b>" + etfAVGVolume);
			}

			etfBeta = instrumentPage.getInstrumentBeta(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add(
						"Step " + (++step) + " : <font color=red>Beta Of '" + etfName + "': <b>" + etfBeta + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Beta Of '" + etfName + "': <b>" + etfBeta);
			}

			etfCurrentPrice = instrumentPage.getInstrumentCurrentPrice(driver);
			if (etfName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>CurrentPrice Of '" + etfName + "': <b>"
						+ etfCurrentPrice + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :CurrentPrice Of '" + etfName + "': <b>" + etfCurrentPrice);
			}

			testSteps.add("<b>***********Logging Out User***********</b>");
			waitTime(5000, driver);
			testSteps.add("Step " + (++step) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++step) + " : click 'LogOut' button");
			monkey.clickOnProfileLogOutButton(driver);

			testSteps.add("Step " + (++step) + " : Verify User is Logout Successfully");
			assertTrue(monkey.isProfileLogOutWelcomeBackPageDisplaying(driver), "User is not Logout Successfully");
			testSteps.add("Step " + (++step) + " : Verified:  User is Logout Successfully");

			testSteps.add("Step " + (++step) + " :Navigate to Instrument Url: <b>" + URL);
			navigateToURL(URL, driver);

			etfName_incongnito = instrumentPage.getInstrumentName(driver);
			testSteps.add("Step " + (++step) + " :Instrument Page ETF Name As Non loggedIn : <b>" + etfName_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF Name");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfName, etfName_incongnito,
					"Instrument ETF Name"));

			etfChangeInPercentage_incongnito = instrumentPage.getInstrumentCurrentValueChangeInPercentage(driver);
			testSteps.add("Step " + (++step) + " :Daily Change In Percentage Of '" + etfName + "' As Non loggedIn: <b>"
					+ etfChangeInPercentage_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF Percentage Change");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfChangeInPercentage,
					etfChangeInPercentage_incongnito, "Instrument ETF Percentage Change"));

			etfMarketCap_incongnito = instrumentPage.getInstrumentMarketCap(driver);
			testSteps.add("Step " + (++step) + " : MarketCap Of '" + etfName + "' As Non loggedIn: <b>"
					+ etfMarketCap_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF MarketCap");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfMarketCap, etfMarketCap_incongnito,
					"Instrument ETF MarketCap"));

			etfRatio_incongnito = instrumentPage.getInstrumentRatio(driver);
			testSteps.add(
					"Step " + (++step) + " : P/E Ratio Of '" + etfName + "'As Non loggedIn: <b>" + etfRatio_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF P/E Ratio");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfRatio, etfRatio_incongnito,
					"Instrument ETF P/E Ratio"));

			etfVolume_incongnito = instrumentPage.getInstrumentVolume(driver);
			testSteps.add(
					"Step " + (++step) + " : Volume Of '" + etfName + "' As Non loggedIn: <b>" + etfVolume_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF Volume");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfVolume, etfVolume_incongnito,
					"Instrument ETF Volume"));

			etfAVGVolume_incongnito = instrumentPage.getInstrumentAVGVolume(driver);
			testSteps.add("Step " + (++step) + " :Average Volume Of '" + etfName + "' As Non loggedIn: <b>"
					+ etfAVGVolume_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF Average Volume");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfAVGVolume, etfAVGVolume_incongnito,
					"Instrument ETF Average Volume"));

			etfBeta_incongnito = instrumentPage.getInstrumentBeta(driver);
			testSteps.add("Step " + (++step) + " :Beta Of '" + etfName + "' As Non loggedIn: <b>" + etfBeta_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF Beta");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfBeta, etfBeta_incongnito,
					"Instrument ETF Beta"));

			etfCurrentPrice_incongnito = instrumentPage.getInstrumentCurrentPrice(driver);
			testSteps.add("Step " + (++step) + " :CurrentPrice Of '" + etfName + "'As Non loggedIn: <b>"
					+ etfCurrentPrice_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument ETF CurrentPrice");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, etfCurrentPrice,
					etfCurrentPrice_incongnito, "Instrument ETF CurrentPrice"));

			testSteps.add("Step " + (++step) + " : Close the Browser");
			AddTest_IntoReport("DetailETFPageVerification_Login_WithoutLogin", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DetailETFPageVerification_Login_WithoutLogin " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("DetailETFPageVerification_Login_WithoutLogin") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DetailETFPageVerification_Login_WithoutLogin", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: DetailETFPageVerification_Login_WithoutLogin " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("DetailETFPageVerification_Login_WithoutLogin") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DetailETFPageVerification_Login_WithoutLogin", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DetailCryptoPageVerification_Login_WithoutLogin() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		driver = initConfiguration();
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("DetailCryptoPageVerification_Login_WithoutLogin:" + driver.hashCode() + "", driver);
		int step = 0;
		String URL = null;
		String cryptoMarketCap = null;
		String cryptoName = null;
		String cryptoRatio = null;
		String cryptoVolume = null;
		String cryptoAVGVolume = null;
		String cryptoBeta = null;
		String cryptoCurrentPrice = null;
		String cryptoChangeInPercentage = null;
		String cryptoMarketCap_incongnito = null;
		String cryptoName_incongnito = null;
		String cryptoRatio_incongnito = null;
		String cryptoVolume_incongnito = null;
		String cryptoAVGVolume_incongnito = null;
		String cryptoBeta_incongnito = null;
		String cryptoCurrentPrice_incongnito = null;
		String cryptoChangeInPercentage_incongnito = null;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-455?atlOrigin=eyJpIjoiNjgwZTI2MDY2YzRiNDEyNDg2YzQ1Njg4NDM5NDk0MmIiLCJwIjoiaiJ9\">QAA-455.2 : [Web] - Verify Crypto instrument detail page with and without logging in<a/>");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Failed Dashboard is displayed");

			testSteps.add("Step " + (++step) + " : Clicking On Crypto");
			instrumentPage.clickingOnFirstStockOfCrypto(driver);

			instrumentPage.clickOnFirstInstrument(driver);
			testSteps.add("Clicking On First Instrument from list");

			URL = getPageUrl(driver);
			testSteps.add("Step " + (++step) + " : Current Page Url: <b>" + URL);

			cryptoName = instrumentPage.getInstrumentName(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>Instrument Page Crypto Name : <b>" + cryptoName
						+ "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Instrument Page Crypto Name : <b>" + cryptoName);
			}

			cryptoChangeInPercentage = instrumentPage.getInstrumentCurrentValueChangeInPercentage(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " :<font color=red> Daily Change In Percentage Of '" + cryptoName
						+ "': <b>" + cryptoChangeInPercentage + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Daily Change In Percentage Of '" + cryptoName + "': <b>"
						+ cryptoChangeInPercentage);
			}

			cryptoMarketCap = instrumentPage.getInstrumentMarketCap(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> MarketCap Of '" + cryptoName + "': <b>"
						+ cryptoMarketCap + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " : MarketCap Of '" + cryptoName + "': <b>" + cryptoMarketCap);
			}

			cryptoRatio = instrumentPage.getInstrumentRatio(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> P/E Ratio Of '" + cryptoName + "': <b>"
						+ cryptoRatio + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " : P/E Ratio Of '" + cryptoName + "': <b>" + cryptoRatio);
			}

			cryptoVolume = instrumentPage.getInstrumentVolume(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> Volume Of '" + cryptoName + "': <b>"
						+ cryptoVolume + "</font");
			} else {
				testSteps.add("Step " + (++step) + " : Volume Of '" + cryptoName + "': <b>" + cryptoVolume);
			}

			cryptoAVGVolume = instrumentPage.getInstrumentAVGVolume(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red> Average Volume Of '" + cryptoName + "': <b>"
						+ cryptoAVGVolume + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Average Volume Of '" + cryptoName + "': <b>" + cryptoAVGVolume);
			}

			cryptoBeta = instrumentPage.getInstrumentBeta(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>Beta Of '" + cryptoName + "': <b>" + cryptoBeta
						+ "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :Beta Of '" + cryptoName + "': <b>" + cryptoBeta);
			}

			cryptoCurrentPrice = instrumentPage.getInstrumentCurrentPrice(driver);
			if (cryptoName.toLowerCase().contains("not visible")) {
				testSteps.add("Step " + (++step) + " : <font color=red>CurrentPrice Of '" + cryptoName + "': <b>"
						+ cryptoCurrentPrice + "</font>");
			} else {
				testSteps.add("Step " + (++step) + " :CurrentPrice Of '" + cryptoName + "': <b>" + cryptoCurrentPrice);
			}

			testSteps.add("<b>***********Logging Out User***********</b>");
			waitTime(5000, driver);
			testSteps.add("Step " + (++step) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++step) + " : click 'LogOut' button");
			monkey.clickOnProfileLogOutButton(driver);

			testSteps.add("Step " + (++step) + " : Verify User is Logout Successfully");
			assertTrue(monkey.isProfileLogOutWelcomeBackPageDisplaying(driver), "User is not Logout Successfully");
			testSteps.add("Step " + (++step) + " : Verified:  User is Logout Successfully");

			testSteps.add("Step " + (++step) + " :Navigate to Instrument Url: <b>" + URL);
			navigateToURL(URL, driver);

			cryptoName_incongnito = instrumentPage.getInstrumentName(driver);
			testSteps.add(
					"Step " + (++step) + " :Instrument Page Crypto Name As Non loggedIn : <b>" + cryptoName_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto Name");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoName, cryptoName_incongnito,
					"Instrument Crypto Name"));

			cryptoChangeInPercentage_incongnito = instrumentPage.getInstrumentCurrentValueChangeInPercentage(driver);
			testSteps.add("Step " + (++step) + " :Daily Change In Percentage Of '" + cryptoName
					+ "' As Non loggedIn: <b>" + cryptoChangeInPercentage_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto Percentage Change");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoChangeInPercentage,
					cryptoChangeInPercentage_incongnito, "Instrument Crypto Percentage Change"));

			cryptoMarketCap_incongnito = instrumentPage.getInstrumentMarketCap(driver);
			testSteps.add("Step " + (++step) + " : MarketCap Of '" + cryptoName + "' As Non loggedIn: <b>"
					+ cryptoMarketCap_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto MarketCap");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoMarketCap,
					cryptoMarketCap_incongnito, "Instrument Crypto MarketCap"));

			cryptoRatio_incongnito = instrumentPage.getInstrumentRatio(driver);
			testSteps.add("Step " + (++step) + " : P/E Ratio Of '" + cryptoName + "'As Non loggedIn: <b>"
					+ cryptoRatio_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto P/E Ratio");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoRatio, cryptoRatio_incongnito,
					"Instrument Crypto P/E Ratio"));

			cryptoVolume_incongnito = instrumentPage.getInstrumentVolume(driver);
			testSteps.add("Step " + (++step) + " : Volume Of '" + cryptoName + "' As Non loggedIn: <b>"
					+ cryptoVolume_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto Volume");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoVolume, cryptoVolume_incongnito,
					"Instrument Crypto Volume"));

			cryptoAVGVolume_incongnito = instrumentPage.getInstrumentAVGVolume(driver);
			testSteps.add("Step " + (++step) + " :Average Volume Of '" + cryptoName + "' As Non loggedIn: <b>"
					+ cryptoAVGVolume_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto Average Volume");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoAVGVolume,
					cryptoAVGVolume_incongnito, "Instrument Crypto Average Volume"));

			cryptoBeta_incongnito = instrumentPage.getInstrumentBeta(driver);
			testSteps.add(
					"Step " + (++step) + " :Beta Of '" + cryptoName + "' As Non loggedIn: <b>" + cryptoBeta_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto Beta");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoBeta, cryptoBeta_incongnito,
					"Instrument Crypto Beta"));

			cryptoCurrentPrice_incongnito = instrumentPage.getInstrumentCurrentPrice(driver);
			testSteps.add("Step " + (++step) + " :CurrentPrice Of '" + cryptoName + "'As Non loggedIn: <b>"
					+ cryptoCurrentPrice_incongnito);
			testSteps.add("Step " + (++step) + " :Verifying Instrument Crypto CurrentPrice");
			testSteps.addAll(instrumentPage.verifyInstrumentStockValues(driver, cryptoCurrentPrice,
					cryptoCurrentPrice_incongnito, "Instrument Crypto CurrentPrice"));

			testSteps.add("Step " + (++step) + " : Close the Browser");

			AddTest_IntoReport("DetailCryptoPageVerification_Login_WithoutLogin", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DetailCryptoPageVerification_Login_WithoutLogin " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("DetailCryptoPageVerification_Login_WithoutLogin") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DetailCryptoPageVerification_Login_WithoutLogin", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DetailCryptoPageVerification_Login_WithoutLogin " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("DetailCryptoPageVerification_Login_WithoutLogin") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DetailCryptoPageVerification_Login_WithoutLogin", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
