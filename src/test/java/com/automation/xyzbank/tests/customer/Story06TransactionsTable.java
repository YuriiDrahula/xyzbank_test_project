package com.automation.xyzbank.tests.customer;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Flaky;
import org.testng.annotations.Test;

public class Story06TransactionsTable extends Manager {

    @Flaky
    @Test(description = "Verify that the transaction from the previous tests exists in the 'Transactions' table")
    public void tc01_verifyDepositTransaction(){
        customerMainPage.clickTransactionsButton();
        transactionsPage.verifyTransactionAmount(depositAmount);
        transactionsPage.verifyTransactionType(depositType);
    }

    @Test(description = "Verify that after clicking the 'Reset' button the balance = 0")
    public void tc02_resetBalance(){
        transactionsPage.clickResetButton();
        transactionsPage.clickBackButton();
        customerMainPage.verifyCorrectBalanceAmount(nullBalance);
    }

}
