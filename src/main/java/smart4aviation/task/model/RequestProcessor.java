package smart4aviation.task.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import smart4aviation.task.databaseconnection.Connector;
import smart4aviation.task.datamodel.CargoSummaryForFlight;
import smart4aviation.task.datamodel.FlightJSON;
import smart4aviation.task.model.responses.FlightNumberResponse;
import smart4aviation.task.model.responses.IATACodeResponse;
import smart4aviation.task.util.IATACodeValidator;
import smart4aviation.task.util.WeightUnit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static smart4aviation.task.util.DateParser.parseDateFromString;

public class RequestProcessor {
    @Autowired
    Connector connector;

    public FlightNumberResponse flightNumberResponse(int flightNumber, String date) throws Exception { // TODO exception handling better
        List<FlightJSON> flightJSONList = connector.getPopulatedFlights();
        List<CargoSummaryForFlight> populatedCargo = connector.getPopulatedCargo();

        Optional<Date> prasedDate = parseDateFromString(date);

        if(prasedDate.isEmpty()){
            return new FlightNumberResponse(0,0,true,"data failed");
        }

        Optional<CargoSummaryForFlight> cargoModel = populatedCargo.stream().filter(e -> e.getFlightId() == flightNumber).findFirst();
        Optional<FlightJSON> flight  = flightJSONList.stream().filter(e -> e.getDepartureDate().equals(prasedDate.get())).findFirst();

        if(cargoModel.isPresent() && flight.isPresent()){
            int cargoWeight = cargoModel.get().getAllCargoWeight(WeightUnit.kg);

            int baggageWeight = cargoModel.get().getAllBaggageWeight(WeightUnit.kg);

            return new FlightNumberResponse(cargoWeight,baggageWeight,false, "");
        }

        return new FlightNumberResponse(0,0,true,"flight not found");
    }

    public IATACodeResponse iataCodeResponse(String IATACode, String date) throws Exception { // TODO date
        List<FlightJSON> flightJSONList = connector.getPopulatedFlights();
        List<CargoSummaryForFlight> populatedCargo = connector.getPopulatedCargo();


        Optional<Date> prasedDate = parseDateFromString(date);

        if(!IATACodeValidator.isValidIATAArrivalsCode(IATACode)){
            return new IATACodeResponse(0,0,0,0,true,"NOT COOL IATA");
        }

        List<FlightJSON> getFlightsArriving = flightJSONList
                .stream()
                .filter(flight ->
                        flight.getArrivalAirportIATACode().equals(IATACode)
                ).toList();

        int allPiecesArriving = getFlightsArriving.stream().map(FlightJSON::getFlightId)
                .map(e ->
                        populatedCargo.stream()
                                .filter(x -> x.getFlightId() == e)
                                .findFirst()
                                .get()
                                .getAllPieces()
                ).reduce(0, Integer::sum);


        List<FlightJSON> getFlightsDeparture = flightJSONList
                .stream()
                .filter(flight ->
                        flight.getDepartureAirportIATACode().equals(IATACode)
                ).toList();

        int allPiecesDeparturing = getFlightsDeparture.stream().map(FlightJSON::getFlightId)
                .map(e ->
                        populatedCargo.stream()
                                .filter(x -> x.getFlightId() == e)
                                .findFirst()
                                .get()
                                .getAllPieces()
                ).reduce(0, Integer::sum);



        return new IATACodeResponse(
                allPiecesArriving,
                getFlightsArriving.size(),
                allPiecesDeparturing,
                getFlightsDeparture.size(),
                false,
                ""
                );
    }

}
