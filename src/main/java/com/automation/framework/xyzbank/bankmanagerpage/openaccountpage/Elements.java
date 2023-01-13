package com.automation.framework.xyzbank.bankmanagerpage.openaccountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "select[id='userSelect']")
    public WebElement customerDropdown;

    @FindBy(css = "select[id='currency']")
    public WebElement currencyDropdown;

    @FindBy(css = "button[type='submit']")
    public WebElement processButton;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
