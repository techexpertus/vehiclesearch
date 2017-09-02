package com.selenium.pageobjects.vehicleinformation;

import com.bdd.helpers.Utils;
import com.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


public class EnterRegistrationNumberView extends BasePage {

    private By registrationNumberInput= By.cssSelector("input#Vrm");
    private By continueBtn = By.cssSelector("button[name='Continue']");

    public EnterRegistrationNumberView(WebDriver driver, Wait<WebDriver> waitItem){
        super(driver, waitItem);
        Utils.log("Loading " + this.getClass().getName());
    }

    public EnterRegistrationNumberView waitForLoad(){
        waitExplicit(By.cssSelector("h1.heading-large"), "Enter the registration number of the vehicle");
        Utils.log("Waited for loading of  " + this.getClass().getName());
        return this;
    }
    public void searchRegistrationNumber(String registrationNumber){
        Utils.log("Searching Vehicle registration Number " + registrationNumber);
        driver.findElement(registrationNumberInput).sendKeys(registrationNumber);
        driver.findElement(continueBtn).click();
    }


}
