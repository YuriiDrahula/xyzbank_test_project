package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import org.testng.annotations.Test;

public class Story08DeleteCreatedCustomer extends Manager {

    @Test(description = "Verify that bank manager can delete the customer")
    public void tc01_deleteCreatedCustomer(){
        homePage.clickBankManagerLoginButton();
        bankManagerPage.clickCustomersButton();
        customersListPage.searchInput(lastName);
        customersListPage.clickDeleteCustomerButton();
        customersListPage.verifyDeletedCustomerDoesntExistInTable(firstName);
    }
}
