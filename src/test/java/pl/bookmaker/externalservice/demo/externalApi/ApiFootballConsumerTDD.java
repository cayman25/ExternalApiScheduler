package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiFootballConsumerTDD {

  ApiFootballConsumer consumer =new ApiFootballConsumer();

  @Test
  public void shouldGetUrl(){
    ApiFootballUrls url = new ApiFootballUrls();
    List<String> list = url.createListUrl();
    Assert.assertFalse(list.isEmpty());
  }

  @Test
  public void setHeaderHttpEntityShouldNotBeNull(){
    HttpEntity<String> entity = consumer.setHeaderOfHttpEntity();
    Assert.assertNotNull(entity.getHeaders());
  }

  @Test
  public void restTemplateShouldHaveConverter(){
    RestTemplate restTemplate = new RestTemplate();
    restTemplate = consumer.setConverter(restTemplate);
  }

  @Test
  public void restTemplateShouldExchangeUrlToMatchesExternalApi(){
    ResponseEntity
  }
}
