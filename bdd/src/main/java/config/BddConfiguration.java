package config;

import com.bdd.helpers.CSVParser;
import com.bdd.helpers.ParserFile;
import cucumber.runtime.java.spring.ScenarioScoped;
import cucumber.runtime.java.spring.ScenarioScoper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.nio.file.FileSystems;
import java.nio.file.Path;

@Configuration
@Import({ FilesRetrieverSvcConfig.class, ScenarioScoper.class})
public class BddConfiguration {

    @Bean @ScenarioScoped
    public State state() {
        return new State();
    }

    @Bean
    public ParserFile parserFile(){
        return new CSVParser();
    }

    @Bean
    public WebDriver driver(){
        Path path = FileSystems.getDefault().getPath("bdd/src/main/resources/drivers/geckodriver");
        System.setProperty("webdriver.gecko.driver",path.toString());
        return new FirefoxDriver();
    }



//    @Bean
//    public WebDriver chromeDriver(){
//        return new ChromeDriver();
//    }

}
