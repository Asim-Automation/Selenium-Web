package com.investor.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;

public class MonkeyPageObject extends BaseClass {

	@FindBy(xpath = "(//*[contains(text(),'Home')])[1]")
	WebElement btnHome;

	@FindBy(xpath = "(//*[contains(text(),'Transfer')])[1]")
	WebElement btnTransfer;

	@FindBy(xpath = "(//*[contains(text(),'DIY Vest')])[1]")
	WebElement btnDIYVest;

	private WebDriver podriver = null;
	@FindBy(xpath = "//div[@title='Daily Portfolio Tracker Chart']")
	WebElement dailyPortFolio;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement dailyPortFolioModelCloseIcon;

	@FindBy(xpath = "//div[@data-testid='addfundsBtn']")
	WebElement addFundsIcon;

	@FindBy(xpath = "//p[contains(text(),'Add USD')] | //p[contains(text(),'ADD FUNDS')]")
	WebElement addFundsModel;

	@FindBy(xpath = "//p[contains(text(),'Add USD')]/..//following-sibling::div/img | //p[contains(text(),'ADD FUNDS')]/..//following-sibling::div/img")
	WebElement addFundsModelCloseIcon;

	@FindBy(xpath = "(//p[contains(text(),'proceed with vested direct')])[1]")
	WebElement proceedWithVestedDirectBtn;

	@FindBy(xpath = "(//div[@class='ant-modal-body']//following::img)[1]")
	WebElement proceedWithVestedDirectModelCloseIcon;

	@FindBy(xpath = "//p[text()='Introducing the Vested Direct Account']")
	WebElement proceedWithVestedDirectModelTitle;

	@FindBy(xpath = "(//p[contains(text(),'Open Vested Direct Account')])[1]")
	WebElement openVestedDirectAccountBtn;

	@FindBy(xpath = "(//button/span[contains(text(),'WITHDRAW FUNDS')])[1]")
	WebElement withdrawFundsBtn;

	@FindBy(xpath = "(//p[contains(text(),'Amount to Withdraw')])[1]")
	WebElement amountToWithdrawLable;

	@FindBy(xpath = "//button/p[text()='switch bank']")
	WebElement switchBankBtn;

	@FindBy(xpath = "//p[text()='add funds']/../following-sibling::div/img")
	WebElement switchBankCloseIcon;

	@FindBy(xpath = "(//p[contains(text(),'Introducing the Vested Direct Account')])")
	WebElement vistedDirectPage;

	@FindBy(xpath = "//p[text()='Bank servers are offline from 11 Pm to 4 am IST.']")
	WebElement openVestedDirectAccountPageOffline;

	@FindBy(xpath = "//p[contains(text(),'OPEN Vested Direct account')]")
	WebElement openVestedDirectAccountNotPage;

	@FindBy(xpath = "//span[text()='GO TO DASHBOARD']")
	WebElement goToDashboardBtn;

	@FindBy(xpath = "//span[text()='Your Vests']")
	WebElement diyVestPage;

	@FindBy(xpath = "//span[text()='Proceed']")
	WebElement proceedPopupBtn;

	@FindBy(xpath = "//span[contains(text(),'Full KYC Verification')]")
	WebElement verificationPage;

	@FindBy(xpath = "//button[contains(text(),'START')]")
	WebElement startBtn;

	@FindBy(xpath = "//span[contains(text(),'KYC')]")
	WebElement KYCPage;

	@FindBy(xpath = "//p[contains(text(),'OPEN Vested Direct account')]")
	WebElement openVestedDirectAccountPage;

	@FindBy(xpath = "//p[contains(text(),'Verify your C-KYC')]")
	WebElement verifyYourKycBtn;

	@FindBy(xpath = "(//p[contains(text(),'Transactions')])[2]")
	WebElement ProfileTransactionsBtn;

	@FindBy(xpath = "(//p[contains(text(),'Completed transactions')])[1]")
	WebElement ProfileTransactionsPage;

	@FindBy(xpath = "(//p[contains(text(),'Trade Confirmations')])[2]")
	WebElement ProfileTradeConfirmationsBtn;

	@FindBy(xpath = "(//p[contains(text(),'Trade Confirmation')])[2]")
	WebElement ProfileTradeConfirmationsPage;

	@FindBy(xpath = "(//p[contains(text(),'Account Statements')])[2]")
	WebElement ProfileAccountStatementsBtn;

	@FindBy(xpath = "(//p[contains(text(),'Monthly Statement')])[1]")
	WebElement ProfileAccountStatementsPage;

	@FindBy(xpath = "(//p[contains(text(),'Tax Documents')])[2]")
	WebElement ProfileTaxDocumentsBtn;

	@FindBy(xpath = "(//div[@data-testid='nav-profile-menu']//p[text()='Tax Documents'])[2]")
	WebElement ProfileTaxDocumentsBtn1;

	@FindBy(xpath = "//p[contains(text(),'- 2022')]//parent::div")
	WebElement latestYear;

	@FindBy(xpath = "(//p[contains(text(),'Tax Documents')])[2]")
	WebElement ProfileTaxDocumentsPage;

	@FindBy(xpath = "(//p[contains(text(),'FAQ')])[2]")
	WebElement ProfileFAQBtn;

	@FindBy(xpath = "(//h2[contains(text(),'Frequently Asked Questions about US Investing and Vested')])[1] | (//h1[contains(text(),'Frequently Asked Questions about US Investing and Vested')])[1]")
	WebElement ProfileFAQPage;

	@FindBy(xpath = "(//p[contains(text(),'Referral')])[2]")
	WebElement ProfileReferralBtn;
	
	@FindBy(xpath = "//button[contains(@class,'ant-btn-link')]")
	WebElement copyLink;
	
	@FindBy(xpath = "//img[contains(@src,'whatsapp.svg')]//parent::div")
	WebElement whatappLink;
	
	@FindBy(xpath = "//img[contains(@src,'facebook.svg')]//parent::div")
	WebElement facebookLink;
	
	@FindBy(xpath = "//img[contains(@src,'linkedin-02.svg')]//parent::div")
	WebElement linkedInLink;
	
	@FindBy(xpath = "//img[contains(@src,'twitter.svg')]//parent::div")
	WebElement twitterLink;
	
	@FindBy(xpath = "//img[contains(@src,'gmail.svg')]//parent::div")
	WebElement gmailLink;
	
	@FindBy(xpath = "//a[text()='FAQs']")
	WebElement faqLink;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement FAQPopupCloseIcon;

	@FindBy(xpath = "(//p[text()='Refer and Earn'])[1] | (//p[contains(text(),'Give $')])[1]")
	WebElement ProfileReferralPage;

	@FindBy(xpath = "//p[text()='Frequently Asked Questions']")
	WebElement ProfileReferralPageFAQPopupHeading;

	@FindBy(xpath = "//p[contains(text(),'maximum limit that I can earn')]")
	WebElement ProfileReferralPageFAQPopupQ1;

	@FindBy(xpath = "//p[contains(text(),'When will I get the')]")
	WebElement ProfileReferralPageFAQPopupQ2;

	@FindBy(xpath = "//p[contains(text(),'What if I did not get the referral')]")
	WebElement ProfileReferralPageFAQPopupQ3;

	@FindBy(xpath = "//p[contains(text(),'What if my friend is already a registered user?')]")
	WebElement ProfileReferralPageFAQPopupQ4;

	@FindBy(xpath = "(//p[contains(text(),'Manage Plan')])[2]")
	WebElement ProfileManagePlanBtn;

	@FindBy(xpath = "(//p[contains(text(),'Plan Details')])[1]")
	WebElement ProfileManagePlanPage;

	@FindBy(xpath = "(//p[contains(text(),'Investment Profile')])[2]")
	WebElement ProfileInvestmentProfileBtn;

	@FindBy(xpath = "(//p[contains(text(),'Investment Profile')])[2]")
	WebElement ProfileInvestmentProfilePage;

	@FindBy(xpath = "(//p[contains(text(),'Recurring Investments')])[2]")
	WebElement ProfileRecurringInvestmentsBtn;

	@FindBy(xpath = "(//p[contains(text(),'Recurring Investment')])[3]")
	WebElement ProfileRecurringInvestmentsPage;

	@FindBy(xpath = "(//p[contains(text(),'Security')])[2]")
	WebElement ProfileSecurityBtn;

	@FindBy(xpath = "(//p[text()='Login and Security'])[2] | (//p[text()='Security'])[2]")
	WebElement ProfileSecurityPage;

	@FindBy(xpath = "(//p[contains(text(),'Log Out')])[2]")
	WebElement ProfileLogOutBtn;

	@FindBy(xpath = "(//div[contains(text(),'Welcome back!')])[1]")
	WebElement ProfileLogOutWelcomeBackPage;

	@FindBy(xpath = "(//div[contains(text(),'Change Password')])[1]")
	WebElement SecurityChangePasswordBtn;

	@FindBy(xpath = "(//span[contains(text(),'Change Password')])[1]")
	WebElement SecurityChangePasswordPage;

	@FindBy(xpath = "(//div[contains(text(),'Change Security Pin')])[1]")
	WebElement ChangeSecurityPinBtn;

	@FindBy(xpath = "(//p[contains(text(),'Enter your current 6 digit pin')])[1]")
	WebElement ChangeSecurityPinPage;

	@FindBy(xpath = "(//p[contains(text(),'FAANG - Rebalance')])[1]")
	WebElement faangRebalanceBtn;

	@FindBy(xpath = "(//p[contains(text(),'FAANG - Rebalance')])[1]")
	WebElement faangRebalancePage;

	@FindBy(xpath = "(//span[contains(text(),'New Recurring Investment')])[1]")
	WebElement newRecurringInvestmentBtn;

	@FindBy(xpath = "(//p[contains(text(),'Create Recurring Investment')])[1]")
	WebElement newRecurringInvestmentPage;
	
	@FindBy(xpath = "//p[text()='For Tax Reporting']//parent::div//a")
	List<WebElement> taxReportLinks; 
	
	@FindBy(xpath = "//div[text()='Earn']/parent::div")
	WebElement earnButton; 
	
	@FindBy(xpath = "//p[text()='Refer And Earn']")
	WebElement earnBannerTitle;
	
	@FindBy(xpath = "//span[contains(text(),'Redeem')]/ancestor::div[@role='tab'] | //div[text()='Redeem']/parent::div")
	WebElement redeemButton; 
	
	@FindBy(xpath = "//p[text()='Redeem For Cash']")
	WebElement redeemBannerTitle;
	
	@FindBy(xpath = "//div[text()='History']/parent::div")
	WebElement historyButton; 
	
	@FindBy(xpath = "(//a[@data-testid='RewardsDisclosureLink'])[last()]")
	WebElement rewardDisclosure; 
	
	@FindBy(xpath = "//h1[contains(text(),'Disclosures')]")
	WebElement rewardDisclosurePageHeading; 
	
	@FindBy(xpath = "//p[@data-testid='vpToCashConversionEgText']")
	WebElement cashConversion; 
	
	@FindBy(xpath = "//p[text()='View details']/parent::div")
	WebElement earnViewDetails; 
	
	@FindBy(xpath = "(//p[text()='Refer and Earn'])[1]")
	WebElement EarnDetailPage; 
	
	@FindBy(xpath = "//p[text()='Redeem']/parent::div")
	WebElement redeemDetail; 
	
	@FindBy(xpath = "(//p[text()='Redeem For Cash'])[1]")
	WebElement redeemDetailPage; 

	public MonkeyPageObject(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public void clickDailyPortFolioIcon(WebDriver driver) {
		try {
			click(dailyPortFolio, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(dailyPortFolio, driver);
		}
	}

	public boolean isDailyPortFolioModelCloseIconDisplaying(WebDriver driver) {
		waitForElementVisibility(dailyPortFolioModelCloseIcon, "30", driver);
		return isElementDisplayed(dailyPortFolioModelCloseIcon, driver);
	}

	public void clickDailyPortFolioModelCloseIcon(WebDriver driver) {
		click(dailyPortFolioModelCloseIcon, driver);
	}

	public void clickAddFundsIcon(WebDriver driver) {
		click(addFundsIcon, driver);
	}

	public boolean isAddFundsModelDisplaying(WebDriver driver) {
		return isElementDisplayed(addFundsModel, driver);
	}

	public void clickAddFundsModelCloseIcon(WebDriver driver) {
		click(addFundsModelCloseIcon, driver);
	}

	public void clickProceedWithVestedDirectBtn(WebDriver driver) {
		click(proceedWithVestedDirectBtn, driver);
	}

	public boolean isProceedWithVestedDirectModelCloseIconDisplaying(WebDriver driver) {
		return isElementDisplayed(proceedWithVestedDirectModelCloseIcon, driver);
	}

	public boolean isProceedWithVestedDirectModelTitleDisplaying(WebDriver driver) {
		return isElementDisplayed(proceedWithVestedDirectModelTitle, driver);
	}

	public void clickProceedWithVestedDirectModelCloseIcon(WebDriver driver) {
		click(proceedWithVestedDirectModelCloseIcon, driver);
	}

	public void clickWithdrawFundsButton(WebDriver driver) {
		click(withdrawFundsBtn, driver);
	}

	public boolean isAmountToWithdrawLableDisplaying(WebDriver driver) {
		return isElementDisplayed(amountToWithdrawLable, driver);
	}

	public void clickSwitchBankButton(WebDriver driver) {
		click(switchBankBtn, driver);
	}

	public void clickSwitchBankCloseIcon(WebDriver driver) {
		click(switchBankCloseIcon, driver);
	}

	public void clickGoToDashboardButton(WebDriver driver) {
		click(goToDashboardBtn, driver);
	}

	public void clickOpenVestedDirectAccountButton(WebDriver driver) {
		click(openVestedDirectAccountBtn, driver);
	}

	public void clickOnPopupProceedButton(WebDriver driver) {
		click(proceedPopupBtn, driver);
	}

	public void clickOnStartButton(WebDriver driver) {
		click(startBtn, driver);
	}

	public boolean isVistedDirectPageDisplaying(WebDriver driver) {
		return isElementDisplayed(vistedDirectPage, driver);
	}

	public boolean isOpenVestedDirectAccountPageOfflineDisplaying(WebDriver driver) {
		waitForElementVisibility(openVestedDirectAccountPageOffline, "10", driver);
		return isElementDisplayed(openVestedDirectAccountPageOffline, driver);
	}

	public boolean isOpenVestedDirectAccountPageDisplaying(WebDriver driver) {
		waitForElementVisibility(openVestedDirectAccountPage, "10", driver);
		return isElementDisplayed(openVestedDirectAccountPage, driver);
	}

	public boolean isopenVestedDirectAccountNotAvailablePageDisplaying(WebDriver driver) {
		waitForElementVisibility(openVestedDirectAccountNotPage, "10", driver);
		return isElementDisplayed(openVestedDirectAccountNotPage, driver);
	}

	public boolean isVerificationPageDisplaying(WebDriver driver) {
		waitForElementVisibility(verificationPage, "30", driver);
		return isElementDisplayed(verificationPage, driver);
	}

	public boolean isKYCPageDisplaying(WebDriver driver) {
		waitForElementVisibility(KYCPage, "30", driver);
		return isElementDisplayed(KYCPage, driver);
	}

	public boolean isdiyVestPageDisplaying(WebDriver driver) {
		return isElementDisplayed(diyVestPage, driver);
	}

	public boolean isProceedPopupBtnDisplaying(WebDriver driver) {
		return isElementDisplayed(proceedPopupBtn, driver);
	}

	public void clickOnverifyYourKycButton(WebDriver driver) {
		waitForElementVisibility(verifyYourKycBtn, "30", driver);
		click(verifyYourKycBtn, driver);
	}

	public void clickOnProfileTransactionsButton(WebDriver driver) {
		waitForElementVisibility(ProfileTransactionsBtn, "30", driver);
		click(ProfileTransactionsBtn, driver);
	}

	public boolean isProfileTransactionsPageDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileTransactionsPage, driver);
	}

	public void clickOnProfileTradeConfirmationsButton(WebDriver driver) {
		waitForElementVisibility(ProfileTradeConfirmationsBtn, "30", driver);
		click(ProfileTradeConfirmationsBtn, driver);
	}

	public boolean isProfileTradeConfirmationsPageDisplaying(WebDriver driver) {
		waitForElementVisibility(ProfileTradeConfirmationsPage, "50", driver);
		return isElementDisplayed(ProfileTradeConfirmationsPage, driver);
	}

	public boolean isProfileTradeConfirmationsMenuEnabled(WebDriver driver) {
		return isElementEnabled(ProfileTradeConfirmationsBtn, driver);
	}

	public boolean isHomeMenuEnabled(WebDriver driver) {
		return isElementEnabled(btnHome, driver);
	}

	public boolean isTransferMenuEnabled(WebDriver driver) {
		return isElementEnabled(btnTransfer, driver);
	}

	public boolean isDIYVestMenuEnabled(WebDriver driver) {
		return isElementEnabled(btnDIYVest, driver);
	}

	public void clickOnProfileAccountStatementsButton(WebDriver driver) {
		waitForElementVisibility(ProfileAccountStatementsBtn, "30", driver);
		click(ProfileAccountStatementsBtn, driver);
	}

	public boolean isProfileAccountStatementsPageDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileAccountStatementsPage, driver);
	}

	public boolean isProfileAccountStatementsMenuIsEnabled(WebDriver driver) {
		return isElementEnabled(ProfileAccountStatementsBtn, driver);
	}

	public void clickOnProfileTaxDocumentsButton(WebDriver driver) {
		try {
			waitForElementVisibility(ProfileTaxDocumentsBtn1, "30", driver);
			click(ProfileTaxDocumentsBtn1, driver);
		} catch (Exception e) {
			waitForElementVisibility(ProfileTaxDocumentsBtn, "30", driver);
			click(ProfileTaxDocumentsBtn, driver);
		}

	}

	public void clickOnLatestYearTaxDocument(WebDriver driver) {
		waitForElementVisibility(latestYear, "30", driver);
		click(latestYear, driver);

	}

	public boolean isProfileTaxDocumentsPageDisplaying(WebDriver driver) {
		waitForElementVisibility(ProfileTaxDocumentsPage, "30", driver);
		return isElementDisplayed(ProfileTaxDocumentsPage, driver);
	}

	public boolean isProfileTaxDocumentsMenuIsEnabled(WebDriver driver) {
		try {
			waitForElementVisibility(ProfileTaxDocumentsPage, "30", driver);
			return isElementDisplayed(ProfileTaxDocumentsPage, driver);
		}catch (Exception e) {
			return false;
		}
		
	}

	public void clickOnProfileFAQButton(WebDriver driver) {
		waitForElementVisibility(ProfileFAQBtn, "30", driver);
		click(ProfileFAQBtn, driver);
	}

	public boolean isProfileFAQButtonEnabled(WebDriver driver) {
		return isElementEnabled(ProfileFAQBtn, driver);
	}

	public boolean isProfileFAQPageDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileFAQPage, driver);
	}

	public void clickOnProfileReferralButton(WebDriver driver) {
		waitForElementVisibility(ProfileReferralBtn, "30", driver);
		click(ProfileReferralBtn, driver);
	}
	public void clickOnCopyLink(WebDriver driver) {
		click(copyLink, driver);
	}
	public void clickOnWhatappLink(WebDriver driver) {
		click(whatappLink, driver);
	}
	public void clickOnFacebookLink(WebDriver driver) {
		click(facebookLink, driver);
	}
	public void clickOnLinkedINLink(WebDriver driver) {
		click(linkedInLink, driver);
	}
	public void clickOnTwitterLink(WebDriver driver) {
		click(twitterLink, driver);
	}
	public void clickOnGmailLink(WebDriver driver) {
		click(gmailLink, driver);
	}
	
	

	public void clickOnFAQLink(WebDriver driver) {
		click(faqLink, driver);
	}
	
	

	public void clickOnFAQPopupCloseIcon(WebDriver driver) {
		click(FAQPopupCloseIcon, driver);
	}

	public boolean isProfileReferralButtonEnabled(WebDriver driver) {
		return isElementEnabled(ProfileReferralBtn, driver);
	}

	public boolean isProfileReferralPageDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileReferralPage, driver);
	}

	public boolean isProfileReferralPageFAQPopupHeadingDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileReferralPageFAQPopupHeading, driver);
	}

	public boolean isProfileReferralPageFAQPopupQ1Displaying(WebDriver driver) {
		return isElementDisplayed(ProfileReferralPageFAQPopupQ1, driver);
	}

	public boolean isProfileReferralPageFAQPopupQ2Displaying(WebDriver driver) {
		return isElementDisplayed(ProfileReferralPageFAQPopupQ2, driver);
	}

	public boolean isProfileReferralPageFAQPopupQ3Displaying(WebDriver driver) {
		return isElementDisplayed(ProfileReferralPageFAQPopupQ3, driver);
	}

	public boolean isProfileReferralPageFAQPopupQ4Displaying(WebDriver driver) {
		return isElementDisplayed(ProfileReferralPageFAQPopupQ4, driver);
	}

	public void clickOnProfileManagePlanButton(WebDriver driver) {
		scrollToElement(ProfileManagePlanBtn, driver);
		waitForElementVisibility(ProfileManagePlanBtn, "30", driver);
		click(ProfileManagePlanBtn, driver);
	}

	public boolean isProfileManagePlanPageDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileManagePlanPage, driver);
	}

	public void clickOnProfileInvestmentProfileButton(WebDriver driver) {
		waitForElementVisibility(ProfileInvestmentProfileBtn, "30", driver);
		click(ProfileInvestmentProfileBtn, driver);
	}

	public boolean isProfileInvestmentProfilePageDisplaying(WebDriver driver) {
		waitForElementVisibility(ProfileInvestmentProfilePage, "30", driver);
		return isElementDisplayed(ProfileInvestmentProfilePage, driver);
	}

	public void clickOnProfileRecurringInvestmentsButton(WebDriver driver) {
		waitForElementVisibility(ProfileRecurringInvestmentsBtn, "30", driver);
		click(ProfileRecurringInvestmentsBtn, driver);
	}

	public boolean isProfileRecurringInvestmentsPageDisplaying(WebDriver driver) {
		waitForElementVisibility(ProfileRecurringInvestmentsPage, "30", driver);
		return isElementDisplayed(ProfileRecurringInvestmentsPage, driver);
	}

	public void clickOnProfileSecurityButton(WebDriver driver) {
		waitForElementVisibility(ProfileSecurityBtn, "30", driver);
		click(ProfileSecurityBtn, driver);
	}

	public boolean isProfileSecurityButtonEnabled(WebDriver driver) {
		return isElementEnabled(ProfileSecurityBtn, driver);
	}

	public boolean isProfileSecurityPageDisplaying(WebDriver driver) {
		return isElementDisplayed(ProfileSecurityPage, driver);
	}

	public void clickOnProfileLogOutButton(WebDriver driver) {
		try {
			waitForElementVisibility(ProfileLogOutBtn, "30", driver);
			click(ProfileLogOutBtn, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public boolean isProfileLogOutButtonEnabled(WebDriver driver) {
		return isElementEnabled(ProfileLogOutBtn, driver);
	}

	public boolean isProfileLogOutWelcomeBackPageDisplaying(WebDriver driver) {
		waitForElementVisibility(ProfileLogOutWelcomeBackPage, "30", driver);
		return isElementDisplayed(ProfileLogOutWelcomeBackPage, driver);
	}

	public void clickOnChangePasswordButton(WebDriver driver) {
		waitForElementVisibility(SecurityChangePasswordBtn, "30", driver);
		click(SecurityChangePasswordBtn, driver);
	}

	public boolean isSecurityChangePasswordPageDisplaying(WebDriver driver) {
		waitForElementVisibility(SecurityChangePasswordPage, "30", driver);
		return isElementDisplayed(SecurityChangePasswordPage, driver);
	}

	public void clickOnChangeSecurityPinButton(WebDriver driver) {
		waitForElementVisibility(ChangeSecurityPinBtn, "30", driver);
		click(ChangeSecurityPinBtn, driver);
	}

	public boolean isChangeSecurityPinPageDisplaying(WebDriver driver) {
		waitForElementVisibility(ChangeSecurityPinPage, "30", driver);
		return isElementDisplayed(ChangeSecurityPinPage, driver);
	}

	public void clickOnFaangRebalanceButton(WebDriver driver) {
		waitForElementVisibility(faangRebalanceBtn, "30", driver);
		click(faangRebalanceBtn, driver);
	}

	public boolean isFaangRebalancePageDisplaying(WebDriver driver) {
		waitForElementVisibility(faangRebalancePage, "30", driver);
		return isElementDisplayed(faangRebalancePage, driver);
	}

	public void clickOnNewRecurringInvestmentButton(WebDriver driver) {
		waitForElementVisibility(newRecurringInvestmentBtn, "30", driver);
		click(newRecurringInvestmentBtn, driver);
	}

	public boolean isNewRecurringInvestmentPageDisplaying(WebDriver driver) {
		waitForElementVisibility(newRecurringInvestmentPage, "30", driver);
		return isElementDisplayed(newRecurringInvestmentPage, driver);
	}

	public ArrayList<String> verifyDownloadableLink(WebDriver driver) throws IOException {
		ArrayList<String> testSteps = new ArrayList<String>();
		for (WebElement element : taxReportLinks) {
			URL url = null;
			final String urlFileToDownload = element.getAttribute("href");
			final String fileText = element.getText();
			testSteps.add("Verifying  <b>'" + " <a href=\"" + urlFileToDownload + "\">" + fileText + "<a/>" + "'</b>");
			url = new URL(urlFileToDownload);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			int response =  httpURLConnection.getResponseCode();
			String responseM =  httpURLConnection.getResponseMessage();
			printString("Response Code: "+httpURLConnection.getResponseCode()) ;
			printString("Response Message: "+httpURLConnection.getResponseMessage()) ;
			if (response == 200) {
				testSteps.add("<b>'" + fileText + "'</b>  link is verified");
				printString("<b>'" + fileText + "'</b>  link is verified");
				testSteps.add("Response Code = <b>"+response);
				printString("Response Code = <b>"+response);
				testSteps.add("Response Message = <b>"+responseM);
				printString("Response Message = <b>"+responseM);
				
			} else {
				testSteps.add("Failed: '" + fileText + "' link is not verified");
				printString("Failed: '" + fileText + "' link is not verified");
				testSteps.add("Response Code = <b>"+response);
				printString("Response Code = <b>"+response);
				testSteps.add("Response Message = <b>"+responseM);
				printString("Response Message = <b>"+responseM);
			}

		}
		return testSteps;

	}



	//Rewards
	
	public void clickOnEarn(WebDriver driver) {
		try {
			click(earnButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(earnButton, driver);
		}
		
	}
	public void clickOnRedeem(WebDriver driver) {
		try {
			click(redeemButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(redeemButton, driver);
		}
	}
	public void clickOnHistory(WebDriver driver) {
		try {
			click(historyButton, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(historyButton, driver);
		}
	}
	public void clickOnRewardsDisclosure(WebDriver driver) {
		try {
			click(rewardDisclosure, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(rewardDisclosure, driver);
		}
	}
	public void clickOnRedeemDetail(WebDriver driver) {
		try {
			click(redeemDetail, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(redeemDetail, driver);
		}
	}
	public void clickOnEarnDetail(WebDriver driver) {
		try {
			click(earnViewDetails, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(earnViewDetails, driver);
		}
	}


	public Boolean isEarnBannerTitleVisible(WebDriver driver) {
		return isElementDisplayed(earnBannerTitle, driver);	
	}
	public Boolean isRedeemBannerTitleVisible(WebDriver driver) {
		return isElementDisplayed(redeemBannerTitle, driver);	
	}
	public Boolean isCashConversionVisible(WebDriver driver) {
		return isElementDisplayed(cashConversion, driver);	
	}
	public Boolean isRewardDisclosureVisible(WebDriver driver) {
		return isElementDisplayed(rewardDisclosurePageHeading, driver);	
	}
	public Boolean isEarnDetailPageVisible(WebDriver driver) {
		return isElementDisplayed(EarnDetailPage, driver);	
	}
	public Boolean isRedeemDetailPageVisible(WebDriver driver) {
		return isElementDisplayed(redeemDetailPage, driver);	
	}
	
	
	
}
