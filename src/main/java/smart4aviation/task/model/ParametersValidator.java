package smart4aviation.task.model;

import smart4aviation.task.model.responses.Response;
import smart4aviation.task.util.IATACodeValidator;

import java.util.Date;
import java.util.Optional;

import static smart4aviation.task.util.DateParser.parseDateFromString;

public class ParametersValidator {
    public Response createDateNotValidResponse(String date) {
        return new Response(true, String.format("%s is not valid date", date));
    }

    public Response createIATACodeValidResponse(String IATA) {
        return new Response(true, String.format("%s is not IATA code", IATA));
    }

    public boolean checkIfDateIsValid(String date) {
        return parseDateFromString(date).isPresent();
    }

    public boolean checkIfIATACodeIsValid(String IATACode) {
        return IATACodeValidator.isValidIATAArrivalsCode(IATACode) || IATACodeValidator.isValidIATADepartureCode(IATACode);
    }

    public Date getDate(String date) {
        return parseDateFromString(date).get();
    }

}
