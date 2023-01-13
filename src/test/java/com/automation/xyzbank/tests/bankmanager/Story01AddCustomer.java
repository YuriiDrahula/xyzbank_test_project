package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import org.testng.annotations.Test;

public class Story01AddCustomer extends Manager {

    @Test(description = "Add the customer by the bank manager")
    public void tc01_addCustomerOne(){
        homePage.clickBankManagerLoginButton();
        bankManagerPage.clickAddCustomerButton();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode(postCode);
        addCustomerPage.clickAddCustomerButton();
        addCustomerPage.verifyCustomerAddition();
        addCustomerPage.acceptAlert();
    }

}
