package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.converters.DateParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
class ApiFootballUrls {

    @Value("${api.url}")
    String url;

    /*List<String> createListUrl() {
        List<String> urls = new ArrayList<String>();

        HashMap<Integer,String> leagues = createLeagueObjects();
        leagues.forEach( (K,V) -> {
            urls.add(url + K + "/matches?" +
                    "dateFrom="+ DateParser.getTodayWithAddOrSubstractionOfDay(-10) +
                    "&dateTo=" + DateParser.getTodayWithAddOrSubstractionOfDay(14));
        });
        return urls;
    }*/

    List<String> createListUrl() {
        HashMap<Integer,String> leagues = createLeagueObjects();

        return leagues.entrySet().stream().map(p ->
                        url + p.getKey() + "/matches?" +
                            "dateFrom="+ DateParser.getTodayWithAddOrSubstractionOfDay(-10) +
                            "&dateTo=" + DateParser.getTodayWithAddOrSubstractionOfDay(14))
                        .collect(Collectors.toList());
    }

    LinkedHashMap<Integer, String> createLeagueObjects() {
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

}
