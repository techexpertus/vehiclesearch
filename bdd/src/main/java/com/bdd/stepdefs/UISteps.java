package com.bdd.stepdefs;


import config.BddConfiguration;
import config.State;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(classes = BddConfiguration.class)
public class UISteps implements En {

    @Autowired
    private State state;

    public UISteps() {

        When("^I search the vehicles from the file on UI$", () -> {
            state.extractVehicles();
            System.out.println("Finished extracting");
        });

        Then("^UI should return vehicle details as per expected details in csv file$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }


}
