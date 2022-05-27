package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99FlightPage extends BasePage{

    public Guru99FlightPage(WebDriver driver) {
        super(driver);
    }

    //Declare objects
    WebElement lblMessage = keyword.findElementByXpath("//table[@width='492']/tbody/tr[3]/td/font");
    WebElement rdoRoundTrip = keyword.findElementByXpath("//input[@value='roundtrip']");
    WebElement rdoOneWay = keyword.findElementByXpath("//input[@type='radio' and @value='oneway']");
    WebElement ddlPassenger = keyword.findElementByXpath("//select[@name='passCount']");
    WebElement ddlDepartingFrom = keyword.findElementByXpath("//select[@name='fromPort']");
    WebElement ddlMonth = keyword.findElementByXpath("//select[@name='fromMonth']");
    WebElement ddlDay = keyword.findElementByXpath("//select[@name='fromDay']");
    WebElement ddlArrivingIn = keyword.findElementByXpath("//select[@name='toPort']");
    WebElement ddlMonthReturn = keyword.findElementByXpath("//select[@name='toMonth']");
    WebElement ddlDayReturn = keyword.findElementByXpath("//select[@name='toDay']");
    WebElement rdoEconomy = keyword.findElementByXpath("//input[@value='Coach']");
    WebElement rdoBusiness = keyword.findElementByXpath("//input[@value='Business']");
    WebElement rdoFirst = keyword.findElementByXpath("//input[@value='First']");
    WebElement ddlAirline = keyword.findElementByXpath("//select[@name='airline']");
    WebElement btnContinue = keyword.findElementByXpath("//input[@name='findFlights']");
    
    //Actions Flight page
    public boolean isFlightPageCorrect(){
        if(isFlightPageTitleCorrect() == true && isFlightMessageCorrect() == true && isButtonContinueEnabled() == true){
            return true;
        }
        return false;
    }

    /**
     * check Flight page title is correct
     * @return true or false
     */
    public boolean isFlightPageTitleCorrect(){
        return pageTitle().equals(expectedFlightPageTitle);
    }

    /**
     * check message in flight page is correct
     * @return true or fasle
     */
    public boolean isFlightMessageCorrect(){
        return lblMessage.getText().equals(expectedFlightMessage);
    }

    /**
     * check button Continue is enable
     * @return truw or false
     */
    public boolean isButtonContinueEnabled(){
        return btnContinue.isEnabled();
    }

    /**
     * Function select value for Flight Detail module
     * @param type Flight type (round trip or one way)
     * @param passenger number of passenger
     * @param departingFrom
     * @param onMonth
     * @param onDay
     * @param arrivingIn
     * @param returningMonth
     * @param returningDay
     */
    public void moduleFlightDetail(String type, String passenger, String departingFrom, String onMonth, String onDay, String arrivingIn, String returningMonth, String returningDay){

        if(type == "roundtrip"){
            keyword.click(rdoRoundTrip);
        }else{
            keyword.click(rdoOneWay);
        }

        keyword.selectByValue(ddlPassenger, passenger);
        keyword.selectByValue(ddlDepartingFrom, departingFrom);
        keyword.selectByValue(ddlMonth, onMonth);
        keyword.selectByValue(ddlDay, onDay);
        keyword.selectByValue(ddlArrivingIn, arrivingIn);
        keyword.selectByValue(ddlMonthReturn, returningMonth);
        keyword.selectByValue(ddlDayReturn, returningDay);
    }

    /**
     * Function select value for Preferences module
     * @param serviceClass Business or Coach or First
     * @param airline
     */
    public void modulePreferences(String serviceClass, String airline){
        if(serviceClass == "Business"){
            keyword.click(rdoBusiness);
        }else if(serviceClass == "First"){
            keyword.click(rdoFirst);
        }else if(serviceClass == "Coach"){
            keyword.click(rdoEconomy);
        }
        keyword.selectByVisibleText(ddlAirline, airline);
    }
        
    /**
     * Function to click on Continue button
     */
    public void clkButtonContinue(){
        keyword.scrollToElement(btnContinue);
        keyword.click(btnContinue);
    }

    public String expectedFlightPageTitle = "Find a Flight: Mercury Tours:";
    public String expectedFlightMessage = "Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.";

}
