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

public class IframePractice {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void setUp(){

        // 1. Set up browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void iframeTest(){


//        3. Go to: https://practice.cydeo.com/iframe

       // driver.switchTo().frame(0); // by index
       // driver.switchTo().frame("mce_0_ifr"); // by id
        driver. switchTo().frame(driver.findElement((By.xpath("//iframe[@id='mce_0_ifr']"))));



//        4. Assert: “Your content goes here.” Text is displayed.
        WebElement textArea = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(textArea.isDisplayed());


        driver.switchTo().parentFrame();  // OR:
        // driver.switchTo().defaultContent();


//        5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        WebElement headerText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(headerText.isDisplayed());

    }
}


