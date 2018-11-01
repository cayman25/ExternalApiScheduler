package pl.bookmaker.externalservice.demo;

import pl.bookmaker.externalservice.demo.ExternalApi.ApiFootballPojo;

//@SpringBootTest
public class ApiFootballPojoTest {

    final String EXAMPLE_URL = "http://api.football-data.org/v2/competitions/2021/matches?dateFrom=2018-10-20&dateTo=2018-10-21";

   // @Test
    public void matchesExternalShouldNotBeEmpty(){
        ApiFootballPojo pojo = new ApiFootballPojo();
      //  List<MatchesExternalApi> matches = pojo.(EXAMPLE_URL);
     //  Assert.assertFalse(matches.isEmpty());
    }

}
