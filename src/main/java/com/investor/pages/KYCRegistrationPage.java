package com.investor.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.investor.base.BaseClass;
import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes.Array;

public class KYCRegistrationPage extends BaseClass {

	private WebDriver podriver = null;
	@FindBy(xpath = ("//input[@type='password']"))
	WebElement appPasswordInput;

	@FindBy(xpath = ("//span[contains(text(),'Start KYC')]//parent::button | //*[contains(text(),'START KYC')]//parent::div| //span[contains(text(),'Complete KYC')]//parent::button"))
	WebElement btnStartKYC;

	@FindBy(xpath = ("//span[text()='ACCEPT AND CONTINUE']//parent::button"))
	WebElement acceptAndContinueBtn;

	@FindBy(xpath = ("//p[text()='Male']//parent::div"))
	WebElement maleGender;

	@FindBy(xpath = ("//p[text()='Female']//parent::div"))
	WebElement femaleGender;

	@FindBy(xpath = ("//p[text()='Single']//parent::div"))
	WebElement singleMarital;

	@FindBy(xpath = ("//p[text()='Divorced']//parent::div"))
	WebElement divorcedMarital;

	@FindBy(xpath = ("//p[text()='Married']//parent::div"))
	WebElement marriedMarital;

	@FindBy(xpath = ("//p[text()='Widowed']//parent::div"))
	WebElement widowedMarital;

	@FindBy(xpath = ("//p[text()='Domestic Partner']//parent::div"))
	WebElement domesticPartnerMarital;

	@FindBy(xpath = ("//p[text()='Retired']//parent::div"))
	WebElement retiredStatus;

	@FindBy(xpath = ("//p[text()='Employed']//parent::div"))
	WebElement employedStatus;

	@FindBy(xpath = ("//p[text()='Student']//parent::div"))
	WebElement studentStatus;

	@FindBy(xpath = ("//p[text()='Self Employed']//parent::div"))
	WebElement selfEmployedStatus;

	@FindBy(xpath = ("//p[text()='Unemployed']//parent::div"))
	WebElement unemployedStatus;

	@FindBy(xpath = ("(//span[@class = 'ant-select-selection-search']/child::input)[1]"))
	WebElement whichIndustry;

	@FindBy(xpath = ("//div[@name='type']//input"))
	WebElement whichIndustry1;

	@FindBy(xpath = ("//div[text() = 'Arts, Entertainment, and Recreation']"))
	WebElement selectIndustryArts;

	@FindBy(xpath = ("(//span[@class = 'ant-select-selection-search']/child::input)[2]"))
	WebElement whichPosition;

	@FindBy(xpath = ("//div[@name='position']//input"))
	WebElement whichPosition1;

	@FindBy(xpath = ("//div[text() = 'Accountant']"))
	WebElement selectPositionAccountant;

	@FindBy(xpath = ("//input[@placeholder = 'Company name']"))
	WebElement companyName;

	@FindBy(xpath = ("//input[@placeholder = 'Company City']"))
	WebElement companyCity;

	@FindBy(xpath = ("//p[text()= 'My family member or I work at a US brokerage firm']/parent::span/parent::label"))
	WebElement usBrokerageFirm;

	@FindBy(xpath = ("//p[text()= 'My family member or I am a political exposed person or a public official']/parent::span/parent::label"))
	WebElement publicOfficial;

	@FindBy(xpath = ("//span[contains(text(), 'My family member or I am')]/parent::p//parent::span"))
	WebElement publicOfficial1;

	@FindBy(xpath = ("//input[@placeholder = 'Please provide the names of the officials']"))
	WebElement publicOfficialNames;

	@FindBy(xpath = ("//p[text() = 'A valid name is required.']"))
	WebElement publicOfficialNamesErrorMessage;

	@FindBy(xpath = ("//p[text()= 'I am a director, officer, or at least a 10% stock owner of a US-listed public company']/parent::span/parent::label"))
	WebElement usListedPublicCompany;

	@FindBy(xpath = ("//input[@name= 'directorOf']"))
	WebElement usListedPublicCompanyName;

	By usListedPublicCompanyNameBy = By.xpath(
			"//input[@placeholder = 'Please list each companyâ€™s name and ticker symbol (e.g. â€œApple Inc. AAPLâ€�)']");

	@FindBy(xpath = ("//p[text() = 'A valid company name and ticker are required.']"))
	WebElement usListedPublicCompanyNameErrorMessage;

	@FindBy(xpath = ("//input[@name='noneOfAbove']//parent::span"))
	WebElement noneofAboveOption;

	@FindBy(xpath = ("//button[@data-testid='kyc-bottom-btn-next']"))
	WebElement nextButton;

	@FindBy(xpath = ("//button[@data-testid='kyc-bottom-btn-previous']"))
	WebElement previousButton;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-riskTolerance_0']"))
	WebElement lowRiskTolerate;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-riskTolerance_1']"))
	WebElement moderateRiskTolerate;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-riskTolerance_2']"))
	WebElement highRiskTolerate;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentObjectives_0']"))
	WebElement severalTimeInvest;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentObjectives_1']"))
	WebElement onceInMonthTimeInvest;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentObjectives_2']"))
	WebElement onceInEveryMonthseveralTimeInvest;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentExperience_0']"))
	WebElement oneYearExperience;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentExperience_1']"))
	WebElement twoYearExperience;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentExperience_2']"))
	WebElement threeYearExperience;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentExperience_3']"))
	WebElement fiveYearExperience;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentExperience_4']"))
	WebElement moreThanTenYearExperience;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-annualIncome_0']"))
	WebElement tenlakhYearlyIncome;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-annualIncome_1']"))
	WebElement twentyFivelakhYearlyIncome;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-annualIncome_2']"))
	WebElement fiftylakhYearlyIncome;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-annualIncome_3']"))
	WebElement fiftyPluslakhYearlyIncome;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthLiquid_0']"))
	WebElement fivelakhLiquidworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthLiquid_1']"))
	WebElement tenlakhLiquidworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthLiquid_2']"))
	WebElement thirtylakhLiquidworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthLiquid_3']"))
	WebElement thirtyPluslakhLiquidworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthTotal_0']"))
	WebElement Tenlakh_Totalworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthTotal_1']"))
	WebElement thirtylakh_Totalworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthTotal_2']"))
	WebElement oneCrore_Totalworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-networthTotal_3']"))
	WebElement oneCrorePlus_Totalworth;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferFrequencyPerMonth_0']"))
	WebElement fivelakh_Deposite;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferFrequencyPerMonth_1']"))
	WebElement Tenlakh_Deposite;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferFrequencyPerMonth_2']"))
	WebElement TenPluslakh_Deposite;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentHistory12M_0']"))
	WebElement fivelakh_InvestmentsMade;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentHistory12M_1']"))
	WebElement Tenlakh_InvestmentsMade;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-investmentHistory12M_2']"))
	WebElement TenPluslakh_InvestmentsMade;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferTotalExpected_0']"))
	WebElement FiftyThousand_MoneyPlan;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferTotalExpected_1']"))
	WebElement oneLakh_MoneyPlan;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferTotalExpected_2']"))
	WebElement sevenLakh_MoneyPlan;

	@FindBy(xpath = ("//div[@data-testid='personalization-select-transferTotalExpected_3']"))
	WebElement sevenPLusLakh_MoneyPlan;

	@FindBy(xpath = ("//div[contains(@class,'ant-select-single')]"))
	WebElement selectPrimarySorce;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[2]"))
	WebElement giftPrimarySorce;

	@FindBy(xpath = ("//div[@title='Gift']"))
	WebElement giftPrimarySorce2;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[1]"))
	WebElement employmentPrimarySorce;

	@FindBy(xpath = ("//div[@title='Employment']"))
	WebElement employmentPrimarySorce2;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[4]"))
	WebElement investmentProceedsPrimarySorce;

	@FindBy(xpath = ("//div[@title='Investment Proceeds']"))
	WebElement investmentProceedsPrimarySorce2;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[5]"))
	WebElement savingsPrimarySorce;

	@FindBy(xpath = ("//div[@title='Savings']"))
	WebElement savingsPrimarySorce2;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[6]"))
	WebElement retirementFundsPrimarySorce;

	@FindBy(xpath = ("//div[@title='Retirement Funds']"))
	WebElement retirementFundsPrimarySorce2;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[7]"))
	WebElement gamblingFundsPrimarySorce;

	@FindBy(xpath = ("//div[@title='Gambling']"))
	WebElement gamblingFundsPrimarySorce2;

	@FindBy(xpath = ("(//div[@class='ant-select-item-option-content'])[7]"))
	WebElement legalSettlementFundsPrimarySorce;

	@FindBy(xpath = ("//div[@title='Legal Settlement']"))
	WebElement legalSettlementFundsPrimarySorce2;

	@FindBy(xpath = ("//p[text()='Which country do you primarily file taxes in?']//following-sibling::div//p[text()='Other']"))
	WebElement PrimarlyFileTaxes_OtherOption;

	@FindBy(xpath = ("//input[@id='rc_select_2']"))
	WebElement US_TaxResidency;

	@FindBy(xpath = ("//p[text()='Country of tax residency']//parent::div//input"))
	WebElement US_TaxResidency2;

	@FindBy(xpath = ("//input[@name='taxId']"))
	WebElement TaxID;

	@FindBy(xpath = ("//input[@name='phone']"))
	WebElement PhoneNumber;

	@FindBy(xpath = ("//span[text()='Get OTP']//parent::button"))
	WebElement GetOTP_Button;

	@FindBy(xpath = ("//p[text()='Resend OTP']//parent::button"))
	WebElement ResendOTP_Button;

	@FindBy(xpath = ("//p[text()='Receive OTP via call']//parent::button"))
	WebElement ResendOTPViaCall_Button;

	@FindBy(xpath = ("//p[text()='Continue Anyway']//parent::button"))
	WebElement ContinueAnyway_Button;

	@FindBy(xpath = ("//span[text()='Upload Passport']//parent::button"))
	WebElement UploadPassport_Button;

	@FindBy(xpath = ("(//span[text()='CONFIRM']//parent::button)[1]"))
	WebElement UploadPassportConfirm_Button;

	@FindBy(xpath = ("//span[text()='Upload']//parent::button//parent::div"))
	WebElement Upload_Button;

	@FindBy(xpath = ("//input[@data-cy='proofOfAddress']"))
	WebElement UploadPassportfile;

	@FindBy(xpath = ("//p[text()='Document Uploaded']"))
	WebElement UploadSuccessPopup;

	@FindBy(xpath = ("//label[text()='UPLOAD']"))
	WebElement popUpUpload_Button;

	@FindBy(xpath = ("//img[@data-testid='kyc-modal-btn-close']"))
	WebElement popUpClose_Button;

	@FindBy(xpath = ("//input[@name='addressStreet1']"))
	WebElement Address1Input;

	@FindBy(xpath = ("//span[text()='Verify your identity']//parent::button"))
	WebElement identificationButton;

	@FindBy(xpath = ("//button[contains(@aria-label,'Close identity verification screen')]"))
	WebElement identificationPopupClose;

	@FindBy(xpath = ("//span[contains(text(),'verify your identity')]"))
	WebElement identificationPopupHeading;

	@FindBy(xpath = ("//input[@name='addressStreet2']"))
	WebElement Address2Input;

	@FindBy(xpath = ("//input[@name='addressCity']"))
	WebElement CityInput;

	@FindBy(xpath = ("//input[@name='addressPostalCode']"))
	WebElement PinCodeInput;

	@FindBy(xpath = ("//div[@name='addressProvince']"))
	WebElement provinceInput;

	@FindBy(xpath = ("//input[@name='passportFileNo']"))
	WebElement passportFileNoInput;

	@FindBy(xpath = ("//input[@name='vestedEditPermission']//parent::span"))
	WebElement iConfirmCheckbox;

	@FindBy(xpath = ("//p[text()='Select a subscription plan']"))
	WebElement selectPlanScreenHeading;

	@FindBy(xpath = ("//span[text()='Done']//parent::button"))
	WebElement DoneButton;

	@FindBy(xpath = "//div[contains(@data-testid, 'citizenship')]//p[text()='India']")
	WebElement selectCitizenshipIndia;

	@FindBy(xpath = "(//p[text()='no'])[1]/..")
	WebElement noButtonForMobile;

	@FindBy(xpath = "//span[text()='Upload PAN card']//parent::button")
	WebElement uploadPanCard;

	@FindBy(xpath = "//span[text()='Upload Aadhaar']//parent::button")
	WebElement uploadAadhaarCard;

	@FindBy(xpath = "//input[@name='agree']/..")
	WebElement iAgreeCheckbox;

	@FindBy(xpath = "//input[@name='signedBy']")
	WebElement enterYourFullName;

	@FindBy(xpath = "(//p[text()='KYC Approved'])[1] |  //p[text()='KYC Approved']")
	WebElement kycApproved;

	@FindBy(xpath = "//input[@placeholder='State']")
	WebElement stateInput;

	@FindBy(xpath = "//input[@id='rc_select_1']")
	WebElement citizenshipTaxResidencyInput;

	@FindBy(xpath = "//div[@name='nationality']//input")
	WebElement citizenshipResidencyInput;

	@FindBy(xpath = "//div[@name='primaryTaxResidency']//input")
	WebElement citizenshipTaxResidencyInput2;

	@FindBy(xpath = "//div[contains(text(),'View Details')]")
	WebElement viewDetails;

	@FindBy(xpath = "//div[contains(text(),'Vested for non-professional use?')]//parent::div//parent::div//p[text()='no']//parent::div")
	WebElement nonProfessionalUseButton;

	@FindBy(xpath = "//div[contains(text(),'solely for your personal, non-business use?')]//parent::div//parent::div//p[text()='no']//parent::div")
	WebElement nonBusinessUseButton;

	@FindBy(xpath = "//div[contains(text(),'your business or any other entity?')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement anyOtherEntityButton;

	@FindBy(xpath = "//div[contains(text(),'qualified with the SEC or CFTC?')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement sECOrCFTCButton;

	@FindBy(xpath = "//div[contains(text(),'Are you currently registered or qualified with any securities agency')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement anySecuritiesAgencyButton;

	@FindBy(xpath = "//div[contains(text(),'Whether you are located within or outside the United States')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement outsideUSButton;

	@FindBy(xpath = "//div[contains(text(),'Are you engaged to provide investment')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement provideInvestmentButton;

	@FindBy(xpath = "//div[contains(text(),'Do you use the capital of any other individual')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement anyOtherIndividualButton;

	@FindBy(xpath = "//div[contains(text(),'conduct trading for the benefit of a corporation')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement benefitCorporationButton;

	@FindBy(xpath = "//div[contains(text(),'entered into any agreement to share the profit')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement shareTheProfitButton;

	@FindBy(xpath = "//div[contains(text(),'Are you receiving office space,')]//parent::div//parent::div//p[text()='yes']//parent::div")
	WebElement receivingOfficeSpaceButton;

	@FindBy(xpath = "//span[@data-testid='signature-tax-form-link']")
	WebElement taxFormInformation;

	@FindBy(xpath = "//div[@data-testid='signature-modal-w8ben']")
	WebElement taxFormInformationModal;

	@FindBy(xpath = "//div[@data-testid='signature-modal-w8ben']//ancestor::div[@class='ant-modal-body']//img")
	WebElement taxFormInformationModalClose;

	@FindBy(xpath = "//span[@data-testid='signature-dw-advisory-link'] | //span[@data-testid='signature-disclosure-link']")
	WebElement disclosureAgreement;

	@FindBy(xpath = "//h3[text()='Market Data Agreements']")
	WebElement disclosureAgreementPageHeading;

	@FindBy(xpath = "//span[@data-testid='signature-esign-link']  | //div[@data-testid='signature-esign-link']//span")
	WebElement esign;

	@FindBy(xpath = "//div[@data-testid='signature-modal-esign']")
	WebElement esignModal;

	@FindBy(xpath = "//div[@data-testid='signature-modal-esign']//ancestor::div[@class='ant-modal-body']//img")
	WebElement esignModalCloseIcon;

	@FindBy(xpath = "//span[@data-testid='signature-advisory-link']")
	WebElement advisoryAgreement;

	@FindBy(xpath = "//span[@data-testid='signature-privacy-link']")
	WebElement privacyPolicy;

	@FindBy(xpath = "//h1[text()='Privacy Policy']")
	WebElement privacyPolicyPageHeading;

	@FindBy(xpath = "//p[text()='All Access Account']//parent::div")
	WebElement selectAccountType;

	@FindBy(xpath = "//span[text()='Proceed with All Access Account']//parent::button")
	WebElement proceedAccountTypeButton;

	@FindBy(xpath = "//input[@name='vfsAgreement']/..")
	WebElement vfsAgreementCheckbox;

	@FindBy(xpath = "//input[@name='crsAgreement']/..")
	WebElement crsAgreementCheckbox;

	@FindBy(xpath = "(//div[contains(text(),'Securities Lending Income Program?')]//..//..//div[contains(@class,'e5u38hc1')])[2]")
	WebElement enrollSocityNo;

	@FindBy(xpath = "//button[@data-testid='kyc-bottom-btn-previous']")
	WebElement kycPerviousButton;

	@FindBy(xpath = "//p[contains(text(), 'Nationality is required')]")
	WebElement nationalityErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Tax residence is required')]")
	WebElement taxResidencyErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Gender is required.')]")
	WebElement genderErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Marital status is required.')]")
	WebElement maritalErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Employment status is required.')]")
	WebElement employementStatusErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Please select atleast one option')]")
	WebElement tickAnyErrorMessage;

	@FindBy(xpath = "//input[@name='politicallyExposed']//parent::span")
	WebElement politicallyExposedCheckBox;

	@FindBy(xpath = "//input[@name='director']//parent::span")
	WebElement directorCheckBox;

	@FindBy(xpath = "//p[contains(text(), 'Please enter a valid name(s).')]")
	WebElement politicallyExposedErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'A valid company name and ticker are required.')]")
	WebElement directorErrorMessage;
	
	@FindBy(xpath = "//img[@data-testid='nav-close-icon']")
	WebElement kycCloseIcon;
	
	@FindBy(xpath = "//img[@data-testid='nav-vested-logo']")
	WebElement kycVestedLogo;
	
	@FindBy(xpath = "//img[contains(@src,'undraw')]")
	WebElement kycPageSideIcon;
	
	@FindBy(xpath = "//input[@data-testid='security-input-mobile']  | //input[@data-testid='security-input-phone']")
	WebElement securityMobileNumber;
	
	
	@FindBy(xpath = "//input[@data-testid='security-input-aadhar-no']")
	WebElement securityAadharNumber;
	
	@FindBy(xpath = "//span[text()='Complete KYC']//parent::button")
	WebElement completeKYC;
	
	@FindBy(xpath = "//input[@placeholder='Enter Your Full Name '] | //input[contains(@placeholder,'Enter Your Full Name')]")
	WebElement enterYourNamePlaceholder;
	
	@FindBy(xpath = "//span[contains(text(),'Start KYC process')]//parent::button | //span[contains(text(),'Complete KYC')]//parent::button")
	WebElement startKYC;
	
	@FindBy(xpath = "//p[contains(text(),'Mobile Verification skipped')]")
	WebElement skippedVerification;
	
	@FindBy(xpath = "//span[text()='PROCEED']//parent::button")
	WebElement processedButton;
	
	@FindBy(xpath = "//input[@name='govermentIDNumber']")
	WebElement panInput;
	
	@FindBy(xpath = "//span[text()='Verify PAN']//parent::button")
	WebElement verifyPANButton;
	
	@FindBy(xpath = "//p[contains(text(),'get to know you')]")
	WebElement letGetToKnowYouScreen;
	
	@FindBy(xpath = "//div[text()='Select basic Plan']")
	WebElement basicPlanButton;
	
	@FindBy(xpath = "//input[@id='contact']")
	WebElement contactNumberField;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceedButton;
	
	@FindBy(xpath = "//button[@method='wallet']")
	WebElement walletButton;
	
	@FindBy(xpath = "//span[text()='Airtel Money']//parent::div")
	WebElement airtelMoney;
	
	@FindBy(xpath = "//button[text()='Pay Now']")
	WebElement payNowButton;
	
	@FindBy(xpath = "//button[text()='Success']")
	WebElement successButton;
	
	
	

	public KYCRegistrationPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public void clickOnEnrollSocityYes(WebDriver driver) {
		try {
			click(enrollSocityNo, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(enrollSocityNo, driver);
		}

	}

	public void clickOnKYCPreviousButton(WebDriver driver) {
		click(kycPerviousButton, driver);
	}

	public void checkVfsAgreementCheckbox(WebDriver driver) {
		click(vfsAgreementCheckbox, driver);
	}

	public void checkCrsAgreementCheckbox(WebDriver driver) {
		click(crsAgreementCheckbox, driver);
	}

	public void clickOnAllAccessAccount(WebDriver driver) {
		try {
			click(selectAccountType, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(selectAccountType, driver);
		}

	}

	public void clickOnProceedAllAccessAccount(WebDriver driver) {
		try {
			click(proceedAccountTypeButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(proceedAccountTypeButton, driver);
		}

	}

	public Boolean isTaxFormInformationModal(WebDriver driver) {
		waitForElementVisibility(taxFormInformationModal, defaultTimeForVisibility, driver);
		return isElementDisplayed(taxFormInformationModal, driver);
	}

	public Boolean isprivacyPolicyPageHeadingDisplaying(WebDriver driver) {
		waitForElementVisibility(privacyPolicyPageHeading, defaultTimeForVisibility, driver);
		return isElementDisplayed(privacyPolicyPageHeading, driver);
	}

	public Boolean isEsignModal(WebDriver driver) {
		waitForElementVisibility(esignModal, defaultTimeForVisibility, driver);
		return isElementDisplayed(esignModal, driver);
	}

	public Boolean isDisclosureAgreementPageHeading(WebDriver driver) {
		waitForElementVisibility(disclosureAgreementPageHeading, defaultTimeForVisibility, driver);
		return isElementDisplayed(disclosureAgreementPageHeading, driver);
	}

	public void clickOnDisclosureAgreement(WebDriver driver) {
		waitForElementVisibility(disclosureAgreement, "30", driver);
		try {
			click(disclosureAgreement, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(disclosureAgreement, driver);
		}
	}

	public void clickOnPrivacyPolicy(WebDriver driver) {
		waitForElementVisibility(privacyPolicy, "30", driver);
		try {
			click(privacyPolicy, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(privacyPolicy, driver);
		}
	}

	public void clickOnAdvisoryAgreement(WebDriver driver) {
		waitForElementVisibility(advisoryAgreement, "30", driver);
		try {
			click(advisoryAgreement, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(advisoryAgreement, driver);
		}
	}

	public void clickOnEsignAgreement(WebDriver driver) {
		waitForElementVisibility(esign, "30", driver);
		try {
			click(esign, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(esign, driver);
		}
	}

	public ArrayList<String> verifyDefaultSelectedButtons(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<>();
		testSteps.add(
				"Verifying Yes Button is Selected By Default of 'Do you confirm that you will use Vested for non-professional use?'");
		assertTrue(getElementAttributeValue(nonProfessionalUseButton, "style", driver).contains("transparent"),
				"Failed: Yes Button is Selected By Default of 'Do you confirm that you will use Vested for non-professional use?'");
		testSteps.add(
				"Verified Yes Button is Selected By Default of 'Do you confirm that you will use Vested for non-professional use?'");

		testSteps.add(
				"Verifying Yes Button is Selected By Default of 'Do you use Market Data solely for your personal, non-business use?'");
		assertTrue(getElementAttributeValue(nonBusinessUseButton, "style", driver).contains("transparent"),
				"Failed: Yes Button is Selected By Default of 'Do you use Market Data solely for your personal, non-business use?'");
		testSteps.add(
				"Verified Yes Button is Selected By Default of 'Do you use Market Data solely for your personal, non-business use?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Do you receive Market Data for your business or any other entity?");
		assertTrue(getElementAttributeValue(anyOtherEntityButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Do you receive Market Data for your business or any other entity?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Do you receive Market Data for your business or any other entity?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Are you currently registered or qualified with the SEC or CFTC?'");
		assertTrue(getElementAttributeValue(sECOrCFTCButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Are you currently registered or qualified with the SEC or CFTC?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Are you currently registered or qualified with the SEC or CFTC?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Are you currently registered or qualified with any securities agency, any securities exchange, association or regulatory body, in the United States or elsewhere?'");
		assertTrue(getElementAttributeValue(anySecuritiesAgencyButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Are you currently registered or qualified with any securities agency, any securities exchange, association or regulatory body, in the United States or elsewhere?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Are you currently registered or qualified with any securities agency, any securities exchange, association or regulatory body, in the United States or elsewhere?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Whether you are located within or outside the United States, do you perform any functions that are similar to those that require an individual to register or qualify with the SEC, the CTFC, any other securities agency or regulatory body, any securities exchange or association, or any commodities or futures contract market, association or regulatory body?");
		assertTrue(getElementAttributeValue(outsideUSButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Whether you are located within or outside the United States, do you perform any functions that are similar to those that require an individual to register or qualify with the SEC, the CTFC, any other securities agency or regulatory body, any securities exchange or association, or any commodities or futures contract market, association or regulatory body?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Whether you are located within or outside the United States, do you perform any functions that are similar to those that require an individual to register or qualify with the SEC, the CTFC, any other securities agency or regulatory body, any securities exchange or association, or any commodities or futures contract market, association or regulatory body?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Are you engaged to provide investment advice to any individual or entity?'");
		assertTrue(getElementAttributeValue(provideInvestmentButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Are you engaged to provide investment advice to any individual or entity?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Are you engaged to provide investment advice to any individual or entity?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Do you use the capital of any other individual or entity in the conduct of your trading?");
		assertTrue(getElementAttributeValue(anyOtherIndividualButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Do you use the capital of any other individual or entity in the conduct of your trading?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Do you use the capital of any other individual or entity in the conduct of your trading?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Do you conduct trading for the benefit of a corporation, partnership, or other entity?");
		assertTrue(getElementAttributeValue(benefitCorporationButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Do you conduct trading for the benefit of a corporation, partnership, or other entity?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Do you conduct trading for the benefit of a corporation, partnership, or other entity?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Have you entered into any agreement to share the profit of your trading activities or receive compensation for your trading activities?");
		assertTrue(getElementAttributeValue(shareTheProfitButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Have you entered into any agreement to share the profit of your trading activities or receive compensation for your trading activities?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Have you entered into any agreement to share the profit of your trading activities or receive compensation for your trading activities?'");

		testSteps.add(
				"Verifying No Button is Selected By Default of 'Are you receiving office space, equipment or other benefits in exchange for your trading or work as a financial consultant to any person, firm or business entity?");
		assertTrue(getElementAttributeValue(receivingOfficeSpaceButton, "style", driver).contains("transparent"),
				"Failed: No Button is Selected By Default of 'Are you receiving office space, equipment or other benefits in exchange for your trading or work as a financial consultant to any person, firm or business entity?'");
		testSteps.add(
				"Verified No Button is Selected By Default of 'Are you receiving office space, equipment or other benefits in exchange for your trading or work as a financial consultant to any person, firm or business entity?'");
		return testSteps;

	}

	public void clickOnStartKYC(WebDriver driver) {
		waitForElementVisibility(btnStartKYC, "30", driver);
		try {
			click(btnStartKYC, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(btnStartKYC, driver);
		}
	}

	public void clickOnTaxFormInformationModalClose(WebDriver driver) {
		waitForElementVisibility(taxFormInformationModalClose, "30", driver);
		try {
			click(taxFormInformationModalClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(taxFormInformationModalClose, driver);
		}
	}

	public void clickOnesignModalCloseIcon(WebDriver driver) {
		waitForElementVisibility(esignModalCloseIcon, "30", driver);
		try {
			click(esignModalCloseIcon, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(esignModalCloseIcon, driver);
		}
	}

	public void clickAcceptAndContinue_button(WebDriver driver) {
		waitForElementVisibility(acceptAndContinueBtn, "10", driver);
		try {
			click(acceptAndContinueBtn, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(acceptAndContinueBtn, driver);
		}
	}

	public void clickOnMaleGender(WebDriver driver) {
		waitForElementVisibility(maleGender, "30", driver);
		try {
			click(maleGender, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(maleGender, driver);
		}
	}

	public boolean isMaleGenderClickable(WebDriver driver) {
		try {
			waitForElementClickable(maleGender, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isFemaleGenderClickable(WebDriver driver) {
		try {
			waitForElementClickable(femaleGender, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSingle_Marital(WebDriver driver) {
		waitForElementVisibility(singleMarital, "30", driver);
		try {
			click(singleMarital, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(singleMarital, driver);
		}
	}

	public boolean isSingleMaritalClickable(WebDriver driver) {
		try {
			waitForElementClickable(singleMarital, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDivorcedMaritalClickable(WebDriver driver) {
		try {
			waitForElementClickable(divorcedMarital, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMarriedMaritalClickable(WebDriver driver) {
		try {
			waitForElementClickable(marriedMarital, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isWidowedMaritalClickable(WebDriver driver) {
		try {
			waitForElementClickable(widowedMarital, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDomesticPartnerMaritalClickable(WebDriver driver) {
		try {
			waitForElementClickable(domesticPartnerMarital, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnRetiredStatus(WebDriver driver) {
		waitForElementVisibility(retiredStatus, "30", driver);
		try {
			click(retiredStatus, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(retiredStatus, driver);
		}
	}
	public void clickOnSelfEmployedStatus(WebDriver driver) {
		waitForElementVisibility(selfEmployedStatus, "30", driver);
		try {
			click(selfEmployedStatus, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(selfEmployedStatus, driver);
		}
	}
	
	public void clickOnEmployedStatus(WebDriver driver) {
		waitForElementVisibility(employedStatus, "30", driver);
		try {
			click(employedStatus, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(employedStatus, driver);
		}
	}

	public boolean isEmployedStatusClickable(WebDriver driver) {
		try {
			waitForElementClickable(employedStatus, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isRetiredStatusClickable(WebDriver driver) {
		try {
			waitForElementClickable(retiredStatus, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isStudentStatusClickable(WebDriver driver) {
		try {
			waitForElementClickable(studentStatus, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isSelfEmployedStatusClickable(WebDriver driver) {
		try {
			waitForElementClickable(selfEmployedStatus, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isUnemployedStatusClickable(WebDriver driver) {
		try {
			waitForElementClickable(unemployedStatus, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void checkNoneofAboveOption(WebDriver driver) {
		waitForElementVisibility(noneofAboveOption, "30", driver);
		String attribute =  getElementAttributeValue(noneofAboveOption, "class", driver);
		if(!attribute.contains("checked")) {
			try {
				click(noneofAboveOption, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(noneofAboveOption, driver);
			}
		}
		
	}

	public void checkUSBrokerageFirmOption(WebDriver driver) {
		waitForElementVisibility(usBrokerageFirm, "30", driver);
		try {
			click(usBrokerageFirm, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(usBrokerageFirm, driver);
		}
	}

	public boolean isUSBrokerageFirmOptionDisabled(WebDriver driver) {
		waitForElementVisibility(usBrokerageFirm, "30", driver);
		return usBrokerageFirm.isEnabled();
	}

	public void checkPublicOfficialOption(WebDriver driver) {

		try {
			try {
				waitForElementVisibility(publicOfficial1, "30", driver);
				click(publicOfficial1, driver);
			} catch (Exception e) {
				waitForElementVisibility(publicOfficial, "30", driver);
				click(publicOfficial, driver);
			}

		} catch (Exception e) {
			try {
				waitForElementVisibility(publicOfficial1, "30", driver);
				clickUsingJavascriptExecutor(publicOfficial1, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(publicOfficial, driver);
			}

		}
	}

	public boolean isPublicOptionDisabled(WebDriver driver) {
		try {
			waitForElementVisibility(publicOfficial1, "30", driver);
			return publicOfficial1.isEnabled();
		} catch (Exception e) {
			waitForElementVisibility(publicOfficial, "30", driver);
			return publicOfficial.isEnabled();
		}

	}

	public void enterPublicOfficialName(String keys, WebDriver driver) {
		waitForElementVisibility(publicOfficialNames, "30", driver);
		publicOfficialNames.clear();
		type(publicOfficialNames, keys, driver);
	}

	public boolean isPublicOfficialNameErrorMessagePresent(WebDriver driver) {
		try {
			waitForElementVisibility(publicOfficialNamesErrorMessage, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void checkOnUSListedPublicCompanyOption(WebDriver driver) {
		waitForElementVisibility(usListedPublicCompany, "30", driver);
		try {
			click(usListedPublicCompany, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(usListedPublicCompany, driver);
		}
	}

	public boolean isUSListedPublicCompanyOptionDisabled(WebDriver driver) {
		waitForElementVisibility(usListedPublicCompany, "30", driver);
		return usListedPublicCompany.isEnabled();
	}

	public void enterUSListedPublicCompanyName(String keys, WebDriver driver) {
		waitForElementVisibility(usListedPublicCompanyName, 10, driver);
		type(usListedPublicCompanyName, keys, driver);
	}

	public boolean isTaxFormInformationPresent(WebDriver driver) {
		try {
			waitForElementVisibility(taxFormInformationModal, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isUSListedPublicCompanyNameErrorMessagePresent(WebDriver driver) {
		try {
			waitForElementVisibility(usListedPublicCompanyNameErrorMessage, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnNextButton(WebDriver driver) {
		waitForElementVisibility(nextButton, "30", driver);
		try {
			click(nextButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(nextButton, driver);
		}
	}

	public void clickOnPreviousButton(WebDriver driver) {
		waitForElementVisibility(previousButton, "30", driver);
		try {
			click(previousButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(previousButton, driver);
		}
	}

	public void clickOnTaxFormInformation(WebDriver driver) {
		waitForElementVisibility(taxFormInformation, "30", driver);
		try {
			click(taxFormInformation, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(taxFormInformation, driver);
		}
	}

	public void clickOnViewDetails(WebDriver driver) {
		waitForElementVisibility(viewDetails, "30", driver);
		try {
			click(viewDetails, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(viewDetails, driver);
		}
	}

	public void ClickOnLow_RiskTolerate(WebDriver driver) {
		waitForElementVisibility(lowRiskTolerate, "30", driver);
		try {
			click(lowRiskTolerate, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(lowRiskTolerate, driver);
		}
	}

	public void ClickOnModerate_RiskTolerate(WebDriver driver) {
		waitForElementVisibility(moderateRiskTolerate, "30", driver);
		try {
			click(moderateRiskTolerate, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(moderateRiskTolerate, driver);
		}
	}

	public void ClickOnHigh_RiskTolerate(WebDriver driver) {
		waitForElementVisibility(highRiskTolerate, "30", driver);
		try {
			click(highRiskTolerate, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(highRiskTolerate, driver);
		}
	}

	public void ClickOnSeveralTime_Invest(WebDriver driver) {
		waitForElementVisibility(severalTimeInvest, "30", driver);
		try {
			click(severalTimeInvest, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(severalTimeInvest, driver);
		}
	}

	public void ClickOnOnceInMonth_Invest(WebDriver driver) {
		waitForElementVisibility(onceInMonthTimeInvest, "30", driver);
		try {
			click(onceInMonthTimeInvest, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(onceInMonthTimeInvest, driver);
		}
	}

	public void ClickOnOnceInEveryMonth_Invest(WebDriver driver) {
		waitForElementVisibility(onceInEveryMonthseveralTimeInvest, "30", driver);
		try {
			click(onceInEveryMonthseveralTimeInvest, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(onceInEveryMonthseveralTimeInvest, driver);
		}
	}

	public void ClickOnOneYear_experience(WebDriver driver) {
		waitForElementVisibility(oneYearExperience, "30", driver);
		try {
			click(oneYearExperience, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(oneYearExperience, driver);
		}
	}

	public void ClickOnTwoYear_experience(WebDriver driver) {
		waitForElementVisibility(twoYearExperience, "30", driver);
		try {
			click(twoYearExperience, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(twoYearExperience, driver);
		}
	}

	public void ClickOnThreeYear_experience(WebDriver driver) {
		waitForElementVisibility(threeYearExperience, "30", driver);
		try {
			click(threeYearExperience, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(threeYearExperience, driver);
		}
	}

	public void ClickOnFiveYear_experience(WebDriver driver) {
		waitForElementVisibility(fiveYearExperience, "30", driver);
		try {
			click(fiveYearExperience, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(fiveYearExperience, driver);
		}
	}

	public void ClickOnTenPlusYear_experience(WebDriver driver) {
		waitForElementVisibility(moreThanTenYearExperience, "30", driver);
		try {
			click(moreThanTenYearExperience, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(moreThanTenYearExperience, driver);
		}
	}

	public void ClickOnTenlakh_yearlyIncome(WebDriver driver) {

		waitForElementVisibility(tenlakhYearlyIncome, "30", driver);
		try {
			click(tenlakhYearlyIncome, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(tenlakhYearlyIncome, driver);
		}
	}

	public void ClickOnTwentyFivelakh_yearlyIncome(WebDriver driver) {

		waitForElementVisibility(twentyFivelakhYearlyIncome, "30", driver);
		try {
			click(twentyFivelakhYearlyIncome, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(twentyFivelakhYearlyIncome, driver);
		}
	}

	public void ClickOnFiftylakh_yearlyIncome(WebDriver driver) {

		waitForElementVisibility(fiftylakhYearlyIncome, "30", driver);
		try {
			click(fiftylakhYearlyIncome, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(fiftylakhYearlyIncome, driver);
		}
	}

	public void ClickOnFiftyPluslakh_yearlyIncome(WebDriver driver) {

		waitForElementVisibility(fiftyPluslakhYearlyIncome, "30", driver);
		try {
			click(fiftyPluslakhYearlyIncome, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(fiftyPluslakhYearlyIncome, driver);
		}
	}

	public void ClickOnFivelakh_liquidworth(WebDriver driver) {

		waitForElementVisibility(fivelakhLiquidworth, "30", driver);
		try {
			click(fivelakhLiquidworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(fivelakhLiquidworth, driver);
		}
	}

	public void ClickOnTenlakh_liquidworth(WebDriver driver) {

		waitForElementVisibility(tenlakhLiquidworth, "30", driver);
		try {
			click(tenlakhLiquidworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(tenlakhLiquidworth, driver);
		}
	}

	public void ClickOnThirtylakh_liquidworth(WebDriver driver) {

		waitForElementVisibility(thirtylakhLiquidworth, "30", driver);
		try {
			click(thirtylakhLiquidworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(thirtylakhLiquidworth, driver);
		}
	}

	public void ClickOnTenlakh_totalworth(WebDriver driver) {
		waitForElementVisibility(Tenlakh_Totalworth, "30", driver);
		try {
			click(Tenlakh_Totalworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(Tenlakh_Totalworth, driver);
		}
	}

	public void ClickOnThirtylakh_totalworth(WebDriver driver) {
		waitForElementVisibility(thirtylakh_Totalworth, "30", driver);
		try {
			click(thirtylakh_Totalworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(thirtylakh_Totalworth, driver);
		}
	}

	public void ClickOnOneCrore_totalworth(WebDriver driver) {
		waitForElementVisibility(oneCrore_Totalworth, "30", driver);
		try {
			click(oneCrore_Totalworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(oneCrore_Totalworth, driver);
		}
	}

	public void ClickOnOnePlusCrore_totalworth(WebDriver driver) {
		waitForElementVisibility(oneCrorePlus_Totalworth, "30", driver);
		try {
			click(oneCrorePlus_Totalworth, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(oneCrorePlus_Totalworth, driver);
		}

	}

	public void ClickOnFivelakh_deposite(WebDriver driver) {
		waitForElementVisibility(fivelakh_Deposite, "30", driver);
		try {
			click(fivelakh_Deposite, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(fivelakh_Deposite, driver);
		}
	}

	public void ClickOnTenlakh_deposite(WebDriver driver) {
		waitForElementVisibility(Tenlakh_Deposite, "30", driver);
		try {
			click(Tenlakh_Deposite, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(Tenlakh_Deposite, driver);
		}
	}

	public void ClickOnTenPluslakh_deposite(WebDriver driver) {
		waitForElementVisibility(TenPluslakh_Deposite, "30", driver);
		try {
			click(TenPluslakh_Deposite, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(TenPluslakh_Deposite, driver);
		}
	}

	public void ClickOnFivelakh_investmentsMade(WebDriver driver) {
		waitForElementVisibility(fivelakh_InvestmentsMade, "30", driver);
		try {
			click(fivelakh_InvestmentsMade, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(fivelakh_InvestmentsMade, driver);
		}
	}

	public void ClickOnTenlakh_investmentsMade(WebDriver driver) {
		waitForElementVisibility(Tenlakh_InvestmentsMade, "30", driver);
		try {
			click(Tenlakh_InvestmentsMade, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(Tenlakh_InvestmentsMade, driver);
		}
	}

	public void ClickOnTenPluslakh_investmentsMade(WebDriver driver) {
		waitForElementVisibility(TenPluslakh_InvestmentsMade, "30", driver);
		try {
			click(TenPluslakh_InvestmentsMade, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(TenPluslakh_InvestmentsMade, driver);
		}
	}

	public void ClickOnfiftythousand_moneyPlan(WebDriver driver) {
		waitForElementVisibility(FiftyThousand_MoneyPlan, "30", driver);
		try {
			click(FiftyThousand_MoneyPlan, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(FiftyThousand_MoneyPlan, driver);
		}
	}

	public void ClickOnOneLakh_moneyPlan(WebDriver driver) {
		waitForElementVisibility(oneLakh_MoneyPlan, "30", driver);
		try {
			click(oneLakh_MoneyPlan, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(oneLakh_MoneyPlan, driver);
		}
	}

	public void ClickOnSevenLakh_moneyPlan(WebDriver driver) {
		waitForElementVisibility(sevenLakh_MoneyPlan, "30", driver);
		try {
			click(sevenLakh_MoneyPlan, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(sevenLakh_MoneyPlan, driver);
		}
	}

	public void ClickOnSevenPlusLakh_moneyPlan(WebDriver driver) {
		waitForElementVisibility(sevenPLusLakh_MoneyPlan, "30", driver);
		try {
			click(sevenPLusLakh_MoneyPlan, driver);
		} catch (Exception e1) {
			clickUsingJavascriptExecutor(sevenPLusLakh_MoneyPlan, driver);
		}

	}

	public void SelectGiftPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(giftPrimarySorce, "30", driver);
			try {
				click(giftPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(giftPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(giftPrimarySorce2, "30", driver);
			try {
				click(giftPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(giftPrimarySorce2, driver);
			}

		}
	}

	public void SelectEmploymentPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(employmentPrimarySorce, "30", driver);
			try {
				click(employmentPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(employmentPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(employmentPrimarySorce2, "30", driver);
			try {
				click(employmentPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(employmentPrimarySorce2, driver);
			}

		}
	}

	public void SelectInvestmentProceedsPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(investmentProceedsPrimarySorce, "30", driver);
			try {
				click(investmentProceedsPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(investmentProceedsPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(investmentProceedsPrimarySorce2, "30", driver);
			try {
				click(investmentProceedsPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(investmentProceedsPrimarySorce2, driver);
			}

		}
	}

	public void SelectSavingsPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(savingsPrimarySorce, "30", driver);
			try {
				click(savingsPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(savingsPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(savingsPrimarySorce2, "30", driver);
			try {
				click(savingsPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(savingsPrimarySorce2, driver);
			}

		}
	}

	public void SelectRetirementFundsPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(retirementFundsPrimarySorce, "30", driver);
			try {
				click(retirementFundsPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(retirementFundsPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(retirementFundsPrimarySorce2, "30", driver);
			try {
				click(retirementFundsPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(retirementFundsPrimarySorce2, driver);
			}

		}
	}

	public void SelectGamblingPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(gamblingFundsPrimarySorce, "30", driver);
			try {
				click(gamblingFundsPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(gamblingFundsPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(gamblingFundsPrimarySorce2, "30", driver);
			try {
				click(gamblingFundsPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(gamblingFundsPrimarySorce2, driver);
			}

		}
	}

	public void SelectlegalSettlementPrimarySorce(WebDriver driver) {
		waitForElementVisibility(selectPrimarySorce, "30", driver);
		try {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(legalSettlementFundsPrimarySorce, "30", driver);
			try {
				click(legalSettlementFundsPrimarySorce, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(legalSettlementFundsPrimarySorce, driver);
			}

		} catch (Exception e) {
			try {
				click(selectPrimarySorce, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(selectPrimarySorce, driver);
			}

			waitForElementVisibility(legalSettlementFundsPrimarySorce2, "30", driver);
			try {
				click(legalSettlementFundsPrimarySorce2, driver);
			} catch (Exception e2) {
				clickUsingJavascriptExecutor(legalSettlementFundsPrimarySorce2, driver);
			}

		}
	}

	public void fillQuestionnaire(WebDriver driver) {
		ClickOnLow_RiskTolerate(driver);
		ClickOnSeveralTime_Invest(driver);
		ClickOnOneYear_experience(driver);
		ClickOnTenlakh_yearlyIncome(driver);
		ClickOnFivelakh_liquidworth(driver);
		ClickOnTenlakh_totalworth(driver);
		ClickOnTenlakh_deposite(driver);
		ClickOnTenlakh_investmentsMade(driver);
		ClickOnfiftythousand_moneyPlan(driver);
		SelectGiftPrimarySorce(driver);
	}

	public void ClickOn_PrimarlyFileTaxes_OtherOption(WebDriver driver) {
		waitForElementVisibility(PrimarlyFileTaxes_OtherOption, "30", driver);
		try {
			click(PrimarlyFileTaxes_OtherOption, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(PrimarlyFileTaxes_OtherOption, driver);
		}
	}

	public void choose_TaxResidency(String country, WebDriver driver) {
		try {
			waitForElementVisibility(US_TaxResidency2, "30", driver);
			type(US_TaxResidency2, country, driver);
//			Actions action = new Actions(getDriver());
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER);
			action.perform();
		} catch (Exception e) {
			waitForElementVisibility(US_TaxResidency, "30", driver);
			type(US_TaxResidency, country, driver);
//			Actions action = new Actions(getDriver());
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER);
			action.perform();
		}
	}

	public void enterTaxID(String country, WebDriver driver) {
		waitForElementVisibility(TaxID, "30", driver);
		type(TaxID, country, driver);
	}

	public void enterPhoneNumber(String Phone, WebDriver driver) {
		scrollIntoViewSmoothly(PhoneNumber, driver);
		waitForElementVisibility(PhoneNumber, "30", driver);
		type(PhoneNumber, Phone, driver);
	}

	public boolean IsPhoneNumberFieldDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(PhoneNumber, "30", driver);
			return PhoneNumber.isDisplayed();
		}catch (Exception e) {
			return false;
		}
		
	}
	public boolean isVerifyYourIdentityButtonDisplaying(WebDriver driver) {
		waitForElementVisibility(identificationButton, 30, driver);
		waitForElementToBeClickable(identificationButton, 30, driver);
		return isElementDisplayed(identificationButton, driver);
	}

	public boolean isVerifyYourIdentityPopupHeadingDisplaying(WebDriver driver) {
		return isElementDisplayed(identificationPopupHeading, driver);
	}

	public void clickOnVerifyIdentityButton(WebDriver driver) {
		try {
			click(identificationButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(identificationButton, driver);
		}
	}

	public void closeVerifyIdentityPopup(WebDriver driver) {
		try {
			click(identificationPopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(identificationPopupClose, driver);
		}
	}

	public ArrayList<String> mobileVerification(WebDriver driver)  {
		ArrayList<String> testSteps = new ArrayList<String>();
		scrollIntoViewSmoothly(GetOTP_Button, driver);
		waitForElementVisibility(GetOTP_Button, "30", driver);
		try {
			click(GetOTP_Button, driver);
			testSteps.add("Click On 'Get OTP'");
		} catch (Exception e) {
			clickUsingJavascriptExecutor(GetOTP_Button, driver);
			testSteps.add("Click On 'Get OTP'");
		}
		testSteps.add("Waiting for 30 seconds 'Resend OTP' Button to be visible");
		waitForElementClickable(ResendOTP_Button, "40", driver);
		try {
			click(ResendOTP_Button, driver);
			testSteps.add("Click On 'Resend OTP'");
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ResendOTP_Button, driver);
			testSteps.add("Click On 'Resend OTP'");
		}

		testSteps.add("Waiting for 30 seconds 'Resend OTP Via Call' Button to be visible");
		waitForElementClickable(ResendOTPViaCall_Button, "40", driver);
		try {
			click(ResendOTPViaCall_Button, driver);
			testSteps.add("Click On 'Resend OTP Via Call'");
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ResendOTPViaCall_Button, driver);
			testSteps.add("Click On 'Resend OTP Via Call'");
		}

		testSteps.add("Waiting for 30 seconds 'Continue Anyway' Button to be visible");
		waitForElementClickable(ContinueAnyway_Button, "40", driver);
		try {
			click(ContinueAnyway_Button, driver);
			testSteps.add("Click On 'Resend OTP Via Call'");
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ContinueAnyway_Button, driver);
			testSteps.add("Click On 'Resend OTP Via Call'");
		}

		return testSteps;

	}
	
	public boolean isGetOtpButtonDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(GetOTP_Button, "30", driver);
			return GetOTP_Button.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}

	public void clickOnUploadPassport_Button(WebDriver driver) {
		scrollIntoViewSmoothly(UploadPassport_Button, driver);
		waitForElementClickable(UploadPassport_Button, "30", driver);
		try {
			click(UploadPassport_Button, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(UploadPassport_Button, driver);
		}
	}

	public void clickOnUploadPassportConfirm_Button(WebDriver driver) {
		waitForElementClickable(UploadPassportConfirm_Button, "30", driver);
		try {
			click(UploadPassportConfirm_Button, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(UploadPassportConfirm_Button, driver);
		}
	}

	public void clickOnUpload_Button(WebDriver driver) {
		waitForElementClickable(Upload_Button, "30", driver);
		try {
			click(Upload_Button, driver);
		} catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(Upload_Button, driver);
			} catch (Exception e1) {
				System.out.print("Clicking Through Action");
				clickUsingActionClass(Upload_Button, driver);
			}

		}
	}

	public void uploadfile(String path, WebDriver driver)  {
		scrollIntoViewSmoothly(UploadPassportfile, driver);
		type(UploadPassportfile, path, driver);
		clickOnUpload_Button(driver);
		waitForElementVisibility(UploadSuccessPopup, "60", driver);
		wait6s();
	}

	public void ClickOnpopUPUpload_Button(WebDriver driver) {
		scrollIntoViewSmoothly(popUpUpload_Button, driver);
		waitForElementClickable(popUpUpload_Button, "30", driver);
		try {
			click(popUpUpload_Button, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(popUpUpload_Button, driver);
		}
	}

	public void ClickOnpopUPClose_Button(WebDriver driver) {
		scrollIntoViewSmoothly(popUpClose_Button, driver);
		waitForElementClickable(popUpClose_Button, "30", driver);
		try {
			click(popUpClose_Button, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(popUpClose_Button, driver);
		}
	}

	public void enterPassportfileNoInput(String number, WebDriver driver) {
		try {
			scrollIntoViewSmoothly(passportFileNoInput, driver);
			waitForElementClickable(passportFileNoInput, "30", driver);
			type(passportFileNoInput, number, driver);
		} catch (Exception e) {
			scrollIntoViewSmoothly(passportFileNoInput, driver);
			waitForElementClickable(passportFileNoInput, "30", driver);
			type(passportFileNoInput, number, driver);
		}

	}

	public ArrayList<String> enterAddressDetails(String Address1, String Address2, String City, String State,
			String PinCode, WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		scrollIntoViewSmoothly(Address1Input, driver);
		waitForElementClickable(Address1Input, "30", driver);
		type(Address1Input, Address1, driver);
		testSteps.add("Entering Address1 : " + Address1);

		scrollIntoViewSmoothly(Address2Input, driver);
		waitForElementClickable(Address2Input, "30", driver);
		type(Address2Input, Address2, driver);
		testSteps.add("Entering Address2 : " + Address2);

		scrollIntoViewSmoothly(CityInput, driver);
		waitForElementClickable(CityInput, "30", driver);
		type(CityInput, City, driver);
		testSteps.add("Entering City : " + City);

		scrollIntoViewSmoothly(PinCodeInput, driver);
		waitForElementClickable(PinCodeInput, "30", driver);
		type(PinCodeInput, PinCode, driver);
		testSteps.add("Entering PinCode: " + PinCode);

		if (isElementDisplayed(stateInput, driver)) {
			scrollIntoViewSmoothly(stateInput, driver);
			testSteps.add("Entering state : " + State);
			type(stateInput, State, driver);

		} else {
			scrollIntoViewSmoothly(provinceInput, driver);
			waitForElementClickable(provinceInput, "30", driver);
			try {
				click(provinceInput, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(provinceInput, driver);
			}

			WebElement stateToSelect = driver
					.findElement(By.xpath("//div[@class='ant-select-item-option-content' and text()='" + State + "']"));
			scrollIntoView(stateToSelect, driver);
			try {
				click(stateToSelect, driver);
				testSteps.add("Choose State: " + State);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(stateToSelect, driver);
				testSteps.add("Choose State: " + State);
			}

		}
		return testSteps;

	}

	public boolean isSelectPlanScreenHeading(WebDriver driver) {
		waitForElementVisibility(selectPlanScreenHeading, "60", driver);
		return isElementDisplayed(selectPlanScreenHeading, driver);

	}

	public void clickOnIConfirmCheckbox(WebDriver driver) {
		waitForElementVisibility(iConfirmCheckbox, "30", driver);
		String attribute =  getElementAttributeValue(iConfirmCheckbox, "class", driver);
		if(!attribute.contains("checked")) {
			try {
				click(iConfirmCheckbox, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(iConfirmCheckbox, driver);
			}
		}
	}
	
	public void uncheckIConfirmCheckbox(WebDriver driver) {
		waitForElementVisibility(iConfirmCheckbox, "30", driver);
		String attribute =  getElementAttributeValue(iConfirmCheckbox, "class", driver);
		if(attribute.contains("checked")) {
			try {
				click(iConfirmCheckbox, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(iConfirmCheckbox, driver);
			}
		}
	}

	public void clickOnDoneButton(WebDriver driver) {
		waitForElementClickable(DoneButton, "30", driver);
		try {
			click(DoneButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(DoneButton, driver);
		}
	}

	public void selectTaxResidencyCountry(WebDriver driver, String Country) {
		try {
			waitForElementVisibility(citizenshipTaxResidencyInput2, 30, driver);
			sendKeysToWebElement(citizenshipTaxResidencyInput2, Country, driver);
			clickUsingJavascriptExecutor(driver.findElement(By.xpath("//div[@title='" + Country + "']")), driver);
		} catch (Exception e) {
			waitForElementVisibility(citizenshipTaxResidencyInput, 30, driver);
			sendKeysToWebElement(citizenshipTaxResidencyInput, Country, driver);
			clickUsingJavascriptExecutor(driver.findElement(By.xpath("//div[@title='" + Country + "']")), driver);
		}

	}

	public void selectResidencyCountry(WebDriver driver, String Country) {
		try {
			waitForElementVisibility(citizenshipResidencyInput, 30, driver);
			sendKeysToWebElement(citizenshipResidencyInput, Country, driver);
			clickUsingJavascriptExecutor(driver.findElement(By.xpath("//div[@title='" + Country + "']")), driver);
		} catch (Exception e) {
			waitForElementVisibility(citizenshipResidencyInput, 30, driver);
			sendKeysToWebElement(citizenshipResidencyInput, Country, driver);
			clickUsingJavascriptExecutor(driver.findElement(By.xpath("//div[@title='" + Country + "']")), driver);
		}

	}

	public void clickOnNoButtonForMobile(WebDriver driver) {
		try {
			click(noButtonForMobile, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(noButtonForMobile, driver);
		}

	}

	public void clickOnUploadPanCard_Button(WebDriver driver) {
		waitForElementVisibility(uploadPanCard,30,driver);
		scrollIntoViewSmoothly(uploadPanCard, driver);
		waitForElementClickable(uploadPanCard, "30", driver);
		try {
			click(uploadPanCard, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(uploadPanCard, driver);
		}
	}

	public void clickOnUploadAadhaarCard_Button(WebDriver driver) {
		scrollIntoViewSmoothly(uploadAadhaarCard, driver);
		waitForElementClickable(uploadAadhaarCard, "30", driver);
		try {
			click(uploadAadhaarCard, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(uploadAadhaarCard, driver);
		}
	}
	
	public boolean isUploadAadharCardButtonDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(uploadAadhaarCard, defaultTimeForVisibility, driver);
			return uploadAadhaarCard.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}

	public void clickOnIAgreeCheckbox(WebDriver driver) {
		waitForElementClickable(iAgreeCheckbox, "30", driver);
		try {
			click(iAgreeCheckbox, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(iAgreeCheckbox, driver);
		}
	}

	public void enterYourFullName(String fullName, WebDriver driver) {
		scrollIntoViewSmoothly(enterYourFullName, driver);
		waitForElementVisibility(enterYourFullName, "30", driver);
		type(enterYourFullName, fullName, driver);
	}

	public boolean verifyKycApprovedTitleIsDisplaying(WebDriver driver) {
		return isElementDisplayed(kycApproved, driver);
	}

	public boolean isWhichIndustryDoYouWorkInPresent(WebDriver driver) {
		try {
			waitForElementVisibility(whichIndustry, 30, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void enterIndustryDropDown(String keys, WebDriver driver) {
		try {
			waitForElementVisibility(whichIndustry1, "30", driver);
			type(whichIndustry1, keys, driver);
		} catch (Exception e) {
			waitForElementVisibility(whichIndustry, "30", driver);
			type(whichIndustry, keys, driver);
		}

	}

	public void selectIndustryArts(WebDriver driver) {
		waitForElementClickable(selectIndustryArts, "30", driver);
		try {
			click(selectIndustryArts, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(selectIndustryArts, driver);
		}
	}

	public boolean isWhichPositionDoYouWorkInPresent(WebDriver driver) {
		try {
			waitForElementVisibility(whichPosition, 30, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void enterPosition(String keys, WebDriver driver) {
		try {
			waitForElementVisibility(whichPosition1, "30", driver);
			type(whichPosition1, keys, driver);
		} catch (Exception e) {
			waitForElementVisibility(whichPosition, "30", driver);
			type(whichPosition, keys, driver);
		}

	}

	public void selectPositionAccountant(WebDriver driver) {
		waitForElementClickable(selectPositionAccountant, "30", driver);
		try {
			click(selectPositionAccountant, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(selectPositionAccountant, driver);
		}
	}

	public void enterCompanyName(String keys, WebDriver driver) {
		waitForElementVisibility(companyName, "30", driver);
		type(companyName, keys, driver);
	}

	public void enterCompanyCity(String keys, WebDriver driver) {
		waitForElementVisibility(companyCity, "30", driver);
		type(companyCity, keys, driver);
	}

	public Boolean isNationalityErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(nationalityErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isTaxErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(taxResidencyErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isGenderErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(genderErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isMaritalStatusErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(maritalErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isEmployementErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(employementStatusErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isTickErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(tickAnyErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void selectPoliticalExposedCheckBox(WebDriver driver) {
		waitForElementClickable(politicallyExposedCheckBox, "30", driver);
		try {
			click(politicallyExposedCheckBox, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(politicallyExposedCheckBox, driver);
		}
	}

	public Boolean isPoliticalExposedErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(politicallyExposedErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void selectDirectorCheckBox(WebDriver driver) {
		waitForElementClickable(directorCheckBox, "30", driver);
		try {
			click(directorCheckBox, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(directorCheckBox, driver);
		}
	}

	public Boolean isDirectorErrorVisible(WebDriver driver) {
		try {
			waitForElementVisibility(directorErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean isTextVisible(WebDriver driver , String Text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='"+Text+"']"));
			return isElementDisplayed(ele, driver);
		}catch (Exception e) {
			return false;
		}
	}
	
	public Boolean isAcceptAndContinueButtonDisplaying(WebDriver driver) {
		waitForElementVisibility(acceptAndContinueBtn, defaultTimeForVisibility, driver);
		return isElementDisplayed(acceptAndContinueBtn, driver);
	}
	
	public Boolean isVestedLogoDisplaying(WebDriver driver) {
		waitForElementVisibility(kycVestedLogo, defaultTimeForVisibility, driver);
		return isElementDisplayed(kycVestedLogo, driver);
	}
	public Boolean isCloseIconDisplaying(WebDriver driver) {
		waitForElementVisibility(kycCloseIcon, defaultTimeForVisibility, driver);
		return isElementDisplayed(kycCloseIcon, driver);
	}
	public Boolean isVestedLogoClickable(WebDriver driver) {
		try {
			waitForElementClickable(kycVestedLogo, "10", driver);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public Boolean isCloseIconClickable(WebDriver driver) {
		try {
			waitForElementClickable(kycCloseIcon, "10", driver);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public void clickOnTaxID(WebDriver driver) {
		click(TaxID, driver);
		click(kycPageSideIcon, driver);
	}
	
	public void clickOnSecurityMobileNumber(WebDriver driver) {
		click(securityMobileNumber, driver);
		securityMobileNumber.clear();
		click(kycPageSideIcon, driver);
		click(securityMobileNumber, driver);
	}
	public void clickOnSecurityAadharNumber(WebDriver driver) {
		click(securityAadharNumber, driver);
		securityAadharNumber.clear();
		click(kycPageSideIcon, driver);
		click(securityAadharNumber, driver);
	}
	
	public void clickOnAddressLine1(WebDriver driver) {
		
		scrollIntoViewSmoothly(Address1Input, driver);
		waitForElementClickable(Address1Input, "30", driver);
		type(Address1Input, "45678", driver);
		clearInputByBackspace(Address1Input,driver);
		click(kycPageSideIcon, driver);
	}
	
	public void clickOnCity(WebDriver driver) {
		
		scrollIntoViewSmoothly(CityInput, driver);
		waitForElementClickable(CityInput, "30", driver);
		type(CityInput, "asdfgh", driver);
		clearInputByBackspace(CityInput,driver);
		click(kycPageSideIcon, driver);
	}
	
	public void clickOnPinCOde(WebDriver driver) {
		scrollIntoViewSmoothly(PinCodeInput, driver);
		waitForElementClickable(PinCodeInput, "30", driver);
		type(PinCodeInput, "asdfgh", driver);
		clearInputByBackspace(PinCodeInput,driver);
		click(kycPageSideIcon, driver);
	}
	
	public void clickOnState(WebDriver driver) {
		
		scrollIntoViewSmoothly(stateInput, driver);
		waitForElementClickable(stateInput, "30", driver);
		type(stateInput, "asdfgh", driver);
		clearInputByBackspace(stateInput,driver);
		click(kycPageSideIcon, driver);
		
	}
	
	public Boolean isErrorMessageDisplaying(WebDriver driver, String error) {
		WebElement ele = null;
		try {
			try {
				ele =  driver.findElement(By.xpath("//p[@color='danger' and contains(text(),'"+error+"')]"));
				scrollIntoViewSmoothly(ele, driver);
				return isElementDisplayed(ele, driver);
			}catch (Exception e) {
				ele =  driver.findElement(By.xpath("//p[@color='danger' and text()='"+error+"']"));
				scrollIntoViewSmoothly(ele, driver);
				return isElementDisplayed(ele, driver);
			}
			
			
		}catch (Exception e) {
			try {
				wait2s();
				ele =  driver.findElement(By.xpath("//p[@color='danger' and text()='"+error+"']"));
				scrollIntoViewSmoothly(ele, driver);
				return isElementDisplayed(ele, driver);
			}catch (Exception e1) {
				return false;
			}
		}
	}
	
	
	public void enterSecurityMobileNumber(WebDriver driver, String Val) {
		sendKeysToWebElement(securityMobileNumber, Val, driver);
	}
	
	public void enterSecurityAadharNumber(WebDriver driver, String Val) {
		sendKeysToWebElement(securityAadharNumber, Val, driver);
	}
	
	public void clickOnKYCPageSideIcon(WebDriver driver) {
		click(kycPageSideIcon, driver);
	}
	
	public Boolean isTextDisplaying(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[contains(text(),'"+text+"')]"));
			scrollIntoViewSmoothly(ele, driver);
			return isElementDisplayed(ele, driver);
		}catch (Exception e) {
			try {
				ele = driver.findElement(By.xpath("//p[text()='"+text+"']"));
				return isElementDisplayed(ele, driver);
			}catch (Exception e1) {
				return false;
			}
		}
	}
	
	public Boolean isOptionWithLabelDisplaying(WebDriver driver, String option, String label) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='"+label+"']//parent::div//p[text()='"+option+"']"));
			scrollIntoViewSmoothly(ele, driver);
			return isElementDisplayed(ele, driver);
		}catch (Exception e) {
			try {
				ele = driver.findElement(By.xpath("//p[text()='"+label+"']//parent::div//p[text()='"+option+"']"));
				return isElementDisplayed(ele, driver);
			}catch (Exception e1) {
				return false;
			}
		}
	}
	
	public Boolean isButtonCLickable(WebDriver driver, String button) {
		WebElement ele = null;
		
		try {
			ele = driver.findElement(By.xpath("//span [contains(text(),'"+button+"')]//parent::button"));
			waitForElementClickable(ele, "10", driver);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnCompleteKYC(WebDriver driver) {
		try {
			click(completeKYC, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(completeKYC, driver);
		}
	}
	public Boolean isEnterYourFullNamePlaceholderDisplaying(WebDriver driver) {
		scrollIntoViewSmoothly(enterYourFullName, driver);
		return isElementDisplayed(enterYourFullName, driver);
		
	}
	
	public Boolean isTextFieldDisplaying(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='"+text+"']//following-sibling::div//input"));
			scrollIntoViewSmoothly(ele, driver);
			return isElementDisplayed(ele, driver);
		}catch (Exception e) {
			try {
				ele = driver.findElement(By.xpath("//input[@placeholder='"+text+"']"));
				return isElementDisplayed(ele, driver);
			}catch (Exception e1) {
				return false;
			}
		}
	}
	
	public Boolean isCountryCodeDisplaying(WebDriver driver) {
		WebElement ele = null;
		return false;
//		try {
//			ele = driver.findElement(By.xpath("(//p[text()='Mobile number']//following-sibling::div//input)[1]"));
//			waitForElementClickable(ele, "20", driver);
//			scrollIntoViewSmoothly(ele, driver);
//			return true;
//		}catch (Exception e) {
//				return false;
//		}
	}
	public Boolean isMobileNumberDisplaying(WebDriver driver ,String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//input[@placeholder='"+text+"']"));
			waitForElementClickable(ele, "20", driver);
			scrollIntoViewSmoothly(ele, driver);
			return true;
		}catch (Exception e) {
				return false;
		}
	}
	
	public Boolean isButtonDisplaying(WebDriver driver, String button) {
		WebElement ele = null;
		try {
			click(processedButton, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			ele = driver.findElement(By.xpath("//span [contains(text(),'"+button+"')]//parent::button"));
			scrollIntoViewSmoothly(ele, driver);
			return isElementDisplayed(ele, driver);
		}catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnThirdCheckbox(WebDriver driver) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("(//input[@data-testid='signature-check-agreement'])[3]//parent::span"));
			click(ele, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(ele, driver);
		}
	}
	
	public Boolean isStartKYCButtonDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(startKYC, 10, driver);
			waitForElementClickable(startKYC, "20", driver);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Boolean isSkippedVerificationDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(skippedVerification, 10, driver);
			waitForElementClickable(skippedVerification, "10", driver);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void enterPANNumber(WebDriver driver, String PAN) {
		type(panInput, PAN, driver);
	}
	public boolean isPANInputFieldDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(panInput, defaultTimeForVisibility, driver);
			return panInput.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	public void clickOnVerifyPANButton(WebDriver driver) {
		try {
			click(verifyPANButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(verifyPANButton, driver);
		}
	}
	public boolean isVerifyPANButtonDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(verifyPANButton, defaultTimeForVisibility, driver);
			return verifyPANButton.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnPreviousButtonUntillGetToKnowScreen(WebDriver driver) {
		while(!letGetToKnowYouScreen.isDisplayed()) {
			clickOnPreviousButton(driver);
		}
		
	}
	public void clickOnProcessedButton(WebDriver driver) {
		try {
			click(processedButton, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void clickOnBasicPlan(WebDriver driver) {
		try {
			click(basicPlanButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(basicPlanButton, driver);
		}
	}
	public void enterContactNumber(WebDriver driver, String contactNo) {
		type(contactNumberField, contactNo, driver);
	}
	
	public void clickOnProceedButton(WebDriver driver) {
		try {
			click(proceedButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(proceedButton, driver);
		}
	}
	
	public void clickOnWalletButton(WebDriver driver) {
		try {
			click(walletButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(walletButton, driver);
		}
	}
	
	public void clickOnAirtelMoney(WebDriver driver) {
		try {
			click(airtelMoney, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(airtelMoney, driver);
		}
	}
	
	public void clickOnPayNowButton(WebDriver driver) {
		try {
			click(payNowButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(payNowButton, driver);
		}
	}
	
	public void clickOnSuccessButton(WebDriver driver) {
		try {
			click(successButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(successButton, driver);
		}
	}
	
	public ArrayList<String> SelectBasicPlan(WebDriver driver, String Number) {
		ArrayList<String> testSteps = new ArrayList<String>();
		testSteps.add("--> Clicking On Select Basic Plan Button");
		clickOnBasicPlan(driver);
		WebElement ele = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(ele);
		testSteps.add("--> Entering Mobile Number: "+Number);
		enterContactNumber(driver,Number);
		
		testSteps.add("--> Clicking On Proceed Button");
		clickOnProceedButton(driver);
		
		testSteps.add("--> Clicking On Wallet");
		clickOnWalletButton(driver);
		
		testSteps.add("--> Clicking On Airtel Money");
		clickOnAirtelMoney(driver);
		
		testSteps.add("--> Clicking On Pay Now Button");
		clickOnPayNowButton(driver);
		
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		
		testSteps.add("--> Clicking On Success Button");
		clickOnSuccessButton(driver);
		
		
		
		
		
		
		
		return testSteps;
	}
	
	

}
