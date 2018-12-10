package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TwitterLoginPageObject {
	
	@FindBy(xpath="//input[@placeholder='Phone, email or username']")
	public WebElement emailBox;

	@FindBy(xpath="//fieldset/div/input[@placeholder='Password']")
	public WebElement passwordBox;
	
	@FindBy(xpath="//button[text()='Log In']")
	public WebElement loginButton;
	
	@FindBy(xpath="//input[@value='Tweet']")
	public WebElement tweetButton;
	
	@FindBy(xpath="//div/div/ul/li/a[@href='/settings']")
	public WebElement profileButton;
	
	@FindBy(xpath="//b[text()='HT Account']")
	public WebElement accountButton;
	
	@FindBy(xpath="//div/ol[@id='stream-items-id']/li[1]/div[1]/div[2]/div[3]/div")
	public WebElement tweetedURL;
	
	//Functions
	public void passfbEmail(String twitteremail) throws Throwable{
		emailBox.sendKeys(twitteremail);
		Thread.sleep(500);
	}

	public void passfbPassword(String twitterpassword) throws Throwable{
		passwordBox.sendKeys(twitterpassword);
		Thread.sleep(500);
	}

	public void clickLogin() throws Throwable{
		loginButton.click();
		Thread.sleep(15000);
	}
	
	public void clickTweet() throws Throwable{
		tweetButton.click();
		Thread.sleep(4000);
	}

	public void clickProfile() throws Throwable{
		profileButton.click();
		Thread.sleep(1000);
	}
	
	public void clickAccountName() throws Throwable{
		accountButton.click();
		Thread.sleep(5000);
	}

	public void clickTweetedURL() throws Throwable{
		tweetedURL.click();
		Thread.sleep(2000);
	}

	
	
	
	//Optimization Functions
	public void twiterlogin(String twitteremail, String twitterpassword) throws Throwable{
		emailBox.sendKeys(twitteremail);
		Thread.sleep(500);
		passwordBox.sendKeys(twitterpassword);
		Thread.sleep(500);
		loginButton.click();
		Thread.sleep(15000);
	}
	
	
}
