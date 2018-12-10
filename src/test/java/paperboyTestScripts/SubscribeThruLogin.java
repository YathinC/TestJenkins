package paperboyTestScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import paperboyPOM.EditionsReadMagazinesPageObject;
import paperboyPOM.EditionsReadPaperPageObject;
import paperboyPOM.EditionsSubscribeMagazinePageObject;
import paperboyPOM.EditionsSubscribePaperPageObject;
import paperboyPOM.HomePageObject;
import paperboyPOM.MyAccountPageObject;
import paperboyPOM.MyPaperPageObject;
import paperboyPOM.ReaderMagazinePageObject;
import paperboyPOM.ReaderPaperPageObject;

public class SubscribeThruLogin{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	MyAccountPageObject myAccountPageObject;
	EditionsSubscribePaperPageObject editionsSubscribePaperPageObject;
	EditionsSubscribeMagazinePageObject editionsSubscribeMagazinePageObject;
	EditionsReadPaperPageObject editionsReadPaperPageObject;
	EditionsReadMagazinesPageObject editionsReadMagazinesPageObject;
	CartPageObject cartPageObject; 
	ReaderPaperPageObject readerPaperPageObject;
	ReaderMagazinePageObject readerMagazinePageObject;
	
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
		editionsReadMagazinesPageObject = PageFactory.initElements(driver, EditionsReadMagazinesPageObject.class);
		cartPageObject = PageFactory.initElements(driver, CartPageObject.class);
		readerPaperPageObject = PageFactory.initElements(driver, ReaderPaperPageObject.class);
		readerMagazinePageObject = PageFactory.initElements(driver, ReaderMagazinePageObject.class);
		
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
    @BeforeMethod (enabled = true)
    public void Login() throws Throwable
    {
    	driver.get("https://www.paperboy.com/");
    	Thread.sleep(4000);    	
    }
    
    
    //Logout
    @AfterMethod (enabled = true)
    public void Logout() throws Throwable
    {
    	myPaperPageObject.logout();
    	Thread.sleep(3000);
    }
	
		
    //Case 10a - Subscribing a paper thru login and verifying
    @Test (enabled = true)
    public void TC10a_SubscribePaperThruLogin() throws Throwable
    {
		String lemail= elib.getExcelData("ReUsableData", 40, 2);			
		String lpassword= elib.getExcelData("ReUsableData", 40, 3);		   
    	homePageObject.clickReadUdayavani();
    	editionsReadPaperPageObject.clickRead();
    	readerPaperPageObject.clickSubscribeAndLogin(lemail, lpassword);
    	cartPageObject.proceedCart();
    	myPaperPageObject.verifySubscribedPaperUdayavani();											/*verifying Subscribed paper from My Papers*/
    	Thread.sleep(6000);																			/* Thread Sleep needed because Toast message is overlapping on Logout button till 6sec */
    }

    
    
    
    
    //Case 10b - Subscribing a magazine thru login and verifying
    @Test (enabled = true)
    public void TC10b_SubscribeMagazineThruLogin() throws Throwable
    {
		String lemail= elib.getExcelData("ReUsableData", 40, 2);			
		String lpassword= elib.getExcelData("ReUsableData", 40, 3);		   

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement JobOffer = driver.findElement(By.xpath("//h2[text()='Magazines']"));															/*	Find element by link text and store in variable "Element"	*/
        js.executeScript("arguments[0].scrollIntoView();", JobOffer); 																			/*   This will scroll the page till the element is found  */
        Thread.sleep(2000);
        
        homePageObject.clickReadJobOffer();
    	editionsReadMagazinesPageObject.clickRead();
    	readerMagazinePageObject.clickSubscribeAndLogin(lemail, lpassword);
    	cartPageObject.proceedCart();
    	myPaperPageObject.clickMyMagazines();
    	myPaperPageObject.verifySubscribedMagazineJobOffer();										/*verifying Subscribed paper from My Papers*/
    	Thread.sleep(6000);																			/* Thread Sleep needed because Toast message is overlapping on Logout button till 6sec */
    }
    
   
    
	@AfterClass (enabled = true)
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}