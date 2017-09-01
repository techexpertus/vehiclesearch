package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.FilesRetrieverSvc;
import service.FilesRetrieverSvcImpl;

@Configuration
public class FilesRetrieverSvcConfig {

    @Bean
    public FilesRetrieverSvc filesRetrieverSvc() {
        return new FilesRetrieverSvcImpl();
    }
}
