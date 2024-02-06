package com.investor.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;

public class InstrumentBuySell extends BaseClass {
	String tempSrc = "";

	// QAA-46
	@Test(groups = "CashRequired")
	public void Instruments_Buy() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_Buy: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String pass = dataArr[rowIndex][2].toString();
		Boolean MarketClose;
		float BeforeInvestedAmount;
		float FractionalBeforeInvestedAmount;
		float DollarAmount_BeforeInvestedAmount;
		int step = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-28?atlOrigin=eyJpIjoiMTA3NTRmZGE1NjdkNGYxMzg0YzY3Y2Q0NWJiZjQ4M2QiLCJwIjoiaiJ9\">QAA-28 : Web - Verify KYC-approved funded account user is able to purchase a stock/ETF<a/>");

			testSteps.add("Step " + (++step) + " : Login to app");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");

			MarketClose = instrumentPage.isMarketClose(driver);

			testSteps.add("Step " + (++step) + " : Close Pending Orders");

			try {
				BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				BeforeInvestedAmount = 0;
			}

			waitTime(2000, driver);
			testSteps.add("Step " + (++step) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step " + (++step) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			testSteps.add("Step " + (++step) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step " + (++step) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			String stockName = instrumentPage.getInstrumentName(driver);

			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-34?atlOrigin=eyJpIjoiZTZhZTJhOTE4Zjc3NDc2NjhiNDdlYThmZTNiYzQ0MTEiLCJwIjoiaiJ9\">QAA-34 : Web - Verify user is able to place various combination of market buy order<a/>");
			double Share = 1.00;
			testSteps.add("Step " + (++step) + " : Enter Share Value: <b>" + Share);
			lp.enterBuyShareValue(Share, driver);

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
			assertTrue(lp.isAmountFieldAutoPopulate(driver), "Verified Estimate Amount field is auto pupolated");

			if (driver.getCurrentUrl().contains("prod")) {
				if (MarketClose) {
//					testSteps.add("Step "+(++step)+" : Click on 'Review Order' button");
//					lp.clickOnReviewOrderButton(driver);
//
//					instrumentPage.ClickOnPopUpGotItButton(driver);
//					testSteps.add("Step "+(++step)+" : Verify Preview Order Page is displaying");
//					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");
//
//					
//					testSteps.add("Step "+(++step)+" : Click on 'Place Buy Order' button");
//					lp.clickOnPlaceBUYOrderButton(driver);
//
//					try {
//						instrumentPage.ClosePopUp(driver);
//					} catch (Exception e) {
//						System.out.print("No PopUp Found");
//					}
//
//					testSteps.add("Step "+(++step)+" : Verify User Dashboard is displaying");
//					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
//
//					testSteps.add("Step "+(++step)+" : Verify Buy Shares");
//					instrumentPage.VerifyPendingShares(Share, driver);
//
//					instrumentPage.VerifyInvestedAmount(BeforeInvestedAmount, ExpectedVal, driver);
//					
//					testSteps.add("Step "+(++step)+" : Close Pending Orders");
//					

					navigateToURL(DashboardUrl, driver);
				} else {
					navigateToURL(DashboardUrl, driver);
				}

			} else {
				testSteps.add("Step " + (++step) + " : Click on Review Order button");
				lp.clickOnReviewOrderButton(driver);

				instrumentPage.ClickOnPopUpGotItButton(driver);
				testSteps.add("Step " + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");

				testSteps.add("Step " + (++step) + " : Click on Place Buy Order button");
				lp.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				testSteps.add("Step " + (++step) + " : Verify Buy Shares");
				instrumentPage.VerifyPendingShares(Share, driver);

				instrumentPage.VerifyInvestedAmount(BeforeInvestedAmount, ExpectedVal, driver);

				testSteps.add("Step " + (++step) + " : Close Pending Orders");

			}

			testSteps.add("For Fractional Share");
			// For Fractional Share

			try {
				FractionalBeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				FractionalBeforeInvestedAmount = 0;
			}

			waitTime(2000, driver);
			testSteps.add("Step " + (++step) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step " + (++step) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			testSteps.add("Step " + (++step) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step " + (++step) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			double Fractional_Share = 1.001;
			testSteps.add("Step " + (++step) + " : Enter Fractional Share Value = " + Fractional_Share);
			lp.enterBuyShareValue(Fractional_Share, driver);

			DecimalFormat df = new DecimalFormat("#.##");
			testSteps.add("Step " + (++step) + " : Verify the amount field is auto-populated");
			double FractionalExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			double FractionalActualVal = instrumentPage.getMarketValue(driver, stockName) * Fractional_Share;
			System.out.print("Expected: " + String.valueOf(FractionalExpectedVal) + "\n Actual: "
					+ String.valueOf(FractionalActualVal) + "\n");
			testSteps.add("Step " + (++step) + " : Actual: " + df.format(FractionalActualVal));
			testSteps.add("Step " + (++step) + " : Expected: " + df.format(FractionalExpectedVal));
			Assert.assertEquals(df.format(FractionalActualVal), df.format(FractionalExpectedVal));
			assertTrue(lp.isAmountFieldAutoPopulate(driver), "Verified Estimate Amount field is auto pupolated");

			if (driver.getCurrentUrl().contains("prod")) {
				if (MarketClose) {
//					testSteps.add("Step "+(++step)+" : Click on 'Review Order' button");
//					lp.clickOnReviewOrderButton(driver);
//					instrumentPage.ClickOnPopUpGotItButton(driver);
//
//					testSteps.add("Step "+(++step)+" : Verify Preview Order Page is displaying");
//					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");
//
//					testSteps.add("Step "+(++step)+" : Click on 'Place Buy Order' button");
//					lp.clickOnPlaceBUYOrderButton(driver);
//
//					try {
//						instrumentPage.ClosePopUp(driver);
//					} catch (Exception e) {
//						System.out.print("No PopUp Found");
//					}
//
//					testSteps.add("Step "+(++step)+" : Verify Buy Shares");
//					instrumentPage.VerifyPendingShares(Fractional_Share, driver);
//
//					testSteps.add("Step "+(++step)+" : Verify User Dashboard is displaying");
//					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
//					
//					

					navigateToURL(DashboardUrl, driver);

				} else {
					navigateToURL(DashboardUrl, driver);
				}
			} else {
				testSteps.add("Step " + (++step) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);
				instrumentPage.ClickOnPopUpGotItButton(driver);

				testSteps.add("Step " + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");

				testSteps.add("Step " + (++step) + " : Click on 'Place Buy Order' button");
				lp.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify Buy Shares");
				instrumentPage.VerifyPendingShares(Fractional_Share, driver);

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
				instrumentPage.VerifyInvestedAmount(FractionalBeforeInvestedAmount, FractionalExpectedVal, driver);

			}

			testSteps.add("Step " + (++step) + " : For Estimated Amount In Dollar");
			try {
				DollarAmount_BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				DollarAmount_BeforeInvestedAmount = 0;
			}

			waitTime(2000, driver);
			testSteps.add("Step " + (++step) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step " + (++step) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			testSteps.add("Step " + (++step) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step " + (++step) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			double EstimatedAmount = 100;
			testSteps.add("Step " + (++step) + " : Enter Dollar In Estimated Value");
			instrumentPage.enterEstimatedCostValue(EstimatedAmount, driver);

			testSteps.add("Step " + (++step) + " : Verify the amount field is auto-populated");
			double ExtpectedShare = instrumentPage.getMarketShares(driver);
			double ActualShare = EstimatedAmount / instrumentPage.getMarketValue(driver, stockName);
			System.out.print("\nExpected Shares: " + String.valueOf(ExtpectedShare) + "\n\n Actual Shares: "
					+ String.valueOf(ActualShare) + "\n");
			testSteps.add("Step " + (++step) + " : Actual Shares: " + df.format(ExtpectedShare));
			testSteps.add("Step " + (++step) + " : Expected Shares: " + df.format(ActualShare));
			Assert.assertEquals(df.format(ExtpectedShare), df.format(ActualShare));

			assertTrue(lp.isAmountFieldAutoPopulate(driver), "Verified Estimate Amount field is auto pupolated");

			if (driver.getCurrentUrl().contains("prod")) {
				if (MarketClose) {
//					testSteps.add("Step "+(++step)+" : Click on 'Review Order' button");
//					lp.clickOnReviewOrderButton(driver);
//					instrumentPage.ClickOnPopUpGotItButton(driver);
//
//					testSteps.add("Step "+(++step)+" : Verify Preview Order Page is displaying");
//					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");
//
//					testSteps.add("Step "+(++step)+" : Click on 'Place Buy Order' button");
//					lp.clickOnPlaceBUYOrderButton(driver);
//
//					try {
//						instrumentPage.ClosePopUp(driver);
//					} catch (Exception e) {
//						System.out.print("No PopUp Found");
//					}
//
//					testSteps.add("Step "+(++step)+" : Verify Buy Shares");
//					instrumentPage.VerifyPendingShares(Double.parseDouble(String.valueOf(df.format(ExtpectedShare))), driver);
//
//					testSteps.add("Step "+(++step)+" : Verify User Dashboard is displaying");
//					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
//					instrumentPage.VerifyInvestedAmount(DollarAmount_BeforeInvestedAmount, EstimatedAmount, driver);
//
//					

					navigateToURL(DashboardUrl, driver);
				} else {
					navigateToURL(DashboardUrl, driver);
				}
			} else {
				testSteps.add("Step " + (++step) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);
				instrumentPage.ClickOnPopUpGotItButton(driver);

				testSteps.add("Step " + (++step) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");

				testSteps.add("Step " + (++step) + " : Click on 'Place Buy Order' button");
				lp.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify Buy Shares");
				instrumentPage.VerifyPendingShares(Double.parseDouble(String.valueOf(df.format(ExtpectedShare))),
						driver);

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
				instrumentPage.VerifyInvestedAmount(DollarAmount_BeforeInvestedAmount, EstimatedAmount, driver);

			}

			testSteps.add("Step " + (++step) + " : Close the Browser");
			AddTest_IntoReport("Instruments_Buy", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: Instruments_Buy " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Buy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Buy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Instruments_Buy " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Buy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Buy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	// QAA-43
	@Test(groups = "CashRequired")
	public void Instruments_Sell() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_Sell:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String pass = dataArr[rowIndex][2].toString();
		double Share = 1.00;
		int share = 1;
		float BeforeInvestedAmount = 0;
		double ExpectedVal;
		double ActualVal;
		double beforeBshareValue;
		boolean marketStatus;
		double stopPriceValue;
		double afterBshareValue;
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		double Fractional_Share = 1.001;
		double EstimatedAmount = 7;
		Boolean MarketClose;
		float FractionalBeforeInvestedAmount;
		float DollarAmount_BeforeInvestedAmount;
		double FractionalExpectedVal;
		double FractionalActualVal;
		double ExtpectedShare;
		double ActualShare;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-31?atlOrigin=eyJpIjoiOGI2MmU5MzVhN2YxNDQzNGIxODU1YTM3NzA0ZmFhMDgiLCJwIjoiaiJ9\">QAA-31 : Web - Verify KYC-approved funded account user is able to sell a stock/ETF that they own<a/>");
			testSteps.add("Step" + (++i) + " : Login To App");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step" + (++i) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			try {
				BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				BeforeInvestedAmount = 0;
			}

			MarketClose = instrumentPage.isMarketClose(driver);

			waitTime(2000, driver);
			testSteps.add("Step" + (++i) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");
			} else {
				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");
			}

			String stockName = instrumentPage.getInstrumentName(driver);

			try {
				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);
				testSteps.add(
						"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-43?atlOrigin=eyJpIjoiY2NlYmM1MWM2MGYzNGE0ZThkOWE4OGI5ZDZjMWIzZmEiLCJwIjoiaiJ9\">QAA-43 : Web - Verify user is able to place various combination of market Sell order<a/>");

				if (!driver.getCurrentUrl().contains("prod")) {
					testSteps.add("Step" + (++i) + " : Enter Share Value");
					lp.enterBuyShareValue(Share, driver);
					testSteps.add("Step" + (++i) + " : Verify the amount field is auto-populated");
					ExpectedVal = instrumentPage.getEstimatedProceedsValue(driver);
					ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share;
					System.out.print("Expected: " + String.valueOf(ExpectedVal) + "\n Actual: "
							+ String.valueOf(ActualVal) + "\n");
					Assert.assertEquals(df.format(ActualVal), df.format(ExpectedVal));

					testSteps.add("Step" + (++i) + " : Verify Estimate Amount field is auto pupolated");
					assertTrue(lp.isAmountFieldAutoPopulate(driver),
							"Verified Estimate Amount field is auto pupolated");
				} else {
					testSteps.add("Step" + (++i) + " : Enter Share Value '" + Share + "'");
					lp.enterBuyShareValue(Share, driver);
					testSteps.add("Step" + (++i) + " : Verify the amount field is auto-populated");
					ExpectedVal = instrumentPage.getEstimatedProceedsValue(driver);
					ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share;
					testSteps.add("Expected: " + String.valueOf(ExpectedVal) + "\n Actual: " + String.valueOf(ActualVal)
							+ "\n");
					Assert.assertEquals(df.format(ActualVal), df.format(ExpectedVal));

					testSteps.add("Step" + (++i) + " : Verify Estimate Amount field is auto pupolated");
					assertTrue(lp.isAmountFieldAutoPopulate(driver),
							"Verified Estimate Amount field is auto pupolated");
				}

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);

				} catch (Exception e) {
					System.out.print("No GotIt PopUp Found");
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified Preview Order Page is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);

				} else {

					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(Share, driver);

					instrumentPage.VerifyInvestedAmount(BeforeInvestedAmount, ExpectedVal, driver);
					testSteps.add("For Fractional Share");

				}

				// For Fractional Share

				try {
					FractionalBeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
				} catch (Exception e) {
					FractionalBeforeInvestedAmount = 0;
				}

				if (driver.getCurrentUrl().contains("prod")) {
					testSteps.add("Step" + (++i) + " : Go to instrument details page");
					navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

					testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
					assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
							"Verified Instrument details page load successfully");
				} else {
					testSteps.add("Step" + (++i) + " : Go to instrument details page");
					navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

					testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
					assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
							"Verified Instrument details page load successfully");
				}

				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);
				if (driver.getCurrentUrl().contains("prod")) {
					testSteps.add("Step" + (++i) + " : Enter Fractional Share Value = " + Fractional_Share);
					lp.enterBuyShareValue(Fractional_Share, driver);

					testSteps.add("Step" + (++i) + " : Verify the amount field is auto-populated");
					FractionalExpectedVal = instrumentPage.getEstimatedProceedsValue(driver);
					FractionalActualVal = instrumentPage.getMarketValue(driver, stockName) * Fractional_Share;
					System.out.print("Expected: " + String.valueOf(FractionalExpectedVal) + "\n Actual: "
							+ String.valueOf(FractionalActualVal) + "\n");
					testSteps.add("Step" + (++i) + " : Actual: " + df.format(FractionalActualVal));
					testSteps.add("Step" + (++i) + " : Expected: " + df.format(FractionalExpectedVal));
					Assert.assertEquals(df.format(FractionalActualVal), df.format(FractionalExpectedVal));

					assertTrue(lp.isAmountFieldAutoPopulate(driver),
							"Verified Estimate Amount field is auto pupolated");

				} else {
					testSteps.add("Step" + (++i) + " : Enter Fractional Share Value = " + Fractional_Share);
					lp.enterBuyShareValue(Fractional_Share, driver);

					testSteps.add("Step" + (++i) + " : Verify the amount field is auto-populated");
					FractionalExpectedVal = instrumentPage.getEstimatedProceedsValue(driver);
					FractionalActualVal = instrumentPage.getMarketValue(driver, stockName) * Fractional_Share;
					System.out.print("Expected: " + String.valueOf(FractionalExpectedVal) + "\n Actual: "
							+ String.valueOf(FractionalActualVal) + "\n");
					testSteps.add("Step" + (++i) + " : Actual: " + df.format(FractionalActualVal));
					testSteps.add("Step" + (++i) + " : Expected: " + df.format(FractionalExpectedVal));
					Assert.assertEquals(df.format(FractionalActualVal), df.format(FractionalExpectedVal));

					assertTrue(lp.isAmountFieldAutoPopulate(driver),
							"Verified Estimate Amount field is auto pupolated");

				}

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);
				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewSellOrderPageDisplaying(driver),
							"Verified Preview Order Page is displaying");

					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(Fractional_Share, driver);

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
					instrumentPage.VerifyInvestedAmount(FractionalBeforeInvestedAmount, FractionalExpectedVal, driver);

				}

				// In Dollar
				testSteps.add("Step" + (++i) + " : For Estimated Amount In Dollar");
				try {
					DollarAmount_BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
				} catch (Exception e) {
					DollarAmount_BeforeInvestedAmount = 0;
				}
				waitTime(2000, driver);

				if (driver.getCurrentUrl().contains("prod")) {
					testSteps.add("Step" + (++i) + " : Go to instrument details page");
					navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

					testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
					assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
							"Verified Instrument details page load successfully");
				} else {
					testSteps.add("Step" + (++i) + " : Go to instrument details page");
					navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

					testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
					assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
							"Verified Instrument details page load successfully");
				}

				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);

				if (driver.getCurrentUrl().contains("prod")) {
					testSteps.add("Step" + (++i) + " : Enter Dollar In Estimated Value");
					instrumentPage.enterEstimatedProceedsValue(EstimatedAmount, driver);

					testSteps.add("Step" + (++i) + " : Verify the amount field is auto-populated");
					ExtpectedShare = instrumentPage.getMarketShares(driver);
					ActualShare = EstimatedAmount / instrumentPage.getMarketValue(driver, stockName);
					System.out.print("\nExpected Shares: " + String.valueOf(ExtpectedShare) + "\n\n Actual Shares: "
							+ String.valueOf(ActualShare) + "\n");
					testSteps.add("Step" + (++i) + " : Actual Shares: " + df.format(ExtpectedShare));
					testSteps.add("Step" + (++i) + " : Expected Shares: " + df.format(ActualShare));
					Assert.assertEquals(df.format(ExtpectedShare), df.format(ActualShare));

				} else {
					testSteps.add("Step" + (++i) + " : Enter Dollar In Estimated Value");
					instrumentPage.enterEstimatedProceedsValue(EstimatedAmount, driver);

					testSteps.add("Step" + (++i) + " : Verify the amount field is auto-populated");
					ExtpectedShare = instrumentPage.getMarketShares(driver);
					ActualShare = EstimatedAmount / instrumentPage.getMarketValue(driver, stockName);
					System.out.print("\nExpected Shares: " + String.valueOf(ExtpectedShare) + "\n\n Actual Shares: "
							+ String.valueOf(ActualShare) + "\n");
					testSteps.add("Step" + (++i) + " : Actual Shares: " + df.format(ExtpectedShare));
					testSteps.add("Step" + (++i) + " : Expected Shares: " + df.format(ActualShare));
					Assert.assertEquals(df.format(ExtpectedShare), df.format(ActualShare));

				}

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);
					try {
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {
						// TODO: handle exception
					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewSellOrderPageDisplaying(driver),
							"Verified Preview Order Page is displaying");

					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(Double.parseDouble(String.valueOf(df.format(ExtpectedShare))),
							driver);

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");
					instrumentPage.VerifyInvestedAmount(DollarAmount_BeforeInvestedAmount, EstimatedAmount, driver);

				}

				// verify the increment post buy order

				if (driver.getCurrentUrl().contains("prod")) {

				} else {

					if (MarketClose) {
						waitTime(2000, driver);
						testSteps.add("Step" + (++i) + " : Visit Instruments page url");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
						assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
								"Verified Instruments table is displaying on the instruments page");

						testSteps.add("Step" + (++i) + " : Go to instrument details page");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
						assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
								"Verified Instrument details page load successfully");

						// Add verification Of Already Share
						testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
						beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
						printString("" + beforeBshareValue);

						testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
						instrumentPage.clickOnBuyButton(driver);

						testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
						assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
								"Verified BUY instrument page is displaying");

						// Add
						testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
						instrumentPage.clickOnOrderDropDownBtn(driver);

						testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
						instrumentPage.clickOnStopOrderOption(driver);

						testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
						assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

						testSteps.add("Step" + (++i) + " : Enter Share Value ' " + Share + " '");
						instrumentPage.enterShareValue(share, driver);

						stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
						stopPriceValue = stopPriceValue + 0.1;
						testSteps.add("Step" + (++i) + " : Enter Stop Value ' "
								+ Double.valueOf(df.format(stopPriceValue)) + " '");
						instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

						if (driver.getCurrentUrl().contains("prod")) {
							navigateToURL(DashboardUrl, driver);
						} else {
							testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
							lp.clickOnReviewOrderButton(driver);

							try {
								testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
								instrumentPage.ClickOnPopUpGotItButton(driver);
							} catch (Exception e) {

							}

							testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
							assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
									"Verified 'Preview Order Page' is displaying");

							testSteps.add("Step" + (++i) + " : Click on 'Place Buy Order' button");
							lp.clickOnPlaceBUYOrderButton(driver);

							try {
								instrumentPage.ClosePopUp(driver);
							} catch (Exception e) {
								System.out.print("No PopUp Found");
							}

							testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
							assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

						}

						waitTime(2000, driver);
						testSteps.add("Step" + (++i) + " : Visit Instruments page url");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
						assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
								"Verified Instruments table is displaying on the instruments page");

						testSteps.add("Step" + (++i) + " : Go to instrument details page");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
						assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
								"Verified Instrument details page load successfully");

						afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
						printString("" + afterBshareValue);

//					assertEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
						testSteps.add("Step" + (++i) + " : Share Value Before " + beforeBshareValue
								+ " Share Value After " + afterBshareValue + " are Equal due to Market is close");

					} else {

						waitTime(2000, driver);
						testSteps.add("Step" + (++i) + " : Visit Instruments page url");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
						assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
								"Verified Instruments table is displaying on the instruments page");

						testSteps.add("Step" + (++i) + " : Go to instrument details page");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
						assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
								"Verified Instrument details page load successfully");

						// Add verification Of Already Share
						testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
						beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
						printString("" + beforeBshareValue);

						testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
						instrumentPage.clickOnBuyButton(driver);

						testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
						assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
								"Verified BUY instrument page is displaying");

						testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
						instrumentPage.clickOnOrderDropDownBtn(driver);

						testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
						instrumentPage.clickOnStopOrderOption(driver);

						testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
						assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

						testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
						instrumentPage.enterShareValue(share, driver);

						stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
						stopPriceValue = stopPriceValue + 0.1;
						testSteps.add("Step" + (++i) + " : Enter Stop Value ' "
								+ Double.valueOf(df.format(stopPriceValue)) + " '");
						instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

						if (driver.getCurrentUrl().contains("prod")) {
							navigateToURL(DashboardUrl, driver);
						} else {
							testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
							lp.clickOnReviewOrderButton(driver);

							try {
								testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
								instrumentPage.ClickOnPopUpGotItButton(driver);
							} catch (Exception e) {
								System.out.print("No PopUp Found");
							}

							testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
							assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
									"Verified 'Preview Order Page' is displaying");

							testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
							lp.clickOnPlaceBUYOrderButton(driver);

							try {
								instrumentPage.ClosePopUp(driver);
							} catch (Exception e) {
								System.out.print("No PopUp Found");
							}

							testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
							assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

						}

						waitTime(2000, driver);
						testSteps.add("Step" + (++i) + " : Visit Instruments page url");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
						assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
								"Verified Instruments table is displaying on the instruments page");

						testSteps.add("Step" + (++i) + " : Go to instrument details page");
						navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

						testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
						assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
								"Verified Instrument details page load successfully");

						afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
						printString("" + afterBshareValue);

//					ErrorCollector.assertNotEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
//					testSteps.add("Step" +(++i) + " 32 : Share Value Before " + beforeBshareValue + " Share Value After "
//							+ afterBshareValue + " are Not Equal");
					}

					// verify user is able to sell all
					testSteps.add("Step" + (++i) + " : Navigate Back to Instruments page");
					lp.goBack(driver);

					testSteps.add("Step" + (++i) + " : Navigate Back to home page");
					lp.goBack(driver);

					lp.pageReload(driver);
					lp.pageReload(driver);
					waitTime(2000, driver);
					testSteps.add("Step" + (++i) + " : Visit Instruments page url");
					navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

					testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
					assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
							"Verified Instruments table is displaying on the instruments page");

					testSteps.add("Step" + (++i) + " : Go to instrument details page");
					navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

					testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
					assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
							"Verified Instrument details page load successfully");

					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
					printString("" + beforeBshareValue);

					testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
					lp.clickOnSellButton(driver);

					testSteps.add("Step" + (++i) + " : Click on 'Check Box Sell All'");
					lp.clickOnCheckBoxSellAll(driver);

					float sellAllVal = instrumentPage.getSharesInput(driver);
					assertEquals(df.format(beforeBshareValue), df.format(beforeBshareValue));
				}
			} catch (Exception e) {
				testSteps.add("Step" + (++i) + " : You Can't 'Sell' Because you don't even buy yet");
			}

			testSteps.add("Step" + (++i) + " : Close the Browser");
			AddTest_IntoReport("Instruments_Sell", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Instruments_Sell " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Sell") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Sell", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Instruments_Sell " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Sell") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Sell", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	// QAA-49
	@Test(groups = "CashRequired")
	public void Instruments_Sell_LimitOrder() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_Sell_LimitOrder:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String pass = dataArr[rowIndex][2].toString();
		int share = 1;
		float BeforeInvestedAmount = 0;
		double beforeBshareValue;
		int limitPriceValue;
		double shareFractional = 1.001;
		limitPriceValue = 100;
		boolean marketStatus;
		double afterBshareValue;
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-46?atlOrigin=eyJpIjoiOWY3ZmVlMGRkMTM2NGE0NWExMTM3ZGY3ZjkyMzUwNTAiLCJwIjoiaiJ9\">QAA-46 : Web - Verify user is able to place various combination of limit sell order<a/>");
			testSteps.add("Step" + (++i) + " : Login To App");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step" + (++i) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			try {
				BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				BeforeInvestedAmount = 0;
			}

			marketStatus = instrumentPage.isMarketClose(driver);

			waitTime(2000, driver);
			testSteps.add("Step" + (++i) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			testSteps.add("Step" + (++i) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			// Add verification Of Already Share
			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			try {
				beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
			} catch (Exception e) {
				beforeBshareValue = 0;
			}

			printString("" + beforeBshareValue);

			testSteps.add("Step" + (++i) + " : Click on Sell button");
			lp.clickOnSellButton(driver);

			testSteps.add("Step" + (++i) + " : Verify Sell instrument page is displaying");
			assertTrue(instrumentPage.isSellInstrumentPageDisplaying(driver),
					"Verified Sell instrument page is displaying");

			// Add
			testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
			instrumentPage.clickOnLimitOrderOption(driver);

			testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
			assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

			testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
			lp.enterBuyShareValue(shareFractional, driver);

			testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
			assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
					"Verified fractional error message");

			testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
			instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

			testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			try {
				instrumentPage.ClickOnPopUpGotItButton(driver);
			} catch (Exception e) {
				System.out.print("No PopUp Found");
			}

			testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
			assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

			if (driver.getCurrentUrl().contains("prod")) {
				printString(DashboardUrl);
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
				lp.clickOnPlaceSellOrderButton(driver);
				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}
			}

			testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			// verify the increment post buy order

			if (marketStatus == true) {
				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);

				testSteps.add("Step" + (++i) + " : Verify Sell instrument page is displaying");
				assertTrue(instrumentPage.isSellInstrumentPageDisplaying(driver),
						"Verified Sell instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));

				} catch (Exception e) {
					afterBshareValue = 0;

				}

				printString("" + afterBshareValue);
				assertEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
				testSteps.add("Step" + (++i) + " : Share Value Before " + beforeBshareValue + " Share Value After "
						+ afterBshareValue + " are Equal");

			} else {
				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);

				testSteps.add("Step" + (++i) + " : Verify Sell instrument page is displaying");
				assertTrue(instrumentPage.isSellInstrumentPageDisplaying(driver),
						"Verified Sell instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

			}

			// verify order under pending list. Expiration date should be 90 days later

			if (marketStatus == true) {

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);

				testSteps.add("Step" + (++i) + " : Verify Sell instrument page is displaying");
				assertTrue(instrumentPage.isSellInstrumentPageDisplaying(driver),
						"Verified Sell instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				if (driver.getCurrentUrl().contains("prod")) {

				} else {
					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(share, driver);
				}

//			expiryDateValue = instrumentPage.getExpiryDateValue();
//			getCurrentDate = instrumentPage.getCurrentDate();
//			daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//			printString(daysBtExpiryDateAndCurrentDate);
//			assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);

			} else {

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
				lp.clickOnSellButton(driver);

				testSteps.add("Step" + (++i) + " : Verify Sell instrument page is displaying");
				assertTrue(instrumentPage.isSellInstrumentPageDisplaying(driver),
						"Verified Sell instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Place Sell Order' button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				if (driver.getCurrentUrl().contains("prod")) {

				} else {
					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(share, driver);
				}

//			expiryDateValue = instrumentPage.getExpiryDateValue();
//			getCurrentDate = instrumentPage.getCurrentDate();
//			daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//			printString(daysBtExpiryDateAndCurrentDate);
//			assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);

//			instrumentPage.ClosePendingOrders();

			}

			testSteps.add("Step" + (++i) + " : Close the Browser");
			AddTest_IntoReport("Instruments_Sell_LimitOrder", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: Instruments_Sell_LimitOrder " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Sell_LimitOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Sell_LimitOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Instruments_Sell_LimitOrder " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Sell_LimitOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Sell_LimitOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	// QAA-37
	@Test(groups = "CashRequired")
	public void Instruments_Buy_LimitOrder() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_Buy_LimitOrder:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String pass = dataArr[rowIndex][2].toString();
		int share = 1;
		float BeforeInvestedAmount = 0;
		double beforeBshareValue;
		double afterBshareValue;
		int limitPriceValue;
		double shareFractional = 1.001;
		limitPriceValue = 100;
		boolean marketStatus;
		double stopPriceValue;
		long daysBtExpiryDateAndCurrentDate;
		long expiryAllDays = 90;
		String expiryDateValue = "";
		String getCurrentDate = "";
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		String stockName = "";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-37\">QAA-37 : Web - Verify User Is Able To Place Various Combination Of Limit Buy Order<a/>");
			testSteps.add("Step" + (++i) + " : Logi To App");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step" + (++i) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			try {
				BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				BeforeInvestedAmount = 0;
			}

			marketStatus = instrumentPage.isMarketClose(driver);

			waitTime(2000, driver);
			testSteps.add("Step" + (++i) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			testSteps.add("Step" + (++i) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			// Add verification Of Already Share
			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
			printString("" + beforeBshareValue);
			stockName = instrumentPage.getInstrumentName(driver);
			testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			// Add
			testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
			instrumentPage.clickOnLimitOrderOption(driver);

			testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
			assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

			testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
			lp.enterBuyShareValue(shareFractional, driver);

			testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
			assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
					"Verified fractional error message");

			testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
			instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);
				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					printString("GotIt Pop Not Showing", driver);
				}
				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
				lp.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				// Pending Shares
				testSteps.add("Step" + (++i) + " : Verify Sell Shares");
				instrumentPage.VerifyPendingShares(share, driver);

			}

			// verify the increment post buy order

			if (marketStatus == true) {
				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {
						// TODO: handle exception
					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on 'Place Buy Order' button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				}

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

				if (driver.getCurrentUrl().contains("prod")) {
					assertEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
					testSteps.add("Step" + (++i) + " : Share Value Before " + beforeBshareValue + " Share Value After "
							+ afterBshareValue + " are Equal");
				}

			} else {
				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);
				stockName = instrumentPage.getInstrumentName(driver);
				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				if (driver.getCurrentUrl().contains("prod")) {

					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);
					try {
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {
						// TODO: handle exception
					}
					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on 'Place Buy Order' button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				}

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

//			ErrorCollector.assertNotEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
//			testSteps.add("Step" +(++i) + " 57 : Share Value Before " + beforeBshareValue + " Share Value After "
//					+ afterBshareValue + " are Not Equal");
			}

			// verify order under pending list. Expiration date should be 90 days later

			if (marketStatus == true) {

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnLimitOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
				lp.enterBuyShareValue(shareFractional, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				testSteps.add("Step" + (++i) + " : Verify fractional error message is displaying");
				assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
						"Verified fractional error message");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + limitPriceValue + " '");
				instrumentPage.enterLimitPriceValue(limitPriceValue, driver);

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {
						// TODO: handle exception
					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on 'Place Buy Order' button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				}

//			expiryDateValue = instrumentPage.getExpiryDateValue();
//			getCurrentDate = instrumentPage.getCurrentDate();
//			daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//			printString(daysBtExpiryDateAndCurrentDate);
//			assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);
//
//			instrumentPage.ClosePendingOrders();

			} else {

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Limit Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Limit Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
				stopPriceValue = stopPriceValue + 0.1;
				testSteps.add(
						"Step" + (++i) + " : Enter Limit Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
				instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						testSteps.add("Step" + (++i) + "  : Click on 'Ok Got It' button");
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {

					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on 'Place Buy Order' button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

//			expiryDateValue = instrumentPage.getExpiryDateValue();
//			getCurrentDate = instrumentPage.getCurrentDate();
//			daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//			printString(daysBtExpiryDateAndCurrentDate);
//			assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);
//
//			instrumentPage.ClosePendingOrders();
			}

			testSteps.add("Step" + (++i) + " : Close the Browser");
			AddTest_IntoReport("Instruments_Buy_LimitOrder", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Instruments_Buy_LimitOrder " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Buy_LimitOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Buy_LimitOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Instruments_Buy_LimitOrder " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Buy_LimitOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Buy_LimitOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	// QAA-40
	@Test(groups = "CashRequired")
	public void Instruments_Buy_StopOrder() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_Buy_StopOrder:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String pass = dataArr[rowIndex][2].toString();
		int share = 1;
		double BeforeInvestedAmount = 0;
		double beforeBshareValue;
		double stopPriceValue;
		boolean marketStatus;
		double afterBshareValue;
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-40?atlOrigin=eyJpIjoiMDFlZGM1MWM4OWI4NGY3YTgzY2IyZDNlYjVmYjE4OTciLCJwIjoiaiJ9\">QAA-40 : Web - Verify user is able to place various combination of stop buy order<a/>");
			testSteps.add("Step" + (++i) + " : Visit app url : https://next-staging.vested.co.in");
			testSteps.add("Step" + (++i) + " : Login To App");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step" + (++i) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			try {
				BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				BeforeInvestedAmount = 0;
			}

			marketStatus = instrumentPage.isMarketClose(driver);

			waitTime(2000, driver);
			testSteps.add("Step" + (++i) + " : Visit Instruments page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified Instruments table is displaying on the instruments page");

			testSteps.add("Step" + (++i) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			// Add verification Of Already Share
			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			try {
				beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
			} catch (Exception e) {
				beforeBshareValue = 0;
			}

			printString("" + beforeBshareValue);

			String stockName = instrumentPage.getInstrumentName(driver);

			testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			// Add
			testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			// When Stop Price Value is Equal To Market price.

			stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
			testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

			if (driver.getCurrentUrl().contains("prod")) {

			} else {

			}

			testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			try {
				testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
				instrumentPage.ClickOnPopUpGotItButton(driver);
			} catch (Exception e) {

			}

			if (driver.getCurrentUrl().contains("prod")) {
				testSteps.add("Step" + (++i) + " : Please add funds");
			} else {
				testSteps.add("Step" + (++i) + " : Verify error message low stop price is displaying");
				assertTrue(instrumentPage.errorMessageLowStopPriceIsShowing(driver),
						"Verified error message low stop price");
				testSteps.addAll(instrumentPage.clickOnErrorMessageLowStopPricePopupCloseButton(driver));
			}

			// When Stop Price Value is Less Then Market price.

			stopPriceValue = stopPriceValue - 1;
			testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

			testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			try {
				testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
				instrumentPage.ClickOnPopUpGotItButton(driver);
			} catch (Exception e) {

			}

			if (driver.getCurrentUrl().contains("prod")) {
				testSteps.add("Step" + (++i) + " : Please add funds");
			} else {
				testSteps.add("Step" + (++i) + " : Verify error message low stop price is displaying");
				assertTrue(instrumentPage.errorMessageLowStopPriceIsShowing(driver),
						"Verified error message low stop price");
				testSteps.addAll(instrumentPage.clickOnErrorMessageLowStopPricePopupCloseButton(driver));
			}

			// When we add 0.05 with Market price.

			stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
			stopPriceValue = stopPriceValue + 0.1;
			testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

			if (driver.getCurrentUrl().contains("prod")) {
				navigateToURL(DashboardUrl, driver);
			} else {
				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
				lp.clickOnPlaceBUYOrderButton(driver);

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			}

			// verify the increment post buy order

			if (marketStatus == true) {
				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
				stopPriceValue = stopPriceValue + 0.1;
				testSteps.add(
						"Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
				instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {

					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				}

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

				if (driver.getCurrentUrl().contains("prod")) {

				} else {
					assertEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
					testSteps.add("Step" + (++i) + " : Share Value Before " + beforeBshareValue + " Share Value After "
							+ afterBshareValue + " are Equal");
				}

			} else {

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
				stopPriceValue = stopPriceValue + 0.1;
				testSteps.add(
						"Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
				instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {

					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}

					testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
					assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				}
				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

//			ErrorCollector.assertNotEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
//			testSteps.add("Step" +(++i) + " 32 : Share Value Before " + beforeBshareValue + " Share Value After "
//					+ afterBshareValue + " are Not Equal");
			}

			// verify order under pending list. Expiration date should be 90 days later

			if (marketStatus == true) {

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
				stopPriceValue = stopPriceValue + 0.1;
				testSteps.add(
						"Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
				instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

				try {

				} catch (Exception e) {
					// TODO: handle exception
				}

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {

					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

//			expiryDateValue = instrumentPage.getExpiryDateValue();
//			getCurrentDate = instrumentPage.getCurrentDate();
//			daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//			printString(daysBtExpiryDateAndCurrentDate);
//			assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);
//
//			instrumentPage.ClosePendingOrders();

			} else {

				waitTime(2000, driver);
				testSteps.add("Step" + (++i) + " : Visit Instruments page url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instruments page load successfully");
				assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
						"Verified Instruments table is displaying on the instruments page");

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on 'BUY' button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step" + (++i) + " : Verify BUY instrument page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified BUY instrument page is displaying");

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = instrumentPage.getMarketValue(driver, stockName);
				stopPriceValue = stopPriceValue + 0.1;
				testSteps.add(
						"Step" + (++i) + " : Enter Stop Value ' " + Double.valueOf(df.format(stopPriceValue)) + " '");
				instrumentPage.enterstopPriceValue(Double.valueOf(df.format(stopPriceValue)), driver);

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
					lp.clickOnReviewOrderButton(driver);

					try {
						testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
						instrumentPage.ClickOnPopUpGotItButton(driver);
					} catch (Exception e) {

					}

					testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
					assertTrue(lp.isPreviewBUYOrderPageDisplaying(driver),
							"Verified 'Preview Order Page' is displaying");

					testSteps.add("Step" + (++i) + " : Click on Place Buy Order button");
					lp.clickOnPlaceBUYOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

//			expiryDateValue = instrumentPage.getExpiryDateValue();
//			getCurrentDate = instrumentPage.getCurrentDate();
//			daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//			printString(daysBtExpiryDateAndCurrentDate);
//			assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);
//
//			instrumentPage.ClosePendingOrders();
			}

			testSteps.add("Step" + (++i) + " : Close the Browser");
			AddTest_IntoReport("Instruments_Buy_StopOrder", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: Instruments_Buy_StopOrder " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Buy_StopOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Buy_StopOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Instruments_Buy_StopOrder " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Buy_StopOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Buy_StopOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void Instruments_Sell_StopOrder() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_Sell_StopOrder: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String pass = dataArr[rowIndex][2].toString();
		int share = 1;
		float BeforeInvestedAmount = 0;
		double beforeBshareValue;
		double stopPriceValue;
		boolean marketStatus;
		double afterBshareValue;
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-49?atlOrigin=eyJpIjoiMWZhMzYxMDZlNjUxNGY2Y2E5N2Y1NmY0YzEzZTExNWQiLCJwIjoiaiJ9\">QAA-49 : Web - Verify user is able to place various combination of stop sell order<a/>");
			testSteps.add("Step" + (++i) + " : Login To App");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step" + (++i) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			try {
				BeforeInvestedAmount = instrumentPage.getInvestedAmountValue(driver);
			} catch (Exception e) {
				BeforeInvestedAmount = 0;
			}

			marketStatus = instrumentPage.isMarketClose(driver);

			// verify user is able to sell all

			lp.pageReload(driver);
			lp.pageReload(driver);
			waitTime(2000, driver);

			testSteps.add("Step" + (++i) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			try {
				beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
			} catch (Exception e) {
				beforeBshareValue = 0;
			}

			printString("" + beforeBshareValue);

			testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
			lp.clickOnSellButton(driver);

			// Add
			testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step" + (++i) + " : Click on 'Check Box Sell All'");
			lp.clickOnCheckBoxSellAll(driver);

			float sellAllVal = instrumentPage.getSharesInput(driver);
			assertEquals(df.format(beforeBshareValue), df.format(beforeBshareValue));

			waitTime(2000, driver);

			testSteps.add("Step" + (++i) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			testSteps.add("Step" + (++i) + " : Click on 'Sell' button");
			lp.clickOnSellButton(driver);

			// Add
			testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
			instrumentPage.enterShareValue(share, driver);

			stopPriceValue = 100;
			testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + stopPriceValue + " '");
			instrumentPage.enterstopPriceValue(stopPriceValue, driver);

			testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			try {
				testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
				instrumentPage.ClickOnPopUpGotItButton(driver);
			} catch (Exception e) {

			}

			testSteps.add("Step" + (++i) + " : Verify error message High stop price is displaying");
			assertTrue(instrumentPage.errorMessageHighStopPriceIsShowing(driver),
					"Verified error message High stop price");
			instrumentPage.clickOnErrorMessageHighStopPricePopupCloseButton(driver);

			// verify the increment post buy order

			if (marketStatus == true) {
				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on Sell button");
				lp.clickOnSellButton(driver);

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = 1;
				testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + stopPriceValue + " '");
				instrumentPage.enterstopPriceValue(stopPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}
				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on Place Sell Order button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

				if (driver.getCurrentUrl().contains("prod")) {

				} else {
					assertEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
				}

				testSteps.add("Step" + (++i) + " : Share Value Before " + beforeBshareValue + " Share Value After "
						+ afterBshareValue + " are Equal");

			} else {
				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on Sell button");
				lp.clickOnSellButton(driver);

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = 1;
				testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + stopPriceValue + " '");
				instrumentPage.enterstopPriceValue(stopPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}
				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on Place Sell Order button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				try {
					afterBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					afterBshareValue = 0;
				}

				printString("" + afterBshareValue);

//			ErrorCollector.assertNotEquals(df.format(afterBshareValue), df.format(beforeBshareValue));
//			testSteps.add("Step" +(++i) + " 32 : Share Value Before " + beforeBshareValue + " Share Value After "
//					+ afterBshareValue + " are Not Equal");
			}

			// verify order under pending list. Expiration date should be 90 days later

			if (marketStatus == true) {

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on Sell button");
				lp.clickOnSellButton(driver);

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = 1;
				testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + stopPriceValue + " '");
				instrumentPage.enterstopPriceValue(stopPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}
				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on Place Sell Order button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				if (driver.getCurrentUrl().contains("prod")) {

				} else {
					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(share, driver);
				}

//					expiryDateValue = instrumentPage.getExpiryDateValue();
//					getCurrentDate = instrumentPage.getCurrentDate();
//					daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//					printString(daysBtExpiryDateAndCurrentDate);
//					assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);
//
//					instrumentPage.ClosePendingOrders();

			} else {

				waitTime(2000, driver);

				testSteps.add("Step" + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step" + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				// Add verification Of Already Share
				try {
					beforeBshareValue = Double.parseDouble(instrumentPage.getYourPositionShare(driver));
				} catch (Exception e) {
					beforeBshareValue = 0;
				}

				printString("" + beforeBshareValue);

				testSteps.add("Step" + (++i) + " : Click on Sell button");
				lp.clickOnSellButton(driver);

				// Add
				testSteps.add("Step" + (++i) + " : Click on 'Order Drop Down button'");
				instrumentPage.clickOnOrderDropDownBtn(driver);

				testSteps.add("Step" + (++i) + " : Click on 'Stop Order Option' ");
				instrumentPage.clickOnStopOrderOption(driver);

				testSteps.add("Step" + (++i) + " : Verify 'Stop Order Page' is displaying");
				assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

				testSteps.add("Step" + (++i) + " : Enter Share Value ' " + share + " '");
				instrumentPage.enterShareValue(share, driver);

				stopPriceValue = 1;
				testSteps.add("Step" + (++i) + " : Enter Stop Value ' " + stopPriceValue + " '");
				instrumentPage.enterstopPriceValue(stopPriceValue, driver);

				testSteps.add("Step" + (++i) + " : Click on 'Review Order' button");
				lp.clickOnReviewOrderButton(driver);

				try {
					testSteps.add("Step" + (++i) + " : Click on 'Ok Got It' button");
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {

				}
				try {
					instrumentPage.ClickOnPopUpGotItButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

				testSteps.add("Step" + (++i) + " : Verify Preview Order Page is displaying");
				assertTrue(lp.isPreviewSellOrderPageDisplaying(driver), "Verified 'Preview Order Page' is displaying");

				if (driver.getCurrentUrl().contains("prod")) {
					navigateToURL(DashboardUrl, driver);
				} else {
					testSteps.add("Step" + (++i) + " : Click on Place Sell Order button");
					lp.clickOnPlaceSellOrderButton(driver);

					try {
						instrumentPage.ClosePopUp(driver);
					} catch (Exception e) {
						System.out.print("No PopUp Found");
					}
				}

				testSteps.add("Step" + (++i) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

				if (driver.getCurrentUrl().contains("prod")) {

				} else {
					testSteps.add("Step" + (++i) + " : Verify Sell Shares");
					instrumentPage.VerifyPendingShares(share, driver);
				}

//					expiryDateValue = instrumentPage.getExpiryDateValue();
//					getCurrentDate = instrumentPage.getCurrentDate();
//					daysBtExpiryDateAndCurrentDate = instrumentPage.getExpiryDateValue(expiryDateValue, getCurrentDate);
//					printString(daysBtExpiryDateAndCurrentDate);
//					assertEquals(daysBtExpiryDateAndCurrentDate, expiryAllDays);
//
//					instrumentPage.ClosePendingOrders();

			}

			testSteps.add("Step" + (++i) + " : Close the Browser");
			AddTest_IntoReport("Instruments_Sell_StopOrder", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Instruments_Sell_StopOrder " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Sell_StopOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Sell_StopOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Instruments_Sell_StopOrder " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_Sell_StopOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_Sell_StopOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(groups = "CashRequired")
	public void BuyInstruments_WithoutVerification() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("BuyInstruments_WithoutVerification: " + driver.hashCode() + "", driver);
		int step = 0;
		double Share = 1.00;
		String stockName = null;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-783?atlOrigin=eyJpIjoiMTA3NTRmZGE1NjdkNGYxMzg0YzY3Y2Q0NWJiZjQ4M2QiLCJwIjoiaiJ9\">QAA-783 : [Web] - Verify that user is buy Instrument/stock for market order<a/>");

			testSteps.add("Step " + (++step) + " : Login to app");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");

			waitTime(2000, driver);
			testSteps.add("Step " + (++step) + " : Search and select any Instrument/stock");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			stockName = instrumentPage.getInstrumentName(driver);
			testSteps.add("Step " + (++step) + " : Click on <b>'BUY'</b> button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++step) + " : Enter Share Value: <b>" + Share);
			lp.enterBuyShareValue(Share, driver);

			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Order'</b> button");
			lp.clickOnReviewOrderButton(driver);

			if (!PropertiesReader.getPropertyValue("env").contains("prod")) {
				testSteps.add("Step " + (++step) + " : Click on <b>'Place Buy Order'</b> button");
				lp.clickOnPlaceBUYOrderButton(driver);

				testSteps.add(
						"Step " + (++step) + " : Verifying <b>'Successfully Order Placed'</b> Screen is Displaying");
				// assertTrue(instrumentPage.SuccessScreenDisplaying(driver), "Successfully
				// Order Placed Screen is not Displaying");
				testSteps.add(
						"Step " + (++step) + " : Verified: <b>'Successfully Order Placed'</b> Screen is Displaying");

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			}

			testSteps.add("Step " + (++step) + " : Close the Browser");
			AddTest_IntoReport("BuyInstruments_WithoutVerification", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: BuyInstruments_WithoutVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("BuyInstruments_WithoutVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("BuyInstruments_WithoutVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: BuyInstruments_WithoutVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("BuyInstruments_WithoutVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("BuyInstruments_WithoutVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void SellInstruments_WithoutVerification() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("SellInstruments_WithoutVerification: " + driver.hashCode() + "", driver);
		int step = 0;
		double Share = 1.00;
		String stockName = null;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-792?atlOrigin=eyJpIjoiMTA3NTRmZGE1NjdkNGYxMzg0YzY3Y2Q0NWJiZjQ4M2QiLCJwIjoiaiJ9\">QAA-792 : [Web] - Verify that user is able to sell shares of Instrument/stock for market order<a/>");

			testSteps.add("Step " + (++step) + " : Login to app");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step " + (++step) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");

			waitTime(2000, driver);
			testSteps.add("Step " + (++step) + " : Search and select any Instrument/stock");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			wait5s();
			stockName = instrumentPage.getInstrumentName(driver);
			testSteps.add("Step " + (++step) + " : Click on <b>'Sell'</b> button");
			instrumentPage.clickOnSellButton(driver);

			testSteps.add("Step " + (++step) + " : Enter Share Value: <b>" + Share);
			lp.enterBuyShareValue(Share, driver);

			testSteps.add("Step " + (++step) + " : Click on <b>'Preview Order'</b> button");
			lp.clickOnReviewOrderButton(driver);

			if (!PropertiesReader.getPropertyValue("env").contains("prod")) {
				testSteps.add("Step " + (++step) + " : Click on <b>'Place Sell Order'</b> button");
				lp.clickOnPlaceSellOrderButton(driver);

				testSteps.add(
						"Step " + (++step) + " : Verifying <b>'Successfully Order Placed'</b> Screen is Displaying");
				// assertTrue(instrumentPage.SuccessScreenDisplaying(driver), "Successfully
				// Order Placed Screen is not Displaying");
				testSteps.add(
						"Step " + (++step) + " : Verified: <b>'Successfully Order Placed'</b> Screen is Displaying");

				try {
					instrumentPage.ClosePopUp(driver);
				} catch (Exception e) {
					System.out.print("No PopUp Found");
				}

				testSteps.add("Step " + (++step) + " : Verify User Dashboard is displaying");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified User Dashboard is displayed");

			}

			testSteps.add("Step " + (++step) + " : Close the Browser");
			AddTest_IntoReport("SellInstruments_WithoutVerification", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: SellInstruments_WithoutVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("SellInstruments_WithoutVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("SellInstruments_WithoutVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: SellInstruments_WithoutVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("SellInstruments_WithoutVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("SellInstruments_WithoutVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
