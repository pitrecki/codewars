package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FindOddTest {

    private FindOdd findOdd = new FindOdd();

    @Test
    @Parameters(method = "parameters")
    public void shouldReturnOddNumber(Integer expected, int[] array) {
        int actual = findOdd.findIt(array);
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[]{5, new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}},
                new Object[]{-1, new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}},
                new Object[]{5, new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}},
                new Object[]{10, new int[]{10}},
                new Object[]{10, new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}},
                new Object[]{1, new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}}
        };
    }
}