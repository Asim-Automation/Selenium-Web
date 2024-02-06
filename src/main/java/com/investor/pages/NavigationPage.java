package com.investor.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;

public class NavigationPage extends BaseClass {

	private WebDriver podriver = null;
	@FindBy(xpath = "(//*[contains(text(),'Go Premium')])[1]")
	WebElement btnGoPremium;
	
	@FindBy(xpath = "(//*[contains(text(),'Select a plan that suits you best')])[1]")
	WebElement labelSelectPlan;

	@FindBy(xpath = "(//*[contains(text(),'Home')])[1]")
	WebElement btnHome;
	
	@FindBy(xpath = "(//*[contains(text(),'Portfolio Overview')])[1]")
	WebElement labelPortfolioOverview;
	
	@FindBy(xpath = "(//*[contains(text(),'Transfer')])[1]")
	WebElement btnTransfer;

	@FindBy(xpath = "(//*[contains(text(),'ADD FUNDS')])[1]")
	WebElement btnAddFund;

	@FindBy(xpath = "(//*[contains(text(),'Vested Direct')])[1]")
	WebElement btnVestedDirects;
	
	@FindBy(xpath = "//div[@data-testid='referralNavBtnDesk'] | (//p[@data-testid='referralNavBtnProfileDrawer'])[last()]")
	WebElement btnReferal;
	
	@FindBy(xpath = "//div[@data-testid='rewardsNavBtnDesk']")
	WebElement btnRewards;
	
	@FindBy(xpath = "(//*[contains(text(),'Introducing the Vested Direct Account')])[1]")
	WebElement labelVestedDirectsIntro;

	@FindBy(xpath = "(//*[contains(text(),'Referral')])[1]")
	WebElement btnReferral;
	
	@FindBy(xpath = "(//*[contains(text(),'Share your link')])[1]")
	WebElement labelShareLink;
	
	@FindBy(xpath = "(//div[contains(@class,'css-1clda8b')]//*[contains(text(),'Profile')])[1]")
	WebElement btnProfile;
	
	@FindBy(xpath = "(//*[contains(@class,'ant-popover-inner-content')])[1]")
	List<WebElement> profileMenu;
	
	@FindBy(xpath = "//span[text()='DIY Vest']")
	WebElement diyVestBtn;
	
	@FindBy(xpath = "//span[text()='Click here to change how your Vests are sorted.']//following-sibling::span")
	WebElement diyVestPopupClose;
	
	@FindBy(xpath = "(//p[text()='Transactions'])[2]")
	WebElement transactionsBtn;
	
	@FindBy(xpath="(//p[text()='Trade Confirmations'])[2]")
	WebElement tradeConfirmationsBtn;

	@FindBy(xpath="(//p[text()='Account Statements'])[2]")
	WebElement accountStatementsBtn;

	@FindBy(xpath="(//p[text()='Tax Documents'])[2]")
	WebElement taxDocumentsBtn;
	
	@FindBy(xpath="(//p[text()='FAQ'])[2]")
	WebElement faqBtn;
	
	@FindBy(xpath="(//p[text()='Referral'])[2]")
	WebElement referralBtn;
	
	@FindBy(xpath = "(//p[text()='Manage Plan'])[2]")
	WebElement managePlanBtn;
			
	@FindBy(xpath="(//p[text()='Investment Profile'])[2]")
	WebElement investmentProfileBtn;
	
	@FindBy(xpath="(//p[text()='Recurring Investments'])[2]")
	WebElement recurringInvestmentsBtn;
		
	@FindBy(xpath="(//p[text()='Login and Security'])[last()] | (//p[contains(text(),'Security')])[2] | (//p[text()='Security'])[last()]")
	WebElement securityBtn;
	
	@FindBy(xpath = "(//p[text()='Login and Security'])[2] | (//p[text()='Security'])[2]")
	WebElement securityPageHeading;
	
	@FindBy(xpath = "(//span[text()='Profile'])[1]")
	WebElement ProfileBtn;
	
	@FindBy(xpath = "(//div[@id='completedTxn']//*[local-name()='svg'])[last()] |  (//p[text()='Completed transactions']//parent::div//*[local-name() = 'svg'])[2] | (//p[text()='Completed transactions']//parent::div//*[local-name() = 'svg'])[2]/parent::div")
	WebElement completedTransactionsFilterIcon;
	
	@FindBy(xpath = "(//li[text()='Buy'])[2] | (//li[text()='Buy'])[1]")
	WebElement completedTransactionsBuy;
	
	@FindBy(xpath = "(//li[text()='Sell'])[2] | (//li[text()='Sell'])[1]")
	WebElement completedTransactionsSell;
	
	@FindBy(xpath = "(//li[text()='Deposits'])[2] | (//li[text()='Deposits'])[1]")
	WebElement completedTransactionsDeposit;
	
	@FindBy(xpath = "//p[text()='Next']//parent::button")
	WebElement addFundsNextBtn;
	
	@FindBy(xpath = "//p[text()='Got It']//parent::button")
	WebElement addFundsGotItBtn;
	@FindBy(xpath = "(//div[@data-testid='nav-profile-menu'])[2]")
	WebElement profileMenuCard;
	
	
	
	public NavigationPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}
	
	public void clickAddFundsGuide(WebDriver driver)  {
		for (int i=1;i<=4 ; i++) {
			wait1s();
			try {
				click(addFundsNextBtn, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(addFundsNextBtn, driver);
			}
			
		}
		try {
			click(addFundsGotItBtn, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(addFundsGotItBtn, driver);
		}
		
	}
	public void clickOnGoPremiumBtn(WebDriver driver) {
		click(btnGoPremium, driver);
	}
	
	public boolean isSelectPlanMessageDisplaying(WebDriver driver) {
		return isElementDisplayed(labelSelectPlan, driver);
	}

	public void clickOnHomeBtn(WebDriver driver) {
		try {
			click(btnHome, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnHome, driver);
		}		
	}
	
	public boolean isPortfolioOverviewLabelDisplaying(WebDriver driver) {
		return isElementDisplayed(labelPortfolioOverview, driver);
	}

	public void clickOnTransferBtn(WebDriver driver) {
		click(btnTransfer, driver);
	}
	
	public boolean isAddFundButtonDisplaying(WebDriver driver) {
		return isElementDisplayed(btnAddFund, driver);
	}
	
	public void clickOnVestedDirectsBtn(WebDriver driver) {
		click(btnVestedDirects, driver);
	}
	public void clickOnReferalBtn(WebDriver driver) {
		try {
			click(btnReferal, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnReferal, driver);
		}
		
	}
	public void clickOnRewardsBtn(WebDriver driver) {
		click(btnRewards, driver);
	}
	
	
	public boolean isVestedDirectsIntroLabelDisplaying(WebDriver driver) {
		return isElementDisplayed(labelVestedDirectsIntro, driver);
	}

	public void clickOnRefferalsBtn(WebDriver driver) {
		click(btnReferral, driver);
	}
	
	public boolean isRefferalsLabelDisplaying(WebDriver driver) {
		return isElementDisplayed(labelShareLink, driver);
	}

//	public void clickOnProfileBtn() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("var clickEvent = document.createEvent('MouseEvents', driver);clickEvent.initEvent('mouseover', true, true, driver); arguments[0].dispatchEvent(clickEvent, driver);", btnProfile, driver);
//	}
	
	public boolean isProfileMenuDisplaying(WebDriver driver) {
		return profileMenu.size()>0;
	}
	
	public void waitTillTenSeconds(WebDriver driver)  {
		wait6s();wait4s();
//		waitforPageLoad(60, driver);
	}

	public void clickOnDiyVestBtn(WebDriver driver) throws InterruptedException {
		waitfor5sec();
		click(diyVestBtn, driver);
		try {
			click(diyVestPopupClose, driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void clickOnProfileBtn(WebDriver driver) {
 
			try {
				click(ProfileBtn, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(ProfileBtn, driver);
			}

		
	}
	
	
	public void clickOnCompletedTransactionsFilterBtn(WebDriver driver) {
		try {
			click(completedTransactionsFilterIcon, driver);
		}catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(completedTransactionsFilterIcon, driver);
			}catch (Exception e1) {
				
				clickUsingActionClass(completedTransactionsFilterIcon, driver);
			}
			
		}
	}
	
	public void clickOnCompletedTransactionsBuyBtn(WebDriver driver) {
		try {
			click(completedTransactionsBuy, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(completedTransactionsBuy, driver);
		}
	}
	public void clickOnCompletedTransactionsSellBtn(WebDriver driver) {
		try {
			click(completedTransactionsSell, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(completedTransactionsSell, driver);
		}
	}
	public void clickOnCompletedTransactionsDepositBtn(WebDriver driver) {
		try {
			click(completedTransactionsDeposit, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(completedTransactionsDeposit, driver);
		}
	}

	public void clickOnTransactionsBtn(WebDriver driver) {
		click(transactionsBtn, driver);
	}
	
	public void clickOnTradeConfirmationsBtn(WebDriver driver) {	
		scrollIntoViewSmoothly(tradeConfirmationsBtn, driver);
		click(tradeConfirmationsBtn, driver);		
	}
	
	public void clickOnAccountStatementsBtn(WebDriver driver) {
		scrollIntoViewSmoothly(accountStatementsBtn, driver);
		click(accountStatementsBtn, driver);
	}
	public void clickOnTaxDocumentsBtn(WebDriver driver) {
		scrollIntoViewSmoothly(taxDocumentsBtn, driver);
		click(taxDocumentsBtn, driver);
	}
	public void clickOnFaqBtn(WebDriver driver) {
		scrollIntoViewSmoothly(faqBtn, driver);
		click(faqBtn, driver);
	}
	public void clickOnReferralBtn(WebDriver driver) {
		scrollIntoViewSmoothly(referralBtn, driver);
		click(referralBtn, driver);
	}
	public void clickOnManagePlanBtn(WebDriver driver) {
		scrollIntoViewSmoothly(managePlanBtn, driver);
		click(managePlanBtn, driver);
	}
	public void clickOnInvestmentProfileBtn(WebDriver driver) {
		scrollIntoViewSmoothly(investmentProfileBtn, driver);
		click(investmentProfileBtn, driver);
	}
	
	public void clickOnSecurityBtn(WebDriver driver) {
		try {
			click(securityBtn, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(securityBtn, driver);
		}
		
	}
	public String getSecurityPageHeading(WebDriver driver) {
		scrollIntoViewSmoothly(securityPageHeading, driver);
		return getElementText(securityPageHeading, driver);
	}
	
	public void clickOnRecurringInvestmentsBtn(WebDriver driver) {
		try {
			click(recurringInvestmentsBtn, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(accountStatementsBtn, driver);
		}
		
	}
	
	public void clickAddFundBtn(WebDriver driver) {
		try {
			click(btnAddFund, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(btnAddFund, driver);
		}
		
	}
	
}
