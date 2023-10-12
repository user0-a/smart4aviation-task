package smart4aviation.task.functionality;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import smart4aviation.task.model.RequestProcessor;
import smart4aviation.task.model.responses.FlightSummaryResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static smart4aviation.task.util.DateParser.parseDateFromString;

@SpringBootTest
public class FlightSummaryTest {
    @Autowired
    RequestProcessor requestProcessor;

    @Test
    public void properFlightIdAndDateResponseTest() throws Exception {
        FlightSummaryResponse flightSummaryResponse = requestProcessor
                .flightNumberResponse(0, parseDateFromString("2016-12-06T07:08:13-01:00").get());
        FlightSummaryResponse expected = new FlightSummaryResponse(1386,961,false,"");
        assertEquals(expected, flightSummaryResponse);
    }

//    @Test
//    public void notProperFlightIdAndDateResponseTest() throws Exception {
//        FlightSummaryResponse flightSummaryResponse = requestProcessor.flightNumberResponse(1,"dsada");
//        FlightSummaryResponse expected = new FlightSummaryResponse(2241,4030,false,"");
//        assertEquals(expected, flightSummaryResponse);
//    }
}
