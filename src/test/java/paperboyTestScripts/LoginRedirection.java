package paperboyTestScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import genericLibrary.Browsers;

/**
 * 
 * @author Yathin
 *
 */

import genericLibrary.ExcelLibrary;
import paperboyPOM.HomePageObject;
import paperboyPOM.MyPaperPageObject;

public class LoginRedirection{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;

	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
	}
	
	/*
	 * step1: Open Login Popup
	 * step2: Enter Respective Email
	 * step3: Enter corresponding PW 
	 * step4: Click on Login Button
	 * step5: Verify redirection by Checking the listed Papers
	 * step6: Logout 
	 */
	
	//Case 3a - Login and Verify redirection to landing (Email = yathintest+58@gmail.com)
	@Test (enabled = true)
	public void TC3a_LoginRedirectionHome() throws Throwable{
		String lemail= elib.getExcelData("ReUsableData", 22, 2);						/* read data from ExcelSheet */
		String lpassword= elib.getExcelData("ReUsableData", 22, 3);	
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.verifyPaperPoliceNews();
		homePageObject.logout();
		Thread.sleep(3000);	
	}
	
	//Case 3b - Login and Verify Redirection to My Papers (Email = yathintest@gmail.com)
	@Test (enabled = true)
	public void TC3b_LoginRedirectionMypapers() throws Throwable{
		String lemail= elib.getExcelData("ReUsableData", 21, 2);
		String lpassword= elib.getExcelData("ReUsableData", 21, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		myPaperPageObject.verifySubscribedPaperSanjevani();
		myPaperPageObject.logout();
		Thread.sleep(3000);
	}
	
	
	@AfterClass (enabled = true)
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}
