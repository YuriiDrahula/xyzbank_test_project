package com.automation.xyzbank.tests.customer;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Story04LoginAsCustomer extends Manager {

    @Story("Login to customers account")
    @Test(description = "Login to customers account with the newly created customer credentials")
    public void tc01_loginAsCustomer(){
        homePage.clickCustomerLoginButton();
        customerLoginPage.selectUserToLogin(fullName);
        customerLoginPage.clickLoginButton();
        customerMainPage.verifyCorrectCustomerLoggedIn(fullName);
    }
}
