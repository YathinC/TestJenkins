package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPageObject {

	//xPaths
	@FindBy(xpath="//a[text()='My Subscriptions']")
	public WebElement mysubscriptionButton;
	
	@FindBy(xpath="//a[text()='LOG OUT']")
	public WebElement logoutButton;

	@FindBy(xpath="//nav/ul/li/a[@href='/myaccount']")
	public WebElement myAccountButton;

	@FindBy(xpath="//input[@ng-model='formUpdatePassword.oldPassword']")
	public WebElement oldPassword;
	
	@FindBy(xpath="//input[@ng-model='formUpdatePassword.newPassword']")
	public WebElement newPassword;
	
	@FindBy(xpath="//input[@ng-model='formUpdatePassword.confirmPassword']")
	public WebElement confirmPassword;
	
	@FindBy(className="change-password__update-button")
	public WebElement changePasswordUpdateButton;
	
	@FindBy(xpath="//div[text()='Password updated successfully']")
	public WebElement successMsgPasswordUpdatedSuccessfully;	
	
	
	//Functions
	public void logout(){
		logoutButton.click();
	}

	public void clickMyAccount(){
		myAccountButton.click();
	}


	
	/*   Optimization Functions   */	
	//Case 1 - Changing PW with Valid details  
	public void changePWVerifyValidData(String OldPW, String NewPW, String ConfirmPW) throws Throwable{
		oldPassword.sendKeys(OldPW);
		newPassword.sendKeys(NewPW);
		confirmPassword.sendKeys(ConfirmPW);
		changePasswordUpdateButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(successMsgPasswordUpdatedSuccessfully.isDisplayed());
		logoutButton.click();
		Thread.sleep(5000);
	}


	
	
	
}
