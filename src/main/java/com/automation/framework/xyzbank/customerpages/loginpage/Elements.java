package com.automation.framework.xyzbank.customerpages.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    @FindBy(css = "select[id='userSelect']")
    public WebElement loginDropdown;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;


    public Elements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
