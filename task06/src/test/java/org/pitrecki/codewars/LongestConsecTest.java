package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LongestConsecTest {

    private LongestConsec longestConsec = new LongestConsec();

    @Test
    @Parameters(method = "parameters")
    public void shouldMergeLongestStrings(List<String> list, int elements, String expected) {
        String actual = longestConsec.longestConsec(list.toArray(new String[0]), elements);
        assertThat(actual).isEqualTo(expected);

    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[]{List.of("zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"), 2, "abigailtheta"},
                new Object[]{List.of("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"), 1, "oocccffuucccjjjkkkjyyyeehh"},
                new Object[]{List.of(), 3, ""},
                new Object[]{List.of("itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"), 2, "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"},
                new Object[]{List.of("wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"), 2, "wlwsasphmxxowiaxujylentrklctozmymu"},
                new Object[]{List.of("zone", "abigail", "theta", "form", "libe", "zas"), -2, ""},
                new Object[]{List.of("it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"), 3, "ixoyx3452zzzzzzzzzzzz"},
                new Object[]{List.of("it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"), 15, ""},
                new Object[]{List.of("it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"), 0, ""}
        };
    }

    ;
}
