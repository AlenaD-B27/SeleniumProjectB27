package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Set up browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void windowsTask(){
    /*
    1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
     */

        driver.get("https://practice.cydeo.com/windows");

//        4. Assert: Title is “Windows”

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

//        5. Click to: “Click Here” link

        WebElement clcHereBtn = driver.findElement(By.linkText("Click Here"));
        clcHereBtn.click();

        actualTitle = driver.getTitle();
        System.out.println("After opening new window: " + actualTitle);
//        6. Switch to new Window.

        for (String eachWindow : driver.getWindowHandles()) { //getWindowHandles() stores all open windows
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }
//        7. Assert: Title is “New Window”

        actualTitle = driver.getTitle();
        expectedTitle = "New Window";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
