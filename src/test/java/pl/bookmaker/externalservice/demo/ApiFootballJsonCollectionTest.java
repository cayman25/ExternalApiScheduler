package pl.bookmaker.externalservice.demo;

import pl.bookmaker.externalservice.demo.apiServices.DateParser;


public class ApiFootballJsonCollectionTest {

    private String currentDate = DateParser.getTodayWithAddOrSubstraction(0);
    private String nextDate = DateParser.getTodayWithAddOrSubstraction(14);

/*    @Test
    public void listShouldNotBeEmpty(){
        ApiFootballJsonCollection jsonCollection = new ApiFootballJsonCollection();
        List<String> list = jsonCollection.createListUrl();

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void listShouldHaveCorrectUrl(){

        final String  VALID_URL="http://api.football-data.org/v2/competitions/2021/matches?dateFrom="+ currentDate + "&dateTo=" + nextDate;

        ApiFootballJsonCollection jsonCollection = new ApiFootballJsonCollection();
        String url = jsonCollection.createListUrl().get(0);
        Assert.assertEquals(url, VALID_URL);
    }*/
}
