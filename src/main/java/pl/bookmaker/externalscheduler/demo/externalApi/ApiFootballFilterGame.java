package pl.bookmaker.externalscheduler.demo.externalApi;

import pl.bookmaker.externalscheduler.demo.externalApi.Games.FinishedGames;
import pl.bookmaker.externalscheduler.demo.externalApi.Games.NotFinishedGames;
import pl.bookmaker.externalscheduler.demo.externalApi.interfaces.GamesStrategy;
import pl.bookmaker.externalscheduler.demo.models.entity.Game;

import java.util.List;

class ApiFootballFilterGame {

    List<Game> getFinishedGames(List<Game> listOfGameEntity) {
        GamesStrategy list = new FinishedGames();
        return list.getList(listOfGameEntity);
    }

    List<Game> getAllNotFinishedGames(List<Game> listOfGameEntity) {
        GamesStrategy list = new NotFinishedGames();
        return list.getList(listOfGameEntity);
    }
}
