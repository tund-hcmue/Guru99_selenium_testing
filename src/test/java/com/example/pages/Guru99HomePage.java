package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99HomePage extends BasePage{

    public Guru99HomePage(WebDriver driver) {
        super(driver);
    }

    //Declare objects
    public WebElement txtUserName = keyword.findElementByXpath("//input[@type='text' and @name = 'userName']");
    public WebElement txtPassword = keyword.findElementByXpath("//input[@type='password' and @name = 'password']");
    public WebElement btnSubmit = keyword.findElementByXpath("//input[@type='submit' and @name = 'submit']");
    public String homePageTitle = pageTitle();

    //Actions
    /**
     * Function to login account
     * @param userName username
     * @param passWord password
     */
    public void actionLogin(String userName, String passWord) {
        keyword.setText(txtUserName, userName);
        keyword.setText(txtPassword, passWord);
        keyword.click(btnSubmit);
    }
    
}
