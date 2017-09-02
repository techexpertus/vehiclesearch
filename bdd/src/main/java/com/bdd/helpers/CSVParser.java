package com.bdd.helpers;

import com.bdd.model.Vehicle;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements ParserFile {

    @Override
    public List<Vehicle> toVehicles(String filePath) throws IOException {

        List<Vehicle> results = new ArrayList<>();

        try {

            CsvReader vehicles = new CsvReader(filePath);

            vehicles.readHeaders();

            while (vehicles.readRecord()) {
                results.add(Vehicle.createVehicle(
                        vehicles.get("registrationNumber"),
                        vehicles.get("make"),
                        vehicles.get("color")));

            }
            vehicles.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
