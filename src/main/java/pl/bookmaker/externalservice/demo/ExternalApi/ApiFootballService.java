package pl.bookmaker.externalservice.demo.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.List;

public class ApiFootballService {

    private final GameRepository gameRepository;

    @Autowired
    private ApiFootballService(GameRepository gameRepository){
        this.gameRepository=gameRepository;
    }

    public void updateFinishedGames(List<Game> list){
        gameRepository.saveAll(list);
    }



}
