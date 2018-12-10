package paperboyPOM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditionsSubscribePaperPageObject {

	//Xpaths	
	@FindBy(xpath="//button[1]/span[text()='Add']")
	public WebElement AddButton;
	
	@FindBy(xpath="//div/p/span[@class='ng-binding']")
	public WebElement validTillDate;
	
	@FindBy(xpath="//label[text()='Subscription Renewal']/ancestor::div[1]/div")
	public WebElement subscriptionRenewalBox;

	@FindBy(xpath="//li/span[text()='one month ']")
	public WebElement dropdownButton1Month;
 
	@FindBy(xpath="//li/span[text()='three months ']")
	public WebElement dropdownButton3Months;
	
	@FindBy(xpath="//li/span[text()='six months ']")
	public WebElement dropdownButton6Months;
	
	@FindBy(xpath="//li/span[text()='one year ']")
	public WebElement dropdownButton1Year;
	
	
	
	
	//Functions
	public void clickAdd() throws Throwable{
		AddButton.click();
		Thread.sleep(2000);
	}
	
	public void clickSubscriptionRenewalBox() throws Throwable{
		subscriptionRenewalBox.click();
		Thread.sleep(500);
	}
	
	public void clickDropdownButton1Month() throws Throwable{
		dropdownButton1Month.click();
		Thread.sleep(500);
	}
	
	public void clickDropdownButton3Months() throws Throwable{
		dropdownButton3Months.click();
		Thread.sleep(500);
	}

	public void clickDropdownButton6Months() throws Throwable{
		dropdownButton6Months.click();
		Thread.sleep(500);
	}
	
	public void clickDropdownButton1Year() throws Throwable{
		dropdownButton1Year.click();
		Thread.sleep(500);
	}

	public void verifyDefaultValidTillDate() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 1);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals(newDate));
	}
	
	public void verifyValidTillDate3months() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 3);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals(newDate));
	}
	
	public void verifyValidTillDate6months() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 6);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals(newDate));
	}
	
	public void verifyValidTillDate1year() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 12);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals(newDate));
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
