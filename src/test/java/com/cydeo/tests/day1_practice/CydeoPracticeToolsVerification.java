package com.cydeo.tests.day1_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoPracticeToolsVerification {
    public static void main(String[] args) {

        /*
        TC #1: Cydeo practice tool verifications
        1. Open Chrome browser
        2. Go to
        https://practice.cydeo.com
        3. Verify URL contains
        Expected: cydeo
        4. Verify title:
        Expected: Practice
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        if (driver.getCurrentUrl().contains("cydeo")){
            System.out.println("Verification URL contains \"cydeo\" PASSED");
        }else{
            System.out.println("Verification URL contains \"cydeo\" FAILED");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Verification of title is PASSED");
        }else{
            System.out.println("Verification of title is PASSED");
        }

        driver.quit();



















    }
}
