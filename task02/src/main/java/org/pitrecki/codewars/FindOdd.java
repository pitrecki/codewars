package org.pitrecki.codewars;

import java.util.Arrays;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindOdd {

    public int findIt(int[] ints) {
        return Arrays.stream(ints)
                .boxed()
                .collect(groupingBy(integer -> integer, counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() % 2 != 0)
                .max(comparing(Map.Entry::getValue))
                .get().getKey();
    }
}
