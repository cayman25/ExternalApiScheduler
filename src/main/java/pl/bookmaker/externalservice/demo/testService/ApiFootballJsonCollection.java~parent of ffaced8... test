package pl.bookmaker.externalservice.demo.testService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ArrayReferenceType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import pl.bookmaker.externalservice.demo.apiServices.DateValidation;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;
import pl.bookmaker.externalservice.demo.models.externalApi.Matches;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ApiFootballJsonCollection {

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

    public List<String> createUrl() {
        List<String> urls = new ArrayList<String>();

        LinkedHashMap<Integer,String> leagues = createLeagueObjects();
        leagues.forEach( (K,V) -> {
            urls.add("http://api.football-data.org/v2/competitions/" + K + "/matches?" +
                    "dateFrom="+ DateValidation.getTodayWithAddOrSubstract(0) +
                    "&dateTo=" + DateValidation.getTodayWithAddOrSubstract(14));
        });
            return urls;
    }



    public void updateAllGames (List<Game> list){

    }

    public void updateOnlyFinishedGames(List<Game> list){

    }


}
