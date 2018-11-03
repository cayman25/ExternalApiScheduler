package pl.bookmaker.externalservice.demo.externalApi.interfaces;

import pl.bookmaker.externalservice.demo.externalApi.interfaces.Observer;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver();

}
