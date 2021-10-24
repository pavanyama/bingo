package com.bingo.generator;

import com.bingo.model.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * This idea has taken from https://stackoverflow.com/questions/16000196/java-generating-non-repeating-random-numbers
 */
public class RandomNumberGenerator {

    List<Integer> eventList = new ArrayList<>();
    int eventIndex = 0;

    public RandomNumberGenerator(Game game){
        for(int i=1; i<=game.getUpperBound(); i++ ) {
            eventList.add(i);
        }
        Collections.shuffle(eventList);
    }

    public Integer generate() {
        return eventList.get(eventIndex++);
    }
}
