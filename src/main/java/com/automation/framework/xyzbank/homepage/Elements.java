package com.automation.framework.xyzbank.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "button[class='btn home']")
    public WebElement homeButton;

    @FindBy(css = "div[class='center'] button[ng-click='customer()']")
    public WebElement customerLoginButton;

    @FindBy(css = "div[class='center'] button[ng-click='manager()']")
    public WebElement bankManagerLoginButton;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
