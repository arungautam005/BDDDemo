package com.sephora.dsg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

public class EmailToClientPage extends SephoraBasePage {
	
	protected SephoraDsgMobileDriver driver;

	
	// Strings 
	

	
	
	// WebElements
	@FindBy (name="DFC.DMGEmailHomeView") public WebElement EMAIL_TO_CLIENT;
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='Summary']/following-sibling::XCUIElementTypeStaticText") public WebElement MODEL_NAME_EMAIL_PAGE;
	@FindBy (name="Summary") public WebElement SUMMARY;
	@FindBy (name="ADD PRODUCTS") public WebElement ADD_PRODUCT_BUTTON;
	@FindBy (name="Please add products.") public WebElement PRODUCT_ERROR_MESSAGE;
	@FindBy (xpath="//XCUIElementTypeStaticText[contains(@name,'VIEW BENEFIT')]") public WebElement VIEW_BENIFIT;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='left nav addPhoto Button'])[2]") public WebElement ADD_PHOTO_LEFT;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='left nav addPhoto Button'])[1]") public WebElement ADD_PHOTO_RIGHT;
	@FindBy (name="close menu icon") public WebElement CLOSE_CAEMRA_ICON;
	@FindBy (name="Capture") public WebElement CAPTURE_ICON;
	@FindBy (name="RETAKE") public WebElement RETAKE;
	@FindBy (name="USE PHOTO") public WebElement USE_PHOTO;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='photo delete'])[1]") public WebElement PHOTO_DELETE_LEFT;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='photo delete'])[2]") public WebElement PHOTO_DELETE_RIGHT;
	@FindBy (name="Are you sure you want to delete?") public WebElement PHOTO_DELETE_ALERT;
	@FindBy (name="NO") public WebElement NO_BUTON;
	@FindBy (name="YES") public WebElement YES_BUTTON;
	@FindBy (name="VIEW PRODUCTS") public WebElement VIEW_PRODUCTS;
	@FindBy (xpath="//XCUIElementTypeCell[5]/XCUIElementTypeTextField") public WebElement EMAIL_FIELD;
	@FindBy (xpath="//XCUIElementTypeCell[6]/XCUIElementTypeTextField") public WebElement ARTIST_NAME;
	@FindBy (xpath="//XCUIElementTypeCell[7]/XCUIElementTypeTextView") public WebElement NOTES_FIELD;
	@FindBy (name="Done") public WebElement DONE_BUTTON;
	@FindBy (name="SEND") public WebElement SEND_EMAIL;
	@FindBy (name="Please enter correct email format.") public WebElement EMAIL_FIELD_ERROR;
	@FindBy (xpath="//XCUIElementTypeStaticText[contains(@name,'.com']") public WebElement EMAIL;
	@FindBy (name="Please enter correct email format.") public WebElement EMAIL_ERROR;
	@FindBy (name="That's a Wrap!") public WebElement THATS_WRAP;
	@FindBy (name="The Digital Makeover Guide was sent and saved to the client's BI account:") public WebElement CONFIRMATION_PAGE_TEXT;
	@FindBy (name="The Digital Makeover Guide was sent to:") public WebElement CONFIRMATION_PAGE_TEXT_NONREGISTEREDUSER;
	@FindBy (name="START NEW SESSION") public WebElement START_NEW_SESSION;
	
	// Methods
	
	/**
	 * Driver
	 */
	public EmailToClientPage(SephoraDsgMobileDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	


}



