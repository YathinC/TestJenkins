package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditionsReadPaperPageObject {

	//Xpaths
	@FindBy(xpath="//meta[@name='description']")
	public WebElement MetaDescription;
	
	@FindBy(xpath="//meta[@name='keywords']")
	public WebElement MetaKeywords;
	
	@FindBy(xpath="//div[@class='paper-desc']/span/h1")
	public WebElement H1Tag;
	
	@FindBy(xpath="//div[5]/button/span[@class='read-add-button-desc-page']")
	public WebElement readButton;
	
	@FindBy(xpath="//div/div/div/div/ul/li/a[@title='Facebook']/ancestor::li")
	public WebElement fbShareButton;
	
	@FindBy(xpath="//div/div/div/div/ul/li/a[@title='Twitter']/ancestor::li")
	public WebElement twitterShareButton;
	
	@FindBy(xpath="//a[@href='/newspapers']")
	public WebElement newspapersButton;
	
	//Functions
	public void verifyMetadata(){
		Assert.assertTrue(MetaDescription.getAttribute("content").equals("Read Your Favourite Kannada Prabha Kannada Newspaper/ePaper Online on Paperboy & Stay Updated with Daily News Headlines on Business, Politics, Sports, Fashion, Finance, Technology & more."));
		Assert.assertTrue(MetaKeywords.getAttribute("content").equals("Kannada Prabha, Kannada Prabha newspaper, Kannada Prabha epaper, today Kannada Prabha newspaper"));
		Assert.assertTrue(H1Tag.getText().equals("Kannada Prabha"));
	}

	public void clickRead() throws Throwable{
		readButton.click();
		Thread.sleep(2000);
	}
	
	public void clickfbShare() throws Throwable{
		fbShareButton.click();
		Thread.sleep(5000);
	}
	
	public void clickTwitterShare() throws Throwable{
		twitterShareButton.click();
		Thread.sleep(3000);
	}
	
	
	
	
	public void clickNewspapers() throws Throwable{
		fbShareButton.click();
		Thread.sleep(5000);
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
