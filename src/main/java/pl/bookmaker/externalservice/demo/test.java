package pl.bookmaker.externalservice.demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1,2,3);
    List<Integer> list2 = Arrays.asList(3);

    List<Integer> temporary = new ArrayList<>(list1);
    temporary.removeAll(list2);

    System.out.println(temporary.size());


  }
}
