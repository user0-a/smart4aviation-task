package smart4aviation.task.model.responses;

import java.util.Objects;

public class FlightSummaryResponse extends Response {
    private final int cargoWeight;
    private final int baggageWeight;

    private final int totalWeight;

    public FlightSummaryResponse(int cargoWeight, int baggageWeight, boolean isFailed, String failedReason) {
        super(isFailed,failedReason);
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.totalWeight = this.cargoWeight + this.baggageWeight;
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

    @Override
    public String toString() {
        return "FlightSummaryResponse{" +
                "cargoWeight=" + cargoWeight +
                ", baggageWeight=" + baggageWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightSummaryResponse that = (FlightSummaryResponse) o;
        return cargoWeight == that.cargoWeight && baggageWeight == that.baggageWeight && totalWeight == that.totalWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoWeight, baggageWeight, totalWeight);
    }
}
