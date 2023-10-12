package smart4aviation.task.model.responses;

public class IATASummaryResponseFactory {
    public IATASummaryResponse createFailedIATASummaryResponse(String reason) {
        return new IATASummaryResponse(0, 0, 0, 0, false, reason);
    }

    public IATASummaryResponse createIATASummaryResponse(int allPiecesArriving, int numberOfFlightArriving, int allPiecesDeparturing, int numberOfFlightDeparturing) {
        return new IATASummaryResponse(allPiecesArriving, numberOfFlightArriving, allPiecesDeparturing, numberOfFlightDeparturing, false, "");
    }
}
