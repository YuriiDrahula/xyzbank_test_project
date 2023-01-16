package com.automation.xyzbank.tests.bankmanager;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Story02OpenAccount extends Manager {

    @Story("Open bank account")
    @Test(description = "Open the bank account in dollar for the created customer")
    public void tc01_openBankAccount() {
        bankManagerPage.clickOpenAccountButton();
        openAccountPage.selectCustomer(fullName);
        openAccountPage.selectCurrency("Dollar");
        openAccountPage.clickProcessButton();
        openAccountPage.verifyAccountCreation();;
        openAccountPage.acceptAlert();
    }
}
