package org.pitrecki.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

public class TopWords {

    private static final Pattern NON_ALPHABET_PATTERN = Pattern.compile("[a-z][a-z']*");
    private static final Pattern NON_PUNCTUATION_PATTERN = Pattern.compile("[^'a-z]");
    private static final String WHITESPACE = " ";

    public List<String> top3(String s) {
        final String[] strings = s.toLowerCase()
                .replaceAll(NON_PUNCTUATION_PATTERN.pattern(), WHITESPACE)
                .split(WHITESPACE);
        return Arrays.stream(strings)
                .filter(this::filterNonWords)
                .collect(groupingBy(o -> o, counting()))
                .entrySet().stream()
                .sorted(comparingByValue(reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(toList());
    }

    private boolean filterNonWords(String s1) {
        return s1.matches(NON_ALPHABET_PATTERN.pattern());
    }
}
