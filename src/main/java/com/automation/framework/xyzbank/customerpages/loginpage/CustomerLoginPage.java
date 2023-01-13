package com.automation.framework.xyzbank.customerpages.loginpage;


import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public Logger logger;

    public CustomerLoginPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.logger = LogManager.getLogger(getClass());
    }

    public void selectUserToLogin(String fullName){
        logger.debug("Entered selectUserToLogin method.");
        adjustedInteractions.click(elements.loginDropdown);
        logger.debug("Clicked the 'Your Name' dropdown.");
        adjustedInteractions.selectFromDropdown("option[class='ng-binding ng-scope']", fullName);
    }

    public void clickLoginButton(){
        logger.debug("Entered clickLoginButton method.");
        adjustedInteractions.click(elements.loginButton);
        logger.debug("Clicked the 'Login' button.");
    }
}
