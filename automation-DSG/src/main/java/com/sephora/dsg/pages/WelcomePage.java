package com.sephora.dsg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dsg.core.constants.TestConstants;

public class WelcomePage extends SephoraBasePage  {







	// Strings 

	public String Welcome_Text="Welcome";
	public String Biuser="ash@gmail.com";
	public String Newuser=generateRandomString()+"@gmail.com"; 
	public String Thankyou="Thank you for being";



	// WebElements
	// WebElements
	@FindBy (name="Welcome") public WebElement WELCOME_TEXT;
	@FindBy (xpath="//XCUIElementTypeTextField") public WebElement EMAIL_ADDRESS;
	@FindBy (name="CONTINUE") public WebElement CONTINUE;
	@FindBy (name="Go") public WebElement GO;
	@FindBy (name="START SESSION") public WebElement START_SESSION;
	@FindBy (name="Thank you for being") public WebElement THANKYOU_TEXT;
	@FindBy (name="Plus Expand") public WebElement PLUS_ICON;
	@FindBy (name="Minus Collapse")  public WebElement MINUS_ICON;
	@FindBy (name="Privacy Policy") public WebElement PRIVACY_LINK;
	@FindBy (name="Terms of Use")  public WebElement TERMS_OF_USE;
	@FindBy (name="PICK A SKIN TONE") public WebElement CLIENT_PAGE; 
	@FindBy (name="Go") public WebElement GO_BUTTON;
	@FindBy (xpath= "(//XCUIElementTypeStaticText[@name='PRIVACY POLICY'])") public WebElement PRIVACY_POLICY_PAGETEXT;
	@FindBy (name="Stop") public WebElement CLOSE_ICON;
	@FindBy (name="SETTINGS") public WebElement SETTING_ICON;
	@FindBy (xpath="//XCUIElementTypeOther[3]/XCUIElementTypeButton[1]") public WebElement SETTING_ICON1;
	@FindBy (name="FEEDBACK") public WebElement FEEDBACK_ICON;
	@FindBy (name="HELP") public WebElement HELP_ICON;
	@FindBy (name="RESUME SESSION") public WebElement RESUME_SESSION;
	@FindBy (name="DELETE SESSION") public WebElement DELETE_SESSION;
	//Setting Page
	@FindBy (xpath= "//XCUIElementTypeStaticText[@name='Store#: 1800002']") public WebElement SETTING_PAGE_STOREID;
	@FindBy (xpath= "//XCUIElementTypeStaticText[@name='Device Name#: GSPANN_MD_132']") public WebElement SETTING_PAGE_DEVICENAME;
	@FindBy (xpath="//XCUIElementTypeButton[@name='CANCEL']/preceding-sibling:: XCUIElementTypeTextField") public WebElement ENTER_ACCESS_CODE_FIELD;
	@FindBy (name="Confirmation") public WebElement CONFIRMATION_POPUP;
	@FindBy (name="CloseButton") public WebElement CLOSE_BUTTON;
	@FindBy (name="In progress") public WebElement IN_PROGRESS_BAR;
	@FindBy (name="Progress") public WebElement PROGRESS;
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='Force Sync']/following-sibling::XCUIElementTypeSwitch") public WebElement FORCE_SYNC;
	@FindBy (name="ENTER ACCESS CODE") public WebElement ENTER_ACCESS_CODE;
	@FindBy (name="OK") public WebElement OK_BUTTON;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='OK'])[2]") public WebElement OK_BUTTON1;
	@FindBy (name="Ok") public WebElement CONFIRMATION_OK_BUTTON;
	@FindBy (name="Please check your code and try again") public WebElement ACCESS_CODE_ERROR;
	@FindBy (name="CANCEL")  public WebElement CANCEL_LINK;
	@FindBy (name="Please enter correct email format.") public WebElement EMAIL_ERROR;
	@FindBy (name="Are you sure you want to stop the sync?") public WebElement WARNING_MESSAGE;
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='English']/preceding-sibling::XCUIElementTypeButton") public WebElement ENGLISH_RADIOBUTTON;
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='French Canadian']/preceding-sibling::XCUIElementTypeButton") public WebElement FRENCH_CANADIAN;;
	
	//Feedback page
	@FindBy (xpath= "//XCUIElementTypeStaticText[@name='Do you have any feedback?']") public WebElement FEEDBACK_PAGE_TEXT;
	@FindBy (name="Type here") public WebElement FEEDBACK_TEXT_FIELD;
	@FindBy (name="SUBMIT") public WebElement SUBMIT;
	@FindBy (name="Thank you!") public WebElement THANKYOU;
	@FindBy (name="Your feedback has been submitted to the Sephora DMG team") public WebElement FEEDBACK_SUBMITTED_TEXT;
	@FindBy (xpath="//XCUIElementTypeButton[@name='OK']") public WebElement OK_POPUP_BUTTON; 
	
	//Other Locators
	@FindBy (name="DMGWebView") public WebElement HELPPAGE_TEXT;
	@FindBy (name="Cancel") public WebElement CANCEL_LINK_THANKUPAGE;
	@FindBy (name ="Clear text") public WebElement CLEAR_TEXT_ICON;
	@FindBy (name="OK") public WebElement ALERT_OK;
	@FindBy (name="thankyou_bi_insider") public WebElement BI_TYPE;
	@FindBy (name="Are you sure you want to delete this session?") public WebElement DELETE_SESSION_ALERT;
	@FindBy (name="CANCEL") public WebElement CANCEL_BUTTON;
	@FindBy (name="DELETE SESSION") public WebElement DELETE_SESSION_BUTTON;

	@FindBy (name="Capture") public WebElement CAPTURE_ICON;
	@FindBy (name="RETAKE") public WebElement RETAKE;
	@FindBy (name="USE PHOTO") public WebElement USE_PHOTO;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='photo delete'])[1]") public WebElement PHOTO_DELETE_LEFT;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='photo delete'])[2]") public WebElement PHOTO_DELETE_RIGHT;
	@FindBy (name="Are you sure you want to delete?") public WebElement PHOTO_DELETE_ALERT;
	@FindBy (name="NO") public WebElement NO_BUTON;
	@FindBy (name="YES") public WebElement YES_BUTTON;
	@FindBy (name="Yes") public WebElement YES_BUTTON1;
	@FindBy (name="close menu icon") public WebElement CLOSE_CAEMRA_ICON;
	@FindBy (name="close menu icon") public WebElement CLOSE_BUTTON1;
	@FindBy (xpath="//XCUIElementTypeStaticText[1]") public WebElement USER_EMAIL_ID;
	
	


	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}


	public void VerifyWelcomeScreen() {
		VerifyElementPresentOnPage(WELCOME_TEXT, "Welcome Text");
	}
	
	public void TapPlusIcon() {
		click(PLUS_ICON, "Plus Icon");
		VerifyElementPresentOnPage(MINUS_ICON, "Minus Icon");
	}
	
	public void VerifySettingPageDisplays() {
		click(SETTING_ICON, "Setting Icon");
		VerifyElementPresentOnPage(SETTING_ICON, "Setting Page");
		click(CLOSE_ICON, "Close Icon");
	}
	
	public void VerifyHelpPageDisplays() {
		click(HELP_ICON, "Help Icon");
		VerifyElementPresentOnPage(HELP_ICON, "Help Page");
		click(CLOSE_ICON, "Close Icon");
	}
	
	public void VerifyEmailFormat() {
		EnterText(EMAIL_ADDRESS, TestConstants.INCORRECT_EMAIL);
		click(GO_BUTTON, "Go Button");
		VerifyElementPresentOnPage(EMAIL_ERROR, "Error Message");
		EnterText(EMAIL_ADDRESS, TestConstants.INCORRECT_EMAIL1);
		click(GO_BUTTON, "Go Button");
		VerifyElementPresentOnPage(EMAIL_ERROR, "Error Message");
		EnterText(EMAIL_ADDRESS, TestConstants.INCORRECT_EMAIL2);
		click(GO_BUTTON, "Go Button");
		VerifyElementPresentOnPage(EMAIL_ERROR, "Error Message");
		EnterText(EMAIL_ADDRESS, TestConstants.INCORRECT_EMAIL3);
		click(GO_BUTTON, "Go Button");
		VerifyElementPresentOnPage(EMAIL_ERROR, "Error Message");
		EnterText(EMAIL_ADDRESS, TestConstants.INCORRECT_EMAIL4);
		click(GO_BUTTON, "Go Button");
		VerifyElementPresentOnPage(EMAIL_ERROR, "Error Message");
	}
	
	public void EnterBiEmailAndStartSession() {
		EnterText(EMAIL_ADDRESS, TestConstants.CLIENTEMAIL1);
		click(START_SESSION, "Start Session");
	}

}