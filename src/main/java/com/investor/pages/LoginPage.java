package com.investor.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;
import com.investor.errorCollectors.ErrorCollector;

public class LoginPage extends BaseClass {

	private WebDriver podriver = null;

	@FindBy(xpath = ("//input[@type='password']"))
	WebElement appPasswordInput;
	
	@FindBy(xpath = ("//span[text()='Incorrect password provided']"))
	WebElement inValidAppPasswordMessage;
	
	@FindBy(xpath = ("//p[text()='Please enter your password']"))
	WebElement blankAppPasswordMessage;
	
	@FindBy(xpath = ("//p[text()='Please enter your email']"))
	WebElement blankEmailMessage;
	
	@FindBy(xpath = ("//p[text()='Please enter your password']"))
	WebElement blankPasswordMessage;
	
	@FindBy(xpath = ("(//p[contains(text(),' find an account with email')])[1]"))
	WebElement unknownEmailErrorMessage;
	
	@FindBy(xpath = ("(//p[text()='Incorrect username or password.'])[1]"))
	WebElement incorrectUsernameAndPasswordErrorMessage;
	
	@FindBy(xpath = ("//p[text()='Invalid email ID format.']"))
	WebElement incorrectEmailFormatErrorMessage;
	
	@FindBy(xpath = ("//p[contains(text(),'entered an invalid PIN')]"))
	WebElement invalidPinErrorMessage;
	
	@FindBy(xpath = ("//p[text()='Request timed out. Please try again.']"))
	WebElement timeoutPinErrorMessage;
	
	
	
	
	
	
	@FindBy(xpath = ("//label[@class='ant-checkbox-wrapper']"))
	WebElement checkBoxSellAll;
	@FindBy(xpath = "//p[text()='Estimate Cost']//..//..//input")
	WebElement EstimatedCostValue;

	@FindBy(xpath = ("//button[@type='submit']"))
	WebElement btnSubmit;
	
	@FindBy(xpath = ("//button[@type='submit'] | //span[text()='Sign up with Email']//ancestor::div[contains(@class,'e1keh4705')]//button"))
	WebElement signUpButton;
	
	

	@FindBy(xpath = ("(//span[contains(text(),'Login')])[1]"))
	WebElement btnLoginPage;

	@FindBy(xpath = ("(//div[contains(text(),'Login with Email')])[1]"))
	WebElement loginWithEmailLink;

	@FindBy(xpath = ("//input[@name='email']"))
	WebElement emailInput;

	@FindBy(xpath = ("//input[@name='password']"))
	WebElement passwordInput;

	@FindBy(xpath = ("(//span[contains(text(),'Login')])[2]"))
	WebElement btnLogin;
	
	@FindBy(xpath = ("//span[contains(text(),'Place Sell Order')]"))
	WebElement btnPlaceSellOrder;

	@FindBy(xpath = ("//input[@id='pin']"))
	WebElement pinCodeInput;

	@FindBy(xpath = ("//*[contains(text(),'Continue')]  | //*[contains(text(),'Start Investing')]"))
	WebElement btnContinue;

	@FindBy(xpath = ("//*[contains(text(),'Start Investing')]"))
	WebElement btnStartInvesting;

	@FindBy(xpath = ("//span[contains(text(),'Profile')]"))
	WebElement profileIcon;
	
	@FindBy(xpath = ("//p[text()='Invest in less than one share. Open an account in minutes.']"))
	WebElement DashboardPageT;
	
	@FindBy(xpath = ("//p[text()='Market']"))
	WebElement marketOpenText;
	
	@FindBy(xpath = ("//p[text()='Multi-Asset Class Vests']"))
	WebElement multiAssetClassVest;
	
	
	
	@FindBy(xpath = ("//div[contains(@class,'css-12oea1u')][1]"))
	WebElement stock;

	@FindBy(xpath = ("//button[@data-testid='Sell']"))
	WebElement btnSell;

	@FindBy(xpath = ("//input[@name='shares']"))
	WebElement sharesInput;

	@FindBy(xpath = ("//input[@name='amount']"))
	WebElement amount;

	@FindBy(xpath = ("//span[contains(text(),'Review Order')]"))
	WebElement btnReviewOrder;
	@FindBy(xpath = ("//span[text()='Ok, Got It']//parent::button"))
	WebElement btnBuyingPowerOkGotIt;
	

	@FindBy(xpath = ("//span[contains(text(),'Place Buy Order')]"))
	WebElement btnPlaceBuyOrder;

	@FindBy(xpath = ("(//div[contains(text(),'Sign up with Email')])[1]"))
	WebElement signUpWithEmail;

	@FindBy(xpath = ("//*[contains(text(),'Verification Code')]"))
	WebElement verificationCodeInput;

	@FindBy(xpath = ("//*[contains(text(),'EXPLORE THE PLATFORM')]"))
	WebElement btnExplorePlatform;

	@FindBy(xpath = ("//*[contains(text(),'START KYC')]"))
	WebElement btnStartKYC;

	@FindBy(xpath = ("//*[contains(text(),'Email address')]/following-sibling::div//p[@color='red']"))
	WebElement emailErrorMessage;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement btnNext;

	@FindBy(xpath = "//span[contains(text(),'Ok, Got it')]")
	WebElement btnOkGotIt;

	@FindBy(xpath = ("//*[contains(text(),'Password')]/following-sibling::div//p[@color='red']"))
	WebElement passwordErrorMessage;

	@FindBy(xpath = "//input[@placeholder='6 digit code']")
	WebElement signUpVerificationCode;

	@FindBy(xpath = "//p[@color = 'red']")
	WebElement signUpVerificationCodeMessage;

	@FindBy(xpath = "//span[text() = 'Confirm Account']/parent::button")
	WebElement confirmAccountButton;

	@FindBy(xpath = "//span[text() = 'Profile']/following-sibling::img")
	WebElement profileDropDown;
	
	@FindBy(xpath = "(//div[@data-testid='nav-profile-menu'])[last()] | //div[@class='ant-popover-inner-content']//div[@data-testid='nav-profile-menu']")
	WebElement profileDropDownMenus;
	

	@FindBy(xpath = "(//p[text() = 'Security'])[2]")
	WebElement security;

	@FindBy(xpath = "//div[text() = 'Change Password']")
	WebElement changePasswordButton;

	@FindBy(xpath = "(//input[@name= 'currentPassword'])[1]")
	WebElement currentPassword;

	@FindBy(xpath = "(//input[@name= 'password'])[1]")
	WebElement newPassword;

	@FindBy(xpath = "(//input[@name= 'confirmPassword'])[1]")
	WebElement confirmPassword;

	@FindBy(xpath = "(//input[@name= 'password']/following-sibling::span/child::span/*[local-name()='svg'])[1]")
	WebElement newPasswordHiddenIcon;

	@FindBy(xpath = "(//span[text() = 'Change Password']/parent::button)[1]")
	WebElement changePasswordButton_2;

	@FindBy(xpath = "//p[text() = 'Password Changed Successfully']")
	WebElement changePasswordSuccessful;

	@FindBy(xpath = "//p[text() = 'BACK TO DASHBOARD']")
	WebElement backToDashBoardButton;

	@FindBy(xpath = "//div[text() = 'Change Security Pin']")
	WebElement changeSecurityPinButton;

	@FindBy(xpath = "//p[text() = 'Continue']/parent::button")
	WebElement continueButton;

	@FindBy(xpath = "//p[@color= 'red']")
	WebElement securityPinErrorMessage;

	@FindBy(xpath = "//p[text() = 'Pin Changed Successfully']")
	WebElement changePinSuccessful;

	@FindBy(xpath = "//input[@id='confirmPin']")
	WebElement confirmPinCode;

	@FindBy(xpath = "//p[text() = 'Forgot Pin?']/parent::div")
	WebElement forgotPinCode;

	@FindBy(xpath = "//p[text() = 'Reset Pin']/parent::button")
	WebElement resetPinButton;

	@FindBy(xpath = "//p[text() = 'Answer 1 is required.']")
	WebElement answer1IsRequired;

	@FindBy(xpath = "//p[text() = 'Answer 2 is required.']")
	WebElement answer2IsRequired;

	@FindBy(xpath = "//input[@name= 'securityAnswer1']")
	WebElement answer1Input;

	@FindBy(xpath = "//input[@name= 'securityAnswer2']")
	WebElement answer2Input;

	@FindBy(xpath = "//input/following-sibling::div/*[local-name()='svg']")
	WebElement eyeIcon;

	@FindBy(xpath = "(//p[text() = 'Manage Plan'])[2]")
	WebElement managePlanTab;

	@FindBy(xpath = "//span[contains(text(), 'Premium Plan')] | //p[text() = 'You are currently on the Premium Plan']")
	WebElement premiumPlanActive;
	
	@FindBy(xpath = "//span[text()='Allow']//parent::button")
	WebElement allowNotifications;
	
	@FindBy(xpath = "//p[text()='no']//parent::div")
	WebElement noButton;
	
	@FindBy(xpath = "//p[text()='ACCEPT AND PROCEED']//parent::button")
	WebElement acceptAndProcessed;
	
	
	


	public LoginPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public void enterBuyShareValue(double Val, WebDriver driver) {

		waitForElementVisibility(sharesInput, "60", driver);
		sharesInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(sharesInput, String.valueOf(Val), driver);
		try {
			clickOnEstimatedCostValue(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		waitForElementVisibility(sharesInput, "60", driver);
//		setValueUsingJavascriptExecutor(sharesInput, String.valueOf(Val), driver);

	}

	public void clickOnEstimatedCostValue(WebDriver driver) {
		click(EstimatedCostValue, driver);
	}

	public void enterBuyShareValue(String Val, WebDriver driver) {
		waitForElementVisibility(sharesInput, "60", driver);
		sharesInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(sharesInput, String.valueOf(Val), driver);
		try {
			clickOnEstimatedCostValue(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		setValueUsingJavascriptExecutor(sharesInput, Val, driver);
//		waitForElementVisibility(sharesInput, "30", driver);

	}

	public void enterB2CUserWebPassword(String pass, WebDriver driver) {
		if(PropertiesReader.getPropertyValue("production").toLowerCase().equalsIgnoreCase("no")) {
			waitUntilElementDisplayed(appPasswordInput, driver);
			type(appPasswordInput, pass, driver);
		}
		
	}

	public void clickOnSubmitButton(WebDriver driver) {
//		if(PropertiesReader.getPropertyValue("production").toLowerCase().equalsIgnoreCase("no")) {
//			click(btnSubmit, driver);
//		}
		wait5s();
		try {
			click(signUpButton, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public void clickOnLoginPageButton(WebDriver driver) {
		try {
			click(btnLoginPage, driver);
		} catch (Exception e) {
			waitForElementClickable(btnLoginPage, "60", driver);
			clickUsingJavascriptExecutor(btnLoginPage, driver);
		}

	}

	public void clickOnloginWithEmail(WebDriver driver) {
		click(loginWithEmailLink, driver);
	}

	public void enterB2CUserEmailAddress(String email, WebDriver driver) {
		waitForElementVisibility(emailInput, "30", driver);
		type(emailInput, email, driver);
	}

	public void enterB2CUserPassword(String pass, WebDriver driver) {
		waitForElementVisibility(passwordInput, "30", driver);
		type(passwordInput, pass, driver);
	}

	public void clickOnLoginButton(WebDriver driver) {
		click(btnLogin, driver);
	}

	public void enterPinCode(String code, WebDriver driver) {
		waitForElementVisibility(pinCodeInput, "60", driver);
		type(pinCodeInput, code, driver);
	}

	public void clickOnContinueButton(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if (isElementDisplayed(btnContinue, driver)) {
			waitForElementVisibility(btnContinue, "30", driver);
			waitForElementClickable(btnContinue, "30", driver);
			click(btnContinue, driver);
		} else {
			waitForElementVisibility(btnStartInvesting, "30", driver);
			waitForElementClickable(btnStartInvesting, "30", driver);
			click(btnStartInvesting, driver);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void clickOnCheckBoxSellAll(WebDriver driver) {
		waitForElementVisibility(checkBoxSellAll, "60", driver);
		try {
			click(checkBoxSellAll, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(checkBoxSellAll, driver);
		}

	}

	public boolean isDashBoardDisplay(WebDriver driver) {
		pageReload(driver);
		waitTime(3000, driver);
		try {
			try {
				waitForElementVisibility(profileIcon, "30", driver);
				return isElementDisplayed(profileIcon, driver);
			} catch (Exception e) {
				waitForElementVisibility(multiAssetClassVest, "30", driver);
				return isElementDisplayed(multiAssetClassVest, driver);
			}
		} catch (Exception e) {
			try {
				waitForElementVisibility(marketOpenText, "30", driver);
				return isElementDisplayed(marketOpenText, driver);
			} catch (Exception e1) {
				waitForElementVisibility(DashboardPageT, "30", driver);
				return isElementDisplayed(DashboardPageT, driver);
			}

		}

	}

	public void enterB2BWebPassword(String pass, WebDriver driver) {
		if (isElementDisplayed(appPasswordInput, driver)) {
			printString(pass, driver);
			waitForElementVisibility(appPasswordInput, "30", driver);
			type(appPasswordInput, pass, driver);
		}
	}

	public void enterB2BUserEmailAddress(String email, WebDriver driver) {
		waitForElementVisibility(emailInput, "30", driver);
		emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(emailInput, email, driver);
	}

	public void enterB2BUserPassword(String pass, WebDriver driver) {
		printString(pass, driver);
		waitForElementVisibility(passwordInput, "30", driver);
		passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(passwordInput, pass, driver);
	}

	public void clickOnAnyStockFromPortfolio(WebDriver driver) {
		click(stock, driver);
	}

	public boolean isSellButtonDisplay(WebDriver driver) {
		waitForElementVisibility(btnSell, "15", driver);
		return isElementDisplayed(btnSell, driver);
	}

	public void clickOnSellButton(WebDriver driver) {
		click(btnSell, driver);
	}

	public void pageReload(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void enterShareValue(WebDriver driver) {
		Object[][] dataArr = getData("testData", "TestData", driver);
		printString("tesData Size : " + dataArr.length, driver);
		String pass = dataArr[0][7].toString();
		printString(pass, driver);
		waitForElementVisibility(sharesInput, "30", driver);
		type(sharesInput, pass, driver);
	}

	public void enterBuyShareValue(WebDriver driver) {
		Object[][] dataArr = getData("testData", "TestData", driver);
		printString("tesData Size : " + dataArr.length, driver);
		String pass = dataArr[0][8].toString();
		printString(pass, driver);
		waitForElementVisibility(sharesInput, "30", driver);
		type(sharesInput, pass, driver);
	}

	public String getAmount(WebDriver driver) {
		return getElementAttributeValue(amount, "value", driver);
	}

	public String getInvalidAppPasswordMessage(WebDriver driver) {
		return getElementText(inValidAppPasswordMessage, driver);
	}

	public String getBlankAppPasswordMessage(WebDriver driver) {
		return getElementText(blankAppPasswordMessage, driver);
	}

	public String getBlankEmailMessage(WebDriver driver) {
		return getElementText(blankEmailMessage, driver);
	}

	public String getBlankPasswordMessage(WebDriver driver) {
		return getElementText(blankPasswordMessage, driver);
	}

	public Boolean getUserNotExistMessage(WebDriver driver) {
		return isElementDisplayed(unknownEmailErrorMessage, driver);
	}

	public String getIncorrectUsernameAndPasswordErrorMessage(WebDriver driver) {
		return getElementText(incorrectUsernameAndPasswordErrorMessage, driver);
	}

	public String getIncorrectEmailFormatErrorMessage(WebDriver driver) {
		return getElementText(incorrectEmailFormatErrorMessage, driver);
	}

	public String getInvalidPinErrorMessage(WebDriver driver) {
		return getElementText(invalidPinErrorMessage, driver);
	}

	public String getTimeoutPinErrorMessage(WebDriver driver) {
		return getElementText(timeoutPinErrorMessage, driver);
	}

	public boolean isAmountFieldAutoPopulate(WebDriver driver) {
		printString(getAmount(driver), driver);
		if (!getAmount(driver).equals("")) {
			return true;
		}
		return false;
	}

	public void clickOnReviewOrderButton(WebDriver driver) {
		waitForElementVisibility(btnReviewOrder, "30", driver);
		waitForElementClickable(btnReviewOrder, "30", driver);
		try {
			click(btnReviewOrder, driver);
		} catch (Exception e) {
			try {
				click(btnBuyingPowerOkGotIt, driver);
			}catch (Exception e1) {
			}
			clickUsingJavascriptExecutor(btnReviewOrder, driver);
		}

	}

	public void clickOnPlaceSellOrderButton(WebDriver driver) {
		try {
			waitForElementVisibility(btnPlaceSellOrder, "15", driver);
			click(btnPlaceSellOrder, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnPlaceSellOrder, driver);
		}
		
	}

	public boolean isPreviewOrderPageDisplaying(WebDriver driver) {
		return isElementDisplayed(btnPlaceSellOrder, driver);
	}

	public void clickOnPlaceBUYOrderButton(WebDriver driver) {
		scrollDown(driver);
		waitForElementVisibility(btnPlaceBuyOrder, "15", driver);
		try {
			click(btnPlaceBuyOrder, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(btnPlaceBuyOrder, driver);
		}

	}

	public boolean isPreviewBUYOrderPageDisplaying(WebDriver driver) {
		scrollDown(driver);
		return isElementDisplayed(btnPlaceBuyOrder, driver);
	}

	public void clickOnSignUpWithEmail(WebDriver driver) {
		scrollIntoViewSmoothly(signUpWithEmail, driver);
		click(signUpWithEmail, driver);
	}

	public boolean verifyOTPScreenDisplaying(WebDriver driver) {
		scrollIntoViewSmoothly(verificationCodeInput, driver);
		return isElementDisplayed(verificationCodeInput, driver);
	}

	public void clickOnExplorePlatform(WebDriver driver) {
		click(btnExplorePlatform, driver);
	}

	public boolean verifyExplorePlatformButtonIsDisplaying(WebDriver driver) {
		return isElementDisplayed(btnExplorePlatform, driver);
	}

	public boolean verifyStartKYCButtonIsDisplaying(WebDriver driver) {
		return isElementDisplayed(btnStartKYC, driver);
	}

	public String getEmailErrorMessage(WebDriver driver) {
		return getElementText(emailErrorMessage, driver);
	}

	public String getPasswordErrorMessage(WebDriver driver) {
		printString("Error Message: '" + getElementText(passwordErrorMessage, driver) + "'", driver);
		return getElementText(passwordErrorMessage, driver);
	}

	public void clickOnBtnNext(WebDriver driver) {
		try {
			waitForElementVisibility(allowNotifications, 10, driver);
			try {
				click(allowNotifications, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(allowNotifications, driver);
			}
			
			
		}catch (Exception e) {
			printString("Allow Popup Not Showing");
		}
		try {
			waitForElementVisibility(btnNext, "10", driver);
			try {
				click(btnNext, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(btnNext, driver);
			}
		} catch (Exception e) {
			System.out.print("Next Button Not Shown");
		}
	}

	public void clickOnBtnOkGotIt(WebDriver driver) {
		try {
			waitForElementVisibility(btnOkGotIt, "10", driver);
			try {
				click(btnOkGotIt, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(btnOkGotIt, driver);
			}

		} catch (Exception e) {
			System.out.print("Next Button Not Shown");
		}
	}

	public String getPageTitle(WebDriver driver) {
		waitforPageLoad(20, driver);
		return getTitle(driver);
	}

	public boolean isPreviewSellOrderPageDisplaying(WebDriver driver) {
		return isElementDisplayed(btnPlaceSellOrder, driver);
	}

	public void enterSignUpVerificationCode(String keys, WebDriver driver) {
		waitForElementVisibility(signUpVerificationCode, 20, driver);
		signUpVerificationCode.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(signUpVerificationCode, keys, driver);
	}

	public void clickOnConfirmAccountButton(WebDriver driver) {
		try {
			waitForElementClickable(confirmAccountButton, "20", driver);
			click(confirmAccountButton, driver);
		}catch (Exception e) {
			printString("Confirm Button is disabled");
		}
		
	}

	public String getSignUpVerificationCodeErrorMessage(WebDriver driver) {
		waitForElementVisibility(signUpVerificationCodeMessage, 20, driver);
		return signUpVerificationCodeMessage.getText();
	}

	public ArrayList<String> loginToApp(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
		testSteps.add("Navigating To : "+PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
		try {
			enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
			clickOnSubmitButton(driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		clickOnLoginPageButton(driver);
		clickOnloginWithEmail(driver);
		testSteps.add("Entered Email: "+PropertiesReader.getPropertyValue(env + "_" + "EmailId"));
		enterB2CUserEmailAddress(PropertiesReader.getPropertyValue(env + "_" + "EmailId"), driver);
		enterB2CUserPassword(PropertiesReader.getPropertyValue(env + "_" + "Password"), driver);
		clickOnLoginButton(driver);
		try {
			enterPinCode(pinCode, driver);
			clickOnContinueButton(driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		clickOnBtnNext(driver);
		clickOnBtnOkGotIt(driver);
		try {
			wait3s();
//			driver.findElement(By.xpath("//p[text()='CONTINUE']/parent::button")).click();
//			wait3s();
//			driver.findElement(By.xpath("//p[text()='Currently Active']/parent::div")).click();
//			wait3s();
//			driver.findElement(By.xpath("//span[text()='Keep my Classic Vested Account']/parent::button")).click();
//			wait5s();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return testSteps;

	}

	public ArrayList<String> loginToApp(String emailParameter, String passwordParameter, WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		navigateToURL(PropertiesReader.getPropertyValue(env + "_" + "AppURL"), driver);
		testSteps.add("Navigating To : "+PropertiesReader.getPropertyValue(env + "_" + "AppURL"));
		enterB2CUserWebPassword(PropertiesReader.getPropertyValue(env + "_" + "app_password"), driver);
		clickOnSubmitButton(driver);
		clickOnLoginPageButton(driver);
		clickOnloginWithEmail(driver);
		testSteps.add("Entered Email: "+emailParameter);
		enterB2CUserEmailAddress(emailParameter, driver);
		enterB2CUserPassword(passwordParameter, driver);
		clickOnLoginButton(driver);
//		try {
//			enterPinCode(pinCode, driver);
//			clickOnContinueButton(driver);
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		clickOnBtnNext(driver);
//		clickOnBtnOkGotIt(driver);
		try {
			wait3s();
//			driver.findElement(By.xpath("//p[text()='CONTINUE']/parent::button")).click();
//			wait3s();
//			driver.findElement(By.xpath("//p[text()='Currently Active']/parent::div")).click();
//			wait3s();
//			driver.findElement(By.xpath("//span[text()='Keep my Classic Vested Account']/parent::button")).click();
//			wait5s();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return testSteps;
	}

	public ArrayList<String> login(String Email,String Password, WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
//		openURL(AppUrl, driver);
//		enterB2CUserWebPassword(appPassword, driver);
//		clickOnSubmitButton(, driver);
//		clickOnLoginPageButton(, driver);
		clickOnloginWithEmail(driver);
		testSteps.add("Entered Email: "+Email);
		enterB2CUserEmailAddress(Email, driver);
		enterB2CUserPassword(Password, driver);

		clickOnLoginButton(driver);
		try {
			enterPinCode(pinCode, driver);
			clickOnContinueButton(driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
//		clickOnBtnNext(driver);
//		clickOnBtnOkGotIt(driver);
		try {
			wait3s();
//			driver.findElement(By.xpath("//p[text()='CONTINUE']/parent::button")).click();
//			wait3s();
//			driver.findElement(By.xpath("//p[text()='Currently Active']/parent::div")).click();
//			wait3s();
//			driver.findElement(By.xpath("//span[text()='Keep my Classic Vested Account']/parent::button")).click();
//			wait5s();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return testSteps;
	}
	
	public void clickOnProfileDropDown(WebDriver driver){
		waitForElementVisibility(profileDropDown, 10,driver);
		click(profileDropDown,driver);
		if(!isElementDisplayed(profileDropDownMenus, driver)) {
			click(profileDropDown,driver);
			if(!isElementDisplayed(profileDropDownMenus, driver)) {
				click(profileDropDown,driver);
			}
		}
	}
	
	public void clickOnSecurity(WebDriver driver){
		//waitForElementVisibility(security, 10,driver);
		click(security,driver);
	}

	public void clickOnChangePasswordButton(WebDriver driver){
		waitForElementVisibility(changePasswordButton, 10,driver);
		click(changePasswordButton,driver);
	}

	public void enterCurrentPassword(String keys,WebDriver driver){
		waitForElementVisibility(currentPassword, 10,driver);
		type(currentPassword, keys,driver);
	}

	public void enterNewPassword(String keys,WebDriver driver){
		waitForElementVisibility(newPassword, 10,driver);
		type(newPassword, keys,driver);
	}

	public void enterConfirmPassword(String keys,WebDriver driver){
		waitForElementVisibility(confirmPassword, 10,driver);
		type(confirmPassword, keys,driver);
	}

	public void clickOnNewPasswordHiddenIcon(WebDriver driver){
		waitForElementVisibility(newPasswordHiddenIcon, 10,driver);
		click(newPasswordHiddenIcon,driver);
	}

	public String getNewPasswordValue(WebDriver driver){
		waitForElementVisibility(newPassword, 10,driver);
		return newPassword.getAttribute("value");
	}

	public void clickOnChangePasswordButton_2(WebDriver driver){
		waitForElementVisibility(changePasswordButton_2, 10,driver);
		click(changePasswordButton_2,driver);
	}

	public boolean isSuccessfulChangePasswordMessagePresent(WebDriver driver){
		waitForElementVisibility(changePasswordSuccessful, 10,driver);
		return isElementDisplayed(changePasswordSuccessful,driver);
	}

	public void clickOnBackToDashboardButton(WebDriver driver){
		waitForElementVisibility(backToDashBoardButton, 10,driver);
		click(backToDashBoardButton,driver);
	}

	public void clickOnChangeSecurityPinButton(WebDriver driver){
		waitForElementVisibility(changeSecurityPinButton, 10,driver);
		click(changeSecurityPinButton,driver);
	}

	public void clickOnContinuePinCodeButton(WebDriver driver){
		waitForElementVisibility(continueButton, 10,driver);
		click(continueButton,driver);
	}

	public boolean isSecurityPinErrorMessagePresent(WebDriver driver){
		waitForElementVisibility(securityPinErrorMessage, 10,driver);
		return isElementDisplayed(securityPinErrorMessage,driver);
	}

	public boolean isSuccessfulChangePinMessagePresent(WebDriver driver){
		waitForElementVisibility(changePinSuccessful, 10,driver);
		return isElementDisplayed(changePinSuccessful,driver);
	}

	public void enterConfirmPinCode(String keys,WebDriver driver){
		waitForElementVisibility(confirmPinCode, 10,driver);
		type(confirmPinCode, keys, driver);
	}

	public void loginToAppWithOutPinCode(String emailParameter, String passwordParameter, WebDriver driver) {
		//ErrorCollector.extentLogInfo("<b>Login With Out Pin Code</b>");
		//openURL(AppUrl);
		enterB2CUserWebPassword(appPassword, driver);
		clickOnSubmitButton(driver);
		clickOnLoginPageButton(driver);
		clickOnloginWithEmail(driver);
		enterB2CUserEmailAddress(emailParameter, driver);
		enterB2CUserPassword(passwordParameter, driver);
		clickOnLoginButton(driver);
	}

	public void clickOnForgotPinCode(WebDriver driver){
		waitForElementClickable(forgotPinCode, "10", driver);
		click(forgotPinCode, driver);
	}

	public void clickOnResetPinButton(WebDriver driver){
		waitForElementClickable(resetPinButton, "10", driver);
		click(resetPinButton, driver);
	}

	public boolean isResetPinDisabled(){
		return resetPinButton.isEnabled();
	}

	public boolean isAnswer1ErrorMessagePresent(WebDriver driver){
		waitForElementVisibility(answer1IsRequired, 10, driver);
		return 	isElementDisplayed(answer1IsRequired, driver);
	}

	public boolean isAnswer2ErrorMessagePresent(WebDriver driver){
		waitForElementVisibility(answer2IsRequired, 10, driver);
		return isElementDisplayed(answer2IsRequired, driver);
	}

	public void enterAnswer1(String keys, WebDriver driver){
		waitForElementVisibility(answer1Input, 10, driver);
		type(answer1Input, keys, driver);
	}

	public void enterAnswer2(String keys, WebDriver driver){
		waitForElementVisibility(answer2Input, 10, driver);
		type(answer2Input, keys, driver);
	}

	public void clearAnswer1(WebDriver driver){
		waitForElementVisibility(answer1Input, 10, driver);
		answer1Input.clear();
		answer1Input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		answer1Input.sendKeys(Keys.DELETE);
	}

	public void clickOnEyeIcon(WebDriver driver){
		waitForElementVisibility(eyeIcon, 10, driver);
		click(eyeIcon, driver);
	}

	public String getPinValue(WebDriver driver){
		waitForElementVisibility(pinCodeInput, "10", driver);
		return pinCodeInput.getAttribute("value");
	}

	public String getConfirmPinValue(WebDriver driver){
		waitForElementVisibility(confirmPinCode, "10", driver);
		return confirmPassword.getAttribute("value");
	}

	public void clickOnManagePlanTab(WebDriver driver){
		click(managePlanTab, driver);
	}

	public boolean isPremiumPlanActive(WebDriver driver){
		waitForElementVisibility(premiumPlanActive, 10, driver);
		return isElementDisplayed(premiumPlanActive, driver);
	}
	
	public void clickOnAcceptAndProcessed(WebDriver driver) {
		try {
			click(noButton, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			click(acceptAndProcessed, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
