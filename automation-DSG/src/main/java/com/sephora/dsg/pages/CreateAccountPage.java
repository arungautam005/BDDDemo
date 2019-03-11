package com.sephora.dsg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

public class CreateAccountPage extends SephoraBasePage {

	protected SephoraDsgMobileDriver driver;


	// Strings 

	public String Welcome_Text="Welcome";
	public String Thankyou="Thank you for being";


	// WebElements
	@FindBy (name="Welcome") public WebElement WELCOME_TEXT;
	@FindBy (name="Skip") public WebElement SKIP_SIGNUP_LINK;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='Cancel'])[1]") public WebElement CANCEL_LINK;
	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='DFC.DFCBIRegistrationView']")  public WebElement  CREATE_ACCOUNT;
	@FindBy (xpath="//XCUIElementTypeApplication[@name='DMG']//XCUIElementTypeTextField[1]") public WebElement EMAIL_ADDRESS;
	@FindBy (xpath="//XCUIElementTypeApplication[@name='DMG']//XCUIElementTypeTextField[2]") public WebElement FIRST_NAME;
	@FindBy (xpath="//XCUIElementTypeApplication[@name='DMG']//XCUIElementTypeTextField[3]") public WebElement LAST_NAME;
	@FindBy (name="unchecked") public WebElement BI_CHECKBOX;
	@FindBy (name="SIGN UP") public WebElement SIGNUP_BUTTON;
	@FindBy (name="CONTINUE") public WebElement CONTINUE;
	@FindBy (name="Thank you for being") public WebElement THANKYOU_TEXT;
	@FindBy (name="I agree to the Beauty Insider Terms & Conditions") public WebElement BI_TERMCONDITION;
	@FindBy (xpath="//XCUIElementTypeButton[@name='Cancel']") public WebElement CANCEL_LINK_THANKUPAGE;
	@FindBy (xpath="//XCUIElementTypeButton[@name='START SESSION']") public WebElement START_SESSION;
	@FindBy (name ="Clear text") public WebElement CLEAR_TEXT_ICON;
	@FindBy (name ="Date of Birth (Optional)") public WebElement DATEOF_BIRTH;
	@FindBy (name ="mm/dd") public WebElement DATE_SELECT;
	@FindBy (name="Done") public WebElement DONE_LINK;
	//@FindBy (name="Please correct email address format.") public WebElement EMAIL_ERROR;
	@FindBy (name="Please enter correct email format.") public WebElement EMAIL_ERROR;
	@FindBy (name="Return") public WebElement RETURN_BUTTON;




	// Methods

	/**
	 * Driver
	 */
	public CreateAccountPage(SephoraDsgMobileDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}




}



