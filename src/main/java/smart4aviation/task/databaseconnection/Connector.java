package smart4aviation.task.databaseconnection;

import smart4aviation.task.datamodel.CargoSummary;
import smart4aviation.task.datamodel.Flight;

import java.util.List;

public interface Connector {
    List<Flight> getPopulatedFlights() throws Exception;
    List<CargoSummary> getPopulatedCargo() throws Exception;
}
