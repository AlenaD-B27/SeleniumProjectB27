package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            String browserType = ConfigReader.getProperty("browser".toLowerCase());

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
         //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }



}
