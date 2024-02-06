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
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.MonkeyPageObject;
import com.investor.pages.NavigationPage;

public class DashboardListVest extends BaseClass {
	private String tempSrc = "";

	@Test
	public void VerifyDashboardVestList() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		MonkeyPageObject monkey;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String multiAssetPopupTitle = "Vests";
		String NonPremiumAccount;
		String nonPremiumPassword;
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			NonPremiumAccount = "apurva.jain+production+8@vestedfinance.co";
			nonPremiumPassword = "iTestUser1!";
		} else {
			NonPremiumAccount = "vested.automation+w02@gmail.com";
			nonPremiumPassword = "#TestUser12";
		}
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		monkey = new MonkeyPageObject(driver);
		printString("VerifyDashboardVestList:" + driver.hashCode() + "", driver);
		int i = 0;

		printString(BaseClass.methodNamelist.toString());
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-128?atlOrigin=eyJpIjoiZmMxNDRlYzBlNzAzNDAxNzhiNmFkNDA0ZmIyZjJkOWEiLCJwIjoiaiJ9\">QAA-128 : [Web] Verify the dashboard list for Vests.<a/>");
			testSteps.add("<b>===========Verification For Premium Account===========</b>");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			// Vests
			testSteps.add("Step " + (++i) + " : Click on Vests <b>'i'</b> Icon.");
			instrumentPage.clickOnVests_i(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vests Popup'</b> page is displaying");
			assertEquals(instrumentPage.getVest_iPopupHeading(driver), multiAssetPopupTitle,
					"Failed : Vests Popup title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Vests Popup'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Vests popup <b>'close'</b> Icon.");
			instrumentPage.clickOnVests_iPopupClose(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vests Count more than: 10'</b>");
			assertTrue(instrumentPage.getVests_Cards() > 9);
			testSteps.add("Step " + (++i) + " : Verified: <b>Vests Count more than: 10</b>");

			testSteps.add("Step " + (++i) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click 'LogOut' button");
			monkey.clickOnProfileLogOutButton(driver);

			testSteps.add("<b>===========Verification For Non Premium Account===========</b>");
			loginPage.login(NonPremiumAccount, nonPremiumPassword, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			// Vests
			testSteps.add("Step " + (++i) + " : Click on Vests <b>'i'</b> Icon.");
			instrumentPage.clickOnVests_i(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vests Popup'</b> page is displaying");
			assertEquals(instrumentPage.getVest_iPopupHeading(driver), multiAssetPopupTitle,
					"Failed : Vests Popup title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Vests Popup'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on Vests popup <b>'close'</b> Icon.");
			instrumentPage.clickOnVests_iPopupClose(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vests Count more than: 9'</b>");
			assertTrue(instrumentPage.getVests_Cards() > 9);
			testSteps.add("Step " + (++i) + " : Verified: <b>Vests Count more than: 9</b>");
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyDashboardVestList", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyDashboardVestList " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			if (BaseClass.methodNamelist.get("VerifyDashboardVestList") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyDashboardVestList", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyDashboardVestList " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyDashboardVestList") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyDashboardVestList", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyYourPortfolioSorting() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("VerifyYourPortfolioSorting:" + driver.hashCode() + "", driver);
		Boolean MarketClose;
		ArrayList<String> yourPortfolioSymbolList = new ArrayList<String>();
		ArrayList<Double> yourPortfolioMarketPriceList = new ArrayList<Double>();
		ArrayList<Double> yourPortfolioDailyChange_USDList = new ArrayList<Double>();
		ArrayList<Double> yourPortfolioDailyChange_PerList = new ArrayList<Double>();
		ArrayList<Double> yourPortfolioCurrentValueList = new ArrayList<Double>();
		ArrayList<Double> yourPortfolioInvestment_USDList = new ArrayList<Double>();
		ArrayList<Double> yourPortfolioInvestment_PerList = new ArrayList<Double>();
		ArrayList<Double> yourPortfolioVolatilityList = new ArrayList<Double>();
		ArrayList<String> sortedStringList = new ArrayList<String>();
		ArrayList<Double> sortedDoubleList = new ArrayList<Double>();
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-286?atlOrigin=eyJpIjoiMDMzMWM0NjI4ODQ0NDlkMGJkMmMxMjJjYzAxZDVhMzkiLCJwIjoiaiJ9\">QAA-286 : Web - Verify Your Portfolio Sorting Parameters<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			MarketClose = instrumentPage.isMarketClose(driver);
			if (MarketClose) {
				
				// For Symbol
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio'");
				instrumentPage.clickOnPortfolio(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
				instrumentPage.clickOnyourPortfolioFilter(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Symbol Option' Of Your Portfolio Filter");
				instrumentPage.clickOnyourPortfolioSymbolFilter(driver);
				yourPortfolioSymbolList = instrumentPage.getYourPortfolioSymbolsList(driver);
				testSteps.add("Step " + (++i) + " : Actual Symbol List : <b>" + yourPortfolioSymbolList);
				sortedStringList = yourPortfolioSymbolList;

				printString(yourPortfolioSymbolList.toString());
				testSteps.add("Step " + (++i) + " : Expected Symbol List : <b>"
						+ instrumentPage.getSortedList(sortedStringList).toString());
				printString(instrumentPage.getSortedList(sortedStringList).toString());
				assertEquals(yourPortfolioSymbolList, instrumentPage.getSortedList(sortedStringList),
						"Portfolio Symbol List Mismatched");
				testSteps.add("Step " + (++i) + " : Symbol List Verified");

//				// For Market Price
//				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
//				instrumentPage.clickOnyourPortfolioFilter(driver);
//				testSteps.add("Step " + (++i) + " : Clicking On 'Market Price Option' Of Your Portfolio Filter");
//				instrumentPage.clickOnyourPortfolioMarketPriceFilter(driver);
//				yourPortfolioMarketPriceList = instrumentPage.getYourPortfolioMarketPriceList(driver);
//				testSteps.add("Step " + (++i) + " : Actual Market Price List : <b>" + yourPortfolioMarketPriceList);
//				sortedDoubleList = yourPortfolioMarketPriceList;
//
//				printString(yourPortfolioMarketPriceList.toString());
//				testSteps.add("Step " + (++i) + " : Expected Market Price List : <b>"
//						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
//				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
//				assertEquals(yourPortfolioMarketPriceList, instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
//						"Portfolio Market Price List Mismatched");
//				testSteps.add("Step " + (++i) + " : Market Price List Verified");
				// For Daily Change USD
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
				instrumentPage.clickOnyourPortfolioFilter(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Daily Change USD Option' Of Your Portfolio Filter");
				instrumentPage.clickOnyourPortfolioDailyChange_USDFilter(driver);
				yourPortfolioDailyChange_USDList = instrumentPage.getYourPortfolioDailyChange_USDList(driver);
				testSteps.add(
						"Step " + (++i) + " : Actual Daily Change USD List : <b>" + yourPortfolioDailyChange_USDList);
				sortedDoubleList = yourPortfolioDailyChange_USDList;

				printString(yourPortfolioDailyChange_USDList.toString());
				testSteps.add("Step " + (++i) + " : Expected Daily Change USD List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(yourPortfolioDailyChange_USDList,
						instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"Portfolio Daily Chnage USD List Mismatched");
				testSteps.add("Step " + (++i) + " : Daily Change USD List Verified");

				// For Daily Change Percentage
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
				instrumentPage.clickOnyourPortfolioFilter(driver);
				testSteps.add(
						"Step " + (++i) + " : Clicking On 'Daily Change Percentage Option' Of Your Portfolio Filter");
				instrumentPage.clickOnyourPortfolioDailyChange_PerFilter(driver);
				yourPortfolioDailyChange_PerList = instrumentPage.getYourPortfolioDailyChange_PerList(driver);
				testSteps.add("Step " + (++i) + " : Actual Daily Change Percentage List : <b>"
						+ yourPortfolioDailyChange_PerList);
				sortedDoubleList = yourPortfolioDailyChange_PerList;

				printString(yourPortfolioDailyChange_PerList.toString());
				testSteps.add("Step " + (++i) + " : Expected Daily Change Percentage List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(yourPortfolioDailyChange_PerList,
						instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"Portfolio Daily Change Percentage List Mismatched");
				testSteps.add("Step " + (++i) + " : Daily Change Percentage List Verified");

				// For current value
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
				instrumentPage.clickOnyourPortfolioFilter(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Current Value Option' Of Your Portfolio Filter");
				instrumentPage.clickOnyourPortfolioCurrentValueFilter(driver);
				yourPortfolioCurrentValueList = instrumentPage.getYourPortfolioCurrentValueList(driver);
				testSteps.add("Step " + (++i) + " : Actual Current Value List : <b>" + yourPortfolioCurrentValueList);
				sortedDoubleList = yourPortfolioCurrentValueList;

				printString(yourPortfolioCurrentValueList.toString());
				testSteps.add("Step " + (++i) + " : Expected Current Value List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(yourPortfolioCurrentValueList, instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"Portfolio Current Value List Mismatched");
				testSteps.add("Step " + (++i) + " : Current Value List Verified");

				// For Investment Return USD
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
				instrumentPage.clickOnyourPortfolioFilter(driver);
				testSteps.add(
						"Step " + (++i) + " : Clicking On 'Investment Return USD Option' Of Your Portfolio Filter");
				instrumentPage.clickOnyourPortfolioinvestmentReturn_USDFilter(driver);
				yourPortfolioInvestment_USDList = instrumentPage.getYourPortfolioInvestmentReturn_USDList(driver);
				testSteps.add("Step " + (++i) + " : Actual Investment Return USD List : <b>"
						+ yourPortfolioInvestment_USDList);
				sortedDoubleList = yourPortfolioInvestment_USDList;

				printString(yourPortfolioInvestment_USDList.toString());
				testSteps.add("Step " + (++i) + " : Expected Investment Return USD List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(yourPortfolioInvestment_USDList,
						instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"Portfolio Investment Return USD List Mismatched");
				testSteps.add("Step " + (++i) + " : Investment Return USD List Verified");

				// For Investment Return Percentage
				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
				instrumentPage.clickOnyourPortfolioFilter(driver);
				testSteps.add("Step " + (++i)
						+ " : Clicking On 'Investment Return Percentage Option' Of Your Portfolio Filter");
				instrumentPage.clickOnyourPortfolioInvestmentReturn_PerFilter(driver);
				yourPortfolioInvestment_PerList = instrumentPage.getYourPortfolioInvestmentReturn_PerList(driver);
				testSteps.add("Step " + (++i) + " : Actual Investment Return Percentage List : <b>"
						+ yourPortfolioInvestment_PerList);
				sortedDoubleList = yourPortfolioInvestment_PerList;

				printString(yourPortfolioInvestment_PerList.toString());
				testSteps.add("Step " + (++i) + " : Actual Investment Return Percentage List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(yourPortfolioInvestment_PerList,
						instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"Portfolio Investment Return Percentage List Mismatched");
				testSteps.add("Step " + (++i) + " : Investment Return Percentage List Verified");

//				// For Voilitility
//				testSteps.add("Step " + (++i) + " : Clicking On 'PortFolio' Filter");
//				instrumentPage.clickOnyourPortfolioFilter(driver);
//				testSteps.add("Step " + (++i) + " : Clicking On 'Volatility Option' Of Your Portfolio Filter");
//				instrumentPage.clickOnyourPortfolioVolatilityFilter(driver);
//				yourPortfolioVolatilityList = instrumentPage.getYourPortfolioVolatilityList(driver);
//				testSteps.add("Step " + (++i) + " : Actual Volatility List : <b>" + yourPortfolioVolatilityList);
//				sortedDoubleList = yourPortfolioVolatilityList;
//				printString(yourPortfolioVolatilityList.toString());
//				testSteps.add("Step " + (++i) + " : Expected Volatility List : <b>"
//						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
//				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
//				assertEquals(yourPortfolioVolatilityList, instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
//						"Portfolio Volatility List Mismatched");
//				testSteps.add("Step " + (++i) + " : Volatility List Verified");
			} else {
				testSteps.add("Step " + (++i) + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed to Verify: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				testSteps.add("Step " + (++i) + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyYourPortfolioSorting", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyYourPortfolioSorting " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyYourPortfolioSorting") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyYourPortfolioSorting", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyYourPortfolioSorting " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyYourPortfolioSorting") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyYourPortfolioSorting", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyWatchListSorting() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		Boolean MarketClose;
		printString("VerifywatchListSorting:" + driver.hashCode() + "", driver);
		ArrayList<String> watchListSymbolList = new ArrayList<String>();
		ArrayList<Double> watchListMarketPriceList = new ArrayList<Double>();
		ArrayList<Double> watchListDailyChange_USDList = new ArrayList<Double>();
		ArrayList<Double> watchListDailyChange_PerList = new ArrayList<Double>();
		ArrayList<String> sortedStringList = new ArrayList<String>();
		ArrayList<Double> sortedDoubleList = new ArrayList<Double>();
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-287?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-287 : Web - Verify Watchlist Sorting parameters<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			MarketClose = instrumentPage.isMarketClose(driver);
			if (MarketClose) {
				
				// For Symbol
				testSteps.add("Step " + (++i) + " : Clicking On 'Watchlist'");
				instrumentPage.clickOnWatchlist(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Watchlist' Filter");
				instrumentPage.clickOnyourWatchlistFilter(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Symbol Option' Of Your Watchlist Filter");
				instrumentPage.clickOnWatchListSymbolFilter(driver);
				watchListSymbolList = instrumentPage.getWatchListSymbolsList(driver);
				testSteps.add("Step " + (++i) + " : Actual Symbol List : <b>" + watchListSymbolList);
				sortedStringList = watchListSymbolList;

				printString(watchListSymbolList.toString());
				testSteps.add("Step " + (++i) + " : Expected Symbol List : <b>"
						+ instrumentPage.getSortedList(sortedStringList).toString());
				printString(instrumentPage.getSortedList(sortedStringList).toString());
				assertEquals(watchListSymbolList, instrumentPage.getSortedList(sortedStringList),
						"watchList Symbol List Mismatched");
				testSteps.add("Step " + (++i) + " : Symbol List Verified");

				// For Market Price
				testSteps.add("Step " + (++i) + " : Clicking On 'Watchlist'");
				instrumentPage.clickOnWatchlist(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Watchlist' Filter");
				instrumentPage.clickOnyourWatchlistFilter(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Market Price Option' Of Your Watchlist Filter");
				instrumentPage.clickOnWatchListMarketPriceFilter(driver);
				watchListMarketPriceList = instrumentPage.getWatchListMarketPriceList(driver);
				testSteps.add("Step " + (++i) + " : Actual Market Price List : <b>" + watchListMarketPriceList);
				sortedDoubleList = watchListMarketPriceList;

				printString(watchListMarketPriceList.toString());
				testSteps.add("Step " + (++i) + " : Expected Market Price List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(watchListMarketPriceList, instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"watchList Market Price List Mismatched");
				testSteps.add("Step " + (++i) + " : Market Price List Verified");

//				// For Daily Change USD
//				testSteps.add("Step " + (++i) + " : Clicking On 'watchList' Filter");
//				instrumentPage.clickOnWatchListFilter(driver);
//				testSteps.add("Step " + (++i) + " : Clicking On 'Daily Change USD Option' Of Your watchList Filter");
//				instrumentPage.clickOnWatchListDailyChange_USDFilter(driver);
//				watchListDailyChange_USDList = instrumentPage.getWatchListDailyChange_USDList(driver);
//				testSteps.add("Step " + (++i) + " : Actual Daily Change USD List : <b>" + watchListDailyChange_USDList);
//				sortedDoubleList = watchListDailyChange_USDList;
//
//				printString(watchListDailyChange_USDList.toString());
//				testSteps.add("Step " + (++i) + " : Expected Daily Change USD List : <b>"
//						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
//				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
//				assertEquals(watchListDailyChange_USDList, instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
//						"watchList Daily Chnage USD List Mismatched");
//				testSteps.add("Step " + (++i) + " : Daily Change USD List Verified");

				// For Daily Change Percentage
				testSteps.add("Step " + (++i) + " : Clicking On 'Watchlist'");
				instrumentPage.clickOnWatchlist(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Watchlist' Filter");
				instrumentPage.clickOnyourWatchlistFilter(driver);
				testSteps.add("Step " + (++i) + " : Clicking On 'Daily Change (%) Option' Of Your Watchlist Filter");
				instrumentPage.clickOnWatchListDailyChange_PerFilter(driver);
				watchListDailyChange_PerList = instrumentPage.getWatchListDailyChange_PerList(driver);
				testSteps.add("Step " + (++i) + " : Actual Daily Change Percentage List : <b>"
						+ watchListDailyChange_PerList);
				sortedDoubleList = watchListDailyChange_PerList;

				printString(watchListDailyChange_PerList.toString());
				testSteps.add("Step " + (++i) + " : Expected Daily Change Percentage List : <b>"
						+ instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				printString(instrumentPage.getReverseSortedDoubleList(sortedDoubleList).toString());
				assertEquals(watchListDailyChange_PerList, instrumentPage.getReverseSortedDoubleList(sortedDoubleList),
						"watchList Daily Change Percentage List Mismatched");
				testSteps.add("Step " + (++i) + " : Daily Change Percentage List Verified");

			} else {
				testSteps.add("Step " + (++i) + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed to Verify: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				testSteps.add("Step " + (++i) + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyWatchListSorting", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyWatchListSorting " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyWatchListSorting") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyWatchListSorting", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyWatchListSorting " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyWatchListSorting") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyWatchListSorting", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifySignalSection() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifySignalSection:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-789?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-789 : [Web] - Verify that 'Signals' section on dashboard screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

//			testSteps.add("Step " + (++i) + " : Verifying <b>'Show All'</b> option is available ");
//			assertTrue(homePage.SignalSectionShowAllDisplaying(driver), "Failed : 'Show All' option is not available");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'Show All'</b> option is available ");
//			
//			testSteps.add("Step " + (++i) + " : Verifying <b>'Show All'</b> option is clickable ");
//			assertTrue(homePage.SignalSectionShowAllClickable(driver), "Failed : 'Show All' option is not clickable");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'Show All'</b> option is clickable ");
//			
//			testSteps.add("Step " + (++i) + " : Clicking On 'Show All' Sections");
//			homePage.clickOnSignalSectionShowAll(driver);

			String[] array = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
					"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };

			for (String text : array) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'" + text + "'</b> signal is available ");
				assertTrue(homePage.SignalSectionOptionDisplaying(driver, text),
						"Failed : '" + text + "' signal is not available");
				testSteps.add("Step " + (++i) + " : Verified: <b>'" + text + "'</b> signal is available ");

				testSteps.add("Step " + (++i) + " : Verifying <b>'" + text + "'</b> signal is clickable ");
				assertTrue(homePage.SignalSectionOptionClickable(driver, text),
						"Failed : '" + text + "' signal is not clickable");
				testSteps.add("Step " + (++i) + " : Verified: <b>'" + text + "'</b> signal is clickable ");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifySignalSection", testSteps, driver);

		} catch (Exception e) {
			e.printStackTrace();
			testSteps.add("Failed: VerifySignalSection " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifySignalSection") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifySignalSection", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			e.printStackTrace();
			testSteps.add("Failed: VerifySignalSection " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifySignalSection") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifySignalSection", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyValueCreatorSignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Value Creators";
		String[] name = { "Exxon Mobil Corp", "Visa Inc. Class A", "Chevron Corp", "Mastercard Inc",
				"AstraZeneca PLC ADR", "ConocoPhillips", "Charles Schwab Corp", "Toronto Dominion Bank",
				"Automatic Data Processing Inc", "EOG Resources Inc", "PNC Financial Services Group Inc",
				"Canadian Natural Resources Ltd", "Fiserv Inc", "Lam Research Corp", "Pioneer Natural Resources Co",
				"Cheniere Energy Inc", "Nucor Corp", "BioNTech SE", "Lincoln National Corporation",
				"Cheniere Energy Partners LP" };
		String[] symbol = { "XOM", "V", "CVX", "MA", "AZN", "COP", "SCHW", "TD", "ADP", "EOG", "PNC", "CNQ", "FISV",
				"LRCX", "PXD", "LNG", "NUE", "BNTX", "LNC", "CQP" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyValueCreatorSignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-882?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-882 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Value Creators' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyValueCreatorSignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyValueCreatorSignalNameAndSymbol " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyValueCreatorSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyValueCreatorSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyValueCreatorSignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyValueCreatorSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyValueCreatorSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyValueCreatorSignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Value Creators";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyValueCreatorSignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-801?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-801 : [Web] - While user logged in with existing user, Verify the 'Value Creators' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i)
					+ " : Verifying heading <b>'Value Creators'</b> with description under it <b>'This Signal lists stocks with strong free cash flow indicators and revenue over the last 12 months'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, "Value Creators"),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextDisplaying(driver,
					"This Signal lists stocks with strong free cash flow indicators and revenue over the last 12 months"),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: heading <b>'Value Creators'</b> with description under it <b>'This Signal lists stocks with strong free cash flow indicators and revenue over the last 12 months'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyValueCreatorSignalDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps
					.add("Failed: VerifyValueCreatorSignalDetailScreen " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyValueCreatorSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyValueCreatorSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyValueCreatorSignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyValueCreatorSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyValueCreatorSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyBullishRSISignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Bullish RSI";
		String description = "This Signal is based on the relative strength index (RSI) technical indicator. It employs filters that screen for stocks where the 14-day RSI crosses over 30, indicating a bullish pattern for the stock price";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyBullishRSISignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-810?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-810 : [Web] - While user logged in with existing user, Verify the 'Bullish RSI' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			wait6s();
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i) + " : Verifying heading <b>'Bullish RSI'</b> with description under it <b>'"
					+ description + "'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, "Bullish RSI"),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextDisplaying(driver, description),
					"Failed : '" + description + "' description is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: heading <b>'Bullish RSI'</b> with description under it <b>'"
					+ description + "'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyBullishRSISignalDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyBullishRSISignalDetailScreen " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyBullishRSISignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBullishRSISignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyBullishRSISignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyBullishRSISignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBullishRSISignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyCoffeeCanInvestingSignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Coffee Can Investing";
		String description = "The Coffee Can Investing approach refers to “buy and forget” for investing in shares of companies that have performed consistently and can deliver value to investors over a longer term";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		String signalWarning = "Upgrade your subscription to view all stocks for this Signal";
		String goPremiumButton = "Go Premium";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyCoffeeCanInvestingSignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-807?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-807 : [Web] - While user logged in with existing user, Verify the 'Coffee Can Investing' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			wait6s();
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i) + " : Verifying heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, signalType), "Failed : '" + signalType
					+ "' Signals heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextContainsDisplaying(driver, "The Coffee Can Investing approach refers to"),
					"Failed : '" + description + "' description is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

//			testSteps.add("Step " + (++i) + " : Verifying <b>'"+signalWarning+"'</b> text is available");
//			assertTrue(homePage.isTextDisplaying(driver,signalWarning), "Failed : <b>'"+signalWarning+"'</b> text is available");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'"+signalWarning+"'</b> text is available");
//			
//			testSteps.add("Step " + (++i) + " : Verifying <b>'"+goPremiumButton+"'</b> button is available");
//			assertTrue(homePage.isButtonDisplaying(driver,goPremiumButton), "Failed : <b>'"+goPremiumButton+"'</b> button is available");
//			testSteps.add("Step " + (++i) + " : Verified: <b>'"+goPremiumButton+"'</b> button is available");

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyCoffeeCanInvestingSignalDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyCoffeeCanInvestingSignalDetailScreen " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyCoffeeCanInvestingSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyCoffeeCanInvestingSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: VerifyCoffeeCanInvestingSignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyCoffeeCanInvestingSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyCoffeeCanInvestingSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyIncomeGeneratorsSignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Income Generators";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		String description = "This Signal lists companies with high dividend yields and strong free cash flow to support steady dividend payments";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyIncomeGeneratorsSignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-804?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-804 : [Web] - While user logged in with existing user, Verify the 'Income Generators' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i) + " : Verifying heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, signalType),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextDisplaying(driver, description),
					"Failed : '" + description + "' Description is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyIncomeGeneratorsSignalDetailScreen", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: VerifyIncomeGeneratorsSignalDetailScreen " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyIncomeGeneratorsSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyIncomeGeneratorsSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps
					.add("Failed: VerifyIncomeGeneratorsSignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyIncomeGeneratorsSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyIncomeGeneratorsSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyRisingStarsSignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Rising Stars";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		String description = "This Signal provides you with a list of Small and Mid Cap companies that have good fundamentals and growth";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyRisingStarsSignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-813?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-813 : [Web] - While user logged in with existing user, Verify the 'Rising Stars' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			wait4s();
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i) + " : Verifying heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, signalType),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextDisplaying(driver, description),
					"Failed : '" + description + "' Description is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyRisingStarsSignalDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyRisingStarsSignalDetailScreen " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyRisingStarsSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyRisingStarsSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyRisingStarsSignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyRisingStarsSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyRisingStarsSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyBuffetGrahamFormulaSignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Buffet-Graham Formula";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		String description = "The Buffet-Graham Formula is used to identify fundamentally strong companies that have good earning potential and are available at a good buying price";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyBuffetGrahamFormulaSignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-816?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-816 : [Web] - While user logged in with existing user, Verify the 'Buffet-Graham Formula' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			wait4s();
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i) + " : Verifying heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, signalType),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextDisplaying(driver, description),
					"Failed : '" + description + "' Description is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyBuffetGrahamFormulaSignalDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyBuffetGrahamFormulaSignalDetailScreen " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyBuffetGrahamFormulaSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBuffetGrahamFormulaSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: VerifyBuffetGrahamFormulaSignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyBuffetGrahamFormulaSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBuffetGrahamFormulaSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyGoldenCrossoverSignalDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Golden Crossover";
		String[] signalTypes = { "Value Creators", "Income Generators", "Coffee Can Investing", "Bullish RSI",
				"Rising Stars", "Buffet-Graham Formula", "Golden Crossover" };
		String[] columnLabel = { "Name", "Price", "Daily Change", "P/E Ratio", "Market Cap" };
		String description = "A Golden Crossover is a bullish technical indicator. This Signal screens for companies whose stock price has formed a golden cross pattern";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyGoldenCrossoverSignalDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-819?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-819 : [Web] - While user logged in with existing user, Verify the 'Golden Crossover' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			wait4s();
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			testSteps.add("Step " + (++i) + " : Verifying heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");
			assertTrue(homePage.isTextDisplaying(driver, signalType),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			assertTrue(homePage.isTextDisplaying(driver, description),
					"Failed : '" + description + "' Description is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: heading <b>'" + signalType
					+ "'</b> with description under it <b>'" + description + "'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is available");
			assertTrue(homePage.isTextDisplaying(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is available");

			testSteps.add("Step " + (++i) + " : Verifying <b>'LEARN MORE'</b> button is clickable");
			assertTrue(homePage.isButtonClickable(driver, "Learn More"),
					"Failed : <b>'LEARN MORE'</b> button is clickable");
			testSteps.add("Step " + (++i) + " : Verified: <b>'LEARN MORE'</b> button is clickable");

			for (String type : signalTypes) {
				testSteps.add(
						"Step " + (++i) + " : Verifying <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				assertTrue(homePage.isSignalTypeOnLeftSideDisplaying(driver, type),
						"Failed : <b>'" + type + "'</b> Signal type is Displaying On Left Side");
				testSteps.add(
						"Step " + (++i) + " : Verified: <b>'" + type + "'</b> Signal type is Displaying On Left Side");
			}

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyGoldenCrossoverSignalDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyGoldenCrossoverSignalDetailScreen " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyGoldenCrossoverSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyGoldenCrossoverSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyGoldenCrossoverSignalDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyGoldenCrossoverSignalDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyGoldenCrossoverSignalDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyOTCDetailScreen() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String[] columnLabel = { "Name", "Symbol", "Price", "Daily Change", "P/E Ratio", "Market Cap", "Watchlist" };
		String pageTitle = "Explore 1,000+ US Stocks & ETFs.";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyOTCDetailScreen:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-859?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-859 : [Web] - While user logged in with existing user, Verify the 'OTC' details screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			wait4s();
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'OTC'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(instrumentPage.isExploreOTCLabelDisplaying(driver),
					"Failed : 'OTC' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'OTC'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'OTC Show All'</b>");
			instrumentPage.clickOnOTCShowAllButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying <b>'OTC'</b> Page is displaying");
			assertTrue(instrumentPage.isOtcPageDisplaying(driver), "Failed : 'OTC' page is displaying");
			testSteps.add("Step " + (++i) + " : Verified: <b>'OTC'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Verifying <b>'" + pageTitle + "'</b> heading is available");
			assertTrue(homePage.isTextDisplaying(driver, pageTitle),
					"Failed : '" + pageTitle + "' heading is available");
			testSteps.add("Step " + (++i) + " : Verified: <b>'" + pageTitle + "'</b> heading is available");

			for (String label : columnLabel) {
				testSteps.add("Step " + (++i) + " : Verifying column with <b>'" + label + "'</b> is Displaying");
				assertTrue(homePage.isColumnLabelDisplaying(driver, label),
						"Failed : column with <b>'" + label + "'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: column with <b>'" + label + "'</b> is Displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyOTCDetailScreen", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyOTCDetailScreen " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyOTCDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyOTCDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyOTCDetailScreen " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyOTCDetailScreen") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyOTCDetailScreen", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyIncomeGeneratorsSignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Income Generators";
		String[] name = { "State Street Corp", "Equity Residential", "ocket Companies Inc",
				"Regency Centers Corporation", "Annaly Capital Management Inc", "F.N.B. Corp", "Independent Bank",
				"Fulton Financial Corporation", "Arch Resources Inc", "Virtu Financial Inc", "Kenon Holdings",
				"Star Bulk Carriers Corp", "Brookline Bancorp Inc", "Armada Hflr Pr", "Office Properties Income Trust",
				"Kearny Financial Corp", "Hbt Financial Inc", "Financial Institutions Inc", "AFC Gamma Inc",
				"Loandepot Inc" };
		String[] symbol = { "STT", "EQR", "RKT", "REG", "NYL", "FNB", "INDB", "FULT", "ARCH", "VIRT", "KEN", "SBLK",
				"BRKL", "AHH", "OPI", "KRNY", "HBT", "FISI", "AFCG", "LDI" };
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyIncomeGeneratorsSignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-831?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-831 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Income Generators' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyIncomeGeneratorsSignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyIncomeGeneratorsSignalNameAndSymbol " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyIncomeGeneratorsSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyIncomeGeneratorsSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: VerifyIncomeGeneratorsSignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyIncomeGeneratorsSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyIncomeGeneratorsSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyCoffeeCanInvestingSignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Coffee Can Investing";
		String[] name = { "Visa Inc. Class A", "Mastercard Inc", "Accenture plc", "Adobe Systems Incorporated",
				"Pinduoduo", "Vertex Pharmaceuticals Inc", "Cadence Design Systems Inc", "Paychex Inc", "Airbnb Inc",
				"Genmab AS", "Texas Pacific Land Trust", "Rollins Inc", "Molina Healthcare Inc",
				"Lattice Semiconductor Corporation", "Medpace Holdings Inc", "Chord Energy Corp",
				"AMN Healthcare Services Inc", "Atkore International Group Inc", "Magnolia Oil & Gas Corp",
				"Endava Ltd" };
		String[] symbol = { "V", "MA", "ANC", "ADBE", "PDD", "VRTX", "CDNS", "PAYX", "ABNB", "GMAB", "TPL", "ROL",
				"MOH", "LSCC", "MEDP", "CHRD", "AMN", "ATKR", "MGY", "DAVA" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyCoffeeCanInvestingSignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-834?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-834 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Coffee Can Investing' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyCoffeeCanInvestingSignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyCoffeeCanInvestingSignalNameAndSymbol " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyCoffeeCanInvestingSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyCoffeeCanInvestingSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: VerifyCoffeeCanInvestingSignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyCoffeeCanInvestingSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyCoffeeCanInvestingSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyBullishRSISignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Bullish RSI";
		String[] name = { "Equinor ASA ADR", "CF Industries Holdings Inc" };
		String[] symbol = { "EQNR", "CF" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyBullishRSISignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-837?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-837 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Bullish RSI' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyBullishRSISignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyBullishRSISignalNameAndSymbol " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyBullishRSISignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBullishRSISignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyBullishRSISignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyBullishRSISignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBullishRSISignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyRisingStarsSignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Rising Stars";
		String[] name = { "Black Stone Minerals LP", "Cactus Inc", "Skyline Corporation", "Forward Air Corporation",
				"Alliance Resource Partners LP", "MaxLinear Inc", "Hub Group Inc", "KB Home",
				"Alpha Metallurgical Resources Inc", "Highpeak Energy Acquisition Corp", "Nova Ltd",
				"Warrior Met Coal Inc", "RPC Inc", "Star Bulk Carriers Corp", "Catalyst Pharmaceuticals Inc",
				"Green Brick Partners Inc", "Riley Exploration Permian Inc", "Ramaco Resources Inc",
				"Intrepid Potash Inc", "Marine Products Corporation" };
		String[] symbol = { "BSM", "WHD", "SKY", "FWRD", "ARLP", "MXL", "HUBG", "KBH", "AMR", "HPK", "NVMI", "HCC",
				"RES", "SBLK", "CPRX", "CHRD", "REPX", "METC", "IPI", "MPX" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyRisingStarsSignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-840?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-840 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Rising Stars' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyRisingStarsSignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {

			testSteps
					.add("Failed: VerifyRisingStarsSignalNameAndSymbol " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyRisingStarsSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyRisingStarsSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyRisingStarsSignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyRisingStarsSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyRisingStarsSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyBuffetGrahamFormulaSignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Buffet-Graham Formula";
		String[] name = { "Taiwan Semiconductor Manufacturing", "ConocoPhillips", "Qualcomm Incorporated",
				"Union Pacific Corporation", "Caterpillar Inc", "EOG Resources Inc", "Lam Research Corp",
				"Occidental Petroleum Corporation", "Marathon Petroleum Corp", "KLA-Tencor Corporation", "Phillips 66",
				"Valero Energy Corporation", "Devon Energy Corporation", "NXP Semiconductors NV", "Cheniere Energy Inc",
				"STMicroelectronics NV ADR", "MPLX LP", "ON Semiconductor Corporation", "DR Horton Inc",
				"Diamondback Energy Inc" };
		String[] symbol = { "TSM", "COP", "QCOM", "UNP", "CAT", "EOG", "LRCX", "OXY", "MPC", "KLAC", "PSX", "VLO",
				"DVN", "NXIP", "LNG", "STM", "MPLX", "ON", "DHI", "FANG" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyBuffetGrahamFormulaSignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-844?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-844 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Buffet-Graham Formula' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyBuffetGrahamFormulaSignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: VerifyBuffetGrahamFormulaSignalNameAndSymbol " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyBuffetGrahamFormulaSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBuffetGrahamFormulaSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: VerifyBuffetGrahamFormulaSignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyBuffetGrahamFormulaSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyBuffetGrahamFormulaSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyGoldenCrossoverSignalNameAndSymbol() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String signalType = "Golden Crossover";
		String[] name = { "Exxon Mobil Corp", "Wells Fargo & Company", "Pinduoduo", "Schlumberger NV",
				"Occidental Petroleum Corporation", "General Motors Company", "Uber Technologies Inc", "Ambev SA ADR",
				"Kinder Morgan Inc", "Energy Transfer Equity LP", "PG&E Corp", "Sirius XM Holding Inc",
				"Itau Unibanco Banco Holding SA", "Huntington Bancshares Incorporated", "Hewlett Packard Enterprise Co",
				"Marathon Oil Corporation", "Pinterest Inc", "Viatris Inc", "Gerdau SA ADR",
				"Tencent Music Entertainment Group" };
		String[] symbol = { "XOM", "WFC", "PDD", "SLB", "OXY", "GM", "UBER", "ABEV", "KMI", "ET", "PCG", "SIRI", "ITUB",
				"HBAN", "HPE", "MRO", "PINS", "VTRS", "GGB", "LNC" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyGoldenCrossoverSignalNameAndSymbol:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-847?atlOrigin=eyJpIjoiNmZmNmMxMDZkMjdlNGNmY2FlYmVlMjAwMGFhYTQ2YWYiLCJwIjoiaiJ9\">QAA-847 : [Web] - Verify the 'Names' and 'Symbols' of available stock in 'Golden Crossover' signal detail screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.SignalSectionDisplaying(driver),
					"Failed : 'Signals' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Signals'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Click On <b>'" + signalType + "'</b>");
			homePage.clickOnSignalSectionOption(driver, signalType);

			for (int stockCount = 0; stockCount < name.length; stockCount++) {
				testSteps.add("<b>**************** Verifying " + name[stockCount] + " ****************<b>");
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying stock <b>'" + name[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockNameDisplaying(driver, name[stockCount]),
							"Failed : '" + name[stockCount] + "' stock is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + name[stockCount] + "'</b> stock is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Name <b>'" + name[stockCount]
							+ "'</b> is not available </font></b>");
				}
				try {
					testSteps.add(
							"Step " + (++i) + " : Verifying symbol <b>'" + symbol[stockCount] + "'</b> is available ");
					assertTrue(homePage.isStockSymbolDisplaying(driver, symbol[stockCount]),
							"Failed : '" + symbol[stockCount] + "' symbol is not available");
					testSteps.add(
							"Step " + (++i) + " : Verified: <b>'" + symbol[stockCount] + "'</b> symbol is available ");
				} catch (Error e) {
					testSteps.add("Step " + (++i) + " :<b><font color='red'> Symbol <b>'" + symbol[stockCount]
							+ "'</b> is not available </font></b>");
				}

			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyGoldenCrossoverSignalNameAndSymbol", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: VerifyGoldenCrossoverSignalNameAndSymbol " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyGoldenCrossoverSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyGoldenCrossoverSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps
					.add("Failed: VerifyGoldenCrossoverSignalNameAndSymbol " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyGoldenCrossoverSignalNameAndSymbol") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyGoldenCrossoverSignalNameAndSymbol", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyOTCSection_ExistingUser() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		HomePage homePage;
		driver = initConfiguration();
		String dashboardTitle = "Dashboard | Vested Finance";
		String[] list = { "Lightwave Logic Inc", "UbiSoft Entertainment Inc", "Alpine 4 Holdings Inc" };
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		homePage = new HomePage(driver);
		printString("VerifyOTCSection_ExistingUser:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/VQAA-857?atlOrigin=eyJpIjoiYjhlN2JlZDhiMjZkNDE5MTgwMDg0MDMzMjlmMTk1OTgiLCJwIjoiaiJ9\">VQAA-857 : [Web] - While user logged in with existing user, Verify the 'OTC' section on dashboard screen<a/>");
			testSteps.add("Login  To App");
			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'OTC'</b> heading is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.OTCSectionDisplaying(driver),
					"Failed : 'OTC' heading is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'OTC'</b> heading is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'OTC Show All'</b> Button is available in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.OTCShowAllButtonisDisplaying(driver),
					"Failed : 'OTC Show All' Button is available in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'OTC Show All'</b> Button is available in <b>'Explore'</b> section is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verifying <b>'OTC Show All'</b> Button is clickable in <b>'Explore'</b> section is displaying");
			assertTrue(homePage.OTCShowAllButtonisClickable(driver),
					"Failed : 'OTC Show All' Button is clickable in 'Explore' section is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'OTC Show All'</b> Button is clickable in <b>'Explore'</b> section is displaying");

			for (String ele : list) {
				testSteps.add("Step " + (++i) + " : Verifying OTC <b>'" + ele + "'</b> is displaying ");
				assertTrue(homePage.OTCisDisplaying(driver, ele), "Failed : OTC <b>'" + ele + "'</b> is displaying ");
				testSteps.add("Step " + (++i) + " : Verified: OTC <b>'" + ele + "'</b> is displaying ");

				testSteps.add("Step " + (++i) + " : Verifying OTC <b>'" + ele + "'</b> is clickable ");
				assertTrue(homePage.OTCisClickable(driver, ele), "Failed : OTC <b>'" + ele + "'</b> is clickable ");
				testSteps.add("Step " + (++i) + " : Verified: OTC <b>'" + ele + "'</b> is clickable ");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyOTCSection_ExistingUser", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: VerifyOTCSection_ExistingUser " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyOTCSection_ExistingUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyOTCSection_ExistingUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyOTCSection_ExistingUser " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyOTCSection_ExistingUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyOTCSection_ExistingUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
