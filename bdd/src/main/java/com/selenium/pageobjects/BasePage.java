package com.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.function.Function;

public class BasePage {

    protected WebDriver driver;

    protected Wait<WebDriver> waitItem;

    public BasePage(WebDriver driver,Wait<WebDriver> waitItem){
        this.driver = driver;
        this.waitItem = waitItem;
    }

    protected void waitExplicit(final By by, final String text) {
        waitItem.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(by);
                if (elements.size() > 0) {
                    for (WebElement ele : elements) {
                        if (ele.getText().contains(text)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

}
