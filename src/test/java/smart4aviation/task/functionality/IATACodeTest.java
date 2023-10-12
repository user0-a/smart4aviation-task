package smart4aviation.task.functionality;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import smart4aviation.task.model.RequestProcessor;
import smart4aviation.task.model.responses.IATASummaryResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static smart4aviation.task.util.DateParser.parseDateFromString;

@SpringBootTest
public class IATACodeTest {
    @Autowired
    RequestProcessor requestProcessor;
    @Test
    public void properIATACodeAndDateResponseTest() throws Exception {
        IATASummaryResponse ia = requestProcessor
                .iataCodeResponse("LEW", parseDateFromString("2016-12-06T07:08:13-01:00").get());
        IATASummaryResponse expected =
                new IATASummaryResponse(7015,2,0,0,false,"");
        assertEquals(expected, ia);
    }
}
