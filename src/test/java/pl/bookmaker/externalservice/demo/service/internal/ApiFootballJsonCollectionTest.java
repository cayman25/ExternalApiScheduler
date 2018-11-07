/*
package pl.bookmaker.externalservice.demo.service.internal;

import org.junit.Assert;
import org.junit.Test;
import pl.bookmaker.externalservice.demo.converters.DateParser;
import pl.bookmaker.externalservice.demo.externalApi.facade.internal.ApiFootballUrls;


public class ApiFootballJsonCollectionTest {

    private String currentDate = DateParser.getTodayWithAddOrSubstraction(-5);
    private String nextDate = DateParser.getTodayWithAddOrSubstraction(1);
    ApiFootballUrls urls= new ApiFootballUrls();

    @Test
    public void listShouldNotBeEmpty(){
        Assert.assertFalse(urls.createListUrl().isEmpty());
    }

    @Test
    public void listShouldHaveCorrectUrl(){
        final String  VALID_URL="http://api.football-data.org/v2/competitions/2021/matches?dateFrom="+ currentDate + "&dateTo=" + nextDate;
        Assert.assertEquals(urls.createListUrl().get(0), VALID_URL);
    }


}
*/
