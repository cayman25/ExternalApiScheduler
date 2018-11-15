package pl.bookmaker.externalservice.demo.externalApi;

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

import java.util.List;
import java.util.stream.Collectors;

class ApiFootballJsonConsumer {

    List<Game> getGames(List<String> urls, String apiToken) {
        HttpEntity<String> httpEntity = createHttpEntityWithHeader(apiToken);
        RestTemplate restTemplate = createRestTemplateWithConverter();
        return createListOfGameEntity(getMatches(urls, httpEntity, restTemplate));
    }

    HttpEntity<String> createHttpEntityWithHeader(String apiToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiToken);
        return new HttpEntity<>("parameters", headers);
    }

    RestTemplate createRestTemplateWithConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }

    List<MatchesExternalApi> getMatches(List<String> urls, HttpEntity<String> entity, RestTemplate restTemplate) {
        return urls.stream()
                .map(url -> {
                    ResponseEntity<MatchesExternalApi> matchesExternalApiResponseEntity = restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            entity,
                            MatchesExternalApi.class);
                    return matchesExternalApiResponseEntity.getBody();
                })
                .collect(Collectors.toList());
    }

    List<Game> createListOfGameEntity(List<MatchesExternalApi> matchesExternalApi) {
        return matchesExternalApi.stream().flatMap(externalMatches ->
                externalMatches.getMatches().stream().map(p ->
                        (new Game(
                                p.getId(),
                                new Competition(externalMatches.getCompetition().getId(),
                                        externalMatches.getCompetition().getName()),
                                DateParser.getDateFromJson(p.getUtcDate()),
                                DateParser.getTimeFromJson(p.getUtcDate()),
                                p.getStatus(),
                                new Team(p.getHomeTeam().getId(), p.getHomeTeam().getName()),
                                new Team(p.getAwayTeam().getId(), p.getAwayTeam().getName()),
                                p.getScore().getWinner())))).
                collect(Collectors.toList());
    }
}