package com.investor.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;

public class FundTransferPage extends BaseClass {

	private WebDriver podriver = null;
	@FindBy(xpath = "(//*[contains(text(),'Transfer')])[1]")
	WebElement btnTransfer;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement btnNext;
	
	@FindBy(xpath = "//span[contains(text(),'Ok, Got it')]")
	WebElement btnOkGotIt;

	@FindBy(xpath = "(//*[contains(text(),'ADD FUNDS')])[1]")
	WebElement btnAddFund;

	@FindBy(xpath = "(//*[contains(text(),'WITHDRAW FUNDS')])[1]")
	WebElement btnWithdrawFund;
	
	@FindBy(xpath = "(//div[contains(@class,'ant-modal-body')]//p)[1]")
	WebElement fundModalText;
	
	@FindBy(xpath = "//p[text()='ADD FUNDS']")
	WebElement addFundText;
	
	@FindBy(xpath = "//img[contains(@src,'x-icon.svg')]")
	WebElement AddFundCloseIcon;
	
	@FindBy(xpath = "(//p[text()='ADD FUNDS']//ancestor::div//img)[1]")
	WebElement AddFundCloseIcon2;
	
	@FindBy(xpath = "//p[text()='Amount to Withdraw']")
	WebElement amountToWithdrawLabel;
	
	@FindBy(xpath = "//*[contains(@class,'ant-modal-content')]")
	WebElement modal;
	
	@FindBy(xpath = "(//div[contains(@class,'css-y0c3w5')])[last()]")
	WebElement modalSliderDots;
	
	@FindBy(xpath = "(//*[contains(text(),'Got It')])[1]")
	WebElement btnGotIt;

	@FindBy(xpath = "//img[contains(@src,'x-icon')] | (//div[contains(@class,'css-1vpxrxu')])[last()]")
	WebElement btnCloseModal;
	
	@FindBy(xpath = "//p[text()='switch bank']//parent::button")
	WebElement switchBankButton;
	
	@FindBy(xpath = "//div[text()='Non-Indian Bank']//parent::div")
	WebElement nonIndianBank;
	
	@FindBy(xpath = "//div[text()='Other Indian Bank']//parent::div")
	WebElement otherIndianBank;
	
	@FindBy(xpath = "//div[text()='HDFC Bank']//parent::div")
	WebElement HDFCBank;
	
	@FindBy(xpath = "//div[text() = 'ICICI Bank']")
	WebElement ICICIBank;
	
	@FindBy(xpath = "//div[text()='Axis Bank']//parent::div")
	WebElement axisBank;
	
	@FindBy(xpath = "//div[text()='Kotak Mahindra Bank']//parent::div")
	WebElement kotakMahindraBank;
	
	@FindBy(xpath = "//div[text()='IDFC First Bank']//parent::div")
	WebElement IDFCFirstBank;
	
	@FindBy(xpath = "//div[text()='IndusInd Bank']//parent::div")
	WebElement indusIndBank;
	
	@FindBy(xpath = "//div[text()='Yes Bank']//parent::div")
	WebElement yesBank;
	
	@FindBy(xpath = "//div[text()='Bank of Baroda']//parent::div")
	WebElement bankofBaroda;
	
	@FindBy(xpath = "//div[text()='Citibank']//parent::div")
	WebElement citiBank;
	
	@FindBy(xpath = "//div[text()='HSBC']//parent::div")
	WebElement HSBCBank;
	
	@FindBy(xpath = "//div[text()='State Bank of India']//parent::div")
	WebElement stateBankofIndia;
	
	@FindBy(xpath = "//div[text()='Punjab National Bank']//parent::div")
	WebElement punjabNationalBank;
	
	
	@FindBy(xpath = "//span[text() = 'Transfer']/parent::p//parent::div")
	WebElement transferTab;

	@FindBy(xpath = "(//span[contains(text(), 'Subscribe and save')])[1]")
	WebElement subscribeAndSaveButton;

	@FindBy(xpath = "//input[@placeholder = 'Search Bank']")
	WebElement searchBank;


	
	

	@FindBy(xpath = "//div[text() = 'ICICI Bank']/parent::div/parent::div/child::img")
	WebElement ICICIBankImage;

	@FindBy(xpath = "//input[@name='amount']")
	WebElement amountToTransfer;
	
	@FindBy(xpath = "//input[@name='usd']")
	WebElement amountToTransfer1;

	@FindBy(xpath = "//p[text()='ICICI Bank']/parent::div")
	WebElement transferFrom;

	@FindBy(xpath = "//span[text()='NEXT']/parent::button")
	WebElement nextButton;

	@FindBy(xpath = "//span[text() = 'DOWNLOAD INSTRUCTIONS']/parent::button")
	WebElement downloadInstructionButton;

	@FindBy(xpath = "//span[text() = '  PREVIOUS']/parent::button")
	WebElement previousButton;

	@FindBy(xpath = "//span[text() = 'CONTINUE LATER']/parent::button")
	WebElement continueLaterButton;

	@FindBy(xpath = "//p[text()='Your full name']/following-sibling::p")
	WebElement yourName;

	@FindBy(xpath = "//p[text()='Your Drivewealth ID']/following-sibling::p")
	WebElement driveWealthId;
	
	@FindBy(xpath = "//p[text()='Your DriveWealth ID']/following-sibling::p")
	WebElement driveWealthId1;
	
	

	@FindBy(xpath = "//p[text()='Bank Name']/following-sibling::p")
	WebElement bankName;

	@FindBy(xpath = "//p[text()='Amount Transferred in USD']/following-sibling::p")
	WebElement amountTransferredInUSD;

	@FindBy(xpath = "//input[@placeholder='Select date']")
	WebElement selectDate;
	
	@FindBy(xpath = "//input[@placeholder='DD/MM/YYYY']")
	WebElement selectDate1;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement enterPassword;

	@FindBy(xpath = "//label[@for= 'uploadreceipt']")
	WebElement uploadFile;

	@FindBy(xpath = "//input[@id= 'uploadreceipt']")
	WebElement uploadFileInput;

	@FindBy(xpath = "//span[text()='SUBMIT']/parent::button")
	WebElement submitButton;

	@FindBy(xpath = "//span[text()='Back to Dashboard']/parent::button")
	WebElement backToDashboardButton;

	@FindBy(xpath = "//p[text() = 'Settled Cash']")
	WebElement settleCash;

	@FindBy(xpath = "(//p[contains(text(),' DriveWealth charges a $')])[1]")
	WebElement driveWealthNote;

	@FindBy(xpath = "//span[text()='Next']/parent::button")
	WebElement nextButton_2;

	@FindBy(xpath = "//input[@name='withdrawalAmount']")
	WebElement withdrawAmount;

	@FindBy(xpath = "//p[@color='danger']")
	WebElement withdrawAmountErrorMessage;

	@FindBy(xpath = "//input[@name = 'beneficiaryName']")
	WebElement beneficiaryName;

	@FindBy(xpath = "//input[@name = 'beneficiaryAccountNumber']")
	WebElement beneficiaryAccountNumber;

	@FindBy(xpath = "//input[@name = 'retypeAccountNumber']")
	WebElement retypeAccountNumber;

	@FindBy(xpath = "//div[@data-testid='withdrawal-account-type-input']")
	WebElement accountTypeDropDown;

	@FindBy(xpath = "//input[@name = 'beneficiarySwiftABA']")
	WebElement swiftCode;

	@FindBy(xpath = "//input[@name = 'retypeSwift']")
	WebElement retypeSwiftCode;

	@FindBy(xpath = "//input[@name = 'beneficiaryBankName']")
	WebElement beneficiaryBankName;

	@FindBy(xpath = "//input[@name = 'beneficiaryBankAddress']")
	WebElement beneficiaryBankAddress;

	@FindBy(xpath = "//div[@name='beneficiaryBankCountry']")
	WebElement selectBankCountryDropDown;

	@FindBy(xpath = "//input[@name = 'beneficiaryBankProvince']")
	WebElement beneficiaryBankProvince;

	@FindBy(xpath = "//input[@name = 'beneficiaryBankCity']")
	WebElement beneficiaryBankCity;

	@FindBy(xpath = "//input[@name = 'beneficiaryBankZip']")
	WebElement beneficiaryBankZip;

	@FindBy(xpath = "//span[text() = 'Continue']/parent::button")
	WebElement continueButton;

	@FindBy(xpath = "//p[text() = 'enter verification code']")
	WebElement otpPage;
	
	@FindBy(xpath = "//p[contains(text(),'You have entered an invalid OTP.')]")
	WebElement invalidOtpMessage;
	
	
	
	@FindBy(xpath = "//p[text()='Next']//parent::button")
	WebElement addFundPopupNextButton;
	
	@FindBy(xpath = "//p[text()='Got It']//parent::button")
	WebElement addFundPopupGotItButton;
	
	@FindBy(xpath = "//p[text()='Account Information']//parent::div//*[local-name()='svg']")
	WebElement AccountInfoCopy;
	
	@FindBy(xpath = "//p[text()='Beneficiary Information']//parent::div//p[text()='Name']//parent::div//*[local-name()='svg']")
	WebElement beneficiaryNameCopy;
	
	@FindBy(xpath = "//p[text()='Beneficiary Information']//parent::div//p[text()='Account Number']//parent::div//*[local-name()='svg']")
	WebElement beneficiaryAccountNumberCopy;
	
	@FindBy(xpath = "//p[text()='Beneficiary Information']//parent::div//p[text()='Address']//parent::div//*[local-name()='svg']")
	WebElement beneficiaryAddressCopy;
	
	@FindBy(xpath = "//p[text()='Beneficiary Information']//parent::div//p[text()='Email']//parent::div//*[local-name()='svg']")
	WebElement beneficiaryEmailCopy;
	
	@FindBy(xpath = "//p[text()='Beneficiary Information']//parent::div//p[text()='Phone Number']//parent::div//*[local-name()='svg']")
	WebElement beneficiaryPhoneNumberCopy;
	
	@FindBy(xpath = "//p[text()='Bank Information']//parent::div//p[text()='Name']//parent::div//*[local-name()='svg']")
	WebElement bankNameCopy;
	
	@FindBy(xpath = "//p[text()='Bank Information']//parent::div//p[contains(text(),'Routing Number')]//parent::div//*[local-name()='svg']")
	WebElement bankRoutingNumberCopy;
	
	@FindBy(xpath = "//p[text()='Bank Information']//parent::div//p[text()='SWIFT Code']//parent::div//*[local-name()='svg']")
	WebElement bankSwiftCodeCopy;
	
	@FindBy(xpath = "//p[text()='Bank Information']//parent::div//p[text()='Address']//parent::div//*[local-name()='svg']")
	WebElement bankAddressCopy;
	
	@FindBy(xpath = "//div[@class='ant-message-notice']//span[contains(text(),'Copied')]")
	WebElement copiedToast;
	
	@FindBy(xpath = "//input[@name='bankName']")
	WebElement bankNameInput;
	
	@FindBy(xpath = "//input[@id='uploadreceipt']")
	WebElement uploadBankReceiptInput;
	
	@FindBy(xpath = "//input[@name='transferRequestSubmissionDate']")
	WebElement submissionDateInput;
	
	@FindBy(xpath = "//a[@class='ant-picker-today-btn']")
	WebElement todaySubmissionDate;
	
	@FindBy(xpath = "//span[text()='Email Forms']//parent::button")
	WebElement emailForm;
	
	@FindBy(xpath = "(//span[contains(text(), 'Go Premium and save')]/parent::button)[1]")
	WebElement goPremiumAndSave;
	
	@FindBy(xpath = "//p[text()='Vested USD Balance']//parent::div//following-sibling::p")
	WebElement vestedAvailableBalance;
	
	@FindBy(xpath = "//p[@data-testid='unSettledCash']")
	WebElement UnsettledCash;
	
	@FindBy(xpath = "//p[@data-testid='cashAvailableForTrade']")
	WebElement buyingPower;
	
	@FindBy(xpath = "//span[contains(text(),'File exceeds size limit')]")
	WebElement fileSizeError;
	
	@FindBy(xpath = "//span[contains(text(),'Failed to upload transfer receipt')]")
	WebElement fileTypeError;
	
	@FindBy(xpath = "//p[text()='Select a different funds transfer method']")
	WebElement differentFundsMethod;
	
	@FindBy(xpath = "//p[text()='FUNDS TRANSFER OPTIONS']")
	WebElement fundsOptionsPopup;
	
	@FindBy(xpath = "//p[text()='FUND IN PERSON WITH BANK VISIT']//parent::div")
	WebElement bankVisit;
	
	@FindBy(xpath = "//p[text()='Fund in-person with bank visit']")
	WebElement bankVisitPage;
	
	@FindBy(xpath = "//div[@data-testid='add-fund-select-traditional-method-1']")
	WebElement indianBank;
	
	@FindBy(xpath = "//div[@data-testid='add-fund-select-traditional-method-2']")
	WebElement internationalBank;
	
	@FindBy(xpath = "//div[text()='Notify Us']")
	WebElement notifyUsDropMenu;
	
	@FindBy(xpath = "//div[text()='Transfer']")
	WebElement TransferDropMenu;
	
	@FindBy(xpath = "//span[@class='ant-select-selection-search']")
	WebElement SwitchMethodDropDown;
	
	@FindBy(xpath = "//div[@data-testid='undefined_0']")
	WebElement SwitchMethodDropDownOption1;
	
	@FindBy(xpath = "//div[contains(@title,'Bank visit')]")
	WebElement SwitchMethodDropDownBankVisit;
	
	@FindBy(xpath = "//p[contains(text(),'Thank you for notifying')]")
	WebElement thankuScreen;
	
	@FindBy(xpath = "//p[text()='International Wire Instructions']")
	WebElement internationalWirePage;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'OK, GOT IT')]//parent::button")
	WebElement OkGotIt;
	
	@FindBy(xpath = "//p[text()='Wire date is required']")
	WebElement requiredDateError;
	
	@FindBy(xpath = "//p[text()='Amount is required']")
	WebElement requiredAmountError;
	
	@FindBy(xpath = "//p[text()='Please enter a value greater than or equal to $1']")
	WebElement negativeAmountError;
	
	@FindBy(xpath = "//p[text()='proceed with vested direct']//parent::button")
	WebElement proceedWithVestedDirectButton;
	
	@FindBy(xpath = "//div[@data-testid='undefined_1']")
	WebElement fundsOnlineUsingBank;
	
	

	public FundTransferPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}
	
	public void randomClickOnScreen(WebDriver driver) {
		wait3s();
		try {
			click(amountToTransfer1, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(amountToTransfer1, driver);
		}
		
		try {
			click(enterPassword, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(enterPassword, driver);
		}
		
		
		
	}
	public void enterAmountToTransfer(WebDriver driver,String Amount){
		try {
			waitForElementVisibility(amountToTransfer1, 10, driver);
			clearInputByBackspace(amountToTransfer1,driver);
			sendKeysToWebElement(amountToTransfer1, Amount, driver);
			click(amountToTransfer1, driver);
		}catch (Exception e) {
			waitForElementVisibility(amountToTransfer, 10, driver);
			clearInputByBackspace(amountToTransfer,driver);
			sendKeysToWebElement(amountToTransfer, Amount, driver);
			click(amountToTransfer, driver);
		}
		
		
	}
	
	public String getSubmissionDate(WebDriver driver){
		waitForElementVisibility(submissionDateInput, 10,driver);
		String Date = getElementAttributeValue(submissionDateInput, "value", driver);
		return Date;
	}
	
	public void enterDate(WebDriver driver,String Date){
		click(submissionDateInput, driver);
		waitForElementVisibility(submissionDateInput, 10,driver);
		click(todaySubmissionDate,driver);
		String dat  = submissionDateInput.getAttribute("value");
		for(int i=0 ; i<dat.length()-5 ; i++) {
			submissionDateInput.sendKeys(Keys.ARROW_LEFT);
			wait1s();
		}
		submissionDateInput.sendKeys(Keys.BACK_SPACE);
		wait1s();
		submissionDateInput.sendKeys(Keys.BACK_SPACE);
		wait1s();
		submissionDateInput.sendKeys(Keys.NUMPAD1);
		wait1s();
		submissionDateInput.sendKeys(Keys.NUMPAD2);
		wait1s();
		submissionDateInput.sendKeys(Keys.ENTER);
		wait1s();
	}
	
	public Boolean isFundsOptionPopupDisplaying(WebDriver driver) {
		waitForElementVisibility(fundsOptionsPopup, defaultTimeForVisibility, driver);
		return isElementDisplayed(fundsOptionsPopup, driver);
	}
	public Boolean isRequiredDateErrorDisplaying(WebDriver driver) {
		waitForElementVisibility(requiredDateError, defaultTimeForVisibility, driver);
		return isElementDisplayed(requiredDateError, driver);
	}
	public Boolean isRequiredAmountErrorDisplaying(WebDriver driver) {
		waitForElementVisibility(requiredAmountError, defaultTimeForVisibility, driver);
		return isElementDisplayed(requiredAmountError, driver);
	}
	public Boolean isNegativeAmountErrorDisplaying(WebDriver driver) {
		waitForElementVisibility(negativeAmountError, defaultTimeForVisibility, driver);
		return isElementDisplayed(negativeAmountError, driver);
	}
	public Boolean isThankyouScreenDisplaying(WebDriver driver) {
		return isElementDisplayed(thankuScreen, driver);
	}
	public Boolean isInternationalWireInstructionPageDisplaying(WebDriver driver) {
		waitForElementVisibility(internationalWirePage, defaultTimeForVisibility, driver);
		return isElementDisplayed(internationalWirePage, driver);
	}
	
	public Boolean verifyAddedAmount(WebDriver driver, String Amount) {
		WebElement element = driver.findElement(By.xpath("//p[contains(.,'"+Amount+"')]"));
		waitForElementVisibility(element, defaultTimeForVisibility, driver);
		return isElementDisplayed(element, driver);
	}
	public Boolean isFundsBankVisitPageDisplaying(WebDriver driver) {
		waitForElementVisibility(bankVisitPage, defaultTimeForVisibility, driver);
		return isElementDisplayed(bankVisitPage, driver);
	}
	
	public void clickOnBankVisitButton(WebDriver driver) {
		click(bankVisit, driver);
	}
	public void clickOnOkGotItButton(WebDriver driver) {
		click(OkGotIt, driver);
	}
	
	public void chooseFirstOptionInSwitchTransfer(WebDriver driver) {
		click(SwitchMethodDropDown, driver);
		click(SwitchMethodDropDownOption1, driver);
	}
	public void chooseBankVisitInSwitchTransfer(WebDriver driver) {
		click(SwitchMethodDropDown, driver);
		click(SwitchMethodDropDownBankVisit, driver);
	}
	public void clickOnNotifyUsDropMenu(WebDriver driver) {
		try {
			waitForElementVisibility(notifyUsDropMenu, defaultTimeForVisibility, driver);
			click(notifyUsDropMenu, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(notifyUsDropMenu, driver);
		}
		
	}
	
	public void clickOnTransferDropMenu(WebDriver driver) {
		try {
			waitForElementVisibility(TransferDropMenu, defaultTimeForVisibility, driver);
			click(TransferDropMenu, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(TransferDropMenu, driver);
		}
		
	}
	
	
	
	public void clickOnIndianBankButton(WebDriver driver) {
		waitForElementVisibility(indianBank, defaultTimeForVisibility, driver);
		click(indianBank, driver);
	}
	public void clickOnInternationalBankButton(WebDriver driver) {
		waitForElementVisibility(internationalBank, defaultTimeForVisibility, driver);
		click(internationalBank, driver);
	}
	
	public void clickOnDifferentFundsMethodText(WebDriver driver){
		waitForElementVisibility(differentFundsMethod, 10,driver);
		click(differentFundsMethod, driver);
	}
	public String getErrorMessage(WebDriver driver){
		waitForElementVisibility(withdrawAmountErrorMessage, 10, driver);
		String Text =  getElementText(withdrawAmountErrorMessage, driver);
		return Text;
	}
	
	public Boolean isErrorMessageDisplay(WebDriver driver){
		waitForElementVisibility(withdrawAmountErrorMessage, 10, driver);
		Boolean Text =  isElementDisplayed(withdrawAmountErrorMessage, driver);
		return Text;
	}
	
	public Boolean isSizeLimitErrorMessageDisplay(WebDriver driver){
		waitForElementVisibility(fileSizeError, 30,driver);
		 return isElementDisplayed(fileSizeError, driver);
		
	}
	
	public Boolean isProceedWithVestedDirectDisplay(WebDriver driver){
		waitForElementVisibility(proceedWithVestedDirectButton, 30,driver);
		 return isElementDisplayed(proceedWithVestedDirectButton, driver);
		
	}
	
	
	public Boolean isInvalidTypeErrorMessageDisplay(WebDriver driver){
		waitForElementVisibility(fileTypeError, 30,driver);
		 return isElementDisplayed(fileTypeError, driver);
	}
	
	public void clickOnBtnTransfer(WebDriver driver) {
		click(btnTransfer, driver);
	}
	public Double getBuyingPower(WebDriver driver) {
		String BuyingP = "";
		wait6s();
		try {
			scrollIntoViewSmoothly(buyingPower, driver);
			waitForElementVisibility(buyingPower, "30", driver);
			BuyingP = getElementText(buyingPower, driver);
		}catch (Exception e) {
			getRefreshWebPage(driver);
			waitUntilElementDisplayed(buyingPower, driver);
			scrollIntoViewSmoothly(buyingPower, driver);
			waitForElementVisibility(buyingPower, "30", driver);
			BuyingP = getElementText(buyingPower, driver);
		}
		
		return Double.valueOf(BuyingP.replace("$", "").replace(",", ""));
	}
	public Double getUnSettledCash(WebDriver driver) {
		String Cost = "";
		try {
			scrollIntoViewSmoothly(UnsettledCash, driver);
			waitForElementVisibility(UnsettledCash, "30", driver);
			Cost = getElementText(UnsettledCash, driver);
		}catch (Exception e) {
			getRefreshWebPage(driver);
			waitUntilElementDisplayed(UnsettledCash, driver);
			scrollIntoViewSmoothly(UnsettledCash, driver);
			waitForElementVisibility(UnsettledCash, "30", driver);
			Cost = getElementText(UnsettledCash, driver);
		}
		
		return Double.valueOf(Cost.replace("$", "").replace(",", ""));
	}
	
	public Double getvestedAvailableBalance(WebDriver driver) {
		Double Amount = 0.0;
		waitForElementVisibility(vestedAvailableBalance, defaultTimeForVisibility, driver);
		Amount = Double.valueOf(getElementText(vestedAvailableBalance, driver).replace(",", "").replace("USD", "").toString());
		return Amount;
	}
	
	public String getSlackMessage(WebDriver driver, String email, String env,String type) {
		String  slackMessage = "@Apurva @Anjali Vikas Kumar\n"
				+ "**********************************************\n"
				+"Web - Insufficient "+type+"("+env+")\n"
				+ "--------------------\n"
				+ "Cash dependent test scripts will be skipped due to insufficient "+type+". \n"
				+ "Kindly add funds and re-run the job.\n" + "Email: "
				+ email
				+ "\n**********************************************";
		return slackMessage;
	}
	
	
	
	public void closeAddFundGuide(WebDriver driver) {
		
		for(int i = 0;i<=3;i++) {
			try {
				waitForElementVisibility(addFundPopupNextButton, "30", driver);
				try {
					click(btnNext, driver);
				}catch (Exception e) {
					clickUsingJavascriptExecutor(addFundPopupNextButton, driver);
				}			
			}catch (Exception e) {
				System.out.print("Next Button Not Shown");
			}
		}
		try {
			waitForElementVisibility(addFundPopupGotItButton, "30", driver);
			try {
				click(addFundPopupGotItButton, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(addFundPopupGotItButton, driver);
			}
			
		}catch (Exception e) {
			System.out.print("Got It Button Not Shown");
		}
		
	}
	
	public void clickOnBtnNext(WebDriver driver) {		
		try {
			waitForElementVisibility(btnNext, "30", driver);
			try {
				click(btnNext, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(btnNext, driver);
			}			
		}catch (Exception e) {
			System.out.print("Next Button Not Shown");
		}		
	}
	
	public void clickOnBtnOkGotIt(WebDriver driver) {
		try {
			waitForElementVisibility(btnOkGotIt, "30", driver);
			try {
				click(btnOkGotIt, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(btnOkGotIt, driver);
			}
			
		}catch (Exception e) {
			System.out.print("Next Button Not Shown");
		}
		
	}
	
	public void clickOnBtnAddFund(WebDriver driver) {
		waitForElementVisibility(btnAddFund, "30", driver);
		waitForElementClickable(btnAddFund, "20", driver);
		scrollIntoViewSmoothly(btnAddFund, driver);
		try {
			click(btnAddFund, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnAddFund, driver);
		}
		
		try {
			try {
				waitfor3sec();
				assertTrue(isAddFundModalMessage(driver),
						"Verified <b>'Add Funds'</b> popup Heading is showing");
			} catch (Exception e) {
				waitTime(2500);
				assertTrue(isAddFundModalMessageShowing(driver),
						"Verified <b>'How US fund transfers work with Vested?'</b> message is showing");
			}

			closeModal(driver);
			waitForElementVisibility(btnAddFund, "30", driver);
			waitForElementClickable(btnAddFund, "20", driver);
			scrollIntoViewSmoothly(btnAddFund, driver);
			try {
				click(btnAddFund, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(btnAddFund, driver);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public void clickOnBtnAddFundWithoutModal(WebDriver driver) {
		waitForElementVisibility(btnAddFund, "30", driver);
		waitForElementClickable(btnAddFund, "20", driver);
		scrollIntoViewSmoothly(btnAddFund, driver);
		try {
			click(btnAddFund, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnAddFund, driver);
		}
	}

	
	
	public boolean isAddFundModalMessageShowing(WebDriver driver) {
		return isElementDisplayed(fundModalText, driver);
	}
	public boolean isTransferModeShowing(WebDriver driver , String tranferMode) {
		WebElement element = driver.findElement(By.xpath("//div[text()='"+tranferMode+"']"));
		return isElementDisplayed(element, driver);
	}
	
	public void clickOnTranfersMode(WebDriver driver , String tranferMode) {
		WebElement element = driver.findElement(By.xpath("//div[text()='"+tranferMode+"']"));
		try {
			click(element, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(element, driver);
		}
		
	}
	
	public boolean isAddFundModalMessage(WebDriver driver) {
		waitForElementVisibility(addFundText, "30", driver);
		return isElementDisplayed(addFundText, driver);
	}
	
	public String getAddFundModalMessage(WebDriver driver) {
		return getElementText(fundModalText, driver);
	}
	
	public String getAddFundModelHeading(WebDriver driver) {
		return getElementText(addFundText, driver);
	}
	public void clickOnCloseIcon(WebDriver driver) {
		try {
			waitForElementVisibility(AddFundCloseIcon, "30", driver);
			click(AddFundCloseIcon, driver);
		}catch (Exception e) {
			waitForElementVisibility(AddFundCloseIcon2, "30", driver);
			click(AddFundCloseIcon2, driver);
		}
	}
	
	public void closeModal(WebDriver driver) {
		try {
			clickOnCloseIcon( driver);
		}catch (Exception e) {
			click(modalSliderDots, driver);
			waitTime(1000, driver);
			scrollIntoViewSmoothly(btnGotIt, driver);
			waitTime(2000, driver);
			click(btnGotIt, driver);
			waitTime(1000, driver);
			click(btnCloseModal, driver);
		}
		
		
		
		
	}
	
	public void clickOnWithdrawFundBtn(WebDriver driver) {
		wait3s();
		click(btnWithdrawFund, driver);
	}
	
	public boolean isAmountToWithdrawLabelDisplaying(WebDriver driver) {
		return isElementDisplayed(amountToWithdrawLabel, driver);
	}

	public void clickOnTransferTab(WebDriver driver){
		waitForElementVisibility(transferTab, 10, driver);
		click(transferTab, driver);
	}

	public boolean isSubscribeAndSaveButtonPresent(WebDriver driver){
		try{
			waitForElementVisibility(subscribeAndSaveButton, "10", driver);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	public boolean isGoPremiumAndSaveButtonPresent(WebDriver driver){
		try{
			waitForElementVisibility(goPremiumAndSave, "10", driver);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public void clickOnSwitchBankButton(WebDriver driver){
		waitForElementVisibility(switchBankButton, 10, driver);
		click(switchBankButton, driver);
	}
	
	public void clickOnNonIndianBank(WebDriver driver){
		waitForElementVisibility(nonIndianBank, 10, driver);
		click(nonIndianBank, driver);
	}
	
	public void clickOnBank(WebDriver driver, String bankname){
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+bankname+"']//parent::div"));
		waitForElementVisibility(ele, 10, driver);
		click(ele, driver);
	}
	
	public void clickOnOtherIndianBank(WebDriver driver){
		waitForElementVisibility(otherIndianBank, 10, driver);
		click(otherIndianBank, driver);
	}
	
	public void clickOnHDFCBank(WebDriver driver){
		waitForElementVisibility(HDFCBank, 10, driver);
		click(HDFCBank, driver);
	}
	
	public void clickOnKotakMahindraBank(WebDriver driver){
		waitForElementVisibility(kotakMahindraBank, 10, driver);
		click(kotakMahindraBank, driver);
	}
	public void clickOnIDFCFirstBank(WebDriver driver){
		waitForElementVisibility(IDFCFirstBank, 10, driver);
		click(IDFCFirstBank, driver);
	}
	public void clickOnIndusIndBank(WebDriver driver){
		waitForElementVisibility(indusIndBank, 10, driver);
		click(indusIndBank, driver);
	}
	public void clickOnYesBank(WebDriver driver){
		waitForElementVisibility(yesBank, 10, driver);
		click(yesBank, driver);
	}
	public void clickOnBankOfBaroda(WebDriver driver){
		waitForElementVisibility(bankofBaroda, 10, driver);
		click(bankofBaroda, driver);
	}

	public void clickOnCitiBank(WebDriver driver){
		waitForElementVisibility(citiBank, 10, driver);
		click(citiBank, driver);
	}

	public void clickOnHSBCBank(WebDriver driver){
		waitForElementVisibility(HSBCBank, 10, driver);
		click(HSBCBank, driver);
	}

	public void clickOnStateBankofIndia(WebDriver driver){
		waitForElementVisibility(stateBankofIndia, 10, driver);
		click(stateBankofIndia, driver);
	}
	
	public void clickOnPunjabNationalBank(WebDriver driver){
		waitForElementVisibility(punjabNationalBank, 10, driver);
		click(punjabNationalBank, driver);
	}	
	
	public  void enterSearchBank(String keys, WebDriver driver){
		waitForElementVisibility(searchBank, 10, driver);
		type(searchBank, keys, driver);
	}

	public boolean isICICIBankImagePresent(WebDriver driver){
		waitForElementVisibility(ICICIBankImage, 10, driver);
		return isElementDisplayed(ICICIBankImage, driver);
	}

	public void clickOnICICIBank(WebDriver driver){
		waitForElementVisibility(ICICIBank, 10,driver);
		click(ICICIBank, driver);
	}
	
	public void clickOnAxisBank(WebDriver driver){
		waitForElementVisibility(axisBank, 10,driver);
		click(axisBank, driver);
	}
	
	

	public  void enterAmountToTransfer(String keys, WebDriver driver){
		try {
			waitForElementVisibility(amountToTransfer1, 10, driver);
			type(amountToTransfer1, keys, driver);
		}catch (Exception e) {
			waitForElementVisibility(amountToTransfer, 10, driver);
			type(amountToTransfer, keys, driver);
		}
		
	}

	public boolean isICICIBankTransferFromDisabled(WebDriver driver){
		waitForElementVisibility(transferFrom, 10, driver);
		return transferFrom.isEnabled();
	}

	public void clickOnNEXTButton(WebDriver driver){
		waitForElementVisibility(nextButton, 10,driver);
		click(nextButton, driver);
	}
	
	
	public void enterBankName(WebDriver driver,String BankName){
		waitForElementVisibility(bankNameInput, 10,driver);
		sendKeysToWebElement(bankNameInput,BankName, driver);
	}
	
	public void uploadRecipt(WebDriver driver,String filePath){
//		waitForElementVisibility(uploadBankReceiptInput, 10,driver);
		printString(filePath);
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('hidden')",uploadBankReceiptInput);
			sendKeysToWebElement(uploadBankReceiptInput,filePath, driver);
		}catch (Exception e) {
			sendKeysToWebElementUsingExecutor(uploadBankReceiptInput, filePath, driver);
		}
		
	}
	
	
	
	public void enterSubmissionDate(WebDriver driver,String Date){
		printString(Date);
		click(submissionDateInput, driver);
		waitForElementVisibility(submissionDateInput, 10,driver);
		click(todaySubmissionDate,driver);
//		sendKeysToWebElement(submissionDateInput,Date, driver);
//		click(submissionDateInput, driver);
	}
	
	
	public void clickOnEmailForm(WebDriver driver) {
		waitForElementVisibility(emailForm, defaultTimeForVisibility, driver);
		click(emailForm, driver);
		
	}
	
	public ArrayList<String> verifyCopyIcons(WebDriver driver){
		boolean flag = false;
		ArrayList<String> testSteps = new ArrayList<String>();
		
		testSteps.add("Click On <b>'Account Info Copy'</b> Icon");
		waitForElementVisibility(AccountInfoCopy, 10,driver);
		click(AccountInfoCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");

		testSteps.add("Click On <b>'Beneficiary Name Copy'</b> Icon");
		waitForElementVisibility(beneficiaryNameCopy, 10,driver);
		click(beneficiaryNameCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Beneficiary Account Number Copy'</b> Icon");
		waitForElementVisibility(beneficiaryAccountNumberCopy, 10,driver);
		click(beneficiaryAccountNumberCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Beneficiary Address Copy'<b/> Icon");
		waitForElementVisibility(beneficiaryAddressCopy, 10,driver);
		click(beneficiaryAddressCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Beneficiary Email Copy'</b> Icon");
		waitForElementVisibility(beneficiaryEmailCopy, 10,driver);
		click(beneficiaryEmailCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Beneficiary Phone Number Copy'</b> Icon");
		waitForElementVisibility(beneficiaryPhoneNumberCopy, 10,driver);
		click(beneficiaryPhoneNumberCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Bank Name Copy'</b> Icon");
		waitForElementVisibility(bankNameCopy, 10,driver);
		click(bankNameCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Bank Routing Number Copy'</b> Icon");
		waitForElementVisibility(bankRoutingNumberCopy, 10,driver);
		click(bankRoutingNumberCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Bank SWIFT Code Copy'</b> Icon");
		waitForElementVisibility(bankSwiftCodeCopy, 10,driver);
		click(bankSwiftCodeCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		testSteps.add("Click On <b>'Bank Address Copy'</b> Icon");
		waitForElementVisibility(bankAddressCopy, 10,driver);
		click(bankAddressCopy, 10, driver);
		testSteps.add("Verifying is Copied Success Toast showing");
		waitForElementVisibility(copiedToast, 10,driver);
		flag = copiedToast.isDisplayed();
		assertTrue(flag," Failed: Copied Success Toast is not showing");
		testSteps.add("Verified: Copied Success Toast is showing");
		
		
		
		return testSteps;
	}
	

	public void clickOnDownloadInstructionButton(WebDriver driver){
		try {
			waitForElementVisibility(downloadInstructionButton, 10,driver);
			click(downloadInstructionButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(downloadInstructionButton, driver);
		}
		
	}
	public Boolean isDownloadInstructionButtonPresent(WebDriver driver){
		return isElementDisplayed(downloadInstructionButton, driver);
	}
	
	public Boolean isEmailFormButtonPresent(WebDriver driver){
		return isElementDisplayed(emailForm, driver);
	}

	public boolean isPreviousPresent(WebDriver driver){
		waitForElementVisibility(previousButton, 10, driver);
		return isElementDisplayed(previousButton, driver);
	}

	public boolean isContinueLaterPresent(WebDriver driver){
		waitForElementVisibility(continueLaterButton, 10, driver);
		return isElementDisplayed(continueLaterButton, driver);
	}

	public boolean isYourNamePresent(WebDriver driver){
		scrollIntoViewSmoothly(yourName, driver);
		waitForElementVisibility(yourName, 10, driver);
		return isElementDisplayed(yourName, driver);
	}

	public boolean isDriveWealthIdPresent(WebDriver driver){
		try {
			scrollIntoViewSmoothly(driveWealthId1, driver);
			waitForElementVisibility(driveWealthId1, 10, driver);
			return isElementDisplayed(driveWealthId1, driver);
		}catch (Exception e) {
			scrollIntoViewSmoothly(driveWealthId, driver);
			waitForElementVisibility(driveWealthId, 10, driver);
			return isElementDisplayed(driveWealthId, driver);
		}
		
	}

	public boolean isBankNamePresent(WebDriver driver){
		waitForElementVisibility(bankName, 10, driver);
		return isElementDisplayed(bankName, driver);
	}

	public boolean isAmountTransferredInUSDPresent(WebDriver driver){
		waitForElementVisibility(amountTransferredInUSD, 10, driver);
		return isElementDisplayed(amountTransferredInUSD, driver);
	}

	public void selectDate(String keys, WebDriver driver){
		try {
			waitForElementVisibility(selectDate1, 10, driver);
			selectDate1.sendKeys(keys);
		}catch (Exception e) {
			waitForElementVisibility(selectDate, 10, driver);
			selectDate.sendKeys(keys);
		}
		
	}

	public void enterFilePassword(String keys, WebDriver driver){
		waitForElementVisibility(enterPassword, 10, driver);
		type(enterPassword, keys, driver);
	}

	public void uploadFile(String keys, WebDriver driver){
		scrollIntoViewSmoothly(uploadFile, driver);
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('uploadreceipt').style.display='block';");
		uploadFileInput.sendKeys(keys);
	}

	public void clickOnSubmitButton(WebDriver driver){
		waitForElementVisibility(submitButton, 10,driver);
		click(submitButton, driver);
	}

	public void clickOnBackToDashboardButton(WebDriver driver){
		waitForElementVisibility(backToDashboardButton, 10,driver);
		click(backToDashboardButton, driver);
	}
	
	public Boolean isTrasactionPresent(WebDriver driver, String amount){
//		Double val = Double.valueOf(amount);
		WebElement ele = driver.findElement(By.xpath("(//p[@color='success'])[1]"));
		scrollIntoViewSmoothly(ele, driver);
		return ele.getText().replace("$", "").contains(amount);
	}

	public boolean isSettledCashPresent(WebDriver driver){
		waitForElementVisibility(settleCash, 10, driver);
		return isElementDisplayed(settleCash, driver);
	}

	public boolean isDriveWealthNodePresent(WebDriver driver){
		waitForElementVisibility(driveWealthNote, 10, driver);
		return isElementDisplayed(driveWealthNote, driver);
	}

	public boolean isNextButton_2Present(WebDriver driver){
		waitForElementVisibility(nextButton_2, 10, driver);
		return isElementDisplayed(nextButton_2, driver);
	}

	public void clickOnNextButton_2(WebDriver driver){
		waitForElementClickable(nextButton_2, "10", driver);
		click(nextButton_2, driver);
	}

	public void clickOnSubscribeAndSaveButton(WebDriver driver){
		try {
			waitForElementClickable(goPremiumAndSave, "10", driver);
			click(goPremiumAndSave, driver);
		}catch (Exception e) {
			waitForElementClickable(subscribeAndSaveButton, "10", driver);
			click(subscribeAndSaveButton, driver);
		}
		
	}

	public void enterWithdrawAmount(String keys, WebDriver driver){
		waitForElementVisibility(withdrawAmount, 10, driver);
		type(withdrawAmount, keys, driver);
	}

	public boolean isWithdrawAmountErrorMessagePresent(WebDriver driver){
		waitForElementVisibility(withdrawAmountErrorMessage, 10, driver);
		return isElementDisplayed(withdrawAmountErrorMessage, driver);
	}

	public void enterBeneficiaryName(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryName, 10, driver);
		type(beneficiaryName, keys, driver);
	}

	public void enterBeneficiaryAccountNumber(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryAccountNumber, 10, driver);
		type(beneficiaryAccountNumber, keys, driver);
	}

	public void enterRetypeAccountNumber(String keys, WebDriver driver){
		waitForElementVisibility(retypeAccountNumber, 10, driver);
		type(retypeAccountNumber, keys, driver);
	}

	public void selectAccountType(String accountType, WebDriver driver){
		waitForElementVisibility(accountTypeDropDown, 10, driver);
		click(accountTypeDropDown, driver);
		WebElement element = driver.findElement(By.xpath("//div[text()= '"+accountType+"']"));
		click(element, driver);
	}

	public void enterSwiftCode(String keys, WebDriver driver){
		waitForElementVisibility(swiftCode, 10, driver);
		type(swiftCode, keys, driver);
	}

	public void enterRetypeSwiftCode(String keys, WebDriver driver){
		waitForElementVisibility(retypeSwiftCode, 10, driver);
		type(retypeSwiftCode, keys, driver);
	}

	public void enterBeneficiaryBankName(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryBankName, 10, driver);
		type(beneficiaryBankName, keys, driver);
	}

	public void enterBeneficiaryBankAddress(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryBankAddress, 10, driver);
		type(beneficiaryBankAddress, keys, driver);
	}

	public void selectBankCountry(String country, WebDriver driver){
		try {
			waitForElementVisibility(selectBankCountryDropDown, 10, driver);
			click(selectBankCountryDropDown, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(selectBankCountryDropDown, driver);
		}
		
		try {
			WebElement element = driver.findElement(By.xpath("//div[text()= '"+country+"']"));
			click(element, driver);
		}catch (Exception e) {
			WebElement element = driver.findElement(By.xpath("//div[text()= '"+country+"']"));
			clickUsingJavascriptExecutor(element, driver);
		}
		
	}

	public void selectBeneficiaryBankProvince(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryBankProvince, 10, driver);
		type(beneficiaryBankProvince,keys,  driver);
	}

	public void enterBeneficiaryBankCity(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryBankCity, 10, driver);
		type(beneficiaryBankCity, keys, driver);
	}

	public void enterBeneficiaryBankZipCode(String keys, WebDriver driver){
		waitForElementVisibility(beneficiaryBankZip, 10, driver);
		type(beneficiaryBankZip, keys, driver);
	}

	public void clickOnContinueButton(WebDriver driver){
		waitForElementClickable(continueButton, "10", driver);
		click(continueButton, driver);
	}
	
	public void enterValidationPin(WebDriver driver){
		for(int i=1; i<=6 ;i++ ) {
			waitForElementVisibility(driver.findElement(By.xpath("(//input[@data-testid='withdrawal-otp-pin'])["+i+"]")), "10", driver);
			sendKeysToWebElement(driver.findElement(By.xpath("(//input[@data-testid='withdrawal-otp-pin'])["+i+"]")), "1", driver);
		}
	}
	
	

	public boolean isOTPPagePresent(WebDriver driver){
		waitForElementVisibility(otpPage, 10, driver);
		return isElementDisplayed(otpPage, driver);
	}
	public boolean isInvalidOTPMessagePresent(WebDriver driver){
		waitForElementVisibility(invalidOtpMessage, 10, driver);
		return isElementDisplayed(invalidOtpMessage, driver);
	}
	

	public void clickOnBtnAddFund_(WebDriver driver) {
		waitForElementVisibility(btnAddFund, "30", driver);
		waitForElementClickable(btnAddFund, "20", driver);
		scrollIntoViewSmoothly(btnAddFund, driver);
		try {
			click(btnAddFund, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnAddFund, driver);
		}		
	}
	public void clickOnFundsOnlineUsingBank(WebDriver driver) {
		WebElement ele = driver.findElement(By.xpath("//span[@class='ant-select-arrow']//parent::div"));
		setAttribute(driver,ele,"class","ant-select ant-select-focused ant-select-single ant-select-show-arrow ant-select-open");
			clickUsingJavascriptExecutor(fundsOnlineUsingBank, driver);
	}
	
	
	
	
}
