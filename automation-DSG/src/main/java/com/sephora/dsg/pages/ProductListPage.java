package com.sephora.dsg.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

public class ProductListPage extends SephoraBasePage {



	protected SephoraDsgMobileDriver driver;


	// Strings 

	public String Welcome_Text="Welcome";

	public String Thankyou="Thank you for being";


	// WebElements
	@FindBy (name="DFC.DMGProductGuideView") public WebElement PRODUCTS_LIST;
	@FindBy (name="NEXT") public WebElement NEXT_BUTTON;
	@FindBy (name="VIEW LOOK") public WebElement VIEW_LOOK;
	@FindBy (name="Sample Inactive") public WebElement SAMPLE_ICON;
	@FindBy (name="Must Have Inactive") public WebElement MUST_HAVE_ICON;
	@FindBy (name="Note Inactive") public WebElement NOTE_ICON;
	@FindBy (name="Scan Grey 375px @1x Copy") public WebElement SCAN_ICON;
	@FindBy (name="Undo") public WebElement UNDO;
	@FindBy (name="trash") public WebElement TRASH_ICON;
	@FindBy (xpath="//XCUIElementTypeStaticText[@name='VIEW LOOK']/preceding-sibling:: XCUIElementTypeStaticText[1]") public WebElement MODEL_NAME_PRODUCTLIST_PAGE;
	@FindBy (name="Browse LookBook") public WebElement BROWSE_LOOKBOOK;
	@FindBy (name="left nav close") public WebElement BROWSE_LOOKBOOK_CLOSE_ICON;
	@FindBy(name="Expand plus") public WebElement  EXPAND_PLUS_ICON;
	@FindBy(name="arrow down") public WebElement ARROW_DOWN_ICON;
	@FindBy(name="add active") public WebElement ADD_BUTTON;
	@FindBy (name="SAVE") public WebElement SAVE_COLORIQ;
	@FindBy (name="2") public WebElement TWO;
	@FindBy (name="Y") public WebElement Y;
	@FindBy (name="0") public WebElement ZERO;
	@FindBy (name="5") public WebElement FIVE;
	@FindBy (name="Expand plus") public WebElement BRUSHES_PLUS_ICON;
	@FindBy (name="Tools") public WebElement TOOLS;
	@FindBy (name="Brushes") public WebElement BRUSHES;
	@FindBy (name="Cleanser") public WebElement CLEANSER;
	@FindBy (name="Moisturizes") public WebElement MOISTURISER;
	@FindBy (name="Eye Cream") public WebElement EYECREAM;
	@FindBy (name="Primer") public WebElement PRIMER;
	@FindBy (name="Eyeliner") public WebElement EYELINER;
	@FindBy (name="Mascara") public WebElement MASCARA;
	@FindBy (name="Setting") public WebElement SETTING;
	@FindBy (name="Lashes") public WebElement LASHES;
	@FindBy (xpath="(//XCUIElementTypeButton[@name='add active'])[1]/preceding-sibling:: XCUIElementTypeStaticText[2]") public WebElement PRODUCT_NAME;

	//Search By Name or UPC#
	
	@FindBy (xpath="//XCUIElementTypeSearchField") public WebElement SEARCH_BY_NAME;
	@FindBy (xpath="//XCUIElementTypeSearchField") public WebElement SEARCH_FIELD;
	@FindBy (name="Scan Barcode") public WebElement SCAN_BARCODE;
	@FindBy (name="DFC.DFCScanHome") public WebElement SCAN_PAGE;
	@FindBy (name="SCAN") public WebElement SCAN_PAGE1;
	@FindBy (name="close") public WebElement CLOSE_ICON;
	@FindBy (name="close menu icon") public WebElement CLOSE_ICON1;
	@FindBy (xpath="//XCUIElementTypeButton[@name='ALL RESULTS']/../../XCUIElementTypeOther[1]/XCUIElementTypeButton") public WebElement COLORIQ_NOTEPAGE;
	@FindBy (name="ALL RESULTS") public WebElement ALL_RESULTS;
	@FindBy (xpath="//XCUIElementTypeCell[2]/XCUIElementTypeStaticText") public WebElement SEARCH_RESULT;
	@FindBy (xpath="//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]") public WebElement SEARCH_RESULT1;
	@FindBy (name="Search") public WebElement SEARCH_BUTTON;
	@FindBy (xpath="//XCUIElementTypeNavigationBar[@name='SEARCH RESULTS']") public WebElement SEARCH_RESULT_PAGE;
	@FindBy (name="Scan") public WebElement SCAN_LINK;
	@FindBy (name="Cancel") public WebElement CANCEL_LINK;
	@FindBy (name="ADD") public WebElement ADD;
	@FindBy (name="CANCEL") public WebElement CANCEL_BUTTON;
	
	//Notes page
	@FindBy (name="DFC.DFCProductNotesView") public WebElement ADD_PRODUCT_NOTES_PAGE;
	@FindBy (xpath="//XCUIElementTypeTextView") public WebElement NOTE_TEXT_FIELD;
	@FindBy (xpath="//XCUIElementTypeStaticText[contains(@name,'C$')]") public WebElement NOTE_PAGE_PRICE;
	@FindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeImage[2]") public WebElement NOTE_PAGE_ADDED;
	@FindBy (xpath="//XCUIElementTypeTextView/preceding-siblingXCUIElementTypeStaticText[1]") public WebElement NOTE_PAGE_PRODUCT_NAME;
	@FindBy (name="Save") public WebElement NOTE_SAVE_LINK;
	
	// Methods


	public ProductListPage(SephoraDsgMobileDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}

	public void EnterColorIQNumber() {
		try {
			boolean b=SAVE_COLORIQ.isEnabled();
			System.out.println(b);
			if(b==false)
			{
				click(TWO, "TWO");
				click(Y, "Y");
				click(ZERO, "ZERO");
				click(FIVE, "FIVE");
				click(SAVE_COLORIQ, "Save Color IQ");
				
			}
			else {
				click(CANCEL_BUTTON, "Cancel Button");
			}
		}
			catch(Exception e) {
				click(SAVE_COLORIQ, "Save Color IQ");
				
			}
		}
	public WebElement VerifyAddProduct() {
		
		WebElement productname = null;
		try {
			String product=PRODUCT_NAME.getText().trim();
			VerifyElementPresentOnPage(NOTE_PAGE_PRICE, "Canadian Dollar Symbol");
			System.out.println(product);
			click(ADD_BUTTON, "ADD Button");
			
			swipe(300, 100, 300, 1500,"Down");
			List<WebElement> Productname=driver.findElements(By.name(product));
			productname=driver.findElement(By.name(product));
			System.out.println(Productname.size());
			if(Productname.size()==2) {
				TestInfo("Product Added Successfully");
			}
			
			else {
				TestInfo("Product Not Added Successfully");
				Assert.fail();
				  
			}
		}
		catch(Exception e){
			Exception(new Exception("Failed to verify Add Product"));
			Assert.fail();
			  
		}
		
		return productname;

	}
	public void ClickProductList(String ListName) {
		try {
			List<WebElement> Listname =driver.findElements(By.name(ListName));
			WebElement List = driver.findElement(By.name(ListName));
			int l=Listname.size();
			if(l>0) {
				while(!List.isDisplayed()) {
					swipe(300, 350, 300, -100,"Up");
				}
				click(List, ListName);
				TestInfo("Verified "+ListName+" present");
			}
			else {
				TestInfo("Verified "+ListName+" not present");
				Assert.fail();
				  
			}
		}
		catch(Exception e) {
			Exception(new Exception("Failed to click product list"));
			Assert.fail();
			  
		}
	}
	
	public void VerifySearchResult() {
		try {
			click(SEARCH_BY_NAME, "Search Field");
			EnterText(SEARCH_FIELD, "Eyeliner");
			pauseExecutionFor(5000);
			click(ALL_RESULTS, "All Result");
			verifyTextOnElement(SEARCH_RESULT, "Eyeliner");
			//click(COLORIQ_NOTEPAGE, "Color IQ No");
			String Productname=SEARCH_RESULT.getText().trim();
			System.out.println(Productname);
			String[] a=Productname.split("-");
			System.out.println(a[0].trim());
			System.out.println(a[1].trim());
			String Productname1=a[0].trim();
			click(SEARCH_RESULT, "Search Result");
			VerifyElementPresentOnPage(PRODUCTS_LIST, "Product Lit");
			List<WebElement> product =driver.findElements(By.name(Productname1));
			int noOfClient=product.size();
			if(noOfClient>0) {
			TestInfo("Verified product added successfully");
		}
			else {
				TestInfo("Verified product not added");
				Assert.fail();
				  
			}
		}
		catch(Exception e) {
			Exception(new Exception("Verify search result failed"));
			e.printStackTrace();
			Assert.fail();
			  
		}
	}

	public void VerifySearchResult1() {
		try {
			click(SEARCH_BY_NAME, "Search Field");
			EnterText(SEARCH_FIELD, "Penny");
			pauseExecutionFor(5000);
			click(SEARCH_BUTTON, "Search Button");
			VerifyElementPresentOnPage(SEARCH_RESULT_PAGE, "Search Result Page");
			verifyTextOnElement(SEARCH_RESULT1, "Penny");
			String Productname=SEARCH_RESULT1.getText().trim();
			System.out.println(Productname);
			click(ADD, "Add Button");
			VerifyElementPresentOnPage(PRODUCTS_LIST, "Product Lit");
//			List<WebElement> product =driver.findElements(By.name(Productname));
//			int noOfClient=product.size();
//			if(noOfClient>0) {
//			TestInfo("Verified product added successfully");
//		}
//			else {
//				TestInfo("Verified product not added");
//				Assert.fail();
//				  
//			}
		}
		catch(Exception e) {
			Exception(new Exception("Verify search result failed"));
			Assert.fail();
			  
		}
	}
}



