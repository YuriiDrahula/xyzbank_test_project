package com.automation.framework.xyzbank.customerpages.mainpage.transactionspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "button[ng-click='back()']")
    public WebElement backButton;

    @FindBy(css = "button[ng-click='reset()']")
    public WebElement resetButton;

    @FindBy(css = "tr[id='anchor0'] :nth-child(1)")
    public WebElement timeOfDeposit;

    @FindBy(css = "tr[id='anchor0'] :nth-child(2)")
    public WebElement amountOfDeposit;

    @FindBy(css = "tr[id='anchor0'] :nth-child(3)")
    public WebElement depositType;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
