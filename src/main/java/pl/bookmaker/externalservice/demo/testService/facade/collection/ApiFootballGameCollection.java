package pl.bookmaker.externalservice.demo.testService.facade.collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.testService.Observer;
import pl.bookmaker.externalservice.demo.testService.service.ApiFootballService;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class ApiFootballGameCollection implements Observable{

    private List<Observer> observerList = new ArrayList<>();;
    private List<Game> finishedGames = new ArrayList<>();
    private List<Game> allGames = new ArrayList<>();


    public void setFinishedGames(List<Game> finishedGames) {
        this.finishedGames = finishedGames;
        notifyObserver();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer o: observerList){
            o.update();
        }
    }
}
