package com.example.core.configuration.driver;

import java.io.File;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFox {
    private FirefoxOptions options;
    private DesiredCapabilities capabilities;

    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(getOptions().merge(getCapabilities()));
    }

    private FirefoxOptions getOptions() {
        if (options == null) {
            options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            profile.addExtension(new File("src/test/java/com/example/core/configuration/browser/adblock_plus-3.13_firefox.xpi"));
            options.setProfile(profile);
            options.addArguments("--start-maximized");
            options.setAcceptInsecureCerts(true);
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        }
        return options;
    }

    private DesiredCapabilities getCapabilities() {
        if (capabilities == null)
            capabilities = DesiredCapabilities.firefox();
        return capabilities;
    }

    public void setDriverOptions(Object options) {
        this.options = (FirefoxOptions) options;
    }

    public void setCapabilities(Object capabilities) {
        this.capabilities = (DesiredCapabilities) capabilities;
    }
}
