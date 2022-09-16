package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tesla.com");

        //driver.navigate().to("https://www.tesla.com"); //  equals driver.get()

        driver.manage().window().maximize(); // GOOD HABIT!!!! The minimized window might hide some modules under hamburger menu for example (check etsy web site);

        Thread.sleep(3000); // need to throw exception to handle the checked exception
        driver.navigate().back(); // go to previous page
        Thread.sleep(3000);
        driver.navigate().forward(); // go to next page
        Thread.sleep(3000);
        driver.navigate().refresh();


        driver.navigate().to("https://www.google.com");
        // System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


        driver.close(); // will close the current open page
        driver.quit(); // closes ALL the open windows

     //  driver.get("https://google.com");      // will not work as after quit() method the session is over(it's called "kill the session" ). Will give you the NoSuchSessionException.


















    }

}
