package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditionsSubscribeMagazinePageObject {

	//Xpaths	
	@FindBy(xpath="//button[2]/span[text()='Add']")
	public WebElement AddButton;
	
	
	//Functions
	public void clickAdd() throws Throwable{
		AddButton.click();
		Thread.sleep(1000);
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
