package org.pitrecki.codewars;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;

public class Calculator {

    private static final ScriptEngine SCRIPT_ENGINE = new ScriptEngineManager().getEngineByName("JavaScript");

    public Double evaluate(String expression) {
        try {
            return Double.parseDouble(SCRIPT_ENGINE.eval(expression).toString());
        } catch (ScriptException e) {
            throw new RuntimeException();
        }
    }

    public Double notHackedEvaluate(String expression) {
        String[] s = expression.split(" ");
        Stack<Double> stack = new Stack<>();
        if (s.length == 1) {
            return parseDouble(expression);
        } else {
            for (int i = 0; i < s.length - 1; i+=2) {
                Double left = Double.parseDouble(s[i]);
                Double right = Double.parseDouble(s[i + 2]);
                Sign sign = Sign.fromString(s[i + 1]);
                if (stack.empty()) {
                    stack.push(count(sign, left, right));
                } else {
                    stack.push(count(sign, stack.pop(), right));
                }
            }
            return stack.peek();
        }
    }

    private Double count(Sign sign, Double left, Double right) {
        switch (sign) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return left / right;
            default:
                return 0d;
        }
    }

    private enum Sign {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String sign;

        Sign(String sign) {
            this.sign = sign;
        }

        public String value() {
            return sign;
        }

        public static Sign fromString(String s) {
            return Arrays.stream(Sign.values())
                    .filter(sign -> sign.value().equalsIgnoreCase(s))
                    .findFirst()
                    .orElse(null);
        }
    }
}
