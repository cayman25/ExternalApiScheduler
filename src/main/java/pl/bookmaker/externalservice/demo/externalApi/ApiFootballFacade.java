package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.List;

@Component
public class ApiFootballFacade implements Observer {

    @Autowired
    private GameRepository gameRepository;

    public final ApiFootballUrls urls;
    public final ApiFootballJsonConsumer consumer;
    public final ApiFootballFilterGame filter;
    public final ApiFootballGamesCollections collection;

    @Value("${api.apiAuthToken}")
    private String apiToken;
    @Value("${api.url}")
    private String url;

    ApiFootballFacade(ApiFootballUrls urls, ApiFootballJsonConsumer consumer, ApiFootballFilterGame filter, ApiFootballGamesCollections collection) {
        this.urls = urls;
        this.consumer = consumer;
        this.filter = filter;
        this.collection = collection;
        collection.register(this);
    }

    public void clearTemporaryCollection() {
        collection.clearTemporaryCollection();
    }

    public void updateGameCollection() {
        List<Game> games = consumer.getGames(urls.createListUrl(url),apiToken);
        collection.setFinishedGames(filter.getFinishedGames(games));
        collection.setAllGames(filter.getAllNotFinishedGames(games));
    }

    public void saveAllGameEntity() {
        System.out.println("Saved All: " + collection.getAllGames().size() + " games");
        gameRepository.saveAll(collection.getAllGames());
    }

    private void saveNotFinishedGames() {
        System.out.println("Saved Finished: " + collection.getFinishedGames().size() + " games");
        gameRepository.saveAll(collection.getNotSavedFinishedGames());
    }

    @Override
    public void update() {
        System.out.println("New finished game, save action needed");
        saveNotFinishedGames();
    }
}
