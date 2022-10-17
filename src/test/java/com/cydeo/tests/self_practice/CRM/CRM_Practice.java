package com.cydeo.tests.self_practice.CRM;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CRM_Practice {


    Faker faker = new Faker();

    @Test
    public void test_successful_login() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        CRM_Utilities.login_crm(Driver.getDriver());

        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigReader.getProperty("title_after_login"));

        CRM_Utilities.logout_crm(Driver.getDriver());
    }

    @Test
    public void test_invalid_credentials_login() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        CRM_Utilities.login_crm(Driver.getDriver(), faker.internet().emailAddress(), faker.internet().password());

        Assert.assertEquals(Driver.getDriver().findElement(By.cssSelector("div.errortext")).getText(), ConfigReader.getProperty("invalid_credentials_login_error_message"));
    }

    @Test
    public void test_remember_me() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//label[.='Remember me on this computer']")).getText(), ConfigReader.getProperty("remember_me_text"));
        WebElement rememberMeBox = Driver.getDriver().findElement(By.id("USER_REMEMBER"));
        rememberMeBox.click();
        Assert.assertTrue(rememberMeBox.isSelected());
        CRM_Utilities.login_crm(Driver.getDriver());
        CRM_Utilities.verifyTitle_CRM_homepage(Driver.getDriver());
        CRM_Utilities.logout_crm(Driver.getDriver());
    }

    @Test
    public void test_logout() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        CRM_Utilities.login_crm(Driver.getDriver());
        CRM_Utilities.logout_crm(Driver.getDriver());
        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigReader.getProperty("welcome_page_title"));

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
