package pl.bookmaker.externalservice.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.models.entity.Team;
import pl.bookmaker.externalservice.demo.testService.facade.collection.ApiFootballGameCollection;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class test {

    @Test
    public void test() {


        ApiFootballGameCollection apiFootballGameCollection = new ApiFootballGameCollection();
        List<Game> finished = new ArrayList<>();

        finished.add(new Game(12,
                            new Competition(1,
                                    "test"),
                "a",
                "a",
                "a",
                new Team(1,"test"),
                new Team(2,"test2"),
                "HOME_TEAM"));
        apiFootballGameCollection.setFinishedGames(finished);
    }
}
