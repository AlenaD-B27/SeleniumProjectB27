package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
//  Method #1 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver

   public static void login_crm(WebDriver driver){
       //        3. Enter valid username  // hr2@cydeo.com
       WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
       inputUsername.sendKeys(ConfigReader.getProperty("user_name"));

//        4. Enter valid password  // UserUser
       WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
       inputPassword.sendKeys(ConfigReader.getProperty("password"));

//        5. Click to Log In button
       WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
       loginBtn.click();

   }

//Method #2 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String username
//• Arg3: String password

    public static void login_crm(WebDriver driver, String username, String password){
        //        3. Enter valid username  // hr2@cydeo.com
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

//        4. Enter valid password  // UserUser
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

//        5. Click to Log In button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();



    }

    public static void verifyTitle_CRM_homepage(WebDriver driver){
        BrowserUtils.verifyTitle(driver, ConfigReader.getProperty("title_after_login"));
    }

}
