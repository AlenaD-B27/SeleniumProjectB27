package com.cydeo.tests.day9_properties_configurations;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CRM_Login extends TestBase {

    @Test
    public void crm_login_test() {

//        2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

//        3. Enter valid username  // hr2@cydeo.com
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr2@cydeo.com");

//        4. Enter valid password  // UserUser
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

//        5. Click to Log In button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

//        6. Verify title is as expected:
//        Expected: Portal
        BrowserUtils.verifyTitle(driver,"Portal");


    }


    @Test
    public void crm_login_test2() {
        driver.get("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);
    }

    @Test
    public void crm_login_test3() {
        driver.get("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver, "hr3@cydeo.com", "UserUser" );
    }
}
