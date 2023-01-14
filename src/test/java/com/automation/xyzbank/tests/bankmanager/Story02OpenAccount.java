package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import org.testng.annotations.Test;

public class Story02OpenAccount extends Manager {

    @Test(description = "Open the bank account in dollar for the created customer")
    public void tc01_openBankAccount() {
        bankManagerPage.clickOpenAccountButton();
        openAccountPage.selectCustomer("John Doe");
        openAccountPage.selectCurrency("Dollar");
        openAccountPage.clickProcessButton();
        openAccountPage.verifyAccountCreation();;
        openAccountPage.acceptAlert();
    }
}
