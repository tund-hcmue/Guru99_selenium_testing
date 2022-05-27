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

    /**
     * Open Url
     * @param url
     * @throws Exception
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
        // return new WebKeyword(driver);
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
     * Set value for element by value
     * @param webElement element to select value
     * @param value value to select
     * @return keyword selectByValue
     */
    public WebKeyword selectByValue(WebElement webElement, String value){
        Select ddl = new Select(webElement);
        ddl.selectByValue(value);
        return new WebKeyword(driver);
    }

    /**
     * Set value for element by visible text
     * @param webElement element to select value
     * @param value value to select
     * @return keyword selectByVisibleText
     */
    public WebKeyword selectByVisibleText(WebElement webElement, String value){
        Select ddl = new Select(webElement);
        ddl.selectByVisibleText(value);
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
