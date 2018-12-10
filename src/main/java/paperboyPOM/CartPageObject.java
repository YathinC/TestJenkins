package paperboyPOM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPageObject {

	//Object Declaration
	String Renewaldatesakshi;
	
	//Xpaths	
	@FindBy(xpath="//button[text()='Add']")
	public WebElement AddButton;
	
	@FindBy(xpath="//button[text()='Proceed']")
	public WebElement ProceedButton;
	
	@FindBy(xpath="//span[@class='subscribe-validity__date ng-binding']")
	public WebElement validTillDate;
	
	@FindBy(xpath="//label[text()='Subscription']/ancestor::div[1]/select")
	public WebElement subscriptionBox;

	@FindBy(xpath="//option[text()='one month']")
	public WebElement dropdownButton1Month;
 
	@FindBy(xpath="//option[text()='three months']")
	public WebElement dropdownButton3Months;
	
	@FindBy(xpath="//option[text()='six months']")
	public WebElement dropdownButton6Months;
	

	@FindBy(xpath="//option[text()='one year']")
	public WebElement dropdownButton1Year;
	
	
	
	//MyPapersPageElement
	@FindBy(xpath="//div/div/div/p[text()='Sakshi']/following-sibling::p[1]")
	public WebElement validTillDateSakshi;

	
	
	
	
	//Functions
	public void clickAdd() throws Throwable{
		AddButton.click();
		Thread.sleep(1000);
	}

	public void clickProceed() throws Throwable{
		ProceedButton.click();
		Thread.sleep(2000);
	}

	public void clickSubscriptionBox() throws Throwable{
		subscriptionBox.click();
		Thread.sleep(1000);
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

	//Optimization Functions
	public void proceedCart() throws Throwable{
		AddButton.click();
		Thread.sleep(1000);
		ProceedButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyDefaultValidTillDate() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 1);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/
		
		System.out.println(newDate);
	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	public void verifyValidTillDate3months() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 3);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying 3 Months
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	public void verifyValidTillDate6months() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 6);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	public void verifyValidTillDate1year() throws Throwable{
    	//Setting date for comparison
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");														/*Describing the date Format*/
		Date date = new Date();																								/*Getting the current date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 12);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	
	
	
	
	public void getValidTillDateSakshi() throws Throwable{
    	//Setting date for comparison
   	 	Renewaldatesakshi = validTillDateSakshi.getText();																	/* Fetching the Valid Till Date */
	}
	
	public void verifyDefaultValidTillDateRenew() throws Throwable{	
   	 	Renewaldatesakshi = Renewaldatesakshi.split("till ")[1];															/* Trimming the Texts "Valid Till " */
   	 	Date date = new SimpleDateFormat("MMM dd, yyyy").parse(Renewaldatesakshi);											/*Converting String to Date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 1);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");																			/*Describing the date Format*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	public void verifyValidTillDate3monthsRenew() throws Throwable{	
   	 	Date date = new SimpleDateFormat("MMM dd, yyyy").parse(Renewaldatesakshi);											/*Converting String to Date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 3);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");																			/*Describing the date Format*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying 3 Months
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}

	public void verifyValidTillDate6monthsRenew() throws Throwable{	
   	 	Date date = new SimpleDateFormat("MMM dd, yyyy").parse(Renewaldatesakshi);											/*Converting String to Date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 6);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");																			/*Describing the date Format*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying 6 Months
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	public void verifyValidTillDate1yearRenew() throws Throwable{	
   	 	Date date = new SimpleDateFormat("MMM dd, yyyy").parse(Renewaldatesakshi);											/*Converting String to Date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 12);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");																			/*Describing the date Format*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying 1 Year
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	public void verifyValidTillDate1monthRenew() throws Throwable{	
   	 	Date date = new SimpleDateFormat("MMM dd, yyyy").parse(Renewaldatesakshi);											/*Converting String to Date*/
		Calendar c = Calendar.getInstance();																				/*Calling a calendar Instance*/
		c.setTime(date);																									/*Setting the current date*/
		c.add(Calendar.MONTH, 1);																							/*Increasing the current date by One Month*/
		Date currentDatePlus1Month = c.getTime();																			/*Getting the new updated date from Calendar*/
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");																			/*Describing the date Format*/
		String newDate = dateFormat.format(currentDatePlus1Month);															/*Describing the Format for new updated date*/

	 	//Verifying Default Month(1Month)
		Assert.assertTrue(validTillDate.getText().equals("valid till "+newDate));
	}
	
	
	
	
	
	
	
	
	
}
