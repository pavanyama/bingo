package com.bingo.generator;

import java.util.*;

/*
 * This idea has taken from https://stackoverflow.com/questions/16000196/java-generating-non-repeating-random-numbers
 * Disadvantages are -  Memory and ahead of generation.
 */
public final class RandomNumberGenerator {

    public static List<Integer> generate(int count, int upperBound) {
        if(upperBound < count) {
            throw new IllegalArgumentException("Count should be less than upperbound");
        } else {
            Random random = new Random();
            Set<Integer> randomNumbers = new LinkedHashSet<>();
            while(randomNumbers.size() != count) {
                int number = random.nextInt(upperBound);
                randomNumbers.add(number+1);
            }
            return new ArrayList<>(randomNumbers);
        }
    }
}
