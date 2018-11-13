package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bookmaker.externalservice.demo.converters.DateParser;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
public class ApiFootballUrlsTest {

  ApiFootballUrls url = new ApiFootballUrls();
  HashMap list = url.createLeagueObjects();
  List<String> urls = url.createListUrl();

  String englandUrl = url.url + "2021" + "/matches?" +
          "dateFrom=" + DateParser.getTodayWithAddOrSubstractionOfDay(-0) +
          "&dateTo=" + DateParser.getTodayWithAddOrSubstractionOfDay(7);

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
    Assert.assertTrue(list.containsKey(2016));
  }

  @Test
  public void listUrlsShouldHaveSevenValues() {
    Assert.assertEquals(7, urls.size());
  }

  @Test
  public void listUrlsShouldStartFromEngland() {
    Assert.assertEquals(urls.get(0), englandUrl);
  }

  @Test
  public void listUrlsShouldStartFromCorrectUrl() {
    Assert.assertEquals(urls.get(0), englandUrl);
  }

  @Test
  public void listUrlsShouldNotBeEmpty() {
    Assert.assertFalse(urls.isEmpty());
  }

}
