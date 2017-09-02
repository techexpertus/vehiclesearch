package config;

import com.bdd.helpers.CSVParser;
import com.bdd.helpers.ParserFile;
import cucumber.runtime.java.spring.ScenarioScoped;
import cucumber.runtime.java.spring.ScenarioScoper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ FilesRetrieverSvcConfig.class, ScenarioScoper.class})
public class BddConfiguration {

    @Bean @ScenarioScoped
    public State state() {
        final State state = new State();
        return state;
    }

    @Bean
    public ParserFile parserFile(){
        return new CSVParser();
    }

}
