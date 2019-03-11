package runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;
import com.sephora.uca.utils.Config;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles/BiNonBiUserFunctionality.feature",
glue = "stepDefination",tags="@home", plugin={"json:target/cucumber-parallel/reports/cucumber-json-report.json","html:target/cucumber-parallel/reports/cucumber-json-report.html","pretty"}, strict = true)





public class RunnerTest extends AbstractTestNGCucumberTests {
	
public static  MobileDriver<WebElement> driver;	
protected  DesiredCapabilities capabilities ;
public Config config= new Config();	

protected static final Logger logger = LogManager
.getLogger(SephoraDsgMobileDriver.class.getName());
public static ExtentReports extent;
public static ExtentTest test;

	
	
	@BeforeSuite(alwaysRun=true)
	public void setUp() throws Exception {
		logger.info("********************Before Suite Starts (SephoraDmgAnalyticsBaseTest)****************");
		stopServer();
		startAppium();
		loadApplication();
		extent = new ExtentReports(System.getProperty("user.dir")+"/ExecutionReport/"+"UCA"+"_"+config.getProperty("device")+"_"+config.getProperty("platformName")+".html",true);
		extent.loadConfig(new File((System.getProperty("user.dir")+"/src/test/resources/environments/extent-config.xml")));
		logger.info("********************Before Suite Ends (SephoraDmgAnalyticsBaseTest)****************");
	}

	@AfterSuite(alwaysRun=true)
	public void tearSuite() {
		extent.flush();
		extent.close();
		driver.quit();
		stopServer();
	}


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
			capabilities.setCapability("udid", config.getProperty("udid"));	
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
				driver = new IOSDriver<WebElement>(remoteUrl, capabilities);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
		
	
	public static void startAppium() throws Exception {
		//String[] OS_LINUX_RUNTIME = { "/bin/bash", "-l", "-c" };
		String command = "/bin/bash -l -c appium --session-override -p 4723";
		System.out.println(command);
		String output = runCommand(command); //run command on terminal
		System.out.println(output);

	}


	// This function will run command on terminal
	public static String runCommand(String command) throws InterruptedException, IOException
	{
		Process p = Runtime.getRuntime().exec(command);

		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line="";
		String allLine="";
		while((line=r.readLine()) != null){
			allLine=allLine+""+line+"\n";
			if(line.contains("started on"))
				break;
		}
		return allLine;
	}


	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}