package pl.bookmaker.externalservice.demo.externalApi;


import org.junit.Assert;
import org.junit.Test;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApiFootballFilterGameTest {

  private List<Game> listOfGame = Arrays.asList(
          new Game(1, new Competition(1, "test"), "2018-12-01", "12:00:00", "SCHEDULED",
                  null, null, null),
          new Game(2, new Competition(2, "test2"), "2018-12-01", "12:00:00", "IN_PLAY",
                  null, null, null),
          new Game(3, new Competition(3, "test3"), "2018-12-01", "12:00:00", "FINISHED",
                  null, null, "AWAY_TEAM"),
          new Game(4, new Competition(3, "test3"), "2018-12-01", "12:00:00", "SCHEDULED",
                  null, null, "HOME_TEAM"));

  private ApiFootballFilterGame filter = new ApiFootballFilterGame();
  private List<Game> finishedGames = filter.getFinishedGames(listOfGame);
  private List<Game> notFinishedGames = filter.getAllNotFinishedGames(listOfGame);

  @Test
  public void shouldReturnSizeListEqualsFour() {
    Assert.assertEquals(4, listOfGame.size());
  }

  @Test
  public void shouldReturnOnlyFinishedAndNotEmptyWinnerGameAndSizeOne() {
    Assert.assertEquals(1, filter.getFinishedGames(listOfGame).size());
    Assert.assertFalse(finishedGames.stream().anyMatch(game -> !game.getStatusMatch().equals("FINISHED")));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrownNpeExceptionWhenAddNull(){
    filter.getFinishedGames(null);
  }

  @Test
  public void shouldReturnOnlyNotFinishedGames(){
    Assert.assertFalse(notFinishedGames.stream().anyMatch(game -> game.getStatusMatch().equals("FINISHED")));
  }

  @Test
  public void shouldReturnThreeNotFinishedGames(){
    Assert.assertEquals(3,notFinishedGames.size());
  }

  @Test(expected = NullPointerException.class)
  public void shouldReturnNpeExceptionWhenAddNull(){
    filter.getAllNotFinishedGames(null);
  }

}