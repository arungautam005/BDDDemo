package stepDefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BiNonBiUserFunctionality_StepDefination extends BaseDefination {

	
@And("^Fill and verify email format functionality$")
public void VerifyEmailFormatFunctionality() {
	welcomepage.VerifyEmailFormat();
}
@And ("^Tap on Plus Icon$")
public void TapPlusIcon() {
	welcomepage.TapPlusIcon();
}

@Then("^Tap Setting and verify setting page displays$")
public void VerifySettingPageDisplays() {
	welcomepage.VerifySettingPageDisplays();
}

@Then("^Tap Help and verify Help page displays$")
public void VerifyHelpPageDisplays() {
	welcomepage.VerifyHelpPageDisplays();
}

















}