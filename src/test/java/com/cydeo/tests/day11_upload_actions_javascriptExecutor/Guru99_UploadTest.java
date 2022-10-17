package com.cydeo.tests.day11_upload_actions_javascriptExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99_UploadTest {
    @Test
    public void guru99_upload_test() {
//        1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get("https://demo.guru99.com/test/upload");

//        2. Upload file into Choose File
        Driver.getDriver().findElement(By.id("uploadfile_0")).sendKeys("/Users/alena/Downloads/some-file.txt");

//        3. Click terms of service check box
        Driver.getDriver().findElement(By.id("terms")).click();

//        4. Click Submit File button
        Driver.getDriver().findElement(By.id("submitbutton")).click();

//        5. Verify expected message appeared.
//        Expected: “1 file has been successfully uploaded.”
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//h3/center")).getText(), "1 file\nhas been successfully uploaded.");


        Driver.getDriver().quit();




    }
}
