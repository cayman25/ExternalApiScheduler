package pl.bookmaker.externalservice.demo.externalApi.facade.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;

@Component
public class ApiFootballFacade {

    private final ApiFootballGameCollection apiFootballGameCollection;

    @Autowired
    public ApiFootballFacade(ApiFootballGameCollection apiFootballGameCollection) {
        this.apiFootballGameCollection=apiFootballGameCollection;
    }

    private final ApiFootballUrls apiFootballUrls = new ApiFootballUrls();
    private final ApiFootballJsonConsumer apiFootballJsonConsumer = new ApiFootballJsonConsumer();
    private final ApiFootballFilterGame apiFootballFilterGame = new ApiFootballFilterGame();

    public void updateGameCollection(){
        List<Game> games = apiFootballJsonConsumer.getGameEntityCollection(apiFootballUrls.createListUrl());
        apiFootballGameCollection.setFinishedGames(apiFootballFilterGame.getFinishedGames(games));
        apiFootballGameCollection.setAllGames(apiFootballFilterGame.getAllGames(games));
    }
}
