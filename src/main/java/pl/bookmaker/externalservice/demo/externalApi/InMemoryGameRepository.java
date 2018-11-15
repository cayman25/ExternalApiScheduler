package pl.bookmaker.externalservice.demo.externalApi;

import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.HashMap;

class InMemoryGameRepository {

    private HashMap<Integer, Game> map = new HashMap<>();

    Game save(Game game) {
        map.put(game.getMatchID(), game);
        return game;
    }

    Game findOne(int id) {
        return map.get(id);
    }

    void delete(int id) {
        map.remove(id);
    }

/*  Page<Game> findAll(Pageable pageable){
    List<Game> games =new ArrayList<>(map.values());
    return new PageImpl<>(games,pageable,games.size());
  }*/


}
