package com.automation.framework.xyzbank.bankmanagerpage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BankManagerPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public Logger logger;

    public BankManagerPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.logger = LogManager.getLogger(getClass());
    }

    @Step("Go to the 'Add Customer' page")
    public void clickAddCustomerButton(){
        logger.debug("Entered clickAddCustomerButton method.");
        adjustedInteractions.click(elements.addCustomerButton);
        logger.debug("Clicked the 'Add Customer' button.");
    }

    @Step("Go to the 'Open Account' page")
    public void clickOpenAccountButton(){
        logger.debug("Entered clickOpenAccountButton method.");
        adjustedInteractions.click(elements.openAccountButton);
        logger.debug("Clicked the 'Open Account' button.");
    }

    @Step("Go to the 'Customer list' page")
    public void clickCustomersButton(){
        logger.debug("Entered clickCustomersButton method.");
        adjustedInteractions.click(elements.customersButton);
        logger.debug("Clicked the 'Customer' button.");
    }
}
