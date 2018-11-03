package pl.bookmaker.externalservice.demo.testService.facade.collection;

import lombok.Getter;
import lombok.Setter;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ApiFootballGameCollection {

    List<Game> finishedGames = new ArrayList<>();
    List<Game> allGames= new ArrayList<>();

}
