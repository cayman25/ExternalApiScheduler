package pl.bookmaker.externalservice.demo.externalApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;
import pl.bookmaker.externalservice.demo.externalApi.facade.ApiFootballFacade;
import pl.bookmaker.externalservice.demo.externalApi.facade.collection.ApiFootballGameCollection;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

@Service
public class ApiFootballService implements Observer {

    private final GameRepository gameRepository;
    private final ApiFootballFacade apiFootballFacade;
    private final ApiFootballGameCollection apiFootballGameCollection;

    @Autowired
    public ApiFootballService(ApiFootballFacade apiFootballFacade, ApiFootballGameCollection apiFootballGameCollection, GameRepository gamerepository) {
        this.apiFootballFacade = apiFootballFacade;
        this.apiFootballGameCollection = apiFootballGameCollection;
        this.gameRepository=gamerepository;
        apiFootballGameCollection.register(this);
    }

   @Scheduled(cron = "0 */2 * * * *")
    public void updateCollectionGame(){
       System.out.println("Update Collection");
        apiFootballFacade.updateGameCollection();
    }

    @Scheduled(cron = "0 */3 * * * *")
    public void saveAllGameEntityOnePerDay(){
        System.out.println("Save All");
        saveAllGameEntity();
    }

//    @Scheduled(cron = "0 */5 * * * *")
    public void clearTemporaryGameEntityCollection(){
        System.out.println("Clear Collection");
        apiFootballGameCollection.clearTemporaryCollection();
        }

    public void saveAllGameEntity(){
        System.out.println("Saved All: " + apiFootballGameCollection.getAllGames().size() + " games");
        gameRepository.saveAll(apiFootballGameCollection.getAllGames());
    }

    public void saveFinishedGameEntity(){
        System.out.println("Saved Finished: " + apiFootballGameCollection.getFinishedGames().size() + " games");
        gameRepository.saveAll(apiFootballGameCollection.getFinishedGames());
    }

    @Override
    public void update() {
        System.out.println("Nowe ukończone mecze");
        saveFinishedGameEntity();
    }
}
