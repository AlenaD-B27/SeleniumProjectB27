package com.cydeo.tests.day3_locators_sccSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetText_getAttribute {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label text verification PASSED");
        } else {
            System.out.println("Remember me label text verification FAILED");
        }

        //================================================================

        WebElement forgotYourPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotYourPasswordLinkText = "Forgot your password?";
        String actualForgotYourPasswordLinkText = forgotYourPasswordLink.getText();

        if(actualForgotYourPasswordLinkText.equals(expectedForgotYourPasswordLinkText)){
            System.out.println("Forgot password link text verification PASSED");
        } else {
            System.out.println("actualForgotYourPasswordLinkText = " + actualForgotYourPasswordLinkText);
            System.out.println("expectedForgotYourPasswordLinkText = " + expectedForgotYourPasswordLinkText);
            System.out.println("Forgot password link text verification FAILED");
        }
        /*
        actualForgotYourPasswordLinkText = FORGOT YOUR PASSWORD?
        expectedForgotYourPasswordLinkText = Forgot your password?
        Forgot password link text verification FAILED
         */

        /*
        if(test == failed){
            ask developer;
        } else {
            ask your team to check if the mistake is in the requirement;
        } else {
            create bug report;
        }
         */

        String expectedInHrf = "forgot_password=yes";
        String actualInHRF = forgotYourPasswordLink.getAttribute("href");

        if(actualInHRF.contains(expectedInHrf)){
            System.out.println("Href attribute value verification PASSED");
        } else {
            System.out.println("Href attribute value verification FAILED");
        }

        driver.quit();












    }
}
