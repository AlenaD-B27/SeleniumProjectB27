package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetSpeedPage {
     public InternetSpeedPage(){
         PageFactory.initElements(Driver.getDriver(), this);
     }

     @FindBy (xpath = "//a[normalize-space()='Results']")
    public WebElement resultLink;

     @FindBy (xpath = "//span[.='Go']")
    public WebElement goButton;

     @FindBy (css = "canvas.gauge-speed-text")
    public WebElement gaugeSpeedNeedle;

     @FindBy (css = "span.result-data-large.number.result-data-value.download-speed")
    public WebElement downloadSpeed;

     @FindBy (css = "span.result-data-large.number.result-data-value.upload-speed")
    public WebElement uploadSpeed;


}
