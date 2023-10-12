package smart4aviation.task.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cargo {

    @JsonProperty("id")
    private long id;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("weightUnit")
    private String weightUnit;

    @JsonProperty("pieces")
    private int pieces;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
