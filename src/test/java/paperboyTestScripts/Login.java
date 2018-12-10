package paperboyTestScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import paperboyPOM.FBLoginPageObject;
import paperboyPOM.GoogleLoginPageObject;
import paperboyPOM.HomePageObject;
import paperboyPOM.MyPaperPageObject;

public class Login{
	
   //Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	MyPaperPageObject myPaperPageObject;
	FBLoginPageObject fbLoginPageObject;
	GoogleLoginPageObject googleLoginPageObject;

	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		myPaperPageObject = PageFactory.initElements(driver, MyPaperPageObject.class);
		fbLoginPageObject = PageFactory.initElements(driver, FBLoginPageObject.class);
		googleLoginPageObject = PageFactory.initElements(driver, GoogleLoginPageObject.class);
	}
	
	
	/* Test Case -
	 * step1: Open Login Popup
	 * step2: Enter Respective Email
	 * step3: Enter corresponding PW 
	 * step4: Click on Login Button
	 * step5: Verify the Validation by Checking Error Msgs
	 * step6: Logout  	 */

	
	//Case 1 - Login and Verify (Email "yathintest@gmail.com", Password "1234a")
	@Test (enabled = true)
	public void TC1a_Login() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 3, 2);						/* read data from ExcelSheet */
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.verifySubscribedPaperSanjevani();
		myPaperPageObject.logout();
		Thread.sleep(3000);
	}
	
	/* Case 1 - Login Validation for Empty Placeholder */	
	//Case 1b - Empty Email & Empty PW 
	@Test (enabled = true)
	public void TC1b_LoginValidationForEmptyData() throws Throwable
	{
	 	homePageObject.openLogin();
		homePageObject.loginErrorVerifyEmptyData();
	}

	//Case 1a2 - //Empty Email & Valid PW
	@Test (enabled = true)
	public void TC1c_LoginValidationForEmptyEmail() throws Throwable
	{
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.openLogin();
		homePageObject.passlPassword(lpassword);
		homePageObject.loginErrorVerifyEmptyData();
	}
	
	//Case 1a3 - Valid Email & Empty PW
	@Test (enabled = true)
	public void TC1d_LoginValidationForEmptyPassword() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 3, 2);
		homePageObject.openLogin();
		homePageObject.passlEmail(lemail);
		homePageObject.loginErrorVerifyEmptyData();
	}
	
	
	/*  Case 1B - Login Validation for Email Placeholder  */
	
	//Case 1b1 - Valid PW & Invalid Phone No. (less than 10 digits "456478378")
	@Test (enabled = true)
	public void TC1e_LoginValidationForInvalidPhNo1() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 13, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);
		homePageObject.loginErrorVerifyInvalidPh(lphno, lpassword);
	}
	
	//Case 1b2 - Valid PW & Invalid Phone No. (More than 10 digits "67849898989")
	@Test (enabled = true)
	public void TC1f_LoginValidationForInvalidPhNo2() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 14, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidPh(lphno, lpassword);
	}
	
	//Case 1b3 - Valid PW & Invalid Phone No. (10 digits alphanumerics "65432qwert")
	@Test (enabled = true)
	public void TC1g_LoginValidationForInvalidPhNo3() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 15, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidPh(lphno, lpassword);
	}
	
	//Case 1b4 - //Valid PW & Invalid Phone No. (10 Special Characters "!@#$%^&*()")
	@Test (enabled = true)
	public void TC1h_LoginValidationForInvalidPhNo4() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 16, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidPh(lphno, lpassword);
	}
	
	//Case 1b5 - //Valid PW & Invalid Phone No. (10 digits including special Characters "67849!@%^&")
	@Test (enabled = true)
	public void TC1i_LoginValidationForInvalidPhNo5() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 17, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidPh(lphno, lpassword);
	}
	
	//Case 1b6 - //Valid PW & Invalid Phone No. (Phone no. should Start from 123 "3455467776")
	@Test (enabled = true)
	public void TC1j_LoginValidationForInvalidPhNo6() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 18, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidPh(lphno, lpassword);
	}

	//Case 1b7 - //Valid PW & valid Phone No. (having exact 10 digits "4455467776")
	@Test (enabled = true)
	public void TC1k_LoginValidationForValidPhNo() throws Throwable
	{
		String lphno= elib.getExcelData("ReUsableData", 19, 1);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginSuccessVerify(lphno, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.logout();
		Thread.sleep(3000);
	}
	
	//Case 1b8 - //Valid PW & Invalid Email (only alphabetical "dsdf")
	@Test (enabled = true)
	public void TC1l_LoginValidationForInvalidEmail1() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 4, 2);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidEmail(lemail, lpassword);
	}
	
	//Case 1b9 - //Valid PW & Invalid Email (Invalid format of Email "asd@sdf.")
	@Test (enabled = true)
	public void TC1m_LoginValidationForInvalidEmail2() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 5, 2);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginErrorVerifyInvalidEmail(lemail, lpassword);
	}
	
	//Case 1b10 - //Valid PW & Valid Email (only letters (a-z) with CAPS "adsQWE@as.as")
	@Test (enabled = true)
	public void TC1n_LoginValidationForValidEmail1() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 6, 2);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.logout();
		Thread.sleep(3000);
		
	}
	
	//Case 1b11 - //Valid PW & Valid Email (Only Numerics(0-9) "4677@dfg.dfg")
	@Test (enabled = true)
	public void TC1o_LoginValidationForValidEmail2() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 7, 2);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.logout();
		Thread.sleep(3000);
	}
	
	//Case 1b12 - //Valid PW & Valid Email (letters with Numerics "asdQWE33@ass.as")
	@Test (enabled = true)
	public void TC1p_LoginValidationForValidEmail3() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 8, 2);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.logout();
		Thread.sleep(3000);	
	}
	
	//Case 1b13 - //Valid PW & Valid Email (letters with Numerics with (.) "DS.as9876@efgh.asa")
	@Test (enabled = true)
	public void TC1q_LoginValidationForValidEmail4() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 9, 2);
		String lpassword= elib.getExcelData("ReUsableData", 3, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.logout();
		Thread.sleep(3000);
		
	}
	
	/* Case 1C - Login Validation for Password Placeholder */
	
	//Case 1c1 - Valid Email & Invalid PW (Only Numerics "1234567") 
	@Test (enabled = true)
	public void TC1r_LoginValidationForInvalidPassword() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 3, 2);
		String lpassword= elib.getExcelData("ReUsableData", 11, 3);		
		homePageObject.loginErrorVerifyInvalidPassword(lemail, lpassword);
	}
	
	//Case 1c2 - //Valid Email & Valid PW (Alphanumerics with CAPS and special Characters with length more than or equal to 5 "1234ASDFqwer!@#$")
	@Test (enabled = true)
	public void TC1s_LoginValidationForValidPassword() throws Throwable
	{
		String lemail= elib.getExcelData("ReUsableData", 10, 2);
		String lpassword= elib.getExcelData("ReUsableData", 10, 3);		
		homePageObject.loginSuccessVerify(lemail, lpassword);
		Thread.sleep(2000);
		homePageObject.clickMySubscription();
		Thread.sleep(2000);
		myPaperPageObject.logout();
		Thread.sleep(3000);
	}
	
	/* Case 1D - Checking Social Logins */	
	//1d1 - Checking Fresh FB Login
	@Test (enabled = true)
	public void TC1t_FBLogin() throws Throwable
	{
		String fbemail= elib.getExcelData("ReUsableData", 25, 2);
		String fbpassword= elib.getExcelData("ReUsableData", 25, 3);		

		homePageObject.openLogin();
		homePageObject.clickFbLogin();
		Thread.sleep(4000);
  		String CurrentWindow = driver.getWindowHandle();					/*Handling Windows*/						/* Initiating Window Handling for the existing Window */
	  		for(String winHandle : driver.getWindowHandles()){															/* Handling the New Opened Window */
	  		    driver.switchTo().window(winHandle);
	  		}
    	fbLoginPageObject.fblogin(fbemail, fbpassword);
		driver.switchTo().window(CurrentWindow);																		/* Switching the Handling to the Previous Window */
		myPaperPageObject.logout();
		Thread.sleep(3000);		
	}	
	
	//1d2 - Checking Google Login
	@Test (enabled = true)
	public void TC1u_GoogleLogin() throws Throwable
	{
		String Gemail= elib.getExcelData("ReUsableData", 28, 2);
		String Gpassword= elib.getExcelData("ReUsableData", 28, 3);		

		homePageObject.openLogin();
		homePageObject.clickGoogleLogin();
		Thread.sleep(4000);
  		String CurrentWindow = driver.getWindowHandle();					/*Handling Windows*/						/* Initiating Window Handling for the existing Window */
	  		for(String winHandle : driver.getWindowHandles()){															/* Handling the New Opened Window */
	  		    driver.switchTo().window(winHandle);
	  		}
  		googleLoginPageObject.passGoogleEmail(Gemail);
		Thread.sleep(2000);
  		googleLoginPageObject.clickNext();
		Thread.sleep(3000);
  		googleLoginPageObject.passGooglePassword(Gpassword);
		Thread.sleep(2000);
  		googleLoginPageObject.clickNext();
		Thread.sleep(20000);
  		driver.switchTo().window(CurrentWindow);																		/* Switching the Handling to the Previous Window */
		myPaperPageObject.logout();
		Thread.sleep(3000);		
	}	
	
	//1E - Checking the redirection Functions of other buttons in the screen
	@Test (enabled = true)
	public void TC1v_OtherFunctions() throws Throwable
	{
 		//Checking the Popup Close using Close button
		homePageObject.openLogin();
		homePageObject.displayLoginButton();
		homePageObject.closeLoginPopup();
		Thread.sleep(4000);
		
	 	//Checking the Popup Close on tapping Escape Key
		homePageObject.openLogin();
		homePageObject.displayLoginButton();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);				
		Thread.sleep(4000);
		
		//Checking the Popup Close on clicking outside Popup	
		homePageObject.openLogin();
		homePageObject.displayLoginButton();
		Thread.sleep(1000);		
		Actions builder = new Actions(driver);  
		WebElement x = driver.findElement(By.xpath("//div[@id='loginModal']"));
		builder.moveToElement(x, 100, 100).click().build().perform();
		Thread.sleep(4000);
		
		//Redirection to Sign Up screen
		homePageObject.openLogin();
		homePageObject.clickCreateAccount();
		homePageObject.displayRegisterButton();
		homePageObject.closeRegisterPopup();
		Thread.sleep(4000);
		
		//Redirection to ForgotPW screen		
		homePageObject.openLogin();
		homePageObject.clickForgot();
		homePageObject.displayResetPWButton();
		homePageObject.closeForgotPWPopup();
		Thread.sleep(4000);
}	
	
	
	
	
	@AfterClass (enabled = true)
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}
