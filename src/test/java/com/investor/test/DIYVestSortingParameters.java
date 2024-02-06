package com.investor.test;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.DIYVestPage;
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.NavigationPage;

public class DIYVestSortingParameters extends BaseClass {
	String tempSrc = "";

	@Test
	public void DIYVest_Sort() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String dashboardTitle = "Dashboard | Vested Finance";
		ArrayList<Double> percentageList = new ArrayList<Double>();
		ArrayList<Double> sortedPercentageList = new ArrayList<Double>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> alphabeticallySortednameList = new ArrayList<String>();
		String newVestTitle = "QAtestingvest";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_Sort:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String email = dataArr[rowIndex][1].toString();
		String password = dataArr[rowIndex][2].toString();
		String pinCode = dataArr[rowIndex][3].toString();
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-86?atlOrigin=eyJpIjoiZjMyZGJiMjBmZmE4NDFkYzk0ODMxOTZkOGQ3YTUyYWYiLCJwIjoiaiJ9\">QAA-86 : [Web Automation DIY Vest] Sorting of the User's DIY Vest on the basis of different sorting parameters.<a/>");

			testSteps.add("Step " + (++i) + "Login To App");
			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Dashboard page'</b> is displaying after clicking on <b>'Home'</b> button");

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			if (diyVestPage.getVestCardCount() == 0) {
				ArrayList<String> steps = diyVestPage.createDIYVest(driver, newVestTitle, i);
				i = i + steps.size();
				testSteps.addAll(steps);

				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

			}

			testSteps.add("Step " + (++i) + " : Chosing <b>'Alphabets'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_Alphabets(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'Alphabets'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("Alphabetical", driver));
			nameList = diyVestPage.getDiyVestCardsNameList(driver);
			alphabeticallySortednameList = nameList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + nameList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify symbol list sorted alphabetically'</b>");
			assertEquals(nameList, instrumentPage.getSortedList(alphabeticallySortednameList),
					"list not sorted alphabetically");
			testSteps.add("Step " + (++i) + " : <b>'Verified:  symbol list sorted alphabetically'</b>");

			testSteps.add("Step " + (++i) + " : Chosing <b>'InceptionDate'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_InceptionDate(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'InceptionDate'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("Inception Date", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
//			printString(percentageList.toString(), driver);
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for InceptionDate'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>'Verified: list sorted for InceptionDate'</b>");

			testSteps.add("Step " + (++i) + " : Chosing <b>'OneWeek'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_OneWeek(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'OneWeek'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("1W Returns", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for OneWeek'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>'Verified: list sorted for OneWeek'</b>");
			testSteps.add("Step " + (++i) + " : Chosing <b>'OneMonth'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_OneMonth(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'OneMonth'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("1M Returns", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for OneMonth'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>'Verified: list sorted for OneMonth'</b>");

			testSteps.add("Step " + (++i) + " : Chosing <b>'ThreeMonth'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_ThreeMonth(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'ThreeMonth'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("3M Returns", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for ThreeMonth'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>'Verified:  list sorted for ThreeMonth'</b>");

			testSteps.add("Step " + (++i) + " : Chosing <b>'OneYear'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_OneYear(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'OneYear'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("1Y Returns", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for OneYear'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>'Verified:  list sorted for OneYear'</b>");

			testSteps.add("Step " + (++i) + " : Chosing <b>'FiveYear'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_FiveYear(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'FiveYear'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("5Y Returns", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for FiveYear'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>Verified:  list sorted for FiveYear</b>");

			testSteps.add("Step " + (++i) + " : Chosing <b>'AllTime'</b> Sorting Option");
			diyVestPage.clickOnsortingButton(driver);
			diyVestPage.clickOnsortingOption_AllTime(driver);
			diyVestPage.clickOnsortingButton(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : Verifying <b>'AllTime'</b> is Selected");
			assertTrue(diyVestPage.isSelectedSortingTypeSelected("All Time Returns", driver));
			percentageList = diyVestPage.getDiyVestCardsPercentageList(driver);
			sortedPercentageList = percentageList;
			testSteps.add("Step " + (++i) + " : List: <b>'" + percentageList + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Verify list sorted for AllTime'</b>");
			assertEquals(percentageList, instrumentPage.getSortedDoubleList(sortedPercentageList));
			testSteps.add("Step " + (++i) + " : <b>'Verified:  list sorted for AllTime'</b>");

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("DIYVest_Sort", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: DIYVest_Sort " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_Sort") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_Sort", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVest_Sort " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_Sort") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_Sort", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void DIYVest_CreateNew1() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String oldVestTitle = "dni_duplicate_test_vest88";
		String newVestTitle = generateRandomStringWithGivenNumberOfDigits(1, driver) + "testvest"
				+ generateRandomNumberWithGivenNumberOfDigits(3, driver);
		String renameVestTitle = generateRandomStringWithGivenNumberOfDigits(1, driver) + "testvest"
				+ generateRandomNumberWithGivenNumberOfDigits(3, driver);
		String investmentAmount = "52";

		String Share = "Share";
		String Rebalance = "Rebalance";
		String Rename = "Rename";
		String Delete = "Delete";
		String notInVested = "Not invested";
		String vested = "Invested";

		String rebalanceVestedName = "rebalance_verification_11th_feb";

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_CreateNew:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-87?atlOrigin=eyJpIjoiMzUwYTIwOWNiYzBhNGM1NzkzMmQ1MmQ0ZmNjNTk1ZjkiLCJwIjoiaiJ9\">QAA-87 : [Web DIY Vest Automation] Sharing the Vest from the three dots..<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor5sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOncreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			diyVestPage.selectStocks(1, driver);
			testSteps.add("Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button status: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			diyVestPage.selectStocks(2, driver);
			testSteps.add(
					"Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with more than one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button status: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
			diyVestPage.clickOnAddedStocksButton(driver);
			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : " + diyVestPage.isNotePopupVisible(driver));
			testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
			diyVestPage.clickOnNotePopupOkButton(driver);
			testSteps.add("Step " + (++i) + " : Enter New Vest Title: <b>'" + newVestTitle + "'</b>");
			diyVestPage.enterVestName(newVestTitle, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			diyVestPage.clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Vest Created Success Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : " + diyVestPage.isvestCreateSuccessfullyPopupVisible());

			try {
				diyVestPage.clickOnNextPopupButton(driver);
			} catch (Exception e) {
				printString("No PopUp Next Button found", driver);
			}

			// QAA-87
//Not invested vest verification 

			testSteps.add("<b> Step " + (++i) + " : Verifying options for <b>'Not Invested'</b> vest. </b>");

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> is not vested ");
			assertEquals(diyVestPage.getVestedOrNotVestedText(newVestTitle, driver), notInVested,
					"Verified that <b>'" + newVestTitle + "'</b> is not vested");
			try {
				diyVestPage.clickOnCloseChangeHowYourVestAreSortedPopUp(driver);
				testSteps.add("Step " + (++i) + " : click <b>'Close Change How Your Vest Are Sorted Pop Up'</b>");
			} catch (Exception e) {

			}

			testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
					+ newVestTitle + "</b>'");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + Share + "'</b> option is showing ");
			assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, Share, driver),
					"Verified that <b>'" + Share + "'</b> option is displaying");

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + Rebalance + "'</b> option is showing ");
			assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, Rebalance, driver),
					"Verified that <b>'" + Rebalance + "'</b> option is displaying");

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + Rename + "'</b> option is showing ");
			assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, Rename, driver),
					"Verified that <b>'" + Rename + "'</b> option is displaying");

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + Delete + "'</b> option is showing ");
			assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, Delete, driver),
					"Verified that <b>'" + Delete + "'</b> option is displaying");

			// verify share page
			testSteps.add("Step " + (++i) + " : Click on  <b>'" + Share + "'</b> option.");
			diyVestPage.clickVestOptionsVisible(newVestTitle, Share, driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Share your Vest'</b> model window is showing ");
			assertTrue(diyVestPage.isShareYourVestTitleDisplaying(driver),
					"Verified that <b>'Share your Vest'</b> Model is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Page'</b> Button");
			diyVestPage.clickOnPreviewPageBtn(driver);

			List<String> previewPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(previewPageWindow.get(1));

			try {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
				assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
						"Verifying that <b>'Vest Performance'</b> Title is showing");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
				assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
						"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			}

			// Whatsapp Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Whatsapp'</b> Button");
			diyVestPage.clickOnWhatsappBtn(driver);

			List<String> whatsappPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(whatsappPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Whatapp Page'</b> Title is showing");
			assertTrue(diyVestPage.isWhatappPageTitleVisible(driver),
					"Verifying that <b>'Whatapp Page'</b> Title is showing");
			driver.switchTo().window(whatsappPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Whatapp'</b> Page Title");
			closeTab(1, driver);

			// faceBook Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Facebook'</b> Button");
			diyVestPage.clickOnFacebookBtn(driver);

			List<String> facebookPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(facebookPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Facebook Page'</b> Title is showing");
			assertTrue(diyVestPage.isFacebookPageTitleVisible(driver),
					"Verifying that 'Facebook Page' Title is showing");
			driver.switchTo().window(facebookPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Facebook'</b> Page Title");
			closeTab(1, driver);

			// LinkedIn Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnLinkedInBtn(driver);

			List<String> linkedInPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(linkedInPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'LinkedIn Page'</b> Title is showing");
			assertTrue(diyVestPage.isLinkedInPageTitleVisible(driver),
					"Verifying that <b>'LinkedIn Page'<b/> Title is showing");
			driver.switchTo().window(linkedInPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'LinkedIn'</b> Page Title");
			closeTab(1, driver);

			// Twitter Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnTwitterBtn(driver);

			List<String> twitterPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(twitterPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Twitter Page'</b> Title is showing");
			assertTrue(diyVestPage.isTwitterPageTitleVisible(driver),
					"Verifying that <b>'Twitter Page'</b> Title is showing");
			driver.switchTo().window(twitterPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Twitter'</b> Page Title");
			closeTab(1, driver);

			// Gmail Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Gmail'</b> Button");
			diyVestPage.clickOnGmailBtn(driver);

			List<String> gmailPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(gmailPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Gmail Page'</b> Title is showing");
			assertTrue(diyVestPage.isGmailPageTitleVisible(driver),
					"Verifying that <b>'Gmail Page'</b> Title is showing");
			driver.switchTo().window(gmailPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Gmail'</b> Page Title");
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'clip board'</b>");
			diyVestPage.clickOnClipBoardCopy(driver);

			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable contents = clipboard.getContents(null);
			String clipboardUrl = (String) contents.getTransferData(DataFlavor.stringFlavor);

			testSteps.add("Step " + (++i) + " : Open <b>'New Window Tab'</b>");
			diyVestPage.openNewTab(clipboardUrl, driver);

			List<String> newWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newWindow.get(1));

			try {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
				assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
						"Verifying that <b>'Vest Performance'</b> Title is showing");
				driver.switchTo().window(newWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
				assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
						"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
				driver.switchTo().window(newWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			}

			testSteps.add("Step " + (++i) + " : Click On Share Your Vest <b>'Close'</b> Button");
			diyVestPage.clickOnShareYourVestCloseButton(driver);

			// Rename
			testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
					+ newVestTitle + "</b>'");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click on  <b>'" + Rename + "'</b> option.");
			diyVestPage.clickVestOptionsVisible(newVestTitle, Rename, driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Rename'</b> Title is showing");
			assertTrue(diyVestPage.isRenameTitleVisible(driver), "Verifying that <b>'Rename'</b> Title is showing");

			testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
			diyVestPage.enterVestRename(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
			diyVestPage.clickOnRenameVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");
			assertTrue(diyVestPage.isVestOptionsVisible(renameVestTitle, driver),
					"Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");

			testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
					+ renameVestTitle + "'</b> ");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click on  <b>'" + Rename + "'</b> option.");
			diyVestPage.clickVestOptionsVisible(renameVestTitle, Rename, driver);

			testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
			diyVestPage.enterVestRename(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
			diyVestPage.clickOnRenameVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Name Already Created'</b> Popup is showing");
			assertTrue(diyVestPage.isVestNameAlreadyCreatdPopupVisible(driver),
					"Verifying that <b>'Vest Name Already Created'</b> Popup is showing");

			testSteps.add("Step " + (++i) + " : click on <b>'Vest Name Already Creatd Popup Ok'</b> Button");
			diyVestPage.clickOnAlreadyCreatdPopupOkButton(driver);

			testSteps.add("Step " + (++i) + " : Click On Rename Popup <b>'Close'</b> Button");
			diyVestPage.clickOnRenameCloseButton(driver);

			// Rebalance
			testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
					+ renameVestTitle + "'</b> ");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click on  <b>'" + Rebalance + "'</b> option.");
			diyVestPage.clickVestOptionsVisible(renameVestTitle, Rebalance, driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click on <b>'Plus'</b> Button");
			diyVestPage.clickOnStockPlusButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
			diyVestPage.clickOnStockBackButton(driver);

			// delete not invested vest code
			testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
					+ renameVestTitle + "'</b> ");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click on  <b>'" + Delete + "'</b> option.");
			diyVestPage.clickVestOptionsVisible(renameVestTitle, Delete, driver);

			testSteps.add("Step " + (++i) + " : click on <b>'Yes, Delete'</b> Button");
			diyVestPage.clickOnDeleteButton(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'deleted vest'</b> is not present");
			assertFalse(diyVestPage.isVestPresent(renameVestTitle, driver),
					"Verified <b>'delete vest'</b> is not present");

			// write vest creation code .
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-84?atlOrigin=eyJpIjoiZjA1NTEwNTAxYjA3NGVlZGJkMTZmZjNiMDZhNzUwNjQiLCJwIjoiaiJ9\">QAA-84 : [Web automation DIY Vest] Create a new DIY vest on the web<a/>");
			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Dashboard page'</b> is displaying after clicking on <b>'Home'</b> button");

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor3sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOnCreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			diyVestPage.selectStocks(1, driver);
			testSteps.add("Step " + (++i) + " : Verifying: <b>'Stocks/ETFs added Button is enable with one stock'</b>");
			assertFalse(diyVestPage.isAddedStocksButtonEnabled(driver), "'Stocks/ETFs added Button' is enabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is disabled ");

			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			diyVestPage.selectStocks(2, driver);
			testSteps.add("Step " + (++i)
					+ " : Verifying: <b>'Stocks/ETFs added'</b> Button is enable with more than one stock");
			assertTrue(diyVestPage.isAddedStocksButtonEnabled(driver),
					"<b>'Stocks/ETFs added Button'</b> is disabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is enabled ");

			testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
			diyVestPage.clickOnAddedStocksButton(driver);
			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Popup'</b> is visible");
			assertTrue(diyVestPage.isNotePopupVisible(driver), "Note Popup Is not visible");
			testSteps.add("Step " + (++i) + " : Verified: the <b>'Note Popup'</b> is visible");

			testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
			diyVestPage.clickOnNotePopupOkButton(driver);
			testSteps.add("Step " + (++i) + " : Enter New Vest Title: <b>'" + newVestTitle + "'</b>");
			diyVestPage.enterVestName(newVestTitle, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			diyVestPage.clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Vest Created Success Popup'</b> is visible");
			assertTrue(diyVestPage.isvestCreateSuccessfullyPopupVisible(),
					"Vest Created Successfully Popup is not shown");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Vest Created Successfully Popup'</b> is shown");

//		try {
//			diyVestPage.clickOnNextPopupButton();
//		} catch (Exception e) {
//			printString("No PopUp Next Button found");
//		}
//
//		//Code to invest from a newly created vest
//
//		try {
//			diyVestPage.clickOnNextPopupButton();
//		} catch (Exception e) {
//			printString("No PopUp Next Button found");
//		}
			testSteps.add("Step " + (++i) + " : click <b>'Buy'</b> button");
			diyVestPage.clickOnbuyStocksButton(driver);

			testSteps.add("Step " + (++i) + " : Enter Investment Amount: <b>'" + investmentAmount + "'</b>");
			diyVestPage.EnterInvestAmount(investmentAmount, driver);

			testSteps.add("Step " + (++i) + " : click <b>'Purchase Preview'</b> button");
			diyVestPage.clickOnpurchasePreviewButton(driver);
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
				testSteps.add("Step " + (++i) + " : click <b>'Place Buy Order'</b> button");
				diyVestPage.clickOnbuyPlaceOrderButton(driver);

				testSteps.add("<b> Step " + (++i) + " : Verifying options for <b>'Invested'</b> vest. </b>");

				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> is invested ");
				assertEquals(diyVestPage.getVestedOrNotVestedText(newVestTitle, driver), vested,
						"Verified that <b>'" + vested + "'</b> is invested");

				testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
						+ newVestTitle + "</b>'");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + Share + "'</b> option is showing ");
				assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, Share, driver),
						"Verified that <b>'" + Share + "'</b> option is displaying");

//		testSteps.add("Step " + (++i) + " : Verifying that '"+ Rebalance +"' option is showing ");
//		assertTrue(diyVestPage.isVestOptionsVisible(rebalanceVestedName, Rebalance), "Verified that '"+ Rebalance+"' option is displaying");

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + Rename + "'</b> option is showing ");
				assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, Rename, driver),
						"Verified that <b>'" + Rename + "'</b> option is displaying");

				// verify share page
				testSteps.add("Step " + (++i) + " : Click on  <b>'" + Share + "'</b> option.");
				diyVestPage.clickVestOptionsVisible(newVestTitle, Share, driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Share your Vest'</b> model window is showing ");
				assertTrue(diyVestPage.isShareYourVestTitleDisplaying(driver),
						"Verified that <b>'Share your Vest'</b> Model is displaying");

				testSteps.add("Step " + (++i) + " : Click on <b>'Preview Page'</b> Button");
				diyVestPage.clickOnPreviewPageBtn(driver);

				previewPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(previewPageWindow.get(1));

				try {
					testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
					assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
							"Verifying that <b>'Vest Performance'</b> Title is showing");
					driver.switchTo().window(previewPageWindow.get(0));

					testSteps.add(
							"Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
					closeTab(1, driver);
				} catch (Exception e) {
					testSteps
							.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
					assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
							"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
					driver.switchTo().window(previewPageWindow.get(0));

					testSteps.add(
							"Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
					closeTab(1, driver);
				}

				// Whatsapp Button
				testSteps.add("Step " + (++i) + " : Click on <b>'Whatsapp'</b> Button");
				diyVestPage.clickOnWhatsappBtn(driver);

				whatsappPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(whatsappPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Whatapp Page'</b> Title is showing");
				assertTrue(diyVestPage.isWhatappPageTitleVisible(driver),
						"Verifying that <b>'Whatapp Page'</b> Title is showing");
				driver.switchTo().window(whatsappPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Whatapp'</b> Page Title");
				closeTab(1, driver);

				// faceBook Button
				testSteps.add("Step " + (++i) + " : Click on <b>'Facebook'</b> Button");
				diyVestPage.clickOnFacebookBtn(driver);

				facebookPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(facebookPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Facebook Page'</b> Title is showing");
				assertTrue(diyVestPage.isFacebookPageTitleVisible(driver),
						"Verifying that 'Facebook Page' Title is showing");
				driver.switchTo().window(facebookPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Facebook'</b> Page Title");
				closeTab(1, driver);

				// LinkedIn Button
				testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
				diyVestPage.clickOnLinkedInBtn(driver);

				linkedInPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(linkedInPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'LinkedIn Page'</b> Title is showing");
				assertTrue(diyVestPage.isLinkedInPageTitleVisible(driver),
						"Verifying that <b>'LinkedIn Page'<b/> Title is showing");
				driver.switchTo().window(linkedInPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'LinkedIn'</b> Page Title");
				closeTab(1, driver);

				// Twitter Button
				testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
				diyVestPage.clickOnTwitterBtn(driver);

				twitterPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(twitterPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Twitter Page'</b> Title is showing");
				assertTrue(diyVestPage.isTwitterPageTitleVisible(driver),
						"Verifying that <b>'Twitter Page'</b> Title is showing");
				driver.switchTo().window(twitterPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Twitter'</b> Page Title");
				closeTab(1, driver);

				// Gmail Button
				testSteps.add("Step " + (++i) + " : Click on <b>'Gmail'</b> Button");
				diyVestPage.clickOnGmailBtn(driver);

				gmailPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(gmailPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Gmail Page'</b> Title is showing");
//		assertTrue(diyVestPage.isGmailPageTitleVisible(),
//				"Verifying that <b>'Gmail Page'</b> Title is showing");
				driver.switchTo().window(gmailPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Gmail'</b> Page Title");
				closeTab(1, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'clip board'</b>");
				diyVestPage.clickOnClipBoardCopy(driver);

				clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				contents = clipboard.getContents(null);
				clipboardUrl = (String) contents.getTransferData(DataFlavor.stringFlavor);

				testSteps.add("Step " + (++i) + " : Open <b>'New Window Tab'</b>");
				diyVestPage.openNewTab(clipboardUrl, driver);

				newWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(newWindow.get(1));

				try {
					testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
					assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
							"Verifying that <b>'Vest Performance'</b> Title is showing");
					driver.switchTo().window(newWindow.get(0));

					testSteps.add(
							"Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
					closeTab(1, driver);
				} catch (Exception e) {
					testSteps
							.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
					assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
							"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
					driver.switchTo().window(newWindow.get(0));

					testSteps.add(
							"Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
					closeTab(1, driver);
				}

				testSteps.add("Step " + (++i) + " : Click On Share Your Vest <b>'Close'</b> Button");
				diyVestPage.clickOnShareYourVestCloseButton(driver);

				// Rename
				testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
						+ newVestTitle + "</b>'");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click on  <b>'" + Rename + "'</b> option.");
				diyVestPage.clickVestOptionsVisible(newVestTitle, Rename, driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Rename'</b> Title is showing");
				assertTrue(diyVestPage.isRenameTitleVisible(driver), "Verifying that <b>'Rename'</b> Title is showing");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
				diyVestPage.enterVestRename(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");
				assertTrue(diyVestPage.isVestOptionsVisible(renameVestTitle, driver),
						"Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");

				testSteps.add("Step " + (++i) + " : click three dots for <b>'Not Invested'</b> vest name <b>'"
						+ renameVestTitle + "'</b> ");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click on  <b>'" + Rename + "'</b> option.");
				diyVestPage.clickVestOptionsVisible(renameVestTitle, Rename, driver);

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
				diyVestPage.enterVestRename(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps
						.add("Step " + (++i) + " : Verifying that <b>'Vest Name Already Created'</b> Popup is showing");
				assertTrue(diyVestPage.isVestNameAlreadyCreatdPopupVisible(driver),
						"Verifying that <b>'Vest Name Already Created'</b> Popup is showing");

				testSteps.add("Step " + (++i) + " : click on <b>'Vest Name Already Creatd Popup Ok'</b> Button");
				diyVestPage.clickOnAlreadyCreatdPopupOkButton(driver);

				testSteps.add("Step " + (++i) + " : Click On Rename Popup <b>'Close'</b> Button");
				diyVestPage.clickOnRenameCloseButton(driver);

				// Rebalance
				testSteps.add("Step " + (++i) + " : click three dots for <b>'Invested'</b> vest name <b>'"
						+ rebalanceVestedName + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(rebalanceVestedName, driver);

				testSteps.add("Step " + (++i) + " : click on  <b>'" + Rebalance + "'</b> option.");
				diyVestPage.clickVestOptionsVisible(rebalanceVestedName, Rebalance, driver);

				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Plus'</b> Button");
				diyVestPage.clickOnStockPlusButton(driver);

				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
				diyVestPage.clickOnStockBackButton(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVest_CreateNew", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DIYVest_CreateNew " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("DIYVest_CreateNew", testSteps, driver);

			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVest_CreateNew " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("DIYVest_CreateNew", testSteps, driver);
			assertTrue(false);
		}
	}

	@Test
	public void DIYVest_CreateNew() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String newVestTitle = "QAduplicatetestingvest" + generateRandomNumberWithGivenNumberOfDigits(2, driver);
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_CreateNew:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-84?atlOrigin=eyJpIjoiZjA1NTEwNTAxYjA3NGVlZGJkMTZmZjNiMDZhNzUwNjQiLCJwIjoiaiJ9\">QAA-84 : [Web automation DIY Vest] Create a new DIY vest on the web<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor5sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOncreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			diyVestPage.selectStocks(1, driver);
			testSteps.add("Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button status: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			diyVestPage.selectStocks(2, driver);
			testSteps.add(
					"Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with more than one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button status: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
			diyVestPage.clickOnAddedStocksButton(driver);
			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : " + diyVestPage.isNotePopupVisible(driver));
			testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
			diyVestPage.clickOnNotePopupOkButton(driver);
			testSteps.add("Step " + (++i) + " : Enter New Vest Title: <b>'" + newVestTitle + "'</b>");
			diyVestPage.enterVestName(newVestTitle, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			diyVestPage.clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Vest Created Success Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : " + diyVestPage.isvestCreateSuccessfullyPopupVisible());

			try {
				diyVestPage.clickOnNextPopupButton(driver);
			} catch (Exception e) {
				printString("No PopUp Next Button found", driver);
			}

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Deleteing <b>'" + newVestTitle + "'</b> Vest");
			diyVestPage.deleteDIYVest(driver, newVestTitle);

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVest_CreateNew", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: DIYVest_CreateNew " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_CreateNew") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_CreateNew", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: DIYVest_CreateNew " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_CreateNew") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_CreateNew", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DIYVestNew_NotAbleToAddOTCStocks() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String newVestTitle = "QAduplicatetestingvest" + generateRandomNumberWithGivenNumberOfDigits(2, driver);
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVestNew_NotAbleToAddOTCStocks:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-850?atlOrigin=eyJpIjoiZjA1NTEwNTAxYjA3NGVlZGJkMTZmZjNiMDZhNzUwNjQiLCJwIjoiaiJ9\">QAA-850 : [Web] - While user create new account, Verify user is not able to create \"DIY Vest\" with OTC stocks/instruments\r\n"
							+ "<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.clickOnDiyVestBtn(driver);

			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor5sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOncreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Search OTC Stock <b>'GBTC'</b>");
			diyVestPage.EnterValueInSearchBar("GBTC", driver);
			testSteps.add("Step " + (++i) + " : Verify GBTC Stock should not be visible in list");
			assertTrue(diyVestPage.verifyStockIsNotDisplayed(driver));
			testSteps.add("Step " + (++i) + " : Search OTC Stock <b>'ADDY'</b>");
			diyVestPage.EnterValueInSearchBar("ADDYY", driver);
			testSteps.add("Step " + (++i) + " : Verify ADDY Stock should not be visible in list");
			assertTrue(diyVestPage.verifyStockIsNotDisplayed(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVestNew_NotAbleToAddOTCStocks", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DIYVestNew_NotAbleToAddOTCStocks " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_NotAbleToAddOTCStocks") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_NotAbleToAddOTCStocks", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVestNew_NotAbleToAddOTCStocks " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_NotAbleToAddOTCStocks") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_NotAbleToAddOTCStocks", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DIYVestRebalancing_NotAbleToAddOTCStocks() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String newVestTitle = "QAduplicatetestingvest" + generateRandomNumberWithGivenNumberOfDigits(2, driver);
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVestNew_RebalancingDIYVest:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-853?atlOrigin=eyJpIjoiZjA1NTEwNTAxYjA3NGVlZGJkMTZmZjNiMDZhNzUwNjQiLCJwIjoiaiJ9\">QAA-853 : [Web] - While rebalancing DIY Vest, Verify that user is not able to add OTC stocks/instruments\r\n"
							+ "<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.waitTillTenSeconds(driver);
			navigationPage.clickOnDiyVestBtn(driver);

			waitfor5sec();

			testSteps.add("Step " + (++i) + " : Click on Three Dots of Vest : <b>BuyVest1362617</b>");

			diyVestPage.clickOnThreeDot(driver, "BuyVest1362617");
			testSteps.add("Step " + (++i) + " : Click on <b>Rebalancing</b> option of Vest");
			diyVestPage.clickOnThreeDotOption(driver, "BuyVest1362617", "Rebalance");
			testSteps.add("Step " + (++i) + " : Search OTC Stock <b>'GBTC'</b>");
			diyVestPage.EnterValueInSearchBar("GBTC", driver);
			testSteps.add("Step " + (++i) + " : Verify GBTC Stock should not be visible in list");
			assertTrue(diyVestPage.verifyStockIsNotDisplayed(driver));
			testSteps.add("Step " + (++i) + " : Search OTC Stock <b>'ADDY'</b>");
			diyVestPage.EnterValueInSearchBar("ADDYY", driver);
			testSteps.add("Step " + (++i) + " : Verify ADDY Stock should not be visible in list");
			assertTrue(diyVestPage.verifyStockIsNotDisplayed(driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVestNew_RebalancingDIYVest", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DIYVestNew_RebalancingDIYVest " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_RebalancingDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_RebalancingDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVestNew_RebalancingDIYVest " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_RebalancingDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_RebalancingDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void DIYVestNew_CancelPendingOrders() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		driver = initConfiguration();

		String newVestTitle = "QAduplicatetestingvest";
		String duplicatePopupTitle = "Vest Name";
		String duplicatePopupContent = "Sorry, you�ve already created a vest with the name " + newVestTitle
				+ ". Please choose a different name.";
		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		instrumentPage = new InstrumentPage(driver);
		printString("DIYVestNew_CancelPendingOrders:" + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-780?atlOrigin=eyJpIjoiZjFiMDhkZmQ5NTU2NDExMmIyMzJhNjIxY2RjNzkzOTkiLCJwIjoiaiJ9\">QAA-780 : [Web] - Verify that user is able to cancel pending orders\r\n"
							+ "<a/>");

			loginPage.loginToApp(driver);
			navigationPage.waitTillTenSeconds(driver);

//			ArrayList<String> steps = diyVestPage.createDIYVest(driver, newVestTitle, i);
//			i = i + steps.size();
//			testSteps.addAll(steps);

//			testSteps.add("Step " + (++i) + " : Verify <b>'Pending Orders'</b> section is visible");
//			assertTrue(diyVestPage.isPendingOrdersSectionVisible(driver));
//
//			int ordersCount = diyVestPage.getPendingOrdersCount(driver);
//			System.out.println("ordersCount" + ordersCount);
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>i</b> icon is visible");
//			assertTrue(diyVestPage.isIiconVisible(driver));

			testSteps.add("Step " + (++i) + " : Click on <b>Order</b> Tab");
			instrumentPage.clickOnOrderTab(driver);
			
			testSteps.add("Step " + (++i) + " : Click on <b>i</b> icon");
			diyVestPage.clickOnPendingVestInfoIcon(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>Pending Orders</b> popup is displaying");
			assertTrue(diyVestPage.isPendingOrdersPopupVisible(driver));

			testSteps.add("Step " + (++i) + " : Click on <b>Cross Icon</b> on Pending Orders popup");
			diyVestPage.clickOnCrossIcon(driver);
			
			testSteps.addAll(instrumentPage.ClosePendingOrders(driver));

//			testSteps.add("Step " + (++i) + " : Verify <b>Cancel Button</b> is displayed");
//			diyVestPage.isCancelButtonDisplayed(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>Cancel</b> Button");
//			diyVestPage.clickOnCancelButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>Warning Popup</b> is displayed");
//			assertTrue(diyVestPage.isWarningPopupDisplayed(driver));
//
//			testSteps.add("Step " + (++i) + " : Click on <b>NO</b> button");
//			diyVestPage.clickOnNoButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify Warning popup is disappeared");
//			assertFalse(diyVestPage.isWarningPopupDisplayed(driver));
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>Warning Popup</b> is displayed");
//			diyVestPage.cancelAllPendingOrders(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>Order</b> cancelled Successfully without any error");
//			int updatedOrdersCount = diyVestPage.getPendingOrdersCount(driver);
//			System.out.println("updatedOrdersCount" + updatedOrdersCount);
//			Assert.assertNotEquals(ordersCount, updatedOrdersCount);

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVestNew_CancelPendingOrders", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: DIYVestNew_CancelPendingOrders " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_CancelPendingOrders") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_CancelPendingOrders", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVestNew_CancelPendingOrders " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_CancelPendingOrders") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_CancelPendingOrders", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);

		}

	}

	@Test
	public void DIYVestNew_VerifyOTCScreenOnDashboard() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		LoginPage loginPage;
		driver = initConfiguration();

		String newVestTitle = "QAduplicatetestingvest";
		String duplicatePopupTitle = "Vest Name";
		String duplicatePopupContent = "Sorry, you�ve already created a vest with the name " + newVestTitle
				+ ". Please choose a different name.";
		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVestNew_VerifyOTCScreenOnDashboard:" + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-857?atlOrigin=eyJpIjoiZjFiMDhkZmQ5NTU2NDExMmIyMzJhNjIxY2RjNzkzOTkiLCJwIjoiaiJ9\">QAA-857 : [Web] - While user logged in with existing user, Verify the \"OTC\" section on dashboard screen\r\n"
							+ "<a/>");

			loginPage.loginToApp(driver);
			navigationPage.waitTillTenSeconds(driver);

//			ArrayList<String> steps = diyVestPage.createDIYVest(driver, newVestTitle, i);
//			i = i + steps.size();
//			testSteps.addAll(steps);

			testSteps.add("Step " + (++i) + " : Verify <b>'OTC Heading'</b> is available in Explore section");
			assertTrue(diyVestPage.isOTCHeadingDisplayed(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>Show All</b> option is available");
			assertTrue(diyVestPage.isShowAllDisplayed(driver));

			testSteps.add("Step " + (++i) + " : Verify <b>Show All</b> option is clickable");
			assertTrue(diyVestPage.isShowAllClickable(driver));

			testSteps.add("Step " + (++i) + " : Click <b>Show All</b> option");
			diyVestPage.clickOTCShowAll(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>Lightwave Logic Inc</b> OTC is available and clickable");
			assertTrue(diyVestPage.isOTCAvailableAndClickable("Lightwave Logic Inc", driver));

			testSteps.add("Step " + (++i) + " : Verify <b>Alpine 4 Holdings Inc</b> OTC is available and clickable");
			assertTrue(diyVestPage.isOTCAvailableAndClickable("Alpine 4 Holdings Inc", driver));

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVestNew_VerifyOTCScreenOnDashboard", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: DIYVestNew_VerifyOTCScreenOnDashboard " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_VerifyOTCScreenOnDashboard") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_VerifyOTCScreenOnDashboard", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVestNew_VerifyOTCScreenOnDashboard " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVestNew_VerifyOTCScreenOnDashboard") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVestNew_VerifyOTCScreenOnDashboard", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);

		}

	}

	@Test
	public void DIYVest_CreateDuplicate() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		LoginPage loginPage;
		driver = initConfiguration();

		String newVestTitle = "QAduplicatetestingvest";
		String duplicatePopupTitle = "Vest Name";
		String duplicatePopupContent = "Sorry, you�ve already created a vest with the name " + newVestTitle
				+ ". Please choose a different name.";
		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_CreateDuplicate:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-85?atlOrigin=eyJpIjoiZjFiMDhkZmQ5NTU2NDExMmIyMzJhNjIxY2RjNzkzOTkiLCJwIjoiaiJ9\">QAA-85 : [Web Automation DIY Vest] Create a duplicate vest name, user should not be allowed to create a duplicate vest name<a/>");

			loginPage.loginToApp(driver);
			testSteps.add("Step " + (++i) + " : click <b>'DIY Vest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			ArrayList<String> steps = diyVestPage.createDIYVest(driver, newVestTitle, i);
			i = i + steps.size();
			testSteps.addAll(steps);

			testSteps.add("Step " + (++i) + " : <b>Creating Dupliate DiyVest</b> ");

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor3sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOnCreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			diyVestPage.selectStocks(1, driver);

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Stocks/ETFs added Button is enable with one stock'</b>");
			assertFalse(diyVestPage.isAddedStocksButtonEnabled(driver),
					"<b>'Stocks/ETFs added Button'</b> is enabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is disabled");
			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			diyVestPage.selectStocks(2, driver);
			testSteps.add("Step " + (++i)
					+ " : Verifying: <b>'Stocks/ETFs added'</b> Button is enable with more than one stock");
			assertTrue(diyVestPage.isAddedStocksButtonEnabled(driver),
					"<b>'Stocks/ETFs added Button'</b> is disabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is enabled ");

			testSteps.add("Step " + (++i) + " : click <b>'Stocks/ETFs added'</b> button");
			diyVestPage.clickOnAddedStocksButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Popup'</b> is visible");
			assertTrue(diyVestPage.isNotePopupVisible(driver), "Note Popup Is not visible");

			testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
			diyVestPage.clickOnNotePopupOkButton(driver);

			testSteps.add("Step " + (++i) + " : Enter New Vest Title: <b>'" + newVestTitle + "'</b>");
			diyVestPage.enterVestName(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			diyVestPage.clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Already Created Vest Popup'</b> is visible");
			assertTrue(diyVestPage.isDuplicateVestPopupVisible(driver),
					"<b>'Already Created Vest Popup'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified: the <b>'Already Created Vest Popup'</b> is visible");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Duplicate Created Vest PopUp'</b> Title");
			assertEquals(duplicatePopupTitle, diyVestPage.getDuplicateVestPopUpTitle(driver),
					"Duplicate Vest Popup Title Mismatch");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Duplicate Created Vest PopUp'</b> Title");

			testSteps.add("Step " + (++i) + " : Verifying <b>'Duplicate Created Vest PopUp'</b> Description:"
					+ duplicatePopupContent);
			assertTrue(diyVestPage.getDuplicateVestPopUpDescription(driver, newVestTitle),
					"Duplicate Vest Popup Description Mismatch");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Duplicate Created Vest PopUp'</b> Description");

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVest_CreateDuplicate", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: DIYVest_CreateDuplicate " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_CreateDuplicate") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_CreateDuplicate", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: DIYVest_CreateDuplicate " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_CreateDuplicate") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_CreateDuplicate", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyVestBreakdownBlock() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String newVestTitle = "breakdownBlocktestingvest";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("VerifyVestBreakdownBlock:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-288?atlOrigin=eyJpIjoiZjFiMDhkZmQ5NTU2NDExMmIyMzJhNjIxY2RjNzkzOTkiLCJwIjoiaiJ9\">QAA-288 : Web - Verify Vest Breakdown Block<a/>");

			loginPage.loginToApp(driver);
			testSteps.add("Step " + (++i) + " : click <b>'DIY Vest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			ArrayList<String> steps = diyVestPage.createDIYVest(driver, newVestTitle, i);
			i = i + steps.size();
			testSteps.addAll(steps);

			try {
				diyVestPage.clickVest(newVestTitle, driver);
				testSteps.add("Step " + (++i) + " : click <b>'" + newVestTitle + "'</b> Vest");
				try {
					diyVestPage.clickOnNextPopupButton(driver);
				} catch (Exception e1) {
					printString("No PopUp Next Button found", driver);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			ArrayList<Double> beforeUpdate = diyVestPage.getBreakdownVestValue();
			testSteps.add("Step " + (++i) + " : click <b>'Allocation'</b> option");
			testSteps.add("<b>" + diyVestPage.getBreakdownVestName() + "</b>" + " = "
					+ diyVestPage.getBreakdownVestValue().toString());

			testSteps.add("Step " + (++i) + " : click <b>'Allocation'</b> button");
			diyVestPage.clickOnAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'1w'</b> option");
			diyVestPage.clickOnAllocationOption("1w", driver);
			testSteps.add("<b>" + diyVestPage.getBreakdownVestName() + "</b>" + " = "
					+ diyVestPage.getBreakdownVestValue().toString());

			testSteps.add("Step " + (++i) + " : click <b>'Allocation'</b> button");
			diyVestPage.clickOnAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'1m'</b> option");
			diyVestPage.clickOnAllocationOption("1m", driver);
			testSteps.add("<b>" + diyVestPage.getBreakdownVestName() + "</b>" + " = "
					+ diyVestPage.getBreakdownVestValue().toString());

			testSteps.add("Step " + (++i) + " : click <b>'Allocation'</b> button");
			diyVestPage.clickOnAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'3m'</b> option");
			diyVestPage.clickOnAllocationOption("3m", driver);
			testSteps.add("<b>" + diyVestPage.getBreakdownVestName() + "</b>" + " = "
					+ diyVestPage.getBreakdownVestValue().toString());

			testSteps.add("Step " + (++i) + " : click <b>'Allocation'</b> button");
			diyVestPage.clickOnAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'1y'</b> option");
			diyVestPage.clickOnAllocationOption("1y", driver);
			testSteps.add("<b>" + diyVestPage.getBreakdownVestName() + "</b>" + " = "
					+ diyVestPage.getBreakdownVestValue().toString());

			testSteps.add("Step " + (++i) + " : click <b>'Allocation'</b> button");
			diyVestPage.clickOnAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'5y'</b> option");
			diyVestPage.clickOnAllocationOption("5y", driver);
			testSteps.add("<b>" + diyVestPage.getBreakdownVestName() + "</b>" + " = "
					+ diyVestPage.getBreakdownVestValue().toString());

			testSteps.add("Step " + (++i) + " : click <b>'Edit Allocation'</b> button");
			diyVestPage.clickOnEditAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'Plus'</b> button to update stock allocations");
			diyVestPage.clickOnPlusAllocationButton(driver, "1", 3);

			testSteps.add("Step " + (++i) + " : click <b>'Update Allocation'</b> button");
			diyVestPage.clickOnUpdateAllocationButton(driver);

			assertTrue(diyVestPage.isRebalanceSuccessMessageDisplay(driver), "Success Screen Not Display");

			testSteps.add("Step " + (++i) + " : click <b>'Back To DIY Vest'</b> button");
			diyVestPage.clickOnBackToDIYVestButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'" + newVestTitle + "'</b> Vest");
			diyVestPage.clickVest(newVestTitle, driver);

			try {
				diyVestPage.clickOnNextPopupButton(driver);
			} catch (Exception e) {
				printString("No PopUp Next Button found", driver);
			}

			ArrayList<Double> afterUpdate = diyVestPage.getBreakdownVestValue();

//			testSteps.add("Step " + (++i) + " : Verifying Stock Allocation Updated Successfully ");
//			testSteps.add("Step " + (++i) + " : Stock Value Before Update: " + beforeUpdate.get(0));
//			testSteps.add("Step " + (++i) + " : Stock Value After Update: " + afterUpdate.get(0));
//			assertTrue(beforeUpdate.get(0) < afterUpdate.get(0), "Stock Allocation is not updated");
//			testSteps.add("Step " + (++i) + " : Verifyied Stock Allocation Updated Successfully");

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyVestBreakdownBlock", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: VerifyVestBreakdownBlock " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyVestBreakdownBlock") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyVestBreakdownBlock", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyVestBreakdownBlock " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyVestBreakdownBlock") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyVestBreakdownBlock", testSteps, driver);
			} else {
				closeBrowser(driver);
			}

			assertTrue(false);
		}

	}

	@Test
	public void VerifyThreeDotOption_NotInvestedDIYVest() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String newVestTitle = "NotInvestedVest" + generateRandomNumberWithGivenNumberOfDigits(2, driver);
		String renameVestTitle = "Renamed" + newVestTitle;
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_CreateNew:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-164?atlOrigin=eyJpIjoiMmVlZGMyMDJlNTdiNDRiMzgyY2VmNzM2NDk3Y2JhNzMiLCJwIjoiaiJ9\">QAA-164.1 : Check the options {'Share' , 'Rebalance', 'Rename', 'Delete'} for 'Not Invested' Vest.<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : creating <b>'" + newVestTitle + "'</b> DIY Vest");
			diyVestPage.createDIYVest(driver, newVestTitle, i);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Share'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Share"),
					"<b>'Share'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> option is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Rebalance'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Rebalance"),
					"<b>'Rebalance'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Rebalance'</b> option is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Rename'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Rename"),
					"<b>'Rename'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Rename'</b> option is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Delete'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Delete"),
					"<b>'Delete'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Delete'</b> option is visible");

			// Share
			testSteps.add("<b>*************Verifying " + newVestTitle + " DIY Vest Share Options*************</b>");
			testSteps.add("Step " + (++i) + " : click On 'Share' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Share");

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Share'</b> Popup is visible");
			assertTrue(diyVestPage.VerifyShareDIYVestPopup(driver), "<b>'Share'</b> Popup is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> Popup is visible");

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Page'</b> Button");
			diyVestPage.clickOnPreviewPageBtn(driver);

			List<String> previewPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(previewPageWindow.get(1));

			try {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
				assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
						"Verifying that <b>'Vest Performance'</b> Title is showing");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
				assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
						"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			}

			// Whatsapp Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Whatsapp'</b> Button");
			diyVestPage.clickOnWhatsappBtn(driver);

			List<String> whatsappPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(whatsappPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Whatapp Page'</b> Title is showing");
			assertTrue(diyVestPage.isWhatappPageTitleVisible(driver),
					"Verifying that <b>'Whatapp Page'</b> Title is showing");
			driver.switchTo().window(whatsappPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Whatapp'</b> Page Title");
			closeTab(1, driver);

			// faceBook Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Facebook'</b> Button");
			diyVestPage.clickOnFacebookBtn(driver);

			List<String> facebookPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(facebookPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Facebook Page'</b> Title is showing");
			assertTrue(diyVestPage.isFacebookPageTitleVisible(driver),
					"Verifying that 'Facebook Page' Title is showing");
			driver.switchTo().window(facebookPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Facebook'</b> Page Title");
			closeTab(1, driver);

			// LinkedIn Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnLinkedInBtn(driver);

			List<String> linkedInPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(linkedInPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'LinkedIn Page'</b> Title is showing");
			assertTrue(diyVestPage.isLinkedInPageTitleVisible(driver),
					"Verifying that <b>'LinkedIn Page'<b/> Title is showing");
			driver.switchTo().window(linkedInPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'LinkedIn'</b> Page Title");
			closeTab(1, driver);

			// Twitter Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnTwitterBtn(driver);

			List<String> twitterPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(twitterPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Twitter Page'</b> Title is showing");
			assertTrue(diyVestPage.isTwitterPageTitleVisible(driver),
					"Verifying that <b>'Twitter Page'</b> Title is showing");
			driver.switchTo().window(twitterPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Twitter'</b> Page Title");
			closeTab(1, driver);

			// Gmail Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Gmail'</b> Button");
			diyVestPage.clickOnGmailBtn(driver);

			List<String> gmailPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(gmailPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Gmail Page'</b> Title is showing");
			assertTrue(diyVestPage.isGmailPageTitleVisible(driver),
					"Verifying that <b>'Gmail Page'</b> Title is showing");
			driver.switchTo().window(gmailPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Gmail'</b> Page Title");
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : click <b>'Close Icon'</b> Of Share Popup");
			diyVestPage.clickOnCloseIcon(driver);

			// Rebalance Option
			testSteps.add("<b>*************Rebalancing " + newVestTitle + " DIY Vest*************</b>");

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click On 'Rebalance' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rebalance");

			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click on <b>'Plus'</b> Button");
			diyVestPage.clickOnStockPlusButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click on <b>'Update Allocation'</b> Button");
			diyVestPage.clickOnUpdateAllocationButton(driver);

			testSteps.add("Step " + (++i) + " : click on <b>'Back To DIY Vest'</b> Button");
			diyVestPage.clickOnBackToDIYVestButton(driver);

			// Rename
			testSteps.add("<b>*************Renaming " + newVestTitle + " DIY Vest*************</b>");

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rename");

			testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
			diyVestPage.enterVestRename(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
			diyVestPage.clickOnRenameVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");
			assertTrue(diyVestPage.isVestOptionsVisible(renameVestTitle, driver),
					"Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + renameVestTitle + "'</b>");
			diyVestPage.clickOnThreeDot(driver, renameVestTitle);

			testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + renameVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, renameVestTitle, "Rename");

			testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
			diyVestPage.enterVestRename(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
			diyVestPage.clickOnRenameVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Name Already Created'</b> Popup is showing");
			assertTrue(diyVestPage.isVestNameAlreadyCreatdPopupVisible(driver),
					"Verifying that <b>'Vest Name Already Created'</b> Popup is showing");

			testSteps.add("Step " + (++i) + " : click on <b>'Vest Name Already Creatd Popup Ok'</b> Button");
			diyVestPage.clickOnAlreadyCreatdPopupOkButton(driver);

			testSteps.add("Step " + (++i) + " : Click On Rename Popup <b>'Close'</b> Button");
			diyVestPage.clickOnCloseIcon(driver);

			// Delete
			testSteps.add("<b>*************Deleting " + renameVestTitle + " DIY Vest*************</b>");

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + renameVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(renameVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click On 'Delete' of <b>'" + renameVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, renameVestTitle, "Delete");

			testSteps.add("Step " + (++i) + " : click on <b>'Yes, Delete'</b> Button");
			diyVestPage.clickOnDeleteButton(driver);

			waitTime(5000, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'deleted vest'</b> is not present");
			assertFalse(diyVestPage.isVestPresent(renameVestTitle, driver),
					"Verified <b>'delete vest'</b> is not present");

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyThreeDotOption_NotInvestedDIYVest", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: VerifyThreeDotOption_NotInvestedDIYVest " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyThreeDotOption_NotInvestedDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_NotInvestedDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyThreeDotOption_NotInvestedDIYVest " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyThreeDotOption_NotInvestedDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_NotInvestedDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void VerifyThreeDotOption_SameDayInvestedDIYVest() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		String newVestTitle = "SameInvestedVest" + generateRandomNumberWithGivenNumberOfDigits(2, driver);
		String renameVestTitle = "Renamed" + newVestTitle;
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_CreateNew:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-164?atlOrigin=eyJpIjoiMmVlZGMyMDJlNTdiNDRiMzgyY2VmNzM2NDk3Y2JhNzMiLCJwIjoiaiJ9\">QAA-164.4 : Check the options {'Share', 'Rename'} for 'Invested' Vest on the same day.<a/>");

			loginPage.loginToApp(driver);
			if (instrumentPage.isMarketClose(driver)) {

				testSteps.add("Step " + (++i) + " : Market is close due to which we can't invest amount in DIY Vest");

			} else {
				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : creating <b>'" + newVestTitle + "'</b> DIY Vest");
				diyVestPage.createDIYVest(driver, newVestTitle, i);

				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				try {
					diyVestPage.clickVest(newVestTitle, driver);
					testSteps.add("Step " + (++i) + " : click <b>'" + newVestTitle + "'</b> Vest");
					try {
						diyVestPage.clickOnNextPopupButton(driver);
					} catch (Exception e1) {
						printString("No PopUp Next Button found", driver);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				testSteps.add("Step " + (++i) + " : click <b>'Buy'</b> button");
				diyVestPage.clickOnbuyStocksButton(driver);
				testSteps.add("Step " + (++i) + " : Entering Invested Amount: 51");
				diyVestPage.EnterInvestAmount("51", driver);
				if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
					testSteps.add("Step " + (++i) + " : click <b>'Preview Order'</b> button");
					diyVestPage.clickOnpurchasePreviewButton(driver);

					testSteps.add("Step " + (++i) + " : click <b>'Place Buy Order'</b> button");
					diyVestPage.clickOnbuyPlaceOrderButton(driver);
				}
				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Verifying the <b>'Share'</b> option is visible");
				assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Share"),
						"<b>'Share'</b> option is not visible");
				testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> option is visible");

				testSteps.add("Step " + (++i) + " : Verifying the <b>'Rebalance'</b> option is visible");
				assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Rebalance"),
						"<b>'Rebalance'</b> option is not visible");
				testSteps.add("Step " + (++i) + " : Verifyied: <b>'Rebalance'</b> option is visible");

				testSteps.add("Step " + (++i) + " : Verifying the <b>'Rename'</b> option is visible");
				assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Rename"),
						"<b>'Rename'</b> option is not visible");
				testSteps.add("Step " + (++i) + " : Verifyied: <b>'Rename'</b> option is visible");

				testSteps.add("Step " + (++i) + " : Verifying the <b>'Delete'</b> option is visible");
				assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Delete"),
						"<b>'Delete'</b> option is not visible");
				testSteps.add("Step " + (++i) + " : Verifyied: <b>'Delete'</b> option is visible");

				// Share
				testSteps.add("<b>*************Verifying " + newVestTitle + " DIY Vest Share Options*************</b>");
				testSteps.add("Step " + (++i) + " : click On 'Share' of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Share");

				testSteps.add("Step " + (++i) + " : Verifying: <b>'Share'</b> Popup is visible");
				assertTrue(diyVestPage.VerifyShareDIYVestPopup(driver), "<b>'Share'</b> Popup is not visible");
				testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> Popup is visible");

				testSteps.add("Step " + (++i) + " : Click on <b>'Preview Page'</b> Button");
				diyVestPage.clickOnPreviewPageBtn(driver);

				List<String> previewPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(previewPageWindow.get(1));

				try {
					testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
					assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
							"Verifying that <b>'Vest Performance'</b> Title is showing");
					driver.switchTo().window(previewPageWindow.get(0));

					testSteps.add(
							"Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
					closeTab(1, driver);
				} catch (Exception e) {
					testSteps
							.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
					assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
							"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
					driver.switchTo().window(previewPageWindow.get(0));

					testSteps.add(
							"Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
					closeTab(1, driver);
				}

				// Whatsapp Button
				testSteps.add("Step " + (++i) + " : Click on <b>'Whatsapp'</b> Button");
				diyVestPage.clickOnWhatsappBtn(driver);

				List<String> whatsappPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(whatsappPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Whatapp Page'</b> Title is showing");
				assertTrue(diyVestPage.isWhatappPageTitleVisible(driver),
						"Verifying that <b>'Whatapp Page'</b> Title is showing");
				driver.switchTo().window(whatsappPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Whatapp'</b> Page Title");
				closeTab(1, driver);

				// faceBook Button
				testSteps.add("Step " + (++i) + " : Click on <b>'Facebook'</b> Button");
				diyVestPage.clickOnFacebookBtn(driver);

				List<String> facebookPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(facebookPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Facebook Page'</b> Title is showing");
				assertTrue(diyVestPage.isFacebookPageTitleVisible(driver),
						"Verifying that 'Facebook Page' Title is showing");
				driver.switchTo().window(facebookPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Facebook'</b> Page Title");
				closeTab(1, driver);

				// LinkedIn Button
				testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
				diyVestPage.clickOnLinkedInBtn(driver);

				List<String> linkedInPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(linkedInPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'LinkedIn Page'</b> Title is showing");
				assertTrue(diyVestPage.isLinkedInPageTitleVisible(driver),
						"Verifying that <b>'LinkedIn Page'<b/> Title is showing");
				driver.switchTo().window(linkedInPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'LinkedIn'</b> Page Title");
				closeTab(1, driver);

				// Twitter Button
				testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
				diyVestPage.clickOnTwitterBtn(driver);

				List<String> twitterPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(twitterPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Twitter Page'</b> Title is showing");
				assertTrue(diyVestPage.isTwitterPageTitleVisible(driver),
						"Verifying that <b>'Twitter Page'</b> Title is showing");
				driver.switchTo().window(twitterPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Twitter'</b> Page Title");
				closeTab(1, driver);

				// Gmail Button
				testSteps.add("Step " + (++i) + " : Click on <b>'Gmail'</b> Button");
				diyVestPage.clickOnGmailBtn(driver);

				List<String> gmailPageWindow = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(gmailPageWindow.get(1));

				testSteps.add("Step " + (++i) + " : Verifying that <b>'Gmail Page'</b> Title is showing");
				assertTrue(diyVestPage.isGmailPageTitleVisible(driver),
						"Verifying that <b>'Gmail Page'</b> Title is showing");
				driver.switchTo().window(gmailPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Gmail'</b> Page Title");
				closeTab(1, driver);

				testSteps.add("Step " + (++i) + " : click <b>'Close Icon'</b> Of Share Popup");
				diyVestPage.clickOnCloseIcon(driver);

				// Rename
				testSteps.add("<b>*************Renaming " + newVestTitle + " DIY Vest*************</b>");

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rename");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
				diyVestPage.enterVestRename(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");
				assertTrue(diyVestPage.isVestOptionsVisible(renameVestTitle, driver),
						"Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDot(driver, renameVestTitle);

				testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, renameVestTitle, "Rename");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
				diyVestPage.enterVestRename(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps
						.add("Step " + (++i) + " : Verifying that <b>'Vest Name Already Created'</b> Popup is showing");
				assertTrue(diyVestPage.isVestNameAlreadyCreatdPopupVisible(driver),
						"Verifying that <b>'Vest Name Already Created'</b> Popup is showing");

				testSteps.add("Step " + (++i) + " : click on <b>'Vest Name Already Creatd Popup Ok'</b> Button");
				diyVestPage.clickOnAlreadyCreatdPopupOkButton(driver);

				testSteps.add("Step " + (++i) + " : Click On Rename Popup <b>'Close'</b> Button");
				diyVestPage.clickOnCloseIcon(driver);

				try {
					diyVestPage.clickVest(newVestTitle, driver);
					testSteps.add("Step " + (++i) + " : click <b>'" + newVestTitle + "'</b> Vest");
					try {
						diyVestPage.clickOnNextPopupButton(driver);
					} catch (Exception e1) {
						printString("No PopUp Next Button found", driver);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

				diyVestPage.clickOnSellStocksButton(driver);
				diyVestPage.checkSellAllButton(driver);
				if (!driver.getCurrentUrl().contains("prod")) {
					diyVestPage.clickOnSellPreviewButton(driver);
					diyVestPage.clickOnPlaceSellOrderButton(driver);
				}

				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				getRefreshWebPage(driver);
				wait6s();
				// Delete
				testSteps.add("<b>*************Deleting " + renameVestTitle + " DIY Vest*************</b>");

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click On 'Delete' of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, renameVestTitle, "Delete");

				testSteps.add("Step " + (++i) + " : click on <b>'Yes, Delete'</b> Button");
				diyVestPage.clickOnDeleteButton(driver);

				waitTime(5000, driver);
				testSteps.add("Step " + (++i) + " : Verify <b>'deleted vest'</b> is not present");
				assertFalse(diyVestPage.isVestPresent(renameVestTitle, driver),
						"Verified <b>'delete vest'</b> is not present");

			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyThreeDotOption_SameDayInvestedDIYVest", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: VerifyThreeDotOption_SameDayInvestedDIYVest " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyThreeDotOption_SameDayInvestedDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_SameDayInvestedDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: VerifyThreeDotOption_SameDayInvestedDIYVest " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyThreeDotOption_SameDayInvestedDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_SameDayInvestedDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void VerifyThreeDotOption_InvestedDIYVest() {

		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		// String newVestTitle = "NotInvestedVest" +
		// generateRandomNumberWithGivenNumberOfDigits(2, driver);
		String newVestTitle = "InvestedVest";
		String renameVestTitle = "Renamed" + newVestTitle;
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("VerifyThreeDotOption_InvestedDIYVest:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-164?atlOrigin=eyJpIjoiMmVlZGMyMDJlNTdiNDRiMzgyY2VmNzM2NDk3Y2JhNzMiLCJwIjoiaiJ9\">QAA-164.2 : Check the options {'Share' , 'Rebalance', 'Rename'} for 'Invested' Vest.<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : creating <b>'" + newVestTitle + "'</b> DIY Vest");
			diyVestPage.createDIYVest(driver, newVestTitle, i);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Share'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Share"),
					"<b>'Share'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> option is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Rebalance'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Rebalance"),
					"<b>'Rebalance'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Rebalance'</b> option is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Rename'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Rename"),
					"<b>'Rename'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Rename'</b> option is visible");

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Delete'</b> option is visible");
			assertTrue(diyVestPage.VerifyThreeDotOptionisDisplaying(driver, newVestTitle, "Delete"),
					"<b>'Delete'</b> option is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Delete'</b> option is visible");

			// Share
			testSteps.add("<b>*************Verifying " + newVestTitle + " DIY Vest Share Options*************</b>");
			testSteps.add("Step " + (++i) + " : click On 'Share' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Share");

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Share'</b> Popup is visible");
			assertTrue(diyVestPage.VerifyShareDIYVestPopup(driver), "<b>'Share'</b> Popup is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> Popup is visible");

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Page'</b> Button");
			diyVestPage.clickOnPreviewPageBtn(driver);

			List<String> previewPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(previewPageWindow.get(1));

			try {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
				assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
						"Verifying that <b>'Vest Performance'</b> Title is showing");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
				assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
						"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			}

			// Whatsapp Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Whatsapp'</b> Button");
			diyVestPage.clickOnWhatsappBtn(driver);

			List<String> whatsappPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(whatsappPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Whatapp Page'</b> Title is showing");
			assertTrue(diyVestPage.isWhatappPageTitleVisible(driver),
					"Verifying that <b>'Whatapp Page'</b> Title is showing");
			driver.switchTo().window(whatsappPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Whatapp'</b> Page Title");
			closeTab(1, driver);

			// faceBook Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Facebook'</b> Button");
			diyVestPage.clickOnFacebookBtn(driver);

			List<String> facebookPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(facebookPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Facebook Page'</b> Title is showing");
			assertTrue(diyVestPage.isFacebookPageTitleVisible(driver),
					"Verifying that 'Facebook Page' Title is showing");
			driver.switchTo().window(facebookPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Facebook'</b> Page Title");
			closeTab(1, driver);

			// LinkedIn Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnLinkedInBtn(driver);

			List<String> linkedInPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(linkedInPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'LinkedIn Page'</b> Title is showing");
			assertTrue(diyVestPage.isLinkedInPageTitleVisible(driver),
					"Verifying that <b>'LinkedIn Page'<b/> Title is showing");
			driver.switchTo().window(linkedInPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'LinkedIn'</b> Page Title");
			closeTab(1, driver);

			// Twitter Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnTwitterBtn(driver);

			List<String> twitterPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(twitterPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Twitter Page'</b> Title is showing");
			assertTrue(diyVestPage.isTwitterPageTitleVisible(driver),
					"Verifying that <b>'Twitter Page'</b> Title is showing");
			driver.switchTo().window(twitterPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Twitter'</b> Page Title");
			closeTab(1, driver);

			// Gmail Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Gmail'</b> Button");
			diyVestPage.clickOnGmailBtn(driver);

			List<String> gmailPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(gmailPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Gmail Page'</b> Title is showing");
			assertTrue(diyVestPage.isGmailPageTitleVisible(driver),
					"Verifying that <b>'Gmail Page'</b> Title is showing");
			driver.switchTo().window(gmailPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Gmail'</b> Page Title");
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : click <b>'Close Icon'</b> Of Share Popup");
			diyVestPage.clickOnCloseIcon(driver);

			// Rebalance Option
			testSteps.add("<b>*************Rebalancing " + newVestTitle + " DIY Vest*************</b>");

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click On 'Rebalance' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rebalance");

			if (diyVestPage.isPreviousPendingRebalancePopupVisible(driver)) {
				testSteps.add("Step " + (++i) + " : click on <b>'Preview Order'</b> Button");
				diyVestPage.clickOnPreviewOrder(driver);

//				if(diyVestPage.isRebalanceQueuedDisplaying(driver)) {
//					testSteps.add("Step " + (++i) + " : Rebalaced DIY Vest is already in queued");
//				}else {
//					testSteps.add("Step " + (++i) + " : click on <b>'Place Order'</b> Button");
//					diyVestPage.clickOnPlaceOrder(driver);
//					
//					if(diyVestPage.isNotEnoughCashPopupFound(driver)) {
//						testSteps.add("--> <font color='red'>You don't have enough cash</font>");
//					}
//					
//					testSteps.add("Step " + (++i) + " : click on <b>'Ok, Got It'</b> Button");
//					diyVestPage.clickOnRebalanceSuccessOkGotIt(driver);
//					
//					try {
//						diyVestPage.clickOnNextPopupButton(driver);
//					} catch (Exception e) {
//						printString("No PopUp Next Button found", driver);
//					}
//				}

			} else {
				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Plus'</b> Button");
				diyVestPage.clickOnStockPlusButton(driver);

				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Update Allocation'</b> Button");
				diyVestPage.clickOnUpdateAllocationButton(driver);

				try {
					testSteps.add("Step " + (++i) + " : click on <b>'Yes, Procesed'</b> Button");
					diyVestPage.clickOnYesProcessedButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

//				testSteps.add("Step " + (++i) + " : click on <b>'Place Order'</b> Button");
//				diyVestPage.clickOnPlaceOrder(driver);
//				
//				testSteps.add("Step " + (++i) + " : click on <b>'Ok, Got It'</b> Button");
//				diyVestPage.clickOnRebalanceSuccessOkGotIt(driver);
//				
//				if(diyVestPage.isRebalanceQueuedDisplaying(driver)) {
//					testSteps.add("<b>DIY Vest is in queued due to market is close</b>");
//				}

			}

			if (diyVestPage.isRebalanceQueuedDisplaying(driver)) {
				testSteps.add("<b>*************Renaming " + newVestTitle + " DIY Vest*************</b>");
				testSteps.add("DIY Vest is in Rebalance-Queued So User Can't Rename Vest");
			} else {
				// Rename
				testSteps.add("<b>*************Renaming " + newVestTitle + " DIY Vest*************</b>");

				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rename");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
				diyVestPage.enterVestRename(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");
				assertTrue(diyVestPage.isVestOptionsVisible(renameVestTitle, driver),
						"Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDot(driver, renameVestTitle);

				testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, renameVestTitle, "Rename");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + newVestTitle + "'</b>");
				diyVestPage.enterVestRename(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing");
				assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, driver),
						"Verifying that <b>'" + newVestTitle + "'</b> Title is showing");

			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("VerifyThreeDotOption_InvestedDIYVest", testSteps, driver);

		} catch (Exception e) {

			testSteps
					.add("Failed: VerifyThreeDotOption_InvestedDIYVest " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyThreeDotOption_InvestedDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_InvestedDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: VerifyThreeDotOption_InvestedDIYVest " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyThreeDotOption_InvestedDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_InvestedDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

//	@Test
	public void VerifyThreeDotOption_RebalancePendingDIYVest() {

		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();

		// String newVestTitle = "NotInvestedVest" +
		// generateRandomNumberWithGivenNumberOfDigits(2, driver);
		String newVestTitle = "RebalancePendingInvestedVest";
		String renameVestTitle = "Renamed" + newVestTitle;
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("VerifyThreeDotOption_RebalancePendingDIYVest:" + driver.hashCode() + "", driver);
		int i = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-164?atlOrigin=eyJpIjoiMmVlZGMyMDJlNTdiNDRiMzgyY2VmNzM2NDk3Y2JhNzMiLCJwIjoiaiJ9\">QAA-164.3 : Check the options {'Share' , 'Rebalance','Rename'} for 'Invested & Pending Re-balanced' Vest.<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : creating <b>'" + newVestTitle + "'</b> DIY Vest");
			diyVestPage.createDIYVest(driver, newVestTitle, i);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			if (diyVestPage.isVestRebalancedQueued(driver, newVestTitle, "Rebalance pending")) {

			} else {
				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click On 'Rebalance' of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rebalance");

				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Plus'</b> Button");
				diyVestPage.clickOnStockPlusButton(driver);

				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Update Allocation'</b> Button");
				diyVestPage.clickOnUpdateAllocationButton(driver);

				try {
					testSteps.add("Step " + (++i) + " : click on <b>'Yes, Procesed'</b> Button");
					diyVestPage.clickOnYesProcessedButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			// Share
			testSteps.add("<b>*************Verifying " + newVestTitle + " DIY Vest Share Options*************</b>");
			testSteps.add("Step " + (++i) + " : click On 'Share' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Share");

			testSteps.add("Step " + (++i) + " : Verifying: <b>'Share'</b> Popup is visible");
			assertTrue(diyVestPage.VerifyShareDIYVestPopup(driver), "<b>'Share'</b> Popup is not visible");
			testSteps.add("Step " + (++i) + " : Verifyied: <b>'Share'</b> Popup is visible");

			testSteps.add("Step " + (++i) + " : Click on <b>'Preview Page'</b> Button");
			diyVestPage.clickOnPreviewPageBtn(driver);

			List<String> previewPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(previewPageWindow.get(1));

			try {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'Vest Performance'</b> Title is showing");
				assertTrue(diyVestPage.isVestPerformanceTitleVisible(driver),
						"Verifying that <b>'Vest Performance'</b> Title is showing");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing ");
				assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
						"Verified that <b>'" + newVestTitle + "'</b> Title is displaying");
				driver.switchTo().window(previewPageWindow.get(0));

				testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Preview'</b> Page Title");
				closeTab(1, driver);
			}

			// Whatsapp Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Whatsapp'</b> Button");
			diyVestPage.clickOnWhatsappBtn(driver);

			List<String> whatsappPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(whatsappPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Whatapp Page'</b> Title is showing");
			assertTrue(diyVestPage.isWhatappPageTitleVisible(driver),
					"Verifying that <b>'Whatapp Page'</b> Title is showing");
			driver.switchTo().window(whatsappPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : <b>'Close newly opened window to verify Whatapp'</b> Page Title");
			closeTab(1, driver);

			// faceBook Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Facebook'</b> Button");
			diyVestPage.clickOnFacebookBtn(driver);

			List<String> facebookPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(facebookPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Facebook Page'</b> Title is showing");
			assertTrue(diyVestPage.isFacebookPageTitleVisible(driver),
					"Verifying that 'Facebook Page' Title is showing");
			driver.switchTo().window(facebookPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Facebook'</b> Page Title");
			closeTab(1, driver);

			// LinkedIn Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnLinkedInBtn(driver);

			List<String> linkedInPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(linkedInPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'LinkedIn Page'</b> Title is showing");
			assertTrue(diyVestPage.isLinkedInPageTitleVisible(driver),
					"Verifying that <b>'LinkedIn Page'<b/> Title is showing");
			driver.switchTo().window(linkedInPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'LinkedIn'</b> Page Title");
			closeTab(1, driver);

			// Twitter Button
			testSteps.add("Step " + (++i) + " : Click on <b>'LinkedIn'</b> Button");
			diyVestPage.clickOnTwitterBtn(driver);

			List<String> twitterPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(twitterPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Twitter Page'</b> Title is showing");
			assertTrue(diyVestPage.isTwitterPageTitleVisible(driver),
					"Verifying that <b>'Twitter Page'</b> Title is showing");
			driver.switchTo().window(twitterPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Twitter'</b> Page Title");
			closeTab(1, driver);

			// Gmail Button
			testSteps.add("Step " + (++i) + " : Click on <b>'Gmail'</b> Button");
			diyVestPage.clickOnGmailBtn(driver);

			List<String> gmailPageWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(gmailPageWindow.get(1));

			testSteps.add("Step " + (++i) + " : Verifying that <b>'Gmail Page'</b> Title is showing");
			assertTrue(diyVestPage.isGmailPageTitleVisible(driver),
					"Verifying that <b>'Gmail Page'</b> Title is showing");
			driver.switchTo().window(gmailPageWindow.get(0));

			testSteps.add("Step " + (++i) + " : Close newly opened window to verify <b>'Gmail'</b> Page Title");
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : click <b>'Close Icon'</b> Of Share Popup");
			diyVestPage.clickOnCloseIcon(driver);

			// Rebalance Option
			testSteps.add("<b>*************Rebalancing " + newVestTitle + " DIY Vest*************</b>");

			testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : click On 'Rebalance' of <b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rebalance");

			if (diyVestPage.isPreviousPendingRebalancePopupVisible(driver)) {
				testSteps.add("Step " + (++i) + " : click on <b>'Preview Order'</b> Button");
				diyVestPage.clickOnPreviewOrder(driver);

			} else {
				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Plus'</b> Button");
				diyVestPage.clickOnStockPlusButton(driver);

				testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
				testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

				testSteps.add("Step " + (++i) + " : click on <b>'Update Allocation'</b> Button");
				diyVestPage.clickOnUpdateAllocationButton(driver);

				try {
					testSteps.add("Step " + (++i) + " : click on <b>'Yes, Procesed'</b> Button");
					diyVestPage.clickOnYesProcessedButton(driver);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			if (diyVestPage.isRebalanceQueuedDisplaying(driver)) {
				testSteps.add("<b>*************Renaming " + newVestTitle + " DIY Vest*************</b>");
				testSteps.add("DIY Vest is in Rebalance-Queued So User Can't Rename Vest");
			} else {
				// Rename
				testSteps.add("<b>*************Renaming " + newVestTitle + " DIY Vest*************</b>");

				testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
				navigationPage.clickOnDiyVestBtn(driver);
				navigationPage.waitTillTenSeconds(driver);

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickThreeDotsOnNewlyCreatedVest(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + newVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, newVestTitle, "Rename");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + renameVestTitle + "'</b>");
				diyVestPage.enterVestRename(renameVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");
				assertTrue(diyVestPage.isVestOptionsVisible(renameVestTitle, driver),
						"Verifying that <b>'" + renameVestTitle + "'</b> Title is showing");

				testSteps.add("Step " + (++i) + " : click On 3 dots of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDot(driver, renameVestTitle);

				testSteps.add("Step " + (++i) + " : click On 'Rename' of <b>'" + renameVestTitle + "'</b>");
				diyVestPage.clickOnThreeDotOption(driver, renameVestTitle, "Rename");

				testSteps.add("Step " + (++i) + " : Enter Rename Vest Title: <b>'" + newVestTitle + "'</b>");
				diyVestPage.enterVestRename(newVestTitle, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Rename Vest'</b> Button");
				diyVestPage.clickOnRenameVestButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying that <b>'" + newVestTitle + "'</b> Title is showing");
				assertTrue(diyVestPage.isVestOptionsVisible(newVestTitle, driver),
						"Verifying that <b>'" + newVestTitle + "'</b> Title is showing");

			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");

			AddTest_IntoReport("VerifyThreeDotOption_RebalancePendingDIYVest", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: VerifyThreeDotOption_RebalancePendingDIYVest " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyThreeDotOption_RebalancePendingDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_RebalancePendingDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: VerifyThreeDotOption_RebalancePendingDIYVest " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("VerifyThreeDotOption_RebalancePendingDIYVest") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyThreeDotOption_RebalancePendingDIYVest", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DIYVest_SellOrder() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		HomePage homePage;
		driver = initConfiguration();
		String newVestTitle = "SellOrderVest";

		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		homePage = new HomePage(driver);
		printString("DIYVest_SellOrder:" + driver.hashCode() + "", driver);
		int i = 0;
		String sellAmount = "1";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-689?atlOrigin=eyJpIjoiMGJlY2QwY2M4YzRiNGNlZTk0OWZjMzJlMDgyZmYzMzciLCJwIjoiaiJ9\">QAA-689 : [Web] - Verify User can place sell order for DIY Vest<a/>");

			loginPage.loginToApp(driver);
			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			diyVestPage.createDIYVest(driver, newVestTitle, i);

			try {
				diyVestPage.clickVest(newVestTitle, driver);
				testSteps.add("Step " + (++i) + " : click <b>'" + newVestTitle + "'</b> Vest");
				try {
					diyVestPage.clickOnNextPopupButton(driver);
				} catch (Exception e1) {
					printString("No PopUp Next Button found", driver);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : click <b>'Sell'</b> button");
			diyVestPage.clickOnSellStocksButton(driver);

			Double currentInvestment = diyVestPage.getCurrentInvestment(driver);
			testSteps.add("Step " + (++i) + " : CurrentInvestment : " + currentInvestment);

			testSteps.add("Step " + (++i) + " : Check <b>'Sell All'</b> checkbox");
			diyVestPage.clickSellAllBox(driver);

			Double sellAmountInputFielsValue = diyVestPage.getSellAmountField(driver);
			testSteps.add("Step " + (++i) + " : Sell Amount Input Field Amount  : " + sellAmountInputFielsValue);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Sell All'</b> is updating field with all amount");
			assertTrue(currentInvestment.equals(sellAmountInputFielsValue),
					"<b>'Sell All'</b> is not updating field with all amount");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Sell All'</b> is updating field with all amount");

			testSteps.add("Step " + (++i) + " : Uncheck <b>'Sell All'</b> checkbox");
			diyVestPage.clickSellAllBox(driver);

			testSteps.add("Step " + (++i) + " : Entering Sell Amount: " + sellAmount);
			diyVestPage.enterSellAmount(driver, sellAmount);

			testSteps.add("Step " + (++i) + " : click <b>'Preview Order'</b> button");
			diyVestPage.clickOnPreviewOrder(driver);
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
				testSteps.add("Step " + (++i) + " : click <b>'Place Sell Order'</b> button");
				diyVestPage.clickOnPlaceSellOrderButton(driver);

//				testSteps.add("Step " + (++i)+ " : Verifying the <b>'Your order was placed successfully.'</b> screen is displaying");
//				assertTrue(diyVestPage.isSuccessScreenDisplay(driver),"'Your order was placed successfully.' screen is not displaying");
//				testSteps.add("Step " + (++i)+ " : Verified: <b>'Your order was placed successfully.'</b> screen is displaying");
			}
			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVest_SellOrder", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: DIYVest_SellOrder " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_SellOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_SellOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: DIYVest_SellOrder " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_SellOrder") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_SellOrder", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void DIYVest_Buy() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		HomePage homePage;
		driver = initConfiguration();

		String newVestTitle = "BuyVest" + generateRandomNumberWithGivenNumberOfDigits(7, driver);
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		homePage = new HomePage(driver);
		printString("DIYVest_Buy:" + driver.hashCode() + "", driver);
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		String investedAmount = "50.00";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-713?atlOrigin=eyJpIjoiZWNhMjdjNzhmOGFmNGQ3NzgzZTM3YTdhYTFlZjEwZWMiLCJwIjoiaiJ9\">QAA-713 : [Web] [New] - Verify user is able to buy DIY Vest<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor5sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOncreateNewVestButton(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			diyVestPage.selectStocks(1, driver);

			testSteps.add("Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button status: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			diyVestPage.selectStocks(2, driver);
			testSteps.add(
					"Step " + (++i) + " : Verifying is <b>'Add Stock Button is enable with more than one stock'</b>");
			testSteps.add("Step " + (++i) + " : Add Stocks Button status: <b>"
					+ diyVestPage.isAddedStocksButtonEnabled(driver) + "'</b>");
			testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
			diyVestPage.clickOnAddedStocksButton(driver);
			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : " + diyVestPage.isNotePopupVisible(driver));
			testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
			diyVestPage.clickOnNotePopupOkButton(driver);

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			diyVestPage.clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Vest Name Required Popup'</b> is visible");
			assertTrue(diyVestPage.isRequiredVestNameDisplay(driver), "'Vest Name Required Popup' is visible");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Vest Name Required Popup'</b> is visible");

			testSteps.add("Step " + (++i) + " : click <b>'OK'</b> button");
			diyVestPage.clickOnRequiredVestNamePopupOkButton(driver);

			testSteps.add("Step " + (++i) + " : Enter New Vest Title: <b>'" + newVestTitle + "'</b>");
			diyVestPage.enterVestName(newVestTitle, driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(diyVestPage.verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			diyVestPage.clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Vest Created Success Popup'</b> is visible");
			testSteps.add("Step " + (++i) + " : " + diyVestPage.isvestCreateSuccessfullyPopupVisible());

			try {
				diyVestPage.clickOnNextPopupButton(driver);
			} catch (Exception e) {
				printString("No PopUp Next Button found", driver);
			}

			testSteps.add("Step " + (++i) + " : click <b>'Buy'</b> button");
			diyVestPage.clickOnbuyStocksButton(driver);

			try {
				if (diyVestPage.isMinimum50DollarRequiredPopupDisplaying(driver)) {
					testSteps.add("<font color='red'>You Don't Have Enough Cash </font>");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			testSteps.add("Step " + (++i) + " : Entering 'Invested Amount': 9");
			diyVestPage.EnterInvestAmount("9", driver);

			testSteps.add("Step " + (++i) + " : click <b>'Preview Order'</b> button");
			diyVestPage.clickOnPreviewOrder(driver);

			testSteps.add("Step " + (++i)
					+ " : Verifying the <b>'Please enter a value greater than or equal to $10.00.'</b> is visible");
			assertTrue(diyVestPage.isMinimum10DollarErrorMessageDisplaying(driver),
					"'Please enter a value greater than or equal to $10.00.' is visible");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Please enter a value greater than or equal to $10.00.'</b> is visible");

			testSteps.add("Step " + (++i) + " : Entering 'Invested Amount':" + investedAmount);
			diyVestPage.EnterInvestAmount(investedAmount, driver);
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : click <b>'Preview Order'</b> button");
				diyVestPage.clickOnPreviewOrder(driver);

				Double investedAmountOnPreview = diyVestPage.getInvestedAmountOnPreviewPage(driver);

				testSteps.add("Step " + (++i) + " : Verifying: <b>'Invested Amount'</b>");
				assertEquals(df.format(Double.parseDouble(investedAmount)), df.format(investedAmountOnPreview),
						"'Invested Amount' is mismatched");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Invested Amount'</b>");

				testSteps.add("Step " + (++i) + " : click <b>'Place Buy Order'</b> button");
				diyVestPage.clickOnbuyPlaceOrderButton(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("DIYVest_Buy", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: DIYVest_Buy " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_Buy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_Buy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: DIYVest_Buy " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_Buy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_Buy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void ExistingDIYVest_Buy() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		HomePage homePage;
		driver = initConfiguration();

		String newVestTitle = "SellOrderVest";
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		homePage = new HomePage(driver);
		printString("ExistingDIYVest_Buy:" + driver.hashCode() + "", driver);
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		String investedAmount = "50.00";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-718?atlOrigin=eyJpIjoiZWNhMjdjNzhmOGFmNGQ3NzgzZTM3YTdhYTFlZjEwZWMiLCJwIjoiaiJ9\">QAA-718 : [Web] [New] - Verify user is able to buy existing DIY Vest<a/>");

			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);

			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++i) + " : click On DIY Vest<b>'" + newVestTitle + "'</b>");
			diyVestPage.clickOnDIYVest(driver, newVestTitle);

			try {
				diyVestPage.clickOnNextPopupButton(driver);
			} catch (Exception e) {
				printString("No PopUp Next Button found", driver);
			}

			testSteps.add("Step " + (++i) + " : Verifying the <b>'" + newVestTitle + " DIY Vest Page'</b>");
			assertTrue(diyVestPage.isVestNameVisible(newVestTitle, driver),
					"Verifying the <b>'" + newVestTitle + " DIY Vest Page'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified: <b> the <b>'" + newVestTitle + " DIY Vest Page'</b>");

			testSteps.add("Step " + (++i) + " : click <b>'Buy'</b> button");
			diyVestPage.clickOnbuyStocksButton(driver);

			try {
				if (diyVestPage.isMinimum50DollarRequiredPopupDisplaying(driver)) {
					testSteps.add("<font color='red'>You Don't Have Enough Cash </font>");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			testSteps.add("Step " + (++i) + " : Entering 'Invested Amount': 9");
			diyVestPage.EnterInvestAmount("9", driver);

			testSteps.add("Step " + (++i) + " : click <b>'Preview Order'</b> button");
			diyVestPage.clickOnPreviewOrder(driver);

			testSteps.add("Step " + (++i)
					+ " : Verifying the <b>'Please enter a value greater than or equal to $10.00.'</b> is visible");
			assertTrue(diyVestPage.isMinimum10DollarErrorMessageDisplaying(driver),
					"'Please enter a value greater than or equal to $10.00.' is visible");
			testSteps.add("Step " + (++i)
					+ " : Verified: <b>'Please enter a value greater than or equal to $10.00.'</b> is visible");

			testSteps.add("Step " + (++i) + " : Entering 'Invested Amount':" + investedAmount);
			diyVestPage.EnterInvestAmount(investedAmount, driver);
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : click <b>'Preview Order'</b> button");
				diyVestPage.clickOnPreviewOrder(driver);

				Double investedAmountOnPreview = diyVestPage.getInvestedAmountOnPreviewPage(driver);

				testSteps.add("Step " + (++i) + " : Verifying: <b>'Invested Amount'</b>");
				assertEquals(df.format(Double.parseDouble(investedAmount)), df.format(investedAmountOnPreview),
						"'Invested Amount' is mismatched");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Invested Amount'</b>");

				testSteps.add("Step " + (++i) + " : click <b>'Place Buy Order'</b> button");
				diyVestPage.clickOnbuyPlaceOrderButton(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("ExistingDIYVest_Buy", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: ExistingDIYVest_Buy " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ExistingDIYVest_Buy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ExistingDIYVest_Buy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: ExistingDIYVest_Buy " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ExistingDIYVest_Buy") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ExistingDIYVest_Buy", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void DIYVest_NotePopup_Verify() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		InstrumentPage instrumentPage;
		NavigationPage navigationPage;
		DIYVestPage diyVestPage;
		driver = initConfiguration();
		String newVestTitle = "QAduplicatetestingvest" + generateRandomNumberWithGivenNumberOfDigits(2, driver);
		loginPage = new LoginPage(driver);
		instrumentPage = new InstrumentPage(driver);
		navigationPage = new NavigationPage(driver);
		diyVestPage = new DIYVestPage(driver);
		printString("DIYVest_NotePopup_Verify:" + driver.hashCode() + "", driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-712?atlOrigin=eyJpIjoiZjA1NTEwNTAxYjA3NGVlZGJkMTZmZjNiMDZhNzUwNjQiLCJwIjoiaiJ9\">QAA-712 : [Web] [New] - While user select different numbers of stock, Verify the DIY Vest note popup<a/>");
//			testSteps.add(
//					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-158?atlOrigin=eyJpIjoiZjA1NTEwNTAxYjA3NGVlZGJkMTZmZjNiMDZhNzUwNjQiLCJwIjoiaiJ9\">QAA-158 : [Bug] - Note Popup is not Showing On Create new DIY vest In Web<a/>");
			loginPage.loginToApp(driver);
			testSteps.add("Step " + (++i) + " : click <b>'DiyVest'</b> button");
			navigationPage.clickOnDiyVestBtn(driver);
			navigationPage.waitTillTenSeconds(driver);
			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			waitfor5sec();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			diyVestPage.clickOncreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Verifying: <b>'Stocks/ETFs added Button is disabled'</b>");
			assertFalse(diyVestPage.isAddStocksOrEftsToProceedButtonEnabled(driver),
					"<b>'Stocks/ETFs added Button'</b> is enabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is disabled");
			for (int j = 1; j <= 10; j++) {
				try {
					if (j == 2) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add two stocks");
						diyVestPage.selectStockByIndex(1, driver);
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertFalse(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : Note Popup is not visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 3) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add three stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is not visible");
						testSteps.add("Step " + (++i) + " : Note Popup is visible");
						testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
						diyVestPage.clickOnNotePopupOkButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 4) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add four stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : Note Popup is not visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 5) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add five stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : Note Popup is not visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 6) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add six stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is not visible");
						testSteps.add("Step " + (++i) + " : Note Popup is visible");
						testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
						diyVestPage.clickOnNotePopupOkButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 7) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add seven stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is not visible");
						testSteps.add("Step " + (++i) + " : Note Popup is visible");
						testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
						diyVestPage.clickOnNotePopupOkButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 8) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add eight stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is not visible");
						testSteps.add("Step " + (++i) + " : Note Popup is visible");
						testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
						diyVestPage.clickOnNotePopupOkButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 9) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add nine stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is not visible");
						testSteps.add("Step " + (++i) + " : Note Popup is visible");
						testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
						diyVestPage.clickOnNotePopupOkButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					} else if (j == 10) {
						testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add more stocks");
						testSteps.add("Step " + (++i) + " : Add ten stocks");
						diyVestPage.selectStockByIndex(1, driver);
						testSteps.add("Step " + (++i) + " : click <b>'Add Stocks'</b> button");
						diyVestPage.clickOnAddedStocksButton(driver);
						assertTrue(diyVestPage.isNotePopupVisibleOrNot(driver), "<b>'Note Popup'</b> is visible");
						testSteps.add("Step " + (++i) + " : Note Popup is not visible");
						testSteps.add("Step " + (++i) + " : click on <b>'Stock Back'</b> Button");
						diyVestPage.clickOnStockBackButton(driver);
					}
				} catch (Exception e) {
					testSteps.add("Exception: " + e.toString());
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
					navigationPage.clickOnDiyVestBtn(driver);
					navigationPage.waitTillTenSeconds(driver);
					waitfor5sec();
					diyVestPage.clickOncreateNewVestButton(driver);
					for (int z = 1; z <= j; z++) {
						diyVestPage.selectStockByIndex(1, driver);
					}

				} catch (Error e) {
					testSteps.add("Exception: " + e.toString());
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
					navigationPage.clickOnDiyVestBtn(driver);
					navigationPage.waitTillTenSeconds(driver);
					waitfor5sec();
					diyVestPage.clickOncreateNewVestButton(driver);
					for (int z = 1; z <= j; z++) {
						diyVestPage.selectStockByIndex(1, driver);
					}
				}

			}
			AddTest_IntoReport("DIYVest_NotePopup_Verify", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: DIYVest_NotePopup_Verify " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_NotePopup_Verify") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_NotePopup_Verify", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: DIYVest_NotePopup_Verify " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("DIYVest_NotePopup_Verify") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("DIYVest_NotePopup_Verify", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}
}