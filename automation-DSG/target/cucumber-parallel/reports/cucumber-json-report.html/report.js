$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/FeatureFiles/BiNonBiUserFunctionality.feature");
formatter.feature({
  "line": 1,
  "name": "Verify BI Non-BI user functionality",
  "description": "",
  "id": "verify-bi-non-bi-user-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 60607099,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify Welcome Screen",
  "description": "",
  "id": "verify-bi-non-bi-user-functionality;verify-welcome-screen",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@home"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Launch the app",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Tap on Plus Icon",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "verify Welcome Screen",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Tap Setting and verify setting page displays",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Tap Help and verify Help page displays",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Fill and verify email format functionality",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefination.launchApp()"
});
formatter.result({
  "duration": 198040671,
  "status": "passed"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.TapPlusIcon()"
});
formatter.result({
  "duration": 1481883759,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefination.verifyWelcomeScreen()"
});
formatter.result({
  "duration": 497354701,
  "status": "passed"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.VerifySettingPageDisplays()"
});
formatter.result({
  "duration": 1977689687,
  "status": "passed"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.VerifyHelpPageDisplays()"
});
formatter.result({
  "duration": 10564324355,
  "status": "passed"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.VerifyEmailFormatFunctionality()"
});
formatter.result({
  "duration": 39047466478,
  "status": "passed"
});
formatter.after({
  "duration": 2612767,
  "status": "passed"
});
formatter.before({
  "duration": 4148104,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify Welcome Screen again",
  "description": "",
  "id": "verify-bi-non-bi-user-functionality;verify-welcome-screen-again",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@home"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Launch the app",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "verify Welcome Screen",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Tap Setting and verify setting page displays",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "Tap Help and verify Help page displays",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Fill and verify email format functionality",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefination.launchApp()"
});
formatter.result({
  "duration": 111787,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefination.verifyWelcomeScreen()"
});
formatter.result({
  "duration": 639511859,
  "status": "passed"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.VerifySettingPageDisplays()"
});
formatter.result({
  "duration": 51974577005,
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:92)\n\tat org.junit.Assert.fail(Assert.java:100)\n\tat com.sephora.dmg.core.driver.SephoraDsgMobileDriver.click(SephoraDsgMobileDriver.java:153)\n\tat com.sephora.dsg.pages.WelcomePage.VerifySettingPageDisplays(WelcomePage.java:119)\n\tat stepDefination.BiNonBiUserFunctionality_StepDefination.VerifySettingPageDisplays(BiNonBiUserFunctionality_StepDefination.java:20)\n\tat ✽.Then Tap Setting and verify setting page displays(src/test/resources/FeatureFiles/BiNonBiUserFunctionality.feature:16)\n",
  "status": "failed"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.VerifyHelpPageDisplays()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BiNonBiUserFunctionality_StepDefination.VerifyEmailFormatFunctionality()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 28329560081,
  "status": "passed"
});
});