package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.LoginPage;

public class TestLogin extends BaseClass {
	String tempSrc = "";

	@Test
	public void Login_B2C_Email() {
		WebDriver driver = null;
		ArrayList<String> testSteps = new ArrayList<>();
		LoginPage lp;

		driver = initConfiguration();

		printString("Login_B2C_Email:" + driver.hashCode() + "", driver);
		lp = new LoginPage(driver);
		Object[][] dataArr = getData("testData", "TestData", driver);
		String appPassword = dataArr[0][0].toString();
		String email = dataArr[0][1].toString();
		String pass = dataArr[0][2].toString();
		String pinCode = dataArr[rowIndex][3].toString();
		int steps = 0;
		try {

			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-10?atlOrigin=eyJpIjoiMzVjNmMxZThlNDkxNGZkMzg0MzQzMjNmNjQ4NmE1ZTUiLCJwIjoiaiJ9\">QAA-10 : Verify that a user is successfully able to login into the B2C platform<a/>");
			testSteps.add("Step " + (++steps) + " : Visit app url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);

			testSteps.add("Step " + (++steps) + " : Enter app Password");
			lp.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);

			testSteps.add("Step " + (++steps) + " : Click on submit");
			lp.clickOnSubmitButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on Login Page Button");
			lp.clickOnLoginPageButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on Login with Email");
			lp.clickOnloginWithEmail(driver);

			testSteps.add("Step " + (++steps) + " : Enter Email Address : <b>"
					+ PropertiesReader.getPropertyValue(env + "_" + "EmailId"));
			lp.enterB2CUserEmailAddress(PropertiesReader.getPropertyValue(env + "_" + "EmailId"), driver);

			testSteps.add("Step " + (++steps) + " : Enter Password ");
			lp.enterB2CUserPassword(PropertiesReader.getPropertyValue(env + "_" + "Password"), driver);

			testSteps.add("Step " + (++steps) + " : Click on Login Button");
			lp.clickOnLoginButton(driver);

			testSteps.add("Step " + (++steps) + " : Enter Pin Code : "
					+ PropertiesReader.getPropertyValue(env + "_" + "Pin"));
			lp.enterPinCode(PropertiesReader.getPropertyValue(env + "_" + "Pin"), driver);

			testSteps.add("Step " + (++steps) + " : Click on 'Continue' Button");
			lp.clickOnContinueButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on 'Next' Button");
			lp.clickOnBtnNext(driver);

			testSteps.add("Step " + (++steps) + " : Click on 'Ok Got It' Button");
			lp.clickOnBtnOkGotIt(driver);

			testSteps.add("Step " + (++steps) + " : Verifying Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Failed to Verify Dashboard is displayed");

			testSteps.add("Step " + (++steps) + " : Close the Browser");
			AddTest_IntoReport("Login_B2C_Email", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: Login_B2C_Email " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_B2C_Email") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_B2C_Email", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Login_B2C_Email " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_B2C_Email") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_B2C_Email", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void Login_AxisUser() {

		ArrayList<String> testSteps = new ArrayList<>();
		LoginPage lp;
		WebDriver driver = null;
		driver = initConfiguration();

		printString("Login_AxisUser:" + driver.hashCode() + "", driver);
		lp = new LoginPage(driver);
		Object[][] dataArr = getData("LoginTestData_MultipleB2BUsers", "Non-SSO Credentials", driver);
		String url = dataArr[0][3].toString();
		String userName = dataArr[0][1].toString();
		String email = dataArr[0][4].toString();
		String pass = dataArr[0][5].toString();
		String appPassword = dataArr[0][2].toString();
		int steps = 0;

		try {
			testSteps.add(

					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-13?atlOrigin=eyJpIjoiZTdiYWZmODgwMDQyNDAzNThmZjU5NWRhOWZkYTQ5MTQiLCJwIjoiaiJ9\">QAA-13 : Web - Verify that a user is successfully able to login into the B2B platform<a/>");
			testSteps.add("Step " + (++steps) + " : Visit app url");
			navigateToURL(url, driver);

			testSteps.add("Step " + (++steps) + " : Enter app Password");
			lp.enterB2BWebPassword(appPassword, driver);

			testSteps.add("Step " + (++steps) + " : Click on submit");
			lp.clickOnSubmitButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on Continue Button");
			lp.clickOnContinueButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on Login Page Button");
			lp.clickOnLoginPageButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on Login with Email");
			lp.clickOnloginWithEmail(driver);

			testSteps.add("Step " + (++steps) + " : Enter Email Address: <b>" + email);
			lp.enterB2BUserEmailAddress(email, driver);

			testSteps.add("Step " + (++steps) + " : Enter Password");
			lp.enterB2BUserPassword(pass, driver);

			testSteps.add("Step " + (++steps) + " : Click on Login Button");
			lp.clickOnLoginButton(driver);

			testSteps.add("Step " + (++steps) + " : Click on 'Next' Button");
			lp.clickOnBtnNext(driver);

			testSteps.add("Step " + (++steps) + " : Click on 'Ok Got It' Button");
			lp.clickOnBtnOkGotIt(driver);

			testSteps.add("Step " + (++steps) + " : Verify Dashboard is display");
			assertTrue(lp.isDashBoardDisplay(driver), "Verified Dashboard is displayed");

			testSteps.add("Step " + (++steps) + " : Close the Browser");
			AddTest_IntoReport("Login_AxisUser", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Login_AxisUser " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_AxisUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_AxisUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Login_AxisUser " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_AxisUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_AxisUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test
	public void Login_B2B_Email() {

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
		String dashboardTitle = "Dashboard | Vested Finance";
		String LoginPageTitle = "Login | Vested Finance";

//		String sheetId="1kKcVv0oF7Plm9Z7P_zqxs1C9blYEeVtL05BU3RWoO7M";
//		String sheetName= "TestSheet";
//		String range = "A1:B20";	
//		try {
//			//String[][] data =Utilities.getData(sheetId, sheetName, range);
//			for(int x=0;x<data.length;x++) {
//				for(int y=0;y<data.length;y++) {
//					printString(data[x][0].toString());
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			
//		}

		driver = initConfiguration();

		printString("Login_B2B_Email:" + driver.hashCode() + "", driver);
		lp = new LoginPage(driver);
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-5?atlOrigin=eyJpIjoiMzQ0MGQ0NWYyOGJmNGI3YTgyYzQwZTQ4Y2M5MjYyNmQiLCJwIjoiaiJ9\">QAA-5 : Verify that a user is successfully able to login into the B2B platform from excel sheet<a/>");

		String url = "";
		String userName = "";
		String email = "";
		String pass = "";
		String pinCode = "";
		int step = 1;
		try {
			for (int x = 0; x < data.length; x++) {
				try {
					getRefreshWebPage(driver);
					Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
					url = data[x][3].toString();
					userName = data[x][1].toString();
					email = data[x][4].toString();
					pass = data[x][5].toString();
					pinCode = dataArr[rowIndex][3].toString();
					printString(url, driver);

					testSteps.add("<b>Verify authentication for User : '" + userName + "' </b>");
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
						testSteps.add("Step " + (++step) + ": No Pin Required For thos User");
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
//					try {
//						assertEquals(lp.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
//					} catch (Exception e1) {
//						assertEquals(lp.getPageTitle(driver), LoginPageTitle, "Failed : Login title not matched");
//					}

					}

					step++;

				} catch (Exception e) {
					testSteps.add("Failed: To verify " + userName);
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
				}

			}

			testSteps.add("Step " + step + " : Close the Browser");

			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			AddTest_IntoReport("Login_B2B_Email", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Login_B2B_Email " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_B2B_Email") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_B2B_Email", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Login_B2B_Email " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_B2B_Email") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_B2B_Email", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test
	public void Login_InvalidCredentials() {
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		printString("Login_InvalidCredentials:" + driver.hashCode(), driver);
		String appPassword = PropertiesReader.getPropertyValue(env + "_" + "app_password");
		String email = PropertiesReader.getPropertyValue(env + "_" + "EmailId");
		String pass = PropertiesReader.getPropertyValue(env + "_" + "Password");
		String pinCode = PropertiesReader.getPropertyValue(env + "_" + "Pin");

		String invalidAppPassword = "jhsweiu387";
		String invalidAppPasswordPopupMessage = "Incorrect password provided";
		String blankAppPasswordMessage = "Please enter your password";
		String blankEmailErrorMessage = "Please enter your email";
		String blankPasswordErrorMessage = "Please enter your password";
		String InCorrectUserAndEmailErrorMessage = "Incorrect username or password.";
		String InCorrectEmailFormatErrorMessage = "Invalid email ID format.";
		String InvalidPinErrorMessage = "You've entered an invalid PIN.";
		String timeoutPinErrorMessage = "Request timed out. Please try again.";
		String invalidemail = "12345@yahoo.com";
		String nonEmailFormat = "12345";
		String invalidPassword = "helloworld";
		String invalidPin = "123456";
		int step = 0;

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-119?atlOrigin=eyJpIjoiNDFmNDdhNmU0YjI4NDU2ZGEwNDQ5NjRjNDI3NjRjZmQiLCJwIjoiaiJ9\">QAA-119 : [Web][Negative] Verify user is not able to login with Invalid Credentials<a/>");
			testSteps.add("Step " + (++step) + " : Visit app url");
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);

			if (PropertiesReader.getPropertyValue("production").toLowerCase().equalsIgnoreCase("no")) {
				testSteps.add("Step " + (++step) + " : Click on submit");
				lp.clickOnSubmitButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Blank App Password Message'");
				assertEquals(lp.getBlankAppPasswordMessage(driver), blankAppPasswordMessage,
						"Blank App Password Message Mismatched");
				testSteps.add("Step " + (++step) + " : Verified Blank App Password Message <b>'"
						+ blankAppPasswordMessage + "'</b>");

				testSteps.add("Step " + (++step) + " : Enter app Password: <b>'" + appPassword + "'</b>");
				lp.enterB2BWebPassword(appPassword, driver);

				testSteps.add("Step " + (++step) + " : Click on submit");
				lp.clickOnSubmitButton(driver);

			}

			testSteps.add("Step " + (++step) + " : Click on Login Page Button");
			lp.clickOnLoginPageButton(driver);

			testSteps.add("Step " + (++step) + " : Click on Login with Email");
			lp.clickOnloginWithEmail(driver);

			testSteps.add("Step " + (++step) + " : Click on Login Button");
			lp.clickOnLoginButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Blank Email Error Message'");
			assertEquals(lp.getBlankEmailMessage(driver), blankEmailErrorMessage,
					"Blank Email Error Message Mismatched");
			testSteps.add("Step " + (++step) + " : Verified Blank App Password Message <b>'" + blankEmailErrorMessage
					+ "'</b>");

			testSteps.add("Step " + (++step) + " : Verifying 'Blank Password Error Message'");
			assertEquals(lp.getBlankPasswordMessage(driver), blankPasswordErrorMessage,
					"Blank Password Error Message Mismatched");
			testSteps.add("Step " + (++step) + " : Verified Blank Password Error Message <b>'"
					+ blankPasswordErrorMessage + "'</b>");

			testSteps.add("Step " + (++step) + " : Enter Invalid Email Address : <b>'" + invalidemail + "'</b>");
			lp.enterB2CUserEmailAddress(invalidemail, driver);

			testSteps.add("Step " + (++step) + " : Enter Invalid Password :<b>'" + invalidPassword + "'</b>");
			lp.enterB2CUserPassword(invalidPassword, driver);

			testSteps.add("Step " + (++step) + " : Click on Login Button");
			lp.clickOnLoginButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'User doesn't exist error message is displaying'");
			assertTrue(lp.getUserNotExistMessage(driver), "User doesn't exist message not displayed");
			testSteps.add("Step " + (++step) + " : Verified 'User doesn't exist error message is displaying'");

			testSteps.add("Step " + (++step) + " : Enter Email Address : <b>'" + email + "'</b>");
			lp.enterB2CUserEmailAddress(email, driver);

			testSteps.add("Step " + (++step) + " : Enter Invalid Password :<b>'" + invalidPassword + "'</b>");
			lp.enterB2CUserPassword(invalidPassword, driver);

			testSteps.add("Step " + (++step) + " : Click on Login Button");
			lp.clickOnLoginButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Incorrect Username And Email Error Message'");
			assertEquals(lp.getIncorrectUsernameAndPasswordErrorMessage(driver), InCorrectUserAndEmailErrorMessage,
					"Blank Password Error Message Mismatched");
			testSteps.add("Step " + (++step) + " : Verified Blank Password Error Message <b>'"
					+ InCorrectUserAndEmailErrorMessage + "'</b>");

			testSteps.add("Step " + (++step) + " : Enter Email Address : <b>'" + nonEmailFormat + "'</b>");
			lp.enterB2CUserEmailAddress(nonEmailFormat, driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Incorrect Email Format Error Message'");
			assertEquals(lp.getIncorrectEmailFormatErrorMessage(driver), InCorrectEmailFormatErrorMessage,
					"Blank Password Error Message Mismatched");
			testSteps.add("Step " + (++step) + " : Verified Blank Password Error Message <b>'"
					+ InCorrectEmailFormatErrorMessage + "'</b>");

			testSteps.add("Step " + (++step) + " : Enter Email Address : <b>'" + email + "'</b>");
			lp.enterB2CUserEmailAddress(email, driver);

			testSteps.add("Step " + (++step) + " : Enter Password : <b>'" + pass + "'</b>");
			lp.enterB2CUserPassword(pass, driver);

			testSteps.add("Step " + (++step) + " : Click on Login Button");
			lp.clickOnLoginButton(driver);

			testSteps.add("Step " + (++step) + " : Enter Invalid Pin : <b>'" + invalidPin + "'</b>");
			lp.enterPinCode(invalidPin, driver);

			testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
			lp.clickOnContinueButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Invalid Pin Error Message'");
			assertTrue(lp.getInvalidPinErrorMessage(driver).contains(InvalidPinErrorMessage),
					"Invalid Pin Error Message Mismatched");
			testSteps.add("Step " + (++step) + " : Verified Invalid Pin Error Message <b>'" + InvalidPinErrorMessage
					+ "'</b>");

			testSteps.add("Step " + (++step) + " : Waiting for '10 minutes' ");
			waitfor10mints();

			testSteps.add("Step " + (++step) + " : Enter Pin : <b>'" + pinCode + "'</b>");
			lp.enterPinCode(pinCode, driver);

			testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
			lp.clickOnContinueButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Request Timeout Retry Pin Error Message'");
			assertEquals(lp.getTimeoutPinErrorMessage(driver), timeoutPinErrorMessage,
					"Request Timeout Retry Pin Error Message Mismatched");
			testSteps.add("Step " + (++step) + " : Verified Request Timeout Retry Pin Error Message <b>'"
					+ timeoutPinErrorMessage + "'</b>");

			testSteps.add("Step " + (++step) + " : Close the Browser");
			AddTest_IntoReport("Login_InvalidCredentials", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: Login_InvalidCredentials " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_InvalidCredentials") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_InvalidCredentials", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Login_InvalidCredentials " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Login_InvalidCredentials") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Login_InvalidCredentials", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

//	@Test
	public void Update_ChangePassword() {
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		printString("Update_ChangePassword:" + driver.hashCode(), driver);
		Object[][] dataArr = getData("testData", "Update_ChangePassword", driver);
		String email = PropertiesReader.getPropertyValue(env + "_" + "EmailId");
		String pass = PropertiesReader.getPropertyValue(env + "_" + "Password");
		String changePassword = "$Pa4" + generateRandomStringWithGivenNumberOfDigits(5, driver);
		String getPassword = "";
		int step = 0;
		try {
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add(
						"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-189?atlOrigin=eyJpIjoiYWM1YjcwMGEwZmI2NDdkNGEwMzdmOGE3YTBkN2UxMzMiLCJwIjoiaiJ9\">QAA-189 : [Web][ Update account Password] Update the user password from the Profile<a/>");
				testSteps.add("Step " + (++step) + " : Visit app url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);

				lp.loginToApp(email, pass, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Profile Drop Down'");
				lp.clickOnProfileDropDown(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Security Tab'");
				lp.clickOnSecurity(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Change Password' button");
				lp.clickOnChangePasswordButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Current Password'");
				lp.enterCurrentPassword(pass, driver);

				testSteps.add("Step " + (++step) + " : Enter 'New Password'");
				lp.enterNewPassword(changePassword, driver);

				testSteps.add("Step " + (++step) + " : Enter 'Confirm Password'");
				lp.enterConfirmPassword(changePassword, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Hidden Eye' icon");
				lp.clickOnNewPasswordHiddenIcon(driver);

				testSteps.add("Step " + (++step) + " : Getting 'New Password' value");
				getPassword = lp.getNewPasswordValue(driver);

				testSteps.add("Step " + (++step) + " : Verifying Password in visible");
				assertEquals(getPassword, changePassword, "Hidden Password is not visible.");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Click on 'Change Password' Button");
				lp.clickOnChangePasswordButton_2(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Successful Change Password' message is present");
				assertTrue(lp.isSuccessfulChangePasswordMessagePresent(driver),
						"Verified 'Successful Change Password' message is present");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Click on 'Back To Dashboard' Button");
				lp.clickOnBackToDashboardButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Dashboard Page' is displayed");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified 'Dashboard Page' is displayed");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Click on 'Profile Drop Down'");
				lp.clickOnProfileDropDown(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Security Tab'");
				lp.clickOnSecurity(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Change Password' button");
				lp.clickOnChangePasswordButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Current Password'");
				lp.enterCurrentPassword(changePassword, driver);

				testSteps.add("Step " + (++step) + " : Enter 'New Password'");
				lp.enterNewPassword(pass, driver);

				testSteps.add("Step " + (++step) + " : Enter 'Confirm Password'");
				lp.enterConfirmPassword(pass, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Change Password' Button");
				lp.clickOnChangePasswordButton_2(driver);

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Close the Browser");

				AddTest_IntoReport("Update_ChangePassword", testSteps, driver);
			} else {
				testSteps.add("Step " + (++step) + " : Change Password Is not Implemented In Pre-Prod");

				testSteps.add("Step " + (++step) + " : Close the Browser");

				AddTest_IntoReport("Update_ChangePassword", testSteps, driver);
			}

		} catch (Exception e) {
			testSteps.add("Failed: Update_ChangePassword " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Update_ChangePassword") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Update_ChangePassword", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Update_ChangePassword " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Update_ChangePassword") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Update_ChangePassword", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

//	@Test
	public void Update_ChangePinCode() {
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		driver = initConfiguration();

		lp = new LoginPage(driver);
		printString("Update_ChangePinCode:" + driver.hashCode(), driver);
		Object[][] dataArr = getData("testData", "Update_ChangePassword", driver);
		String email = PropertiesReader.getPropertyValue(env + "_" + "EmailId");
		String pass = PropertiesReader.getPropertyValue(env + "_" + "Password");
		String defaultPin = "111111";
		String randomPin = generateRandomNumberWithGivenNumberOfDigits(6, driver);
		String invalidPin = "123";
		int step = 0;

		try {
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {

				testSteps.add(
						"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-190?atlOrigin=eyJpIjoiMmNiYWU1MGJjYzQyNDE5Zjk4ZGZiODQ1YjkxODE0OTEiLCJwIjoiaiJ9\">QAA-190 : [Web] Update Security PIN<a/>");
				testSteps.add("Step " + (++step) + " : Visit app url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);

				lp.loginToApp(email, pass, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Profile Drop Down'");
				lp.clickOnProfileDropDown(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Security Tab'");
				lp.clickOnSecurity(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Change Security Pin' Button");
				lp.clickOnChangeSecurityPinButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Security Pin'");
				lp.enterPinCode(defaultPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Less than 6 Digit Of Security Pin'");
				lp.enterPinCode(invalidPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Pin must be 6 digits.' message is present");
				assertTrue(lp.isSecurityPinErrorMessagePresent(driver),
						"Verified 'Pin must be 6 digits' message is present");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Enter 'New Security Pin'");
				lp.enterPinCode(randomPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Confirm Incorrect Security Pin'");
				lp.enterConfirmPinCode(defaultPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step)
						+ " : Verifying 'The two pins you entered did not match. Please re-enter the pin' message is present");
				assertTrue(lp.isSecurityPinErrorMessagePresent(driver),
						"Verified 'The two pins you entered did not match. Please re-enter the pin' message is present");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Enter 'Confirm Security Pin'");
				lp.enterConfirmPinCode(randomPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Successful Change Pin' message is present");
				assertTrue(lp.isSuccessfulChangePinMessagePresent(driver),
						"Verified 'Successful Change Pin' message is present");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Click on 'Back To Dashboard' Button");
				lp.clickOnBackToDashboardButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Dashboard Page' is displayed");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified 'Dashboard Page' is displayed");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Click on 'Profile Drop Down'");
				lp.clickOnProfileDropDown(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Security Tab'");
				lp.clickOnSecurity(driver);

				testSteps.add("Step " + (++step) + " : Click on 'Change Security Pin' Button");
				lp.clickOnChangeSecurityPinButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Security Pin'");
				lp.enterPinCode(randomPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Security Pin'");
				lp.enterPinCode(defaultPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);

				testSteps.add("Step " + (++step) + " : Enter 'Security Pin'");
				lp.enterConfirmPinCode(defaultPin, driver);

				testSteps.add("Step " + (++step) + " : Click on 'Continue' Button");
				lp.clickOnContinuePinCodeButton(driver);
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++step) + " : Close the Browser");

				AddTest_IntoReport("Update_ChangePinCode", testSteps, driver);
			} else {
				testSteps.add("Step " + (++step) + " : Update pinCode is not Implemeted In Pre-Prod");

				testSteps.add("Step " + (++step) + " : Close the Browser");

				AddTest_IntoReport("Update_ChangePinCode", testSteps, driver);
			}

		} catch (Exception e) {
			testSteps.add("Failed: Update_ChangePinCode " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Update_ChangePinCode") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Update_ChangePinCode", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Update_ChangePinCode " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Update_ChangePinCode") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Update_ChangePinCode", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

//	@Test
	public void ResetPinCode_LaunchURL() {

		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		driver = initConfiguration();
		Object[][] dataArr = getData("testData", "ResetPinCode_LaunchURL", driver);
		lp = new LoginPage(driver);
		String email = dataArr[0][0].toString();
		String pass = dataArr[0][1].toString();
		String answer_1 = dataArr[0][2].toString();
		String answer_2 = dataArr[0][3].toString();

		int i = 0;
		try {
			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add(
						"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-204?atlOrigin=eyJpIjoiNzQzNDg3MGFmMDM5NDQ4OGI0YWMzMmJmNGY5ZGI4ZmQiLCJwIjoiaiJ9\">QAA-204 : [Reset PIN web] Reset Pin from the launch URL<a/>");
				testSteps.add("Step " + (++i) + " : Visit app url");
				navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
				testSteps.add("<b>Login With Out Pin Code</b>");
				lp.loginToAppWithOutPinCode(email, pass, driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Forgot Pin Code'");
				lp.clickOnForgotPinCode(driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Reset Pin' Button");
				lp.clickOnResetPinButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Answer 1 is Required' is displayed");
				assertTrue(lp.isAnswer1ErrorMessagePresent(driver), "Verified 'Answer 1 is Required' is displayed");

				testSteps.add("Step " + (++i) + " : Verifying 'Answer 2 is Required' is displayed");
				assertTrue(lp.isAnswer2ErrorMessagePresent(driver), "Verified 'Answer 2 is Required' is displayed");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++i) + " : Verifying 'Reset button' is disabled");
				assertFalse(lp.isResetPinDisabled(), "Verified 'Reset button' is disabled");

				testSteps.add("Step " + (++i) + " : Enter 'Answer 1'");
				lp.enterAnswer1(answer_1, driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Answer 2 is Required' is displayed");
				assertTrue(lp.isAnswer2ErrorMessagePresent(driver), "Verified 'Answer 2 is Required' is displayed");

				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				lp.clearAnswer1(driver);

				testSteps.add("Step " + (++i) + " : Enter 'Answer 2'");
				lp.enterAnswer2(answer_2, driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Answer 1 is Required' is displayed");
				assertTrue(lp.isAnswer1ErrorMessagePresent(driver), "Verified 'Answer 1 is Required' is displayed");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++i) + " : Enter 'Answer 1'");
				lp.enterAnswer1(answer_1, driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Reset Pin' Button");
				lp.clickOnResetPinButton(driver);

				testSteps.add("Step " + (++i) + " : Enter 'Pin Code'");
				lp.enterPinCode(pinCode, driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Eye Icon'");
				lp.clickOnEyeIcon(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Pin Code value is visible'");
				assertEquals(lp.getPinValue(driver), pinCode, "Pin Code value is not equal");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++i) + " : Click on 'Continue' Button");
				lp.clickOnContinueButton(driver);

				testSteps.add("Step " + (++i) + " : Enter 'Confirm Pin Code'");
				lp.enterConfirmPinCode(pinCode, driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Eye Icon'");
				lp.clickOnEyeIcon(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Confirm Pin Code value is visible'");
				assertEquals(lp.getConfirmPinValue(driver), pinCode, "Confirm Pin Code value is not equal");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++i) + " : Click on 'Continue' Button");
				lp.clickOnContinueButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Pin Changed Successfully' is displayed");
				assertTrue(lp.isSuccessfulChangePinMessagePresent(driver),
						"Verified 'Pin Changed Successfully' is displayed");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++i) + " : Click on 'Back To Dashboard' Button");
				lp.clickOnBackToDashboardButton(driver);

				lp.clickOnBtnNext(driver);
				lp.clickOnBtnOkGotIt(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'DashBoard' is displayed");
				assertTrue(lp.isDashBoardDisplay(driver), "Verified 'DashBoard' is displayed");
				tempSrc = getScreenshotPath();
				testSteps.add(tempSrc);
				captureCapture(driver, tempSrc);

				testSteps.add("Step " + (++i) + " : Close the Browser");
				AddTest_IntoReport("Update_ChangePassword", testSteps, driver);
			} else {
				testSteps.add("Step " + (++i) + " : Reset Pin is not Implemented in Pre-Prod");

				testSteps.add("Step " + (++i) + " : Close the Browser");
				AddTest_IntoReport("Update_ChangePassword", testSteps, driver);
			}

		} catch (Exception e) {
			testSteps.add("Failed: ResetPinCode_LaunchURL " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ResetPinCode_LaunchURL") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ResetPinCode_LaunchURL", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: ResetPinCode_LaunchURL " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ResetPinCode_LaunchURL") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ResetPinCode_LaunchURL", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}
}
