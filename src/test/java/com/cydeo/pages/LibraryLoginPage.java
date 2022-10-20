package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    public LibraryLoginPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement inputPassword;

    @FindBy (xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy (css = "div.has-error")
    public WebElement fieldRequiredErrorMsg;

    @FindBy (xpath = "//div[@class='alert alert-danger']")
    public WebElement enterInvalidEmailErrorMsg;

    @FindBy (xpath="//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailAndPasswordErrorMsg;



}
