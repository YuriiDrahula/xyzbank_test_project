package com.automation.framework.xyzbank.bankmanagerpage.openaccountpage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class OpenAccountPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public SoftAssert softAssert;
    public Logger logger;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.softAssert = new SoftAssert();
        this.logger = LogManager.getLogger(getClass());
    }

    @Step("Select customer from the 'Customer' dropdown")
    public void selectCustomer(String fullName) {
        adjustedInteractions.click(elements.customerDropdown);
        logger.debug("Clicked the 'Customer' dropdown.");
        adjustedInteractions.selectFromDropdown("option[ng-repeat='cust in Customers']", fullName);
    }

    @Step("Select currency from the 'Currency' dropdown")
    public void selectCurrency(String currency){
        adjustedInteractions.click(elements.currencyDropdown);
        logger.debug("Clicked the 'Currency' dropdown.");
        adjustedInteractions.selectFromDropdown("select[id='currency'] option", currency);
    }

    @Step("Click the 'Process' button")
    public void clickProcessButton(){
        adjustedInteractions.click(elements.processButton);
        logger.debug("Clicked the 'Process' button.");
    }

    @Step("Click the 'OK' button in the alert window")
    public void acceptAlert(){
        adjustedInteractions.acceptAlert();
        logger.debug("JS alert accepted.");
    }

    @Step("Verify that the 'Account created successfully' message is displayed in alert window")
    public void verifyAccountCreation(){
        logger.debug("Entered verifyAccountCreation method");
        softAssert.assertTrue(adjustedInteractions.getTextFromAlertBox().contains("Account created successfully"),
                "The text in alert box doesn't match with the expected!");
        softAssert.assertAll();
    }
}
