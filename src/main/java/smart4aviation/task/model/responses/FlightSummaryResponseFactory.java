package smart4aviation.task.model.responses;

public class FlightSummaryResponseFactory {
    public FlightSummaryResponse createFailedSummaryResponse(String reason){
        return new FlightSummaryResponse(0,0,true,reason);
    }

    public FlightSummaryResponse createSummaryResponse(int cargoWeight, int baggageWeight){
        return new FlightSummaryResponse(cargoWeight,baggageWeight,false,"");
    }
}
