package smart4aviation.task.model.responses;

import java.util.Objects;

public class IATASummaryResponse extends Response {
    private final int allPiecesArriving;
    private final int numberOfFlightArriving;
    private final int allPiecesDeparting;
    private final int numberOfFlightDeparting;

    public IATASummaryResponse(int allPiecesArriving, int numberOfFlightArriving, int allPiecesDeparting, int numberOfFlightDeparting, boolean isFailed, String failedReason) {
        super(isFailed,failedReason);
        this.allPiecesArriving = allPiecesArriving;
        this.numberOfFlightArriving = numberOfFlightArriving;
        this.allPiecesDeparting = allPiecesDeparting;
        this.numberOfFlightDeparting = numberOfFlightDeparting;
    }

    public int getAllPiecesArriving() {
        return allPiecesArriving;
    }

    public int getNumberOfFlightArriving() {
        return numberOfFlightArriving;
    }

    public int getAllPiecesDeparting() {
        return allPiecesDeparting;
    }

    public int getNumberOfFlightDeparting() {
        return numberOfFlightDeparting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IATASummaryResponse that = (IATASummaryResponse) o;
        return allPiecesArriving == that.allPiecesArriving && numberOfFlightArriving == that.numberOfFlightArriving && allPiecesDeparting == that.allPiecesDeparting && numberOfFlightDeparting == that.numberOfFlightDeparting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allPiecesArriving, numberOfFlightArriving, allPiecesDeparting, numberOfFlightDeparting);
    }
}
