package pl.bookmaker.externalservice.demo.externalApi.FactoryMethodGame;

import pl.bookmaker.externalservice.demo.converters.DateParser;
import pl.bookmaker.externalservice.demo.externalApi.FactoryMethodGame.FactoryMethodGame;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FactoryFromMatchesExternalApi implements FactoryMethodGame {

    private List<Game> games;

    public FactoryFromMatchesExternalApi(List<MatchesExternalApi> matchesExternalApi){
        this.games =  matchesExternalApi.stream().flatMap(externalMatches ->
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

    @Override
    public List<Game> getGames() {
        return games;
    }
}
