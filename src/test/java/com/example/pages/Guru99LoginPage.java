package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99LoginPage extends BasePage{

    public Guru99LoginPage(WebDriver driver) {
        super(driver);
    }

    //Declare objects
    public WebElement lblSuccessMessage = keyword.findElementByXpath("//h3");
    WebElement lnkFlight = keyword.findElementByXpath("//a[text()='Flights']");
    WebElement lblSubMessage = keyword.findElementByXpath("//b[contains(text(),' Thank you for Loggin. ')]");
    
    //Actions
    /**
     * verify login page map to testcase
     * @return
     */
    public boolean isLoginPageCorrect(){
        if(isDisplayedSuccessMessage() == true && isSuccessMessageCorrect() == true && isDisplayedSuccessMessage() == true && isPageTitleChangedAfterUserLoginSuccess() == true){
            return true;
        }
        return false;
    }
    
    /**
     * Function to click on Flight
     */
    public void clkFlight(){
        keyword.click(lnkFlight);
    }

    /**
     * Check message login success is displayed
     * @return true or false
     */
    public boolean isDisplayedSuccessMessage(){
        return lblSuccessMessage.isDisplayed();
    }

    /**
     * check message login success is correct
     * @return true or false
     */
    public boolean isSuccessMessageCorrect(){
        return keyword.getText(lblSuccessMessage).equals(messageLoginSuccess);
    }

    /**
     * check sub message login success is correct
     * @return true or false
     */
    public boolean isSuccessSubMessageCorrect(){
        return keyword.getText(lblSubMessage).equals(subMessageLoginSuccess);
    }
    
    /**
     * check title should changed when user login success
     * @return true or false
     */
    public boolean isPageTitleChangedAfterUserLoginSuccess(){
        if(pageTitle().equals(homePageTitle)){
            return false;
        }else{
            return true;
        }
    }
    
    public String homePageTitle = "Welcome: Mercury Tours";
    public String messageLoginSuccess = "Login Successfully";
    public String subMessageLoginSuccess = "Thank you for Loggin.";
}
