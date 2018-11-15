package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryGameRepository {

  private HashMap<Integer, Game> map = new HashMap<>();

  Game save(Game game){
    map.put(game.getMatchID(), game);
    return game;
  }

  Game findOne(int id){
    Game game = map.get(id);
    return game;
  }

  void delete(int id){
    map.remove(id);
  }

/*  Page<Game> findAll(Pageable pageable){
    List<Game> games =new ArrayList<>(map.values());
    return new PageImpl<>(games,pageable,games.size());
  }*/


}
