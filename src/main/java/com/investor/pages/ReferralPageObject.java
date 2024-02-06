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

public class ReferralPageObject extends BaseClass {

	private WebDriver podriver = null;
	@FindBy(xpath = "//div[@data-testid='rewardsNavBtnDesk']")
	WebElement btnRewards;

	@FindBy(xpath = "//div[text()='Earn']/parent::div")
	WebElement earnButton;

	@FindBy(xpath = "//span[contains(text(),'Redeem')]/parent::span/parent::div")
	WebElement redeemButton;

	@FindBy(xpath = "//div[text()='History']/parent::div")
	WebElement historyButton;

	@FindBy(xpath = "//p[text()='View details']/parent::div")
	WebElement earnViewDetails;

	@FindBy(xpath = "(//p[text()='Refer and Earn'])[1] | (//p[contains(text(),'Give $')])[1]")
	WebElement profileReferralPage;

	@FindBy(xpath = "//span[contains(text(), 'Invite')]//parent::button")
	WebElement inviteButton;

	@FindBy(xpath = "//a[contains(text(), 'FAQs')]")
	WebElement FAQsButton;

	@FindBy(xpath = "//a[contains(text(), 'Referral Disclosure')]")
	WebElement referralButton;

	@FindBy(xpath = "//p[contains(text(), 'Share your link')]")
	WebElement shareLinkPopup;

	@FindBy(xpath = "//p[@data-testid= 'ReferralInviteLink']")
	WebElement referralInviteLink;

	@FindBy(xpath = "//p[contains(text(), 'Copy link')]//parent::button")
	WebElement copyLinkButton;

	@FindBy(xpath = "//span[contains(text(), 'Link Copied!')]")
	WebElement linkCopied;

	@FindBy(xpath = "//input[@name='password']")
	WebElement ngaPassword;

	@FindBy(xpath = "//span[contains(text(), 'Submit')]//parent::button")
	WebElement submitButton;

	@FindBy(xpath = "//p[contains(text(), 'SIGN UP & CLAIM YOUR $10 REWARD')]//parent::button")
	WebElement rewardSignUpButton;

	@FindBy(xpath = "//input[@placeholder='Referral Code']")
	WebElement referralInput;

	public ReferralPageObject(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public void clickOnRewardsDisclosure(WebDriver driver) {
		try {
			click(btnRewards, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(btnRewards, driver);
		}
	}

	public Boolean isEarnButtonVisible(WebDriver driver) {
		return isElementDisplayed(earnButton, driver);
	}

	public Boolean isRedeemButtonVisible(WebDriver driver) {
		return isElementDisplayed(redeemButton, driver);
	}

	public Boolean isHistoryButtonVisible(WebDriver driver) {
		return isElementDisplayed(historyButton, driver);
	}

	public Boolean isViewDetailsButtonVisible(WebDriver driver) {
		return isElementDisplayed(earnViewDetails, driver);
	}

	public Boolean isViewDetailsButtonClickable(WebDriver driver) {
		try {
			waitForElementClickable(earnViewDetails, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public void clickOnViewDetail(WebDriver driver) {
		try {
			click(earnViewDetails, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(earnViewDetails, driver);
		}
	}

	public boolean isProfileReferralPageDisplaying(WebDriver driver) {
		return isElementDisplayed(profileReferralPage, driver);
	}

	public boolean isInviteButtonVisible(WebDriver driver) {
		return isElementDisplayed(inviteButton, driver);
	}

	public boolean isFAQsButtonVisible(WebDriver driver) {
		return isElementDisplayed(FAQsButton, driver);
	}

	public boolean isReferralButtonVisible(WebDriver driver) {
		return isElementDisplayed(referralButton, driver);
	}

	public boolean isFAQsButtonClickable(WebDriver driver) {
		try {
			waitForElementClickable(FAQsButton, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public boolean isReferralButtonClickable(WebDriver driver) {
		try {
			waitForElementClickable(referralButton, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public boolean isInviteButtonClickable(WebDriver driver) {
		try {
			waitForElementClickable(inviteButton, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public void clickOnInviteButton(WebDriver driver) {
		try {
			click(inviteButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(inviteButton, driver);
		}
	}

	public boolean isShareLinkPopUpVisible(WebDriver driver) {
		return isElementDisplayed(shareLinkPopup, driver);
	}

	public boolean isReferralInviteLinkVisible(WebDriver driver) {
		return isElementDisplayed(referralInviteLink, driver);
	}

	public boolean isCopyLinkButtonVisible(WebDriver driver) {
		return isElementDisplayed(copyLinkButton, driver);
	}

	public boolean isCopyLinkButtonClickable(WebDriver driver) {
		try {
			waitForElementClickable(copyLinkButton, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public void clickOnCopyLinkButton(WebDriver driver) {
		try {
			click(copyLinkButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(copyLinkButton, driver);
		}
	}

	public boolean isLinkCopiedVisible(WebDriver driver) {
		try {
			waitForElementVisibility(linkCopied, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String getReferralInviteLink(WebDriver driver) {
		return getElementText(referralInviteLink, driver);
	}

	public void NgaPasswordInsert(WebDriver driver, String password) {
		type(ngaPassword, password, driver);
	}

	public void clickOnSubmitButton(WebDriver driver) {
		try {
			click(submitButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(submitButton, driver);
		}
	}

	public void clickOnRewardSignUpButton(WebDriver driver) {
		try {
			click(rewardSignUpButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(rewardSignUpButton, driver);
		}
	}

	public String getReferralCode(WebDriver driver) {
		return getElementAttributeValue(referralInput, "value", driver);
	}

}
