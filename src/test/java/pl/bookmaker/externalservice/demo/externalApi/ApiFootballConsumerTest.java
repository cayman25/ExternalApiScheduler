package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

import java.util.List;

public class ApiFootballConsumerTest {

  private ApiFootballConsumer consumer =new ApiFootballConsumer();
  private HttpEntity<String> entity = consumer.createHttpEntityAndSetHeader();
//  private RestTemplate restTemplate = new RestTemplate();

  @Test
  public void headerHttpEntityShouldNotBeNull(){
    Assert.assertNotNull(entity.getHeaders());
  }

  @Test
  public void headerHttpEntityShouldHaveCorrectXAuthToken(){
    Assert.assertTrue(entity.getHeaders().toString().contains("X-Auth-Token"));
  }

  @Test
  public void headerHttpEntityShouldHaveBody() {
    Assert.assertTrue(entity.hasBody());
  }

  @Test
  public void headersHttpEntityShouldHaveParametersInBody(){
    Assert.assertTrue(entity.getBody().contains("parameters"));
  }

}
