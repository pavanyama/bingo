package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleDimensionArray {

    public static void main(String[] args) {
        /*
        tickets = new ArrayList<>(game.getTicketRowCount());
        for(int i=0; i<game.getTicketRowCount(); i++) {
            tickets.add(new ArrayList<Integer>(game.getTicketColCount()));
        }
         */

        List<List<Integer>> lists = new ArrayList<>(3);
        for(int i=0; i<3; i++) {

            List<Integer> l = new ArrayList<>(5);
            l.add(0);
            l.add(3);
            l.add(0);
            l.add(4);
            l.add(null);
            l.add(6);

            lists.add(l);
            Collections.shuffle(l);

        }

        lists.forEach(list -> list.forEach(System.out::print));
    }
}
