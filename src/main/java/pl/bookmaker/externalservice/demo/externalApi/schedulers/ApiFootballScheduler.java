package pl.bookmaker.externalservice.demo.externalApi.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.externalApi.ApiFootballFacade;

@Component
class ApiFootballScheduler {

    private final ApiFootballFacade facade;

    @Autowired
    public ApiFootballScheduler(ApiFootballFacade facade) {
        this.facade = facade;
    }

    @Scheduled(cron = "*/30 * * * * *")
    void updateCollectionGame() {
        System.out.println("Update Collection");
        facade.updateGameCollection();
    }

    @Scheduled(cron = "0 0 1 * * *")
    void saveAllGameEntityOnePerDay() {
        System.out.println("Save All");
        facade.saveAllGameEntity();
    }

    @Scheduled(cron = "0 30 1 * * *")
    void clearTemporaryGameEntityCollection() {
        System.out.println("Clear Collection");
        facade.clearTemporaryCollection();
    }
}
