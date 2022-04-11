package com.demoblaze.cucumber.featureSteps;

import com.demoblaze.cucumber.steps.LogInSteps;
import com.demoblaze.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogInFeatureSteps {

    @Steps
    LogInSteps loginUser;
    BasePage baseUser;

    @Given("user is at the DemoBlaze home page")
    public void userAtHomePage() {
        baseUser.navigateToDemoBlaze();    }

    @And("user clicks on the Log in link")
    public void userClicksOnTheLoginLink() {
        loginUser.navigateToLogin();
    }

    @When("user enters {word} and {word}")
    public void userEntersUserNameAndPassword(String userName, String password) {
        loginUser.enterUserInfo(userName, password);
    }

    @And("user clicks on Log in button")
    public void userClicksOnLogIn() {
        loginUser.login();
    }

    @Then("user should see Welcome {word}")
    public void UserSeeWelcomeUsername(String userName) {
        loginUser.verifyWelcomeMessage(userName);
    }

    @Then("an alert message should say login is incorrect")
    public void userGetsAlertMessageLoginIncorrect() {
        loginUser.verifyIncorrectLogin();
    }

    @Then("an alert message should say user does not exist")
    public void userGetsAlertMessageInvalidUsername() {
        loginUser.verifyWrongUser();
    }
}