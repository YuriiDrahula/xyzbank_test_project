package com.automation.framework.xyzbank.bankmanagerpage.customerslistpage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CustomersListPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public SoftAssert softAssert;
    public Logger logger;

    public CustomersListPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.softAssert = new SoftAssert();
        this.logger = LogManager.getLogger(getClass());
    }

    @Step("Search for the newly created customer")
    public void searchInput(String searchedInput){
        logger.debug("Entered searchInput method.");
        adjustedInteractions.sendKeys(elements.searchInputField, searchedInput);
        logger.debug(searchedInput + " is searched.");
    }

    @Step("Click the 'Delete' button for deleting the customer")
    public void clickDeleteCustomerButton(){
        adjustedInteractions.click(elements.deleteCustomerButton);
    }

    @Step("Verify that newly created customer is added to the 'Customers' table")
    public void verifyNewCustomerExistsInTable(String searchedElement){
        logger.debug("Entered verifyNewCustomerExistsInTable method.");
        adjustedInteractions.wait(elements.tableRow);
        int loopNumber = 1;
        List<WebElement> table = driver.findElements(By.cssSelector("td[class='ng-binding']"));
        for(WebElement tableRow : table){
            if(tableRow.getText().equals(searchedElement)){
                logger.debug(searchedElement + " was found in the table.");
                break;
            }else {
                if(loopNumber == table.size()){
                    softAssert.fail(searchedElement + " wasn't found in the table.");}
            }
            loopNumber++;
        }
        softAssert.assertAll();
    }

    @Step("Verify that deleted customer is deleted from the 'Customers' table")
    public void verifyDeletedCustomerDoesntExistInTable(String customersName){
        logger.debug("Entered verifyNewCustomerExistsInTable method.");
        List<WebElement> table = driver.findElements(By.cssSelector("td[class='ng-binding']"));
        if(table.size() == 0){
            softAssert.assertTrue(true);
        } else {
            softAssert.fail(customersName + " still can be found in the table!");
        }
        softAssert.assertAll();
    }
}
