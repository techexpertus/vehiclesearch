package com.selenium.pageobjects.vehicleinformation;


import com.bdd.helpers.Utils;
import com.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class StartPage extends BasePage {


    private By startButtonIdentifier = By.cssSelector("a[href='https://www.vehicleenquiry.service.gov.uk']");

    public StartPage(WebDriver driver,Wait<WebDriver> waitItem){
        super(driver, waitItem);
        Utils.log("Loading " + this.getClass().getName());

    }
    public StartPage waitForLoad(){

        waitExplicit(By.cssSelector("h1"), "Get vehicle information from DVLA");
        Utils.log("Waited for loading of  " + this.getClass().getName());
        return this;
    }



    public void clickStart() {
        driver.findElement(startButtonIdentifier).click();
        Utils.log("Clicked on Start button" );
    }
}
