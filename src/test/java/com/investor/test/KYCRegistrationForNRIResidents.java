package com.investor.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.KYCRegistrationPage;
import com.investor.pages.LoginPage;

public class KYCRegistrationForNRIResidents extends BaseClass {
	String tempSrc = "";

	@Test(priority = 1)
	public void KYC_NRI_USA() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_NRI_USA: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-69?atlOrigin=eyJpIjoiNjVhYjZhMTRiMzFlNDk4YTk4YmVkYjc3YWFjYmQ0YTQiLCJwIjoiaiJ9\">QAA-69 : KYC registration for NRI<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "United States";
		String countryNationality = "United States of America";
		String SSN_number = "296482326";
		String Phone_number = "0987654321";
		String filepath = imagePath + "PassportImage.PNG";
		String passportfileno = "BP4063972871419";
		String Address1 = "Address1";
		String Address2 = "Address2";
		String City = "California";
		String PinCode = "268643";
		String State = "Alabama";
		String fullName = "Mohit Singh Chahar";

		int i = 0;
		try {
			String email = "vested.automation+w01nri_usa@gmail.com";
			
			loginPage.loginToApp(email, password, driver);

//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}
			

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_number);
			kycRegistrationPage.enterTaxID(SSN_number, driver);
			
			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
				
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number);
				kycRegistrationPage.enterPhoneNumber(Phone_number, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport' button");
//			kycRegistrationPage.clickOnUploadPassport_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.uploadfile(filepath, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter passport file No : " + passportfileno);
//			kycRegistrationPage.enterPassportfileNoInput(passportfileno, driver);

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(Address1, Address2, City, State, PinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify that 'Select a plan that suits you best' page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that 'Select a plan that suits you best' page is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : click on 'I Agree' Checkbok");
//			kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Full name :  " + fullName);
//			kycRegistrationPage.enterYourFullName(fullName, driver);

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
//				testSteps.add("Step " + (++i) + " : Click on 'Done Button'");
//				kycRegistrationPage.clickOnDoneButton(driver);
//
//				testSteps.add("Step " + (++i)
//						+ " : Verify that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
//				assertTrue(kycRegistrationPage.verifyKycApprovedTitleIsDisplaying(driver),
//						"Verified that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYC_NRI_USA", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYC_NRI_USA " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NRI_USA") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NRI_USA", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			

			testSteps.add("Failed: KYC_NRI_USA " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NRI_USA") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NRI_USA", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 2)
	public void KYC_NRI() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_NRI:" + driver.hashCode() + "", driver);
		Object[][] loginSheet = getData(testDataFile, testDataSheet, driver);
		String appPassword = loginSheet[rowIndex][0].toString();

		Object[][] dataArr = getData(testDataFile, KYC_OtherNRI_Reg, driver);

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-70?atlOrigin=eyJpIjoiMzE2ZDk4YzNkZDFlNDE3ZDk5N2IwYzAwNmViYTU5MDQiLCJwIjoiaiJ9\">QAA-70 : KYC registration for residents in Any other country<a/>");

		String fullName = dataArr[rowIndex][0].toString();

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String phoneNumber = dataArr[rowIndex][3].toString();
		String Phone_number2 = "0918653578";
		String address1 = dataArr[rowIndex][6].toString();
		String address2 = dataArr[rowIndex][7].toString();
		String city = dataArr[rowIndex][8].toString();
		String pinCode = dataArr[rowIndex][9].toString();
		String state = "AL";
//		String state = dataArr[rowIndex][10].toString();
		String country = "Japan";
		String countryNationality = "Japan";
//		String country = dataArr[rowIndex][12].toString();
		String SSN_Number = dataArr[rowIndex][13].toString();
		String passportImage = imagePath + dataArr[rowIndex][14].toString();
		String passportFileNo = dataArr[rowIndex][15].toString();
		String email = "vested.automation+w02nri@gmail.com";

		int i = 0;
		try {
			
			
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId(dataArr[rowIndex][1].toString(), driver, 4);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//			wait6s();
//			wait6s();
//			wait6s();
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_Number);
			kycRegistrationPage.enterTaxID(SSN_Number, driver);

			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number2);
				kycRegistrationPage.enterPhoneNumber(Phone_number2, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport' button");
//			kycRegistrationPage.clickOnUploadPassport_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.uploadfile(passportImage, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter passport file No : " + passportFileNo);
//			kycRegistrationPage.enterPassportfileNoInput(passportFileNo, driver);

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify that 'Select a plan that suits you best' page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that 'Select a plan that suits you best' page is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : click on 'I Agree' Checkbok");
//			kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Full name :  " + fullName);
//			kycRegistrationPage.enterYourFullName(fullName, driver);

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
//				testSteps.add("Step " + (++i) + " : Click on 'Done Button'");
//				kycRegistrationPage.clickOnDoneButton(driver);
//
//				testSteps.add("Step " + (++i)
//						+ " : Verify that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
//				assertTrue(kycRegistrationPage.verifyKycApprovedTitleIsDisplaying(driver),
//						"Verified that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYC_NRI", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYC_NRI " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NRI") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NRI", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: KYC_NRI " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NRI") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NRI", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 3)
	public void KYC_DifferentTaxResidencies() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_DifferentTaxResidencies:" + driver.hashCode() + "", driver);
		Object[][] loginSheet = getData(testDataFile, testDataSheet, driver);
		String appPassword = loginSheet[rowIndex][0].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-318?atlOrigin=eyJpIjoiM2RmZjU2MzI5YzQ4NGMxMjlmOGJjOTdjYWE0NGQwOTYiLCJwIjoiaiJ9\">QAA-318 : KYC registration for residents in 3 different countries<a/>");

		Object[][] dataArr = getData(testDataFile, KYC_OtherNRI_Reg, driver);
		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String Phone_number2 = "0918653578";
		String address1 = dataArr[rowIndex][6].toString();
		String address2 = dataArr[rowIndex][7].toString();
		String city = dataArr[rowIndex][8].toString();
		String pinCode = dataArr[rowIndex][9].toString();
		String state = "AL";
		String country = "Japan";
		String country1 = "Ireland";
		String country2 = "Italy";
		String countryNationality = "Japan";
		String SSN_Number = dataArr[rowIndex][13].toString();
		String email = "vested.automation+w01differentresidence@gmail.com";
			
			

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId(dataArr[rowIndex][1].toString(), driver, 4);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//			wait6s();
//			wait6s();
//			wait6s();
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}


			testSteps.add("<b>*****************For " + country + "*****************</b>");

			testSteps.add("Step " + (++i) + " : Choose " + country + " Tax Residency");
			kycRegistrationPage.choose_TaxResidency(country, driver);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_Number);
			kycRegistrationPage.enterTaxID(SSN_Number, driver);
			
			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
				
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number2);
				kycRegistrationPage.enterPhoneNumber(Phone_number2, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Kyc Previous' Button");
			kycRegistrationPage.clickOnKYCPreviousButton(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Kyc Previous' Button");
			kycRegistrationPage.clickOnKYCPreviousButton(driver);
			//
			testSteps.add("<b>*****************For " + country1 + "*****************</b>");

			testSteps.add("Step " + (++i) + " : Choose " + country1 + " Tax Residency");
			kycRegistrationPage.choose_TaxResidency(country1, driver);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country1 + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, country1);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

//			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
//			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_Number);
			kycRegistrationPage.enterTaxID(SSN_Number, driver);
			
			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number2);
				kycRegistrationPage.enterPhoneNumber(Phone_number2, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Kyc Previous' Button");
			kycRegistrationPage.clickOnKYCPreviousButton(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Kyc Previous' Button");
			kycRegistrationPage.clickOnKYCPreviousButton(driver);

			//
			testSteps.add("<b>*****************For " + country2 + "*****************</b>");

			testSteps.add("Step " + (++i) + " : Choose " + country2 + " Tax Residency");
			kycRegistrationPage.choose_TaxResidency(country2, driver);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country2 + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, country2);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

//			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
//			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_Number);
			kycRegistrationPage.enterTaxID(SSN_Number, driver);
			
			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number2);
				kycRegistrationPage.enterPhoneNumber(Phone_number2, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYC_DifferentTaxResidencies", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYC_DifferentTaxResidencies " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_DifferentTaxResidencies") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_DifferentTaxResidencies", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: KYC_DifferentTaxResidencies " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_DifferentTaxResidencies") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_DifferentTaxResidencies", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 4)
	public void KYC_NRI_UAE() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_NRI_UAE: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-632?atlOrigin=eyJpIjoiNTg0NzFhYjZiODRmNGQ1MGE3MWI0ZjBmMmE1ZGI4NmQiLCJwIjoiaiJ9\">QAA-632 : [Web] - KYC registration for UAE<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "United Arab Emirates";
		String countryNationality = "United Arab Emirates";
		String SSN_number = "296482326";
		String Phone_number = "0987654321";
		String filepath = imagePath + "PassportImage.PNG";
		String passportfileno = "BP4063972871419";
		String Address1 = "Address1";
		String Address2 = "Address2";
		String City = "Dubai";
		String PinCode = "268643";
		String State = "Dubai";
		String fullName = "Mohit Singh Chahar";
		String email = "vested.automation+w01uae@gmail.com";

			

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_number);
			kycRegistrationPage.enterTaxID(SSN_number, driver);
			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number);
				kycRegistrationPage.enterPhoneNumber(Phone_number, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport' button");
//			kycRegistrationPage.clickOnUploadPassport_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.uploadfile(filepath, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter passport file No : " + passportfileno);
//			kycRegistrationPage.enterPassportfileNoInput(passportfileno, driver);

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(Address1, Address2, City, State, PinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify that 'Select a plan that suits you best' page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that 'Select a plan that suits you best' page is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : click on 'I Agree' Checkbok");
//			kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Full name :  " + fullName);
//			kycRegistrationPage.enterYourFullName(fullName, driver);

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
//				testSteps.add("Step " + (++i) + " : Click on 'Done Button'");
//				kycRegistrationPage.clickOnDoneButton(driver);
//
//				testSteps.add("Step " + (++i)
//						+ " : Verify that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
//				assertTrue(kycRegistrationPage.verifyKycApprovedTitleIsDisplaying(driver),
//						"Verified that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYC_NRI_UAE", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: KYC_NRI_UAE " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NRI_UAE") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NRI_UAE", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: KYC_NRI_UAE " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NRI_UAE") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NRI_UAE", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 5)
	public void IndianNationality_NonIndianTaxResidency_KYC() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("IndianNationality_NonIndianTaxResidency_KYC: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-656?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-656 : [Web] - KYC Verification For User With Indian Nationality and Non-Indian Tax Residence<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "Albania";
		String countryNationality = "India";
		String SSN_number = "296482326";
		String Phone_number = "0987654321";
		String filepath = imagePath + "PassportImage.PNG";
		String passportfileno = "BP4063972871419";
		String Address1 = "Address1";
		String Address2 = "Address2";
		String City = "Alaska";
		String PinCode = "268643";
		String State = "Alaska";
		String fullName = "Mohit Singh Chahar";
		String email = "vested.automation+w012345@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Enter TaxID:  " + SSN_number);
			kycRegistrationPage.enterTaxID(SSN_number, driver);

			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  " + Phone_number);
				kycRegistrationPage.enterPhoneNumber(Phone_number, driver);

				testSteps.add("Step " + (++i) + " : Mobile Verification");
				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
			}

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Button is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityButtonDisplaying(driver),
					"'Verify your identity' is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Button is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Verify Your Identity' Button");
			kycRegistrationPage.clickOnVerifyIdentityButton(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Displaying");
			assertTrue(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not displaying");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Identity Verification Popup Close' Button");
			kycRegistrationPage.closeVerifyIdentityPopup(driver);

			testSteps.add("Step " + (++i) + " : Verify Is Identity Verification Popup is Successfully Closed");
			assertFalse(kycRegistrationPage.isVerifyYourIdentityPopupHeadingDisplaying(driver),
					"'Verify your identity' Popup is not Successfully Closed");
			testSteps.add("Step " + (++i) + " : Verified Identity Verification Popup is Successfully Closed");

//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport' button");
//			kycRegistrationPage.clickOnUploadPassport_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On 'Upload Passport popUp Confirm' button");
//			kycRegistrationPage.uploadfile(filepath, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter passport file No : " + passportfileno);
//			kycRegistrationPage.enterPassportfileNoInput(passportfileno, driver);

			testSteps.add("Step " + (++i) + " : Enter Address Information");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(Address1, Address2, City, State, PinCode, driver));

			testSteps.add("Step " + (++i) + " : Confirm Checkbok");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify that 'Select a plan that suits you best' page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that 'Select a plan that suits you best' page is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : click on 'I Agree' Checkbok");
//			kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Full name :  " + fullName);
//			kycRegistrationPage.enterYourFullName(fullName, driver);

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
//				testSteps.add("Step " + (++i) + " : Click on 'Done Button'");
//				kycRegistrationPage.clickOnDoneButton(driver);
//
//				testSteps.add("Step " + (++i)
//						+ " : Verify that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
//				assertTrue(kycRegistrationPage.verifyKycApprovedTitleIsDisplaying(driver),
//						"Verified that 'Complete 3 simple steps to start investing in US stocks and ETFs' page is displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("IndianNationality_NonIndianTaxResidency_KYC", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: IndianNationality_NonIndianTaxResidency_KYC " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("IndianNationality_NonIndianTaxResidency_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("IndianNationality_NonIndianTaxResidency_KYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: IndianNationality_NonIndianTaxResidency_KYC " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("IndianNationality_NonIndianTaxResidency_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("IndianNationality_NonIndianTaxResidency_KYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 6)
	public void Letsgo_Screen_KYC() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("IndianNationality_NonIndianTaxResidency_KYC: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-723?atlOrigin=eyJpIjoiMWFlYTVkMTk0NTNjNDFmNzk2YzAwODNkZmE1MjZhNTAiLCJwIjoiaiJ9\">QAA-723 : [Web] [New] - While options are blank, Verify validation messages on \"Let’s get to know you\" screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "Albania";
		String countryNationality = "India";
		String email = "vested.automation+w03LetsGo@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);

//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Nationality' Error Message is displaying");
			assertTrue(kycRegistrationPage.isNationalityErrorVisible(driver),
					"Verified 'Nationality' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Nationality' Error Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Tax Residency' Error Message is displaying");
			assertTrue(kycRegistrationPage.isTaxErrorVisible(driver),
					"Verified 'Tax Residency' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Tax Residency' Error Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Gender' Error Message is displaying");
			assertTrue(kycRegistrationPage.isGenderErrorVisible(driver),
					"Verified 'Gender' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Gender' Error Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Marital Status' Error Message is displaying");
			assertTrue(kycRegistrationPage.isMaritalStatusErrorVisible(driver),
					"Verified 'Marital Status' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Marital Status' Error Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Employement' Error Message is displaying");
			assertTrue(kycRegistrationPage.isEmployementErrorVisible(driver),
					"Verified 'Employement' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Employement' Error Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Tick Any CheckBox' Error Message is displaying");
			assertTrue(kycRegistrationPage.isTickErrorVisible(driver),
					"Verified 'Tick Any CheckBox' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Tick Any CheckBox' Error Message is displaying");

			testSteps.add("Step " + (++i)
					+ " : Click on My family member or I am a political exposed person or a public official Check Box");
			kycRegistrationPage.selectPoliticalExposedCheckBox(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Please enter a valid name(s).' Error Message is displaying");
			assertTrue(kycRegistrationPage.isPoliticalExposedErrorVisible(driver),
					"Verified 'Please enter a valid name(s).' Error Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Please enter a valid name(s).' Error Message is displaying");

			testSteps.add("Step " + (++i)
					+ " : Click on I am a director, officer, or at least a 10% stock owner of a US-listed public company Check Box");
			kycRegistrationPage.selectDirectorCheckBox(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify 'A valid company name and ticker are required.' Error Message is displaying");
			assertTrue(kycRegistrationPage.isDirectorErrorVisible(driver),
					"Verified 'A valid company name and ticker are required.' Error Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified 'A valid company name and ticker are required.' Error Message is displaying");

			
//			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
//			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);
//
//			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
//			kycRegistrationPage.selectTaxResidencyCountry(driver, country);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
//			kycRegistrationPage.clickOnMaleGender(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
//			kycRegistrationPage.clickOnSingle_Marital(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
//			kycRegistrationPage.clickOnRetiredStatus(driver);
//
//			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
//			kycRegistrationPage.checkNoneofAboveOption(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Nationalality' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isNationalityErrorVisible(driver),
//					"Verified 'Nationalality' Error Message is displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Nationalality' Error Message is not displaying");
//
//			testSteps.add("Step " + (++i) + " : Verify 'Tax Residency' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isTaxErrorVisible(driver),
//					"Verified 'Tax Residency' Error Message is displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Tax Residency' Error Message is not displaying");
//
//			testSteps.add("Step " + (++i) + " : Verify 'Gender' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isGenderErrorVisible(driver),
//					"Verified 'Gender' Error Message is displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Gender' Error Message is not displaying");
//
//			testSteps.add("Step " + (++i) + " : Verify 'Marital Status' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isMaritalStatusErrorVisible(driver),
//					"Verified 'Marital Status' Error Message is displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Marital Status' Error Message is not displaying");
//
//			testSteps.add("Step " + (++i) + " : Verify 'Employement' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isEmployementErrorVisible(driver),
//					"Verified 'Employement' Error Message is displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Employement' Error Message is not displaying");
//
//			testSteps.add("Step " + (++i) + " : Verify 'Tick Any CheckBox' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isTickErrorVisible(driver),
//					"Verified 'Tick Any CheckBox' Error Message is displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Tick Any CheckBox' Error Message is not displaying");
//
//			testSteps
//					.add("Step " + (++i) + " : Verify 'Please enter a valid name(s).' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isPoliticalExposedErrorVisible(driver),
//					"Verified 'Please enter a valid name(s).' Error Message is displaying");
//			testSteps.add(
//					"Step " + (++i) + " : Verified 'Please enter a valid name(s).' Error Message is not displaying");
//
//			testSteps.add("Step " + (++i)
//					+ " : Verify 'A valid company name and ticker are required.' Error Message is not displaying");
//			assertFalse(kycRegistrationPage.isDirectorErrorVisible(driver),
//					"Verified 'A valid company name and ticker are required.' Error Message is n displaying");
//			testSteps.add("Step " + (++i)
//					+ " : Verified 'A valid company name and ticker are required.' Error Message is not displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("Letsgo_Screen_KYC", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: Letsgo_Screen_KYC " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Letsgo_Screen_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Letsgo_Screen_KYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Letsgo_Screen_KYC " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Letsgo_Screen_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Letsgo_Screen_KYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 7)
	public void KYC_StartScreenVerification() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_StartScreenVerification: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-749?atlOrigin=eyJpIjoiMGVmOWMzOTk2NWFhNDE3M2EwMmFiMTEyOGIzYjRkMDAiLCJwIjoiaiJ9\">QAA-749 : [Web] [New] - Verify the 'Start KYC' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "Albania";
		String countryNationality = "India";
		String email = PropertiesReader.getPropertyValue("KYC_Email");

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=3; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
//			try {
//				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
//				kycRegistrationPage.clickAcceptAndContinue_button(driver);
//				kycRegistrationPage.clickOnPreviousButton(driver);
//			}catch (Exception e) {
//				// TODO: handle exception
//			}

			testSteps.add("Step " + (++i) + " : Verify 'Vested Logo' is displaying on Left Side");
			assertTrue(kycRegistrationPage.isVestedLogoDisplaying(driver), "'Vested Logo' is not displaying");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'Vested Logo' is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Vested Logo' is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'Vested Logo' is clickable");

			testSteps.add("Step " + (++i) + " : Verify 'Close Icon' is displaying on Right Side");
			assertTrue(kycRegistrationPage.isCloseIconDisplaying(driver), "'Close Icon' is not displaying");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'Close Icon' is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Close Icon' is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'Close Icon' is clickable");

			testSteps.add("Step " + (++i) + " : Verify 'KYC' Heading is displaying");
			assertTrue(kycRegistrationPage.isTextVisible(driver, "KYC"), "'KYC' Heading is not displaying");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'KYC' Heading is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify 'Complete the process in less than 5 minutes' Heading is displaying");
			assertTrue(kycRegistrationPage.isTextVisible(driver, "Complete the process in less than 5 minutes"),
					"'Complete the process in less than 5 minutes' Heading is not displaying");
			testSteps.add("Step " + (++i)
					+ " : <b>Verified</b> 'Complete the process in less than 5 minutes' Heading is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'What do you need for KYC?' Message is displaying");
			assertTrue(kycRegistrationPage.isTextVisible(driver, "What do you need for KYC?"),
					"'What do you need for KYC?' Message is not displaying");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'What do you need for KYC?' Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'How do we use your information?' Message is displaying");
			assertTrue(kycRegistrationPage.isTextVisible(driver, "How do we use your information?"),
					"'How do we use your information?' Message is not displaying");
			testSteps.add(
					"Step " + (++i) + " : <b>Verified</b> 'How do we use your information?' Message is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify 'What else do we need your information for?' Message is displaying");
			assertTrue(kycRegistrationPage.isTextVisible(driver, "What else do we need your information for?"),
					"'What else do we need your information for?' Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : <b>Verified</b> 'What else do we need your information for?' Message is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify 'What else do we need your information for?' Message is displaying");
			assertTrue(kycRegistrationPage.isTextVisible(driver, "What else do we need your information for?"),
					"'What else do we need your information for?' Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : <b>Verified</b> 'What else do we need your information for?' Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'ACCEPT AND CONTINUE' Button is available");
			assertTrue(kycRegistrationPage.isAcceptAndContinueButtonDisplaying(driver),
					"'ACCEPT AND CONTINUE' Button is not available");
			testSteps.add("Step " + (++i) + " : <b>Verified</b> 'ACCEPT AND CONTINUE' Button is available");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYC_StartScreenVerification", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: KYC_StartScreenVerification " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Letsgo_Screen_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_StartScreenVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: KYC_StartScreenVerification " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_StartScreenVerification") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_StartScreenVerification", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 8)
	public void KYC_Validations_IdentityPage() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_Validations_IdentityPage: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-729?atlOrigin=eyJpIjoiMGVmOWMzOTk2NWFhNDE3M2EwMmFiMTEyOGIzYjRkMDAiLCJwIjoiaiJ9\">QAA-729 : [Web] [New] - While fields are blank, Verify validation messages on 'Let�s verify your identity' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "Albania";
		String countryNationality = "India";
		String email = "vested.automation+w012346@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");
//
			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			
			try {
			testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
			kycRegistrationPage.clickAcceptAndContinue_button(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}
//
//			testSteps.add("Step " + (++i) + " : Entering all required data in 'Let�s get to know you' screen");
//
////			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
//			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);
//
////			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
//			kycRegistrationPage.selectTaxResidencyCountry(driver, country);
//
////			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
//			kycRegistrationPage.clickOnMaleGender(driver);
//
////			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
//			kycRegistrationPage.clickOnSingle_Marital(driver);
//
////			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
//			kycRegistrationPage.clickOnRetiredStatus(driver);
//
////			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
//			kycRegistrationPage.checkNoneofAboveOption(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add(
//					"Step " + (++i) + " : Enter all required data in 'Let�s build your investment profile' screen");
//			kycRegistrationPage.fillQuestionnaire(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);

			wait3s();
			testSteps.add("Step " + (++i) + " : Click inside the'Tax ID number' field");
			testSteps.add("Step " + (++i) + " : Click outside the'Tax ID number' field");
			kycRegistrationPage.clickOnTaxID(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Tax ID is required' Validation Message is displaying");
			try {
				assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Tax ID is required"),
						"'Tax ID is required' Validation Message is not displaying");
			} catch (Exception e) {
				assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "SSN is required"),
						"'Tax ID is required' Validation Message is not displaying");
			} catch (Error e) {
				assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "SSN is required"),
						"'Tax ID is required' Validation Message is not displaying");
			}
			testSteps.add("Step " + (++i) + " : Verified 'Tax ID is required' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Click inside the 'Address Line 1' field");
			testSteps.add("Step " + (++i) + " : Click outside the 'Address Line 1' field");
			kycRegistrationPage.clickOnAddressLine1(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Address Line 1 is required' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Address Line 1 is required"),
					"'Address Line 1 is required' Validation Message is not displaying");
			testSteps
					.add("Step " + (++i) + " : Verified 'Address Line 1 is required' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Click inside the 'City' field");
			testSteps.add("Step " + (++i) + " : Click outside the 'City' field");
			kycRegistrationPage.clickOnCity(driver);

			testSteps.add("Step " + (++i) + " : Verify 'City is required' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "City is required"),
					"'City is required' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'City is required' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Click inside the 'PinCode' field");
			testSteps.add("Step " + (++i) + " : Click outside the 'PinCode' field");
			kycRegistrationPage.clickOnPinCOde(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Pincode is required' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Pincode is required"),
					"'Pincode is required' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Pincode is required' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Click inside the 'State' field");
			testSteps.add("Step " + (++i) + " : Click outside the 'State' field");
			kycRegistrationPage.clickOnState(driver);

			testSteps.add("Step " + (++i) + " : Verify 'State is required' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "State is required"),
					"'State is required' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'State is required' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Checkmark the 'I confirm'");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

			testSteps.add("Step " + (++i) + " : UnCheck the 'I confirm'");
			kycRegistrationPage.uncheckIConfirmCheckbox(driver);

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYC_Validations_IdentityPage", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYC_Validations_IdentityPage " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_Validations_IdentityPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_Validations_IdentityPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: KYC_Validations_IdentityPage " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_Validations_IdentityPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_Validations_IdentityPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 9)
	public void KYCMobileAndAdhaarNumberValidation_IdentifyFacePage() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String panCardFileName = imagePath + dataArr1[rowIndex][4].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-744?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-744 : [Web] [New] - While user enter invalid mobile & Aadhaar number , Verify validation messages on 'Let�s verify your identity' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String SSN_number = "296482326";
		String Phone_number = "0987654321";
		String filepath = imagePath + "PassportImage.PNG";
		String passportfileno = "BP4063972871419";
		String Address1 = "Address1";
		String Address2 = "Address2";
		String City = "Alaska";
		String PinCode = "268643";
		String State = "Alaska";
		String fullName = "Mohit Singh Chahar";
		String email = "vested.automation+w03identitypage@gmail.com";
		String panCard = "BNZPM2501F";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			if (!kycRegistrationPage.isTextDisplaying(driver, "PAN verified successfully")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'PAN CARD Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.isPANInputFieldDisplaying(driver),"'PAN CARD Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'PAN CARD Number Field'</b> is Displaying");
				testSteps.add("Step " + (++i) + " : Verifying <b>'Verify PAN Button'</b> is Displaying");
				assertTrue(kycRegistrationPage.isVerifyPANButtonDisplaying(driver),"'PAN Button'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Verify PAN Button'</b> is Displaying");
//				try {
//					kycRegistrationPage.enterPANNumber(driver,panCard);
//					testSteps.add("Step " + (++i) + " : Entering <b>'PAN CARD Number'</b>: ");
//					testSteps.add("Step " + (++i) + " : Click On <b>'VerifyPAN'</b> button");
//					kycRegistrationPage.clickOnVerifyPANButton(driver);
//				}catch (Exception e) {
//					// TODO: handle exception
//				}
			}
			
			

			testSteps.add("Step " + (++i) + " : Entering Mobile Number:  " + "!@#$%^&*()!@");
			kycRegistrationPage.enterSecurityMobileNumber(driver, "!@#$%^&*()!@");
			kycRegistrationPage.clickOnKYCPageSideIcon(driver);

			testSteps.add(
					"Step " + (++i) + " : Verify 'Phone Number Must be a number.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Phone Number Must be a number."),
					"'Phone Number Must be a number.' Validation Message is not displaying");
			testSteps.add(
					"Step " + (++i) + " : Verified 'Phone Number Must be a number.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Entering Aadhar Number:  " + "!@#$%^&*()!@");
			kycRegistrationPage.enterSecurityAadharNumber(driver, "!@#$%^&*()!@");
			kycRegistrationPage.clickOnKYCPageSideIcon(driver);

			testSteps.add(
					"<font color = 'red'><a href=\"https://vestedfinance.atlassian.net/browse/DSCA-542\">DSCA-542 : Bug - [Web/NTV] - While user enter alphabets & special character in Aadhaar, validation message is not showing]<a/></font>");

			testSteps.add(
					"Step " + (++i) + " : Verify 'Aadhaar Number Must be a number.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Aadhaar Number Must be a number."),
					"'Aadhaar Number Must be a number.' Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified 'Aadhaar Number Must be a number.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYCMobileAndAdhaarNumberValidation_IdentifyFacePage " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCMobileAndAdhaarNumberValidation_IdentifyFacePage " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			Integer val = BaseClass.methodNamelist.get("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage");
			System.out.print("P: " + val);
			System.out.print("P2: " + RetryListener.maxRetryCnt);
			if (BaseClass.methodNamelist
					.get("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCMobileAndAdhaarNumberValidation_IdentifyFacePage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 10)
	public void KYCValidation_LetGetToKnowPage() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetGetToKnowPage: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String panCardFileName = imagePath + dataArr1[rowIndex][4].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-738?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-738 : [Web] [New] - While employment fields are blank, Verify validation messages on 'Let�s get to know you' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String SSN_number = "296482326";
		String Phone_number = "0987654321";
		String filepath = imagePath + "PassportImage.PNG";
		String passportfileno = "BP4063972871419";
		String Address1 = "Address1";
		String Address2 = "Address2";
		String City = "Alaska";
		String PinCode = "268643";
		String State = "Alaska";
		String fullName = "Mohit Singh Chahar";
		String email = "vested.automation+w012347@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Employed'");
			kycRegistrationPage.clickOnEmployedStatus(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Work type is required.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Work type is required."),
					"'Work type is required.' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Work type is required.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Work position is required.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Work position is required."),
					"'Work position is required.' Validation Message is not displaying");
			testSteps
					.add("Step " + (++i) + " : Verified 'Work position is required.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Company name is required.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Company name is required."),
					"'Company name is required.' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Company name is required.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Company city is required.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Company city is required."),
					"'Company city is required.' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Company city is required.' Validation Message is displaying");

//			testSteps.add(
//					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-771?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-771 : [Web- Bug] - On Let�s get to know you screen 'Company country is required.' is not displaying when field is empty.<a/>");
//			Apurva's Response
//			https://vestedfinance.slack.com/archives/D0330236CR0/p1666263943216779
//			testSteps.add("Step " + (++i) + " : Verify 'Company country is required.' Validation Message is displaying");
//			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver,"Company country is required."),
//					"'Company country is required.' Validation Message is not displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Company country is required.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetGetToKnowPage", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: KYCValidation_LetGetToKnowPage " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYCValidation_LetGetToKnowPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetGetToKnowPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetGetToKnowPage " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYCValidation_LetGetToKnowPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetGetToKnowPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 11)
	public void KYCOptionsValidation_LetsGetToKnowYouPage() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCOptionsValidation_LetsGetToKnowYouPage: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-752?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-752 : [Web] [New] - Verify the 'Let�s get to know you' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String email = "vested.automation+w012348@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
//			try {
//				for(int count =1; count <=2; count++) {
//					kycRegistrationPage.clickOnPreviousButton(driver);
//				}
//				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
//				
//			}catch (Exception e) {
//				// TODO: handle exception
//			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
//				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Verify <b>'Vested Logo'</b> is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Vested Logo'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Close Icon'</b> is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Close Icon'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'What is your nationality?'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "What is your nationality?"),
					"'What is your nationality?' Text is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'What is your nationality?'</b> Text is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Country of tax residency'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Country of tax residency"),
					"'Country of tax residency' Text is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Country of tax residency'</b> Text is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Gender'</b> Label with <b>'Male'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Male", "Gender"),
					"'Gender' Label with 'Male' Option is not displaying");
			testSteps
					.add("Step " + (++i) + " : Verified <b>'Gender'</b> Label with <b>'Male'</b> Option is displaying");

			testSteps
					.add("Step " + (++i) + " : Verify <b>'Gender'</b> Label with <b>'Female'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Female", "Gender"),
					"'Gender' Label with 'Female' Option is not displaying");
			testSteps.add(
					"Step " + (++i) + " : Verified <b>'Gender'</b> Label with <b>'Female'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Marital status'</b> Label with <b>'Single'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Single", "Marital status"),
					"'Marital status' Label with 'Single' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Marital status'</b> Label with <b>'Single'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Marital status'</b> Label with <b>'Divorced'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Divorced", "Marital status"),
					"'Marital status' Label with 'Divorced' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Marital status'</b> Label with <b>'Divorced'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Marital status'</b> Label with <b>'Married'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Married", "Marital status"),
					"'Marital status' Label with 'Married' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Marital status'</b> Label with <b>'Married'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Marital status'</b> Label with <b>'Widowed'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Widowed", "Marital status"),
					"'Marital status' Label with 'Widowed' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Marital status'</b> Label with <b>'Widowed'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Marital status'</b> Label with <b>'Domestic Partner'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Domestic Partner", "Marital status"),
					"'Marital status' Label with 'Domestic Partner' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Marital status'</b> Label with <b>'Domestic Partner'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Employment'</b> Label with <b>'Employed'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Employed", "Employment"),
					"'Employment' Label with 'Employed' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Employment'</b> Label with <b>'Employed'</b> Option is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Employment'</b> Label with <b>'Retired'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Retired", "Employment"),
					"'Employment' Label with 'Retired' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Employment'</b> Label with <b>'Retired'</b> Option is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Employment'</b> Label with <b>'Student'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Student", "Employment"),
					"'Employment' Label with 'Student' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Employment'</b> Label with <b>'Student'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Employment'</b> Label with <b>'Self Employed'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Self Employed", "Employment"),
					"'Employment' Label with 'Self Employed' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Employment'</b> Label with <b>'Self Employed'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Employment'</b> Label with <b>'Unemployed'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, "Unemployed", "Employment"),
					"'Employment' Label with 'Unemployed' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Employment'</b> Label with <b>'Unemployed'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Tick any of the below that applies to you'</b> Label with <b>'My family member or I work at a US brokerage firm'</b> Option is displaying");
			assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver,
					"My family member or I work at a US brokerage firm", "Tick any of the below that applies to you"),
					"'Tick any of the below that applies to you' Label with 'My family member or I work at a US brokerage firm' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Tick any of the below that applies to you'</b> Label with <b>'My family member or I work at a US brokerage firm'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Tick any of the below that applies to you'</b> Label with <b>'I am a director, officer, or at least a 10% stock owner of a US-listed public company'</b> Option is displaying");
			assertTrue(
					kycRegistrationPage.isOptionWithLabelDisplaying(driver,
							"I am a director, officer, or at least a 10% stock owner of a US-listed public company",
							"Tick any of the below that applies to you"),
					"'Tick any of the below that applies to you' Label with 'I am a director, officer, or at least a 10% stock owner of a US-listed public company' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Tick any of the below that applies to you'</b> Label with <b>'I am a director, officer, or at least a 10% stock owner of a US-listed public company'</b> Option is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Tick any of the below that applies to you'</b> Label with <b>'None of these apply to me'</b> Option is displaying");
			assertTrue(
					kycRegistrationPage.isOptionWithLabelDisplaying(driver, "None of these apply to me",
							"Tick any of the below that applies to you"),
					"'Tick any of the below that applies to you' Label with 'None of these apply to me' Option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Tick any of the below that applies to you'</b> Label with <b>'None of these apply to me'</b> Option is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Next'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Next"), "'Next' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Next'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Previous'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Previous"), "'Previous' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Previous'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCOptionsValidation_LetsGetToKnowYouPage", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: KYCOptionsValidation_LetsGetToKnowYouPage " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCOptionsValidation_LetsGetToKnowYouPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCOptionsValidation_LetsGetToKnowYouPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: KYCOptionsValidation_LetsGetToKnowYouPage " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCOptionsValidation_LetsGetToKnowYouPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCOptionsValidation_LetsGetToKnowYouPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 12)
	public void KYCValidation_LetsOpenYourAccountPage() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-767?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-767 : [Web] [New] - Verify the 'Let�s open your account' screen<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsOpenYourAccountPage: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String email = "codeautomation.nouman+27@vestedfinance.co";
		String password = "Test@12345";

		int i = 0;
		try {
			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> page is displaying");
			assertEquals(loginPage.getPageTitle(driver), dashboardTitle, "Failed : Dashboard title not matched");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Dashboard'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'COMPLETE KYC' Button");
			kycRegistrationPage.clickOnCompleteKYC(driver);
			try {
				kycRegistrationPage.clickOnNextButton(driver);
				testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			} catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Verify <b>'Vested Logo'</b> is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Vested Logo'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Close Icon'</b> is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Close Icon'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Let�s open your account'</b> Heading is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "open your account"),
					"'open your account' Heading is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Let�s open your account'</b> Heading is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Terms & conditions'</b> Title is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Terms & conditions"),
					"'Terms & conditions' Title is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Terms & conditions'</b> Title is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'I want to enroll in the Securities Lending Income Program and have reviewed DriveWealth�s Master Securities Lending Agreement, and DriveWealth�s Fully Paid Securities Lending Disclosures.'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "I want to enroll in the"),
					"'I want to enroll in the Securities Lending Income Program and have reviewed DriveWealth�s Master Securities Lending Agreement, and DriveWealth�s Fully Paid Securities Lending Disclosures.' Text is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'I want to enroll in the Securities Lending Income Program and have reviewed DriveWealth�s Master Securities Lending Agreement, and DriveWealth�s Fully Paid Securities Lending Disclosures.'</b> Text is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'I agree to Vested�s Advisory Agreement, ESIGN Agreement, Vested�s Privacy Policy, Vested�s Terms of Service, DriveWealth�s Privacy Policy, DriveWealth�s Disclosures and Account Agreements, and the Tax Form Information.'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "I agree to Vested"),
					"'I agree to Vested�s Advisory Agreement, ESIGN Agreement, Vested�s Privacy Policy, Vested�s Terms of Service, DriveWealth�s Privacy Policy, DriveWealth�s Disclosures and Account Agreements, and the Tax Form Information.' Text is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'I agree to Vested�s Advisory Agreement, ESIGN Agreement, Vested�s Privacy Policy, Vested�s Terms of Service, DriveWealth�s Privacy Policy, DriveWealth�s Disclosures and Account Agreements, and the Tax Form Information.'</b> Text is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'I have reviewed and agree to VF Securities Account Agreement, VF Securities Use and Risk Disclosures, and VF Securities Business Continuity Plan.'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "I have reviewed and agree to VF Securities"),
					"'I have reviewed and agree to VF Securities Account Agreement, VF Securities Use and Risk Disclosures, and VF Securities Business Continuity Plan.' Text is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'I have reviewed and agree to VF Securities Account Agreement, VF Securities Use and Risk Disclosures, and VF Securities Business Continuity Plan.'</b> Text is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'I have reviewed the Client Relationship Summary'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "I have reviewed the"),
					"'I have reviewed the Client Relationship Summary' Text is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'I have reviewed the Client Relationship Summary'</b> Text is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Enter Your Full Name '</b> Placeholder is displaying");
			assertTrue(kycRegistrationPage.isEnterYourFullNamePlaceholderDisplaying(driver),
					"'Enter Your Full Name ' Placeholder is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Enter Your Full Name '</b> Placeholder is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'By checking where indicated above and typing your name, you acknowledge that you have carefully reviewed and agree to each of the agreements listed above, which you are encouraged to download and save.'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver,
					"By checking where indicated above and typing your name, you acknowledge that you have carefully reviewed and agree to each of the agreements listed above, which you are encouraged to download and save."),
					"'By checking where indicated above and typing your name, you acknowledge that you have carefully reviewed and agree to each of the agreements listed above, which you are encouraged to download and save.' Text is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'By checking where indicated above and typing your name, you acknowledge that you have carefully reviewed and agree to each of the agreements listed above, which you are encouraged to download and save.'</b> Text is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'By signing above, you agree that your electronic signature has the same legal meaning, validity as your handwritten signature.'</b> Text is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver,
					"By signing above, you agree that your electronic signature has the same legal meaning, validity as your handwritten signature."),
					"'By signing above, you agree that your electronic signature has the same legal meaning, validity as your handwritten signature.' Text is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'By signing above, you agree that your electronic signature has the same legal meaning, validity as your handwritten signature.'</b> Text is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Done'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Done"), "'Done' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Done'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Previous'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Previous"), "'Previous' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Previous'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsOpenYourAccountPage", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: KYCValidation_LetsOpenYourAccountPage " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYCValidation_LetsOpenYourAccountPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsOpenYourAccountPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetsOpenYourAccountPage " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYCValidation_LetsOpenYourAccountPage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsOpenYourAccountPage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 13)
	public void KYCValidation_LetsVerifyYourIdentityPage_NonIndian() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-758?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-758 : [Web] [New] - While user select any foreign country tax residence, Verify 'Let�s verify your identity' screen<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsVerifyYourIdentityPage_NonIndian: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "United States";
		String countryNationality = "United States of America";
		String email = "vested.automation+w012349@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vested Logo'</b> is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Vested Logo'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Close Icon'</b> is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Close Icon'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'country code dropdown'</b> without any label is available");
			assertFalse(kycRegistrationPage.isCountryCodeDisplaying(driver),
					"'country code dropdown' with any label is available");
			testSteps
					.add("Step " + (++i) + " : Verified <b>'country code dropdown'</b> without any label is available");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'This is the number you use to file taxes with, not your passport or any other ID number.'</b> Description is displaying");
			assertTrue(
					kycRegistrationPage.isTextDisplaying(driver,
							"This is the number you use to file taxes with, not your passport or any other ID number."),
					"'This is the number you use to file taxes with, not your passport or any other ID number.' Description is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'This is the number you use to file taxes with, not your passport or any other ID number.'</b> Description is displaying");

			try {
				
				assertTrue(kycRegistrationPage.isMobileNumberDisplaying(driver, "Mobile number"),
						"text field with label 'Mobile number' is not available");
				testSteps.add("Step " + (++i) + " : Verify text field with label <b>'Mobile number'</b> is available");
				testSteps.add("Step " + (++i) + " : Verified text field with label <b>'Mobile number'</b> is available");

				testSteps.add("Step " + (++i) + " : Verify <b>'Get OTP'</b> Button is displaying");
				assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Get OTP"), "'Get OTP' Button is not displaying");
				testSteps.add("Step " + (++i) + " : Verified <b>'Get OTP'</b> Button is displaying");
			}catch (Exception e) {
				// TODO: handle exception
			}catch (Error e) {
				// TODO: handle exception
			}
			

			testSteps.add("Step " + (++i) + " : Verify <b>'Identity Verification'</b> Heading is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Identity Verification"),
					"'Identity Verification' Heading is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Identity Verification'</b> Heading is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Verify your identity'</b> Button is displaying");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Verify your identity"),
					"'Verify your identity' Button is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Verify your identity'</b> Button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Enter your address'</b> Heading is displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Enter your address"),
					"'Enter your address' Heading is not displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Enter your address'</b> Heading is displaying");

			testSteps.add("Step " + (++i) + " : Verify text field with label <b>'Address Line 1'</b> is available");
			assertTrue(kycRegistrationPage.isTextFieldDisplaying(driver, "Address Line 1"),
					"text field with label 'Address Line 1' is not available");
			testSteps.add("Step " + (++i) + " : Verified text field with label <b>'Address Line 1'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify text field with label <b>'Address Line 2'</b> is available");
			assertTrue(kycRegistrationPage.isTextFieldDisplaying(driver, "Address Line 2"),
					"text field with label 'Address Line 2' is not available");
			testSteps.add("Step " + (++i) + " : Verified text field with label <b>'Address Line 2'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify text field with label <b>'City'</b> is available");
			assertTrue(kycRegistrationPage.isTextFieldDisplaying(driver, "City"),
					"text field with label 'City' is not available");
			testSteps.add("Step " + (++i) + " : Verified text field with label <b>'City'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify text field with label <b>'State'</b> is available");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "State"),
					"text field with label 'State' is not available");
			testSteps.add("Step " + (++i) + " : Verified text field with label <b>'State'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify text field with label <b>'PinCode'</b> is available");
			assertTrue(kycRegistrationPage.isTextFieldDisplaying(driver, "PinCode"),
					"text field with label 'PinCode' is not available");
			testSteps.add("Step " + (++i) + " : Verified text field with label <b>'PinCode'</b> is available");

			testSteps.add("Step " + (++i)
					+ " : Verify checkbox with label <b>'I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.'</b> is available");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "the name on the government ID"),
					"''I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.' Checkbox is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: checkbox with label <b>'I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify <b>'Previous'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Previous"), "'Previous' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Previous'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_NonIndian", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentityPage_NonIndian " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsVerifyYourIdentityPage_NonIndian") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_NonIndian", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentityPage_NonIndian " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsVerifyYourIdentityPage_NonIndian") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_NonIndian", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 14)
	public void KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-761?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-761 : [Web] [New] - While user select India and Aadhaar is linked with mobile number, Verify 'Let�s verify your identity' screen<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, KYC_NonAdaarReg, driver);

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String panCardFileName = imagePath + dataArr[rowIndex][4].toString();
		String Phone_number = "0987654321";
		String email = "vested.automation+w012350@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vested Logo'</b> is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Vested Logo'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Close Icon'</b> is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Close Icon'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify title <b>'Let�s verify your identity'</b>  is available");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "verify your identity"),
					"'Let�s verify your identity' title is not displaying");
//			assertTrue(kycRegistrationPage.isTextDisplaying(driver,"ID verification"),
//					"'ID verification' description is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: title <b>'Let�s verify your identity'</b> is available");

			testSteps.add("Step " + (++i)
					+ " : Verify heading <b>'Is your mobile number linked with Aadhaar?'</b> with 2 option <b>'Yes'</b> and <b>'No'</b>");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Is your mobile number linked with Aadhaar?"),
					"'Is your mobile number linked with Aadhaar?' heading is not displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "yes"), "'yes' option is not displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "no"), "'no' option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: heading <b>'Is your mobile number linked with Aadhaar?'</b> with 2 option <b>'Yes'</b> and <b>'No'</b>");

//			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
//				kycRegistrationPage.enterPhoneNumber(Phone_number, driver);
//				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
//			}
			
			testSteps.add("Step " + (++i)
					+ " : Verify heading <b>'Identity Verification'</b> with description <b>'The US Government requires Vested and its broker partner to collect your PAN and Aadhaar for identity verification purposes. Your information will not be sold or used for advertisements. Read more here.'</b>");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Identity Verification"),
					"'Identity Verification' Heading is not displaying");
			assertTrue(
					kycRegistrationPage.isTextDisplaying(driver,
							"The US Government requires Vested and its broker partner to collect your"),
					"'The US Government requires Vested and its broker partner to collect your' description is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: heading <b>'Upload Documents'</b> with description <b>'The US Government requires Vested and its broker partner to collect your PAN and Aadhaar for identity verification purposes. Your information will not be sold or used for advertisements. Read more here.'</b>");

			if (!kycRegistrationPage.isTextDisplaying(driver, "PAN verified successfully")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'PAN CARD Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.isPANInputFieldDisplaying(driver),"'PAN CARD Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'PAN CARD Number Field'</b> is Displaying");
				testSteps.add("Step " + (++i) + " : Verifying <b>'Verify PAN Button'</b> is Displaying");
				assertTrue(kycRegistrationPage.isVerifyPANButtonDisplaying(driver),"'PAN Button'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Verify PAN Button'</b> is Displaying");
//				kycRegistrationPage.enterPANNumber(driver, panCard);
//				testSteps.add("Step " + (++i) + " : Entering <b>'PAN CARD Number'</b>: ");
//
//				testSteps.add("Step " + (++i) + " : Click On <b>'VerifyPAN'</b> button");
//				kycRegistrationPage.clickOnVerifyPANButton(driver);
			}

			try {
				
				assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Aadhaar Verification"),
						"'Aadhaar Verification' heading is not displaying");
				testSteps.add("Step " + (++i) + " : Verify heading with label '<b>Aadhaar Verification'</b>");
				testSteps.add("Step " + (++i) + " : Verified: heading with label '<b>Aadhaar Verification'</b>");

				testSteps.add("Step " + (++i) + " : Verify number field with label <b>Enter your mobile number'</b>");
				assertTrue(kycRegistrationPage.isTextFieldDisplaying(driver, "Enter your mobile number"),
						"text field with label 'Enter your mobile number' is not available");
				testSteps.add("Step " + (++i) + " : Verified: number field with label <b>Enter your mobile number'</b>");

				testSteps.add("Step " + (++i)
						+ " : Verify number field with label <b>'Enter Aadhaar number'</b> with description under it <b>'By clicking on Get OTP, you authorize Vested and its partners to access your Aadhaar details on your behalf.'</b>");
				assertTrue(kycRegistrationPage.isTextFieldDisplaying(driver, "Enter Aadhaar number"),
						"text field with label 'Enter Aadhaar number' is not available");
				assertTrue(kycRegistrationPage.isTextDisplaying(driver,
						"By clicking on Get OTP, you authorize Vested and its partners to access your Aadhaar details on your behalf."),
						"'By clicking on Get OTP, you authorize Vested and its partners to access your Aadhaar details on your behalf.' description is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified: number field with label <b>'Enter Aadhaar number'</b> with description under it <b>'By clicking on Get OTP, you authorize Vested and its partners to access your Aadhaar details on your behalf.'</b>");

				testSteps.add("Step " + (++i) + " : Verify button with label <b>'Get OTP'<b>");
				assertTrue(kycRegistrationPage.isButtonDisplaying(driver, "Get OTP"), "'Get OTP' Button is not displaying");
				testSteps.add("Step " + (++i) + " : Verified: button with label <b>'Get OTP'<b>");

			}catch (Exception e) {
				// TODO: handle exception
			}catch (Error e) {
				testSteps.add("Step " + (++i) + " : Verify Button with label '<b>Upload Aadhaar'</b> is clickable");
				assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Upload Aadhaar"),
						"'Upload Aadhaar' button is not clickable");
				testSteps.add("Step " + (++i) + " : Verified: button with label '<b>Upload Aadhaar'</b> is clickable");
			}
			
			testSteps.add("Step " + (++i)
					+ " : Verify checkbox with label <b>'I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.'</b> is available");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "the name on the government ID"),
					"''I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.' Checkbox is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: checkbox with label <b>'I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify <b>'Next'</b> is Displaying");
			assertTrue(kycRegistrationPage.isButtonDisplaying(driver, "Next"), "'Previous' is not Displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Next'</b> is Displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Previous'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Previous"), "'Previous' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Previous'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar "
					+ "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar "
					+ "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_IndianLinkedAadhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 15)
	public void KYCValidation_LetsBuildYourInvestmentProfilePage() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-755?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-755 : [Web] [New] - Verify the 'Let�s build your investment profile' screen<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsBuildYourInvestmentProfilePage: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, KYC_NonAdaarReg, driver);
		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String panCardFileName = imagePath + dataArr[rowIndex][4].toString();
		String email = "vested.automation+w012351@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			
			kycRegistrationPage.clickOnPreviousButton(driver);
			testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vested Logo'</b> is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Vested Logo'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Close Icon'</b> is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Close Icon'</b> is clickable");

			String[] ar7 = { "Low", "Moderate", "High" };
			for (String val : ar7) {
				testSteps.add("Step " + (++i) + " : Verify <b>'Risk Tolerance'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
				assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, val, "Risk Tolerance"),
						"'Risk Tolerance' Label with '" + val + "' Option is not displaying");
				testSteps.add("Step " + (++i) + " : Verified <b>'Risk Tolerance'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
			}

			String[] ar6 = { "Several times a week", "Once a month", "Once every 6 months" };
			for (String val : ar6) {
				testSteps.add("Step " + (++i)
						+ " : Verify <b>'How often do you plan to invest in companies?'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
				assertTrue(
						kycRegistrationPage.isOptionWithLabelDisplaying(driver, val,
								"How often do you plan to invest in companies?"),
						"'How often do you plan to invest in companies?' Label with '" + val
								+ "' Option is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified <b>'How often do you plan to invest in companies?'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
			}

			String[] ar5 = { "0 to 1 year", "1 to 2 years", "3 to 5 years", "5 to 10 years", "10+ years" };
			for (String val : ar5) {
				testSteps.add("Step " + (++i) + " : Verify <b>'Investing experience'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
				assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, val, "Investing experience"),
						"'Investing experience' Label with '" + val + "' Option is not displaying");
				testSteps.add("Step " + (++i) + " : Verified <b>'Investing experience'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
			}

			String[] ar8 = { "0 to 10 lakh rupees", "10 to 25 lakh rupees", "25 to 50 lakh rupees", "50+ lakh rupees" };
			for (String val : ar8) {
				testSteps.add("Step " + (++i) + " : Verify <b>'Yearly income'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
				assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, val, "Yearly income"),
						"'Yearly income' Label with '" + val + "' Option is not displaying");
				testSteps.add("Step " + (++i) + " : Verified <b>'Yearly income'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
			}

			String[] ar4 = { "0 to 5 lakh rupees", "5 to 10 lakh rupees", "10 to 30 lakh rupees", "30+ lakh rupees" };
			for (String val : ar4) {
				testSteps.add(
						"Step " + (++i) + " : Verify <b>'Liquid net worth (stocks + bank balance)'</b> Label with <b>'"
								+ val + "'</b> Option is displaying");
				assertTrue(
						kycRegistrationPage.isOptionWithLabelDisplaying(driver, val,
								"Liquid net worth (stocks + bank balance)"),
						"'Liquid net worth (stocks + bank balance)' Label with '" + val + "' Option is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified <b>'Liquid net worth (stocks + bank balance)'</b> Label with <b>'" + val
						+ "'</b> Option is displaying");
			}

			String[] ar3 = { "0 to 10 lakh rupees", "10 to 30 lakh rupees", "30 lakh to 1 crore rupees",
					"1+ crore rupees" };
			for (String val : ar3) {
				testSteps.add("Step " + (++i)
						+ " : Verify <b>'Total net worth (liquid net worth + all other assets)'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
				assertTrue(
						kycRegistrationPage.isOptionWithLabelDisplaying(driver, val,
								"Total net worth (liquid net worth + all other assets)"),
						"'Total net worth (liquid net worth + all other assets)' Label with '" + val
								+ "' Option is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified <b>'Total net worth (liquid net worth + all other assets)'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
			}

			testSteps.add("Step " + (++i)
					+ " : Verify dropdown with label <b>'What is your primary source of investments?'</b>");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "What is your primary source of investments?"),
					"'What is your primary source of investments?' title is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified dropdown with label <b>'What is your primary source of investments?'</b>");

			String[] ar = { "0 to 5", "6 to 10", "11+" };
			for (String val : ar) {
				testSteps.add("Step " + (++i)
						+ " : Verify <b>'In the next 12 months, how many deposits and withdrawals do you plan to make with your Vested account?'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
				assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, val,
						"In the next 12 months, how many deposits and withdrawals do you plan to make with your Vested account?"),
						"'In the next 12 months, how many deposits and withdrawals do you plan to make with your Vested account?' Label with '"
								+ val + "' Option is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified <b>'In the next 12 months, how many deposits and withdrawals do you plan to make with your Vested account?'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
			}

			String[] ar1 = { "0 to 50,000 rupees", "50,000 to 1 lakh rupees", "1 lakh to 7 lakh rupees",
					"7+ lakh rupees" };
			for (String val : ar1) {
				testSteps.add("Step " + (++i)
						+ " : Verify <b>'In the next 12 months, how much money do you plan to deposit into your Vested account?'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
				assertTrue(kycRegistrationPage.isOptionWithLabelDisplaying(driver, val,
						"In the next 12 months, how much money do you plan to deposit into your Vested account?"),
						"'In the next 12 months, how much money do you plan to deposit into your Vested account?' Label with '"
								+ val + "' Option is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified <b>'In the next 12 months, how much money do you plan to deposit into your Vested account?'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
			}

			String[] ar2 = { "0 to 5", "6 to 10", "11+" };
			for (String val : ar2) {
				testSteps.add("Step " + (++i)
						+ " : Verify <b>'In the last 12 months, how many investments have you made?'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
				assertTrue(
						kycRegistrationPage.isOptionWithLabelDisplaying(driver, val,
								"In the last 12 months, how many investments have you made?"),
						"'In the last 12 months, how many investments have you made?' Label with '" + val
								+ "' Option is not displaying");
				testSteps.add("Step " + (++i)
						+ " : Verified <b>'In the last 12 months, how many investments have you made?'</b> Label with <b>'"
						+ val + "'</b> Option is displaying");
			}

			testSteps.add("Step " + (++i) + " : Verify <b>'Next'</b> is Displaying");
			assertTrue(kycRegistrationPage.isButtonDisplaying(driver, "Next"), "'Previous' is not Displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Next'</b> is Displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Previous'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Previous"), "'Previous' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Previous'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsBuildYourInvestmentProfilePage", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: KYCValidation_LetsBuildYourInvestmentProfilePage " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsBuildYourInvestmentProfilePage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsBuildYourInvestmentProfilePage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetsBuildYourInvestmentProfilePage " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsBuildYourInvestmentProfilePage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsBuildYourInvestmentProfilePage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 16)
	public void KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-764?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-764 : [Web] [New] - While user select India and Aadhaar is not linked with mobile number, Verify 'Let�s verify your identity' screen<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar: " + driver.hashCode() + "",
				driver);
		Object[][] dataArr = getData(testDataFile, KYC_NonAdaarReg, driver);
		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String panCardFileName = imagePath + dataArr[rowIndex][4].toString();
		String email = "vested.automation+w012352@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
//			try {
//				for(int count =1; count <=2; count++) {
//					kycRegistrationPage.clickOnPreviousButton(driver);
//				}
//				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
//				
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			try {
//				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
//				kycRegistrationPage.clickAcceptAndContinue_button(driver);
//				kycRegistrationPage.clickOnPreviousButton(driver);
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
//			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);
//
//			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
//			kycRegistrationPage.selectTaxResidencyCountry(driver, country);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
//			kycRegistrationPage.clickOnMaleGender(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
//			kycRegistrationPage.clickOnSingle_Marital(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
//			kycRegistrationPage.clickOnRetiredStatus(driver);
//
//			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
//			kycRegistrationPage.checkNoneofAboveOption(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
//			kycRegistrationPage.fillQuestionnaire(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Vested Logo'</b> is clickable");
			assertTrue(kycRegistrationPage.isVestedLogoClickable(driver), "'Vested Logo' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Vested Logo'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Close Icon'</b> is clickable");
			assertTrue(kycRegistrationPage.isCloseIconClickable(driver), "'Close Icon' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Close Icon'</b> is clickable");

			testSteps.add("Step " + (++i)
					+ " : Verify title <b>'Let�s verify your identity'</b> with description 'ID verification' is available");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "verify your identity"),
					"'Let�s verify your identity' title is not displaying");
//			assertTrue(kycRegistrationPage.isTextDisplaying(driver,"ID verification"),
//					"'ID verification' description is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: title <b>'Let�s verify your identity'</b> with description 'ID verification' is available");

			testSteps.add("Step " + (++i)
					+ " : Verify heading <b>'Is your mobile number linked with Aadhaar?'</b> with 2 option <b>'Yes'</b> and <b>'No'</b>");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Is your mobile number linked with Aadhaar?"),
					"'Is your mobile number linked with Aadhaar?' heading is not displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "yes"), "'yes' option is not displaying");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "no"), "'no' option is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: heading <b>'Is your mobile number linked with Aadhaar?'</b> with 2 option <b>'Yes'</b> and <b>'No'</b>");

			try {
				waitfor10sec();
				kycRegistrationPage.clickOnNoButtonForMobile(driver);
				testSteps.add("Step " + (++i)
						+ " : Selecting <b>'No'</b> in <b>'Is your mobile number linked with Aadhaar?'</b>");
			} catch (Exception e) {
				// TODO: handle exception
			}

			if(!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verify <b>'country code dropdown'</b> without any label is available");
				assertFalse(kycRegistrationPage.isCountryCodeDisplaying(driver),
						"'country code dropdown' with any label is available");
				testSteps
						.add("Step " + (++i) + " : Verified <b>'country code dropdown'</b> without any label is available");

				testSteps.add("Step " + (++i) + " : Verify text field with label <b>'Mobile number'</b> is available");
				assertTrue(kycRegistrationPage.isMobileNumberDisplaying(driver, "Mobile number"),
						"text field with label 'Mobile number' is not available");
				testSteps.add("Step " + (++i) + " : Verified text field with label <b>'Mobile number'</b> is available");

			}
			
			testSteps.add("Step " + (++i)
					+ " : Verify heading <b>'Identity Verification'</b> with description <b>'The US Government requires Vested and its broker partner to collect your PAN and Aadhaar for identity verification purposes. Your information will not be sold or used for advertisements. Read more here.'</b>");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "Identity Verification"),
					"'Identity Verification' Heading is not displaying");
			assertTrue(
					kycRegistrationPage.isTextDisplaying(driver,
							"The US Government requires Vested and its broker partner to collect your"),
					"'The US Government requires Vested and its broker partner to collect your' description is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: heading <b>'Identity Verification'</b> with description <b>'The US Government requires Vested and its broker partner to collect your PAN and Aadhaar for identity verification purposes. Your information will not be sold or used for advertisements. Read more here.'</b>");

			testSteps.add("Step " + (++i) + " : Verify button with label <b>'Get OTP'<b>");
			assertTrue(kycRegistrationPage.isButtonDisplaying(driver, "Get OTP"), "'Get OTP' Button is not displaying");
			testSteps.add("Step " + (++i) + " : Verified: button with label <b>'Get OTP'<b>");

			testSteps.add("Step " + (++i) + " : Verify button with label <b>'Upload Aadhaar'<b> is available");
			assertTrue(kycRegistrationPage.isButtonDisplaying(driver, "Upload Aadhaar"),
					"'Upload Aadhaar' Button is not available");
			testSteps.add("Step " + (++i) + " : Verified: button with label <b>'Upload Aadhaar'<b> is available");

			if (!kycRegistrationPage.isTextDisplaying(driver, "PAN verified successfully")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'PAN CARD Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.isPANInputFieldDisplaying(driver),"'PAN CARD Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'PAN CARD Number Field'</b> is Displaying");
				testSteps.add("Step " + (++i) + " : Verifying <b>'Verify PAN Button'</b> is Displaying");
				assertTrue(kycRegistrationPage.isVerifyPANButtonDisplaying(driver),"'PAN Button'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Verify PAN Button'</b> is Displaying");
//				kycRegistrationPage.enterPANNumber(driver, panCard);
//				testSteps.add("Step " + (++i) + " : Entering <b>'PAN CARD Number'</b>: ");
//
//				testSteps.add("Step " + (++i) + " : Click On <b>'VerifyPAN'</b> button");
//				kycRegistrationPage.clickOnVerifyPANButton(driver);
			}

			testSteps.add("Step " + (++i)
					+ " : Verify checkbox with label <b>'I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.'</b> is available");
			assertTrue(kycRegistrationPage.isTextDisplaying(driver, "the name on the government ID"),
					"''I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.' Checkbox is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified: checkbox with label <b>'I confirm that (i) the name on the government ID uploaded is an exact match to the name on my bank account, and (ii) the information in my uploaded documents is true, complete and accurate.'</b> is available");

			testSteps.add("Step " + (++i) + " : Verify <b>'Next'</b> is Displaying");
			assertTrue(kycRegistrationPage.isButtonDisplaying(driver, "Next"), "'Previous' is not Displaying");
			testSteps.add("Step " + (++i) + " : Verified <b>'Next'</b> is Displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Previous'</b> is clickable");
			assertTrue(kycRegistrationPage.isButtonCLickable(driver, "Previous"), "'Previous' is not clickable");
			testSteps.add("Step " + (++i) + " : Verified <b>'Previous'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar "
					+ "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get(
					"KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar "
					+ "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get(
					"KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentityPage_IndianNotLinkedAadhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 17)
	public void KYCValidation_LetGetToKnowPageWhileSelfEmployeed() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetGetToKnowPageWhileSelfEmployeed: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String panCardFileName = imagePath + dataArr1[rowIndex][4].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-741?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-741 : [Web] [New] - While self employed fields are blank, Verify validation messages on 'Let�s get to know you' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String email = "vested.automation+w012353@gmail.com";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Self Employed'");
			kycRegistrationPage.clickOnSelfEmployedStatus(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Work type is required.'</b> Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Work type is required."),
					"'Work type is required.' Validation Message is not displaying");
			testSteps.add(
					"Step " + (++i) + " : Verified <b>'Work type is required.'</b> Validation Message is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Work position is required.'</b> Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Work position is required."),
					"'Work position is required.' Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Work position is required.'</b> Validation Message is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Company name is required.'</b> Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Company name is required."),
					"'Company name is required.' Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Company name is required.'</b> Validation Message is displaying");

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Company city is required.'</b> Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Company city is required."),
					"'Company city is required.' Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'Company city is required.'</b> Validation Message is displaying");

//			testSteps.add(
//					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-771?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-771 : [Web- Bug] - On Let�s get to know you screen 'Company country is required.' is not displaying when field is empty.<a/>");
//			Apurva's Response
//			https://vestedfinance.slack.com/archives/D0330236CR0/p1666263943216779
//			testSteps.add("Step " + (++i) + " : Verify 'Company country is required.' Validation Message is displaying");
//			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver,"Company country is required."),
//					"'Company country is required.' Validation Message is not displaying");
//			testSteps.add("Step " + (++i) + " : Verified 'Company country is required.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetGetToKnowPageWhileSelfEmployeed", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: KYCValidation_LetGetToKnowPageWhileSelfEmployeed " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetGetToKnowPageWhileSelfEmployeed") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetGetToKnowPageWhileSelfEmployeed", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetGetToKnowPageWhileSelfEmployeed " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetGetToKnowPageWhileSelfEmployeed") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetGetToKnowPageWhileSelfEmployeed", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 18)
	public void KYCValidation_LetsVerifyYourIdentity_IndiaResidence() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsVerifyYourIdentity_IndiaResidence: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String panCardFileName = imagePath + dataArr1[rowIndex][4].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-735?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-735 : [Web] [New] - While user select India and fields are blank, Verify validation messages on 'Let�s verify your identity' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String email = PropertiesReader.getPropertyValue("KYC_Email");

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId("QATest", driver, 3);
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				for(int count =1; count <=2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				kycRegistrationPage.clickOnPreviousButton(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			kycRegistrationPage.selectResidencyCountry(driver, "United States of America");
			wait3s();

			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);

			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, country);

			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Fill Questionnaire");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);
			
			if (!kycRegistrationPage.isSkippedVerificationDisplaying(driver)) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Phone Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.IsPhoneNumberFieldDisplaying(driver),"'Phone Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Phone Number Field'</b> is Displaying");
				
				testSteps.add("Step " + (++i) + " : Verifying <b>'GET OTP'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isGetOtpButtonDisplaying(driver),"'GET OTP'</b> button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'GET OTP'</b> button is Displaying");
//				kycRegistrationPage.enterPhoneNumber(phoneNumber, driver);
//				testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  <b>" + phoneNumber + "</b>");
//				testSteps.addAll(kycRegistrationPage.mobileVerification(driver));
//				testSteps.add("Step " + (++i) + " : <b>'Mobile Verification'</b>");
			}

			if (!kycRegistrationPage.isTextDisplaying(driver, "PAN verified successfully")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'PAN CARD Number Field'</b> is Displaying");
				assertTrue(kycRegistrationPage.isPANInputFieldDisplaying(driver),"'PAN CARD Number Field'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'PAN CARD Number Field'</b> is Displaying");
				testSteps.add("Step " + (++i) + " : Verifying <b>'Verify PAN Button'</b> is Displaying");
				assertTrue(kycRegistrationPage.isVerifyPANButtonDisplaying(driver),"'PAN Button'</b> is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Verify PAN Button'</b> is Displaying");
//				kycRegistrationPage.enterPANNumber(driver, panCard);
//				testSteps.add("Step " + (++i) + " : Entering <b>'PAN CARD Number'</b>: ");
//
//				testSteps.add("Step " + (++i) + " : Click On <b>'VerifyPAN'</b> button");
//				kycRegistrationPage.clickOnVerifyPANButton(driver);
			}

			testSteps.add("Step " + (++i) + " : Click inside the'Mobile number' field");
			testSteps.add("Step " + (++i) + " : Click outside the'Mobile number' field");
			kycRegistrationPage.clickOnSecurityMobileNumber(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify 'Please enter a valid phone number.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Please enter a valid phone number."),
					"'Please enter a valid phone number.' Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified 'Please enter a valid phone number.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Click inside the'Aadhar number' field");
			testSteps.add("Step " + (++i) + " : Click outside the'the'Aadhar number' field");
			kycRegistrationPage.clickOnSecurityAadharNumber(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Aadhaar No is required' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Aadhaar No is required"),
					"'Aadhaar No is required' Validation Message is not displaying");
			testSteps.add("Step " + (++i) + " : Verified 'Aadhaar No is required' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Select �No� in �Is your mobile number linked with Aadhaar?");
			kycRegistrationPage.clickOnNoButtonForMobile(driver);

			testSteps.add("Step " + (++i) + " : Click inside the'Mobile number' field");
			testSteps.add("Step " + (++i) + " : Click outside the'Mobile number' field");
			kycRegistrationPage.clickOnSecurityMobileNumber(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify 'Please enter a valid phone number.' Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "Please enter a valid phone number."),
					"'Please enter a valid phone number.' Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified 'Please enter a valid phone number.' Validation Message is displaying");

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentity_IndiaResidence", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentity_IndiaResidence " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsVerifyYourIdentity_IndiaResidence") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentity_IndiaResidence", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetsVerifyYourIdentity_IndiaResidence " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsVerifyYourIdentity_IndiaResidence") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsVerifyYourIdentity_IndiaResidence", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 19)
	public void KYCValidation_LetsOpenYourAccount_BlankOptions() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-732?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-732 : [Web] [New] - While options are blank, Verify validation messages on 'Let�s open your account' screen<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsOpenYourAccount_BlankOptions: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String panCardFileName = imagePath + dataArr1[rowIndex][4].toString();

		String email = "codeautomation.nouman+27@vestedfinance.co";
		String password = "Test@12345";
		String country = "India";
		String countryNationality = "India";

		int i = 0;
		try {

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			testSteps.add("Step " + (++i) + " : Click on 'CompleteKYC'");
			kycRegistrationPage.clickOnCompleteKYC(driver);

			try {
				kycRegistrationPage.isSelectPlanScreenHeading(driver);
				testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
				kycRegistrationPage.clickOnNextButton(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}
			testSteps.add("Step " + (++i) + " : Click on 'Done'");
			kycRegistrationPage.clickOnDoneButton(driver);
			String[] message = { "You must review our Client Relationship Summary.", "Your signature is required" };

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'You must agree to Vested and DriveWealth's Disclosures and Privacy Policy.'</b> Validation Message is displaying");
			assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, "You must agree to Vested and DriveWealth"),
					"<b>'You must agree to Vested and DriveWealth's Disclosures and Privacy Policy.'</b> Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'You must agree to Vested and DriveWealth's Disclosures and Privacy Policy.'</b> Validation Message is displaying");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'You must agree to VF Securities and DriveWealth's Agreements.'</b> Validation Message is displaying");
			assertTrue(
					kycRegistrationPage.isErrorMessageDisplaying(driver,
							"You must agree to VF Securities and DriveWealth"),
					"<b>'You must agree to VF Securities and DriveWealth's Agreements.'</b> Validation Message is not displaying");
			testSteps.add("Step " + (++i)
					+ " : Verified <b>'You must agree to VF Securities and DriveWealth's Agreements.'</b> Validation Message is displaying");

			for (String l : message) {
				testSteps.add("Step " + (++i) + " : Verify <b>'" + l + "'</b> Validation Message is displaying");
				assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, l),
						"<b>'" + l + "'</b> Validation Message is not displaying");
				testSteps.add("Step " + (++i) + " : Verified <b>'" + l + "'</b> Validation Message is displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsOpenYourAccount_BlankOptions", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYCValidation_LetsOpenYourAccount_BlankOptions " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsOpenYourAccount_BlankOptions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsOpenYourAccount_BlankOptions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps.add("Failed: KYCValidation_LetsOpenYourAccount_BlankOptions " + "<br><b>Error:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsOpenYourAccount_BlankOptions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsOpenYourAccount_BlankOptions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 20)
	public void KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		Object[][] dataArr1 = getData(testDataFile, KYC_NonAdaarReg, driver);
		String appPassword = dataArr[rowIndex][0].toString();
		String panCardFileName = imagePath + dataArr1[rowIndex][4].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-726?atlOrigin=eyJpIjoiYzQwMjBhNWFmNTgyNGM4ZmJkYjBjNjAzMDZlMWYyYzMiLCJwIjoiaiJ9\">QAA-726 : [Web] [New] - While options are blank, Verify validation messages on 'Let�s build your investment profile' screen<a/>");

		String password = PropertiesReader.getPropertyValue("KYC_Password");
		String country = "India";
		String countryNationality = "India";
		String[] ErrorList = { "Risk tolerance is required.", "Investing frequency is required.",
				"Investing experience is required.", "Yearly income is required.", "Liquid net worth is required.",
				"Total net worth is required.", "Funding source is required.",
				"The number of deposits and withdrawals is required.",
				"The amount you plan to deposit in your account is required.",
				"The number of investments you have made in the last year is required." };

		String email = "vested.automation+w03letsbuild@gmail.com";
		int i = 0;
		try {
			testSteps.addAll(loginPage.loginToApp(email, password, driver));
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//			String email = getUniqueEmailId("QATest", driver, 3);
//			testSteps.add("Step " + (++i) + " : Enter app Password");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'submit'");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign up' with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Sign Up' Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Verification' code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified 'Verification code' screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login' Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Login with Email'");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : " + email);
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : " + password);
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on Login Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify 'Explore Platform' button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified 'Explore Platform' button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver), "Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);
			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
			}catch (Exception e) {
				// TODO: handle exception
			}

//			testSteps.add("Step " + (++i) + " : Choose <b>'" + countryNationality + "'</b> nationality country");
//			kycRegistrationPage.selectResidencyCountry(driver, countryNationality);
//
//			testSteps.add("Step " + (++i) + " : Choose <b>'" + country + "'</b> primarily file taxes country");
//			kycRegistrationPage.selectTaxResidencyCountry(driver, country);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Male Gender'");
//			kycRegistrationPage.clickOnMaleGender(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Single Marital Status'");
//			kycRegistrationPage.clickOnSingle_Marital(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Retired'");
//			kycRegistrationPage.clickOnRetiredStatus(driver);
//
//			testSteps.add("Step " + (++i) + " : Check 'None of Above'");
//			kycRegistrationPage.checkNoneofAboveOption(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
//			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Click on 'Next Button'");
			kycRegistrationPage.clickOnNextButton(driver);

			for (String message : ErrorList) {
				testSteps.add("Step " + (++i) + " : Verify <b>'" + message + "'</b> Validation Message is displaying");
				assertTrue(kycRegistrationPage.isErrorMessageDisplaying(driver, message),
						"'" + message + "' Validation Message is not displaying");
				testSteps
						.add("Step " + (++i) + " : Verified <b>'" + message + "'</b> Validation Message is displaying");
			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions", testSteps, driver);

		} catch (Exception e) {
			
			testSteps.add("Failed: KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions "
					+ "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions "
					+ "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCValidation_LetsBuildYourInvestmentProfile_BlankOptions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
