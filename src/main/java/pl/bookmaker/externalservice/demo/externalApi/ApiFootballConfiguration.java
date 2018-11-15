package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bookmaker.externalservice.demo.repository.CompetitionRepository;
import pl.bookmaker.externalservice.demo.repository.GameRepository;
import pl.bookmaker.externalservice.demo.repository.TeamRepository;

@Configuration
public class ApiFootballConfiguration {

  @Autowired
  ApiFootballGameCollection collection;

  @Bean
  ApiFootballFacade apiFootballFacade(GameRepository gameRepository){
    ApiFootballUrls urls = new ApiFootballUrls();
    ApiFootballJsonConsumer consumer = new ApiFootballJsonConsumer();
    ApiFootballFilterGame filter = new ApiFootballFilterGame();
    //ApiFootballGameCollection collection = new ApiFootballGameCollection();

    return new ApiFootballFacade(urls,consumer,filter,collection);
  }
}
