package smart4aviation.task;

import org.springframework.context.annotation.Bean;
import smart4aviation.task.databaseconnection.Connector;
import smart4aviation.task.databaseconnection.MockedConnector;
import smart4aviation.task.model.RequestProcessor;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RequestProcessor requestProcessor() {
        return new RequestProcessor();
    }

    @Bean
    public Connector connector() {
        return new MockedConnector();
    }
}
