package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

@Configuration
public class ApiFootballConfiguration {

    @Bean
    ApiFootballFacade apiFootballFacade(GameRepository gameRepository) {
        ApiFootballUrls urls = new ApiFootballUrls();
        ApiFootballJsonConsumer consumer = new ApiFootballJsonConsumer();
        ApiFootballFilterGame filter = new ApiFootballFilterGame();
        ApiFootballGameCollection collection = new ApiFootballGameCollection();

        return new ApiFootballFacade(urls, consumer, filter, collection);
    }

    ApiFootballFacade apiFootballFacade(InMemoryGameRepository gameRepository) {
        ApiFootballUrls urls = new ApiFootballUrls();
        ApiFootballJsonConsumer consumer = new ApiFootballJsonConsumer();
        ApiFootballFilterGame filter = new ApiFootballFilterGame();
        ApiFootballGameCollection collection = new ApiFootballGameCollection();

        return new ApiFootballFacade(urls, consumer, filter, collection);
    }

}
