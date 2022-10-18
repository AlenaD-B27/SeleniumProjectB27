package com.cydeo.tests.day12_actions_javascriptExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Circle_DragAndDrop {
    @Test
    public void test_drag_and_drop() {

//            1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

//            2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        // accept cookies

        WebElement acceptCookies = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(3);
        actions.dragAndDrop(smallCircle, bigCircle).perform();
/*
        actions.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(2000)
                .release()
                .perform();

 */

//            3. Assert:
//    Text in big circle changed to: “You did great!”

        String actualText = bigCircle.getText();
        String expectedText = "You did great!";

        Assert.assertEquals(actualText, expectedText);

        Driver.closeDriver();


    }
}
