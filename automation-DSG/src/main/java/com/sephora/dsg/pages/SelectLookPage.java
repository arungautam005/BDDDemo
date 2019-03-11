package com.sephora.dsg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

public class SelectLookPage extends SephoraBasePage {
	
	protected SephoraDsgMobileDriver driver;

	
	// Strings 
	
	public String Welcome_Text="Welcome";
	public String Thankyou="Thank you for being";
	
	
	// WebElements
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='SELECT LOOK']") public WebElement SELECT_LOOK_PAGETITLE;
	@FindBy (xpath="//XCUIElementTypeButton[@name='Skip']") public WebElement SKIP_LINK;
	@FindBy (xpath="//XCUIElementTypeButton[@name='back menu icon']") public WebElement BACK_MENU;
	@FindBy (xpath="//XCUIElementTypeApplication[@name='DMG']//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeButton") public WebElement SELECT_LOOK;

	
	// Methods
	
	/**
	 * Driver
	 */
	public SelectLookPage(SephoraDsgMobileDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * CreateAccount
	 */

}



