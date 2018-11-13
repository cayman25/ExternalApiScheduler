package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiFootballConfiguration {

    @Bean
    ApiFootballFacade apiFootballFacade(){
        ApiFootballUrls urls = new ApiFootballUrls();
        ApiFootballConsumer consumer = new ApiFootballConsumer();
        ApiFootballFilterGame filter = new ApiFootballFilterGame();
        ApiFootballGameCollection collection = new ApiFootballGameCollection();

        return new ApiFootballFacade(collection,consumer,urls,filter);
    }


}
