package com.cydeo.tests.help_friends;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Help1 {
    //    2. Create new test and make set ups
//3. Go to : https://practice.cydeo.com/windows

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }

//7. Assert: Title is “New Window”

    @Test
    public void windowsPractice() {
        //  4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Before opening new window " + actualTitle);

//      5. Click to: “Click Here” link
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();

        actualTitle = driver.getTitle();
        System.out.println("After opening new window " + actualTitle);

        //6. Switch to new Window.
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

            //7. Assert: Title is “New Window”

            actualTitle = driver.getTitle();
            String expectedTitle1 = "New Window";


            Assert.assertEquals(actualTitle, expectedTitle1);
        }
    }

