package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {


        // 1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();   // you can choose any browser here

        // 2- Create an instance of the Chrome driver
        WebDriver driver = new ChromeDriver();         // Right side constructor <= Polymorphism

        // 3- Test if the driver is working
        driver.get("https://www.google.com"); // make sure you use httpS, not http. http could give you an error if you have some security settings set up in your ChromeDriver.


        // RemoteWebDriver is the parent of all the web drivers.

    }
}
