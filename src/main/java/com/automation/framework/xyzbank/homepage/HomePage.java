package com.automation.framework.xyzbank.homepage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public Logger logger;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.logger = LogManager.getLogger(getClass());
    }

    @Step("Click the 'Home' button")
    public void clickHomeButton(){
        logger.debug("Entered clickHomeButton method");
        adjustedInteractions.click(elements.homeButton);
        logger.debug("Clicked the 'Home' button.");
    }

    @Step("Click the 'Customer Login' button")
    public void clickCustomerLoginButton(){
        logger.debug("Entered clickCustomerLoginButton method");
        adjustedInteractions.click(elements.customerLoginButton);
        logger.debug("Clicked the 'Customer Login' button.");
    }

    @Step("Click the 'Bank Manager Login' button")
    public void clickBankManagerLoginButton(){
        logger.debug("Entered clickBankManagerLoginButton method");
        adjustedInteractions.click(elements.bankManagerLoginButton);
        logger.debug("Clicked the 'Bank Manager Login' button.");
    }
}
