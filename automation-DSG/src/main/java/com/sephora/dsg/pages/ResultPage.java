package com.sephora.dsg.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends SephoraBasePage {





	// WebElements

	@FindBy (name="RESULTS") public WebElement RESULT_PAGE;
	@FindBy (name="FILTER") public WebElement FILTER_LINK;
	@FindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,'CLEANSE')]") public WebElement CLEANSE_TAB;
	@FindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,'TREAT')]") public WebElement TRAT_TAB;
	@FindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,'MOISTURIZE')]") public WebElement MOISTURIZE_TAB;
	@FindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,'FINISH')]") public WebElement FINISH_TAB;
	@FindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,'EXTRA CREDIT')]") public WebElement EXTRA_CREDIT_TAB;	
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='Recommended for:']") public WebElement RECOMMENDED_FOR;
	@FindBy (xpath="//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name='ADD']") public WebElement ADD_BUTTON;
	@FindBy (xpath="//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[contains(@name,'US$')]") public WebElement PRICE;
	@FindBy (xpath="//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]") public WebElement PRODUCT_NAME;
	@FindBy (name="Show More") public WebElement SHOW_MORE_BUTTON;
	@FindBy (name="VIEW ROUTINE") public WebElement VIEW_ROUTINE_BUTTON;
	@FindBy (name="REMOVE") public WebElement REMOVE_BUTTON;
	
	
	
	

	@FindBy (xpath="////XCUIElementTypeNavigationBar[contains(@name,'MY ROUTINE')]") public WebElement MY_ROUTINE_PAGE;
	@FindBy (name="Erase") public WebElement CROSS_ICON;
	@FindBy (name="EMAIL ROUTINE") public WebElement EMAIL_ROUTINE_BUTTON;
	@FindBy (xpath="//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]") public WebElement PRODUCT_NAME_MY_ROUTINE;
	@FindBy (name="sampleFilled") public WebElement SAMPLE_ICON;
	@FindBy (name="starUnfilled") public WebElement STAR_ICON;
	@FindBy (xpath="//XCUIElementTypeCell[1]/XCUIElementTypeButton[4]") public WebElement SELECT_DATE;
	
	@FindBy (xpath="//XCUIElementTypeNavigationBar") public WebElement MODEL_NAME;
	@FindBy (name="noteIconUnfilled") public WebElement NOTE_ICON;
	@FindBy (name="Add Color iQ Number") public WebElement ADD_COLOR_IQ_NUMBER;
	@FindBy (name="SAVE") public WebElement SAVE_BUTTON;
	@FindBy (name="�DMG� Would Like to Access the Camera") public WebElement CAMERA_ALERT;
	@FindBy (name="OK") public WebElement OK_BUTTON;


	// Methods

	/**
	 * Driver
	 */
	public ResultPage() {
		PageFactory.initElements(driver, this);
	}

	public void CameraAlert() {
		try {
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			boolean b=CAMERA_ALERT.isDisplayed();
			if(b==true) {
				click(OK_BUTTON, "OK Button");
			}

		}	catch(Exception e)
		
		{
		}
		finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}
}