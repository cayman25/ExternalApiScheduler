package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;

@Component
class ApiFootballFacade {

    private final ApiFootballGameCollection apiFootballGameCollection;
    private final ApiFootballConsumer apiFootballConsumer;
    private final ApiFootballUrls apiFootballUrls;
    private final ApiFootballFilterGame apiFootballFilterGame = new ApiFootballFilterGame();

    @Autowired
    ApiFootballFacade(ApiFootballGameCollection apiFootballGameCollection, ApiFootballConsumer apiFootballConsumer, ApiFootballUrls apiFootballUrls) {
        this.apiFootballGameCollection=apiFootballGameCollection;
        this.apiFootballConsumer = apiFootballConsumer;
        this.apiFootballUrls = apiFootballUrls;
    }

    void updateGameCollection(){
        List<Game> games = apiFootballConsumer.getGameEntityCollection(apiFootballUrls.createListUrl());
        apiFootballGameCollection.setFinishedGames(apiFootballFilterGame.getFinishedGames(games));
        apiFootballGameCollection.setAllGames(apiFootballFilterGame.getAllNotFinishedGames(games));
    }
}
