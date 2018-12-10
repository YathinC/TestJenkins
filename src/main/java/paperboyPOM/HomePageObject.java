package paperboyPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePageObject {

	//Xpaths
	//Home Screen
	@FindBy(xpath="//a[@href='/newspapers']")
	public WebElement newspaperButton;
	
	@FindBy(xpath="//a[@href='/magazines']")
	public WebElement magazineButton;
	
	@FindBy(xpath="//a[@href='/mypaper']")
	public WebElement MySubscriptionButton;
	
	@FindBy(xpath="//a[text()='Log In/ Sign Up']")
	public WebElement LoginSignupButton;	
	
	@FindBy(id="autoComplete")
	public WebElement searchBox;

	@FindBy(xpath="//li[text()='Sanjevani']")
	public WebElement searchedPaperSanjevani;
	
	@FindBy(xpath="//p[text()='Sanjevani']")
	public WebElement listedPaperSanjevani;

	@FindBy(xpath="//span/a[@href='vijayavani-newspaper-read']")
	public WebElement listedPaperVijayavani;

	@FindBy(xpath="//span/a[@href='udayavani-newspaper-read']")
	public WebElement listedPaperUdayavani;
	
	@FindBy(xpath="//a[@href='kannada-prabha-newspaper-subscribe']")
	public WebElement SubscribeButtonKannadaPrabha;
	
	@FindBy(xpath="//a[@href='aragini-magazine-subscribe']")
	public WebElement SubscribeButtonAragini;
	
//	@FindBy(xpath="//span/a[@href='job-offer-magazine-read']")
	@FindBy(xpath="//div/a[@href='job-offer-magazine-read']")
	
	
	public WebElement listedMagazineJobOffer;
	
	
	//span/a[@href='job-offer-magazine-read']

	@FindBy(xpath="//p[@href='police-news-newspaper-read']")
	public WebElement listedPaperPoliceNews;

	@FindBy(xpath="//li[text()='Cosmopolitan']")
	public WebElement searchedMagazineCosmopolitan;
	
	@FindBy(xpath="//p[text()='Cosmopolitan']")
	public WebElement listedMagazineCosmopolitan;

	@FindBy(xpath="//li[text()='Delhi']")
	public WebElement searchedStateDelhi;
	
	@FindBy(xpath="//p[text()='Dainik Jagran']")
	public WebElement listedPaperDainikJagran;
	
	@FindBy(xpath="//p[text()='The Hans India']")
	public WebElement listedPaperTheHansIndia;
				
	@FindBy(xpath="//meta[@name='description']")
	public WebElement MetaDescription;
	
	@FindBy(xpath="//meta[@name='keywords']")
	public WebElement MetaKeywords;

	@FindBy(xpath="//a[text()='LOG OUT']")
	public WebElement logoutButton;

	
	
	
	
	//Login Screen
	@FindBy(id="inputidentifier")
	public WebElement lemailBox;

	@FindBy(id="inputidentifier")
	public WebElement lphoneNoBox;
	
	@FindBy(id="inputpassword")
	public WebElement lpasswordBox;

	@FindBy(xpath="//button[text()='Login']")
	public WebElement PopupLoginButton;

	@FindBy(xpath="//div[@id='loginModal']/div/header/div/img")
	public WebElement LoginPopupCloseButton;

	@FindBy(xpath="//div/div/div/div/a/div/p[text()='Sign in with facebook']")
	public WebElement FbLoginButton;

	@FindBy(xpath="//div/div/div/div/a/div/p[text()='sign in with google']")
	public WebElement GoogleLoginButton;

	@FindBy(xpath="//a[text()='Forgot?']")
	public WebElement ForgotButton;			
	
	@FindBy(xpath="//div[4]/div/footer/a[text()='Create Account']")
	public WebElement CreateAccountButton;	
	
	@FindBy(xpath="//div[text()='All fields required']")
	public WebElement ErrorAllFieldsRequired;
	
	@FindBy(xpath="//div[text()='You are not yet registered. Please register']")
	public WebElement ErrorYouAreNotYetRegistered;

	@FindBy(xpath="//div[text()='Please check your credentials']")
	public WebElement ErrorPleaseCheckYourCredentials;	

	
	//Register
	@FindBy(xpath="//button[text()='Register']")
	public WebElement PopupRegisterButton;

	@FindBy(xpath="//div[@id='signUpModal']/div/header/div/img")
	public WebElement RegisterPopupCloseButton;
	
	
	//Forgot
	@FindBy(xpath="//div[6]/div/div/form/button[text()='Reset my password']")
	public WebElement ResetPasswordButton;				
	
	@FindBy(xpath="//div[@id='forgotpasswordModal']/div/header/div/img")
	public WebElement ForgotPWPopupCloseButton;
	
	@FindBy(xpath="//form/div/input[@placeholder='Email or Phone number']")
	public WebElement femailBox;
	
	@FindBy(xpath="//p[text()=\"We've sent you a link to reset your password. Please check your Email/Mobile inbox.\"]")
	public WebElement fpwSuccessPopup;
	
	@FindBy(xpath="//div[text()='Please enter a email or phone number']")
	public WebElement fpwErrorPleaseEnterEmailorPhoneNumber;	
	
	@FindBy(xpath="//div[text()='Please enter a valid email or phone number']")
	public WebElement fpwErrorPleaseEnterValidEmailorPhoneNumber;	

	@FindBy(xpath="//img[@class='emailrecieved']/ancestor::div[2]/header/div/img")
	public WebElement fpwSuccessPopupCloseButton;
	
	@FindBy(xpath="//p[text()='Forgot your password?']/ancestor::div[2]/header/div/img")
	public WebElement fpwPopupCloseButton;
	
		
	
	
	
	//Functions

	//Home screen Functions 
	public void openLogin(){
		LoginSignupButton.click();
	}

	public void clickMySubscription() throws Throwable{
		MySubscriptionButton.click();
		Thread.sleep(2000);
	}

	public void clearSearchTexts(){
		searchBox.clear();
	}

	public void enterSearchTextsPaper(String paper){
		searchBox.sendKeys(paper);
	}
		
	public void enterSearchTextsMagazine(String magazine){
		searchBox.sendKeys(magazine);
	}

	public void enterSearchTextsState(String state){
		searchBox.sendKeys(state);
	}
	
	public void clickSearchedPaperSanjevani(){
		searchedPaperSanjevani.click();
	}
	
	public void verifyPaperSanjevani(){
		Assert.assertTrue(listedPaperSanjevani.isDisplayed());
	}
	
	public void verifyPaperPoliceNews(){
		Assert.assertTrue(listedPaperPoliceNews.isDisplayed());
	}

	public void clickReadVijayavani() throws Throwable{
		listedPaperVijayavani.click();
		Thread.sleep(2000);
	}

	public void clickReadUdayavani() throws Throwable{
		listedPaperUdayavani.click();
		Thread.sleep(2000);
	}
	
	public void clickSubscribeKannadaPrabha() throws Throwable{
		SubscribeButtonKannadaPrabha.click();
		Thread.sleep(2000);
		
	}
	
	public void clickSubscribeAragini() throws Throwable{
		SubscribeButtonAragini.click();
		Thread.sleep(2000);
	}
		
	public void clickReadJobOffer() throws Throwable{
		listedMagazineJobOffer.click();
		Thread.sleep(2000);
	}

	public void clickSearchedMagazineCosmopolitan(){
		searchedMagazineCosmopolitan.click();
	}
	
	public void verifyMagazineCosmopolitan(){
		Assert.assertTrue(listedMagazineCosmopolitan.isDisplayed());
	}

	public void clickSearchedStateDelhi(){
		searchedStateDelhi.click();
	}
	
	public void verifyStateDelhi(){
		Assert.assertTrue(listedPaperDainikJagran.isDisplayed());
		Assert.assertTrue(listedPaperTheHansIndia.isDisplayed());
	}
		
	public void verifyMetadata(){
		
		Assert.assertTrue(MetaDescription.getAttribute("content").contains("Paperboy provides free online news papers and magazines for web, iOS and android platforms.With a clean and simple interface, the app contains no pop up ads or interferences, and lets one access their news both in online and offline mode; thus, making it easy to for people to read the newspapers at their convenience."));
		Assert.assertTrue(MetaKeywords.getAttribute("content").contains("Newspapers, magazines, newspapers online, magazines online, regional newspapers, regional magazines, epapers,Android magazine, PDF for smartphones, iOS magazines, digital magazine, Digital subscription, magazine subscription, digital books, ebooks, digital india, free magazine subscription, free magazine pdf, download emagazine, magazine app for ipad, magazine app for android"));
	}

	public void logout(){
		logoutButton.click();
	}
	
	
	//Login screen Functions
	public void passlEmail(String lemail){
		lemailBox.sendKeys(lemail);
	}
	
	public void passlPhNo(String lphno){
		lphoneNoBox.sendKeys(lphno);
	}
	
	public void passlPassword(String lpassword){
		lpasswordBox.sendKeys(lpassword);
	}
	
	public void clickLogin(){
		PopupLoginButton.click();
	}

	public void displayLoginButton(){
		Assert.assertTrue(PopupLoginButton.isDisplayed());
	}
	
	public void closeLoginPopup(){
		LoginPopupCloseButton.click();
	}	
	
	public void clickFbLogin(){
		FbLoginButton.click();
	}
	
	public void clickGoogleLogin(){
		GoogleLoginButton.click();
	}
	
	public void clickCreateAccount(){
		CreateAccountButton.click();
	}
	
	public void clickForgot(){
		ForgotButton.click();
	}
	
	public void errorMsg1(){
		Assert.assertTrue(ErrorAllFieldsRequired.isDisplayed());
	}
	
	public void errorMsg2(){
		Assert.assertTrue(ErrorYouAreNotYetRegistered.isDisplayed());
	}
	
	public void errorMsg3(){
		Assert.assertTrue(ErrorPleaseCheckYourCredentials.isDisplayed());
	}

	
	
	
	
	
	

	
	//Register Screen Functions
	public void closeRegisterPopup(){
		RegisterPopupCloseButton.click();
	}	
	
	public void displayRegisterButton(){
		Assert.assertTrue(PopupRegisterButton.isDisplayed());
	}


	
	//Forgot Screen Functions
	public void displayResetPWButton(){
		Assert.assertTrue(ResetPasswordButton.isDisplayed());
	}

	public void clickResetPWButton(){
		ResetPasswordButton.click();
	}
	
	public void closeForgotPWPopup(){
		ForgotPWPopupCloseButton.click();
	}
	
	public void passfemail(String femail){
		femailBox.sendKeys(femail);
	}
	
	public void displayFPWSuccesPopup(){
		Assert.assertTrue(fpwSuccessPopup.isDisplayed());
	}
	

	
	
	

	/*   Optimization Functions   */	
	//Case 1 - Login Error Verify with Invalid PhNo and Invalid PW
	public void loginErrorVerifyEmptyData() throws Throwable{
		PopupLoginButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(ErrorAllFieldsRequired.isDisplayed());
		Thread.sleep(5000);
		LoginPopupCloseButton.click();
	}
	
	//Case 2 - Login Error Verify with Invalid PhNo and Invalid PW
	public void loginErrorVerifyInvalidPh(String lphno, String lpassword) throws Throwable{
		LoginSignupButton.click();
		lemailBox.sendKeys(lphno);
		lpasswordBox.sendKeys(lpassword);
		PopupLoginButton.click();
		Thread.sleep(1000);		
		Assert.assertTrue(ErrorYouAreNotYetRegistered.isDisplayed());
		Thread.sleep(5000);
		LoginPopupCloseButton.click();
	}
	
	//Case 3 - Login Error Verify with Invalid Email and Invalid PW
	public void loginErrorVerifyInvalidEmail(String lemail, String lpassword) throws Throwable{
		LoginSignupButton.click();
		lemailBox.sendKeys(lemail);
		lpasswordBox.sendKeys(lpassword);
		PopupLoginButton.click();
		Thread.sleep(1000);		
		Assert.assertTrue(ErrorYouAreNotYetRegistered.isDisplayed());
		Thread.sleep(5000);
		LoginPopupCloseButton.click();
	}

	//Case 4 - Login Error Verify with valid Email and Invalid PW
	public void loginErrorVerifyInvalidPassword(String lemail, String lpassword) throws Throwable{
		LoginSignupButton.click();
		lemailBox.sendKeys(lemail);
		lpasswordBox.sendKeys(lpassword);
		PopupLoginButton.click();
		Thread.sleep(1000);		
		Assert.assertTrue(ErrorPleaseCheckYourCredentials.isDisplayed());
		LoginPopupCloseButton.click();
	}
	
	//Case 5 - Login Success Verify with valid Email and valid PW
	public void loginSuccessVerify(String lemail, String lpassword) throws Throwable{
		LoginSignupButton.click();
		lemailBox.sendKeys(lemail);
		Thread.sleep(500);
		lpasswordBox.sendKeys(lpassword);
		Thread.sleep(500);
		PopupLoginButton.click();
		Thread.sleep(4000);
	}

	
	//Forgot
	//Case 6 - Executing Forgot PW with Valid Email or Phone Number
	public void ForgotPWSuccessVerify(String femail) throws Throwable{
		LoginSignupButton.click();
		ForgotButton.click();
		femailBox.sendKeys(femail);
		ResetPasswordButton.click();
    	Thread.sleep(3000);
		Assert.assertTrue(fpwSuccessPopup.isDisplayed());
		fpwSuccessPopupCloseButton.click();
	}
	
	//Case 7 - Executing Forgot PW with Empty Data 
	public void ForgotPWErrorVerifyEmptyData() throws Throwable{
		LoginSignupButton.click();
		ForgotButton.click();
		ResetPasswordButton.click();
    	Thread.sleep(1000);
		Assert.assertTrue(fpwErrorPleaseEnterEmailorPhoneNumber.isDisplayed());
    	Thread.sleep(5000);
    	fpwPopupCloseButton.click();    	
	}
	
	//Case 8 - Executing Forgot PW with Invalid Email or Phone No 
	public void ForgotPWErrorVerifyInvalidData(String femail) throws Throwable{
		LoginSignupButton.click();
		ForgotButton.click();
		femailBox.sendKeys(femail);
		ResetPasswordButton.click();
    	Thread.sleep(1000);
		Assert.assertTrue(fpwErrorPleaseEnterValidEmailorPhoneNumber.isDisplayed());
    	Thread.sleep(5000);
    	fpwPopupCloseButton.click();    	
	}
	
	
	
	
	
	
	
	
}
