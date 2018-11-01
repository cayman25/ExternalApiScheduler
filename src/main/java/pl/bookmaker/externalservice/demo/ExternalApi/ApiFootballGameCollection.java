package pl.bookmaker.externalservice.demo.ExternalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiFootballGameCollection{

    ApiFootballService apiFootballService =new ApiFootballService();

    private List<Game> finishedGames = new ArrayList<>(Arrays.asList());
    private List<Game> allGames= new ArrayList<>(Arrays.asList());

    public List<Game> getFinishedGames() {
        return finishedGames;
    }

    public void setFinishedGames(List<Game> finish) {
        System.out.println(finish.size());
            if (finish.size() == finishedGames.size())
                System.out.println("No changes in list finished game");
            else {
                finishedGames.clear();
                System.out.println(finishedGames.size());
                finishedGames.addAll(finish);
                finishedGames.remove(finish.get(finish.size()-1));
                System.out.println(finishedGames.size());
                apiFootballService.update();
            }
    }

    public List<Game> getAllGames() {
        return allGames;
    }

    public void setAllGames(List<Game> allGames) {
        this.allGames = allGames;
    }

}
