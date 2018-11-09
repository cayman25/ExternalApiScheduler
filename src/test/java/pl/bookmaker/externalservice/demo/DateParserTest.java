package pl.bookmaker.externalservice.demo;

import org.junit.Assert;
import org.junit.Test;
import pl.bookmaker.externalservice.demo.converters.DateParser;

public class DateParserTest {

  @Test
  public void shouldReturnCurrentDate(){
    Assert.assertEquals("2018-11-09", DateParser.getToday());
  }

  @Test
  public void shouldReturnCurrentTime(){
    System.out.println(DateParser.getTodayWithAddOrSubstractionOfDay(2));
  }
}
