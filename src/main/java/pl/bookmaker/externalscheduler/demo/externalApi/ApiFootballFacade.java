package pl.bookmaker.externalscheduler.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalscheduler.demo.externalApi.ex.ApiFootballException;
import pl.bookmaker.externalscheduler.demo.models.entity.Game;
import pl.bookmaker.externalscheduler.demo.repository.GameRepository;
import pl.bookmaker.externalscheduler.demo.externalApi.interfaces.Observer;

import java.util.List;

@Component
public class ApiFootballFacade implements Observer {

    @Autowired
    private GameRepository gameRepository;

    private final ApiFootballUrls urls;
    private final ApiFootballJsonConsumer consumer;
    private final ApiFootballFilterGame filter;
    private final ApiFootballGamesCollections collection;

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
        collection.clearTemporaryCollections();
    }

    public void updateGameCollection() {
        List<Game> games = consumer.getGames(urls.createListUrl(url),apiToken);
        collection.setFinishedAndUpdateNotSavedGames(filter.getFinishedGames(games));
        collection.setAllGames(filter.getAllNotFinishedGames(games));
    }

    public void saveAllGameEntity() {
        if(collection.getAllGames().isEmpty())
            throw new ApiFootballException("list of AllGame is empty");
        else
        gameRepository.saveAll(collection.getAllGames());
        System.out.println("Saved All: " + collection.getAllGames().size() + " games");
    }

    private void saveNotFinishedGames() {
        if(collection.getNotSavedFinishedGames().isEmpty())
            throw new ApiFootballException("list of FinishedGames is empty");
        else
        gameRepository.saveAll(collection.getNotSavedFinishedGames());
        System.out.println("Save not saved games: " + collection.getNotSavedFinishedGames().size() + " games");
    }

    @Override
    public void update() {
        System.out.println("New finished game, save action needed");
        saveNotFinishedGames();
    }
}
