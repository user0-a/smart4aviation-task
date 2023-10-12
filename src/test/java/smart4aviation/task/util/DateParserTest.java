package smart4aviation.task.util;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static smart4aviation.task.util.DateParser.parseDateFromString;

class DateParserTest {
    @Test
    void parseProperDateFromStringTest() {
        Optional<Date> parsedDate = parseDateFromString("2016-12-06T07:08:13-01:00");
        assertTrue(parsedDate.isPresent());
    }

    @Test
    void parseFalseDateFromStringTest() {
        Optional<Date> parsedDate = parseDateFromString("randomTest");
        assertFalse(parsedDate.isPresent());
    }

}