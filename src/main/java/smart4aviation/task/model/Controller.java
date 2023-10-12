package smart4aviation.task.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RequestProcessor requestProcessor;

    @Autowired
    private ParametersValidator parametersValidator;

    @GetMapping(value = "/iata-summary")
    public String getUsers(@RequestParam String IATACode, @RequestParam String date) throws Exception {
        if(!parametersValidator.checkIfDateIsValid(date)){
            return parametersValidator.createDateNotValidResponse(date).toString();
        }
        if(!parametersValidator.checkIfIATACodeIsValid(IATACode)){
            return parametersValidator.createIATACodeValidResponse(IATACode).toString();
        }
       return requestProcessor.iataCodeResponse(IATACode, parametersValidator.getDate(date)).toString();
    }

    @GetMapping(value = "/flight-number-summary")
    public String getUsers(@RequestParam int flightNumber, @RequestParam String date) throws Exception {
        if(!parametersValidator.checkIfDateIsValid(date)){
            return parametersValidator.createDateNotValidResponse(date).toString();
        }
        return requestProcessor.flightNumberResponse(flightNumber,parametersValidator.getDate(date)).toString();
    }
}
