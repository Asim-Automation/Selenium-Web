package com.investor.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.investor.base.BaseClass;
import com.investor.errorCollectors.ErrorCollector;

public class DIYVestPage extends BaseClass {

	private WebDriver podriver = null;
	@FindBy(xpath = "//span[text()='Your Vests']//parent::span//button")
	WebElement sortingButton;

	@FindBy(xpath = "//span[text()='Create new vest']//parent::button")
	WebElement createNewVest;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_alphabetical']")
	WebElement sortingOption_Alphabets;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_inceptionDate']")
	WebElement sortingOption_InceptionDate;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_1w']")
	WebElement sortingOption_OneWeek;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_1m']")
	WebElement sortingOption_OneMonth;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_3m']")
	WebElement sortingOption_ThreeMonth;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_1y']")
	WebElement sortingOption_OneYear;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_5y']")
	WebElement sortingOption_FiveYear;

	@FindBy(xpath = "//span[@data-testid='sortDIYVests_item_max']")
	WebElement sortingOption_AllTime;

	@FindBy(xpath = "//div[@class='ant-card-head']")
	WebElement diyVestCard;

	@FindBy(xpath = "//input[@id='react-select-searchTickerDIYVest-input']")
	WebElement diyVestSearchBar;

	@FindBy(xpath = "//span[contains(text(),'added')]//parent::button")
	WebElement addedStocksButton;

	@FindBy(xpath = "//span[contains(text(),'Create Vest')]//parent::button")
	WebElement createVestButton;

	@FindBy(xpath = "//label[text()='Vest Name']//parent::div//input")
	WebElement createVestName;

	@FindBy(xpath = "//button[@title='Next']")
	WebElement nextPopupButton;

	@FindBy(xpath = "//span[text()='Ok, Got it']//parent::button")
	WebElement oKGotItButton;

	@FindBy(xpath = "(//p[text()='Show All'])[1]")
	WebElement showAllStocks;

	@FindBy(xpath = "//p[text()='Weights are rounded to the nearest whole number. As a result, equal weighting may not be achieved.']")
	WebElement notePopupText;

	@FindBy(xpath = "//span[@class='ant-modal-confirm-title']")
	WebElement notePopupHeading;
	@FindBy(xpath = "//span[contains(text(),'Note')]")
	WebElement notePopupHeading2;

	@FindBy(xpath = "//p[text()='Weights are rounded to the nearest whole number. As a result, equal weighting may not be achieved.']")
	WebElement notePopupDescription;

	@FindBy(xpath = "//span[contains(text(),'Do not show')]")
	WebElement notePopupDontShow;

	@FindBy(xpath = "(//span[text()='OK']//parent::button)[1]")
	WebElement notePopupOkButton;

	@FindBy(xpath = "//span[text()='Successfully created DIY Vest.']")
	WebElement vestCreateSuccessfullyPopup;

	@FindBy(xpath = "//button[text()='Buy']")
	WebElement buyStocksButton;

	@FindBy(xpath = "//button[text()='Sell']")
	WebElement sellStocksButton;

	@FindBy(xpath = "//input[@name='sellAll']//parent::span")
	WebElement sellAllCheckbox;

	@FindBy(xpath = "//input[@name='sellAll']//parent::span")
	WebElement sellAllStocksCheckbox;

	@FindBy(xpath = "//span[@type='not-invested']//ancestor::div[contains(@class,'ant-card')]//button")
	List<WebElement> notVestedThreeDotsButton;

	@FindBy(xpath = "//input[@data-testid='purchase-amount']")
	WebElement investAmountInput;

	@FindBy(xpath = "(//button[@data-testid='purchase-preview'])[1]")
	WebElement purchasePreviewButton;

	@FindBy(xpath = "(//button[@data-testid='sell-preview'])[1]")
	WebElement sellPreviewButton;

	@FindBy(xpath = "(//button[@data-testid='placeOrder'])[1]")
	WebElement buyPlaceOrderButton;

	@FindBy(xpath = "(//span[text()='Place Sell Order']//parent::button)[1] |(//button[@data-testid='placeOrder'])[1]")
	WebElement sellPlaceOrderButton;

	// QAA-87

	@FindBy(xpath = "//span[text()='Share your Vest']")
	WebElement shareYourVestTitle;

	@FindBy(xpath = "//span[text()='Preview Page']/parent::div/parent::button")
	WebElement previewPageBtn;

	@FindBy(xpath = "//span[text()='Share link']//following-sibling::div//div")
	WebElement shareLink;

	@FindBy(xpath = "//p[text()='Whatsapp']//parent::div")
	WebElement whatsappBtn;

	@FindBy(xpath = "//p[text()='Facebook']//parent::div")
	WebElement facebookBtn;

	@FindBy(xpath = "//p[text()='LinkedIn']//parent::div")
	WebElement linkedInBtn;

	@FindBy(xpath = "//p[text()='Twitter']//parent::div")
	WebElement twitterBtn;

	@FindBy(xpath = "//p[text()='Gmail']//parent::div")
	WebElement gmailBtn;

	@FindBy(xpath = "//p[text()='Vest Performance']")
	WebElement vestPerformanceTitle;

	@FindBy(xpath = "//h5[text()='WHATSAPP WEB']")
	WebElement whatappPageTitle;

	@FindBy(xpath = "//h2[text()='Facebook']")
	WebElement facebookPageTitle;

	@FindBy(xpath = "//h1[text()='Make the most of your professional life']")
	WebElement linkedInPageTitle;

	@FindBy(xpath = "//span[text()='Want to log in first?']")
	WebElement twitterPageTitle;

	@FindBy(xpath = "//a[text()='Sign in'] | //span[text()='Sign in']")
	WebElement gmailPageTitle;

	@FindBy(xpath = "//div[contains(@class,'css-id5zxd')]")
	WebElement clipBoardCopy;

	@FindBy(xpath = "//button[@class='ant-modal-close']")
	WebElement shareYourVestCloseBtn;

	@FindBy(xpath = "(//button[@class='ant-modal-close'])[2]")
	WebElement renameCloseBtn;

	@FindBy(xpath = "(//span[text()='Rename'])[2]")
	WebElement renameTitle;

	@FindBy(xpath = "//input[@class='ant-input']")
	WebElement renameTxt;

	@FindBy(xpath = "//span[text()='Rename Vest']")
	WebElement renameVestBtn;

	@FindBy(xpath = "//span[text()= 'Yes, Delete']/parent::button")
	WebElement deleteButton;

	@FindBy(xpath = "//span[@data-testid='manageDIYVest_item_DELETE']")
	WebElement diyVestdeleteButton;

	@FindBy(xpath = "//p[contains(text(),'Sorry')and contains(text(),'already created a vest with the name')]")
	WebElement vestNameAlreadyCreatdPopup;

	@FindBy(xpath = "//span[text()='OK']")
	WebElement vestNameAlreadyCreatdPopupOkbtn;

	@FindBy(xpath = "(//*[local-name()='svg' and @class='isPlus'])[1]")
	WebElement stockPlusBtn;

	@FindBy(xpath = "//button[contains(@class,'ant-btn ant-btn-link')]")
	WebElement stockBackBtn;

	@FindBy(xpath = "//span[@class='ant-modal-confirm-title']")
	WebElement duplicatePopTitle;

	@FindBy(xpath = "//div[@class='ant-modal-confirm-content']")
	WebElement duplicatePopContent;

	@FindBy(xpath = "//div[@class='ant-card-head']")
	List<WebElement> VestCardCount;

	@FindBy(xpath = "(//p[text()='Current Investment'])[1]/following-sibling::p")
	WebElement currentInvestmentAmount;

	@FindBy(xpath = "//span[text()='Click here to change how your Vests are sorted.']//following-sibling::span")
	WebElement howYourVestedAreSortedPopup;

	@FindBy(xpath = "//span[text() = 'Click here to change how your Vests are sorted.']/following-sibling::span/*[local-name()='svg' and @stroke='currentColor']")
	WebElement changeHowYourVestAreSortedPopUpXIcon;

	@FindBy(xpath = "//button[contains(@class,'diy-vest-breakdown-filter-tour')]")
	WebElement breakdownAllocationButton;

	@FindBy(xpath = "//span[@data-testid='DIYVestDetailBreakdown_item_1w']")
	WebElement breakdownAllocation1w;

	@FindBy(xpath = "//span[@data-testid='DIYVestDetailBreakdown_item_1m']")
	WebElement breakdownAllocation1m;

	@FindBy(xpath = "//span[@data-testid='DIYVestDetailBreakdown_item_3m']")
	WebElement breakdownAllocation3m;

	@FindBy(xpath = "//span[@data-testid='DIYVestDetailBreakdown_item_1y']")
	WebElement breakdownAllocation1y;

	@FindBy(xpath = "//span[@data-testid='DIYVestDetailBreakdown_item_5y']")
	WebElement breakdownAllocation5y;

	@FindBy(xpath = "//div[contains(@class,'e1ue8bwd39')]//p[2]")
	List<WebElement> breakdownAllocationValue;

	@FindBy(xpath = "//div[contains(@class,'e1ue8bwd39')]//p[1]")
	List<WebElement> breakdownAllocationName;

	@FindBy(xpath = "//span[text()='Edit allocations']//parent::button")
	WebElement editAllocations;

	@FindBy(xpath = "//span[contains(text(),'Update Allocation')]//parent::button")
	WebElement updateAllocations;

	@FindBy(xpath = "//p[contains(text(),'You have successfully rebalanced')]")
	WebElement rebalanceSuccess;

	@FindBy(xpath = "//span[text()='Back to your DIY vests']//parent::button")
	WebElement backToVest;

	@FindBy(xpath = "//span[text()='Share your Vest']")
	WebElement shareVestPopup;

	@FindBy(xpath = "//span[@aria-label='close']")
	WebElement closeIcon;

	@FindBy(xpath = "(//span[@aria-label='close'])[2]")
	WebElement closeIcon2;

	@FindBy(xpath = "//span[text()='Please execute your pending rebalance order.']")
	WebElement previousPendingRebalancePopup;

	@FindBy(xpath = "(//span[text()='Preview Order']//parent::button)[1] | (//span[text()='Preview order']//parent::button)[1]")
	WebElement previewOrderButton;

	@FindBy(xpath = "//span[text()='PLACE ORDER']//parent::button")
	WebElement placeOrderButton;

	@FindBy(xpath = "//p[text()='Not enough settled cash']")
	WebElement notEnoughCashPopup;

	@FindBy(xpath = "//button[@data-testid='vestReBalanceSuccessBackToVest']")
	WebElement rebalanceSuccessOkGotIt;

	@FindBy(xpath = "//span[text()='REBALANCE QUEUED']//parent::button | //span[text()='Rebalance Queued']//parent::button")
	WebElement rebalanceQueuedButton;

	@FindBy(xpath = "//span[text()='Yes, Proceed']//parent::button")
	WebElement yesProcessedButton;

	@FindBy(xpath = "//input[@data-testid='sell-amount']")
	WebElement sellAmountInput;

	@FindBy(xpath = "//p[contains(text(),'placed successfully.')] |//p[text()='Your order was placed successfully.']")
	WebElement successScreenMessage;

	@FindBy(xpath = "//p[contains(text(),'Please enter a name for the Vest')]")
	WebElement requiredVestNamePopup;

	@FindBy(xpath = "//span[text()='OK']/parent::button")
	WebElement requiredVestNamePopupOkButton;

	@FindBy(xpath = "//div[contains(text(),'you need at least $50.00')]")
	WebElement minimumAmountRequired;

	@FindBy(xpath = "//p[text()='Please enter a value greater than or equal to $50.'] | //p[text()='Please enter a value greater than or equal to $50.00.']")
	WebElement minimumAmountErrorMessage;
	
	@FindBy(xpath = "//p[text()='Please enter a value greater than or equal to $10.'] | //p[text()='Please enter a value greater than or equal to $10.00.']")
	WebElement minimum10AmountErrorMessage;

	@FindBy(xpath = "//p[text()='Investment']/following-sibling::p")
	WebElement previewPageInvestedAmount;

	@FindBy(xpath = "//span[contains(text(), 'Add Stocks or ETFs to proceed')]//parent::button")
	WebElement addStocksEftsButton;
	
	@FindBy(xpath = "//div[@class='ant-empty ant-empty-normal']") WebElement stockNotAvailable;
	
	@FindBy(xpath = "//p[text()='Pending Orders']/parent::div/parent::div/parent::div") WebElement pendingOrdersSection;
	
	@FindBy(xpath = "//p[text()='Pending Orders']/span") WebElement iIcon;
	
	@FindBy(xpath = "//div[text()='Pending Orders']/parent::div/parent::div| //div[text()='Pending Vest Orders' and @class='ant-modal-title']") WebElement pendingOrdersPopup;
	
	@FindBy(xpath = "//div[@type='pendingOrder']/div/p[text()='Cancel']") List<WebElement> listOfCancelButton;
	
	@FindBy(xpath = "(//p[text()='Cancel'])[1]") WebElement cancelButton;
	
	@FindBy(xpath = "//p[contains(text(), \"Are you sure you want to cancel your pending order for\")]/ancestor::div[@class='ant-modal-content']") WebElement warningPopup;
	
	@FindBy(xpath = "//button[@aria-label = 'Close']") WebElement crossIcon;
	
	@FindBy(xpath = "//span[text()='NO']/parent::button") WebElement noButtonOnWarningPopup;
	
	@FindBy (xpath = "//span[text()='YES']/parent::button") WebElement yesButtonOnWarningPopup;
	
	@FindBy(xpath = "(//div[@class=\"ant-card-body\"])[4]/div") List<WebElement> pendingOrdersList;
	
	@FindBy(xpath = "//p[text()='OTC']/parent::div/parent::div/parent::div") WebElement OTCheading;
	
	@FindBy(xpath = "//p[text()='OTC']/parent::div/following-sibling::p") WebElement showAll;
	
	@FindBy(xpath = "//table/tbody/tr/td/div/a") List<WebElement> listOfOTCStocks;

	@FindBy(xpath = "//span[text()=' Pending Vest Orders']//span[@aria-label='info-circle']") WebElement pendingVestInfoIcon;
	
	public DIYVestPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public void clickOncreateNewVestButton(WebDriver driver) {
		try {
			try {
				click(howYourVestedAreSortedPopup, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(howYourVestedAreSortedPopup, driver);
			}
		} catch (Exception e) {
			printString("No pop found", driver);
		}
		try {
			click(createNewVest, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(createNewVest, driver);
		}
	}

	public void clickOnEditAllocationButton(WebDriver driver) {
		try {
			click(editAllocations, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(editAllocations, driver);
		}

	}

	public void clickOnPlusAllocationButton(WebDriver driver, String Stock, int increment) {
		WebElement element = driver.findElement(By.xpath("(//*[@class='isPlus'])[" + Stock + "]"));
		for (int i = 1; i <= increment; i++) {
			try {
				click(element, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(element, driver);
			}
		}

	}

	public void clickOnUpdateAllocationButton(WebDriver driver) {
		try {
			click(updateAllocations, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(updateAllocations, driver);
		}

	}

	public boolean isRebalanceSuccessMessageDisplay(WebDriver driver) {
		waitForElementVisibility(rebalanceSuccess, 30, driver);
		return isElementDisplayed(rebalanceSuccess, driver);

	}

	public void clickOnBackToDIYVestButton(WebDriver driver) {
		try {
			click(backToVest, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(backToVest, driver);
		}

	}

	public void clickOnAllocationButton(WebDriver driver) {
		try {
			click(breakdownAllocationButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(breakdownAllocationButton, driver);
		}

	}

	public void clickOnAllocationOption(String Option, WebDriver driver) {
		if (Option.toLowerCase().equalsIgnoreCase("1w")) {
			try {
				click(breakdownAllocation1w, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(breakdownAllocation1w, driver);
			}
		} else if (Option.toLowerCase().equalsIgnoreCase("1m")) {
			try {
				click(breakdownAllocation1m, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(breakdownAllocation1m, driver);
			}
		} else if (Option.toLowerCase().equalsIgnoreCase("3m")) {
			try {
				click(breakdownAllocation3m, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(breakdownAllocation3m, driver);
			}
		} else if (Option.toLowerCase().equalsIgnoreCase("1y")) {
			try {
				click(breakdownAllocation1y, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(breakdownAllocation1y, driver);
			}
		} else if (Option.toLowerCase().equalsIgnoreCase("5y")) {
			try {
				click(breakdownAllocation5y, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(breakdownAllocation5y, driver);
			}
		}

	}

	public ArrayList<Double> getBreakdownVestValue() {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < breakdownAllocationValue.size(); i++) {
			list.add(Double.parseDouble(
					breakdownAllocationValue.get(i).getText().replace("%", "").replace(",", "").replace("-", "0")));
		}
		return list;
	}

	public ArrayList<String> getBreakdownVestName() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < breakdownAllocationName.size(); i++) {
			list.add(breakdownAllocationName.get(i).getText());
		}
		return list;
	}

	public void clickOnCreateNewVestButton(WebDriver driver) {
		try {
			try {
				click(howYourVestedAreSortedPopup, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(howYourVestedAreSortedPopup, driver);
			}
		} catch (Exception e) {
//			printString("No pop found", driver);
		}
		try {
			click(createNewVest, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(createNewVest, driver);
		}

	}

	public void deleteDIYVest(WebDriver driver, String vest) {
		WebElement ele = driver.findElement(By.xpath("//div[text()='" + vest + "']"));
		scrollIntoViewSmoothly(ele, driver);
		click(driver.findElement(
				By.xpath("//div[text()='" + vest + "']//ancestor::div[@class='ant-card-head']//button")), driver);
		click(diyVestdeleteButton, driver);
		click(deleteButton, driver);

	}

	public ArrayList<String> deleteNotVestedThreeDotButton(WebDriver driver) {
		ArrayList<String> list = new ArrayList<String>();
//		printString("Count : " + notVestedThreeDotsButton.size());
		if (notVestedThreeDotsButton.size() > 0) {
			for (int i = 1; i <= notVestedThreeDotsButton.size(); i++) {
				list.add("- Deleting <b>" + i + " </b>Not Invested Vest");
				try {
					click(driver.findElement(By
							.xpath("(//span[@type='not-invested']//ancestor::div[contains(@class,'ant-card')]//button)["
									+ i + "]")),
							driver);
					list.add("- Clicking On Three dot icon");

				} catch (Exception e) {
					clickUsingJavascriptExecutor(driver.findElement(By
							.xpath("(//span[@type='not-invested']//ancestor::div[contains(@class,'ant-card')]//button)["
									+ i + "]")),
							driver);
					list.add("- Clicking On Three dot icon");

				}

				try {
					try {

						click(driver.findElement(
								By.xpath("(//span[@data-testid='manageDIYVest_item_DELETE'])[" + i + "]")), driver);
						list.add("- Clicking On 'DELETE' option");
					} catch (Exception e1) {
						clickUsingJavascriptExecutor(
								driver.findElement(
										By.xpath("(//span[@data-testid='manageDIYVest_item_DELETE'])[" + i + "]")),
								driver);
						list.add("- Clicking On 'DELETE' option");

					}

				} catch (Exception e) {
					clickOnDIYVestDeleteButton(driver);
					list.add("- Clicking On 'DELETE' option");

				}
				try {

					clickOnDeleteButton(driver);
					list.add("- Clicking On 'Yes, DELETE' Confirmation Popup Button");
				} catch (Exception e) {
					printString("no Delete Button");
				}

			}
		} else {
			printString("No Not inVested Vest Found");
		}

		return list;
	}

	public void clickOnbuyStocksButton(WebDriver driver) {
		try {
			click(buyStocksButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(buyStocksButton, driver);
		}

	}

	public void clickOnSellStocksButton(WebDriver driver) {
		try {
			click(sellStocksButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sellStocksButton, driver);
		}

	}

	public void clickSellAllBox(WebDriver driver) {
		try {
			click(sellAllCheckbox, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sellAllCheckbox, driver);
		}

	}

	public void checkSellAllButton(WebDriver driver) {
		try {
			click(sellAllStocksCheckbox, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sellAllStocksCheckbox, driver);
		}

	}

	public void EnterInvestAmount(String amount, WebDriver driver)  {
		waitForElementVisibility(investAmountInput, "60", driver);
		type(investAmountInput, amount, driver);
	}

	public void clickOnpurchasePreviewButton(WebDriver driver) {
		try {
			click(purchasePreviewButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(purchasePreviewButton, driver);
		}
	}

	public void clickOnSellPreviewButton(WebDriver driver) {
		try {
			click(sellPreviewButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sellPreviewButton, driver);
		}
	}

	public void clickOnbuyPlaceOrderButton(WebDriver driver) {
		try {
			click(buyPlaceOrderButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(buyPlaceOrderButton, driver);
		}
	}

	public void clickOnPlaceSellOrderButton(WebDriver driver) {
		try {
			click(sellPlaceOrderButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sellPlaceOrderButton, driver);
		}
	}

	public Boolean isNotePopupVisible(WebDriver driver) {
		waitForElementVisibility(notePopupText, "30", driver);
		if (isElementDisplayed(notePopupText, driver)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isNotePopupHeadingVisible(WebDriver driver) {
		wait5s();
		try {
			return isElementDisplayed(notePopupHeading, driver);
		} catch (Exception e) {
			return isElementDisplayed(notePopupHeading2, driver);
		}

	}

	public Boolean isNotePopupDescriptionVisible(WebDriver driver) {
		wait5s();
		return isElementDisplayed(notePopupDescription, driver);

	}

	public Boolean isNotePopupDontShowVisible(WebDriver driver) {
		wait5s();
		return isElementDisplayed(notePopupDontShow, driver);

	}

	public Boolean isvestCreateSuccessfullyPopupVisible() {
//		isElementDisplayed(vestCreateSuccessfullyPopup);
		return true;
	}

	public String getDuplicateVestPopUpTitle(WebDriver driver) {
		waitForElementVisibility(duplicatePopTitle, "30", driver);
		return getElementText(duplicatePopTitle, driver);
	}

	public String getDuplicateVestPopUpDescription(WebDriver driver) {
		waitForElementVisibility(duplicatePopContent, "30", driver);
		return getElementText(duplicatePopContent, driver);
	}

	public boolean getDuplicateVestPopUpDescription(WebDriver driver, String Name) {
		waitForElementVisibility(
				driver.findElement(
						By.xpath("//div[@class='ant-modal-confirm-content']//b[contains(text(),'" + Name + "')]")),
				"30", driver);
		return isElementDisplayed(
				driver.findElement(
						By.xpath("//div[@class='ant-modal-confirm-content']//b[contains(text(),'" + Name + "')]")),
				driver);
	}

	public Boolean isDuplicateVestPopupVisible(WebDriver driver) {
		waitForElementVisibility(duplicatePopTitle, "30", driver);
		if (isElementDisplayed(duplicatePopTitle, driver)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnNotePopupOkButton(WebDriver driver) {
		click(notePopupOkButton, driver);
	}

	public void EnterValueInSearchBar(String Stockname, WebDriver driver) {
		type(diyVestSearchBar, Stockname, driver);
	}
	
	public boolean verifyStockIsNotDisplayed(WebDriver driver) {
		return stockNotAvailable.isDisplayed();
	}

	public ArrayList<String> verifyTotalPercentageOfWeightage(int Sharecount, WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		ArrayList<Integer> percentageList = new ArrayList<Integer>();
		for (int i = 1; i <= Sharecount; i++) {
			percentageList.add(Integer.parseInt(
					driver.findElement(By.xpath("(//div[@class='ant-input-number-input-wrap'])[" + i + "]//input"))
							.getAttribute("aria-valuenow")));
		}
		testSteps.add(" - " + Sharecount + " Shares weightage List: <b>" + percentageList);
		int ExpectedTotalPercentage = sumofList(percentageList, driver);
		printString(" - Expected Sum of " + Sharecount + " Percentage: <b>" + ExpectedTotalPercentage, driver);
		testSteps.add(" - ExpectedTotalPercentage: <b>" + ExpectedTotalPercentage);
		int ActualTotalPercentage = Integer.parseInt(driver
				.findElement(By.xpath("(//div[@class='ant-input-number-input-wrap'])[" + (Sharecount + 1) + "]//input"))
				.getAttribute("aria-valuenow"));
		printString(" - ActualTotalPercentage: " + ActualTotalPercentage, driver);
		testSteps.add(" - ActualTotalPercentage: <b>" + ActualTotalPercentage);
		assertEquals(ExpectedTotalPercentage, ActualTotalPercentage,
				"Verify that Expected Total Percentage is Equal To Actual Total Percentage");
		return testSteps;

	}

	public void clickOnShowAllStockButton(WebDriver driver) {
		click(showAllStocks, driver);
	}

	public void Selectstocks(WebDriver driver) {
		clickOnShowAllStockButton(driver);
		for (int i = 1; i <= 2; i++) {
			click(driver.findElement(By.xpath("(//*[@class='isPlus'])[" + i + "]")), driver);
		}
	}

	public void selectStocks(int count, WebDriver driver) {
		try {
			clickOnShowAllStockButton(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int i = 1; i <= count; i++) {
			click(driver.findElement(By.xpath("(//*[@class='isPlus'])[" + i + "]")), driver);
		}
	}

	public Boolean isAddedStocksButtonEnabled(WebDriver driver)  {
		wait3s();
		if (isElementEnabled(addedStocksButton, driver)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnAddedStocksButton(WebDriver driver) {
		try {
			click(addedStocksButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(addedStocksButton, driver);
		}

	}

	public void clickOnCreateVestButton(WebDriver driver) {
		try {
			click(createVestButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(createVestButton, driver);
		}

	}

	public void enterVestName(String vestName, WebDriver driver) {
		type(createVestName, vestName, driver);
		String Value = getElementText(createVestName, driver);
		if (!Value.equalsIgnoreCase(vestName)) {
			type(createVestName, vestName, driver);
		}
	}

	public void clickVest(String vestName, WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//div[text()='" + vestName + "']//ancestor::div[contains(@class,'ant-card')]"));
		try {
			click(element, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(element, driver);
		}

	}

	public void clickOnNextPopupButton(WebDriver driver) {

		wait5s();
		for (int i = 1; i <= 6; i++) {
			try {
				click(nextPopupButton, driver);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		try {
			click(oKGotItButton, driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickOnsortingButton(WebDriver driver) {
		click(sortingButton, driver);
	}

	public void clickOnsortingOption_Alphabets(WebDriver driver) {
		try {
			click(sortingOption_Alphabets, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_Alphabets, driver);
		}

	}

	public void clickOnsortingOption_InceptionDate(WebDriver driver) {
		try {
			click(sortingOption_InceptionDate, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_InceptionDate, driver);
		}
	}

	public void clickOnsortingOption_OneWeek(WebDriver driver) {
		try {
			click(sortingOption_OneWeek, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_OneWeek, driver);
		}
	}

	public void clickOnsortingOption_OneMonth(WebDriver driver) {
		try {
			click(sortingOption_OneMonth, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_OneMonth, driver);
		}
	}

	public void clickOnsortingOption_ThreeMonth(WebDriver driver) {
		try {
			click(sortingOption_ThreeMonth, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_ThreeMonth, driver);
		}
	}

	public void clickOnsortingOption_OneYear(WebDriver driver) {
		try {
			click(sortingOption_OneYear, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_OneYear, driver);
		}
	}

	public void clickOnsortingOption_FiveYear(WebDriver driver) {
		try {
			click(sortingOption_FiveYear, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_FiveYear, driver);
		}
	}

	public void clickOnsortingOption_AllTime(WebDriver driver) {
		try {
			click(sortingOption_AllTime, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(sortingOption_AllTime, driver);
		}
	}

	public Boolean isSelectedSortingTypeSelected(String type, WebDriver driver) {
		return isElementDisplayed(driver.findElement(By.xpath("(//span[text()='" + type + "'])[1]")), driver);
	}

	public int getVestCardCount()  {
		wait5s();
		return VestCardCount.size();
	}

	public double getCurrentInvestment(WebDriver driver)  {
		waitForElementVisibility(currentInvestmentAmount, defaultTimeForVisibility, driver);
		String val = getElementText(currentInvestmentAmount, driver);
		return Double.parseDouble(val.replace("$", "").replace(",", ""));
	}

	public ArrayList<String> getDiyVestCardsNameList(WebDriver driver) {
		ArrayList<String> namelist = new ArrayList<>();
		for (int i = 1; i <= getVestCardCount(); i++) {
			namelist.add(driver.findElement(By.xpath("(//div[@class='ant-card-head-title'])[" + i + "]")).getText());
		}
		return namelist;
	}

	public ArrayList<Double> getDiyVestCardsPercentageList(WebDriver driver) {
		ArrayList<Double> namelist = new ArrayList<>();
		for (int i = 1; i <= getVestCardCount(); i++) {
			namelist.add(Double
					.valueOf(driver.findElement(By.xpath("(//span[contains(@data-testid,'stat-percent')])[" + i + "]"))
							.getText().replace("+", "").replace("%", "").replace(",", "").trim()));
		}
		return namelist;
	}

	public void clickThreeDotsOnNewlyCreatedVest(String vestName, WebDriver driver) {
		String path = "//div[@class='ant-card-head-title' and contains(text(),'" + vestName
				+ "')]//following-sibling::div/div";
		WebElement element = driver.findElement(By.xpath(path));
		waitForElementVisibility(element, defaultTimeForVisibility, driver);
//		waitForElementToBeClickable(element, defaultTimeTOBeClickable);
		click(element, driver);
	}

	public String getVestedOrNotVestedText(String vestName, WebDriver driver) {
		String path = "//div[@class='ant-card-head-title' and contains(text(),'" + vestName
				+ "')]/parent::Div//parent::div//parent::div//ul[@class='ant-card-actions']//span//span";
		WebElement element = driver.findElement(By.xpath(path));
		scrollIntoView(element, driver);
		waitForElementVisibility(element, defaultTimeForVisibility, driver);
//		waitForElementToBeClickable(element, defaultTimeTOBeClickable);
		return element.getText();
	}

	public boolean isVestPresent(String vestName, WebDriver driver) {
		String path = "//div[@class='ant-card-head-title' and contains(text(),'" + vestName + "')]";
		try {
			WebElement element = driver.findElement(By.xpath(path));
			waitForElementVisibility(element, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isVestOptionsVisible(String vestName, String vestOption, WebDriver driver) {
		String path = "(//div[@class='ant-card-head-title' and contains(text(),'" + vestName
				+ "')]//following-sibling::div/div)[1]//span[text()='" + vestOption + "']";
		return isElementDisplayed(driver.findElement(By.xpath(path)), driver);
	}

	public void clickVestOptionsVisible(String vestName, String vestOption, WebDriver driver) {
		String path = "(//div[@class='ant-card-head-title' and contains(text(),'" + vestName
				+ "')]//following-sibling::div/div)[1]//span[text()='" + vestOption + "']";
		click(driver.findElement(By.xpath(path)), driver);
	}

	public boolean isShareYourVestTitleDisplaying(WebDriver driver) {
		return isElementDisplayed(shareYourVestTitle, driver);
	}

	public void clickOnShareLink(WebDriver driver) {
		click(shareLink, driver);
	}

	public void clickOnWhatsappBtn(WebDriver driver) {
		waitForElementClickable(whatsappBtn, "5", driver);
		click(whatsappBtn, driver);
	}

	public void clickOnFacebookBtn(WebDriver driver) {
		waitForElementClickable(facebookBtn, "5", driver);
		click(facebookBtn, driver);
	}

	public void clickOnLinkedInBtn(WebDriver driver) {
		waitForElementClickable(linkedInBtn, "5", driver);
		clickUsingJavascriptExecutor(linkedInBtn, driver);
	}

	public void clickOnTwitterBtn(WebDriver driver) {
		waitForElementClickable(twitterBtn, "5", driver);
		click(twitterBtn, driver);
	}

//////////////////////////////////////////
	public void clickOnGmailBtn(WebDriver driver) {
		click(gmailBtn, driver);
	}

	public void clickOnPreviewPageBtn(WebDriver driver) {
		click(previewPageBtn, driver);
	}

	public void clickOnDeleteButton(WebDriver driver) {
		waitForElementClickable(deleteButton, "10", driver);
		click(deleteButton, driver);
	}

	public void clickOnDIYVestDeleteButton(WebDriver driver) {
		waitForElementClickable(diyVestdeleteButton, "10", driver);
		click(diyVestdeleteButton, driver);
	}

	public boolean isVestNameVisible(String vestName, WebDriver driver) {
		String path = "//p[text()='" + vestName + "']";
		return isElementDisplayed(driver.findElement(By.xpath(path)), driver);
	}

	public boolean isVestPerformanceTitleVisible(WebDriver driver) {
		waitForElementVisibility(vestPerformanceTitle, "30", driver);
		return isElementDisplayed(vestPerformanceTitle, driver);
	}

	public boolean isWhatappPageTitleVisible(WebDriver driver) {
		wait5s();
		if(driver.getCurrentUrl().contains("whatsapp")) {
			return true;
		}else {
			return false;
		}
//		waitForElementVisibility(whatappPageTitle, "30", driver);
//		return isElementDisplayed(whatappPageTitle, driver);
	}

	public boolean isFacebookPageTitleVisible(WebDriver driver) {
		wait5s();
		if(driver.getCurrentUrl().contains("facebook")){
			return true;
		}else {
			return false;
		}
//		waitForElementVisibility(facebookPageTitle, "30", driver);
//		return isElementDisplayed(facebookPageTitle, driver);
	}

	public boolean isLinkedInPageTitleVisible(WebDriver driver) {
		wait5s();
		if(driver.getCurrentUrl().contains("linkedin")) {
			return true;
		}else {
			return false;
		}
//		waitForElementVisibility(linkedInPageTitle, "30", driver);
//		return isElementDisplayed(linkedInPageTitle, driver);
	}

	public boolean isTwitterPageTitleVisible(WebDriver driver) {
		wait5s();
		if(driver.getCurrentUrl().contains("twitter")) {
			return true;
		}else {
			return false;
		}
//		waitForElementVisibility(twitterPageTitle, "30", driver);
//		return isElementDisplayed(twitterPageTitle, driver);
	}

	public boolean isGmailPageTitleVisible(WebDriver driver) {
		wait5s();
		waitForElementVisibility(gmailPageTitle, "30", driver);
		return isElementDisplayed(gmailPageTitle, driver);
	}

	public void clickOnNotInvestedCard(String vestName, WebDriver driver) {
		String path = "//div[text()='" + vestName
				+ "']//parent::div//parent::div//parent::div//ul[@class='ant-card-actions']//li";

		WebElement element = driver.findElement(By.xpath(path));
		waitForElementVisibility(element, defaultTimeForVisibility, driver);
//		waitForElementToBeClickable(element, defaultTimeTOBeClickable,driver);
		click(element, driver);
	}

	public void clickOnClipBoardCopy(WebDriver driver) {
		wait2s();
		waitForElementClickable(clipBoardCopy, "5", driver);
		click(clipBoardCopy, driver);
		wait2s();
	}

	public void openNewTab(String url, WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank'," + driver + ");", driver);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(url);
		}

	}

	public void clickOnShareYourVestCloseButton(WebDriver driver) {
		waitForElementClickable(shareYourVestCloseBtn, "5", driver);
		click(shareYourVestCloseBtn, driver);
	}

	public boolean isRenameTitleVisible(WebDriver driver) {
		waitForElementVisibility(renameTitle, "30", driver);
		return isElementDisplayed(renameTitle, driver);
	}

	public void enterVestRename(String vestName, WebDriver driver) {
		type(renameTxt, vestName, driver);
	}

	public void clickOnRenameVestButton(WebDriver driver) {
		waitForElementClickable(renameVestBtn, "5", driver);
		click(renameVestBtn, driver);
	}

	public boolean isVestOptionsVisible(String vestName, WebDriver driver) {
		String path = "//div[@class='ant-card-head-title' and contains(text(),'" + vestName + "')]";
		return isElementDisplayed(driver.findElement(By.xpath(path)), driver);
	}

	public boolean isVestNameAlreadyCreatdPopupVisible(WebDriver driver) {
		waitForElementVisibility(vestNameAlreadyCreatdPopup, "30", driver);
		return isElementDisplayed(vestNameAlreadyCreatdPopup, driver);
	}

	public void clickOnAlreadyCreatdPopupOkButton(WebDriver driver) {
		waitForElementClickable(vestNameAlreadyCreatdPopupOkbtn, "5", driver);
		click(vestNameAlreadyCreatdPopupOkbtn, driver);
	}

	public void clickOnStockPlusButton(WebDriver driver) {
		waitForElementClickable(stockPlusBtn, "5", driver);
		click(stockPlusBtn, driver);
	}

	public void clickOnStockBackButton(WebDriver driver) {
		waitForElementClickable(stockBackBtn, "5", driver);
		click(stockBackBtn, driver);
	}

	public void enterStockPercentage(String vestName, WebDriver driver) {
		String path = "(//div[@class='ant-input-number-input-wrap'])[" + 1 + "]//input";
		type(driver.findElement(By.xpath(path)), vestName, driver);
	}

	public void clickOnRenameCloseButton(WebDriver driver) {
		waitForElementClickable(renameCloseBtn, "5", driver);
		click(renameCloseBtn, driver);
	}

	public void clickOnCloseChangeHowYourVestAreSortedPopUp(WebDriver driver) {
		waitForElementClickable(changeHowYourVestAreSortedPopUpXIcon, "5", driver);
		click(changeHowYourVestAreSortedPopUpXIcon, driver);
	}

	public ArrayList<String> createDIYVest(WebDriver driver, String newVestTitle, int i) {
		ArrayList<String> testSteps = new ArrayList<String>();
		wait5s();
		try {
			WebElement ele = driver.findElement(By.xpath("//div[text()='" + newVestTitle + "']"));
			scrollIntoSpecificView(ele, driver);
			testSteps.add("Step " + (++i) + " : <b>'" + newVestTitle + "'</b> vest is already created");

		} catch (Exception e) {
			testSteps.add("Step " + (++i) + " : <b>'Creating New Vest'</b>");
			wait3s();
			testSteps.add("Step " + (++i) + " : click <b>'Create New Vest'</b> button");
			clickOnCreateNewVestButton(driver);
			testSteps.add("Step " + (++i) + " : Click On <b>'+'</b> to add stocks");
			testSteps.add("Step " + (++i) + " : Add one stock");
			selectStocks(1, driver);
			testSteps.add("Step " + (++i) + " : Verifying: <b>'Stocks/ETFs added Button is enable with one stock'</b>");
			assertFalse(isAddedStocksButtonEnabled(driver), "'Stocks/ETFs added Button' is enabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is disabled ");
			testSteps.add("Step " + (++i) + " : <b>'Add more stock'</b>");
			selectStocks(2, driver);
			testSteps.add("Step " + (++i)
					+ " : Verifying: <b>'Stocks/ETFs added'</b> Button is enable with more than one stock");
			assertTrue(isAddedStocksButtonEnabled(driver), "<b>'Stocks/ETFs added Button'</b> is disabled ");
			testSteps.add("Verified: <b>'Stocks/ETFs added'</b> is enabled ");
			testSteps.add("Step " + (++i) + " : click <b>'Stocks/ETFs added'</b> button");
			clickOnAddedStocksButton(driver);
			testSteps.add("Step " + (++i) + " : Verifying the <b>'Note Popup'</b> is visible");
			assertTrue(isNotePopupVisible(driver), "Note Popup Is not visible");
			testSteps.add("Step " + (++i) + " : Verified: Note Popup is visible");
			testSteps.add("Step " + (++i) + " : click <b>'Note Popup OK'</b> button");
			clickOnNotePopupOkButton(driver);
			testSteps.add("Step " + (++i) + " : Enter New Vest Title: <b>'" + newVestTitle + "'</b>");
			enterVestName(newVestTitle, driver);
			testSteps.add("Step " + (++i) + " : Verify <b>'Percentage weightage'</b>");
			testSteps.addAll(verifyTotalPercentageOfWeightage(3, driver));

			testSteps.add("Step " + (++i) + " : click <b>'Create Vest'</b> button");
			clickOnCreateVestButton(driver);

			testSteps.add("Step " + (++i) + " : Verifying the <b>'Vest Created Success Popup'</b> is visible");
			assertTrue(isvestCreateSuccessfullyPopupVisible(), "Vest Created Successfully Popup is not shown");
			testSteps.add("Step " + (++i) + " : Verified: <b>'Vest Created Successfully Popup'</b> is shown");

			try {
				clickOnNextPopupButton(driver);
			} catch (Exception e1) {
				printString("No PopUp Next Button found", driver);
			}

		}
		return testSteps;
	}

	public void clickOnDIYVest(WebDriver driver, String vestName) {

		WebElement ele = driver.findElement(By.xpath("(//div[text()='" + vestName
				+ "']/ancestor::div[@class='ant-card-head']/following-sibling::div//p)[1]"));
		try {
			click(ele, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ele, driver);
		}
	}

	public void clickOnThreeDot(WebDriver driver, String Vestname) {
		WebElement ele = driver.findElement(
				By.xpath("//div[text()='" + Vestname + "']//ancestor::div[@class='ant-card-head']//button"));
		try {
			click(ele, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ele, driver);
		}
	}

	public void clickOnThreeDotOption(WebDriver driver, String vestname, String button) {
		WebElement ele = driver.findElement(By.xpath(
				"//div[text()='" + vestname + "']//ancestor::div[@class='ant-card-head']//*[text()='" + button + "']"));
		try {
			click(ele, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(ele, driver);
		}
	}

	public Boolean VerifyThreeDotOptionisDisplaying(WebDriver driver, String vestname, String button) {
		WebElement ele = driver.findElement(By.xpath(
				"//div[text()='" + vestname + "']//ancestor::div[@class='ant-card-head']//*[text()='" + button + "']"));
		return isElementEnabled(ele, driver);
	}

	public Boolean VerifyShareDIYVestPopup(WebDriver driver) {
		waitForElementVisibility(shareVestPopup, defaultTimeForVisibility, driver);
		return isElementEnabled(shareVestPopup, driver);
	}

	public void clickOnCloseIcon(WebDriver driver) {
		try {
			click(closeIcon, driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			click(closeIcon2, driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean isPreviousPendingRebalancePopupVisible(WebDriver driver) {
		return isElementDisplayed(previousPendingRebalancePopup, driver);
	}

	public boolean isNotEnoughCashPopupFound(WebDriver driver) {
		return isElementDisplayed(notEnoughCashPopup, driver);
	}

	public boolean isRebalanceQueuedDisplaying(WebDriver driver) {
		return isElementDisplayed(rebalanceQueuedButton, driver);
	}
	
	public boolean isPendingOrdersSectionVisible(WebDriver driver) throws InterruptedException {
		waitfor10sec();
		return isElementDisplayed(pendingOrdersSection, driver);
	}
	
	public boolean isOTCHeadingDisplayed(WebDriver driver) {
		return isElementDisplayed(OTCheading, driver);
	}
	
	public boolean isIiconVisible(WebDriver driver) {
		return isElementDisplayed(iIcon,driver);
	}
	
	public boolean isPendingOrdersPopupVisible(WebDriver driver) {
		return isElementDisplayed(pendingOrdersPopup,driver);
	}
	

	public boolean isWarningPopupDisplayed(WebDriver driver) {
		return isElementDisplayed(warningPopup, driver);
	}
	
	public boolean isShowAllDisplayed(WebDriver driver) {
		return isElementDisplayed(showAll, driver);
	}
	
	public boolean isCancelButtonDisplayed(WebDriver driver) {
		return isElementDisplayed(cancelButton,driver);
	}
	
	public boolean isShowAllClickable(WebDriver driver) {
		return showAll.isEnabled();
	}
	
	public boolean isOTCAvailableAndClickable(String OTCname, WebDriver driver) throws InterruptedException {
		
		waitfor10sec();
		
		
		boolean isAvailable = true;
		for (int i = 0; i < listOfOTCStocks.size(); i++) {
			System.out.println(listOfOTCStocks.get(i).getText());
			if(listOfOTCStocks.get(i).getText().equals(OTCname) && listOfOTCStocks.get(i).isEnabled()) {
				isAvailable = true;
				break;
				
			}else {
				isAvailable = false;
			}
		}
		return isAvailable;
		
	}
	
	public void clickOnCrossIcon(WebDriver driver) {
		click(crossIcon, driver);
	}
	
	public void clickOTCShowAll(WebDriver driver) {
		click(showAll, driver);
	}
	
	public void clickOnYesButton(WebDriver driver) {
		click(yesButtonOnWarningPopup, driver);
	}
	
	
	public void clickOnNoButton(WebDriver driver) {
		click(noButtonOnWarningPopup, driver);
	}
	
	
	
	public void clickOnCancelButton(WebDriver driver) {
		click(cancelButton, driver);
	}
	
	public void cancelAllPendingOrders(WebDriver driver) throws InterruptedException {
		
		List<WebElement> listOfCancelButton = driver.findElements(By.xpath("//div[@type='pendingOrder']/div/p[text()='Cancel']"));
		System.out.println("Size is"+listOfCancelButton.size());
		while (listOfCancelButton.size() > 0) {
		  
			waitfor10sec();
			try {
			listOfCancelButton.get(0).click();
			yesButtonOnWarningPopup.click();
			}catch(Exception e) {
				System.out.println(e);
			}
			  listOfCancelButton = driver.findElements(By.xpath("//div[@type='pendingOrder']/div/p[text()='Cancel']"));
			
		}
	}

	public void clickOnIicon(WebDriver driver) {
		click(iIcon, driver);
	}

	public void clickOnPreviewOrder(WebDriver driver) {
		click(previewOrderButton, driver);
	}

	public void clickOnPlaceOrder(WebDriver driver) {
		click(placeOrderButton, driver);
	}

	public void clickOnRebalanceSuccessOkGotIt(WebDriver driver) {
		click(rebalanceSuccessOkGotIt, driver);
	}

	public void clickOnYesProcessedButton(WebDriver driver) {
		click(yesProcessedButton, driver);
	}
	
	public int getPendingOrdersCount(WebDriver driver) throws InterruptedException {
		System.out.println("Wait start");
		waitfor10sec();
		System.out.println("Wait End");
		return pendingOrdersList.size();
	}

	public Boolean isVestRebalancedQueued(WebDriver driver, String Vest, String type) {

		try {
			WebElement ele = driver.findElement(By.xpath("//div[text()='" + Vest
					+ "']//ancestor::div[contains(@class,'bordered')]//span[text()='" + type + "']"));
			waitForElementVisibility(ele, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Double getSellAmountField(WebDriver driver) {
		waitForElementVisibility(sellAmountInput, defaultTimeForVisibility, driver);
		return Double.parseDouble(
				getElementAttributeValue(sellAmountInput, "value", driver).replace("$", "").replace(",", ""));
	}

	public void enterSellAmount(WebDriver driver, String amount) {
		waitForElementVisibility(sellAmountInput, defaultTimeForVisibility, driver);
		sendKeysToWebElement(sellAmountInput, amount, driver);

	}

	public Boolean isSuccessScreenDisplay(WebDriver driver) {
		try {
			waitForElementVisibility(oKGotItButton, defaultTimeForVisibility, driver);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	public Boolean isRequiredVestNameDisplay(WebDriver driver) {
		try {
			waitForElementVisibility(requiredVestNamePopup, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnRequiredVestNamePopupOkButton(WebDriver driver) {
		try {
			click(requiredVestNamePopupOkButton, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(requiredVestNamePopupOkButton, driver);
		}
	}

	public Boolean isMinimum50DollarRequiredPopupDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(minimumAmountRequired, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean isMinimum50DollarErrorMessageDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(minimumAmountErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public Boolean isMinimum10DollarErrorMessageDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(minimum10AmountErrorMessage, defaultTimeForVisibility, driver);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Double getInvestedAmountOnPreviewPage(WebDriver driver) {
		return Double.parseDouble(getElementText(previewPageInvestedAmount, driver).replace("$", "").replace(",", ""));
	}

	public void selectStockByIndex(int index, WebDriver driver) {
		try {
			clickOnShowAllStockButton(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		click(driver.findElement(By.xpath("(//*[@class='isPlus'])[" + index + "]")), driver);
	}

	public Boolean isNotePopupVisibleOrNot(WebDriver driver) {
		try {
			waitForElementVisibility(notePopupText, "30", driver);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}

	}

	public Boolean isAddStocksOrEftsToProceedButtonEnabled(WebDriver driver) {
		wait3s();
		if (isElementEnabled(addStocksEftsButton, driver)) {
			return true;
		} else {
			return false;
		}
	}
	public void clickOnPendingVestInfoIcon(WebDriver driver) {
		try {
			click(pendingVestInfoIcon, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(pendingVestInfoIcon, driver);
		}
	}
	
	

}
