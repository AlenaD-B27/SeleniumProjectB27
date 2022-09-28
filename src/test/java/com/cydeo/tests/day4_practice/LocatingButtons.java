package com.cydeo.tests.day4_practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LocatingButtons {
    public static void main(String[] args) {

//        XPATH Practice
//        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
//        TC #6:  XPATH LOCATOR practice
//        1. Open Chrome browser
//        2. Go to http://practice.cydeo.com/multiple_buttons
//        3. Click on Button 1
//        4. Verify text displayed is as expected:
//        Expected: “Clicked on button one!”
//
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


        //        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();



        //        2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");


        //        3. Click on Button 1
        WebElement b1 = driver.findElement(By.xpath("//button[.='Button 1']"));
        b1.click();


        //        4. Verify text displayed is as expected:
        //        Expected: “Clicked on button one!”

        String expectedTextDisplayed = "Clicked on button one!";
        WebElement textDisplayed = driver.findElement(By.xpath("//p[@style='color:green']"));
        String actualTextDisplayed = textDisplayed.getText();

        if(actualTextDisplayed.equals(expectedTextDisplayed)){
            System.out.println("Text displayed after clicking Button 1 verification test is PASSED");
        } else {
            System.out.println("Text displayed after clicking Button 1 verification test is FAILED");
        }

        //===================================================================



        //        3. Click on Button 2
        WebElement b2 = driver.findElement(By.xpath("//*[@name='button2']"));
        b2.click();


        //        4. Verify text displayed is as expected:
        //        Expected: “Clicked on button one!”

        expectedTextDisplayed = "Clicked on button two!";

        actualTextDisplayed = textDisplayed.getText();

        if(actualTextDisplayed.equals(expectedTextDisplayed)){
            System.out.println("Text displayed after clicking Button 2 verification test is PASSED");
        } else {
            System.out.println("Text displayed after clicking Button 2 verification test is FAILED");
        }


        //======================================================================















    }


}
