package pl.bookmaker.externalservice.demo.externalApi.facade.internal;

import pl.bookmaker.externalservice.demo.converters.DateParser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ApiFootballUrls {

    private LinkedHashMap<Integer, String> createLeagueObjects() {
        LinkedHashMap<Integer, String> listOfAvailableLeagues = new LinkedHashMap<Integer, String>();
        listOfAvailableLeagues.put(2021, "England: Premier League");
        listOfAvailableLeagues.put(2016, "England: Championship");
        listOfAvailableLeagues.put(2015, "France: Ligue 1");
        listOfAvailableLeagues.put(2002, "Germany: Bundesliga");
        listOfAvailableLeagues.put(2019, "Italy: Serie A");
        listOfAvailableLeagues.put(2014, "Spain: Primera Division");
        listOfAvailableLeagues.put(2001, "Europe: UEFA Champions League");
        return listOfAvailableLeagues;
    }

    public List<String> createListUrl() {
        List<String> urls = new ArrayList<String>();

        LinkedHashMap<Integer,String> leagues = createLeagueObjects();
        leagues.forEach( (K,V) -> {
            urls.add("http://api.football-data.org/v2/competitions/" + K + "/matches?" +
                    "dateFrom="+ DateParser.getTodayWithAddOrSubstraction(0) +
                    "&dateTo=" + DateParser.getTodayWithAddOrSubstraction(2));
        });
            return urls;
    }

}
