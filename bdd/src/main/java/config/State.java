package config;

import com.bdd.helpers.ParserFile;
import com.bdd.model.Vehicle;
import model.FileDetails;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class State {

    public List<FileDetails> fileDetailsList = new ArrayList<>();
    public List<Vehicle> vehiclesFromFiles = new ArrayList<>();
    public List<Vehicle> vehiclesFromUI = new ArrayList<>();
    public String searchPath;

    @Autowired
    private ParserFile parserFile;

    public void extracVehiclesFromFiles() {

        this.fileDetailsList.forEach(file -> {
            String fileFullpath = this.searchPath + "/" + file.getFileName();
            try {
                parserFile.toVehicles(Paths.get(fileFullpath).toString())
                         .forEach(vehicle -> this.vehiclesFromFiles.add(vehicle));
            } catch (IOException io) {
                throw new RuntimeException("Unable to parse file " + fileFullpath);
            }
        });
    }
}
