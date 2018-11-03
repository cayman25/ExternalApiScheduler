package pl.bookmaker.externalservice.demo.testService.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.testService.facade.internal.ApiFootballFilter;
import pl.bookmaker.externalservice.demo.testService.facade.collection.ApiFootballGameCollection;
import pl.bookmaker.externalservice.demo.testService.facade.internal.ApiFootballPojo;
import pl.bookmaker.externalservice.demo.testService.facade.internal.ApiFootballUrls;

import java.util.List;

@Component
public class ApiFootballFacade {

    private final ApiFootballGameCollection apiFootballGameCollection;

    @Autowired
    public ApiFootballFacade(ApiFootballGameCollection apiFootballGameCollection) {
        this.apiFootballGameCollection=apiFootballGameCollection;
    }

    private final ApiFootballUrls apiFootballUrls = new ApiFootballUrls();
    private final ApiFootballPojo apiFootballPojo = new ApiFootballPojo();
    private final ApiFootballFilter apiFootballFilter = new ApiFootballFilter();

    public void updateGameCollection(){
       List<String> urls =  apiFootballUrls.createUrl();
       List<Game> games = apiFootballPojo.getGameEntityCollection(urls);
       System.out.println(apiFootballFilter.getFinishedGames(games).size());
       apiFootballGameCollection.setFinishedGames(apiFootballFilter.getFinishedGames(games));
       apiFootballGameCollection.setAllGames(apiFootballFilter.getAllGames(games));
    }
}
