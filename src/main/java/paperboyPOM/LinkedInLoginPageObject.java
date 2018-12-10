package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInLoginPageObject {
	
	@FindBy(xpath="//input[@placeholder='Email or phone number']")
	public WebElement emailBox;

	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement passwordBox;
	
	@FindBy(xpath="//input[@value='Sign in']")
	public WebElement loginButton;
	
	//Functions
	public void passfbEmail(String LinkedInemail) throws Throwable{
		emailBox.sendKeys(LinkedInemail);
		Thread.sleep(500);
	}

	public void passfbPassword(String LinkedInpassword) throws Throwable{
		passwordBox.sendKeys(LinkedInpassword);
		Thread.sleep(500);
	}

	public void clickLogin() throws Throwable{
		loginButton.click();
		Thread.sleep(15000);
	}
	
	
	//Optimization Functions
	public void linkedInlogin(String LinkedInemail, String LinkedInpassword) throws Throwable{
		emailBox.sendKeys(LinkedInemail);
		Thread.sleep(500);
		passwordBox.sendKeys(LinkedInpassword);
		Thread.sleep(500);
		loginButton.click();
		Thread.sleep(15000);
	}
	
	
}
