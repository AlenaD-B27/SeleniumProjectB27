package com.cydeo.tests.day12_actions_javascriptExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavascriptExecutor_Scroll {
    @Test
    public void test_jsexecutor_scroll() {
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        // We have to do downcasting(typecasting) to JSExecutor interface for using methods coming from this interface
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

//        3- Scroll down to “Cydeo” link
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);


//        4- Scroll up to “Home” link
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

        Driver.closeDriver();
//        5- Use below provided JS method only
//
//        JavaScript method to use : arguments[0].scrollIntoView(true)
//
//        Note: You need to locate the links as web elements and pass them
//        as arguments into executeScript() method
    }
}
