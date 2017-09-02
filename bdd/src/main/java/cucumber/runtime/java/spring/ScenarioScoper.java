package cucumber.runtime.java.spring;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ScenarioScoper {
    @Bean
    public static CustomScopeConfigurer scenarioScopeConfigurer() {
        CustomScopeConfigurer scopes = new CustomScopeConfigurer();
        scopes.addScope("cucumber-glue", new GlueCodeScope());
        return scopes;
    }
}
