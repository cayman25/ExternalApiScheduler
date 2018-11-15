package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.converters.DateParser;

import java.util.*;
import java.util.stream.Collectors;

@Component
class ApiFootballUrls {

    @Value("${api.url}")
    String url;

    List<String> createListUrl() {
        HashMap<Integer,String> leagues = createLeagueObjects();

        return leagues.entrySet().stream().map(p ->
                        url + p.getKey() + "/matches?" +
                            "dateFrom="+ DateParser.getTodayWithAddOrSubstractionOfDay(-1) +
                            "&dateTo=" + DateParser.getTodayWithAddOrSubstractionOfDay(14))
                        .collect(Collectors.toList());
    }

    HashMap<Integer, String> createLeagueObjects() {
        return new HashMap<>(Map.ofEntries
                (Map.entry(2021, "England: Premier League"),
                (Map.entry(2016, "England: Championship")),
                (Map.entry(2015, "France: Ligue 1")),
                (Map.entry(2002, "Germany: Bundesliga")),
                (Map.entry(2019, "Italy: Serie A")),
                (Map.entry(2014, "Spain: Primera Division")),
                (Map.entry(2001, "Europe: UEFA Champions League"))));
    }
}
