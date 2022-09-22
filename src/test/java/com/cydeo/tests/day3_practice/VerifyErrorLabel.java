package com.cydeo.tests.day3_practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyErrorLabel {
    public static void main(String[] args) {

        /*
        1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found




PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement loginBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        loginBox.sendKeys("incorrect");

        WebElement resetPswdBtn = driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetPswdBtn.click();

        WebElement errorLbl = driver.findElement(By.cssSelector("div.errortext"));

        String expectedErrorLblText = "Login or E-mail not found";
        String actualErrorLblText = errorLbl.getText();

        if(actualErrorLblText.equals(expectedErrorLblText)){
            System.out.println("Error label text verification PASSED");
        } else {
            System.out.println("Error label text verification FAILED");
        }

        driver.quit();

















    }
}
