package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditionsReadMagazinesPageObject {

	//Xpaths
	@FindBy(xpath="//meta[@name='description']")
	public WebElement MetaDescription;
	
	@FindBy(xpath="//meta[@name='keywords']")
	public WebElement MetaKeywords;

	@FindBy(xpath="//div[@class='paper-desc']/span/h1")
	public WebElement H1Tag;
	
	@FindBy(xpath="//div[5]/button/span[@class='read-add-button-desc-page']")
	public WebElement readButton;
	
	//Functions
	public void verifyMetadata(){
		Assert.assertTrue(MetaDescription.getAttribute("content").equals("Get the latest issue of Gadgets & Gizmos English e-Magazine Online on Paperboy & enjoy reading them on Web, Android & iOS."));
		Assert.assertTrue(MetaKeywords.getAttribute("content").equals("Gadgets & Gizmos, Gadgets & Gizmos Magazine, Gadgets & Gizmos Magazine Online, Gadgets & Gizmos eMagazine"));
		Assert.assertTrue(H1Tag.getText().equals("Gadgets & Gizmos"));
	}
	
	public void clickRead() throws Throwable{
		readButton.click();
		Thread.sleep(2000);
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
