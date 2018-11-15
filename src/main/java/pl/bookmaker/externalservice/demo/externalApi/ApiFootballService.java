package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

@Service
class ApiFootballService implements Observer {

    private GameRepository gameRepository;

    @Autowired
    private ApiFootballGameCollection apiFootballGameCollection;

    private final ApiFootballConfiguration configuration = new ApiFootballConfiguration();
    private final ApiFootballFacade apiFootballFacade = configuration.apiFootballFacade(gameRepository);

    ApiFootballService() {
        this.apiFootballGameCollection = new ApiFootballGameCollection();
        this.apiFootballGameCollection.register(this);
    }

   @Scheduled(cron = "*/30 * * * * *")
    void updateCollectionGame(){
      apiFootballGameCollection.register(this);
       System.out.println("Update Collection");
        apiFootballFacade.updateGameCollection();
    }

    @Scheduled(cron = "0 0 1 * * *")
    void saveAllGameEntityOnePerDay(){
        System.out.println("Save All");
        saveAllGameEntity();
    }

    @Scheduled(cron = "0 30 1 * * *")
    void clearTemporaryGameEntityCollection(){
        System.out.println("Clear Collection");
        apiFootballGameCollection.clearTemporaryCollection();
    }

    private void saveAllGameEntity(){
        System.out.println("Saved All: " + apiFootballGameCollection.getAllGames().size() + " games");
        gameRepository.saveAll(apiFootballGameCollection.getAllGames());
    }

    private void saveFinishedGameEntity(){
        System.out.println("Saved Finished: " + apiFootballGameCollection.getFinishedGames().size() + " games");
        gameRepository.saveAll(apiFootballGameCollection.getNotSavedFinishedGames());
    }

    @Override
    public void update() {
        System.out.println("New finished game, save action needed");
        saveFinishedGameEntity();
    }
}
