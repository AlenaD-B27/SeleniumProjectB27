package com.cydeo.tests.day13_pom_explicitwait;

import com.cydeo.pages.DynamicallyLoadedPage_1;
import com.cydeo.pages.DynamicallyLoadedPage_7;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    @Test
    public void dynamically_loaded_page_elements_7() {
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");


        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));


        //3. Assert: Message “Done” is displayed.
        DynamicallyLoadedPage_7 dynamicallyLoadedPage_7 = new DynamicallyLoadedPage_7();

        Assert.assertTrue(dynamicallyLoadedPage_7.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.

        Assert.assertTrue(dynamicallyLoadedPage_7.spongeBobImg.isDisplayed());

    }

    @Test
    public void dynamically_loaded_page_elements_1_test() {
        //1. Go to https://practice.cydeo.com/dynamic_loading/1

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        //2. Click to start
        DynamicallyLoadedPage_1 dynamicallyLoadedPage_1 = new DynamicallyLoadedPage_1();

        dynamicallyLoadedPage_1.startBtn.click();


        //3. Wait until loading bar disappears

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicallyLoadedPage_1.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicallyLoadedPage_1.loadingBar, 30);


        //4. Assert username inputbox is displayed

        Assert.assertTrue(dynamicallyLoadedPage_1.inputUserName.isDisplayed());


        //5. Enter username: tomsmith

        dynamicallyLoadedPage_1.inputUserName.sendKeys("tomsmith");


        //6. Enter password: incorrectpassword

        dynamicallyLoadedPage_1.inputPassword.sendKeys("incorrectpassword");


        //7. Click to Submit button

        dynamicallyLoadedPage_1.submitBtn.click();


        //8. Assert “Your password is invalid!” text is displayed.

        Assert.assertTrue(dynamicallyLoadedPage_1.errorMsg.isDisplayed());


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
