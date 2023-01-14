package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import org.testng.annotations.Test;

public class Story01AddCustomer extends Manager {

    @Test(description = "Add the customer by the bank manager")
    public void tc01_addCustomerOne(){
        homePage.clickBankManagerLoginButton();
        bankManagerPage.clickAddCustomerButton();
        addCustomerPage.enterFirstName("John");
        addCustomerPage.enterLastName("Doe");
        addCustomerPage.enterPostCode("12345");
        addCustomerPage.clickAddCustomerButton();
        addCustomerPage.verifyCustomerAddition();
        addCustomerPage.acceptAlert();
    }

}
