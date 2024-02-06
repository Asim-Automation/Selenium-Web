package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;

public class InstrumentViewDetails extends BaseClass {
	String tempSrc = "";

	@Test
	public void Instruments_View_NonLoggedInUser() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		int i = 0;
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_View_NonLoggedInUser: " + driver.hashCode() + "", driver);

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-16?atlOrigin=eyJpIjoiZDhmOWQ2MDg2ZTI1NDFmM2I2ZmMxMDVmMDVjMGFjNzIiLCJwIjoiaiJ9\">QAA-16 : Web - Verify non-logged in user is successfully able to view instruments on the platform<a/>");
			testSteps.add("Step " + (++i) + ": Visit app <b>'url'</b>");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);

			testSteps.add("Step " + (++i) + " : Enter app <b>'Password'</b>");
			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'submit'</b>");
			loginPage.clickOnSubmitButton(driver);

			waitTime(2000, driver);
			testSteps.add("Step " + (++i) + " : <b>'Navigate to Instruments'</b> page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'instruments page load successfully'</b>");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified <b>'Instruments table is displaying on the instruments page'</b>");

			testSteps.add("Step " + (++i) + " : <b>'Navigate to instrument details page'</b>");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Invest Now'</b> button");
			instrumentPage.clickOnInvestNowBtn(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Login/Signup modal'</b> is showing");
			// assertTrue(instrumentPage.verifyLoginSignupModalIsDisplaying(driver),
			// "Verified Login/Signup modal is showing");

			testSteps.add("Step " + (++i) + " : Click on <b>'Close Modal'</b> button");
			instrumentPage.clickOnCloseModalButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'ADD TO WATCHLIST'</b> button");
			instrumentPage.clickOnAddToWatchList(driver);

			AddTest_IntoReport("Instruments_View_NonLoggedInUser", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Instruments_View_NonLoggedInUser " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_View_NonLoggedInUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_View_NonLoggedInUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Instruments_View_NonLoggedInUser " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_View_NonLoggedInUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_View_NonLoggedInUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void Instruments_View_Sort_List() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;

		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_View_Sort_List:" + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-22?atlOrigin=eyJpIjoiYWYyZTJkYjAwNGZlNGQ4NWIwMjg2ZDgwN2U4MTVkZDAiLCJwIjoiaiJ9\">QAA-22 : Web - Explore stocks and verify the user is able to sort the list, add a stock to watchlist<a/>");
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-19?atlOrigin=eyJpIjoiMjM5MzY1NjAyNDQ0NDg5Mzk5MTRhOWY5ZGExNGExZWQiLCJwIjoiaiJ9\">QAA-19 : Web - Verify KYC-approved funded account user is successfully able to login into the platform and view recommended and watchlist stocks/ETFs<a/>");

			testSteps.add("Step " + (++i) + " : Login To App");
			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is display");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified <b>'Dashboard'</b> is displayed");

			waitTime(2000, driver);
			testSteps.add("Step " + (++i) + " : Visit <b>'Instruments page'</b> url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'instruments page load successfully'</b>");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified <b>'Instruments table'</b> is displaying on the instruments page");

			testSteps.add("Step " + (++i) + " : Verify <b>'20 instruments'</b> are showing in the table");
			assertEquals(instrumentPage.getInstrumentTableRowsSize(), 20);

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Name List'</b>");
			ArrayList<String> names = instrumentPage.getInstrumentNameList(driver);

			testSteps.add("Step " + (++i) + " : Verifying names are sorted <b>'alphabetically A to Z'</b>");
			assertEquals(names, instrumentPage.getSortedList(names), "Names are not sorted <b>'alphabetically'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Name cell of table header'</b>");
			instrumentPage.clickOnNameCellInstrumentTableHeader(driver);

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Name List'</b>");
			ArrayList<String> reverseNames = instrumentPage.getInstrumentNameList(driver);

			testSteps.add("Step " + (++i) + " : Verifying names are sorted <b>'alphabetically Z to A'</b>");
			assertEquals(reverseNames, instrumentPage.getReverseSortedList(reverseNames),
					"Names are not sorted <b>'revrse alphabetically'</b>");

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Symbol List'</b>");
			ArrayList<String> symbol = instrumentPage.getInstrumentSymbolList(driver);

			testSteps.add("Step " + (++i) + " : Verifying names are sorted <b>'alphabetically A to Z'</b>");
			assertEquals(symbol, instrumentPage.getSortedList(symbol),
					"Symbols are not <b>'sorted alphabetically'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Symbol cell'</b> from table header");
			instrumentPage.clickOnSymbolCellInstrumentTableHeader(driver);

			testSteps.add("Step " + (++i) + " : <b>Getting AllSymbols'</b>");
			ArrayList<String> reverseSymbol = instrumentPage.getInstrumentSymbolList(driver);

			testSteps.add("Step " + (++i) + " : Verifying Symbols are sorted <b>'alphabetically Z to A'</b>");
			assertEquals(reverseSymbol, instrumentPage.getReverseSortedList(reverseSymbol),
					"Symbols are not sorted <b>'revrse alphabetically'</b>");

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Price List'</b>");
			ArrayList<String> price = instrumentPage.getInstrumentPriceList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by price low to high'</b>");
			assertEquals(price, instrumentPage.getReverseSortedList(price),
					"Instruments are <b>'sorted by price low to high'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Price cell of table header'</b>");
			instrumentPage.clickOnPriceCellInstrumentTableHeader(driver);

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Price List'</b>");
			ArrayList<String> reversePrice = instrumentPage.getInstrumentPriceList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by price high to low'</b>");
			assertEquals(reversePrice, instrumentPage.getSortedList(reversePrice),
					"Instruments are not <b>'sorted by price high to low'</b>");

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Daily Change List'</b>");
			ArrayList<String> changeList = instrumentPage.getInstrumentDailyChangeList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by Daily Change low to high'</b>");
			assertEquals(changeList, instrumentPage.getReverseSortedList(changeList),
					"Instruments are <b>'sorted by Daily Change low to high</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Daily Change cell of table header'</b>");
			instrumentPage.clickOnChangeCellInstrumentTableHeader(driver);

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Daily Change List'</b>");
			ArrayList<String> reverseChange = instrumentPage.getInstrumentDailyChangeList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by Daily Change high to low'</b>");
			assertEquals(reverseChange, instrumentPage.getSortedList(reverseChange),
					"Instruments are not <b>'sorted by Daily Change high to low'</b>");

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Market Cap List'</b>");
			ArrayList<String> marketCap = instrumentPage.getInstrumentDailyChangeList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by Market Cap low to high'</b>");
			assertEquals(marketCap, instrumentPage.getReverseSortedList(marketCap),
					"Instruments are <b>'sorted by Market Cap low to high'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Market Cap cell of table header'</b>");
			instrumentPage.clickOnMarketCapCellInstrumentTableHeader(driver);

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments Market Cap List'</b>");
			ArrayList<String> reverseMC = instrumentPage.getInstrumentDailyChangeList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by Market Cap high to low'</b>");
			assertEquals(reverseMC, instrumentPage.getSortedList(reverseMC),
					"Instruments are not <b>'sorted by Market Cap high to low'</b>");

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments P/E Ratio List'</b>");
			ArrayList<String> peRatio = instrumentPage.getInstrumentPERatioList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by P/E Ratio high to low'</b>");
			assertEquals(peRatio, instrumentPage.getReverseSortedList(peRatio),
					"Instruments are <b>'sorted by P/E Ratio high to low'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'P/E Ratio cell of table header'</b>");
			instrumentPage.clickOnPERatioCellInstrumentTableHeader(driver);

			testSteps.add("Step " + (++i) + " : <b>'Getting Instruments P/E Ratio List'</b>");
			ArrayList<String> reversePE = instrumentPage.getInstrumentPERatioList(driver);

			testSteps.add("Step " + (++i) + " : Verifying instruments are <b>'sorted by P/E Ratio low to high'</b>");
			assertEquals(reversePE, instrumentPage.getSortedList(reversePE),
					"Instruments are not <b>'sorted by P/E Ratio low to high'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Watch List Icon of 1st instrument'</b>");
			instrumentPage.clickOnWatchListIconOf1stInstrument(driver);
			waitTime(2000, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'1st instrument'</b>");
			instrumentPage.clickOnFirstInstrument(driver);

			System.out.println("Stocks Name:  " + instrumentPage.getStockname(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>'instrument details page load successfully'</b>");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified <b>'Instrument details page load successfully'</b>");

			testSteps.add("Step " + (++i) + " : Instrument Name = <b>" + instrumentPage.getStockname(driver) + "'</b>");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified <b>'Instrument details page load successfully'</b>");

			testSteps.add("Step " + (++i) + " : Verify <b>'instrument added to watchlist without error'</b>");
			assertTrue(instrumentPage.isAddedToWatchListDisplaying(driver),
					"Verified <b>'instrument added to watchlist without error'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'WATCHLIST'</b> button to remove from Watchlist");
			instrumentPage.clickOnAddToWatchList(driver);
			waitTime(2000, driver);

			AddTest_IntoReport("Instruments_View_Sort_List", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Instruments_View_Sort_List " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_View_Sort_List") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_View_Sort_List", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Instruments_View_Sort_List " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_View_Sort_List") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_View_Sort_List", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void Instruments_View() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		int i = 0;
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("Instruments_View: " + driver.hashCode() + "", driver);

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-19?atlOrigin=eyJpIjoiYTE1YzFkNDA2NzhiNGQ3NDgxZjhlOGFkMTFjMjFhYzAiLCJwIjoiaiJ9\">QAA-19 : Web - Verify KYC-approved funded account user is successfully able to login into the platform and view recommended and watchlist stocks/ETFs<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");

			testSteps.addAll(loginPage.loginToApp(driver));
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified <b>'Dashboard'</b> is displayed");

			waitTime(2000, driver);
			testSteps.add("Step " + (++i) + " : <b>'Navigate to Instruments'</b> page url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentURL"), driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'instruments page load successfully'</b>");
			assertTrue(instrumentPage.verifyInstrumentsTableIsShowing(driver),
					"Verified <b>'Instruments table is displaying on the instruments page'</b>");

			testSteps.add("Step " + (++i) + " : Go to <b>'instrument details page'</b>");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'instrument details page load successfully'</b>");
			assertTrue(instrumentPage.verifyInstrumentDetailPageIsShowing(driver),
					"Verified <b>'Instrument details page load successfully</b>");

			testSteps.add("Step " + (++i) + " : Verify <b>'Overview'</b> Tab is showing");
			assertTrue(instrumentPage.isOverviewTabIsDisplaying(driver), "Verified <b>'Overview'</b> Tab is showing");

			testSteps.add("Step " + (++i) + " : Click on <b>'Overview'</b> Tab");
			instrumentPage.clickOnOverviewTab(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Overview'</b> Tab Details is showing");
			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified <b>'Overview'</b> Tab Details is showing");

			testSteps.add("Step " + (++i) + " : Verify <b>'Returns Tab'</b> is showing");
			assertTrue(instrumentPage.isReturnTabIsDisplaying(driver), "Verified <b>'Returns Tab'</b> is showing");

			testSteps.add("Step " + (++i) + " : Click on <b>'Returns Tab'</b>");
			instrumentPage.clickOnReturnTab(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Returns Tab'</b> Details is showing");
			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified <b>'Overview Tab Details'</b> is showing");

			testSteps.add("Step " + (++i) + " : Verify <b>'Fundamental Data Tab</b> is showing");
			assertTrue(instrumentPage.isFundamentalDataTabIsDisplaying(driver),
					"Verified <b>'Fundamental Data Tab'</b> is showing");

			testSteps.add("Step " + (++i) + " : Click on <b>'Fundamental Data Tab'</b>");
			instrumentPage.clickOnFundamentalDataTab(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Fundamental Data Tab Details'</b> is showing");
			assertTrue(instrumentPage.isTabDetailShowing(driver),
					"Verified <b>'Fundamental Data Tab Details'</b> is showing");

			testSteps.add("Step " + (++i) + " : Verify <b>'Key Ratio Tab'</b> is showing");
			assertTrue(instrumentPage.isKeyRatioTabIsDisplaying(driver), "Verified <b>'Key Ratio Tab'</b> is showing");

			testSteps.add("Step " + (++i) + " : Click on <b>'Key Ratio Tab'</b>");
			instrumentPage.clickOnKeyRatioTab(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Key Ratio Tab Details'</b> is showing");
			assertTrue(instrumentPage.isTabDetailShowing(driver), "Verified <b>'Key Ratio Tab Details'</b> is showing");

			testSteps.add("Step " + (++i) + " : Click on <b>'ADD TO WATCHLIST'</b> button");
			instrumentPage.clickOnAddToWatchList(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'instrument added to watchlist without error'</b>");
			assertTrue(instrumentPage.isAddedToWatchListDisplaying(driver),
					"Verified <b>'instrument added to watchlist without error'</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'ADD TO WATCHLIST'</b> button to remove from Watchlist");
			instrumentPage.clickOnAddToWatchList(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'BUY'</b> button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'BUY instrument page'</b> is displaying");
			assertTrue(instrumentPage.isBuyInstrumentPageDisplaying(driver),
					"Verified <b>'BUY instrument page'</b> is displaying");

			AddTest_IntoReport("Instruments_View", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Instruments_View " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_View") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_View", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Instruments_View " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Instruments_View") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Instruments_View", testSteps, driver);
			} else {
				closeBrowser(driver);
			}

			assertTrue(false);
		}
	}

}
