package pl.bookmaker.externalservice.demo.ExternalApi;

import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;

public class ApiFootballFacade{

    public void setActualGameEntityInCollection() {
        ApiFootballJsonCollection json = new ApiFootballJsonCollection();
        ApiFootballPojo pojo = new ApiFootballPojo();
        List<String> url = json.createUrl();
        pojo.setActualGame(url);
    }

    public List<Game> getFinishedGames(){
        ApiFootballGameCollection games = new ApiFootballGameCollection();
        return games.getFinishedGames();
    }
}
