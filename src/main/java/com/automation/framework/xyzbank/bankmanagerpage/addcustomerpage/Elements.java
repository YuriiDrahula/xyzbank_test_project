package com.automation.framework.xyzbank.bankmanagerpage.addcustomerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(xpath = ".//input[@placeholder='First Name']")
    public WebElement firstNameInputField;

    @FindBy(css = "input[placeholder='Last Name']")
    public WebElement lastNameInputField;

    @FindBy(css = "input[placeholder='Post Code']")
    public WebElement postCodeInputField;

    @FindBy(css = "button[type='submit']")
    public WebElement addCustomerButton;

    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
