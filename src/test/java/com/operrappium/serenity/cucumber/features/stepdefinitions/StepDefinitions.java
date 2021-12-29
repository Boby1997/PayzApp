package com.operrappium.serenity.cucumber.features.stepdefinitions;

import com.operrappium.serenity.cucumber.features.pages.BasePage;
import com.operrappium.serenity.cucumber.features.pages.HomePage;
import com.operrappium.serenity.cucumber.features.pages.LoginPage;
import com.operrappium.serenity.cucumber.features.steps.Steps;
import com.operrappium.serenity.cucumber.features.utils.TestDataSetup;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitions extends BasePage{

    public static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);

    @net.thucydides.core.annotations.Steps
    Steps steps;
    LoginPage loginPage;

    @Before
    public void setPlatform() {
        String platform = System.getProperty("testEnvironment");
        if (platform == null) {
            platform = "Android";
        }
        LOGGER.info("The platform is " + platform);
        if (platform.compareToIgnoreCase("android") == 0) {
            BasePage.setAndroid(true);
            BasePage.setIOS(false);
        } else {
            BasePage.setAndroid(false);
            BasePage.setIOS(true);
        }
    }

    @After
    public void closeApp() {
        loginPage.closeApp();
    }


    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
        LOGGER.info("user is on login page");
        steps.user_is_on_login_page();
    }

    @Given("^user enter username and \"([^\"]*)\" and password as \"([^\"]*)\" and click Login button$")
    public void user_enter_username_and_and_password_as_and_click_Login_button(String email, String password) throws Throwable {
        steps.user_enter_username_and_and_password_as_and_click_Login_button(email, password);
    }

    @Then("^home page is displayed$")
    public void home_page_is_displayed() throws Throwable {
        steps.home_page_is_displayed();
    }

    @Then("^click on Skip button$")
    public void click_on_Skip_button() throws InterruptedException {
        steps.click_on_Skip_button();

    }

    @And("^check \"([^\"]*)\" is displayed$")
    public void checkIsDisplayed(String arg0) throws Throwable {
        steps.checkIsDisplayed(arg0);

    }

    @And("^check the \"([^\"]*)\" is displayed$")
    public void checkTheIsDisplayed(String arg0) throws Throwable {
        steps.checkTheIsDisplayed(arg0);
    }

    @And("^check \"([^\"]*)\" input field is displayed$")
    public void checkInputFieldIsDisplayed(String arg0) throws Throwable {
        steps.checkInputFieldIsDisplayed(arg0);
    }

    @And("^check \"([^\"]*)\" checkbox is displayed$")
    public void checkCheckboxIsDisplayed(String arg0) throws Throwable {
        steps.checkCheckboxIsDisplayed(arg0);
    }

    @And("^check \"([^\"]*)\" button is displayed and clickable$")
    public void checkButtonIsDisplayedAndClickable(String arg0) throws Throwable {
        steps.checkButtonIsDisplayedAndClickable(arg0);
    }

    @And("^check \"([^\"]*)\" link is displayed$")
    public void checkLinkIsDisplayed(String arg0) throws Throwable {
        steps.checkLinkIsDisplayed(arg0);
    }

    @And("^click \"([^\"]*)\" link$")
    public void clickLink(String arg0) throws Throwable {
        steps.clickLink(arg0);

    }

    @And("^click on \"([^\"]*)\" button$")
    public void clickOnButton(String arg0) throws Throwable {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.clickOnButton(arg0);
        }
    }

    @Then("^message \"([^\"]*)\" is displayed$")
    public void messageIsDisplayed(String arg0) throws Throwable {
        steps.messageIsDisplayed(arg0);
    }

    @Then("^enter the email \"([^\"]*)\"\\.$")
    public void enterTheEmail(String email) throws Throwable {
        steps.enterTheEmail(email);
    }

    //PayzApp
    @Given("^User Click on Login App$")
    public void user_Click_on_Login_App() throws InterruptedException{
        steps.user_Click_on_Login_App();
    }

    @Then("^User Enter Registered Email or Phone Number \"([^\"]*)\" and Click on Login Button$")
    public void user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(String arg1) throws Throwable{
        steps.user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(arg1);
    }

    @Given("^User click on Allow button$")
    public void user_click_on_Allow_button() throws InterruptedException{
        steps.user_click_on_Allow_button();
    }
}
