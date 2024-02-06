package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.DIYVestPage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import com.investor.pages.ModelStockData;
import com.investor.pages.MonkeyPageObject;
import com.investor.pages.NavigationPage;

public class TaxDocuments extends BaseClass {
	String tempSrc = "";

	@Test
	public void TaxDocuments_LinksVerification() {

		LoginPage lp;

		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;

		driver = initConfiguration();
		lp = new LoginPage(driver);
		NavigationPage navigationPage = new NavigationPage(driver);
		MonkeyPageObject monkey = new MonkeyPageObject(driver);
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-336?atlOrigin=eyJpIjoiODBjN2Y1ZWI1YzgyNGMzZjg3NzJkY2Q1NGVkY2U1ZTIiLCJwIjoiaiJ9\">QAA-336 : Verify all links are working correctly in tax documents<a/>");
		int step = 1;
		try {

			testSteps.add("Login to App");
			testSteps.addAll(lp.loginToApp(driver));

			waitTime(5000, driver);
			testSteps.add("Step " + (++step) + " : click 'Profile' button");
			navigationPage.clickOnProfileBtn(driver);

			testSteps.add("Step " + (++step) + " : Verify 'Tax Documents' button is enabled");
			assertTrue(monkey.isProfileTaxDocumentsMenuIsEnabled(driver), "Verified 'Tax Documents' button is enabled");

			testSteps.add("Step " + (++step) + " : click 'Tax Documents' button");
			monkey.clickOnProfileTaxDocumentsButton(driver);
			navigationPage.waitTillTenSeconds(driver);

			testSteps.add("Step " + (++step) + " : click '2021 - 2022'");
			monkey.clickOnLatestYearTaxDocument(driver);

			testSteps.addAll(monkey.verifyDownloadableLink(driver));

			testSteps.add("Step " + step + " : Close the Browser");
			AddTest_IntoReport("TaxDocuments_LinksVerification", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: TaxDocuments_LinksVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("TaxDocuments_LinksVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("TaxDocuments_LinksVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: TaxDocuments_LinksVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("TaxDocuments_LinksVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("TaxDocuments_LinksVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
