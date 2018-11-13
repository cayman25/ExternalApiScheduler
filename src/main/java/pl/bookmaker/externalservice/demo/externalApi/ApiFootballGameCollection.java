package pl.bookmaker.externalservice.demo.externalApi;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observable;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class ApiFootballGameCollection implements Observable {

    private List<Observer> observerList = new ArrayList<>();
    private List<Game> finishedGames = new ArrayList<>();
    private List<Game> allGames = new ArrayList<>();
    private List<Game> notSavedFinishedGames = new ArrayList<>();

    void setFinishedGames(List<Game> finishedGames) {
        if(finishedGames.size() == this.finishedGames.size())
            System.out.println("All games were updated");
        else {
            notSavedFinishedGames = finishedGames;
            notSavedFinishedGames.removeAll(this.finishedGames);
            this.finishedGames = finishedGames;
            notifyObserver();
        }
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

    void clearTemporaryCollection() {
        finishedGames.clear();
        allGames.clear();
    }
}
