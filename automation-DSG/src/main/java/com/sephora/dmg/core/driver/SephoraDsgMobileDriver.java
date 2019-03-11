package com.sephora.dmg.core.driver;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sephora.uca.utils.Config;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import runner.RunnerTest;

/**
 * 	SephoraDmgMobileDriver extends implements Webdriver and
 *  uses RemoteWebdriver for implementation, customized reusable
 *  functions are added along with regular functions
 */

public class SephoraDsgMobileDriver implements WebDriver,MobileDriver {
	public static  MobileDriver<WebElement> driver;
	public final String CHAR_LIST = 
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public final int RANDOM_STRING_LENGTH = 4;

	public Config config= new Config();
	//	private int elementWaitTime = 40;
	private static final int DEFAULT_TIMEOUT = 40;
	private static final int POLLING_TIME = 3;
	private static int MIN_DEFAULT_TIMEOUT=50;
	private static String platformUsed;	
	public static String UDID = null;
	public static ExtentReports extent=RunnerTest.extent;
	public static ExtentTest test=RunnerTest.test;

	public SephoraDsgMobileDriver() {
		if(driver==null)
			driver = RunnerTest.driver;
	}

	protected static final Logger logger = LogManager
			.getLogger(SephoraDsgMobileDriver.class.getName());
	protected  DesiredCapabilities capabilities ;



	public void loadApplication() {

		try {
			config.loadProps();
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName",config.getProperty("platformName"));
			capabilities.setCapability("platformVersion",config.getProperty("platformVersion"));
			capabilities.setCapability("deviceName",config.getProperty("deviceName"));
			capabilities.setCapability("dontStopAppOnReset", false);
			capabilities.setCapability("nativeWebTap", true);
			capabilities.setCapability("simpleIsVisibleCheck", true);
			capabilities.setCapability("noResetValue","true");
			if(UDID==null || UDID.equalsIgnoreCase("${udid}"))
				capabilities.setCapability("udid", config.getProperty("udid"));
			else
				capabilities.setCapability("udid", UDID);	
			capabilities.setCapability("bundleId", config.getProperty("bundleId"));
			capabilities.setCapability("newCommandTimeout",30000);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			capabilities.setCapability("agentPath", config.getProperty("agentPath"));
			capabilities.setCapability("bootstrapPath", config.getProperty("bootstrapPath"));
			capabilities.setCapability("xcodeConfigFile",config.getProperty("xcodeConfigFile"));
			capabilities.setCapability("useNewWDA", "true");
			capabilities.setCapability("usePrebuiltWDA", "false");

			URL remoteUrl = new URL("http://"+ config.getProperty("host") +"/wd/hub");
			logger.debug("Remote URL is " + remoteUrl);

			if (config.getProperty("platformName").contains("iOS")) 
				driver = new IOSDriver(remoteUrl, capabilities);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);




		} catch(Exception e) {
			e.printStackTrace();
		}
	}




	@SuppressWarnings("deprecation")
	public void swipe(int startx, int starty, int endx, int endy,String Direction) {
		try {

			TouchAction touch =	new TouchAction(driver);

			touch.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(endx, endy).release().perform();
			TestPass("Swiped "+Direction+" Successfully");

		} 

		catch (Exception e) 
		{
			Exception(new Exception("Screen not swiped"));

			Assert.fail();


		}

	}

	public void click(WebElement Element, String ElementName) {

		try {
			Element.click();
			TestInfo("Successfully clicked on "+ElementName);

		} catch(Exception e) {
			e.printStackTrace();
			TestFail("Failed to clicked on "+ElementName);
			Assert.fail();



		}

	}



	public int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public String generateRandomString(){

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	public void ClosedApp() {
		driver.closeApp();
		TestInfo("App Closed successfully");
	}

	public void LaunchApp() {
		driver.launchApp();
		TestInfo("App relaunched successfully");
	}

	public void PressHomeButton(int durationtoRelaunch) {
		try {
			//driver.lockDevice(Duration.ofSeconds(durationtoRelaunch));
			driver.runAppInBackground(Duration.ofSeconds(durationtoRelaunch));

			TestInfo("Pressed home button successfully.");

		}catch(Exception e) {
			Exception(new Exception("Failed to click home button"));
			Assert.fail();
		}
	}

	public void waitForLocatorToBeClickable(WebElement locator) {
		try {
			turnOffImplicitWaits();
			TestInfo("Waiting for locator to be clickable");
			long startTime = System.currentTimeMillis();
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT, POLLING_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			TestInfo("Finished waiting for locator to be clickable after " + totalTime + " milliseconds.");
			turnOnImplicitWaits();
		} catch (Exception e) {
			turnOnImplicitWaits();
			e.printStackTrace();
			Exception(new Exception("Error occurred while waiting for element '" + locator + "' to be clickable"));
			Assert.fail();


		}
	}


	public boolean waitForElementPresence(WebElement locator) throws InterruptedException {
		TestInfo("Waiting for locator to be presence");
		for(int trialTime=0;trialTime<12;trialTime++) {
			try {
				if(locator.getSize() != null) {
					return true;
				}else {
					Thread.sleep(5000);
				}
			}catch(Exception e) {
				System.out.println("element not found");
				Thread.sleep(5000);
			}
		}
		return false;
	}

	public static String getScreenshot(WebDriver driver1, String screenshotName) throws Exception {
		//below line is just to append the date format with the screenshot name to avoid duplicate names 
		String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") +"/test-output/"+ "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		//Returns the captured file path
		return destination;
	}

	public static boolean isValidDate(String inDate,String Dateformat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
			System.out.println("Format matched");
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public void swipe(int startx, int starty, int endx, int endy) {
		try {


			TouchAction touch =	new TouchAction(driver);

			touch.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(endx, endy).release().perform();

		} 
		catch (Exception e) 
		{
			Exception(new Exception("Screen not swiped"));

			Assert.fail();

		}

	}

	public void VerifyIsDisabled(WebElement Element,String WebElement) {
		try {
			boolean b=Element.isEnabled();

			if(b==true)
			{
				TestInfo("Failed : "+WebElement+" is Enabled");
				Assert.fail();


			} else
			{
				TestPass("Verify "+WebElement+" is Disabled");
			}
		}

		catch(Exception e){
			Exception(new Exception("VerifyIsDiabled method failed"));
			Assert.fail();
		}
	}

	public void VerifyIsEnabled(WebElement Element,String WebElement) {
		try {
			boolean b=Element.isEnabled();

			if(b==true)
			{
				TestPass("Verify "+WebElement+" is Enabled");


			} else
			{
				TestInfo("Failed : "+WebElement+" is Disabled");
				Assert.fail();

			}
		}
		catch(Exception e){
			Exception(new Exception("VerifyIsEnabled method failed"));
			Assert.fail();
		}
	}



	public void TapByCordinate(String Element, int xPoint, int yPoint) {
		try {
			TouchAction touchAction=new TouchAction(driver);
			pauseExecutionFor(2000);
			touchAction.tap(xPoint, yPoint).perform();
			TestPass("Successfully Clicked on "+Element);
		}
		catch(Exception e){
			Exception(new Exception("Failed to click on "+Element));
			Assert.fail();

		}
	}



	public void selectValueByText(WebElement ele, String value){
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(value);
	}



	public void TestPass(String info){

		try {
			test.log(LogStatus.PASS, info);
			System.out.println(info);
		}
		catch(Exception e) {
			Exception(new Exception("Test Passed Method Failed"));
			Assert.fail();
		}
	}


	public void TestInfo(String info) {
		try {

			test.log(LogStatus.INFO, info);;
			System.out.println(info);
		}
		catch(Exception e) {
			Exception(new Exception("Test Info Method Failed"));
			Assert.fail();
		}
	}

	public void Exception(Exception info) {
		try {

			info.printStackTrace();
			test.log(LogStatus.ERROR,"<pre><b><font color='red'>"+info+"</font></b></pre>");
			Assert.fail();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void TestSkip(String info) {
		try {

			test.log(LogStatus.SKIP, info);;
			System.out.println(info);
		}
		catch(Exception e) {
			Exception(new Exception("Test Info Method Failed"));
			Assert.fail();
		}
	}

	public void TestFail(String info,String methodName){
		try {

			String imagePath=getScreenshot(driver, methodName);
			test.log(LogStatus.FAIL, info+ test.addScreenCapture(imagePath));
			System.out.println(info);
		}
		catch(Exception e) {
			Exception(new Exception("Test Failed Method Failed"));
			Assert.fail();
		}
	}

	public void TestFail(String info){
		try {
			String imagePath=getScreenshot(driver,getDateTime());
			test.log(LogStatus.FAIL, info+ test.addScreenCapture(imagePath));
			System.out.println(info);
		}
		catch(Exception e) {
			Exception(new Exception("Test Failed Method Failed"));
			Assert.fail();
		}
	}


	public void verifyTextOnElement(WebElement Element, String verificationText)
	{

		String retrievedText = "";
		try {


			retrievedText = Element.getText().trim();
			if ((retrievedText.contains(verificationText.trim()) & (Element.isDisplayed()))) {

				TestPass("The text verified successfully. Element-> "  + " text: " + verificationText);

			}	   

			else {
				TestInfo(verificationText+ "Text not found");
				Assert.fail();


			}
		}
		catch (Throwable t)
		{
			Exception(new Exception("Exception while locating the element. Element-> "  + ", text: " + verificationText));
			Assert.fail();

		}
	}






	public void movetToElementJavascript(By locator) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+findElement(locator).getLocation().y+")");
	}

	public void movetToElementJavascript(WebElement webElement) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				webElement);
	}


	public void pauseExecutionFor(long lTimeInMilliSeconds) {
		try {
			Thread.sleep(lTimeInMilliSeconds);
			System.out.println("pause Execution for "+lTimeInMilliSeconds+ " Mili Seconds");
		} catch (InterruptedException e) {
			Exception(new Exception("Pause Execution Method failed"));
		}
	}


	public boolean IsElementVisible(WebElement element) {
		return element.isDisplayed() ? true : false;
	}




	public void turnOffImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public void turnOnImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(MIN_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	}



	/**
	 * Returns current Date Time
	 * 
	 * @return
	 */
	/*public void swipe(int startx, int starty, int endx, int endy, int duration) {
		driver.swipe(startx, starty, endx, endy, duration);
	}
	 */
	/**
	 * Returns current Date Time
	 * 
	 * @return
	 */
	public static String getDateTime() {
		String sDateTime = "";
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			String strTime = sdfTime.format(now);
			strTime = strTime.replace(":", "-");
			sDateTime = "D" + strDate + "_T" + strTime;
		} catch (Exception e) {
			System.err.println(e);
		}
		return sDateTime;
	}


	public void takeScreenShot(String fileName) throws Exception{
		String folder = "logs/screen/";
		WebDriver driver1 = new Augmenter().augment(driver);
		File file  = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(folder+fileName+".jpg"));
	}






	public boolean IsLocatorEnable(By by){
		return driver.findElement(by).isEnabled();
	}

	public int getIntegerValueFromString(String value){
		int returnValue=Integer.parseInt(value.replaceAll("[^0-9]", ""));
		return returnValue;
	}


	public void selectByText(WebElement element,String text){
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			TestPass("Successfully Selected Text "+text);
		}
		catch(Exception e) {
			TestInfo("Failed to selct Selected Text "+text);
			Assert.fail();
		}
	}


	public int getCurrentYear(){
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR);
		return year;
	}





	public void VerifyElementPresentOnPage(WebElement Element, String ElementName) {


		try {

			boolean result= Element.isDisplayed();
			boolean result1=Element.isEnabled();


			if(result==true || result1==true)
			{
				TestPass("Verified "+ElementName+ " is present on page  ");
			}
			else {
				TestInfo("Failed "+ElementName+ " is not present on page  ");
				Assert.fail();

			}

		}
		catch(Exception e) {
			e.printStackTrace();
			Exception(new Exception(ElementName+" is not present"));
			Assert.fail();

		}
	}



	public void VerifyElementNotPresentOnPage(WebElement Element, String ElementName) {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		try {

			boolean result= Element.isDisplayed();


			if(result==true)
			{
				System.out.println("Failed "+ElementName+ " is present on page  ");
				Assert.fail();

			}

		}
		catch(Exception e) {
			TestPass("Verified "+ElementName+ " is not present on page  ");
		}

		finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}


	public void verifyText(String Actual, String Expected)
	{
		try {
			if (Actual.trim().equalsIgnoreCase(Expected.trim()))
			{
				TestInfo("Verified Text As Expected. Text: " + Expected);
			}
			else {
				TestInfo("Failed: Text not as Expected. Actual: " + Actual + ", Expected: " + Expected);
				Assert.fail();

			}

		}
		catch(Exception e) {
			Exception(new Exception("Exception in Verifying Text"));
			Assert.fail();

		}
	}
	public void verifyTextNotMatched(String Actual, String Expected)
	{
		try {
			if (!Actual.trim().equalsIgnoreCase(Expected.trim()))
			{
				TestInfo("Verified Actaual text : "+Actual+" Not matched with : " + Expected);
			}
			else {
				TestInfo("Failed: Actaual text : "+Actual+" matched with : " + Expected);
				Assert.fail();

			}

		}
		catch(Exception e) {
			Exception(new Exception("Exception in Verifying Text not matched"));
			Assert.fail();

		}
	}

	public void EnterText(WebElement Element,String EnterText) {
		try {
			Element.clear();
			Element.sendKeys(EnterText);
			TestPass("Successfully enterd "+EnterText);
		}
		catch(Exception e) {
			Exception(new Exception("Failed to enterd text "+EnterText));
			Assert.fail();

		}
	}



	public Response execute(String driverCommand, Map<String, ?> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response execute(String driverCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebDriver context(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getContextHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public void rotate(ScreenOrientation orientation) {
		// TODO Auto-generated method stub

	}

	public ScreenOrientation getOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void rotate(DeviceRotation rotation) {
		// TODO Auto-generated method stub

	}

	public DeviceRotation rotation() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement(String by, String using) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElements(String by, String using) {
		// TODO Auto-generated method stub
		return null;
	}

	public Location location() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLocation(Location location) {
		// TODO Auto-generated method stub

	}

	public WebElement findElementByClassName(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByClassName(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementByCssSelector(String cssSelector) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByCssSelector(String cssSelector) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementByLinkText(String linkText) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByLinkText(String linkText) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementByPartialLinkText(String partialLinkText) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByPartialLinkText(String partialLinkText) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementByTagName(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByTagName(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElementByXPath(String xPath) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findElementsByXPath(String xPath) {
		// TODO Auto-generated method stub
		return null;
	}

	public void get(String url) {
		// TODO Auto-generated method stub

	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void quit() {
		// TODO Auto-generated method stub

	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}


}
