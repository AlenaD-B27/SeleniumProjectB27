package com.cydeo.tests.CRM;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CRM_Practice {

    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();

    @Test
    public void test_successful_login() {
        driver.get(ConfigReader.getProperty("env"));
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigReader.getProperty("user_name"));

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigReader.getProperty("password"));

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        BrowserUtils.verifyTitle(driver, ConfigReader.getProperty("title_after_login"));
    }

    @Test
    public void test_invalid_credentials_login() {
        driver.get(ConfigReader.getProperty("env"));
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(faker.superhero().name() + '@' + faker.university().name() + ".com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(faker.random().hex());

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.errortext")).getText(), ConfigReader.getProperty("invalid_credentials_login_error_message"));
    }

    @Test
    public void test_remember_me() {
        driver.get(ConfigReader.getProperty("env"));
        Assert.assertEquals(driver.findElement(By.xpath("//label[.='Remember me on this computer']")).getText(), ConfigReader.getProperty("remember_me_text"));
        WebElement rememberMeBox = driver.findElement(By.id("USER_REMEMBER"));
        rememberMeBox.click();
        Assert.assertTrue(rememberMeBox.isSelected());
        CRM_Utilities.login_crm(driver);
        CRM_Utilities.verifyTitle_CRM_homepage(driver);
    }

    @AfterClass

    public void tearDown() {
        driver.quit();
    }
}
