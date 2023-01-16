package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Story03FindCustomer extends Manager {

    @Story("Find new customer in the table")
    @Test(description = "Verify that new customer was created by finding him in the 'Customers' table")
    public void tc01_findCreatedCustomer() {
        bankManagerPage.clickCustomersButton();
        customersListPage.searchInput(firstName);
        customersListPage.verifyNewCustomerExistsInTable(lastName);
        homePage.clickHomeButton();
        softAssert.assertAll();
    }
}
