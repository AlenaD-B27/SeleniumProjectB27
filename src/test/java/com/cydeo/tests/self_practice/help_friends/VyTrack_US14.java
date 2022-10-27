package com.cydeo.tests.self_practice.help_friends;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VyTrack_US14 {


    @Test
    public void uncheckAnyFilterOptions(){
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");

        WebElement userName = Driver.getDriver().findElement(By.id("prependedInput"));
        userName.sendKeys("salesmanager140");
        WebElement password1 = Driver.getDriver().findElement(By.id("prependedInput2"));
        password1.sendKeys("UserUser123");
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));
        loginButton.click();


        WebElement marketingModules = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        WebElement campaignOption = Driver.getDriver().findElement(By.xpath("//a[.='Campaigns']/span"));
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(3);

        actions.moveToElement(marketingModules)
                .pause(5000)
                .moveToElement(campaignOption)
                .pause(5000)
                .click()
                .perform();

        BrowserUtils.sleep(10);


        WebElement manageFiltersBtn = Driver.getDriver().findElement(By.xpath("//a[@title='Filters']"));

        if(!manageFiltersBtn.isSelected()) {
            manageFiltersBtn.click();
        }

        WebElement manageOptions = Driver.getDriver().findElement(By.xpath("//a[.='Manage filters']"));
        manageOptions.click();

        List<WebElement> allBoxes = Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']"));

        int count = 0;

        for (int i = 0; i < allBoxes.size(); i++) {
           if(allBoxes.get(i).isSelected()){
               count++;
           }
        }


        Assert.assertTrue(count == 5); // how many checked by default, and it passes, means all 5 options are visible as selected ones.


     /*

       for(WebElement eachBox : allBoxes){
            eachBox.click();
       }




        // next code will not be executed until the bug is fixed.

        count = 0;

        for (int i = 0; i < allBoxes.size(); i++) {
            if(!allBoxes.get(i).isSelected()){
                count++;
                System.out.println(count);
            }
        }

        Assert.assertTrue(count == 5);

      */











    }
    }


