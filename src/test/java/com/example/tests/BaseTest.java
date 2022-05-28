package com.example.tests;

import java.util.concurrent.TimeUnit;

import com.example.core.configuration.ConfigurationReader;
import com.example.core.configuration.driver.DriverFactory;
import com.example.core.keywords.WebKeyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;
    public WebKeyword keyword;
    public static WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }

    @BeforeMethod
    public void setUp() throws Exception{
        this.driver = DriverFactory.getDriver(ConfigurationReader.getDriverFromPropertiesFile("browser"));
        keyword = new WebKeyword(driver);
        keyword.openUrl(ConfigurationReader.getDriverFromPropertiesFile("url"));
        driver.manage().timeouts().implicitlyWait(ConfigurationReader.getTimeoutFromPropertiesFile("implicitlyWait"), TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}