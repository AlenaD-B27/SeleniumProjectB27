package com.cydeo.tests.day11_upload_actions_javascriptExecutor;

import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JavaFaker_Practice {
    @Test
    public void registration_form() {


//        1. Open browser
//        2. Go to website: https://practice.cydeo.com/registration_form

        Driver.getDriver().get(ConfigReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

//        3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());


//        4. Enter last name --> HW
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

//        5. Enter username
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(faker.name().username().replace(".", ""));


//        6. Enter email address : email.sendKeys(faker.internet().emailAddress());
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());


//        7. Enter password : faker.internet().password();
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());


//        8. Enter phone number
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));


//        9. Select a gender from radio buttons
        List<WebElement> genders = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));

            genders.get(faker.number().numberBetween(0, 2)).click();

//        10. Enter date of birth
        WebElement dob = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dob.sendKeys(faker.number().numberBetween(1, 12) + "/" + faker.number().numberBetween(1, 28) + "/" + faker.number().numberBetween(1940, 2022));


//        11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));



//        12. Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(faker.number().numberBetween(1, 8));


//        13. Select programming language from checkboxes
        List<WebElement> languages = Driver.getDriver().findElements(By.cssSelector("input.form-check-input"));
        languages.get(faker.number().numberBetween(0, 2)).click();


//        14. Click to sign up button
        WebElement signinBtn = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signinBtn.click();


//        15. Verify success message “You've successfully completed registration!” is
//        displayed.
        WebElement successText = Driver.getDriver().findElement(By.tagName("p"));
        Assert.assertTrue(successText.isDisplayed(), ConfigReader.getProperty("successful.registration.text"));


        Driver.closeDriver();


    }
}
