package smart4aviation.task.databaseconnection;

import smart4aviation.task.datamodel.CargoSummaryForFlight;
import smart4aviation.task.datamodel.FlightJSON;

import java.io.IOException;
import java.util.List;

public interface Connector {
    List<FlightJSON> getPopulatedFlights() throws Exception;
    List<CargoSummaryForFlight> getPopulatedCargo() throws Exception;
}
