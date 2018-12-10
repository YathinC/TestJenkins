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
import paperboyPOM.HomePageObject;
import paperboyPOM.MyAccountPageObject;
import paperboyPOM.MyPaperPageObject;

public class ChangePassword{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	MyAccountPageObject myAccountPageObject;
	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
		myAccountPageObject = PageFactory.initElements(driver, MyAccountPageObject.class);
	}
	
	/*
	 * step1: Open Login Popup
	 * step2: Enter Respective Email or Phone Number
	 * step3: Login and Go to My Account
	 * step4: Change Password with the New One
	 * step5: Logout and Login with the Same email with New PW
	 * step6: Verify whether it is Logged in with New PW and Logout again
	 */

	//Login
    @BeforeMethod
    public void Login() throws Throwable
    {
		String lemail= elib.getExcelData("ReUsableData", 38, 2);			
		String lpassword= elib.getExcelData("ReUsableData", 38, 3);		   
    	homePageObject.loginSuccessVerify(lemail, lpassword);
    	Thread.sleep(4000);
    }
    
    
    //Logout
    @AfterMethod
    public void Logout() throws Throwable
    {
    	myAccountPageObject.logout();
    }
	
		
	//Case 7 - Login, Change PW and Verify
    @Test
    public void TC7a_ChangePassword() throws Throwable
    {
		String OldPW= elib.getExcelData("ReUsableData", 38, 5);			
		String NewPW= elib.getExcelData("ReUsableData", 38, 6);		   
		String ConfirmPW= elib.getExcelData("ReUsableData", 38, 7);			
		String lemail= elib.getExcelData("ReUsableData", 38, 2);			
	
    	homePageObject.clickMySubscription();
    	Thread.sleep(2000);
    	myPaperPageObject.clickMyAccount();
    	myAccountPageObject.changePWVerifyValidData(OldPW, NewPW, ConfirmPW);

    	homePageObject.loginSuccessVerify(lemail, NewPW);							/* Verifying by login with NewPW*/
    	Thread.sleep(3000);
       	homePageObject.clickMySubscription();
    	myPaperPageObject.clickMyAccount();
    }
	
	
	@AfterClass 
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}
