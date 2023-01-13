package com.automation.framework.xyzbank.customerpages.mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "button[ng-show='logout']")
    public WebElement logoutButton;

    @FindBy(css = "span[class='fontBig ng-binding']")
    public WebElement loggedUserName;

    @FindBy(css = "select[id='accountSelect'] ")
    public WebElement accountDropdown;

    @FindBy(css = "div[class='center'] :nth-child(1)")
    public WebElement accountNumber;

    @FindBy(css = "div[class='center'] :nth-child(2)")
    public WebElement accountBalance;

    @FindBy(css = "div[class='center'] :nth-child(3)")
    public WebElement accountCurrency;

    @FindBy(css = "button[ng-click='transactions()']")
    public WebElement transactionsButton;

    @FindBy(css = "button[ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(css = "form[ng-submit='deposit()'] input[placeholder='amount']")
    public WebElement depositInputField;

    @FindBy(css = "form[ng-submit='deposit()'] button[type='submit']")
    public WebElement confirmDepositButton;

    @FindBy(css = "span[ng-show='message']")
    public WebElement successMessage;

    @FindBy(css = "button[ng-click='withdrawl()'] ")
    public WebElement withdrawButton;

    @FindBy(css = "form[ng-submit='withdrawl()'] input[placeholder='amount']")
    public WebElement withdrawInputField;

    @FindBy(css = "form[ng-submit='withdrawl()'] button[type='submit']")
    public WebElement confirmWithdrawButton;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
