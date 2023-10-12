package smart4aviation.task.databaseconnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import smart4aviation.task.datamodel.CargoSummary;
import smart4aviation.task.datamodel.Flight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MockedConnector implements Connector {
    private final static String PATH_TO_FLIGHT_JSON_DATA = "generatedData/Flights.json";
    private final static String PATH_TO_CARGO_JSON_DATA = "generatedData/Cargo.json";

    private final Path flightJsonPath;
    private final Path cargoJsonPath;
    private final ObjectMapper objectMapper;

    private final ClassLoader classLoader = getClass().getClassLoader();

    public MockedConnector() {
        flightJsonPath = Paths.get(classLoader.getResource(PATH_TO_FLIGHT_JSON_DATA).getPath());
        cargoJsonPath = Paths.get(classLoader.getResource(PATH_TO_CARGO_JSON_DATA).getPath());
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Flight> getPopulatedFlights() throws IOException { // TODO exception handling better
        Flight[] flights = objectMapper.readValue(Files.readAllBytes(flightJsonPath), Flight[].class);
        return Arrays.stream(flights).toList();
    }

    @Override
    public List<CargoSummary> getPopulatedCargo() throws IOException {
        CargoSummary[] cargoSummary = objectMapper.readValue(Files.readAllBytes(cargoJsonPath), CargoSummary[].class);
        return Arrays.stream(cargoSummary).toList();
    }
}
