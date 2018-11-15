package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.List;

@Service
class ApiFootballFacade implements Observer {

    @Autowired
    private GameRepository gameRepository;
    private final ApiFootballUrls urls;
    private final ApiFootballJsonConsumer consumer;
    private final ApiFootballFilterGame filter;
    private final ApiFootballGameCollection collection;

    @Value("${api.apiAuthToken}")
    private String apiToken;

    @Value("${api.url}")
    private String url;

    ApiFootballFacade(ApiFootballUrls urls, ApiFootballJsonConsumer consumer, ApiFootballFilterGame filter, ApiFootballGameCollection collection) {
        this.urls = urls;
        this.consumer = consumer;
        this.filter = filter;
        this.collection = collection;
        collection.register(this);
    }

    @Scheduled(cron = "*/30 * * * * *")
    void updateCollectionGame() {
        System.out.println("Update Collection");
        updateGameCollection();
    }

    @Scheduled(cron = "0 0 1 * * *")
    void saveAllGameEntityOnePerDay() {
        System.out.println("Save All");
        saveAllGameEntity();
    }

    @Scheduled(cron = "0 30 1 * * *")
    void clearTemporaryGameEntityCollection() {
        System.out.println("Clear Collection");
        collection.clearTemporaryCollection();
    }

    void updateGameCollection() {
        List<Game> games = consumer.getGames(urls.createListUrl(url),apiToken);
        collection.setFinishedGames(filter.getFinishedGames(games));
        collection.setAllGames(filter.getAllNotFinishedGames(games));
    }

    private void saveAllGameEntity() {
        System.out.println("Saved All: " + collection.getAllGames().size() + " games");
        gameRepository.saveAll(collection.getAllGames());
    }

    private void saveFinishedGameEntity() {
        System.out.println("Saved Finished: " + collection.getFinishedGames().size() + " games");
        gameRepository.saveAll(collection.getNotSavedFinishedGames());
    }

    @Override
    public void update() {
        System.out.println("New finished game, save action needed");
        saveFinishedGameEntity();
    }
}
