package com.psv;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TeeingCollectors {
    public static void main(String[] args) {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, n) -> sum / n));

        System.out.println(mean); // 3.0

        boolean result = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        teeing(
                                maxBy(Integer::compareTo),
                                minBy(Integer::compareTo),
                                (max, min) ->
                                        max.flatMap(a ->
                                                min.map(b -> a - b))),
                        averagingInt(i -> i),
                        (diff, avg) -> diff.map(d -> d > avg)
                                .orElse(false)
                ));

        System.out.println(result); // true
    }
}
