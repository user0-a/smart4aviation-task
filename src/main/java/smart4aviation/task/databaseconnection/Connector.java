package smart4aviation.task.databaseconnection;

import smart4aviation.task.data.CargoSummary;
import smart4aviation.task.data.Flight;

import java.util.List;

public interface Connector {
    List<Flight> getFlights() throws Exception;
    List<CargoSummary> getCargo() throws Exception;
}
