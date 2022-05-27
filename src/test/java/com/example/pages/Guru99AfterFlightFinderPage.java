package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99AfterFlightFinderPage extends BasePage{

    public Guru99AfterFlightFinderPage(WebDriver driver) {
        super(driver);
    }

    //Declare object
    public WebElement lblMessageBackToHome = keyword.findElementByXpath("//p/font/b/font[@size = 4]");

    //Actions
    /**
     * check message on Flight finder page is correct
     * @return
     */
    public boolean isMesssageCorrect(){
        return keyword.getText(lblMessageBackToHome).equals(expectedMessage);
    }

    public String expectedMessage = "After flight finder - No Seats Avaialble  ";
}
