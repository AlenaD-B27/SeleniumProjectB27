package com.cydeo.tests.day9_practice;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigReader;
import org.testng.annotations.Test;

public class CRM_Login extends TestBase {
    /*
    TC #1: Login scenario

1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to Log In button
6. Verify title is as expected:
Expected: Portal
     */

    @Test
    public void testLoginFunction() {
        driver.get(ConfigReader.getProperty("env"));
        CRM_Utilities.login_crm(driver, ConfigReader.getProperty("user_name"), ConfigReader.getProperty("password"));
        BrowserUtils.verifyTitle(driver, ConfigReader.getProperty("title_after_login"));
    }
}
