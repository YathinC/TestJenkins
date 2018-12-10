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

public class ForgotPassword{
	
	//Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;

	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
	}
	
	/*
	 * step1: Open Login Popup
	 * step2: Enter Respective Email or Phone Number
	 * step3: Click on Reset Button
	 * step4: Verify Validation Error Texts
	 * step5: Closing the Popup 
	 */
	
	
	//Case 6a - Executing Forgot PW and getting RESET link
    @Test (enabled = true)
    public void TC6a_ForgotPW() throws Throwable
    {	    	
		String femail= elib.getExcelData("ReUsableData", 32, 2);    	
    	homePageObject.ForgotPWSuccessVerify(femail);
    	driver.navigate().refresh();
    	Thread.sleep(5000);
    }

	//Case 6b - TextBox Validation for Empty Placeholder
    @Test (enabled = true)
    public void TC6b_ForgotPWValidationForEmptyData() throws Throwable
    {	    	
    	homePageObject.ForgotPWErrorVerifyEmptyData();
    }

	//Case 6c - TextBox Validation for Invalid Email (Invalid format of Email "asd@sdf.")
    @Test (enabled = true)
    public void TC6c_ForgotPWValidationForInvalidEmail() throws Throwable
    {	    	
		String femail= elib.getExcelData("ReUsableData", 33, 2);    	
    	homePageObject.ForgotPWErrorVerifyInvalidData(femail);
    }
    
	//Case 6d - TextBox Validation for Invalid Phone No. (Phone no. should Start from 123 "3455467776")
    @Test (enabled = true)
    public void TC6d_ForgotPWValidationForInvalidPh() throws Throwable
    {	    	
		String femail= elib.getExcelData("ReUsableData", 33, 1);    	
    	homePageObject.ForgotPWErrorVerifyInvalidData(femail);
    }

	//Case 6e - Executing Forgot PW for Valid Email (letters with Numerics with (.) "DS.as9876@efgh.asa")
    @Test (enabled = true)
    public void TC6e_ForgotPWValidationForValidEmail() throws Throwable
    {	    	
		String femail= elib.getExcelData("ReUsableData", 34, 2);    	
    	homePageObject.ForgotPWSuccessVerify(femail);
    }
    
	//Case 6f - Executing Forgot PW for Valid Phone No. (having exact 10 digits "4455467776")
    @Test (enabled = true)
    public void TC6f_ForgotPWValidationForValidPh() throws Throwable
    {	    	
		String femail= elib.getExcelData("ReUsableData", 34, 1);    	
    	homePageObject.ForgotPWSuccessVerify(femail);
    }
	
	
	@AfterClass (enabled = true)
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}
