package smart4aviation.task.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RequestProcessor requestProcessor;
    @GetMapping(value = "/iata-summary")
    public String getUsers(@RequestParam String IATACode, @RequestParam String date) throws Exception {
       return requestProcessor.iataCodeResponse(IATACode,date).toString();
    }

    @GetMapping(value = "/flight-number-summary")
    public String getUsers(@RequestParam int flightNumber, @RequestParam String date) throws Exception {
        return requestProcessor.flightNumberResponse(flightNumber,date).toString();
    }
}
