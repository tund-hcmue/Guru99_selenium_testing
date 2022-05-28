package com.example.tests;

import com.example.core.datadriven.DataForTest;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.Guru99AfterFlightFinderPage;
import com.example.pages.Guru99FlightPage;
import com.example.pages.Guru99HomePage;
import com.example.pages.Guru99LoginPage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class Guru99PageTest extends BaseTest{
    @Test(priority = 1, testName = "Verify User Login Successfully", dataProvider = "dataForLoginAccount", dataProviderClass = DataForTest.class)
    public void verifyUserLoginSuccessfully(String username, String password) throws InterruptedException{
        Guru99HomePage guru99HomePage = new Guru99HomePage(driver);
        guru99HomePage.actionLogin(username, password);
        Guru99LoginPage guru99LoginPage = new Guru99LoginPage(driver);
        Assert.assertTrue(guru99LoginPage.isLoginPageCorrect(), "Login page is not correct.");       
    }

    @Test(priority = 2, testName = "Verify Flight Page Is Default In The First Time When User Navigate To Flight Menu", dataProvider = "dataForFlightFinder", dataProviderClass = DataForTest.class)
    public void verifyFlightPageIsDefaultInTheFirstTimeWhenUserNavigateToFlightMenu(
            String username, String password, String type, String passenger, String departingFrom, String onMonth, 
            String onDay, String arrivingIn, String returningMonth, String returningDay, String serviceClass, String airline) throws InterruptedException{

        Guru99HomePage guru99HomePage = new Guru99HomePage(driver);
        guru99HomePage.actionLogin(username, password);
        
        Guru99LoginPage guru99LoginPage = new Guru99LoginPage(driver);               
        guru99LoginPage.clkFlight();
        
        Guru99FlightPage guru99FlightPage = new Guru99FlightPage(driver);
        Assert.assertTrue(guru99FlightPage.isFlightPageCorrect(), "Flight page is not correct.");
        guru99FlightPage.moduleFlightDetail(type, passenger, departingFrom, onMonth, onDay, arrivingIn, returningMonth, returningDay);
        guru99FlightPage.modulePreferences(serviceClass, airline);        
        guru99FlightPage.clkButtonContinue();
        
    }

    @Test(priority = 3, testName = "Verify Message After Click Continue Is Correct", dataProvider = "dataForLoginAccount", dataProviderClass = DataForTest.class)
    public void verifyMessageIsCorrect(String userName, String passWord){
        Guru99HomePage guru99HomePage = new Guru99HomePage(driver);
        guru99HomePage.actionLogin(userName, passWord);

        Guru99LoginPage guru99LoginPage = new Guru99LoginPage(driver);
        guru99LoginPage.clkFlight();

        Guru99FlightPage guru99FlightPage = new Guru99FlightPage(driver);
        guru99FlightPage.clkButtonContinue();
        
        Guru99AfterFlightFinderPage guru99AfterFlightFinderPage = new Guru99AfterFlightFinderPage(driver);
        Assert.assertTrue(guru99AfterFlightFinderPage.isMesssageCorrect(), "Message in flight finder page is not correct.");
    }
}
