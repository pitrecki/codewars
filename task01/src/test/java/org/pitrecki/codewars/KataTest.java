package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class KataTest {

    private Kata kata = new Kata();

    @Test
    @Parameters(method = "parameters")
    public void shouldReturnExpectedString(String expectedValue, String s, Integer n) {
        String actual = kata.remove(s, n);
        assertThat(actual).isEqualTo(expectedValue);
    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[]{"Hi", "Hi!", 1},
                new Object[]{"Hi", "Hi!", 100},
                new Object[]{"Hi!!", "Hi!!!", 1},
                new Object[]{"Hi", "Hi!!!", 100},
                new Object[]{"Hi", "!Hi", 1},
                new Object[]{"Hi!", "!Hi!", 1},
                new Object[]{"Hi", "!Hi!", 100},
                new Object[]{"!!Hi !!hi!!! !hi", "!!!Hi !!hi!!! !hi", 1},
                new Object[]{"Hi !!hi!!! !hi", "!!!Hi !!hi!!! !hi", 3},
                new Object[]{"Hi hi!!! !hi", "!!!Hi !!hi!!! !hi", 5},
                new Object[]{"Hi hi hi", "!!!Hi !!hi!!! !hi", 100}
        };
    }
}