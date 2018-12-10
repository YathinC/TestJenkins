package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ReaderPaperPageObject {

	//Xpaths
	@FindBy(xpath="//meta[@name='description']")
	public WebElement MetaDescription;
	
	@FindBy(xpath="//meta[@name='keywords']")
	public WebElement MetaKeywords;
	
	@FindBy(tagName="h1")
	public WebElement H1Tag;
	
	@FindBy(xpath="//span[text()='Subscribe']")
	public WebElement subscribeButton;
	
	
	
	//Login
	@FindBy(id="inputidentifier")
	public WebElement lemailBox;
	
	@FindBy(id="inputpassword")
	public WebElement lpasswordBox;

	@FindBy(xpath="//button[text()='Login']")
	public WebElement PopupLoginButton;

	
	
	
	//Functions
	public void verifyMetadata(){
		Assert.assertTrue(MetaDescription.getAttribute("content").equals("Read Your Kannada Prabha Shimoga Edition ePaper on Paperboy & Stay Updated with Daily News Headlines on Business, Politics, Sports, Fashion, Finance, Technology & more."));
		Assert.assertTrue(MetaKeywords.getAttribute("content").equals("Kannada Prabha Kannada Shimoga ePaper"));
		Assert.assertTrue(H1Tag.getText().equals("KANNADA PRABHA SHIMOGA EDITION"));
	}

	public void clickSubscribe() throws Throwable{
		subscribeButton.click();
		Thread.sleep(2000);
	}
	
//	//Login screen Functions
//	public void passlEmail(String lemail){
//		lemailBox.sendKeys(lemail);
//	}
//	
//	public void passlPassword(String lpassword){
//		lpasswordBox.sendKeys(lpassword);
//	}
//	
//	public void clickLogin() throws Throwable{
//		PopupLoginButton.click();
//		Thread.sleep(3000);
//	}

	//Optimization functions	
	public void clickSubscribeAndLogin(String lemail, String lpassword) throws Throwable{
		subscribeButton.click();
		Thread.sleep(2000);
		lemailBox.sendKeys(lemail);
		lpasswordBox.sendKeys(lpassword);
		PopupLoginButton.click();
		Thread.sleep(3000);
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
