package pl.bookmaker.externalservice.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@ContextConfiguration
@TestPropertySource("classpath:api.properties")
@Component
public class properties {


  private static String test;

  @Value("${test.test}")
  public void setDirectory(String value) {
    this.test = value;
  }

  @Test
  public void test (){
    System.out.println(test);
  }

}
