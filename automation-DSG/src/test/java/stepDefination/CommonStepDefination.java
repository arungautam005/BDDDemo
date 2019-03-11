package stepDefination;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonStepDefination extends BaseDefination{


	@Given("^Launch the app$")
	public void launchApp() {
		System.out.println("Launch the app");
	}

	@Then("^verify Welcome Screen$")
	public void verifyWelcomeScreen() {
		welcomepage.VerifyWelcomeScreen();
	}

	@And("^Enter Valid BI user Email and Start Session$")
	public void EnterBiEmailAndStartSession() {
		welcomepage.EnterBiEmailAndStartSession();
	}

	@Then("^Home page displays with Skincare consulation and Find By product Type$")
	public void VerifyHomePageDisplays() {
		homepage.VerifyHomePageDisplays();
	}
	
	@Then("^And Click Skincare Consultaion section and complete the quiz$")
	public void SkincareConsultation() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Before
	public void beforeMethodSetUp(Scenario m) throws Exception {
		try {	
			System.out.println(m.getName());
			test = extent.startTest(m.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public void afterMethodSetUp(Scenario m) {
		System.out.println(m.getStatus());
		if(m.getStatus().equals("failed")) {
			TestFail("",m.getName());
			RestartApp();
			System.out.println("Failure");
		}
		else {
			TestPass("Test Case Pass");
		}	
		extent.endTest(test);
	}


	public void RestartApp() {
		try {
			loadApplication();
		} catch (Exception e) {
			e.printStackTrace();
			Exception(new Exception("App not Re launched"));
		}

	}

	

	
	

}
