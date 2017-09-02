package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@Configuration
@Import({ BddConfiguration.class})
public class DriverConfiguration {

    @Autowired
    private WebDriver driver;

    @Bean
    public Wait<WebDriver> waitItem(){
        return new FluentWait<>(driver).withTimeout(15, TimeUnit.SECONDS)
                                                .pollingEvery(500,TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

    }
}
