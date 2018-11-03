package pl.bookmaker.externalservice.demo.testService.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.bookmaker.externalservice.demo.testService.facade.ApiFootballFacade;

@Service
public class ApiFootballService {

    private final ApiFootballFacade facade = new ApiFootballFacade();

    @Scheduled(cron = "*/30 * * * * *")
    public void updateCollectionGame(){
        facade.updateGameCollection();
        System.out.println("Działa");
    }


    
}
