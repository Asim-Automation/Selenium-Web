package com.investor.pages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;

public class HomePage extends BaseClass {

	private WebDriver podriver = null;
	@FindBy(xpath = "//p[contains(text(),'Multi-Asset Class - Aggressive')]/parent::div/parent::a | //p[text()='Aggressive']/../parent::div")
	WebElement agressiveButton;

	@FindBy(xpath = "//p[contains(text(),'Multi-Asset Class - Moderate')]/parent::div/parent::a |//p[text()='Moderate']/../parent::div")
	WebElement moderateButton;

	@FindBy(xpath = "//p[contains(text(),'Multi-Asset Class - Conservative')]/parent::div/parent::a | //p[text()='Conservative']/../parent::div")
	WebElement conservativeButton;

	@FindBy(xpath = "(//p[text()='Create Recurring Investment']/parent::button)[1]")
	WebElement createRecurringInvestmentButton;

	@FindBy(xpath = "(//p[text()='Create Recurring Investment']/parent::button)[2]")
	WebElement createRecurringInvestmentButton2;

	@FindBy(xpath = "//p[text()='Total Buying Power']/following-sibling::p")
	WebElement totalBuyingPower;

	@FindBy(name = "amount")
	WebElement investmentAmountInput;

	@FindBy(xpath = "//p[text()='Vest fee per purchase']/..//following::div/p")
	WebElement vestFeePerPurchase;

	@FindBy(xpath = "//div[@class='ant-picker-input']/input")
	WebElement startDate;

	@FindBy(name = "frequency")
	WebElement frequencyDropdownButton;

	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	WebElement selectedFrequency;

	@FindBy(xpath = "//button[text()='FAQs']")
	WebElement faqButton;

	@FindBy(xpath = "//p[text()='Frequently Asked Questions']")
	WebElement FAQModelTitle;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement faqModelCloseIcon;

	@FindBy(xpath = "//span[text()='Preview Recurring Investment']/..")
	WebElement previewRecurringInvestmentButton;

	@FindBy(className = "investment-amount-error")
	WebElement investmentAmountError;

	// Confirm page

	@FindBy(xpath = "//p[text()='Confirm']")
	WebElement confirmPagebreadCrumb;

	@FindBy(xpath = "//p[text()='Frequency']//following-sibling::p")
	WebElement confirmPageFrequency;

	@FindBy(xpath = "//p[text()='Start Date']//following-sibling::p")
	WebElement confirmPageStartDate;

	@FindBy(xpath = "//p[text()='Installment Amount']/parent::div/following-sibling::p | //p[text()='Investment Amount']//following-sibling::p")
	WebElement confirmPageInvestmentAmount;

	@FindBy(xpath = "//p[text()='Vest Fee']//following-sibling::p")
	WebElement confirmPageVestFee;

	@FindBy(xpath = "//span[text()='Start Recurring Investment']/..")
	WebElement startRecurringInvestmentButton;

	@FindBy(xpath = "//p[text()='Recurring Investments Dashboard']")
	WebElement recurringInvestmentsDashboardButton;

	@FindBy(xpath = "//p[contains(text(),'Recurring investment scheduled successfully')]")
	WebElement successMessage;

	@FindBy(xpath = "//span[text()='Start New recurring investment']/..")
	WebElement startNewRecurrignInvestmentButton;

	@FindBy(xpath = "//p[text()='Premium Member']")
	WebElement premiumMember;

	@FindBy(xpath = "//p[text()='All Weather']/parent::div/parent::a | //p[text()='All Weather']//parent::div")
	WebElement allWeather_Button;

	@FindBy(xpath = "//p[text()='All Weather']")
	WebElement allWeather_ButtonName;

	@FindBy(xpath = "//p[text()='BlackRock Smart Beta']//parent::div")
	WebElement blackRockSmartBetaBtn;
	@FindBy(xpath = "//p[text()='BlackRock Smart Beta']")
	WebElement blackRockSmartBetaBtnName;

	@FindBy(xpath = "//p[text()='Swensen Portfolio']/parent::div/parent::a | //p[text()='Swensen Portfolio']")
	WebElement SwensenPortfolioButton;
	@FindBy(xpath = "//p[text()='Swensen Portfolio']//parent::div")
	WebElement SwensenPortfolioButtonName;

	@FindBy(xpath = "//p[text() = 'Compare Vests']/parent::div")
	WebElement compareVestButton;

	@FindBy(xpath = "//p[contains(text() , 'Multi-Asset Class')]")
	WebElement multiAssetClassSection;

	@FindBy(xpath = "(//p[text() = 'Your Position'])[2]")
	WebElement yourPositionSection;

	@FindBy(xpath = "//button[text() = 'Buy']")
	WebElement buyButton;

	@FindBy(xpath = "//p[text() = 'Allocations']")
	WebElement allocationSection;

	@FindBy(xpath = "//p[text() = 'Returns']")
	WebElement returnsSection;

	@FindBy(xpath = "//p[text() = 'Volatility']")
	WebElement volatilitySection;

	@FindBy(xpath = "//p[text() = 'Multi-Asset Class - Conservative'] | (//p[contains(text() , 'Multi-Asset Class')])[1]")
	WebElement multiAssetClassConservativeSection;

	@FindBy(xpath = "(//p[contains(text() , 'Multi-Asset Class - Conservative')])[3] | (//p[text() = 'Multi-Asset Class - Conservative'])[3] | (//p[text() = 'Conservative'])[3]")
	WebElement compareVestConservative;

	@FindBy(xpath = "(//p[text() = 'Multi-Asset Class - Moderate'])[2] | (//p[text() = 'Moderate'])[2]")
	WebElement compareVestModerate;

	@FindBy(xpath = "(//p[text() = 'Multi-Asset Class - Aggressive '])[2] | (//p[text() = 'Multi-Asset Class - Aggressive'])[2] | (//p[text() = 'Aggressive'])[2]")
	WebElement compareVestAggressive;

	@FindBy(xpath = "//button[@class='ant-modal-close']")
	WebElement closeCompareVest;

	@FindBy(xpath = "(//div[text()='MAX'])[1]")
	WebElement overviewMax;

	@FindBy(xpath = "(//div[text()='Max'])[1]")
	WebElement overviewMax2;

	@FindBy(xpath = "(//div[text()='5Y'])[1]")
	WebElement overview5Y;

	@FindBy(xpath = "(//div[text()='1Y'])[1]")
	WebElement overview1Y;

	@FindBy(xpath = "(//div[text()='6M'])[1]")
	WebElement overview6M;

	@FindBy(xpath = "(//div[text()='3M'])[1]")
	WebElement overview3M;

	@FindBy(xpath = "(//div[text()='1M'])[1]")
	WebElement overview1M;

	@FindBy(xpath = "(//div[text()='1W'])[1]")
	WebElement overview1W;

	@FindBy(xpath = "//cq-clickable//*[@class='symbol-search'] | //div[@class='ant-card-head']//span[text()='fullscreen']//parent::div")
	WebElement fullScreen;

	@FindBy(xpath = "(//div[text()='1D'])[1]")
	WebElement overview1D;

	@FindBy(xpath = "//cq-chart-title[@cq-marker='true'] | (//div[@class='ant-card-body'])[1]")
	WebElement overviewGraph;

	@FindBy(xpath = "//div[@class='stx-subholder']")
	WebElement fullScreenGraph;

	@FindBy(xpath = "(//div[contains(text(),'Comparing')]/child::span)[1]")
	WebElement iIcon;

	@FindBy(xpath = "//div[text() = 'Vest Performance Chart']")
	WebElement vestPerformanceChart;

	@FindBy(xpath = "(//button[@class='ant-modal-close'])[2]")
	WebElement closeVestPerformanceChartButton;

	@FindBy(xpath = "//span[@class='ant-modal-close-x']/parent::button")
	WebElement closeVestPerformanceChartButton_2;

	@FindBy(xpath = "(//*[local-name()='g' and @class='recharts-layer recharts-line']/*[local-name()='path'])[1]")
	WebElement graph;

	@FindBy(xpath = "(//p[text() = 'FAANG - Rebalance'])[1]")
	WebElement fAANGRebalanceSection;

	@FindBy(xpath = "//p[text() = 'Vest Performance']")
	WebElement vestPerformanceSection;

	@FindBy(xpath = "//h1[text() = 'All Weather Portfolio - Inspired by Ray Dalio']")
	WebElement allWeatherPortfolioSection;

	@FindBy(xpath = "//p[text() = 'Share']/parent::div")
	WebElement shareFaangRebalanceButton;

	@FindBy(xpath = "//p[text() = 'Name']")
	WebElement nameInBuy;

	@FindBy(xpath = "//p[text() = 'Price']")
	WebElement priceInBuy;

	@FindBy(xpath = "//p[text() = 'Weight']")
	WebElement weightInBuy;

	@FindBy(xpath = "//p[text() = 'No. of Shares']")
	WebElement noOfShareInBuy;

	@FindBy(xpath = "//p[text() = 'Total Buying Power']")
	WebElement totalBuyingPowerInBuy;

	@FindBy(xpath = "//input[@name='cash']")
	WebElement investmentAmountBuyPage;

	@FindBy(xpath = "(//span[text() = 'Preview Order']/parent::button)[1]")
	WebElement previewOrderButton;

	@FindBy(xpath = "(//p[@color = 'danger'])[1]")
	WebElement investmentAmountErrorMessageOnBuy;

	@FindBy(xpath = "//span[text() = 'Place Buy Order']/parent::button")
	WebElement placeBuyOrder;

	@FindBy(xpath = "//div[text() = 'Buy Temporarily Unavailable']")
	WebElement buyTemporaryUnAvailable;

	@FindBy(xpath = "//span[text() = 'Home']/parent::p/parent::div/parent::li")
	WebElement homeTab;

	@FindBy(xpath = "//p[text() = 'Pending Vest Orders']/parent::div/parent::div/parent::div/parent::div/following-sibling::div/child::div/child::p")
	WebElement showAllPendingVestOrders;

	@FindBy(xpath = "//p[text() = 'Multi-Asset Class - Conservative']/parent::div/parent::div/following-sibling::div/child::div/child::p[text() = 'Cancel']")
	WebElement cancelPendingInvestmentMultiAssetClass;

	@FindBy(xpath = "//span[text() = 'YES']/parent::button")
	WebElement yesButton;

	@FindBy(xpath = "//p[text() = 'KYC']")
	WebElement KYCHeading;

	@FindBy(xpath = "//span[text() = 'Start KYC process']/parent::button")
	WebElement startKYCProcessButton;

	@FindBy(xpath = "//p[text() = 'START KYC']/parent::div")
	WebElement startKYCButton;

	@FindBy(xpath = "//img[@data-testid='nav-close-icon']")
	WebElement navCloseIcon;

	@FindBy(xpath = "(//div[@class = 'ant-card-body']/child::div)[5]")
	WebElement stockButton;

	@FindBy(xpath = "//button[text() = 'BUY']")
	WebElement buyButton_2;

	@FindBy(xpath = "//span[text() = 'COMPLETE KYC']/parent::button")
	WebElement completeKYCButton;

	@FindBy(xpath = "//span[text() = 'NOT NOW']/parent::button")
	WebElement notNowButton;

	@FindBy(xpath = "(//div[text() = 'Go Premium'])[1]")
	WebElement goPremiumButton;

	@FindBy(xpath = "//p[@data-testid='featureInfo-PREMIUM1SUBSECTION']")
	WebElement premiumPrice;

	@FindBy(xpath = "//p[text() = 'BASIC']")
	WebElement basicText;

	@FindBy(xpath = "//p[text() = 'Investing']")
	WebElement investingText;

	@FindBy(xpath = "//p[text() = 'Frequently Asked Questions']")
	WebElement faqText;

	@FindBy(xpath = "//div[text() = 'Get premium Plan']")
	WebElement selectPremiumButton;

	@FindBy(xpath = "(//div[@data-testid='goPremiumBtn'])[last()] | (//div[text() = 'Go Premium'])[3]")
	WebElement goPremiumProfileButton;

	@FindBy(xpath = "//div[text() = 'Not enough cash available.']")
	WebElement notEnoughCash;

	@FindBy(xpath = "//span[text() = 'View Plan Details']//parent::button")
	WebElement upgradeRequired;

	@FindBy(xpath = "//div[@class='ant-modal-body']//*[local-name()='svg']")
	WebElement upgradeRequiredClose;

	@FindBy(xpath = "(//span[contains(text(), 'Subscribe and save')]/parent::button)[1]")
	WebElement SubscribeAndSave;

	@FindBy(xpath = "(//span[contains(text(), 'Go Premium and save')]/parent::button)[1]")
	WebElement goPremiumAndSave;

	@FindBy(xpath = "//p[text() = 'Vest Purchase Fee']/following-sibling::p[@color = 'secondary']")
	WebElement vestFees;

	@FindBy(xpath = "(//p[text()='Pending Vest Orders']//ancestor::div[@class='ant-card']//p[text()='Cancel'])[1]")
	WebElement vestCancel;

	@FindBy(xpath = "//span[text()='YES']//parent::button")
	WebElement vestDeletePopupYes;

	@FindBy(xpath = "//p[text()='Pending Vest Orders']//ancestor::div[@class='ant-card']//p[text()='Show All']")
	WebElement vestPendingBoxShowAll;

	@FindBy(xpath = "(//p[text()='Pending Vest Orders']//ancestor::div[@class='ant-card']//p[text()='Cancel'])")
	List<WebElement> vestCancelCount;

	@FindBy(xpath = "//p[text()='no']//parent::div")
	WebElement kycPopupNoButton;

	@FindBy(xpath = "//p[text()='ACCEPT AND PROCEED']//parent::button")
	WebElement kycPopupAcceptButton;

	@FindBy(xpath = ("//p[text()='Pending Vest Orders']"))
	WebElement PendingVestOrderBox;

	@FindBy(xpath = ("//p[text()='Theme Based Vests']//ancestor::div[@class='ant-card']//p[text()='Show All']"))
	WebElement themeBasedVestShowAll;

	@FindBy(xpath = ("//p[text()='You have not invested into this vest.'] |  (//p[text()='Total Invested']//following-sibling::p[text()='$0'])[2]"))
	WebElement notInvestedText;

	@FindBy(xpath = ("//button[text()='Sell']"))
	WebElement vestSellButton;

	@FindBy(xpath = ("//p[contains(text(),'Theme Based')]//ancestor::div[@class='ant-card']//a"))
	List<WebElement> themeBasedList;

	@FindBy(xpath = ("//p[contains(@class,'e1ue8bwd24')]"))
	WebElement multiVestName;

	@FindBy(xpath = ("//p[contains(@class,'e1ue8bwd21')]"))
	WebElement themeBasedVestName;

	@FindBy(xpath = ("//button[text()='Buy']"))
	WebElement vestBuyButton;

	@FindBy(xpath = ("//p[text()='Explore']/ancestor::div[@class='ant-card']//p[@data-testid='SignalTitle']"))
	WebElement signalSection;

	@FindBy(xpath = ("//p[@data-testid='SignalTitle']//following-sibling::p[@data-testid='ShowAllCollection']"))
	WebElement signalSectionShowAll;

	@FindBy(xpath = ("//p[text()='Vest Purchase Fee']/parent::div//following-sibling::p"))
	WebElement vestPurchaseFee;

	@FindBy(xpath = ("//p[text()='Explore']/ancestor::div[@class='ant-card']//p[@data-testid='CollectionTitleOTC']"))
	WebElement otcSection;

	@FindBy(xpath = ("//p[@data-testid='CollectionTitleOTC']/parent::div//following-sibling::p"))
	WebElement otcShowAllButton;

	@FindBy(xpath = "//div[text()='Orders']")
	WebElement orderTab;

	@FindBy(xpath = "(//span[@class='ant-collapse-header-text'])[2] | (//div[@id='rc-tabs-2-panel-Orders']//div[@role='tab'])[2]")
	WebElement pendingVestOrder;

	@FindBy(xpath = "//span[text()=' Pending Vest Orders']//parent::div//parent::div//button[text()='Cancel Order']")
	List<WebElement> pendingVestOrderCancelList;

	@FindBy(xpath = ("//span[contains(text(),'YES')]//.."))
	WebElement CancelPendingOrderYes;

	@FindBy(xpath = ("//div[text()='No Pending Vest Orders']"))
	WebElement noPendingVest;

	public HomePage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public String getVestCategory() {
		return multiVestName.getText();
	}

	public String getThemeBasedVestName() {
		return themeBasedVestName.getText();
	}

	public ArrayList<String> verifySellButton_MultiAssetVest(WebDriver driver, int stepCount) {
		ArrayList<String> testSteps = new ArrayList<>();
		testSteps.add("Step " + (++stepCount) + " : Verifying Multi Class Vest Sell Button");

		for (int i = 1; i <= 3; i++) {
			WebElement elements = null;
			try {
				elements = driver.findElement(By.xpath(
						"(//p[contains(text(),'Multi-Asset')]//ancestor::div[@class='ant-card']//div[contains(@class,'ejmjp4a76')])["
								+ i + "]"));
				scrollIntoViewSmoothly(elements, driver);
				waitForElementClickable(elements, "20", driver);
			} catch (Exception e) {
				elements = driver.findElement(By.xpath(
						"(//p[contains(text(),'Multi-Asset')]//ancestor::div[@class='ant-card']//a)[" + i + "]"));
				scrollIntoViewSmoothly(elements, driver);
			}
			try {
				click(elements, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(elements, driver);
			}

			wait6s();
			String vestCategory = getVestCategory();
			try {

				testSteps.add("Step " + (++stepCount) + " : Clicking On <b>'" + vestCategory + "'</b> MultiAsset Vest");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'" + vestCategory
						+ "'</b> is Invested Or Not Invested");
				scrollIntoViewSmoothly(notInvestedText, driver);
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'" + vestCategory + "'</b> is Not Invested");

				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Buy Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestBuyButton, driver), "Vest Buy Button is Not Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Buy Button'</b> is displaying");

				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Sell Button'</b> is Not Displaying");
				assertFalse(isElementDisplayed(vestSellButton, driver), "<b>'Sell Button'</b> is Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Sell Button'</b> is Not displaying");
			} catch (Exception e) {
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'" + vestCategory + "'</b> is Invested");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Buy Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestBuyButton, driver), "Vest Buy Button is Not Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Buy Button'</b> is displaying");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Sell Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestSellButton, driver), "<b>'Sell Button'</b> is not displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Sell Button'</b> is displaying");
			}
			navigateToURL(DashboardUrl, driver);
			wait6s();

		}

		return testSteps;
	}

	public ArrayList<String> verifySellButton_ThemeBasedVest(WebDriver driver, int stepCount) {
		ArrayList<String> testSteps = new ArrayList<>();
		testSteps.add("Step " + (++stepCount) + " : Verifying 'Theme Based Vest' Sell Button");

		testSteps.add("Step " + (++stepCount) + " : Clicking On 'Theme Based Vest' Show All Button");
		click(themeBasedVestShowAll, driver);
		int listCount = themeBasedList.size();
		for (int i = 1; i <= listCount; i++) {

			WebElement elements = driver.findElement(
					By.xpath("(//p[contains(text(),'Theme Based')]//ancestor::div[@class='ant-card']//a)[" + i + "]"));
			click(elements, driver);
			wait5s();
			wait5s();

			wait3s();
			String vestCategory = getVestCategory();
			String vestName = getThemeBasedVestName();
			try {
				testSteps.add("Step " + (++stepCount) + " : Clicking On '<b>" + vestName + "</b> " + vestCategory
						+ "' Theme Based Vest");
				testSteps.add("Step " + (++stepCount) + " : Verifying '<b>" + vestName + "</b> " + vestCategory
						+ "' is Invested Or Not Invested");
				scrollIntoViewSmoothly(notInvestedText, driver);
				testSteps.add("Step " + (++stepCount) + " : Verified: '<b>" + vestName + "</b> " + vestCategory
						+ "' is Not Invested");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Buy Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestBuyButton, driver), "Vest Buy Button is Not Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Buy Button'</b> is displaying");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Sell Button'</b> is Not displaying");
				assertFalse(isElementDisplayed(vestSellButton, driver), "<b>'Sell Button'</b> is displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Sell Button'</b> is Not displaying");
			} catch (Exception e) {
				testSteps.add("Step " + (++stepCount) + " : Verified: '<b>" + vestName + "</b> " + vestCategory
						+ "' is Invested");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Buy Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestBuyButton, driver), "Vest Buy Button is Not Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Buy Button'</b> is displaying");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Sell Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestSellButton, driver), "<b>'Sell Button'</b> is not displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Sell Button'</b> is displaying");
			}
			navigateToURL(DashboardUrl, driver);
			wait3s();
			testSteps.add("Step " + (++stepCount) + " : Clicking On 'Theme Based Vest' Show All Button");
			click(themeBasedVestShowAll, driver);

		}

		return testSteps;
	}

	public void closeOnKycVerificationPopupButton(WebDriver driver) {
		try {
			wait5s();
			try {
				click(kycPopupNoButton, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(kycPopupNoButton, driver);
			}
			wait5s();
			try {
				click(kycPopupAcceptButton, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(kycPopupAcceptButton, driver);
			}

		} catch (Exception e) {
			printString("No Popup Found");
		}

	}

	public void clickOnAgressiveButton(WebDriver driver) {

		try {
			try {
				clickwithClickableOnly(agressiveButton, driver);
			} catch (Exception e) {
				driver.findElement(By.xpath("//p[text()='Multi-Asset Class - Aggressive']/parent::div/parent::a"))
						.click();
			}

		} catch (Exception e) {
			try {
				click(agressiveButton, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(agressiveButton, driver);
			}

		}

	}

	public int getCountOfPendingVestOrders(WebDriver driver) {
		int NumberOfOrders = driver.findElements(By.xpath(
				"//span[text()=' Pending Vest Orders']//parent::div//parent::div//div[contains(@class,'e8zw5vw0')]"))
				.size();
		System.out.print("\n\nNumber Of Pending Vest Orders: " + NumberOfOrders + "\n\n");
		return NumberOfOrders;

	}

	public void cancelAllPendingVest(WebDriver driver) {

		wait6s();
		try {

			click(orderTab, driver);
			try {
				clickUsingActionClass(pendingVestOrder, driver);
			}catch (Exception e) {
				clickUsingJavascriptExecutor(pendingVestOrder, driver);
			}
			waitForElementVisibility(noPendingVest, defaultTimeForVisibility, driver);
		} catch (Exception e) {
			e.printStackTrace();
			int beforeCount = 0;
			int cancelCount = 0;
			int count = 0;
			do {
				getRefreshWebPage(driver);
				wait6s();
				click(orderTab, driver);
				try {
					clickUsingActionClass(pendingVestOrder, driver);
				}catch (Exception e1) {
					clickUsingJavascriptExecutor(pendingVestOrder, driver);
				}
				beforeCount = getCountOfPendingVestOrders(driver);
				cancelCount = pendingVestOrderCancelList.size();
				waitUntilElementDisplayed(pendingVestOrderCancelList.get(0), driver);
				scrollIntoViewSmoothly(pendingVestOrderCancelList.get(0), driver);
				try {
					click(pendingVestOrderCancelList.get(0), driver);
				} catch (Exception e1) {
					clickUsingJavascriptExecutor(pendingVestOrderCancelList.get(0), driver);
				}
				waitForElementClickable(CancelPendingOrderYes, "60", driver);
				click(CancelPendingOrderYes, driver);
				wait6s();
				count++;
			} while (count < cancelCount);
		}

	}

	public void clickOnModerateButton(WebDriver driver) {
		try {
			clickwithClickableOnly(moderateButton, driver);
		} catch (Exception e) {
			try {
				click(moderateButton, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(moderateButton, driver);
			}

		}
	}

	public void clickOnConservativeButton(WebDriver driver) {
		try {
			clickwithClickableOnly(conservativeButton, driver);
		} catch (Exception e) {
			try {
				click(conservativeButton, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(conservativeButton, driver);
			}

		}
	}

	public void clickOnCreateRecurringInvestmentButton(WebDriver driver) {
		try {
			click(createRecurringInvestmentButton2, driver);
		} catch (Exception e) {
			click(createRecurringInvestmentButton, driver);
		}

	}

	public Double getTotalBuyingPower(WebDriver driver) {
		return Double.parseDouble(removeDollarandSpaces(getElementText(totalBuyingPower, driver), driver));
	}

	public String getInvestmentAmount(WebDriver driver) {
		return getInputText(investmentAmountInput, 30, driver);
	}

	public void clearInvestmentAmount(WebDriver driver) {
		clearUsingJavascriptExecutor(investmentAmountInput, driver);
	}

	public void enterInvestmentAmount(String amount, WebDriver driver) {
		clearInvestmentAmount(driver);
		sendKeysToWebElement(investmentAmountInput, amount, driver);
		click(frequencyDropdownButton, driver);
		clickInvestmentAmount(driver);
	}

	public void clickInvestmentAmount(WebDriver driver) {
		click(investmentAmountInput, driver);
	}

	public String getVestFeePerPurchase(WebDriver driver) {

		return getElementText(vestFeePerPurchase, driver);
	}

	public String getStartDate(WebDriver driver) {

		return getElementAttributeValue(startDate, "title", driver);
	}

	public String getSelectedFrequency(WebDriver driver) {
		return getElementAttributeValue(selectedFrequency, "title", driver);
	}

	public String selectFrequency(String frequencyToBeSelected, WebDriver driver) {
		click(frequencyDropdownButton, driver);
		String path = "//div[@title='" + frequencyToBeSelected + "']";
		click(driver.findElement(By.xpath(path)), driver);
		return getSelectedFrequency(driver);
	}

	public void clickOnFaqButton(WebDriver driver) {
		click(faqButton, driver);
	}

	public boolean isFAQModelTitleDisplaying(WebDriver driver) {
		return isElementDisplayed(FAQModelTitle, driver);
	}

	public void clickOnFaqModelCloseIcon(WebDriver driver) {
		try {
			click(upgradeRequiredClose, driver);
		} catch (Exception e) {
			click(faqModelCloseIcon, driver);

		}

	}

	public String getInvestmentAmountError(WebDriver driver) {
		return getElementText(investmentAmountError, driver);
	}

	public void clickOnPreviewRecurringInvestmentButton(WebDriver driver) {
		click(previewRecurringInvestmentButton, driver);
	}

	public void clickOnStartRecurringInvestmentButton(WebDriver driver) {
		click(startRecurringInvestmentButton, driver);
	}

	public String getDateThreeDaysAhead() throws ParseException {
		int count = 1;
		int counter = 4;
		int c = 1;
		while (count < 5) {
			String day = getDate(c, "E", "US/Eastern");
			c++;
			if (day.equalsIgnoreCase("Sat")) {
				counter++;
				continue;
			} else if (day.equalsIgnoreCase("Sun")) {
				counter++;
				continue;
			}
			count++;

		}
		return getDate(counter, "d MMM, yyyy", "US/Eastern");

	}

	public boolean isConfirmPagebreadCrumbDisplaying(WebDriver driver) {
		return isElementDisplayed(confirmPagebreadCrumb, driver);
	}

	public String getConfirmPageFrequency(WebDriver driver) {

		return getElementText(confirmPageFrequency, driver);
	}

	public String getConfirmPageStartDate(WebDriver driver) {

		return getElementText(confirmPageStartDate, driver);
	}

	public String getConfirmPageVestFee(WebDriver driver) {
		return getElementText(confirmPageVestFee, driver);
	}

	public String getConfirmPageInvestmentAmount(WebDriver driver) {
		return removeDollarandSpaces(getElementText(confirmPageInvestmentAmount, driver), driver);
	}

	public String getSuccessMessage(WebDriver driver) {
		return getElementText(successMessage, driver);
	}

	public boolean isRecurringInvestmentsDashboardButtonDisplaying(WebDriver driver) {
		return isElementDisplayed(recurringInvestmentsDashboardButton, driver);
	}

	public boolean isMultiVestBreadCrumbDisplaying(String breadCrumb, WebDriver driver) {
		return (isElementDisplayed(driver.findElement(By.xpath("//p[contains(text(),'" + breadCrumb + "')]")), driver));
	}

	public void clickOnStartNewRecurrignInvestmentButton(WebDriver driver) {
		click(startNewRecurrignInvestmentButton, driver);
	}

	public boolean isPremiumMemberDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(premiumMember, 20, driver);
			return isElementDisplayed(premiumMember, driver);
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnAllWeather_Button(WebDriver driver) {

		try {
			clickwithClickableOnly(allWeather_Button, driver);
		} catch (Exception e) {
			try {
				click(allWeather_Button, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(allWeather_Button, driver);
			}

		}
	}

	public String getCardNameallWeather_Button(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(themeBasedVestShowAll, driver);
			try {
				click(themeBasedVestShowAll, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(themeBasedVestShowAll, driver);
			}
		} catch (Exception e) {
			printString("Show All of theme base is not showing");
		}
		scrollIntoViewSmoothly(allWeather_ButtonName, driver);
		waitForElementVisibility(allWeather_ButtonName, 30, driver);
		return allWeather_ButtonName.getText().trim();
	}

	public void clickOnBlackRockSmartBetaBtn(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(themeBasedVestShowAll, driver);
			try {
				click(themeBasedVestShowAll, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(themeBasedVestShowAll, driver);
			}
		} catch (Exception e) {
			printString("Show All of theme base is not showing");
		}
		click(blackRockSmartBetaBtn, driver);
	}

	public String getCardNameBlackRockSmartBetaBtn(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(themeBasedVestShowAll, driver);
			try {
				click(themeBasedVestShowAll, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(themeBasedVestShowAll, driver);
			}
		} catch (Exception e) {
			printString("Show All of theme base is not showing");
		}
		scrollIntoViewSmoothly(blackRockSmartBetaBtnName, driver);
		waitForElementVisibility(blackRockSmartBetaBtnName, 30, driver);
		return blackRockSmartBetaBtnName.getText().trim();
	}

	public void clickOnSwensenPortfolioButton(WebDriver driver) {

		try {
			clickwithClickableOnly(SwensenPortfolioButton, driver);
		} catch (Exception e) {
			try {
				click(SwensenPortfolioButton, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(SwensenPortfolioButton, driver);
			}

		}

	}

	public String getCardNameSwensenPortfolioButton(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(themeBasedVestShowAll, driver);
			try {
				click(themeBasedVestShowAll, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(themeBasedVestShowAll, driver);
			}
		} catch (Exception e) {
			printString("Show All of theme base is not showing");
		}
		scrollIntoViewSmoothly(SwensenPortfolioButtonName, driver);
		waitForElementVisibility(SwensenPortfolioButtonName, 30, driver);
		return SwensenPortfolioButtonName.getText().trim();
	}

	public void clickOnCompareVestButton(WebDriver driver) {
		waitForElementVisibility(compareVestButton, 20, driver);
		click(compareVestButton, driver);
	}

	public boolean isMultiAssetClassSectionPresent(WebDriver driver) {
		waitForElementVisibility(multiAssetClassSection, 20, driver);
		return isElementDisplayed(multiAssetClassSection, driver);
	}

	public boolean isYourPositionSectionPresent(WebDriver driver) {
		waitForElementVisibility(yourPositionSection, 20, driver);
		return isElementDisplayed(yourPositionSection, driver);
	}

	public boolean isBuyButtonPresent(WebDriver driver) {
		waitForElementVisibility(buyButton, 20, driver);
		return isElementDisplayed(buyButton, driver);
	}

	public boolean isAllocationsSectionPresent(WebDriver driver) {
		waitForElementVisibility(allocationSection, 20, driver);
		return isElementDisplayed(allocationSection, driver);
	}

	public boolean isMultiAssetClassConservativeSectionPresent(WebDriver driver) {
		waitForElementVisibility(multiAssetClassConservativeSection, 20, driver);
		return isElementDisplayed(multiAssetClassConservativeSection, driver);
	}

	public boolean isReturnSectionPresent(WebDriver driver) {
		waitForElementVisibility(returnsSection, 20, driver);
		return isElementDisplayed(returnsSection, driver);
	}

	public boolean isVolatilitySectionPresent(WebDriver driver) {
		waitForElementVisibility(volatilitySection, 20, driver);
		return isElementDisplayed(volatilitySection, driver);
	}

	public boolean isCreateRecurringInvestmentButtonPresent(WebDriver driver) {
		waitForElementVisibility(createRecurringInvestmentButton, 20, driver);
		return isElementDisplayed(createRecurringInvestmentButton, driver);
	}

	public boolean isCompareVestConservativePresent(WebDriver driver) {
		waitForElementVisibility(compareVestConservative, 20, driver);
		return isElementDisplayed(compareVestConservative, driver);
	}

	public boolean isCompareVestModeratePresent(WebDriver driver) {
		waitForElementVisibility(compareVestModerate, 20, driver);
		return isElementDisplayed(compareVestModerate, driver);
	}

	public boolean isCompareVestAggressivePresent(WebDriver driver) {
		waitForElementVisibility(compareVestAggressive, 20, driver);
		return isElementDisplayed(compareVestAggressive, driver);
	}

	public void clickOnCloseCompareVest(WebDriver driver) {
		waitForElementVisibility(closeCompareVest, 20, driver);
		click(closeCompareVest, driver);
	}

	public void clickOnOverviewMax(WebDriver driver) {
		try {
			try {
				scrollIntoSpecificView(overviewMax2, driver);
				waitForElementVisibility(overviewMax2, 20, driver);
				click(overviewMax2, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(overviewMax2, driver);
			}
		} catch (Exception e) {
			try {
				scrollIntoSpecificView(overviewMax, driver);
				waitForElementVisibility(overviewMax, 20, driver);
				click(overviewMax, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(overviewMax, driver);
			}
		}

	}

	public void clickOnOverview5Y(WebDriver driver) {
		waitForElementVisibility(overview5Y, 20, driver);
		click(overview5Y, driver);
	}

	public void clickOnOverview1Y(WebDriver driver) {
		waitForElementVisibility(overview1Y, 20, driver);
		click(overview1Y, driver);
	}

	public void clickOnOverview6M(WebDriver driver) {
		waitForElementVisibility(overview6M, 20, driver);
		click(overview6M, driver);
	}

	public void clickOnOverview3M(WebDriver driver) {
		waitForElementVisibility(overview3M, 20, driver);
		click(overview3M, driver);
	}

	public void clickOnOverview1M(WebDriver driver) {
		waitForElementVisibility(overview1M, 20, driver);
		click(overview1M, driver);
	}

	public void clickOnOverview1W(WebDriver driver) {
		waitForElementVisibility(overview1W, 20, driver);
		click(overview1W, driver);
	}

	public void clickOnFullScreen(WebDriver driver) {
		waitForElementVisibility(fullScreen, 20, driver);
		click(fullScreen, driver);
	}

	public void clickOnOverview1D(WebDriver driver) {
		waitForElementVisibility(overview1D, 20, driver);
		click(overview1D, driver);
	}

	public boolean isOverviewGraphPresent(WebDriver driver) {
		waitForElementVisibility(overviewGraph, 20, driver);
		return isElementDisplayed(overviewGraph, driver);
	}

	public boolean isFullScreenGraphPresent(WebDriver driver) {
		waitForElementVisibility(fullScreenGraph, 20, driver);
		return isElementDisplayed(fullScreenGraph, driver);
	}

	public void clickOnIIcon(WebDriver driver) {
		try {
			waitForElementVisibility(iIcon, 20, driver);
			click(iIcon, driver);
		} catch (Exception e) {
			waitForElementClickable(iIcon, "20", driver);
			clickUsingJavascriptExecutor(iIcon, driver);
		}

	}

	public boolean isVestPerformanceChartPresent(WebDriver driver) {
		waitForElementVisibility(vestPerformanceChart, 20, driver);
		return isElementDisplayed(vestPerformanceChart, driver);
	}

	public void clickOnCloseVestPerformanceChart(WebDriver driver) {
		waitForElementVisibility(closeVestPerformanceChartButton, 20, driver);
		click(closeVestPerformanceChartButton, driver);
	}

	public void clickOnCloseVestPerformanceChart_2(WebDriver driver) {
		waitForElementVisibility(closeVestPerformanceChartButton_2, 20, driver);
		click(closeVestPerformanceChartButton_2, driver);
	}

	public void moveToGraph(WebDriver driver) {
		waitForElementVisibility(graph, 20, driver);
		mouseHover(graph, driver);
	}

	public boolean isFaangRebalanceSectionPresent(String Name, WebDriver driver) {
		waitForElementVisibility(driver.findElement(By.xpath("(//p[text() = '" + Name + "'])[1]")), 20, driver);
		return isElementDisplayed(driver.findElement(By.xpath("(//p[text() = '" + Name + "'])[1]")), driver);
	}

	public boolean isVestPerformanceSectionPresent(WebDriver driver) {
		waitForElementVisibility(vestPerformanceSection, 20, driver);
		return isElementDisplayed(vestPerformanceSection, driver);
	}

	public boolean isAllWeatherPortfolioSectionPresent(WebDriver driver) {
		waitForElementVisibility(allWeatherPortfolioSection, 20, driver);
		return isElementDisplayed(allWeatherPortfolioSection, driver);
	}

	public void clickOnShareFaangRebalanceButton(WebDriver driver) {
		waitForElementVisibility(shareFaangRebalanceButton, 20, driver);
		click(shareFaangRebalanceButton, driver);
	}

	public void clickOnBuyButton(WebDriver driver) {
		waitForElementVisibility(buyButton, 80, driver);
		try {
			click(buyButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(buyButton, driver);
		}

	}

	public boolean isNameInBuyPresent(WebDriver driver) {
		waitForElementVisibility(nameInBuy, 20, driver);
		return isElementDisplayed(nameInBuy, driver);
	}

	public boolean isPriceInBuyPresent(WebDriver driver) {
		waitForElementVisibility(priceInBuy, 20, driver);
		return isElementDisplayed(priceInBuy, driver);
	}

	public boolean isWeightInBuyPresent(WebDriver driver) {
		waitForElementVisibility(weightInBuy, 20, driver);
		return isElementDisplayed(weightInBuy, driver);
	}

	public boolean isNoOfSharesInBuyPresent(WebDriver driver) {
		waitForElementVisibility(noOfShareInBuy, 20, driver);
		return isElementDisplayed(noOfShareInBuy, driver);
	}

	public boolean isInvestmentAmountEnabled(WebDriver driver) {
		waitForElementVisibility(investmentAmountBuyPage, 20, driver);
		return investmentAmountBuyPage.isEnabled();
	}

	public void enterInvestmentAmountOnBuy(String key, WebDriver driver) {
		waitForElementVisibility(investmentAmountBuyPage, 20, driver);
		type(investmentAmountBuyPage, key, driver);
	}

	public boolean isPreviewOrderButtonClickable(WebDriver driver) {
		try {
			waitForElementClickable(previewOrderButton, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnPreviewOrderButton(WebDriver driver) {
		waitForElementClickable(previewOrderButton, "20", driver);
		click(previewOrderButton, driver);
	}

	public String getInvestmentAmountErrorMessage(WebDriver driver) {
		waitForElementVisibility(investmentAmountErrorMessageOnBuy, 20, driver);
		return investmentAmountErrorMessageOnBuy.getText();
	}

	public void clickOnPlaceBuyOrderOrderButton(WebDriver driver) {
		waitForElementClickable(placeBuyOrder, "20", driver);
		click(placeBuyOrder, driver);
	}

	public boolean isBuyTemporaryUnAvailable(WebDriver driver) {
		try {
			scrollIntoSpecificView(buyTemporaryUnAvailable, driver);
			waitForElementVisibility(buyTemporaryUnAvailable, 20, driver);
			return isElementDisplayed(buyTemporaryUnAvailable, driver);
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnHomeTabButton(WebDriver driver) {
		waitForElementClickable(homeTab, "20", driver);
		click(homeTab, driver);
	}

	public void clickOnShowAllPendingVestOrdersButton(WebDriver driver) {
		try {
			scrollIntoSpecificView(showAllPendingVestOrders, driver);
			waitForElementClickable(showAllPendingVestOrders, "20", driver);
			click(showAllPendingVestOrders, driver);
		} catch (Exception e) {
			System.out.print("No Show All Button");
		}

	}

	public void clickOnCancelAllPendingMultiAssetClassConservative(WebDriver driver) {
		waitForElementClickable(cancelPendingInvestmentMultiAssetClass, "20", driver);
		click(cancelPendingInvestmentMultiAssetClass, driver);
		waitForElementClickable(yesButton, "20", driver);
		click(yesButton, driver);
//		List<WebElement> elementList = driver.findElements(By.xpath("//p[text() = 'Multi-Asset Class - Conservative']/parent::div/parent::div/following-sibling::div/child::div/child::p[text() = 'Cancel']"));
//		for(int i = 0; i < elementList.size(); i++){
//			elementList.get(i).click();
//			waitForElementClickable(yesButton, "20");
//			click(yesButton);
//		}
	}

	public void clickOnCancelAllPendingThemeBasedFaangRebalance(WebDriver driver) {
		waitForElementClickable(cancelPendingInvestmentMultiAssetClass, "20", driver);
		click(cancelPendingInvestmentMultiAssetClass, driver);
		waitForElementClickable(yesButton, "20", driver);
		click(yesButton, driver);
	}

	public boolean isKYCHeadingPresent(WebDriver driver) {
		waitForElementVisibility(KYCHeading, 10, driver);
		return isElementDisplayed(KYCHeading, driver);
	}

	public boolean isStartKYCProcessButtonPresent(WebDriver driver) {
		waitForElementVisibility(startKYCProcessButton, 10, driver);
		return isElementDisplayed(startKYCProcessButton, driver);
	}

	public void clickOnStartKYCButton(WebDriver driver) {
		waitForElementClickable(startKYCButton, "10", driver);
		click(startKYCButton, driver);
	}

	public void clickNavCloseIcon(WebDriver driver) {
		waitForElementClickable(navCloseIcon, "10", driver);
		click(navCloseIcon, driver);
	}

	public void clickOnStock(WebDriver driver) {
		waitForElementClickable(stockButton, "10", driver);
		click(stockButton, driver);
	}

	public void clickOnBuyButton_2(WebDriver driver) {
		waitForElementClickable(buyButton_2, "10", driver);
		click(buyButton_2, driver);
	}

	public boolean isCompleteKYCButtonPresent(WebDriver driver) {
		waitForElementVisibility(completeKYCButton, 10, driver);
		return isElementDisplayed(completeKYCButton, driver);
	}

	public void clickOnNotNowButton(WebDriver driver) {
		waitForElementClickable(notNowButton, "10", driver);
		click(notNowButton, driver);
	}

	public void clickOnGoPremiumButton(WebDriver driver) {
		waitForElementClickable(goPremiumButton, "10", driver);
		click(goPremiumButton, driver);
	}

	public boolean isPremiumPricePresent(WebDriver driver) {
		waitForElementVisibility(premiumPrice, 10, driver);
		return isElementDisplayed(premiumPrice, driver);
	}

	public boolean isSelectPremiumButtonPresent(WebDriver driver) {
		waitForElementVisibility(selectPremiumButton, 10, driver);
		return isElementDisplayed(selectPremiumButton, driver);
	}

	public boolean isBasicHeadingPresent(WebDriver driver) {
		waitForElementVisibility(basicText, 10, driver);
		return isElementDisplayed(basicText, driver);
	}

	public boolean isInvestingHeadingPresent(WebDriver driver) {
		waitForElementVisibility(investingText, 10, driver);
		return isElementDisplayed(investingText, driver);
	}

	public boolean isFAQHeadingPresent(WebDriver driver) {
		waitForElementVisibility(faqText, 10, driver);
		return isElementDisplayed(faqText, driver);
	}

	public boolean isGoPremiumProfilePresent(WebDriver driver) {
		waitForElementVisibility(goPremiumProfileButton, "10", driver);
		return isElementDisplayed(goPremiumProfileButton, driver);
	}

	public boolean isNotEnoughCastPresent(WebDriver driver) {
		waitForElementVisibility(notEnoughCash, "10", driver);
		return isElementDisplayed(notEnoughCash, driver);
	}

	public boolean isUpgradeRequiredPresent(WebDriver driver) {
		waitForElementVisibility(upgradeRequired, "10", driver);
		return isElementDisplayed(upgradeRequired, driver);
	}

	public boolean isVestPurchaseFeesPresent(WebDriver driver) {
		// waitForElementVisibility(element, 10, driver);
		return isElementDisplayed(vestFees, driver);
	}

	public boolean isVestPurchaseFees3Present(WebDriver driver) {
		WebElement element = driver.findElement(
				By.xpath("//p[text() = 'Vest Purchase Fee']//parent::div//following-sibling::p[@color = 'secondary']"));
		waitForElementVisibility(element, 10, driver);
		return isElementDisplayed(element, driver);
	}

	public void clickOnSubscribeAndSaveButton(WebDriver driver) {
		try {
			waitForElementClickable(goPremiumAndSave, "10", driver);
			click(goPremiumAndSave, driver);
		} catch (Exception e) {
			waitForElementClickable(SubscribeAndSave, "10", driver);
			click(SubscribeAndSave, driver);
		}

	}

	public Boolean SignalSectionDisplaying(WebDriver driver) {
		try {
			wait3s();
			scrollIntoViewSmoothly(signalSection, driver);
			waitForElementVisibility(signalSection, defaultTimeForVisibility, driver);
			return isElementDisplayed(signalSection, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean SignalSectionShowAllDisplaying(WebDriver driver) {
		try {
			wait3s();
			scrollIntoViewSmoothly(signalSectionShowAll, driver);
			waitForElementVisibility(signalSectionShowAll, defaultTimeForVisibility, driver);
			return isElementDisplayed(signalSectionShowAll, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSignalSectionShowAll(WebDriver driver) {
		try {
			click(signalSectionShowAll, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(signalSectionShowAll, driver);
		}
	}

	public Boolean SignalSectionShowAllClickable(WebDriver driver) {
		try {
			wait3s();
			scrollIntoViewSmoothly(signalSectionShowAll, driver);
			waitForElementToBeClickable(signalSectionShowAll, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean SignalSectionOptionDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(
					By.xpath("//p[@data-testid='SignalTitle']/ancestor::div[@class='ant-space-item']//p[text()='"
							+ option + "']"));
			wait3s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean SignalSectionOptionClickable(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(
					By.xpath("//p[@data-testid='SignalTitle']/ancestor::div[@class='ant-space-item']//p[text()='"
							+ option + "']"));
			wait3s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementToBeClickable(ele, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSignalSectionOption(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(
					By.xpath("//p[@data-testid='SignalTitle']/ancestor::div[@class='ant-space-item']//p[text()='"
							+ option + "']"));
			wait3s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			click(ele, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ele, driver);

		}
	}

	public Boolean isStockNameDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("(//tbody//a[text()='" + option + "'])[1]"));
			wait3s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isStockSymbolDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("(//tbody//a[text()='" + option + "'])[1]"));
			wait3s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isTextDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("(//p[text()='" + option + "'])[1]"));
			wait1s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isSignalTypeOnLeftSideDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='Signals']//parent::div//p[text()='" + option + "']"));
			wait1s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isColumnLabelDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("(//thead//th[text()='" + option + "'])[1]"));
			wait1s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isButtonClickable(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='" + text + "']"));
			waitForElementClickable(ele, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isButtonDisplaying(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//span[text()='" + text + "']/parent::button"));
			waitForElementClickable(ele, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean isTextContainsDisplaying(WebDriver driver, String option) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("(//p[contains(text(),'" + option + "')])[1]"));
			wait1s();
			scrollIntoViewSmoothly(ele, driver);
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return isElementDisplayed(ele, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<String> verifySellButton_Vest(WebDriver driver, int stepCount) {
		ArrayList<String> testSteps = new ArrayList<>();
		testSteps.add("Step " + (++stepCount) + " : Verifying Vests Sell Button");

		List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@class,'SECTION_VESTS')]//a"));
		int vestCount = ele.size();

		for (int i = 1; i <= vestCount; i++) {
			WebElement elements = null;
			elements = driver.findElement(By.xpath("(//div[contains(@class,'SECTION_VESTS')]//a)[" + i + "]"));
			try {
				click(elements, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(elements, driver);
			}
			wait6s();
			String vestCategory = getVestCategory();
			String vestName = getThemeBasedVestName();
			try {

				testSteps.add("Step " + (++stepCount) + " : Clicking On '<b>" + vestName + "</b>' '" + vestCategory
						+ "'  Vest");
				testSteps.add("Step " + (++stepCount) + " : Verifying '<b>" + vestName + "</b>'  '" + vestCategory
						+ "' is Invested Or Not Invested");
				scrollIntoViewSmoothly(notInvestedText, driver);
				testSteps.add("Step " + (++stepCount) + " : Verified: '<b>" + vestName + "</b>' '" + vestCategory
						+ "' is Not Invested");

				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Buy Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestBuyButton, driver), "Vest Buy Button is Not Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Buy Button'</b> is displaying");

				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Sell Button'</b> is Not Displaying");
				assertFalse(isElementDisplayed(vestSellButton, driver), "<b>'Sell Button'</b> is Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Sell Button'</b> is Not displaying");
			} catch (Exception e) {
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'" + vestCategory + "'</b> is Invested");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Buy Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestBuyButton, driver), "Vest Buy Button is Not Displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Buy Button'</b> is displaying");
				testSteps.add("Step " + (++stepCount) + " : Verifying <b>'Sell Button'</b> is displaying");
				assertTrue(isElementDisplayed(vestSellButton, driver), "<b>'Sell Button'</b> is not displaying");
				testSteps.add("Step " + (++stepCount) + " : Verified: <b>'Sell Button'</b> is displaying");
			}
			navigateToURL(DashboardUrl, driver);
			wait6s();

		}

		return testSteps;
	}

	public double getVestPurchaseFee(WebDriver driver) {
		waitForElementVisibility(vestPurchaseFee, "10", driver);
		return Double.parseDouble(getElementText(vestPurchaseFee, driver).replace("$", "").replace(",", ""));
	}

	public Boolean OTCSectionDisplaying(WebDriver driver) {
		try {
			wait3s();
			scrollIntoViewSmoothly(otcSection, driver);
			waitForElementVisibility(otcSection, defaultTimeForVisibility, driver);
			return isElementDisplayed(otcSection, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean OTCShowAllButtonisDisplaying(WebDriver driver) {
		try {
			wait3s();
			scrollIntoViewSmoothly(otcShowAllButton, driver);
			waitForElementVisibility(otcShowAllButton, defaultTimeForVisibility, driver);
			return isElementDisplayed(otcShowAllButton, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean OTCShowAllButtonisClickable(WebDriver driver) {
		try {
			wait3s();
			scrollIntoViewSmoothly(otcShowAllButton, driver);
			waitForElementClickable(otcShowAllButton, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean OTCisDisplaying(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='" + text + "']"));
			scrollIntoViewSmoothly(otcShowAllButton, driver);
			waitForElementVisibility(otcShowAllButton, defaultTimeForVisibility, driver);
			return isElementDisplayed(otcShowAllButton, driver);
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean OTCisClickable(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='" + text + "']"));
			scrollIntoViewSmoothly(ele, driver);
			waitForElementClickable(ele, "20", driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
