package pl.bookmaker.externalservice.demo.externalApi;

import org.assertj.core.internal.Urls;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pl.bookmaker.externalservice.demo.models.entity.Competition;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ApiFootballFacadeTest {

    private InMemoryGameRepository inMemoryGameRepository = new InMemoryGameRepository();
    private ApiFootballConfiguration configuration = new ApiFootballConfiguration();
    private ApiFootballFacade facade = configuration.apiFootballFacade(inMemoryGameRepository);

    private List<Game> games = new ArrayList<>(Arrays.asList(new Game(2, new Competition(2, "test2"), "2018-12-01", "12:00:00", "FINISHED", null, null, "DRAW"),
                                                    (new Game(1, new Competition(2, "test2"), "2018-12-01", "12:00:00", "FINISHED", null, null, "AWAY_TEAM"))));

    private List<String> urls = new ArrayList<>(Arrays.asList("1","2"));

    @Mock
    ApiFootballGamesCollections collections;

    @Mock
    ApiFootballJsonConsumer consumer;


    @Test
    public void test() {
        //ArgumentCaptor valueCapture = ArgumentCaptor.forClass(String.class);
        when(consumer.getGames(any(),anyString())).thenReturn(games);
        //doNothing().when(collections).setFinishedGames(anyList());
        //verify(collections,times(0));
        //doNothing().when(consumer).getGames(anyList(),valueCapture.capture());
        //facade.updateGameCollection();
        //System.out.println(valueCapture.getValue());
        //doNothing().when(consumer).getGames(anyList(),anyString()).;

        Assert.assertEquals(games,consumer.getGames(null,"123"));
    }
}
