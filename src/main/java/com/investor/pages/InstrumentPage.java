package com.investor.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investor.base.BaseClass;
import com.investor.base.PropertiesReader;

public class InstrumentPage extends BaseClass {

	private WebDriver podriver = null;

	@FindBy(xpath = ("//div[contains(@class,'css-12oea1u')][1]"))
	WebElement stock;

	@FindBy(xpath = ("//button[@data-testid='Sell'] | //button[text()='SELL']"))
	WebElement btnSell;

	@FindBy(xpath = ("//input[@name='shares']"))
	WebElement sharesInput;

	@FindBy(xpath = ("//input[@name='amount']"))
	WebElement amount;

	@FindBy(xpath = ("//span[contains(text(),'Review Order')]"))
	WebElement btnReviewOrder;

	@FindBy(xpath = ("//span[contains(text(),'Place Sell Order')]"))
	WebElement btnPlaceSellOrder;

	@FindBy(xpath = "(//table[contains(@class,'css-8atqhb')])[1]")
	WebElement tableInstruments;

	@FindBy(xpath = "//p[text()='Your Position']")
	WebElement instrumentDetailsPage;

	@FindBy(xpath = "//p[contains(text(),'overview')]")
	WebElement instrumentDetailsOverviewTab;

	@FindBy(css = "div.e14yx2tp3")
	WebElement overViewTabDetails;

	@FindBy(xpath = "//p[contains(text(),'returns')]")
	WebElement instrumentDetailsReturnsTab;

	@FindBy(xpath = "//p[contains(text(),'fundamental data')]")
	WebElement instrumentDetailsFundamentalDataTab;

	@FindBy(xpath = "//p[contains(text(),'key ratios')]")
	WebElement instrumentDetailsKeyRatiosTab;

	@FindBy(xpath = "//button[contains(text(),'Invest Now')]")
	WebElement btnInvestNow;

	@FindBy(xpath = "//div[text()='Register']")
	WebElement modalSignupLogin;

	@FindBy(xpath = "//button[contains(@class,'ant-modal-close')]")
	WebElement btnCloseModal;

	@FindBy(xpath = "(//div[@data-testid='WatchlistSelect'])[last()]")
	WebElement btnAddToWatchList;

	@FindBy(xpath = "(//p[contains(text(),'to Watchlist')])[last()]")
	WebElement btnAddToWatchList2;

	@FindBy(xpath = "(//p[contains(text(),'Add to Watchlist')])[last()]")
	WebElement addToWatchListMessage;

	@FindBy(xpath = "(//p[contains(text(),'Added to Watchlist')])[last()]")
	WebElement addedToWatchListMessage;

	@FindBy(xpath = "(//span[contains(text(),'Schedule your orders for the future')])[2]//..//..//span[@class='tooltip-cross-button']")
	WebElement extraPOpUp;

	@FindBy(xpath = "//button[contains(text(),'BUY')]")
	WebElement btnBUY;

	@FindBy(xpath = "//*[contains(text(),'Buying Power')]")
	WebElement buyInstrumentPage;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)//td[1]")
	List<WebElement> instrumentTableRows;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[1]/th[contains(text(),'Name')]")
	WebElement nameCellTableHeader;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[1]/th[contains(text(),'Symbol')]")
	WebElement symbolCellTableHeader;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[1]/th[contains(text(),'Price')]")
	WebElement priceCellTableHeader;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[1]/th[contains(text(),'Daily Change')]")
	WebElement dailyChangeCellTableHeader;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[1]/th[contains(text(),'Market Cap')]")
	WebElement marketCapCellTableHeader;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[1]/th[contains(text(),'P/E Ratio')]")
	WebElement peRationCellTableHeader;

	@FindBy(xpath = "((//table[contains(@class,'css-8atqhb')])[1]//tr)[2]//td[last()]//span")
	WebElement firstInstrumentWatchListIcon;

	@FindBy(xpath = "(//*[contains(text(),'Top Movers')])[1]")
	WebElement topMoversLabel;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleTop Movers']/parent::div//following-sibling::p | //p[@data-testid='CollectionTitleTop Movers']//following-sibling::p")
	WebElement topeMoversShowAll;

	@FindBy(xpath = "//div[contains(@class,'css-tydqpe')]//span[contains(@class,'unchecked')]")
	List<WebElement> Allcategories;

	@FindBy(xpath = "//div[contains(@class,'css-tydqpe')]")
	List<WebElement> categoryTitles;

	@FindBy(xpath = "(//table[contains(@class,'css-8atqhb')])[1]/tbody/tr")
	List<WebElement> stocksList;

	@FindBy(xpath = "(//*[contains(@class,'18y7tie')])[1]")
	WebElement stockSymbolOnDetailsPage;

	@FindBy(xpath = "(//*[contains(@class,'css-1d62lsh')])[1]")
	WebElement stockNameOnDetailsPage;

	@FindBy(xpath = "//p[text()='Explore 1,000+ US Stocks & ETFs.']")
	WebElement stockNamesPage;

	@FindBy(xpath = "//p[text()='Signals']")
	WebElement signalsPage;

	@FindBy(xpath = "(//*[contains(@class,'css-ykvost')])[1]")
	WebElement stockPriceOnDetailsPage;

	@FindBy(xpath = "(//*[contains(@class,'css-w8v2t6')])[1]//../following-sibling::p")
	WebElement stockDailyChangeOnDetailsPage;

	@FindBy(xpath = "//p[text()='Invested Amount']//..//p[@data-testid='investedAmount']")
	WebElement InvestedAmount;

	@FindBy(xpath = "//p[text()='Market Price']//..//..//p[contains(text(),'$')]")
	WebElement MarketValue;

	@FindBy(xpath = "//button[@class='ant-modal-close']")
	WebElement PopUpCLoseButton;

	@FindBy(xpath = "//p[text()='Shares']//..//..//input")
	WebElement SharesValue;

	@FindBy(xpath = "(//p[text()='Shares']//..//..//input)[2]")
	WebElement SharesValue2;

	@FindBy(xpath = "//p[contains(text(),'Estimated Proceeds')]//..//..//..//input | //p[contains(text(),'Total Cost')]//..//..//..//input |//p[contains(text(),'Estimate')]//..//..//input")
	WebElement EstimatedCostValue;
	

	@FindBy(xpath = ("//p[text()='Market']"))
	WebElement OpenTimmer;

	@FindBy(xpath = ("//span[contains(text(),'YES')]//.."))
	WebElement CancelPendingOrderYes;

	@FindBy(xpath = ("//p[text()='Pending Orders']//..//..//..//..//..//p[contains(text(),'Show All')]"))
	WebElement PendingOrderShowAll;

	@FindBy(xpath = ("//p[text()='Pending Orders']"))
	WebElement PendingOrderBox;

	@FindBy(xpath = ("//span[contains(text(),'Got It')]//parent::button"))
	WebElement WarningPopUpGotItButton;

	@FindBy(xpath = ("//div[contains(@class,\"css-6hb8hu\")][3]/p[contains(@class,'css-6p3gid')]"))
	WebElement YourPositionShare;

	@FindBy(xpath = ("//span[contains(@class,\"anticon-caret-down\")]"))
	WebElement OrderDorpDownBtn;

	@FindBy(xpath = ("//p[contains(text(),\"Limit Order\")]"))
	WebElement LimitOrderDorpDown;

	@FindBy(xpath = ("//a[contains(@class,'ant-dropdown-link')]"))
	WebElement LimitOrderPage;

	@FindBy(xpath = ("//span[contains(text(),'Fractional shares are not')]"))
	WebElement errorMessageFractionalShare;

	@FindBy(xpath = ("//input[contains(@name,\"amount\")]"))
	WebElement limitPriceInput;

	@FindBy(xpath = ("//p[text()='Total Buying Power']//..//p[@class='amount']"))
	WebElement BuyingPower;

	@FindBy(xpath = "//p[contains(text(),'overview')]")
	WebElement overviewBtn;

	@FindBy(xpath = "(//div[contains(@class,'panel-chart')])[1] | //cq-chart-title[@cq-marker='true'] | //div[@class='ant-card']/div/div[1]//span[text()='fullscreen']")
	WebElement overviewPage;

	@FindBy(xpath = "//p[contains(text(),'returns')]")
	WebElement returnsBtn;

	@FindBy(xpath = "//div[@data-testid='no-data-label'] | //th[contains(text(),'Time Frame')]")
	WebElement returnsPage;

	@FindBy(xpath = "//p[contains(text(),'fundamental data')]")
	WebElement fundamentalDataBtn;

	@FindBy(xpath = "//p[contains(text(),'Income Statement')]")
	WebElement fundamentalDataPage;

	@FindBy(xpath = "//p[contains(text(),'Balance Sheet')]")
	WebElement balanceSheetBtn;

	@FindBy(xpath = "//span[contains(text(),'Numbers')]")
	WebElement balanceSheetPage;

	@FindBy(xpath = "//p[contains(text(),'Cash Flow')]")
	WebElement cashFlowBtn;

	@FindBy(xpath = "//span[contains(text(),'Numbers')]")
	WebElement cashFlowPage;

	@FindBy(xpath = "//p[contains(text(),'key ratios')]")
	WebElement keyRatiosBtn;

	@FindBy(xpath = "//p[contains(text(),'Liquidity')]")
	WebElement keyRatiosPage;

	@FindBy(xpath = "//div[text()='No data available!']")
	WebElement keyRatiosNoDataPage;

	@FindBy(xpath = "//div[@class=\"css-1dmy950 e14yx2tp3\"]/div/div/div[1]/div/*[2]")
	WebElement addTickerForComparisonBtn;

	@FindBy(xpath = "//div[contains(text(),'Search Ticker')]")
	WebElement searchTicker;

	@FindBy(xpath = "//p[contains(text(),'Liabilities')]")
	WebElement liabilitiesTitle;

	@FindBy(xpath = "//button[contains(text(),'BUY')]")
	WebElement buyBtn;

	@FindBy(xpath = "//p[contains(text(),'Total Buying Power')]")
	WebElement buyingPage;

	@FindBy(xpath = ("//p[contains(text(),\"Stop Order\")]"))
	WebElement StopOrderDorpDown;

	@FindBy(xpath = ("//span[contains(text(),'Place Buy Order')]"))
	WebElement btnPlaceBuyOrder;

	@FindBy(xpath = ("(//p[contains(text(),'Create Recurring Investment')]//parent::button)[last()] | //div[contains(@class,'css-23mid0')]//p[contains(text(),'Create Recurring Investment')]"))
	WebElement createRecurringInvestmentBtn;

	@FindBy(xpath = "//*[contains(text(),'Sectors')]")
	WebElement sectorsLabel;
	@FindBy(xpath = "//p[@data-testid='CollectionTitleOTC']")
	WebElement otcLabel;
	@FindBy(xpath = "//p[@data-testid='SignalTitle']")
	WebElement signalsLabel;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleSectors']/parent::div//following-sibling::p")
	WebElement sectorsShowAll;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleOTC']/parent::div//following-sibling::p")
	WebElement otcShowAll;

	@FindBy(xpath = "(//p[contains(text(),'Sectors')])[2]")
	WebElement sectorsPage;

	@FindBy(xpath = "//p[text()='OTC']//span[@class='checked'] | (//img[contains(@src,'otc')])[1]")
	WebElement otcPage;

	@FindBy(xpath = "(//p[contains(text(),'Communication Services')])[1]")
	WebElement communicationServices;

	@FindBy(xpath = "//p[@data-testid='SignalTitle']/parent::div/following-sibling::div[1]//a[1]")
	WebElement signalFirstOption;

	@FindBy(xpath = "//*[contains(text(),'Emerging Themes')]")
	WebElement emergingThemesLabel;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleEmerging Themes']/parent::div//following-sibling::p")
	WebElement emergingThemesShowAll;

	@FindBy(xpath = "(//p[contains(text(),'Emerging Themes')])[2]")
	WebElement emergingThemesShowPage;

	@FindBy(xpath = "(//p[contains(text(),'Artificial Intelligence')])")
	WebElement artificialIntelligence;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleGeography'] | (//p[contains(text(),'Geography')])")
	WebElement geographyLabel;

	@FindBy(xpath = ("//span[contains(@class,'anticon-close')]"))
	WebElement errorMessageLowStopPricePopupCloseBtn;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleGeography']/parent::div//following-sibling::p")
	WebElement geographyShowAll;

	@FindBy(xpath = "(//p[contains(text(),'Geography')])[2]")
	WebElement geographyPage;

	@FindBy(xpath = ("//div[contains(text(),'High Stop Price')]"))
	WebElement errorMessageHighStopPrice;

	@FindBy(xpath = ("//input[contains(@name,\"amount\")]"))
	WebElement stopPriceInput;

	@FindBy(xpath = "(//p[contains(text(),'US')])")
	WebElement US;

	@FindBy(xpath = "(//p[contains(text(),'ETF Providers')])")
	WebElement ETFProvidersLabel;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleETF Providers']/parent::div//following-sibling::p")
	WebElement ETFProvidersShowAll;

	@FindBy(xpath = "(//p[contains(text(),'ETF Providers')])[2]")
	WebElement ETFProvidersPage;

	@FindBy(xpath = "(//p[contains(text(),'Fidelity')])/..")
	WebElement fidelity;

	@FindBy(xpath = "(//p[contains(text(),'Income Focused')])")
	WebElement incomeFocusedLabel;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleIncome Focused']/parent::div/parent::div/parent::div//p[contains(text(),'Bonds')]//parent::a")
	WebElement bondsBtn;

	@FindBy(xpath = "(//p[contains(text(),'Recommended')])[1]")
	WebElement recommendedLabel;

	@FindBy(xpath = "//p[@data-testid='CollectionTitleRecommended']/parent::div//following-sibling::p")
	WebElement recommendedShowAll;

	@FindBy(xpath = "//p[text()='Estimate Proceeds']//..//..//input")
	WebElement EstimatedProceedsValue;

	@FindBy(xpath = "//p[text()='Market Price']//..//p[2]")
	WebElement stopOrderMarketValue;

	@FindBy(xpath = ("//div[contains(text(),'Low Stop Price')]"))
	WebElement errorMessageLowStopPrice;

	@FindBy(xpath = ("//div[@class='ant-modal-body']"))
	WebElement errorMessageLowStopPriceContent;

	@FindBy(xpath = "//*[contains(text(),'Current Investment')]")
	WebElement sellInstrumentPage;

	@FindBy(xpath = "//span[text()='You do not have enough cash.']")
	WebElement notEnoughCashError;

	@FindBy(xpath = "//span[text()='Invalid cash.']")
	WebElement InvalidCashError;

	@FindBy(xpath = "//p[text()='Multi-Asset Class Vests']//span")
	WebElement multiAssetClassVests_i;
	
	@FindBy(xpath = "//p[text()='Vests ']//span")
	WebElement Vests_i;
	

	@FindBy(xpath = "//p[text()='Portfolio Overview']//span")
	WebElement PortfolioOverview_i;

	@FindBy(xpath = "//p[text()='Your Portfolio']//span")
	WebElement YourPortFolio_i;
	@FindBy(xpath = "//div[@data-testid='EmergingThemeCollectionDisclosure']")
	WebElement EmergingThemeDisclosure;

	@FindBy(xpath = "//div[@data-testid='signalDisclosure']")
	WebElement signalsDisclosure;

	@FindBy(xpath = "//div[@data-testid='RecommendedCollectionDisclosure']")
	WebElement RecommedationDisclosure;

	@FindBy(xpath = "//div[text()='Multi-Asset Class Portfolios'] ")
	WebElement multiAssetClassVests_iPopup;
	@FindBy(xpath = "//div[text()='Definitions of portfolio parameters']")
	WebElement YourPortFolio_iPopup;

	@FindBy(xpath = "//p[text()='add funds']")
	WebElement AddFunds_Popup;

	@FindBy(xpath = "//div[text()='Emerging Themes Disclosure']")
	WebElement EmergingThemesDisclosure_Popup;

	@FindBy(xpath = "//div[text()='Signals Disclosure']")
	WebElement SignalsDisclosure_Popup;

	@FindBy(xpath = "//div[text()='Recommended Disclosure']")
	WebElement RecomendationDisclosure_Popup;

	@FindBy(xpath = "//div[text()='Portfolio Overview']")
	WebElement portfolioOverview_iPopup;

	@FindBy(xpath = "//div[text()='Multi-Asset Class Portfolios']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement multiAssetClassVests_iPopupClose;

	@FindBy(xpath = "//div[text()='Portfolio Overview']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement PortfolioOverview_iPopupClose;

	@FindBy(xpath = "//div[text()='Definitions of portfolio parameters']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement YourPortFolio_iPopupClose;

	@FindBy(xpath = "//div[text()='Emerging Themes Disclosure']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement EmergingThemesDisclosure_PopupClose;

	@FindBy(xpath = "//div[text()='Signals Disclosure']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement SignalsDisclosure_PopupClose;

	@FindBy(xpath = "//div[text()='Recommended Disclosure']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement RecommendedDisclosure_PopupClose;

	@FindBy(xpath = "//p[text()='Multi-Asset Class Vests']//ancestor::div[@class='ant-card']//p[text()='Show All']")
	WebElement multiAssetClassVests_ShowAll;

	@FindBy(xpath = "//p[text()='Theme Based Vests']//span")
	WebElement themeBasedVests_i;

	@FindBy(xpath = "//p[contains(text(),'Vests are curated portfolios that are comprised of stocks')]")
	WebElement themeBasedVests_iPopup;

	@FindBy(xpath = "//div[text()='Vests']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement themeBasedVests_iPopupClose;

	@FindBy(xpath = "//p[text()='Theme Based Vests']//ancestor::div[@class='ant-card']//p[text()='Show All']")
	WebElement themeBasedVests_ShowAll;

	@FindBy(xpath = "//p[text()='Multi-Asset Class Vests']//ancestor::div[@class='ant-card']//div[contains(@class,'ejmjp4a76')]")
	List<WebElement> multiAssetClassVests_Cards;

	@FindBy(xpath = "//p[text()='Theme Based Vests']//ancestor::div[@class='ant-card']//div[contains(@class,'ejmjp4a76')]")
	List<WebElement> themeBasedVests_Cards;

	@FindBy(xpath = "//p[text()='Your Portfolio']//ancestor::div[@class='ant-card']//p[text()='Show All']")
	WebElement yourPortfolio_ShowAll;
	@FindBy(xpath = "(//span[contains(@class,'ehtrbr93')])[1] | //p[text()='Your Portfolio']//ancestor::div[@class='ant-card']//div[@title='filters']")
	WebElement yourPortfolio_Filter;
	@FindBy(xpath = "(//span[contains(@class,'ehtrbr93')])[1]")
	WebElement yourWatchlist_Filter;

	@FindBy(xpath = "(//p[@data-testid='filterKeySYMBOL'])[1]")
	WebElement yourPortfolio_SymbolFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeyMARKET_PRICE'])[1]")
	WebElement yourPortfolio_MarketPriceFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeyDAILY_CHANGE'])[1]")
	WebElement yourPortfolio_DailyChangeFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeyDAILY_CHANGE_PERCENT'])[1]")
	WebElement yourPortfolio_PercentageChangeFilter;
	@FindBy(xpath = "//p[@data-testid='filterKeyCURRENT_VALUE']")
	WebElement yourPortfolio_CurrentValueFilter;
	@FindBy(xpath = "//p[@data-testid='filterKeyINVESTMENT_RETURNS_CHANGE']")
	WebElement yourPortfolio_InvestmentReturn_USDFilter;
	@FindBy(xpath = "//p[@data-testid='filterKeyINVESTMENT_RETURNS_CHANGE_PERCENT']")
	WebElement yourPortfolio_InvestmentReturn_PercentageFilter;
	@FindBy(xpath = "//p[@data-testid='filterKeyVOLATILITY']")
	WebElement yourPortfolio_VolatilityFilter;

	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Portfolio')]//p[contains(@data-testid,'StockName')]")
	List<WebElement> yourPortfolio_Symbols;
	@FindBy(xpath = "//p[text()='Your Portfolio']//ancestor::div[@class='ant-card']//p[contains(@class,'eebo0bc8')]")
	List<WebElement> yourPortfolio_MarketPrices;
	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Portfolio')]//span[contains(text(),'1D')]//parent::div//div[contains(@class,'e1l0flmh0')]//span[1]")
	List<WebElement> yourPortfolio_DailyChangeUSD;
	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Portfolio')]//span[contains(text(),'1D')]//parent::div//div[contains(@class,'e1l0flmh0')]//span[2]")
	List<WebElement> yourPortfolio_DailyChangePercentage;
	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Portfolio')]//span[contains(@class,'e8zw5vw9')]")
	List<WebElement> yourPortfolio_CurrentValue;
	@FindBy(xpath = "//p[text()='Your Portfolio']//ancestor::div[@class='ant-card']//div[contains(@class,'e1l0flmh0')]//span[1]")
	List<WebElement> yourPortfolio_InvestmentReturn_USD;
	@FindBy(xpath = "//p[text()='Your Portfolio']//ancestor::div[@class='ant-card']//div[contains(@class,'e1l0flmh0')]//span[2]")
	List<WebElement> yourPortfolio_InvestmentReturn_Percentage;
	@FindBy(xpath = "//p[text()='Your Portfolio']//ancestor::div[@class='ant-card']//p[contains(@class,'eebo0bc8')]")
	List<WebElement> yourPortfolio_Volatility;

	@FindBy(xpath = "//p[text()='Watchlist']//ancestor::div[@class='ant-card']//p[text()='Show All']")
	WebElement watchlist_ShowAll;

	@FindBy(xpath = "//p[text()='Watchlist']//ancestor::div[@class='ant-card']//div[@title='filters']")
	WebElement watchlist_Filter;
	@FindBy(xpath = "(//p[@data-testid='filterKeySYMBOL'])[2]")
	WebElement watchlist_SymbolFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeyMARKET_PRICE'])[2]")
	WebElement watchlist_MarketPriceFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeyDAILY_CHANGE'])[2]")
	WebElement watchlist_DailyChangeFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeyDAILY_CHANGE_PERCENT'])[2]")
	WebElement watchlist_PercentageChangeFilter;
	@FindBy(xpath = "(//p[@data-testid='filterKeySYMBOL'])[1]")
	WebElement watchlist_SymbolFilter1;
	@FindBy(xpath = "(//p[@data-testid='filterKeyMARKET_PRICE'])[1]")
	WebElement watchlist_MarketPriceFilter1;
	@FindBy(xpath = "(//p[@data-testid='filterKeyDAILY_CHANGE'])[1]")
	WebElement watchlist_DailyChangeFilter1;
	@FindBy(xpath = "(//p[@data-testid='filterKeyDAILY_CHANGE_PERCENT'])[1]")
	WebElement watchlist_PercentageChangeFilter1;

	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Watchlist')]//p[contains(@data-testid,'StockName')]")
	List<WebElement> watchlist_Symbols;
	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Watchlist')]//span[contains(@class,'e8zw5vw9')]")
	List<WebElement> watchlist_MarketPrices;
	@FindBy(xpath = "//p[text()='Watchlist']//ancestor::div[@class='ant-card']//div[contains(@class,'e1l0flmh0')]//span[1]")
	List<WebElement> watchlist_DailyChangeUSD;
	@FindBy(xpath = "//div[contains(@aria-labelledby,'tab-Watchlist')]//span[contains(@class,'e1l0flmh1')]")
	List<WebElement> watchlist_DailyChangePercentage;

	@FindBy(xpath = "//span[text()=' Pending Stock/ETF Orders']//parent::div//parent::div//p[contains(@data-testid,'StockName')]")
	List<WebElement> pendingOrderStocksNameList;
	@FindBy(xpath = "//span[text()=' Pending Stock/ETF Orders']//parent::div//parent::div//button[text()='Cancel Order']")
	List<WebElement> pendingOrderCancelList;

	@FindBy(xpath = "//p[text()='overview']//parent::div")
	WebElement overviewTab;
	@FindBy(xpath = "//p[text()='returns']//parent::div")
	WebElement returnsTab;
	@FindBy(xpath = "//p[text()='fundamental data']//parent::div")
	WebElement fundamentalDataTab;
	@FindBy(xpath = "//p[text()='key ratios']//parent::div")
	WebElement keyRatiosTab;

	@FindBy(xpath = "//p[text()='Your Position']//ancestor::div[@class='ant-card']")
	WebElement yourPositionSection;
	@FindBy(xpath = "//p[text()='Performance']//ancestor::div[@class='ant-card']")
	WebElement performanceSection;
	@FindBy(xpath = "//p[contains(text(),'ABOUT')]//ancestor::div[@class='ant-card']")
	WebElement aboutSection;
	@FindBy(xpath = "//p[text()='Earnings']//ancestor::div[@class='ant-card']")
	WebElement earningsSection;
	@FindBy(xpath = "//p[text()='News & Articles']//ancestor::div[@class='ant-card']")
	WebElement newsSection;
	@FindBy(xpath = "//div[contains(@class,'e1huqel564')]")
	WebElement stocksSymbol;
	@FindBy(xpath = "//input[@id='react-select-stocksdesk-input']")
	WebElement searchBox;

	@FindBy(xpath = "(//p[@data-testid='CollectionTitleTop Movers']//ancestor::div[@class='ant-card-body']//a)[1]")
	WebElement firstTopMovers;

	@FindBy(xpath = "(//p[@data-testid='CollectionTitleTop Movers']//ancestor::div[@class='ant-card-body']//div[contains(@class,'ejmjp4a115')])[1]")
	WebElement firstTopMovers1;

	@FindBy(xpath = "//p[text()='Market Cap']//following-sibling::p")
	WebElement instrumentMarketCap;

	@FindBy(xpath = "//p[text()='P/E Ratio']//following-sibling::p")
	WebElement instrumentP_ERatio;

	@FindBy(xpath = "//p[text()='Volume']//following-sibling::p")
	WebElement instrumentVolume;

	@FindBy(xpath = "//p[text()='Avg Volume']//following-sibling::p")
	WebElement instrumentAVGVolume;

	@FindBy(xpath = "//p[text()='Beta']//following-sibling::p")
	WebElement instrumentBeta;

	@FindBy(xpath = "//p[contains(text(),'Current Price')]")
	WebElement instrumentCurrentPrice;

	@FindBy(xpath = "//p[text()='Current Value']//following-sibling::p")
	WebElement instrumentCurrentValueChangeInPercentage;

	@FindBy(xpath = "(//div[@class='ant-card-body'])[1]//div[@class='css-18y7tie e1huqel564'] | ((//div[@class='ant-card-body'])[1]//div)[5]")
	WebElement instrumentName;

	@FindBy(xpath = "//a[@data-testid='Crypto_0']")
	WebElement firstCrypto;

	@FindBy(xpath = "//div[@data-testid='Crypto_0']")
	WebElement firstCrypto1;

	@FindBy(xpath = "//a[@data-testid='Vanguard_0']")
	WebElement firstETF;
	@FindBy(xpath = "//div[@data-testid='Vanguard_0']")
	WebElement firstETF1;

	@FindBy(xpath = "//p[contains(text(),'MARKET Buy') and (not(contains(text(),'Cancelled'))) and (not(contains(text(),'Completed')))]//ancestor::div [contains(@class,'e554ctv3')]//div[contains(@class,'e554ctv6')]/p[(not(contains(@color,'secondary')))]")
	List<WebElement> transcactionMarketBuyVal;

	@FindBy(xpath = "//p[contains(text(),'Deposit') ]//ancestor::div [contains(@class,'e554ctv3')]//div[contains(@class,'e554ctv6')]/p[(not(contains(@color,'secondary')))]")
	List<WebElement> transcactionDepositVal;

	@FindBy(xpath = "//p[contains(text(),'MARKET Sell') and (not(contains(text(),'Cancelled'))) and (not(contains(text(),'Completed')))]//ancestor::div [contains(@class,'e554ctv3')]//div[contains(@class,'e554ctv6')]/p[(not(contains(@color,'secondary')))]")
	List<WebElement> transcactionMarketSellVal;

	@FindBy(xpath = "//p[contains(text(),'MARKET Buy') and (not(contains(text(),'Cancelled'))) and (not(contains(text(),'Completed')))]")
	List<WebElement> transcactionMarketBuyText;

	@FindBy(xpath = "//p[contains(text(),'MARKET Sell') and (not(contains(text(),'Cancelled'))) and (not(contains(text(),'Completed')))]")
	List<WebElement> transcactionMarketSellText;
	
	@FindBy(xpath = "//p[contains(text(),'successfully')]")
	WebElement successScreen;
	
	@FindBy(xpath = "//div[@class='ant-modal-title']")
	WebElement vests_iPopup;
	
	@FindBy(xpath = "//div[text()='Vests']//ancestor::div[@class='ant-modal']//span[@aria-label='close']")
	WebElement vests_iPopupClose;
	
	@FindBy(xpath = "//div[contains(@class,'SECTION_VESTS')]//a")
	List<WebElement> vests_Cards;
	
	@FindBy(xpath = "//div[text()='Portfolio' and @role='tab']")
	WebElement portfolioTab;
	
	@FindBy(xpath = "//div[text()='Watchlist' and @role='tab']")
	WebElement watchlistTab;
	
	@FindBy(xpath = "//div[text()='Orders']")
	WebElement orderTab;
	
	@FindBy(xpath = "//span[text()=' Pending Stock/ETF Orders']")
	WebElement pendingOrders;
	
	@FindBy(xpath = "//button[text()='Cancel Order']")
	WebElement cancelOrder;
	
	@FindBy(xpath = "//div[text()='No Pending Stock/ETF Orders']")
	WebElement noPendingOrder;
	
	
	
	
	
	

	public InstrumentPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	public int getTransactionMarketBuyTextCount()  {
		wait6s();
		return transcactionMarketBuyVal.size();

	}

	public ArrayList<String> getTransactionMarketBuyTextAndColor(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<>();
		List<WebElement> elements = transcactionMarketBuyVal;
		List<WebElement> elementsText = transcactionMarketBuyText;

		for (int i = 0; i < elements.size(); i++) {
			String textColor = getElementAttributeValue(elements.get(i), "color", driver);
			String textVal = getElementText(elements.get(i), driver);
			String texts = getElementText(elementsText.get(i), driver);
			printString("***********" + texts + "***********");
			testSteps.add("***********" + texts + "***********");

			testSteps.add("Verifying Market Buy Value of '" + texts + "' is <b>'darkOrange'</b> Color");
			if (textColor.equalsIgnoreCase("darkOrange")) {
				testSteps.add("Verified: Market Buy Value Color of " + texts + " is <b>'" + textColor + "'</b>");
			} else {
				testSteps.add("<b>Failed:</b> <font color=red> Market Buy Value Color of " + texts + " is <b>'"
						+ textColor + "'</b><font>");
			}
			testSteps.add("Verifying Market Buy Value of '" + texts + "' is negetive");
			if (textVal.contains("-")) {
				testSteps.add("Verified: Market Buy Value is negetive");
				testSteps.add("Market Buy Value of " + texts + " is <b>'" + textVal + "'</b>");
			} else {
				testSteps.add("<b>Failed:</b> <font color=red> Market Buy Value of " + texts + " is negetive</font>");
				testSteps.add("Market Buy Value is <b>'" + textVal + "'</b>");
			}
		}
		return testSteps;

	}

	public ArrayList<String> getTransactionMarketSellTextAndColor(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<>();
		List<WebElement> elements = transcactionMarketSellVal;
		List<WebElement> elementsText = transcactionMarketSellText;

		for (int i = 0; i < elements.size(); i++) {
			String textColor = getElementAttributeValue(elements.get(i), "color", driver);
			String textVal = getElementText(elements.get(i), driver);
			String texts = getElementText(elementsText.get(i), driver);
			printString("***********" + texts + "***********");
			testSteps.add("***********" + texts + "***********");

			testSteps.add("Verifying Market Sell Value of '" + texts + "' is <b>'Success'</b> in Color");
			if (textColor.equalsIgnoreCase("success")) {
				testSteps.add("Verified: Market Sell Value Color of " + texts + " is <b>'" + textColor + "'</b>");
			} else {
				testSteps.add("<b>Failed:</b> <font color=red> Market Sell Value Color of " + texts + " is <b>'"
						+ textColor + "'</b><font>");
			}
			testSteps.add("Verifying Market Sell Value of '" + texts + "' is positive");
			if (!textVal.contains("-")) {
				testSteps.add("Verified: Market Sell Value is positive");
				testSteps.add("Market Sell Value of " + texts + " is <b>'" + textVal + "'</b>");
			} else {
				testSteps.add("<b>Failed:</b> <font color=red> Market Sell Value of " + texts + " is positive</font>");
				testSteps.add("Market Sell Value is <b>'" + textVal + "'</b>");
			}
		}
		return testSteps;

	}

	public ArrayList<String> getTransactionDepositTextAndColor(WebDriver driver)  {
		ArrayList<String> testSteps = new ArrayList<>();
		wait6s();
		scrollDown(driver);
		List<WebElement> elements = transcactionDepositVal;
		int count = 1;
		for (int i = 0; i < elements.size(); i++) {
			String textColor = getElementAttributeValue(elements.get(i), "color", driver);
			String textVal = getElementText(elements.get(i), driver);
			printString("***********" + count + ". Deposit" + "***********");
			testSteps.add("***********" + count + ". Deposit" + "***********");

			testSteps.add("Verifying Deposit Value is <b>'Success'</b> Color");
			if (textColor.equalsIgnoreCase("success")) {
				testSteps.add("Verified: Deposit Value Color is <b>'" + textColor + "'</b>");
			} else {
				testSteps.add(
						"<b>Failed:</b> <font color=red> Deposit Value Color  is <b>'" + textColor + "'</b><font>");
			}
			testSteps.add("Verifying Deposit Value is positive");
			if (!textVal.contains("-")) {
				testSteps.add("Verified: Deposit Value is positive");
				testSteps.add("Deposit Value  is <b>'" + textVal + "'</b>");
			} else {
				testSteps.add("<b>Failed:</b> <font color=red> Deposit Value is positive</font>");
				testSteps.add("Deposit Value is <b>'" + textVal + "'</b>");
			}
			count++;
		}
		return testSteps;

	}

	public void searchStock(WebDriver driver, String stocks) {
		waitForElementVisibility(searchBox, defaultTimeForVisibility, driver);
		sendKeysToWebElement(searchBox, stocks, driver);
		wait6s();
		searchBox.sendKeys(Keys.ENTER);
	}

	public void clickingOnFirstStockOfTopMovers(WebDriver driver) {
		try {
			click(firstTopMovers1, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(firstTopMovers, driver);
		}
	}

	public void clickingOnFirstStockOfCrypto(WebDriver driver) {
		try {
			click(firstCrypto1, driver);
		} catch (Exception e) {
			click(firstCrypto, driver);
		}

	}

	public void clickingOnFirstStockOfETF(WebDriver driver) {
		try {
			click(firstETF1, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(firstETF, driver);
		}
	}

	public String getInstrumentMarketCap(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentMarketCap, driver);
			waitForElementVisibility(instrumentMarketCap, defaultTimeForVisibility, driver);
			return getElementText(instrumentMarketCap, driver).replace("$", "").replace(",", "").replace(" ", "");
		} catch (Exception e) {
			return "<font color=red>Market Cap Is Not Visible</font>";
		}

	}

	public String getInstrumentRatio(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentP_ERatio, driver);
			waitForElementVisibility(instrumentP_ERatio, defaultTimeForVisibility, driver);
			return getElementText(instrumentP_ERatio, driver);
		} catch (Exception e) {
			return "<font color=red>P/E Ratio is not visible</font>";
		}

	}

	public String getInstrumentVolume(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentVolume, driver);
			waitForElementVisibility(instrumentVolume, defaultTimeForVisibility, driver);
			return getElementText(instrumentVolume, driver);
		} catch (Exception e) {
			return "<font color=red>Volume is not visible</font>";
		}

	}

	public String getInstrumentAVGVolume(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentAVGVolume, driver);
			waitForElementVisibility(instrumentAVGVolume, defaultTimeForVisibility, driver);
			return getElementText(instrumentAVGVolume, driver);
		} catch (Exception e) {
			return "<font color=red>Average Volume is not visible</font>";
		}

	}

	public String getInstrumentBeta(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentBeta, driver);
			waitForElementVisibility(instrumentBeta, defaultTimeForVisibility, driver);
			return getElementText(instrumentBeta, driver);
		} catch (Exception e) {
			return "<font color=red>Beta is not visible</font>";
		}

	}

	public String getInstrumentCurrentPrice(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentCurrentPrice, driver);
			waitForElementVisibility(instrumentCurrentPrice, defaultTimeForVisibility, driver);
			return getElementText(instrumentCurrentPrice, driver).replace("Current Price", "").replace(":", "")
					.replace("$", "").replace(",", "").replace(" ", "").replace("CURRENTPRICE", "")
					.replace("currentprice", "");
		} catch (Exception e) {
			return "<font color=red>Current Price is not visible</font>";
		}

	}

	public String getInstrumentCurrentValueChangeInPercentage(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentCurrentValueChangeInPercentage, driver);
			waitForElementVisibility(instrumentCurrentValueChangeInPercentage, defaultTimeForVisibility, driver);
			return getElementText(instrumentCurrentValueChangeInPercentage, driver);
		} catch (Exception e) {
			return "<font color=red>Current Value Change In Percentage is not visible</font>";
		}

	}

	public String getInstrumentName(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(instrumentName, driver);
			waitForElementVisibility(instrumentName, defaultTimeForVisibility, driver);
			return getElementText(instrumentName, driver);
		} catch (Exception e) {
			return "<font color=red>instrument Name  is not visible</font>";
		}

	}

	public ArrayList<String> verifyInstrumentStockValues(WebDriver driver, String withLogin, String withoutLogin,
			String valueType) {

		ArrayList<String> list = new ArrayList<>();
		list.add("With Login '" + valueType + "': <b>" + withLogin);
		list.add("Without Login '" + valueType + "': <b>" + withoutLogin);
		if (withLogin.equalsIgnoreCase(withoutLogin)) {
			list.add("<font color=green><b>'" + valueType + "'</b> is matched</font>");
		} else {
			list.add("<font color=red><b>'" + valueType + "'</b> is not matched</font>");
		}
		return list;
	}

	// Your WatchList Sorting
	public void clickOnWatchListShowAll(WebDriver driver) {
		try {
			try {
				click(watchlist_ShowAll, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(watchlist_ShowAll, driver);
			}
		} catch (Exception e) {
			printString("Show Button is not displaying");
		}

	}

	public void clickOnWatchListFilter(WebDriver driver) {
		try {
			click(watchlist_Filter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(watchlist_Filter, driver);
		}

	}

	public void clickOnWatchListSymbolFilter(WebDriver driver) {
		try {
			try {
				click(watchlist_SymbolFilter, driver);
			} catch (Exception e) {
				click(watchlist_SymbolFilter1, driver);
			}

		} catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(watchlist_SymbolFilter, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(watchlist_SymbolFilter1, driver);
			}

		}

	}

	public ArrayList<String> getWatchListSymbolsList(WebDriver driver) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < watchlist_Symbols.size(); i++) {
//				printString(watchlist_Symbols.get(i).getText());
			list.add(watchlist_Symbols.get(i).getText());
		}

		return list;
	}

	public void clickOnWatchListMarketPriceFilter(WebDriver driver) {
		try {
			try {
				click(watchlist_MarketPriceFilter, driver);
			} catch (Exception e) {
				click(watchlist_MarketPriceFilter1, driver);
			}

		} catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(watchlist_MarketPriceFilter, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(watchlist_MarketPriceFilter1, driver);
			}

		}

	}

	public ArrayList<Double> getWatchListMarketPriceList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < watchlist_MarketPrices.size(); i++) {
//				printString(watchlist_MarketPrices.get(i).getText());
			list.add(Double.parseDouble(
					watchlist_MarketPrices.get(i).getText().replace("$", "").replace(",", "").replace("-", "0.00")));
		}

		return list;
	}

	public void clickOnWatchListDailyChange_USDFilter(WebDriver driver) {
		try {
			try {
				click(watchlist_DailyChangeFilter, driver);
			} catch (Exception e) {
				click(watchlist_DailyChangeFilter1, driver);
			}

		} catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(watchlist_DailyChangeFilter, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(watchlist_DailyChangeFilter1, driver);
			}

		}

	}

	public ArrayList<Double> getWatchListDailyChange_USDList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < watchlist_DailyChangeUSD.size(); i++) {
//				printString(watchlist_DailyChangeUSD.get(i).getText());
			list.add(Double.parseDouble(
					watchlist_DailyChangeUSD.get(i).getText().replace("$", "").replace("+", "").replace(",", "")));
		}

		return list;
	}

	public void clickOnWatchListDailyChange_PerFilter(WebDriver driver) {
		try {
			try {
				click(watchlist_PercentageChangeFilter, driver);
			} catch (Exception e) {
				click(watchlist_PercentageChangeFilter1, driver);
			}

		} catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(watchlist_PercentageChangeFilter, driver);
			} catch (Exception e1) {
				clickUsingJavascriptExecutor(watchlist_PercentageChangeFilter, driver);
			}

		}

	}

	public ArrayList<Double> getWatchListDailyChange_PerList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < watchlist_DailyChangePercentage.size(); i++) {
//				printString(watchlist_DailyChangePercentage.get(i).getText());
			list.add(Double.parseDouble(watchlist_DailyChangePercentage.get(i).getText().replace("%", "")
					.replace("+", "").replace("(", "").replace(")", "").replace(",", "")));
		}

		return list;
	}

	// Your Portfolio Sorting
	public void clickOnyourPortfolioShowAll(WebDriver driver) {
		try {
			try {
				click(yourPortfolio_ShowAll, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(yourPortfolio_ShowAll, driver);
			}
		} catch (Exception e) {
			printString("Show Button is not displaying");
		}

	}

	public void clickOnyourPortfolioFilter(WebDriver driver) {
		try {
			click(yourPortfolio_Filter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_Filter, driver);
		}

	}
	
	public void clickOnyourWatchlistFilter(WebDriver driver) {
		try {
			click(yourWatchlist_Filter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourWatchlist_Filter, driver);
		}

	}

	public void clickOnyourPortfolioSymbolFilter(WebDriver driver) {
		try {
			click(yourPortfolio_SymbolFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_SymbolFilter, driver);
		}

	}

	public ArrayList<String> getYourPortfolioSymbolsList(WebDriver driver) {
		
		ArrayList<String> list = new ArrayList<String>();
//		wait =  new WebDriverWait(driver, Long.parseLong("15000"));
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@aria-labelledby='rc-tabs-2-tab-Portfolio']//p[contains(@data-testid,'StockName')]")));
//		int SymbolCounts = yourPortfolio_Symbols.size();
		wait3s();
		System.out.println("Count: "+yourPortfolio_Symbols.size());
		for (int i = 0; i < yourPortfolio_Symbols.size(); i++) {
			printString(yourPortfolio_Symbols.get(i).getText());
			list.add(yourPortfolio_Symbols.get(i).getText());
		}

		return list;
	}

	public void clickOnyourPortfolioMarketPriceFilter(WebDriver driver) {
		try {
			click(yourPortfolio_MarketPriceFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_MarketPriceFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioMarketPriceList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_MarketPrices.size(); i++) {
//			printString(yourPortfolio_MarketPrices.get(i).getText());
			list.add(Double.parseDouble(yourPortfolio_MarketPrices.get(i).getText().replace("$", "").replace(",", "")
					.replace("-", "0.00")));
		}

		return list;
	}

	public void clickOnyourPortfolioDailyChange_USDFilter(WebDriver driver) {
		try {
			click(yourPortfolio_DailyChangeFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_DailyChangeFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioDailyChange_USDList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_DailyChangeUSD.size(); i++) {
//			printString(yourPortfolio_DailyChangeUSD.get(i).getText());
			list.add(Double.parseDouble(
					yourPortfolio_DailyChangeUSD.get(i).getText().replace("$", "").replace("+", "").replace(",", "")));
		}

		return list;
	}

	public void clickOnyourPortfolioDailyChange_PerFilter(WebDriver driver) {
		try {
			click(yourPortfolio_PercentageChangeFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_PercentageChangeFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioDailyChange_PerList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_DailyChangePercentage.size(); i++) {
//			printString(yourPortfolio_DailyChangePercentage.get(i).getText());
			list.add(Double.parseDouble(yourPortfolio_DailyChangePercentage.get(i).getText().replace("%", "")
					.replace("+", "").replace("(", "").replace(")", "").replace(",", "")));
		}

		return list;
	}

	public void clickOnyourPortfolioCurrentValueFilter(WebDriver driver) {
		try {
			click(yourPortfolio_CurrentValueFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_CurrentValueFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioCurrentValueList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_CurrentValue.size(); i++) {
//			printString(yourPortfolio_CurrentValue.get(i).getText());
			list.add(Double.parseDouble(yourPortfolio_CurrentValue.get(i).getText().replace("$", "").replace("+", "")
					.replace(",", "").replace(")", "").replace("-", "0.00")));
		}

		return list;
	}

	public void clickOnyourPortfolioinvestmentReturn_USDFilter(WebDriver driver) {
		try {
			click(yourPortfolio_InvestmentReturn_USDFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_InvestmentReturn_USDFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioInvestmentReturn_USDList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_InvestmentReturn_USD.size(); i++) {
//			printString(yourPortfolio_InvestmentReturn_USD.get(i).getText());
			list.add(Double.parseDouble(yourPortfolio_InvestmentReturn_USD.get(i).getText().replace("$", "")
					.replace("+", "").replace(",", "")));
		}

		return list;
	}

	public void clickOnyourPortfolioInvestmentReturn_PerFilter(WebDriver driver) {
		try {
			click(yourPortfolio_InvestmentReturn_PercentageFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_InvestmentReturn_PercentageFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioInvestmentReturn_PerList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_InvestmentReturn_Percentage.size(); i++) {
//			printString(yourPortfolio_InvestmentReturn_Percentage.get(i).getText());
			list.add(Double.parseDouble(yourPortfolio_InvestmentReturn_Percentage.get(i).getText().replace("%", "")
					.replace("+", "").replace("(", "").replace(")", "").replace(",", "")));
		}

		return list;
	}

	public void clickOnyourPortfolioVolatilityFilter(WebDriver driver) {
		try {
			click(yourPortfolio_VolatilityFilter, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(yourPortfolio_VolatilityFilter, driver);
		}

	}

	public ArrayList<Double> getYourPortfolioVolatilityList(WebDriver driver) {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < yourPortfolio_Volatility.size(); i++) {
//			printString(yourPortfolio_Volatility.get(i).getText());
			list.add(Double.parseDouble(
					yourPortfolio_Volatility.get(i).getText().replace("%", "").replace("+", "").replace(",", "")));
		}

		return list;
	}

	public boolean isSellInstrumentPageDisplaying(WebDriver driver) {
		return isElementDisplayed(sellInstrumentPage, driver);
	}

	public String getInvalidCashErrorMessage(WebDriver driver) {
		return getElementText(InvalidCashError, driver);
	}

	public String getNotEnoughCashErrorMessage(WebDriver driver) {
		return getElementText(notEnoughCashError, driver);
	}

	public ArrayList<String> clickOnErrorMessageLowStopPricePopupCloseButton(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		try {
			waitForElementVisibility(errorMessageLowStopPricePopupCloseBtn, "60", driver);
			try {
				click(errorMessageLowStopPricePopupCloseBtn, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(errorMessageLowStopPricePopupCloseBtn, driver);
			}
		} catch (Exception e) {
			testSteps.add(e.toString());
			e.printStackTrace();
			printString("Error Message Low Stop Price Popup Close Button Not Shown", driver);
		}
		return testSteps;
	}

	public float getStopOrderMarketValue(WebDriver driver) {
		System.out.print(getElementText(stopOrderMarketValue, driver));
		return Float.parseFloat(getElementText(stopOrderMarketValue, driver).replace("$", "").replace(",", "").trim());
	}

	public boolean errorMessageLowStopPriceIsShowing(WebDriver driver) {
		waitForElementVisibility(errorMessageLowStopPrice, "60", driver);
		return isElementDisplayed(errorMessageLowStopPrice, driver);
	}

	public boolean geterrorMessageLowStopPriceBody(WebDriver driver) {
		waitForElementVisibility(errorMessageLowStopPriceContent, "60", driver);
		return isElementDisplayed(errorMessageLowStopPriceContent, driver);
	}

	public float getEstimatedProceedsValue(WebDriver driver) {
		System.out.print(getElementAttributeValue(EstimatedProceedsValue, "value", driver));
		return Float.parseFloat(getElementAttributeValue(EstimatedProceedsValue, "value", driver));
	}

	public void enterEstimatedProceedsValue(Double Val, WebDriver driver) {
		waitForElementVisibility(EstimatedProceedsValue, "60", driver);
		type(EstimatedProceedsValue, String.valueOf(Val), driver);
	}

	public float getMarketValue(WebDriver driver, String text) {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath("//p[text()='"+text+"']//..//..//p[contains(text(),'$')]"));
			System.out.print(getElementText(ele, driver));
			return Float.parseFloat(getElementText(ele, driver).replace("$", "").replace(",", "").trim());
		}catch (Exception e) {
			ele = driver.findElement(By.xpath("//p[text()='"+text+"']//..//..//p[contains(text(),'$')]"));
			System.out.print(getElementText(ele, driver));
			return Float.parseFloat(getElementText(ele, driver).replace("$", "").replace(",", "").trim());
		}
		
	}
	

	public float getEstimatedCostValue(WebDriver driver) {
		System.out.print(getElementAttributeValue(EstimatedCostValue, "value", driver));
		return Float.parseFloat(getElementAttributeValue(EstimatedCostValue, "value", driver));
	}

	public void clickOnEstimatedCostValue(WebDriver driver) {
		click(EstimatedCostValue, driver);
	}

	public void ClickOnPopUpGotItButton(WebDriver driver) {
//		 String powerBuy =  getBuyingPowerAmount(,driver);
//		 System.out.println(powerBuy,driver);

		try {
			try {
				waitForElementVisibility(WarningPopUpGotItButton, "60", driver);
				waitForElementClickable(WarningPopUpGotItButton, "60", driver);
				click(WarningPopUpGotItButton, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(WarningPopUpGotItButton, driver);
			}
		} catch (Exception e) {
			printString("No PopUp Shown", driver);
		}

	}

	public String getBuyingPowerAmount(WebDriver driver) {
		waitForElementVisibility(BuyingPower, "30", driver);
		return getElementText(BuyingPower, driver).replace("$", "").trim();
	}

	public ArrayList<String> ClosePendingOrders(WebDriver driver)  {
		ArrayList<String> testSteps = new ArrayList<String>();

		click(orderTab, driver);
		click(pendingOrders,driver);
		try {
			waitForElementVisibility(noPendingOrder, defaultTimeForVisibility, driver);
			testSteps.add("<b> --> </b> There is no pending order ");
		}catch (Exception e) {
			testSteps.add("<b>***************Cancelling All Pending Orders***************</b>");
			testSteps.addAll(CancelPendingOrders(driver));
		}
		return testSteps;
	}

	public void VerifyInvestedAmount(float BeforeInvestingAmout, double ExpectedVal, WebDriver driver) {
		getRefreshWebPage(driver);
		float FractionalAfterInvestedAmount = getInvestedAmountValue(driver);
		System.out.print("AfterInvestedAmount: " + String.valueOf(FractionalAfterInvestedAmount)
				+ "\n BeforeInvestedAmount: " + String.valueOf(BeforeInvestingAmout) + "\n" + "\n ExpectedVal: "
				+ String.valueOf(ExpectedVal) + "\n");
		if (isMarketClose(driver)) {
			assertEquals(BeforeInvestingAmout, FractionalAfterInvestedAmount);
		} else {
			assertNotEquals(BeforeInvestingAmout + ExpectedVal, FractionalAfterInvestedAmount);
		}
	}

	public void VerifyPendingShares(double ExpectedVal, WebDriver driver) {

		try {
			waitForElementVisibility(driver.findElement(By.xpath(
					"//p[text()='Pending Orders']//..//..//..//..//..//p[contains(text(),'" + ExpectedVal + "')]")),
					"60", driver);
		} catch (Exception e) {
			System.out.print("Pending Order is not Present");
		}
	}

	public float getMarketShares(WebDriver driver) {
		try {
			System.out.print(getElementAttributeValue(SharesValue, "value", driver));
			return Float.parseFloat(getElementAttributeValue(SharesValue, "value", driver));
		} catch (Exception e) {
			System.out.print(getElementAttributeValue(SharesValue2, "value", driver));
			return Float.parseFloat(getElementAttributeValue(SharesValue2, "value", driver));
		}

	}

	public void ClosePopUp(WebDriver driver) {
		waitForElementVisibility(PopUpCLoseButton, "30", driver);
		waitForElementClickable(PopUpCLoseButton, "30", driver);
		scrollIntoViewSmoothly(PopUpCLoseButton, driver);
		waitTime(3000, driver);
		click(PopUpCLoseButton, driver);
	}

	public int getCountOfPendingOrders(WebDriver driver) {
		int NumberOfOrders = driver.findElements(By.xpath(
				"//span[text()=' Pending Stock/ETF Orders']//parent::div//parent::div//div[contains(@class,'e8zw5vw0')]"))
				.size();
		System.out.print("\n\nNumber Of Pending Orders: " + NumberOfOrders + "\n\n");
		return NumberOfOrders;

	}

	public Boolean isMarketClose(WebDriver driver) {

		waitForElementVisibility(OpenTimmer, "60", driver);
		String Text = getElementText(OpenTimmer, driver);
		if (Text.contains("opens")) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<String> getPendingOrderStocksNameList(WebDriver driver) {
		ArrayList<String> stokesName = new ArrayList<String>();
		for (int i = 0; i < pendingOrderStocksNameList.size(); i++) {
			stokesName.add(pendingOrderStocksNameList.get(i).getText());
		}
		return stokesName;
	}

	public ArrayList<String> CancelPendingOrders(WebDriver driver)  {

		ArrayList<String> testSteps = new ArrayList<String>();
		wait3s();
		int beforeCount = getCountOfPendingOrders(driver);
		int cancelCount = pendingOrderCancelList.size();
		testSteps.add("Pending Orders: <b>" + cancelCount);
		ArrayList<String> stocksName = getPendingOrderStocksNameList(driver);
		int count = 1;
		for (int i = 0; i < cancelCount; i++) {

			testSteps.add("<b>" + (count) + ".</b> Deleting <b>'" + stocksName.get(i) + "'</b> Pending Order");
			waitUntilElementDisplayed(pendingOrderCancelList.get(0), driver);
			scrollIntoViewSmoothly(pendingOrderCancelList.get(0), driver);
			try {
				click(pendingOrderCancelList.get(0), driver);
				testSteps.add("Clicking <b>'" + stocksName.get(i) + "'</b> cancel button");
			} catch (Exception e) {
				clickUsingJavascriptExecutor(pendingOrderCancelList.get(0), driver);
			}
			waitForElementClickable(CancelPendingOrderYes, "60", driver);
			click(CancelPendingOrderYes, driver);
			testSteps.add("Clicking Confirmation Popup 'Yes' Button");
			wait6s();
			int afterCount = getCountOfPendingOrders(driver);
			assertTrue(beforeCount > afterCount, stocksName.get(i) + " not deleted successfully");
			testSteps.add("<b>'" + stocksName.get(i) + "' </b> Deleted Successfully");
			count++;

		}
		return testSteps;

	}

	public void clickOnAnyStockFromPortfolio(WebDriver driver) {
		click(stock, driver);
	}

	public boolean isSellButtonDisplay(WebDriver driver) {
		waitForElementVisibility(btnSell, "15", driver);
		return isElementDisplayed(btnSell, driver);
	}

	public void clickOnSellButton(WebDriver driver) {
		try {
			click(btnSell, driver);
		}catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(btnSell, driver);
			}catch (Exception e1) {
				click(AddFunds_Popup, driver);
			}
			
		}
		
	}

	public float getInvestedAmountValue(WebDriver driver) {
		System.out.print(getElementText(InvestedAmount, driver));
		return Float.parseFloat(getElementText(InvestedAmount, driver).replace("$", "").replace(",", "").trim());
	}

	public void enterShareValue(WebDriver driver) {
		Object[][] dataArr = getData("testData", "TestData", driver);
		printString("tesData Size : " + dataArr.length, driver);
		String share = dataArr[0][7].toString();
		printString(share, driver);
		waitForElementVisibility(sharesInput, "30", driver);
		type(sharesInput, share, driver);
	}

	public void enterShareValue(int Val, WebDriver driver) {
		System.out.println(Val);
		waitForElementVisibility(sharesInput, "30", driver);
		sharesInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(sharesInput, String.valueOf(Val), driver);
	}

	public void enterShareValue(double Val, WebDriver driver) {
		System.out.println(Val);
		waitForElementVisibility(sharesInput, "30", driver);
		sharesInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(sharesInput, String.valueOf(Val), driver);
	}

	public String getAmount(WebDriver driver) {
		return getElementAttributeValue(amount, "value", driver);
	}

	public boolean isAmountFieldAutoPopulate(WebDriver driver) {
		printString("Auto Populated Amount: " + getAmount(driver), driver);
		if (!getAmount(driver).equals("")) {
			return true;
		}
		return false;
	}

	public void clickOnReviewOrderButton(WebDriver driver) {
		waitForElementVisibility(btnReviewOrder, "15", driver);
		click(btnReviewOrder, driver);
	}

	public void clickOnPlaceSellOrderButton(WebDriver driver) {
		waitForElementVisibility(btnPlaceSellOrder, "15", driver);
		click(btnPlaceSellOrder, driver);
	}

	public boolean verifyInstrumentsTableIsShowing(WebDriver driver) {
		return isElementDisplayed(tableInstruments, driver);
	}

	public boolean verifyInstrumentDetailPageIsShowing(WebDriver driver)  {
		try {
			waitForElementVisibility(modalSignupLogin, "30", driver);
			return false;
		} catch (Exception e) {
			waitForElementVisibility(instrumentDetailsPage, "30", driver);
			return true;
		}
	}

	public float getSharesInput(WebDriver driver) {
		System.out.print(getElementAttributeValue(sharesInput, "value", driver));
		return Float.parseFloat(getElementAttributeValue(sharesInput, "value", driver));
	}

	public void clickOnInvestNowBtn(WebDriver driver) {
		waitForElementClickable(btnInvestNow, "60", driver);
		click(btnInvestNow, driver);
	}

	public boolean verifyLoginSignupModalIsDisplaying(WebDriver driver) {
		waitForElementVisibility(modalSignupLogin, "30", driver);
		return isElementDisplayed(modalSignupLogin, driver);
	}

	public void clickOnCloseModalButton(WebDriver driver) {
		try {
			click(btnCloseModal, driver);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void ClickExtraPopUpWatchlist(WebDriver driver) {
		try {
			try {
				click(extraPOpUp, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(extraPOpUp, driver);
			}

		} catch (Exception e) {
			System.out.print("No PopUp Shown");
		}
	}

	public ArrayList<String> clickOnAddToWatchList(WebDriver driver) {
		waitTime(5);
		ArrayList<String> testSteps = new ArrayList<String>();
		try {
			ClickExtraPopUpWatchlist(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (isElementDisplayed(addedToWatchListMessage, driver)) {
			testSteps.add("Stock has already been added in watchlist");
		} else {
			click(btnAddToWatchList2, driver);
		}
		return testSteps;

	}

	public boolean isOverviewTabIsDisplaying(WebDriver driver) {
		return isElementDisplayed(instrumentDetailsOverviewTab, driver);
	}

	public void clickOnOverviewTab(WebDriver driver) {
		click(instrumentDetailsOverviewTab, driver);
	}

	public boolean isReturnTabIsDisplaying(WebDriver driver) {
		return isElementDisplayed(instrumentDetailsReturnsTab, driver);
	}

	public void clickOnReturnTab(WebDriver driver) {
		click(instrumentDetailsReturnsTab, driver);
	}

	public boolean isFundamentalDataTabIsDisplaying(WebDriver driver) {
		return isElementDisplayed(instrumentDetailsFundamentalDataTab, driver);
	}

	public void clickOnFundamentalDataTab(WebDriver driver) {
		click(instrumentDetailsFundamentalDataTab, driver);
	}

	public boolean isKeyRatioTabIsDisplaying(WebDriver driver) {
		return isElementDisplayed(instrumentDetailsKeyRatiosTab, driver);
	}

	public void clickOnKeyRatioTab(WebDriver driver) {
		click(instrumentDetailsKeyRatiosTab, driver);
	}

	public boolean isTabDetailShowing(WebDriver driver) {
		return isElementDisplayed(overViewTabDetails, driver);
	}

	public boolean isAddedToWatchListDisplaying(WebDriver driver) {
		try {
			ClickExtraPopUpWatchlist(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			try {

				scrollToElement(addToWatchListMessage, driver);
				waitForElementVisibility(addedToWatchListMessage, "30", driver);
				return isElementDisplayed(addedToWatchListMessage, driver);

			} catch (Exception e) {
				scrollToElement(btnAddToWatchList2, driver);
				waitForElementVisibility(btnAddToWatchList2, "30", driver);
				return isElementDisplayed(btnAddToWatchList2, driver);
			}

		} catch (Exception e) {
			scrollToElement(addToWatchListMessage, driver);
			waitForElementVisibility(addToWatchListMessage, "30", driver);
			return isElementDisplayed(addToWatchListMessage, driver);
		}
	}

	public void clickOnBuyButton(WebDriver driver) {
		waitTime(2000, driver);
		try {
			click(btnBUY, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(btnBUY, driver);
		}

	}

	public boolean isBuyInstrumentPageDisplaying(WebDriver driver) {
		return isElementDisplayed(buyInstrumentPage, driver);
	}

	public ArrayList<String> getInstrumentNameList(WebDriver driver) {
		ArrayList<String> names = new ArrayList<>();
		for (int i = 1; i <= instrumentTableRows.size(); i++) {
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[2]")),
					driver);
			names.add(string);
		}
		return names;
	}

	public void enterEstimatedCostValue(Double Val, WebDriver driver) {
		waitForElementVisibility(EstimatedCostValue, "60", driver);
		type(EstimatedCostValue, String.valueOf(Val), driver);
	}

	public void clickOnNameCellInstrumentTableHeader(WebDriver driver) {
		try {
			click(nameCellTableHeader, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(nameCellTableHeader, driver);
		}

	}

	public ArrayList<String> getInstrumentSymbolList(WebDriver driver) {
		ArrayList<String> symbol = new ArrayList<>();
		for (int i = 1; i <= instrumentTableRows.size(); i++) {
			JavascriptExecutor exec = (JavascriptExecutor) driver;
			exec.executeScript("localStorage.setItem('AF_SESSION','" + System.currentTimeMillis() + "');");
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[3]")),
					driver);
			symbol.add(string);
			printString(string);
		}
		return symbol;
	}

	public ArrayList<String> getSortedList(ArrayList<String> symbol) {
		Collections.sort(symbol);
		return symbol;
	}

	public ArrayList<Double> getSortedDoubleList(ArrayList<Double> symbol) {
		Collections.sort(symbol);
		return symbol;
	}

	public ArrayList<Double> getReverseSortedDoubleList(ArrayList<Double> symbol) {
		Collections.sort(symbol, Collections.reverseOrder());
		return symbol;
	}

	public ArrayList<String> getReverseSortedList(ArrayList<String> symbol) {
		Collections.sort(symbol, Collections.reverseOrder());
		return symbol;
	}

	public void clickOnSymbolCellInstrumentTableHeader(WebDriver driver) {
		try {
			click(symbolCellTableHeader, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(symbolCellTableHeader, driver);
		}

	}

	public ArrayList<String> getInstrumentPriceList(WebDriver driver) {
		ArrayList<String> price = new ArrayList<>();
		for (int i = 1; i <= instrumentTableRows.size(); i++) {
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[4]")),
					driver);
			price.add(string);
		}
		return price;
	}

	public ArrayList<Double> getDoubleInstrumentPriceList(WebDriver driver) {
		ArrayList<Double> price = new ArrayList<>();
		for (int i = 1; i <= instrumentTableRows.size(); i++) {
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[4]")),
					driver).replace("-", "").replace("%", "").replace(",", "").replace("$", "");
			price.add(Double.parseDouble(string));
		}
		return price;
	}

	public void clickOnPriceCellInstrumentTableHeader(WebDriver driver) {
		try {
			click(priceCellTableHeader, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(priceCellTableHeader, driver);
		}
		
	}

	public ArrayList<String> getInstrumentDailyChangeList(WebDriver driver) {
		ArrayList<String> change = new ArrayList<>();
		for (int i = 2; i <= instrumentTableRows.size(); i++) {
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[5]")),
					driver);
			change.add(string);
		}
		return change;
	}

	public void clickOnChangeCellInstrumentTableHeader(WebDriver driver) {
		click(dailyChangeCellTableHeader, driver);
	}

	public ArrayList<String> getInstrumentMarketCapList(WebDriver driver) {
		ArrayList<String> capital = new ArrayList<>();
		for (int i = 2; i <= instrumentTableRows.size(); i++) {
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[6]")),
					driver);
			capital.add(string);
		}
		return capital;
	}

	public void clickOnMarketCapCellInstrumentTableHeader(WebDriver driver) {
		click(marketCapCellTableHeader, driver);
	}

	public ArrayList<String> getInstrumentPERatioList(WebDriver driver) {
		ArrayList<String> PERatio = new ArrayList<>();
		for (int i = 2; i <= instrumentTableRows.size(); i++) {
			String string = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[7]")),
					driver);
			PERatio.add(string);
		}
		return PERatio;
	}

	public void clickOnPERatioCellInstrumentTableHeader(WebDriver driver) {
		click(peRationCellTableHeader, driver);
	}

	public int getInstrumentTableRowsSize() {
		return instrumentTableRows.size();
	}

	public void clickOnWatchListIconOf1stInstrument(WebDriver driver) {
		click(firstInstrumentWatchListIcon, driver);
	}

	public void clickOnFirstInstrument(WebDriver driver) throws InterruptedException {
		waitfor5sec();
		click(instrumentTableRows.get(1), driver);
	}

	public void exploreTopMovers(WebDriver driver) {
		scrollIntoViewSmoothly(topMoversLabel, driver);
		waitTime(3000, driver);
	}

	public void clickOnTopMoversShowAllButton(WebDriver driver) {
		click(topeMoversShowAll, driver);
	}

	public void expandAllCategories(WebDriver driver) {
		for (int i = 1; i < categoryTitles.size(); i++) {
			scrollIntoViewSmoothly(categoryTitles.get(i), driver);
			waitTime(2000, driver);
			click(categoryTitles.get(i), driver);

		}
	}

	public void selectSubCategories(WebDriver driver, int start, int end, String category) {
		for (int i = start; i <= end; i++) {
			scrollIntoViewSmoothly(
					driver.findElement(By.xpath(
							"//p[text()='" + category + "']//parent::div//following-sibling::div//p[" + i + "]")),
					driver);
			waitTime(2000, driver);
			click(driver.findElement(
					By.xpath("//p[text()='" + category + "']//parent::div//following-sibling::div//p[" + i + "]")),
					driver);

		}
	}

	public void selectSubCategories(WebDriver driver) {
		for (int i = 1; i < categoryTitles.size(); i++) {
			scrollIntoViewSmoothly(categoryTitles.get(i), driver);
			waitTime(2000, driver);
			click(categoryTitles.get(i), driver);
			List<WebElement> subCategoriesElements = Allcategories;
			for (int y = 0; y < subCategoriesElements.size(); y++) {
				click(subCategoriesElements.get(y), driver);
			}
			waitTime(1000, driver);
		}
	}

	public void selectAllCategories(WebDriver driver) {
		for (int i = 1; i < categoryTitles.size(); i++) {
			scrollIntoViewSmoothly(categoryTitles.get(i), driver);
			waitTime(2000, driver);
			click(categoryTitles.get(i), driver);
			List<WebElement> subCategoriesElements = Allcategories;
			for (int y = 0; y < subCategoriesElements.size(); y++) {
				click(subCategoriesElements.get(y), driver);
			}
			waitTime(1000, driver);
		}
	}

	public int getStockListSize(WebDriver driver) {
		return stocksList.size();
	}

	public String getStockNameAtPosition(int position, WebDriver driver) {
		return getElementText(
				driver.findElement(
						By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + position + "]//td[2]")),
				driver);
	}

	public String getStockSymbolAtPosition(int position, WebDriver driver) {
		return getElementText(
				driver.findElement(
						By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + position + "]//td[3]")),
				driver);
	}

	public String getStockPriceAtPosition(int position, WebDriver driver) {
		return getElementText(
				driver.findElement(
						By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + position + "]//td[4]")),
				driver);
	}

	public String getStockDailyChangeAtPosition(int position, WebDriver driver) {
		return getElementText(
				driver.findElement(
						By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + position + "]//td[5]")),
				driver);
	}

	public void clickOnStockAtPosition(int position, WebDriver driver) {
		scrollIntoViewSmoothly(stocksList.get(position - 1), driver);
		waitTime(1500, driver);
		click(stocksList.get(position - 1), driver);
	}

	public boolean verifyStockNameOnDetailsPageShowing(WebDriver driver) {
		return isElementDisplayed(stockNameOnDetailsPage, driver);
	}

	public boolean verifyStockNamesShowing(WebDriver driver)  {
		wait3s();
		waitForElementVisibility(stockNamesPage, "60", driver);
		return isElementDisplayed(stockNamesPage, driver);
	}

	public boolean verifySignalsPageisShowing(WebDriver driver)  {
		wait3s();
		waitForElementVisibility(signalsPage, "30", driver);
		return isElementDisplayed(signalsPage, driver);
	}

	public String getStockNameOnDetailsPage(WebDriver driver) {
		return getElementText(stockNameOnDetailsPage, driver);
	}

	public boolean verifyStockSymbolOnDetailsPageShowing(WebDriver driver) {
		return isElementDisplayed(stockSymbolOnDetailsPage, driver);
	}

	public String getStockSymbolOnDetailsPage(WebDriver driver) {
		return getElementText(stockSymbolOnDetailsPage, driver);
	}

	public boolean verifyStockPriceOnDetailsPageShowing(WebDriver driver) {
		return isElementDisplayed(stockPriceOnDetailsPage, driver);
	}

	public String getStockPriceOnDetailsPage(WebDriver driver) {
		return getElementText(stockPriceOnDetailsPage, driver);
	}

	public boolean verifyStockDailyChangeOnDetailsPageShowing(WebDriver driver) {
		return isElementDisplayed(stockDailyChangeOnDetailsPage, driver);
	}

	public String getStockDailyChangeOnDetailsPage(WebDriver driver) {
		String changeString = getElementText(stockDailyChangeOnDetailsPage, driver);
		return changeString.substring(changeString.indexOf("(") + 1, changeString.indexOf(")"));
	}

	public void loadInstrumentDetailPageBySymbol(String symbol, WebDriver driver) {
		getRefreshWebPage(driver);
		waitTime(3000, driver);
		String stockUrl = PropertiesReader.getPropertyValue(env + "_" + "AppURL");
		stockUrl += "/instrument/" + symbol;
		driver.get(stockUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")),
				TimeUnit.SECONDS);
	}

	public Map<Integer, ModelStockData> getStocksListData(WebDriver driver) {
		Map<Integer, ModelStockData> dataMap = new HashMap<>();
		// for (int i=1;i<=stocksList.size(,driver);i++)
		for (int i = 1; i <= stocksList.size(); i++) {
			scrollIntoViewSmoothly(stocksList.get(i - 1), driver);
			String name = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[2]")),
					driver);
			String symbol = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[3]")),
					driver);
			String price = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[4]")),
					driver);
			String dailyChange = getElementText(
					driver.findElement(
							By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + i + "]//td[5]")),
					driver);
			dataMap.put(i, new ModelStockData(name, symbol, price, dailyChange));
		}
		return dataMap;
	}

	public Map<Integer, ModelStockData> getFirstStockListData(WebDriver driver) {
		Map<Integer, ModelStockData> dataMap = new HashMap<>();
		// for (int i=1;i<=stocksList.size(,driver);i++)
		scrollIntoViewSmoothly(stocksList.get(0), driver);
		String name = getElementText(driver.findElement(
				By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + 1 + "]//td[2]")), driver);
		String symbol = getElementText(driver.findElement(
				By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + 1 + "]//td[3]")), driver);
		String price = getElementText(driver.findElement(
				By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + 1 + "]//td[4]")), driver);
		String dailyChange = getElementText(driver.findElement(
				By.xpath("((//table[contains(@class,'css-8atqhb')])[1]/tbody//tr)[" + 1 + "]//td[5]")), driver);
		dataMap.put(1, new ModelStockData(name, symbol, price, dailyChange));
		return dataMap;
	}

	public boolean verifyAddToWathclistButtonDisplaying(WebDriver driver) {
		return isElementDisplayed(btnAddToWatchList, driver);
	}

	public boolean verifyBuyButtonIsDisplaying(WebDriver driver) {
		return isElementDisplayed(btnBUY, driver);
	}

	public String getYourPositionShare(WebDriver driver) {
		try {
			return getElementText(YourPositionShare, driver);
		} catch (Exception e) {
			return "0";
		}

	}

	public void clickOnOrderDropDownBtn(WebDriver driver) {
		try {
			waitForElementVisibility(OrderDorpDownBtn, "60", driver);
			try {
				click(OrderDorpDownBtn, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(OrderDorpDownBtn, driver);
			}
		} catch (Exception e) {
			System.out.print("Order Dorp Down Button Not Shown");
		}
	}

	public void clickOnLimitOrderOption(WebDriver driver) {
		try {
			waitForElementVisibility(LimitOrderDorpDown, "60", driver);
			try {
				click(LimitOrderDorpDown, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(LimitOrderDorpDown, driver);
			}
		} catch (Exception e) {
			System.out.print("Limit Order Dorp Down Not Shown");
		}
	}

	public boolean verifyLimitOrderPageIsShowing(WebDriver driver) {
		return isElementDisplayed(LimitOrderPage, driver);
	}

	public boolean errorMessageFractionalShareIsShowing(WebDriver driver) {
		return isElementDisplayed(errorMessageFractionalShare, driver);
	}

	public void enterLimitPriceValue(int Val, WebDriver driver) {
		waitForElementVisibility(limitPriceInput, "60", driver);
		type(limitPriceInput, String.valueOf(Val), driver);
	}

	public void enterBuyShareValue(int Val, WebDriver driver) {
		System.out.println(Val);
		waitForElementVisibility(sharesInput, "30", driver);
		sharesInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waitTime(3000, driver);
		type(sharesInput, String.valueOf(Val), driver);
	}

	public void clickOnOverviewButton(WebDriver driver) {
		try {
			click(overviewBtn, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(overviewBtn, driver);
		}
		
	}

	public boolean verifyOverviewPageIsShowing(WebDriver driver) {
		return isElementDisplayed(overviewPage, driver);
	}

	public void clickOnReturnsButton(WebDriver driver) {
		click(returnsBtn, driver);
	}

	public boolean verifyReturnsPageIsShowing(WebDriver driver) {
		return isElementDisplayed(returnsPage, driver);
	}

	public void clickOnFundamentalDataButton(WebDriver driver) {
		click(fundamentalDataBtn, driver);
	}

	public boolean verifyFundamentalDataPageIsShowing(WebDriver driver) {
		return isElementDisplayed(fundamentalDataPage, driver);
	}

	public void clickOnBalanceSheetButton(WebDriver driver) {
		click(balanceSheetBtn, driver);
	}

	public boolean verifyBalanceSheetPageIsShowing(WebDriver driver) {
		return isElementDisplayed(balanceSheetPage, driver);
	}

	public void clickOnCashFlowButton(WebDriver driver) {
		click(cashFlowBtn, driver);
	}

	public boolean verifyCashFlowPageIsShowing(WebDriver driver) {
		return isElementDisplayed(cashFlowPage, driver);
	}

	public void clickOnKeyRatiosButton(WebDriver driver) {
		click(keyRatiosBtn, driver);
	}

	public boolean verifyKeyRatiosPageIsShowing(WebDriver driver) {
		try {
			waitForElementVisibility(keyRatiosPage, "30", driver);
			return isElementDisplayed(keyRatiosPage, driver);
		} catch (Exception e) {
			return isElementDisplayed(keyRatiosNoDataPage, driver);
		}
	}

	public void clickOnAddTickerForComparisonButton(WebDriver driver) {
		scrollIntoViewSmoothly(liabilitiesTitle, driver);
		click(addTickerForComparisonBtn, driver);
	}

	public boolean verifySearchTickerPageIsShowing(WebDriver driver) {
		return isElementDisplayed(searchTicker, driver);
	}

	public ArrayList<String> clickOnStopOrderOption(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		try {
			waitForElementVisibility(StopOrderDorpDown, "60", driver);
			try {
				click(StopOrderDorpDown, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(StopOrderDorpDown, driver);
			}
		} catch (Exception e) {
			testSteps.add(e.toString());
			e.printStackTrace();
			printString("Stop Order Dorp Down Not Shown", driver);
		}
		return testSteps;
	}

	public boolean verifyStopOrderPageIsShowing(WebDriver driver) {
		return isElementDisplayed(StopOrderDorpDown, driver);
	}

	public boolean isPreviewBUYOrderPageDisplaying(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(btnPlaceBuyOrder, driver);
			return isElementDisplayed(btnPlaceBuyOrder, driver);
		} catch (Exception e) {
			scrollIntoViewSmoothly(btnPlaceBuyOrder, driver);
			waitForElementVisibility(btnPlaceBuyOrder, "30", driver);
			return isElementDisplayed(btnPlaceBuyOrder, driver);
		}

	}

	public void clickOncreateRecurringInvestmentButton(WebDriver driver) {
		waitForElementVisibility(createRecurringInvestmentBtn, "60", driver);
		click(createRecurringInvestmentBtn, driver);
	}

	public void exploreSectorsLabel(WebDriver driver) {
		scrollIntoViewSmoothly(sectorsLabel, driver);
		waitTime(3000, driver);
	}

	public void exploreOTCLabel(WebDriver driver) {
		scrollIntoViewSmoothly(otcLabel, driver);
		waitTime(3000, driver);
	}

	public void exploreSignalsLabel(WebDriver driver) {
		scrollIntoViewSmoothly(signalsLabel, driver);
		waitTime(3000, driver);
	}

	public void clickOnSectorsShowAllButton(WebDriver driver) {
		click(sectorsShowAll, driver);
	}

	public void clickOnOTCShowAllButton(WebDriver driver) {
		click(otcShowAll, driver);
	}

	public boolean isSectorsPageDisplaying(WebDriver driver) {
		return isElementDisplayed(sectorsPage, driver);
	}

	public boolean isOtcPageDisplaying(WebDriver driver) {
		return isElementDisplayed(otcPage, driver);
	}

	public void clickOnCommunicationServicesButton(WebDriver driver) {
		click(communicationServices, driver);
	}

	public void clickOnFirstSignalOption(WebDriver driver) {
		click(signalFirstOption, driver);
	}

	public void emergingThemesLabel(WebDriver driver) {
		scrollIntoViewSmoothly(emergingThemesLabel, driver);
		waitTime(3000, driver);
	}

	public void clickOnEmergingThemesShowAllButton(WebDriver driver) {
		click(emergingThemesShowAll, driver);
	}

	public boolean isEmergingThemesShowPageDisplaying(WebDriver driver) {
		return isElementDisplayed(emergingThemesShowPage, driver);
	}

	public void clickOnArtificialIntelligenceButton(WebDriver driver) {
		click(artificialIntelligence, driver);
	}

	public void geographyLabel(WebDriver driver) {
		scrollIntoViewSmoothly(geographyLabel, driver);
		waitTime(3000, driver);
	}

	public void clickOnGeographyShowAllButton(WebDriver driver) {
		try {
			click(geographyShowAll, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(geographyShowAll, driver);
		}

	}

	public boolean isGeographyPageDisplaying(WebDriver driver) {
		return isElementDisplayed(geographyPage, driver);
	}

	public void clickOnUSButton(WebDriver driver) {
		click(US, driver);
	}

	public void enterstopPriceValue(Double Val, WebDriver driver) {
		waitForElementVisibility(stopPriceInput, "60", driver);
		clearField(stopPriceInput, driver);
		type(stopPriceInput, String.valueOf(Val), driver);
	}

	public void ETFProvidersLabel(WebDriver driver) {
		scrollIntoViewSmoothly(ETFProvidersLabel, driver);
		waitTime(3000, driver);
	}

	public ArrayList<String> clickOnErrorMessageHighStopPricePopupCloseButton(WebDriver driver) {
		ArrayList<String> testSteps = new ArrayList<String>();
		try {
			waitForElementVisibility(errorMessageLowStopPricePopupCloseBtn, "60", driver);
			try {
				click(errorMessageLowStopPricePopupCloseBtn, driver);
			} catch (Exception e) {
				clickUsingJavascriptExecutor(errorMessageLowStopPricePopupCloseBtn, driver);
			}
		} catch (Exception e) {
			testSteps.add(e.toString());
			e.printStackTrace();
			printString("Error Message Low Stop Price Popup Close Button Not Shown", driver);
		}
		return testSteps;
	}

	public boolean errorMessageHighStopPriceIsShowing(WebDriver driver) {
		waitForElementVisibility(errorMessageHighStopPrice, "60", driver);
		return isElementDisplayed(errorMessageHighStopPrice, driver);
	}

	public void clickOnETFProvidersShowAllButton(WebDriver driver) {
		click(ETFProvidersShowAll, driver);
	}

	public boolean isETFProvidersPageDisplaying(WebDriver driver) {
		waitForElementVisibility(ETFProvidersPage, "30", driver);
		return isElementDisplayed(ETFProvidersPage, driver);
//		try {
//			waitForElementVisibility(ETFProvidersPage, "30",driver);
//			return isElementDisplayed(ETFProvidersPage,driver);
//		}catch (Exception e) {
//			waitForElementVisibility(ETFProvidersPage, "30",driver);
//			return isElementDisplayed(ETFProvidersPage,driver);
//		}

	}

	public void clickOnfidelityButton(WebDriver driver) {
		click(fidelity, driver);
	}

	public void exploreIncomeFocusedLabel(WebDriver driver) {
		scrollIntoViewSmoothly(incomeFocusedLabel, driver);
		waitTime(3000, driver);
	}

	public void clickOnBondsButton(WebDriver driver) {
		click(bondsBtn, driver);
	}

	public void exploreRecommendedLabel(WebDriver driver) {
		scrollIntoViewSmoothly(recommendedLabel, driver);
		waitTime(3000, driver);
	}

	public void clickOnRecommendedShowAllButton(WebDriver driver) {
		click(recommendedShowAll, driver);
	}

	public String getStockname(WebDriver driver) {
		String arr[] = driver.getCurrentUrl().split("/");
		return arr[(arr.length - 1)];
	}

	public void clickOnmultiAssetClassVests_i(WebDriver driver) {
		try {
			click(multiAssetClassVests_i, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(multiAssetClassVests_i, driver);
		}

	}

	public void clickOnPortfolioOverview_i(WebDriver driver) {
		try {
			click(PortfolioOverview_i, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(PortfolioOverview_i, driver);
		}

	}

	public void clickOnYourPortFolio_i(WebDriver driver) {
		try {
			click(YourPortFolio_i, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(YourPortFolio_i, driver);
		}

	}

	public void clickOnEmergingThemeDisclosure(WebDriver driver) {
		try {
			click(EmergingThemeDisclosure, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(EmergingThemeDisclosure, driver);
		}

	}

	public void clickOnSignalsDisclosure(WebDriver driver) {
		try {
			click(signalsDisclosure, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(signalsDisclosure, driver);
		}

	}

	public void clickOnRecommedationDisclosure(WebDriver driver) {
		try {
			click(RecommedationDisclosure, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(RecommedationDisclosure, driver);
		}

	}

	public void clickOnmultiAssetClassVests_ShowAll(WebDriver driver) {
		try {
			click(multiAssetClassVests_ShowAll, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(multiAssetClassVests_ShowAll, driver);
		}

	}

	public Boolean isYourPortFolio_iPopupHeading(WebDriver driver) {
		return isElementDisplayed(YourPortFolio_iPopup, driver);
	}

	public Boolean isAddFunds_PopupHeading(WebDriver driver) {
		return isElementDisplayed(AddFunds_Popup, driver);
	}

	public Boolean isEmergingThemesDisclosure_PopupHeading(WebDriver driver) {
		return isElementDisplayed(EmergingThemesDisclosure_Popup, driver);
	}

	public Boolean isSignalsDisclosure_PopupHeading(WebDriver driver) {
		return isElementDisplayed(SignalsDisclosure_Popup, driver);
	}

	public Boolean isRecomendationDisclosure_PopupHeading(WebDriver driver) {
		return isElementDisplayed(RecomendationDisclosure_Popup, driver);
	}

	public String getmultiAssetClassVests_iPopupHeading(WebDriver driver) {
		return getElementText(multiAssetClassVests_iPopup, driver);
	}

	public Boolean isPortfolioOverview_iPopupHeading(WebDriver driver) {
		return isElementDisplayed(portfolioOverview_iPopup, driver);
	}

	public void clickOnThemeBasedVests_i(WebDriver driver) {
		try {
			click(themeBasedVests_i, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(themeBasedVests_i, driver);
		}

	}

	public void clickOnThemeBasedVests_ShowAll(WebDriver driver) {
		try {
			click(themeBasedVests_ShowAll, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(themeBasedVests_ShowAll, driver);
		}

	}

	public Boolean getThemeBasedVests_iPopupHeading(WebDriver driver) {
		waitForElementVisibility(themeBasedVests_iPopup, "30", driver);
		return isElementDisplayed(themeBasedVests_iPopup, driver);
	}

	public int getMultiAssetClassVests_Cards()  {
		wait3s();
		return multiAssetClassVests_Cards.size();
	}

	public ArrayList<String> getThemeBasedVests_Cards(WebDriver driver)  {
		wait3s();
		ArrayList<String> list = new ArrayList<>();
		for (WebElement text : themeBasedVests_Cards) {
			scrollToElement(text, driver);
			list.add(text.getText());
		}

		return list;
	}

	public void clickOnMultiAssetClassVests_iPopupClose(WebDriver driver) {
		try {
			click(multiAssetClassVests_iPopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(multiAssetClassVests_iPopupClose, driver);
		}

	}

	public void clickOnPortfolioOverview_iPopupClose(WebDriver driver) {
		try {
			click(PortfolioOverview_iPopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(PortfolioOverview_iPopupClose, driver);
		}

	}

	public void clickOnYourPortFolio_iPopupClose(WebDriver driver) {
		try {
			click(YourPortFolio_iPopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(YourPortFolio_iPopupClose, driver);
		}

	}

	public void clickOnEmergingThemesDisclosure_PopupClose(WebDriver driver) {
		try {
			click(EmergingThemesDisclosure_PopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(EmergingThemesDisclosure_PopupClose, driver);
		}

	}

	public void clickOnSignalsDisclosure_PopupClose(WebDriver driver) {
		try {
			click(SignalsDisclosure_PopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(SignalsDisclosure_PopupClose, driver);
		}

	}

	public void clickOnRecommendedDisclosure_PopupClose(WebDriver driver) {
		try {
			click(RecommendedDisclosure_PopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(RecommendedDisclosure_PopupClose, driver);
		}

	}

	public void clickOnThemeBasedVests_iPopupClose(WebDriver driver) {
		try {
			click(themeBasedVests_iPopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(themeBasedVests_ShowAll, driver);
		}

	}

	public ArrayList<String> verifyTabs(WebDriver driver) {
		waitforPageLoad(defaultTimeForVisibility, driver);
		int staticWaitTime = 1;
		ArrayList<String> testSteps = new ArrayList<String>();
		String sym = stocksSymbol.getText();
		testSteps.add("<b>****************Verifying '" + sym + "' instrument Page****************</b>");
		try {
			testSteps.add("Verifying 'Overview Tab' is displaying");
			scrollIntoSpecificView(overviewTab, driver);
			waitForElementVisibility(overviewTab, staticWaitTime, driver);
			testSteps.add("<b>'Overview Tab' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'Overview Tab' is not displaying</b></font>");
		}

		try {
			testSteps.add("Verifying 'Returns Tab' is displaying");
			scrollIntoSpecificView(returnsTab, driver);
			waitForElementVisibility(returnsTab, staticWaitTime, driver);
			testSteps.add("<b>'Returns Tab' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b> 'Returns Tab' is not displaying </b></font>");
		}

		try {
			testSteps.add("Verifying 'FundamentalData Tab' is displaying");
			scrollIntoSpecificView(fundamentalDataTab, driver);
			waitForElementVisibility(fundamentalDataTab, staticWaitTime, driver);
			testSteps.add("<b>'FundamentalData Tab' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'FundamentalData Tab' is not displaying </b></font>");
		}

		try {
			testSteps.add("Verifying 'KeyRatios Tab' is displaying");
			scrollIntoSpecificView(keyRatiosTab, driver);
			waitForElementVisibility(keyRatiosTab, staticWaitTime, driver);
			testSteps.add("<b>'KeyRatios Tab' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'KeyRatios Tab' is not displaying</b></font>");
		}

		try {
			testSteps.add("Verifying 'YourPosition Section' is displaying");
			scrollIntoSpecificView(yourPositionSection, driver);
			waitForElementVisibility(yourPositionSection, staticWaitTime, driver);
			testSteps.add("<b>'YourPosition Section' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'YourPosition Section' is not displaying</b></font>");
		}

		try {
			testSteps.add("Verifying 'Performance Section' is displaying");
			scrollIntoSpecificView(performanceSection, driver);
			waitForElementVisibility(performanceSection, staticWaitTime, driver);
			testSteps.add("<b>'Performance Section' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'Performance Section' is not displaying</b></font>");
		}

		try {
			testSteps.add("Verifying 'About Section' is displaying");
			scrollIntoSpecificView(aboutSection, driver);
			waitForElementVisibility(aboutSection, staticWaitTime, driver);
			testSteps.add("<b>'About Section' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'About Section' is not displaying</b></font>");
		}

		try {
			testSteps.add("Verifying 'Earnings Section' is displaying");
			scrollIntoSpecificView(earningsSection, driver);
			waitForElementVisibility(earningsSection, staticWaitTime, driver);
			testSteps.add("<b>'Earnings Section' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'Earnings Section' is not displaying</b></font>");
		}
		try {
			testSteps.add("Verifying 'News Section' is displaying");
			scrollIntoSpecificView(newsSection, driver);
			waitForElementVisibility(newsSection, staticWaitTime, driver);
			testSteps.add("<b>'News Section' is displaying</b>");
		} catch (Exception e) {
			testSteps.add("<font color= red><b>'News Section' is not displaying</b></font>");
		}

		return testSteps;
	}
	
	public Boolean SuccessScreenDisplaying(WebDriver driver) {
		try {
			waitForElementVisibility(successScreen, defaultTimeForVisibility, driver);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnVests_i(WebDriver driver) {
		try {
			click(Vests_i, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(Vests_i, driver);
		}

	}
	
	public String getVest_iPopupHeading(WebDriver driver) {
		return getElementText(vests_iPopup, driver).trim();
	}
	public void clickOnVests_iPopupClose(WebDriver driver) {
		try {
			click(vests_iPopupClose, driver);
		} catch (Exception e) {
			clickUsingJavascriptExecutor(vests_iPopupClose, driver);
		}

	}
	public int getVests_Cards()  {
		wait3s();
		return vests_Cards.size();
	}
	public boolean isExploreOTCLabelDisplaying(WebDriver driver) {
		try {
			scrollIntoViewSmoothly(otcLabel, driver);
			return isElementDisplayed(otcLabel, driver);
		}catch (Exception e) {
			return false;
		}
	}

	public void clickOnPortfolio(WebDriver driver) {
		try {
			click(portfolioTab, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(portfolioTab, driver);
		}
	}
	
	public void clickOnWatchlist(WebDriver driver) {
		try {
			click(watchlistTab, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(watchlistTab, driver);
		}
	}
	public void clickOnOrderTab(WebDriver driver) {
		try {
			click(orderTab, driver);
		}catch (Exception e) {
			clickUsingJavascriptExecutor(orderTab, driver);
		}
	}
	
	
}
