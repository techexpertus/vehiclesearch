package com.selenium.pageobjects.vehicleinformation;


import com.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


public class StartPage extends BasePage {


    private By startButtonIdentifier = By.cssSelector("a[href='https://www.vehicleenquiry.service.gov.uk']");

    public StartPage(WebDriver driver,Wait<WebDriver> waitItem){
        super(driver, waitItem);

    }
    public StartPage waitForLoad(){
        waitItem.until(driver -> driver.findElement(By.cssSelector("h1")).getText().contains(
                "Get vehicle information from DVLA"));
        return this;
    }

    public void clickStart() {
        driver.findElement(startButtonIdentifier).click();
    }
}
