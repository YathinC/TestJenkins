package paperboyTestScripts;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import paperboyPOM.FBLoginPageObject;
import paperboyPOM.HomePageObject;
import paperboyPOM.LinkedInLoginPageObject;
import paperboyPOM.MyPaperPageObject;
import paperboyPOM.TwitterLoginPageObject;

public class ShareUrlCheck{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	CartPageObject cartPageObject; 
	FBLoginPageObject fbLoginPageObject;
	TwitterLoginPageObject twitterLoginPageObject;
	LinkedInLoginPageObject linkedInLoginPageObject;
	EditionsReadPaperPageObject editionsReadPaperPageObject;
	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
		cartPageObject = PageFactory.initElements(driver, CartPageObject.class);
		fbLoginPageObject = PageFactory.initElements(driver, FBLoginPageObject.class);
		twitterLoginPageObject = PageFactory.initElements(driver, TwitterLoginPageObject.class);
		linkedInLoginPageObject = PageFactory.initElements(driver, LinkedInLoginPageObject.class);
		editionsReadPaperPageObject = PageFactory.initElements(driver, EditionsReadPaperPageObject.class);


	}
	
	/*
	 * step1: Login with Valid Credentials
	 * step2: Subscribing a Paper/Magazine from Home 
	 * step3: Verifying the Subscribed from MyPapers
	 * step4: Logout and Login with the Same Credentials
	 * step5: Subscribing the Paper/Magazine from recommendation as well as Reader screen 
	 * step6: Logout and Close Browser
	 */

	//Case 15 - Login to all the 3 social Sites
    @BeforeMethod
    public void Login() throws Throwable
    {
		//Login via FB
//		String fbemail= elib.getExcelData("ReUsableData", 25, 2);
//		String fbpassword= elib.getExcelData("ReUsableData", 25, 3);		
//    	driver.get("https://www.facebook.com/");
//    	Thread.sleep(5000);
//    	fbLoginPageObject.fblogin(fbemail, fbpassword);

    	//Login via Twitter
		String twitteremail= elib.getExcelData("ReUsableData", 49, 2);
		String twitterpassword= elib.getExcelData("ReUsableData", 49, 3);		
		driver.get("https://twitter.com/login");
    	Thread.sleep(5000);
    	twitterLoginPageObject.twiterlogin(twitteremail, twitterpassword);
    	
//	  	//Login via LinkedIn
//		String LinkedInemail= elib.getExcelData("ReUsableData", 52, 2);
//		String LinkedInpassword= elib.getExcelData("ReUsableData", 52, 3);		
//	  	driver.get("https://www.linkedin.com/");
//    	Thread.sleep(5000);
//    	linkedInLoginPageObject.linkedInlogin(LinkedInemail, LinkedInpassword);
    }
    
    
    //Logout
    @AfterMethod (enabled = false)
    public void Logout() throws Throwable
    {
    	myPaperPageObject.logout();
    	Thread.sleep(3000);
    }
			
	//Case 15a - Verifying URL sharing through FB(https://www.paperboy.com/kannada-prabha-newspaper-read)
    @Test (enabled = false)
    public void TC15a_ShareUrlVerify() throws Throwable
    {
  		//Sharing
    	driver.get("https://www.paperboy.com/kannada-prabha-newspaper-read");
  		Thread.sleep(5000);	
  		editionsReadPaperPageObject.clickfbShare();
  		
  		//Handling Windows
  		String CurrentWindow = driver.getWindowHandle();																/* Initiating Window Handling for the existing Window */
	  		for(String winHandle : driver.getWindowHandles()){															/* Handling the New Opened Window */
	  		    driver.switchTo().window(winHandle);
	  		}
    	
    	fbLoginPageObject.clickPost();
  		driver.switchTo().window(CurrentWindow);																		/* Switching the Handling to the Previous Window */
    	
  		//Handling Tabs
	  	String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN); 											/* Opening New Tab with reference by an Element */
	  	editionsReadPaperPageObject.newspapersButton.sendKeys(selectLinkOpeninNewTab);
	  	Thread.sleep(2000);
	  	ArrayList tabs = new ArrayList (driver.getWindowHandles());														/* Finding out the No. of Tabs and Storing in Array */
  		System.out.println(tabs.size());																				/* Finding out the Array Size (No. of Tabs) */
	  	driver.switchTo().window((String) tabs.get(1));																	/* Switching to the Particular Tab which found in Array */
    	
	  	//Clicking on the Shared URL
	  	driver.get("https://www.facebook.com/");
	  	Thread.sleep(2000);
	  	fbLoginPageObject.clickUserName();
	  	((JavascriptExecutor)driver).executeScript("scroll(0,700)");													/* Scrolling the page to Make the element visible*/
	  	Thread.sleep(1000);
	  	fbLoginPageObject.clicksharedLink();																			/* Clicking on the Shared url */
	  	driver.close();
    	
	  	//Verifying the Shared URL
	  	ArrayList tabs1 = new ArrayList (driver.getWindowHandles());													/* Finding out the No. of Tabs and Storing in Array */
	  	driver.switchTo().window((String) tabs1.get(1));	
	  	Thread.sleep(2000);
	  	assertTrue(driver.getCurrentUrl().contains("https://www.paperboy.com/kannada-prabha-newspaper-read"));			/* Verifying the Shared URL */
	  	driver.close();
	  	driver.switchTo().window((String) tabs1.get(0));
    }
        
	//Case 15b - Verifying URL sharing through Twitter(https://www.paperboy.com/kannada-prabha-newspaper-read)
    @Test (enabled = true)
    public void TC15b_ShareUrlVerify() throws Throwable
    {
  		//Sharing
    	driver.get("https://www.paperboy.com/kannada-prabha-newspaper-read");
  		Thread.sleep(5000);	
  		editionsReadPaperPageObject.clickTwitterShare();
  		
  		//Handling Windows
  		String CurrentWindow = driver.getWindowHandle();																/* Initiating Window Handling for the existing Window */
	  		for(String winHandle : driver.getWindowHandles()){															/* Handling the New Opened Window */
	  		    driver.switchTo().window(winHandle);
	  		}
	  	
	  	twitterLoginPageObject.clickTweet(); 																			/* Sharing the Post in the Newly Opened Window */
  		driver.switchTo().window(CurrentWindow);																		/* Switching the Handling to the Previous Window */
    	
  		//Handling Tabs
	  	String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN); 											/* Opening New Tab with reference by an Element */
	  	editionsReadPaperPageObject.newspapersButton.sendKeys(selectLinkOpeninNewTab);
	  	Thread.sleep(2000);
	  	ArrayList tabs = new ArrayList (driver.getWindowHandles());														/* Finding out the No. of Tabs and Storing in Array */
  		System.out.println(tabs.size());																				/* Finding out the Array Size (No. of Tabs) */
	  	driver.switchTo().window((String) tabs.get(1));																	/* Switching to the Particular Tab which found in Array */

	  	//Clicking on the Shared URL
	  	driver.get("https://twitter.com/");	
	  	Thread.sleep(2000);
	  	twitterLoginPageObject.clickProfile();
	  	twitterLoginPageObject.clickAccountName();
	  	twitterLoginPageObject.clickTweetedURL();
	  	driver.close();
	  	
	  	//Verifying the SHared URL
	  	ArrayList tabs1 = new ArrayList (driver.getWindowHandles());													/* Finding out the No. of Tabs and Storing in Array */
	  	driver.switchTo().window((String) tabs1.get(1));	
	  	Thread.sleep(2000);
	  	assertTrue(driver.getCurrentUrl().contains("https://www.paperboy.com/kannada-prabha-newspaper-read"));			/* Verifying the Shared URL */
	  	driver.close();
	  	driver.switchTo().window((String) tabs1.get(0));    	
    }

    
    @AfterClass (enabled = false)
	public void closeBrowser() throws Throwable{	
		driver.close();
	}

}
