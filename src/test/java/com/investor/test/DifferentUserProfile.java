package com.investor.test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.FundTransferPage;
import com.investor.pages.HomePage;
import com.investor.pages.InstrumentPage;
import com.investor.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DifferentUserProfile extends BaseClass {
	String tempSrc = "";

	@Test
	public void Verify_UserProfile_NonKYC() {

		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		InstrumentPage instrumentPage = new InstrumentPage(driver);
		FundTransferPage transferPage = new FundTransferPage(driver);
		printString("Verify_UserProfile_NonKYC: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData("testData", "TestData", driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[0][0].toString();
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-214?atlOrigin=eyJpIjoiNzZjNThmZTRhNzk1NDhjMTlkYTkwN2MyNGNmNzViZWMiLCJwIjoiaiJ9\">QAA-214 : Web - Verify Different user Profiles - Non- KYC User<a/>");
		String password = "#TestUser12";
		int step = 1;
		try {

			
			String email = "vested.automation+w01000011@gmail.com";	
			lp.loginToApp(email, password, driver);
			
//			testSteps.add("Step " + step + " : Visit app url");
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Enter app Password");
//			lp.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Click on submit");
//			lp.clickOnSubmitButton(driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Click on Sign up with email Button");
//			lp.clickOnSignUpWithEmail(driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Enter Email Address : " + email);
//			lp.enterB2BUserEmailAddress(email, driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Enter Password : " + password);
//			lp.enterB2BUserPassword(password, driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Click on Sign Up Button");
//			lp.clickOnSubmitButton(driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Click on Login Button");
//			lp.clickOnLoginPageButton(driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Click on Login with Email");
//			lp.clickOnloginWithEmail(driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Enter Email Address : " + email);
//			lp.enterB2BUserEmailAddress(email, driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Enter Password : " + password);
//			lp.enterB2BUserPassword(password, driver);
//			step++;
//
//			testSteps.add("Step " + step + " : Click on Login Button");
//			lp.clickOnLoginButton(driver);
//			step++;
//
//			testSteps.add("Step " + ++step + " : Click on Start KYC Button");
//			homePage.clickOnStartKYCButton(driver);
//
//			testSteps.add("Step " + ++step + " : Verify the user is shown the Complete KYC screen");
//			assertTrue(homePage.isKYCHeadingPresent(driver), "Verified the user is shown the Complete KYC screen");
//
//			testSteps.add("Step " + ++step + " : Click on Close Icon");
//			homePage.clickNavCloseIcon(driver);
//
//			testSteps.add("Step " + ++step + " : Click on Ok Next Button");
//			lp.clickOnBtnNext(driver);
//
//			testSteps.add("Step " + ++step + " : Click on Ok Got it Button");
//			lp.clickOnBtnOkGotIt(driver);
//			wait3s();
//			homePage.closeOnKycVerificationPopupButton(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC' Card on Dashboard");
			assertTrue(homePage.isStartKYCProcessButtonPresent(driver), "Verified 'Complete KYC' Card on Dashboard");

			testSteps.add("Step " + ++step + " : Click on Profile drop down");
			lp.clickOnProfileDropDown(driver);

			waitTime(2000, driver);
			testSteps.add("Step " + (++step) + " : Go to instrument details page");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppInstrumentDetailURL"), driver);

			testSteps.add("Step " + (++step) + " : Click on 'BUY' button");
			instrumentPage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			testSteps.add("Step " + ++step + " : Click on Home Tab");
			homePage.clickOnHomeTabButton(driver);

			testSteps.add("Step " + ++step + " : Click on Swensen Portfolio");
			homePage.clickOnSwensenPortfolioButton(driver);

			testSteps.add("Step " + ++step + " : Click on Buy Button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			testSteps.add("Step " + ++step + " : Click on Home Tab");
			homePage.clickOnHomeTabButton(driver);

			testSteps.add("Step " + ++step + " : Click on All Weather");
			homePage.clickOnAllWeather_Button(driver);

			testSteps.add("Step " + ++step + " : Click on Buy Button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			testSteps.add("Step " + ++step + " : Click on Home Tab");
			homePage.clickOnHomeTabButton(driver);

			testSteps.add("Step " + ++step + " : Click on Aggressive");
			homePage.clickOnAgressiveButton(driver);

			testSteps.add("Step " + ++step + " : Click on Buy Button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			testSteps.add("Step " + ++step + " : Click on Home Tab");
			homePage.clickOnHomeTabButton(driver);

			testSteps.add("Step " + ++step + " : Click on Conservative");
			homePage.clickOnConservativeButton(driver);

			testSteps.add("Step " + ++step + " : Click on Buy Button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			testSteps.add("Step " + ++step + " : Click on Transfer Tab");
			transferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + ++step + " : Click on Add Fund Button");
			transferPage.clickOnBtnAddFund_(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			testSteps.add("Step " + ++step + " : Click on WithDraw Fund Button");
			transferPage.clickOnWithdrawFundBtn(driver);

			testSteps.add("Step " + ++step + " : Verify 'Complete KYC Button' is present");
			assertTrue(homePage.isCompleteKYCButtonPresent(driver), "Verified 'Complete KYC Button' is present");

			testSteps.add("Step " + ++step + " : Click on Not Now Button");
			homePage.clickOnNotNowButton(driver);

			AddTest_IntoReport("Verify_UserProfile_NonKYC", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Verify_UserProfile_NonKYC " + "<br><b>Exception:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_UserProfile_NonKYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_UserProfile_NonKYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Verify_UserProfile_NonKYC " + "<br><b>Error:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_UserProfile_NonKYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_UserProfile_NonKYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "NonPreniumCashRequired")
	public void Verify_UserProfile_BasicPlan() {
		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		FundTransferPage transferPage = new FundTransferPage(driver);
		printString("Verify_UserProfile_BasicPlan: " + driver.hashCode() + "", driver);
		String email = "";
		Object[][] dataArr = getData("testData", "UserProfile_BasicPlan", driver);
		printString("tesData Size : " + dataArr.length, driver);
		String password = "";
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			email = "apurva.jain+production+8@vestedfinance.co";
			password = "iTestUser1!";
		} else {
			email = dataArr[0][0].toString();
			password = dataArr[0][1].toString();
		}
		Double vestPurchaseFee = 0.25;
		int step = 1;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-218?atlOrigin=eyJpIjoiYWM1Yjk0OWEzZWJlNGUzNGE3M2E3ZDE4ZGQzY2Y2NTQiLCJwIjoiaiJ9\">QAA-218 : Web - Verify Different user Profiles - Basic Plan<a/>");
			testSteps.add("Step " + step + " : Visit and login application");

			testSteps.addAll(lp.loginToApp(email, password, driver));

			testSteps.add("Step " + (++step) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);

//			testSteps.add("Step " + ++step + " : Clicking On 'Go Premium' button");
//			homePage.clickOnGoPremiumButton(driver);
//
//			testSteps.add("Step " + ++step + " : Verifying 'Premium Price' is present");
//			assertTrue(homePage.isPremiumPricePresent(driver), "Verified 'Premium Price' is present");
//
//			testSteps.add("Step " + ++step + " : Verifying 'Select Premium Button' is present");
//			assertTrue(homePage.isSelectPremiumButtonPresent(driver), "Verified 'Select Premium Button' is present");
//
//			testSteps.add("Step " + ++step + " : Verifying 'Basic Heading' is present");
//			assertTrue(homePage.isBasicHeadingPresent(driver), "Verified 'Basic Heading' is present");
//
//
//			testSteps.add("Step " + ++step + " : Verifying 'FAQ Heading' is present");
//			assertTrue(homePage.isFAQHeadingPresent(driver), "Verified 'FAQ Heading' is present");
//
//			testSteps.add("Step " + ++step + " : Clicking On 'Home Tab' button");
//			homePage.clickOnHomeTabButton(driver);
//
//			testSteps.add("Step " + ++step + " : Clicking On 'Profile' drop down");
//			lp.clickOnProfileDropDown(driver);
//
//			testSteps.add("Step " + ++step + " : Verifying 'Go Premium' is present");
//			assertTrue(homePage.isGoPremiumProfilePresent(driver), "Verified 'Go Premium' is present");
//			tempSrc = getScreenshotPath();
//			testSteps.add(tempSrc);
//			captureCapture(driver, tempSrc);

			testSteps.add("Step " + ++step + " : Clicking On 'Aggressive Multi-Asset Class'");
			homePage.clickOnAgressiveButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Buy' button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Enter 'Investment Amount'");
			homePage.enterInvestmentAmountOnBuy("50", driver);
			wait2s();
			testSteps.add("Step " + ++step + " : Clicking On 'Preview Order' button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Subscribe and save' button");
			homePage.clickOnSubscribeAndSaveButton(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Plan Upgrade page' is present");
			assertTrue(homePage.isBasicHeadingPresent(driver), "Verified 'Plan Upgrade page' is present");

			goBack(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Vest Purchase Fee' is present");
			assertEquals(homePage.getVestPurchaseFee(driver), vestPurchaseFee,
					"Verified 'Vest Purchase Fee' is not present");

			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + ++step + " : Click on 'Place Buy Order' button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			} else {
				testSteps.add("Step " + ++step + " : Clicking On 'Home Tab' button");
				homePage.clickOnHomeTabButton(driver);
			}

			testSteps.add("Step " + ++step + " : Clicking On 'Conservative Multi-Asset Class'");
			homePage.clickOnConservativeButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Buy' button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Enter 'Investment Amount'");
			homePage.enterInvestmentAmountOnBuy("50", driver);
			wait2s();
			testSteps.add("Step " + ++step + " : Clicking On 'Preview Order' button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Subscribe and save' button");
			homePage.clickOnSubscribeAndSaveButton(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Plan Upgrade page' is present");
			assertTrue(homePage.isBasicHeadingPresent(driver), "Verified 'Plan Upgrade page' is present");

			goBack(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Vest Purchase Fee' is present");
			assertEquals(homePage.getVestPurchaseFee(driver), vestPurchaseFee,
					"Verified 'Vest Purchase Fee' is not present");

			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + ++step + " : Click on 'Place Buy Order' button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			} else {
				testSteps.add("Step " + ++step + " : Clicking On 'Home Tab' button");
				homePage.clickOnHomeTabButton(driver);
			}

			testSteps.add("Step " + ++step + " : Clicking On 'Moderate Multi-Asset Class'");
			homePage.clickOnModerateButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Buy' button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Enter 'Investment Amount'");
			homePage.enterInvestmentAmountOnBuy("50", driver);
			wait2s();
			testSteps.add("Step " + ++step + " : Clicking On 'Preview Order' button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Vest Purchase Fee' is present");
			assertEquals(homePage.getVestPurchaseFee(driver), vestPurchaseFee,
					"Verified 'Vest Purchase Fee' is not present");

			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + ++step + " : Click on 'Place Buy Order' button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			} else {
				testSteps.add("Step " + ++step + " : Clicking On 'Home Tab' button");
				homePage.clickOnHomeTabButton(driver);
			}

			testSteps.add("Step " + ++step + " : Clicking 'SwensenPortfolio' icon");
			homePage.clickOnSwensenPortfolioButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Buy' button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Entering 'Investment Amount'");
			homePage.enterInvestmentAmountOnBuy("50", driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Preview Order' button");
			homePage.clickOnPreviewOrderButton(driver);
			testSteps.add("Step " + ++step + " : Verifying 'Vest Purchase Fees' is present");
			assertTrue(homePage.isVestPurchaseFees3Present(driver), "Verified 'Vest Purchase Fees' is present");

			testSteps.add("Step " + ++step + " : Clicking On 'Subscribe and save' button");
			homePage.clickOnSubscribeAndSaveButton(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Plan Upgrade page' is present");
			assertTrue(homePage.isBasicHeadingPresent(driver), "Verified 'Plan Upgrade page' is present");

			testSteps.add("Step " + ++step + " : Click on Transfer Tab");
			transferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + ++step + " : Click on WithDraw Fund Button");
			transferPage.clickOnWithdrawFundBtn(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Go Premium and Save Button' is present");
			assertTrue(transferPage.isGoPremiumAndSaveButtonPresent(driver),
					"Verified 'Go Premium and Save Button' is present");

			testSteps.add("Step " + ++step + " : CLose Browser");
			AddTest_IntoReport("Verify_UserProfile_BasicPlan", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: Verify_UserProfile_BasicPlan " + "<br><b>Exception:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_UserProfile_BasicPlan") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_UserProfile_BasicPlan", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Verify_UserProfile_BasicPlan " + "<br><b>Error:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_UserProfile_BasicPlan") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_UserProfile_BasicPlan", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(groups = "CashRequired")
	public void Verify_UserProfile_PremiumPlan() {
		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		FundTransferPage transferPage = new FundTransferPage(driver);
		String email = PropertiesReader.getPropertyValue(env + "_" + "EmailId");
		String password = PropertiesReader.getPropertyValue(env + "_" + "Password");
		printString("Verify_UserProfile_PremiumPlan: " + driver.hashCode() + "", driver);
		int step = 1;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-221?atlOrigin=eyJpIjoiZDhiMTYyNzEzNGYzNGQ0NWEyNjY1NjdlOGFjYzAyZGEiLCJwIjoiaiJ9\">QAA-221 : Web - Verify Different user Profiles - Premium Plan<a/>");
			testSteps.add("Step " + step + " : Visit and login application");

			lp.loginToApp(email, password, driver);

			testSteps.add("Clicking on 'Profile' dropdown");
			lp.clickOnProfileDropDown(driver);

			testSteps.add("Clicking on 'Manage Plan Tab'");
			lp.clickOnManagePlanTab(driver);

			testSteps.add("Verifying 'Premium Plan' is active");
			assertTrue(lp.isPremiumPlanActive(driver), "Verified 'Premium Plan' is active");

			testSteps.add("Clicking on 'Home Tab'");
			homePage.clickOnHomeTabButton(driver);

			testSteps.add("Step " + (++step) + " : Cancelling All Pending Vest");
			homePage.cancelAllPendingVest(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'Aggressive Multi-Asset Class'");
			homePage.clickOnAgressiveButton(driver);

			waitfor10sec();
			testSteps.add("Step " + ++step + " : Clicking On 'Buy' button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Enter 'Investment Amount'");
			homePage.enterInvestmentAmountOnBuy("50", driver);
			wait2s();
			testSteps.add("Step " + ++step + " : Clicking On 'Preview Order' button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Vest Purchase Fees' is not present");
			assertFalse(homePage.isVestPurchaseFeesPresent(driver), "Verified 'Vest Purchase Fees' is not present");

			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + ++step + " : Click on 'Place Buy Order' button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			}
			wait2s();
			testSteps.add("Clicking on 'Home Tab'");
			homePage.clickOnHomeTabButton(driver);

			testSteps.add("Step " + ++step + " : Clicking On 'SwensenPortfolio'");
			homePage.clickOnSwensenPortfolioButton(driver);

			waitfor10sec();
			testSteps.add("Step " + ++step + " : Clicking On 'Buy' button");
			homePage.clickOnBuyButton(driver);

			testSteps.add("Step " + ++step + " : Enter 'Investment Amount'");
			homePage.enterInvestmentAmountOnBuy("50", driver);
			wait2s();
			testSteps.add("Step " + ++step + " : Clicking On 'Preview Order' button");
			homePage.clickOnPreviewOrderButton(driver);

			testSteps.add("Step " + ++step + " : Verifying 'Vest Purchase Fees' is not present");
			assertFalse(homePage.isVestPurchaseFeesPresent(driver), "Verified 'Vest Purchase Fees' is not present");

			if (!(driver.getCurrentUrl().contains("prod"))) {
				testSteps.add("Step " + ++step + " : Click on 'Place Buy Order' button");
				homePage.clickOnPlaceBuyOrderOrderButton(driver);
			}
			waitfor10sec();
			testSteps.add("Step " + ++step + " : Clicking On 'Transfer Tab' button");
			transferPage.clickOnTransferTab(driver);
			testSteps.add("Step " + ++step + " : Clicking On 'Withdraw Funds' button");
			transferPage.clickOnWithdrawFundBtn(driver);
			wait3s();
			testSteps.add("Step " + ++step + " : Verifying 'GoPremium And Save Button' is not present");
			assertFalse(transferPage.isGoPremiumAndSaveButtonPresent(driver),
					"Verified 'GoPremium And Save Button' is not present");

			testSteps.add("Step " + ++step + " : CLose Browser");
			AddTest_IntoReport("Verify_UserProfile_PremiumPlan", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Verify_UserProfile_PremiumPlan " + "<br><b>Exception:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_UserProfile_PremiumPlan") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_UserProfile_PremiumPlan", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Verify_UserProfile_PremiumPlan " + "<br><b>Error:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_UserProfile_PremiumPlan") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_UserProfile_PremiumPlan", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}
}
