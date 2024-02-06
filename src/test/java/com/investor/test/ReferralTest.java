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
import com.investor.pages.KYCRegistrationPage;
import com.investor.pages.LoginPage;
import com.investor.pages.ModelStockData;
import com.investor.pages.ReferralPageObject;
import com.investor.pages.NavigationPage;

public class ReferralTest extends BaseClass {
	String tempSrc = "";

	@Test
	public void VerifyFlowOfReferral() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		WebDriver driver2 = null;
		LoginPage loginPage;
		ReferralPageObject referral;
		String SignUpEmail = getUniqueEmailId("QATest", driver, 3);
		String password = "Vested123!";
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		referral = new ReferralPageObject(driver);
		printString("VerifyFlowOfReferral:" + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		int i = 0;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-697?atlOrigin=eyJpIjoiOTEzMWI1Y2I4OWM3NGJjN2JlNWRlY2QxOTZjY2QyOTciLCJwIjoiaiJ9\">QAA-697 : [Web] - Verify the Rewards screen and flow of referral and earn.<a/>");
			testSteps.add("Step " + (++i) + " : Login To App");
			loginPage.loginToApp(driver);

			testSteps.add("Step " + (++i) + " : Click on Rewards");
			referral.clickOnRewardsDisclosure(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Earn'</b> button is displaying");
			assertTrue(referral.isEarnButtonVisible(driver), "<b>'Earn Button'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'Earn'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Redeem'</b> button is displaying");
			assertTrue(referral.isRedeemButtonVisible(driver), "<b>'Redeem Button'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'Redeem'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'History'</b> button is displaying");
			assertTrue(referral.isHistoryButtonVisible(driver), "<b>'History Button'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'History'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'View Details'</b> button is displaying");
			assertTrue(referral.isViewDetailsButtonVisible(driver), "<b>'View Details'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'View Details'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'View Details'</b> button is displaying");
			assertTrue(referral.isViewDetailsButtonClickable(driver), "<b>'View Details'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'View Details'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'View Details'</b> button");
			referral.clickOnViewDetail(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'label'</b> is Refer and Earn");
			assertTrue(referral.isProfileReferralPageDisplaying(driver),
					"<b>'Refer and Earn Label'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'Refer and earn'</b> label is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Invite'</b> button is displaying");
			assertTrue(referral.isInviteButtonVisible(driver), "<b>'Invite'</b> is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'Invite'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'FAQs'</b> Hyperlink is displaying");
			assertTrue(referral.isFAQsButtonVisible(driver), "<b>'FAQs'</b> Hyperlink is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'FAQs'</b> Hyperlink is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Referral Disclosure'</b> Hyperlink is displaying");
			assertTrue(referral.isReferralButtonVisible(driver),
					"<b>'Referral Disclosure'</b> Hyperlink is not visible");
			testSteps.add("Step " + (++i) + " : Verified <b>'Referral Disclosure'</b> Hyperlink is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'FAQs'</b> Hyperlink is clickable");
			assertTrue(referral.isFAQsButtonClickable(driver), "<b>'FAQs'</b> Hyperlink is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'FAQs'</b> Hyperlink is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Referral Disclosure'</b> Hyperlink is clickable");
			assertTrue(referral.isReferralButtonClickable(driver),
					"<b>'Referral Disclosure'</b> Hyperlink is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Referral Disclosure'</b> Hyperlink is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Invite'</b> button is clickable");
			assertTrue(referral.isInviteButtonClickable(driver), "<b>'Invite'</b> button is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Invite'</b> button is clickable");

			testSteps.add("Step " + (++i) + " : click on <b>'Invite'</b> button");
			referral.clickOnInviteButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Share your link'</b> label is displaying");
			assertTrue(referral.isShareLinkPopUpVisible(driver), "<b>'Share your link'</b> label is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Share your link'</b> label is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Referral link'</b> is displaying");
			assertTrue(referral.isReferralInviteLinkVisible(driver), "<b>'Referral link'</b> is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Referral link'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Copy link'</b> button is displaying");
			assertTrue(referral.isCopyLinkButtonVisible(driver), "<b>'Copy link'</b> is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Copy link'</b> is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Copy link'</b> Button is clickable");
			assertTrue(referral.isCopyLinkButtonClickable(driver), "<b>'Copy link'</b> button is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Copy link'</b> button is clickable");

			testSteps.add("Step " + (++i) + " : click on <b>'Copy link'</b> button");
			referral.clickOnCopyLinkButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'link copied'</b> success message is displaying");
			assertTrue(referral.isLinkCopiedVisible(driver), "<b>'link copied'</b> success message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'link copied'</b>  success message is displaying");

			String link = referral.getReferralInviteLink(driver);
			testSteps.add("Step " + (++i) + " : Close the Browser");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			driver.close();

			driver2 = initConfiguration();
			loginPage = new LoginPage(driver2);
			kycRegistrationPage = new KYCRegistrationPage(driver2);
			referral = new ReferralPageObject(driver2);

			navigateToURL("https://next-staging.vested.co.in/nga", driver2);

			testSteps.add("Step " + (++i) + " : Enter app Password");
			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver2);

			testSteps.add("Step " + (++i) + " : Click on 'submit'");
			loginPage.clickOnSubmitButton(driver2);

			testSteps.add("Step " + (++i) + " : Navigating To Url: " + link);
			navigateToURL(link, driver2);
			referral.clickOnRewardSignUpButton(driver2);

			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
			loginPage.clickOnSignUpWithEmail(driver2);

			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
			loginPage.enterB2BUserEmailAddress(SignUpEmail, driver2);

			testSteps.add("Step " + (++i) + " : Enter Password ");
			loginPage.enterB2BUserPassword(password, driver2);

			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
			loginPage.clickOnSubmitButton(driver2);

			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
			assertTrue(loginPage.verifyOTPScreenDisplaying(driver2),
					"Verified 'Verification code' screen is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
			loginPage.clickOnLoginPageButton(driver2);

			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
			loginPage.clickOnloginWithEmail(driver2);

			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
			loginPage.enterB2BUserEmailAddress(SignUpEmail, driver2);

			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
			loginPage.enterB2BUserPassword(password, driver2);

			testSteps.add("Step " + (++i) + " : Click on Login Button");
			loginPage.clickOnLoginButton(driver2);

			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver2),
					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(loginPage.verifyStartKYCButtonIsDisplaying(driver2),
					"Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver2);

			testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
			kycRegistrationPage.clickAcceptAndContinue_button(driver2);

			String[] codeFromLink = link.split("/");
			String code = codeFromLink[codeFromLink.length - 1];
			String[] ReferralcodeFromcode = code.split("=");
			String data = ReferralcodeFromcode[ReferralcodeFromcode.length - 1];
			testSteps.add("Step " + (++i) + " : Verify Referral code is displaying");
			String referralCode = referral.getReferralCode(driver2);
			assertTrue(referralCode.equalsIgnoreCase(data),
					"Both Codes '" + referralCode + "' and '" + data + "' are not equal");
			testSteps.add("Step " + (++i) + "Verified: Both Codes '" + referralCode + "' and '" + data + "' are equal");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("VerifyFlowOfReferral", testSteps, driver2);

		} catch (Exception e) {
			testSteps.add("Failed: VerifyFlowOfReferral " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyFlowOfReferral") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyFlowOfReferral", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: VerifyFlowOfReferral " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("VerifyFlowOfReferral") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("VerifyFlowOfReferral", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}
}
