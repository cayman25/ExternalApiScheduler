package pl.bookmaker.externalservice.demo.externalApi.FactoryMethodGame;

import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.externalApi.Matches;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class FactoryMethodImplementation {

    public List<Game> getGame(List list) {

        if(list.size()==0)
            System.out.println("Empty List");

        else if (list.get(0) instanceof MatchesExternalApi)
            return new FactoryFromMatchesExternalApi(list).getGames();

        return null;
            }
}