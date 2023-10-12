package smart4aviation.task.model.responses;

import java.util.Objects;

public class IATASummaryResponse {
    private final int allPiecesArriving;
    private final int numberOfFlightArriving;
    private final int allPiecesDeparturing;
    private final int numberOfFlightDeparturing;
    private final boolean isFailed;
    private final String failedReason;

    public IATASummaryResponse(int allPiecesArriving, int numberOfFlightArriving, int allPiecesDeparturing, int numberOfFlightDeparturing, boolean isFailed, String failedReason) {
        this.allPiecesArriving = allPiecesArriving;
        this.numberOfFlightArriving = numberOfFlightArriving;
        this.allPiecesDeparturing = allPiecesDeparturing;
        this.numberOfFlightDeparturing = numberOfFlightDeparturing;
        this.isFailed = isFailed;
        this.failedReason = failedReason;
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

    public boolean isFailed() {
        return isFailed;
    }

    public String getFailedReason() {
        return failedReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IATASummaryResponse that = (IATASummaryResponse) o;
        return allPiecesArriving == that.allPiecesArriving && numberOfFlightArriving == that.numberOfFlightArriving && allPiecesDeparturing == that.allPiecesDeparturing && numberOfFlightDeparturing == that.numberOfFlightDeparturing && isFailed == that.isFailed && Objects.equals(failedReason, that.failedReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allPiecesArriving, numberOfFlightArriving, allPiecesDeparturing, numberOfFlightDeparturing, isFailed, failedReason);
    }

    @Override
    public String toString() {
        return "IATACodeResponse{" +
                "allPiecesArriving=" + allPiecesArriving +
                ", numberOfFlightArriving=" + numberOfFlightArriving +
                ", allPiecesDeparturing=" + allPiecesDeparturing +
                ", numberOfFlightDeparturing=" + numberOfFlightDeparturing +
                ", isFailed=" + isFailed +
                ", failedReason='" + failedReason + '\'' +
                '}';
    }
}
