package com.cydeo.tests.day3_locators_sccSelector;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute_cssSelector {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        WebElement logInBtn  = driver.findElement(By.cssSelector("input.login-btn")); //- by class attribute
                                                                               // "input[class='login-btn']"
                          // = driver.findElement(By.cssSelector("input[value='Log In']")); - by value attribute
                          // = driver.findElement(By.cssSelector("input[value='Log In']")); - by value attribute

        String expectedLoginBtnText = "Log In";
        String actualLoginBtnText = logInBtn.getAttribute("value");

        if(actualLoginBtnText.equals(expectedLoginBtnText)){
            System.out.println("Login button text verification PASSED");
        }else{
            System.out.println("Login button text verification FAILED");
        }

driver.quit();






    }
}
