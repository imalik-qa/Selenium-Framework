package com.qaclickacademy.app;

import base.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.io.IOException;

public class LoginTest extends Base {
    @BeforeTest
    private void init() throws IOException {
        driver = initDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("login-url"));
        log.info("Successfully loaded *" + prop.getProperty("url") +  "* url");
    }

    @Test(dataProvider = "getData", dataProviderClass = base.DataClass.class)
    private void loginTest(String userName, String password) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);

        lp.getUserEmailField().clear();
        lp.getUserEmailField().sendKeys(userName);
        lp.getpswdField().clear();
        lp.getpswdField().sendKeys(password);
        lp.getSubmitBtn().click();
        sa.assertTrue(lp.getInvalidAlert().isDisplayed(), "Invalid login credentials warning not displayed.");
        Thread.sleep(2000);
    }

    @AfterTest
    private void tearDown() {
        driver.quit();
        log.info("Driver quit successfully!");
        sa.assertAll();
    }
}
