package com.automation.framework.xyzbank.customerpages.mainpage;

import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CustomerMainPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public SoftAssert softAssert;
    public Logger logger;

    public CustomerMainPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.softAssert = new SoftAssert();
        this.logger = LogManager.getLogger(getClass());
    }

    @Step("Click the 'Transactions' button")
    public void clickTransactionsButton(){
        logger.debug("Entered clickTransactionsButton method.");
        adjustedInteractions.click(elements.transactionsButton);
        logger.debug("Clicked the 'Transactions' button.");
    }

    @Step("Click the 'Logout' button")
    public void clickLogoutButton(){
        logger.debug("Entered clickLogoutButton method.");
        adjustedInteractions.click(elements.logoutButton);
        logger.debug("Clicked the 'Logout' button.");
    }

    public String getCustomerName(){
        adjustedInteractions.wait(elements.loggedUserName);
        return elements.loggedUserName.getText();
    }

    public String getBalanceAmount(){
        adjustedInteractions.wait(elements.accountBalance);
        return elements.accountBalance.getText();
    }
    @Step("Verify that the chosen in dropdown customer logged in")
    public void verifyCorrectCustomerLoggedIn(String fullName){
        logger.debug("Entered verifyCorrectCustomerLoggedIn method.");
        softAssert.assertEquals(getCustomerName(), fullName,
                "The incorrect customer logged in! You logged in as " + getCustomerName());
        softAssert.assertAll();
    }

    @Step("Deposit money to the customers bank account")
    public void depositMoney(String amountToDeposit){
        logger.debug("Entered depositMoney method.");
        adjustedInteractions.click(elements.depositButton);
        logger.debug("Clicked the 'Deposit' button.");
        adjustedInteractions.sendKeys(elements.depositInputField, amountToDeposit);
        logger.debug("Filled the 'Deposit' input field with amount of - " + amountToDeposit);
        adjustedInteractions.click(elements.confirmDepositButton);
        logger.debug("Clicked the 'Confirm Deposit' button.");
    }

    @Step("Withdraw money from the customers bank account")
    public void withdrawMoney(String amountToWithdraw){
        logger.debug("Entered withdrawMoney method.");
        adjustedInteractions.click(elements.withdrawButton);
        logger.debug("Clicked the 'Withdraw' button.");
        adjustedInteractions.sendKeys(elements.withdrawInputField, amountToWithdraw);
        logger.debug("Filled the 'Withdraw' input field with amount of - " + amountToWithdraw);
        adjustedInteractions.click(elements.confirmWithdrawButton);
        logger.debug("Clicked the 'Confirm Withdraw' button.");
    }

    public String getSuccessMessage(){
        adjustedInteractions.wait(elements.successMessage);
        return elements.successMessage.getText();
    }

    @Step("Verify that the 'Deposit Successful' message is shown after making a deposit")
    public void verifyDepositSuccessfullyMessageIsShown(){
        logger.debug("Entered verifyDepositSuccessfullyMessageIsShown method.");
        softAssert.assertTrue(getSuccessMessage().equals("Deposit Successful"),
                "The 'Deposit Successful' message isn't shown.");
        softAssert.assertAll();
    }

    @Step("Verify that the 'Transaction successful' message is shown after withdrawing money")
    public void verifyTransactionSuccessfulMessageIsShown(){
        logger.debug("Entered verifyTransactionSuccessfulMessageIsShown method.");
        softAssert.assertTrue(getSuccessMessage().equals("Transaction successful"),
                "The 'Transaction successful' message isn't shown.");
        softAssert.assertAll();
    }
    @Step("Verify that the customers account balance is equal to the expected")
    public void verifyCorrectBalanceAmount(String expectedBalance){
        logger.debug("Entered verifyCorrectBalanceAmount method.");
        adjustedInteractions.wait(elements.accountBalance);
        softAssert.assertEquals(getBalanceAmount(), expectedBalance,
                "The incorrect balance amount!");
        softAssert.assertAll();
    }

}
