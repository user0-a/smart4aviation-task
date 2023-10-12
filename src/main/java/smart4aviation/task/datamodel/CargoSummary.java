package smart4aviation.task.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import smart4aviation.task.util.WeightUnit;

import java.util.List;

import static smart4aviation.task.util.WeightUnitExchanger.kgToLb;
import static smart4aviation.task.util.WeightUnitExchanger.lbToKg;

public class CargoSummary {

    @JsonProperty("flightId")
    private long flightId;
    @JsonProperty("baggage")
    private List<Cargo> baggage;
    @JsonProperty("cargo")
    private List<Cargo> cargo;

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public List<Cargo> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Cargo> baggage) {
        this.baggage = baggage;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    public int getAllCargoWeight(WeightUnit weightUnit) {
        return this.getCargo().stream()
                .map(cargo -> cargoAlignWeightUnit(cargo, weightUnit))
                .reduce(0, Integer::sum);
    }

    public int getAllBaggageWeight(WeightUnit weightUnit) {
        return this.getBaggage().stream()
                .map(cargo -> cargoAlignWeightUnit(cargo, weightUnit))
                .reduce(0, Integer::sum);
    }

    public int getAllPieces() {
        return this.getBaggage().stream()
                .map(Cargo::getPieces)
                .reduce(0, Integer::sum)
                +
                this.getCargo().stream()
                        .map(Cargo::getPieces)
                        .reduce(0, Integer::sum);

    }

    private int cargoAlignWeightUnit(Cargo cargo, WeightUnit weightUnit) {
        if (cargo.getWeightUnit().equals(weightUnit.name())) {
            return cargo.getWeight();
        }

        if (weightUnit == WeightUnit.kg) {
            return lbToKg(cargo.getWeight());
        } else {
            return kgToLb(cargo.getWeight());
        }
    }

    @Override
    public String toString() {
        return "CargoSummaryForFlight{" +
                "flightId=" + flightId +
                ", baggage=" + baggage +
                ", cargo=" + cargo +
                '}';
    }
}
