package smart4aviation.task.model;

import org.springframework.beans.factory.annotation.Autowired;
import smart4aviation.task.databaseconnection.Connector;
import smart4aviation.task.data.CargoSummary;
import smart4aviation.task.data.Flight;
import smart4aviation.task.model.responses.FlightSummaryResponse;
import smart4aviation.task.model.responses.FlightSummaryResponseFactory;
import smart4aviation.task.model.responses.IATASummaryResponse;
import smart4aviation.task.model.responses.IATASummaryResponseFactory;
import smart4aviation.task.util.WeightUnit;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RequestProcessor {
    @Autowired
    private Connector connector;
    private final FlightSummaryResponseFactory flightSummaryResponseFactory;

    private final IATASummaryResponseFactory iataSummaryResponseFactory;

    public RequestProcessor(FlightSummaryResponseFactory flightSummaryResponseFactory, IATASummaryResponseFactory iataSummaryResponseFactory) {
        this.flightSummaryResponseFactory = flightSummaryResponseFactory;
        this.iataSummaryResponseFactory = iataSummaryResponseFactory;
    }

    public FlightSummaryResponse flightNumberResponse(int flightNumber, Date date) throws Exception { // TODO exception handling better
        List<Flight> flightData = connector.getFlights();
        List<CargoSummary> cargoData = connector.getCargo();

        Optional<CargoSummary> cargoModel = findCargoBasedOnFlightId(cargoData, flightNumber);

        Optional<Flight> requestedFlight = findFlightBasedOnDateAndId(flightData, flightNumber, date); //TODO failed

        if (cargoModel.isPresent() && requestedFlight.isPresent()) {
            return createResponseBasedOnCalculatedData(cargoModel.get());
        }

        return flightSummaryResponseFactory.createFailedSummaryResponse(String.format("flightid:%d Flight not found", flightNumber));
    }

    private Optional<CargoSummary> findCargoBasedOnFlightId(List<CargoSummary> cargoData, int flightNumber) {
        return cargoData.stream()
                .filter(flight -> flight.getFlightId() == flightNumber)
                .findFirst();
    }

    private Optional<Flight> findFlightBasedOnDateAndId(List<Flight> flightData, int flightNumber, Date date) {
        return flightData.stream()
                .filter(flight -> flight.getDepartureDate().equals(date)
                && flight.getFlightId() == flightNumber)
                .findFirst();
    }

    private FlightSummaryResponse createResponseBasedOnCalculatedData(CargoSummary cargoModel) {
        int cargoWeight = cargoModel.getAllCargoWeight(WeightUnit.kg);

        int baggageWeight = cargoModel.getAllBaggageWeight(WeightUnit.kg);

        return flightSummaryResponseFactory.createSummaryResponse(cargoWeight, baggageWeight);
    }

    public IATASummaryResponse iataCodeResponse(String IATACode, Date date) throws Exception { // TODO date
        List<Flight> flightList = connector.getFlights();
        List<CargoSummary> populatedCargo = connector.getCargo();

        List<Flight> getFlightsArriving = getFlightsBasedOnConditions(flightList, true, IATACode, date);
        List<Flight> getFlightsDeparture = getFlightsBasedOnConditions(flightList, false, IATACode, date);

        if(getFlightsArriving.isEmpty() && getFlightsDeparture.isEmpty()){
            return iataSummaryResponseFactory.createFailedIATASummaryResponse("Not flights found for this date");
        }

        int allPiecesArriving = calculateAllPiecesForFlights(getFlightsArriving, populatedCargo);
        int allPiecesDeparting = calculateAllPiecesForFlights(getFlightsDeparture, populatedCargo);

        return iataSummaryResponseFactory.createIATASummaryResponse(
                allPiecesArriving,
                getFlightsArriving.size(),
                allPiecesDeparting,
                getFlightsDeparture.size()
        );
    }

    private int calculateAllPiecesForFlights(List<Flight> flightList, List<CargoSummary> cargo){
        return flightList.stream().map(Flight::getFlightId)
                .map(e ->
                        cargo.stream()
                                .filter(x -> x.getFlightId() == e)
                                .findFirst()
                                .get()
                                .getAllPieces()
                ).reduce(0, Integer::sum);
    }

    private List<Flight> getFlightsBasedOnConditions(List<Flight> flightList, boolean findArrival, String IATACode, Date date){
        return flightList
                .stream()
                .filter(flight ->
                        {
                            if(findArrival){
                                return flight.getArrivalAirportIATACode().equals(IATACode);
                            }else{
                                return flight.getDepartureAirportIATACode().equals(IATACode);
                            }
                        }
                )
                .filter(flight -> {
                    Instant dateInstant = date.toInstant()
                            .truncatedTo(ChronoUnit.DAYS);
                    Instant flightInstant = flight.getDepartureDate().toInstant()
                            .truncatedTo(ChronoUnit.DAYS);
                    return dateInstant.equals(flightInstant);
                })
                .toList();
    }

}
