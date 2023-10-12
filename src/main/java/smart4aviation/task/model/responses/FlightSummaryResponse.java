package smart4aviation.task.model.responses;

import java.util.Objects;

public class FlightSummaryResponse {
    private final int cargoWeight;
    private final int baggageWeight;

    private final int totalWeight;

    private final boolean isFailed;
    private final String failedReason;

    public FlightSummaryResponse(int cargoWeight, int baggageWeight, boolean isFailed, String failedReason) {
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.totalWeight = this.cargoWeight + this.baggageWeight;
        this.isFailed = isFailed;
        this.failedReason = failedReason;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
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
        FlightSummaryResponse that = (FlightSummaryResponse) o;
        return cargoWeight == that.cargoWeight && baggageWeight == that.baggageWeight && totalWeight == that.totalWeight && isFailed == that.isFailed && Objects.equals(failedReason, that.failedReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoWeight, baggageWeight, totalWeight, isFailed, failedReason);
    }

    @Override
    public String toString() {
        return "FlightNumberResponse{" +
                "cargoWeightForFlight=" + cargoWeight +
                ", baggageWeightForFlight=" + baggageWeight +
                ", totalWeightForFlight=" + totalWeight +
                ", isFailed=" + isFailed +
                ", failedReason='" + failedReason + '\'' +
                '}';
    }
}
