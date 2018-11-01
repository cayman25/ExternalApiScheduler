package pl.bookmaker.externalservice.demo.apiServices;

import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;
import java.util.*;

public class ExternalApiFacade {

    private FilterMatches filter = new FilterMatches();

    private HashMap<Integer, String> createLeagueObjects() {
        HashMap<Integer, String> listOfAvailableLeagues = new HashMap<Integer, String>();
        listOfAvailableLeagues.put(2021, "England: Premier League");
        listOfAvailableLeagues.put(2016, "England: Championship");
        listOfAvailableLeagues.put(2015, "France: Ligue 1");
        // listOfAvailableLeagues.put(2002, "Germany: Bundesliga");
        // listOfAvailableLeagues.put(2019, "Italy: Serie A");
        listOfAvailableLeagues.put(2014, "Spain: Primera Division");
        //  listOfAvailableLeagues.put(2001, "Europe: UEFA Champions League");
        return listOfAvailableLeagues;
    }


    public List<Game> getOnlyFinishedGames() {
        HashMap<Integer, String> listOfLeagues = createLeagueObjects();
        List<Game> list = new ArrayList<>();

       for (int key : listOfLeagues.keySet()) {
           GettingObjectsFromApi gettingObjectsFromApi = new GettingObjectsFromApi();
           MatchesExternalApi matches = gettingObjectsFromApi.createMatchesExternalApi(key);
           list.addAll(filter.getOnlyFinishedMatches(matches));
       }
            return list;
    }

    public List<Game> getOtherGames() {
        HashMap<Integer, String> listOfLeagues = createLeagueObjects();
        List<Game> list = new ArrayList<>();

        for (int key : listOfLeagues.keySet()) {
            GettingObjectsFromApi gettingObjectsFromApi = new GettingObjectsFromApi();
            MatchesExternalApi matches = gettingObjectsFromApi.createMatchesExternalApi(key);
            list.addAll(filter.getScheduledAndOtherMatches(matches));
        }
            return list;
    }
}



