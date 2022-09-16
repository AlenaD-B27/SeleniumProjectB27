package com.cydeo.tests.day2_locators_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryAppLogin {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Open Chrome browser
        2. Go to https://library2.cydeo.com/login.html
        3. Enter username: “incorrect@email.com”
        4. Enter password: “incorrect password”
        5. Verify: visually “Sorry, Wrong Email or Password”
        displayed
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://library2.cydeo.com/login.html");

        // 1. Locating the email address bar by id:
        WebElement userNameInput = driver.findElement(By.id("inputEmail"));

        // 2. Input email:
        userNameInput.sendKeys("incorrect@email.com");

        // 3. Locate the password bar by id:
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));

        // 4. Input password:
        passwordInput.sendKeys("incorrect password");

        // 5. Locate the Sign in button by tag name (because it is the only button on this web page):
        WebElement signinBtn = driver.findElement(By.tagName("button"));

        // 6. Click Sign In button:
        signinBtn.click();

        // RUN THE TEST HERE TO MAKE THE ALERT TO APPEAR ON THE WEB PAGE

        //============================================================================

        // 7. Verify the requirement: "VISUALLY “Sorry, Wrong Email or Password" displayed.

        Thread.sleep(3000);
        driver.quit();












    }
}
