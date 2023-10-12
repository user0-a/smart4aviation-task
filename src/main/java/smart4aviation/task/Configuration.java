package smart4aviation.task;

import org.springframework.context.annotation.Bean;
import smart4aviation.task.databaseconnection.Connector;
import smart4aviation.task.databaseconnection.MockedConnector;
import smart4aviation.task.model.ParametersValidator;
import smart4aviation.task.model.RequestProcessor;
import smart4aviation.task.model.responses.FlightSummaryResponseFactory;
import smart4aviation.task.model.responses.IATASummaryResponseFactory;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RequestProcessor requestProcessor() {
        return new RequestProcessor(new FlightSummaryResponseFactory(),new IATASummaryResponseFactory());
    }

    @Bean
    public Connector connector() {
        return new MockedConnector();
    }

    @Bean
    public ParametersValidator parametersValidator(){
        return new ParametersValidator();
    }
}
