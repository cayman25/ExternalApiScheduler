package pl.bookmaker.externalservice.demo.externalApi.facade.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import pl.bookmaker.externalservice.demo.converters.DateParser;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

import java.util.ArrayList;
import java.util.List;

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

    private List<Game> createListOfGameEntity(List<MatchesExternalApi> matchesExternalApi) {
        List<Game> listOfGames = new ArrayList<>();
            matchesExternalApi.forEach(externalMatches -> {
                externalMatches.getMatches().forEach(p -> {
                        listOfGames.add(new Game(
                                p.getId(),
                                new Competition(externalMatches.getCompetition().getId(),
                                                externalMatches.getCompetition().getName()),
                                DateParser.getDateFromJson(p.getUtcDate()),
                                DateParser.getTimeFromJson(p.getUtcDate()),
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
    
    public List<Game> getGameEntityCollection(List<String> urls){
        return createListOfGameEntity(createMatchesExternalApi(urls));
    }
}