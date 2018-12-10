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
import paperboyPOM.HomePageObject;
import paperboyPOM.MyPaperPageObject;

public class Unsubscribe{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	CartPageObject cartPageObject; 
	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
		cartPageObject = PageFactory.initElements(driver, CartPageObject.class);
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
		String lemail= elib.getExcelData("ReUsableData", 44, 2);			
		String lpassword= elib.getExcelData("ReUsableData", 44, 3);		   
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
			
    //Case 11a - Renewing a Subscription
    @Test
    public void TC11a_Renew() throws Throwable
    {
    	homePageObject.clickMySubscription();
    	myPaperPageObject.clickRenewals();
    	myPaperPageObject.clickUnsubscribeEveningTimes();
    	myPaperPageObject.confirmUnsubscribe();
    }
        
	@AfterClass 
	public void closeBrowser() throws Throwable{	
		driver.close();
	}

}
