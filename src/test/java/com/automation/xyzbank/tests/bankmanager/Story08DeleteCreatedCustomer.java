package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Story08DeleteCreatedCustomer extends Manager {

    @Story("Delete customer")
    @Test(description = "Verify that bank manager can delete the customer")
    public void tc01_deleteCreatedCustomer(){
        homePage.clickBankManagerLoginButton();
        bankManagerPage.clickCustomersButton();
        customersListPage.searchInput(lastName);
        customersListPage.clickDeleteCustomerButton();
        customersListPage.verifyDeletedCustomerDoesntExistInTable(firstName);
    }
}
