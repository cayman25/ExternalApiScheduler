package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Test;
import org.mockito.Mock;

public class ApiFootballFacadeTest {


  ApiFootballGameCollection apiFootballGameCollection;

  @Mock
  ApiFootballConsumer apiFootballConsumer;
  @Mock
  ApiFootballUrls apiFootballUrls;

  ApiFootballFacade api = new ApiFootballFacade(apiFootballGameCollection,apiFootballConsumer,apiFootballUrls);

  @Test
  public void checkMethod(){

  }

}
