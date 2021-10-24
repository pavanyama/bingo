package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffle {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(9);
        Collections.shuffle(list);
        list.forEach(System.out::println);

    }
}
