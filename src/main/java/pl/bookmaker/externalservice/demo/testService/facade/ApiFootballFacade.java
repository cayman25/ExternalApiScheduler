package pl.bookmaker.externalservice.demo.testService.facade;

import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.testService.facade.internal.ApiFootballFilter;
import pl.bookmaker.externalservice.demo.testService.facade.collection.ApiFootballGameCollection;
import pl.bookmaker.externalservice.demo.testService.facade.internal.ApiFootballPojo;
import pl.bookmaker.externalservice.demo.testService.facade.internal.ApiFootballUrls;

import java.util.List;

public class ApiFootballFacade {

    private final ApiFootballUrls apiFootballUrls = new ApiFootballUrls();
    private final ApiFootballPojo apiFootballPojo = new ApiFootballPojo();
    private final ApiFootballFilter apiFootballFilter = new ApiFootballFilter();
    private final ApiFootballGameCollection collection = new ApiFootballGameCollection();

    public void updateGameCollection(){
       List<String> urls =  apiFootballUrls.createUrl();
       List<Game> games = apiFootballPojo.getGameEntityCollection(urls);
       collection.setFinishedGames(apiFootballFilter.getFinishedGames(games));
       collection.setAllGames(apiFootballFilter.getAllGames(games));
    }

}
