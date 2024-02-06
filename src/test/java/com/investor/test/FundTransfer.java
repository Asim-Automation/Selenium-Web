package com.investor.test;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.investor.pages.KYCRegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.listeners.RetryListener;
import com.investor.pages.FundTransferPage;
import com.investor.pages.LoginPage;

public class FundTransfer extends BaseClass {

	String tempSrc = "";

	@Test(priority = 6)
	public void FundsTransfer() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("FundsTransfer: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-55?atlOrigin=eyJpIjoiYWQ0ZWI0MTI0ZGUwNGUzMGE1MmZkN2Y1M2ExMjVkNTgiLCJwIjoiaiJ9\">QAA-55 : Web - Verify that user is able to initiate fund transfer<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			fundTransferPage.clickOnBtnTransfer(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);
			try {
				waitfor3sec();
				testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
				assertTrue(fundTransferPage.isAddFundModalMessage(driver),
						"Verified <b>'Add Funds'</b> popup Heading is showing");
			} catch (Exception e) {
				testSteps.add("Step " + (++i) + " : Verify <b>'Add USD'</b> message is showing");
				waitTime(2500);
				assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
						"Verified <b>'Add USD'</b> message is showing");
				assertEquals(fundTransferPage.getAddFundModalMessage(driver), addFundModalMessage,
						"Failed : <b>'Add USD'</b> message is not showing");
			}

			testSteps.add("Step " + (++i) + " : Close the <b>'Modal'</b>");
			fundTransferPage.closeModal(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Withdraw Fund'</b> button");
			fundTransferPage.clickOnWithdrawFundBtn(driver);

			testSteps.add("Step " + (++i) + " : Verify <b>'Amount to withdraw'</b> label is displaying");
			assertTrue(fundTransferPage.isAmountToWithdrawLabelDisplaying(driver),
					"Verified <b>'Amount to withdraw'</b> label is displayed");

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("FundsTransfer", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: FundsTransfer " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("FundsTransfer") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("FundsTransfer", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: FundsTransfer " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("FundsTransfer") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("FundsTransfer", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

//Commented due to obsolete	test
//	@Test(priority = 5)
	public void Verify_CompleteAddFund_ICICIBank() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		Object[][] dataArr = getData(testDataFile, "CompleteAddFund_ICICIBank", driver);
		String bank = dataArr[0][0].toString();
		String amount = dataArr[0][1].toString().replace(".0", "");
		driver = initConfiguration();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		String filePath = excelFilePath + "download.pdf";
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("Verify_CompleteAddFund_ICICBank: " + driver.hashCode() + "", driver);

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-224?atlOrigin=eyJpIjoiNzY5N2EyOWI1NjE4NDMxOGIyOWI1ZmUwYzQwYmJiZGMiLCJwIjoiaiJ9\">QAA-224 : Web - [Add Funds]Complete the Add Funds for ICICI bank<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Clicking on 'Transfer Tab'");
			fundTransferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Add Fund' Button");
			fundTransferPage.clickOnBtnAddFund(driver);

			try {
				testSteps.add("Step " + (++i) + " : Clicking on 'Switch Bank' Button");
				fundTransferPage.clickOnSwitchBankButton(driver);
			} catch (Exception e) {
				fundTransferPage.closeAddFundGuide(driver);
			}

			testSteps.add("Step " + (++i) + " : Enter 'Search Bank'");
			fundTransferPage.enterSearchBank(bank, driver);

			testSteps.add("Step " + (++i) + " : Verifying 'ICICI Bank Image' is present");
			assertTrue(fundTransferPage.isICICIBankImagePresent(driver), "Verified 'ICICI Bank Image' is present");

			testSteps.add("Step " + (++i) + " : Clicking on 'ICICI Bank'");
			fundTransferPage.clickOnICICIBank(driver);

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amount, driver);

			testSteps.add("Step " + (++i) + " : Verifying 'ICICI Bank Transfer From' is Disabled");
			assertTrue(fundTransferPage.isICICIBankTransferFromDisabled(driver),
					"Verified 'ICICI Bank Transfer From' is Disabled");

			testSteps.add("Step " + (++i) + " : Clicking on 'NEXT' button");
			fundTransferPage.clickOnNEXTButton(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
			fundTransferPage.clickOnDownloadInstructionButton(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));

			testSteps.add("Step " + (++i) + " : Verifying 'Previous' is Present");
			assertTrue(fundTransferPage.isPreviousPresent(driver), "Verified 'Previous' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Continue Later' is Present");
			assertTrue(fundTransferPage.isContinueLaterPresent(driver), "Verified 'Continue Later' is Present");

			testSteps.add("Step " + (++i) + " : Clicking on 'NEXT' button");
			fundTransferPage.clickOnNEXTButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Bank Name' is Present");
			assertTrue(fundTransferPage.isBankNamePresent(driver), "Verified 'Bank Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Amount Transferred In USD' is Present");
			assertTrue(fundTransferPage.isAmountTransferredInUSDPresent(driver),
					"Verified 'Amount Transferred In USD' is Present");

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(date, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			try {
				fundTransferPage.uploadFile(filePath, driver);
				testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
			} catch (Exception e) {
				fundTransferPage.uploadFile(filePath, driver);
				testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
			}

			if (!(driver.getCurrentUrl().contains("prod"))) {
				waitTime(5000);
				testSteps.add("Step " + (++i) + " : Clicking on 'Submit' button");
				fundTransferPage.clickOnSubmitButton(driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Back To Dashboard' button");
				fundTransferPage.clickOnBackToDashboardButton(driver);
			}
			AddTest_IntoReport("Verify_CompleteAddFund_ICICIBank", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Verify_CompleteAddFund_ICICIBank " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_CompleteAddFund_ICICIBank") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteAddFund_ICICIBank", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Verify_CompleteAddFund_ICICIBank " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_CompleteAddFund_ICICIBank") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteAddFund_ICICIBank", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 7, groups = "CashRequired")
	public void Verify_Withdraw_OTPValidationMessage() {
		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		FundTransferPage fundTransferPage = new FundTransferPage(driver);
		KYCRegistrationPage kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("Verify_Withdraw_OTPValidationMessage: " + driver.hashCode() + "", driver);

		String amountGreaterThanBalance = "1000000000000";
		String zeroAmount = "0.0";
		String correctAmount = "50";
		String accountNumber = generateRandomNumberWithGivenNumberOfDigits(10, driver);
		String swiftCode = generateRandomNumberWithGivenNumberOfDigits(5, driver);
		String zipCode = generateRandomNumberWithGivenNumberOfDigits(5, driver);
		String name = "abc";
		String accountType = "Current";
		String country = "Greece";
		String country2 = "Armenia";
		String state = "Jomala";
		int step = 1;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-342?atlOrigin=eyJpIjoiNjk0ODRjZTY1NGQ3NDUzMGIwZTQ3ZmEyZmM2YTQ4YzEiLCJwIjoiaiJ9\">QAA-342 : Web - Verify withdraw funds OTP Validation Message.<a/>");
			testSteps.add("Step " + step + " : Visit and login application");
			testSteps.addAll(lp.loginToApp(driver));

			testSteps.add("Step " + (++step) + " : Clicking on 'Transfer Tab'");
			fundTransferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Withdraw Fund' Button");
			fundTransferPage.clickOnWithdrawFundBtn(driver);

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + "");
			fundTransferPage.enterWithdrawAmount("", driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
			fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Withdrawal Amount is required.' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Withdrawal Amount is required.' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + "");
			fundTransferPage.enterWithdrawAmount("", driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Withdrawal Amount is required.' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Withdrawal Amount is required.' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + amountGreaterThanBalance);
			fundTransferPage.enterWithdrawAmount(amountGreaterThanBalance, driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
			fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step)
					+ " : Verifying 'Please enter no more than the amount available for withdrawal.' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Please enter no more than the amount available for withdrawal.' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + zeroAmount);
			fundTransferPage.enterWithdrawAmount(zeroAmount, driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Withdrawal Amount must be greater than 0' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Withdrawal Amount must be greater than 0' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + correctAmount);
			fundTransferPage.enterWithdrawAmount(correctAmount, driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
			fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Name: '" + name);
			fundTransferPage.enterBeneficiaryName(name, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Account Number: '" + accountNumber);
			fundTransferPage.enterBeneficiaryAccountNumber(accountNumber, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Retype Account Name: '" + accountNumber);
			fundTransferPage.enterRetypeAccountNumber(accountNumber, driver);

			testSteps.add("Step " + (++step) + " : Select 'Account Type: '" + accountType);
			fundTransferPage.selectAccountType(accountType, driver);

			testSteps.add("Step " + (++step) + " : Enter 'SWIFT Code: '" + swiftCode);
			fundTransferPage.enterSwiftCode(swiftCode, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Retype SWIFT Code: '" + swiftCode);
			fundTransferPage.enterRetypeSwiftCode(swiftCode, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank Name: '" + name);
			fundTransferPage.enterBeneficiaryBankName(name, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank Address: '" + name);
			fundTransferPage.enterBeneficiaryBankAddress(name, driver);

			try {
				fundTransferPage.selectBankCountry(country, driver);
				testSteps.add("Step " + (++step) + " : Select ' Bank Country: '" + country);
			} catch (Exception e) {
				fundTransferPage.selectBankCountry(country2, driver);
				testSteps.add("Step " + (++step) + " : Select ' Bank Country: '" + country2);
			}

			testSteps.add("Step " + (++step) + " : Select ' Bank State: '" + state);
			fundTransferPage.selectBeneficiaryBankProvince(state, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank City: '" + name);
			fundTransferPage.enterBeneficiaryBankCity(name, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank Zip Code: '" + zipCode);
			fundTransferPage.enterBeneficiaryBankZipCode(zipCode, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				waitTime(5000);
				testSteps.add("Step " + (++step) + " : Clicking on 'Continue' Button");
				fundTransferPage.clickOnContinueButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'OTP page' is present");
				assertTrue(fundTransferPage.isOTPPagePresent(driver), "Failed: 'OTP page' is present");
				testSteps.add("Step " + (++step) + " : Verified: 'OTP page' is present");

				testSteps.add("Step " + (++step) + " : Enter Pin : <b>111111</b>");
				fundTransferPage.enterValidationPin(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'Invalid OTP Error Message' is present");
				assertTrue(fundTransferPage.isInvalidOTPMessagePresent(driver),
						"Failed: 'Invalid OTP Error Message' is present");
				testSteps.add("Step " + (++step) + " : Verified: 'Invalid OTP Error Message' is present");

			}

			AddTest_IntoReport("Verify_Withdraw_OTPValidationMessage", testSteps, driver);
		} catch (Exception e) {

			testSteps
					.add("Failed: Verify_Withdraw_OTPValidationMessage " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_Withdraw_OTPValidationMessage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_Withdraw_OTPValidationMessage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Verify_Withdraw_OTPValidationMessage " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_Withdraw_OTPValidationMessage") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_Withdraw_OTPValidationMessage", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	// Commented due to obsolete test
//	@Test(priority = 8)
	public void NegetiveValidation_AddFunds() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("NegetiveValidation_AddFunds: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String submissionDateAfterToday = getDate(3, "dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String bankReceiptFileNameExcel = excelFilePath + "testData.xlsx";
		String bankReceiptFileNameJson = excelFilePath + "credentials.json";
		String bankReceiptFileNameMoreThan10MB = excelFilePath + "10mbPDFFile.pdf";
		String negetiveAmount = "-12";
		String alphabet = "aaaaaaa";
		String characters = "!@#$%^&*(";
		String errorMessage = null;
		String[] banks = { "Non-Indian Bank", "Other Indian Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-433?atlOrigin=eyJpIjoiYWZjZDkwYzVkMjIzNGE3MGFlNmYyMmIzZTZkZGFhNWMiLCJwIjoiaiJ9\">QAA-433.1 : Negetive - Web - NegetiveValidation_AddFunds<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			fundTransferPage.clickOnBtnTransfer(driver);

			for (int a = 0; a < banks.length; a++) {
				String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
				testSteps.add("<b>*************For " + banks[a] + "*************</b>");

				testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
				fundTransferPage.clickOnBtnAddFund(driver);
				try {
					waitfor3sec();
					testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
					assertTrue(fundTransferPage.isAddFundModalMessage(driver),
							"Verified <b>'Add Funds'</b> popup Heading is showing");
				} catch (Exception e) {
					testSteps.add("Step " + (++i)
							+ " : Verify <b>'How US fund transfers work with Vested?'</b> message is showing");
					waitTime(2500);
					assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
							"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
					assertEquals(fundTransferPage.getAddFundModalMessage(driver), addFundModalMessage,
							"Failed : <b>'How US fund transfers work with Vested?'</b> message is not showing");
				}

				testSteps.add("Step " + (++i) + " :Click On 'Switch Bank'");
				fundTransferPage.clickOnSwitchBankButton(driver);

				testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
				fundTransferPage.clickOnBank(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Enter Negetive Amount To Transfer Amount :" + negetiveAmount);
				fundTransferPage.enterAmountToTransfer(driver, negetiveAmount);

				testSteps.add("Step " + (++i) + " :Verifying Error Message is Displaying");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver), "Error Message is not Diplaying");
				errorMessage = fundTransferPage.getErrorMessage(driver);
				testSteps
						.add("Step " + (++i) + " :Verified: <b>'" + errorMessage + "'</b> Error Message is Displaying");

				testSteps.add("Step " + (++i) + " :Enter Alphabet To Transfer Amount:" + alphabet);
				fundTransferPage.enterAmountToTransfer(driver, alphabet);

				testSteps.add("Step " + (++i) + " :Verifying Error Message is Displaying");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver), "Error Message is not Diplaying");
				errorMessage = fundTransferPage.getErrorMessage(driver);
				testSteps
						.add("Step " + (++i) + " :Verified: <b>'" + errorMessage + "'</b> Error Message is Displaying");

				testSteps.add("Step " + (++i) + " :Enter Characters To Transfer Amount:" + characters);
				fundTransferPage.enterAmountToTransfer(driver, characters);

				testSteps.add("Step " + (++i) + " :Verifying Error Message is Displaying");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver), "Error Message is not Diplaying");
				errorMessage = fundTransferPage.getErrorMessage(driver);
				testSteps
						.add("Step " + (++i) + " :Verified: <b>'" + errorMessage + "'</b> Error Message is Displaying");

				testSteps.add("Step " + (++i) + " :Enter Amount To Transfer :" + amountToTransfer);
				fundTransferPage.enterAmountToTransfer(driver, amountToTransfer);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " :Enter Bank Name :" + banks[a]);
				fundTransferPage.enterBankName(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Verifying The Error Message Of Blank 'Date On Wire Receipt' Field");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver),
						"Blank 'Date On Wire Receipt' Field Error Message Is Not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: The Error Message Of Blank 'Date On Wire Receipt' Field");

				testSteps.add("Step " + (++i) + " :Entering Submission Date");
				fundTransferPage.enterDate(driver, submissionDateAfterToday);

				String selectedDate = fundTransferPage.getSubmissionDate(driver);
				testSteps.add("Step " + (++i) + " :Verifying Upcoming Date is not selectable");
				assertTrue(selectedDate.equalsIgnoreCase(submissionDate), "Upcoming Date is selectable");
				testSteps.add("Step " + (++i) + " :Verified: Upcoming Date is not selectable");

				fundTransferPage.uploadFile(bankReceiptFileNameExcel, driver);
				testSteps.add("Step " + (++i) + " : Uploading 'Excel file'");

				testSteps.add("Step " + (++i) + " :Verifying InValid File Type Error Message is Displaying");
				assertTrue(fundTransferPage.isInvalidTypeErrorMessageDisplay(driver),
						"InValid File Type Error Message is not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: InValid File Type Error Message is Displaying");

				fundTransferPage.uploadFile(bankReceiptFileNameJson, driver);
				testSteps.add("Step " + (++i) + " : Uploading 'Json file'");

				testSteps.add("Step " + (++i) + " :Verifying InValid File Type Error Message is Displaying");
				assertTrue(fundTransferPage.isInvalidTypeErrorMessageDisplay(driver),
						"InValid File Type Error Message is not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: InValid File Type Error Message is Displaying");

				fundTransferPage.uploadFile(bankReceiptFileNameMoreThan10MB, driver);
				testSteps.add("Step " + (++i) + " : Upload 'pdf file more than 10MBs'");

				testSteps.add("Step " + (++i) + " :Verifying File Size Limit Exceed Error Message is Displaying");
				assertTrue(fundTransferPage.isSizeLimitErrorMessageDisplay(driver),
						"File Size Limit Exceed Error Message is not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: File Size Limit Exceed Error Message is Displaying");

				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}
				if (!(driver.getCurrentUrl().contains("prod"))) {

					testSteps.add("Step " + (++i) + " :Click On 'Submit'");
					fundTransferPage.clickOnSubmitButton(driver);

					testSteps.add("Step " + (++i) + " :Click On 'Back To Dashboard'");
					fundTransferPage.clickOnBackToDashboardButton(driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);

					testSteps.add("Step " + (++i) + " :Verifying Add fund request of '" + amountToTransfer + "'");
					assertTrue(fundTransferPage.isTrasactionPresent(driver, amountToTransfer),
							"Transaction of " + amountToTransfer + " is not found");

				} else {
					navigateToURL(DashboardUrl, driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);
				}
			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("NegetiveValidation_AddFunds", testSteps, driver);

		} catch (Exception e) {
//			AddTest_IntoReport("NegetiveValidation_AddFunds", testSteps, driver);
//			
			testSteps.add("Failed: NegetiveValidation_AddFunds " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("NegetiveValidation_AddFunds") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("NegetiveValidation_AddFunds", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
//			AddTest_IntoReport("NegetiveValidation_AddFunds", testSteps, driver);
//			
			testSteps.add("Failed: NegetiveValidation_AddFunds " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("NegetiveValidation_AddFunds") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("NegetiveValidation_AddFunds", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	// Commented due to obsolete test
//	@Test(priority = 9)
	public void ChangeOfFlow_AddFunds_DownloadInstruction() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("ChangeOfFlow_AddFunds_DownloadInstruction: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String submissionDateAfterToday = getDate(3, "dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String bankReceiptFileNameExcel = excelFilePath + "testData.xlsx";
		String bankReceiptFileNameJson = excelFilePath + "credentials.json";
		String bankReceiptFileNameMoreThan10MB = excelFilePath + "10mbPDFFile.pdf";
		String negetiveAmount = "-12";
		String alphabet = "aaaaaaa";
		String characters = "!@#$%^&*(";
		String errorMessage = null;
		String[] banks = { "Axis Bank", "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-433?atlOrigin=eyJpIjoiYWZjZDkwYzVkMjIzNGE3MGFlNmYyMmIzZTZkZGFhNWMiLCJwIjoiaiJ9\">QAA-433.2 : Negetive - Web - ChangeOfFlow_AddFunds_DownloadInstruction<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			fundTransferPage.clickOnBtnTransfer(driver);

			for (int a = 0; a < banks.length; a++) {
				String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
				testSteps.add("<b>*************For " + banks[a] + "*************</b>");

				testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
				fundTransferPage.clickOnBtnAddFund(driver);
				try {
					waitfor3sec();
					testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
					assertTrue(fundTransferPage.isAddFundModalMessage(driver),
							"Verified <b>'Add Funds'</b> popup Heading is showing");
				} catch (Exception e) {
					testSteps.add("Step " + (++i)
							+ " : Verify <b>'How US fund transfers work with Vested?'</b> message is showing");
					waitTime(2500);
					assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
							"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
					assertEquals(fundTransferPage.getAddFundModalMessage(driver), addFundModalMessage,
							"Failed : <b>'How US fund transfers work with Vested?'</b> message is not showing");
				}

				testSteps.add("Step " + (++i) + " :Click On 'Switch Bank'");
				fundTransferPage.clickOnSwitchBankButton(driver);

				testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
				fundTransferPage.clickOnBank(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Enter Negetive Amount To Transfer Amount :" + negetiveAmount);
				fundTransferPage.enterAmountToTransfer(driver, negetiveAmount);

				testSteps.add("Step " + (++i) + " :Verifying Error Message is Displaying");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver), "Error Message is not Diplaying");
				errorMessage = fundTransferPage.getErrorMessage(driver);
				testSteps
						.add("Step " + (++i) + " :Verified: <b>'" + errorMessage + "'</b> Error Message is Displaying");

				testSteps.add("Step " + (++i) + " :Enter Alphabet To Transfer Amount:" + alphabet);
				fundTransferPage.enterAmountToTransfer(driver, alphabet);

				testSteps.add("Step " + (++i) + " :Verifying Error Message is Displaying");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver), "Error Message is not Diplaying");
				errorMessage = fundTransferPage.getErrorMessage(driver);
				testSteps
						.add("Step " + (++i) + " :Verified: <b>'" + errorMessage + "'</b> Error Message is Displaying");

				testSteps.add("Step " + (++i) + " :Enter Characters To Transfer Amount:" + characters);
				fundTransferPage.enterAmountToTransfer(driver, characters);

				testSteps.add("Step " + (++i) + " :Verifying Error Message is Displaying");
				assertTrue(fundTransferPage.isErrorMessageDisplay(driver), "Error Message is not Diplaying");
				errorMessage = fundTransferPage.getErrorMessage(driver);
				testSteps
						.add("Step " + (++i) + " :Verified: <b>'" + errorMessage + "'</b> Error Message is Displaying");

				testSteps.add("Step " + (++i) + " :Enter Amount To Transfer :" + amountToTransfer);
				fundTransferPage.enterAmountToTransfer(driver, amountToTransfer);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Select a different funds transfer method' button");
				fundTransferPage.clickOnDifferentFundsMethodText(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'FUNDS TRANSFER OPTIONS POPUP' is Present");
				assertTrue(fundTransferPage.isFundsOptionPopupDisplaying(driver),
						"'FUNDS TRANSFER OPTIONS POPUP' is not Present");
				testSteps.add("Step " + (++i) + " : Verified: 'FUNDS TRANSFER OPTIONS POPUP' is Present");

				testSteps.add("Step " + (++i) + " : Clicking on 'FUND IN PERSON WITH BANK VISIT' button");
				fundTransferPage.clickOnBankVisitButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Fund in-person with bank visit' Page is Displaying");
				assertTrue(fundTransferPage.isFundsBankVisitPageDisplaying(driver),
						"'Fund in-person with bank visit' Page is not Displaying");
				testSteps.add("Step " + (++i) + " : Verified: 'Fund in-person with bank visit' Page is Displaying");

				testSteps.add("Step " + (++i) + " :Click On 'Email Form'");
				fundTransferPage.clickOnEmailForm(driver);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
				assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
				assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Bank Name' is Present");
				assertTrue(fundTransferPage.isBankNamePresent(driver), "Verified 'Bank Name' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Amount Transferred In USD' is Present");
				assertTrue(fundTransferPage.isAmountTransferredInUSDPresent(driver),
						"Verified 'Amount Transferred In USD' is Present");

				testSteps.add("Step " + (++i) + " :Entering Submission Date");
				fundTransferPage.enterDate(driver, submissionDateAfterToday);

				String selectedDate = fundTransferPage.getSubmissionDate(driver);
				testSteps.add("Step " + (++i) + " :Verifying Upcoming Date is not selectable");
				assertTrue(selectedDate.equalsIgnoreCase(submissionDate), "Upcoming Date is selectable");
				testSteps.add("Step " + (++i) + " :Verified: Upcoming Date is not selectable");

				fundTransferPage.uploadFile(bankReceiptFileNameExcel, driver);
				testSteps.add("Step " + (++i) + " : Uploading 'Excel file'");

				testSteps.add("Step " + (++i) + " :Verifying InValid File Type Error Message is Displaying");
				assertTrue(fundTransferPage.isInvalidTypeErrorMessageDisplay(driver),
						"InValid File Type Error Message is not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: InValid File Type Error Message is Displaying");

				fundTransferPage.uploadFile(bankReceiptFileNameJson, driver);
				testSteps.add("Step " + (++i) + " : Uploading 'Json file'");

				testSteps.add("Step " + (++i) + " :Verifying InValid File Type Error Message is Displaying");
				assertTrue(fundTransferPage.isInvalidTypeErrorMessageDisplay(driver),
						"InValid File Type Error Message is not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: InValid File Type Error Message is Displaying");

				fundTransferPage.uploadFile(bankReceiptFileNameMoreThan10MB, driver);
				testSteps.add("Step " + (++i) + " : Upload 'pdf file more than 10MBs'");

				testSteps.add("Step " + (++i) + " :Verifying File Size Limit Exceed Error Message is Displaying");
				assertTrue(fundTransferPage.isSizeLimitErrorMessageDisplay(driver),
						"File Size Limit Exceed Error Message is not Displaying");
				testSteps.add("Step " + (++i) + " :Verified: File Size Limit Exceed Error Message is Displaying");

				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}
				if (!(driver.getCurrentUrl().contains("prod"))) {

					testSteps.add("Step " + (++i) + " :Click On 'Submit'");
					fundTransferPage.clickOnSubmitButton(driver);

					testSteps.add("Step " + (++i) + " :Click On 'Back To Dashboard'");
					fundTransferPage.clickOnBackToDashboardButton(driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);

					testSteps.add("Step " + (++i) + " :Verifying Add fund request of '" + amountToTransfer + "'");
					assertTrue(fundTransferPage.isTrasactionPresent(driver, amountToTransfer),
							"Transaction of " + amountToTransfer + " is not found");

				} else {
					navigateToURL(DashboardUrl, driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("ChangeOfFlow_AddFunds_DownloadInstruction", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: ChangeOfFlow_AddFunds_DownloadInstruction " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("ChangeOfFlow_AddFunds_DownloadInstruction") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ChangeOfFlow_AddFunds_DownloadInstruction", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: ChangeOfFlow_AddFunds_DownloadInstruction " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("ChangeOfFlow_AddFunds_DownloadInstruction") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ChangeOfFlow_AddFunds_DownloadInstruction", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 4, groups = "NonPreniumCashRequired")
	public void Verify_CompleteWithdraw_NonPremium() {
		WebDriver driver = null;
		LoginPage lp;
		ArrayList<String> testSteps = new ArrayList<>();
		driver = initConfiguration();

		lp = new LoginPage(driver);
		FundTransferPage fundTransferPage = new FundTransferPage(driver);
		KYCRegistrationPage kycRegistrationPage = new KYCRegistrationPage(driver);
		printString("Verify_CompleteWithDraw_NonPremium: " + driver.hashCode() + "", driver);
		String email = "";
		String password = "";
		if (PropertiesReader.getPropertyValue("env").toLowerCase().equalsIgnoreCase("Pre-Prod")) {
			email = "apurva.jain+production+8@vestedfinance.co";
			password = "iTestUser1!";
		} else {
			email = "vested.automation+w02@gmail.com";
			password = "#TestUser12";
		}

		String amountGreaterThanBalance = "10000000000";
		String zeroAmount = "0.0";
		String correctAmount = "50";
		String accountNumber = generateRandomNumberWithGivenNumberOfDigits(10, driver);
		String swiftCode = generateRandomNumberWithGivenNumberOfDigits(5, driver);
		String zipCode = generateRandomNumberWithGivenNumberOfDigits(5, driver);
		String name = "abc";
		String accountType = "Current";
		String country = "Greece";
		String country2 = "Aland Islands";
		String state = "Jomala";
		int step = 1;
		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-223?atlOrigin=eyJpIjoiMzI3N2Q3M2Y5NjZkNGE1ODllNzg4NmEyNDA5YzM5MGYiLCJwIjoiaiJ9\">QAA-223 : Web - [Withdraw Funds][Non-Premium] Complete the Withdraw funds from the web portal.<a/>");
			testSteps.add("Step " + step + " : Visit and login application");
			lp.loginToApp(email, password, driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Transfer Tab'");
			fundTransferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Withdraw Fund' Button");
			fundTransferPage.clickOnWithdrawFundBtn(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Settled Cash' is present");
			assertTrue(fundTransferPage.isSettledCashPresent(driver), "Verified 'Settled Cash' is present");

			testSteps.add("Step " + (++step) + " : Verifying 'DriveWealth Note' is present");
			assertTrue(fundTransferPage.isDriveWealthNodePresent(driver), "Verified 'DriveWealth Note' is present");

			testSteps.add("Step " + (++step) + " : Verifying 'GoPremium And Save button' is present");
			assertTrue(fundTransferPage.isGoPremiumAndSaveButtonPresent(driver),
					"Verified 'GoPremium And Save button' is present");

			testSteps.add("Step " + (++step) + " : Verifying 'Next button' is present");
			assertTrue(fundTransferPage.isNextButton_2Present(driver), "Verified 'Next button' is present");

			testSteps.add("Step " + (++step) + " : Clicking on 'Subscribe And Save' Button");
			fundTransferPage.clickOnSubscribeAndSaveButton(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Subscription page' is present");
			assertTrue(kycRegistrationPage.isSelectPlanScreenHeading(driver),
					"Verified 'Subscription page' is present");

			driver.navigate().back();

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + "");
			fundTransferPage.enterWithdrawAmount("", driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
			fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Withdrawal Amount is required.' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Withdrawal Amount is required.' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + "");
			fundTransferPage.enterWithdrawAmount("", driver);

//            testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
//            fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Withdrawal Amount is required.' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Withdrawal Amount is required.' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + amountGreaterThanBalance);
			fundTransferPage.enterWithdrawAmount(amountGreaterThanBalance, driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
			fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step)
					+ " : Verifying 'Please enter no more than the amount available for withdrawal.' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Please enter no more than the amount available for withdrawal.' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + zeroAmount);
			fundTransferPage.enterWithdrawAmount(zeroAmount, driver);

//            testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
//            fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step) + " : Verifying 'Withdrawal Amount must be greater than 0' is present");
			assertTrue(fundTransferPage.isWithdrawAmountErrorMessagePresent(driver),
					"Verified 'Withdrawal Amount must be greater than 0' is present");

			testSteps.add("Step " + (++step) + " : Enter 'Withdraw Amount: '" + correctAmount);
			fundTransferPage.enterWithdrawAmount(correctAmount, driver);

			testSteps.add("Step " + (++step) + " : Clicking on 'Next' Button");
			fundTransferPage.clickOnNextButton_2(driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Name: '" + name);
			fundTransferPage.enterBeneficiaryName(name, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Account Number: '" + accountNumber);
			fundTransferPage.enterBeneficiaryAccountNumber(accountNumber, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Retype Account Name: '" + accountNumber);
			fundTransferPage.enterRetypeAccountNumber(accountNumber, driver);

			testSteps.add("Step " + (++step) + " : Select 'Account Type: '" + accountType);
			fundTransferPage.selectAccountType(accountType, driver);

			testSteps.add("Step " + (++step) + " : Enter 'SWIFT Code: '" + swiftCode);
			fundTransferPage.enterSwiftCode(swiftCode, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Retype SWIFT Code: '" + swiftCode);
			fundTransferPage.enterRetypeSwiftCode(swiftCode, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank Name: '" + name);
			fundTransferPage.enterBeneficiaryBankName(name, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank Address: '" + name);
			fundTransferPage.enterBeneficiaryBankAddress(name, driver);

			try {
				fundTransferPage.selectBankCountry(country, driver);
				testSteps.add("Step " + (++step) + " : Select ' Bank Country: '" + country);
			} catch (Exception e) {
				fundTransferPage.selectBankCountry(country2, driver);
				testSteps.add("Step " + (++step) + " : Select ' Bank Country: '" + country2);
			}

			testSteps.add("Step " + (++step) + " : Select ' Bank State: '" + state);
			fundTransferPage.selectBeneficiaryBankProvince(state, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank City: '" + name);
			fundTransferPage.enterBeneficiaryBankCity(name, driver);

			testSteps.add("Step " + (++step) + " : Enter 'Beneficiary Bank Zip Code: '" + zipCode);
			fundTransferPage.enterBeneficiaryBankZipCode(zipCode, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				waitTime(5000);
				testSteps.add("Step " + (++step) + " : Clicking on 'Continue' Button");
				fundTransferPage.clickOnContinueButton(driver);

				testSteps.add("Step " + (++step) + " : Verifying 'OTP page' is present");
				assertTrue(fundTransferPage.isOTPPagePresent(driver), "Verified 'OTP page' is present");
			}

			AddTest_IntoReport("Verify_CompleteWithDraw_NonPremium", testSteps, driver);
		} catch (Exception e) {

			testSteps.add("Failed: Verify_CompleteWithDraw_NonPremium " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_CompleteWithDraw_NonPremium") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteWithDraw_NonPremium", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: Verify_CompleteWithDraw_NonPremium " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_CompleteWithDraw_NonPremium") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteWithDraw_NonPremium", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	// Commented due to obsolete test
//	@Test(priority = 2)
	public void AddFunds_InformationConfirmation() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("FundsTransfer: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "Non-Indian Bank", "Other Indian Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-337?atlOrigin=eyJpIjoiMDE2MzY1ZDg4NmIxNDY4Y2JmYTBkMjI5ZDZjY2YzZDUiLCJwIjoiaiJ9\">QAA-337 : Web - Verify add funds flow for each different bank<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			fundTransferPage.clickOnBtnTransfer(driver);

			for (int a = 0; a < banks.length; a++) {
				String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
				testSteps.add("<b>*************For " + banks[a] + "*************</b>");

				testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
				fundTransferPage.clickOnBtnAddFund(driver);
				try {
					waitfor3sec();
					testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
					assertTrue(fundTransferPage.isAddFundModalMessage(driver),
							"Verified <b>'Add Funds'</b> popup Heading is showing");
				} catch (Exception e) {
					testSteps.add("Step " + (++i)
							+ " : Verify <b>'How US fund transfers work with Vested?'</b> message is showing");
					waitTime(2500);
					assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
							"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
					assertEquals(fundTransferPage.getAddFundModalMessage(driver), addFundModalMessage,
							"Failed : <b>'How US fund transfers work with Vested?'</b> message is not showing");
				}

				testSteps.add("Step " + (++i) + " :Click On 'Switch Bank'");
				fundTransferPage.clickOnSwitchBankButton(driver);

				testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
				fundTransferPage.clickOnBank(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Enter Amount To Transfer :" + amountToTransfer);
				fundTransferPage.enterAmountToTransfer(driver, amountToTransfer);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " :Enter Bank Name :" + banks[a]);
				fundTransferPage.enterBankName(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Enter Submission Date :" + submissionDate);
				fundTransferPage.enterSubmissionDate(driver, submissionDate);

				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				if (!(driver.getCurrentUrl().contains("prod"))) {

					testSteps.add("Step " + (++i) + " :Click On 'Submit'");
					fundTransferPage.clickOnSubmitButton(driver);

					testSteps.add("Step " + (++i) + " :Click On 'Back To Dashboard'");
					fundTransferPage.clickOnBackToDashboardButton(driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);

					testSteps.add("Step " + (++i) + " :Verifying Add fund request of '" + amountToTransfer + "'");
					assertTrue(fundTransferPage.isTrasactionPresent(driver, amountToTransfer),
							"Transaction of " + amountToTransfer + " is not found");

				} else {
					navigateToURL(DashboardUrl, driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_InformationConfirmation", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: AddFunds_InformationConfirmation " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_InformationConfirmation") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_InformationConfirmation", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: AddFunds_InformationConfirmation " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_InformationConfirmation") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_InformationConfirmation", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	// Commented due to obsolete test
//	@Test(priority = 1)
	public void AddFunds_EmailForm() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_EmailForm: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "Yes Bank", "Bank of Baroda", "Citibank", "HSBC", "State Bank of India",
				"Punjab National Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-337?atlOrigin=eyJpIjoiMDE2MzY1ZDg4NmIxNDY4Y2JmYTBkMjI5ZDZjY2YzZDUiLCJwIjoiaiJ9\">QAA-337 : Web - Verify add funds flow for each different bank<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));
			waitTime(1500);
			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			fundTransferPage.clickOnBtnTransfer(driver);

			for (int a = 0; a < banks.length; a++) {
				String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
				testSteps.add("<b>*************For " + banks[a] + "*************</b>");

				testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
				fundTransferPage.clickOnBtnAddFund(driver);
				try {
					waitfor3sec();
					testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
					assertTrue(fundTransferPage.isAddFundModalMessage(driver),
							"Verified <b>'Add Funds'</b> popup Heading is showing");
				} catch (Exception e) {
					testSteps.add("Step " + (++i)
							+ " : Verify <b>'How US fund transfers work with Vested?'</b> message is showing");
					waitTime(2500);
					assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
							"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
					assertEquals(fundTransferPage.getAddFundModalMessage(driver), addFundModalMessage,
							"Failed : <b>'How US fund transfers work with Vested?'</b> message is not showing");
				}

				testSteps.add("Step " + (++i) + " :Click On 'Switch Bank'");
				fundTransferPage.clickOnSwitchBankButton(driver);

				testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
				fundTransferPage.clickOnBank(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Enter Amount To Transfer :" + amountToTransfer);
				fundTransferPage.enterAmountToTransfer(driver, amountToTransfer);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " :Click On 'Email Form'");
				fundTransferPage.clickOnEmailForm(driver);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
				assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
				assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Bank Name' is Present");
				assertTrue(fundTransferPage.isBankNamePresent(driver), "Verified 'Bank Name' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Amount Transferred In USD' is Present");
				assertTrue(fundTransferPage.isAmountTransferredInUSDPresent(driver),
						"Verified 'Amount Transferred In USD' is Present");

				testSteps.add("Step " + (++i) + " :Enter Submission Date :" + submissionDate);
				fundTransferPage.enterSubmissionDate(driver, submissionDate);

				testSteps.add("Step " + (++i) + " :Uploading File Receipt");
				fundTransferPage.uploadRecipt(driver, bankReceiptFileName);
				if (!(driver.getCurrentUrl().contains("prod"))) {

					testSteps.add("Step " + (++i) + " :Click On 'Submit'");
					fundTransferPage.clickOnSubmitButton(driver);

					testSteps.add("Step " + (++i) + " :Click On 'Back To Dashboard'");
					fundTransferPage.clickOnBackToDashboardButton(driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);

					testSteps.add("Step " + (++i) + " :Verifying Add fund request of '" + amountToTransfer + "'");
					assertTrue(fundTransferPage.isTrasactionPresent(driver, amountToTransfer),
							"Transaction of " + amountToTransfer + " is not found");

				} else {
					navigateToURL(DashboardUrl, driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_EmailForm", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: AddFunds_EmailForm " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_EmailForm") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_EmailForm", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: AddFunds_EmailForm " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_EmailForm") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_EmailForm", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	// Commented due to obsolete test
//	@Test(priority = 3)
	public void AddFunds_DownloadInstruction() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_DownloadInstruction: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "Axis Bank", "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank", "IDFC First Bank",
				"IndusInd Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-337?atlOrigin=eyJpIjoiMDE2MzY1ZDg4NmIxNDY4Y2JmYTBkMjI5ZDZjY2YzZDUiLCJwIjoiaiJ9\">QAA-337 : Web - Verify add funds flow for each different bank<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			fundTransferPage.clickOnBtnTransfer(driver);

			for (int a = 0; a < banks.length; a++) {
				String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
				testSteps.add("<b>*************For " + banks[a] + "*************</b>");

				testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
				fundTransferPage.clickOnBtnAddFund(driver);
				try {
					waitfor3sec();
					testSteps.add("Step " + (++i) + " : Verify <b>'Add Fund'</b> Heading is showing");
					assertTrue(fundTransferPage.isAddFundModalMessage(driver),
							"Verified <b>'Add Funds'</b> popup Heading is showing");
				} catch (Exception e) {
					testSteps.add("Step " + (++i)
							+ " : Verify <b>'How US fund transfers work with Vested?'</b> message is showing");
					waitTime(2500);
					assertTrue(fundTransferPage.isAddFundModalMessageShowing(driver),
							"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
					assertEquals(fundTransferPage.getAddFundModalMessage(driver), addFundModalMessage,
							"Failed : <b>'How US fund transfers work with Vested?'</b> message is not showing");
				}

				testSteps.add("Step " + (++i) + " :Click On 'Switch Bank'");
				fundTransferPage.clickOnSwitchBankButton(driver);

				testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
				fundTransferPage.clickOnBank(driver, banks[a]);

				testSteps.add("Step " + (++i) + " :Enter Amount To Transfer :" + amountToTransfer);
				fundTransferPage.enterAmountToTransfer(driver, amountToTransfer);

				testSteps.add("Step " + (++i) + " :Click On 'NEXT'");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
				fundTransferPage.clickOnDownloadInstructionButton(driver);

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(0));

				testSteps.add("Step " + (++i) + " : Verifying 'Previous' is Present");
				assertTrue(fundTransferPage.isPreviousPresent(driver), "Verified 'Previous' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Continue Later' is Present");
				assertTrue(fundTransferPage.isContinueLaterPresent(driver), "Verified 'Continue Later' is Present");

				testSteps.add("Step " + (++i) + " : Clicking on 'NEXT' button");
				fundTransferPage.clickOnNEXTButton(driver);

				testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
				assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
				assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Bank Name' is Present");
				assertTrue(fundTransferPage.isBankNamePresent(driver), "Verified 'Bank Name' is Present");

				testSteps.add("Step " + (++i) + " : Verifying 'Amount Transferred In USD' is Present");
				assertTrue(fundTransferPage.isAmountTransferredInUSDPresent(driver),
						"Verified 'Amount Transferred In USD' is Present");

				testSteps.add("Step " + (++i) + " :Enter Submission Date :" + submissionDate);
				fundTransferPage.enterSubmissionDate(driver, submissionDate);

				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}
				if (!(driver.getCurrentUrl().contains("prod"))) {

					testSteps.add("Step " + (++i) + " :Click On 'Submit'");
					fundTransferPage.clickOnSubmitButton(driver);

					testSteps.add("Step " + (++i) + " :Click On 'Back To Dashboard'");
					fundTransferPage.clickOnBackToDashboardButton(driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);

					testSteps.add("Step " + (++i) + " :Verifying Add fund request of '" + amountToTransfer + "'");
					assertTrue(fundTransferPage.isTrasactionPresent(driver, amountToTransfer),
							"Transaction of " + amountToTransfer + " is not found");

				} else {
					navigateToURL(DashboardUrl, driver);

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					fundTransferPage.clickOnBtnTransfer(driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_DownloadInstruction", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_DownloadInstruction " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_DownloadInstruction") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_DownloadInstruction", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_DownloadInstruction " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_DownloadInstruction") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_DownloadInstruction", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

//Updated Flows
	@Test(priority = 10)
	public void Verify_CompleteAddFund_ICICIBank_UpdatedFlow() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		Object[][] dataArr = getData(testDataFile, "CompleteAddFund_ICICIBank", driver);
		String bank = dataArr[0][0].toString();
		String amount = dataArr[0][1].toString().replace(".0", "");
		driver = initConfiguration();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		String filePath = excelFilePath + "download.pdf";
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("Verify_CompleteAddFund_ICICIBank_UpdatedFlow: " + driver.hashCode() + "", driver);

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-494?atlOrigin=eyJpIjoiYWY0YzMyNzRiMjBjNGRjOGExNDkyZGNkMjQ2MjM1MGUiLCJwIjoiaiJ9\">QAA-494 : [Updated] [Web] [Add Funds] Complete the Add Funds for ICICI bank<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Clicking on 'Transfer Tab'");
			fundTransferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Add Fund' Button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
			fundTransferPage.clickOnIndianBankButton(driver);

			testSteps.add("Step " + (++i) + " : Enter 'Search Bank'");
			fundTransferPage.enterSearchBank(bank, driver);

			testSteps.add("Step " + (++i) + " : Verifying 'ICICI Bank Image' is present");
			assertTrue(fundTransferPage.isICICIBankImagePresent(driver), "Verified 'ICICI Bank Image' is present");

			testSteps.add("Step " + (++i) + " : Clicking on 'ICICI Bank'");
			fundTransferPage.clickOnICICIBank(driver);

			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
			fundTransferPage.clickOnDownloadInstructionButton(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));

			closeTab(1, driver);

			testSteps.add("Step " + (++i)
					+ " : Selecting <b>'Fund Online using ICICI MONEY2WORLD'</b> Switch Transfer Method");
			fundTransferPage.chooseFirstOptionInSwitchTransfer(driver);

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amount, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(date, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(filePath, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(filePath, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Verifying: <b>'Fund Amount'</b>");
				assertTrue(fundTransferPage.verifyAddedAmount(driver, amount), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Fund Amount'</b>");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

			}
			AddTest_IntoReport("Verify_CompleteAddFund_ICICIBank_UpdatedFlow", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Verify_CompleteAddFund_ICICIBank_UpdatedFlow " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("Verify_CompleteAddFund_ICICIBank_UpdatedFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteAddFund_ICICIBank_UpdatedFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: Verify_CompleteAddFund_ICICIBank_UpdatedFlow " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("Verify_CompleteAddFund_ICICIBank_UpdatedFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteAddFund_ICICIBank_UpdatedFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 11)
	public void Verify_CompleteAddFund_NegativeFlow() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		Object[][] dataArr = getData(testDataFile, "CompleteAddFund_ICICIBank", driver);
		String bank = dataArr[0][0].toString();
		String amount = dataArr[0][1].toString().replace(".0", "");
		driver = initConfiguration();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		String filePath = excelFilePath + "download.pdf";
		String filePath10mb = excelFilePath + "10mbPDFFile.pdf";
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("Verify_CompleteAddFund_NegativeFlow: " + driver.hashCode() + "", driver);

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-493?atlOrigin=eyJpIjoiNTc3ZGQ0ZjM4OTBkNDllMTkwYzY5YTkwMDdmMzdjZWMiLCJwIjoiaiJ9\">QAA-493 : [Negetive]  Web - Verify add funds updated flow for each different bank<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			testSteps.add("Step " + (++i) + " : Clicking on 'Transfer Tab'");
			fundTransferPage.clickOnTransferTab(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Add Fund' Button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
			fundTransferPage.clickOnIndianBankButton(driver);

			testSteps.add("Step " + (++i) + " : Enter 'Search Bank'");
			fundTransferPage.enterSearchBank(bank, driver);

			testSteps.add("Step " + (++i) + " : Verifying 'ICICI Bank Image' is present");
			assertTrue(fundTransferPage.isICICIBankImagePresent(driver), "Verified 'ICICI Bank Image' is present");

			testSteps.add("Step " + (++i) + " : Clicking on 'ICICI Bank'");
			fundTransferPage.clickOnICICIBank(driver);

			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
			fundTransferPage.clickOnDownloadInstructionButton(driver);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));

			closeTab(1, driver);

			testSteps.add("Step " + (++i)
					+ " : Selecting <b>'Fund Online using ICICI MONEY2WORLD'</b> Switch Transfer Method");
			fundTransferPage.chooseFirstOptionInSwitchTransfer(driver);

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			fundTransferPage.randomClickOnScreen(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Amount Required Error Message' is Present");
			assertTrue(fundTransferPage.isRequiredAmountErrorDisplaying(driver),
					"Verified 'Amount Required Error Message' is not Present");
			testSteps.add("Step " + (++i) + " : Verified: 'Amount Required Error Message' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Date Required Error Message' is Present");
			assertTrue(fundTransferPage.isRequiredDateErrorDisplaying(driver),
					"Verified 'Date Required Error Message' is not Present");
			testSteps.add("Step " + (++i) + " : Verified: 'Date Required Error Message' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer': -1");
			fundTransferPage.enterAmountToTransfer("-1", driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Negetive Amount Error Message' is Present");
			assertTrue(fundTransferPage.isNegativeAmountErrorDisplaying(driver),
					"Verified 'Negative Amount Error Message' is not Present");
			testSteps.add("Step " + (++i) + " : Verified: 'Negetive Amount Error Message' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer': 0");
			fundTransferPage.enterAmountToTransfer("0", driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Negetive Amount Error Message' is Present");
			assertTrue(fundTransferPage.isNegativeAmountErrorDisplaying(driver),
					"Verified 'Negative Amount Error Message' is not Present");
			testSteps.add("Step " + (++i) + " : Verified: 'Negetive Amount Error Message' is Present");

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(date, driver);

			try {
				fundTransferPage.uploadFile(filePath10mb, driver);
				testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
			} catch (Exception e) {
				fundTransferPage.uploadFile(filePath10mb, driver);
				testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
			}

			testSteps.add("Step " + (++i) + " : Verifying 'Negetive Amount Error Message' is Present");
			assertTrue(fundTransferPage.isSizeLimitErrorMessageDisplay(driver),
					"Verified 'Negative Amount Error Message' is not Present");
			testSteps.add("Step " + (++i) + " : Verified: 'Negetive Amount Error Message' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer': 50");
			fundTransferPage.enterAmountToTransfer("50", driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(filePath, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(filePath, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

			}
			AddTest_IntoReport("Verify_CompleteAddFund_NegativeFlow", testSteps, driver);
		} catch (Exception e) {
			testSteps.add("Failed: Verify_CompleteAddFund_NegativeFlow " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_CompleteAddFund_NegativeFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteAddFund_NegativeFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: Verify_CompleteAddFund_NegativeFlow " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("Verify_CompleteAddFund_NegativeFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("Verify_CompleteAddFund_NegativeFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}
	}

	@Test(priority = 12)
	public void AddFunds_DownloadInstructionsUpdateFlow() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_DownloadInstructionsUpdateFlow: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank", "IDFC First Bank", "IndusInd Bank" };
//		String[] banks = { "Axis Bank", "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-491?atlOrigin=eyJpIjoiNmMyYzU0YTdlYjFlNDEzNGFmMTJkZTdiNWM1OWJhNmIiLCJwIjoiaiJ9\">QAA-491 : [Updated] Banks with Instructions Download<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");

			for (int a = 0; a < banks.length; a++) {

				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					waitfor10sec();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);

					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
					fundTransferPage.clickOnDownloadInstructionButton(driver);

					ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(0));

					closeTab(1, driver);

					if (a <= 3) {
						testSteps.add("Step " + (++i) + " : Selecting <b>'Fund Online'</b> Switch Transfer Method");
						fundTransferPage.chooseFirstOptionInSwitchTransfer(driver);
					}

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}

				} catch (Exception e) {
					testSteps.add("<font color=red>Exception:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				} catch (Error e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_DownloadInstructionsUpdateFlow", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: AddFunds_DownloadInstructionsUpdateFlow " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_DownloadInstructionsUpdateFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_DownloadInstructionsUpdateFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_DownloadInstructionsUpdateFlow " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_DownloadInstructionsUpdateFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_DownloadInstructionsUpdateFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 13)
	public void AddFunds_EmailFormUpdateFlow() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_EmailFormUpdateFlow: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "Axis Bank", "Yes Bank", "Bank of Baroda", "Citibank", "HSBC", "State Bank of India",
				"Punjab National Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-492?atlOrigin=eyJpIjoiNmMyYzU0YTdlYjFlNDEzNGFmMTJkZTdiNWM1OWJhNmIiLCJwIjoiaiJ9\">QAA-492 : [Updated] Banks with Email Forms<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");

			for (int a = 0; a < banks.length; a++) {
				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					waitfor10sec();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);

					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Email Form' button");
					fundTransferPage.clickOnEmailForm(driver);

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {
						navigateToURL(DashboardUrl, driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}
				} catch (Exception e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_EmailFormUpdateFlow", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_EmailFormUpdateFlow " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_EmailFormUpdateFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_EmailFormUpdateFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_EmailFormUpdateFlow " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_EmailFormUpdateFlow") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_EmailFormUpdateFlow", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 14)
	public void AddFunds_InternationalBank() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_InternationalBank: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "Yes Bank", "Bank of Baroda", "Citibank", "HSBC", "State Bank of India",
				"Punjab National Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-510?atlOrigin=eyJpIjoiNGRkYzJkYzdiOTkxNGYxZTgxNzc0MjM2N2Q4YzI1OTAiLCJwIjoiaiJ9\">QAA-510 : Web - Verify add funds for International Banks<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			try {
				fundTransferPage.clickOnBtnTransfer(driver);
			} catch (Exception e) {
				fundTransferPage.clickOnTransferTab(driver);
			}
			waitfor10sec();

			String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Step " + (++i) + " : Clicking on 'International Bank' Button");
			fundTransferPage.clickOnInternationalBankButton(driver);

//			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(submissionDate, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);

			} else {
				navigateToURL(DashboardUrl, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_InternationalBank", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_InternationalBank " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_InternationalBank") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_InternationalBank", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_InternationalBank " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_InternationalBank") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_InternationalBank", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 15)
	public void ChangeOfFlow_AddFunds_Updated() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("ChangeOfFlow_AddFunds_Updated: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-527?atlOrigin=eyJpIjoiNWRlYjY3ZjgzMTczNDY4Mzk0NWM2MzQyYjgxMDI2ZWMiLCJwIjoiaiJ9\">QAA-527 : [Web] - Update ChangeOfFlow_AddFunds<a/>");

			testSteps.addAll(loginPage.loginToApp(driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");

			for (int a = 0; a < banks.length; a++) {
				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					wait5s();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);
					
					fundTransferPage.clickOnFundsOnlineUsingBank(driver);

//					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Download Instruction' is Present");
					assertTrue(fundTransferPage.isDownloadInstructionButtonPresent(driver),
							"Failed: 'Download Instruction' is not Present");
					testSteps.add("Step " + (++i) + " : Verified 'Download Instruction' is Present");

					testSteps.add("Step " + (++i) + " : Selecting <b>'Bank Visit'</b> Switch Transfer Method");
					fundTransferPage.chooseBankVisitInSwitchTransfer(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Email Form' is Present");
					assertTrue(fundTransferPage.isEmailFormButtonPresent(driver),
							"Failed: 'Email Form' is not Present");
					testSteps.add("Step " + (++i) + " : Verified 'Email Form' is Present");

					testSteps.add("Step " + (++i) + " : Clicking on 'Email Form' button");
					fundTransferPage.clickOnEmailForm(driver);

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Failed: 'Your Full Name' is not Present");
					testSteps.add("Step " + (++i) + " : Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Failed 'Drive Wealth ID' is not Present");
					testSteps.add("Step " + (++i) + " : Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {
						navigateToURL(DashboardUrl, driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}

				} catch (Exception e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("ChangeOfFlow_AddFunds_Updated", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: ChangeOfFlow_AddFunds_Updated " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ChangeOfFlow_AddFunds_Updated") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ChangeOfFlow_AddFunds_Updated", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: ChangeOfFlow_AddFunds_Updated " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("ChangeOfFlow_AddFunds_Updated") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("ChangeOfFlow_AddFunds_Updated", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 16)
	public void AddFunds_WithGlobalUser() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithGlobalUser: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String email = "codeautomation.usman+Glo@vestedfinance.co";
		String password = "#TestUser12";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-529?atlOrigin=eyJpIjoiNmZmOGE4YjZjOGRiNDI2NmJkYmEwNjJjOGU3MTRhMTIiLCJwIjoiaiJ9\">QAA-529 : [Web] - Verify Add Funds Flow With Global User<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			try {
				fundTransferPage.clickOnBtnTransfer(driver);
			} catch (Exception e) {
				fundTransferPage.clickOnTransferTab(driver);
			}
			waitfor10sec();

			String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFundWithoutModal(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'International Bank'</b>");
			fundTransferPage.clickOnInternationalBankButton(driver);

//			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(submissionDate, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);

			} else {
				navigateToURL(DashboardUrl, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithGlobalUser", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_WithGlobalUser " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithGlobalUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithGlobalUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_WithGlobalUser " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithGlobalUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithGlobalUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 17)
	public void AddFunds_WithUSAUser() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithUSAUser: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String email = "codeautomation.usman+US@vestedfinance.co";
		String password = "#TestUser12";
		String wireTransfer = "Domestic Wire Transfer";
		String achTransfer = "ACH Transfer";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-532?atlOrigin=eyJpIjoiZjg5ZGYyODRlZjc5NGUxY2ExNDA5MDAxNGNkODUwNjciLCJwIjoiaiJ9\">QAA-532 : [Web] - Verify Add Funds Flow With US User<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			try {
				fundTransferPage.clickOnBtnTransfer(driver);
			} catch (Exception e) {
				fundTransferPage.clickOnTransferTab(driver);
			}
			waitfor10sec();

			String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);

			testSteps.add("<b>**********For " + wireTransfer + " Tansfer Mode**********</b>");

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Verifying: <b>'" + wireTransfer + "'</b> Transfer Mode is Displaying");
			assertTrue(fundTransferPage.isTransferModeShowing(driver, wireTransfer),
					"'" + wireTransfer + "' Transfer Mode is Displaying");
			testSteps.add("Verified: <b>'" + wireTransfer + "'</b> Transfer Mode is Displaying");

			testSteps.add("Verifying: <b>'" + achTransfer + "'</b> Transfer Mode is Displaying");
			assertTrue(fundTransferPage.isTransferModeShowing(driver, wireTransfer),
					"'" + achTransfer + "' Transfer Mode is Displaying");
			testSteps.add("Verified: <b>'" + achTransfer + "'</b> Transfer Mode is Displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'" + wireTransfer + "'</b> button");
			fundTransferPage.clickOnTranfersMode(driver, wireTransfer);

//			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(submissionDate, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);

			} else {
				navigateToURL(DashboardUrl, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);
			}

			testSteps.add("<b>**********For " + achTransfer + " Tansfer Mode**********</b>");
			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'" + achTransfer + "'</b> button");
			fundTransferPage.clickOnTranfersMode(driver, achTransfer);

//			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(submissionDate, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);

			} else {
				navigateToURL(DashboardUrl, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithUSAUser", testSteps, driver);

		} catch (Exception e) {
			testSteps.add("Failed: AddFunds_WithUSAUser " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithUSAUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithUSAUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add("Failed: AddFunds_WithUSAUser " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithUSAUser") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithUSAUser", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 18)
	public void AddFunds_WithNRIUser_International() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithNRIUser_International: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String email = "codeautomation.usman+NRI@vestedfinance.co";
		String password = "#TestUser12";
		String indianTranferType = "Indian Bank";
		String internationalTranferType = "International Bank";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-535?atlOrigin=eyJpIjoiZjg5ZGYyODRlZjc5NGUxY2ExNDA5MDAxNGNkODUwNjciLCJwIjoiaiJ9\">QAA-535 : [Web] - Verify Add Funds Flow With NRI User for International Bank<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			try {
				fundTransferPage.clickOnBtnTransfer(driver);
			} catch (Exception e) {
				fundTransferPage.clickOnTransferTab(driver);
			}
			waitfor10sec();

			String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Verifying: <b>'" + indianTranferType + "'</b> Transfer Mode is Displaying");
			assertTrue(fundTransferPage.isTransferModeShowing(driver, indianTranferType),
					"'" + indianTranferType + "' Transfer Mode is Displaying");
			testSteps.add("Verified: <b>'" + indianTranferType + "'</b> Transfer Mode is Displaying");

			testSteps.add("Verifying: <b>'" + internationalTranferType + "'</b> Transfer Mode is Displaying");
			assertTrue(fundTransferPage.isTransferModeShowing(driver, internationalTranferType),
					"'" + internationalTranferType + "' Transfer Mode is Displaying");
			testSteps.add("Verified: <b>'" + internationalTranferType + "'</b> Transfer Mode is Displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'International Bank'</b> button");
			fundTransferPage.clickOnInternationalBankButton(driver);

//			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(submissionDate, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);

			} else {
				navigateToURL(DashboardUrl, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithNRIUser_International", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_WithNRIUser_International " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithNRIUser_International") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithNRIUser_International", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_WithNRIUser_International " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithNRIUser_International") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithNRIUser_International", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 19)
	public void AddFunds_WithNRIUser_DownloadInstructions() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithNRIUser_DownloadInstructions: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String email = "codeautomation.usman+NRI@vestedfinance.co";
		String password = "#TestUser12";
		String indianTransfer = "Indian Bank";
		String internationalTransfer = "International Bank";
		String[] banks = { "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank", "IDFC First Bank", "IndusInd Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-535?atlOrigin=eyJpIjoiNmMyYzU0YTdlYjFlNDEzNGFmMTJkZTdiNWM1OWJhNmIiLCJwIjoiaiJ9\">QAA-535 : Verify Add Funds Flow With NRI User_DownloadInstructions<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			for (int a = 0; a < banks.length; a++) {
				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					waitfor10sec();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Verifying: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, indianTransfer),
							"'" + indianTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Verifying: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, internationalTransfer),
							"'" + internationalTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);

					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
					fundTransferPage.clickOnDownloadInstructionButton(driver);

					ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(0));

					closeTab(1, driver);

					if (a <= 3) {
						testSteps.add("Step " + (++i) + " : Selecting <b>'Fund Online'</b> Switch Transfer Method");
						fundTransferPage.chooseFirstOptionInSwitchTransfer(driver);
					}

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {
						navigateToURL(DashboardUrl, driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}

				} catch (Exception e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithNRIUser_DownloadInstructions", testSteps, driver);

		} catch (Exception e) {
			testSteps.add(
					"Failed: AddFunds_WithNRIUser_DownloadInstructions " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("AddFunds_WithNRIUser_DownloadInstructions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithNRIUser_DownloadInstructions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {
			testSteps.add(
					"Failed: AddFunds_WithNRIUser_DownloadInstructions " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("AddFunds_WithNRIUser_DownloadInstructions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithNRIUser_DownloadInstructions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 20)
	public void AddFunds_WithNRIUser_EmailForm() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithNRIUser_EmailForm: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String email = "codeautomation.usman+NRI@vestedfinance.co";
		String password = "#TestUser12";
		String indianTransfer = "Indian Bank";
		String internationalTransfer = "International Bank";
		String[] banks = { "Axis Bank", "Yes Bank", "Bank of Baroda", "Citibank", "HSBC", "State Bank of India",
				"Punjab National Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-535?atlOrigin=eyJpIjoiNmMyYzU0YTdlYjFlNDEzNGFmMTJkZTdiNWM1OWJhNmIiLCJwIjoiaiJ9\">QAA-535 : Verify Add Funds Flow With NRI User_ Email Form<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");

			for (int a = 0; a < banks.length; a++) {
				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					waitfor10sec();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Verifying: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, indianTransfer),
							"'" + indianTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Verifying: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, internationalTransfer),
							"'" + internationalTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);

					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Email Form' button");
					fundTransferPage.clickOnEmailForm(driver);

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {
						navigateToURL(DashboardUrl, driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}

				} catch (Exception e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithNRIUser_EmailForm", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_WithNRIUser_EmailForm " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithNRIUser_EmailForm") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithNRIUser_EmailForm", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_WithNRIUser_EmailForm " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithNRIUser_EmailForm") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithNRIUser_EmailForm", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 21)
	public void AddFunds_WithIndianUser_DownloadInstructions() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_DownloadInstructionsUpdateFlow: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String email = "codeautomation.usman+IN@vestedfinance.co";
		String password = "#TestUser12";
		String indianTransfer = "Indian Bank";
		String internationalTransfer = "International Bank";
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "ICICI Bank", "HDFC Bank", "Kotak Mahindra Bank", "IDFC First Bank", "IndusInd Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-547?atlOrigin=eyJpIjoiNmMyYzU0YTdlYjFlNDEzNGFmMTJkZTdiNWM1OWJhNmIiLCJwIjoiaiJ9\">QAA-547 : AddFunds_DownloadInstruction_WithIndian<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			for (int a = 0; a < banks.length; a++) {
				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					waitfor10sec();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Verifying: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, indianTransfer),
							"'" + indianTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Verifying: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, internationalTransfer),
							"'" + internationalTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Verifying: <b>'Proceed With Vested Direct'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isProceedWithVestedDirectDisplay(driver),
							"'Proceed With Vested Direct' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'Proceed With Vested Direct'</b> Transfer Mode is Displaying");

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);

					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Download Instruction' button");
					fundTransferPage.clickOnDownloadInstructionButton(driver);

					ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(0));

					closeTab(1, driver);

					if (a <= 3) {
						testSteps.add("Step " + (++i) + " : Selecting <b>'Fund Online'</b> Switch Transfer Method");
						fundTransferPage.chooseFirstOptionInSwitchTransfer(driver);
					}

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {
						navigateToURL(DashboardUrl, driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}

				} catch (Exception e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithIndianUser_DownloadInstructions", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_WithIndianUser_DownloadInstructions " + "<br><b>Exception:</b><br> "
					+ e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("AddFunds_WithIndianUser_DownloadInstructions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithIndianUser_DownloadInstructions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: AddFunds_WithIndianUser_DownloadInstructions " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("AddFunds_WithIndianUser_DownloadInstructions") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithIndianUser_DownloadInstructions", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 22)
	public void AddFunds_WithIndianUser_EmailForm() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithIndianUser_EmailForm: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String email = "codeautomation.usman+IN@vestedfinance.co";
		String password = "#TestUser12";
		String indianTransfer = "Indian Bank";
		String internationalTransfer = "International Bank";
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String[] banks = { "Axis Bank", "Yes Bank", "Bank of Baroda", "Citibank", "HSBC", "State Bank of India",
				"Punjab National Bank" };

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-547?atlOrigin=eyJpIjoiNmMyYzU0YTdlYjFlNDEzNGFmMTJkZTdiNWM1OWJhNmIiLCJwIjoiaiJ9\">QAA-547 : AddFunds_EmailForm_WithIndian<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			for (int a = 0; a < banks.length; a++) {
				try {

					String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);
					testSteps.add("<b>*************For " + banks[a] + "*************</b>");

					testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
					try {
						fundTransferPage.clickOnBtnTransfer(driver);
					} catch (Exception e) {
						fundTransferPage.clickOnTransferTab(driver);
					}
					waitfor10sec();

					testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
					fundTransferPage.clickOnBtnAddFund(driver);

					testSteps.add("Verifying: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, indianTransfer),
							"'" + indianTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Verifying: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isTransferModeShowing(driver, internationalTransfer),
							"'" + internationalTransfer + "' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");

					testSteps.add("Verifying: <b>'Proceed With Vested Direct'</b> Transfer Mode is Displaying");
					assertTrue(fundTransferPage.isProceedWithVestedDirectDisplay(driver),
							"'Proceed With Vested Direct' Transfer Mode is Displaying");
					testSteps.add("Verified: <b>'Proceed With Vested Direct'</b> Transfer Mode is Displaying");

					testSteps.add("Step " + (++i) + " : Clicking on 'Indian Bank' Button");
					fundTransferPage.clickOnIndianBankButton(driver);

					testSteps.add("Step " + (++i) + " :Click On '" + banks[a] + "'");
					fundTransferPage.clickOnBank(driver, banks[a]);

					testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
					fundTransferPage.clickOnTransferDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Clicking on 'Email Form' button");
					fundTransferPage.clickOnEmailForm(driver);

					testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
					fundTransferPage.clickOnNotifyUsDropMenu(driver);

					testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
					assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

					testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
					assertTrue(fundTransferPage.isDriveWealthIdPresent(driver),
							"Verified 'Drive Wealth ID' is Present");

					testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
					fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

					testSteps.add("Step " + (++i) + " : Select 'Date'");
					fundTransferPage.selectDate(submissionDate, driver);

					testSteps.add("Step " + (++i) + " : Enter 'Password'");
					fundTransferPage.enterFilePassword(password, driver);

					if (!(driver.getCurrentUrl().contains("prod"))) {
						try {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						} catch (Exception e) {
							fundTransferPage.uploadFile(bankReceiptFileName, driver);
							testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
						}

						testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
						assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver),
								"'Thank You' Screen is not Displaying");
						testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

						testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
						fundTransferPage.clickOnOkGotItButton(driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);

					} else {
						navigateToURL(DashboardUrl, driver);

						testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
						fundTransferPage.clickOnTransferTab(driver);
					}

				} catch (Exception e) {
					testSteps.add("<font color=red>Error:" + e.toString() + "</font>");
					tempSrc = getScreenshotPath();
					testSteps.add(tempSrc);
					captureCapture(driver, tempSrc);
					navigateToURL(DashboardUrl, driver);
				}

			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithIndianUser_EmailForm", testSteps, driver);

		} catch (Exception e) {

			testSteps.add("Failed: AddFunds_WithIndianUser_EmailForm " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithIndianUser_EmailForm") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithIndianUser_EmailForm", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add("Failed: AddFunds_WithIndianUser_EmailForm " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist.get("AddFunds_WithIndianUser_EmailForm") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithIndianUser_EmailForm", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

	@Test(priority = 23)
	public void AddFunds_WithIndianUser_InternationalBank() {
		ArrayList<String> testSteps = new ArrayList<>();
		FundTransferPage fundTransferPage;
		LoginPage loginPage;
		WebDriver driver = null;
		driver = initConfiguration();
		int i = 0;

		loginPage = new LoginPage(driver);
		fundTransferPage = new FundTransferPage(driver);

		printString("AddFunds_WithIndianUser_InternationalBank: " + driver.hashCode() + "", driver);
		Object[][] dataArr = getData(testDataFile, testDataSheet, driver);
		String addFundModalMessage = dataArr[rowIndex][9].toString();
		String bankName = generateRandomStringWithGivenNumberOfDigits(3, driver);
		String submissionDate = getDate("dd/MM/yyyy", driver);
		String bankReceiptFileName = excelFilePath + "download.pdf";
		String email = "codeautomation.usman+IN@vestedfinance.co";
		String password = "#TestUser12";
		String indianTransfer = "Indian Bank";
		String internationalTransfer = "International Bank";

		try {
			testSteps.add(
					"<a href=\"https://vestedfinance.atlassian.net/browse/QAA-547?atlOrigin=eyJpIjoiNGRkYzJkYzdiOTkxNGYxZTgxNzc0MjM2N2Q4YzI1OTAiLCJwIjoiaiJ9\">QAA-547 : AddFunds_InternationalBank_WithIndian<a/>");

			testSteps.addAll(loginPage.loginToApp(email, password, driver));

			waitTime(1500);

			testSteps.add("Step " + (++i) + " : Verify <b>'Dashboard'</b> is displaying");
			assertTrue(loginPage.isDashBoardDisplay(driver), "Verified Dashboard is displaying");

			testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
			try {
				fundTransferPage.clickOnBtnTransfer(driver);
			} catch (Exception e) {
				fundTransferPage.clickOnTransferTab(driver);
			}
			waitfor10sec();

			String amountToTransfer = generateRandomNumberWithGivenNumberOfDigits(3, driver);

			testSteps.add("Step " + (++i) + " : Click on <b>'Add Fund'</b> button");
			fundTransferPage.clickOnBtnAddFund(driver);

			testSteps.add("Verifying: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");
			assertTrue(fundTransferPage.isTransferModeShowing(driver, indianTransfer),
					"'" + indianTransfer + "' Transfer Mode is Displaying");
			testSteps.add("Verified: <b>'" + indianTransfer + "'</b> Transfer Mode is Displaying");

			testSteps.add("Verifying: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");
			assertTrue(fundTransferPage.isTransferModeShowing(driver, internationalTransfer),
					"'" + internationalTransfer + "' Transfer Mode is Displaying");
			testSteps.add("Verified: <b>'" + internationalTransfer + "'</b> Transfer Mode is Displaying");

			try {
				
				assertTrue(fundTransferPage.isProceedWithVestedDirectDisplay(driver),
						"'Proceed With Vested Direct' Transfer Mode is Displaying");
				testSteps.add("Verifying: <b>'Proceed With Vested Direct'</b> Transfer Mode is Displaying");
				testSteps.add("Verified: <b>'Proceed With Vested Direct'</b> Transfer Mode is Displaying");
			}catch (Exception e) {
				testSteps.add("<b>'Proceed With Vested Direct'</b> Transfer Mode is not Displaying");
			}
			catch (Error e) {
				testSteps.add("<b>'Proceed With Vested Direct'</b> Transfer Mode is not Displaying");
			}
			

			testSteps.add("Step " + (++i) + " : Clicking on 'International Bank' Button");
			fundTransferPage.clickOnInternationalBankButton(driver);

//			testSteps.add("Step " + (++i) + " : Expand 'Transfer' Accordion");
//			fundTransferPage.clickOnTransferDropMenu(driver);

			testSteps.addAll(fundTransferPage.verifyCopyIcons(driver));

			testSteps.add("Step " + (++i) + " : Expand 'Notify Us' Accordion");
			fundTransferPage.clickOnNotifyUsDropMenu(driver);

			testSteps.add("Step " + (++i) + " : Verifying 'Your Full Name' is Present");
			assertTrue(fundTransferPage.isYourNamePresent(driver), "Verified 'Your Full Name' is Present");

			testSteps.add("Step " + (++i) + " : Verifying 'Drive Wealth ID' is Present");
			assertTrue(fundTransferPage.isDriveWealthIdPresent(driver), "Verified 'Drive Wealth ID' is Present");

			testSteps.add("Step " + (++i) + " : Enter 'Amount To Transfer'");
			fundTransferPage.enterAmountToTransfer(amountToTransfer, driver);

			testSteps.add("Step " + (++i) + " : Select 'Date'");
			fundTransferPage.selectDate(submissionDate, driver);

			testSteps.add("Step " + (++i) + " : Enter 'Password'");
			fundTransferPage.enterFilePassword(password, driver);

			if (!(driver.getCurrentUrl().contains("prod"))) {
				try {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				} catch (Exception e) {
					fundTransferPage.uploadFile(bankReceiptFileName, driver);
					testSteps.add("Step " + (++i) + " : Upload 'pdf file'");
				}

				testSteps.add("Verifying: <b>'Thank You'</b> Screen is Displaying");
				assertTrue(fundTransferPage.isThankyouScreenDisplaying(driver), "'Thank You' Screen is not Displaying");
				testSteps.add("Verified: <b>'Thank You'</b> Screen is Displaying");

				testSteps.add("Step " + (++i) + " : Clicking on 'OK , Got it'");
				fundTransferPage.clickOnOkGotItButton(driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);

			} else {
				navigateToURL(DashboardUrl, driver);

				testSteps.add("Step " + (++i) + " : Click on <b>'Transfer'</b> button");
				fundTransferPage.clickOnTransferTab(driver);
			}

			testSteps.add("Step " + (++i) + " : Close the '<b>Browser'</b>");
			AddTest_IntoReport("AddFunds_WithIndianUser_InternationalBank", testSteps, driver);

		} catch (Exception e) {

			testSteps.add(
					"Failed: AddFunds_WithIndianUser_InternationalBank " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("AddFunds_WithIndianUser_InternationalBank") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithIndianUser_InternationalBank", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		} catch (Error e) {

			testSteps.add(
					"Failed: AddFunds_WithIndianUser_InternationalBank " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureCapture(driver, tempSrc);
			if (BaseClass.methodNamelist
					.get("AddFunds_WithIndianUser_InternationalBank") == RetryListener.maxRetryCnt) {
				AddTest_IntoReport("AddFunds_WithIndianUser_InternationalBank", testSteps, driver);
			} else {
				closeBrowser(driver);
			}
			assertTrue(false);
		}

	}

}
