package pl.bookmaker.externalscheduler.demo.externalApi.interfaces;

import pl.bookmaker.externalscheduler.demo.models.entity.Game;

import java.util.List;

public interface GamesStrategy {
  List<Game> getList(List<Game> list);
}
