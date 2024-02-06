package com.investor.utilities;

public class Constants {

	public String premiumSkippedTestCases = "<b>***************************************************************</b><br>"
			+ "Following Test Cases will be Skipped and will not add in Report<br>"
			+ "Due to Failure of <b>'VerifyFundsAvailable_Premium'</b><br>"
			+ "<b>***************************************************************</b><br>"
			+ "-> RecurringInvestments_Vest_MultiAssetClass<br>" + "-> RecurringInvestments_Vest_ThemeBased<br>"
			+ "-> KYC_ApprovedFundedAccount_PurchaseVest_MultiAssetClass<br>"
			+ "-> KYC_ApprovedFundedAccount_PurchaseVest_ThemeBased<br>" + "-> Verify_UserProfile_PremiumPlan<br>"
			+ "-> ETFsFlowVerification<br>" + "-> StocksFlowVerification<br>" + "-> OTCFlowVerification<br>"
			+ "-> Verify_Withdraw_OTPValidationMessage<br>" + "-> Verify_CompleteWithdraw_NonPremium<br>"
			+ "-> Instruments_Buy<br>" + "-> Instruments_Sell<br>" + "-> Instruments_Sell_LimitOrder<br>"
			+ "-> Instruments_Buy_LimitOrder<br>" + "-> Instruments_Buy_LimitOrder<br>"
			+ "-> Instruments_Buy_LimitOrder<br>" + "-> Instruments_NegetiveBuy<br>" +"-> VerifyThreeDotOption_SameDayInvestedDIYVest";

	public String nonPremiumSkippedTestCases = "<b>***************************************************************</b><br>"
			+ "Following Test Cases will be Skipped and will not add in Report<br>"
			+ "Due to Failure of <b>'VerifyFundsAvailable_NonPremium'</b>br>"
			+ "<b>***************************************************************</b><br>"
			+ "-> Verify_UserProfile_BasicPlan";
	
	////////////////////////////////
	// BaseClass
	//////////////////////////////
	public static final String api_base_url = "http://182.180.172.81:8082/";

	// This is the default path to data package
	public static String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\";

	// This is the default path to imageUpload
	public static String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\";
	public static String UtilityscreenshotPath;
	public static String UtilityscreenshotName;
	// This is column name from which we need to get row
	public static final String colName = "env";
	// This is row index of environment column from which we need to get data
	public static int rowIndex = 0;
	// Excel file name
	public static final String testDataFile = "testData";
	// Excel sheetname
	public static final String testDataSheet = "TestData";
	public static final String KYC_NonAdaarReg = "KYC_NonAdaarReg";
	public static final String KYC_OtherNRI_Reg = "KYC_OtherNRI_Reg";
	public static final String KYCNegative_NonAadhar = "KYCNegative_NonAadhar";
	public static final String recurringInvestmentFromVests = "recurringInvestmentFromVests";
	public static final String KYC_ApprovedFundedAccountVest = "KYC_ApprovedFundedAccountVest";

	public static final int defaultTimeForVisibility = 30;
	public static final int defaultTimeTOBeClickable = 30;
	public static final String AppUrl = "AppURL";
	// Test Suite Runner File Name
	public static final String testSuiteRunnerFileName = "SuiteTests_Web";
	// Test Suite Runner Sheet Name
	public static final String testSuiteRunnerSheetName = "Tests";
	
	
	////////////////////////////////
	// Utilities
	//////////////////////////////
	
//	public static final int defaultTimeForVisibility = 30;
//	public static final int defaultTimeTOBeClickable = 30;
	// This is column name from which we need to get row
//	public static final String colName = "env";
	public static Integer waitInSeconds = 5;
//	// This is the default path to data package
//	public static String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\";
//	// This is the default path to imageUpload
//	public static String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\";
//	// This is row index of environment column from which we need to get data
//	public static int rowIndex = 0;

}
