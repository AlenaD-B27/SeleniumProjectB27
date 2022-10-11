package com.cydeo.tests.day7_practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice {

    /*
TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332

TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page

TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testNumOfLinks() {

//        TC #1: Checking the number of links on the page
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
        driver.get("https://www.openxcell.com");
//        3. Count the number of the links on the page and verify
        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
//        Expected: 332
        int expectedNumOfLinks = 354;
        int actualNumOfLinks = links.size();

        Assert.assertTrue(expectedNumOfLinks == actualNumOfLinks);
//        TC #2: Printing out the texts of the links on the page
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
//        3. Print out all of the texts of the links on the page
        for (WebElement eachLink : links){
            System.out.println(eachLink.getText());
        }
//        TC #3: Counting the number of links that does not have text
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
//        3. Count the number of links that does not have text and verify
//        Expected: 109
        int expectedNoTextLinks = 259; //259
        List <WebElement> empties = new ArrayList<>();
        for (WebElement eachLink : links){
            if(eachLink.getText().isEmpty()){
                empties.add(eachLink);
            }
        }
        int actualNoTextLinks = empties.size();

        Assert.assertEquals(actualNoTextLinks, expectedNoTextLinks);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
