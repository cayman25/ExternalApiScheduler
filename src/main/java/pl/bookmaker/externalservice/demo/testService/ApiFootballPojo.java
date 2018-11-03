package pl.bookmaker.externalservice.demo.testService;

import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 602866516a36c48a67921a27f401eeb264533225:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======
import org.springframework.boot.context.properties.bind.Bindable;
>>>>>>> parent of ffaced8... test:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> parent of 40c459c... test:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
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

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApiFootballPojo {

    private List<MatchesExternalApi> createMatchesExternalApi(List<String> urls) {

        List<MatchesExternalApi> listOfMatchesExternalApi = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", "bf5c0f84e2214a43978af5da8e98d878");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);

        urls.forEach(url -> {
                    ResponseEntity<MatchesExternalApi> matchesExternalApiResponseEntity = restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            entity,
                            MatchesExternalApi.class);
                    listOfMatchesExternalApi.add(matchesExternalApiResponseEntity.getBody());
                }
        );
        return listOfMatchesExternalApi;
    }

<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
    private List<Game> createListOfGameEntityListOfGameEntity(List<MatchesExternalApi> matchesExternalApi) { ////TO JEST DO POPRAWIENIA ŻEBY BYŁO ŁADNE
=======
    private List<Game> crateListOfGameEntity(List<MatchesExternalApi> matchesExternalApi) {
>>>>>>> 602866516a36c48a67921a27f401eeb264533225:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======
    private List<Game> crateListOfGameEntity(List<MatchesExternalApi> matchesExternalApi) { ////TO JEST DO POPRAWIENIA ŻEBY BYŁO ŁADNE
>>>>>>> parent of ffaced8... test:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======
    private List<Game> createListOfGameEntityListOfGameEntity(List<MatchesExternalApi> matchesExternalApi) { ////TO JEST DO POPRAWIENIA ŻEBY BYŁO ŁADNE
>>>>>>> parent of 40c459c... test:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
        List<Game> listOfGames = new ArrayList<>();
            matchesExternalApi.forEach(externalMatches -> {
                externalMatches.getMatches().forEach(p -> {
                        listOfGames.add(new Game(
                                p.getId(),
                                new Competition(externalMatches.getCompetition().getId(),
                                                externalMatches.getCompetition().getName()),
                                DateValidation.getDateFromJson(p.getUtcDate()),
                                DateValidation.getTimeFromJson(p.getUtcDate()),
                                p.getStatus(),
                                new Team(p.getHomeTeam().getId(), p.getHomeTeam().getName()),
                                new Team(p.getAwayTeam().getId(), p.getAwayTeam().getName()),
                                p.getScore().getWinner())
                        );
                }
                );
            }
            );
        return listOfGames;
    }
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java

    private void setFinishedAndOtherGamesEntity(List<Game> games){
        System.out.println(games.get(0).getStatusMatch());
        ApiFootballGameCollection collection = new ApiFootballGameCollection();
        collection.setFinishedGames(games.stream().filter(game -> game.getStatusMatch().equals("FINISHED")).collect(Collectors.toList()));
        collection.setAllGames(games.stream().filter(game -> !game.getStatusMatch().equals("FINISHED")).collect(Collectors.toList()));
    }

    public void setActualGame (List<String> urls){
        setFinishedAndOtherGamesEntity(createListOfGameEntityListOfGameEntity(createMatchesExternalApi(urls)));
    }
<<<<<<< HEAD:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======



>>>>>>> 602866516a36c48a67921a27f401eeb264533225:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======
>>>>>>> parent of ffaced8... test:src/main/java/pl/bookmaker/externalservice/demo/testService/ApiFootballPojo.java
=======
>>>>>>> parent of 40c459c... test:src/main/java/pl/bookmaker/externalservice/demo/ExternalApi/ApiFootballPojo.java
}