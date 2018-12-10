package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FBLoginPageObject {
	
	@FindBy(id="email")
	public WebElement emailBox;

	@FindBy(id="pass")
	public WebElement passwordBox;
	
	@FindBy(id="loginbutton")
	public WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Post to Facebook']")
	public WebElement fbSharePostButton;
	
	@FindBy(xpath="//span[text()='Sanjay']")
	public WebElement userName;
	
	@FindBy(xpath="//div[@data-insertion-position='0']/div/div/div/div/div/div/div/div/div/div/span/div/a[@rel='nofollow']")
	public WebElement sharedLink;
	
	
	
	//Functions
	public void passfbEmail(String fbemail){
		emailBox.sendKeys(fbemail);
	}

	public void passfbPassword(String fbpassword){
		passwordBox.sendKeys(fbpassword);
	}

	public void clickLogin(){
		loginButton.click();
	}

	public void clickPost() throws Throwable{
		fbSharePostButton.click();
  		Thread.sleep(3000);
	}

	public void clickUserName() throws Throwable{
		userName.click();
	  	Thread.sleep(5000);
	}

	public void clicksharedLink() throws Throwable{
		sharedLink.click();
	  	Thread.sleep(1000);
	}
	
	//Optimization Functions
	public void fblogin(String fbemail, String fbpassword) throws Throwable{
		emailBox.sendKeys(fbemail);
		Thread.sleep(500);
		passwordBox.sendKeys(fbpassword);
		Thread.sleep(500);
		loginButton.click();
		Thread.sleep(15000);
	}
	
	
}
