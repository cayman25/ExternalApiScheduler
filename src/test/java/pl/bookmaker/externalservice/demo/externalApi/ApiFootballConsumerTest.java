package pl.bookmaker.externalservice.demo.externalApi;


import org.junit.Test;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;

public class ApiFootballConsumerTest {

  List<String> invalidUrls = List.of("http://invalidurl");
  ApiFootballConsumer apiConsumer = new ApiFootballConsumer();

  //@Test(expected = org.springframework.web.client.ResourceAccessException.class) //very very slow, not unit
  public void restTemplateShouldReturnResourceAccessException() {
    apiConsumer.createMatchesExternalApi(invalidUrls);
  }

/*
  @Test
  public void restTemplateShouldReturn403(){
  }
*/

  @Test(expected = NullPointerException.class)
  public void listOfGameEntityShouldReturnNPE() {
    List<Game> list = apiConsumer.createListOfGameEntity(null);
  }

/*
  @Test
  public void listOfGameEntityShouldHaveValue(){
  }
*/

}
