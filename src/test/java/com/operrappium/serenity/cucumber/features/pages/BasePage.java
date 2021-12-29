package com.operrappium.serenity.cucumber.features.pages;


import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BasePage extends PageObject {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static boolean isIOS;
    private static boolean isAndroid;
    public static void setAndroid(boolean android) {
        isAndroid = android;
    }
    public static boolean isAndroid() {
        return isAndroid;
    }
    public static void setIOS(boolean iOS) {
        isIOS = iOS;
    }
    public static boolean isIOS() {
        return isIOS;
    }

    //general
    public WebElement waitForElement(WebElement element) {
        return waitForElement(element, 10);
    }

    public WebElement waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void setText(WebElement element, String value) {
        typeInto(waitForElement(element), value);
        getDriver().navigate().back();
    }

    public String getText(WebElement element) {
        String txt = waitForElement(element).getText();
        if (txt.equals("")) {
            txt = element.getAttribute("value");
        }
        LOGGER.info(element.toString() + "  -  " + txt);
        return txt;
    }

    public void clickButtonUsingClassname(String className, String buttonName) throws InterruptedException {
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click " + buttonName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(buttonName)) {
                getDriver().findElements(By.className(className)).get(i).click();
                return;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }
    }

    public void scrollAndClick(String visibleText) {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }

    public void scrollToElement(String visibleText) {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
        ((AndroidDriver) driver).hideKeyboard();
    }

    public void waitForLoadPage() throws InterruptedException {
        Thread.sleep(999);
        for (int i = 0; i < 120; i++) {
            int len = getDriver().findElements(By.className("android.widget.ProgressBar")).size();
            System.out.println("String len " + len);
            if (len == 0) {
                return;
            }
            Thread.sleep(300);
            LOGGER.info("Waiting for page to load");
        }
    }

    public void SendValueUsingClassName(String className, String fieldName, String value) throws InterruptedException {
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click " + fieldName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(fieldName)) {
                getDriver().findElements(By.className(className)).get(i).sendKeys(value);
                return;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }
    }



    public String fetchValueFromExcelSheet(int rowNum, int colNum) throws Throwable {
        String filePath =""; //mention file path if needed
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        try {
            String phoneNumber = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            return phoneNumber;
        } catch (Exception e) {
            Long phoneNumber = (long) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            String phoneNumberinStringFormat = "" + phoneNumber;
            return phoneNumberinStringFormat;
        }
    }

    public void writeDataIntoExcelSheet(int rowNo, int colNo, String text) throws Throwable{
        String filePath ="";
        File file =    new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet2=wb.getSheet("sheet1");
        Row row = sheet2.getRow(rowNo);
        row.createCell(colNo).setCellValue(""+text);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        wb.write(outputStream);
        wb.close();
    }
}
