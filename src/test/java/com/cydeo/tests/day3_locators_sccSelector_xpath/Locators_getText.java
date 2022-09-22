package com.cydeo.tests.day3_locators_sccSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators_getText {
    /*
    1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
     */
    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://login1.nextbasecrm.com/");
        driver.manage().window().maximize();

       // driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        WebElement inputUserName = driver.findElement(By.name("USER_LOGIN"));
        inputUserName.sendKeys("incorrect");

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        //================================================================

        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification test PASSED");
        }else{
            System.out.println("Error message verification test FAILED");
        }


        driver.quit();













    }
}
