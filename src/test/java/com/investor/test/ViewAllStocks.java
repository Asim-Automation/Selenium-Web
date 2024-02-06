package com.investor.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
//import com.investor.errorCollectors.ErrorCollector;
//import com.investor.listeners.ExtentListeners;
import com.investor.pages.FundTransferPage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.ModelStockData;

public class ViewAllStocks extends BaseClass {
	String tempSrc = "";

	@Test
	public void ViewInstruments_Sorting() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("ViewInstruments_Sorting: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
//		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-252?atlOrigin=eyJpIjoiNjMxYzQ5OTczYjY3NGNkZTljMWRhZjE0ZjdhYzdmNmUiLCJwIjoiaiJ9\">QAA-252 : Web - Verify sorting based on columns in view all instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();

			testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
			navigateToURL(instrumentUrl, driver);
			step++;

			testSteps.add("Step " + step + " : Exploring the page till bottom");
			instrumentPage.exploreTopMovers(driver);
			printString("Exploring the page till bottom", driver);
			step++;

			try {

				instrumentPage.clickOnTopMoversShowAllButton(driver);
				testSteps.add("Step " + step + " : Click on 'Show All' button");
				printString("Click on Show All button", driver);
				step++;
			} catch (Exception e) {
				printString("Show All Button Not showing", driver);
			}

			testSteps.add("Step " + step + " : Click on Symbol cell of table header");
			instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
			printString("Click on Symbol cell of table header", driver);
			step++;

			wait5s();
			instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
			instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
			testSteps.add("Step " + step + " : Getting Instruments Symbol List");
			ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
			ArrayList<String> stockSymbolListAfterSort = instrumentPage.getInstrumentSymbolList(driver);
			printString("Getting Instruments Symbol List", driver);
			step++;

			testSteps.add("Step " + step + " : <b>Verifying Symbol list sorted alphabetically</b>");
			testSteps.add("<b>Expected Symbol List:</b> " + stockSymbolListBeforeSort);
			testSteps.add("<b>Actual Symbol List:</b> " + instrumentPage.getSortedList(stockSymbolListAfterSort));
			assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
					"Symbol list not sorted alphabetically");
			testSteps.add("<b>Symbol list Is Verified</b>");
			printString("Verify Symbol list sorted alphabetically", driver);
			step++;

			getRefreshWebPage(driver);
			testSteps.add("Step " + step + " : Click on Price cell of table header");
			instrumentPage.clickOnPriceCellInstrumentTableHeader(driver);
			printString("Click on Price cell of table header", driver);
			step++;

			wait5s();
			instrumentPage.clickOnPriceCellInstrumentTableHeader(driver);
			instrumentPage.clickOnPriceCellInstrumentTableHeader(driver);
			testSteps.add("Step " + step + " : Getting Instruments Price List");
			ArrayList<Double> stockPriceListBeforeSort = instrumentPage.getDoubleInstrumentPriceList(driver);
			ArrayList<Double> stockPriceListAfterSort = instrumentPage.getDoubleInstrumentPriceList(driver);
			printString("Getting Instruments Price List", driver);
			step++;

			testSteps.add("Step " + step + " : <b>Verifying Price list Sorted Dscendingly</b>");
			testSteps.add("<b>Expected Price List:</b> " + stockPriceListBeforeSort);
			ArrayList<Double> SortedList = instrumentPage.getReverseSortedDoubleList(stockPriceListAfterSort);
			testSteps.add("<b>Actual Price List:</b> " + SortedList);
			assertEquals(stockPriceListBeforeSort, SortedList, "Price list not sorted");
			testSteps.add("<b> Price list is Verified</b>");
			printString("Verify Price list sorted", driver);
			step++;
			
			getRefreshWebPage(driver);
			testSteps.add("Step " + step + " : Click on Name cell of table header");
			instrumentPage.clickOnNameCellInstrumentTableHeader(driver);
			printString("Click on Name cell of table header", driver);
			step++;

			wait5s();
			instrumentPage.clickOnNameCellInstrumentTableHeader(driver);
			instrumentPage.clickOnNameCellInstrumentTableHeader(driver);
			testSteps.add("Step " + step + " : Getting Instruments Symbol List");
			ArrayList<String> stockNameListBeforeSort = instrumentPage.getInstrumentNameList(driver);
			ArrayList<String> stockNameListAfterSort = instrumentPage.getInstrumentNameList(driver);
			printString("Getting Instruments Name List", driver);
			step++;

			testSteps.add("Step " + step + " : <b>Verifying Name list sorted alphabetically</b>");
			testSteps.add("<b>Expected Name List:</b> " + stockNameListBeforeSort);
			testSteps.add("<b>Actual Name List:</b> " + instrumentPage.getSortedList(stockNameListAfterSort));
			assertEquals(stockNameListBeforeSort, instrumentPage.getSortedList(stockNameListAfterSort),
					"Name list not sorted alphabetically");
			testSteps.add("<b>Name list Is Verified</b>");
			printString("Verify Name list sorted alphabetically", driver);
			step++;
			
			AddTest_IntoReport("ViewInstruments_Sorting", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: ViewInstruments_Sorting " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ViewInstruments_Sorting") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ViewInstruments_Sorting", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: ViewInstruments_Sorting " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ViewInstruments_Sorting") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ViewInstruments_Sorting", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifySectorsInstrumentDetailTabs() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("VerifySectorsInstrumentDetailTabs: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String[] filters = { "", "Information Technology", "Consumer Discretionary" };
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-330?atlOrigin=eyJpIjoiZGY2ODMzM2Y0MTFiNDcwNTgwZGE3ZTcyYzhhYTFmNDIiLCJwIjoiaiJ9\">QAA-330 : Verify tabs in instruments detail page.<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();

			/////////////////////////////////////////////////////////
			for (int c = 1; c <= 2; c++) {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				instrumentPage.expandAllCategories(driver);

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Income Focused' Category");
				step++;
				instrumentPage.selectSubCategories(driver, c, c, "Sectors");
				testSteps.add("Step " + step + " : Checking checkbox of <b>'" + filters[c] + "'</b>");
				step++;

				try {
					instrumentPage.clickOnFirstInstrument(driver);
					testSteps.add("Clicking On First Instrument from list");
					testSteps.addAll(instrumentPage.verifyTabs(driver));

				} catch (Exception e) {
					testSteps.add("No Instrument Found");
				}
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

			}

			AddTest_IntoReport("VerifySectorsInstrumentDetailTabs", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifySectorsInstrumentDetailTabs " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifySectorsInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifySectorsInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifySectorsInstrumentDetailTabs " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifySectorsInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifySectorsInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyEmergingThemeInstrumentDetailTabs() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("VerifyEmergingThemeInstrumentDetailTabs: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-330?atlOrigin=eyJpIjoiZGY2ODMzM2Y0MTFiNDcwNTgwZGE3ZTcyYzhhYTFmNDIiLCJwIjoiaiJ9\">QAA-330 : Verify tabs in instruments detail page.<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();

			/////////////////////////////////////////////////////////
			testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
			navigateToURL(instrumentUrl, driver);
			step++;
			instrumentPage.expandAllCategories(driver);
			instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
			testSteps.add("Step " + step + " : Expanding 'Emerging Themes' Category");
			step++;
			instrumentPage.selectSubCategories(driver, 1, 1, "Emerging Themes");
			testSteps.add("Step " + step + " : Checking checkbox of <b>'Crypto'</b>");
			step++;

			try {
				instrumentPage.clickOnFirstInstrument(driver);
				testSteps.add("Clicking On First Instrument");
				testSteps.addAll(instrumentPage.verifyTabs(driver));

			} catch (Exception e) {
				testSteps.add("No Instrument Found");
			}
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);

			AddTest_IntoReport("VerifyEmergingThemeInstrumentDetailTabs", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyEmergingThemeInstrumentDetailTabs " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyEmergingThemeInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyEmergingThemeInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyEmergingThemeInstrumentDetailTabs " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyEmergingThemeInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyEmergingThemeInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyIncomeFocusedInstrumentDetailTabs() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("VerifyIncomeFocusedInstrumentDetailTabs: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String[] filters = { "", "Dividends", "Real Estate", "Bonds" };
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-330?atlOrigin=eyJpIjoiZGY2ODMzM2Y0MTFiNDcwNTgwZGE3ZTcyYzhhYTFmNDIiLCJwIjoiaiJ9\">QAA-330 : Verify tabs in instruments detail page.<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();

			/////////////////////////////////////////////////////////
			for (int b = 1; b <= 3; b++) {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding <b>'Income Focused'</b> Category");
				step++;
				instrumentPage.selectSubCategories(driver, b, b, "Income Focused");
				testSteps.add("Step " + step + " : Checking checkbox of <b>'" + filters[b] + "'</b>");
				step++;

				try {
					instrumentPage.clickOnFirstInstrument(driver);
					testSteps.add("Clicking On First Instrument");
					testSteps.addAll(instrumentPage.verifyTabs(driver));

				} catch (Exception e) {
					testSteps.add("No Instrument Found");
				}
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

			}

			AddTest_IntoReport("VerifyIncomeFocusedInstrumentDetailTabs", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyIncomeFocusedInstrumentDetailTabs " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyIncomeFocusedInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyIncomeFocusedInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyIncomeFocusedInstrumentDetailTabs " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyIncomeFocusedInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyIncomeFocusedInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyETFProvidersInstrumentDetailTabs() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("VerifyETFProvidersInstrumentDetailTabs: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String[] filters = { "", "Vanguard", "Others", "iShares", "Fidelity", "Schwab", "Morgan Stanley" };
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-330?atlOrigin=eyJpIjoiZGY2ODMzM2Y0MTFiNDcwNTgwZGE3ZTcyYzhhYTFmNDIiLCJwIjoiaiJ9\">QAA-330 : Verify tabs in instruments detail page.<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();

			/////////////////////////////////////////////////////////
			for (int a = 1; a <= 6; a++) {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding <b>'ETF Providers'</b> Category");
				step++;
				instrumentPage.selectSubCategories(driver, a, a, "ETF Providers");
				testSteps.add("Step " + step + " : Checking checkbox of <b>'" + filters[a] + "'</b>");
				step++;

				try {
					instrumentPage.clickOnFirstInstrument(driver);
					testSteps.add("Clicking On First Instrument from list");
					testSteps.addAll(instrumentPage.verifyTabs(driver));

				} catch (Exception e) {
					testSteps.add("No Instrument Found");
				}

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

			}

			AddTest_IntoReport("VerifyETFProvidersInstrumentDetailTabs", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyETFProvidersInstrumentDetailTabs " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyETFProvidersInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyETFProvidersInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyETFProvidersInstrumentDetailTabs " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyETFProvidersInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyETFProvidersInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyGeographyInstrumentDetailTabs() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("VerifyGeographyInstrumentDetailTabs: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String[] filters = { "", "US", "East Asia", "Latin America", "UK", "North America", "Europe", "Australia",
				"South Asia", "South East Asia", "Global", "Africa" };
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-330?atlOrigin=eyJpIjoiZGY2ODMzM2Y0MTFiNDcwNTgwZGE3ZTcyYzhhYTFmNDIiLCJwIjoiaiJ9\">QAA-330 : Verify tabs in instruments detail page.<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();

			/////////////////////////////////////////////////////////

			for (int i = 2; i <= 11; i++) {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding <b>'Geographic Breakdowns'</b> Category");
				step++;
				instrumentPage.selectSubCategories(driver, i, i, "Geographic Breakdowns");
				testSteps.add("Step " + step + " : Checking checkbox of <b>'" + filters[i] + "'</b>");
				step++;

				try {
					instrumentPage.clickOnFirstInstrument(driver);
					testSteps.add("Clicking On First Instrument from list");
					testSteps.addAll(instrumentPage.verifyTabs(driver));

				} catch (Exception e) {
					testSteps.add("No Instrument Found");
				}

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

			}

			AddTest_IntoReport("VerifyGeographyInstrumentDetailTabs", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyGeographyInstrumentDetailTabs " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyGeographyInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyGeographyInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyGeographyInstrumentDetailTabs " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyGeographyInstrumentDetailTabs") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyGeographyInstrumentDetailTabs", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void TopMovers_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("TopMovers_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-258?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-258 : TopMovers_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {

						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("TopMovers_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: TopMovers_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("TopMovers_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("TopMovers_Instruments", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: TopMovers_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("TopMovers_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("TopMovers_Instruments", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void IncomeFocused_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("IncomeFocused_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-260?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-260 : IncomeFocused_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Income Focused' Categories");
				instrumentPage.selectSubCategories(driver, 1, 3, "Income Focused");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("IncomeFocused_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: IncomeFocused_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("IncomeFocused_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("IncomeFocused_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: IncomeFocused_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("IncomeFocused_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("IncomeFocused_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Recommended_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Recommended_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-259?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-259 : Recommended_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Recommended' Categories");
				instrumentPage.selectSubCategories(driver, 1, 1, "Recommended");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Recommended_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Recommended_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Recommended_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Recommended_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Recommended_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Recommended_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Recommended_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void ETFProviders_1_3_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("ETFProviders_1_3_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-261?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-261 : ETFProviders_1_3_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'ETF Providers' 1 to 3 Categories");
				instrumentPage.selectSubCategories(driver, 1, 3, "ETF Providers");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("ETFProviders_1_3_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: ETFProviders_1_3_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ETFProviders_1_3_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ETFProviders_1_3_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: ETFProviders_1_3_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ETFProviders_1_3_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ETFProviders_1_3_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void ETFProviders_4_6_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("ETFProviders_4_6_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-262?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-262 : ETFProviders_4_6_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'ETF Providers' 4 to 6 Categories");
				instrumentPage.selectSubCategories(driver, 4, 6, "ETF Providers");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("ETFProviders_4_6_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: ETFProviders_4_6_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ETFProviders_4_6_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ETFProviders_4_6_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: ETFProviders_4_6_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ETFProviders_4_6_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ETFProviders_4_6_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void EmergingThemes_1_3_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("EmergingThemes_1_3_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-263?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-263 : EmergingThemes_1_3_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Emerging Themes' 1 to 3 Categories");
				instrumentPage.selectSubCategories(driver, 1, 3, "Emerging Themes");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("EmergingThemes_1_3_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: EmergingThemes_1_3_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("EmergingThemes_1_3_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("EmergingThemes_1_3_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: EmergingThemes_1_3_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("EmergingThemes_1_3_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("EmergingThemes_1_3_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void EmergingThemes_4_7_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("EmergingThemes_4_7_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-264?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-264 : EmergingThemes_4_7_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Emerging Themes' 4 to 7 Categories");
				instrumentPage.selectSubCategories(driver, 4, 7, "Emerging Themes");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("EmergingThemes_4_7_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: EmergingThemes_4_7_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("EmergingThemes_4_7_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("EmergingThemes_4_7_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: EmergingThemes_4_7_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("EmergingThemes_4_7_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("EmergingThemes_4_7_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Sectors_1_3_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Sectors_1_3_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-265?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-265 : Sectors_1_3_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'GICS Sector' 1 to 3 Categories");
				instrumentPage.selectSubCategories(driver, 1, 3, "Sectors");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						try {
							testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
							instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
							printString("Open Detail Page of Stock " + i, driver);
							waitTime(3000, driver);
							step++;

							testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
									+ "'</b> is displaying");
							assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
									"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
							printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
							step++;

							testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
									+ "'</b> is displaying");
							printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying",
									driver);
							assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
									"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
							step++;

							testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
									+ "'</b> is displaying");
							printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
							assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
									"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
							step++;

							testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
									+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
							printString(
									"Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
									driver);
							assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
									"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
											+ "<b> is displaying");
							step++;

							tempSrc = getScreenshotPath();
							testSteps.add(tempSrc);
							captureCapture(driver, tempSrc);

							testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
							printString("Verify add to Watchlist button is displaying", driver);
							assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
									"Verified add to Watchlist button is displaying");
							step++;

							testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
							printString("Verify Buy button is displaying", driver);
							assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
									"Verified Buy button is displaying");
							step++;

						} catch (Exception e) {
							testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
							tempSrc = getScreenshotPath();
							testSteps.add(tempSrc);
							captureCapture(driver, tempSrc);
						}
					} catch (Exception e) {

					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Sectors_1_3_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Sectors_1_3_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_1_3_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_1_3_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Sectors_1_3_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_1_3_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_1_3_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Sectors_4_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Sectors_4_6_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-266?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-266 : Sectors_4_6_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'GICS Sector' 4 Categories");
				instrumentPage.selectSubCategories(driver, 4, 4, "GICS sectors");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Sectors_4_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Sectors_4_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_4_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_4_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Sectors_4_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_4_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_4_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Sectors_5_6_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Sectors_5_6_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-266?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-266 : Sectors_4_6_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'GICS Sector' 5 to 6 Categories");
				instrumentPage.selectSubCategories(driver, 5, 6, "GICS sectors");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Sectors_5_6_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Sectors_5_6_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_5_6_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_5_6_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Sectors_5_6_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_5_6_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_5_6_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Sectors_7_9_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Sectors_7_9_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-267?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-267 : Sectors_7_9_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'GICS Sector' 7 to 9 Categories");
				instrumentPage.selectSubCategories(driver, 7, 9, "GICS sectors");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Sectors_7_9_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Sectors_7_9_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_7_9_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_7_9_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Sectors_7_9_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_7_9_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_7_9_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Sectors_10_11_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Sectors_10_11_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-268?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-268 : Sectors_10_11_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'GICS Sector' 10 to 11 Categories");
				instrumentPage.selectSubCategories(driver, 10, 11, "GICS sectors");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Sectors_10_11_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Sectors_10_11_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_10_11_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_10_11_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Sectors_10_11_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Sectors_10_11_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Sectors_10_11_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Geography_1_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Geography_1_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-269?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-269 : Geography_1_4_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Geography' 1 to 2 Categories");
				instrumentPage.selectSubCategories(driver, 1, 1, "Geography");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Geography_1_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Geography_1_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_1_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_1_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Geography_1_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_1_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_1_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Geography_2_4_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Geography_2_4_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-269?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-269 : Geography_1_4_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Geography' 2 to 4 Categories");
				instrumentPage.selectSubCategories(driver, 2, 4, "Geography");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Geography_2_4_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Geography_2_4_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_2_4_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_2_4_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Geography_2_4_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_2_4_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_2_4_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Geography_5_8_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Geography_5_8_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-270?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-270 : Geography_5_8_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Geography' 5 to 8 Categories");
				instrumentPage.selectSubCategories(driver, 5, 8, "Geography");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());
						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Geography_5_8_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Geography_5_8_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_5_8_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_5_8_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Geography_5_8_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_5_8_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_5_8_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void Geography_9_12_Instruments() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		int step = 1;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Geography_9_12_Instruments: " + driver.hashCode(), driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		printString("tesData Size : " + dataArr.length, driver);
		String instrumentUrl = PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL");
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-257?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-257 : Verify each Stock page is loaded successfully<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-271?atlOrigin=eyJpIjoiYTM2YWI0OWNmMmJhNDE1N2FlNzcxYzU2ZTVjN2IwMjciLCJwIjoiaiJ9\">QAA-271 : Geography_9_12_Instruments<a/>");
			testSteps.add("Step " + step + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			step++;

			testSteps.add("Step " + step + " : Verify Dashboard is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displayed");
			step++;

			waitfor5sec();
			if (!instrumentPage.isMarketClose(driver)) {
				testSteps.add("Step " + step + " : Verifying Market Is Open");
				assertTrue(!instrumentPage.isMarketClose(driver), "Failed: Market is Opened");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);
				step++;
				testSteps.add("Step " + step + " : Verified:  Market Is Open");
				printString("Market Is Open", driver);
			} else {
				testSteps.add("Step " + step + " : Navigate to app url : <b>" + instrumentUrl);
				navigateToURL(instrumentUrl, driver);
				step++;

				testSteps.add("Step " + step + " : Exploring the page till bottom");
				instrumentPage.exploreTopMovers(driver);
				printString("Exploring the page till bottom", driver);
				step++;

				testSteps.add("Step " + step + " : Expanding Categories");
				instrumentPage.expandAllCategories(driver);
				step++;

				instrumentPage.selectSubCategories(driver, 1, 1, "Top Movers");
				testSteps.add("Step " + step + " : Expanding 'Geography' 9 to 12 Categories");
				instrumentPage.selectSubCategories(driver, 9, 12, "Geography");
				step++;

				try {
					testSteps.add("Step " + step + " : Click on 'Show All' button");
					instrumentPage.clickOnTopMoversShowAllButton(driver);
					printString("Click on Show All button", driver);
					step++;
				} catch (Exception e) {
					printString("Show All Button Not showing", driver);
				}

				testSteps.add("Step " + step + " : Click on Symbol cell of table header");
				instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);
				printString("Click on Symbol cell of table header", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Instruments Symbol List");
				ArrayList<String> stockSymbolListBeforeSort = instrumentPage.getInstrumentSymbolList(driver);
				ArrayList<String> stockSymbolListAfterSort = stockSymbolListBeforeSort;
				printString("Getting Instruments Symbol List", driver);
				step++;

				testSteps.add("Step " + step + " : Verify symbol list sorted alphabetically");
				assertEquals(stockSymbolListBeforeSort, instrumentPage.getSortedList(stockSymbolListAfterSort),
						"Symbol list not sorted alphabetically");
				printString("Verify symbol list sorted alphabetically", driver);
				step++;

				testSteps.add("Step " + step + " : Getting Stocks Data List");
				Map<Integer, ModelStockData> dataMap = instrumentPage.getStocksListData(driver);
				printString("Getting Stocks Data List", driver);
				step++;
				for (int i = 1; i <= dataMap.size(); i++) {
					try {
						testSteps.add("Step " + step + " : Open Detail Page of Stock: <b>" + i);
						instrumentPage.loadInstrumentDetailPageBySymbol(dataMap.get(i).getSymbol(), driver);
						printString("Open Detail Page of Stock " + i, driver);
						waitTime(3000, driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Name : <b>'" + dataMap.get(i).getName()
								+ "'</b> is displaying");
						assertTrue(instrumentPage.verifyStockNameOnDetailsPageShowing(driver),
								"Verified Stock Name : <b>" + dataMap.get(i).getName() + "<b> is displaying");
						printString("Verify Stock Name : " + dataMap.get(i).getName() + " is displaying", driver);
						step++;

						testSteps.add("Step " + step + " : Verify Stock Symbol : <b>'" + dataMap.get(i).getSymbol()
								+ "'</b> is displaying");
						printString("Verify Stock Symbol : " + dataMap.get(i).getSymbol() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockSymbolOnDetailsPageShowing(driver),
								"Verified Stock Symbol : <b>" + dataMap.get(i).getSymbol() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Price : <b>'" + dataMap.get(i).getPrice()
								+ "'</b> is displaying");
						printString("Verify Stock Price : " + dataMap.get(i).getPrice() + " is displaying", driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Price : <b>" + dataMap.get(i).getPrice() + "<b> is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify Stock Daily Change : <b>'"
								+ dataMap.get(i).getDailyChange() + "'</b> is displaying");
						printString("Verify Stock Daily Change : " + dataMap.get(i).getDailyChange() + " is displaying",
								driver);
						assertTrue(instrumentPage.verifyStockPriceOnDetailsPageShowing(driver),
								"Verified Stock Daily Change : <b>" + dataMap.get(i).getDailyChange()
										+ "<b> is displaying");
						step++;

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);

						testSteps.add("Step " + step + " : Verify add to 'Watchlist' button is displaying");
						printString("Verify add to Watchlist button is displaying", driver);
						assertTrue(instrumentPage.verifyAddToWathclistButtonDisplaying(driver),
								"Verified add to Watchlist button is displaying");
						step++;

						testSteps.add("Step " + step + " : Verify 'Buy' button is displaying");
						printString("Verify Buy button is displaying", driver);
						assertTrue(instrumentPage.verifyBuyButtonIsDisplaying(driver),
								"Verified Buy button is displaying");
						step++;

					} catch (Exception e) {
						testSteps.add("Failed: To Verify " + dataMap.get(i).getName());

						tempSrc = getScreenshotPath();
						testSteps.add(tempSrc);
						captureCapture(driver, tempSrc);
					}

				}
			}

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Geography_9_12_Instruments", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Geography_9_12_Instruments " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_9_12_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_9_12_Instruments", testSteps, driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Geography_9_12_Instruments " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Geography_9_12_Instruments") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Geography_9_12_Instruments", testSteps, driver);
			}
			assertTrue(false);
		}

	}

}
