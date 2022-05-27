package com.example.core.configuration.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver getDriver(String browser) throws Exception{
        switch (browser) {
            case "CHROME":
                return new Chrome().createDriver();
            case "FF":
                return new FireFox().createDriver();
            // case "edge":
            //     WebDriverManager.edgedriver().setup();
            //     return new EdgeDriver();        
            default:
                throw new Exception("Driver is not found");
                // System.out.println("Browser" + browser + "is invalid. Use chrome instead.");
                // WebDriverManager.chromedriver().setup();
                // return new ChromeDriver();
        }
    }
    
}
