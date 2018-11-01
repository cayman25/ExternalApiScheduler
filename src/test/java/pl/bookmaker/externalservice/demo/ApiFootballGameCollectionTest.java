package pl.bookmaker.externalservice.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ApiFootballGameCollectionTest {

    List<String> finished = new ArrayList<>(Arrays.asList("Mariusz", "Kuba", "Tomek"));
    List<String> nowa = new ArrayList<>(Arrays.asList("a", "b", "s", "h"));


    @Test
    public void checkSize() {
     System.out.println(finished.size());
        if(finished.size()==nowa.size())
            System.out.println("No changes in list finished game");
        else{
            finished.clear();
            System.out.println(finished.size());
            setFinished(nowa);
            System.out.println(finished.size());
    }

}
    public List<String> getFinished() {
        return finished;
    }

    public void setFinished(List<String> finished) {
        this.finished = finished;
    }

    public List<String> getNowa() {
        return nowa;
    }

    public void setNowa(List<String> nowa) {
        this.nowa = nowa;
    }
}
