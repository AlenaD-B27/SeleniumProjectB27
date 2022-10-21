package com.cydeo.tests.day14_explicitwait_review;

import com.cydeo.pages.InternetSpeedPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InternetSpeedTest {

    @Test
    public void internet_speed_test() {
        //        1- Open a chrome browser
//        2- Go to: https://www.speedtest.net
        Driver.getDriver().get("https://www.speedtest.net");

        WebDriverWait wait  =new WebDriverWait(Driver.getDriver(), 50);
        InternetSpeedPage internetSpeedPage = new InternetSpeedPage();


//        3- Wait until Results link is displayed
        wait.until(ExpectedConditions.visibilityOf(internetSpeedPage.resultLink));


//        4- Click on Go button
        internetSpeedPage.goButton.click();


//        5- Wait until gauge-speed-needle displayed
        wait.until(ExpectedConditions.visibilityOf(internetSpeedPage.gaugeSpeedNeedle));


//        6- Wait until gauge-speed-needle disappear
        wait.until(ExpectedConditions.invisibilityOf(internetSpeedPage.gaugeSpeedNeedle));


//        7- Print Download and Upload Speeds
        System.out.println("internetSpeedPage.downloadSpeed = " + internetSpeedPage.downloadSpeed.getText());
        System.out.println("internetSpeedPage.uploadSpeed = " + internetSpeedPage.uploadSpeed.getText());


    }
}
