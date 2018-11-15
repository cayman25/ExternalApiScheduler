package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;


class ApiFootballFacade {

    private final ApiFootballUrls urls;
    private final ApiFootballJsonConsumer consumer;
    private final ApiFootballFilterGame filter;

    @Autowired
    private ApiFootballGameCollection collection;

    ApiFootballFacade(ApiFootballUrls urls, ApiFootballJsonConsumer consumer, ApiFootballFilterGame filter, ApiFootballGameCollection collection) {
        this.urls=urls;
        this.consumer=consumer;
        this.filter=filter;
    //    this.collection = collection;
    }

    void updateGameCollection(){
        List<Game> games = consumer.getGames(urls.createListUrl());
        collection.setFinishedGames(filter.getFinishedGames(games));
        collection.setAllGames(filter.getAllNotFinishedGames(games));
    }
}
