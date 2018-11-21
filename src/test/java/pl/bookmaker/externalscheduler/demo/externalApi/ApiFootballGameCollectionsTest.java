package pl.bookmaker.externalscheduler.demo.externalApi;

import org.junit.Assert;
import org.junit.Test;
import pl.bookmaker.externalscheduler.demo.models.entity.Competition;
import pl.bookmaker.externalscheduler.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.Arrays;

public class ApiFootballGameCollectionsTest {

  ApiFootballGamesCollections collections = new ApiFootballGamesCollections();

  private ArrayList<Game> listOfTwoFinishedGames = new ArrayList<>(Arrays.asList(
          new Game(1, new Competition(1, "test"), "2018-12-01", "12:00:00", "FINISHED",null, null, "HOME_TEAM"),
          new Game(2, new Competition(2, "test2"), "2018-12-01", "12:00:00", "FINISHED",null, null, "DRAW")));

  private ArrayList<Game> listOfThreeFinishedGames= new ArrayList<>(Arrays.asList(
          new Game(1, new Competition(1, "test"), "2018-12-01", "12:00:00", "FINISHED",null, null, "HOME_TEAM"),
          new Game(2, new Competition(2, "test2"), "2018-12-01", "12:00:00", "FINISHED",null, null, "DRAW"),
          new Game(3, new Competition(2, "test2"), "2018-12-01", "12:00:00", "FINISHED",null, null, "AWAY_TEAM")));

  private ArrayList<Game> emptyList = new ArrayList<>();

  @Test
  public void shouldReturnSizeEquals2NotFinishedGamesList(){
    collections.setNotSavedFinishedGames(listOfTwoFinishedGames);
    Assert.assertEquals(2,collections.getNotSavedFinishedGames().size());
  }

  @Test
  public void shouldReturnSizeEqualsThreeFinishedGames(){
    collections.setFinishedAndUpdateNotSavedGames(listOfThreeFinishedGames);
    Assert.assertEquals(3,collections.getFinishedGames().size());
  }

  @Test
  public void shouldReturnSizeEqualsOneNotSavedFinishedGames(){
    collections.setFinishedAndUpdateNotSavedGames(listOfTwoFinishedGames);
    collections.setFinishedAndUpdateNotSavedGames(listOfThreeFinishedGames);
    Assert.assertEquals(3,collections.getFinishedGames().size());
    Assert.assertEquals(1, collections.getNotSavedFinishedGames().size());
  }

  @Test
  public void shouldReturnSizeTwoInFinishedGames(){
    collections.setFinishedAndUpdateNotSavedGames(listOfTwoFinishedGames);
    Assert.assertEquals(2, collections.getNotSavedFinishedGames().size());
    Assert.assertEquals(2,collections.getFinishedGames().size());
    collections.setFinishedAndUpdateNotSavedGames(listOfTwoFinishedGames);
    Assert.assertEquals(2, collections.getNotSavedFinishedGames().size());
    Assert.assertEquals(2,collections.getFinishedGames().size());
  }

  @Test
  public void shouldReturnSizeEqualsZero(){
    collections.setFinishedAndUpdateNotSavedGames(emptyList);
    Assert.assertEquals(0,collections.getFinishedGames().size());
  }

  @Test
  public void shouldReturnMessageAndSizeEqualsTwo(){
    collections.setFinishedAndUpdateNotSavedGames(listOfTwoFinishedGames);
    Assert.assertEquals(2,listOfTwoFinishedGames.size());
    collections.setFinishedAndUpdateNotSavedGames(emptyList);
    Assert.assertEquals(2,listOfTwoFinishedGames.size());
  }

  @Test
  public void shouldFinishedGamesAndAllGamesSizeEqualsZeroAfterClear(){
    collections.setFinishedAndUpdateNotSavedGames(listOfTwoFinishedGames);
    collections.setAllGames(listOfThreeFinishedGames);
    collections.clearTemporaryCollections();
    Assert.assertEquals(0,collections.getFinishedGames().size());
    Assert.assertEquals(0,collections.getAllGames().size());
  }
}
