package com.bdd.stepdefs;

import com.bdd.model.Vehicle;
import com.selenium.pageobjects.vehicleinformation.EnterRegistrationNumberView;
import com.selenium.pageobjects.vehicleinformation.StartPage;
import com.selenium.pageobjects.vehicleinformation.VehicleDetailsView;
import config.DriverConfiguration;
import config.State;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ContextConfiguration(classes = {DriverConfiguration.class})
public class UISteps implements En {

    @Autowired
    private State state;

    @Autowired
    private WebDriver driver;

    @Autowired
    private Wait<WebDriver> waitItem;

    public UISteps() {

        When("^I search the vehicles from the file on UI$", () -> {
            state.extracVehiclesFromFiles();
            List<Vehicle> results = new ArrayList<>();

            for (Vehicle vehicle : state.vehiclesFromFiles) {
                results.add(fetchVehiclesDetails(vehicle));
            }
            state.vehiclesFromUI = results;
        });

        Then("^UI should return vehicle details as per expected details in csv file$", () -> {

            List<Vehicle> expectedVehicles = state.vehiclesFromFiles;
            List<Vehicle> actualVehicles = state.vehiclesFromUI;
            int max = expectedVehicles.size() > actualVehicles.size() ? expectedVehicles.size() : actualVehicles.size();
            for (int i = 0; i < max; i++) {
                assertTrue("Checking vehicle " + expectedVehicles.get(i).getVehicleDetails().get("Registration number"),
                           expectedVehicles.get(i).compare(actualVehicles.get(i)));
            }
        });
    }

    private Vehicle fetchVehiclesDetails(Vehicle vehicle) {

        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");

        new StartPage(driver, waitItem).waitForLoad().clickStart();
        new EnterRegistrationNumberView(driver, waitItem)
                .waitForLoad()
                .searchRegistrationNumber(vehicle.getVehicleDetails().get("Registration number"));
        return new VehicleDetailsView(driver, waitItem)
                .waitForLoad()
                .extractVehicleDetails();
    }
}
