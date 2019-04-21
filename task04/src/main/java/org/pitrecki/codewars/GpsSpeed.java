package org.pitrecki.codewars;

import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class GpsSpeed {

    public int gps(int s, double[] x) {
        return x.length <= 1 ? 0 : (int) IntStream.iterate(0, value -> value + 1)
                .mapToDouble(operand -> (3600 * abs(x[operand] - x[operand + 1])) / s)
                .limit(x.length - 1)
                .max().getAsDouble();
    }
}
