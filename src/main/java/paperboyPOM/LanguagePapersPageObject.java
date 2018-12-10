package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LanguagePapersPageObject {

	//Xpaths
	@FindBy(xpath="//meta[@name='description']")
	public WebElement MetaDescription;
	
	@FindBy(xpath="//meta[@name='keywords']")
	public WebElement MetaKeywords;
	
	
	//Functions
	public void verifyMetadata(){
		Assert.assertTrue(MetaDescription.getAttribute("content").contains("Enjoy reading all your favourite English Newspapers Online and keep yourself informed with daily news headlines from around the world related to Business, Politics, Fashion, Technology, Sports, Entertainment and more, only on Paperboy."));
		Assert.assertTrue(MetaKeywords.getAttribute("content").contains("English Newspapers, English ePapers,English Newspapers Online, Digital Newspapers in English, Daily English Newspapers, Today's English Newspapers, Read epapers in English"));
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
