package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TopWordsTest {

    private TopWords topWords = new TopWords();

    @Test
    @Parameters(method = "parameters")
    public void shouldReturnTop3OcurrenceOfWordsInText(List<String> expected, String text) {
        List<String> actual = topWords.top3(text);
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[]{List.of("e", "d", "a"), "a a a  b  c c  d d d d  e e e e e"},
                new Object[]{List.of("e", "ddd", "aa"), "e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"},
                new Object[]{List.of("won't", "wont"), "  //wont won't won't "},
                new Object[]{List.of("e"), "  , e   .. "},
                new Object[]{emptyList(), "  ...  "},
                new Object[]{emptyList(), "  '  "},
                new Object[]{emptyList(), "  '''  "},
                new Object[]{List.of("a", "of", "on"), String.join("\n", "In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")}
        };
    }
}