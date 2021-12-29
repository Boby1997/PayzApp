package com.operrappium.serenity.cucumber.features.pages;

import com.operrappium.serenity.cucumber.features.stepdefinitions.StepDefinitions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    StepDefinitions stepDefinitions;

    public void clickOnNavigationBar() throws InterruptedException {
        Thread.sleep(1999);
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className("android.widget.ImageButton"));
        getDriver().findElement(By.className("android.widget.ImageButton")).click();
        Thread.sleep(1999);
    }

    public void clickOnGivenMenu(String menuName) throws InterruptedException {
        clickButtonUsingClassname("android.widget.TextView", menuName);
        Thread.sleep(2999);
    }

    public boolean isTextDisplayed(String classname, String pageName) throws InterruptedException {
        Thread.sleep(2999);
        waitForLoadPage();
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className(classname));
        int len = getDriver().findElements(By.className(classname)).size();
        int i;
        LOGGER.info("btnname " + pageName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(classname)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(pageName)) {

                return true;
            }
        }
        if (i == len) {

            return false;
        }
        return true;
    }
    //PayzApp code

}