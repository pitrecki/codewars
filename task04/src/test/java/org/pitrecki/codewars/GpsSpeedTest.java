package org.pitrecki.codewars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GpsSpeedTest {

    private GpsSpeed gpsSpeed = new GpsSpeed();

    @Test
    @Parameters(method = "parameters")
    public void shouldCalculateCorrectAverageSpeed(int s, double[] values, int expected) {
        int actual = gpsSpeed.gps(s, values);
        assertThat(actual).isEqualTo(expected);
    }

    private static Object[] parameters() {
        return new Object[]{
                new Object[] {15, new double[]{0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25}, 74},
                new Object[]{20, new double[]{0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61}, 41},
                new Object[]{12, new double[]{0.0, 0.11, 0.22, 0.33, 0.44, 0.65, 1.08, 1.26, 1.68, 1.89, 2.1, 2.31, 2.52, 3.25}, 219},
                new Object[]{20, new double[]{0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84}, 80}
        };
    }
}