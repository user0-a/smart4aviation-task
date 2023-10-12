package smart4aviation.task.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static smart4aviation.task.util.IATACodeValidator.isValidIATAArrivalsCode;
import static smart4aviation.task.util.IATACodeValidator.isValidIATADepartureCode;

class IATACodeValidatorTest {

    @Test
    void checkValidCodesTest(){
        String properDepartureCode = "LAX";
        String properArrivalCode = "LEW";

        assertTrue(isValidIATADepartureCode(properDepartureCode));
        assertTrue(isValidIATAArrivalsCode(properArrivalCode));
    }

    @Test
    void checkNotValidCodesTest(){
        String notProperArrivalCode = "LWW";
        String notProperDepartureCode = "LAA";

        assertFalse(isValidIATAArrivalsCode(notProperArrivalCode));
        assertFalse(isValidIATADepartureCode(notProperDepartureCode));
    }

}