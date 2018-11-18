package pl.bookmaker.externalservice.demo.externalApi;

import lombok.Getter;
import lombok.Setter;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observable;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
class ApiFootballGamesCollections implements Observable {

    private List<Observer> observerList = new ArrayList<>();
    private List<Game> finishedGames = new ArrayList<>();
    private List<Game> allGames = new ArrayList<>();
    private List<Game> notSavedFinishedGames = new ArrayList<>();

    void setFinishedGames(List<Game> finishedGames) {
       if(finishedGames.size() != this.finishedGames.size()) {
           notSavedFinishedGames.clear();
           notSavedFinishedGames.addAll(finishedGames);
           notSavedFinishedGames.removeAll(this.finishedGames);
           this.finishedGames.clear();
           this.finishedGames.addAll(finishedGames);
           notifyObserver();
       }
       else
           System.out.println("Nothing was changed");
        }


    void setAllGames(List<Game> allGames){
        this.allGames.addAll(allGames);
    }

    void setNotSavedFinishedGames(List<Game> notSavedFinishedGamesFinishedGames){
        this.notSavedFinishedGames.addAll(notSavedFinishedGamesFinishedGames);
    }

    void clearTemporaryCollection() {
        finishedGames.clear();
        allGames.clear();
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
        for (Observer o : observerList)
            o.update();
    }
}