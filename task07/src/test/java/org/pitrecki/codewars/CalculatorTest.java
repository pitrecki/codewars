package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @Parameters(method = "parameters")
    public void shouldCalculateExpectedResults(double expected, String expression) {
        Double actual = calculator.evaluate(expression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Parameters(method = "parameters")
    public void shouldCalculateExpectedResultsWithNotHacked(double expected, String expression) {
        Double actual = calculator.notHackedEvaluate(expression);
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[]{127d, "127"},
                new Object[]{5d, "2 + 3"},
                new Object[]{-5d, "2 - 3 - 4"},
                new Object[]{10d, "10 * 5 / 5"},
                new Object[]{13d, "2 / 2 + 3 * 4"},
                new Object[]{0d, "7.7 - 3.3 - 4.4"}
        };
    }
}