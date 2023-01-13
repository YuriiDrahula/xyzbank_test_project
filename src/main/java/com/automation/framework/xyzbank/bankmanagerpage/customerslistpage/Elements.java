package com.automation.framework.xyzbank.bankmanagerpage.customerslistpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "input[type='text']")
    public WebElement searchInputField;

    @FindBy(css = "td[class='ng-binding']")
    public WebElement tableRow;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
