package com.cydeo.tests.day3_locators_sccSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetText_sccSelector {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
     */
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button.login-btn"));
        String expectedResetPasswordBtnText = "Reset password";
        String actualResetPasswordBtnText = resetPasswordBtn.getText();

        if(actualResetPasswordBtnText.equals(expectedResetPasswordBtnText)){
            System.out.println("Reset button text verification PASSED");
        } else {
            System.out.println("Reset button text verification FAILED");
        }

        driver.quit();


















    }
}
