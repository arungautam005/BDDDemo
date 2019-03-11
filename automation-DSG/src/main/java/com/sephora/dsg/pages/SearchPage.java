package com.sephora.dsg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

public class SearchPage extends SephoraBasePage {

	protected SephoraDsgMobileDriver driver;


	// Strings 

	public String Welcome_Text="Welcome";
	public String Biuser="ash@gmail.com";
	public String Newuser=generateRandomString()+"@gmail.com"; 
	public String Thankyou="Thank you for being";



    @FindBy (xpath="//XCUIElementTypeSearchField") public WebElement SEARCH_BY_NAME;
    @FindBy (name="Scan Barcode") public WebElement SCAN_BARCODE;
    @FindBy (name="SCAN") public WebElement SCAN_PAGE;
    @FindBy (name="close") public WebElement CLOSE_ICON;
    @FindBy (xpath="//XCUIElementTypeButton[@name='2Y05']") public WebElement COLORIQ_NOTEPAGE;
    @FindBy (name="ALL RESULTS") public WebElement ALL_RESULTS;
    @FindBy (xpath="//XCUIElementTypeCell[1]/XCUIElementTypeStaticText") public WebElement SEARCH_RESULT;
    @FindBy (name="Search") public WebElement SEARCH_BUTTON;
    @FindBy (xpath="//XCUIElementTypeNavigationBar[@name='SEARCH RESULTS']") public WebElement SEARCH_RESULT_PAGE;
    @FindBy (name="scan") public WebElement SCAN_LINK;
    @FindBy (name="Cancel") public WebElement CANCEL_LINK;
    @FindBy (name="ADD") public WebElement ADD;


	// Methods

	/**
	 * Driver
	 */
	public SearchPage(SephoraDsgMobileDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}


}