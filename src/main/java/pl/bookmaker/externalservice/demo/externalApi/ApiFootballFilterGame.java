package pl.bookmaker.externalservice.demo.externalApi;

import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ApiFootballFilterGame {

    List<Game> getFinishedGames(List<Game> listOfGameEntity) {
        return listOfGameEntity.stream()
                .filter(game -> game.getStatusMatch().equals("FINISHED")&&
                               !game.getWinner().isEmpty())
                        .collect(Collectors.toList());
        }

    List<Game> getAllGames(List<Game> listOfGameEntity){
        return listOfGameEntity.stream()
                .filter(game -> !game.getStatusMatch().equals("FINISHED"))
                .collect(Collectors.toList());
    }
}
