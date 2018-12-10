package paperboyTestScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Yathin
 *
 */

import genericLibrary.Browsers;
import genericLibrary.ExcelLibrary;
import paperboyPOM.HomePageObject;

public class Search{
	
   //Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;

	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);		
	}
	
	
	/*
	 * step1: Clearing the existing Search Texts
	 * step2: Entering Search Texts
	 * step3: Click on Searched Paper
	 * step4: Verifying the displayed Results
	 */


	
	//Case4a - Verifying Paper Search
	@Test
	public void TC4a_SearchPaper() throws Throwable
	{
		Thread.sleep(3000);
		String paper= elib.getExcelData("ReUsableData", 36, 8);
		homePageObject.clearSearchTexts();
		homePageObject.enterSearchTextsPaper(paper);
		Thread.sleep(2000);
		homePageObject.clickSearchedPaperSanjevani();
		Thread.sleep(2000);
		homePageObject.verifyPaperSanjevani();
	}
	
	//Case4b - Verifying Magazine Search
	@Test 
	public void TC4b_SearchMagazine() throws Throwable
	{
		String magazine= elib.getExcelData("ReUsableData", 36, 9);
		homePageObject.clearSearchTexts();
		homePageObject.enterSearchTextsMagazine(magazine);
		Thread.sleep(2000);
		homePageObject.clickSearchedMagazineCosmopolitan();
		Thread.sleep(2000);
		homePageObject.verifyMagazineCosmopolitan();
	}
	

    //case4c - Verifying State Search
	@Test 
	public void TC4c_SearchState() throws Throwable
	{
		String state= elib.getExcelData("ReUsableData", 36, 10);
//		homePageObject.searchBox.clear();
		homePageObject.clearSearchTexts();
		homePageObject.enterSearchTextsMagazine(state);
		Thread.sleep(2000);
		homePageObject.clickSearchedStateDelhi();
		Thread.sleep(2000);
		homePageObject.verifyStateDelhi();
	}



	
	@AfterClass (enabled = true)
	public void closeBrowser() throws Throwable{	
		driver.close();
	}
	
	

}