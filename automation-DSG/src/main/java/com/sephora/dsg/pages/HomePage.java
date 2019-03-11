package com.sephora.dsg.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends SephoraBasePage {




	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='HOME']/XCUIElementTypeButton[1]") public WebElement HOME_HAMBURGER_ICON;
	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='HOME']") public WebElement HOME_PAGE_TEXT;
	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='HOME']/XCUIElementTypeButton[2]") public WebElement SEARCH_BARCODE;
	@FindBy (name="Skincare Consultation") public WebElement SKINCARE_CONSULTATION;
	@FindBy (name="Find by Product Type") public WebElement FIND_BY_PRODUCT_TYPE;	
	@FindBy (xpath="//XCUIElementTypeImage[@name='Header_MainNav']") public WebElement DIGITAL_SKINCARE_GUIDE_IMAGE_HAM;
	@FindBy (name="Erase") public WebElement CROSS_SIGN;
	@FindBy (name="SKIN CONSULTATION") public WebElement SKIN_CONSULTATION;
	@FindBy (name="FIND BY PRODUCT TYPE") public WebElement FIND_BY_PRODUCT_TYPE_LEFT_NAVIGATION;	
	@FindBy (name="VIEW ROUTINE") public WebElement VIEW_ROUTINE_HAM;
	@FindBy (name="EMAIL ROUTINE") public WebElement EMAIL_ROUTINE_HAM;
	@FindBy (xpath="//XCUIElementTypeStaticText[contains(@name,'@')]") public WebElement CLIENT_EMAIL_HAM;
	@FindBy (xpath="//XCUIElementTypeStaticText[contains(@name,'@')]/following-sibling::XCUIElementTypeStaticText") public WebElement CLIENT_NAME_HAM;
	@FindBy (name="END SESSION")   public WebElement END_SESSION_BUTTON;
	@FindBy (name="CANCEL") public WebElement CANCEL_BUTTON;

	// SETTING  
	@FindBy (name="SETTINGS") public WebElement SETTING_ICON;
	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='SETTINGS']") public WebElement SETTING_PAGE;

	//Help Page
	@FindBy (name="HELP") public WebElement HELP_ICON;
	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='HELP']") public WebElement HELP_PAGE_TEXT;
	
	
	//SKINCARE CONSULTATION
	
	@FindBy (xpath="//XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]") public WebElement BACK_BUTTON;
	@FindBy (xpath="//XCUIElementTypeNavigationBar/XCUIElementTypeButton[2]") public WebElement HAMBURGER_ICON;;
	@FindBy (name="LEARNING ABOUT YOUR SKIN") public WebElement LEARNING_ABOUT_YOUR_SKIN;
	@FindBy (name="LET'S LEARN ABOUT YOUR SKIN!") public WebElement LETS_LEARN_ABOUT_YOUR_SKIN_Button;
	@FindBy (name="If you could focus on one thing, what would it be?") public WebElement FOCUS_ON_ONE_THING_PAGE;
	@FindBy (name="Pores") public WebElement PORES;
	@FindBy (name="Dullness & Uneven Texture") public WebElement DULLNESS;
	@FindBy (name="Fine Lines & Wrinkles") public WebElement FINE_LINE;
	@FindBy (name="Firmness & Elasticity") public WebElement FIRMNESS_AND_ELASTIITY;
	@FindBy (name="Dark Spots & Uneven Tone") public WebElement DARK_SPOT;
	@FindBy (name="Acne & Blemishes") public WebElement ACNE_BLEMISHES;
	@FindBy (name="Drynessy") public WebElement DRYNESS;
	@FindBy (name="Redness") public WebElement REDNESS;
	@FindBy (name="Oiliness") public WebElement OILINESS;
	@FindBy (name="NEXT") public WebElement NEXT_BUTTON;
	
	@FindBy (name="Which of these best describes your skin?") public WebElement DESCRIBE_SKIN_PAGE;
	@FindBy (name="Dry") public WebElement DRY;
	@FindBy (name="Oily") public WebElement OILY;
	@FindBy (name="Normal") public WebElement NORMAL;
	@FindBy (name="Combination") public WebElement COMBINATION;
	
	@FindBy (name="Is your skin sensitive or easily irritated?") public WebElement SKIN_SENSITIVE_PAGE;
	@FindBy (name="Yes") public WebElement Yes;
	@FindBy (name="No") public WebElement No;
	
	@FindBy (name="Is your skin sensitive or easily irritated?") public WebElement SKINCARE_STEPS_CURRENT;
	@FindBy (name="Cleanser") public WebElement CLEANSER;
	@FindBy (name="AM Treatment") public WebElement AM_TREATMENT;
	@FindBy (name="PM Treatment") public WebElement PM_TREATMENT;
	@FindBy (name="Moisturizers") public WebElement MOISTURIZERS;
	@FindBy (name="Sunscreen") public WebElement SUNSCREEN;
	@FindBy (name="Masks") public WebElement MASKS;

	@FindBy (name="VIEW RESULTS") public WebElement VIEW_RESULT;
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void VerifyHomePageDisplays() {
		VerifyElementPresentOnPage(HOME_PAGE_TEXT, "Home Page");
		VerifyElementPresentOnPage(SKINCARE_CONSULTATION, "Skincare Consultaion");
		VerifyElementPresentOnPage(SKINCARE_CONSULTATION, "Skincare Consultaion");
	}


	public void SkinCareConsultationQuiz() {
		click(SKINCARE_CONSULTATION, "Skincare Consultaion");
		
	}











}
