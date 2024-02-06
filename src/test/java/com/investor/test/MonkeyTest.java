package com.investor.test;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.DIYVestPage;
import com.investor.pages.FundTransferPage;
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.ModelStockData;
import com.investor.pages.MonkeyPageObject;
import com.investor.pages.NavigationPage;

public class MonkeyTest extends BaseClass {
	String tempSrc = "";

	@Test
	public void MonkeyTest_Home() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		HomePage homePage;
		String dashboardTitle = "Dashboard | Vested Finance";
		String transferFundsTitle = "Transfer Funds | Vested Finance";
		String ETFProvidersTitle = "ETF Providers | Vested Finance";
		String multiAssetPopupTitle = "Multi-Asset Class Portfolios";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		homePage = new HomePage(driver);
		printString("MonkeyTest_Home: " + driver.hashCode() + "", driver);
		int i = 0;
		boolean marketStatus;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-153?atlOrigin=eyJpIjoiODUxZDVlZDA2NDFhNDllZDgzZDBjMGYxYWFjMTU3ZGQiLCJwIjoiaiJ9\">QAA-153 : Web - Monkey Test Home<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-274?atlOrigin=eyJpIjoiOGY1NDVlZDFiMGE5NGIzNjgwYTljNDU5M2NiNzFhOWMiLCJwIjoiaiJ9\">QAA-274 : [Web] Verify All Info Popups<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			marketStatus = instrumentPage.isMarketClose(driver);

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Home' button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verifying 'Portfolio Overview' section");
//			// Portfolio Overview
//
//			testSteps.add("Step " + (++i) + " : Click on 'Daily Port Folio' Icon");
//			monkey.clickDailyPortFolioIcon(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Daily Port Folio' Model is displaying");
//			assertTrue(monkey.isDailyPortFolioModelCloseIconDisplaying(driver),
//					"Verified 'Daily Port Folio' Model is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Daily Port Folio' Model Close icon");
//			monkey.clickDailyPortFolioModelCloseIcon(driver);

			// Portfolio Overview Popup
			testSteps.add("Step " + (++i) + " : Click on 'Portfolio Overview' <b>'i'</b> Icon.");
			instrumentPage.clickOnPortfolioOverview_i(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Portfolio Overview'</b> page is displaying");
			assertTrue(instrumentPage.isPortfolioOverview_iPopupHeading(driver),
					"Failed : Portfolio Overview Popup title is not displayed");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Portfolio Overview Popup'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Portfolio Overview popup <b>'close'</b> Icon.");
			instrumentPage.clickOnPortfolioOverview_iPopupClose(driver);

//			// Your PortFolio Popup
//			testSteps.add("Step " + (++i) + " : Click on 'Your PortFolio' <b>'i'</b> Icon.");
//			instrumentPage.clickOnYourPortFolio_i(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Your PortFolio'</b> page is displaying");
//			assertTrue(instrumentPage.isYourPortFolio_iPopupHeading(driver),
//					"Failed : Your PortFolio Popup title is not displaying");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'Your PortFolio Popup'</b> page is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on Your PortFolio popup <b>'close'</b> Icon.");
//			instrumentPage.clickOnYourPortFolio_iPopupClose(driver);

			// Signals Disclosure Popup
			testSteps.add("Step " + (++i) + " : Click on 'Signals Disclosure'.");
			try {
				instrumentPage.clickOnSignalsDisclosure(driver);
			}catch (Exception e) {
				getRefreshWebPage(driver);
				wait6s();
				instrumentPage.clickOnSignalsDisclosure(driver);
			}
			

			testSteps.add("Step " + (++i) + " : Verify <b>'Signals Disclosure'</b> popup is displaying");
			assertTrue(instrumentPage.isSignalsDisclosure_PopupHeading(driver),"Failed : Emerging Theme Disclosure Popup title is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Signals Disclosure Popup'</b>  is displaying");

			testSteps.add("Step " + (++i) + " : Click on Signals Disclosure popup <b>'close'</b> Icon.");
			instrumentPage.clickOnSignalsDisclosure_PopupClose(driver);
			
			
			
			// EmergingThemeDisclosure Popup
			testSteps.add("Step " + (++i) + " : Click on 'Emerging Theme Disclosure'.");
			try {
				instrumentPage.clickOnEmergingThemeDisclosure(driver);
			}catch (Exception e) {
				getRefreshWebPage(driver);
				wait6s();
				instrumentPage.clickOnEmergingThemeDisclosure(driver);
			}
			

			testSteps.add("Step " + (++i) + " : Verify <b>'Emerging Theme Disclosure'</b> page is displaying");
			assertTrue(instrumentPage.isEmergingThemesDisclosure_PopupHeading(driver),"Failed : Emerging Theme Disclosure Popup title is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Emerging Theme Disclosure Popup'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Emerging Theme Disclosure popup <b>'close'</b> Icon.");
			instrumentPage.clickOnEmergingThemesDisclosure_PopupClose(driver);

			// Recommended Disclosure Popup
			testSteps.add("Step " + (++i) + " : Click on 'Recommended Disclosure'.");
			instrumentPage.clickOnRecommedationDisclosure(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Recommended Disclosure'</b> page is displaying");
			assertTrue(instrumentPage.isRecomendationDisclosure_PopupHeading(driver), "Failed : Recommended Disclosure Popup title is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Recommended Disclosure Popup'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Recommended Disclosure popup <b>'close'</b> Icon.");
			instrumentPage.clickOnRecommendedDisclosure_PopupClose(driver);

//			// Multi Asset Class VestsPop
//			testSteps.add("Step " + (++i) + " : Click on Multi Asset Class Vests <b>'i'</b> Icon.");
//			instrumentPage.clickOnmultiAssetClassVests_i(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Multi Asset Class Vests Popup'</b> page is displaying");
//			assertEquals(instrumentPage.getmultiAssetClassVests_iPopupHeading(driver), multiAssetPopupTitle,
//					"Failed : Multi Asset Class Vests Popup title not matched");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'Multi Asset Class Vests Popup'</b> page is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on Multi Asset Class Vests popup <b>'close'</b> Icon.");
//			instrumentPage.clickOnMultiAssetClassVests_iPopupClose(driver);
//
//			// Theme Based Vests
//			testSteps.add("Step " + (++i) + " : Click on Theme Based Vests <b>'i'</b> Icon.");
//			instrumentPage.clickOnThemeBasedVests_i(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Theme Based Vests Banner'</b> is displaying");
//			assertTrue(instrumentPage.getThemeBasedVests_iPopupHeading(driver),
//					"Failed : Theme Based Vests Banner not displaying");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'Theme Based Vests Banner'</b> is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on Theme Based Vests Banner <b>'close'</b> Icon.");
//			instrumentPage.clickOnThemeBasedVests_iPopupClose(driver);

			// Next

			testSteps.add("Step " + (++i) + " : Click on 'Add Funds' Icon");
			monkey.clickAddFundsIcon(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Transfer Fund' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), transferFundsTitle,
					"Failed : 'Transfer Fund' page title not matched");
			System.out.println(loginPage.getPageTitle(driver));

			testSteps.add("Step " + (++i) + " : Click on 'Add Funds' button");
			navigationPage.clickAddFundBtn(driver);

			try {
				navigationPage.clickAddFundsGuide(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Verify 'add funds' Model is displaying");
			assertTrue(monkey.isAddFundsModelDisplaying(driver), "Verified Daily 'add funds' Model is displaying");

			
			// Next

			try {
			
				
				monkey.clickProceedWithVestedDirectBtn(driver);
				testSteps.add("Step " + (++i) + " : Click on 'Proceed with vested direct' Icon");

				testSteps.add("Step " + (++i) + " : Verify Model opened after clicking on 'Proceed with vested direct'");
				assertTrue(monkey.isProceedWithVestedDirectModelCloseIconDisplaying(driver),
						"Verified Model opened after clicking on 'Proceed with vested direct'");

				testSteps.add(
						"Step " + (++i) + " : Verify Title On Model opened after clicking on 'Proceed with vested direct'");
				assertTrue(monkey.isProceedWithVestedDirectModelTitleDisplaying(driver),
						"Verified Title On Model opened after clicking on 'Proceed with vested direct'");

				testSteps.add("Step " + (++i) + " : Click on 'Proceed With Vested Direct' model close icon");
				monkey.clickProceedWithVestedDirectModelCloseIcon(driver);

				

			}catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Click on 'Proceed with vested direct' Icon is not Displaying");
			}
			testSteps.add("Step " + (++i) + " : Click on 'Add Funds' model close icon");
			monkey.clickAddFundsModelCloseIcon(driver);
			
			
			testSteps.add("Step " + (++i) + " : Click on 'WITHDRAW FUNDS' button");
			monkey.clickWithdrawFundsButton(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify 'Amount to with draw' label is displaying after clicking on 'WITHDRAW FUNDS' button");
			assertTrue(monkey.isAmountToWithdrawLableDisplaying(driver),
					"'Amount to with draw' label is displaying after clicking on 'WITHDRAW FUNDS' button");

			testSteps.add("Step " + (++i) + " : click 'Home' button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			// Verify Move All Stocks
			if (marketStatus == true) {
				testSteps.add("Step " + (++i) + " : Scroll to Top Movers");
				instrumentPage.exploreTopMovers(driver);

				testSteps.add("Step " + (++i) + " : Click on Show All button");
				instrumentPage.clickOnTopMoversShowAllButton(driver);
				wait3s();
				testSteps.add("Step " + (++i) + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);

				testSteps.add("Step " + (++i) + " : Go to instrument details page");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

				testSteps.add("Step " + (++i) + " : Verify instrument details page load successfully");
				assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
						"Verified Instrument details page load successfully");

				testSteps.add("Step " + (++i) + " : Click on Overview Button");
				instrumentPage.clickOnOverviewButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Over View Page' is displaying");
				assertTrue(instrumentPage.verifyOverviewPageIsShowing(driver),
						"Verified 'Over View' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Returns Button");
				instrumentPage.clickOnReturnsButton(driver);

				testSteps.add("Step " + (++i) + " : Verified 'Returns Page' is displaying");
				assertTrue(instrumentPage.verifyReturnsPageIsShowing(driver), "Verified 'Returns' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Fundamental Data Button");
				instrumentPage.clickOnFundamentalDataButton(driver);

				testSteps.add("Step " + (++i) + " : Verify Verified 'Returns Page' is displaying");
				assertTrue(instrumentPage.verifyFundamentalDataPageIsShowing(driver),
						"Verified 'Fundamental Data' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Balance Sheet Button");
				instrumentPage.clickOnBalanceSheetButton(driver);

				testSteps.add("Step " + (++i) + " : Verified 'Balance Sheet' Page is displaying");
				assertTrue(instrumentPage.verifyBalanceSheetPageIsShowing(driver),
						"Verified 'Balance Sheet' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Cash Flow Button");
				instrumentPage.clickOnCashFlowButton(driver);

				testSteps.add("Step " + (++i) + " : Verify Verified 'Cash Flow' Page is displaying");
				assertTrue(instrumentPage.verifyCashFlowPageIsShowing(driver),
						"Verified 'Cash Flow' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Key Ratios Button");
				instrumentPage.clickOnKeyRatiosButton(driver);

				testSteps.add("Step " + (++i) + " : Verified 'Key Ratios' Page is displaying");
				assertTrue(instrumentPage.verifyKeyRatiosPageIsShowing(driver),
						"Verified 'Key Ratios' Page is displaying");

				// verify Buy Page
				testSteps.add("Step " + (++i) + " : Click on 'Buy' Button");
				instrumentPage.clickOnBuyButton(driver);

				testSteps.add("Step " + (++i) + " : Verify Buy Instrument Page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified Buy Instrument Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Back button Navigate to Previous page");
				instrumentPage.goBack(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Create Recurring Investment' Button");
				instrumentPage.clickOncreateRecurringInvestmentButton(driver);

				try {
					testSteps.add("Step " + (++i) + " : Click on <b>'Start New Recurring Investment'</b> button");
					homePage.clickOnStartNewRecurrignInvestmentButton(driver);

				} catch (Exception e) {
				}

				testSteps.add("Step " + (++i) + " : Verify 'Create Recurring Investment' Page is displaying");
				assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
						"Verified 'Create Recurring Investment' Page is displaying");

				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				// Verify Signals Stocks

				testSteps.add("Step " + (++i) + " : Scroll to 'Signals' Label");
				instrumentPage.exploreSignalsLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on Signal First Option");
				instrumentPage.clickOnFirstSignalOption(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Signals' Page  is displaying");
				assertTrue(instrumentPage.verifySignalsPageisShowing(driver), "'Signals' Page is not displaying");
				testSteps.add("Step " + (++i) + " : Verified: 'Signals' Page  is displaying");

				// Verify OTC
				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to 'OTC' Label");
				instrumentPage.exploreOTCLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on OTC Show All button");
				instrumentPage.clickOnOTCShowAllButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'OTC' Page is displaying");
				assertTrue(instrumentPage.isOtcPageDisplaying(driver), "'Sectors' Page is not displaying");

				// Verify Sectors Stocks
				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to 'Sectors' Label");
				instrumentPage.exploreSectorsLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on Sectors Show All button");
				instrumentPage.clickOnSectorsShowAllButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Sectors' Page is displaying");
				assertTrue(instrumentPage.isSectorsPageDisplaying(driver), "Verified 'Sectors' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Communication Services button");
				instrumentPage.clickOnCommunicationServicesButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Stock Names' Page  is displaying");
				assertTrue(instrumentPage.verifyStockNamesShowing(driver), "Verified 'Stock Names' Page is displaying");

				// Verify Emerging Themes

				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to 'Emerging Theme' Label");
				instrumentPage.emergingThemesLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Emerging Themes Show All' button");
				instrumentPage.clickOnEmergingThemesShowAllButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Emerging Themes' Page is displaying");
				assertTrue(instrumentPage.isEmergingThemesShowPageDisplaying(driver),
						"Verified 'Emerging Themes Show' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on Artificial Intelligence Button");
				instrumentPage.clickOnArtificialIntelligenceButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Stock Names' Page  is displaying");
				assertTrue(instrumentPage.verifyStockNamesShowing(driver), "Verified 'Stock Names' Page is displaying");

				// Verify Geography

				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to 'Geography' Label");
				instrumentPage.geographyLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Geography Show All' button");
				instrumentPage.clickOnGeographyShowAllButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Geography' Page is displaying");
				assertTrue(instrumentPage.isGeographyPageDisplaying(driver),
						"Verified 'Emerging Themes Show' Page is displaying");

				testSteps.add("Step " + (++i) + " : Click on 'US' Button");
				instrumentPage.clickOnUSButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Stock Names' Page  is displaying");
				assertTrue(instrumentPage.verifyStockNamesShowing(driver), "Verified 'Stock Names' Page is displaying");

				// Verify ETF Providers

				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to 'ETF Providers' Label");
				instrumentPage.ETFProvidersLabel(driver);

				waitTime(5000, driver);
				testSteps.add("Step " + (++i) + " : Click on 'Fidelity' Button");
				instrumentPage.clickOnfidelityButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'ETF Providers' Page  is displaying");
				assertTrue(instrumentPage.verifyStockNamesShowing(driver),
						"Verified 'ETF Providers' Page is displaying");

				// Verify Income Focused

				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to 'Income Focused' Label");
				instrumentPage.exploreIncomeFocusedLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Bonds' Button");
				instrumentPage.clickOnBondsButton(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Stock Names' Page  is displaying");
				assertTrue(instrumentPage.verifyStockNamesShowing(driver), "Verified 'Stock Names' Page is displaying");

				// Verify Recommended

				testSteps.add("Step " + (++i) + " : click 'Home' button");
				navigationPage.clickOnHomeBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Scroll to Recommended Label");
				instrumentPage.exploreRecommendedLabel(driver);

				testSteps.add("Step " + (++i) + " : Click on 'Recommended Show All' button");
				instrumentPage.clickOnRecommendedShowAllButton(driver);

				try {
					testSteps.add("Step " + (++i) + " : Verify 'ETF Providers' Page  is displaying");
					assertTrue(instrumentPage.verifyStockNamesShowing(driver),
							"Verified 'ETF Providers' Page is displaying");

				} catch (Exception e) {
					// TODO: handle exception
				}
//			}
				testSteps.add("Step " + (++i) + " : Close the Browser");
				AddTest_IntoReport("MonkeyTest_Home", testSteps, driver);
			}
		} catch (Exception e) {
			testSteps.add("Failed: MonkeyTest_Home " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_Home") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_Home", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: MonkeyTest_Home " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_Home") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_Home", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void MonkeyTest_TransferFundsTab() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		InstrumentPage instrumentPage;
		MonkeyPageObject monkey;
		String dashboardTitle = "Dashboard | Vested Finance";
		String transferFundsTitle = "Transfer Funds | Vested Finance";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("MonkeyTest_TransferFundsTab: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-154?atlOrigin=eyJpIjoiMjA5MjExNjI5ODZjNGIyMTg1YWVkNjY3MWNiOWMzZTgiLCJwIjoiaiJ9\">QAA-154 : Web - Monkey Test TransferFundsTab<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-274?atlOrigin=eyJpIjoiOGY1NDVlZDFiMGE5NGIzNjgwYTljNDU5M2NiNzFhOWMiLCJwIjoiaiJ9\">QAA-274 : [Web] Verify All Info Popups<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Transfer' button");
			navigationPage.clickOnTransferBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Transfer Fund' page is displaying");
			assertEquals(loginPage.getPageTitle(driver), transferFundsTitle,
					"Failed : 'Transfer Fund' page title not matched");

			testSteps.add("Step " + (++i) + " : Click on 'Add Funds' button");
			navigationPage.clickAddFundBtn(driver);

			try {
				navigationPage.clickAddFundsGuide(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Verify 'add funds' Model is displaying");
			assertTrue(monkey.isAddFundsModelDisplaying(driver), "Verified Daily 'add funds' Model is displaying");

			// Next

			try {
				
				monkey.clickProceedWithVestedDirectBtn(driver);
				testSteps.add("Step " + (++i) + " : Click on 'Proceed with vested direct' Icon");
				testSteps.add("Step " + (++i) + " : Verify Model opened after clicking on 'Proceed with vested direct'");
				assertTrue(monkey.isProceedWithVestedDirectModelCloseIconDisplaying(driver),
						"Verified Model opened after clicking on 'Proceed with vested direct'");

				testSteps.add(
						"Step " + (++i) + " : Verify Title On Model opened after clicking on 'Proceed with vested direct'");
				assertTrue(monkey.isProceedWithVestedDirectModelTitleDisplaying(driver),
						"Verified Title On Model opened after clicking on 'Proceed with vested direct'");

				testSteps.add("Step " + (++i) + " : Click on 'Proceed With Vested Direct' model close icon");
				monkey.clickProceedWithVestedDirectModelCloseIcon(driver);

			}catch (Exception e) {
				testSteps.add("Step " + (++i) + " :'Proceed with vested direct' is not displaying");
			}
			
			testSteps.add("Step " + (++i) + " : Click on 'Add Funds' model close icon");
			monkey.clickAddFundsModelCloseIcon(driver);

			testSteps.add("Step " + (++i) + " : Click on 'WITHDRAW FUNDS' button");
			monkey.clickWithdrawFundsButton(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify 'Amount to with draw' label is displaying after clicking on 'WITHDRAW FUNDS' button");
			assertTrue(monkey.isAmountToWithdrawLableDisplaying(driver),
					"'Amount to with draw' label is displaying after clicking on 'WITHDRAW FUNDS' button");

			testSteps.add("Step " + (++i) + " : click 'Home' button");
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_TransferFundsTab", testSteps, driver);

		} catch (Exception e) {
			e.printStackTrace();
			testSteps.add("Failed: MonkeyTest_TransferFundsTab " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_TransferFundsTab") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_TransferFundsTab", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			e.printStackTrace();
			testSteps.add("Failed: MonkeyTest_TransferFundsTab " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_TransferFundsTab") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_TransferFundsTab", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void MonkeyTest_VDTab() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		FundTransferPage fundTransferPage;
		MonkeyPageObject monkey;
		String dashboardTitle = "Dashboard | Vested Finance";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		fundTransferPage = new FundTransferPage(driver);
		printString("MonkeyTest_VDTab: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String password = dataArr[rowIndex][2].toString();
		String pinCode = dataArr[rowIndex][3].toString();
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-155?atlOrigin=eyJpIjoiMDM5MjMxNGQxMzY3NDQ3MDhmNzVmMmNjZDBiYTFmNmEiLCJwIjoiaiJ9\">QAA-155 : Web - Monkey Test VDTab<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-274?atlOrigin=eyJpIjoiOGY1NDVlZDFiMGE5NGIzNjgwYTljNDU5M2NiNzFhOWMiLCJwIjoiaiJ9\">QAA-274 : [Web] Verify All Info Popups<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Transfer' button");
			navigationPage.clickOnTransferBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Add Funds' button");
			navigationPage.clickAddFundBtn(driver);

			try {
				waitfor3sec();

				assertTrue(fundTransferPage.isAddFundModalMessage(driver),
						"Verified <b>'Add Funds'</b> popup Heading is showing");
				testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
			} catch (Exception e) {
				testSteps.add("Step " + (++i)
						+ " : Verify <b>'How US fund transfers work with Vested?'</b> message is showing");
				waitTime(2500);
				assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
						"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Modal'</b>");
			fundTransferPage.closeModal(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Proceed with vested direct' Icon");
			monkey.clickProceedWithVestedDirectBtn(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Visted Direct' Page is displaying");
			assertTrue(monkey.isVistedDirectPageDisplaying(driver), "Verified 'Visted Direct' Page is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Open Vested Direct Account' button");
			monkey.clickOpenVestedDirectAccountButton(driver);
			try {

				try {
					testSteps.add("Step " + (++i)
							+ " : Verify 'Open Vested Direct Account Not Available' Page is displaying");
					assertTrue(monkey.isopenVestedDirectAccountNotAvailablePageDisplaying(driver),
							"Verified 'Open Vested Direct Account Not Available' Page is displaying");

					testSteps.add("Step " + (++i) + " : Click on 'Open Vested Direct Account' button");
					monkey.clickOnPopupProceedButton(driver);

					List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(browserTabs.get(1));
					testSteps.add("Step " + (++i) + " : Verify 'Open Vested Direct Account' Page is displaying");
					assertTrue(monkey.isVerificationPageDisplaying(driver),
							"Verified 'Full KYC Verification' Page is displaying");

					testSteps.add("Step " + (++i) + " : Click on 'Start' button");
					monkey.clickOnStartButton(driver);

					testSteps.add("Step " + (++i) + " : Verify 'Open Vested Direct Account' Page is displaying");
					assertTrue(monkey.isKYCPageDisplaying(driver), "Verified 'KYC' Page is displaying");

					testSteps.add("Step " + (++i) + " : Close the Browser Tab");
					driver.close();
					navigationPage.waitTillTenSeconds(driver);
					driver.switchTo().window(browserTabs.get(0));

					testSteps.add("Step " + (++i) + " : Verify 'Open Vested Direct Account' Page is displaying");
					assertTrue(monkey.isOpenVestedDirectAccountPageDisplaying(driver),
							"Verified 'Open Vested Direct Account' Page is displaying");

					testSteps.add("Step " + (++i) + " : Click on 'Verify your C-KYC' button");
					monkey.clickOnverifyYourKycButton(driver);

					testSteps.add("Step " + (++i) + " : Verify 'Open Vested Direct Account' Page is displaying");
					assertTrue(monkey.isProceedPopupBtnDisplaying(driver),
							"Verified 'Proceed Popup' button is displaying");

				} catch (Exception e) {
					testSteps.add(
							"Step " + (++i) + " : Verify 'Open Vested Direct Account  Offline' Page is displaying");
					assertTrue(monkey.isOpenVestedDirectAccountPageOfflineDisplaying(driver),
							"Verified 'Open Vested Direct Account Offline' Page is displaying");

					testSteps.add("Step " + (++i) + " : Click on 'Go To Dashboard' button");
					monkey.clickGoToDashboardButton(driver);

					waitTime(5000, driver);
					testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying");
					assertEquals(loginPage.getPageTitle(driver), dashboardTitle,
							"Failed : Dashboard title not matched");
				}

			} catch (Exception e) {

			}
			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_VDTab", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: MonkeyTest_VDTab " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_VDTab") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_VDTab", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: MonkeyTest_VDTab " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_VDTab") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_VDTab", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void MonkeyTest_DIYVestTab() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		DIYVestPage diyVestPage;
		String dashboardTitle = "Dashboard | Vested Finance";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("MonkeyTest_DIYVestTab: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-156?atlOrigin=eyJpIjoiMDZjN2U4NWY1OTY4NDJkMTlmMzA2MmFiNTc5ZDk2ZjEiLCJwIjoiaiJ9\">QAA-156 : Web - Monkey Test DIYVestTab<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-274?atlOrigin=eyJpIjoiOGY1NDVlZDFiMGE5NGIzNjgwYTljNDU5M2NiNzFhOWMiLCJwIjoiaiJ9\">QAA-274 : [Web] Verify All Info Popups<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'DIY Vest' button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Visted Direct' Page is displaying");
			assertTrue(monkey.isdiyVestPageDisplaying(driver), "Verified 'Visted Direct' Page is displaying");

			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOncreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			diyVestPage.selectStocks(1, driver);
			testSteps.add("Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button is enable: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			diyVestPage.selectStocks(2, driver);
			testSteps.add(
					"Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with more than one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button is enable: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
			diyVestPage.clickOnAddedStocksButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Heading Popup'</b> is visible");
			assertTrue(diyVestPage.isNotePopupHeadingVisible(driver),
					"Failed: Verify the <b>'Note Heading Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : Verified the <b>'Note Heading Popup'</b> is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Description Popup'</b> is visible");
			assertTrue(diyVestPage.isNotePopupDescriptionVisible(driver),
					"Failed: Verify the <b>'Note Description Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : Verified the <b>'Note Description Popup'</b> is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Don't Show Again Popup'</b> is visible");
			assertTrue(diyVestPage.isNotePopupDontShowVisible(driver),
					"Failed: Verify the <b>'Note Don't Show Again Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : Verified the <b>'Note Don't Show Again Popup'</b> is visible");
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_DIYVestTab", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: MonkeyTest_DIYVestTab " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_DIYVestTab") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_DIYVestTab", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: MonkeyTest_DIYVestTab " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_DIYVestTab") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_DIYVestTab", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void MonkeyTest_ProfileMenu() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		String dashboardTitle = "Dashboard | Vested Finance";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("MonkeyTest_ProfileMenu: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-157?atlOrigin=eyJpIjoiNTU5OWRmNmRjNjk1NGM1N2IyNTgxZWRlY2IxY2FlOWUiLCJwIjoiaiJ9\">QAA-157 : Web - Monkey Test ProfileMenu<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-274?atlOrigin=eyJpIjoiOGY1NDVlZDFiMGE5NGIzNjgwYTljNDU5M2NiNzFhOWMiLCJwIjoiaiJ9\">QAA-274 : [Web] Verify All Info Popups<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Transactions' button");
			monkey.clickOnProfileTransactionsButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Transactions' Page is displaying");
			assertTrue(monkey.isProfileTransactionsPageDisplaying(driver),
					"Verified 'Transactions' Page is displaying");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Trade Confirmations' button");
			monkey.clickOnProfileTradeConfirmationsButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Trade Confirmations' Page is displaying");
			assertTrue(monkey.isProfileTradeConfirmationsPageDisplaying(driver),
					"Verified 'Trade Confirmations' Page is displaying");

			
			navigationPage.clickOnHomeBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			
			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Account Statements' button");
			monkey.clickOnProfileAccountStatementsButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Account Statements' Page is displaying");
			assertTrue(monkey.isProfileAccountStatementsPageDisplaying(driver),
					"Verified 'Account Statements' Page is displaying");

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Tax Documents' button");
			monkey.clickOnProfileTaxDocumentsButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Tax Documents' Page is displaying");
			assertTrue(monkey.isProfileTaxDocumentsPageDisplaying(driver),
					"Verified 'Tax Documents' Page is displaying");

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'FAQ' button");
			monkey.clickOnProfileFAQButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));

			testSteps.add("Step " + (++i) + " : Verify 'FAQ' Page is displaying");
			assertTrue(monkey.isProfileFAQPageDisplaying(driver), "Verified 'FAQ' Page is displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser Tab");
			driver.close();
			navigationPage.waitTillTenSeconds(driver);
			driver.switchTo().window(browserTabs.get(0));

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Referral' button");
			navigationPage.clickOnReferalBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Referral' Page is displaying");
			assertTrue(monkey.isProfileReferralPageDisplaying(driver), "Verified 'Referral' Page is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'FAQ'");
			monkey.clickOnFAQLink(driver);

			testSteps.add("Step " + (++i) + " : Verify 'FAQ Popup Heading' On Referel Page is displaying");
			assertTrue(monkey.isProfileReferralPageFAQPopupHeadingDisplaying(driver),
					"Failed: Verify 'FAQ Popup Heading' On Referel Page is displaying");
			testSteps.add("Step " + (++i) + " : Verified: 'FAQ Popup Heading' On Referel Page is displaying");

//			testSteps.add("Step " + (++i) + " : Verify 'FAQ Popup Q1' On Referel Page is displaying");
//			assertTrue(monkey.isProfileReferralPageFAQPopupQ1Displaying(driver),"Failed: Verify 'FAQ Popup Q1' On Referel Page is displaying");
//			testSteps.add("Step " + (++i) + " : Verified: 'FAQ Popup Q1' On Referel Page is displaying");
//			
//			testSteps.add("Step " + (++i) + " : Verify 'FAQ Popup Q2' On Referel Page is displaying");
//			assertTrue(monkey.isProfileReferralPageFAQPopupQ2Displaying(driver),"Failed: Verify 'FAQ Popup Q2' On Referel Page is displaying");
//			testSteps.add("Step " + (++i) + " : Verified: 'FAQ Popup Q2' On Referel Page is displaying");
//			
//			testSteps.add("Step " + (++i) + " : Verify 'FAQ Popup Q3' On Referel Page is displaying");
//			assertTrue(monkey.isProfileReferralPageFAQPopupQ3Displaying(driver),"Failed: Verify 'FAQ Popup Q3' On Referel Page is displaying");
//			testSteps.add("Step " + (++i) + " : Verified: 'FAQ Popup Q3' On Referel Page is displaying");
//			
//			testSteps.add("Step " + (++i) + " : Verify 'FAQ Popup Q4' On Referel Page is displaying");
//			assertTrue(monkey.isProfileReferralPageFAQPopupQ4Displaying(driver),"Failed: Verify 'FAQ Popup Q4' On Referel Page is displaying");
//			testSteps.add("Step " + (++i) + " : Verified: 'FAQ Popup Q4' On Referel Page is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'FAQ Close Icon'");
			monkey.clickOnFAQPopupCloseIcon(driver);

			try {
				waitTime(5000, driver);
				testSteps.add("Step " + (++i) + " : click 'Profile' button");
				navigationPage.clickOnProfileBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : click 'Manage Plan' button");
				monkey.clickOnProfileManagePlanButton(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Verify 'Manage Plan' Page is displaying");
				assertTrue(monkey.isProfileManagePlanPageDisplaying(driver),
						"Verified 'Manage Plan' Page is displaying");
			} catch (Exception e) {
				printString("User is not premium", driver);
			}

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Investment Profile' button");
			monkey.clickOnProfileInvestmentProfileButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Investment Profile' Page is displaying");
			assertTrue(monkey.isProfileInvestmentProfilePageDisplaying(driver),
					"Verified 'Investment Profile' Page is displaying");

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Recurring Investments' button");
			monkey.clickOnProfileRecurringInvestmentsButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Recurring Investments' Page is displaying");
			assertTrue(monkey.isProfileRecurringInvestmentsPageDisplaying(driver),
					"Verified 'Recurring Investments' Page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Back button Navigate to Previous page");
			instrumentPage.goBack(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'Security' button");
			monkey.clickOnProfileSecurityButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Security' Page is displaying");
			assertTrue(monkey.isProfileSecurityPageDisplaying(driver), "Verified 'Security' Page is displaying");

			testSteps.add("Step " + (++i) + " : click 'Change Password' button");
			monkey.clickOnChangePasswordButton(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Change Password' Page is displaying");
			assertTrue(monkey.isSecurityChangePasswordPageDisplaying(driver),
					"Verified 'Change Password' Page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Back button Navigate to Previous page");
			instrumentPage.goBack(driver);

			testSteps.add("Step " + (++i) + " : click 'Change Security Pin' button");
			monkey.clickOnChangeSecurityPinButton(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Change Security Pin' Page is displaying");
			assertTrue(monkey.isChangeSecurityPinPageDisplaying(driver),
					"Verified 'Change Security Pin' Page is displaying");

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'LogOut' button");
			monkey.clickOnProfileLogOutButton(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Welcome Back' Page is displaying");
			assertTrue(monkey.isProfileLogOutWelcomeBackPageDisplaying(driver),
					"Verified 'Welcome Back' Page is displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_ProfileMenu", testSteps, driver);

		} catch (Exception e) {
			e.printStackTrace();
			testSteps.add("Failed: MonkeyTest_ProfileMenu " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_ProfileMenu") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_ProfileMenu", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			e.printStackTrace();
			testSteps.add("Failed: MonkeyTest_ProfileMenu " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_ProfileMenu") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_ProfileMenu", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

//	@Test
	public void MonkeyTest_Referral() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		String dashboardTitle = "Dashboard | Vested Finance";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("MonkeyTest_Referral: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-516?atlOrigin=eyJpIjoiMjJlYWM2MmVmOGJlNDIwY2IxZDE1OTE2YjI3ODk1ZTEiLCJwIjoiaiJ9\">QAA-516 : [Web] - MonketTest_Referral<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Referral' button");
			navigationPage.clickOnReferalBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Referral' Page is displaying");
			assertTrue(monkey.isProfileReferralPageDisplaying(driver), "Verified 'Referral' Page is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Copy Link'");
			monkey.clickOnCopyLink(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Whatsapp Link'");
			monkey.clickOnWhatappLink(driver);
			switchTab(1, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Whatsapp Page' is displaying");
			assertTrue(getPageUrl(driver).contains("whatsapp"), "Failed: 'Whatsapp Page' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: 'Whatsapp Page' is displaying");
			switchTab(0, driver);
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on 'Facebook Link'");
			monkey.clickOnFacebookLink(driver);
			switchTab(1, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Facebook Page' is displaying");
			assertTrue(getPageUrl(driver).contains("facebook"), "Failed: 'Facebook Page' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: 'Facebook Page' is displaying");
			switchTab(0, driver);
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on 'LinkedIn Link'");
			monkey.clickOnLinkedINLink(driver);
			switchTab(1, driver);
			testSteps.add("Step " + (++i) + " : Verify 'LinkedIn Page' is displaying");
			assertTrue(getPageUrl(driver).contains("linkedin"), "Failed: 'LinkedIn Page' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: 'LinkedIn Page' is displaying");
			switchTab(0, driver);
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on 'Twitter Link'");
			monkey.clickOnTwitterLink(driver);
			switchTab(1, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Twitter Page' is displaying");
			assertTrue(getPageUrl(driver).contains("twitter"), "Failed: 'Twitter Page' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: 'Twitter Page' is displaying");
			switchTab(0, driver);
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on 'Gmail Link'");
			monkey.clickOnGmailLink(driver);
			switchTab(1, driver);
			testSteps.add("Step " + (++i) + " : Verify 'Gmail Page' is displaying");
			assertTrue(getTitle(driver).contains("Gmail"), "Failed: 'Gmail Page' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: 'Gmail Page' is displaying");
			switchTab(0, driver);
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_Referral", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: MonkeyTest_Referral " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_Referral") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_Referral", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: MonkeyTest_Referral" + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_Referral") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_Referral", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void B2B_User_Menu_Verification() {

		LoginPage lp;

		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		Object[][] data;
		if (PropertiesReader.getPropertyValue("production").toLowerCase().equalsIgnoreCase("yes")) {
			data = getData("LoginTestData_MultipleB2BUsers", "Prod Non-SSO Credentials", driver);
		} else {
			if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {

				data = getData("LoginTestData_MultipleB2BUsers", "PreProd Non-SSO Credentials", driver);

			} else {
				data = getData("LoginTestData_MultipleB2BUsers", "Non-SSO Credentials", driver);
			}
		}

		String appPassword = data[0][2].toString();

		driver = initConfiguration();
		lp = new LoginPage(driver);
		NavigationPage navigationPage = new NavigationPage(driver);
		MonkeyPageObject monkey = new MonkeyPageObject(driver);
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-250\">QAA-250 : Verify the menu options for B2B Users<a/>");

		String url = "";
		String userName = "";
		String email = "";
		String pass = "";
		String pinCode = "";
		int step = 1;
		try {
			for (int x = 0; x < data.length; x++) {
				try {
					Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
					url = data[x][3].toString();
					userName = data[x][1].toString();
					email = data[x][4].toString();
					pass = data[x][5].toString();
					pinCode = dataArr[rowIndex][3].toString();
					printString(url, driver);

					testSteps.add("<b>Verify Menu options for User : '" + userName + "' </b>");
					testSteps.add("Step " + step + " : Visit app url : " + url);
					navigateToURL(url, driver);
					step++;

					testSteps.add("Step " + step + " : Enter app Password : " + appPassword);
					lp.enterB2BWebPassword(appPassword, driver);
					step++;

					testSteps.add("Step " + step + " : Click on submit");
					lp.clickOnSubmitButton(driver);
					step++;

					testSteps.add("Step " + step + " : Click on Continue Button");
					lp.clickOnContinueButton(driver);
					step++;

					testSteps.add("Step " + step + " : Click on Login Page Button");
					lp.clickOnLoginPageButton(driver);
					step++;

					testSteps.add("Step " + step + " : Click on Login with Email");
					lp.clickOnloginWithEmail(driver);
					step++;

					testSteps.add("Step " + step + " : Enter Email Address : " + email);
					lp.enterB2BUserEmailAddress(email, driver);
					step++;

					testSteps.add("Step " + step + " : Enter Password : " + pass);
					lp.enterB2BUserPassword(pass, driver);
					step++;

					testSteps.add("Step " + step + " : Click on Login Button");
					lp.clickOnLoginButton(driver);
					step++;

					try {

						lp.enterPinCode(PropertiesReader.getPropertyValue(env + "_" + "Pin"), driver);
						testSteps.add("Step " + (++step) + " : Enter Pin Code : "
								+ PropertiesReader.getPropertyValue(env + "_" + "Pin"));

						testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
						lp.clickOnContinueButton(driver);
					} catch (Exception e) {
						testSteps.add("Step " + (++step) + ": No Pin Required For the User");
					}

					testSteps.add("Step  " + step + "  : Click on 'Next' Button");
					lp.clickOnBtnNext(driver);
					step++;

					testSteps.add("Step  " + step + "  : Click on 'Ok Got It' Button");
					lp.clickOnBtnOkGotIt(driver);
					step++;

					testSteps.add("Step " + step + " : Verify Dashboard is display");
					try {
						assertTrue(lp.isDashBoardDisplay(driver),
								"Failed to Verify '" + userName + "' Dashboard is displayed");
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					} catch (Exception e) {
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

					}

					testSteps.add("Step " + (++step) + " : Verify 'Home' menu button is enabled");
					assertTrue(monkey.isHomeMenuEnabled(driver), "Verified 'Home' menu button is enabled");

					testSteps.add("Step " + (++step) + " : Verify 'Transfer' menu button is enabled");
					assertTrue(monkey.isTransferMenuEnabled(driver), "Verified 'Transfer' menu button is enabled");

					testSteps.add("Step " + (++step) + " : Verify 'Transfer' menu button is enabled");
					assertTrue(monkey.isTransferMenuEnabled(driver), "Verified 'Transfer' menu button is enabled");

					testSteps.add("Step " + (++step) + " : Verify 'DIY Vest' menu button is enabled");
					assertTrue(monkey.isDIYVestMenuEnabled(driver), "Verified 'DIY Vest' menu button is enabled");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);
					navigationPage.waitTillTenSeconds(driver);

					testSteps.add("Step " + (++step) + " : click 'Transactions' button");
					monkey.clickOnProfileTransactionsButton(driver);

					testSteps.add("Step " + (++step) + " : Verify 'Transactions' button is displaying");
					assertTrue(driver.getTitle().contains("History"), "Verified 'Transactions' Page is displaying");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);

					waitTime(1000, driver);
					testSteps.add("Step " + (++step) + " : Verify 'Trade Confirmations' button is enabled");
					assertTrue(monkey.isProfileTradeConfirmationsMenuEnabled(driver),
							"Verified 'Trade Confirmations' button is enabled");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);

					if (monkey.isProfileTaxDocumentsMenuIsEnabled(driver)) {
						testSteps.add("Step " + (++step) + " : 'Tax Documents' button is found");
					} else {
						testSteps.add("Step " + (++step) + " : 'Tax Documents' button is not found");
					}

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);
					testSteps.add("Step " + (++step) + " : Verify 'Account Statements' button is enabled");
					assertTrue(monkey.isProfileAccountStatementsMenuIsEnabled(driver),
							"Verified 'Account Statements' button is enabled");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);
					testSteps.add("Step " + (++step) + " : Verify 'FAQ' button is enabled");
					assertTrue(monkey.isProfileFAQButtonEnabled(driver), "Verified 'FAQ' button is enabled");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);
					testSteps.add("Step " + (++step) + " : Verify 'Referral' button is enabled");
					assertTrue(monkey.isProfileReferralButtonEnabled(driver), "Verified 'Referral' button is enabled");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);
					testSteps.add("Step " + (++step) + " : Verify 'Security' button is enabled");
					assertTrue(monkey.isProfileSecurityButtonEnabled(driver), "Verified 'Security' button is enabled");

					testSteps.add("Step " + (++step) + " : click 'Profile' button");
					navigationPage.clickOnProfileBtn(driver);
					testSteps.add("Step " + (++step) + " : Verify 'Logout' button is enabled");
					assertTrue(monkey.isProfileLogOutButtonEnabled(driver), "Verified 'Logout' button is enabled");

					step++;
				} catch (Exception e) {
					testSteps.add("Failed: To verify " + userName);
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
				}

			}

			testSteps.add("Step " + step + " : Close the Browser");
			AddTest_IntoReport("B2B_User_Menu_Verification", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: B2B_User_Menu_Verification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("B2B_User_Menu_Verification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("B2B_User_Menu_Verification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: B2B_User_Menu_Verification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("B2B_User_Menu_Verification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("B2B_User_Menu_Verification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void MonkeyTest_Rewards() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		String dashboardTitle = "Dashboard | Vested Finance";
		String rewardsTitle = "Rewards | Vested Finance";

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("MonkeyTest_Rewards: " + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-599?atlOrigin=eyJpIjoiZmRiZGUxMTVlODNlNDU2YTg4MDA5N2VhNjBkZjBmNTYiLCJwIjoiaiJ9\">QAA-599 : [Web] - MonketTest_Rewards<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>Dashboard</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");

			testSteps.add("Step " + (++i) + " : Verify Dashboard page is displaying after clicking on Home button");

			testSteps.add("Step " + (++i) + " : click 'Rewards' button");
			navigationPage.clickOnRewardsBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Rewards' Page is displaying");
			assertEquals(loginPage.getPageTitle(driver), rewardsTitle, "Failed : Rewards title not matched");

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Vested Point To Cash Conversion'</b> is displaying");
			assertTrue(monkey.isEarnBannerTitleVisible(driver), "'Earn Banner' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Earn Banner'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Earn'");
			monkey.clickOnEarn(driver);

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Earn Banner'</b> is displaying");
			assertTrue(monkey.isEarnBannerTitleVisible(driver), "'Earn Banner' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Earn Banner'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Earn View Detail'");
			monkey.clickOnEarnDetail(driver);

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Earn View Detail'</b> Page is displaying");
			assertTrue(monkey.isEarnDetailPageVisible(driver), "'Earn View Detail' Page is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Earn View Detail'</b> Page is displaying");

			goBack(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Redeem'");
			monkey.clickOnRedeem(driver);

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Redeem Banner'</b> is displaying");
			assertTrue(monkey.isRedeemBannerTitleVisible(driver), "'Redeem Banner' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Redeem Banner'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Redeem View Detail'");
			monkey.clickOnRedeemDetail(driver);

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Redeem View Detail'</b> Page is displaying");
			assertTrue(monkey.isRedeemDetailPageVisible(driver), "'Redeem View Detail' Page is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Redeem View Detail'</b> Page is displaying");
			goBack(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Reward Disclosure'");
			monkey.clickOnRewardsDisclosure(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			testSteps.add("Step " + (++i) + " : Verifying: <b>'Reward Disclosure'</b> Page is displaying");
			assertTrue(monkey.isRewardDisclosureVisible(driver), "'Reward Disclosure' Page is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Reward Disclosure'</b> Page is displaying");
			driver.switchTo().window(tabs2.get(0));
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on 'History'");
			monkey.clickOnHistory(driver);

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("MonkeyTest_Rewards", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: MonkeyTest_Rewards " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_Rewards") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_Rewards", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: MonkeyTest_Rewards" + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("MonkeyTest_Rewards") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("MonkeyTest_Rewards", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

}
