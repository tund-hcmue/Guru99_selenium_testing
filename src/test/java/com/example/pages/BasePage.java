package com.example.pages;

import com.example.core.keywords.WebKeyword;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;
    public WebKeyword keyword;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.keyword = new WebKeyword(driver);
    }

    /**
     * get title page
     * @return string title page
     */
    public String pageTitle(){
        return driver.getTitle();
    }
}
