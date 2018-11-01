package pl.bookmaker.externalservice.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bookmaker.externalservice.demo.apiServices.DateValidation;
import pl.bookmaker.externalservice.demo.ExternalApi.ApiFootballJsonCollection;

import java.util.List;

@SpringBootTest
public class ApiFootballJsonCollectionTest {

    private String currentDate = DateValidation.getTodayWithAddOrSubstract(0);
    private String nextDate = DateValidation.getTodayWithAddOrSubstract(7);

    @Test
    public void listShouldNotBeEmpty(){
        ApiFootballJsonCollection jsonCollection = new ApiFootballJsonCollection();
        List<String> list = jsonCollection.createUrl();

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void listShouldHaveCorrectUrl(){

        final String VALID_URL="http://api.football-data.org/v2/competitions/2021/matches?dateFrom="+ currentDate + "&dateTo=" + nextDate;

        ApiFootballJsonCollection jsonCollection = new ApiFootballJsonCollection();
        String url = jsonCollection.createUrl().get(0);
        Assert.assertEquals(url, VALID_URL);
    }
}
