package com.cydeo.tests.day2_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {
    /*
    TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement header = driver.findElement(By.tagName("h3"));

        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = header.getText();

        if(expectedHeaderText.equals(actualHeaderText)){
            System.out.println("Verification header text test PASSED");
        }else{
            System.out.println("Verification header text test FAILED");
        }

        driver.quit();














    }
}
