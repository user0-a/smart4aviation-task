package smart4aviation.task.model.responses;

public class IATASummaryResponseFactory {
    public IATASummaryResponse createFailedIATASummaryResponse(String reason) {
        return new IATASummaryResponse(0, 0, 0, 0, true, reason);
    }

    public IATASummaryResponse createIATASummaryResponse(int allPiecesArriving, int numberOfFlightArriving, int allPiecesDeparting, int numberOfFlightDeparting) {
        return new IATASummaryResponse(allPiecesArriving, numberOfFlightArriving, allPiecesDeparting, numberOfFlightDeparting, false, "");
    }
}
