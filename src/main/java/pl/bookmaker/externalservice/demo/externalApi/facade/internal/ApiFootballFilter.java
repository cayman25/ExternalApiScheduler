package pl.bookmaker.externalservice.demo.externalApi.facade.internal;

import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApiFootballFilter {

    public List<Game> getFinishedGames(List<Game> listOfGameEntity) {
        return listOfGameEntity.stream().filter(game ->
                        game.getStatusMatch().equals("FINISHED")
                        && !game.getWinner().isEmpty())
                        .collect(Collectors.toList());
        }

    public List<Game> getAllGames(List<Game> listOfGameEntity){
        return listOfGameEntity.stream().filter(game ->
                !game.getStatusMatch().equals("FINISHED")).collect(Collectors.toList());
    }
}
