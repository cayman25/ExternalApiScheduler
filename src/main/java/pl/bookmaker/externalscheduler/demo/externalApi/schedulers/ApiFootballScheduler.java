package pl.bookmaker.externalscheduler.demo.externalApi.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalscheduler.demo.externalApi.ApiFootballFacade;

@Component
class ApiFootballScheduler {

    private final ApiFootballFacade facade;

    @Autowired
    public ApiFootballScheduler(ApiFootballFacade facade) {
        this.facade = facade;
    }

    @Scheduled(cron = "*/30 * * * * *")
    void updateCollectionGame() {
        facade.updateGameCollection();
        System.out.println("Updated Collection");
    }

    @Scheduled(cron = "0 0 1 * * *")
    void saveAllGameEntityOnePerDay() {
        facade.saveAllGameEntity();
    }

    @Scheduled(cron = "0 30 1 * * *")
    void clearTemporaryGameEntityCollection() {
        facade.clearTemporaryCollection();
        System.out.println("Cleared Collection");
    }
}
