package com.automation.xyzbank.tests.customer;

import com.automation.framework.xyzbank.Manager;
import org.testng.annotations.Test;

public class Story04LoginAsCustomer extends Manager {

    @Test(description = "Login as customer with the created customer credentials")
    public void tc01_loginAsCustomer(){
        homePage.clickCustomerLoginButton();
        customerLoginPage.selectUserToLogin(fullName);
        customerLoginPage.clickLoginButton();
        customerMainPage.verifyCorrectCustomerLoggedIn(fullName);
    }
}
