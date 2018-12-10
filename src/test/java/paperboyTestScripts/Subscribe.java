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
import paperboyPOM.EditionsReadPaperPageObject;
import paperboyPOM.EditionsSubscribeMagazinePageObject;
import paperboyPOM.EditionsSubscribePaperPageObject;
import paperboyPOM.HomePageObject;
import paperboyPOM.MyAccountPageObject;
import paperboyPOM.MyPaperPageObject;
import paperboyPOM.ReaderPaperPageObject;

public class Subscribe{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	MyAccountPageObject myAccountPageObject;
	EditionsSubscribePaperPageObject editionsSubscribePaperPageObject;
	EditionsSubscribeMagazinePageObject editionsSubscribeMagazinePageObject;
	EditionsReadPaperPageObject editionsReadPaperPageObject;
	CartPageObject cartPageObject; 
	ReaderPaperPageObject readerPaperPageObject;
	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
		myAccountPageObject = PageFactory.initElements(driver, MyAccountPageObject.class);
		editionsSubscribePaperPageObject = PageFactory.initElements(driver, EditionsSubscribePaperPageObject.class);
		editionsSubscribeMagazinePageObject = PageFactory.initElements(driver, EditionsSubscribeMagazinePageObject.class);
		editionsReadPaperPageObject = PageFactory.initElements(driver, EditionsReadPaperPageObject.class);
		cartPageObject = PageFactory.initElements(driver, CartPageObject.class);
		readerPaperPageObject = PageFactory.initElements(driver, ReaderPaperPageObject.class);
	
		
		
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
		String lemail= elib.getExcelData("ReUsableData", 40, 2);			
		String lpassword= elib.getExcelData("ReUsableData", 40, 3);		   
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
	
		
    //Case 9a - Subscribing a paper from landing and verifying
    @Test
    public void TC9a_SubscribePaperHome() throws Throwable
    {
    	homePageObject.clickSubscribeKannadaPrabha();
    	editionsSubscribePaperPageObject.clickAdd();
    	cartPageObject.proceedCart();
    	myPaperPageObject.verifySubscribedPaperKannadaPrabha();											/*verifying Subscribed paper from My Papers*/
    	Thread.sleep(6000);																				/* Thread Sleep needed because Toast msg is overlapping on Logout button till 6sec */
    }

    //Case 9b - Subscribing a magazine from landing and verifying
    @Test
    public void TC9b_SubscribeMagazineHome() throws Throwable
    {
    	homePageObject.clickSubscribeAragini();
    	editionsSubscribeMagazinePageObject.clickAdd();
    	cartPageObject.proceedCart();
    	myPaperPageObject.clickMyMagazines();
    	myPaperPageObject.verifySubscribedMagazineAragini();											/*verifying Subscribed Magazine from My Magazines*/
    	Thread.sleep(6000);																				/* Thread Sleep needed because Toast message is overlapping on Logout button till 6sec */
    }
    
    //Case 9c - Subscribing from recommendations
    @Test
    public void TC9c_SubscribeRecommendation() throws Throwable
    {
    	homePageObject.clickMySubscription();
    	myPaperPageObject.clickRecomendationSubscribeButton();
    	cartPageObject.proceedCart();
    	Thread.sleep(6000);																				/* Thread Sleep needed because Toast message is overlapping on Logout button till 6sec */
    }
	
    //Case 9d - Subscribing through Reader
    @Test
    public void TC9d_SubscribeThruReader() throws Throwable
    {
    	homePageObject.clickReadVijayavani();
    	editionsReadPaperPageObject.clickRead();
    	readerPaperPageObject.clickSubscribe();
    	cartPageObject.proceedCart();
    	myPaperPageObject.verifySubscribedPaperVijayavani();											/*verifying Subscribed paper from My Papers*/
    	Thread.sleep(6000);																				/* Thread Sleep needed because Toast message is overlapping on Logout button till 6sec */
    }
   
    
	@AfterClass 
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}
