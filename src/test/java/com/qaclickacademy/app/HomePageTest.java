package com.qaclickacademy.app;

import base.Base;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import java.io.IOException;

public class HomePageTest extends Base {
    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void navBarTest() {
        LandingPage lp = new LandingPage(driver);

        sa.assertTrue(lp.getnavBar().isDisplayed());
        log.info("Nav Bar is displayed");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        sa.assertAll();
    }

}
