package pl.bookmaker.externalservice.demo.ExternalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ApiFootballService{

    @Autowired
    private GameRepository gameRepository;

/*
    @Autowired
    public ApiFootballService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
*/

    @Scheduled(cron = "*/30 * * * * *")
    public void setActualGameEntityInCollection(){
        final ApiFootballFacade facade = new ApiFootballFacade();
        facade.setActualGameEntityInCollection();
    }

    private void saveFinishedGame(){
        ApiFootballFacade facade = new ApiFootballFacade();
        List <Game> finished = facade.getFinishedGames();
        System.out.println(finished.size());
       // gameRepository.saveAll(facade.getFinishedGames());
    }

    public void update() {
        System.out.println("New Finished Game");
        saveFinishedGame();
    }
}
