package org.pitrecki.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class LongestConsec {

    private static final String EMPTY_STRING = "";

    public String longestConsec(String[] strarr, int k) {
        return k > strarr.length || k <= 0
                ? EMPTY_STRING
                : findLongest(strarr, k);
    }

    private String findLongest(String[] strarr, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= strarr.length - k; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < k; j++) {
                builder.append(strarr[j + i]);
            }
            list.add(builder.toString());
        }

        return Collections.max(list, comparingInt(String::length));
    }
}
