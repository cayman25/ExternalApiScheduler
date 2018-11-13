package pl.bookmaker.externalservice.demo.externalApi;


import org.junit.Assert;
import org.junit.Test;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApiFootballFilterGameTest {

  List<Game> listOfGame = Arrays.asList(
          new Game(1, new Competition(1, "test"), "2018-12-01", "12:00:00", "SCHEDULED", new Team(1, "testTeam"), new Team(2, "testTeam2"), null),
          new Game(2, new Competition(2, "test2"), "2018-12-01", "12:00:00", "IN_PLAY", new Team(1, "testTeam"), new Team(2, "testTeam2"), null),
          new Game(3, new Competition(3, "test3"), "2018-12-01", "12:00:00", "FINISHED", new Team(1, "testTeam"), new Team(2, "testTeam2"), "AWAY_TEAM"));

  ApiFootballFilterGame filter = new ApiFootballFilterGame();

  @Test
  public void shouldReturnSizeListEquals3() {
    Assert.assertEquals(2, filter.getAllNotFinishedGames(listOfGame).size());
  }

  @Test
  public void shouldReturnFinishedGameSize1() {
    Assert.assertEquals(1, filter.getFinishedGames(listOfGame).size());
  }

  @Test
  public void shouldContainOneFinishedGame() {
    List<Game> list = filter.getFinishedGames(listOfGame);
    list.stream().filter(game -> game.getStatusMatch().equals("FINISHED"))
            .collect(Collectors.toList());
    Assert.assertFalse(list.isEmpty());
    Assert.assertEquals(1, list.size());
  }

  @Test
  public void shouldContainTwoGameAndNoOneIsFinished() {
    List<Game> list = filter.getAllNotFinishedGames(listOfGame);
    list.stream().filter(game -> !game.getStatusMatch().equals("FINISHED"))
            .collect(Collectors.toList());
    Assert.assertFalse(list.isEmpty());
    Assert.assertEquals(2, list.size());
  }


}