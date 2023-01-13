package com.automation.framework.xyzbank.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class AdjustedInteractions {

    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert softAssert;
    public Logger logger;

    public AdjustedInteractions(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();
        this.logger = LogManager.getLogger(getClass());
    }

    public void click(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public void sendKeys(WebElement element, String keysToSend){
        wait.until(ExpectedConditions.visibilityOf(element));
        while(!element.getAttribute("value").isEmpty()){
            element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
        element.sendKeys(keysToSend);
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getTextFromAlertBox(){
        String text = driver.switchTo().alert().getText();
        return text;
    }

    public void selectFromDropdown(String elementsCSS, String keysToSend){
        int loopNumber = 1;
        List<WebElement> dropdown = driver.findElements(By.cssSelector(elementsCSS));

        for(WebElement dropdownElement : dropdown){
            if(dropdownElement.getText().equals(keysToSend)){
                logger.debug("Found the element - " + keysToSend);
                dropdownElement.click();
                logger.debug("Clicked the element - " + keysToSend);
                break;
            } else {
                if(loopNumber == dropdown.size()){
                    softAssert.fail(keysToSend + " wasn't found in the dropdown");}
            }
            loopNumber++;
        }
        softAssert.assertAll();
    }

    public void wait(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy h:m:s a");
        String currentTime = simpleDateFormat.format(new Date());
        return currentTime;
    }
}
