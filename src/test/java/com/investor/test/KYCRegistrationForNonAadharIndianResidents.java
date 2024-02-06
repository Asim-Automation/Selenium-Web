package com.investor.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.KYCRegistrationPage;
import com.investor.pages.LoginPage;

public class KYCRegistrationForNonAadharIndianResidents extends BaseClass {
	String tempSrc = "";

//	@Test(priority = 1)
	public void KYC_NonAdhar() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_NonAdhar:" + driver.hashCode() + "", driver);
		Object[][] loginSheet = getData(testDataFile, testDataSheet, driver);
		String appPassword = loginSheet[rowIndex][0].toString();
		Object[][] dataArr = getData(testDataFile, KYC_NonAdaarReg, driver);
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-68?atlOrigin=eyJpIjoiNGJmYjI2YzIyYzk2NDgwMGIyZmFjMjQyMTA1OTE2MWEiLCJwIjoiaiJ9\">QAA-68 : [KYC Registration] for the Non Aadhar Indian Residents<a/>");

		String fullName = dataArr[rowIndex][0].toString();
		String password = dataArr[rowIndex][2].toString();
		String phoneNumber = dataArr[rowIndex][3].toString();
		String panCardFileName = imagePath + dataArr[rowIndex][4].toString();
		String aadhaarCardFileName = imagePath + dataArr[rowIndex][5].toString();
		String address1 = dataArr[rowIndex][6].toString();
		String address2 = dataArr[rowIndex][7].toString();
		String city = dataArr[rowIndex][8].toString();
		String pinCode = dataArr[rowIndex][9].toString();
		String state = dataArr[rowIndex][10].toString();

		String kycApproved = "KYC | Vested Finance";

		int i = 0;
		try {

			testSteps.add("Step " + (++i) + " : Navigate to app url : "
					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);

			String email = getUniqueEmailId(dataArr[rowIndex][1].toString(), driver, 3);

			testSteps.add("Step " + (++i) + " : Enter app <b>'Password'</b>");
			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'submit'</b>");
			loginPage.clickOnSubmitButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Sign up'</b> with email Button");
			loginPage.clickOnSignUpWithEmail(driver);

			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
			loginPage.enterB2BUserEmailAddress(email, driver);

			testSteps.add("Step " + (++i) + " : Enter <b>'Password'</b> ");
			loginPage.enterB2BUserPassword(password, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Sign Up'</b> Button");
			loginPage.clickOnSubmitButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Verification'</b> code screen is displaying");
			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
					"Verified <b>'Verification code'</b> screen is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
			loginPage.clickOnLoginPageButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Login with Email'</b>");
			loginPage.clickOnloginWithEmail(driver);

			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
			loginPage.enterB2BUserEmailAddress(email, driver);

			testSteps.add("Step " + (++i) + " : Enter Password : <b>'" + password + "'</b>");
			loginPage.enterB2BUserPassword(password, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
			loginPage.clickOnLoginButton(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Explore Platform'</b> button is displaying");
			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
					"Verified <b>'Explore Platform'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify <b>'Start KYC'</b> button is displaying");
			assertTrue(loginPage.verifyStartKYCButtonIsDisplaying(driver),
					"Verified <b>'Start KYC'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Start KYC'</b>");
			kycRegistrationPage.clickOnStartKYC(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'ACCEPT AND CONTINUE'</b>");
			kycRegistrationPage.clickAcceptAndContinue_button(driver);

			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Click on <b>'Male Gender'</b>");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Single Marital Status'</b>");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Retired'</b>");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check <b>'None of Above'</b>");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : <b>'Fill Questionnaire'</b>");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			try {
				waitfor10sec();
				kycRegistrationPage.clickOnNoButtonForMobile(driver);
				testSteps.add("Step " + (++i)
						+ " : Selecting <b>'No'</b> in <b>'Is your mobile number linked with Aadhaar?'</b>");
			} catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : Enter PhoneNumber:  <b>" + phoneNumber + "</b>");
			kycRegistrationPage.enterPhoneNumber(phoneNumber, driver);

			testSteps.add("Step " + (++i) + " : <b>'Mobile Verification'</b>");
			testSteps.addAll(kycRegistrationPage.mobileVerification(driver));

			testSteps.add("Step " + (++i) + " : Click On <b>'Upload PAN CARD'</b> button");
			kycRegistrationPage.clickOnUploadPanCard_Button(driver);

			testSteps.add("Step " + (++i) + " : Click On Upload PAN CARD pop up <b>'Confirm'</b> button");
			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);

			testSteps.add("Step " + (++i) + " : <b>'Upload file'</b>");
			kycRegistrationPage.uploadfile(panCardFileName, driver);

//			testSteps.add("Step " + (++i) + " : <b>'Upload Button'</b>");
//			kycRegistrationPage.clickOnUpload_Button(driver);

			testSteps.add("Step " + (++i) + " : Click On <b>'Upload Aadhaar Card'</b> button");
			kycRegistrationPage.clickOnUploadAadhaarCard_Button(driver);

			testSteps.add("Step " + (++i) + " : Click On Upload Aadhaar card pop up <b>'Confirm'</b> button");
			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);

			testSteps.add("Step " + (++i) + " : <b>'Upload file'</b>");
			kycRegistrationPage.uploadfile(aadhaarCardFileName, driver);

//			testSteps.add("Step " + (++i) + " : <b>'Upload Button'</b>");
//			kycRegistrationPage.clickOnUpload_Button(driver);

			testSteps.add("Step " + (++i) + " : Enter <b>'Address Information'</b>");
			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : <b>'Confirm Checkbok'</b>");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

//			testSteps.add("Step " + (++i) + " :Selecting <b>'All Access'</b> Account Type");
//			kycRegistrationPage.clickOnAllAccessAccount(driver);
//			
//			testSteps.add("Step " + (++i) + " : Click on <b>'Proceed All Access Account Type'</b>");
//			kycRegistrationPage.clickOnProceedAllAccessAccount(driver);

			testSteps.add("Step " + (++i) + " : Verify that <b>'Select a subscription plan'</b> page is displaying");
			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
					"Verified that <b>'Select a plan that suits you best'</b> page is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'View Details'</b>");
			kycRegistrationPage.clickOnViewDetails(driver);

			testSteps.addAll(kycRegistrationPage.verifyDefaultSelectedButtons(driver));

			testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information'</b>");
			kycRegistrationPage.clickOnTaxFormInformation(driver);

			testSteps.add("Verifying 'TaxFormInformation' Pop Up Modal is Displaying");
			assertTrue(kycRegistrationPage.isTaxFormInformationModal(driver),
					"Failed:'TaxFormInformation' Pop Up Modal is not Displaying");
			testSteps.add("Verified: 'TaxFormInformation' Pop Up Modal is Displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information' Close Icon</b>");
			kycRegistrationPage.clickOnTaxFormInformationModalClose(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'DriveWealth�s Disclosures and Account Agreements'</b>");
			kycRegistrationPage.clickOnDisclosureAgreement(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			testSteps.add("Verifying 'Disclosure Agreement' Page Heading  is Displaying");
			assertTrue(kycRegistrationPage.isDisclosureAgreementPageHeading(driver),
					"Failed:'Disclosure Agreement' Page Heading is not Displaying");
			testSteps.add("Verified: 'Disclosure Agreement' Page Heading is Displaying");

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement'</b>");
			kycRegistrationPage.clickOnEsignAgreement(driver);

			testSteps.add("Verifying 'Esign' Pop Up Modal is Displaying");
			assertTrue(kycRegistrationPage.isEsignModal(driver), "Failed:'Esign' Pop Up Modal is not Displaying");
			testSteps.add("Verified: 'Esign' Pop Up Modal is Displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement' Modal Close Icon</b>");
			kycRegistrationPage.clickOnesignModalCloseIcon(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Advisory Agreement'</b>");
			kycRegistrationPage.clickOnAdvisoryAgreement(driver);

			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			testSteps.add("Verifying 'Advisory Agreement' Page  is Displaying");
			assertTrue(driver.getCurrentUrl().contains("vested-advisory-agreement"),
					"Failed:'Advisory Agreement' Page is not Displaying");
			testSteps.add("Verified: 'Advisory Agreement' Page is Displaying");

			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			closeTab(1, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'DriveWealth�s Privacy Policy'</b>");
			kycRegistrationPage.clickOnPrivacyPolicy(driver);

			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			testSteps.add("Verifying 'DriveWealth�s Privacy Policy' Page  is Displaying");
			assertTrue(kycRegistrationPage.isprivacyPolicyPageHeadingDisplaying(driver),
					"Failed:'DriveWealth�s Privacy Policy' Page is not Displaying");
			testSteps.add("Verified: 'DriveWealth�s Privacy Policy' Page is Displaying");

			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			closeTab(1, driver);

			try {
				kycRegistrationPage.checkVfsAgreementCheckbox(driver);
				testSteps.add("Step " + (++i) + " : click on <b>'Vfs Agreement'</b> Checkbox");
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				kycRegistrationPage.checkCrsAgreementCheckbox(driver);
				testSteps.add("Step " + (++i) + " : click on <b>'Crs Agreement'</b> Checkbox");
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				kycRegistrationPage.clickOnEnrollSocityYes(driver);
				testSteps.add("Step " + (++i) + " : click on <b>'Enroll In Society'</b> Yes Button");
			} catch (Exception e) {
				// TODO: handle exception
			}

			testSteps.add("Step " + (++i) + " : click on <b>'I Agree'</b> Checkbok");
			kycRegistrationPage.clickOnIAgreeCheckbox(driver);

			testSteps.add("Step " + (++i) + " : Enter Full name :  <b>'" + fullName + "'</b>");
			kycRegistrationPage.enterYourFullName(fullName, driver);

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
				testSteps.add("Step " + (++i) + " : Click on <b>'Done Button'</b>");
				kycRegistrationPage.clickOnDoneButton(driver);

				testSteps.add("Step " + (++i)
						+ " : Verify that <b>'Complete 3 simple steps to start investing in US stocks and ETFs'</b> page is displaying");
				assertTrue(kycRegistrationPage.verifyKycApprovedTitleIsDisplaying(driver),
						"Verified that <b>'Complete 3 simple steps to start investing in US stocks and ETFs'</b> page is displaying");

			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("KYC_NonAdhar", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: KYC_NonAdhar " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NonAdhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NonAdhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: KYC_NonAdhar " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NonAdhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NonAdhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 3)
	public void KYC_NonAdharFlowWithDifferentCombination() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-68?atlOrigin=eyJpIjoiNGJmYjI2YzIyYzk2NDgwMGIyZmFjMjQyMTA1OTE2MWEiLCJwIjoiaiJ9\">QAA-471 : [Web] - Verify KYC flow with different combinations of options selected<a/>");

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYC_NonAdharFlowWithDifferentCombination:" + driver.hashCode() + "", driver);
		Object[][] loginSheet = getData(testDataFile, testDataSheet, driver);
		String appPassword = loginSheet[rowIndex][0].toString();
		Object[][] dataArr = getData(testDataFile, KYC_NonAdaarReg, driver);
		String invalidString = "a";
		String invalidString_2 = "abc";
		String validString = "Apurva Jain";
		Object[][] dataKYC = getData(testDataFile, KYCNegative_NonAadhar, driver);
		String company = dataKYC[rowIndex][3].toString();
		String industry = dataKYC[rowIndex][4].toString();
		String position = dataKYC[rowIndex][5].toString();
		String fullName = dataArr[rowIndex][0].toString();
		String password = "#TestUser12";
		String phoneNumber = dataArr[rowIndex][3].toString();
		String panCardFileName = imagePath + dataArr[rowIndex][4].toString();
		String aadhaarCardFileName = imagePath + dataArr[rowIndex][5].toString();
		String address1 = dataArr[rowIndex][6].toString();
		String address2 = dataArr[rowIndex][7].toString();
		String city = dataArr[rowIndex][8].toString();
		String pinCode = dataArr[rowIndex][9].toString();
		String state = dataArr[rowIndex][10].toString();
		String email = "vested.automation+w0100201@gmail.com";
		String kycApproved = "KYC | Vested Finance";
		String panCard = "BNZPM2501F";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			String email = getUniqueEmailId(dataArr[rowIndex][1].toString(), driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app <b>'Password'</b>");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'submit'</b>");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Sign up'</b> with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter <b>'Password'</b> ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Sign Up'</b> Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Verification'</b> code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified <b>'Verification code'</b> screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login with Email'</b>");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : <b>'" + password + "'</b>");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Explore Platform'</b> button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified <b>'Explore Platform'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver),
					"Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			try {
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
			} catch (Exception e) {
				// TODO: handle exception
			}

			for (int count = 1; count <= 2; count++) {
				kycRegistrationPage.clickOnPreviousButton(driver);
			}
//			testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
//			try {
//				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
//				kycRegistrationPage.clickAcceptAndContinue_button(driver);
//				for (int count = 1; count <= 2; count++) {kycRegistrationPage.clickOnPreviousButton(driver);}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
			wait3s();
			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Verify <b>'Male Gender'</b> is clickable");
			assertTrue(kycRegistrationPage.isMaleGenderClickable(driver), "Verified <b>'Male Gender'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify 'Female Gender is clickable");
			assertTrue(kycRegistrationPage.isFemaleGenderClickable(driver),
					"Verified <b>'Female Gender'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Male Gender'</b>");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Single Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isSingleMaritalClickable(driver),
					"Verified <b>'Single Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Divorced Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isDivorcedMaritalClickable(driver),
					"Verified <b>'Divorced Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Widowed Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isWidowedMaritalClickable(driver),
					"Verified <b>'Widowed Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Married Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isMarriedMaritalClickable(driver),
					"Verified <b>'Married Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Domestic Partner Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isDomesticPartnerMaritalClickable(driver),
					"Verified <b>'Domestic Partner Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Single Marital Status'</b>");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Employed Status is clickable");
			assertTrue(kycRegistrationPage.isEmployedStatusClickable(driver),
					"Verified <b>'Employed Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Retired Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isRetiredStatusClickable(driver),
					"Verified 'Retired Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Student Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isStudentStatusClickable(driver),
					"Verified <b>'Student Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Self Employed Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isSelfEmployedStatusClickable(driver),
					"Verified <b>'Self Employed Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Unemployed Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isUnemployedStatusClickable(driver),
					"Verified <b>'Unemployed Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Self Employed'</b>");
			kycRegistrationPage.clickOnSelfEmployedStatus(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Which industry you work on'</b> is present");
			assertTrue(kycRegistrationPage.isWhichIndustryDoYouWorkInPresent(driver),
					"Verified <b>'Which industry you work on'</b> is present");

			testSteps.add("Step " + (++i) + " : Verify <b>'Which Position you work on'</b> is present");
			assertTrue(kycRegistrationPage.isWhichPositionDoYouWorkInPresent(driver),
					"Verified <b>'Which Position you work on'</b> is present");

			testSteps.add("Step " + (++i) + " :  Enter Industry: <b>'" + industry + "'</b>");
			kycRegistrationPage.enterIndustryDropDown(industry, driver);

			testSteps.add("Step " + (++i) + " : Select <b>'Industry Arts'</b>");
			kycRegistrationPage.selectIndustryArts(driver);

			testSteps.add("Step " + (++i) + " :  Enter Industry: <b>'" + position + "'</b>");
			kycRegistrationPage.enterPosition(position, driver);

			testSteps.add("Step " + (++i) + " : Select <b>'Position Accountant'</b>");
			kycRegistrationPage.selectPositionAccountant(driver);

			testSteps.add("Step " + (++i) + " : Enter Company Name :  <b>'" + company + "'</b>");
			kycRegistrationPage.enterCompanyName(company, driver);

			testSteps.add("Step " + (++i) + " : Enter Company City :  <b>" + city + "'</b>");
			kycRegistrationPage.enterCompanyCity(city, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>' None of Above Checkbox'</b>");
			kycRegistrationPage.checkNoneofAboveOption(driver);
			
			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			// Page 2

			testSteps.add("Step " + (++i) + " : Click on <b>'Low Risk Tolerance'</b>");
			kycRegistrationPage.ClickOnLow_RiskTolerate(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Several Times A Week Investment'</b>");
			kycRegistrationPage.ClickOnSeveralTime_Invest(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'One Year Investing Experience'</b>");
			kycRegistrationPage.ClickOnOneYear_experience(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Ten Lakh Yearly Income'</b>");
			kycRegistrationPage.ClickOnTenlakh_yearlyIncome(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'0 - 5 Lakh Liquid Net Worth'</b>");
			kycRegistrationPage.ClickOnFivelakh_liquidworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'0 - 10 Lakh Total Net Worth'</b>");
			kycRegistrationPage.ClickOnTenlakh_totalworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'0 - 5 Lakh Deposit and Withdrawal'</b>");
			kycRegistrationPage.ClickOnFivelakh_deposite(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'0 - 5 Investment Made'</b>");
			kycRegistrationPage.ClickOnFivelakh_investmentsMade(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'0 - 50,000 Money To Do Plan To Deposit'</b>");
			kycRegistrationPage.ClickOnfiftythousand_moneyPlan(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'Gift'</b> as a Primary Source");
			kycRegistrationPage.SelectGiftPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Previous Button'</b>");
			kycRegistrationPage.clickOnPreviousButton(driver);

			// 1

			testSteps.add("Step " + (++i) + " : Click on <b>'Moderate Risk Tolerance'</b>");
			kycRegistrationPage.ClickOnModerate_RiskTolerate(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Once In Month Investment'</b>");
			kycRegistrationPage.ClickOnOnceInMonth_Invest(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'1 - 2 Year Investing Experience'</b>");
			kycRegistrationPage.ClickOnTwoYear_experience(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'10 - 25 Lakh Yearly Income'</b>");
			kycRegistrationPage.ClickOnTwentyFivelakh_yearlyIncome(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'5 - 10 Lakh Liquid Net Worth'</b>");
			kycRegistrationPage.ClickOnTenlakh_liquidworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'0 - 30 Lakh Total Net Worth'</b>");
			kycRegistrationPage.ClickOnThirtylakh_totalworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'6 - 10 Lakh Deposit and Withdrawal'</b>");
			kycRegistrationPage.ClickOnTenlakh_deposite(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'6 - 10 Investment Made'</b>");
			kycRegistrationPage.ClickOnTenlakh_investmentsMade(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'50,000 - 1 lakh Money To Do Plan To Deposit'</b>");
			kycRegistrationPage.ClickOnOneLakh_moneyPlan(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'Employment'</b> as a Primary Source");
			kycRegistrationPage.SelectEmploymentPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Previous Button'</b>");
			kycRegistrationPage.clickOnPreviousButton(driver);

			// 2

			testSteps.add("Step " + (++i) + " : Click on <b>'High Risk Tolerance'</b>");
			kycRegistrationPage.ClickOnHigh_RiskTolerate(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Once In Every Month Investment'</b>");
			kycRegistrationPage.ClickOnOnceInEveryMonth_Invest(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'3 - 5 Year Investing Experience'</b>");
			kycRegistrationPage.ClickOnFiveYear_experience(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'25 - 50 Lakh Yearly Income'</b>");
			kycRegistrationPage.ClickOnFiftylakh_yearlyIncome(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'10 - 30 Lakh Liquid Net Worth'</b>");
			kycRegistrationPage.ClickOnThirtylakh_liquidworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'30 Lakh - 1 Crore Lakh Total Net Worth'</b>");
			kycRegistrationPage.ClickOnOneCrore_totalworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'11+ Lakh Deposit and Withdrawal'</b>");
			kycRegistrationPage.ClickOnTenPluslakh_deposite(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'11+ Investment Made'</b>");
			kycRegistrationPage.ClickOnTenPluslakh_investmentsMade(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'1 lakh - 7 lakh Money To Do Plan To Deposit'</b>");
			kycRegistrationPage.ClickOnSevenLakh_moneyPlan(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'InvestmentProceeds'</b> as a Primary Source");
			kycRegistrationPage.SelectInvestmentProceedsPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Previous Button'</b>");
			kycRegistrationPage.clickOnPreviousButton(driver);

			// 3

			testSteps.add("Step " + (++i) + " : Click on <b>'High Risk Tolerance'</b>");
			kycRegistrationPage.ClickOnHigh_RiskTolerate(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Once In Every Month Investment'</b>");
			kycRegistrationPage.ClickOnOnceInEveryMonth_Invest(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'10+ Year Investing Experience'</b>");
			kycRegistrationPage.ClickOnTenPlusYear_experience(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'50+ Lakh Yearly Income'</b>");
			kycRegistrationPage.ClickOnFiftyPluslakh_yearlyIncome(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'30+ Lakh Liquid Net Worth'</b>");
			kycRegistrationPage.ClickOnThirtylakh_liquidworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'1+ Crore Lakh Total Net Worth'</b>");
			kycRegistrationPage.ClickOnOnePlusCrore_totalworth(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'11+ Lakh Deposit and Withdrawal'</b>");
			kycRegistrationPage.ClickOnTenPluslakh_deposite(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'11+ Investment Made'</b>");
			kycRegistrationPage.ClickOnTenPluslakh_investmentsMade(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'7+ lakh Money To Do Plan To Deposit'</b>");
			kycRegistrationPage.ClickOnSevenPlusLakh_moneyPlan(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'Savings'</b> as a Primary Source");
			kycRegistrationPage.SelectSavingsPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'Retirement Funds'</b> as a Primary Source");
			kycRegistrationPage.SelectRetirementFundsPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'Gambling'</b> as a Primary Source");
			kycRegistrationPage.SelectGamblingPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Select on <b>'Legal Settlement'</b> as a Primary Source");
			kycRegistrationPage.SelectlegalSettlementPrimarySorce(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			try {
				waitfor10sec();
				kycRegistrationPage.clickOnNoButtonForMobile(driver);
				testSteps.add("Step " + (++i)
						+ " : Selecting <b>'No'</b> in <b>'Is your mobile number linked with Aadhaar?'</b>");
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				kycRegistrationPage.clickOnProcessedButton(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

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
//				testSteps.add("Step " + (++i) + " : Click On <b>'VerifyPAN'</b> button");
//				kycRegistrationPage.clickOnVerifyPANButton(driver);
			}

			if (!kycRegistrationPage.isTextDisplaying(driver, "Proof of Address: Aadhaar uploaded.")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Upload Aadhar'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isUploadAadharCardButtonDisplaying(driver),"'Upload Aadhar' button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Upload Aadhar'</b> button is Displaying");
				
//				testSteps.add("Step " + (++i) + " : Click On <b>'Upload Aadhaar Card'</b> button");
//				kycRegistrationPage.clickOnUploadAadhaarCard_Button(driver);
//
//				testSteps.add("Step " + (++i) + " : Click On Upload Aadhaar card pop up <b>'Confirm'</b> button");
//				kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//				testSteps.add("Step " + (++i) + " : <b>'Upload file'</b>");
//				kycRegistrationPage.uploadfile(aadhaarCardFileName, driver);
			}

//			testSteps.add("Step " + (++i) + " : Enter <b>'Address Information'</b>");
//			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

//			testSteps.add("Step " + (++i) + " : <b>'Confirm Checkbok'</b>");
//			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
//			kycRegistrationPage.clickOnNextButton(driver);
//			try {
//				testSteps.add("Step " + (++i) + " : Click on <b>'Proceed All Access Account '</b>Button");
//				kycRegistrationPage.clickOnProceedAllAccessAccount(driver);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>'Select a subscription plan'</b> page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that <b>'Select a plan that suits you best'</b> page is displaying");

			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				try {
//					testSteps.addAll(kycRegistrationPage.SelectBasicPlan(driver, phoneNumber));
//				} catch (Exception e) {
//					testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
//					kycRegistrationPage.clickOnNextButton(driver);
//				}
//
//				try {
//
//					kycRegistrationPage.clickOnViewDetails(driver);
//					testSteps.add("Step " + (++i) + " : Click on <b>'View Details'</b>");
//
//					testSteps.addAll(kycRegistrationPage.verifyDefaultSelectedButtons(driver));
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information'</b>");
//				kycRegistrationPage.clickOnTaxFormInformation(driver);
//
//				testSteps.add("Verifying 'TaxFormInformation' Pop Up Modal is Displaying");
//				assertTrue(kycRegistrationPage.isTaxFormInformationModal(driver),
//						"Failed:'TaxFormInformation' Pop Up Modal is not Displaying");
//				testSteps.add("Verified: 'TaxFormInformation' Pop Up Modal is Displaying");
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information' Close Icon</b>");
//				kycRegistrationPage.clickOnTaxFormInformationModalClose(driver);
//
//				testSteps.add(
//						"Step " + (++i) + " : Click on <b>'DriveWealth�s Disclosures and Account Agreements'</b>");
//				kycRegistrationPage.clickOnDisclosureAgreement(driver);
//
//				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs2.get(1));
//
//				testSteps.add("Verifying 'Disclosure Agreement' Page Heading  is Displaying");
//				assertTrue(kycRegistrationPage.isDisclosureAgreementPageHeading(driver),
//						"Failed:'Disclosure Agreement' Page Heading is not Displaying");
//				testSteps.add("Verified: 'Disclosure Agreement' Page Heading is Displaying");
//
//				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(0));
//				closeTab(1, driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement'</b>");
//				kycRegistrationPage.clickOnEsignAgreement(driver);
//
//				testSteps.add("Verifying 'Esign' Pop Up Modal is Displaying");
//				assertTrue(kycRegistrationPage.isEsignModal(driver), "Failed:'Esign' Pop Up Modal is not Displaying");
//				testSteps.add("Verified: 'Esign' Pop Up Modal is Displaying");
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement' Modal Close Icon</b>");
//				kycRegistrationPage.clickOnesignModalCloseIcon(driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'DriveWealth�s Privacy Policy'</b>");
//				kycRegistrationPage.clickOnPrivacyPolicy(driver);
//
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(1));
//
//				testSteps.add("Verifying 'DriveWealth�s Privacy Policy' Page  is Displaying");
//				assertTrue(kycRegistrationPage.isprivacyPolicyPageHeadingDisplaying(driver),
//						"Failed:'DriveWealth�s Privacy Policy' Page is not Displaying");
//				testSteps.add("Verified: 'DriveWealth�s Privacy Policy' Page is Displaying");
//
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(0));
//				closeTab(1, driver);
//
//				try {
//					kycRegistrationPage.checkVfsAgreementCheckbox(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Vfs Agreement'</b> Checkbox");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					kycRegistrationPage.checkCrsAgreementCheckbox(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Crs Agreement'</b> Checkbox");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					kycRegistrationPage.clickOnEnrollSocityYes(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Enroll In Society'</b> Yes Button");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				testSteps.add("Step " + (++i) + " : click on <b>'I Agree'</b> Checkbok");
//				kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//				testSteps.add("Step " + (++i) + " : Enter Full name :  <b>'" + fullName + "'</b>");
//				kycRegistrationPage.enterYourFullName(fullName, driver);

				testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
				AddTest_IntoReport("KYC_NonAdharFlowWithDifferentCombination", testSteps, driver);
			}
		} catch (Exception e) {
			
			testSteps.add(
					"Failed: KYC_NonAdharFlowWithDifferentCombination " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NonAdharFlowWithDifferentCombination") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NonAdharFlowWithDifferentCombination", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			
			testSteps
					.add("Failed: KYC_NonAdharFlowWithDifferentCombination " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYC_NonAdharFlowWithDifferentCombination") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYC_NonAdharFlowWithDifferentCombination", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 2)
	public void KYCNegative_NonAadhar() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("KYCNegative_NonAadhar: " + driver.hashCode() + "", driver);
		Object[][] loginSheet = getData(testDataFile, testDataSheet, driver);
		String appPassword = loginSheet[rowIndex][0].toString();

		Object[][] dataArr = getData(testDataFile, KYCNegative_NonAadhar, driver);
		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-99?atlOrigin=eyJpIjoiOTUyZjdiY2RkYWZmNGQ1YTg4YTZjN2Q3NDkyNjkxZDAiLCJwIjoiaiJ9\"> QAA-99 : [KYC] Negative - Non Aadhar Indian Residents - add to QAA-68<a/>");

		String password = "#TestUser12";
		String city = dataArr[rowIndex][2].toString();
		String company = dataArr[rowIndex][3].toString();
		String industry = dataArr[rowIndex][4].toString();
		String position = dataArr[rowIndex][5].toString();

		String invalidString = "a";
		String invalidString_2 = "abc";
		String validString = "Apurva Jain";
		String email = "vested.automation+w01negetivenonaadhar@gmail.com";

		int i = 0;
		try {

			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//
//			testSteps.add("Step " + (++i) + " : Enter app <b>'Password'</b>");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'submit'</b>");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Sign up'</b> with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter <b>'Password'</b> ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Sign Up'</b> Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Verification'</b> code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified <b>'Verification code'</b> screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login with Email'</b>");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : <b>'" + password + "'</b>");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Explore Platform'</b> button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified <b>'Explore Platform'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver),
					"Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

//			try {
//				for(int count =1; count <=2; count++) {
//					kycRegistrationPage.clickOnPreviousButton(driver);
//				}
//				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
//				
//			}catch (Exception e) {
//				// TODO: handle exception
//			}

			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Verify <b>'Male Gender'</b> is clickable");
			assertTrue(kycRegistrationPage.isMaleGenderClickable(driver), "Verified <b>'Male Gender'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify 'Female Gender is clickable");
			assertTrue(kycRegistrationPage.isFemaleGenderClickable(driver),
					"Verified <b>'Female Gender'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Male Gender'</b>");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Single Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isSingleMaritalClickable(driver),
					"Verified <b>'Single Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Divorced Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isDivorcedMaritalClickable(driver),
					"Verified <b>'Divorced Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Widowed Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isWidowedMaritalClickable(driver),
					"Verified <b>'Widowed Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Married Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isMarriedMaritalClickable(driver),
					"Verified <b>'Married Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Domestic Partner Marital'</b> is clickable");
			assertTrue(kycRegistrationPage.isDomesticPartnerMaritalClickable(driver),
					"Verified <b>'Domestic Partner Marital'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Single Marital Status'</b>");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Verify 'Employed Status is clickable");
			assertTrue(kycRegistrationPage.isEmployedStatusClickable(driver),
					"Verified <b>'Employed Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Retired Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isRetiredStatusClickable(driver),
					"Verified 'Retired Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Student Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isStudentStatusClickable(driver),
					"Verified <b>'Student Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Self Employed Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isSelfEmployedStatusClickable(driver),
					"Verified <b>'Self Employed Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Verify <b>'Unemployed Status'</b> is clickable");
			assertTrue(kycRegistrationPage.isUnemployedStatusClickable(driver),
					"Verified <b>'Unemployed Status'</b> is clickable");

			testSteps.add("Step " + (++i) + " : Click on <b>'Self Employed'</b>");
			kycRegistrationPage.clickOnSelfEmployedStatus(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Which industry you work on'</b> is present");
			assertTrue(kycRegistrationPage.isWhichIndustryDoYouWorkInPresent(driver),
					"Verified <b>'Which industry you work on'</b> is present");

			testSteps.add("Step " + (++i) + " : Verify <b>'Which Position you work on'</b> is present");
			assertTrue(kycRegistrationPage.isWhichPositionDoYouWorkInPresent(driver),
					"Verified <b>'Which Position you work on'</b> is present");

			testSteps.add("Step " + (++i) + " :  Enter Industry: <b>'" + industry + "'</b>");
			kycRegistrationPage.enterIndustryDropDown(industry, driver);

			testSteps.add("Step " + (++i) + " : Select <b>'Industry Arts'</b>");
			kycRegistrationPage.selectIndustryArts(driver);

			testSteps.add("Step " + (++i) + " :  Enter Industry: <b>'" + position + "'</b>");
			kycRegistrationPage.enterPosition(position, driver);

			testSteps.add("Step " + (++i) + " : Select <b>'Position Accountant'</b>");
			kycRegistrationPage.selectPositionAccountant(driver);

			testSteps.add("Step " + (++i) + " : Enter Company Name :  <b>'" + company + "'</b>");
			kycRegistrationPage.enterCompanyName(company, driver);

			testSteps.add("Step " + (++i) + " : Enter Company City :  <b>" + city + "'</b>");
			kycRegistrationPage.enterCompanyCity(city, driver);

			scrollDown(driver);
			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add("Step " + (++i)
					+ " : Check on <b>'My family member or I am a political exposed person or a public official'</b>");
			kycRegistrationPage.checkPublicOfficialOption(driver);

			testSteps.add("Step " + (++i) + " : Enter Public Official Name :  <b>'" + invalidString + "'</b>");
			kycRegistrationPage.enterPublicOfficialName(invalidString, driver);

			testSteps.add("Step " + (++i) + " : UnCheck on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Error message on invalid Public official name'</b> is present");
			assertTrue(kycRegistrationPage.isPublicOfficialNameErrorMessagePresent(driver),
					"Verified <b>'Error message on invalid Public official name'</b> is present");

			testSteps.add("Step " + (++i) + " : Enter Public Official Name :  <b>'" + invalidString_2 + "'</b>");
			kycRegistrationPage.enterPublicOfficialName(invalidString_2, driver);

			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Error message on invalid Public official name'</b> is present");
			assertTrue(kycRegistrationPage.isPublicOfficialNameErrorMessagePresent(driver),
					"Verified <b>'Error message on invalid Public official name'</b> is present");

			testSteps.add("Step " + (++i) + " : Enter Public Official Name :  <b>" + validString + "'</b>");
			kycRegistrationPage.enterPublicOfficialName(validString, driver);

			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add(
					"Step " + (++i) + " : Verify <b>'Error message on valid Public official name is'</b> not present");
			assertFalse(kycRegistrationPage.isPublicOfficialNameErrorMessagePresent(driver),
					"Verified <b>'Error message on valid Public official name is'</b> not present");

			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add("Step " + (++i)
					+ " : Check on <b>'I am a director, officer, or at least a 10% stock owner of a US-listed public company'</b>");
			kycRegistrationPage.checkOnUSListedPublicCompanyOption(driver);

			testSteps.add("Step " + (++i) + " : Enter US Listed Public Company Name :  <b>'" + invalidString + "'</b>");
			kycRegistrationPage.enterUSListedPublicCompanyName(invalidString, driver);

			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Error message on invalid US Listed Public Company name'</b> is present");
			assertTrue(kycRegistrationPage.isUSListedPublicCompanyNameErrorMessagePresent(driver),
					"Verified <b>'Error message on invalid US Listed Public Company name'</b> is present");

			testSteps.add("Step " + (++i) + " : Enter US Listed Public Company Name :  <b>" + invalidString_2 + "</b>");
			kycRegistrationPage.enterUSListedPublicCompanyName(invalidString_2, driver);

			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Error message on invalid US Listed Public Company name'</b> is present");
			assertTrue(kycRegistrationPage.isUSListedPublicCompanyNameErrorMessagePresent(driver),
					"Verified <b>'Error message on invalid US Listed Public Company name'</b> is present");

			testSteps.add("Step " + (++i) + " : Enter US Listed Public Company Name :  <b>'" + validString + "'</b>");
			kycRegistrationPage.enterUSListedPublicCompanyName(validString, driver);

			testSteps.add("Step " + (++i) + " : Check on <b>'My family member or I work at a US brokerage firm'</b>");
			kycRegistrationPage.checkUSBrokerageFirmOption(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'Error message on valid US Listed Public Company name'</b> is not present");
			assertFalse(kycRegistrationPage.isUSListedPublicCompanyNameErrorMessagePresent(driver),
					"Verified <b>'Error message on valid US Listed Public Company name'</b> is not present");

			testSteps.add("Step " + (++i) + " : Check <b>'None of Above'</b>");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'My family member or I work at a US brokerage firm'</b> is disabled");
			assertTrue(kycRegistrationPage.isUSBrokerageFirmOptionDisabled(driver),
					"Verified <b>'My family member or I work at a US brokerage firm'</b> is disabled");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'My family member or I am a political exposed person or a public official'</b> is disabled");
			assertTrue(kycRegistrationPage.isPublicOptionDisabled(driver),
					"Verified <b>'My family member or I am a political exposed person or a public official'</b> is disabled");

			testSteps.add("Step " + (++i)
					+ " : Verify <b>'I am a director, officer, or at least a 10% stock owner of a US-listed public company'</b> is disabled");
			assertTrue(kycRegistrationPage.isUSListedPublicCompanyOptionDisabled(driver),
					"Verified <b>'I am a director, officer, or at least a 10% stock owner of a US-listed public company</b> is disabled");

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("KYCNegative_NonAadhar", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: KYCNegative_NonAadhar " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYCNegative_NonAadhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCNegative_NonAadhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: KYCNegative_NonAadhar " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("KYCNegative_NonAadhar") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("KYCNegative_NonAadhar", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 5)
	public void UpdatedKYCWithNonAadharCard() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("UpdatedKYCWithNonAadharCard:" + driver.hashCode() + "", driver);
		Object[][] loginSheet = getData(testDataFile, testDataSheet, driver);
		String appPassword = loginSheet[rowIndex][0].toString();
		Object[][] dataArr = getData(testDataFile, KYC_NonAdaarReg, driver);

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-68?atlOrigin=eyJpIjoiNGJmYjI2YzIyYzk2NDgwMGIyZmFjMjQyMTA1OTE2MWEiLCJwIjoiaiJ9\">QAA-68 : [KYC Registration] for the Non Aadhar Indian Residents<a/>");

		String fullName = dataArr[rowIndex][0].toString();
		String phoneNumber = dataArr[rowIndex][3].toString();
		String panCardFileName = imagePath + dataArr[rowIndex][4].toString();
		String aadhaarCardFileName = imagePath + dataArr[rowIndex][5].toString();
		String address1 = dataArr[rowIndex][6].toString();
		String address2 = dataArr[rowIndex][7].toString();
		String city = dataArr[rowIndex][8].toString();
		String pinCode = dataArr[rowIndex][9].toString();
		String state = dataArr[rowIndex][10].toString();

		String kycApproved = "KYC | Vested Finance";
		String email = "vested.automation+w0100202@gmail.com";
		String password = "#TestUser12";
		String panCard = "BNZPM2501F";

		int i = 0;
		try {
			loginPage.loginToApp(email, password, driver);
//			testSteps.add("Step " + (++i) + " : Navigate to app url : "
//					+ PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
//			navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
//			String email = getUniqueEmailId(dataArr[rowIndex][1].toString(), driver, 3);
//
//			testSteps.add("Step " + (++i) + " : Enter app <b>'Password'</b>");
//			loginPage.enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'submit'</b>");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Sign up'</b> with email Button");
//			loginPage.clickOnSignUpWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter <b>'Password'</b> ");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Sign Up'</b> Button");
//			loginPage.clickOnSubmitButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Verification'</b> code screen is displaying");
//			assertTrue(loginPage.verifyOTPScreenDisplaying(driver),
//					"Verified <b>'Verification code'</b> screen is displaying");
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
//			loginPage.clickOnLoginPageButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login with Email'</b>");
//			loginPage.clickOnloginWithEmail(driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Email Address : <b>'" + email + "</b>");
//			loginPage.enterB2BUserEmailAddress(email, driver);
//
//			testSteps.add("Step " + (++i) + " : Enter Password : <b>'" + password + "'</b>");
//			loginPage.enterB2BUserPassword(password, driver);
//
//			testSteps.add("Step " + (++i) + " : Click on <b>'Login'</b> Button");
//			loginPage.clickOnLoginButton(driver);
//
//			testSteps.add("Step " + (++i) + " : Verify <b>'Explore Platform'</b> button is displaying");
//			assertTrue(loginPage.verifyExplorePlatformButtonIsDisplaying(driver),
//					"Verified <b>'Explore Platform'</b> button is displaying");

			testSteps.add("Step " + (++i) + " : Verify 'Start KYC' button is displaying");
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver),
					"Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

				for (int count = 1; count <= 2; count++) {
					kycRegistrationPage.clickOnPreviousButton(driver);
				}
				testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");


			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> primarily file taxes country");
			kycRegistrationPage.selectTaxResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Choose <b>'India'</b> nationality country");
			kycRegistrationPage.selectResidencyCountry(driver, "India");

			testSteps.add("Step " + (++i) + " : Click on <b>'Male Gender'</b>");
			kycRegistrationPage.clickOnMaleGender(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Single Marital Status'</b>");
			kycRegistrationPage.clickOnSingle_Marital(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Retired'</b>");
			kycRegistrationPage.clickOnRetiredStatus(driver);

			testSteps.add("Step " + (++i) + " : Check <b>'None of Above'</b>");
			kycRegistrationPage.checkNoneofAboveOption(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			testSteps.add("Step " + (++i) + " : <b>'Fill Questionnaire'</b>");
			kycRegistrationPage.fillQuestionnaire(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
			kycRegistrationPage.clickOnNextButton(driver);

			try {
				waitfor10sec();
				kycRegistrationPage.clickOnNoButtonForMobile(driver);
				testSteps.add("Step " + (++i)
						+ " : Selecting <b>'No'</b> in <b>'Is your mobile number linked with Aadhaar?'</b>");
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				kycRegistrationPage.clickOnProcessedButton(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

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

//			testSteps.add("Step " + (++i) + " : Click On <b>'Upload PAN CARD'</b> button");
//			kycRegistrationPage.clickOnUploadPanCard_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : Click On Upload PAN CARD pop up <b>'Confirm'</b> button");
//			kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//			testSteps.add("Step " + (++i) + " : <b>'Upload file'</b>");
//			kycRegistrationPage.uploadfile(panCardFileName, driver);
//
//			testSteps.add("Step " + (++i) + " : <b>'Upload Button'</b>");
//			kycRegistrationPage.clickOnUpload_Button(driver);

			if (!kycRegistrationPage.isTextDisplaying(driver, "Proof of Address: Aadhaar uploaded.")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Upload Aadhar'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isUploadAadharCardButtonDisplaying(driver),"'Upload Aadhar' button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Upload Aadhar'</b> button is Displaying");
				
//				testSteps.add("Step " + (++i) + " : Click On <b>'Upload Aadhaar Card'</b> button");
//				kycRegistrationPage.clickOnUploadAadhaarCard_Button(driver);
//
//				testSteps.add("Step " + (++i) + " : Click On Upload Aadhaar card pop up <b>'Confirm'</b> button");
//				kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//				testSteps.add("Step " + (++i) + " : <b>'Upload file'</b>");
//				kycRegistrationPage.uploadfile(aadhaarCardFileName, driver);
			}

//			testSteps.add("Step " + (++i) + " : <b>'Upload Button'</b>");
//			kycRegistrationPage.clickOnUpload_Button(driver);

//			testSteps.add("Step " + (++i) + " : Enter <b>'Address Information'</b>");
//			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : <b>'Confirm Checkbok'</b>");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
//			kycRegistrationPage.clickOnNextButton(driver);

//			try {
//				testSteps.add("Step " + (++i) + " :Selecting <b>'All Access'</b> Account Type");
//				kycRegistrationPage.clickOnAllAccessAccount(driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Proceed All Access Account Type'</b>");
//				kycRegistrationPage.clickOnProceedAllAccessAccount(driver);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>'Select a subscription plan'</b> page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that <b>'Select a plan that suits you best'</b> page is displaying");
//
//			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				try {
//					testSteps.addAll(kycRegistrationPage.SelectBasicPlan(driver, phoneNumber));
//				} catch (Exception e) {
//					testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
//					kycRegistrationPage.clickOnNextButton(driver);
//				}
//
//				try {
//
//					kycRegistrationPage.clickOnViewDetails(driver);
//					testSteps.add("Step " + (++i) + " : Click on <b>'View Details'</b>");
//
//					testSteps.addAll(kycRegistrationPage.verifyDefaultSelectedButtons(driver));
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information'</b>");
//				kycRegistrationPage.clickOnTaxFormInformation(driver);
//
//				testSteps.add("Verifying 'TaxFormInformation' Pop Up Modal is Displaying");
//				assertTrue(kycRegistrationPage.isTaxFormInformationModal(driver),
//						"Failed:'TaxFormInformation' Pop Up Modal is not Displaying");
//				testSteps.add("Verified: 'TaxFormInformation' Pop Up Modal is Displaying");
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information' Close Icon</b>");
//				kycRegistrationPage.clickOnTaxFormInformationModalClose(driver);
//
//				testSteps.add(
//						"Step " + (++i) + " : Click on <b>'DriveWealth�s Disclosures and Account Agreements'</b>");
//				kycRegistrationPage.clickOnDisclosureAgreement(driver);
//
//				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs2.get(1));
//
//				testSteps.add("Verifying 'Disclosure Agreement' Page Heading  is Displaying");
//				assertTrue(kycRegistrationPage.isDisclosureAgreementPageHeading(driver),
//						"Failed:'Disclosure Agreement' Page Heading is not Displaying");
//				testSteps.add("Verified: 'Disclosure Agreement' Page Heading is Displaying");
//
//				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(0));
//				closeTab(1, driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement'</b>");
//				kycRegistrationPage.clickOnEsignAgreement(driver);
//
//				testSteps.add("Verifying 'Esign' Pop Up Modal is Displaying");
//				assertTrue(kycRegistrationPage.isEsignModal(driver), "Failed:'Esign' Pop Up Modal is not Displaying");
//				testSteps.add("Verified: 'Esign' Pop Up Modal is Displaying");
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement' Modal Close Icon</b>");
//				kycRegistrationPage.clickOnesignModalCloseIcon(driver);
//
////			testSteps.add("Step " + (++i) + " : Click on <b>'Advisory Agreement'</b>");
////			kycRegistrationPage.clickOnAdvisoryAgreement(driver);
////			
////			tabs = new ArrayList<String>(driver.getWindowHandles());
////			driver.switchTo().window(tabs.get(1));
////			
////			
////			
////			testSteps.add("Verifying 'Advisory Agreement' Page  is Displaying");
////			assertTrue(driver.getCurrentUrl().contains("vested-advisory-agreement"),"Failed:'Advisory Agreement' Page is not Displaying");
////			testSteps.add("Verified: 'Advisory Agreement' Page is Displaying");
////			
////			
////			tabs = new ArrayList<String>(driver.getWindowHandles());
////			driver.switchTo().window(tabs.get(0));
////			closeTab(1, driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'DriveWealth�s Privacy Policy'</b>");
//				kycRegistrationPage.clickOnPrivacyPolicy(driver);
//
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(1));
//
//				testSteps.add("Verifying 'DriveWealth�s Privacy Policy' Page  is Displaying");
//				assertTrue(kycRegistrationPage.isprivacyPolicyPageHeadingDisplaying(driver),
//						"Failed:'DriveWealth�s Privacy Policy' Page is not Displaying");
//				testSteps.add("Verified: 'DriveWealth�s Privacy Policy' Page is Displaying");
//
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(0));
//				closeTab(1, driver);
//
//				try {
//					kycRegistrationPage.checkVfsAgreementCheckbox(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Vfs Agreement'</b> Checkbox");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					kycRegistrationPage.checkCrsAgreementCheckbox(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Crs Agreement'</b> Checkbox");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					kycRegistrationPage.clickOnEnrollSocityYes(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Enroll In Society'</b> Yes Button");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				testSteps.add("Step " + (++i) + " : click on <b>'I Agree'</b> Checkbok");
//				kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//				testSteps.add("Step " + (++i) + " : Enter Full name :  <b>'" + fullName + "'</b>");
//				kycRegistrationPage.enterYourFullName(fullName, driver);
//
//				kycRegistrationPage.clickOnThirdCheckbox(driver);

//				testSteps.add("Step " + (++i) + " : Click on <b>'Done Button'</b>");
//				kycRegistrationPage.clickOnDoneButton(driver);
//
//				testSteps.add("Step " + (++i)
//						+ " : Verify that <b>'Complete 3 simple steps to start investing in US stocks and ETFs'</b> page is displaying");
//				assertTrue(kycRegistrationPage.verifyKycApprovedTitleIsDisplaying(driver),
//						"Verified that <b>'Complete 3 simple steps to start investing in US stocks and ETFs'</b> page is displaying");
//		}
			

			testSteps.add("Step " + (++i) + " : Close the <b>'Browser'</b>");
			AddTest_IntoReport("UpdatedKYCWithNonAadharCard", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: UpdatedKYCWithNonAadharCard " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("UpdatedKYCWithNonAadharCard") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("UpdatedKYCWithNonAadharCard", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: UpdatedKYCWithNonAadharCard " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("UpdatedKYCWithNonAadharCard") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("UpdatedKYCWithNonAadharCard", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 6)
	public void NonIndianNationality_IndianTaxResidency_KYC() {
		ArrayList<String> testSteps = new ArrayList<>();
		WebDriver driver = null;
		LoginPage loginPage;
		KYCRegistrationPage kycRegistrationPage;
		driver = initConfiguration();

		loginPage = new LoginPage(driver);
		kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("NonIndianNationality_IndianTaxResidency_KYC: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String appPassword = dataArr[rowIndex][0].toString();

		testSteps.add(
				"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-661?atlOrigin=eyJpIjoiMThlZTA3NzlmMWJhNDcxYWE3ODgyZmM3NDljYmJjODQiLCJwIjoiaiJ9\">QAA-661 : [Web] - KYC Verification For User With Non-Indian Natonality and Indian Tax Residence<a/>");

		String password = "#TestUser12";
		String country = "India";
		String countryNationality = "United States of America";
		String filepath = imagePath + "PassportImage.PNG";
		String passportfileno = "BP4063972871419";
		String fullName = "Mohit Singh Chahar";
		String phoneNumber = "0987654321";
		String panCardFileName = imagePath + "pan_card.jpg";
		String aadhaarCardFileName = imagePath + "aadhaar_card.jpg";
		String address1 = "Address1";
		String address2 = "Address2";
		String city = "Alaska";
		String pinCode = "268643";
		String state = "Andhra Pradesh";
		String email ="vested.automation+w01003@gmail.com";
		String panCard = "BNZPM2501F";

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
			assertTrue(kycRegistrationPage.isStartKYCButtonDisplaying(driver),
					"Verified 'Start KYC' button is displaying");

			testSteps.add("Step " + (++i) + " : Click on 'Start KYC'");
			kycRegistrationPage.clickOnStartKYC(driver);

			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

			for (int count = 1; count <= 3; count++) {
				kycRegistrationPage.clickOnPreviousButton(driver);
			}
			testSteps.add("Step " + (++i) + " : Click on 'Previous' Button untill KYC start screen");
			try {
				testSteps.add("Step " + (++i) + " : Click on 'ACCEPT AND CONTINUE'");
				kycRegistrationPage.clickAcceptAndContinue_button(driver);
				for (int count = 1; count <= 2; count++) {kycRegistrationPage.clickOnPreviousButton(driver);}
			} catch (Exception e) {
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

			try {
				waitfor10sec();
				kycRegistrationPage.clickOnNoButtonForMobile(driver);
				testSteps.add("Step " + (++i)
						+ " : Selecting <b>'No'</b> in <b>'Is your mobile number linked with Aadhaar?'</b>");
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				kycRegistrationPage.clickOnProcessedButton(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}

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


			if (!kycRegistrationPage.isTextDisplaying(driver, "Proof of Address: Aadhaar uploaded.")) {
				testSteps.add("Step " + (++i) + " : Verifying <b>'Upload Aadhar'</b> button is Displaying");
				assertTrue(kycRegistrationPage.isUploadAadharCardButtonDisplaying(driver),"'Upload Aadhar' button is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: <b>'Upload Aadhar'</b> button is Displaying");
				
//				testSteps.add("Step " + (++i) + " : Click On <b>'Upload Aadhaar Card'</b> button");
//				kycRegistrationPage.clickOnUploadAadhaarCard_Button(driver);
//
//				testSteps.add("Step " + (++i) + " : Click On Upload Aadhaar card pop up <b>'Confirm'</b> button");
//				kycRegistrationPage.clickOnUploadPassportConfirm_Button(driver);
//
//				testSteps.add("Step " + (++i) + " : <b>'Upload file'</b>");
//				kycRegistrationPage.uploadfile(aadhaarCardFileName, driver);
			}
//
//
//			testSteps.add("Step " + (++i) + " : Enter <b>'Address Information'</b>");
//			testSteps.addAll(kycRegistrationPage.enterAddressDetails(address1, address2, city, state, pinCode, driver));

			testSteps.add("Step " + (++i) + " : <b>'Confirm Checkbok'</b>");
			kycRegistrationPage.clickOnIConfirmCheckbox(driver);

//			testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
//			kycRegistrationPage.clickOnNextButton(driver);
//
//			try {
//				testSteps.add("Step " + (++i) + " :Selecting <b>'All Access'</b> Account Type");
//				kycRegistrationPage.clickOnAllAccessAccount(driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Proceed All Access Account Type'</b>");
//				kycRegistrationPage.clickOnProceedAllAccessAccount(driver);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			testSteps.add("Step " + (++i) + " : Verify that <b>'Select a subscription plan'</b> page is displaying");
//			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
//					"Verified that <b>'Select a plan that suits you best'</b> page is displaying");

//			if (!PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("pre-prod")) {
//				try {
//					testSteps.addAll(kycRegistrationPage.SelectBasicPlan(driver, phoneNumber));
//				} catch (Exception e) {
//					testSteps.add("Step " + (++i) + " : Click on <b>'Next Button'</b>");
//					kycRegistrationPage.clickOnNextButton(driver);
//				}
//
//				try {
//
//					kycRegistrationPage.clickOnViewDetails(driver);
//					testSteps.add("Step " + (++i) + " : Click on <b>'View Details'</b>");
//
//					testSteps.addAll(kycRegistrationPage.verifyDefaultSelectedButtons(driver));
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information'</b>");
//				kycRegistrationPage.clickOnTaxFormInformation(driver);
//
//				testSteps.add("Verifying 'TaxFormInformation' Pop Up Modal is Displaying");
//				assertTrue(kycRegistrationPage.isTaxFormInformationModal(driver),
//						"Failed:'TaxFormInformation' Pop Up Modal is not Displaying");
//				testSteps.add("Verified: 'TaxFormInformation' Pop Up Modal is Displaying");
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'Tax Form Information' Close Icon</b>");
//				kycRegistrationPage.clickOnTaxFormInformationModalClose(driver);
//
//				testSteps.add(
//						"Step " + (++i) + " : Click on <b>'DriveWealth�s Disclosures and Account Agreements'</b>");
//				kycRegistrationPage.clickOnDisclosureAgreement(driver);
//
//				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs2.get(1));
//
//				testSteps.add("Verifying 'Disclosure Agreement' Page Heading  is Displaying");
//				assertTrue(kycRegistrationPage.isDisclosureAgreementPageHeading(driver),
//						"Failed:'Disclosure Agreement' Page Heading is not Displaying");
//				testSteps.add("Verified: 'Disclosure Agreement' Page Heading is Displaying");
//
//				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(0));
//				closeTab(1, driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement'</b>");
//				kycRegistrationPage.clickOnEsignAgreement(driver);
//
//				testSteps.add("Verifying 'Esign' Pop Up Modal is Displaying");
//				assertTrue(kycRegistrationPage.isEsignModal(driver), "Failed:'Esign' Pop Up Modal is not Displaying");
//				testSteps.add("Verified: 'Esign' Pop Up Modal is Displaying");
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'ESIGN Agreement' Modal Close Icon</b>");
//				kycRegistrationPage.clickOnesignModalCloseIcon(driver);
//
//				testSteps.add("Step " + (++i) + " : Click on <b>'DriveWealth�s Privacy Policy'</b>");
//				kycRegistrationPage.clickOnPrivacyPolicy(driver);
//
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(1));
//
//				testSteps.add("Verifying 'DriveWealth�s Privacy Policy' Page  is Displaying");
//				assertTrue(kycRegistrationPage.isprivacyPolicyPageHeadingDisplaying(driver),
//						"Failed:'DriveWealth�s Privacy Policy' Page is not Displaying");
//				testSteps.add("Verified: 'DriveWealth�s Privacy Policy' Page is Displaying");
//
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				driver.switchTo().window(tabs.get(0));
//				closeTab(1, driver);
//
//				try {
//					kycRegistrationPage.checkVfsAgreementCheckbox(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Vfs Agreement'</b> Checkbox");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					kycRegistrationPage.checkCrsAgreementCheckbox(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Crs Agreement'</b> Checkbox");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					kycRegistrationPage.clickOnEnrollSocityYes(driver);
//					testSteps.add("Step " + (++i) + " : click on <b>'Enroll In Society'</b> Yes Button");
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				testSteps.add("Step " + (++i) + " : click on <b>'I Agree'</b> Checkbok");
//				kycRegistrationPage.clickOnIAgreeCheckbox(driver);
//
//				testSteps.add("Step " + (++i) + " : Enter Full name :  <b>'" + fullName + "'</b>");
//				kycRegistrationPage.enterYourFullName(fullName, driver);
//
//				kycRegistrationPage.clickOnThirdCheckbox(driver);
//
//			}

			testSteps.add("Step " + (++i) + " : Close the Browser");
			AddTest_IntoReport("NonIndianNationality_IndianTaxResidency_KYC", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: NonIndianNationality_IndianTaxResidency_KYC " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("NonIndianNationality_IndianTaxResidency_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("NonIndianNationality_IndianTaxResidency_KYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: NonIndianNationality_IndianTaxResidency_KYC " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("NonIndianNationality_IndianTaxResidency_KYC") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("NonIndianNationality_IndianTaxResidency_KYC", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
