package pl.bookmaker.externalservice.demo.externalApi;

import lombok.Getter;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observable;
import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.List;

@Getter
class ApiFootballGamesCollections implements Observable {

    private final List<Observer> observerList = new ArrayList<>();
    private final List<Game> finishedGames = new ArrayList<>();
    private List<Game> allGames = new ArrayList<>();
    private List<Game> notSavedFinishedGames = new ArrayList<>();

    void setFinishedGames(List<Game> finishedGames) {
       if(finishedGames.size() == this.finishedGames.size() || finishedGames.size()==0)
           System.out.println("Nothing was changed");
       else{
           notSavedFinishedGames.clear();
           notSavedFinishedGames.addAll(finishedGames);
           notSavedFinishedGames.removeAll(this.finishedGames);
           this.finishedGames.clear();
           this.finishedGames.addAll(finishedGames);
           notifyObserver();
       }
    }


    void setAllGames(List<Game> allGames){
        this.allGames = allGames;
    }

    void setNotSavedFinishedGames(List<Game> notSavedFinishedGamesFinishedGames){
        this.notSavedFinishedGames =notSavedFinishedGamesFinishedGames;
    }

    void clearTemporaryCollections() {
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
