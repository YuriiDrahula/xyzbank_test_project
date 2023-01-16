package com.automation.xyzbank.tests.customer;

import com.automation.framework.xyzbank.Manager;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Story07LogoutAsCustomer extends Manager {

    @Story("Logout from customers account")
    @Test(description = "Verify that the customer can logout from his account")
    public void tc01_logoutFromCustomerAccount(){
        customerMainPage.clickLogoutButton();
        customerLoginPage.verifyUserIsLocatedOnLoginPage();
        homePage.clickHomeButton();
    }
}
