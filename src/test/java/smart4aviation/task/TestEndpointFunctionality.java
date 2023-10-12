package smart4aviation.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import smart4aviation.task.model.OverallController;
import smart4aviation.task.model.RequestProcessor;
import smart4aviation.task.model.responses.FlightNumberResponse;
import smart4aviation.task.model.responses.IATACodeResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestEndpointFunctionality {
    @Autowired
    RequestProcessor requestProcessor;
    @Test
    public void test1() throws Exception {

        IATACodeResponse ia = requestProcessor.iataCodeResponse("LEW","2016-12-06T07:08:13-01:00");
        IATACodeResponse expected =
                new IATACodeResponse(7015,2,0,0,false,"");
        assertEquals(expected, ia);
    }

    @Test
    public void test2() throws Exception {
        FlightNumberResponse flightNumberResponse = requestProcessor.flightNumberResponse(1,"2016-12-06T07:08:13-01:00");
        FlightNumberResponse expected = new FlightNumberResponse(2241,4030,false,"");
        assertEquals(expected,flightNumberResponse);
    }
}
