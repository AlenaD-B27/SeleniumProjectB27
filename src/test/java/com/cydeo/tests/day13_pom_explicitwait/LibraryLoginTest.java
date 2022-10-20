package com.cydeo.tests.day13_pom_explicitwait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryLoginTest {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://library1.cydeo.com/");
    }



    @Test
    public void required_field_error_message_test(){

//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com/

        Driver.getDriver().get("https://library1.cydeo.com/");


//3- Do not enter any information
//4- Click to “Sign in” button

        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.signInBtn.click();


//5- Verify expected error is displayed:
//   Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMsg.isDisplayed());
    }


    @Test
    public void invalid_email_format_error_message_text(){
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com/
//        3- Enter invalid email format


        libraryLoginPage.inputUsername.sendKeys(faker.name().username());
        libraryLoginPage.signInBtn.click();


//        4- Verify expected error is displayed:
//        Expected: Please enter a valid email address.

        Assert.assertTrue(libraryLoginPage.enterInvalidEmailErrorMsg.isDisplayed());


    }





}
