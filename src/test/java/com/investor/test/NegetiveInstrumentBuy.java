package com.investor.test;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;

public class NegetiveInstrumentBuy extends BaseClass {
	String tempSrc = "";

	// QAA-100
	@Test(groups = "CashRequired")
	public void Instruments_NegetiveBuy() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage lp;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_NegetiveBuy:" + driver.hashCode() + "", driver);
		double ExpectedVal = 0;
		double ActualVal = 0;
		int i = 0;
		double Share = 0.0000000001;
		double Share1 = 0.0000000001;
		double Share2 = 0.00000000001;
		String StopPriceShares = "0.9";
		String StopPrice = "0.8";
		String ErrorMessage = "Invalid cash.";
		double shareFractional = 1.001;
		DecimalFormat df = new DecimalFormat("#.##");
		DecimalFormat dfEightDecimal = new DecimalFormat("#.#################");

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-100?atlOrigin=eyJpIjoiYWNmZWUzMjRkNjljNGVmZTliZjdlYWViOTdiOWE0MzEiLCJwIjoiaiJ9\">QAA-100 : [Negative Web Buy] Instrument Buy scenario<a/>");

			testSteps.addAll(lp.loginToApp(driver));

			waitTime(2000, driver);
			testSteps.add("Step " + (++i) + " : Verify Dashboard is displaying");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");

			testSteps.add("Step " + (++i) + " : Navigate to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURLAMZN"), driver);

			testSteps.add("Step " + (++i) + " : Instrument Name = <b>" + instrumentPage.getStockname(driver));
			testSteps.add("Step " + (++i) + " : Verify instrument details page load successfully");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified Instrument details page load successfully");

			String stockName = instrumentPage.getStockname(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Overview' Tab is showing");
			assertTrue(instrumentPage.isOverviewTabIsDisplaying(driver), "Verified 'Overview' Tab is showing");

			testSteps.add("Step " + (++i) + " : Click on 'Overview' Tab");
			instrumentPage.clickOnOverviewTab(driver);

//			testSteps.add("Step " + (++i) + " : Verify 'Overview' Tab Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified 'Overview' Tab Details is showing");

			testSteps.add("Step " + (++i) + " : Verify Returns Tab is showing");
			assertTrue(instrumentPage.isReturnTabIsDisplaying(driver), "Verified Returns Tab is showing");

			testSteps.add("Step " + (++i) + " : Click on 'Returns Tab'");
			instrumentPage.clickOnReturnTab(driver);

//			testSteps.add("Step " + (++i) + " : Verify 'Returns Tab' Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified Overview Tab Details is showing");

			testSteps.add("Step " + (++i) + " : Verify Fundamental Data Tab is showing");
			assertTrue(instrumentPage.isFundamentalDataTabIsDisplaying(driver),
					"Verified Fundamental Data Tab is showing");

			testSteps.add("Step " + (++i) + " : Click on Fundamental Data Tab");
			instrumentPage.clickOnFundamentalDataTab(driver);

//			testSteps.add("Step " + (++i) + " : Verify Fundamental Data Tab Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified Fundamental Data Tab Details is showing");

			testSteps.add("Step " + (++i) + " : Verify Key Ratio Tab is showing");
			assertTrue(instrumentPage.isKeyRatioTabIsDisplaying(driver), "Verified Key Ratio Tab is showing");

			testSteps.add("Step " + (++i) + " : Click on Key Ratio Tab");
			instrumentPage.clickOnKeyRatioTab(driver);

//			testSteps.add("Step " + (++i) + " : Verify Key Ratio Tab Details is showing");
//			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified Key Ratio Tab Details is showing");

			testSteps.add("Step " + (++i) + " : Click on 'ADD TO WATCHLIST' button");
			instrumentPage.clickOnAddToWatchList(driver);

			testSteps.add("Step " + (++i) + " : Verify instrument added to watchlist without error");
			assertTrue(instrumentPage.isAddedToWatchListDisplaying(driver),
					"Verified instrument added to watchlist without error");

			testSteps.add("Step " + (++i) + " : Click on 'ADD TO WATCHLIST' button to remove from Watchlist");
			instrumentPage.clickOnAddToWatchList(driver);

			testSteps.add("Step " + (++i) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step  " + (++i) + " : Verify BUY instrument page is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified BUY instrument page is displaying");

			testSteps.add("Step  " + (++i) + " : Enter Share Value: " + dfEightDecimal.format(Share));
			lp.enterBuyShareValue(dfEightDecimal.format(Share), driver);

			testSteps.add("Step  " + (++i) + " : Verify the amount field is auto-populated");
			ExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share;
			assertEquals(df.format(ActualVal), df.format(ExpectedVal));

			testSteps.add("Step  " + (++i) + " : Click on Review Order button");
			lp.clickOnReviewOrderButton(driver);

			testSteps.add("Step  " + (++i) + " : Verify Error Message: <b>" + ErrorMessage);
			assertEquals(instrumentPage.getInvalidCashErrorMessage(driver), ErrorMessage,
					"<b>'Invalid Cash'</b> Error Message Mismatched");
			testSteps.add("Step  " + (++i) + " : Verified Error Message: <b>" + ErrorMessage);

			testSteps.add("Step  " + (++i) + " : Enter Share Value : <b>" + dfEightDecimal.format(Share1));
			lp.enterBuyShareValue(dfEightDecimal.format(Share1), driver);

			testSteps.add("Step  " + (++i) + " : Verify the amount field is auto-populated");
			ExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share1;
			assertEquals(df.format(ActualVal), df.format(ExpectedVal));

			testSteps.add("Step  " + (++i) + " : Verify Error Message: " + ErrorMessage);
			assertEquals(instrumentPage.getInvalidCashErrorMessage(driver), ErrorMessage,
					"<b>'Invalid Cash'</b> Error Message Mismatched");
			testSteps.add("Step  " + (++i) + " : Verified Error Message: <b>" + ErrorMessage);

			testSteps.add("Step  " + (++i) + " : Enter Share Value : <b>" + dfEightDecimal.format(Share2));
			lp.enterBuyShareValue(dfEightDecimal.format(Share2), driver);

			testSteps.add("Step  " + (++i) + " : Verify the amount field is auto-populated");
			ExpectedVal = instrumentPage.getEstimatedCostValue(driver);
			ActualVal = instrumentPage.getMarketValue(driver, stockName) * Share2;
			assertEquals(df.format(ActualVal), df.format(ExpectedVal));

			testSteps.add("Step  " + (++i) + " : Verify Error Message: " + ErrorMessage);
			assertEquals(instrumentPage.getInvalidCashErrorMessage(driver), ErrorMessage,
					"<b>'Invalid Cash'</b> Error Message Mismatched");
			testSteps.add("Step  " + (++i) + " : Verified Error Message: <b>" + ErrorMessage);

			testSteps.add("Step " + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Limit Order Option' ");
			instrumentPage.clickOnLimitOrderOption(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Limit Order Page' is displaying");
			assertTrue(instrumentPage.verifyLimitOrderPageIsShowing(driver), "Verified Limit Order Page");

			testSteps.add("Step " + (++i) + " : Enter Share Fractional Value ' " + shareFractional + " '");
			lp.enterBuyShareValue(shareFractional, driver);

			testSteps.add("Step " + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Fractional shares are not supported for limit orders.'</b> is displaying");
			assertTrue(instrumentPage.errorMessageFractionalShareIsShowing(driver),
					"Verified: <b>'Fractional shares are not supported for limit orders.'</b>");

			testSteps.add("Step " + (++i) + " : Click on 'Order Drop Down button'");
			instrumentPage.clickOnOrderDropDownBtn(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Stop Order Option' ");
			instrumentPage.clickOnStopOrderOption(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Stop Order Page' is displaying");
			assertTrue(instrumentPage.verifyStopOrderPageIsShowing(driver), "Verified Stop Order Page");

			testSteps.add("Step " + (++i) + " : Enter Share Value ' " + StopPriceShares + " '");
			instrumentPage.enterShareValue(Double.valueOf(StopPriceShares), driver);

			testSteps.add("Step " + (++i) + " : Enter Stop Price Value ' " + StopPrice + " '");
			instrumentPage.enterstopPriceValue(Double.valueOf(StopPrice), driver);

			testSteps.add("Step " + (++i) + " : Click on 'Review Order' button");
			lp.clickOnReviewOrderButton(driver);

			try {
				testSteps.add("Step " + (++i) + " : Verify error message low stop price is displaying");
				assertTrue(instrumentPage.errorMessageLowStopPriceIsShowing(driver),
						"Verified error message <b>'LOW STOP PRICE'</b>");

				testSteps.add("Step " + (++i)
						+ " : Verify <b>Your stop price must be at least $0.05 above the market price. Please increase your stop price in order for the order to be accepted.</b> is display");
				assertTrue(instrumentPage.geterrorMessageLowStopPriceBody(driver),
						"Verified: <b>Your stop price must be at least $0.05 above the market price. Please increase your stop price in order for the order to be accepted.</b>");
			} catch (Exception e) {
				testSteps.add("Failed: You do not have enough cash.");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Instruments_NegetiveBuy", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: Instruments_NegetiveBuy " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_NegetiveBuy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_NegetiveBuy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Instruments_NegetiveBuy " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_NegetiveBuy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_NegetiveBuy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
