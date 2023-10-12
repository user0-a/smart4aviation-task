package smart4aviation.task.model.responses;

import java.util.Objects;

public class IATASummaryResponse extends Response {
    private final int allPiecesArriving;
    private final int numberOfFlightArriving;
    private final int allPiecesDeparturing;
    private final int numberOfFlightDeparturing;

    public IATASummaryResponse(int allPiecesArriving, int numberOfFlightArriving, int allPiecesDeparturing, int numberOfFlightDeparturing, boolean isFailed, String failedReason) {
        super(isFailed,failedReason);
        this.allPiecesArriving = allPiecesArriving;
        this.numberOfFlightArriving = numberOfFlightArriving;
        this.allPiecesDeparturing = allPiecesDeparturing;
        this.numberOfFlightDeparturing = numberOfFlightDeparturing;
    }

    public int getAllPiecesArriving() {
        return allPiecesArriving;
    }

    public int getNumberOfFlightArriving() {
        return numberOfFlightArriving;
    }

    public int getAllPiecesDeparturing() {
        return allPiecesDeparturing;
    }

    public int getNumberOfFlightDeparturing() {
        return numberOfFlightDeparturing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IATASummaryResponse that = (IATASummaryResponse) o;
        return allPiecesArriving == that.allPiecesArriving && numberOfFlightArriving == that.numberOfFlightArriving && allPiecesDeparturing == that.allPiecesDeparturing && numberOfFlightDeparturing == that.numberOfFlightDeparturing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allPiecesArriving, numberOfFlightArriving, allPiecesDeparturing, numberOfFlightDeparturing);
    }
}
