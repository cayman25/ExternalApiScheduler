package pl.bookmaker.externalscheduler.demo.externalApi.Games;

import pl.bookmaker.externalscheduler.demo.externalApi.interfaces.GamesStrategy;
import pl.bookmaker.externalscheduler.demo.models.entity.Game;

import java.util.List;
import java.util.stream.Collectors;

public class FinishedGames implements GamesStrategy {

  @Override
  public List<Game> getList(List<Game> list) {
    return list.stream()
            .filter(game -> game.getStatusMatch().equals("FINISHED") &&
                    !game.getWinner().isEmpty())
            .collect(Collectors.toList());
  }
}
