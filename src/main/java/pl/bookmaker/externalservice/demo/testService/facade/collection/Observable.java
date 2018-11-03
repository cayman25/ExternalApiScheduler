package pl.bookmaker.externalservice.demo.testService.facade.collection;

import pl.bookmaker.externalservice.demo.testService.Observer;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver();

}
