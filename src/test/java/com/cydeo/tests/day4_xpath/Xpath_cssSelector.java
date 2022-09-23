package com.cydeo.tests.day4_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_cssSelector {
    public static void main(String[] args) {

        /*
        1. Open Chrome browser
2. Go to  https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");

        // Locate “Home” link:
        // using sccSelector with class attribute:
        WebElement homeLink1 = driver.findElement(By.cssSelector(".nav-link"));
        // using sccSelector with class attribute:
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        // using xpath with class attribute:
        WebElement homeLink3 = driver.findElement(By.xpath("//a[@href='/']"));

        // Locate “Forgot password” header:
        // using sccSelector with class attribute:
        WebElement forgotPass1 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        // using sccSelector with class attribute:
        WebElement forgotPass2 = driver.findElement(By.cssSelector("div.example>h2"));
        // using xpath with class attribute:
        WebElement forgotPass3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        // Locate “E-mail” text:             // <label for="email">E-mail</label>
        // using xpath with text:
        WebElement emailText1 = driver.findElement(By.xpath("//label[.='E-mail']"));
        // using xpath using contains:
        WebElement emailText2 = driver.findElement(By.xpath("//label[contains(@for,'email')]"));


        // Locate E-mail input box:
        // <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">

        WebElement emailInput = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));

        // Locate “Retrieve password” button:

        WebElement retrievePassButton = driver.findElement(By.xpath("//button[@id='form_submit']/i"));

        // Locate “Powered by Cydeo" text

        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        // Verify all web elements are displayed.

        // element.isDisplayed() method returns boolean
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("forgotPass1.isDisplayed() = " + forgotPass1.isDisplayed());
        System.out.println("emailText1.isDisplayed() = " + emailText1.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("retrievePassButton.isDisplayed() = " + retrievePassButton.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        driver.quit();


    }
}
