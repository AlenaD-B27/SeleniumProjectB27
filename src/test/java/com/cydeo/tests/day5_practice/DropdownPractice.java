package com.cydeo.tests.day5_practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DropdownPractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void stateDropdown() throws InterruptedException {
        /*
    Selecting state from State dropdown and verifying
result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");
        Thread.sleep(1000);

        // List of xpath indexes:

        Map<String, Integer> states = new HashMap<>();
        for (int i = 0; i < stateDropdown.getOptions().size(); i++){
            stateDropdown.selectByIndex(i);
            states.put(stateDropdown.getFirstSelectedOption().getText(), i);
        }
        // California index? ==> states.get("California");
        stateDropdown.selectByIndex(states.get("California")); // => 5
        Thread.sleep(1000);

        String expectedSelectedOption = "California";
        String actualSelectedOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);
    }

    @Test
    public void selectDate(){
        /*
        Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number
         */
        driver.get("https://practice.cydeo.com/dropdown");
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1923");
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);

        String expectedMonth = "December";
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth, expectedMonth);

        String expectedDay = "1";
        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay, expectedDay);

        String expectedYear = "1923";
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear, expectedYear);

    }

    @Test
    public void nonSelectDropdown() throws InterruptedException {
        /*
        Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
         */
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdown = driver.findElement(By.linkText("Dropdown link"));
        dropdown.click();
        Thread.sleep(2000);
        WebElement fbOption = driver.findElement(By.linkText("Facebook"));
        fbOption.click();
        Thread.sleep(2000);

        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    @Test
    public void multipleSelectDropdown() throws InterruptedException {
        /*
        Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
         */
        driver.get("https://practice.cydeo.com/dropdown");
        Select dropdownMenu = new Select(driver.findElement(By.xpath("//*[@name='Languages']")));
        for (int i = 0; i < dropdownMenu.getOptions().size(); i++){
            dropdownMenu.selectByIndex(i);
        }

        List<WebElement> allSelectedOptions = (dropdownMenu.getAllSelectedOptions());
        for(WebElement eachElement : allSelectedOptions){
            System.out.println(eachElement.getText());
        }



        // extra
        for (int i = 0; i < dropdownMenu.getOptions().size(); i++){
            Assert.assertFalse(dropdownMenu.getOptions().size() == 0);
        }

        dropdownMenu.deselectAll();

        // extra
        for (int i = 0; i < dropdownMenu.getOptions().size(); i++){
            Assert.assertTrue(dropdownMenu.getAllSelectedOptions().size() == 0);
        }

    }







}
