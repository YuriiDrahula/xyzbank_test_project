package com.automation.framework.xyzbank;

import com.automation.framework.xyzbank.bankmanagerpage.BankManagerPage;
import com.automation.framework.xyzbank.bankmanagerpage.addcustomerpage.AddCustomerPage;
import com.automation.framework.xyzbank.bankmanagerpage.customerslistpage.CustomersListPage;
import com.automation.framework.xyzbank.bankmanagerpage.openaccountpage.OpenAccountPage;
import com.automation.framework.xyzbank.customerpages.loginpage.CustomerLoginPage;
import com.automation.framework.xyzbank.customerpages.mainpage.CustomerMainPage;
import com.automation.framework.xyzbank.customerpages.mainpage.transactionspage.TransactionsPage;
import com.automation.framework.xyzbank.homepage.HomePage;
import com.automation.framework.xyzbank.tools.AdjustedInteractions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(com.automation.framework.xyzbank.tools.Listeners.class)
public class Manager {

    private ChromeOptions chromeOptions;
    public WebDriver driver;
    private String pathToGlobalVariables = "src\\main\\resources\\globalvariables.properties";
    private String url;
    public static String firstName;
    public static String lastName;
    public static String postCode;
    public static String fullName;
    public static String depositAmount;
    public static String depositType;
    public static String withdrawAmount;
    public static String nullBalance;
    public static SoftAssert softAssert;
    public AdjustedInteractions adjustedInteractions;
    public static HomePage homePage;
    public static BankManagerPage bankManagerPage;
    public static AddCustomerPage addCustomerPage;
    public static OpenAccountPage openAccountPage;
    public static CustomersListPage customersListPage;
    public static CustomerLoginPage customerLoginPage;
    public static CustomerMainPage customerMainPage;
    public static TransactionsPage transactionsPage;
    public Logger logger;

    @BeforeSuite
    public void prepareTestSuite() throws IOException {
        logger = LogManager.getLogger(getClass());
        logger.info("Logging started.");

        logger.info("Loading global variables.");
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(pathToGlobalVariables);
        properties.load(fileInputStream);
        url = properties.getProperty("url");
        firstName = properties.getProperty("firstName");
        lastName = properties.getProperty("lastName");
        postCode = properties.getProperty("postCode");
        fullName = properties.getProperty("fullName");
        depositAmount = properties.getProperty("depositAmount");
        depositType = properties.getProperty("depositType");
        withdrawAmount = properties.getProperty("withdrawAmount");
        nullBalance = properties.getProperty("nullBalance");
        logger.info("Global variables loaded.");

        logger.info("Initializing Web Driver.");
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        logger.info("Chrome driver initialized.");

        logger.info("Opening tested site " + url);
        driver.get(url);
        logger.info(url + " has been opened.");

        logger.debug("Initializing variables of web pages.");
        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        bankManagerPage = new BankManagerPage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        openAccountPage = new OpenAccountPage(driver);
        customersListPage = new CustomersListPage(driver);
        customerLoginPage = new CustomerLoginPage(driver);
        customerMainPage = new CustomerMainPage(driver);
        transactionsPage = new TransactionsPage(driver);
        logger.debug("Variables of web pages initialized.");
    }


    @AfterSuite
    public void terminateDriver(){
        //driver.quit();
        logger.info("The driver was closed.");
    }

    /*@Test
    public void testDriver(){
        homePage.clickBankManagerLoginButton();
        bankManagerPage.clickAddCustomerButton();
    }*/
}
