package com.cydeo.tests.day11_upload_actions_javascriptExecutor;

import com.cydeo.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll_JavaScriptExecutor {
    @Test
    public void scroll_js_executor_test() {
//        1- Open a chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://practice.cydeo.com/infinite_scroll

        driver.get("https://practice.cydeo.com/infinite_scroll");

//        3- Use below JavaScript method and scroll
        // window.scrollBy(x,y) ---> like in coordinate system
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0,750)");


//           a. 750 pixels down 10 times.
        for(int i=0; i<10; i++){
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
//           b. 750 pixels up 10 times
        for(int i=0; i<10; i++){
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }
        driver.quit();
    }
}
