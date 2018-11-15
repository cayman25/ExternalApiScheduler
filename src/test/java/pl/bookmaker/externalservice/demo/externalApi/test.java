package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bookmaker.externalservice.demo.externalApi.FactoryMethodGame.FactoryFromMatchesExternalApi;
import pl.bookmaker.externalservice.demo.externalApi.FactoryMethodGame.FactoryMethodImplementation;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.externalApi.MatchesExternalApi;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.List;

import static org.mockito.Mockito.mock;

public class test {

    @Autowired
    ApiFootballFacade facade;

    @Test
    public void test(){
        FactoryMethodImplementation factory = new FactoryMethodImplementation();
        List<String> list = List.of("a","b","s");
        factory.getGame(list);

    }

}
