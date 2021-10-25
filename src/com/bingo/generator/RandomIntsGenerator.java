package com.bingo.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public final class RandomIntsGenerator {

    public static List<Integer> generate(int count, int upperBound) {
        if(upperBound < count) {
            throw new IllegalArgumentException("Count should be less than upperbound");
        } else {
            Random random = new Random();
            return random.ints(count, 1, upperBound)
                    .boxed()
                    .collect(Collectors.toList());
        }
    }
}
