package com.bingo.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomIntsGenerator {

    public static List<Integer> generate(int count, int upperBound) {
        if(upperBound < count) {
            throw new IllegalArgumentException("Count should be less than upperbound");
        } else {
            Random random = new Random();
            List<Integer> randomNumbers = random.ints(count, 1, upperBound)
                    .mapToObj(i -> i)
                    .collect(Collectors.toList());
            return randomNumbers;
        }
    }
}
