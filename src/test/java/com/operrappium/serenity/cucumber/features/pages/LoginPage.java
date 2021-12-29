package com.operrappium.serenity.cucumber.features.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

//    @FindBy(className = "//text()='Password'")
    @FindBy(id = "com.operr.operrprovider.us.dev:id/email_login_activity")
    private WebElement editText_email;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/password_login_activity")
    private WebElement editText_password;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/skip_screen_slide")
    private WebElement skip_button;
    @FindBy(id = "com.enstage.wibmo.hdfc:id/textbutton_login")
    private WebElement login_btn;

    public boolean isEmailFieldDisplayed() throws InterruptedException {
//        Thread.sleep(9999);
//        return waitForElement(skip_button, 60).isDisplayed();
        return waitForElement(login_btn, 60).isDisplayed();
    }

    public void login(String email, String password) throws InterruptedException {
        Thread.sleep(1999);
        getDriver().findElements(By.className("android.widget.EditText")).get(0).sendKeys(email);
        getDriver().findElements(By.className("android.widget.EditText")).get(1).sendKeys(password);
        clickButtonUsingClassname("android.widget.Button", "Sign in");
        Thread.sleep(1999);
        //        clickButtonUsingClassname("android.widget.Button", "Driver Login");
        Thread.sleep(2999);
    }


    @FindBy(id = "com.bynfor.dev:id/edt_product_search")
    private WebElement home_page;

    public boolean home_page_is_displayed() throws Throwable {
        Thread.sleep(9999);
        return waitForElement(home_page, 40).isDisplayed();
    }

    public void setEmail(String email) throws InterruptedException {
        waitForElement(editText_email).sendKeys(email);
    }

    @AndroidFindBy(id = "android:id/message")
//    @iOSFindBy(xpath = "ios:id/message")
    @FindBy(xpath = "android:id/message")
    private WebElement errorMessage;

    public String getErrorMsg() throws InterruptedException {
        return waitForElement(errorMessage).getText();
    }

    public void click_on_Skip_button() throws InterruptedException {
        Thread.sleep(999);
        skip_button.click();
    }

    public void closeApp(){
        getDriver().quit();
//        ((AppiumDriver)getDriver()).quit();
//        ((AppiumDriver) getDriver()).resetApp();
    }

    //PayzApp
    public void clickLoginButton() throws InterruptedException{
        String xpathLogin = "//*[@text=\"Login\"]";
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(xpathLogin));
        getDriver().findElement(By.xpath(xpathLogin)).click();
//        clickButtonUsingClassname("android.widget.TextView", "Login");
    }

    public void enterEmailOrPhoneNumber(String emailOrPhoneNumber) throws Throwable{
        Thread.sleep(1999);
        String getPhoneNumber = fetchValueFromExcelSheet(1,0);
        Thread.sleep(999);
        getDriver().findElement(By.id("com.enstage.wibmo.hdfc:id/fl_text_username")).sendKeys(getPhoneNumber+"");
        clickButtonUsingClassname("android.widget.Button", "Login");
        Thread.sleep(2999);
    }

    public void clicAllowButton() throws InterruptedException{
        clickButtonUsingClassname("android.widget.Button", "Allow");
    }
}
