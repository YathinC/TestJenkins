package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LanguageMagazinesPageObject {

	//Xpaths
	@FindBy(xpath="//meta[@name='description']")
	public WebElement MetaDescription;
	
	@FindBy(xpath="//meta[@name='keywords']")
	public WebElement MetaKeywords;
	
	
	//Functions
	public void verifyMetadata(){
		Assert.assertTrue(MetaDescription.getAttribute("content").contains("Get the latest issue of all your favorite Kannada e-Magazines Online on Paperboy & enjoy reading them on Web, Android & iOS."));
		Assert.assertTrue(MetaKeywords.getAttribute("content").contains("Kannada Magazines, Kannada e-magazines, Kannada Magazines Online, Digital Kannada Magazines"));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//Case 1 - Login and Verify
//	public void loginToPaperboy(String lemail, String lpassword){
//		LoginSignupButton.click();
//		lemailBox.sendKeys(lemail);
//		lpasswordBox.sendKeys(lpassword);
//		PopupLoginButton.click();
//	}
//	
//	//Case 2 - Login Validation for Empty Placeholder
//	public void loginToPaperboy2(String lemail, String lpassword){
//
//		//Empty Email & Empty PW 
//		LoginSignupButton.click();
//		PopupLoginButton.click();	 			
//		Assert.assertTrue(ErrorText1.isDisplayed());
//		PopupCloseButton.click();
//
//		//Empty Email & Valid PW 
//		LoginSignupButton.click();
//		lpasswordBox.sendKeys(lpassword);
//		PopupLoginButton.click();
//		Assert.assertTrue(ErrorText1.isDisplayed());
//		PopupCloseButton.click();
//	
//		//Valid Email & Empty PW 
//		LoginSignupButton.click();
//		lemailBox.sendKeys(lemail);
//		PopupLoginButton.click();
//		Assert.assertTrue(ErrorText1.isDisplayed());
//		PopupCloseButton.click();		
//		
//	}

	
	
	
}
