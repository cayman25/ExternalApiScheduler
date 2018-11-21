package pl.bookmaker.externalscheduler.demo.externalApi.interfaces;

public interface Observable {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObserver();

}
