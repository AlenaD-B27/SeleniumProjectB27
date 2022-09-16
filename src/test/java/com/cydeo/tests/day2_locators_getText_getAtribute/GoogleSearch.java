package com.cydeo.tests.day2_locators_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) {

        /*
        1- Open a chrome browser
        2- Go to: https://google.com/
        3- Write “apple” in search box
        4- Click google search button
        5- Verify title:
        Expected: Title should start with “apple” word
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        // 1. Locating search box:
        WebElement searchBox  = driver.findElement(By.name("q"));

        // 2. Typing in a search box and pressing Enter:
        searchBox.sendKeys("apple" + Keys.ENTER);

        // 3. Title verification:
        String expectedInTitle = "apple";
        String actualInTitle = driver.getTitle();

        if(actualInTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification test PASSED");
        } else {
            System.out.println("Title verification test FAILED");
        }

        driver.quit();























    }











}
