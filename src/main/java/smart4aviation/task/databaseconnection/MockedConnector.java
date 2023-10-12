package smart4aviation.task.databaseconnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import smart4aviation.task.datamodel.CargoSummaryForFlight;
import smart4aviation.task.datamodel.FlightJSON;

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
    public List<FlightJSON> getPopulatedFlights() throws IOException { // TODO exception handling better
        FlightJSON[] flights = objectMapper.readValue(Files.readAllBytes(flightJsonPath), FlightJSON[].class);
        return Arrays.stream(flights).toList();
    }

    @Override
    public List<CargoSummaryForFlight> getPopulatedCargo() throws IOException {
        CargoSummaryForFlight[] cargoSummaryForFlight = objectMapper.readValue(Files.readAllBytes(cargoJsonPath), CargoSummaryForFlight[].class);
        return Arrays.stream(cargoSummaryForFlight).toList();
    }
}
