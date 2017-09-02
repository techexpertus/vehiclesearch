package com.bdd.helpers;

import com.bdd.model.Vehicle;

import java.io.IOException;
import java.util.List;

public interface ParserFile {

    public List<Vehicle> toVehicles(String filePath) throws IOException;
}
