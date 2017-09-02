package com.bdd.stepdefs;

import config.BddConfiguration;
import config.State;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import service.FilesRetrieverSvc;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = BddConfiguration.class)
public class FileMatcherSteps implements En {

    @Autowired
    private FilesRetrieverSvc filesRetrieverSvc;

    @Autowired
    private State state;

    public FileMatcherSteps() {

        Given("^I invoke file retrieve service for csv files located in \"([^\"]*)\"$",
              (String dirPath) -> {
                  List<String> allowableMimeTypes = Arrays.asList("text/csv");
                  state.fileDetailsList = filesRetrieverSvc.getFiles(dirPath,allowableMimeTypes);
                  state.searchPath = dirPath;
              }
        );
    }
}
