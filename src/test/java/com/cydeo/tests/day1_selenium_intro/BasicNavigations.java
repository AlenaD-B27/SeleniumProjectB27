package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tesla.com");

        //driver.navigate().to("https://www.tesla.com"); //  equals driver.get()

        Thread.sleep(3000); // need to throw exception to handle the checked exception
        driver.navigate().back(); // go to previous page
        Thread.sleep(3000);
        driver.navigate().forward(); // go to next page
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.close(); // will close the current open page
        driver.quit(); // closes ALL the open windows


















    }

}
