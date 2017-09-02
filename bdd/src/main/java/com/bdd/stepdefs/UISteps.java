package com.bdd.stepdefs;

import com.bdd.model.Vehicle;
import com.selenium.pageobjects.vehicleinformation.EnterRegistratioNumerView;
import com.selenium.pageobjects.vehicleinformation.StartPage;
import com.selenium.pageobjects.vehicleinformation.VehicleDetailsView;
import config.DriverConfiguration;
import config.State;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;


@ContextConfiguration(classes = { DriverConfiguration.class})
public class UISteps implements En {

    @Autowired
    private State state;

    @Autowired
    private WebDriver driver;

    @Autowired
    private Wait<WebDriver> waitItem;

    public UISteps() {

        When("^I search the vehicles from the file on UI$", () -> {
            state.extractVehicles();
            driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
            new StartPage(driver,waitItem).waitForLoad().clickStart();
            new EnterRegistratioNumerView(driver,waitItem).waitForLoad().searchRegistrationNumber("HG05 VBF");
            List<Vehicle> actualVehicles = new ArrayList<>();
            actualVehicles.add(new VehicleDetailsView(driver,waitItem).waitForLoad().extractVehicleDetails());

            System.out.println("Finished extracting");
        });

        Then("^UI should return vehicle details as per expected details in csv file$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
