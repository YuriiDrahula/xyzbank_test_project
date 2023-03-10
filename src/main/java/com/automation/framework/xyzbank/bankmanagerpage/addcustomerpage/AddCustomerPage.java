package com.automation.framework.xyzbank.bankmanagerpage.addcustomerpage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AddCustomerPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public SoftAssert softAssert;
    public Logger logger;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.softAssert = new SoftAssert();
        this.logger = LogManager.getLogger(getClass());
    }

    @Step("Enter customer's first name into the 'First name' input field")
    public void enterFirstName(String firstName){
        logger.debug("Entered enterFirstName method.");
        adjustedInteractions.sendKeys(elements.firstNameInputField, firstName);
        logger.debug("Filled the 'Fist Name' input field with - " + firstName);
    }

    @Step("Enter customer's last name into the 'Last name' input field")
    public void enterLastName(String lastName){
        logger.debug("Entered enterLastName method.");
        adjustedInteractions.sendKeys(elements.lastNameInputField, lastName);
        logger.debug("Filled the 'Last Name' input field with - " + lastName);
    }

    @Step("Enter customer's post code into the 'Post Code' input field")
    public void enterPostCode(String postCode){
        logger.debug("Entered enterPostCode method.");
        adjustedInteractions.sendKeys(elements.postCodeInputField, postCode);
        logger.debug("Filled the 'Post Code' input field with - " + postCode);
    }

    @Step("Click the 'Add Customer' button")
    public void clickAddCustomerButton(){
        logger.debug("Entered clickAddCustomerButton method.");
        adjustedInteractions.click(elements.addCustomerButton);
        logger.debug("Clicked the 'Add Customer' button.");
    }

    @Step("Click the 'OK' button at the alert window")
    public void acceptAlert(){
        adjustedInteractions.acceptAlert();
    }

    @Step("Verify that the 'Customer added successfully' message is shown in the alert window")
    public void verifyCustomerAddition(){
        logger.debug("Entered verifyCustomerAddition method.");
        softAssert.assertTrue(adjustedInteractions.getTextFromAlertBox().contains("Customer added successfully"),
                "The text in alert box doesn't match with the expected!");
        softAssert.assertAll();
    }
}
