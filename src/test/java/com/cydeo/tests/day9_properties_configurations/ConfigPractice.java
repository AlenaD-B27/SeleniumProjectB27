package com.cydeo.tests.day9_properties_configurations;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigPractice extends TestBase {
    @Test
    public void testName() {
//        2- Go to: https://google.com
        driver.get(ConfigReader.getProperty("google.url"));

//        3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(ConfigReader.getProperty("search.keyword") + Keys.ENTER);

//        4- Verify title:
//        Expected: apple - Google Search
        String actualTitle = driver.getTitle();
        String expectedTitle = ConfigReader.getProperty("search.keyword") + " - Google Search";

        Assert.assertEquals(actualTitle, expectedTitle);
    }



}
