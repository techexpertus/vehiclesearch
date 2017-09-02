package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


public class BasePage {

    protected WebDriver driver;

    protected Wait<WebDriver> waitItem;

    public BasePage(WebDriver driver,Wait<WebDriver> waitItem){
        this.driver = driver;
        this.waitItem = waitItem;
    }


}
