package com.cydeo.tests.self_practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrack_US9 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");


    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void TC_001() throws InterruptedException {

        // 1. User logs in with valid credentials.

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));

        usernameBox.sendKeys("user166");
        Thread.sleep(3000);
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        passwordBox.sendKeys(Keys.ENTER);

        //


    }



}
