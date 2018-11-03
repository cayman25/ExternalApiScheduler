package pl.bookmaker.externalservice.demo.testService.service;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.testService.Observer;
import pl.bookmaker.externalservice.demo.testService.facade.ApiFootballFacade;
import pl.bookmaker.externalservice.demo.testService.facade.collection.ApiFootballGameCollection;

@Service
public class ApiFootballService implements Observer {

    private final ApiFootballFacade apiFootballFacade;
    private final ApiFootballGameCollection apiFootballGameCollection;

    @Autowired
    public ApiFootballService(ApiFootballFacade apiFootballFacade, ApiFootballGameCollection apiFootballGameCollection) {
        this.apiFootballFacade = apiFootballFacade;
        this.apiFootballGameCollection = apiFootballGameCollection;
        apiFootballGameCollection.register(this);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void updateCollectionGame(){
        apiFootballFacade.updateGameCollection();
    }

    @Override
    public void update() {
        System.out.println("Nowe ukończone mecze");
    }
}
