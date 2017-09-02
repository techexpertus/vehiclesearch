package com.selenium.pageobjects.vehicleinformation;

import com.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


public class EnterRegistratioNumerView extends BasePage {

    private By registrationNumberInput= By.cssSelector("input#Vrm");
    private By continueBtn = By.cssSelector("button[name='Continue']");

    public EnterRegistratioNumerView(WebDriver driver,Wait<WebDriver> waitItem){
        super(driver, waitItem);
    }

    public EnterRegistratioNumerView waitForLoad(){
        waitItem.until(driver -> driver.findElement(By.cssSelector("h1.heading-large")).getText().contains(
                "Enter the registration number of the vehicle"));
        return this;
    }
    public void searchRegistrationNumber(String registrationNumber){
        driver.findElement(registrationNumberInput).sendKeys(registrationNumber);
        driver.findElement(continueBtn).click();
    }


}
