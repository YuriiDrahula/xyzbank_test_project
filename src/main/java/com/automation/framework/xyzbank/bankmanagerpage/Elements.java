package com.automation.framework.xyzbank.bankmanagerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "div[class='center'] button[ng-click='addCust()']")
    public WebElement addCustomerButton;

    @FindBy(css = "div[class='center'] button[ng-click='openAccount()']")
    public WebElement openAccountButton;

    @FindBy(css = "div[class='center'] button[ng-click='showCust()']")
    public WebElement customersButton;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
