package paperboyTestScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import genericLibrary.Browsers;
 
/**
 * 
 * @author Yathin
 *
 */

import genericLibrary.ExcelLibrary;
import paperboyPOM.CartPageObject;
import paperboyPOM.EditionsSubscribePaperPageObject;
import paperboyPOM.HomePageObject;
import paperboyPOM.MyPaperPageObject;

public class VerifyingValidTillDate{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	CartPageObject cartPageObject; 
	EditionsSubscribePaperPageObject editionsSubscribePaperPageObject;
	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
		cartPageObject = PageFactory.initElements(driver, CartPageObject.class);
		editionsSubscribePaperPageObject = PageFactory.initElements(driver, EditionsSubscribePaperPageObject.class);
	}
	
	/*
	 * step1: Login with Valid Credentials
	 * step2: Subscribing a Paper/Magazine from Home 
	 * step3: Verifying the Subscribed from MyPapers
	 * step4: Logout and Login with the Same Credentials
	 * step5: Subscribing the Paper/Magazine from recommendation as well as Reader screen 
	 * step6: Logout and Close Browser
	 */

	//Login
    @BeforeMethod
    public void Login() throws Throwable
    {
		String lemail= elib.getExcelData("ReUsableData", 46, 2);			
		String lpassword= elib.getExcelData("ReUsableData", 46, 3);		   
    	homePageObject.loginSuccessVerify(lemail, lpassword);
    	Thread.sleep(2000);
    	driver.get("https://www.paperboy.com/");
    	Thread.sleep(4000);    	
    }
    
    
    //Logout
    @AfterMethod
    public void Logout() throws Throwable
    {
    	myPaperPageObject.logout();
    	Thread.sleep(3000);
    }
			
	//Case 13a - valid till date From Subscribe screen(https://www.paperboy.com/kannada-prabha-newspaper-subscribe)
    @Test 
    public void TC13a_VerifyValidTillDateEditionsSubscribeScreen() throws Throwable
    {
	 	//Verifying Default Month(1Month)
		homePageObject.clickSubscribeKannadaPrabha();
		editionsSubscribePaperPageObject.verifyDefaultValidTillDate();
		
     	//Verifying Third Month
		editionsSubscribePaperPageObject.clickSubscriptionRenewalBox();		
		editionsSubscribePaperPageObject.clickDropdownButton3Months();
		editionsSubscribePaperPageObject.verifyValidTillDate3months();
		
     	//Verifying Six Month
		editionsSubscribePaperPageObject.clickSubscriptionRenewalBox();		
		editionsSubscribePaperPageObject.clickDropdownButton6Months();
		editionsSubscribePaperPageObject.verifyValidTillDate6months();

     	//Verifying 1 Year
		editionsSubscribePaperPageObject.clickSubscriptionRenewalBox();		
		editionsSubscribePaperPageObject.clickDropdownButton1Year();
		editionsSubscribePaperPageObject.verifyValidTillDate1year();
		
     	//Verifying 1 Month
		editionsSubscribePaperPageObject.clickSubscriptionRenewalBox();		
		editionsSubscribePaperPageObject.clickDropdownButton1Month();
		editionsSubscribePaperPageObject.verifyDefaultValidTillDate();
    }
     
	//Case 13b - Verifying valid till date in Cart screen through Subscribe flow
    @Test 
    public void TC13b_VerifyValidTillDateCartScreen() throws Throwable
    {
	 	//Verifying Default Month(1Month)
		homePageObject.clickSubscribeKannadaPrabha();
		editionsSubscribePaperPageObject.clickAdd();
		cartPageObject.verifyDefaultValidTillDate();
		
     	//Verifying Third Month
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton3Months();
		cartPageObject.verifyValidTillDate3months();
		
		
     	//Verifying Six Month
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton6Months();
		cartPageObject.verifyValidTillDate6months();

     	//Verifying 1 Year
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton1Year();
		cartPageObject.verifyValidTillDate1year();
		
     	//Verifying 1 Month
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton1Month();
		cartPageObject.verifyDefaultValidTillDate();
    }
        
    
    //Case 13c - Verifying valid till date in Cart screen through Renew flow */
    @Test
    public void TC13c_VerifyValidTillDateCartScreenThruRenew() throws Throwable
    {
    	//Verifying Default Month(1Month)
    	homePageObject.clickMySubscription();
    	myPaperPageObject.clickRenewals();
    	cartPageObject.getValidTillDateSakshi();
    	myPaperPageObject.clickRenewSakshi();
    	cartPageObject.verifyDefaultValidTillDateRenew();
    	
     	//Verifying Third Month
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton3Months();
		cartPageObject.verifyValidTillDate3monthsRenew();
		
		
     	//Verifying Six Month
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton6Months();
		cartPageObject.verifyValidTillDate6monthsRenew();

     	//Verifying 1 Year
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton1Year();
		cartPageObject.verifyValidTillDate1yearRenew();
		
     	//Verifying 1 Month
		cartPageObject.clickSubscriptionBox();
		cartPageObject.clickDropdownButton1Month();
		cartPageObject.verifyValidTillDate1monthRenew();
    }
    
	@AfterClass (enabled = false) 
	public void closeBrowser() throws Throwable{	
		driver.close();
	}

}
