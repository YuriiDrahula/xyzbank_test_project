package com.automation.xyzbank.tests.customer;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Story05CustomerOperations extends Manager {

    @Story("Make deposit")
    @Test(description = "Deposit money to the customers bank account")
    public void tc01_depositMoney(){
        customerMainPage.depositMoney(depositAmount);
        customerMainPage.verifyDepositSuccessfullyMessageIsShown();
        customerMainPage.verifyCorrectBalanceAmount(depositAmount);
    }

    @Story("Withdraw money")
    @Test(description = "Withdraw money from the customers bank account")
    public void tc02_withdrawMoney(){
        customerMainPage.withdrawMoney(withdrawAmount);
        customerMainPage.verifyTransactionSuccessfulMessageIsShown();
        customerMainPage.verifyCorrectBalanceAmount(withdrawAmount);
    }
}
