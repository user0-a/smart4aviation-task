package smart4aviation.task.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Flight {
    @JsonProperty("flightId")
    private long flightId;
    @JsonProperty("flightNumber")
    private int flightNumber;
    @JsonProperty("departureAirportIATACode")
    private String departureAirportIATACode;
    @JsonProperty("arrivalAirportIATACode")
    private String arrivalAirportIATACode;
    @JsonProperty("departureDate")
    private Date departureDate;

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "FlightJSON{" +
                "flightId=" + flightId +
                ", flightNumber=" + flightNumber +
                ", departureAirportIATACode='" + departureAirportIATACode + '\'' +
                ", arrivalAirportIATACode='" + arrivalAirportIATACode + '\'' +
                ", departureDate=" + departureDate +
                '}';
    }

}
