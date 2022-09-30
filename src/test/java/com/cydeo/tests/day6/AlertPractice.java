package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Set up browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void alertTask1(){
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertBtn = driver.findElement(By.xpath("//*[@onclick = 'jsAlert()']"));
        informationAlertBtn.click();

        //4. Click to OK button from the alert
        Alert alertWindow = driver.switchTo().alert();
        alertWindow.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.

        WebElement textResult = driver.findElement(By.xpath("//p[@style = 'color:green']"));
        String actualText = textResult.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualText, expectedText);


    }
}
