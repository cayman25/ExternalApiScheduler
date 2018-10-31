package pl.bookmaker.externalservice.demo.testService;

import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;
import java.util.stream.Collectors;

public class ApiFootballFilter {

    public void filterGame(List<Game> listOfGameEntity){
        List<Game> finished =listOfGameEntity.stream().filter(game ->
                 game.getStatusMatch().equals("FINISHED")).collect(Collectors.toList());

        List<Game> other =listOfGameEntity.stream().filter(game ->
                !game.getStatusMatch().equals("FINISHED")).collect(Collectors.toList());


    }
}
