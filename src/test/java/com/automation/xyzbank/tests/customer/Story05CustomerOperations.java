package com.automation.xyzbank.tests.customer;

import com.automation.framework.xyzbank.Manager;
import org.testng.annotations.Test;

public class Story05CustomerOperations extends Manager {

    @Test(description = "Deposit money to the customers bank account")
    public void tc01_depositMoney(){
        customerMainPage.depositMoney("1000");
        customerMainPage.verifyDepositSuccessfullyMessageIsShown();
        customerMainPage.verifyCorrectBalanceAmount("1000");
    }

    @Test(description = "Withdraw money from the customers bank account")
    public void tc02_withdrawMoney(){
        customerMainPage.withdrawMoney("500");
        customerMainPage.verifyTransactionSuccessfulMessageIsShown();
        customerMainPage.verifyCorrectBalanceAmount("500");
    }
}
