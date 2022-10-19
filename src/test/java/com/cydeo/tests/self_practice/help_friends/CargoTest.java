package com.cydeo.tests.self_practice.help_friends;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CargoTest {
    @Test
    public void test() {
        //go to cargurus.com and verify Buy module has 6 links - Used Cars, New Cars, Certified Cars, Dealerships Near Me, Delivery, Buying a Car During Coronavirus

        Driver.getDriver().get("https://www.cargurus.com/");
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(Driver.getDriver().findElement(By.xpath("//span[text()='Buy']"))).perform();
        BrowserUtils.sleep(1);

        List<WebElement> actualLinks = Driver.getDriver().findElements(By.xpath("//button[@id='wai_snm_cnl_buy']/following-sibling::div//a/span"));

        Assert.assertEquals(actualLinks.size(), 6);

        List<String> expectedLinkTexts = new ArrayList<>(Arrays.asList("Used Cars", "New Cars", "Certified Cars", "Dealerships Near Me", "Delivery", "Buying a Car During Coronavirus" ));

        for (int i = 0; i < actualLinks.size(); i++) {
            Assert.assertEquals(actualLinks.get(i).getText(), expectedLinkTexts.get(i));
        }
    }
}
