package com.cydeo.tests.day4_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.id("box1"));

        WebElement checkbox2 = driver.findElement(By.id("box2"));

        // Confirm checkbox #1 is NOT selected by default

        System.out.println("checkbox1.isSelected(), expected false " + checkbox1.isSelected());

        // Confirm checkbox #2 is SELECTED by default.

        System.out.println("checkbox2.isSelected(), expected true " + checkbox2.isSelected());

//        Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkbox1.click();


//        Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkbox2.click();
        Thread.sleep(2000);


//        Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected(), expected true " + checkbox1.isSelected());


//        Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected(), expected false " + checkbox2.isSelected());

        driver.quit();










    }
}
