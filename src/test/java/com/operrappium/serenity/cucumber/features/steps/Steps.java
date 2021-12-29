package com.operrappium.serenity.cucumber.features.steps;

import com.operrappium.serenity.cucumber.features.pages.*;
import com.operrappium.serenity.cucumber.features.utils.TestDataSetup;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Steps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(Steps.class);

    private LoginPage loginPage;
    private HomePage homePage;
    private DriverAppPage driverAppPage;

    @Step
    public void user_is_on_login_page() throws Throwable {
        Assert.assertEquals(true, loginPage.isEmailFieldDisplayed());
//        loginPage.login("email", "password");
    }

    @Step
    public void user_enter_username_and_and_password_as_and_click_Login_button(String email, String password) throws Throwable {
        loginPage.login(email, password);
    }


    @Step
    public void home_page_is_displayed() throws Throwable {
        Assert.assertEquals(true, loginPage.home_page_is_displayed());
    }

    @Step
    public void click_on_Skip_button() throws InterruptedException {
        loginPage.click_on_Skip_button();

    }

    @Step
    public void checkIsDisplayed(String arg0) throws Throwable {
        Assert.assertEquals(true, driverAppPage.checkIsDisplayed(arg0));

    }

    @Step
    public void checkTheIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driverAppPage.checkTheIsDisplayed(arg0).contains(arg0));

    }

    @Step
    public void checkInputFieldIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driverAppPage.checkInputFieldIsDisplayed(arg0).contains(arg0));
    }

    @Step
    public void checkCheckboxIsDisplayed(String arg0) throws Throwable {
        System.out.println(driverAppPage.checkCheckboxIsDisplayed(arg0));
        Assert.assertTrue(driverAppPage.checkCheckboxIsDisplayed(arg0).contains(arg0));
    }

    @Step
    public void checkButtonIsDisplayedAndClickable(String arg0) throws Throwable {
        Assert.assertEquals(true, driverAppPage.checkButtonIsDisplayedAndClickable(arg0));
    }

    @Step
    public void checkLinkIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driverAppPage.checkLinkIsDisplayed(arg0).contains(arg0));
    }

    @Step
    public void clickLink(String arg0) throws Throwable {
        driverAppPage.clickLink(arg0);
    }

    @Step
    public void clickOnButton(String arg0) throws Throwable {
        driverAppPage.clickOnButton(arg0);
    }

    @Step
    public void messageIsDisplayed(String arg0) throws Throwable {
//        Assert.assertEquals(true, driverAppPage.messageIsDisplayed(arg0));
//        Assert.assertTrue(driverAppPage.messageIsDisplayed(arg0).contains(arg0));
        Thread.sleep(2999);

    }

    @Step
    public void enterTheEmail(String email) throws Throwable {
        driverAppPage.enterTheEmail(email);
    }

    //PayzApp
    @Step
    public void user_Click_on_Login_App() throws InterruptedException{
        loginPage.clickLoginButton();
    }

    @Step
    public void user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(String arg1) throws Throwable{
        loginPage.enterEmailOrPhoneNumber(arg1);
    }

    @Step
    public void user_click_on_Allow_button() throws InterruptedException{
        loginPage.clicAllowButton();
    }
}
