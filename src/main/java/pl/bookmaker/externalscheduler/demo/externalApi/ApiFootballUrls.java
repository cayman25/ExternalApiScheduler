package pl.bookmaker.externalscheduler.demo.externalApi;

import pl.bookmaker.externalscheduler.demo.converters.DateParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ApiFootballUrls {

    List<String> createListUrl(String url) {
        HashMap<Integer, String> leagues = createLeagueObjects();

        return leagues.entrySet().stream().map(p ->
                url + p.getKey() + "/matches?" +
                        "dateFrom=" + DateParser.getTodayWithAddOrSubstractDay(-5) +
                        "&dateTo=" + DateParser.getTodayWithAddOrSubstractDay(14))
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
