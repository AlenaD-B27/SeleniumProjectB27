package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BrowserUtils {
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }

    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait  =new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForInvisibilityOf(WebElement element, int seconds){
        WebDriverWait wait  =new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }





}
