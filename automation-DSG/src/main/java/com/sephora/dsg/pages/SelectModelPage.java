package com.sephora.dsg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

public class SelectModelPage extends SephoraBasePage {
	
	protected SephoraDsgMobileDriver driver;

	
	// Strings 
	
	public String Welcome_Text="Welcome";
	public String Thankyou="Thank you for being";
	
	
	// WebElements
	@FindBy (xpath="//XCUIElementTypeButton[@name='Don�t Allow']") public WebElement DONTALLOW_POPUP;
	@FindBy (xpath="//XCUIElementTypeButton[@name='OK']") public WebElement OK_POPUP;
	@FindBy (xpath="//XCUIElementTypeButton[@name='Skip']") public WebElement SKIP_LINK;
	@FindBy (xpath="//XCUIElementTypeApplication[@name='DMG']//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeButton") public WebElement SELECT_MODEL;
	@FindBy (xpath = "//XCUIElementTypeButton[@name='dock menu icon']") public WebElement LEFT_NAVIGATION;

	
	// Methods
	
	/**
	 * Driver
	 */
	public SelectModelPage(SephoraDsgMobileDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * CreateAccount
	 */

}



