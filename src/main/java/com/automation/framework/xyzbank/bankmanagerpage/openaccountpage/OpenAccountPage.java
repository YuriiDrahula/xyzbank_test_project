package com.automation.framework.xyzbank.bankmanagerpage.openaccountpage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
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

    public void selectCustomer(String fullName) {
        adjustedInteractions.click(elements.customerDropdown);
        logger.debug("Clicked the 'Customer' dropdown.");
        adjustedInteractions.selectFromDropdown("option[ng-repeat='cust in Customers']", fullName);
    }

    public void selectCurrency(String currency){
        adjustedInteractions.click(elements.currencyDropdown);
        logger.debug("Clicked the 'Currency' dropdown.");
        adjustedInteractions.selectFromDropdown("select[id='currency'] option", currency);
    }

    public void clickProcessButton(){
        adjustedInteractions.click(elements.processButton);
        logger.debug("Clicked the 'Process' button.");
    }

    public void acceptAlert(){
        adjustedInteractions.acceptAlert();
        logger.debug("JS alert accepted.");
    }

    public void verifyAccountCreation(){
        logger.debug("Entered verifyAccountCreation method");
        softAssert.assertTrue(adjustedInteractions.getTextFromAlertBox().contains("Account created successfully"),
                "The text in alert box doesn't match with the expected!");
        softAssert.assertAll();
    }
}
