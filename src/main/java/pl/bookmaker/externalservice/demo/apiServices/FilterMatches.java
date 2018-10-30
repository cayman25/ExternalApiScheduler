package pl.bookmaker.externalservice.demo.apiServices;

import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;
import pl.bookmaker.externalservice.demo.models.externalApi.Matches;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

import java.util.List;
import java.util.stream.Collectors;

public class FilterMatches {

    public List<Game> getOnlyFinishedMatches(MatchesExternalApi matchesExternalApi){
        List<Matches> matchesFiltered = matchesExternalApi.getMatches().stream().filter(match ->
                match.getStatus().equals("FINISHED")).collect(Collectors.toList());
        Competition competition = new Competition(
                matchesExternalApi.getCompetition().getId(),
                matchesExternalApi.getCompetition().getName());
        List<Game> games = createGameEntity(matchesFiltered, competition);
        //games.forEach(game -> game.setVerifiedStatus(false));
        return games;
    }

    public List<Game> getScheduledAndOtherMatches(MatchesExternalApi matchesExternalApi){
        List<Matches> matchesFiltered = matchesExternalApi.getMatches().stream().
                filter(match -> !match.getStatus().equals("FINISHED")).collect(Collectors.toList());
        Competition competition = new Competition(
                matchesExternalApi.getCompetition().getId(),
                matchesExternalApi.getCompetition().getName());
        List<Game> games = createGameEntity(matchesFiltered, competition);
        return games;
    }

    private List<Game> createGameEntity(List<Matches> matchesFiltered, Competition competition) {
        return matchesFiltered.stream()
                .map(p->
                        new Game(
                                p.getId(),
                                competition,
                                DateValidation.getDateFromJson(p.getUtcDate()),
                                DateValidation.getTimeFromJson(p.getUtcDate()),
                                p.getStatus(),
                                new Team(p.getHomeTeam().getId(), p.getHomeTeam().getName()),
                                new Team(p.getAwayTeam().getId(), p.getAwayTeam().getName()),
                                p.getScore().getWinner()))
                .collect(Collectors.toList());
    }
}
