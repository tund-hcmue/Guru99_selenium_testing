package com.example.core.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

public class WebKeyword {

    private WebDriver driver;
    private WebDriverWait wait;
    private int timout = 30;

    public WebKeyword(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timout);
    }

    public enum typeOfSelect{
        selectByValue, 
        selectByVisibleText, 
        selectByIndex
    }

    /**
     * Open Url
     * @param url
     */
    public void openUrl(String url) throws Exception{
        if(!(url.startsWith("http://") || url.startsWith("https://"))){
            throw new Exception("Invalid Url Format");
        }
        driver.get(url);
    }

    /**
     * Clear text before set text
     * @param webElement element to set text
     * @param text value to set text for element
     * @return
     */
    public WebKeyword setText(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }
        return new WebKeyword(driver);
    }

    public String getText(WebElement webElement){
        return webElement.getText();
    }

    /**
     * Click to element
     * @param webElement element to click
     * @return keyword to click
     */
    public WebKeyword click(WebElement webElement){
        Actions actions = new Actions(this.driver);
        actions.moveToElement(webElement).build().perform();
        webElement.click();
        return new WebKeyword(driver);
    }

    /**
     * Wait to element visible
     * @param locator element locator
     * @return element to be located
     */
    public WebElement findElementByXpath(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * set value for Element by Select
     * @param webElement element to set value
     * @param type type of select element (e.g selectByValue, selectByVisibleText, selectByIndex)
     * @param value value of element
     * @return WebKeyword to set value for element
     */
    public WebKeyword setValueForElement(WebElement webElement, typeOfSelect type, String value){
        Select ddlElement = new Select(webElement);
        switch (type){
            case selectByValue:
                ddlElement.selectByValue(value);            
                break;
            case selectByVisibleText:
                ddlElement.selectByVisibleText(value);
                break;
            case selectByIndex:
                ddlElement.selectByIndex(Integer.parseInt(value));
                break;
        }
        return new WebKeyword(driver);
    }
    
    /**
     * Scroll to element in page
     * @param webElement element to scroll
     * @return keyword scroll to element
     */
    public WebKeyword scrollToElement(WebElement webElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return new WebKeyword(driver);
    }

    /**
     * Switch into iframe
     * @param webElement iframe to switch
     * @return keyword to switch into iframe
     */
    public WebKeyword switchIntoIframe(WebElement webElement){
        driver.switchTo().frame(webElement);
        return new WebKeyword(driver);
    }

    /**
     * Switch to default content
     * @return content defaut
     */
    public WebKeyword swithchToDefaultContent(){
        driver.switchTo().defaultContent();
        return new WebKeyword(driver);
    }
    
}
