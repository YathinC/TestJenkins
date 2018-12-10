package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyPaperPageObject {

	//xPaths
	@FindBy(xpath="//a[text()='My Subscriptions']")
	public WebElement mysubscriptionButton;
	
	@FindBy(xpath="//a[text()='LOG OUT']")
	public WebElement logoutButton;
	
	@FindBy(xpath="//li/div/div/p[text()='Sanjevani']")
	public WebElement sanjevaniText;
	
	@FindBy(xpath="//li/div/div/p[text()='Kannada Prabha']")
	public WebElement kannadaPrabhaText;

	@FindBy(xpath="//li/div/div/p[text()='Vijayavani']")
	public WebElement vijayavaniText;
	
	@FindBy(xpath="//li/div/div/p[text()='Udayavani']")
	public WebElement udayavaniText;

	@FindBy(xpath="//li/div/div/p[text()='Aragini']")
	public WebElement AraginiText;
	
	@FindBy(xpath="//li/div/div/p[text()='Job Offer']")
	public WebElement JobOfferText;
	
	
	
	@FindBy(xpath="//nav/ul/li/a[@href='/myaccount']")
	public WebElement myAccountButton;
	
	@FindBy(xpath="//span[text()='My Magazines']")
	public WebElement myMagazinesButton;

	@FindBy(xpath="//span[text()='Renewals']")
	public WebElement renewalsButton;
	
	@FindBy(xpath="//div/div/div/p[text()='Sakshi']/ancestor::div[4]/button[1]")
	public WebElement renewSakshiButton;
	
	@FindBy(xpath="//div[1]/div/ul[@class=\"newsubscription__list\"]/div/li[1]")
	public WebElement recomendationSubscribeButton;
	
	@FindBy(xpath="//div/div/div/p[text()='Evening Times']/ancestor::div[4]/button[2]")
	public WebElement unsubscribeEveningTimesButton;
	
	@FindBy(xpath="//button[text()='Yes, unsubscribe!']")
	public WebElement confirmUnsubscribeButton;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement dismissUnsubscribePopup;

	@FindBy(xpath="//div/div/div/p[text()='Sakshi']/following-sibling::p[1]")
	public WebElement validTillDateSakshi;

	
	
	
	
	
	
	
	
	
	//Functions
	public void logout(){
		logoutButton.click();
	}

	public void clickMyAccount(){
		myAccountButton.click();
	}
	
	public void clickMyMagazines() throws Throwable{
		myMagazinesButton.click();
		Thread.sleep(1000);
	}

	public void clickRenewals() throws Throwable{
		renewalsButton.click();
		Thread.sleep(1000);
	}
	
	public void clickRenewSakshi() throws Throwable{
		renewSakshiButton.click();
		Thread.sleep(2000);
	}
	
	public void clickUnsubscribeEveningTimes() throws Throwable{
		unsubscribeEveningTimesButton.click();
		Thread.sleep(2000);
	}
	
	public void confirmUnsubscribe() throws Throwable{
		confirmUnsubscribeButton.click();
		Thread.sleep(1000);
		dismissUnsubscribePopup.click();
		Thread.sleep(1000);
	}
	
	
	
	
	public void verifySubscribedPaperSanjevani(){
		Assert.assertTrue(sanjevaniText.isDisplayed());
	}

	public void verifySubscribedPaperKannadaPrabha(){
		Assert.assertTrue(kannadaPrabhaText.isDisplayed());
	}
	
	public void verifySubscribedPaperVijayavani(){
		Assert.assertTrue(vijayavaniText.isDisplayed());
	}
	
	public void verifySubscribedPaperUdayavani(){
		Assert.assertTrue(udayavaniText.isDisplayed());
	}

	
	public void verifySubscribedMagazineAragini(){
		Assert.assertTrue(AraginiText.isDisplayed());
	}
	
	public void verifySubscribedMagazineJobOffer(){
		Assert.assertTrue(JobOfferText.isDisplayed());
	}
	
	public void clickRecomendationSubscribeButton() throws Throwable{
		recomendationSubscribeButton.click();
		Thread.sleep(2000);
	}

	
	
	
	
	
}
