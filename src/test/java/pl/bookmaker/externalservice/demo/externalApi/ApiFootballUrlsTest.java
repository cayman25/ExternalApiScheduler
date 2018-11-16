package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bookmaker.externalservice.demo.converters.DateParser;

import java.util.HashMap;
import java.util.List;

public class ApiFootballUrlsTest {

  private ApiFootballUrls url = new ApiFootballUrls();
  private HashMap list = url.createLeagueObjects();
  private List<String> urls = url.createListUrl("test");

  @Test
  public void mapShouldNotBeNull() {
    Assert.assertNotNull(list);
  }

  @Test
  public void mapShouldContainPremierLeague() {
    Assert.assertTrue(list.containsValue("England: Premier League"));
  }

  @Test
  public void mapShouldHaveEightValues() {
    Assert.assertEquals(7, list.size());
  }

  @Test
  public void mapShouldHaveKeyValue() {
    Assert.assertTrue(list.containsKey(2021));
  }

  @Test
  public void listUrlsShouldHaveSevenValues() {
    Assert.assertEquals(7, urls.size());
  }

  @Test
  public void listUrlsShouldNotBeEmpty() {
    Assert.assertFalse(urls.isEmpty());
  }
}

