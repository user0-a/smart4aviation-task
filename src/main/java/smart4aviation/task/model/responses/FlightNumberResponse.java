package smart4aviation.task.model.responses;

import java.util.Objects;

public class FlightNumberResponse {
    private final int cargoWeightForFlight;
    private final int baggageWeightForFlight;

    private final int totalWeightForFlight;

    private final boolean isFailed;
    private final String failedReason;

    public FlightNumberResponse(int cargoWeightForFlight, int baggageWeightForFlight, boolean isFailed, String failedReason) {
        this.cargoWeightForFlight = cargoWeightForFlight;
        this.baggageWeightForFlight = baggageWeightForFlight;
        this.totalWeightForFlight = this.cargoWeightForFlight + this.baggageWeightForFlight;
        this.isFailed = isFailed;
        this.failedReason = failedReason;
    }

    public int getCargoWeightForFlight() {
        return cargoWeightForFlight;
    }

    public int getBaggageWeightForFlight() {
        return baggageWeightForFlight;
    }

    public int getTotalWeightForFlight() {
        return totalWeightForFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightNumberResponse that = (FlightNumberResponse) o;
        return cargoWeightForFlight == that.cargoWeightForFlight && baggageWeightForFlight == that.baggageWeightForFlight && totalWeightForFlight == that.totalWeightForFlight && isFailed == that.isFailed && Objects.equals(failedReason, that.failedReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoWeightForFlight, baggageWeightForFlight, totalWeightForFlight, isFailed, failedReason);
    }

    public boolean isFailed() {
        return isFailed;
    }

    public String getFailedReason() {
        return failedReason;
    }

    @Override
    public String toString() {
        return "FlightNumberResponse{" +
                "cargoWeightForFlight=" + cargoWeightForFlight +
                ", baggageWeightForFlight=" + baggageWeightForFlight +
                ", totalWeightForFlight=" + totalWeightForFlight +
                ", isFailed=" + isFailed +
                ", failedReason='" + failedReason + '\'' +
                '}';
    }
}
