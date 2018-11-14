package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Test;
import org.mockito.Mock;

public class ApiFootballFacadeTest {


  ApiFootballGameCollection apiFootballGameCollection;

  @Mock
  ApiFootballJsonConsumer apiFootballJsonConsumer;
  @Mock
  ApiFootballUrls apiFootballUrls;

  ApiFootballFacade api = new ApiFootballFacade(apiFootballGameCollection, apiFootballJsonConsumer,apiFootballUrls);

  @Test
  public void checkMethod(){

  }

}
