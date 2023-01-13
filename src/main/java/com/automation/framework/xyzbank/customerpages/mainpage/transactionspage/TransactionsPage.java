package com.automation.framework.xyzbank.customerpages.mainpage.transactionspage;


import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TransactionsPage {

    public WebDriver driver;
    public Elements elements;
    public AdjustedInteractions adjustedInteractions;
    public SoftAssert softAssert;
    public Logger logger;

    public TransactionsPage(WebDriver driver){
        this.driver = driver;
        this.elements = new Elements(driver);
        this.adjustedInteractions = new AdjustedInteractions(driver);
        this.softAssert = new SoftAssert();
        this.logger = LogManager.getLogger(getClass());
    }

    public void clickBackButton(){
        logger.debug("Entered clickBackButton method.");
        adjustedInteractions.click(elements.backButton);
        logger.debug("Clicked the 'Back' button.");
    }

    public void clickResetButton(){
        logger.debug("Entered clickResetButton method.");
        adjustedInteractions.click(elements.resetButton);
        logger.debug("Clicked the 'Reset' button.");
    }

    public void verifyTransactionAmount(String expectedAmountOfTransaction){
        logger.debug("Entered verifyTransactionAmount method.");
        adjustedInteractions.wait(elements.amountOfDeposit);
        softAssert.assertEquals(elements.amountOfDeposit.getText(),
                expectedAmountOfTransaction, "The transactions amount isn't correct!");
        softAssert.assertAll();
    }

    public void verifyTransactionType(String expectedTransactionType){
        logger.debug("Entered verifyTransactionType method.");
        adjustedInteractions.wait(elements.depositType);
        softAssert.assertEquals(elements.depositType.getText(),
                expectedTransactionType, "The transactions type isn't correct!");
        softAssert.assertAll();
    }

    public void verifyTime(String expectedTime){
        logger.debug("Entered verifyTime method.");
        adjustedInteractions.wait(elements.timeOfDeposit);
        softAssert.assertEquals(elements.timeOfDeposit.getText(),
                expectedTime, "Expected time isn't correct!");
        softAssert.assertAll();
    }
}
