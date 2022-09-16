package com.cydeo.tests.day2_locators_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextPractice {
    public static void main(String[] args) {

        /*
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/
        3- Click to A/B Testing from top of the list.
        4- Verify title is:
         Expected: No A/B Test
        5- Go back to home page by using the .back();
        6- Verify title equals:
        Expected: Practice
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");

        //===========================================================

       WebElement abTestLink = driver.findElement(By.linkText("A/B Testing")); // found element
       abTestLink.click(); // action => click;


        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("No A/B test title verification PASSED");
        }else{
            System.out.println("No A/B test title verification failed");
        }


        driver.navigate().back();
        expectedTitle = "Practice";
        actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Practice page title verification PASSED");
        }else{
            System.out.println("Practice page title verification PASSED");
        }

        driver.quit();
















    }
}
