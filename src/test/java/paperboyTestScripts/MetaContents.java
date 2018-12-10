package paperboyTestScripts;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import genericLibrary.Browsers;
/**
 * 
 * @author Yathin
 *
 */


import genericLibrary.ExcelLibrary;
import paperboyPOM.EditionsReadMagazinesPageObject;
import paperboyPOM.EditionsReadPaperPageObject;
import paperboyPOM.HomePageObject;
import paperboyPOM.LanguageMagazinesPageObject;
import paperboyPOM.LanguagePapersPageObject;
import paperboyPOM.ReaderMagazinePageObject;
import paperboyPOM.ReaderPaperPageObject;


public class MetaContents{
	
   //Object Declaration
	WebDriver driver;
	ExcelLibrary elib= new ExcelLibrary();
	HomePageObject homePageObject;
	LanguagePapersPageObject languagePapersPageObject;
	LanguageMagazinesPageObject languageMagazinesPageObject;
	EditionsReadPaperPageObject editionsReadPaperPageObject;
	EditionsReadMagazinesPageObject editionsReadMagazinesPageObject;
	ReaderPaperPageObject readerPaperPageObject;	
	ReaderMagazinePageObject readerMagazinePageObject;
	
	//Initialising object and Launching browser
	@BeforeClass
	public void launchBrowser() throws Throwable{
		driver = Browsers.getBrowser();
		Reporter.log("-----Browser launch successfully-----");
		
		homePageObject = PageFactory.initElements(driver, HomePageObject.class);
		languagePapersPageObject = PageFactory.initElements(driver, LanguagePapersPageObject.class);
		languageMagazinesPageObject = PageFactory.initElements(driver, LanguageMagazinesPageObject.class);
		editionsReadPaperPageObject = PageFactory.initElements(driver, EditionsReadPaperPageObject.class);
		editionsReadMagazinesPageObject = PageFactory.initElements(driver, EditionsReadMagazinesPageObject.class);
		readerPaperPageObject = PageFactory.initElements(driver, ReaderPaperPageObject.class);
		readerMagazinePageObject = PageFactory.initElements(driver, ReaderMagazinePageObject.class);
	}
	
	
	/*
	 * step1: Redirecting to Required Url 
	 * step2: Verifying the Title
	 * step3: Verifying MetaData
	 */


	
	 //Case 8a - Verifying MetaContents(https://www.paperboy.com/)
     @Test
     public void TC8a_Home() throws Throwable
     {	
    	driver.get("https://www.paperboy.com/");
    	Thread.sleep(2000);
    	assertTrue(driver.getTitle().contains("Paperboy: Online Newspapers & Magazines, ePapers - Read on Web, Android & iOS"));
    	homePageObject.verifyMetadata();
     }
	
	   
     //Case 8b - Verifying MetaContents(https://www.paperboy.com/newspapers/english)
 	 @Test (enabled = true)
     public void TC8b_LanguagePaper() throws Throwable
     {
 		driver.get("https://www.paperboy.com/newspapers/english");
    	Thread.sleep(2000);
 		assertTrue(driver.getTitle().contains("English Newspapers Online: Get Today ePapers on Web, Android & iOS - Paperboy.com"));
    	languagePapersPageObject.verifyMetadata();
     }

 	
 	//Case 8c - Verifying MetaContents(https://www.paperboy.com/kannada-prabha-newspaper-read)  	
 	 @Test (enabled = true)
     public void TC8c_EditionsReadPaper() throws Throwable
     {
 		driver.get("https://www.paperboy.com/kannada-prabha-newspaper-read");
    	Thread.sleep(2000);
    	assertTrue(driver.getTitle().contains("Kannada Prabha Kannada Newspaper, Get Todays ePaper on Web, Android & iOS - Paperboy"));
    	editionsReadPaperPageObject.verifyMetadata();
     }	
 		

 	 //Case 8d - Verifying MetaContents(https://www.paperboy.com/kannada-prabha-shimoga-epaper/883)  	
 	 @Test (enabled = true)
     public void TC8d_ReaderPaper() throws Throwable
     {
 		driver.get("https://www.paperboy.com/kannada-prabha-shimoga-epaper/883");
 	 	Thread.sleep(2000);
     	assertTrue(driver.getTitle().contains("Kannada Prabha Kannada Shimoga ePaper, Karnataka, Get Today eNewspaper on Web, Android & iOS"));
     	readerPaperPageObject.verifyMetadata();
}	 
 		
 	
 	 //Case 8e - Verifying MetaContents(https://www.paperboy.com/magazines/kannada)  	
 	 @Test (enabled = true)
     public void TC8e_LanguageMagazine() throws Throwable
     {
 		driver.get("https://www.paperboy.com/magazines/kannada");
	 	Thread.sleep(2000);
    	assertTrue(driver.getTitle().contains("Kannada Magazines Online: Get Your eMagazines on Web, Android & iOS - Paperboy.com"));
     	languageMagazinesPageObject.verifyMetadata();
     }	 
 	 
 	//Case 8f - Verifying MetaContents(https://www.paperboy.com/gadgets-&-gizmos-magazine-read)  	
 	 @Test (enabled = true)
     public void TC8f_EditionsReadMagazine() throws Throwable
     {
 		driver.get("https://www.paperboy.com/gadgets-&-gizmos-magazine-read");
	 	Thread.sleep(2000);
 		assertTrue(driver.getTitle().contains("Gadgets & Gizmos English Magazine, Get Your Magazine on Web, Android & iOS - Paperboy"));
		editionsReadMagazinesPageObject.verifyMetadata();
     }	
 	 
 	//Case 8g - Verifying MetaContents(https://www.paperboy.com/gadgets-&-gizmos-bangalore-emagazine/681)  	
 	 @Test (enabled = true)
     public void TC8g_ReaderMagazine() throws Throwable
     {
 		driver.get("https://www.paperboy.com/gadgets-&-gizmos-bangalore-emagazine/681");
	 	Thread.sleep(2000);
    	assertTrue(driver.getTitle().contains("Gadgets & Gizmos English Bangalore eMagazine, Karnataka, Get Your eMagazine on Web, Android & iOS"));
    	readerMagazinePageObject.verifyMetadata();
     }	
 	 
 	 
 	@AfterClass (enabled = true)
 	public void closeBrowser() throws Throwable{	
 		driver.close();
 	}

 	 
 	 
}

