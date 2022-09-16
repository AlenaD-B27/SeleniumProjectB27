package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {


        // 1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        // 2- Create an instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // 3- Test if the driver is working
        driver.get("https://www.google.com");
    }
}
