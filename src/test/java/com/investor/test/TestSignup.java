package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.LoginPage;

public class TestSignup extends BaseClass {
	String tempSrc = "";

	@Test
	public void SignUp_B2C_Email() {
		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		printString("SignUp_B2C_Email: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData("testData", "TestData", driver);
		printString("tesData Size : " + dataArr.length, driver);
		String appPassword = dataArr[0][0].toString();

		int step = 1;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-7?atlOrigin=eyJpIjoiNTAzMTY5ZGEzNDEzNGIzYWFhYzhkNjFlNDg0ZDE2ZDciLCJwIjoiaiJ9\">QAA-7 : Web - Verify a user is able to sign up to the platform with a valid email address and password<a/>");
			testSteps.add("Step " + step + " : Visit app url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
			step++;

			String email = getUniqueEmailId("QATest9", driver, 3);
			String password = "Vested123!";

			testSteps.add("Step " + step + " : Enter app Password");
			lp.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
			step++;

			testSteps.add("Step " + step + " : Click on submit");
			lp.clickOnSubmitButton(driver);
			step++;

			testSteps.add("Step " + step + " : Click on Sign up with email Button");
			lp.clickOnSignUpWithEmail(driver);
			step++;

			testSteps.add("Step " + step + " : Click on Sign Up Button");
			lp.clickOnSubmitButton(driver);
			step++;

			testSteps.add("Step " + step + " : Verify Email error message is displaying");
			assertEquals(lp.getEmailErrorMessage(driver), "Please enter your email", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : qwertyui");
			lp.enterB2BUserEmailAddress("qwertyui", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Email error message is displaying");
			assertEquals(lp.getEmailErrorMessage(driver), "Invalid email ID format.", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : " + email);
			lp.enterB2BUserEmailAddress(email, driver);
			step++;

			testSteps.add("Step " + step + " : Verify Password error message is displaying");
			assertEquals(lp.getPasswordErrorMessage(driver), "Please enter your password",
					"Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Password : qwerty");
			lp.enterB2BUserPassword("qwerty", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Password error message is displaying");
			assertEquals(lp.getPasswordErrorMessage(driver),
					"Your Password should atleast have 8 characters, a lower-case letter , an upper-case letter, a number and a special character",
					"Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Password : " + password);
			lp.enterB2BUserPassword(password, driver);
			step++;

			testSteps.add("Step " + step + " : Click on Sign Up Button");
			lp.clickOnSubmitButton(driver);
			step++;

			testSteps.add("Step " + step + " : Verify 'Verification' code screen is displaying");
			assertTrue(lp.verifyOTPScreenDisplaying(driver), "Verified 'Verification code' screen is displaying");
			step++;

			testSteps.add("Step " + step + " : Click on Login Button");
			lp.clickOnLoginPageButton(driver);
			step++;

			testSteps.add("Step " + step + " : Click on Login with Email");
			lp.clickOnloginWithEmail(driver);
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : " + email);
			lp.enterB2BUserEmailAddress(email, driver);
			step++;

			testSteps.add("Step " + step + " : Enter Password : " + password);
			lp.enterB2BUserPassword(password, driver);
			step++;

			testSteps.add("Step " + step + " : Click on Login Button");
			lp.clickOnLoginButton(driver);
			step++;

			testSteps.add("Step " + step + " : Verify 'Explore Platform' button is displaying");
			assertTrue(lp.verifyExplorePlatformButtonIsDisplaying(driver),
					"Verified 'Explore Platform' button is displaying");
			step++;

			testSteps.add("Step " + step + " : Verify 'Start KYC' button is displaying");
			assertTrue(lp.verifyStartKYCButtonIsDisplaying(driver), "Verified 'Start KYC' button is displaying");
			step++;

			testSteps.add("Step " + step + " : Close the Browser");
			AddTest_IntoReport("SignUp_B2C_Email", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: SignUp_B2C_Email " + "<br><b>Exception:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("SignUp_B2C_Email") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("SignUp_B2C_Email", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: SignUp_B2C_Email " + "<br><b>Error:</b> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("SignUp_B2C_Email") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("SignUp_B2C_Email", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void SignUp_Invalid_Data() {
		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		printString("SignUp_Invalid_Data:" + driver.hashCode(), driver);
		int step = 1;
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[0][0].toString();

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-120?atlOrigin=eyJpIjoiYjdiYTRjYzVlMTgwNGU1YjljM2Y0OGIzZjg3MzQ4MmMiLCJwIjoiaiJ9\">QAA-120 : [Web][Negative] Verify user is not able to sign up if invalid data is used <a/>");
			testSteps.add("Step " + step + " : Visit app url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
			step++;

			String email = generateRandomNumberWithGivenNumberOfDigits(8, driver) +"@codeautomation.ai";
			String password = "VestedQA120!";

			testSteps.add("Step " + step + " : Enter app Password");
			lp.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
			step++;

			testSteps.add("Step " + step + " : Click on submit");
			lp.clickOnSubmitButton(driver);
			step++;

			testSteps.add("Step " + step + " : Click on Sign up with email Button");
			lp.clickOnSignUpWithEmail(driver);
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : abc");
			lp.enterB2BUserEmailAddress("abc", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Email error message is displaying");
			lp.enterB2BUserPassword("", driver);
			assertEquals(lp.getEmailErrorMessage(driver), "Invalid email ID format.", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : 1111");
			lp.enterB2BUserEmailAddress("1111", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Email error message is displaying");
			assertEquals(lp.getEmailErrorMessage(driver), "Invalid email ID format.", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : 1111@aa");
			lp.enterB2BUserEmailAddress("1111@aa", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Email error message is displaying");
			assertEquals(lp.getEmailErrorMessage(driver), "Invalid email ID format.", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Password : abc");
			lp.enterB2BUserPassword("abc", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Password error message is displaying");
			assertEquals(lp.getPasswordErrorMessage(driver),
					"Your Password should atleast have 8 characters, a lower-case letter , an upper-case letter, a number and a special character",
					"Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Password : 1111");
			lp.enterB2BUserPassword("1111", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Password error message is displaying");
			assertEquals(lp.getPasswordErrorMessage(driver),
					"Your Password should atleast have 8 characters, a lower-case letter , an upper-case letter, a number and a special character",
					"Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Password : @@@");
			lp.enterB2BUserPassword("@@@", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Password error message is displaying");
			assertEquals(lp.getPasswordErrorMessage(driver),
					"Your Password should atleast have 8 characters, a lower-case letter , an upper-case letter, a number and a special character",
					"Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Email Address : " + email);
			lp.enterB2BUserEmailAddress(email, driver);
			step++;

			testSteps.add("Step " + step + " : Enter Password : " + password);
			lp.enterB2BUserPassword(password, driver);
			step++;

			testSteps.add("Step " + step + " : Click on Sign Up Button");
			lp.clickOnSubmitButton(driver);
			step++;

			testSteps.add("Step " + step + " : Enter Verification Code aaaaaa");
			lp.enterSignUpVerificationCode("aaaaaa", driver);
			step++;

			testSteps.add("Step " + step + " : Click on Confirm Account Button");
			lp.clickOnConfirmAccountButton(driver);
			step++;

			testSteps.add("Step " + step + " : Verify Verification code error message is displaying");
			assertEquals(lp.getSignUpVerificationCodeErrorMessage(driver),
					"Verification should only be in numeric format", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Verification Code ######");
			lp.enterSignUpVerificationCode("######", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Verification code error message is displaying");
			assertEquals(lp.getSignUpVerificationCodeErrorMessage(driver),
					"Verification should only be in numeric format", "Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Enter Verification Code 12345");
			lp.enterSignUpVerificationCode("12345", driver);
			step++;

			testSteps.add("Step " + step + " : Verify Verification code error message is displaying");
			assertEquals(lp.getSignUpVerificationCodeErrorMessage(driver), "Must be exactly 6 digits",
					"Error messages are not equals.");
			step++;

			testSteps.add("Step " + step + " : Close the Browser");
			AddTest_IntoReport("SignUp_Invalid_Data", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: SignUp_Invalid_Data " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("SignUp_Invalid_Data") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("SignUp_Invalid_Data", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: SignUp_Invalid_Data " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("SignUp_Invalid_Data") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("SignUp_Invalid_Data", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

}