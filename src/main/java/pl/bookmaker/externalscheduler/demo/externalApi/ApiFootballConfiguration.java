package pl.bookmaker.externalscheduler.demo.externalApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bookmaker.externalscheduler.demo.repository.GameRepository;

@Configuration
public class ApiFootballConfiguration {

    @Bean
    ApiFootballFacade apiFootballFacade(GameRepository gameRepository) {
        ApiFootballUrls urls = new ApiFootballUrls();
        ApiFootballJsonConsumer consumer = new ApiFootballJsonConsumer();
        ApiFootballFilterGame filter = new ApiFootballFilterGame();
        ApiFootballGamesCollections collection = new ApiFootballGamesCollections();

        return new ApiFootballFacade(urls, consumer, filter, collection);
    }
}
