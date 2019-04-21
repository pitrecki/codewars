package org.pitrecki.codewars;

public class Kata {

    private static final String EXCLAMATION_MARK = "!";
    private static final String EMPTY = "";

    public String remove(String s, int n) {
        for (int i = 0; i < n; i++) {
            s= s.replaceFirst(EXCLAMATION_MARK, EMPTY);
        }
        return s;
    }
}
