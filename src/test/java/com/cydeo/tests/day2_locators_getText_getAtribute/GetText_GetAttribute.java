package com.cydeo.tests.day2_locators_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText_GetAttribute {
    public static void main(String[] args) {

        /*
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/registration_form
        3- Verify header text is as expected:
        Expected: Registration form
        4- Locate “First name” input box
        5- Verify placeholder attribute’s value is as expected:
        Expected: first name
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");

        // Locating the header:
        WebElement headerText = driver.findElement(By.tagName("h2"));

        // Verification of the header text:
        String expectedHeaderText = "Registration form";
        String actualHeaderText = headerText.getText();

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification test PASSED");
        }else{
            System.out.println("Header text verification test FAILED");
        }

        // Verification of the name input attribute:

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        if(actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder text verification PASSED");
        }else{
            System.out.println("Placeholder text verification FAILED");
        }

        driver.quit();








    }
}
