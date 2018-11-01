package pl.bookmaker.externalservice.demo;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

@SpringBootTest
public class ApiFootballObservable{

    @Test
    public void checkChanged(){
        List<String> list1 = List.of("1","2","3");
        List<Integer> list2 = List.of(1,2,3);
        List<String> list3 = List.of("1","2","3");

        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
        System.out.println(list2.equals(list3));
    }

}
