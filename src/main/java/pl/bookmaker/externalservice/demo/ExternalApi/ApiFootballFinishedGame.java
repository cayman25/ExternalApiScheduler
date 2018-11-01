package pl.bookmaker.externalservice.demo.testService;

import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.List;

public class ApiFootballFinishedGame {

    List<Game> finishedGames = new ArrayList<>();

    public void getActualListOfGame (List<Game> list){
        if(!finishedGames.equals(list))
            this.finishedGames = list;
            ApiFootballService api = new ApiFootballService();
        else
            System.out.println("Lists are the same");
    }


}
