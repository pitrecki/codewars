package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    @Parameters(method = "parameters")
    public void shouldReturnExpectedLikesString(String expected, String... names) {
        String actual = solution.whoLikesIt(names);
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[]{"no one likes this", new String[]{}},
                new Object[]{"Peter likes this", new String[]{"Peter"}},
                new Object[]{"Jacob and Alex like this", new String[]{"Jacob", "Alex"}},
                new Object[]{"Max, John and Mark like this", new String[]{"Max", "John", "Mark"}},
                new Object[]{"Alex, Jacob and 2 others like this", new String[]{"Alex", "Jacob", "Mark", "Max"}}
        };
    }
}