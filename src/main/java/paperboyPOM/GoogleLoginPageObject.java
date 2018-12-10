package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleLoginPageObject {

//		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("hashtaagtest1@gmail.com");
//		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("hashtaag123");
//		driver.findElement(By.xpath("//button[@value='Log In']")).click();
	
	@FindBy(id="identifierId")
	public WebElement emailBox;

	@FindBy(name="password")
	public WebElement passwordBox;
	
	@FindBy(name="login")
	public WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Next']")
	public WebElement nextButton;

	
	//Functions
	public void passGoogleEmail(String Gemail){
		emailBox.sendKeys(Gemail);
	}

	public void passGooglePassword(String Gpassword) throws Throwable{
		passwordBox.sendKeys(Gpassword);
		Thread.sleep(2000);
	}

	public void clickLogin() throws Throwable{
		loginButton.click();
		Thread.sleep(2000);
	}
	
	public void clickNext(){
		nextButton.click();
	}
	
}
