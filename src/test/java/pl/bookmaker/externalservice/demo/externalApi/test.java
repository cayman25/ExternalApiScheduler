package pl.bookmaker.externalservice.demo.externalApi;

import org.junit.Test;
import org.mockito.Mockito;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import static org.mockito.Mockito.mock;

public class test {
    GameRepository gameRepository = mock(GameRepository.class);
    ApiFootballConfiguration configuration = new ApiFootballConfiguration();
    ApiFootballFacade facade = configuration.apiFootballFacade(gameRepository);

    @Test
    public void test(){
        facade.updateCollectionGame();
    }
}
