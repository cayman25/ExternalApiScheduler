package pl.bookmaker.externalservice.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bookmaker.externalservice.demo.apiServices.DateValidation;
<<<<<<< HEAD
import pl.bookmaker.externalservice.demo.ExternalApi.ApiFootballJsonCollection;
=======
import pl.bookmaker.externalservice.demo.testService.ApiFootballUrlToGetJsonCollection;
>>>>>>> 602866516a36c48a67921a27f401eeb264533225

import java.util.List;

@SpringBootTest
public class ApiFootballJsonCollectionTest {

    private String currentDate = DateValidation.getTodayWithAddOrSubstract(0);
    private String nextDate = DateValidation.getTodayWithAddOrSubstract(7);

    @Test
    public void listShouldNotBeEmpty(){
        ApiFootballUrlToGetJsonCollection jsonCollection = new ApiFootballUrlToGetJsonCollection();
        List<String> list = jsonCollection.createUrl();

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void listShouldHaveCorrectUrl(){

        final String VALID_URL="http://api.football-data.org/v2/competitions/2021/matches?dateFrom="+ currentDate + "&dateTo=" + nextDate;

        ApiFootballUrlToGetJsonCollection jsonCollection = new ApiFootballUrlToGetJsonCollection();
        String url = jsonCollection.createUrl().get(0);
        Assert.assertEquals(url, VALID_URL);
    }
}
