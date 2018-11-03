package pl.bookmaker.externalservice.demo.apiServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.List;

@Service
public class ApiServicesImplementation implements ApiServices{

    private final GameRepository gameRepository;

    @Autowired
    private ApiServicesImplementation(GameRepository gameRepository){
        this.gameRepository=gameRepository;
    }

    @Override
    @Scheduled(cron = "0 */5 * * * *") //getting all information about match from today to next 7 days
    public void updateFinishedGames() {
        System.out.println("wszystkie mecze");
        ExternalApiFacade facade = new ExternalApiFacade();
        List<Game> list  = facade.getOnlyFinishedGames();
        gameRepository.saveAll(list);
    }

    @Override
    @Scheduled(cron = "0 0 */1 * * *")
    public void insertGames() {
        System.out.println("insert All");
        ExternalApiFacade facade = new ExternalApiFacade();
        List <Game> games = facade.getOtherGames();
        gameRepository.saveAll(games);
    }


}
